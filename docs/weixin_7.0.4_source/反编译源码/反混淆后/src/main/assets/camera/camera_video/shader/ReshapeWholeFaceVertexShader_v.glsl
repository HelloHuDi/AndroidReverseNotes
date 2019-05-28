 precision highp float;

 attribute vec4 position;
 //common
 uniform float sin_t;
 uniform float cos_t;
 uniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll
 uniform vec2 size;
 varying highp vec2 textureCoordinate;

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
 uniform vec2 nostrilsCenter;
 uniform vec2 nostrilsPlaneSize;
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

 //wrinkle
 uniform vec2 lipsLeftEdge;
 uniform vec2 lipsRightEdge;
 uniform float faceSmile;

 //jaw
 uniform vec2 jawCenterOfGravity;
 uniform vec2 jawSize;
 uniform float faceJaw;

 //eye brow
 uniform vec2 leftEyebrowPlainSize;
 uniform vec2 leftEyebrowCenter;
 uniform vec2 rightEyebrowPlainSize;
 uniform vec2 rightEyebrowCenter;
 uniform float eyebrowHeight; // eyebrow height adjust factor
 uniform float eyebrowDistance;
 uniform float eyebrowTiltAngle; // rotate angle need to apply

 //face width
 uniform vec2 facePlainSize;
 uniform vec2 faceCenter;
 uniform float faceWidth;
 uniform float faceWidth2;

 uniform vec2 facePlainSizeLeft2;
 uniform vec2 faceCenterLeft2;
 uniform float leftAngle2;
 uniform vec2 facePlainSizeRight2;
 uniform vec2 faceCenterRight2;
 uniform float rightAngle2;
 uniform vec2 faceMoveCenter2;

 //forehead
 uniform vec2 foreheadSize;
 uniform vec2 foreheadCenter;
 uniform float foreheadHeight;

 const float kLipsEdgeWrinkleSizeToLipsSizeRatio = 0.23;
 const float kPi = 3.14159265358979;
 const float kLipsEdgeWrinklesRotationAngle = 0.025 * kPi;

 uniform float meshType;
 uniform sampler2D inputImageTexture;

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

 float face_getLeftEyeMask() {
     return getEllipseMask(vec2(1.5, 0.9), position.xy, leftEyeCenter, leftEyePlainSize, 0.5, 1.2);
 }
 float face_getRightEyeMask() {
     return getEllipseMask(vec2(1.5, 0.9), position.xy, rightEyeCenter, rightEyePlainSize, 0.5, 1.2);
 }
 float face_getLeftEyebrowMask() {
     return getEllipseMask(vec2(1.1, 1.0), position.xy, leftEyebrowCenter, leftEyebrowPlainSize, 0.5, 1.0);
 }
 float face_getRightEyebrowMask() {
     return getEllipseMask(vec2(1.1, 1.0), position.xy, rightEyebrowCenter, rightEyebrowPlainSize, 0.5, 1.0);
 }
 float face_getLipsMask() {
     return getEllipseMask(vec2(1.5, 1.5), position.xy, lipsCenter, lipsPlainSize, 0.5, 1.2);
 }
 float face_getNoseMask() {
     return getEllipseMask(vec2(1.1, 1.0), position.xy, nose3DCenter, nosePlainSize, 0.5, 1.2);
 }
 float face_getFaceMask() {
     return getEllipseMask(vec2(1.5, 1.2), position.xy, faceCenter, facePlainSize, 0.7, 0.9);
 }
 float face_getFaceMaskLeft2(vec2 point) {
     return getEllipseMask2(vec2(3.0, 1.4), point, faceCenterLeft2, facePlainSizeLeft2, 0.5, 1.3, leftAngle2);
 }
 float face_getFaceMaskRight2(vec2 point) {
     return getEllipseMask2(vec2(3.0, 1.4), point, faceCenterRight2, facePlainSizeRight2, 0.5, 1.3, rightAngle2);
 }
 vec2 face_getScaledFacePoint2(vec2 originalPoint, float scalingFactor, float faceCoarseMask) {
     if (scalingFactor == 0.0) {
         return originalPoint;
     }
     vec2 v = originalPoint - faceCenter;
     float d = dot(v, vec2(cos_t, sin_t));
     d = d * 0.45 * faceCoarseMask * scalingFactor;
     vec2 sc = d * vec2(cos_t, sin_t);
     return originalPoint+sc;
 }

 vec2 getFaceWidthDiff() {
     float faceNegativeRegionsMask = (1.0 - 0.8*face_getLeftEyeMask()) * (1.0 - 0.8*face_getRightEyeMask()) * (1.0 - 0.8*face_getLeftEyebrowMask()) * (1.0 - 0.8*face_getRightEyebrowMask()) * (1.0 - 0.6*face_getLipsMask()) * (1.0 - 0.9*face_getNoseMask());
     float faceCoarseMask   = face_getFaceMask();
     float faceCoarseMaskLeft2   = face_getFaceMaskLeft2(position.xy);
     float faceCoarseMaskRight2   = face_getFaceMaskRight2(position.xy);
     vec2 displacedFacePoint   = position.xy;

     // width
     displacedFacePoint = face_getScaledFacePoint2(displacedFacePoint, faceWidth, faceCoarseMask*faceNegativeRegionsMask);

     //displacedFacePoint = face_getScaledFacePoint2(displacedFacePoint, faceWidth2, angles.z, faceCoarseMask2*faceNegativeRegionsMask);
     vec2 leftPush2 = displacedFacePoint - (faceMoveCenter2 - displacedFacePoint) * 0.0 - (faceMoveCenter2 - faceCenterLeft2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, leftPush2, faceCoarseMaskLeft2 * faceWidth2);
     vec2 rightPush2 = displacedFacePoint - (faceMoveCenter2 - displacedFacePoint) * 0.0 - (faceMoveCenter2 - faceCenterRight2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, rightPush2, faceCoarseMaskRight2 * faceWidth2);

     faceCoarseMaskLeft2   = face_getFaceMaskLeft2(displacedFacePoint);
     faceCoarseMaskRight2   = face_getFaceMaskRight2(displacedFacePoint);
     leftPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterLeft2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, leftPush2, faceCoarseMaskLeft2 * faceWidth2);
     rightPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterRight2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, rightPush2, faceCoarseMaskRight2 * faceWidth2);

     faceCoarseMaskLeft2   = face_getFaceMaskLeft2(displacedFacePoint);
     faceCoarseMaskRight2   = face_getFaceMaskRight2(displacedFacePoint);
     leftPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterLeft2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, leftPush2, faceCoarseMaskLeft2 * faceWidth2);
     rightPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterRight2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, rightPush2, faceCoarseMaskRight2 * faceWidth2);

     faceCoarseMaskLeft2   = face_getFaceMaskLeft2(displacedFacePoint);
     faceCoarseMaskRight2   = face_getFaceMaskRight2(displacedFacePoint);
     leftPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterLeft2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, leftPush2, faceCoarseMaskLeft2 * faceWidth2);
     rightPush2 = displacedFacePoint - (faceMoveCenter2 - faceCenterRight2)* 0.1;
     displacedFacePoint = mix(displacedFacePoint, rightPush2, faceCoarseMaskRight2 * faceWidth2);

     vec2 diffPosition = displacedFacePoint - position.xy;
     return diffPosition;
 }


 float jaw_getLipsMask() {
     return getEllipseMask(vec2(1.4, 1.0), position.xy, lipsCenter, lipsPlainSize, 0.5, 1.2);
 }
 float jaw_getNoseMask() {
     return getEllipseMask(vec2(1.0, 1.5), position.xy, nose3DCenter, nosePlainSize, 0.5, 1.2);
 }
 float jaw_getJawMask() {
     return getEllipseMask(vec2(1.8, 1.0), position.xy, jawCenterOfGravity, jawSize, 0.5, 1.2);
 }
 vec2 getJawDiff() {
     float lipsMask = jaw_getLipsMask();
     float noseMask = jaw_getNoseMask();
     float jawMask = jaw_getJawMask() * (1.0 - 0.9 * lipsMask) * (1.0 - 0.9 * noseMask);

     vec2 displacedPoint = position.xy;

     const float kJawLiftingYRatio = 0.1;
     vec2 jawLiftingVector = vec2(0.0, kJawLiftingYRatio * jawSize.y);
     jawLiftingVector = vec2(dot(jawLiftingVector, vec2(cos_t, -sin_t)), dot(jawLiftingVector, vec2(sin_t, cos_t)));
     vec2 jawPositionPoint = displacedPoint + jawLiftingVector;
     vec2 displacedPoint2 = mix(displacedPoint, jawPositionPoint, faceJaw * jawMask);

     const vec2 kScaleFactors = vec2(1.1, 1.1);
     displacedPoint = jawCenterOfGravity + kScaleFactors * (position.xy - jawCenterOfGravity);
     displacedPoint = mix(position.xy, displacedPoint, faceJaw * jawMask);

     displacedPoint = displacedPoint * 0.65 + displacedPoint2 * 0.35;
     vec2 diffPosition = displacedPoint - position.xy;
     return diffPosition;
 }

 float head_getLeftEyebrowMask() {
     return getEllipseMask(vec2(1.0, 0.8), position.xy, leftEyebrowCenter, leftEyebrowPlainSize, 0.6, 1.0);
 }
 float head_getRightEyebrowMask() {
     return getEllipseMask(vec2(1.0, 0.8), position.xy, rightEyebrowCenter, rightEyebrowPlainSize, 0.6, 1.0);
 }
 float head_getForeheadMask() {
     return getEllipseMask(vec2(1.5, 1.5), position.xy, foreheadCenter, foreheadSize, 0.5, 1.5);
 }

 vec2 getForeHeadDiff() {
     float foreheadMask    = head_getForeheadMask() * (1.0 - head_getLeftEyebrowMask()) * (1.0 - head_getRightEyebrowMask());
     vec2 displacedForeheadPoint   = position.xy;

     const float kForeheadLiftingYRatio = 0.05518821053;
     vec2 foreheadLiftingVector = vec2(0.0, -kForeheadLiftingYRatio * foreheadSize.y);
     foreheadLiftingVector = vec2(dot(foreheadLiftingVector, vec2(cos_t, -sin_t)), dot(foreheadLiftingVector, vec2(sin_t, cos_t)));
     vec2 foreheadPositionPoint = displacedForeheadPoint + foreheadLiftingVector;
     displacedForeheadPoint = mix(displacedForeheadPoint, foreheadPositionPoint, foreheadMask * foreheadHeight);

     vec2 diffPosition = displacedForeheadPoint - position.xy;
     return diffPosition;
 }

 vec2 wrinkle_rotate2DPointAroundCenter(in vec2 point, in vec2 center, in float angle) {
     return center + rotate2DPoint(point - center, angle);
 }
 vec2 wrinkle_getRotatedLipsEdgeWrinkle(in vec2 originalPoint, in int isLeftSide) {
     vec2 wrinkleSize = 1.1*vec2(kLipsEdgeWrinkleSizeToLipsSizeRatio * lipsPlainSize.x, 0.6*lipsPlainSize.y);
     vec2 lipsEdge = isLeftSide == 1 ? lipsLeftEdge : lipsRightEdge;
     float directionSign = isLeftSide == 1 ? 1.0 : -1.0;
     vec2 wrinkleCenter = lipsEdge + directionSign * 0.055 * (lipsRightEdge - lipsLeftEdge);

     float wrinkleMask = getEllipseMask(vec2(0.8, 0.5), position.xy, wrinkleCenter,wrinkleSize, 0.5, 1.2);
     vec2 wrinkleRotationCenter = lipsEdge + directionSign * 0.2 * (lipsRightEdge - lipsLeftEdge);
     vec2 rotated2DPoint = wrinkle_rotate2DPointAroundCenter(originalPoint, wrinkleRotationCenter, - directionSign * wrinkleMask * kLipsEdgeWrinklesRotationAngle);
     return rotated2DPoint;
 }
 vec2 wrinkle_getRotatedLipsLeftEdgeWrinkle(in vec2 originalPoint) {
     return wrinkle_getRotatedLipsEdgeWrinkle(originalPoint, 1);
 }
 vec2 wrinkle_getRotatedLipsRightEdgeWrinkle(in vec2 originalPoint) {
     return wrinkle_getRotatedLipsEdgeWrinkle(originalPoint, 0);
 }

 float wrinkle_getNoseMask() {
     return getEllipseMask(vec2(1.2, 1.5), position.xy, nose3DCenter.xy, nosePlainSize, 0.8, 1.0);
 }
 vec2 getWrinkleDiff() {
     vec2 displacedPoint = position.xy;
     float _noseMask = wrinkle_getNoseMask() * 0.8;
     displacedPoint = mix(wrinkle_getRotatedLipsLeftEdgeWrinkle(displacedPoint), displacedPoint, _noseMask);
     displacedPoint = mix(wrinkle_getRotatedLipsRightEdgeWrinkle(displacedPoint), displacedPoint, _noseMask);
     vec2 displacedPosition = position.xy + faceSmile * (displacedPoint - position.xy);
     vec2 diffPosition = displacedPosition - position.xy;
     return diffPosition;
 }

 void main(){
     vec2 diffPosition =  getJawDiff() + getFaceWidthDiff() + getForeHeadDiff() + getWrinkleDiff();
     vec4 color = texture2D(inputImageTexture, position.xy);
     vec2 offset = (color.xy * 255.0 + color.zw) / 127.5 - 1.0;
     textureCoordinate = diffPosition + offset;
    if(meshType > 0.0) {
        textureCoordinate = diffPosition + position.xy;
    }
     gl_Position = vec4(position.x*2.0-1.0, position.y*2.0-1.0, 0.0, 1.0);
 }