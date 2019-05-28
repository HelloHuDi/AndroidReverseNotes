package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.xwalk.core.XWalkUpdater;

public final class g {
    public FaceProNative lTP = null;

    public final FaceResult bsG() {
        AppMethodBeat.i(214);
        if (this.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            AppMethodBeat.o(214);
            return null;
        }
        try {
            long yz = bo.yz();
            ab.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", Integer.valueOf(this.lTP.engineReleaseOut().result), Long.valueOf(bo.yz() - yz));
            this.lTP = null;
            AppMethodBeat.o(214);
            return r1;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.lTP.engineRelease();
            this.lTP = null;
            AppMethodBeat.o(214);
            return null;
        }
    }

    public final int bsH() {
        AppMethodBeat.i(215);
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.lTP == null);
        ab.v(str, str2, objArr);
        if (this.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            AppMethodBeat.o(215);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        ab.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", Integer.valueOf(this.lTP.engineRelease()));
        this.lTP = null;
        AppMethodBeat.o(215);
        return this.lTP.engineRelease();
    }
}
