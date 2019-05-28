package com.tencent.p177mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C38361e;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p966b.C43031r;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.MMService;
import com.tencent.p177mm.vfs.C5728b;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService */
public class FaceUploadVideoService extends MMService implements C1202f {

    /* renamed from: com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService$a */
    class C20642a implements C1628a {
        private long lTH;
        private String mAppId;
        private String mFileName;

        /* synthetic */ C20642a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2, byte b) {
            this(j, str, str2);
        }

        private C20642a(long j, String str, String str2) {
            this.lTH = -1;
            this.mAppId = null;
            this.mFileName = null;
            this.lTH = j;
            this.mAppId = str;
            this.mFileName = str2;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(C38361e.CTRL_INDEX);
            C4990ab.m7417i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
            if (c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7416i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
                C7060h.pYm.mo8378a(917, 23, 1, false);
                FaceDetectReporter.m55882i(this.lTH, 0, 0);
                C1720g.m3540Rg().mo14539a(1197, FaceUploadVideoService.this);
                C1720g.m3540Rg().mo14541a(new C43031r(this.mFileName, this.lTH, this.mAppId, c9545d.field_fileId, c9545d.field_aesKey), 0);
            } else if (c9545d != null) {
                C4990ab.m7421w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                C1173e.deleteFile(this.mFileName);
                C7060h.pYm.mo8378a(917, 24, 1, false);
                FaceDetectReporter.m55882i(this.lTH, 1, c9545d.field_retCode);
                AppMethodBeat.m2505o(C38361e.CTRL_INDEX);
                return 0;
            } else if (i != 0) {
                C4990ab.m7421w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                C1173e.deleteFile(this.mFileName);
                C7060h.pYm.mo8378a(917, 24, 1, false);
                FaceDetectReporter.m55882i(this.lTH, 1, i);
                AppMethodBeat.m2505o(C38361e.CTRL_INDEX);
                return 0;
            }
            AppMethodBeat.m2505o(C38361e.CTRL_INDEX);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(C33379c.CTRL_INDEX);
        int onStartCommand;
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
            onStartCommand = super.onStartCommand(null, i, i2);
            AppMethodBeat.m2505o(C33379c.CTRL_INDEX);
            return onStartCommand;
        }
        String stringExtra = intent.getStringExtra("key_video_file_name");
        long longExtra = intent.getLongExtra("k_bio_id", -1);
        String stringExtra2 = intent.getStringExtra("key_app_id");
        C4990ab.m7417i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", stringExtra);
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7420w("MicroMsg.FaceUploadVideoService", "hy: null file name");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C33379c.CTRL_INDEX);
            return onStartCommand;
        } else if (!new C5728b(stringExtra).exists()) {
            C4990ab.m7420w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C33379c.CTRL_INDEX);
            return onStartCommand;
        } else if (longExtra == -1 && C5046bo.isNullOrNil(stringExtra2)) {
            C4990ab.m7420w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
            C1173e.deleteFile(stringExtra);
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C33379c.CTRL_INDEX);
            return onStartCommand;
        } else {
            C42130g c42130g = new C42130g();
            c42130g.egl = new C20642a(this, longExtra, stringExtra2, stringExtra, (byte) 0);
            c42130g.field_mediaId = C43036p.m76427Lt(stringExtra);
            c42130g.field_fullpath = stringExtra;
            c42130g.field_thumbpath = "";
            c42130g.field_fileType = C42129a.MediaType_FILE;
            c42130g.field_talker = "";
            c42130g.field_priority = C42129a.efC;
            c42130g.field_needStorage = false;
            c42130g.field_isStreamMedia = false;
            c42130g.field_appType = 0;
            c42130g.field_bzScene = 0;
            c42130g.field_largesvideo = 0;
            if (!C37461f.afx().mo51225e(c42130g)) {
                C4990ab.m7413e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", c42130g.field_mediaId);
                C1173e.deleteFile(stringExtra);
                FaceDetectReporter.m55882i(longExtra, 1, 10086);
            }
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(C33379c.CTRL_INDEX);
            return onStartCommand;
        }
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        return null;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(355);
        if (c1207m instanceof C43031r) {
            C43031r c43031r = (C43031r) c1207m;
            C4990ab.m7417i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            C7060h.pYm.mo8378a(917, i2 == 0 ? 25 : 26, 1, false);
            C1720g.m3540Rg().mo14546b(1197, (C1202f) this);
            C1173e.deleteFile(c43031r.mFileName);
            stopSelf();
        }
        AppMethodBeat.m2505o(355);
    }

    public final String getTag() {
        return "MicroMsg.FaceUploadVideoService";
    }
}
