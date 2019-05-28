package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"DefaultLocale"})
class ak extends a {
    ak(String str, String str2, int i) {
        super(String.format("WxaDebugPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), ap.avY() + String.format("debug_%d_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), str2, str, String.format("%d-%s", new Object[]{Integer.valueOf(i), str2}).hashCode(), i);
        AppMethodBeat.i(59475);
        AppMethodBeat.o(59475);
    }

    ak(String str, String str2, int i, a.a aVar) {
        super(String.format("WxaDebugPkg_%s_%d_%s", new Object[]{str, Integer.valueOf(i), bo.nullAsNil(aVar.avJ())}), ap.avY() + String.format("debug_%d_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(bo.nullAsNil(aVar.avJ()).hashCode())}), str2, str, String.format("%s_%d_%s", new Object[]{str, Integer.valueOf(i), bo.nullAsNil(aVar.avJ())}).hashCode(), i);
        AppMethodBeat.i(59476);
        AppMethodBeat.o(59476);
    }
}
