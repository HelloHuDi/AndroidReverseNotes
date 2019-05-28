package com.tencent.p177mm.plugin.p436hp.p437b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18295ij;
import com.tencent.p177mm.protocal.p1338b.p1339a.C23368a;
import com.tencent.p177mm.protocal.p1338b.p1339a.C46515b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.hp.b.i */
public final class C46029i {
    /* renamed from: a */
    public static void m85611a(String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(90615);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
            AppMethodBeat.m2505o(90615);
            return;
        }
        C4990ab.m7416i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final OnClickListener onClickListener3 = onClickListener;
        final OnClickListener onClickListener4 = onClickListener2;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90614);
                C18295ij c18295ij = new C18295ij();
                C46515b c46515b = new C46515b();
                c46515b.title = str5;
                c46515b.bzH = str6;
                c46515b.vzI = new LinkedList();
                C23368a c23368a = new C23368a();
                c23368a.vzG = str7;
                c46515b.vzI.add(c23368a);
                c23368a = new C23368a();
                c23368a.vzG = str8;
                c46515b.vzI.add(c23368a);
                c18295ij.cDv.type = 1;
                c18295ij.cDv.cDw = c46515b;
                c18295ij.cDv.cDx = onClickListener3;
                c18295ij.cDv.cDy = onClickListener4;
                C4879a.xxA.mo10055m(c18295ij);
                AppMethodBeat.m2505o(90614);
            }
        });
        AppMethodBeat.m2505o(90615);
    }
}
