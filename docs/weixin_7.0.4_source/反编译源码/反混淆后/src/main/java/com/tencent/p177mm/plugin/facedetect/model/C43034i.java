package com.tencent.p177mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37778or;
import com.tencent.p177mm.p230g.p231a.C37778or.C9437b;
import com.tencent.p177mm.plugin.facedetect.p403ui.FaceDetectConfirmUI;
import com.tencent.p177mm.plugin.facedetect.p403ui.FaceDetectPrepareUI;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.model.i */
public final class C43034i extends C4884c<C37778or> {
    public C43034i() {
        AppMethodBeat.m2504i(243);
        this.xxI = C37778or.class.getName().hashCode();
        AppMethodBeat.m2505o(243);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z = false;
        AppMethodBeat.m2504i(244);
        C37778or c37778or = (C37778or) c4883b;
        if (c37778or == null) {
            AppMethodBeat.m2505o(244);
            return false;
        }
        C9437b c9437b = c37778or.cLe;
        C11810f c11810f = C11810f.lTL;
        Context context = c37778or.cLd.context;
        Bundle bundle = c37778or.cLd.extras;
        int i = c37778or.cLd.cKY;
        if (bundle == null || bundle.getBoolean("key_is_need_confirm_page", true)) {
            C4990ab.m7416i("MicroMsg.FaceDetectManager", "start face detect process");
            FaceDetectReporter.bsJ().bsK();
            FaceDetectReporter.bsJ().bsL();
            FaceDetectReporter.bsJ().lUA = System.currentTimeMillis();
            if (context != null) {
                if (bundle != null) {
                    int i2 = bundle.getInt("k_server_scene", 2);
                    FaceDetectReporter.bsJ().appId = bundle.getString("k_app_id", "");
                    if (C11810f.m19662ha(bundle.getBoolean("is_check_dyncfg", false))) {
                        Intent intent;
                        if (i2 == 2 || i2 == 5) {
                            C4990ab.m7420w("MicroMsg.FaceDetectManager", "carson: serverScene == FACE_DETECT_SERVER_SCENE_MP | FACE_DETECT_SERVER_SCENE_SUBAPP");
                            intent = new Intent(context, FaceDetectConfirmUI.class);
                        } else {
                            intent = new Intent(context, FaceDetectPrepareUI.class);
                        }
                        intent.putExtras(bundle);
                        ((Activity) context).startActivityForResult(intent, i);
                        z = true;
                    } else {
                        C4990ab.m7420w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                        FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
                        bsJ.mo54646R(FaceDetectReporter.m55883vl(i2), false);
                        bsJ.mo54651c(FaceDetectReporter.m55883vl(i2), false, 3, 4, 90001);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
                }
            }
        } else {
            z = C11810f.m19660a(context, bundle, i);
        }
        c9437b.cKV = z;
        if (!c37778or.cLe.cKV) {
            c37778or.cLe.extras = new Bundle();
            c37778or.cLe.extras.putInt("err_code", 90001);
            c37778or.cLe.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.m2505o(244);
        return true;
    }
}
