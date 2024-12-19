package com.rca.demosms;

public record SMSSendRequest(String destinationSMSNumber, String smsMessage) {
}
