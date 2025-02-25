package com.rca.demosms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    @PostConstruct
    public void setup(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendSms(String smsNumber, String smsMessage){
        Message message = Message.creator(
                new PhoneNumber(smsNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                smsMessage
        ).create();
        return message.toString();
    }
}
