package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C30309s;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.c.c */
public final class C34739c {
    /* renamed from: cP */
    public static final void m57055cP(String str, int i) {
        AppMethodBeat.m2504i(23957);
        C46140d Va = C34696c.cap().mo55342Va(str);
        String str2 = Va != null ? Va.field_decryptUserName : "";
        C4990ab.m7411d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s", str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4), str2);
        C7060h.pYm.mo8381e(13307, str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4), str2, Integer.valueOf(C30309s.getSessionId()));
        AppMethodBeat.m2505o(23957);
    }
}
