package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.f;

public final class ai {

    public interface a<T> {
        T newInstance();
    }

    public static ModulePkgInfo a(f fVar) {
        AppMethodBeat.i(101712);
        ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
        modulePkgInfo.name = fVar.name;
        modulePkgInfo.cvZ = fVar.cvZ;
        modulePkgInfo.cta = fVar.cta;
        modulePkgInfo.gSQ = fVar.gSQ;
        AppMethodBeat.o(101712);
        return modulePkgInfo;
    }
}
