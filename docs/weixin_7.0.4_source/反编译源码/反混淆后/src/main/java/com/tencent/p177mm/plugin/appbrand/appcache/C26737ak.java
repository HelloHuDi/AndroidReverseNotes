package com.tencent.p177mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a.C10066a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ak */
class C26737ak extends C10065a {
    C26737ak(String str, String str2, int i) {
        super(String.format("WxaDebugPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), C10072ap.avY() + String.format("debug_%d_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), str2, str, String.format("%d-%s", new Object[]{Integer.valueOf(i), str2}).hashCode(), i);
        AppMethodBeat.m2504i(59475);
        AppMethodBeat.m2505o(59475);
    }

    C26737ak(String str, String str2, int i, C10066a c10066a) {
        super(String.format("WxaDebugPkg_%s_%d_%s", new Object[]{str, Integer.valueOf(i), C5046bo.nullAsNil(c10066a.avJ())}), C10072ap.avY() + String.format("debug_%d_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(C5046bo.nullAsNil(c10066a.avJ()).hashCode())}), str2, str, String.format("%s_%d_%s", new Object[]{str, Integer.valueOf(i), C5046bo.nullAsNil(c10066a.avJ())}).hashCode(), i);
        AppMethodBeat.m2504i(59476);
        AppMethodBeat.m2505o(59476);
    }
}
