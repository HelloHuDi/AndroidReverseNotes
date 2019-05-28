package com.tencent.p177mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33381d;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C27929b;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C27930a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.service.b */
public final class C45919b extends C39014a {
    long lTH = -1;
    String mAppId = "";

    /* renamed from: S */
    public final void mo61919S(Intent intent) {
        AppMethodBeat.m2504i(C33381d.CTRL_INDEX);
        this.lTH = intent.getLongExtra("k_bio_id", -1);
        this.mAppId = intent.getStringExtra("key_app_id");
        C4990ab.m7417i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", Long.valueOf(this.lTH), this.mAppId);
        C4990ab.m7416i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (C27922a.btw().lZc && (C27922a.btw().btz() == C27930a.STARTED || C27922a.btw().btz() == C27930a.STOPPING || C27922a.btw().btz() == C27930a.STOPPED)) {
            final long yz = C5046bo.m7588yz();
            C27922a.btw().mo45817a(new C27929b() {
                /* renamed from: Lu */
                public final void mo23665Lu(String str) {
                    AppMethodBeat.m2504i(351);
                    C4990ab.m7417i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", Long.valueOf(C5046bo.m7525az(yz)), str);
                    if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(351);
                        return;
                    }
                    Intent intent = new Intent(C4996ah.getContext(), FaceUploadVideoService.class);
                    intent.putExtra("key_video_file_name", str);
                    intent.putExtra("k_bio_id", C45919b.this.lTH);
                    intent.putExtra("key_app_id", C45919b.this.mAppId);
                    C25985d.m41463aH(intent);
                    AppMethodBeat.m2505o(351);
                }
            });
            AppMethodBeat.m2505o(C33381d.CTRL_INDEX);
            return;
        }
        C4990ab.m7416i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
        AppMethodBeat.m2505o(C33381d.CTRL_INDEX);
    }
}
