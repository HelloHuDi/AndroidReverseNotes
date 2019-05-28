 precision highp float;

attribute vec4 position;

 //common
 uniform float sin_t;
 uniform float cos_t;
 uniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll
 uniform vec2 size;
 varying vec2 textureCoordinate;

 //eye
 uniform vec2 leftEyePlainSize;
 uniform vec2 leftEyeCenter;
 uniform vec2 rightEyePlainSize;
 uniform vec2 rightEyeCenter;
 uniform float eyesSize; // it is eye size adjust factor
 uniform float eyesWidth; // it is eye width adjust factor
 uniform float eyesHeight; // it is eye height adjust factor
 uniform float eyesTiltAngle; // rotate angle need to apply
 uniform float eyesDistance;

 //nose
 uniform vec2 nose3DCenter;
 uniform vec2 nosePlainSize;
 uniform vec2 noseTipCenter;
 uniform vec2 noseTipPlaneSize;
 uniform vec2 noseBottomCenter;
 uniform float noseSize;
 uniform float noseOutlineWidth;
 uniform float noseBridgeWidth;
 uniform float nosePosition;
 uniform float noseTipSize;

 //lips
 uniform vec2 lipsCenter;
 uniform vec2 lipsPlainSize;
 uniform float lipsSize;
 uniform float lipsWidth;
 uniform float lipsHeight;
 uniform float lipsYPosition;
 uniform vec2 lipsProtectSizeLeft;
 uniform vec2 lipsProtectCenterLeft;
 uniform float lipsProtectAngleLeft;
 uniform vec2 lipsProtectSizeRight;
 uniform vec2 lipsProtectCenterRight;
 uniform float lipsProtectAngleRight;

 //eye brow
 uniform vec2 leftEyebrowPlainSize;
 uniform vec2 leftEyebrowCenter;
 uniform vec2 rightEyebrowPlainSize;
 uniform vec2 rightEyebrowCenter;
 uniform float eyebrowHeight; // eyebrow height adjust factor
 uniform float eyebrowDistance;
 uniform float eyebrowTiltAngle; // rotate angle need to apply

 uniform float meshType;
 uniform sampler2D inputImageTexture;

 const float kLipsEdgeWrinkleSizeToLipsSizeRatio = 0.23;
 const float kPi = 3.14159265358979;
 const float kLipsEdgeWrinklesRotationAngle = 0.025 * kPi;

 //common func
 float getEllipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2) {
     // un-normalization
     boundingSize = boundingSize * size;
     point = point * size;
     center = center * size;
     vec2 translate = (point - center);
     // rotate and scale
     vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;
     float d2 = sqrt(dot(v / boundingSize, v / boundingSize));
     return 1.0 - smoothstep(a1, a2, d2);
 }

 float getEllipseMask2(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2, float ang) {
     // un-normalization
     boundingSize = boundingSize * size;
     point = point * size;
     center = center * size;

     float cos_t = cos(ang);
     float sin_t = sin(ang);
     vec2 translate = (point - center);
     // rotate and scale
     vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;

     float d2 = sqrt(dot(v / boundingSize, v / boundingSize));

     return 1.0 - smoothstep(a1, a2, d2);
 }

 vec2 rotate2DPoint(vec2 point, float angle) {
     return vec2(cos(angle) * point.x - sin(angle) * point.y, sin(angle) * point.x + cos(angle) * point.y);
 }

 //for eye part
 float eye_getLeftEyeFineMask(vec2 sigmaScaling, float a1, float a2) {
     return getEllipseMask(sigmaScaling, position.xy, leftEyeCenter, leftEyePlainSize, a1, a2);
 }
 float eye_getRightEyeFineMask(vec2 sigmaScaling, float a1, float a2) {
     return getEllipseMask(sigmaScaling, position.xy, rightEyeCenter, rightEyePlainSize, a1, a2);
 }
 vec2 eye_getScaledEyesPoint(vec2 originalPoint, vec2 scalingFactors,float scalingFactor,float leftEyeMask, float rightEyeMask) {
     if (scalingFactor == 0.0) {
         return originalPoint;
     }
     vec2 eyesScaledPoint = originalPoint;
     vec2 leftEyeScaledPoint = leftEyeCenter + scalingFactors * (originalPoint - leftEyeCenter);
     eyesScaledPoint = mix(eyesScaledPoint, leftEyeScaledPoint, leftEyeMask);
     vec2 rightEyeScaledPoint = rightEyeCenter + scalingFactors * (originalPoint - rightEyeCenter);
     eyesScaledPoint = mix(eyesScaledPoint, rightEyeScaledPoint, rightEyeMask);
     return mix(originalPoint, eyesScaledPoint, scalingFactor);
 }
 vec2 eye_getEyesDistanceFactors() {
     const float kEyesDistanceXRatio = 0.03662283339;
     return vec2(abs(kEyesDistanceXRatio * (leftEyeCenter - rightEyeCenter).x), 0.0);
 }
 vec2 eye_getEyesDistanceFactors2() {
     const float kEyesDistanceXRatio = 0.03662283339;
     return kEyesDistanceXRatio * vec2(leftEyeCenter.x - rightEyeCenter.x, leftEyeCenter.y - rightEyeCenter.y);
 }

 vec2 eye_getScaledEyesPoint2(vec2 originalPoint, float scalingFactor, float theta, float leftEyeMask, float rightEyeMask) {
     if (scalingFactor == 0.0) {
         return originalPoint;
     }
     float sin_t2 = sin(theta);
     float cos_t2 = cos(theta);
     vec2 v = originalPoint - leftEyeCenter;
     float d = dot(v, vec2(cos_t2, sin_t2));
     d = d * 0.3 * leftEyeMask * scalingFactor;
     vec2 left = d * vec2(cos_t2, sin_t2);

     v = originalPoint - rightEyeCenter;
     d = dot(v, vec2(cos_t2, sin_t2));
     d = d * 0.3 * rightEyeMask * scalingFactor;
     vec2 right = d * vec2(cos_t2, sin_t2);
     return originalPoint+left+right;
 }

 vec2 getEyeDiff() {
     //faceIndex;
     float leftEyeFineMask     = eye_getLeftEyeFineMask(vec2(1.0, 0.6), 0.9, 1.1);
     float rightEyeFineMask    = eye_getRightEyeFineMask(vec2(1.0, 0.6), 0.9, 1.1);
     float leftEyeCoarseMask   = eye_getLeftEyeFineMask(vec2(0.8, 0.7), 0.7, 1.2);
     float rightEyeCoarseMask  = eye_getRightEyeFineMask(vec2(0.8, 0.7), 0.7, 1.2);
     vec2 displacedEyesPoint   = position.xy;
     //textureCoordinate = vec2(leftEyeFineMask+rightEyeFineMask);
     //gl_Position = vec4(position.x*2.0-1.0, position.y*2.0-1.0, 0.0, 1.0);
     //return;
     // width
     vec2 kEyesWidthFactors = vec2(1.3*cos_t, -1.3*sin_t);
     //vec3 kEyesWidthFactors = vec3(1.3, 1.0, 1.0);
     displacedEyesPoint = eye_getScaledEyesPoint2(displacedEyesPoint, eyesWidth, angles.z, leftEyeFineMask, rightEyeFineMask);

     // height
     displacedEyesPoint = eye_getScaledEyesPoint2(displacedEyesPoint, eyesHeight, kPi/2.0 + angles.z, leftEyeFineMask, rightEyeFineMask);

     // all size
     const vec2 kEyesSizeFactors = vec2(1.4, 1.4);
     displacedEyesPoint = eye_getScaledEyesPoint(displacedEyesPoint, kEyesSizeFactors, eyesSize, leftEyeFineMask, rightEyeFineMask);

     // rotate
     vec2 leftEye2DTiltPoint = leftEyeCenter + rotate2DPoint(displacedEyesPoint - leftEyeCenter, -eyesTiltAngle);
     displacedEyesPoint = mix(displacedEyesPoint, leftEye2DTiltPoint, leftEyeCoarseMask);
     vec2 rightEye2DTiltPoint = rightEyeCenter + rotate2DPoint(displacedEyesPoint - rightEyeCenter, eyesTiltAngle);
     displacedEyesPoint = mix(displacedEyesPoint, rightEye2DTiltPoint, rightEyeCoarseMask);

     // distance
     vec2 eyesDistanceFactors = eye_getEyesDistanceFactors2();
     vec2 leftEyeDistancePoint = displacedEyesPoint + eyesDistance * eyesDistanceFactors;
     displacedEyesPoint = mix(displacedEyesPoint, leftEyeDistancePoint, leftEyeCoarseMask);
     vec2 rightEyeDistancePoint = displacedEyesPoint - eyesDistance * eyesDistanceFactors;
     displacedEyesPoint = mix(displacedEyesPoint, rightEyeDistancePoint, rightEyeCoarseMask);

     vec2 diffPosition = displacedEyesPoint - position.xy;
     return diffPosition;
 }

 float nose_getNoseMask(vec2 sigmaScaling, float a1, float a2) {
     return getEllipseMask(sigmaScaling, position.xy, nose3DCenter, nosePlainSize, a1, a2);
 }
 float nose_getNoseTipFineMask() {
     return getEllipseMask(vec2(2.0, 2.0), position.xy, noseTipCenter, noseTipPlaneSize, 0.4, 0.8);
 }
 float nose_getNoseTipCoarseMask() {
     return getEllipseMask(vec2(1.0, 1.2), position.xy, noseBottomCenter, noseTipPlaneSize, 0.5, 1.2);
 }
 float nose_getNoseVerticalAxisMask() {
     return getEllipseMask(vec2(2.0, 1.0), position.xy, nose3DCenter, nosePlainSize, 0.5, 1.2);
 }
 float nose_getNoseVerticalAxisFineMask() {
     return getEllipseMask(vec2(2.5, 0.8), position.xy, nose3DCenter, nosePlainSize, 0.5, 1.2);
 }
 float nose_getLipsMask(vec2 sigmaScaling, float a1, float a2) {
     return getEllipseMask(sigmaScaling, position.xy, lipsCenter, lipsPlainSize, a1, a2);
 }

 vec2 nose_getScaledNosePoint(vec2 originalPoint, vec2 center, float scale) {
     vec2 v = originalPoint - center;
     float d = dot(v, vec2(cos_t, sin_t));
     d = d * scale;
     vec2 dv = d * vec2(cos_t, sin_t);

     return originalPoint+dv;
 }

 vec2 getNoseDiff() {
     float noseNegativeRegionsMask = (1.0 - eye_getLeftEyeFineMask(vec2(0.8), 0.5, 1.2)) * (1.0 - eye_getRightEyeFineMask(vec2(0.8), 0.5, 1.2)) * (1.0 - nose_getLipsMask(vec2(1.8), 0.5, 1.0));
     float noseMask = nose_getNoseMask(vec2(1.0, 1.5), 0.5, 1.2) * noseNegativeRegionsMask;
     float noseTipFineMask = nose_getNoseTipFineMask() * noseNegativeRegionsMask;
     float noseTipCoarseMask = nose_getNoseTipCoarseMask() * noseNegativeRegionsMask;
     float noseVertivalAxisMask = nose_getNoseVerticalAxisMask() * noseNegativeRegionsMask;
     float noseVertivalAxisFineMask = nose_getNoseVerticalAxisFineMask() * noseNegativeRegionsMask;
     vec2 displacedNosePoint = position.xy;

     vec2 noseOutlineWidthPoint = nose_getScaledNosePoint(displacedNosePoint, nose3DCenter, 0.3);
     displacedNosePoint = mix(displacedNosePoint, noseOutlineWidthPoint, noseOutlineWidth * noseTipCoarseMask*(1.0-noseVertivalAxisFineMask));

     vec2 noseBridgeWidthPoint = nose_getScaledNosePoint(displacedNosePoint, nose3DCenter, 0.3);
     displacedNosePoint = mix(displacedNosePoint, noseBridgeWidthPoint, noseBridgeWidth * noseVertivalAxisMask);

     vec2 noseSizePoint = nose_getScaledNosePoint(displacedNosePoint, nose3DCenter, 0.3);
     displacedNosePoint = mix(displacedNosePoint, noseSizePoint, noseSize * noseMask);

     const float kNoseLiftingYRatio = 0.05518821053;
     vec2 noseLiftingVector = vec2(0.0, -kNoseLiftingYRatio * nosePlainSize.y);
     noseLiftingVector = vec2(dot(noseLiftingVector, vec2(cos_t, -sin_t)), dot(noseLiftingVector, vec2(sin_t, cos_t)));
     vec2 nosePositionPoint = displacedNosePoint + noseLiftingVector;
     displacedNosePoint = mix(displacedNosePoint, nosePositionPoint, nosePosition * noseMask);

     vec2 noseTipPoint = noseTipCenter + vec2(0.4) * (displacedNosePoint - noseTipCenter);
     displacedNosePoint = mix(displacedNosePoint, noseTipPoint, noseTipSize * noseTipFineMask);

     vec2 diffPosition = displacedNosePoint - position.xy;
     return diffPosition;
 }
 vec2 lips_getScaledLipsPoint(in vec2 originalPoint, in vec2 scalingFactors, in float scalingCoefficient, in float lipsMask) {
     if (scalingCoefficient == 0.0) {
         return originalPoint;
     }
     vec2 lipsScaledPoint = lipsCenter + scalingFactors * (originalPoint - lipsCenter);
     return mix(originalPoint, lipsScaledPoint, scalingCoefficient * lipsMask);
 }

 vec2 lips_getScaledLipsPoint2(vec2 originalPoint, vec2 center, float theta, float scale) {
     float sin_t = sin(theta);
     float cos_t = cos(theta);
     vec2 v = originalPoint - center;
     float d = dot(v, vec2(cos_t, sin_t));
     d = d * scale;
     vec2 dv = d * vec2(cos_t, sin_t);

     return originalPoint+dv;
 }
 vec2 lips_getTransformYFactors() {
     const float kDistanceYRatio = 0.1;
     return kDistanceYRatio * (nose3DCenter - lipsCenter) / 2.0;
 }
 float lips_face_getFaceMaskLeft2(vec2 point) {
     return getEllipseMask2(vec2(1.0, 2.0), point, lipsProtectCenterLeft, lipsProtectSizeLeft, 0.8, 1.2, lipsProtectAngleLeft);
 }
 float lips_face_getFaceMaskRight2(vec2 point) {
     return getEllipseMask2(vec2(1.0, 2.0), point, lipsProtectCenterRight, lipsProtectSizeRight, 0.8, 1.2, lipsProtectAngleRight);
 }
 vec2 getLipsDiff() {
     const float kScalingFactor = 1.3;
     vec2 originalPosition = position.xy;
     vec2 faceFrameCoords = originalPosition;
     float teethRegionWeight = 0.0;
     float noseMask = nose_getNoseMask(vec2(1.0, 1.2), 0.8, 1.0);
     float faceCoarseMaskLeft2   = lips_face_getFaceMaskLeft2(position.xy);
     float faceCoarseMaskRight2   = lips_face_getFaceMaskRight2(position.xy);
     float lipsNegativeMask = (1.0 - teethRegionWeight) * (1.0 - noseMask) * (1.0 - faceCoarseMaskLeft2) * (1.0 - faceCoarseMaskRight2);
     float lipsMask = nose_getLipsMask(vec2(1.2, 1.2), 0.8, 1.1) * lipsNegativeMask;
//     lipsMask = lips_face_getFaceMaskLeft2(position.xy) + lips_face_getFaceMaskRight2(position.xy);
     float lipsMask1 = nose_getLipsMask(vec2(1.2, 1.1), 0.8, 0.9) * lipsNegativeMask;
     float lipsMask2 = nose_getLipsMask(vec2(1.2, 0.8), 1.0, 1.2) * lipsNegativeMask;
     vec2 displacedLipsPoint = position.xy;
     const vec2 kLipsWidthFactors = vec2(kScalingFactor, 1.0);
     displacedLipsPoint = mix(displacedLipsPoint, lips_getScaledLipsPoint2(displacedLipsPoint, lipsCenter, angles.z, 0.3), lipsWidth * lipsMask1);

     const vec2 kLipsHeightFactors = vec2(1.0, kScalingFactor);
     displacedLipsPoint = mix(displacedLipsPoint, lips_getScaledLipsPoint2(displacedLipsPoint, lipsCenter, kPi/2.0 + angles.z, 0.3), lipsHeight * lipsMask);

     const vec2 kLipsSizeFactors = vec2(kScalingFactor, kScalingFactor);
     displacedLipsPoint = lips_getScaledLipsPoint(displacedLipsPoint, kLipsSizeFactors, lipsSize, lipsMask);

     vec2 lipsYFactors = lips_getTransformYFactors();
     vec2 lipsTransformYPoint = displacedLipsPoint + lipsYFactors;
     displacedLipsPoint = mix(displacedLipsPoint, lipsTransformYPoint, lipsYPosition * lipsMask2);

     vec2 diffPosition = displacedLipsPoint - position.xy;
     return diffPosition;
 }

 float brow_getLeftEyebrowMask() {
     return getEllipseMask(vec2(1.4, 0.8), position.xy, leftEyebrowCenter, leftEyebrowPlainSize, 0.7, 1.0);
 }

 float brow_getRightEyebrowMask() {
     return getEllipseMask(vec2(1.4, 0.8), position.xy, rightEyebrowCenter, rightEyebrowPlainSize, 0.7, 1.0);
 }

 float brow_getLeftEyebrowMask2() {
     return getEllipseMask(vec2(1.0, 0.7), position.xy, leftEyebrowCenter, leftEyebrowPlainSize, 0.6, 1.0);
 }

 float brow_getRightEyebrowMask2() {
     return getEllipseMask(vec2(1.0, 0.7), position.xy, rightEyebrowCenter, rightEyebrowPlainSize, 0.6, 1.0);
 }
 vec2 brow_getEyebrowDistanceFactors() {
     const float kEyesDistanceXRatio = 0.03662283339;
     return kEyesDistanceXRatio * vec2(leftEyebrowCenter.x - rightEyebrowCenter.x, leftEyebrowCenter.y - rightEyebrowCenter.y);
 }
 vec2 brow_getEyebrowHeightFactors() {
     const float kEyesDistanceXRatio = 0.14;
     return kEyesDistanceXRatio * (leftEyebrowCenter + rightEyebrowCenter - leftEyeCenter - rightEyeCenter) / 2.0;
 }
 vec2 getEyebrowDiff() {
     float _noseNegativeMask    = 1.0 - nose_getNoseMask(vec2(3.0, 0.9), 0.7, 0.9);
     float _leftEyeNegativeMask = 1.0 - eye_getLeftEyeFineMask(vec2(1.5, 1.5), 0.6, 0.9);
     float _rightEyeNegativeMask = 1.0 - eye_getRightEyeFineMask(vec2(1.5, 1.5), 0.6, 0.9);
     float leftEyebrowMask   = brow_getLeftEyebrowMask() * _leftEyeNegativeMask * _noseNegativeMask;
     float rightEyebrowMask  = brow_getRightEyebrowMask() * _rightEyeNegativeMask * _noseNegativeMask;
     float leftEyebrowMask2   = brow_getLeftEyebrowMask2() * _leftEyeNegativeMask * _noseNegativeMask;
     float rightEyebrowMask2  = brow_getRightEyebrowMask2() * _rightEyeNegativeMask * _noseNegativeMask;
     vec2 displacedEyebrowPoint   = position.xy;

     // rotate
     vec2 leftEyebrow2DTiltPoint = leftEyebrowCenter + rotate2DPoint(displacedEyebrowPoint - leftEyebrowCenter, -eyebrowTiltAngle);
     displacedEyebrowPoint = mix(displacedEyebrowPoint, leftEyebrow2DTiltPoint, leftEyebrowMask2);
     vec2 rightEyebrow2DTiltPoint = rightEyebrowCenter + rotate2DPoint(displacedEyebrowPoint - rightEyebrowCenter, eyebrowTiltAngle);
     displacedEyebrowPoint = mix(displacedEyebrowPoint, rightEyebrow2DTiltPoint, rightEyebrowMask2);

     // distance
     vec2 eyebrowDistanceFactors = brow_getEyebrowDistanceFactors();
     vec2 leftEyeBrowDistancePoint = displacedEyebrowPoint + eyebrowDistance * eyebrowDistanceFactors;
     displacedEyebrowPoint = mix(displacedEyebrowPoint, leftEyeBrowDistancePoint, leftEyebrowMask);
     vec2 rightEyebrowDistancePoint = displacedEyebrowPoint - eyebrowDistance * eyebrowDistanceFactors;
     displacedEyebrowPoint = mix(displacedEyebrowPoint, rightEyebrowDistancePoint, rightEyebrowMask);

     vec2 eyebrowHeightFactors = brow_getEyebrowHeightFactors();
     vec2 leftEyeBrowHeightPoint = displacedEyebrowPoint + eyebrowHeight * eyebrowHeightFactors;
     displacedEyebrowPoint = mix(displacedEyebrowPoint, leftEyeBrowHeightPoint, leftEyebrowMask);
     vec2 rightEyebrowHeightPoint = displacedEyebrowPoint + eyebrowHeight * eyebrowHeightFactors;
     displacedEyebrowPoint = mix(displacedEyebrowPoint, rightEyebrowHeightPoint, rightEyebrowMask);

     vec2 diffPosition = displacedEyebrowPoint - position.xy;
     return diffPosition;
 }

 void main(){
     vec2 diffPosition = getEyeDiff() + getNoseDiff() + getLipsDiff() + getEyebrowDiff();
     vec4 color = texture2D(inputImageTexture, position.xy);
     vec2 offset = (color.xy * 255.0 + color.zw) / 127.5 - 1.0;
     textureCoordinate = diffPosition + offset;
    if(meshType > 0.0) {
        textureCoordinate = diffPosition + position.xy;
    }
     gl_Position = vec4(position.x*2.0-1.0, position.y*2.0-1.0, 0.0, 1.0);
 }