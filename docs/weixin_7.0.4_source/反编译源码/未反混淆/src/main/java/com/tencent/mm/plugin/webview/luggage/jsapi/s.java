package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class s extends bd<d> {
    public final String name() {
        return "getSystemInfo";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6314);
        HashMap hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
        hashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
        hashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(ah.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        aVar.c("", hashMap);
        AppMethodBeat.o(6314);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
