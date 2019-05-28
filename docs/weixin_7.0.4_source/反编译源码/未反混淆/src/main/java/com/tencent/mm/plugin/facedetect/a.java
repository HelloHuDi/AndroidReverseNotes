package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class a implements com.tencent.mm.vending.c.a<Void, Void> {
    private static j lRY = new j();
    private static o lRZ = new o();
    private static i lSa = new i();
    private static m lSb = new m();
    private static c lSc = new c();
    private static k lSd = new k();
    private b glt = null;

    static {
        AppMethodBeat.i(56);
        AppMethodBeat.o(56);
    }

    private static void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        AppMethodBeat.i(53);
        if (cVar == null) {
            ab.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
            AppMethodBeat.o(53);
        } else if (com.tencent.mm.sdk.b.a.xxA.e(cVar)) {
            ab.w("MicroMsg.TaskInitFace", "hy: already has listener");
            AppMethodBeat.o(53);
        } else {
            com.tencent.mm.sdk.b.a.xxA.c(cVar);
            AppMethodBeat.o(53);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(54);
        ab.i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.glt = f.dMj();
        safeAddListener(lRY);
        safeAddListener(lRZ);
        safeAddListener(lSa);
        safeAddListener(lSc);
        safeAddListener(lSd);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52);
                String bsP = p.bsP();
                String bsQ = p.bsQ();
                String bsR = p.bsR();
                ab.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b, postDetectModel: %s, exist: %s", bsP, Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.d.a.ct(bsP)), bsQ, Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.d.a.ct(bsQ)), bsR, Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.d.a.ct(bsR)));
                if (com.tencent.mm.pluginsdk.g.a.d.a.ct(bsP)) {
                    a.ei(bsP, "face_detect" + File.separator + "ufdmtcc.bin");
                } else {
                    ab.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
                    p.p(ah.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", bsP);
                }
                if (r4) {
                    a.ei(bsQ, "face_detect" + File.separator + "ufat.bin");
                } else {
                    ab.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
                    p.p(ah.getContext(), "face_detect" + File.separator + "ufat.bin", bsQ);
                }
                if (r5) {
                    a.ei(bsR, "face_detect" + File.separator + "PE.dat");
                    AppMethodBeat.o(52);
                    return;
                }
                ab.i("MicroMsg.TaskInitFace", "copy post detect model file");
                p.p(ah.getContext(), "face_detect" + File.separator + "PE.dat", bsR);
                AppMethodBeat.o(52);
            }
        }, "FaceDetectCopyModelFile");
        AppMethodBeat.o(54);
        return null;
    }

    static /* synthetic */ void ei(String str, String str2) {
        AppMethodBeat.i(55);
        String atg = e.atg(str);
        String atg2 = e.atg("assets:///".concat(String.valueOf(str2)));
        ab.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(atg)));
        ab.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(atg2)));
        if (atg.equals(atg2)) {
            ab.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", str);
            AppMethodBeat.o(55);
            return;
        }
        e.deleteFile(str);
        ab.i("MicroMsg.TaskInitFace", str + " md5 is wrong");
        p.p(ah.getContext(), str2, str);
        AppMethodBeat.o(55);
    }
}
