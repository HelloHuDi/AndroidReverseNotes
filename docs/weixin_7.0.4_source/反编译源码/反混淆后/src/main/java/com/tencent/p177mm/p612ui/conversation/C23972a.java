package com.tencent.p177mm.p612ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p871b.C45437b.C9646b;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p230g.p231a.C26083af;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.p230g.p231a.C37747jr;
import com.tencent.p177mm.p612ui.conversation.p626a.C36257a;
import com.tencent.p177mm.p612ui.conversation.p626a.C36263j;
import com.tencent.p177mm.p612ui.conversation.p626a.C46680q;
import com.tencent.p177mm.p612ui.conversation.p626a.C5477e;
import com.tencent.p177mm.p612ui.conversation.p626a.C5477e.C5479a;
import com.tencent.p177mm.p612ui.p1093d.C24001a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.conversation.a */
public final class C23972a implements C8915a, C1815as, C4937b {
    Context context;
    C1923n qbK;
    View zqA;
    List<C14933b> zqr = new LinkedList();
    List<C14933b> zqs = new LinkedList();
    List<C14933b> zqt = new LinkedList();
    List<C14933b> zqu = new LinkedList();
    List<C14933b> zqv = new LinkedList();
    List<C14933b> zqw = new LinkedList();
    C4884c zqx;
    C4884c zqy;
    ListView zqz;

    /* renamed from: com.tencent.mm.ui.conversation.a$3 */
    class C158583 extends C1924a {
        private final C7564ap zqC = new C7564ap(new C158571(), false);

        /* renamed from: com.tencent.mm.ui.conversation.a$3$1 */
        class C158571 implements C5015a {
            C158571() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(34029);
                C23972a.this.dIn();
                AppMethodBeat.m2505o(34029);
                return false;
            }
        }

        C158583() {
            AppMethodBeat.m2504i(34030);
            AppMethodBeat.m2505o(34030);
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(34031);
            if (this.zqC != null) {
                this.zqC.mo16770ae(10, 10);
            }
            AppMethodBeat.m2505o(34031);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a$2 */
    class C239732 implements Comparator<C14933b> {
        C239732() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(34028);
            int order = ((C14933b) obj2).getOrder() - ((C14933b) obj).getOrder();
            AppMethodBeat.m2505o(34028);
            return order;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a$4 */
    class C239744 extends C4884c<C37747jr> {
        C239744() {
            AppMethodBeat.m2504i(34032);
            this.xxI = C37747jr.class.getName().hashCode();
            AppMethodBeat.m2505o(34032);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34033);
            if (C23972a.this.zqz.getVisibility() != 0) {
                C23972a.this.zqz.setVisibility(0);
                C23972a.this.zqA.setVisibility(8);
            }
            AppMethodBeat.m2505o(34033);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a$1 */
    class C239751 extends C4884c<C26083af> {
        C239751() {
            AppMethodBeat.m2504i(34026);
            this.xxI = C26083af.class.getName().hashCode();
            AppMethodBeat.m2505o(34026);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34027);
            C26083af c26083af = (C26083af) c4883b;
            C14933b c14933b = c26083af.csZ.ctb;
            if (c14933b != null && c14933b.getView() != null) {
                C4990ab.m7417i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", c14933b, Integer.valueOf(C23972a.this.hashCode()));
                if (!c26083af.csZ.cta) {
                    switch (c26083af.csZ.level) {
                        case 1:
                            C23972a.this.zqs.add(c14933b);
                            break;
                        case 2:
                            C23972a.this.zqt.add(c14933b);
                            break;
                        default:
                            C23972a.this.zqu.add(c14933b);
                            break;
                    }
                }
                C23972a.this.zqr.add(c14933b);
            } else {
                C4990ab.m7421w("MicroMsg.BannerHelper", "banner is null, event:%s", c26083af);
            }
            AppMethodBeat.m2505o(34027);
            return false;
        }
    }

    public C23972a() {
        AppMethodBeat.m2504i(34034);
        AppMethodBeat.m2505o(34034);
    }

    /* renamed from: a */
    public final void mo39773a(Context context, ListView listView, View view) {
        AppMethodBeat.m2504i(34035);
        this.context = context;
        this.zqz = listView;
        this.zqA = view;
        this.zqy = new C239751();
        C4879a.xxA.mo10052c(this.zqy);
        C32512ae c32512ae = new C32512ae();
        c32512ae.csY.activity = (Activity) context;
        C4879a.xxA.mo10055m(c32512ae);
        C26083af c26083af = new C26083af();
        c26083af.csZ.ctb = (C14933b) C5477e.m8281a(this.context, C5479a.MAIN_FRAME_AND_ABTEST_BANNER, null);
        C4879a.xxA.mo10055m(c26083af);
        C14933b c14933b = (C14933b) C5477e.m8281a(this.context, C5479a.NET_WARN_BANNER, null);
        c26083af = new C26083af();
        c26083af.csZ.ctb = c14933b;
        c26083af.csZ.level = 1;
        C4879a.xxA.mo10055m(c26083af);
        c14933b = (C14933b) C5477e.m8281a(this.context, C5479a.OTHER_ONLINE_BANNER, null);
        c26083af = new C26083af();
        c26083af.csZ.ctb = c14933b;
        c26083af.csZ.cta = false;
        c26083af.csZ.level = 1;
        C4879a.xxA.mo10055m(c26083af);
        C46680q c46680q = (C46680q) C5477e.m8281a(this.context, C5479a.TRY_NEW_INIT_BANNER, null);
        c26083af = new C26083af();
        c26083af.csZ.ctb = c46680q;
        c26083af.csZ.cta = false;
        c26083af.csZ.level = 2;
        C4879a.xxA.mo10055m(c26083af);
        C36257a c36257a = (C36257a) C5477e.m8281a(this.context, C5479a.AD_BANNER, null);
        c26083af = new C26083af();
        c26083af.csZ.ctb = c36257a;
        c26083af.csZ.cta = false;
        c26083af.csZ.level = 3;
        C4879a.xxA.mo10055m(c26083af);
        C24001a c24001a = (C24001a) C5477e.m8281a(this.context, C5479a.CHATTING_MONITORED_HINT, new Object[]{C9646b.Main});
        c26083af = new C26083af();
        c26083af.csZ.ctb = c24001a;
        c26083af.csZ.cta = true;
        C4879a.xxA.mo10055m(c26083af);
        c14933b = (C14933b) C5477e.m8281a(this.context, C5479a.FORCE_NOTIFY_BANNER, null);
        c26083af = new C26083af();
        c26083af.csZ.ctb = c14933b;
        c26083af.csZ.cta = false;
        c26083af.csZ.level = 1;
        C4879a.xxA.mo10055m(c26083af);
        C4879a.xxA.mo10053d(this.zqy);
        this.zqw.addAll(this.zqr);
        this.zqw.addAll(this.zqs);
        this.zqw.addAll(this.zqt);
        this.zqw.addAll(this.zqu);
        Collections.sort(this.zqw, new C239732());
        for (C14933b c14933b2 : this.zqw) {
            this.zqz.addHeaderView(c14933b2.getView());
        }
        LinkedList linkedList = new LinkedList();
        c14933b2 = (C14933b) C5477e.m8281a(context, C5479a.FACEBOOK_BANNER, null);
        if (!(c14933b2 == null || c14933b2.getView() == null)) {
            listView.addFooterView(c14933b2.getView());
        }
        this.zqv.add(c14933b2);
        listView.addFooterView(new C36263j(context).getView(), null, true);
        this.zqv.add(c14933b2);
        this.qbK = new C158583();
        C9638aw.m17198a(this.qbK);
        this.zqx = new C239744();
        C4879a.xxA.mo10052c(this.zqx);
        C9638aw.m17190ZK();
        C18628c.m29103a(this);
        dIn();
        AppMethodBeat.m2505o(34035);
    }

    public final void dIn() {
        AppMethodBeat.m2504i(34036);
        if (this.context == null || !C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(34036);
            return;
        }
        C4990ab.m7417i("MicroMsg.BannerHelper", "updateBanner, :%d", Integer.valueOf(hashCode()));
        boolean m = mo39776m(this.zqr, true);
        boolean m2 = mo39776m(this.zqs, true);
        boolean m3 = mo39776m(this.zqt, true);
        int i = (m || m2 || m3 || mo39776m(this.zqu, true)) ? 1 : 0;
        if (m2) {
            C23972a.m36946fu(this.zqt);
            C23972a.m36946fu(this.zqu);
        } else if (m3) {
            C23972a.m36946fu(this.zqu);
        }
        LinkedList<C14933b> linkedList = new LinkedList();
        for (C14933b c14933b : this.zqw) {
            if (c14933b != null) {
                View childAt = ((ViewGroup) c14933b.getView()).getChildAt(0);
                if (childAt != null && childAt.getVisibility() == 0) {
                    c14933b.nfA = false;
                    c14933b.eVH = false;
                    linkedList.add(c14933b);
                }
            }
        }
        if (linkedList.size() > 0) {
            ((C14933b) linkedList.getFirst()).nfA = true;
            ((C14933b) linkedList.getLast()).eVH = true;
            for (C14933b aMN : linkedList) {
                aMN.aMN();
            }
        }
        if (!(i == 0 || this.zqz.getVisibility() == 0)) {
            this.zqz.setVisibility(0);
            this.zqA.setVisibility(8);
        }
        for (C14933b aMN2 : this.zqv) {
            if (aMN2 != null) {
                aMN2.aMN();
            }
        }
        AppMethodBeat.m2505o(34036);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(34037);
        if (C9638aw.m17179RK() && !C9638aw.m17178QT() && C42252ah.nullAsNil(str).length() > 0 && str.equals(C1853r.m3846Yz())) {
            dIn();
        }
        AppMethodBeat.m2505o(34037);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(34038);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            if (c7298n == C18628c.m29072Ry()) {
                int bh = C42252ah.m74609bh(obj);
                if (8193 == bh) {
                    dIn();
                }
                if (42 == bh) {
                    dIn();
                }
            }
        }
        AppMethodBeat.m2505o(34038);
    }

    /* renamed from: ZB */
    public final void mo5390ZB() {
        AppMethodBeat.m2504i(34039);
        dIn();
        AppMethodBeat.m2505o(34039);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ft */
    public final void mo39775ft(List<C14933b> list) {
        AppMethodBeat.m2504i(34040);
        for (C14933b c14933b : list) {
            if (c14933b.getView() != null) {
                this.zqz.removeHeaderView(c14933b.getView());
            }
        }
        AppMethodBeat.m2505o(34040);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: m */
    public final boolean mo39776m(List<C14933b> list, boolean z) {
        AppMethodBeat.m2504i(34041);
        boolean z2 = false;
        for (C14933b c14933b : list) {
            boolean z3;
            View childAt = ((ViewGroup) c14933b.getView()).getChildAt(0);
            if (c14933b.aMN()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = c14933b;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                C4990ab.m7417i(str, str2, objArr);
                if (z) {
                    z3 = true;
                } else {
                    AppMethodBeat.m2505o(34041);
                    return true;
                }
            }
            if (childAt != null && childAt.getVisibility() == 0) {
                C4990ab.m7417i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", c14933b, Boolean.valueOf(z), Integer.valueOf(hashCode()));
            }
            z3 = z2;
            z2 = z3;
        }
        AppMethodBeat.m2505o(34041);
        return z2;
    }

    /* renamed from: fu */
    private static void m36946fu(List<C14933b> list) {
        AppMethodBeat.m2504i(34042);
        for (C14933b visibility : list) {
            visibility.setVisibility(8);
        }
        AppMethodBeat.m2505o(34042);
    }

    /* renamed from: fv */
    static void m36947fv(List<C14933b> list) {
        AppMethodBeat.m2504i(34043);
        for (C14933b release : list) {
            release.release();
        }
        AppMethodBeat.m2505o(34043);
    }

    /* renamed from: fw */
    static void m36948fw(List<C14933b> list) {
        AppMethodBeat.m2504i(34044);
        for (C14933b destroy : list) {
            destroy.destroy();
        }
        list.clear();
        AppMethodBeat.m2505o(34044);
    }
}
