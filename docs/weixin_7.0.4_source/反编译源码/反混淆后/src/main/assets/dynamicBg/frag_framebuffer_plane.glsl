precision mediump float;
const int kernelSize = 5;
varying vec2 fragUV;
varying mat4 fragColorMatrix;
//varying vec2 vBlurTexCoords[15];
uniform sampler2D diffuseMap;
uniform int directionX;
uniform int needColorMatrix;
const bool blur = true;

vec4 sampleColor(vec2 sampleUV)
{
    vec4 originColor = texture2D(diffuseMap, sampleUV);
    return originColor;
}

void main(void)
{
    vec4 finalColor = vec4(0.0);

    float kernel[3];
    kernel[0] = 0.153388;
    kernel[1] = 0.221461;
    kernel[2] = 0.250301;
    int halfLength = 3;
    int value;
    float strength = 4.7;   // 8.0

    for (int i=0; i<kernelSize; i++) {
        value = i;
        if (i >= halfLength) {
            value = kernelSize - i - 1;
        }

        float sampleIndex = float(i) - (float(halfLength) - 1.0);

        if (directionX > 0) {
            vec2 sampleYUV = fragUV + vec2(0.0, (sampleIndex * float(strength)/896.0)); // 896.0
            finalColor += sampleColor(sampleYUV) * kernel[value];
        }
        else {
            vec2 sampleXUV = fragUV + vec2((sampleIndex * float(strength))/414.0, 0.0);    // 414
            finalColor += sampleColor(sampleXUV) * kernel[value];
        }
    }

    if (!blur) {
        finalColor = texture2D(diffuseMap, fragUV);
    }

    if (needColorMatrix > 0) {
        vec4 matrixedColor = finalColor * fragColorMatrix;
        matrixedColor.a -= 3.55;
        finalColor = matrixedColor;
    }

//    if (needColorMatrix > 0) {
//        if (finalColor.a >= 1.0) {
//            finalColor = vec4(1.0, 1.0, 1.0, 1.0);
//        }
//        else if (finalColor.a >= 0.9) {
//            finalColor = vec4(1.0, 0.0, 0.0, finalColor.a);
//        }
//        else if (finalColor.a >= 0.6){
//            finalColor = vec4(0.0, 1.0, 0.0, 0.2);
//        }
//        else if (finalColor.a >= 0.3) {
//            finalColor = vec4(0.0, 0.0, 1.0, 0.2);
//        }
//        else {
//            finalColor = vec4(0.0, 0.0, 0.0, 0.2);
//        }
//    }

//    if (needColorMatrix > 0) {
//        finalColor = vec4(1.0, 1.0, 1.0, 1.0);
//        if (finalColor.a <= 1.0) {
//            finalColor.a = 0.0;
//        }
//    }
//    if (needColorMatrix > 0) {
//        if (finalColor.r == 0.0 && finalColor.g == 0.0 && finalColor.b == 0.0) {
//            finalColor = vec4(0.0, 0.0, 0.0, 1.0);
//        }
//    }

    gl_FragColor = finalColor;
}
