package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.d;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends a {
    long lTH = -1;
    String mAppId = "";

    public final void S(Intent intent) {
        AppMethodBeat.i(d.CTRL_INDEX);
        this.lTH = intent.getLongExtra("k_bio_id", -1);
        this.mAppId = intent.getStringExtra("key_app_id");
        ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", Long.valueOf(this.lTH), this.mAppId);
        ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (a.btw().lZc && (a.btw().btz() == a.a.STARTED || a.btw().btz() == a.a.STOPPING || a.btw().btz() == a.a.STOPPED)) {
            final long yz = bo.yz();
            a.btw().a(new com.tencent.mm.plugin.facedetect.e.a.b() {
                public final void Lu(String str) {
                    AppMethodBeat.i(351);
                    ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", Long.valueOf(bo.az(yz)), str);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(351);
                        return;
                    }
                    Intent intent = new Intent(ah.getContext(), FaceUploadVideoService.class);
                    intent.putExtra("key_video_file_name", str);
                    intent.putExtra("k_bio_id", b.this.lTH);
                    intent.putExtra("key_app_id", b.this.mAppId);
                    com.tencent.mm.bp.d.aH(intent);
                    AppMethodBeat.o(351);
                }
            });
            AppMethodBeat.o(d.CTRL_INDEX);
            return;
        }
        ab.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
        AppMethodBeat.o(d.CTRL_INDEX);
    }
}
