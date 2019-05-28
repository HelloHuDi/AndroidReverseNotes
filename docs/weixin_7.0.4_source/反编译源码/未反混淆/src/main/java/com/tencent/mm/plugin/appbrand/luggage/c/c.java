package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.l.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;

public final class c implements o {
    public final void zT(String str) {
        AppMethodBeat.i(132158);
        AppBrandStatObject wK = a.wK(str);
        if (wK != null) {
            f.zT(bo.nullAsNil(wK.cst));
        }
        AppMethodBeat.o(132158);
    }

    public final void a(String str, String str2, String str3, String str4, long j, long j2, int i, int i2, int i3) {
        AppMethodBeat.i(132157);
        AppBrandSysConfigWC wJ = a.wJ(str);
        if (wJ != null) {
            try {
                str4 = q.encode(str4, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                ab.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
            }
            int i4 = wJ.hhd.gVu;
            int i5 = wJ.hhd.gVt + 1;
            String cV = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
            h.pYm.e(14510, str, Integer.valueOf(i4), Integer.valueOf(i5), cV, str2, str4, str3, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            StringBuilder stringBuilder = new StringBuilder("report kv_14510{");
            stringBuilder.append("appId='").append(str).append('\'').append(", appVersion=").append(i4).append(", appState=").append(i5).append(", networkType='").append(cV).append('\'').append(", functionName='").append(str2).append('\'').append(", url='").append(str4).append('\'').append(", method='").append(str3).append('\'').append(", sentsize=").append(j).append(", receivedsize=").append(j2).append(", statusCode=").append(i).append(", result=").append(i2).append(", costtime=").append(i3).append('}');
            ab.d("MicroMsg.AppBrand.Report.kv_14510", stringBuilder.toString());
            AppMethodBeat.o(132157);
            return;
        }
        ab.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", str);
        AppMethodBeat.o(132157);
    }
}
