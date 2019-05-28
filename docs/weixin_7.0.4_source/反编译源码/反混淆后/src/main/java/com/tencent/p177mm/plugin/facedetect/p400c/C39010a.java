package com.tencent.p177mm.plugin.facedetect.p400c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.plugin.facedetect.model.C27932e;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p403ui.C3048c;
import com.tencent.p177mm.plugin.facedetect.p966b.C11793v;
import com.tencent.p177mm.plugin.facedetect.p966b.C34093a;
import com.tencent.p177mm.plugin.facedetect.p966b.C39007d;
import com.tencent.p177mm.plugin.facedetect.p966b.C45915c;
import com.tencent.p177mm.plugin.facedetect.p966b.C45918u;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.facedetect.c.a */
public abstract class C39010a {
    private C46607d ext = null;
    private int lSf;
    protected C39007d lSg = null;
    protected C45915c lSh = null;
    protected WeakReference<C11795f> lTc;
    protected boolean lTd = false;
    int lTe = -1;
    public int lTf;
    protected C34093a lTg = null;
    protected boolean lTh = false;
    protected int lTi;
    private Context mContext;

    /* renamed from: ax */
    public abstract void mo7226ax(int i, String str);

    public abstract C1207m bsn();

    public abstract Bundle bso();

    /* renamed from: c */
    public abstract void mo7229c(int i, int i2, String str, Bundle bundle);

    /* renamed from: c */
    public abstract boolean mo7230c(int i, String str, Bundle bundle);

    /* renamed from: g */
    public abstract void mo7231g(int i, int i2, String str, C1207m c1207m);

    /* renamed from: n */
    public abstract void mo7232n(int i, int i2, String str);

    public abstract void onRelease();

    public abstract void onStart();

    C39010a(Context context, C11795f c11795f, int i, int i2) {
        this.mContext = context;
        this.lSf = i;
        this.lTc = new WeakReference(c11795f);
        this.lTf = i2;
        this.lTg = new C34093a(i, i2);
        this.lTe = FaceDetectReporter.m55883vl(i);
    }

    /* renamed from: vg */
    public final void mo61917vg(int i) {
        this.lTi = i;
    }

    /* renamed from: a */
    public final void mo61908a(C45915c c45915c) {
        if (this.lTg != null) {
            this.lSh = c45915c;
            this.lTg.lSh = this.lSh;
        }
    }

    /* renamed from: a */
    public final void mo61909a(C39007d c39007d) {
        if (this.lTg != null) {
            this.lSg = c39007d;
            this.lTg.lSg = c39007d;
        }
    }

    public final void bsj() {
        if (this.lTg != null) {
            this.lTg.lSq = this.lTf;
            C1202f c1202f = this.lTg;
            C1720g.m3534RN();
            c1202f.lSi = C1668a.m3395QX();
            C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", Boolean.valueOf(c1202f.lSi));
            if (c1202f.lSi) {
                C1720g.m3540Rg().mo14539a((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, c1202f);
            } else {
                C1720g.m3540Rg().mo14539a(733, c1202f);
            }
            C34093a c34093a = this.lTg;
            c34093a.lSk = 0;
            c34093a.lSl = 0;
            if (c34093a.lSm != null) {
                C1720g.m3540Rg().mo14547c(c34093a.lSm);
            }
            if (C27932e.bst()) {
                C27932e.m44467il(c34093a.lSk);
            }
            if (c34093a.lSi) {
                c34093a.lSm = new C45918u(c34093a.lSf, c34093a.lSq);
            } else {
                c34093a.lSm = new C11793v(c34093a.lSf, c34093a.lSq);
            }
            C1720g.m3540Rg().mo14541a(c34093a.lSm, 0);
        }
    }

    public final void bsk() {
        if (!(this.lTc == null || this.lTc.get() == null)) {
            ((C11795f) this.lTc.get()).bsk();
        }
        onStart();
    }

    /* renamed from: Lq */
    public final void mo61906Lq(String str) {
        if (this.lTg != null) {
            C34093a c34093a = this.lTg;
            if (!c34093a.lSj) {
                c34093a.lSl = 1;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    c34093a.mo54640m(4, 90011, "face file null");
                } else if (!C5730e.m8628ct(str)) {
                    C4990ab.m7412e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    c34093a.mo54640m(4, 90011, "get image failed");
                } else if (c34093a.lSk == 0) {
                    C4990ab.m7412e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    c34093a.mo54640m(4, 90014, "uploadId not init");
                } else {
                    C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", str);
                    if (!c34093a.lSj) {
                        C42130g c42130g = new C42130g();
                        c42130g.egl = c34093a.lSr;
                        c42130g.field_mediaId = C43036p.m76427Lt(str);
                        c42130g.field_fullpath = str;
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
                            C4990ab.m7413e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", c42130g.field_mediaId);
                            c34093a.mo54640m(4, 90019, "add to cdn failed");
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
        C4990ab.m7416i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.lTc == null || this.lTc.get() == null)) {
            ((C11795f) this.lTc.get()).bsm();
        }
        this.lTc = null;
        String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
        String packageName = C4996ah.getPackageName();
        C4990ab.m7417i("MicroMsg.FaceDetectBaseController", "process name: %s", aw);
        if (aw.equalsIgnoreCase(packageName)) {
            if (this.lTg != null) {
                C1202f c1202f = this.lTg;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(c1202f.lSm == null);
                C4990ab.m7419v(str, str2, objArr);
                c1202f.lSj = true;
                if (c1202f.lSm != null) {
                    C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", c1202f.lSm.getClass().getSimpleName());
                    C1720g.m3540Rg().mo14547c(c1202f.lSm);
                }
                if (c1202f.lSi) {
                    C1720g.m3540Rg().mo14546b((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, c1202f);
                } else {
                    C1720g.m3540Rg().mo14546b(733, c1202f);
                }
                c1202f.bsd();
            }
            this.lTg = null;
        }
        onRelease();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61907a(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.lTc != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        if (this.lTc != null && this.lTc.get() != null) {
            ((C11795f) this.lTc.get()).mo23589a(i, i2, str, bundle);
        }
    }

    /* renamed from: a */
    public final void mo61910a(boolean z, boolean z2, C3048c c3048c) {
        if (this.lTc != null && this.lTc.get() != null) {
            ((C11795f) this.lTc.get()).mo23590a(z, z2, c3048c);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo61911b(int i, int i2, String str, Bundle bundle) {
        if (this.lTc != null && this.lTc.get() != null) {
            ((C11795f) this.lTc.get()).mo23594d(i, i2, str, bundle);
        }
    }

    /* renamed from: b */
    public final void mo61912b(int i, String str, Bundle bundle) {
        if (i == 0 && !mo7230c(i, str, bundle)) {
            C4990ab.m7416i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.lTd = true;
            if (this.lTh) {
                C1207m bsn = bsn();
                if (bsn == null) {
                    C4990ab.m7412e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                C4990ab.m7417i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", Integer.valueOf(bsn.getType()));
                if (!this.lTd) {
                    C4990ab.m7413e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", Boolean.valueOf(this.lTd));
                } else if (this.lTg != null) {
                    C1202f c1202f = this.lTg;
                    if (bsn == null) {
                        C4990ab.m7412e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", Integer.valueOf(bsn.getType()));
                    c1202f.bsd();
                    c1202f.lSn = bsn;
                    c1202f.lSl = 2;
                    C1720g.m3540Rg().mo14539a(bsn.getType(), c1202f);
                    C1720g.m3540Rg().mo14541a(bsn, 0);
                    c1202f.lSo = System.currentTimeMillis();
                }
            }
        }
    }
}
