package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetect.FaceProNative;
import com.tencent.p177mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.facedetect.model.g */
public final class C43032g {
    public FaceProNative lTP = null;

    public final FaceResult bsG() {
        AppMethodBeat.m2504i(214);
        if (this.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            AppMethodBeat.m2505o(214);
            return null;
        }
        try {
            long yz = C5046bo.m7588yz();
            C4990ab.m7417i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", Integer.valueOf(this.lTP.engineReleaseOut().result), Long.valueOf(C5046bo.m7588yz() - yz));
            this.lTP = null;
            AppMethodBeat.m2505o(214);
            return r1;
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.lTP.engineRelease();
            this.lTP = null;
            AppMethodBeat.m2505o(214);
            return null;
        }
    }

    public final int bsH() {
        AppMethodBeat.m2504i(215);
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.lTP == null);
        C4990ab.m7419v(str, str2, objArr);
        if (this.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            AppMethodBeat.m2505o(215);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        C4990ab.m7417i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", Integer.valueOf(this.lTP.engineRelease()));
        this.lTP = null;
        AppMethodBeat.m2505o(215);
        return this.lTP.engineRelease();
    }
}
