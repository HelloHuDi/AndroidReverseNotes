package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.a.c;

public final class h implements i {
    public final o a(q qVar, String str, String str2, String str3, String str4, String str5, a aVar) {
        AppMethodBeat.i(27711);
        o a = g.a(qVar, str, str2, str3, str4, str5, aVar);
        AppMethodBeat.o(27711);
        return a;
    }

    public final void a(q qVar, String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(27712);
        g.a(qVar, str, str2, str3, aVar);
        AppMethodBeat.o(27712);
    }

    public final c b(q qVar, String str, String str2, String str3, String str4, String str5, a aVar) {
        AppMethodBeat.i(27713);
        c b = g.b(qVar, str, str2, str3, str4, str5, aVar);
        AppMethodBeat.o(27713);
        return b;
    }

    public final c a(Context context, String str, View view, String str2, a aVar) {
        AppMethodBeat.i(27714);
        g.a djy = new g.a(context).cx(str).ev(view).h(Boolean.TRUE).djy();
        djy.vkn = str2;
        c cVar = djy.a(aVar).gud;
        AppMethodBeat.o(27714);
        return cVar;
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, a aVar) {
        AppMethodBeat.i(27715);
        g.a aVar2 = new g.a(context);
        aVar2.cx(str).ajC(str2).vkn = str3;
        aVar2.ajD(str5).djx();
        aVar2.vkm.asH(str4);
        aVar2.a(aVar).gud.show();
        AppMethodBeat.o(27715);
    }

    public final void a(Context context, String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(27716);
        g.a aVar2 = new g.a(context);
        aVar2.cx(str);
        aVar2.ajE(str2);
        aVar2.h(Boolean.TRUE);
        aVar2.vkn = str3;
        aVar2.a(aVar).gud.show();
        AppMethodBeat.o(27716);
    }
}
