package com.tcaini.cardio.properties.controller;

import cn.hutool.core.lang.Dict;
import com.tcaini.cardio.properties.property.ApplicationProperty;
import com.tcaini.cardio.properties.property.DeveloperProperty;
import com.tcaini.cardio.properties.property.PersonalProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    private ApplicationProperty applicationProperty;
    private DeveloperProperty developerProperty;
    private PersonalProperty personalProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty, PersonalProperty personalProperty){
        this.applicationProperty=applicationProperty;
        this.developerProperty=developerProperty;
        this.personalProperty=personalProperty;
    }

    @GetMapping("/property")
    public Dict index(){
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty)
                .set("personalProperty", personalProperty);
    }

}
