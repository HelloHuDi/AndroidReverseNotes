package com.tencent.p177mm.plugin.facedetect.p966b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.facedetect.model.C27932e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.facedetect.b.a */
public final class C34093a implements C1202f {
    public int lSf = -1;
    public C39007d lSg = null;
    public C45915c lSh = null;
    public boolean lSi = false;
    public boolean lSj = false;
    public long lSk = 0;
    public int lSl = 0;
    public C1207m lSm = null;
    public C1207m lSn = null;
    public long lSo = -1;
    public int lSp = -1;
    public int lSq;
    public C1628a lSr = new C206221();

    /* renamed from: com.tencent.mm.plugin.facedetect.b.a$1 */
    class C206221 implements C1628a {
        C206221() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(57);
            if (i == -21005) {
                C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                AppMethodBeat.m2505o(57);
                return 0;
            } else if (c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                String str2 = c9545d.field_fileId;
                Bundle bundle = new Bundle();
                bundle.putString("key_pic_cdn_id", str2);
                bundle.putString("key_cdn_aes_key", c9545d.field_aesKey);
                C34093a c34093a = C34093a.this;
                String str3 = "ok";
                if (c34093a.lSg != null) {
                    c34093a.lSg.mo61904n(str3, bundle);
                }
                C7060h.pYm.mo8378a(917, 13, 1, false);
                AppMethodBeat.m2505o(57);
                return 0;
            } else if (c9545d != null) {
                C4990ab.m7421w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                C7060h.pYm.mo8378a(917, 14, 1, false);
                C34093a.this.mo54640m(3, 90020, "cdn ret error");
                AppMethodBeat.m2505o(57);
                return 0;
            } else if (i != 0) {
                C4990ab.m7421w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                C7060h.pYm.mo8378a(917, 14, 1, false);
                C34093a.this.mo54640m(3, 90021, "cdn start error");
                AppMethodBeat.m2505o(57);
                return 0;
            } else {
                C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                if (c18496c != null) {
                    C4990ab.m7411d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", Double.valueOf(((double) c18496c.field_finishedLength) / ((double) c18496c.field_toltalLength)));
                    C34093a c34093a2 = C34093a.this;
                    if (c34093a2.lSg != null) {
                        c34093a2.lSg.mo61905w(r0);
                    }
                }
                AppMethodBeat.m2505o(57);
                return 0;
            }
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    public C34093a(int i, int i2) {
        AppMethodBeat.m2504i(59);
        this.lSf = i;
        this.lSq = i2;
        AppMethodBeat.m2505o(59);
    }

    public final void bsd() {
        AppMethodBeat.m2504i(60);
        if (this.lSn != null) {
            C1720g.m3540Rg().mo14546b(this.lSn.getType(), (C1202f) this);
        }
        AppMethodBeat.m2505o(60);
    }

    /* renamed from: m */
    public final void mo54640m(final int i, final int i2, final String str) {
        AppMethodBeat.m2504i(61);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58);
                if (C34093a.this.lSg != null) {
                    C34093a.this.lSg.mo61902a(C34093a.this.lSl, i, i2, str);
                }
                AppMethodBeat.m2505o(58);
            }
        });
        AppMethodBeat.m2505o(61);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(62);
        C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", c1207m.toString(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if ((c1207m instanceof C45918u) || (c1207m instanceof C11793v)) {
            if (i == 0 && i2 == 0) {
                C39006b c39006b = (C39006b) c1207m;
                this.lSk = c39006b.bse();
                C27932e.m44467il(this.lSk);
                if (c39006b.bsf() == null) {
                    C4990ab.m7412e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    mo54640m(2, 90015, "face motion config from server is null");
                    AppMethodBeat.m2505o(62);
                    return;
                }
                byte[] bsf = c39006b.bsf();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bsf.length);
                if (this.lSg == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                C4990ab.m7417i(str2, str3, objArr);
                if (this.lSh != null) {
                    this.lSh.mo61925e(this.lSk, bsf);
                }
                AppMethodBeat.m2505o(62);
                return;
            } else if (this.lSh != null) {
                this.lSh.mo61924aw(i, "get face bio config failed");
                AppMethodBeat.m2505o(62);
                return;
            }
        } else if (this.lSn != null && c1207m.getType() == this.lSn.getType()) {
            this.lSp = (int) (System.currentTimeMillis() - this.lSo);
            if (this.lSg != null) {
                this.lSg.mo61903g(i, i2, str, c1207m);
            }
        }
        AppMethodBeat.m2505o(62);
    }
}
