package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.ByteArrayOutputStream;

public final class a implements f {
    public int lSf = -1;
    public d lSg = null;
    public c lSh = null;
    public boolean lSi = false;
    public boolean lSj = false;
    public long lSk = 0;
    public int lSl = 0;
    public m lSm = null;
    public m lSn = null;
    public long lSo = -1;
    public int lSp = -1;
    public int lSq;
    public com.tencent.mm.i.g.a lSr = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(57);
            if (i == -21005) {
                ab.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                AppMethodBeat.o(57);
                return 0;
            } else if (dVar != null && dVar.field_retCode == 0) {
                ab.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                String str2 = dVar.field_fileId;
                Bundle bundle = new Bundle();
                bundle.putString("key_pic_cdn_id", str2);
                bundle.putString("key_cdn_aes_key", dVar.field_aesKey);
                a aVar = a.this;
                String str3 = "ok";
                if (aVar.lSg != null) {
                    aVar.lSg.n(str3, bundle);
                }
                h.pYm.a(917, 13, 1, false);
                AppMethodBeat.o(57);
                return 0;
            } else if (dVar != null) {
                ab.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                h.pYm.a(917, 14, 1, false);
                a.this.m(3, 90020, "cdn ret error");
                AppMethodBeat.o(57);
                return 0;
            } else if (i != 0) {
                ab.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                h.pYm.a(917, 14, 1, false);
                a.this.m(3, 90021, "cdn start error");
                AppMethodBeat.o(57);
                return 0;
            } else {
                ab.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                if (cVar != null) {
                    ab.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", Double.valueOf(((double) cVar.field_finishedLength) / ((double) cVar.field_toltalLength)));
                    a aVar2 = a.this;
                    if (aVar2.lSg != null) {
                        aVar2.lSg.w(r0);
                    }
                }
                AppMethodBeat.o(57);
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };

    public a(int i, int i2) {
        AppMethodBeat.i(59);
        this.lSf = i;
        this.lSq = i2;
        AppMethodBeat.o(59);
    }

    public final void bsd() {
        AppMethodBeat.i(60);
        if (this.lSn != null) {
            g.Rg().b(this.lSn.getType(), (f) this);
        }
        AppMethodBeat.o(60);
    }

    public final void m(final int i, final int i2, final String str) {
        AppMethodBeat.i(61);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58);
                if (a.this.lSg != null) {
                    a.this.lSg.a(a.this.lSl, i, i2, str);
                }
                AppMethodBeat.o(58);
            }
        });
        AppMethodBeat.o(61);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(62);
        ab.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", mVar.toString(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if ((mVar instanceof u) || (mVar instanceof v)) {
            if (i == 0 && i2 == 0) {
                b bVar = (b) mVar;
                this.lSk = bVar.bse();
                e.il(this.lSk);
                if (bVar.bsf() == null) {
                    ab.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    m(2, 90015, "face motion config from server is null");
                    AppMethodBeat.o(62);
                    return;
                }
                byte[] bsf = bVar.bsf();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bsf.length);
                if (this.lSg == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                ab.i(str2, str3, objArr);
                if (this.lSh != null) {
                    this.lSh.e(this.lSk, bsf);
                }
                AppMethodBeat.o(62);
                return;
            } else if (this.lSh != null) {
                this.lSh.aw(i, "get face bio config failed");
                AppMethodBeat.o(62);
                return;
            }
        } else if (this.lSn != null && mVar.getType() == this.lSn.getType()) {
            this.lSp = (int) (System.currentTimeMillis() - this.lSo);
            if (this.lSg != null) {
                this.lSg.g(i, i2, str, mVar);
            }
        }
        AppMethodBeat.o(62);
    }
}
