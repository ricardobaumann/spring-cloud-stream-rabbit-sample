package works.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WorkUnitsSource {

    String CHANNEL_NAME = "worksChannel";
    String SECOND_NAME = "secondChannel";

    @Output
    MessageChannel worksChannel();

    @Output
    MessageChannel secondChannel();

}
