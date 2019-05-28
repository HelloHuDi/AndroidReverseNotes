package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.bbb;

public final class c {
    e mUm;
    b mUn;
    public d mUo = new d(this.mUm.mContext);

    public c(e eVar, b bVar) {
        AppMethodBeat.i(135896);
        this.mUm = eVar;
        this.mUn = bVar;
        this.mUo.a(new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c() {
            public final void f(MenuItem menuItem) {
                AppMethodBeat.i(135895);
                c cVar = c.this;
                b bVar = cVar.mUn;
                Context context = cVar.mUm.mContext;
                com.tencent.mm.plugin.webview.luggage.d dVar = cVar.mUm;
                a aVar = (a) bVar.mUk.get(Integer.valueOf(menuItem.getItemId()));
                for (bbb bbb : bVar.mUj) {
                    if (bbb != null && bbb.wkB == menuItem.getItemId()) {
                        break;
                    }
                }
                bbb bbb2 = null;
                if (!(aVar == null || bbb2 == null)) {
                    aVar.a(context, dVar, bbb2);
                }
                c.this.mUo.cpE();
                AppMethodBeat.o(135895);
            }
        });
        this.mUo.cpD();
        AppMethodBeat.o(135896);
    }
}
