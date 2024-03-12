package com.predict.javademo.services;

import com.predict.javademo.utils.PythonUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.predict.javademo.entity.URL.DEFENCE_URL;

@Component
public class DefenceImageService {
       private final Map<String,String> defenceModel=new HashMap<>(){{
            put("CW","CW\\AttackCW_tojpg");
            put("PGD","PGD\\AttackPGD_tojpg");
        }};

        public String defence(String attackImageUrl,String model) {

            String defencedImage = PythonUtils.run(DEFENCE_URL, attackImageUrl, defenceModel.get(model));
            return defencedImage;
        }
}
