package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.e;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;
import com.tencent.mm.vfs.b;
import java.io.ByteArrayOutputStream;

public class FaceUploadVideoService extends MMService implements f {

    class a implements com.tencent.mm.i.g.a {
        private long lTH;
        private String mAppId;
        private String mFileName;

        /* synthetic */ a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2, byte b) {
            this(j, str, str2);
        }

        private a(long j, String str, String str2) {
            this.lTH = -1;
            this.mAppId = null;
            this.mFileName = null;
            this.lTH = j;
            this.mAppId = str;
            this.mFileName = str2;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(e.CTRL_INDEX);
            ab.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
            if (dVar != null && dVar.field_retCode == 0) {
                ab.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
                h.pYm.a(917, 23, 1, false);
                FaceDetectReporter.i(this.lTH, 0, 0);
                g.Rg().a(1197, FaceUploadVideoService.this);
                g.Rg().a(new r(this.mFileName, this.lTH, this.mAppId, dVar.field_fileId, dVar.field_aesKey), 0);
            } else if (dVar != null) {
                ab.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                com.tencent.mm.a.e.deleteFile(this.mFileName);
                h.pYm.a(917, 24, 1, false);
                FaceDetectReporter.i(this.lTH, 1, dVar.field_retCode);
                AppMethodBeat.o(e.CTRL_INDEX);
                return 0;
            } else if (i != 0) {
                ab.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                com.tencent.mm.a.e.deleteFile(this.mFileName);
                h.pYm.a(917, 24, 1, false);
                FaceDetectReporter.i(this.lTH, 1, i);
                AppMethodBeat.o(e.CTRL_INDEX);
                return 0;
            }
            AppMethodBeat.o(e.CTRL_INDEX);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
        int onStartCommand;
        if (intent == null) {
            ab.e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
            onStartCommand = super.onStartCommand(null, i, i2);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
            return onStartCommand;
        }
        String stringExtra = intent.getStringExtra("key_video_file_name");
        long longExtra = intent.getLongExtra("k_bio_id", -1);
        String stringExtra2 = intent.getStringExtra("key_app_id");
        ab.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", stringExtra);
        if (bo.isNullOrNil(stringExtra)) {
            ab.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
            return onStartCommand;
        } else if (!new b(stringExtra).exists()) {
            ab.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
            return onStartCommand;
        } else if (longExtra == -1 && bo.isNullOrNil(stringExtra2)) {
            ab.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
            com.tencent.mm.a.e.deleteFile(stringExtra);
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
            return onStartCommand;
        } else {
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.egl = new a(this, longExtra, stringExtra2, stringExtra, (byte) 0);
            gVar.field_mediaId = p.Lt(stringExtra);
            gVar.field_fullpath = stringExtra;
            gVar.field_thumbpath = "";
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
            gVar.field_talker = "";
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_needStorage = false;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 0;
            gVar.field_bzScene = 0;
            gVar.field_largesvideo = 0;
            if (!com.tencent.mm.al.f.afx().e(gVar)) {
                ab.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", gVar.field_mediaId);
                com.tencent.mm.a.e.deleteFile(stringExtra);
                FaceDetectReporter.i(longExtra, 1, 10086);
            }
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
            return onStartCommand;
        }
    }

    public final IBinder Iu() {
        return null;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(355);
        if (mVar instanceof r) {
            r rVar = (r) mVar;
            ab.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            h.pYm.a(917, i2 == 0 ? 25 : 26, 1, false);
            g.Rg().b(1197, (f) this);
            com.tencent.mm.a.e.deleteFile(rVar.mFileName);
            stopSelf();
        }
        AppMethodBeat.o(355);
    }

    public final String getTag() {
        return "MicroMsg.FaceUploadVideoService";
    }
}
