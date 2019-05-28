package com.tencent.mm.plugin.game.luggage.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.c.a;
import com.tencent.mm.plugin.game.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class c extends k {
    private b mUB;
    private com.tencent.mm.plugin.game.luggage.c.a.c mUC;
    private e mUm;
    private com.tencent.mm.plugin.game.luggage.c.a.b mUz;

    static /* synthetic */ com.tencent.mm.plugin.game.luggage.c.a.b b(c cVar) {
        AppMethodBeat.i(135924);
        com.tencent.mm.plugin.game.luggage.c.a.b h5GameMenuHelp = cVar.getH5GameMenuHelp();
        AppMethodBeat.o(135924);
        return h5GameMenuHelp;
    }

    public c(e eVar) {
        super(eVar);
        this.mUm = eVar;
    }

    public final l getMenuHelp() {
        AppMethodBeat.i(135919);
        if (this.ujb == null) {
            this.ujb = new a();
        }
        l lVar = this.ujb;
        AppMethodBeat.o(135919);
        return lVar;
    }

    private com.tencent.mm.plugin.game.luggage.c.a.b getH5GameMenuHelp() {
        AppMethodBeat.i(135920);
        if (this.mUz == null) {
            this.mUz = new com.tencent.mm.plugin.game.luggage.c.a.b(this.mUm.bPP.getString("game_hv_menu_appid"));
        }
        com.tencent.mm.plugin.game.luggage.c.a.b bVar = this.mUz;
        AppMethodBeat.o(135920);
        return bVar;
    }

    public final void bDx() {
        AppMethodBeat.i(135921);
        if (!this.mUm.bPe.xi().aZ(!(this.mUm instanceof a))) {
            ((Activity) this.mContext).finish();
        }
        AppMethodBeat.o(135921);
    }

    public final void bDy() {
        long j;
        AppMethodBeat.i(135922);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).mController.hideVKB();
        }
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(135918);
                if (bo.isNullOrNil(c.this.mUm.bPP.getString("game_hv_menu_appid"))) {
                    c.this.mUB = new b(c.this.mUm, c.this.getMenuHelp());
                    AppMethodBeat.o(135918);
                    return;
                }
                c.this.mUC = new com.tencent.mm.plugin.game.luggage.c.a.c(c.this.mUm, c.b(c.this));
                AppMethodBeat.o(135918);
            }
        };
        if (z) {
            j = 100;
        } else {
            j = 0;
        }
        al.n(anonymousClass1, j);
        AppMethodBeat.o(135922);
    }

    public final void bDz() {
        AppMethodBeat.i(135923);
        if (this.mUB != null) {
            this.mUB.cXg();
        }
        if (this.mUC != null) {
            com.tencent.mm.plugin.game.luggage.c.a.c cVar = this.mUC;
            if (cVar.mUo != null) {
                cVar.mUo.cpE();
            }
        }
        AppMethodBeat.o(135923);
    }
}
