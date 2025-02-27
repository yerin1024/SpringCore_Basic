package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자주입
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void log(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = "+id);
    }
}
