package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.af;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.ArrayList;
import java.util.List;

public class a implements ae {
    private static volatile a ebw;
    private List<af> callbacks = new ArrayList();
    private ax ebu = new ax();
    private com.tencent.mm.sdk.platformtools.ax.a ebv = new com.tencent.mm.sdk.platformtools.ax.a() {
        public final void ih(int i) {
            AppMethodBeat.i(77618);
            switch (i) {
                case 0:
                    ab.v("MicroMsg.BackgroundPlayer", "call end");
                    a.this.Ic();
                    AppMethodBeat.o(77618);
                    return;
                case 1:
                case 2:
                    ab.v("MicroMsg.BackgroundPlayer", "call start");
                    a.this.Id();
                    break;
            }
            AppMethodBeat.o(77618);
        }
    };
    private c ebx;

    private a() {
        AppMethodBeat.i(77621);
        this.ebu.a(this.ebv);
        this.ebu.gK(ah.getContext());
        if (this.ebx == null) {
            this.ebx = new c<nu>() {
                {
                    AppMethodBeat.i(77619);
                    this.xxI = nu.class.getName().hashCode();
                    AppMethodBeat.o(77619);
                }

                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(77620);
                    switch (((nu) bVar).cKl.state) {
                        case 0:
                            ab.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                            a.this.Id();
                            break;
                        case 1:
                            ab.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                            a.this.Ic();
                            break;
                    }
                    AppMethodBeat.o(77620);
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.ebx);
        AppMethodBeat.o(77621);
    }

    public static a Ib() {
        AppMethodBeat.i(77622);
        if (ebw == null) {
            synchronized (a.class) {
                try {
                    if (ebw == null) {
                        ebw = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(77622);
                    }
                }
            }
        }
        a aVar = ebw;
        AppMethodBeat.o(77622);
        return aVar;
    }

    public final void a(af afVar) {
        AppMethodBeat.i(77623);
        ab.d("MicroMsg.BackgroundPlayer", "add callback : %s", afVar.toString());
        this.callbacks.add(afVar);
        AppMethodBeat.o(77623);
    }

    public final void b(af afVar) {
        AppMethodBeat.i(77624);
        this.callbacks.remove(afVar);
        AppMethodBeat.o(77624);
    }

    public final void Ic() {
        AppMethodBeat.i(77625);
        if (this.callbacks == null) {
            AppMethodBeat.o(77625);
            return;
        }
        for (af Zs : this.callbacks) {
            Zs.Zs();
        }
        AppMethodBeat.o(77625);
    }

    public final void Id() {
        AppMethodBeat.i(77626);
        if (this.callbacks == null) {
            AppMethodBeat.o(77626);
            return;
        }
        for (af Zt : this.callbacks) {
            Zt.Zt();
        }
        AppMethodBeat.o(77626);
    }
}
