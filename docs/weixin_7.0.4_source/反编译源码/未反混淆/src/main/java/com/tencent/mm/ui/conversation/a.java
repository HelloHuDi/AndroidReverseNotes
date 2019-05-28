package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.q;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ah.d.a, as, b {
    Context context;
    n qbK;
    View zqA;
    List<com.tencent.mm.pluginsdk.ui.b.b> zqr = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zqs = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zqt = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zqu = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zqv = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> zqw = new LinkedList();
    c zqx;
    c zqy;
    ListView zqz;

    public a() {
        AppMethodBeat.i(34034);
        AppMethodBeat.o(34034);
    }

    public final void a(Context context, ListView listView, View view) {
        AppMethodBeat.i(34035);
        this.context = context;
        this.zqz = listView;
        this.zqA = view;
        this.zqy = new c<af>() {
            {
                AppMethodBeat.i(34026);
                this.xxI = af.class.getName().hashCode();
                AppMethodBeat.o(34026);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34027);
                af afVar = (af) bVar;
                com.tencent.mm.pluginsdk.ui.b.b bVar2 = afVar.csZ.ctb;
                if (bVar2 != null && bVar2.getView() != null) {
                    ab.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", bVar2, Integer.valueOf(a.this.hashCode()));
                    if (!afVar.csZ.cta) {
                        switch (afVar.csZ.level) {
                            case 1:
                                a.this.zqs.add(bVar2);
                                break;
                            case 2:
                                a.this.zqt.add(bVar2);
                                break;
                            default:
                                a.this.zqu.add(bVar2);
                                break;
                        }
                    }
                    a.this.zqr.add(bVar2);
                } else {
                    ab.w("MicroMsg.BannerHelper", "banner is null, event:%s", afVar);
                }
                AppMethodBeat.o(34027);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(this.zqy);
        ae aeVar = new ae();
        aeVar.csY.activity = (Activity) context;
        com.tencent.mm.sdk.b.a.xxA.m(aeVar);
        af afVar = new af();
        afVar.csZ.ctb = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.MAIN_FRAME_AND_ABTEST_BANNER, null);
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        com.tencent.mm.pluginsdk.ui.b.b bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.NET_WARN_BANNER, null);
        afVar = new af();
        afVar.csZ.ctb = bVar;
        afVar.csZ.level = 1;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.OTHER_ONLINE_BANNER, null);
        afVar = new af();
        afVar.csZ.ctb = bVar;
        afVar.csZ.cta = false;
        afVar.csZ.level = 1;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        q qVar = (q) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.TRY_NEW_INIT_BANNER, null);
        afVar = new af();
        afVar.csZ.ctb = qVar;
        afVar.csZ.cta = false;
        afVar.csZ.level = 2;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        com.tencent.mm.ui.conversation.a.a aVar = (com.tencent.mm.ui.conversation.a.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.AD_BANNER, null);
        afVar = new af();
        afVar.csZ.ctb = aVar;
        afVar.csZ.cta = false;
        afVar.csZ.level = 3;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        com.tencent.mm.ui.d.a aVar2 = (com.tencent.mm.ui.d.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.CHATTING_MONITORED_HINT, new Object[]{com.tencent.mm.model.b.b.b.Main});
        afVar = new af();
        afVar.csZ.ctb = aVar2;
        afVar.csZ.cta = true;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.FORCE_NOTIFY_BANNER, null);
        afVar = new af();
        afVar.csZ.ctb = bVar;
        afVar.csZ.cta = false;
        afVar.csZ.level = 1;
        com.tencent.mm.sdk.b.a.xxA.m(afVar);
        com.tencent.mm.sdk.b.a.xxA.d(this.zqy);
        this.zqw.addAll(this.zqr);
        this.zqw.addAll(this.zqs);
        this.zqw.addAll(this.zqt);
        this.zqw.addAll(this.zqu);
        Collections.sort(this.zqw, new Comparator<com.tencent.mm.pluginsdk.ui.b.b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(34028);
                int order = ((com.tencent.mm.pluginsdk.ui.b.b) obj2).getOrder() - ((com.tencent.mm.pluginsdk.ui.b.b) obj).getOrder();
                AppMethodBeat.o(34028);
                return order;
            }
        });
        for (com.tencent.mm.pluginsdk.ui.b.b bVar2 : this.zqw) {
            this.zqz.addHeaderView(bVar2.getView());
        }
        LinkedList linkedList = new LinkedList();
        bVar2 = (com.tencent.mm.pluginsdk.ui.b.b) e.a(context, com.tencent.mm.ui.conversation.a.e.a.FACEBOOK_BANNER, null);
        if (!(bVar2 == null || bVar2.getView() == null)) {
            listView.addFooterView(bVar2.getView());
        }
        this.zqv.add(bVar2);
        listView.addFooterView(new j(context).getView(), null, true);
        this.zqv.add(bVar2);
        this.qbK = new com.tencent.mm.network.n.a() {
            private final ap zqC = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(34029);
                    a.this.dIn();
                    AppMethodBeat.o(34029);
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(34030);
                AppMethodBeat.o(34030);
            }

            public final void gl(int i) {
                AppMethodBeat.i(34031);
                if (this.zqC != null) {
                    this.zqC.ae(10, 10);
                }
                AppMethodBeat.o(34031);
            }
        };
        aw.a(this.qbK);
        this.zqx = new c<jr>() {
            {
                AppMethodBeat.i(34032);
                this.xxI = jr.class.getName().hashCode();
                AppMethodBeat.o(34032);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34033);
                if (a.this.zqz.getVisibility() != 0) {
                    a.this.zqz.setVisibility(0);
                    a.this.zqA.setVisibility(8);
                }
                AppMethodBeat.o(34033);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(this.zqx);
        aw.ZK();
        com.tencent.mm.model.c.a(this);
        dIn();
        AppMethodBeat.o(34035);
    }

    public final void dIn() {
        AppMethodBeat.i(34036);
        if (this.context == null || !aw.RK()) {
            AppMethodBeat.o(34036);
            return;
        }
        ab.i("MicroMsg.BannerHelper", "updateBanner, :%d", Integer.valueOf(hashCode()));
        boolean m = m(this.zqr, true);
        boolean m2 = m(this.zqs, true);
        boolean m3 = m(this.zqt, true);
        int i = (m || m2 || m3 || m(this.zqu, true)) ? 1 : 0;
        if (m2) {
            fu(this.zqt);
            fu(this.zqu);
        } else if (m3) {
            fu(this.zqu);
        }
        LinkedList<com.tencent.mm.pluginsdk.ui.b.b> linkedList = new LinkedList();
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.zqw) {
            if (bVar != null) {
                View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
                if (childAt != null && childAt.getVisibility() == 0) {
                    bVar.nfA = false;
                    bVar.eVH = false;
                    linkedList.add(bVar);
                }
            }
        }
        if (linkedList.size() > 0) {
            ((com.tencent.mm.pluginsdk.ui.b.b) linkedList.getFirst()).nfA = true;
            ((com.tencent.mm.pluginsdk.ui.b.b) linkedList.getLast()).eVH = true;
            for (com.tencent.mm.pluginsdk.ui.b.b aMN : linkedList) {
                aMN.aMN();
            }
        }
        if (!(i == 0 || this.zqz.getVisibility() == 0)) {
            this.zqz.setVisibility(0);
            this.zqA.setVisibility(8);
        }
        for (com.tencent.mm.pluginsdk.ui.b.b aMN2 : this.zqv) {
            if (aMN2 != null) {
                aMN2.aMN();
            }
        }
        AppMethodBeat.o(34036);
    }

    public final void qj(String str) {
        AppMethodBeat.i(34037);
        if (aw.RK() && !aw.QT() && ah.nullAsNil(str).length() > 0 && str.equals(r.Yz())) {
            dIn();
        }
        AppMethodBeat.o(34037);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(34038);
        if (aw.RK()) {
            aw.ZK();
            if (nVar == com.tencent.mm.model.c.Ry()) {
                int bh = ah.bh(obj);
                if (8193 == bh) {
                    dIn();
                }
                if (42 == bh) {
                    dIn();
                }
            }
        }
        AppMethodBeat.o(34038);
    }

    public final void ZB() {
        AppMethodBeat.i(34039);
        dIn();
        AppMethodBeat.o(34039);
    }

    /* Access modifiers changed, original: final */
    public final void ft(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(34040);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.zqz.removeHeaderView(bVar.getView());
            }
        }
        AppMethodBeat.o(34040);
    }

    /* Access modifiers changed, original: final */
    public final boolean m(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        AppMethodBeat.i(34041);
        boolean z2 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            boolean z3;
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.aMN()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                ab.i(str, str2, objArr);
                if (z) {
                    z3 = true;
                } else {
                    AppMethodBeat.o(34041);
                    return true;
                }
            }
            if (childAt != null && childAt.getVisibility() == 0) {
                ab.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", bVar, Boolean.valueOf(z), Integer.valueOf(hashCode()));
            }
            z3 = z2;
            z2 = z3;
        }
        AppMethodBeat.o(34041);
        return z2;
    }

    private static void fu(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(34042);
        for (com.tencent.mm.pluginsdk.ui.b.b visibility : list) {
            visibility.setVisibility(8);
        }
        AppMethodBeat.o(34042);
    }

    static void fv(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(34043);
        for (com.tencent.mm.pluginsdk.ui.b.b release : list) {
            release.release();
        }
        AppMethodBeat.o(34043);
    }

    static void fw(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(34044);
        for (com.tencent.mm.pluginsdk.ui.b.b destroy : list) {
            destroy.destroy();
        }
        list.clear();
        AppMethodBeat.o(34044);
    }
}
