package com.predict.javademo.services;

import com.predict.javademo.utils.PythonUtils;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import static com.predict.javademo.entity.URL.ATTACK_URL;

@Component
public class AttackImageService {
    private final Map<String,String> attackModel=new HashMap<>(){{
        put("CW","CW\\AttackCW_tojpg");
        put("PGD","PGD\\AttackPGD_tojpg");
    }};

    public String attack(String originImageUrl,String model){

        String attackedImage= PythonUtils.run(ATTACK_URL,originImageUrl,attackModel.get(model));
        return attackedImage;
    }

}
