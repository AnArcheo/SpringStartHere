package com.springstart.springstartch11_1.proxy;

import com.springstart.springstartch11_1.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="payments", url = "${name.service.url}") // REST client configuration,defines a name & end point base URI
public interface PaymentProxy {

    @PostMapping("/payment")  // end point path
    Payment createPayment(
            @RequestHeader String requestId, // defined header and body
            @RequestBody Payment payment);
}
