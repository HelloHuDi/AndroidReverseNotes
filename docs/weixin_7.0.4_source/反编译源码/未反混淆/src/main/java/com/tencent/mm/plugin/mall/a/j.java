package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class j implements f, at {
    private ak mHandler = new ak(Looper.getMainLooper());
    ConcurrentHashMap<Integer, w> ola = new ConcurrentHashMap();
    private boolean olb = false;
    private a olc = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(43117);
            final String a = aa.a(aVar.eAB.vED);
            ab.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(a)));
            j.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43116);
                    c cQT = c.cQT();
                    String str = a;
                    MallNews acJ = c.acJ(str);
                    if (acJ != null) {
                        if ("2".equals(acJ.type)) {
                            ab.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(acJ)));
                            MallNews mallNews = (MallNews) cQT.tDE.get(acJ.fsT);
                            if (mallNews != null && mallNews.ssr.equals(acJ.ssr) && mallNews.cxb.equals(acJ.cxb)) {
                                ab.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + acJ.fsT);
                                cQT.tDE.remove(acJ.fsT);
                                AppMethodBeat.o(43116);
                                return;
                            }
                            ab.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        } else {
                            cQT.tDE.put(acJ.fsT, acJ);
                            ab.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(str)));
                            cQT.bZX();
                            if (c.a(acJ)) {
                                ab.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                                AppMethodBeat.o(43116);
                                return;
                            }
                            if (acJ.showType == 0) {
                                ab.d("MicroMsg.MallNewsManager", "showType New");
                                com.tencent.mm.x.c.PK().x(262156, true);
                                g.RQ();
                                g.RP().Ry().set(ac.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            } else if (acJ.showType == 1) {
                                ab.d("MicroMsg.MallNewsManager", "showType Dot");
                                com.tencent.mm.x.c.PK().y(262156, true);
                                g.RQ();
                                g.RP().Ry().set(ac.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            }
                            c.cQV();
                            AppMethodBeat.o(43116);
                            return;
                        }
                    }
                    AppMethodBeat.o(43116);
                }
            });
            AppMethodBeat.o(43117);
        }
    };
    private a old = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(43119);
            final String a = aa.a(aVar.eAB.vED);
            ab.d("MicroMsg.SubCoreMall", "receive pay msg: %s", a);
            j.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43118);
                    c.cQT();
                    c.acG(a);
                    AppMethodBeat.o(43118);
                }
            });
            AppMethodBeat.o(43119);
        }
    };

    public j() {
        AppMethodBeat.i(43120);
        AppMethodBeat.o(43120);
    }

    public static j bMV() {
        AppMethodBeat.i(43121);
        j jVar = (j) q.Y(j.class);
        AppMethodBeat.o(43121);
        return jVar;
    }

    public final ArrayList<MallFunction> ym(int i) {
        AppMethodBeat.i(43123);
        ArrayList arrayList = yl(i).okP;
        AppMethodBeat.o(43123);
        return arrayList;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(43124);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("mallactivity", this.olc, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.old, true);
        c.cQT().Kh();
        com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().Kh();
        if (r.YM() && r.YI()) {
            b.Hs(b.tDs);
        } else {
            b.Hs(b.tDr);
        }
        g.RQ();
        g.RO().eJo.a(302, (f) this);
        AppMethodBeat.o(43124);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(43125);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("mallactivity", this.olc, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.old, true);
        g.RQ();
        g.RO().eJo.b(302, (f) this);
        AppMethodBeat.o(43125);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43126);
        if (i2 == 0 && i == 0 && !this.olb && r.YM()) {
            this.olb = true;
            b.Hs(b.tDs);
        }
        AppMethodBeat.o(43126);
    }

    public final w yl(int i) {
        Object obj = null;
        AppMethodBeat.i(43122);
        if (!this.ola.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.d.e cPN = com.tencent.mm.plugin.wallet_core.model.r.cPN();
            String concat = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(i));
            Cursor a = cPN.bSd.a(concat, null, 2);
            ab.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(concat)));
            if (a != null) {
                if (a.moveToNext()) {
                    obj = new w();
                    obj.d(a);
                }
                a.close();
            }
            if (obj != null) {
                this.ola.put(Integer.valueOf(i), obj);
            }
        }
        w wVar = (w) this.ola.get(Integer.valueOf(i));
        if (wVar == null) {
            wVar = new w();
            AppMethodBeat.o(43122);
            return wVar;
        }
        AppMethodBeat.o(43122);
        return wVar;
    }
}
