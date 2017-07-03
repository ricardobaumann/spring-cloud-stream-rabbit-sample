package works.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import works.service.domain.WorkUnit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class WorkDispatcherScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkDispatcherScheduler.class);

    @Autowired
    private WorkUnitGateway workUnitGateway;

    @Scheduled(fixedDelay = 1000)
    public void sendToMain() {
        WorkUnit workUnit = new WorkUnit(UUID.randomUUID().toString(),
                String.format("Generated on main at %s",new SimpleDateFormat("HH:mm:ss").format(new Date())));
        LOGGER.info("Sent {}",workUnit.getId());
        workUnitGateway.generate(workUnit);
    }

}
