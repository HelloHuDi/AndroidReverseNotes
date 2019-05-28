package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public class o {
    u hTn;
    d irC;
    List<n> irD;
    String mAppId;

    public o(u uVar, List<n> list) {
        AppMethodBeat.i(87073);
        this.mAppId = uVar.getAppId();
        this.hTn = uVar;
        this.irD = list;
        d dVar = new d(uVar.mContext);
        this.irC = dVar;
        a(dVar);
        AppMethodBeat.o(87073);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJm() {
        AppMethodBeat.i(87074);
        try {
            this.irC.cpD();
            AppMethodBeat.o(87074);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", e);
            AppMethodBeat.o(87074);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJn() {
        AppMethodBeat.i(87075);
        try {
            this.irC.cpE();
            AppMethodBeat.o(87075);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", e);
            AppMethodBeat.o(87075);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(d dVar) {
        AppMethodBeat.i(87076);
        View aBl = this.hTn.aBl();
        if (aBl != null) {
            this.irC.F(aBl, false);
        }
        this.irC.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(87071);
                for (n nVar : o.this.irD) {
                    if (!(nVar == null || nVar.imK)) {
                        Context context = o.this.hTn.mContext;
                        u uVar = o.this.hTn;
                        String str = o.this.mAppId;
                        if (nVar != null) {
                            nVar.imL.a(context, uVar, lVar, str);
                        }
                    }
                }
                AppMethodBeat.o(87071);
            }
        };
        this.irC.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Object obj;
                AppMethodBeat.i(87072);
                List<n> list = o.this.irD;
                int itemId = menuItem.getItemId();
                for (n nVar : list) {
                    if (nVar.id == itemId) {
                        break;
                    }
                }
                n nVar2 = null;
                Context context = o.this.hTn.mContext;
                u uVar = o.this.hTn;
                String str = o.this.mAppId;
                if (nVar2 == null) {
                    obj = null;
                } else {
                    nVar2.imL.a(context, uVar, str, nVar2);
                    obj = 1;
                }
                if (obj != null) {
                    o.this.irC.cpE();
                }
                AppMethodBeat.o(87072);
            }
        };
        if (this.hTn.isO) {
            d dVar2 = this.irC;
            int parseColor = Color.parseColor("#000000");
            if (dVar2.iym != null) {
                dVar2.iym.setBackgroundColor(parseColor);
            }
            dVar2.zQj = Boolean.valueOf(ah.Nw(parseColor));
            if (dVar2.zQj.booleanValue() && dVar2.zQr != null) {
                dVar2.zQr.setImageDrawable(dVar2.mContext.getResources().getDrawable(R.color.lb));
            }
        }
        AppMethodBeat.o(87076);
    }
}
