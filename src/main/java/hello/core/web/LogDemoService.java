package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자주입
public class LogDemoService {

    private final MyLogger myLogger;

    public void log(String id) {
        myLogger.log("service id = "+id);
    }
}
