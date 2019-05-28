package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParamSDK {
    public int effectIndex = 0;
    public float faceCenterX = 0.5f;
    public float faceCenterY = 0.5f;
    public int faceRotation = 0;
    public float faceWidth = 0.0f;
    public int filterId = 0;
    public String flagId;
    public boolean isBlackOpen = false;
    public boolean isBlurOpen = false;
    private boolean lowEnergy = false;
    public int smoothLevel = -1;

    public Map<String, Object> getBlurMap(boolean z) {
        AppMethodBeat.m2504i(83467);
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
        AppMethodBeat.m2505o(83467);
        return hashMap;
    }

    public void enableLowEnergy(boolean z) {
        this.lowEnergy = z;
    }

    public Map<String, Object> getSmoothMap() {
        AppMethodBeat.m2504i(83468);
        if (this.lowEnergy) {
            Map smoothMapLowEnergy = getSmoothMapLowEnergy();
            AppMethodBeat.m2505o(83468);
            return smoothMapLowEnergy;
        }
        Map<String, Object> smoothMapCommon = getSmoothMapCommon();
        AppMethodBeat.m2505o(83468);
        return smoothMapCommon;
    }

    private Map<String, Object> getSmoothMapCommon() {
        AppMethodBeat.m2504i(83469);
        HashMap hashMap = new HashMap();
        switch (this.smoothLevel) {
            case 0:
                hashMap.put("opttype", Float.valueOf(0.0f));
                hashMap.put("radius", Float.valueOf(0.0f));
                hashMap.put("whitenmag", Float.valueOf(0.0f));
                break;
            case 1:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.2f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 2:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.35f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 3:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.5f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 4:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.625f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 5:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.75f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
        }
        AppMethodBeat.m2505o(83469);
        return hashMap;
    }

    private Map<String, Object> getSmoothMapLowEnergy() {
        AppMethodBeat.m2504i(83470);
        HashMap hashMap = new HashMap();
        switch (this.smoothLevel) {
            case 0:
                hashMap.put("opttype", Float.valueOf(0.0f));
                hashMap.put("radius", Float.valueOf(0.0f));
                hashMap.put("whitenmag", Float.valueOf(0.0f));
                break;
            case 1:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.1f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 2:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.1725f));
                hashMap.put("whitenmag", Float.valueOf(0.2f));
                break;
            case 3:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.25f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 4:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.3125f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
            case 5:
                hashMap.put("opttype", Float.valueOf(1.0f));
                hashMap.put("radius", Float.valueOf(0.375f));
                hashMap.put("whitenmag", Float.valueOf(0.25f));
                break;
        }
        AppMethodBeat.m2505o(83470);
        return hashMap;
    }

    public CameraFilterParamSDK copyParam() {
        AppMethodBeat.m2504i(83471);
        CameraFilterParamSDK cameraFilterParamSDK = new CameraFilterParamSDK();
        cameraFilterParamSDK.smoothLevel = this.smoothLevel;
        cameraFilterParamSDK.effectIndex = this.effectIndex;
        cameraFilterParamSDK.filterId = this.filterId;
        cameraFilterParamSDK.flagId = this.flagId;
        cameraFilterParamSDK.isBlurOpen = this.isBlurOpen;
        cameraFilterParamSDK.faceCenterX = this.faceCenterX;
        cameraFilterParamSDK.faceCenterY = this.faceCenterY;
        cameraFilterParamSDK.faceWidth = this.faceWidth;
        cameraFilterParamSDK.faceRotation = this.faceRotation;
        cameraFilterParamSDK.isBlackOpen = this.isBlackOpen;
        AppMethodBeat.m2505o(83471);
        return cameraFilterParamSDK;
    }

    public PointF getRealFaceCenter() {
        AppMethodBeat.m2504i(83472);
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
        AppMethodBeat.m2505o(83472);
        return pointF;
    }
}
