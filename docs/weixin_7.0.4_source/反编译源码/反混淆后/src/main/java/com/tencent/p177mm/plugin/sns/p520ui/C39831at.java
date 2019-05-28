package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.at */
public final class C39831at extends C35120d<C46236n> {
    private boolean czr = false;
    private String lQD = "";
    List<C46236n> list = new ArrayList();
    private Comparator<C46236n> qHx = new C220681();
    private int rgh = 0;
    private int rgi = 0;
    private boolean rwo = false;
    private C39832b rwp;
    private C39830a rwq;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.at$1 */
    class C220681 implements Comparator<C46236n> {
        C220681() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C46236n c46236n = (C46236n) obj;
            C46236n c46236n2 = (C46236n) obj2;
            if (c46236n.reX == -1) {
                return -1;
            }
            if (c46236n2.reX == -1) {
                return 1;
            }
            if (c46236n.field_head != c46236n2.field_head) {
                return c46236n2.field_head - c46236n.field_head;
            }
            if (c46236n.field_createTime != c46236n2.field_createTime) {
                return c46236n2.field_createTime - c46236n.field_createTime;
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.at$a */
    class C39830a {
        public int rwA = -1;
        int rwB = 0;
        public boolean rwC = false;
        public int rwD = -1;
        public boolean rwE = false;
        public int rwF = -1;
        int rwG = 0;
        public int rws = -1;
        public int rwt = -1;
        public boolean rwu = false;
        public int rwv = -1;
        int rww = 0;
        public String rwx = "";
        public String rwy = "";
        public String rwz = "";

        C39830a() {
        }

        /* renamed from: Ee */
        public static boolean m68218Ee(int i) {
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 15:
                case 18:
                case 26:
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.at$b */
    public interface C39832b {
        /* renamed from: a */
        void mo25836a(List<C46236n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void ctL();
    }

    public C39831at(C39832b c39832b, String str, boolean z) {
        AppMethodBeat.m2504i(39233);
        this.rwp = c39832b;
        this.userName = str;
        this.czr = z;
        AppMethodBeat.m2505o(39233);
    }

    /* renamed from: dq */
    public final void mo55749dq(List<C46236n> list) {
        AppMethodBeat.m2504i(39234);
        if (this.rwp != null) {
            if (list != null) {
                m68221c(true, list);
            }
            this.rwp.ctL();
        }
        AppMethodBeat.m2505o(39234);
    }

    /* renamed from: Kx */
    public final List<C46236n> mo55747Kx() {
        AppMethodBeat.m2504i(39235);
        C4990ab.m7417i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(C34955aj.m57396a(this.userName, this.czr, this.lQD, this.rwo).size()));
        AppMethodBeat.m2505o(39235);
        return C34955aj.m57396a(this.userName, this.czr, this.lQD, this.rwo);
    }

    public final void ctM() {
        AppMethodBeat.m2504i(39236);
        Collections.sort(this.list, this.qHx);
        AppMethodBeat.m2505o(39236);
    }

    /* Access modifiers changed, original: final */
    public final void ctN() {
        AppMethodBeat.m2504i(39237);
        m68221c(false, this.list);
        AppMethodBeat.m2505o(39237);
    }

    /* renamed from: g */
    public final void mo63020g(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(39238);
        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(str)));
        this.lQD = str;
        this.rwo = z;
        mo55750hM(z2);
        AppMethodBeat.m2505o(39238);
    }

    /* renamed from: fz */
    private int m68222fz(int i, int i2) {
        int i3 = 0;
        if (this.czr && i == 0) {
            return 0;
        }
        if (i2 > 0 && this.rwq.rwA == 1) {
            i3 = 1;
        }
        if (i2 >= 2 && this.rwq.rwv == 1) {
            i3++;
        }
        if (i2 < 3 || this.rwq.rwF != 1) {
            return i3;
        }
        return i3 + 1;
    }

    /* renamed from: a */
    private int m68219a(int i, int i2, List<C46236n> list) {
        boolean z = true;
        AppMethodBeat.m2504i(39239);
        C39830a c39830a = this.rwq;
        c39830a.rwt = -1;
        c39830a.rwD = -1;
        c39830a.rws = -1;
        c39830a.rwx = "";
        c39830a.rwy = "";
        c39830a.rwz = "";
        c39830a.rwC = false;
        c39830a.rwu = false;
        c39830a.rwE = false;
        c39830a.rwF = -1;
        c39830a.rwv = -1;
        c39830a.rwA = -1;
        c39830a.rwB = 0;
        c39830a.rww = 0;
        c39830a.rwG = 0;
        if (this.czr && i == 0) {
            AppMethodBeat.m2505o(39239);
            return 1;
        }
        C46236n c46236n;
        TimeLineObject cqu;
        boolean z2;
        if (i + 1 < i2) {
            c46236n = (C46236n) list.get(i + 1);
            this.rwq.rwt = c46236n.field_head;
            cqu = c46236n.cqu();
            this.rwq.rwx = cqu.xfF;
            this.rwq.rwu = C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
            this.rwq.rwv = c46236n.field_type;
            if (cqu.xfI != null) {
                this.rwq.rww = cqu.xfI.wbK.size();
            } else {
                this.rwq.rww = 0;
            }
        }
        if (i + 2 < i2) {
            c46236n = (C46236n) list.get(i + 2);
            this.rwq.rwD = c46236n.field_head;
            cqu = c46236n.cqu();
            this.rwq.rwy = cqu.xfF;
            this.rwq.rwE = C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
            this.rwq.rwF = c46236n.field_type;
            if (cqu.xfI != null) {
                this.rwq.rwG = cqu.xfI.wbK.size();
            } else {
                this.rwq.rwG = 0;
            }
        }
        c46236n = (C46236n) list.get(i);
        this.rwq.rws = c46236n.field_head;
        cqu = c46236n.cqu();
        this.rwq.rwz = cqu.xfF;
        this.rwq.rwA = c46236n.field_type;
        this.rwq.rwC = C34955aj.m57399ab(c46236n.field_localPrivate, this.czr);
        if (cqu.xfI != null) {
            this.rwq.rwB = cqu.xfI.wbK.size();
        } else {
            this.rwq.rwB = 0;
        }
        c39830a = this.rwq;
        if (c39830a.rwA == 2) {
            z2 = true;
        } else if (c39830a.rwt == -1) {
            z2 = true;
        } else if (c39830a.rwA != c39830a.rwv) {
            z2 = true;
        } else if (C39830a.m68218Ee(c39830a.rwA)) {
            z2 = true;
        } else if (C39830a.m68218Ee(c39830a.rwv)) {
            z2 = true;
        } else if (c39830a.rwB > 1 || c39830a.rww > 1) {
            z2 = true;
        } else if (c39830a.rwz != null && !c39830a.rwz.equals("")) {
            z2 = true;
        } else if (c39830a.rwx != null && !c39830a.rwx.equals("")) {
            z2 = true;
        } else if (c39830a.rws != c39830a.rwt) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.m2505o(39239);
            return 1;
        }
        c39830a = this.rwq;
        if (c39830a.rwD != -1 && c39830a.rwv == c39830a.rwF && !C39830a.m68218Ee(c39830a.rwF) && c39830a.rwG <= 1 && ((c39830a.rwy == null || c39830a.rwy.equals("")) && c39830a.rwt == c39830a.rwD)) {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(39239);
            return 2;
        }
        AppMethodBeat.m2505o(39239);
        return 3;
    }

    /* renamed from: b */
    private void m68220b(boolean z, List<C46236n> list) {
        AppMethodBeat.m2504i(39240);
        if (z) {
            if (this.czr) {
                C46236n c46236n = new C46236n((byte) 0);
                c46236n.field_snsId = 0;
                c46236n.reX = -1;
                c46236n.mo74294ls((int) (System.currentTimeMillis() / 1000));
                list.add(0, c46236n);
            }
            AppMethodBeat.m2505o(39240);
            return;
        }
        AppMethodBeat.m2505o(39240);
    }

    /* renamed from: c */
    private void m68221c(boolean z, List<C46236n> list) {
        AppMethodBeat.m2504i(39241);
        this.rwq = new C39830a();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        m68220b(z, list);
        int size = list.size();
        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(size)));
        int i4 = 0;
        while (i4 < size) {
            int a = m68219a(i4, size, list);
            hashMap.put(Integer.valueOf(i3), Integer.valueOf(i));
            hashMap2.put(Integer.valueOf(i3), Integer.valueOf(a));
            i += a;
            hashMap3.put(Integer.valueOf(i3), Integer.valueOf(i2));
            i2 += m68222fz(i4, a);
            i4 += a;
            i3++;
        }
        this.rgh = i3;
        this.rgi = list.size();
        C4990ab.m7410d("MicroMsg.SnsSelfHelper", "icount " + this.rgh);
        this.list = list;
        C29036i.m46099am("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.rwp.mo25836a(this.list, hashMap, hashMap2, hashMap3, this.rgi, this.rgh);
        AppMethodBeat.m2505o(39241);
    }
}
