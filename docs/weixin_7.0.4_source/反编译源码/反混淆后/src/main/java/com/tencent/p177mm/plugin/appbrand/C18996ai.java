package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;

/* renamed from: com.tencent.mm.plugin.appbrand.ai */
public final class C18996ai {

    /* renamed from: com.tencent.mm.plugin.appbrand.ai$a */
    public interface C2045a<T> {
        T newInstance();
    }

    /* renamed from: a */
    public static ModulePkgInfo m29565a(C31284f c31284f) {
        AppMethodBeat.m2504i(101712);
        ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
        modulePkgInfo.name = c31284f.name;
        modulePkgInfo.cvZ = c31284f.cvZ;
        modulePkgInfo.cta = c31284f.cta;
        modulePkgInfo.gSQ = c31284f.gSQ;
        AppMethodBeat.m2505o(101712);
        return modulePkgInfo;
    }
}
