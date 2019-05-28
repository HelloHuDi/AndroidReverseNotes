package com.tencent.p177mm.loader.p246e;

import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.loader.e.a */
public final class C45418a implements C32733f {
    /* renamed from: b */
    public final String mo53285b(C42156a<?> c42156a) {
        if (c42156a == null || C5046bo.isNullOrNil(c42156a.toString())) {
            return null;
        }
        C4990ab.m7411d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", C1178g.m2591x(c42156a.toString().getBytes()));
        return C1178g.m2591x(c42156a.toString().getBytes());
    }

    /* renamed from: c */
    public final String mo53286c(C42156a<?> c42156a) {
        String str = null;
        if (!(c42156a == null || C5046bo.isNullOrNil(c42156a.toString()))) {
            str = C1178g.m2591x(c42156a.toString().getBytes());
            C4990ab.m7411d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", str);
        }
        return str + ".tmp";
    }
}
