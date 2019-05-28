package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ad {
    String ecX = "";
    private String path;
    private Map<String, Integer> qKA = new HashMap();
    private List<Integer> qKB = new Vector();
    private Map<Integer, Integer> qKC = new HashMap();
    private d qKy;
    private List<Integer> qKz = new Vector();

    public static boolean XT(String str) {
        AppMethodBeat.i(36382);
        if (str == null) {
            AppMethodBeat.o(36382);
            return false;
        } else if (str.startsWith("_AD_TAG_")) {
            AppMethodBeat.o(36382);
            return true;
        } else {
            AppMethodBeat.o(36382);
            return false;
        }
    }

    public ad(String str) {
        AppMethodBeat.i(36383);
        this.path = str;
        if (!cnh()) {
            this.qKy = new d();
        }
        this.qKz.clear();
        this.qKA.clear();
        AppMethodBeat.o(36383);
    }

    public final synchronized void cnf() {
        AppMethodBeat.i(36384);
        if (aq(this.qKy.qQg)) {
            AppMethodBeat.o(36384);
        } else if (aq(this.qKy.qQh)) {
            AppMethodBeat.o(36384);
        } else if (aq(this.qKy.qQi)) {
            AppMethodBeat.o(36384);
        } else if (aq(this.qKy.qQj)) {
            AppMethodBeat.o(36384);
        } else {
            f fVar;
            long j;
            while (!this.qKy.qQk.isEmpty()) {
                fVar = (f) this.qKy.qQk.getFirst();
                if (bo.fp((long) fVar.qQn) <= 21600) {
                    j = fVar.qQp;
                    g.RQ();
                    g.RO().eJo.a(new r(j, 1), 0);
                    AppMethodBeat.o(36384);
                    break;
                }
                this.qKy.qQk.removeFirst();
            }
            while (!this.qKy.qQl.isEmpty()) {
                fVar = (f) this.qKy.qQl.getFirst();
                if (bo.fp((long) fVar.qQn) <= 21600) {
                    j = fVar.qQp;
                    g.RQ();
                    g.RO().eJo.a(new r(j, 5), 0);
                    AppMethodBeat.o(36384);
                    break;
                }
                this.qKy.qQl.removeFirst();
            }
            AppMethodBeat.o(36384);
        }
    }

    private static boolean aq(LinkedList<e> linkedList) {
        AppMethodBeat.i(36385);
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (bo.fp((long) eVar.qQn) > 21600) {
                linkedList.removeFirst();
            } else {
                if (XT(eVar.qQm)) {
                    g.RQ();
                    g.RO().eJo.a(new k(eVar.qIS, eVar.qQm, eVar.qQo), 0);
                } else {
                    g.RQ();
                    g.RO().eJo.a(new o(eVar.qIS, eVar.qQm), 0);
                }
                AppMethodBeat.o(36385);
                return true;
            }
        }
        AppMethodBeat.o(36385);
        return false;
    }

    public final synchronized boolean kl(long j) {
        boolean z;
        AppMethodBeat.i(36386);
        Iterator it = this.qKy.qQk.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).qQp == j) {
                z = false;
                AppMethodBeat.o(36386);
                break;
            }
        }
        z = true;
        AppMethodBeat.o(36386);
        return z;
    }

    public final synchronized void km(long j) {
        AppMethodBeat.i(36387);
        f fVar = new f();
        fVar.qQp = j;
        fVar.qQn = (int) bo.anT();
        this.qKy.qQk.add(fVar);
        cng();
        AppMethodBeat.o(36387);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void kn(long j) {
        Object obj;
        AppMethodBeat.i(36388);
        Iterator it = this.qKy.qQk.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.qQp == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.qKy.qQk.remove(obj);
        }
        cng();
        AppMethodBeat.o(36388);
    }

    private static boolean a(LinkedList<cat> linkedList, String str, int i) {
        AppMethodBeat.i(36389);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36389);
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cat cat = (cat) it.next();
            if (str.equals(cat.ncM) && i == cat.pcX) {
                AppMethodBeat.o(36389);
                return true;
            }
        }
        AppMethodBeat.o(36389);
        return false;
    }

    public final synchronized cbf c(cbf cbf) {
        AppMethodBeat.i(36390);
        if (bo.isNullOrNil(this.ecX)) {
            this.ecX = r.Yz();
        }
        if (this.qKy.qQg.size() == 0 && this.qKy.qQh.size() == 0) {
            AppMethodBeat.o(36390);
        } else {
            e eVar;
            cat cat;
            long j = cbf.vQE;
            Iterator it = this.qKy.qQg.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                cat b = b(eVar.qIS);
                if (eVar.qIS.vQE == j && !a(cbf.xaq, b.ncM, b.pcX)) {
                    cbf.xaq.add(b);
                    cbf.xao++;
                }
            }
            Iterator it2 = cbf.xaq.iterator();
            while (it2.hasNext()) {
                cat = (cat) it2.next();
                if (cat.vHl.equals(this.ecX)) {
                    Object obj = null;
                    Iterator it3 = this.qKy.qQl.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).qQp == j) {
                            cbf.xaq.remove(cat);
                            cbf.xao--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.qKy.qQh.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.qIS.vQE == j) {
                    cat = b(eVar.qIS);
                    if (!a(cbf.xat, cat.ncM, cat.pcX)) {
                        cbf.xat.add(cat);
                        cbf.xar++;
                    }
                }
            }
            AppMethodBeat.o(36390);
        }
        return cbf;
    }

    public static cat b(cao cao) {
        AppMethodBeat.i(36391);
        can can = cao.wZN;
        can can2 = cao.wZO;
        cat cat = new cat();
        cat.ncM = can.ncM;
        cat.pcX = can.pcX;
        cat.wCW = can.wZD;
        cat.vFH = can.vFH;
        cat.jCt = can.jCt;
        cat.vHl = can.wPm;
        cat.wZG = can.wZG;
        cat.wZJ = can.wZJ;
        cat.wZL = can.wZL;
        cat.xaa = can2.wPm;
        cat.wZI = can2.wZI;
        cat.wZF = can2.wZF;
        AppMethodBeat.o(36391);
        return cat;
    }

    public final boolean a(String str, cao cao) {
        AppMethodBeat.i(36392);
        boolean a = a(str, cao, "");
        AppMethodBeat.o(36392);
        return a;
    }

    public final synchronized boolean a(String str, cao cao, String str2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(36393);
            e eVar = new e();
            eVar.qQm = str;
            eVar.qIS = cao;
            eVar.qQn = (int) bo.anT();
            eVar.qQo = str2;
            switch (cao.wZN.jCt) {
                case 1:
                    this.qKy.qQg.add(eVar);
                    if (kp(cao.vQE)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.qKy.qQh.add(eVar);
                    break;
                case 3:
                    this.qKy.qQi.add(eVar);
                    break;
                case 5:
                    this.qKy.qQj.add(eVar);
                    break;
                case 7:
                    this.qKy.qQg.add(eVar);
                    if (kp(cao.vQE)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                case 16:
                    this.qKy.qQh.add(eVar);
                    break;
            }
            if (!cng()) {
                ab.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
            AppMethodBeat.o(36393);
        }
        return z;
    }

    public final void e(long j, int i, String str) {
        AppMethodBeat.i(36394);
        aj.cnW();
        f(j, i, str);
        AppMethodBeat.o(36394);
    }

    private synchronized void f(long j, int i, String str) {
        AppMethodBeat.i(36395);
        switch (i) {
            case 1:
                a(j, this.qKy.qQg, str);
                break;
            case 2:
                a(j, this.qKy.qQh, str);
                break;
            case 3:
                a(j, this.qKy.qQi, str);
                break;
            case 5:
                a(j, this.qKy.qQj, str);
                break;
            case 7:
                a(j, this.qKy.qQg, str);
                break;
            case 8:
            case 16:
                a(j, this.qKy.qQh, str);
                break;
        }
        cng();
        AppMethodBeat.o(36395);
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        AppMethodBeat.i(36396);
        a(j, linkedList, str, false);
        AppMethodBeat.o(36396);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        AppMethodBeat.i(36397);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.qIS.vQE == j && (z || obj.qQm.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            linkedList.remove(obj);
            AppMethodBeat.o(36397);
            return true;
        }
        AppMethodBeat.o(36397);
        return false;
    }

    public final synchronized boolean ko(long j) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(36398);
            f fVar = new f();
            fVar.qQp = j;
            fVar.qQn = (int) bo.anT();
            this.qKy.qQl.add(fVar);
            cng();
            if (a(j, this.qKy.qQg, "", true)) {
                z = false;
                AppMethodBeat.o(36398);
            } else {
                AppMethodBeat.o(36398);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean kp(long j) {
        boolean z;
        Object obj;
        AppMethodBeat.i(36399);
        Iterator it = this.qKy.qQl.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.qQp == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.qKy.qQl.remove(obj);
            z = true;
        } else {
            z = false;
        }
        cng();
        AppMethodBeat.o(36399);
        return z;
    }

    private synchronized boolean cng() {
        boolean z;
        AppMethodBeat.i(36400);
        try {
            byte[] toByteArray = this.qKy.toByteArray();
            if (com.tencent.mm.vfs.e.b(this.path, toByteArray, toByteArray.length) == 0) {
                z = true;
                AppMethodBeat.o(36400);
            } else {
                AppMethodBeat.o(36400);
                z = false;
            }
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
            com.tencent.mm.vfs.e.deleteFile(this.path);
            AppMethodBeat.o(36400);
            z = false;
        }
        return z;
    }

    private synchronized boolean cnh() {
        boolean z;
        AppMethodBeat.i(36401);
        byte[] e = com.tencent.mm.vfs.e.e(this.path, 0, -1);
        if (e == null) {
            AppMethodBeat.o(36401);
            z = false;
        } else {
            try {
                this.qKy = (d) new d().parseFrom(e);
                z = true;
                AppMethodBeat.o(36401);
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e2, "", new Object[0]);
                com.tencent.mm.vfs.e.deleteFile(this.path);
                AppMethodBeat.o(36401);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean CR(int i) {
        boolean contains;
        AppMethodBeat.i(36402);
        contains = this.qKz.contains(Integer.valueOf(i));
        AppMethodBeat.o(36402);
        return contains;
    }

    public final synchronized boolean CS(int i) {
        boolean z;
        AppMethodBeat.i(36403);
        if (this.qKz.contains(Integer.valueOf(i))) {
            z = false;
            AppMethodBeat.o(36403);
        } else {
            this.qKz.add(Integer.valueOf(i));
            z = true;
            AppMethodBeat.o(36403);
        }
        return z;
    }

    public final synchronized boolean CT(int i) {
        AppMethodBeat.i(36404);
        this.qKz.remove(Integer.valueOf(i));
        AppMethodBeat.o(36404);
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        boolean containsKey;
        AppMethodBeat.i(36405);
        containsKey = this.qKA.containsKey(str);
        AppMethodBeat.o(36405);
        return containsKey;
    }

    public final synchronized boolean XU(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(36406);
            if (this.qKA.containsKey(str)) {
                AppMethodBeat.o(36406);
            } else {
                this.qKA.put(str, Integer.valueOf(0));
                z = true;
                AppMethodBeat.o(36406);
            }
        }
        return z;
    }

    public final synchronized boolean XV(String str) {
        AppMethodBeat.i(36407);
        this.qKA.remove(str);
        AppMethodBeat.o(36407);
        return true;
    }

    public final synchronized int cni() {
        int size;
        AppMethodBeat.i(36408);
        size = this.qKA.size();
        AppMethodBeat.o(36408);
        return size;
    }

    public final synchronized boolean CU(int i) {
        boolean z;
        AppMethodBeat.i(36409);
        if (this.qKB.contains(Integer.valueOf(i))) {
            z = false;
            AppMethodBeat.o(36409);
        } else {
            this.qKB.add(Integer.valueOf(i));
            z = true;
            AppMethodBeat.o(36409);
        }
        return z;
    }

    public final synchronized boolean CV(int i) {
        AppMethodBeat.i(36410);
        this.qKB.remove(Integer.valueOf(i));
        this.qKC.remove(Integer.valueOf(i));
        AppMethodBeat.o(36410);
        return true;
    }

    public final synchronized boolean fk(int i, int i2) {
        AppMethodBeat.i(36411);
        this.qKC.put(Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(36411);
        return true;
    }

    public final synchronized boolean CW(int i) {
        AppMethodBeat.i(36412);
        this.qKC.remove(Integer.valueOf(i));
        AppMethodBeat.o(36412);
        return true;
    }

    public final synchronized int CX(int i) {
        int intValue;
        AppMethodBeat.i(36413);
        if (this.qKC.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.qKC.get(Integer.valueOf(i))).intValue();
            AppMethodBeat.o(36413);
        } else {
            intValue = -1;
            AppMethodBeat.o(36413);
        }
        return intValue;
    }
}
