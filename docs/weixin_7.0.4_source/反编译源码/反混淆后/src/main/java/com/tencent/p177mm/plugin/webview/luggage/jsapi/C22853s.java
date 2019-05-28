package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.s */
public class C22853s extends C46419bd<C24905d> {
    public final String name() {
        return "getSystemInfo";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6314);
        HashMap hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
        hashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
        hashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(C4996ah.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        c32183a.mo52825c("", hashMap);
        AppMethodBeat.m2505o(6314);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
