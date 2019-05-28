package com.tencent.p177mm.plugin.facedetect.p400c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p403ui.C3048c;
import com.tencent.p177mm.plugin.facedetect.p403ui.C34109a;
import com.tencent.p177mm.plugin.facedetect.p966b.C20627n;
import com.tencent.p177mm.plugin.facedetect.p966b.C20628o;
import com.tencent.p177mm.plugin.facedetect.p966b.C27916e;
import com.tencent.p177mm.plugin.facedetect.p966b.C39009t;
import com.tencent.p177mm.plugin.facedetect.p966b.C45917s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.c.c */
public final class C3015c extends C39010a {
    boolean isRetry;
    private String lTl;
    private String lTm;
    private int lTn;

    C3015c(Context context, C11795f c11795f, int i, int i2) {
        super(context, c11795f, i, i2);
        this.isRetry = false;
        this.lTh = true;
        this.lTn = i;
    }

    private String getResultKey() {
        switch (this.lTn) {
            case 0:
            case 3:
                return "faceregister_ticket";
            case 1:
            case 4:
            case 6:
                return "faceverify_ticket";
            default:
                return "verify_result";
        }
    }

    public final C1207m bsn() {
        AppMethodBeat.m2504i(124);
        long bsl = bsl();
        String str = this.lTl;
        String str2 = this.lTm;
        C1207m c20627n;
        switch (this.lTn) {
            case 0:
                c20627n = new C20627n(bsl, str, str2);
                AppMethodBeat.m2505o(124);
                return c20627n;
            case 1:
                c20627n = new C45917s(bsl, str, str2);
                AppMethodBeat.m2505o(124);
                return c20627n;
            case 3:
                c20627n = new C20628o(bsl, str, str2);
                AppMethodBeat.m2505o(124);
                return c20627n;
            case 4:
                c20627n = new C39009t(bsl, str, str2);
                AppMethodBeat.m2505o(124);
                return c20627n;
            default:
                AppMethodBeat.m2505o(124);
                return null;
        }
    }

    public final void onStart() {
        AppMethodBeat.m2504i(125);
        C4990ab.m7416i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().mo54646R(FaceDetectReporter.m55883vl(this.lTn), this.isRetry);
        AppMethodBeat.m2505o(125);
    }

    public final void onRelease() {
        AppMethodBeat.m2504i(126);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.m2505o(126);
    }

    /* renamed from: n */
    public final void mo7232n(int i, int i2, String str) {
        AppMethodBeat.m2504i(C31128d.MIC_SketchMark);
        C4990ab.m7419v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.m2505o(C31128d.MIC_SketchMark);
    }

    /* renamed from: c */
    public final boolean mo7230c(int i, String str, Bundle bundle) {
        AppMethodBeat.m2504i(128);
        C4990ab.m7417i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 1, 2, 90012);
            m5299a(i, 0, str, false, null);
            AppMethodBeat.m2505o(128);
            return true;
        } else if (bundle == null || C5046bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            C4990ab.m7412e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            m5299a(4, 6, "not return cdn id", false, null);
            AppMethodBeat.m2505o(128);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            C4990ab.m7419v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            AppMethodBeat.m2505o(128);
            return false;
        }
    }

    /* renamed from: g */
    public final void mo7231g(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        C4990ab.m7417i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C27916e) {
            C27916e c27916e = (C27916e) c1207m;
            Bundle bundle = new Bundle();
            bundle.putString(getResultKey(), c27916e.bsh());
            FaceDetectReporter bsJ;
            int i3;
            boolean bsg;
            int i4;
            if (i == 0 && i2 == 0) {
                bsJ = FaceDetectReporter.bsJ();
                i3 = this.lTe;
                bsg = c27916e.bsg();
                if (this.lTg != null) {
                    i4 = this.lTg.lSp;
                } else {
                    i4 = 0;
                }
                bsJ.mo54647a(i3, bsg, 0, i, i2, i4);
                C3048c bti = C34109a.bti();
                bti.lYx = true;
                bti.lYF = C4996ah.getResources().getString(C25738R.string.ckn);
                bti.status = 2;
                mo61910a(false, true, bti);
                final int i5 = i;
                final int i6 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(121);
                        C3015c.this.mo61907a(i5, i6, str2, bundle2);
                        AppMethodBeat.m2505o(121);
                    }
                }, 1500);
                AppMethodBeat.m2505o(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
                return;
            }
            bsJ = FaceDetectReporter.bsJ();
            i3 = this.lTe;
            bsg = c27916e.bsg();
            if (this.lTg != null) {
                i4 = this.lTg.lSp;
            } else {
                i4 = 0;
            }
            bsJ.mo54647a(i3, bsg, 1, i, i2, i4);
            m5299a(i, i2, str, c27916e.bsg(), bundle);
        }
        AppMethodBeat.m2505o(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
    }

    /* renamed from: c */
    public final void mo7229c(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(130);
        C4990ab.m7417i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(getResultKey(), bundle.getString(getResultKey()));
            mo61907a(i, i2, str, bundle2);
            AppMethodBeat.m2505o(130);
            return;
        }
        mo61907a(i, i2, str, null);
        AppMethodBeat.m2505o(130);
    }

    /* renamed from: ax */
    public final void mo7226ax(int i, String str) {
        AppMethodBeat.m2504i(131);
        C4990ab.m7417i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(FaceDetectReporter.m55883vl(this.lTn), this.isRetry, 2, 1, i);
        }
        mo61907a(1, i, str, null);
        AppMethodBeat.m2505o(131);
    }

    public final Bundle bso() {
        AppMethodBeat.m2504i(132);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        AppMethodBeat.m2505o(132);
        return bundle;
    }

    /* renamed from: a */
    private void m5299a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        AppMethodBeat.m2504i(C19394e.CTRL_INDEX);
        mo61911b(i, i2, str, bundle);
        Context context = C4996ah.getContext();
        if (str == null) {
            string = context.getString(C25738R.string.bjk);
        } else {
            string = str;
        }
        String string2 = z ? context.getString(C25738R.string.blm) : context.getString(C25738R.string.blk);
        String string3 = z ? context.getString(C25738R.string.f9076or) : null;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C30172 c30172 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(122);
                if (z2) {
                    C3015c c3015c = C3015c.this;
                    c3015c.bsk();
                    c3015c.isRetry = true;
                    AppMethodBeat.m2505o(122);
                    return;
                }
                C3015c.this.mo61907a(i3, i4, str2, bundle2);
                AppMethodBeat.m2505o(122);
            }
        };
        i3 = i;
        i4 = i2;
        str2 = str;
        bundle2 = bundle;
        C3048c b = C34109a.m55909b(C25738R.drawable.b33, string, string2, string3, c30172, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(123);
                C3015c.this.mo61907a(i3, i4, str2, bundle2);
                AppMethodBeat.m2505o(123);
            }
        });
        b.status = 3;
        mo61910a(true, false, b);
        AppMethodBeat.m2505o(C19394e.CTRL_INDEX);
    }
}
