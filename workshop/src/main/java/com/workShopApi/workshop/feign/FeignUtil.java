package com.workShopApi.workshop.feign;
import com.workShopApi.workshop.util.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "validationService", url = "localhost:8080/api/files")
public interface FeignUtil {

    @GetMapping(value = "/validate-cvs", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Persona> getPerson();

    @PostMapping(value = "/validate-cvs", consumes = MediaType.APPLICATION_JSON_VALUE)
    Persona saveData(@RequestBody Persona persona);
}
