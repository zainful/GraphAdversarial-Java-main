package com.predict.javademo.controller;

import com.predict.javademo.entity.ImageDTO;
import com.predict.javademo.entity.RespondDTO;
import com.predict.javademo.entity.Result;
import com.predict.javademo.services.AttackImageService;
import com.predict.javademo.services.DefenceImageService;
import com.predict.javademo.services.PredictImageService;
import com.predict.javademo.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.predict.javademo.entity.URL.IMAGE_URL;

@Controller
@CrossOrigin
@ResponseBody
@RestController
public class PredictApiController {

    @Resource
    AttackImageService attackImageService;
    @Resource
    DefenceImageService defenceImageService;

    @Resource
    PredictImageService predictImageService;

    @PostMapping("/predict")
    public Result predict(@RequestBody ImageDTO imageDTO) {
        String rootUrl = IMAGE_URL;
        List<RespondDTO> respondDTOList = new ArrayList<>();
        for (MultipartFile image : imageDTO.getImg()) {
            String originImageUrl = FileUtils.write(rootUrl, image);
            RespondDTO respondDTO = new RespondDTO();

            respondDTO.setOriginalPredict(predictImageService.predict(originImageUrl, imageDTO.getPredictModel()));

            String attackImageUrl = attackImageService.attack(originImageUrl, imageDTO.getAttackModel());
            respondDTO.setAttackedPredict(predictImageService.predict(attackImageUrl, imageDTO.getPredictModel()));
            respondDTO.setAttackedImage(FileUtils.readAsBase64(attackImageUrl));

            String defenceImageUrl = defenceImageService.defence(attackImageUrl, imageDTO.getDefenceModel());
            respondDTO.setDefencedPredict(predictImageService.predict(defenceImageUrl, imageDTO.getPredictModel()));
            respondDTO.setDefencedImage(FileUtils.readAsBase64(defenceImageUrl));

            FileUtils.delete(originImageUrl);
            FileUtils.delete(attackImageUrl);
            FileUtils.delete(defenceImageUrl);

            respondDTOList.add(respondDTO);
        }
            return Result.ok(respondDTOList);
        }
}
