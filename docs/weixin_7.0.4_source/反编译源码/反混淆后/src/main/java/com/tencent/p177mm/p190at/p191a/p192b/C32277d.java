package com.tencent.p177mm.p190at.p191a.p192b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p193c.C9013f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.at.a.b.d */
public final class C32277d implements C9013f {
    /* renamed from: sF */
    public final String mo20445sF(String str) {
        AppMethodBeat.m2504i(116083);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            str2 = C1178g.m2591x(str.getBytes());
            C4990ab.m7411d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", str2);
        }
        AppMethodBeat.m2505o(116083);
        return str2;
    }
}
