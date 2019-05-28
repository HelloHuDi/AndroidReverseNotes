package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class d extends a {
    String appId;
    boolean isRetry;
    private String jsonString;
    private String lTl;
    private String lTm;
    String lTr;
    private float lTs;
    private boolean lTt;

    d(Context context, f fVar, int i, int i2, Bundle bundle) {
        super(context, fVar, i, i2);
        AppMethodBeat.i(138);
        this.isRetry = false;
        this.lTh = true;
        this.appId = bundle.getString("k_app_id", null);
        this.jsonString = bundle.getString("request_verify_pre_info", null);
        this.lTr = bundle.getString("key_feedback_url", null);
        this.lTs = bundle.getFloat("key_current_light", 0.0f);
        this.lTt = bundle.getBoolean("key_upload_video", false);
        AppMethodBeat.o(138);
    }

    public final m bsn() {
        AppMethodBeat.i(a.CTRL_INDEX);
        com.tencent.mm.plugin.facedetect.b.m mVar = new com.tencent.mm.plugin.facedetect.b.m(bsl(), this.appId, this.jsonString, this.lTl, this.lTm, this.lTi, this.lTs, this.lTt ? 1 : 0);
        AppMethodBeat.o(a.CTRL_INDEX);
        return mVar;
    }

    public final void onStart() {
        AppMethodBeat.i(140);
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().R(this.lTe, this.isRetry);
        FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
        bsJ.lUC++;
        ab.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", Integer.valueOf(bsJ.lUC));
        AppMethodBeat.o(140);
    }

    public final void onRelease() {
        AppMethodBeat.i(141);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(this.lTe, this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.o(141);
    }

    public final void n(int i, int i2, String str) {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_3);
        ab.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_3);
    }

    public final boolean c(int i, String str, Bundle bundle) {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_4);
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().c(this.lTe, this.isRetry, 1, 2, 90012);
            a(i, 0, str, false, null);
            AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_4);
            return true;
        } else if (bundle == null || bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            ab.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_4);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            ab.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_4);
            return false;
        }
    }

    public final void g(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(144);
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof com.tencent.mm.plugin.facedetect.b.m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((com.tencent.mm.plugin.facedetect.b.m) mVar).lSQ);
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
                bsJ.a(i3, z, 0, i, i2, i4);
                h.pYm.a(917, 15, 1, false);
                FaceDetectReporter.bsJ().lUD = true;
                c bti = com.tencent.mm.plugin.facedetect.ui.a.bti();
                bti.lYx = true;
                bti.lYF = ah.getResources().getString(R.string.ckn);
                bti.status = 2;
                a(false, true, bti);
                final int i5 = i;
                final int i6 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX);
                        d.this.a(i5, i6, str2, bundle2);
                        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX);
                    }
                }, 1500);
                AppMethodBeat.o(144);
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
            bsJ.a(i3, z, 1, i, i2, i4);
            h.pYm.a(917, 16, 1, false);
            a(i, i2, str, ((com.tencent.mm.plugin.facedetect.b.m) mVar).lSR, bundle);
        }
        AppMethodBeat.o(144);
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(145);
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(this.lTe, this.isRetry, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("verify_result", bundle.getString("verify_result"));
            a(i, i2, str, bundle2);
            AppMethodBeat.o(145);
            return;
        }
        a(i, i2, str, null);
        AppMethodBeat.o(145);
    }

    public final void ax(int i, String str) {
        AppMethodBeat.i(146);
        ab.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(this.lTe, this.isRetry, 2, 1, i);
        }
        a(1, i, str, null);
        AppMethodBeat.o(146);
    }

    public final Bundle bso() {
        AppMethodBeat.i(ErrorCode.NEEDDOWNLOAD_8);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        bundle.putString("key_app_id", this.appId);
        AppMethodBeat.o(ErrorCode.NEEDDOWNLOAD_8);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        AppMethodBeat.i(148);
        ab.e("MicroMsg.FaceDetectMpController", "carson onVerifyFailed（）");
        b(i, i2, str, bundle);
        final Context context = ah.getContext();
        if (str == null) {
            string = context.getString(R.string.bjk);
        } else {
            string = str;
        }
        String string2 = z ? context.getString(R.string.blm) : context.getString(R.string.blk);
        String string3 = z ? context.getString(R.string.or) : null;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(b.CTRL_INDEX);
                if (z2) {
                    d dVar = d.this;
                    dVar.bsk();
                    dVar.isRetry = true;
                    AppMethodBeat.o(b.CTRL_INDEX);
                    return;
                }
                d.this.a(i3, i4, str2, bundle2);
                AppMethodBeat.o(b.CTRL_INDEX);
            }
        };
        i3 = i;
        i4 = i2;
        str2 = str;
        bundle2 = bundle;
        c b = com.tencent.mm.plugin.facedetect.ui.a.b(R.drawable.b33, string, string2, string3, anonymousClass2, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(n.CTRL_INDEX);
                d.this.a(i3, i4, str2, bundle2);
                AppMethodBeat.o(n.CTRL_INDEX);
            }
        });
        b.status = 3;
        final Bundle bundle3 = bundle;
        final int i5 = i2;
        com.tencent.mm.plugin.facedetect.ui.a.a(b, context.getString(R.string.bke), new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(137);
                if (bo.isNullOrNil(d.this.lTr)) {
                    ab.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
                    AppMethodBeat.o(137);
                    return;
                }
                if (!(d.this.lTc == null || d.this.lTc.get() == null)) {
                    ((f) d.this.lTc.get()).bsp();
                }
                String str = null;
                if (bundle3 != null) {
                    str = bundle3.getString("verify_result");
                }
                try {
                    String str2;
                    String str3 = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    if (d.this.appId != null) {
                        str2 = d.this.appId;
                    } else {
                        str2 = "";
                    }
                    objArr[0] = str2;
                    objArr[1] = Integer.valueOf(i5);
                    if (str == null) {
                        str = "";
                    }
                    objArr[2] = str;
                    ab.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", d.this.lTr + "?customInfo=" + q.encode(String.format(str3, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(137);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FaceDetectMpController", e, "alvinluo start feedback webview exception", new Object[0]);
                    AppMethodBeat.o(137);
                }
            }
        });
        a(true, false, b);
        AppMethodBeat.o(148);
    }
}
