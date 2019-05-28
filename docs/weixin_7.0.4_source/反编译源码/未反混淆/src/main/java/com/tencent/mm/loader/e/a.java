package com.tencent.mm.loader.e;

import com.tencent.mm.a.g;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a implements f {
    public final String b(com.tencent.mm.loader.h.a.a<?> aVar) {
        if (aVar == null || bo.isNullOrNil(aVar.toString())) {
            return null;
        }
        ab.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", g.x(aVar.toString().getBytes()));
        return g.x(aVar.toString().getBytes());
    }

    public final String c(com.tencent.mm.loader.h.a.a<?> aVar) {
        String str = null;
        if (!(aVar == null || bo.isNullOrNil(aVar.toString()))) {
            str = g.x(aVar.toString().getBytes());
            ab.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", str);
        }
        return str + ".tmp";
    }
}
