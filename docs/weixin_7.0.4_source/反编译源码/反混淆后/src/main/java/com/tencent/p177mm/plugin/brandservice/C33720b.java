package com.tencent.p177mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.b */
public final class C33720b implements C23256o {
    public static C23255n gkE;
    public static C23244m gkF;

    /* renamed from: a */
    public final void mo7223a(C23255n c23255n) {
        gkE = c23255n;
    }

    /* renamed from: a */
    public final void mo7222a(C23244m c23244m) {
        gkF = c23244m;
    }

    /* renamed from: h */
    public static void m55106h(int i, Object obj) {
        AppMethodBeat.m2504i(13798);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? BuildConfig.COMMAND : obj.toString();
        C4990ab.m7417i(str, str2, objArr);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(i, obj);
        AppMethodBeat.m2505o(13798);
    }

    /* renamed from: a */
    public static void m55105a(String str, Runnable runnable, long j) {
        AppMethodBeat.m2504i(13799);
        if (j > 0) {
            C7305d.xDG.mo10152b(runnable, str, j);
            AppMethodBeat.m2505o(13799);
            return;
        }
        C7305d.xDG.mo10151b(runnable, str);
        AppMethodBeat.m2505o(13799);
    }
}
