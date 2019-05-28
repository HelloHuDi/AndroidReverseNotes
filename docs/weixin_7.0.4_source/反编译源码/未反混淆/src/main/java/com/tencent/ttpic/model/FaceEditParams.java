package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class FaceEditParams implements Cloneable {
    public HashMap<String, Double> mParamsMap = new HashMap();

    public FaceEditParams() {
        AppMethodBeat.i(83482);
        this.mParamsMap.put("BEAUTY_WHITE", Double.valueOf(0.2d));
        this.mParamsMap.put("BEAUTY_SMOOTH", Double.valueOf(0.5d));
        this.mParamsMap.put("BEAUTY_COMPLEXION", Double.valueOf(0.5d));
        this.mParamsMap.put("BEAUTY_ANTISPOT", Double.valueOf(1.0d));
        this.mParamsMap.put("BEAUTY_EYEPOUCH", Double.valueOf(0.0d));
        this.mParamsMap.put("BEAUTY_TOOTH", Double.valueOf(0.0d));
        this.mParamsMap.put("BEAUTY_EYELIGHT", Double.valueOf(0.7d));
        this.mParamsMap.put("BEAUTY_GLOSSY", Double.valueOf(0.0d));
        AppMethodBeat.o(83482);
    }

    public void updateFaceParam(String str, double d) {
        AppMethodBeat.i(83483);
        if (this.mParamsMap.containsKey(str)) {
            this.mParamsMap.put(str, Double.valueOf(d));
        }
        AppMethodBeat.o(83483);
    }

    public FaceEditParams clone() {
        AppMethodBeat.i(83484);
        FaceEditParams faceEditParams = new FaceEditParams();
        for (String str : this.mParamsMap.keySet()) {
            faceEditParams.mParamsMap.put(str, Double.valueOf(((Double) this.mParamsMap.get(str)).doubleValue()));
        }
        AppMethodBeat.o(83484);
        return faceEditParams;
    }
}
