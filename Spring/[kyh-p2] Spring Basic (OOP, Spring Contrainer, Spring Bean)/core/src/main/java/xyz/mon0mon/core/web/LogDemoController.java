package xyz.mon0mon.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mon0mon.core.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) throws InterruptedException {
    String requestURL = request.getRequestURL().toString();
    System.out.println("myLogger = " + myLogger.getClass());
    myLogger.setRequestUrl(requestURL);

    myLogger.log("controller test");
    Thread.sleep(800);
    logDemoService.logic("testId");
    return "OK";
  }
}
