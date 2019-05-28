package com.tencent.p177mm.plugin.facedetect.p400c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p403ui.C3048c;
import com.tencent.p177mm.plugin.facedetect.p403ui.C34109a;
import com.tencent.p177mm.plugin.facedetect.p966b.C43030m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.facedetect.c.d */
public final class C20630d extends C39010a {
    String appId;
    boolean isRetry;
    private String jsonString;
    private String lTl;
    private String lTm;
    String lTr;
    private float lTs;
    private boolean lTt;

    C20630d(Context context, C11795f c11795f, int i, int i2, Bundle bundle) {
        super(context, c11795f, i, i2);
        AppMethodBeat.m2504i(138);
        this.isRetry = false;
        this.lTh = true;
        this.appId = bundle.getString("k_app_id", null);
        this.jsonString = bundle.getString("request_verify_pre_info", null);
        this.lTr = bundle.getString("key_feedback_url", null);
        this.lTs = bundle.getFloat("key_current_light", 0.0f);
        this.lTt = bundle.getBoolean("key_upload_video", false);
        AppMethodBeat.m2505o(138);
    }

    public final C1207m bsn() {
        AppMethodBeat.m2504i(C33333a.CTRL_INDEX);
        C43030m c43030m = new C43030m(bsl(), this.appId, this.jsonString, this.lTl, this.lTm, this.lTi, this.lTs, this.lTt ? 1 : 0);
        AppMethodBeat.m2505o(C33333a.CTRL_INDEX);
        return c43030m;
    }

    public final void onStart() {
        AppMethodBeat.m2504i(140);
        C4990ab.m7416i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().mo54646R(this.lTe, this.isRetry);
        FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
        bsJ.lUC++;
        C4990ab.m7419v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", Integer.valueOf(bsJ.lUC));
        AppMethodBeat.m2505o(140);
    }

    public final void onRelease() {
        AppMethodBeat.m2504i(141);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(this.lTe, this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.m2505o(141);
    }

    /* renamed from: n */
    public final void mo7232n(int i, int i2, String str) {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_3);
        C4990ab.m7419v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_3);
    }

    /* renamed from: c */
    public final boolean mo7230c(int i, String str, Bundle bundle) {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_4);
        C4990ab.m7417i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().mo54651c(this.lTe, this.isRetry, 1, 2, 90012);
            m31865a(i, 0, str, false, null);
            AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_4);
            return true;
        } else if (bundle == null || C5046bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            C4990ab.m7412e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            m31865a(4, 6, "not return cdn id", false, null);
            AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_4);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            C4990ab.m7419v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_4);
            return false;
        }
    }

    /* renamed from: g */
    public final void mo7231g(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(144);
        C4990ab.m7417i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C43030m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((C43030m) c1207m).lSQ);
            FaceDetectReporter bsJ;
            int i3;
            boolean z;
            int i4;
            if (i == 0 && i2 == 0) {
                bsJ = FaceDetectReporter.bsJ();
                i3 = this.lTe;
                z = this.isRetry;
                if (this.lTg != null) {
                    i4 = this.lTg.lSp;
                } else {
                    i4 = 0;
                }
                bsJ.mo54647a(i3, z, 0, i, i2, i4);
                C7060h.pYm.mo8378a(917, 15, 1, false);
                FaceDetectReporter.bsJ().lUD = true;
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
                        AppMethodBeat.m2504i(C19392d.CTRL_INDEX);
                        C20630d.this.mo61907a(i5, i6, str2, bundle2);
                        AppMethodBeat.m2505o(C19392d.CTRL_INDEX);
                    }
                }, 1500);
                AppMethodBeat.m2505o(144);
                return;
            }
            bsJ = FaceDetectReporter.bsJ();
            i3 = this.lTe;
            z = this.isRetry;
            if (this.lTg != null) {
                i4 = this.lTg.lSp;
            } else {
                i4 = 0;
            }
            bsJ.mo54647a(i3, z, 1, i, i2, i4);
            C7060h.pYm.mo8378a(917, 16, 1, false);
            m31865a(i, i2, str, ((C43030m) c1207m).lSR, bundle);
        }
        AppMethodBeat.m2505o(144);
    }

    /* renamed from: c */
    public final void mo7229c(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(145);
        C4990ab.m7417i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(this.lTe, this.isRetry, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("verify_result", bundle.getString("verify_result"));
            mo61907a(i, i2, str, bundle2);
            AppMethodBeat.m2505o(145);
            return;
        }
        mo61907a(i, i2, str, null);
        AppMethodBeat.m2505o(145);
    }

    /* renamed from: ax */
    public final void mo7226ax(int i, String str) {
        AppMethodBeat.m2504i(146);
        C4990ab.m7417i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().mo54651c(this.lTe, this.isRetry, 2, 1, i);
        }
        mo61907a(1, i, str, null);
        AppMethodBeat.m2505o(146);
    }

    public final Bundle bso() {
        AppMethodBeat.m2504i(ErrorCode.NEEDDOWNLOAD_8);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        bundle.putString("key_app_id", this.appId);
        AppMethodBeat.m2505o(ErrorCode.NEEDDOWNLOAD_8);
        return bundle;
    }

    /* renamed from: a */
    private void m31865a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        AppMethodBeat.m2504i(148);
        C4990ab.m7412e("MicroMsg.FaceDetectMpController", "carson onVerifyFailed（）");
        mo61911b(i, i2, str, bundle);
        final Context context = C4996ah.getContext();
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
        C206312 c206312 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(C44697b.CTRL_INDEX);
                if (z2) {
                    C20630d c20630d = C20630d.this;
                    c20630d.bsk();
                    c20630d.isRetry = true;
                    AppMethodBeat.m2505o(C44697b.CTRL_INDEX);
                    return;
                }
                C20630d.this.mo61907a(i3, i4, str2, bundle2);
                AppMethodBeat.m2505o(C44697b.CTRL_INDEX);
            }
        };
        i3 = i;
        i4 = i2;
        str2 = str;
        bundle2 = bundle;
        C3048c b = C34109a.m55909b(C25738R.drawable.b33, string, string2, string3, c206312, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(C19395n.CTRL_INDEX);
                C20630d.this.mo61907a(i3, i4, str2, bundle2);
                AppMethodBeat.m2505o(C19395n.CTRL_INDEX);
            }
        });
        b.status = 3;
        final Bundle bundle3 = bundle;
        final int i5 = i2;
        C34109a.m55907a(b, context.getString(C25738R.string.bke), new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(137);
                if (C5046bo.isNullOrNil(C20630d.this.lTr)) {
                    C4990ab.m7412e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
                    AppMethodBeat.m2505o(137);
                    return;
                }
                if (!(C20630d.this.lTc == null || C20630d.this.lTc.get() == null)) {
                    ((C11795f) C20630d.this.lTc.get()).bsp();
                }
                String str = null;
                if (bundle3 != null) {
                    str = bundle3.getString("verify_result");
                }
                try {
                    String str2;
                    String str3 = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    if (C20630d.this.appId != null) {
                        str2 = C20630d.this.appId;
                    } else {
                        str2 = "";
                    }
                    objArr[0] = str2;
                    objArr[1] = Integer.valueOf(i5);
                    if (str == null) {
                        str = "";
                    }
                    objArr[2] = str;
                    C4990ab.m7417i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", C20630d.this.lTr + "?customInfo=" + C18178q.encode(String.format(str3, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(137);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FaceDetectMpController", e, "alvinluo start feedback webview exception", new Object[0]);
                    AppMethodBeat.m2505o(137);
                }
            }
        });
        mo61910a(true, false, b);
        AppMethodBeat.m2505o(148);
    }
}
