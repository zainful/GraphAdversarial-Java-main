package com.predict.javademo.services;

import com.predict.javademo.utils.PythonUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.predict.javademo.entity.URL.PREDICT_URL;

@Component
public class PredictImageService {
    private final Map<String, String> predictModel = new HashMap<>() {{
        put("inception-v3", "inception-v3");
        put("Resnet-101", "Resnet-101");
        put("VGG-16", "VGG-16");
    }};

    public String predict(String imageUrl, String model) {
        return PythonUtils.run(PREDICT_URL, imageUrl, predictModel.get(model));
    }
}
