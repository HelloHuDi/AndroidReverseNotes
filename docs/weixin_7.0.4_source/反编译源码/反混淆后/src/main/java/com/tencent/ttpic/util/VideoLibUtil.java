package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoLibUtil {
    private static native int nativeGetFaceDetectLibVersion();

    private static native float[] nativeRigidTransform(float[] fArr, float[] fArr2, float[] fArr3);

    public static int getFaceDetectLibVersion() {
        AppMethodBeat.m2504i(84040);
        int nativeGetFaceDetectLibVersion = nativeGetFaceDetectLibVersion();
        AppMethodBeat.m2505o(84040);
        return nativeGetFaceDetectLibVersion;
    }

    public static int getFilterLibVersion() {
        AppMethodBeat.m2504i(84041);
        int versionCode = BaseFilter.getVersionCode();
        AppMethodBeat.m2505o(84041);
        return versionCode;
    }

    public static float[] estimateRigidTransform(float[] fArr, float[] fArr2, float[] fArr3) {
        AppMethodBeat.m2504i(84042);
        float[] nativeRigidTransform = nativeRigidTransform(fArr, fArr2, fArr3);
        AppMethodBeat.m2505o(84042);
        return nativeRigidTransform;
    }
}
