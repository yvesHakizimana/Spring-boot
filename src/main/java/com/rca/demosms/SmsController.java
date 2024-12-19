package com.rca.demosms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/processSms")
    public String processSms(@RequestBody SMSSendRequest request) {
        log.info("Processing the sms request.: {}", request);
        return smsService.sendSms(request.destinationSMSNumber(), request.smsMessage());
    }

}
