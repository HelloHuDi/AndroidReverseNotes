package com.tencent.p177mm.plugin.webview.p1068e;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.e.c */
public final class C43866c {
    public HashMap<String, C22786a> uKV = new HashMap();

    /* renamed from: com.tencent.mm.plugin.webview.e.c$a */
    public static class C22786a {
        public int permission;
        public String title;
        public int uKW;
    }

    public C43866c() {
        AppMethodBeat.m2504i(10139);
        AppMethodBeat.m2505o(10139);
    }

    /* renamed from: a */
    public static void m78658a(Context context, String str, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(10140);
        C5652a c5652a = new C5652a(context);
        c5652a.mo11482rc(false);
        c5652a.mo11449PY(3);
        c5652a.asD(context.getString(C25738R.string.fz4));
        if (!C5046bo.isNullOrNil(str)) {
            c5652a.mo11480ra(true);
            c5652a.mo11466ak(str);
        }
        c5652a.mo11481rb(true);
        c5652a.asH(context.getString(C25738R.string.fz3));
        c5652a.asJ(context.getString(C25738R.string.f9187s6));
        c5652a.mo11455Qe(context.getResources().getColor(C25738R.color.f12123t7));
        c5652a.mo11457a(onClickListener);
        c5652a.asK(context.getString(C25738R.string.f9076or));
        C5018as eg = C5018as.m7465eg("key_webview_menu_haokan", 2);
        if (eg.decodeBool("show_first_tips", true)) {
            eg.encode("show_first_tips", false);
            eg.apply();
            c5652a.mo11465aj(context.getString(C25738R.string.fz2));
        }
        c5652a.aMb().show();
        AppMethodBeat.m2505o(10140);
    }

    public final C22786a agE(String str) {
        AppMethodBeat.m2504i(10141);
        C22786a c22786a = (C22786a) this.uKV.get(str);
        AppMethodBeat.m2505o(10141);
        return c22786a;
    }
}
