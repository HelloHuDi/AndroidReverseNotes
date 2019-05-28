package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.FaceFeatureParam;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParam {
    public float adjustValue = 1.0f;
    public int beautyLevel = 0;
    public float clarityAdjustValue = 0.8f;
    public float colorToneAlpha = 0.0f;
    public float contrastLevel = 0.0f;
    public int effectIndex = 0;
    public float exposureLevel = 50.0f;
    public float eyeLightenAlpha = 0.25f;
    public float eyeLightenAlpha_573 = 0.8f;
    public float faceCenterX = 0.5f;
    public float faceCenterY = 0.5f;
    public float faceFeatureAdjustValue_573 = 0.8f;
    public float faceFeatureNormalFactor = 1.0f;
    public FaceFeatureParam faceFeatureParam = new FaceFeatureParam(0.8f);
    public int faceRotation = 0;
    public float faceWidth = 0.0f;
    public int filterId = 0;
    public String flagId;
    public int[] histogram;
    public boolean isBlackOpen = false;
    public boolean isBlurOpen = false;
    public float removePounchAlpha = 0.3f;
    public float removePounchAlpha_573 = 0.7f;
    public int smoothLevel = -1;
    public float toothWhitenAdjustValue = 0.0f;

    public CameraFilterParam() {
        AppMethodBeat.m2504i(83461);
        AppMethodBeat.m2505o(83461);
    }

    public Map<String, Object> getBlurMap(boolean z) {
        AppMethodBeat.m2504i(83462);
        HashMap hashMap = new HashMap();
        if (((double) this.faceWidth) > 0.0d) {
            hashMap.put("circle", Boolean.FALSE);
            hashMap.put("tx", Float.valueOf(this.faceCenterX));
            hashMap.put("ty", Float.valueOf(z ? 1.0f - this.faceCenterY : this.faceCenterY));
            hashMap.put("radius", Float.valueOf(this.faceWidth / 2.0f));
            hashMap.put("angle", Float.valueOf(((float) this.faceRotation) + 180.0f));
            if (!z && this.faceRotation % 180 == 0) {
                hashMap.put("angle", Float.valueOf((float) this.faceRotation));
            }
        } else {
            hashMap.put("tx", Float.valueOf(0.5f));
            hashMap.put("ty", Float.valueOf(0.5f));
            hashMap.put("radius", Float.valueOf(0.35f));
            hashMap.put("circle", Boolean.TRUE);
        }
        AppMethodBeat.m2505o(83462);
        return hashMap;
    }

    public Map<String, Object> getSmoothMap() {
        AppMethodBeat.m2504i(83463);
        HashMap hashMap = new HashMap();
        switch (this.smoothLevel) {
            case -1:
                hashMap.put("opttype", Float.valueOf(0.0f));
                hashMap.put("smoothMag", Float.valueOf(0.0f));
                hashMap.put("whitenmag", Float.valueOf(0.0f));
                break;
            case 1:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("smoothMag", Float.valueOf(0.2f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 2:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("smoothMag", Float.valueOf(0.35f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 3:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("smoothMag", Float.valueOf(0.5f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 4:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("smoothMag", Float.valueOf(0.625f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 5:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("smoothMag", Float.valueOf(0.75f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
        }
        AppMethodBeat.m2505o(83463);
        return hashMap;
    }

    public Map<String, Object> getSmoothMap(int i) {
        AppMethodBeat.m2504i(83464);
        this.beautyLevel = i;
        HashMap hashMap = new HashMap();
        hashMap.put("smoothMag", Float.valueOf((((float) i) / 100.0f) * 0.9f));
        AppMethodBeat.m2505o(83464);
        return hashMap;
    }

    public CameraFilterParam copyParam() {
        AppMethodBeat.m2504i(83465);
        CameraFilterParam cameraFilterParam = new CameraFilterParam();
        cameraFilterParam.smoothLevel = this.smoothLevel;
        cameraFilterParam.effectIndex = this.effectIndex;
        cameraFilterParam.filterId = this.filterId;
        cameraFilterParam.flagId = this.flagId;
        cameraFilterParam.isBlurOpen = this.isBlurOpen;
        cameraFilterParam.faceCenterX = this.faceCenterX;
        cameraFilterParam.faceCenterY = this.faceCenterY;
        cameraFilterParam.faceWidth = this.faceWidth;
        cameraFilterParam.faceRotation = this.faceRotation;
        cameraFilterParam.isBlackOpen = this.isBlackOpen;
        cameraFilterParam.beautyLevel = this.beautyLevel;
        cameraFilterParam.removePounchAlpha_573 = this.removePounchAlpha_573;
        cameraFilterParam.removePounchAlpha = this.removePounchAlpha;
        cameraFilterParam.eyeLightenAlpha = this.eyeLightenAlpha;
        cameraFilterParam.eyeLightenAlpha_573 = this.eyeLightenAlpha_573;
        cameraFilterParam.adjustValue = this.adjustValue;
        cameraFilterParam.faceFeatureParam = this.faceFeatureParam;
        cameraFilterParam.faceFeatureAdjustValue_573 = this.faceFeatureAdjustValue_573;
        cameraFilterParam.clarityAdjustValue = this.clarityAdjustValue;
        cameraFilterParam.exposureLevel = this.exposureLevel;
        cameraFilterParam.toothWhitenAdjustValue = this.toothWhitenAdjustValue;
        cameraFilterParam.colorToneAlpha = this.colorToneAlpha;
        cameraFilterParam.contrastLevel = this.contrastLevel;
        AppMethodBeat.m2505o(83465);
        return cameraFilterParam;
    }

    public PointF getRealFaceCenter() {
        AppMethodBeat.m2504i(83466);
        PointF pointF = new PointF(this.faceCenterX, this.faceCenterY);
        switch (this.faceRotation) {
            case 90:
                pointF.y = 1.0f - this.faceCenterX;
                pointF.x = this.faceCenterY;
                break;
            case 180:
                pointF.y = 1.0f - this.faceCenterY;
                pointF.x = 1.0f - this.faceCenterX;
                break;
            case 270:
                pointF.y = this.faceCenterX;
                pointF.x = 1.0f - this.faceCenterY;
                break;
        }
        AppMethodBeat.m2505o(83466);
        return pointF;
    }
}
