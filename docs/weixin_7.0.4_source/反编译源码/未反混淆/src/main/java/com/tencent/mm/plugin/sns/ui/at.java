package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class at extends d<n> {
    private boolean czr = false;
    private String lQD = "";
    List<n> list = new ArrayList();
    private Comparator<n> qHx = new Comparator<n>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            n nVar = (n) obj;
            n nVar2 = (n) obj2;
            if (nVar.reX == -1) {
                return -1;
            }
            if (nVar2.reX == -1) {
                return 1;
            }
            if (nVar.field_head != nVar2.field_head) {
                return nVar2.field_head - nVar.field_head;
            }
            if (nVar.field_createTime != nVar2.field_createTime) {
                return nVar2.field_createTime - nVar.field_createTime;
            }
            return 0;
        }
    };
    private int rgh = 0;
    private int rgi = 0;
    private boolean rwo = false;
    private b rwp;
    private a rwq;
    private String userName = "";

    class a {
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

        a() {
        }

        public static boolean Ee(int i) {
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

    public interface b {
        void a(List<n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void ctL();
    }

    public at(b bVar, String str, boolean z) {
        AppMethodBeat.i(39233);
        this.rwp = bVar;
        this.userName = str;
        this.czr = z;
        AppMethodBeat.o(39233);
    }

    public final void dq(List<n> list) {
        AppMethodBeat.i(39234);
        if (this.rwp != null) {
            if (list != null) {
                c(true, list);
            }
            this.rwp.ctL();
        }
        AppMethodBeat.o(39234);
    }

    public final List<n> Kx() {
        AppMethodBeat.i(39235);
        ab.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(aj.a(this.userName, this.czr, this.lQD, this.rwo).size()));
        AppMethodBeat.o(39235);
        return aj.a(this.userName, this.czr, this.lQD, this.rwo);
    }

    public final void ctM() {
        AppMethodBeat.i(39236);
        Collections.sort(this.list, this.qHx);
        AppMethodBeat.o(39236);
    }

    /* Access modifiers changed, original: final */
    public final void ctN() {
        AppMethodBeat.i(39237);
        c(false, this.list);
        AppMethodBeat.o(39237);
    }

    public final void g(String str, boolean z, boolean z2) {
        AppMethodBeat.i(39238);
        ab.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(str)));
        this.lQD = str;
        this.rwo = z;
        hM(z2);
        AppMethodBeat.o(39238);
    }

    private int fz(int i, int i2) {
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

    private int a(int i, int i2, List<n> list) {
        boolean z = true;
        AppMethodBeat.i(39239);
        a aVar = this.rwq;
        aVar.rwt = -1;
        aVar.rwD = -1;
        aVar.rws = -1;
        aVar.rwx = "";
        aVar.rwy = "";
        aVar.rwz = "";
        aVar.rwC = false;
        aVar.rwu = false;
        aVar.rwE = false;
        aVar.rwF = -1;
        aVar.rwv = -1;
        aVar.rwA = -1;
        aVar.rwB = 0;
        aVar.rww = 0;
        aVar.rwG = 0;
        if (this.czr && i == 0) {
            AppMethodBeat.o(39239);
            return 1;
        }
        n nVar;
        TimeLineObject cqu;
        boolean z2;
        if (i + 1 < i2) {
            nVar = (n) list.get(i + 1);
            this.rwq.rwt = nVar.field_head;
            cqu = nVar.cqu();
            this.rwq.rwx = cqu.xfF;
            this.rwq.rwu = aj.ab(nVar.field_localPrivate, this.czr);
            this.rwq.rwv = nVar.field_type;
            if (cqu.xfI != null) {
                this.rwq.rww = cqu.xfI.wbK.size();
            } else {
                this.rwq.rww = 0;
            }
        }
        if (i + 2 < i2) {
            nVar = (n) list.get(i + 2);
            this.rwq.rwD = nVar.field_head;
            cqu = nVar.cqu();
            this.rwq.rwy = cqu.xfF;
            this.rwq.rwE = aj.ab(nVar.field_localPrivate, this.czr);
            this.rwq.rwF = nVar.field_type;
            if (cqu.xfI != null) {
                this.rwq.rwG = cqu.xfI.wbK.size();
            } else {
                this.rwq.rwG = 0;
            }
        }
        nVar = (n) list.get(i);
        this.rwq.rws = nVar.field_head;
        cqu = nVar.cqu();
        this.rwq.rwz = cqu.xfF;
        this.rwq.rwA = nVar.field_type;
        this.rwq.rwC = aj.ab(nVar.field_localPrivate, this.czr);
        if (cqu.xfI != null) {
            this.rwq.rwB = cqu.xfI.wbK.size();
        } else {
            this.rwq.rwB = 0;
        }
        aVar = this.rwq;
        if (aVar.rwA == 2) {
            z2 = true;
        } else if (aVar.rwt == -1) {
            z2 = true;
        } else if (aVar.rwA != aVar.rwv) {
            z2 = true;
        } else if (a.Ee(aVar.rwA)) {
            z2 = true;
        } else if (a.Ee(aVar.rwv)) {
            z2 = true;
        } else if (aVar.rwB > 1 || aVar.rww > 1) {
            z2 = true;
        } else if (aVar.rwz != null && !aVar.rwz.equals("")) {
            z2 = true;
        } else if (aVar.rwx != null && !aVar.rwx.equals("")) {
            z2 = true;
        } else if (aVar.rws != aVar.rwt) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(39239);
            return 1;
        }
        aVar = this.rwq;
        if (aVar.rwD != -1 && aVar.rwv == aVar.rwF && !a.Ee(aVar.rwF) && aVar.rwG <= 1 && ((aVar.rwy == null || aVar.rwy.equals("")) && aVar.rwt == aVar.rwD)) {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(39239);
            return 2;
        }
        AppMethodBeat.o(39239);
        return 3;
    }

    private void b(boolean z, List<n> list) {
        AppMethodBeat.i(39240);
        if (z) {
            if (this.czr) {
                n nVar = new n((byte) 0);
                nVar.field_snsId = 0;
                nVar.reX = -1;
                nVar.ls((int) (System.currentTimeMillis() / 1000));
                list.add(0, nVar);
            }
            AppMethodBeat.o(39240);
            return;
        }
        AppMethodBeat.o(39240);
    }

    private void c(boolean z, List<n> list) {
        AppMethodBeat.i(39241);
        this.rwq = new a();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        b(z, list);
        int size = list.size();
        ab.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(size)));
        int i4 = 0;
        while (i4 < size) {
            int a = a(i4, size, list);
            hashMap.put(Integer.valueOf(i3), Integer.valueOf(i));
            hashMap2.put(Integer.valueOf(i3), Integer.valueOf(a));
            i += a;
            hashMap3.put(Integer.valueOf(i3), Integer.valueOf(i2));
            i2 += fz(i4, a);
            i4 += a;
            i3++;
        }
        this.rgh = i3;
        this.rgi = list.size();
        ab.d("MicroMsg.SnsSelfHelper", "icount " + this.rgh);
        this.list = list;
        i.am("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.rwp.a(this.list, hashMap, hashMap2, hashMap3, this.rgi, this.rgh);
        AppMethodBeat.o(39241);
    }
}
