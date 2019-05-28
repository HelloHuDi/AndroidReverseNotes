package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d implements f {
    public final String sF(String str) {
        AppMethodBeat.i(116083);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            str2 = g.x(str.getBytes());
            ab.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", str2);
        }
        AppMethodBeat.o(116083);
        return str2;
    }
}
