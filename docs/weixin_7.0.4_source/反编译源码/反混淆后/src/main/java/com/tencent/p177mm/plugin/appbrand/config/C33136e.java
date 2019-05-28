package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C40616m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.config.e */
public final class C33136e extends C4884c<C32519bf> {
    public C33136e() {
        AppMethodBeat.m2504i(67893);
        this.xxI = C32519bf.class.getName().hashCode();
        AppMethodBeat.m2505o(67893);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(67894);
        C32519bf c32519bf = (C32519bf) c4883b;
        if (c32519bf.cus.cut == 38) {
            int i = c32519bf.cus.cuu;
            int i2 = c32519bf.cus.cuv;
            String str = c32519bf.cus.filePath;
            if (!C5046bo.isNullOrNil(str) || C1173e.m2561ct(str)) {
                boolean z;
                String ayA = AppBrandGlobalSystemConfig.ayA();
                if (C1173e.m2561ct(ayA)) {
                    String cz = C1178g.m2587cz(str);
                    String cz2 = C1178g.m2587cz(ayA);
                    if (C5046bo.isNullOrNil(cz) || cz.equals(cz2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = true;
                }
                if (z) {
                    AppBrandGlobalSystemConfig.ayz();
                    C40616m.copyFile(str, ayA);
                    C14845c.veg.mo27147as(38, i, i2);
                }
            }
        }
        AppMethodBeat.m2505o(67894);
        return true;
    }
}
