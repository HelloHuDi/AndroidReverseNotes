package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g extends com.tencent.mm.ui.base.sortview.a {
    private static b jKQ;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
    }

    public g(Object obj) {
        super(0, obj);
        this.yDq = true;
    }

    public final b aVY() {
        AppMethodBeat.i(14056);
        if (jKQ == null) {
            jKQ = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                public final View c(Context context, View view) {
                    AppMethodBeat.i(14055);
                    if (view == null) {
                        view = new View(context);
                    }
                    AppMethodBeat.o(14055);
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                }
            };
        }
        b bVar = jKQ;
        AppMethodBeat.o(14056);
        return bVar;
    }

    public final com.tencent.mm.ui.base.sortview.a.a aVZ() {
        AppMethodBeat.i(14057);
        a aVar = new a();
        AppMethodBeat.o(14057);
        return aVar;
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
    }
}
