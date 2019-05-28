package com.tencent.p177mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.asr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.model.f */
public final class C27852f {

    /* renamed from: com.tencent.mm.plugin.exdevice.model.f$1 */
    public static class C278511 implements C9636a {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ long kEX;

        public C278511(long j, Runnable runnable) {
            this.kEX = j;
            this.cfC = runnable;
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(19246);
            if (z) {
                C4990ab.m7418v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (C5046bo.anU() - this.kEX) + " ms");
                C41730b.m73489U(str, 3);
                if (this.cfC != null) {
                    this.cfC.run();
                    AppMethodBeat.m2505o(19246);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
            AppMethodBeat.m2505o(19246);
        }
    }

    /* renamed from: ao */
    public static boolean m44278ao(Context context, String str) {
        AppMethodBeat.m2504i(19247);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            AppMethodBeat.m2505o(19247);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(19247);
        return true;
    }

    /* renamed from: a */
    public static void m44277a(C11648b c11648b, asq asq, asr asr) {
        AppMethodBeat.m2504i(19248);
        if (asr != null) {
            c11648b.field_connProto = asr.wwn;
            c11648b.field_connStrategy = asr.wwo;
            c11648b.field_closeStrategy = asr.wwp;
            c11648b.field_mac = C42992b.m76346KK(C42992b.m76347KL(asr.vKF));
            c11648b.field_authKey = asr.vHO;
            c11648b.field_brandName = asr.wwm;
            c11648b.mo60557iy(asr.guS);
            c11648b.mo60554eH(asr.dFq);
            c11648b.mo60562jp(asr.wwv);
            c11648b.mo60561jo(asr.wwu);
            c11648b.mo60560jn(asr.wwt);
            c11648b.mo60555hV(asr.www);
            c11648b.mo60558jl(asr.IconUrl);
            c11648b.mo60556hW(asr.dFp);
            c11648b.mo60559jm(asr.mZj);
            c11648b.mo60563jq(asr.dFr);
            c11648b.mo60564jr(asr.dFs);
            c11648b.mo60565js(asr.dFt);
            c11648b.mo60566jt(asr.dFu);
        }
        if (asq != null) {
            c11648b.field_deviceID = asq.jBE;
            c11648b.field_deviceType = asq.vIk;
            c11648b.field_md5Str = C1178g.m2591x(new String(asq.vIk + asq.jBE).getBytes());
            if (C5046bo.isNullOrNil(c11648b.field_brandName)) {
                c11648b.field_brandName = asq.vIk;
            }
        }
        AppMethodBeat.m2505o(19248);
    }

    /* renamed from: b */
    public static boolean m44279b(C11648b c11648b) {
        return c11648b != null && (c11648b.dFq & 1) == 1;
    }
}
