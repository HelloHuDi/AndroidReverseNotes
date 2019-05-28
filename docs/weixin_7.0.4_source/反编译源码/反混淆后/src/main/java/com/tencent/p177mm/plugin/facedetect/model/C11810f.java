package com.tencent.p177mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.facedetect.FaceProNative;
import com.tencent.p177mm.plugin.facedetect.p403ui.FaceDetectPrepareUI;
import com.tencent.p177mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.facedetect.model.f */
public enum C11810f {
    ;
    
    private static C5004al lTN;
    public FaceDetectProcessService lTM;

    private C11810f(String str) {
        this.lTM = null;
    }

    static {
        lTN = new C5004al("face_process");
        AppMethodBeat.m2505o(213);
    }

    /* renamed from: V */
    public static void m19659V(Runnable runnable) {
        AppMethodBeat.m2504i(202);
        lTN.mo10302aa(runnable);
        AppMethodBeat.m2505o(202);
    }

    public static void bsz() {
        AppMethodBeat.m2504i(203);
        lTN.doN().removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(203);
    }

    public static C7306ak bsA() {
        AppMethodBeat.m2504i(204);
        C7306ak doN = lTN.doN();
        AppMethodBeat.m2505o(204);
        return doN;
    }

    /* renamed from: ha */
    public static boolean m19662ha(boolean z) {
        AppMethodBeat.m2504i(205);
        C4990ab.m7417i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", Boolean.valueOf(z));
        boolean dL = C11810f.m19661dL(C4996ah.getContext());
        boolean bsN = C43036p.bsN();
        if (z) {
            boolean z2;
            if (C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("BioSigFaceEntry"), 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            C4990ab.m7417i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", Boolean.valueOf(z2), Boolean.valueOf(dL), Boolean.valueOf(bsN));
            if (!z2 || (dL & bsN) == 0) {
                AppMethodBeat.m2505o(205);
                return false;
            }
            AppMethodBeat.m2505o(205);
            return true;
        }
        C4990ab.m7417i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", Boolean.valueOf(dL), Boolean.valueOf(bsN));
        if (bsN && dL) {
            AppMethodBeat.m2505o(205);
            return true;
        }
        AppMethodBeat.m2505o(205);
        return false;
    }

    public static boolean bsB() {
        AppMethodBeat.m2504i(138982);
        boolean bsN = C43036p.bsN();
        AppMethodBeat.m2505o(138982);
        return bsN;
    }

    /* renamed from: dL */
    static boolean m19661dL(Context context) {
        AppMethodBeat.m2504i(207);
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        AppMethodBeat.m2505o(207);
        return hasSystemFeature;
    }

    /* renamed from: a */
    public static boolean m19660a(Context context, Bundle bundle, int i) {
        AppMethodBeat.m2504i(208);
        C4990ab.m7416i("MicroMsg.FaceDetectManager", "start wx internal face verify");
        if (context == null || bundle == null) {
            AppMethodBeat.m2505o(208);
            return false;
        }
        Intent intent = new Intent(context, FaceDetectPrepareUI.class);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, i);
        AppMethodBeat.m2505o(208);
        return true;
    }

    public final int bsC() {
        AppMethodBeat.m2504i(209);
        C43032g c43032g = this.lTM.lVR;
        if (c43032g.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
            AppMethodBeat.m2505o(209);
            return -3;
        }
        int engineReleaseCurrMotion = c43032g.lTP.engineReleaseCurrMotion();
        AppMethodBeat.m2505o(209);
        return engineReleaseCurrMotion;
    }

    public final int bsD() {
        AppMethodBeat.m2504i(210);
        C43032g c43032g = this.lTM.lVR;
        if (c43032g.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
            AppMethodBeat.m2505o(210);
            return -1;
        }
        int engineGetCurrMotion = c43032g.lTP.engineGetCurrMotion();
        AppMethodBeat.m2505o(210);
        return engineGetCurrMotion;
    }

    public final int bsF() {
        AppMethodBeat.m2504i(212);
        C43032g c43032g = this.lTM.lVR;
        if (c43032g.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            AppMethodBeat.m2505o(212);
            return -1;
        }
        int engineGroupChange = c43032g.lTP.engineGroupChange();
        AppMethodBeat.m2505o(212);
        return engineGroupChange;
    }

    public static int bsE() {
        AppMethodBeat.m2504i(211);
        int engineVersion = FaceProNative.engineVersion();
        AppMethodBeat.m2505o(211);
        return engineVersion;
    }
}
