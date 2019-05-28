package com.tencent.p177mm.plugin.appbrand.luggage.p1538c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f;
import com.tencent.p177mm.plugin.appbrand.p321l.C42602o;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.c.c */
public final class C45645c implements C42602o {
    /* renamed from: zT */
    public final void mo68038zT(String str) {
        AppMethodBeat.m2504i(132158);
        AppBrandStatObject wK = C10048a.m17637wK(str);
        if (wK != null) {
            C10211f.m17851zT(C5046bo.nullAsNil(wK.cst));
        }
        AppMethodBeat.m2505o(132158);
    }

    /* renamed from: a */
    public final void mo68037a(String str, String str2, String str3, String str4, long j, long j2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(132157);
        AppBrandSysConfigWC wJ = C10048a.m17636wJ(str);
        if (wJ != null) {
            try {
                str4 = C18178q.encode(str4, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7420w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
            }
            int i4 = wJ.hhd.gVu;
            int i5 = wJ.hhd.gVt + 1;
            String cV = C19690c.m30503cV(C4996ah.getContext());
            C7060h.pYm.mo8381e(14510, str, Integer.valueOf(i4), Integer.valueOf(i5), cV, str2, str4, str3, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            StringBuilder stringBuilder = new StringBuilder("report kv_14510{");
            stringBuilder.append("appId='").append(str).append('\'').append(", appVersion=").append(i4).append(", appState=").append(i5).append(", networkType='").append(cV).append('\'').append(", functionName='").append(str2).append('\'').append(", url='").append(str4).append('\'').append(", method='").append(str3).append('\'').append(", sentsize=").append(j).append(", receivedsize=").append(j2).append(", statusCode=").append(i).append(", result=").append(i2).append(", costtime=").append(i3).append('}');
            C4990ab.m7410d("MicroMsg.AppBrand.Report.kv_14510", stringBuilder.toString());
            AppMethodBeat.m2505o(132157);
            return;
        }
        C4990ab.m7421w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", str);
        AppMethodBeat.m2505o(132157);
    }
}
