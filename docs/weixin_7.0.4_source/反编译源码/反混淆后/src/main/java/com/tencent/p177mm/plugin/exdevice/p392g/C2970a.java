package com.tencent.p177mm.plugin.exdevice.p392g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.g.a */
public final class C2970a {
    /* renamed from: n */
    public static void m5256n(long j, int i) {
        AppMethodBeat.m2504i(19519);
        C11648b Ku = C45891ad.boW().mo45700Ku(String.valueOf(j));
        if (Ku == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.m2505o(19519);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Ku.field_deviceType).append(',');
        stringBuilder.append(Ku.field_deviceID).append(',');
        stringBuilder.append(i);
        C7060h.pYm.mo8374X(11232, stringBuilder.toString());
        AppMethodBeat.m2505o(19519);
    }
}
