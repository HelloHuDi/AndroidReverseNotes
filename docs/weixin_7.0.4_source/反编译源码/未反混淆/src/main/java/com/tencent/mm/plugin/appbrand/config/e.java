package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.m;

public final class e extends c<bf> {
    public e() {
        AppMethodBeat.i(67893);
        this.xxI = bf.class.getName().hashCode();
        AppMethodBeat.o(67893);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(67894);
        bf bfVar = (bf) bVar;
        if (bfVar.cus.cut == 38) {
            int i = bfVar.cus.cuu;
            int i2 = bfVar.cus.cuv;
            String str = bfVar.cus.filePath;
            if (!bo.isNullOrNil(str) || com.tencent.mm.a.e.ct(str)) {
                boolean z;
                String ayA = AppBrandGlobalSystemConfig.ayA();
                if (com.tencent.mm.a.e.ct(ayA)) {
                    String cz = g.cz(str);
                    String cz2 = g.cz(ayA);
                    if (bo.isNullOrNil(cz) || cz.equals(cz2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = true;
                }
                if (z) {
                    AppBrandGlobalSystemConfig.ayz();
                    m.copyFile(str, ayA);
                    com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(38, i, i2);
                }
            }
        }
        AppMethodBeat.o(67894);
        return true;
    }
}
