package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public enum f {
    ;
    
    private static al lTN;
    public FaceDetectProcessService lTM;

    private f(String str) {
        this.lTM = null;
    }

    static {
        lTN = new al("face_process");
        AppMethodBeat.o(213);
    }

    public static void V(Runnable runnable) {
        AppMethodBeat.i(202);
        lTN.aa(runnable);
        AppMethodBeat.o(202);
    }

    public static void bsz() {
        AppMethodBeat.i(203);
        lTN.doN().removeCallbacksAndMessages(null);
        AppMethodBeat.o(203);
    }

    public static ak bsA() {
        AppMethodBeat.i(204);
        ak doN = lTN.doN();
        AppMethodBeat.o(204);
        return doN;
    }

    public static boolean ha(boolean z) {
        AppMethodBeat.i(205);
        ab.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", Boolean.valueOf(z));
        boolean dL = dL(ah.getContext());
        boolean bsN = p.bsN();
        if (z) {
            boolean z2;
            if (bo.getInt(((a) g.K(a.class)).Nu().getValue("BioSigFaceEntry"), 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            ab.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", Boolean.valueOf(z2), Boolean.valueOf(dL), Boolean.valueOf(bsN));
            if (!z2 || (dL & bsN) == 0) {
                AppMethodBeat.o(205);
                return false;
            }
            AppMethodBeat.o(205);
            return true;
        }
        ab.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", Boolean.valueOf(dL), Boolean.valueOf(bsN));
        if (bsN && dL) {
            AppMethodBeat.o(205);
            return true;
        }
        AppMethodBeat.o(205);
        return false;
    }

    public static boolean bsB() {
        AppMethodBeat.i(138982);
        boolean bsN = p.bsN();
        AppMethodBeat.o(138982);
        return bsN;
    }

    static boolean dL(Context context) {
        AppMethodBeat.i(207);
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
        AppMethodBeat.o(207);
        return hasSystemFeature;
    }

    public static boolean a(Context context, Bundle bundle, int i) {
        AppMethodBeat.i(208);
        ab.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
        if (context == null || bundle == null) {
            AppMethodBeat.o(208);
            return false;
        }
        Intent intent = new Intent(context, FaceDetectPrepareUI.class);
        intent.putExtras(bundle);
        ((Activity) context).startActivityForResult(intent, i);
        AppMethodBeat.o(208);
        return true;
    }

    public final int bsC() {
        AppMethodBeat.i(209);
        g gVar = this.lTM.lVR;
        if (gVar.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
            AppMethodBeat.o(209);
            return -3;
        }
        int engineReleaseCurrMotion = gVar.lTP.engineReleaseCurrMotion();
        AppMethodBeat.o(209);
        return engineReleaseCurrMotion;
    }

    public final int bsD() {
        AppMethodBeat.i(210);
        g gVar = this.lTM.lVR;
        if (gVar.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
            AppMethodBeat.o(210);
            return -1;
        }
        int engineGetCurrMotion = gVar.lTP.engineGetCurrMotion();
        AppMethodBeat.o(210);
        return engineGetCurrMotion;
    }

    public final int bsF() {
        AppMethodBeat.i(212);
        g gVar = this.lTM.lVR;
        if (gVar.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            AppMethodBeat.o(212);
            return -1;
        }
        int engineGroupChange = gVar.lTP.engineGroupChange();
        AppMethodBeat.o(212);
        return engineGroupChange;
    }

    public static int bsE() {
        AppMethodBeat.i(211);
        int engineVersion = FaceProNative.engineVersion();
        AppMethodBeat.o(211);
        return engineVersion;
    }
}
