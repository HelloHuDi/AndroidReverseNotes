package com.tencent.mm.plugin.webview.e;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> uKV = new HashMap();

    public static class a {
        public int permission;
        public String title;
        public int uKW;
    }

    public c() {
        AppMethodBeat.i(10139);
        AppMethodBeat.o(10139);
    }

    public static void a(Context context, String str, OnClickListener onClickListener) {
        AppMethodBeat.i(10140);
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.rc(false);
        aVar.PY(3);
        aVar.asD(context.getString(R.string.fz4));
        if (!bo.isNullOrNil(str)) {
            aVar.ra(true);
            aVar.ak(str);
        }
        aVar.rb(true);
        aVar.asH(context.getString(R.string.fz3));
        aVar.asJ(context.getString(R.string.s6));
        aVar.Qe(context.getResources().getColor(R.color.t7));
        aVar.a(onClickListener);
        aVar.asK(context.getString(R.string.or));
        as eg = as.eg("key_webview_menu_haokan", 2);
        if (eg.decodeBool("show_first_tips", true)) {
            eg.encode("show_first_tips", false);
            eg.apply();
            aVar.aj(context.getString(R.string.fz2));
        }
        aVar.aMb().show();
        AppMethodBeat.o(10140);
    }

    public final a agE(String str) {
        AppMethodBeat.i(10141);
        a aVar = (a) this.uKV.get(str);
        AppMethodBeat.o(10141);
        return aVar;
    }
}
