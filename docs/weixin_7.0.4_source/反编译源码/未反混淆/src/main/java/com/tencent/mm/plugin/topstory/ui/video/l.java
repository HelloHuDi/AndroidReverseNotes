package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class l {
    private a kto = new a() {
        public final void gl(int i) {
            AppMethodBeat.i(1742);
            final int i2 = l.this.sEO;
            l.this.sEO = l.cGO();
            if (l.this.sEO != i2) {
                ab.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", Integer.valueOf(i2), Integer.valueOf(l.this.sEO));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(1741);
                        if (l.this.sEN != null) {
                            l.this.sEN.fP(i2, l.this.sEO);
                        }
                        AppMethodBeat.o(1741);
                    }
                });
            }
            AppMethodBeat.o(1742);
        }
    };
    public boolean sEM = false;
    c sEN;
    public int sEO = cGO();

    public l() {
        AppMethodBeat.i(1743);
        g.RO().a(this.kto);
        AppMethodBeat.o(1743);
    }

    public final void aEX() {
        AppMethodBeat.i(1744);
        g.RO().b(this.kto);
        this.sEN = null;
        this.sEO = 0;
        this.sEM = false;
        AppMethodBeat.o(1744);
    }

    public final boolean bkJ() {
        return this.sEO == 1;
    }

    public final boolean cGN() {
        return this.sEO == 2;
    }

    public final boolean isConnected() {
        return this.sEO != 0;
    }

    public static int cGO() {
        AppMethodBeat.i(1745);
        if (!com.tinkerboots.sdk.b.a.isConnected(ah.getContext())) {
            AppMethodBeat.o(1745);
            return 0;
        } else if (!com.tinkerboots.sdk.b.a.isWifi(ah.getContext())) {
            AppMethodBeat.o(1745);
            return 2;
        } else if (((PluginTopStoryUI) g.M(PluginTopStoryUI.class)).getTopStoryCommand().sBk) {
            AppMethodBeat.o(1745);
            return 2;
        } else {
            AppMethodBeat.o(1745);
            return 1;
        }
    }
}
