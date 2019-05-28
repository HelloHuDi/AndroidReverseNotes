//attribute vec4 position;
//attribute vec4 positionColor;
//attribute vec2 uv;
//uniform mat4 projectionMatrix;
//uniform mat4 modelViewMatrix;
//uniform mat4 colorMatrix;
//uniform float colorRatio;
//
////varying lowp vec4 varyColor;
//varying vec2 fragUV;
//varying mat4 fragColorMatrix;
//
//void main()
//{
//
////    varyColor = colorMatrix * positionColor;
//    //    varyColor = vec4(varyColor.x, varyColor.y, varyColor.z, varyColor.w - 4.0);
//    //        varyColor = positionColor;
//    fragColorMatrix = colorMatrix;
//    fragUV = uv;
//    vec4 vPos;
//    vPos = projectionMatrix * /*modelViewMatrix */ position;
//
//    //    vPos = position;
//
//    gl_Position = vPos;
//}


attribute vec4 position;
attribute vec2 uv;

//uniform float strength;
uniform mat4 projectionMatrix;
uniform mat4 colorMatrix;

//varying vec2 vBlurTexCoords[15];
varying vec2 fragUV;
varying mat4 fragColorMatrix;

void main(void)
{
//    int strength = 1;
//    int halfLength = 8;//ceil(5/2);
//    for (int i=0; i<15; i++) {
//        float sampleIndex = float(i) - (float(halfLength) - 1.0);
//        vBlurTexCoords[i] = uv + vec2(sampleIndex * float(strength), 0.0);
//    }
    fragUV = uv;
    fragColorMatrix = colorMatrix;
    
    vec4 vPos;
    vPos = projectionMatrix * /*modelViewMatrix */ position;
    
    //    vPos = position;
    
    gl_Position = vPos;
}
