package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap {
    private static HashMap<String, b> qMP = new HashMap();
    private static LinkedList<a> qMQ = new LinkedList();
    private static c qMR = new c<tj>() {
        {
            AppMethodBeat.i(36610);
            this.xxI = tj.class.getName().hashCode();
            AppMethodBeat.o(36610);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 1;
            AppMethodBeat.i(36611);
            tj tjVar = (tj) bVar;
            if (tjVar instanceof tj) {
                String str = tjVar.cPF.id;
                int i2 = tjVar.cPF.type;
                a dc = ap.dc(str, i2);
                if (dc != null) {
                    String str2 = tjVar.cPF.cPG;
                    dc.qMT = str2;
                    dc.cNS = tjVar.cPF.cNS;
                    String str3 = "MicroMsg.SnsTranslateManager";
                    String str4 = "finish translate, id:%s, type: %d, success: %b";
                    Object[] objArr = new Object[3];
                    objArr[0] = dc.id;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Boolean.valueOf(!bo.isNullOrNil(str2));
                    ab.i(str3, str4, objArr);
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
                        ap.g(str, i, dc.qMT, dc.cNS);
                        ap.qMQ.remove(dc);
                    }
                }
            }
            AppMethodBeat.o(36611);
            return false;
        }
    };

    public static class b {
        public boolean aAR;
        public int dtW;
        public boolean foa;
        public String fwM;
        public String id;
        public boolean qMU;
        public boolean qMV;
        public String result;
    }

    static class a {
        String cNS;
        String id;
        String qMS;
        String qMT;
        int type;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(36612);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.id.equals(aVar.id) && this.type == aVar.type) {
                    AppMethodBeat.o(36612);
                    return true;
                }
                AppMethodBeat.o(36612);
                return false;
            }
            boolean equals = super.equals(obj);
            AppMethodBeat.o(36612);
            return equals;
        }
    }

    static /* synthetic */ void g(String str, int i, String str2, String str3) {
        AppMethodBeat.i(36632);
        f(str, i, str2, str3);
        AppMethodBeat.o(36632);
    }

    static {
        AppMethodBeat.i(36633);
        AppMethodBeat.o(36633);
    }

    public static void init() {
        AppMethodBeat.i(36613);
        com.tencent.mm.sdk.b.a.xxA.c(qMR);
        AppMethodBeat.o(36613);
    }

    public static void aon() {
        AppMethodBeat.i(36614);
        com.tencent.mm.sdk.b.a.xxA.d(qMR);
        AppMethodBeat.o(36614);
    }

    private static boolean Cj() {
        AppMethodBeat.i(36615);
        if (d.afj("translate")) {
            String value = g.Nu().getValue("TranslateSnsOff");
            if (bo.isNullOrNil(value)) {
                AppMethodBeat.o(36615);
                return true;
            } else if (bo.ank(value) != 0) {
                AppMethodBeat.o(36615);
                return false;
            } else {
                AppMethodBeat.o(36615);
                return true;
            }
        }
        AppMethodBeat.o(36615);
        return false;
    }

    public static void a(Menu menu, boolean z) {
        AppMethodBeat.i(36616);
        if (Cj()) {
            if (z) {
                menu.add(0, 14, 0, R.string.eq5);
                AppMethodBeat.o(36616);
                return;
            }
            menu.add(0, 15, 0, R.string.eq5);
        }
        AppMethodBeat.o(36616);
    }

    public static void b(Menu menu, boolean z) {
        AppMethodBeat.i(36617);
        if (Cj()) {
            if (z) {
                menu.add(0, 16, 0, R.string.eq7);
                AppMethodBeat.o(36617);
                return;
            }
            menu.add(0, 17, 0, R.string.eq7);
        }
        AppMethodBeat.o(36617);
    }

    public static void r(n nVar) {
        AppMethodBeat.i(36618);
        if (nVar != null) {
            String cqA = nVar.cqA();
            ab.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", cqA);
            if (nVar.field_snsId == 0) {
                ab.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                qMP.remove(cqA);
                f(cqA, 1, null, null);
                AppMethodBeat.o(36618);
                return;
            }
            if (qMP.containsKey(cqA)) {
                b bVar = (b) qMP.get(cqA);
                if (!bVar.foa || bVar.aAR) {
                    qMP.remove(cqA);
                } else {
                    ab.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", cqA);
                    f(bVar.id, 1, bVar.result, bVar.fwM);
                    AppMethodBeat.o(36618);
                    return;
                }
            }
            if (nVar.cqu() != null) {
                String str = nVar.cqu().xfF;
                th thVar = new th();
                thVar.cPy.id = cqA;
                thVar.cPy.cPz = str;
                thVar.cPy.type = 2;
                com.tencent.mm.sdk.b.a.xxA.m(thVar);
                cY(nVar.cqA(), 1);
                a aVar = new a();
                aVar.id = cqA;
                aVar.qMS = str;
                aVar.type = 2;
                qMQ.add(aVar);
            }
        }
        AppMethodBeat.o(36618);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(36619);
        if ((bVar.dtW & 2) != 0) {
            bVar.qMU = false;
        } else if ((bVar.dtW & 4) != 0) {
            bVar.qMV = false;
        }
        qMP.put(bVar.id, bVar);
        AppMethodBeat.o(36619);
    }

    private static void b(b bVar) {
        AppMethodBeat.i(36620);
        if ((bVar.dtW & 2) != 0) {
            bVar.qMU = true;
        } else if ((bVar.dtW & 4) != 0) {
            bVar.qMV = true;
        }
        qMP.put(bVar.id, bVar);
        AppMethodBeat.o(36620);
    }

    public static void s(n nVar) {
        AppMethodBeat.i(36621);
        if (nVar != null) {
            String cqA = nVar.cqA();
            b(Ye(cqA));
            rz rzVar = new rz();
            rzVar.cNU.type = 1;
            rzVar.cNU.id = cqA;
            com.tencent.mm.sdk.b.a.xxA.m(rzVar);
            ab.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", cqA);
        }
        AppMethodBeat.o(36621);
    }

    public static void a(l lVar) {
        AppMethodBeat.i(36622);
        if (!(lVar == null || lVar.qJj == null)) {
            String str = lVar.ncM;
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
                AppMethodBeat.o(36622);
                return;
            }
            long j;
            StringBuilder stringBuilder = new StringBuilder();
            if (lVar.qJj.wZG != 0) {
                j = (long) lVar.qJj.wZG;
            } else {
                j = lVar.qJj.wZJ;
            }
            String ga = ga(lVar.rib, stringBuilder.append(j).toString());
            if (qMP.containsKey(ga)) {
                b bVar = (b) qMP.get(ga);
                if (!bVar.foa || bo.isNullOrNil(bVar.result)) {
                    qMP.remove(ga);
                } else {
                    ab.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", ga);
                    f(bVar.id, 2, bVar.result, bVar.fwM);
                    AppMethodBeat.o(36622);
                    return;
                }
            }
            th thVar = new th();
            thVar.cPy.id = ga;
            thVar.cPy.cPz = str;
            thVar.cPy.type = 3;
            com.tencent.mm.sdk.b.a.xxA.m(thVar);
            cY(ga, 2);
            a aVar = new a();
            aVar.id = ga;
            aVar.qMS = str;
            aVar.type = 3;
            qMQ.add(aVar);
            ab.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", aVar.id);
        }
        AppMethodBeat.o(36622);
    }

    public static void b(l lVar) {
        AppMethodBeat.i(36623);
        if (lVar != null) {
            String ga = ga(lVar.rib, (lVar.qJj.wZG != 0 ? (long) lVar.qJj.wZG : lVar.qJj.wZJ));
            b(Ye(ga));
            rz rzVar = new rz();
            rzVar.cNU.type = 2;
            rzVar.cNU.id = ga;
            com.tencent.mm.sdk.b.a.xxA.m(rzVar);
            ab.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", ga);
        }
        AppMethodBeat.o(36623);
    }

    private static void cY(String str, int i) {
        AppMethodBeat.i(36624);
        if (!qMP.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.fwM = null;
            bVar.result = null;
            bVar.foa = false;
            bVar.aAR = false;
            bVar.qMV = true;
            bVar.qMU = true;
            qMP.put(str, bVar);
        }
        ry ryVar = new ry();
        ryVar.cNT.type = i;
        ryVar.cNT.id = str;
        com.tencent.mm.sdk.b.a.xxA.m(ryVar);
        AppMethodBeat.o(36624);
    }

    private static void f(String str, int i, String str2, String str3) {
        AppMethodBeat.i(36625);
        if (qMP.containsKey(str)) {
            b bVar = (b) qMP.get(str);
            bVar.fwM = str3;
            bVar.result = str2;
            bVar.foa = true;
            bVar.aAR = bo.isNullOrNil(str2);
            qMP.put(str, bVar);
        }
        if (bo.isNullOrNil(str2)) {
            Toast.makeText(ah.getContext(), R.string.eq6, 1).show();
        }
        rx rxVar = new rx();
        rxVar.cNR.type = i;
        rxVar.cNR.id = str;
        rxVar.cNR.result = str2;
        rxVar.cNR.cNS = str3;
        com.tencent.mm.sdk.b.a.xxA.m(rxVar);
        AppMethodBeat.o(36625);
    }

    public static String ga(String str, String str2) {
        AppMethodBeat.i(36626);
        String str3 = str + ";" + str2;
        AppMethodBeat.o(36626);
        return str3;
    }

    public static HashMap<String, b> coh() {
        return qMP;
    }

    public static void cZ(String str, int i) {
        AppMethodBeat.i(36627);
        if (qMP.containsKey(str)) {
            b bVar = (b) qMP.get(str);
            bVar.dtW |= i;
            qMP.put(str, bVar);
        }
        AppMethodBeat.o(36627);
    }

    public static void da(String str, int i) {
        AppMethodBeat.i(36628);
        if (qMP.containsKey(str)) {
            b bVar = (b) qMP.get(str);
            bVar.dtW &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.qMV = true;
            }
            qMP.put(str, bVar);
        }
        AppMethodBeat.o(36628);
    }

    public static boolean db(String str, int i) {
        AppMethodBeat.i(36629);
        if (!qMP.containsKey(str)) {
            AppMethodBeat.o(36629);
            return false;
        } else if ((((b) qMP.get(str)).dtW & i) != 0) {
            AppMethodBeat.o(36629);
            return true;
        } else {
            AppMethodBeat.o(36629);
            return false;
        }
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.dtW & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b Ye(String str) {
        AppMethodBeat.i(36630);
        if (qMP.containsKey(str)) {
            b bVar = (b) qMP.get(str);
            AppMethodBeat.o(36630);
            return bVar;
        }
        AppMethodBeat.o(36630);
        return null;
    }

    static /* synthetic */ a dc(String str, int i) {
        AppMethodBeat.i(36631);
        Iterator it = qMQ.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !bo.isNullOrNil(str) && !bo.isNullOrNil(aVar.id) && str.equals(aVar.id)) {
                AppMethodBeat.o(36631);
                return aVar;
            }
        }
        AppMethodBeat.o(36631);
        return null;
    }
}
