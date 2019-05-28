package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.c.db;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.music.e.f;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.plugin.music.ui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class e implements at {
    private c gRa = new c<ae>() {
        {
            AppMethodBeat.i(104894);
            this.xxI = ae.class.getName().hashCode();
            AppMethodBeat.o(104894);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(104895);
            af afVar = new af();
            afVar.csZ.ctb = new a(ah.getContext());
            com.tencent.mm.sdk.b.a.xxA.m(afVar);
            AppMethodBeat.o(104895);
            return false;
        }
    };
    private c<d> mGU = new c<d>() {
        {
            AppMethodBeat.i(104896);
            this.xxI = d.class.getName().hashCode();
            AppMethodBeat.o(104896);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(104897);
            if (!((d) bVar).crQ.crR) {
                new com.tencent.mm.plugin.music.model.a.a().bUn();
            }
            AppMethodBeat.o(104897);
            return false;
        }
    };
    private c oMA = new f();
    private com.tencent.mm.plugin.music.model.e.b oMx;
    private ClipboardManager oMy;
    private com.tencent.mm.plugin.music.model.e.d oMz;

    public e() {
        AppMethodBeat.i(104898);
        AppMethodBeat.o(104898);
    }

    private static e bUj() {
        AppMethodBeat.i(104899);
        e eVar = (e) q.Y(e.class);
        AppMethodBeat.o(104899);
        return eVar;
    }

    public final HashMap<Integer, h.d> Jx() {
        AppMethodBeat.i(104900);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new h.d() {
            public final String[] Af() {
                AppMethodBeat.i(104892);
                String[] strArr = new String[1];
                Class cls = db.class;
                strArr[0] = j.a(db.Hm(), "Music");
                AppMethodBeat.o(104892);
                return strArr;
            }
        });
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new h.d() {
            public final String[] Af() {
                AppMethodBeat.i(104893);
                String[] strArr = new String[1];
                Class cls = dl.class;
                strArr[0] = j.a(dl.Hm(), "PieceMusicInfo");
                AppMethodBeat.o(104893);
                return strArr;
            }
        });
        AppMethodBeat.o(104900);
        return hashMap;
    }

    public static com.tencent.mm.plugin.music.model.e.b bUk() {
        AppMethodBeat.i(104901);
        if (bUj().oMx == null) {
            bUj().oMx = new com.tencent.mm.plugin.music.model.e.b(g.RP().eJN);
        }
        com.tencent.mm.plugin.music.model.e.b bVar = bUj().oMx;
        AppMethodBeat.o(104901);
        return bVar;
    }

    public static ClipboardManager bUl() {
        AppMethodBeat.i(104902);
        if (bUj().oMy == null) {
            bUj().oMy = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        }
        ClipboardManager clipboardManager = bUj().oMy;
        AppMethodBeat.o(104902);
        return clipboardManager;
    }

    public static com.tencent.mm.plugin.music.model.e.d bUm() {
        AppMethodBeat.i(104903);
        if (bUj().oMz == null) {
            bUj().oMz = new com.tencent.mm.plugin.music.model.e.d(g.RP().eJN);
        }
        com.tencent.mm.plugin.music.model.e.d dVar = bUj().oMz;
        AppMethodBeat.o(104903);
        return dVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(104904);
        this.mGU.dnU();
        this.oMA.dnU();
        this.gRa.dnU();
        m mVar = new m();
        k.a(mVar);
        com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, mVar);
        com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.e());
        AppMethodBeat.o(104904);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(104905);
        k.bUg();
        com.tencent.mm.plugin.music.f.c.b.L(com.tencent.mm.plugin.music.e.e.class);
        this.oMx = null;
        this.oMy = null;
        this.oMz = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.oMA);
        this.oMA.dead();
        this.gRa.dead();
        this.mGU.dead();
        AppMethodBeat.o(104905);
    }
}
