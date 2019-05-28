package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.or;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends c<or> {
    public i() {
        AppMethodBeat.i(243);
        this.xxI = or.class.getName().hashCode();
        AppMethodBeat.o(243);
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        AppMethodBeat.i(244);
        or orVar = (or) bVar;
        if (orVar == null) {
            AppMethodBeat.o(244);
            return false;
        }
        or.b bVar2 = orVar.cLe;
        f fVar = f.lTL;
        Context context = orVar.cLd.context;
        Bundle bundle = orVar.cLd.extras;
        int i = orVar.cLd.cKY;
        if (bundle == null || bundle.getBoolean("key_is_need_confirm_page", true)) {
            ab.i("MicroMsg.FaceDetectManager", "start face detect process");
            FaceDetectReporter.bsJ().bsK();
            FaceDetectReporter.bsJ().bsL();
            FaceDetectReporter.bsJ().lUA = System.currentTimeMillis();
            if (context != null) {
                if (bundle != null) {
                    int i2 = bundle.getInt("k_server_scene", 2);
                    FaceDetectReporter.bsJ().appId = bundle.getString("k_app_id", "");
                    if (f.ha(bundle.getBoolean("is_check_dyncfg", false))) {
                        Intent intent;
                        if (i2 == 2 || i2 == 5) {
                            ab.w("MicroMsg.FaceDetectManager", "carson: serverScene == FACE_DETECT_SERVER_SCENE_MP | FACE_DETECT_SERVER_SCENE_SUBAPP");
                            intent = new Intent(context, FaceDetectConfirmUI.class);
                        } else {
                            intent = new Intent(context, FaceDetectPrepareUI.class);
                        }
                        intent.putExtras(bundle);
                        ((Activity) context).startActivityForResult(intent, i);
                        z = true;
                    } else {
                        ab.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                        FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
                        bsJ.R(FaceDetectReporter.vl(i2), false);
                        bsJ.c(FaceDetectReporter.vl(i2), false, 3, 4, 90001);
                    }
                } else {
                    ab.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
                }
            }
        } else {
            z = f.a(context, bundle, i);
        }
        bVar2.cKV = z;
        if (!orVar.cLe.cKV) {
            orVar.cLe.extras = new Bundle();
            orVar.cLe.extras.putInt("err_code", 90001);
            orVar.cLe.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(244);
        return true;
    }
}
