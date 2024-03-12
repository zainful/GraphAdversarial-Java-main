package com.predict.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondDTO implements Serializable {
    String originalPredict;
    String attackedPredict;
    String attackedImage;
    String defencedPredict;
    String defencedImage;
}
