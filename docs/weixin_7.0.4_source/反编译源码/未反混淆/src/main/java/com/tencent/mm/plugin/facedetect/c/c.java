package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;

public final class c extends a {
    boolean isRetry;
    private String lTl;
    private String lTm;
    private int lTn;

    c(Context context, f fVar, int i, int i2) {
        super(context, fVar, i, i2);
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

    public final m bsn() {
        AppMethodBeat.i(124);
        long bsl = bsl();
        String str = this.lTl;
        String str2 = this.lTm;
        m nVar;
        switch (this.lTn) {
            case 0:
                nVar = new n(bsl, str, str2);
                AppMethodBeat.o(124);
                return nVar;
            case 1:
                nVar = new s(bsl, str, str2);
                AppMethodBeat.o(124);
                return nVar;
            case 3:
                nVar = new o(bsl, str, str2);
                AppMethodBeat.o(124);
                return nVar;
            case 4:
                nVar = new t(bsl, str, str2);
                AppMethodBeat.o(124);
                return nVar;
            default:
                AppMethodBeat.o(124);
                return null;
        }
    }

    public final void onStart() {
        AppMethodBeat.i(125);
        ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().R(FaceDetectReporter.vl(this.lTn), this.isRetry);
        AppMethodBeat.o(125);
    }

    public final void onRelease() {
        AppMethodBeat.i(126);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 2, 1, 90006);
        }
        AppMethodBeat.o(126);
    }

    public final void n(int i, int i2, String str) {
        AppMethodBeat.i(d.MIC_SketchMark);
        ab.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(d.MIC_SketchMark);
    }

    public final boolean c(int i, String str, Bundle bundle) {
        AppMethodBeat.i(128);
        ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(0), str);
        if (i != 0) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 1, 2, 90012);
            a(i, 0, str, false, null);
            AppMethodBeat.o(128);
            return true;
        } else if (bundle == null || bo.isNullOrNil(bundle.getString("key_pic_cdn_id"))) {
            ab.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            AppMethodBeat.o(128);
            return true;
        } else {
            this.lTl = bundle.getString("key_pic_cdn_id");
            this.lTm = bundle.getString("key_cdn_aes_key");
            ab.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", this.lTl, this.lTm);
            AppMethodBeat.o(128);
            return false;
        }
    }

    public final void g(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof e) {
            e eVar = (e) mVar;
            Bundle bundle = new Bundle();
            bundle.putString(getResultKey(), eVar.bsh());
            FaceDetectReporter bsJ;
            int i3;
            boolean bsg;
            int i4;
            if (i == 0 && i2 == 0) {
                bsJ = FaceDetectReporter.bsJ();
                i3 = this.lTe;
                bsg = eVar.bsg();
                if (this.lTg != null) {
                    i4 = this.lTg.lSp;
                } else {
                    i4 = 0;
                }
                bsJ.a(i3, bsg, 0, i, i2, i4);
                com.tencent.mm.plugin.facedetect.ui.c bti = a.bti();
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
                        AppMethodBeat.i(121);
                        c.this.a(i5, i6, str2, bundle2);
                        AppMethodBeat.o(121);
                    }
                }, 1500);
                AppMethodBeat.o(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
                return;
            }
            bsJ = FaceDetectReporter.bsJ();
            i3 = this.lTe;
            bsg = eVar.bsg();
            if (this.lTg != null) {
                i4 = this.lTg.lSp;
            } else {
                i4 = 0;
            }
            bsJ.a(i3, bsg, 1, i, i2, i4);
            a(i, i2, str, eVar.bsg(), bundle);
        }
        AppMethodBeat.o(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.i(130);
        ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(getResultKey(), bundle.getString(getResultKey()));
            a(i, i2, str, bundle2);
            AppMethodBeat.o(130);
            return;
        }
        a(i, i2, str, null);
        AppMethodBeat.o(130);
    }

    public final void ax(int i, String str) {
        AppMethodBeat.i(131);
        ab.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.bsJ().lUt) {
            FaceDetectReporter.bsJ().c(FaceDetectReporter.vl(this.lTn), this.isRetry, 2, 1, i);
        }
        a(1, i, str, null);
        AppMethodBeat.o(131);
    }

    public final Bundle bso() {
        AppMethodBeat.i(132);
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", bsl());
        AppMethodBeat.o(132);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX);
        b(i, i2, str, bundle);
        Context context = ah.getContext();
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
                AppMethodBeat.i(122);
                if (z2) {
                    c cVar = c.this;
                    cVar.bsk();
                    cVar.isRetry = true;
                    AppMethodBeat.o(122);
                    return;
                }
                c.this.a(i3, i4, str2, bundle2);
                AppMethodBeat.o(122);
            }
        };
        i3 = i;
        i4 = i2;
        str2 = str;
        bundle2 = bundle;
        com.tencent.mm.plugin.facedetect.ui.c b = a.b(R.drawable.b33, string, string2, string3, anonymousClass2, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123);
                c.this.a(i3, i4, str2, bundle2);
                AppMethodBeat.o(123);
            }
        });
        b.status = 3;
        a(true, false, b);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX);
    }
}
