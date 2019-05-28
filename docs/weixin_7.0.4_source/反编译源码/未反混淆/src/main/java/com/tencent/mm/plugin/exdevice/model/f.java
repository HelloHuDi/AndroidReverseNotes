package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {

    /* renamed from: com.tencent.mm.plugin.exdevice.model.f$1 */
    public static class AnonymousClass1 implements a {
        final /* synthetic */ Runnable cfC;
        final /* synthetic */ long kEX;

        public AnonymousClass1(long j, Runnable runnable) {
            this.kEX = j;
            this.cfC = runnable;
        }

        public final void o(String str, boolean z) {
            AppMethodBeat.i(19246);
            if (z) {
                ab.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bo.anU() - this.kEX) + " ms");
                b.U(str, 3);
                if (this.cfC != null) {
                    this.cfC.run();
                    AppMethodBeat.o(19246);
                    return;
                }
            }
            ab.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
            AppMethodBeat.o(19246);
        }
    }

    public static boolean ao(Context context, String str) {
        AppMethodBeat.i(19247);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            AppMethodBeat.o(19247);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(19247);
        return true;
    }

    public static void a(com.tencent.mm.plugin.exdevice.h.b bVar, asq asq, asr asr) {
        AppMethodBeat.i(19248);
        if (asr != null) {
            bVar.field_connProto = asr.wwn;
            bVar.field_connStrategy = asr.wwo;
            bVar.field_closeStrategy = asr.wwp;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.KK(com.tencent.mm.plugin.exdevice.j.b.KL(asr.vKF));
            bVar.field_authKey = asr.vHO;
            bVar.field_brandName = asr.wwm;
            bVar.iy(asr.guS);
            bVar.eH(asr.dFq);
            bVar.jp(asr.wwv);
            bVar.jo(asr.wwu);
            bVar.jn(asr.wwt);
            bVar.hV(asr.www);
            bVar.jl(asr.IconUrl);
            bVar.hW(asr.dFp);
            bVar.jm(asr.mZj);
            bVar.jq(asr.dFr);
            bVar.jr(asr.dFs);
            bVar.js(asr.dFt);
            bVar.jt(asr.dFu);
        }
        if (asq != null) {
            bVar.field_deviceID = asq.jBE;
            bVar.field_deviceType = asq.vIk;
            bVar.field_md5Str = g.x(new String(asq.vIk + asq.jBE).getBytes());
            if (bo.isNullOrNil(bVar.field_brandName)) {
                bVar.field_brandName = asq.vIk;
            }
        }
        AppMethodBeat.o(19248);
    }

    public static boolean b(com.tencent.mm.plugin.exdevice.h.b bVar) {
        return bVar != null && (bVar.dFq & 1) == 1;
    }
}
