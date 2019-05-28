package com.tencent.p177mm.plugin.mall.p450a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C35482w;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C29636b;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C46367d;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C43792e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.mall.a.j */
public class C43288j implements C1202f, C1816at {
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    ConcurrentHashMap<Integer, C35482w> ola = new ConcurrentHashMap();
    private boolean olb = false;
    private C1837a olc = new C432871();
    private C1837a old = new C284682();

    /* renamed from: com.tencent.mm.plugin.mall.a.j$2 */
    class C284682 implements C1837a {
        C284682() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(43119);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7411d("MicroMsg.SubCoreMall", "receive pay msg: %s", a);
            C43288j.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(43118);
                    C40113c.cQT();
                    C40113c.acG(a);
                    AppMethodBeat.m2505o(43118);
                }
            });
            AppMethodBeat.m2505o(43119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.a.j$1 */
    class C432871 implements C1837a {
        C432871() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(43117);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7410d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(a)));
            C43288j.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(43116);
                    C40113c cQT = C40113c.cQT();
                    String str = a;
                    MallNews acJ = C40113c.acJ(str);
                    if (acJ != null) {
                        if ("2".equals(acJ.type)) {
                            C4990ab.m7410d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(acJ)));
                            MallNews mallNews = (MallNews) cQT.tDE.get(acJ.fsT);
                            if (mallNews != null && mallNews.ssr.equals(acJ.ssr) && mallNews.cxb.equals(acJ.cxb)) {
                                C4990ab.m7416i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + acJ.fsT);
                                cQT.tDE.remove(acJ.fsT);
                                AppMethodBeat.m2505o(43116);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        } else {
                            cQT.tDE.put(acJ.fsT, acJ);
                            C4990ab.m7416i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(str)));
                            cQT.bZX();
                            if (C40113c.m68764a(acJ)) {
                                C4990ab.m7416i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                                AppMethodBeat.m2505o(43116);
                                return;
                            }
                            if (acJ.showType == 0) {
                                C4990ab.m7410d("MicroMsg.MallNewsManager", "showType New");
                                C16112c.m24429PK().mo28556x(262156, true);
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            } else if (acJ.showType == 1) {
                                C4990ab.m7410d("MicroMsg.MallNewsManager", "showType Dot");
                                C16112c.m24429PK().mo28557y(262156, true);
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                            }
                            C40113c.cQV();
                            AppMethodBeat.m2505o(43116);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(43116);
                }
            });
            AppMethodBeat.m2505o(43117);
        }
    }

    public C43288j() {
        AppMethodBeat.m2504i(43120);
        AppMethodBeat.m2505o(43120);
    }

    public static C43288j bMV() {
        AppMethodBeat.m2504i(43121);
        C43288j c43288j = (C43288j) C7485q.m12925Y(C43288j.class);
        AppMethodBeat.m2505o(43121);
        return c43288j;
    }

    /* renamed from: ym */
    public final ArrayList<MallFunction> mo68837ym(int i) {
        AppMethodBeat.m2504i(43123);
        ArrayList arrayList = mo68836yl(i).okP;
        AppMethodBeat.m2505o(43123);
        return arrayList;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(43124);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("mallactivity", this.olc, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.old, true);
        C40113c.cQT().mo63442Kh();
        C46367d.cQX().mo74577Kh();
        if (C1853r.m3831YM() && C1853r.m3827YI()) {
            C29636b.m47009Hs(C29636b.tDs);
        } else {
            C29636b.m47009Hs(C29636b.tDr);
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(302, (C1202f) this);
        AppMethodBeat.m2505o(43124);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(43125);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("mallactivity", this.olc, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.old, true);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(302, (C1202f) this);
        AppMethodBeat.m2505o(43125);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43126);
        if (i2 == 0 && i == 0 && !this.olb && C1853r.m3831YM()) {
            this.olb = true;
            C29636b.m47009Hs(C29636b.tDs);
        }
        AppMethodBeat.m2505o(43126);
    }

    /* renamed from: yl */
    public final C35482w mo68836yl(int i) {
        Object obj = null;
        AppMethodBeat.m2504i(43122);
        if (!this.ola.contains(Integer.valueOf(i))) {
            C43792e cPN = C14241r.cPN();
            String concat = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(i));
            Cursor a = cPN.bSd.mo10104a(concat, null, 2);
            C4990ab.m7416i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(concat)));
            if (a != null) {
                if (a.moveToNext()) {
                    obj = new C35482w();
                    obj.mo8995d(a);
                }
                a.close();
            }
            if (obj != null) {
                this.ola.put(Integer.valueOf(i), obj);
            }
        }
        C35482w c35482w = (C35482w) this.ola.get(Integer.valueOf(i));
        if (c35482w == null) {
            c35482w = new C35482w();
            AppMethodBeat.m2505o(43122);
            return c35482w;
        }
        AppMethodBeat.m2505o(43122);
        return c35482w;
    }
}
