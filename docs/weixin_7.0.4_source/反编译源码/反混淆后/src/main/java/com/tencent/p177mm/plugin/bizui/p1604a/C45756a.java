package com.tencent.p177mm.plugin.bizui.p1604a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.p069v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.bizui.a.a */
public final class C45756a {
    /* renamed from: a */
    public static C5653c m84568a(C5536q c5536q, String str, String str2, String str3, final C30111a c30111a, final C30111a c30111a2) {
        CharSequence str32;
        CharSequence str22;
        AppMethodBeat.m2504i(70044);
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11459a(C1434a.decodeResource(c5536q.ylL.getResources(), C1318a.dialog_successful_icon), false, 3);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        c5652a.asG(str).mo11452Qb(17);
        final C5653c aMb = c5652a.aMb();
        AppCompatActivity appCompatActivity = c5536q.ylL;
        if (C5046bo.isNullOrNil(str32) || str32.length() == 0) {
            str32 = appCompatActivity.getResources().getString(C25738R.string.atf);
        }
        if (C5046bo.isNullOrNil(str22) || str22.length() == 0) {
            str22 = appCompatActivity.getResources().getString(C25738R.string.f9076or);
        }
        aMb.mo11489a(str32, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(70042);
                aMb.dismiss();
                if (c30111a2 != null) {
                    c30111a2.mo6399a(true, aMb.dKV(), aMb.dKW());
                }
                AppMethodBeat.m2505o(70042);
            }
        });
        aMb.mo11491b(str22, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(70043);
                aMb.dismiss();
                if (c30111a != null) {
                    c30111a.mo6399a(false, null, 0);
                }
                AppMethodBeat.m2505o(70043);
            }
        });
        aMb.mo11486PU(c5536q.ylL.getResources().getColor(C25738R.color.f11795hi));
        aMb.show();
        AppMethodBeat.m2505o(70044);
        return aMb;
    }
}
