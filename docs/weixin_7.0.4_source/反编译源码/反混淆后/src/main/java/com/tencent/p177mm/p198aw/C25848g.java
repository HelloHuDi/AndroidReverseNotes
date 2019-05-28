package com.tencent.p177mm.p198aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.aw.g */
public final class C25848g extends C9059f {
    /* renamed from: a */
    public static C9058e m41159a(String str, TimeLineObject timeLineObject, int i) {
        String str2 = null;
        AppMethodBeat.m2504i(108010);
        if (timeLineObject == null || timeLineObject.xfI == null || timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() <= 0) {
            AppMethodBeat.m2505o(108010);
            return null;
        }
        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
        if (bau == null) {
            AppMethodBeat.m2505o(108010);
            return null;
        }
        C9058e c9058e = new C9058e();
        c9058e.fJS = i;
        c9058e.fJU = timeLineObject.f15074Id;
        c9058e.fJV = 0.0f;
        c9058e.fJY = "";
        c9058e.fJZ = bau.wEH;
        c9058e.fKe = null;
        c9058e.fJT = 1;
        c9058e.fKd = null;
        c9058e.fJW = bau.Title;
        c9058e.fJX = bau.Desc;
        if (timeLineObject.xfI != null) {
            str2 = timeLineObject.xfI.Url;
        }
        c9058e.fKc = str2;
        c9058e.fKb = bau.wEL;
        c9058e.fKa = bau.Url;
        c9058e.fKi = bau.wEI;
        c9058e.fKk = bau.f17915Id;
        c9058e.fKf = str;
        c9058e.fKh = timeLineObject.xfH.f17242Id;
        c9058e.fKo = timeLineObject.jBB;
        AppMethodBeat.m2505o(108010);
        return c9058e;
    }

    /* renamed from: a */
    public static C9058e m41158a(C8910b c8910b, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(108011);
        if (c8910b == null) {
            AppMethodBeat.m2505o(108011);
            return null;
        }
        C9058e c9058e = new C9058e();
        c9058e.fJS = 0;
        c9058e.fJU = str;
        c9058e.fJV = 0.0f;
        c9058e.fJY = "";
        c9058e.fJZ = str2;
        c9058e.fKe = str4;
        c9058e.fJT = 1;
        c9058e.fKd = null;
        c9058e.fJW = c8910b.title;
        c9058e.fJX = c8910b.description;
        c9058e.fKc = c8910b.url;
        c9058e.fKb = !C5046bo.isNullOrNil(c8910b.fgN) ? c8910b.fgN : c8910b.fgn;
        c9058e.fKa = c8910b.fgM;
        c9058e.fKh = c8910b.appId;
        c9058e.fKf = str3;
        AppMethodBeat.m2505o(108011);
        return c9058e;
    }
}
