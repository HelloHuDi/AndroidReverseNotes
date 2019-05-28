package com.tencent.mm.plugin.exdevice.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static void n(long j, int i) {
        AppMethodBeat.i(19519);
        b Ku = ad.boW().Ku(String.valueOf(j));
        if (Ku == null) {
            ab.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(19519);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Ku.field_deviceType).append(',');
        stringBuilder.append(Ku.field_deviceID).append(',');
        stringBuilder.append(i);
        h.pYm.X(11232, stringBuilder.toString());
        AppMethodBeat.o(19519);
    }
}
