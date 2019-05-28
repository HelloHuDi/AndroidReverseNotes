package com.tencent.p177mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C26237rx;
import com.tencent.p177mm.p230g.p231a.C32636th;
import com.tencent.p177mm.p230g.p231a.C45372tj;
import com.tencent.p177mm.p230g.p231a.C9459ry;
import com.tencent.p177mm.p230g.p231a.C9461rz;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.p520ui.C46922l;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.model.ap */
public final class C13413ap {
    private static HashMap<String, C13414b> qMP = new HashMap();
    private static LinkedList<C13415a> qMQ = new LinkedList();
    private static C4884c qMR = new C71001();

    /* renamed from: com.tencent.mm.plugin.sns.model.ap$1 */
    static class C71001 extends C4884c<C45372tj> {
        C71001() {
            AppMethodBeat.m2504i(36610);
            this.xxI = C45372tj.class.getName().hashCode();
            AppMethodBeat.m2505o(36610);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i = 1;
            AppMethodBeat.m2504i(36611);
            C45372tj c45372tj = (C45372tj) c4883b;
            if (c45372tj instanceof C45372tj) {
                String str = c45372tj.cPF.f17878id;
                int i2 = c45372tj.cPF.type;
                C13415a dc = C13413ap.m21552dc(str, i2);
                if (dc != null) {
                    String str2 = c45372tj.cPF.cPG;
                    dc.qMT = str2;
                    dc.cNS = c45372tj.cPF.cNS;
                    String str3 = "MicroMsg.SnsTranslateManager";
                    String str4 = "finish translate, id:%s, type: %d, success: %b";
                    Object[] objArr = new Object[3];
                    objArr[0] = dc.f2920id;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Boolean.valueOf(!C5046bo.isNullOrNil(str2));
                    C4990ab.m7417i(str3, str4, objArr);
                    switch (i2) {
                        case 2:
                            break;
                        case 3:
                            i = 2;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    if (i != -1) {
                        C13413ap.m21554g(str, i, dc.qMT, dc.cNS);
                        C13413ap.qMQ.remove(dc);
                    }
                }
            }
            AppMethodBeat.m2505o(36611);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ap$b */
    public static class C13414b {
        public boolean aAR;
        public int dtW;
        public boolean foa;
        public String fwM;
        /* renamed from: id */
        public String f2919id;
        public boolean qMU;
        public boolean qMV;
        public String result;
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ap$a */
    static class C13415a {
        String cNS;
        /* renamed from: id */
        String f2920id;
        String qMS;
        String qMT;
        int type;

        private C13415a() {
        }

        /* synthetic */ C13415a(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(36612);
            if (obj instanceof C13415a) {
                C13415a c13415a = (C13415a) obj;
                if (this.f2920id.equals(c13415a.f2920id) && this.type == c13415a.type) {
                    AppMethodBeat.m2505o(36612);
                    return true;
                }
                AppMethodBeat.m2505o(36612);
                return false;
            }
            boolean equals = super.equals(obj);
            AppMethodBeat.m2505o(36612);
            return equals;
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m21554g(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(36632);
        C13413ap.m21553f(str, i, str2, str3);
        AppMethodBeat.m2505o(36632);
    }

    static {
        AppMethodBeat.m2504i(36633);
        AppMethodBeat.m2505o(36633);
    }

    public static void init() {
        AppMethodBeat.m2504i(36613);
        C4879a.xxA.mo10052c(qMR);
        AppMethodBeat.m2505o(36613);
    }

    public static void aon() {
        AppMethodBeat.m2504i(36614);
        C4879a.xxA.mo10053d(qMR);
        AppMethodBeat.m2505o(36614);
    }

    /* renamed from: Cj */
    private static boolean m21539Cj() {
        AppMethodBeat.m2504i(36615);
        if (C25985d.afj("translate")) {
            String value = C26373g.m41964Nu().getValue("TranslateSnsOff");
            if (C5046bo.isNullOrNil(value)) {
                AppMethodBeat.m2505o(36615);
                return true;
            } else if (C5046bo.ank(value) != 0) {
                AppMethodBeat.m2505o(36615);
                return false;
            } else {
                AppMethodBeat.m2505o(36615);
                return true;
            }
        }
        AppMethodBeat.m2505o(36615);
        return false;
    }

    /* renamed from: a */
    public static void m21541a(Menu menu, boolean z) {
        AppMethodBeat.m2504i(36616);
        if (C13413ap.m21539Cj()) {
            if (z) {
                menu.add(0, 14, 0, C25738R.string.eq5);
                AppMethodBeat.m2505o(36616);
                return;
            }
            menu.add(0, 15, 0, C25738R.string.eq5);
        }
        AppMethodBeat.m2505o(36616);
    }

    /* renamed from: b */
    public static void m21544b(Menu menu, boolean z) {
        AppMethodBeat.m2504i(36617);
        if (C13413ap.m21539Cj()) {
            if (z) {
                menu.add(0, 16, 0, C25738R.string.eq7);
                AppMethodBeat.m2505o(36617);
                return;
            }
            menu.add(0, 17, 0, C25738R.string.eq7);
        }
        AppMethodBeat.m2505o(36617);
    }

    /* renamed from: r */
    public static void m21556r(C46236n c46236n) {
        AppMethodBeat.m2504i(36618);
        if (c46236n != null) {
            String cqA = c46236n.cqA();
            C4990ab.m7411d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", cqA);
            if (c46236n.field_snsId == 0) {
                C4990ab.m7410d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                qMP.remove(cqA);
                C13413ap.m21553f(cqA, 1, null, null);
                AppMethodBeat.m2505o(36618);
                return;
            }
            if (qMP.containsKey(cqA)) {
                C13414b c13414b = (C13414b) qMP.get(cqA);
                if (!c13414b.foa || c13414b.aAR) {
                    qMP.remove(cqA);
                } else {
                    C4990ab.m7411d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", cqA);
                    C13413ap.m21553f(c13414b.f2919id, 1, c13414b.result, c13414b.fwM);
                    AppMethodBeat.m2505o(36618);
                    return;
                }
            }
            if (c46236n.cqu() != null) {
                String str = c46236n.cqu().xfF;
                C32636th c32636th = new C32636th();
                c32636th.cPy.f15020id = cqA;
                c32636th.cPy.cPz = str;
                c32636th.cPy.type = 2;
                C4879a.xxA.mo10055m(c32636th);
                C13413ap.m21548cY(c46236n.cqA(), 1);
                C13415a c13415a = new C13415a();
                c13415a.f2920id = cqA;
                c13415a.qMS = str;
                c13415a.type = 2;
                qMQ.add(c13415a);
            }
        }
        AppMethodBeat.m2505o(36618);
    }

    /* renamed from: a */
    public static void m21542a(C13414b c13414b) {
        AppMethodBeat.m2504i(36619);
        if ((c13414b.dtW & 2) != 0) {
            c13414b.qMU = false;
        } else if ((c13414b.dtW & 4) != 0) {
            c13414b.qMV = false;
        }
        qMP.put(c13414b.f2919id, c13414b);
        AppMethodBeat.m2505o(36619);
    }

    /* renamed from: b */
    private static void m21545b(C13414b c13414b) {
        AppMethodBeat.m2504i(36620);
        if ((c13414b.dtW & 2) != 0) {
            c13414b.qMU = true;
        } else if ((c13414b.dtW & 4) != 0) {
            c13414b.qMV = true;
        }
        qMP.put(c13414b.f2919id, c13414b);
        AppMethodBeat.m2505o(36620);
    }

    /* renamed from: s */
    public static void m21557s(C46236n c46236n) {
        AppMethodBeat.m2504i(36621);
        if (c46236n != null) {
            String cqA = c46236n.cqA();
            C13413ap.m21545b(C13413ap.m21540Ye(cqA));
            C9461rz c9461rz = new C9461rz();
            c9461rz.cNU.type = 1;
            c9461rz.cNU.f2864id = cqA;
            C4879a.xxA.mo10055m(c9461rz);
            C4990ab.m7411d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", cqA);
        }
        AppMethodBeat.m2505o(36621);
    }

    /* renamed from: a */
    public static void m21543a(C46922l c46922l) {
        AppMethodBeat.m2504i(36622);
        if (!(c46922l == null || c46922l.qJj == null)) {
            String str = c46922l.ncM;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
                AppMethodBeat.m2505o(36622);
                return;
            }
            long j;
            StringBuilder stringBuilder = new StringBuilder();
            if (c46922l.qJj.wZG != 0) {
                j = (long) c46922l.qJj.wZG;
            } else {
                j = c46922l.qJj.wZJ;
            }
            String ga = C13413ap.m21555ga(c46922l.rib, stringBuilder.append(j).toString());
            if (qMP.containsKey(ga)) {
                C13414b c13414b = (C13414b) qMP.get(ga);
                if (!c13414b.foa || C5046bo.isNullOrNil(c13414b.result)) {
                    qMP.remove(ga);
                } else {
                    C4990ab.m7411d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", ga);
                    C13413ap.m21553f(c13414b.f2919id, 2, c13414b.result, c13414b.fwM);
                    AppMethodBeat.m2505o(36622);
                    return;
                }
            }
            C32636th c32636th = new C32636th();
            c32636th.cPy.f15020id = ga;
            c32636th.cPy.cPz = str;
            c32636th.cPy.type = 3;
            C4879a.xxA.mo10055m(c32636th);
            C13413ap.m21548cY(ga, 2);
            C13415a c13415a = new C13415a();
            c13415a.f2920id = ga;
            c13415a.qMS = str;
            c13415a.type = 3;
            qMQ.add(c13415a);
            C4990ab.m7411d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", c13415a.f2920id);
        }
        AppMethodBeat.m2505o(36622);
    }

    /* renamed from: b */
    public static void m21546b(C46922l c46922l) {
        AppMethodBeat.m2504i(36623);
        if (c46922l != null) {
            String ga = C13413ap.m21555ga(c46922l.rib, (c46922l.qJj.wZG != 0 ? (long) c46922l.qJj.wZG : c46922l.qJj.wZJ));
            C13413ap.m21545b(C13413ap.m21540Ye(ga));
            C9461rz c9461rz = new C9461rz();
            c9461rz.cNU.type = 2;
            c9461rz.cNU.f2864id = ga;
            C4879a.xxA.mo10055m(c9461rz);
            C4990ab.m7411d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", ga);
        }
        AppMethodBeat.m2505o(36623);
    }

    /* renamed from: cY */
    private static void m21548cY(String str, int i) {
        AppMethodBeat.m2504i(36624);
        if (!qMP.containsKey(str)) {
            C13414b c13414b = new C13414b();
            c13414b.f2919id = str;
            c13414b.fwM = null;
            c13414b.result = null;
            c13414b.foa = false;
            c13414b.aAR = false;
            c13414b.qMV = true;
            c13414b.qMU = true;
            qMP.put(str, c13414b);
        }
        C9459ry c9459ry = new C9459ry();
        c9459ry.cNT.type = i;
        c9459ry.cNT.f2863id = str;
        C4879a.xxA.mo10055m(c9459ry);
        AppMethodBeat.m2505o(36624);
    }

    /* renamed from: f */
    private static void m21553f(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(36625);
        if (qMP.containsKey(str)) {
            C13414b c13414b = (C13414b) qMP.get(str);
            c13414b.fwM = str3;
            c13414b.result = str2;
            c13414b.foa = true;
            c13414b.aAR = C5046bo.isNullOrNil(str2);
            qMP.put(str, c13414b);
        }
        if (C5046bo.isNullOrNil(str2)) {
            Toast.makeText(C4996ah.getContext(), C25738R.string.eq6, 1).show();
        }
        C26237rx c26237rx = new C26237rx();
        c26237rx.cNR.type = i;
        c26237rx.cNR.f13666id = str;
        c26237rx.cNR.result = str2;
        c26237rx.cNR.cNS = str3;
        C4879a.xxA.mo10055m(c26237rx);
        AppMethodBeat.m2505o(36625);
    }

    /* renamed from: ga */
    public static String m21555ga(String str, String str2) {
        AppMethodBeat.m2504i(36626);
        String str3 = str + ";" + str2;
        AppMethodBeat.m2505o(36626);
        return str3;
    }

    public static HashMap<String, C13414b> coh() {
        return qMP;
    }

    /* renamed from: cZ */
    public static void m21549cZ(String str, int i) {
        AppMethodBeat.m2504i(36627);
        if (qMP.containsKey(str)) {
            C13414b c13414b = (C13414b) qMP.get(str);
            c13414b.dtW |= i;
            qMP.put(str, c13414b);
        }
        AppMethodBeat.m2505o(36627);
    }

    /* renamed from: da */
    public static void m21550da(String str, int i) {
        AppMethodBeat.m2504i(36628);
        if (qMP.containsKey(str)) {
            C13414b c13414b = (C13414b) qMP.get(str);
            c13414b.dtW &= i ^ -1;
            if (i != 2 && i == 4) {
                c13414b.qMV = true;
            }
            qMP.put(str, c13414b);
        }
        AppMethodBeat.m2505o(36628);
    }

    /* renamed from: db */
    public static boolean m21551db(String str, int i) {
        AppMethodBeat.m2504i(36629);
        if (!qMP.containsKey(str)) {
            AppMethodBeat.m2505o(36629);
            return false;
        } else if ((((C13414b) qMP.get(str)).dtW & i) != 0) {
            AppMethodBeat.m2505o(36629);
            return true;
        } else {
            AppMethodBeat.m2505o(36629);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m21547c(C13414b c13414b) {
        if (c13414b == null || (c13414b.dtW & 2) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: Ye */
    public static C13414b m21540Ye(String str) {
        AppMethodBeat.m2504i(36630);
        if (qMP.containsKey(str)) {
            C13414b c13414b = (C13414b) qMP.get(str);
            AppMethodBeat.m2505o(36630);
            return c13414b;
        }
        AppMethodBeat.m2505o(36630);
        return null;
    }

    /* renamed from: dc */
    static /* synthetic */ C13415a m21552dc(String str, int i) {
        AppMethodBeat.m2504i(36631);
        Iterator it = qMQ.iterator();
        while (it.hasNext()) {
            C13415a c13415a = (C13415a) it.next();
            if (c13415a.type == i && !C5046bo.isNullOrNil(str) && !C5046bo.isNullOrNil(c13415a.f2920id) && str.equals(c13415a.f2920id)) {
                AppMethodBeat.m2505o(36631);
                return c13415a;
            }
        }
        AppMethodBeat.m2505o(36631);
        return null;
    }
}
