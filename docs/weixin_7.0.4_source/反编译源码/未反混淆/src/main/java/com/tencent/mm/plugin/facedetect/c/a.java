package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.lang.ref.WeakReference;

public abstract class a {
    private d ext = null;
    private int lSf;
    protected com.tencent.mm.plugin.facedetect.b.d lSg = null;
    protected c lSh = null;
    protected WeakReference<f> lTc;
    protected boolean lTd = false;
    int lTe = -1;
    public int lTf;
    protected com.tencent.mm.plugin.facedetect.b.a lTg = null;
    protected boolean lTh = false;
    protected int lTi;
    private Context mContext;

    public abstract void ax(int i, String str);

    public abstract m bsn();

    public abstract Bundle bso();

    public abstract void c(int i, int i2, String str, Bundle bundle);

    public abstract boolean c(int i, String str, Bundle bundle);

    public abstract void g(int i, int i2, String str, m mVar);

    public abstract void n(int i, int i2, String str);

    public abstract void onRelease();

    public abstract void onStart();

    a(Context context, f fVar, int i, int i2) {
        this.mContext = context;
        this.lSf = i;
        this.lTc = new WeakReference(fVar);
        this.lTf = i2;
        this.lTg = new com.tencent.mm.plugin.facedetect.b.a(i, i2);
        this.lTe = FaceDetectReporter.vl(i);
    }

    public final void vg(int i) {
        this.lTi = i;
    }

    public final void a(c cVar) {
        if (this.lTg != null) {
            this.lSh = cVar;
            this.lTg.lSh = this.lSh;
        }
    }

    public final void a(com.tencent.mm.plugin.facedetect.b.d dVar) {
        if (this.lTg != null) {
            this.lSg = dVar;
            this.lTg.lSg = dVar;
        }
    }

    public final void bsj() {
        if (this.lTg != null) {
            this.lTg.lSq = this.lTf;
            f fVar = this.lTg;
            g.RN();
            fVar.lSi = com.tencent.mm.kernel.a.QX();
            ab.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", Boolean.valueOf(fVar.lSi));
            if (fVar.lSi) {
                g.Rg().a((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, fVar);
            } else {
                g.Rg().a(733, fVar);
            }
            com.tencent.mm.plugin.facedetect.b.a aVar = this.lTg;
            aVar.lSk = 0;
            aVar.lSl = 0;
            if (aVar.lSm != null) {
                g.Rg().c(aVar.lSm);
            }
            if (e.bst()) {
                e.il(aVar.lSk);
            }
            if (aVar.lSi) {
                aVar.lSm = new u(aVar.lSf, aVar.lSq);
            } else {
                aVar.lSm = new v(aVar.lSf, aVar.lSq);
            }
            g.Rg().a(aVar.lSm, 0);
        }
    }

    public final void bsk() {
        if (!(this.lTc == null || this.lTc.get() == null)) {
            ((f) this.lTc.get()).bsk();
        }
        onStart();
    }

    public final void Lq(String str) {
        if (this.lTg != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.lTg;
            if (!aVar.lSj) {
                aVar.lSl = 1;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    aVar.m(4, 90011, "face file null");
                } else if (!com.tencent.mm.vfs.e.ct(str)) {
                    ab.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    aVar.m(4, 90011, "get image failed");
                } else if (aVar.lSk == 0) {
                    ab.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    aVar.m(4, 90014, "uploadId not init");
                } else {
                    ab.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", str);
                    if (!aVar.lSj) {
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.egl = aVar.lSr;
                        gVar.field_mediaId = p.Lt(str);
                        gVar.field_fullpath = str;
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
                            ab.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", gVar.field_mediaId);
                            aVar.m(4, 90019, "add to cdn failed");
                        }
                    }
                }
            }
        }
    }

    public final long bsl() {
        if (this.lTg != null) {
            return this.lTg.lSk;
        }
        return -1;
    }

    public final void bsm() {
        ab.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.lTc == null || this.lTc.get() == null)) {
            ((f) this.lTc.get()).bsm();
        }
        this.lTc = null;
        String aw = bo.aw(ah.getContext(), Process.myPid());
        String packageName = ah.getPackageName();
        ab.i("MicroMsg.FaceDetectBaseController", "process name: %s", aw);
        if (aw.equalsIgnoreCase(packageName)) {
            if (this.lTg != null) {
                f fVar = this.lTg;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(fVar.lSm == null);
                ab.v(str, str2, objArr);
                fVar.lSj = true;
                if (fVar.lSm != null) {
                    ab.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", fVar.lSm.getClass().getSimpleName());
                    g.Rg().c(fVar.lSm);
                }
                if (fVar.lSi) {
                    g.Rg().b((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, fVar);
                } else {
                    g.Rg().b(733, fVar);
                }
                fVar.bsd();
            }
            this.lTg = null;
        }
        onRelease();
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.lTc != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        if (this.lTc != null && this.lTc.get() != null) {
            ((f) this.lTc.get()).a(i, i2, str, bundle);
        }
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.c cVar) {
        if (this.lTc != null && this.lTc.get() != null) {
            ((f) this.lTc.get()).a(z, z2, cVar);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, int i2, String str, Bundle bundle) {
        if (this.lTc != null && this.lTc.get() != null) {
            ((f) this.lTc.get()).d(i, i2, str, bundle);
        }
    }

    public final void b(int i, String str, Bundle bundle) {
        if (i == 0 && !c(i, str, bundle)) {
            ab.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.lTd = true;
            if (this.lTh) {
                m bsn = bsn();
                if (bsn == null) {
                    ab.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                ab.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", Integer.valueOf(bsn.getType()));
                if (!this.lTd) {
                    ab.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", Boolean.valueOf(this.lTd));
                } else if (this.lTg != null) {
                    f fVar = this.lTg;
                    if (bsn == null) {
                        ab.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    ab.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", Integer.valueOf(bsn.getType()));
                    fVar.bsd();
                    fVar.lSn = bsn;
                    fVar.lSl = 2;
                    g.Rg().a(bsn.getType(), fVar);
                    g.Rg().a(bsn, 0);
                    fVar.lSo = System.currentTimeMillis();
                }
            }
        }
    }
}
