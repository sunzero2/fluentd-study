package com.hyeyeong.fluentd.controller;

import lombok.AllArgsConstructor;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/fluentd")
public class FluentdController {
    private static FluentLogger LOG = FluentLogger.getLogger("fluentd.test");

    @RequestMapping("/pub")
    public String test() {
        Map<String, Object> data = new HashMap<>();
        data.put("from", "userA");
        data.put("to", "userB");
        LOG.log("follow", data);
        return "hello";
    }
}
