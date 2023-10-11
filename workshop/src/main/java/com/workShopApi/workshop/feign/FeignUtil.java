package com.workShopApi.workshop.feign;
import com.workShopApi.workshop.modeldto.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "validationService", url = "localhost:8090")
public interface FeignUtil {

    @PostMapping(value = "/validar/cvs", consumes = MediaType.APPLICATION_JSON_VALUE)
        Boolean validateLine(Persona persona);
}
