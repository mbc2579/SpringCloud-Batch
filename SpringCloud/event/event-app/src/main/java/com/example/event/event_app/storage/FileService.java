package com.example.event.event_app.storage;

import com.example.event.event_app.event.FileEvent;
import com.example.event.event_app.event.FileEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class FileService {
    @Autowired
    FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            FileEvent completeEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent errorEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyComplete(errorEvent);
        }
    }
}
