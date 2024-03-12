package com.predict.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class URL implements Serializable {
     private static final String ROOT = "C:\\Users\\BolshevikNanven\\Desktop\\scau大创\\";
     public static final String IMAGE_URL = ROOT+"images\\";
     public static final String PythonExe = ROOT+"NeuralNetworks_Attack-main\\venv\\Scripts\\python.exe";
     public static final String Py = ".py";
     public static  final String DEFENCE_URL=ROOT+"defense-of-adversarial-attack-master\\";
     public static  final String ATTACK_URL=ROOT+"NeuralNetworks_Attack-main\\";
     public static  final String PREDICT_URL=ROOT+"Pytorch-module\\";

}
