package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.sns.p1025h.C43544d;
import com.tencent.p177mm.plugin.sns.p1025h.C43545e;
import com.tencent.p177mm.plugin.sns.p1025h.C43546f;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.model.ad */
public final class C21915ad {
    String ecX = "";
    private String path;
    private Map<String, Integer> qKA = new HashMap();
    private List<Integer> qKB = new Vector();
    private Map<Integer, Integer> qKC = new HashMap();
    private C43544d qKy;
    private List<Integer> qKz = new Vector();

    /* renamed from: XT */
    public static boolean m33476XT(String str) {
        AppMethodBeat.m2504i(36382);
        if (str == null) {
            AppMethodBeat.m2505o(36382);
            return false;
        } else if (str.startsWith("_AD_TAG_")) {
            AppMethodBeat.m2505o(36382);
            return true;
        } else {
            AppMethodBeat.m2505o(36382);
            return false;
        }
    }

    public C21915ad(String str) {
        AppMethodBeat.m2504i(36383);
        this.path = str;
        if (!cnh()) {
            this.qKy = new C43544d();
        }
        this.qKz.clear();
        this.qKA.clear();
        AppMethodBeat.m2505o(36383);
    }

    public final synchronized void cnf() {
        AppMethodBeat.m2504i(36384);
        if (C21915ad.m33480aq(this.qKy.qQg)) {
            AppMethodBeat.m2505o(36384);
        } else if (C21915ad.m33480aq(this.qKy.qQh)) {
            AppMethodBeat.m2505o(36384);
        } else if (C21915ad.m33480aq(this.qKy.qQi)) {
            AppMethodBeat.m2505o(36384);
        } else if (C21915ad.m33480aq(this.qKy.qQj)) {
            AppMethodBeat.m2505o(36384);
        } else {
            C43546f c43546f;
            long j;
            while (!this.qKy.qQk.isEmpty()) {
                c43546f = (C43546f) this.qKy.qQk.getFirst();
                if (C5046bo.m7549fp((long) c43546f.qQn) <= 21600) {
                    j = c43546f.qQp;
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46224r(j, 1), 0);
                    AppMethodBeat.m2505o(36384);
                    break;
                }
                this.qKy.qQk.removeFirst();
            }
            while (!this.qKy.qQl.isEmpty()) {
                c43546f = (C43546f) this.qKy.qQl.getFirst();
                if (C5046bo.m7549fp((long) c43546f.qQn) <= 21600) {
                    j = c43546f.qQp;
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46224r(j, 5), 0);
                    AppMethodBeat.m2505o(36384);
                    break;
                }
                this.qKy.qQl.removeFirst();
            }
            AppMethodBeat.m2505o(36384);
        }
    }

    /* renamed from: aq */
    private static boolean m33480aq(LinkedList<C43545e> linkedList) {
        AppMethodBeat.m2504i(36385);
        while (!linkedList.isEmpty()) {
            C43545e c43545e = (C43545e) linkedList.getFirst();
            if (C5046bo.m7549fp((long) c43545e.qQn) > 21600) {
                linkedList.removeFirst();
            } else {
                if (C21915ad.m33476XT(c43545e.qQm)) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46223k(c43545e.qIS, c43545e.qQm, c43545e.qQo), 0);
                } else {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C13430o(c43545e.qIS, c43545e.qQm), 0);
                }
                AppMethodBeat.m2505o(36385);
                return true;
            }
        }
        AppMethodBeat.m2505o(36385);
        return false;
    }

    /* renamed from: kl */
    public final synchronized boolean mo37409kl(long j) {
        boolean z;
        AppMethodBeat.m2504i(36386);
        Iterator it = this.qKy.qQk.iterator();
        while (it.hasNext()) {
            if (((C43546f) it.next()).qQp == j) {
                z = false;
                AppMethodBeat.m2505o(36386);
                break;
            }
        }
        z = true;
        AppMethodBeat.m2505o(36386);
        return z;
    }

    /* renamed from: km */
    public final synchronized void mo37410km(long j) {
        AppMethodBeat.m2504i(36387);
        C43546f c43546f = new C43546f();
        c43546f.qQp = j;
        c43546f.qQn = (int) C5046bo.anT();
        this.qKy.qQk.add(c43546f);
        cng();
        AppMethodBeat.m2505o(36387);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: kn */
    public final synchronized void mo37411kn(long j) {
        Object obj;
        AppMethodBeat.m2504i(36388);
        Iterator it = this.qKy.qQk.iterator();
        while (it.hasNext()) {
            obj = (C43546f) it.next();
            if (obj.qQp == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.qKy.qQk.remove(obj);
        }
        cng();
        AppMethodBeat.m2505o(36388);
    }

    /* renamed from: a */
    private static boolean m33479a(LinkedList<cat> linkedList, String str, int i) {
        AppMethodBeat.m2504i(36389);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36389);
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cat cat = (cat) it.next();
            if (str.equals(cat.ncM) && i == cat.pcX) {
                AppMethodBeat.m2505o(36389);
                return true;
            }
        }
        AppMethodBeat.m2505o(36389);
        return false;
    }

    /* renamed from: c */
    public final synchronized cbf mo37403c(cbf cbf) {
        AppMethodBeat.m2504i(36390);
        if (C5046bo.isNullOrNil(this.ecX)) {
            this.ecX = C1853r.m3846Yz();
        }
        if (this.qKy.qQg.size() == 0 && this.qKy.qQh.size() == 0) {
            AppMethodBeat.m2505o(36390);
        } else {
            C43545e c43545e;
            cat cat;
            long j = cbf.vQE;
            Iterator it = this.qKy.qQg.iterator();
            while (it.hasNext()) {
                c43545e = (C43545e) it.next();
                cat b = C21915ad.m33481b(c43545e.qIS);
                if (c43545e.qIS.vQE == j && !C21915ad.m33479a(cbf.xaq, b.ncM, b.pcX)) {
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
                        if (((C43546f) it3.next()).qQp == j) {
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
                c43545e = (C43545e) it.next();
                if (c43545e.qIS.vQE == j) {
                    cat = C21915ad.m33481b(c43545e.qIS);
                    if (!C21915ad.m33479a(cbf.xat, cat.ncM, cat.pcX)) {
                        cbf.xat.add(cat);
                        cbf.xar++;
                    }
                }
            }
            AppMethodBeat.m2505o(36390);
        }
        return cbf;
    }

    /* renamed from: b */
    public static cat m33481b(cao cao) {
        AppMethodBeat.m2504i(36391);
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
        AppMethodBeat.m2505o(36391);
        return cat;
    }

    /* renamed from: a */
    public final boolean mo37401a(String str, cao cao) {
        AppMethodBeat.m2504i(36392);
        boolean a = mo37402a(str, cao, "");
        AppMethodBeat.m2505o(36392);
        return a;
    }

    /* renamed from: a */
    public final synchronized boolean mo37402a(String str, cao cao, String str2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(36393);
            C43545e c43545e = new C43545e();
            c43545e.qQm = str;
            c43545e.qIS = cao;
            c43545e.qQn = (int) C5046bo.anT();
            c43545e.qQo = str2;
            switch (cao.wZN.jCt) {
                case 1:
                    this.qKy.qQg.add(c43545e);
                    if (mo37413kp(cao.vQE)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.qKy.qQh.add(c43545e);
                    break;
                case 3:
                    this.qKy.qQi.add(c43545e);
                    break;
                case 5:
                    this.qKy.qQj.add(c43545e);
                    break;
                case 7:
                    this.qKy.qQg.add(c43545e);
                    if (mo37413kp(cao.vQE)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                case 16:
                    this.qKy.qQh.add(c43545e);
                    break;
            }
            if (!cng()) {
                C4990ab.m7412e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
            AppMethodBeat.m2505o(36393);
        }
        return z;
    }

    /* renamed from: e */
    public final void mo37406e(long j, int i, String str) {
        AppMethodBeat.m2504i(36394);
        C34955aj.cnW();
        m33482f(j, i, str);
        AppMethodBeat.m2505o(36394);
    }

    /* renamed from: f */
    private synchronized void m33482f(long j, int i, String str) {
        AppMethodBeat.m2504i(36395);
        switch (i) {
            case 1:
                C21915ad.m33477a(j, this.qKy.qQg, str);
                break;
            case 2:
                C21915ad.m33477a(j, this.qKy.qQh, str);
                break;
            case 3:
                C21915ad.m33477a(j, this.qKy.qQi, str);
                break;
            case 5:
                C21915ad.m33477a(j, this.qKy.qQj, str);
                break;
            case 7:
                C21915ad.m33477a(j, this.qKy.qQg, str);
                break;
            case 8:
            case 16:
                C21915ad.m33477a(j, this.qKy.qQh, str);
                break;
        }
        cng();
        AppMethodBeat.m2505o(36395);
    }

    /* renamed from: a */
    private static void m33477a(long j, LinkedList<C43545e> linkedList, String str) {
        AppMethodBeat.m2504i(36396);
        C21915ad.m33478a(j, linkedList, str, false);
        AppMethodBeat.m2505o(36396);
    }

    /* renamed from: a */
    private static boolean m33478a(long j, LinkedList<C43545e> linkedList, String str, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(36397);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (C43545e) it.next();
            if (obj.qIS.vQE == j && (z || obj.qQm.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            linkedList.remove(obj);
            AppMethodBeat.m2505o(36397);
            return true;
        }
        AppMethodBeat.m2505o(36397);
        return false;
    }

    /* renamed from: ko */
    public final synchronized boolean mo37412ko(long j) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(36398);
            C43546f c43546f = new C43546f();
            c43546f.qQp = j;
            c43546f.qQn = (int) C5046bo.anT();
            this.qKy.qQl.add(c43546f);
            cng();
            if (C21915ad.m33478a(j, this.qKy.qQg, "", true)) {
                z = false;
                AppMethodBeat.m2505o(36398);
            } else {
                AppMethodBeat.m2505o(36398);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: kp */
    public final synchronized boolean mo37413kp(long j) {
        boolean z;
        Object obj;
        AppMethodBeat.m2504i(36399);
        Iterator it = this.qKy.qQl.iterator();
        while (it.hasNext()) {
            obj = (C43546f) it.next();
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
        AppMethodBeat.m2505o(36399);
        return z;
    }

    private synchronized boolean cng() {
        boolean z;
        AppMethodBeat.m2504i(36400);
        try {
            byte[] toByteArray = this.qKy.toByteArray();
            if (C5730e.m8624b(this.path, toByteArray, toByteArray.length) == 0) {
                z = true;
                AppMethodBeat.m2505o(36400);
            } else {
                AppMethodBeat.m2505o(36400);
                z = false;
            }
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
            C5730e.deleteFile(this.path);
            AppMethodBeat.m2505o(36400);
            z = false;
        }
        return z;
    }

    private synchronized boolean cnh() {
        boolean z;
        AppMethodBeat.m2504i(36401);
        byte[] e = C5730e.m8632e(this.path, 0, -1);
        if (e == null) {
            AppMethodBeat.m2505o(36401);
            z = false;
        } else {
            try {
                this.qKy = (C43544d) new C43544d().parseFrom(e);
                z = true;
                AppMethodBeat.m2505o(36401);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e2, "", new Object[0]);
                C5730e.deleteFile(this.path);
                AppMethodBeat.m2505o(36401);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: CR */
    public final synchronized boolean mo37392CR(int i) {
        boolean contains;
        AppMethodBeat.m2504i(36402);
        contains = this.qKz.contains(Integer.valueOf(i));
        AppMethodBeat.m2505o(36402);
        return contains;
    }

    /* renamed from: CS */
    public final synchronized boolean mo37393CS(int i) {
        boolean z;
        AppMethodBeat.m2504i(36403);
        if (this.qKz.contains(Integer.valueOf(i))) {
            z = false;
            AppMethodBeat.m2505o(36403);
        } else {
            this.qKz.add(Integer.valueOf(i));
            z = true;
            AppMethodBeat.m2505o(36403);
        }
        return z;
    }

    /* renamed from: CT */
    public final synchronized boolean mo37394CT(int i) {
        AppMethodBeat.m2504i(36404);
        this.qKz.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(36404);
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        boolean containsKey;
        AppMethodBeat.m2504i(36405);
        containsKey = this.qKA.containsKey(str);
        AppMethodBeat.m2505o(36405);
        return containsKey;
    }

    /* renamed from: XU */
    public final synchronized boolean mo37399XU(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(36406);
            if (this.qKA.containsKey(str)) {
                AppMethodBeat.m2505o(36406);
            } else {
                this.qKA.put(str, Integer.valueOf(0));
                z = true;
                AppMethodBeat.m2505o(36406);
            }
        }
        return z;
    }

    /* renamed from: XV */
    public final synchronized boolean mo37400XV(String str) {
        AppMethodBeat.m2504i(36407);
        this.qKA.remove(str);
        AppMethodBeat.m2505o(36407);
        return true;
    }

    public final synchronized int cni() {
        int size;
        AppMethodBeat.m2504i(36408);
        size = this.qKA.size();
        AppMethodBeat.m2505o(36408);
        return size;
    }

    /* renamed from: CU */
    public final synchronized boolean mo37395CU(int i) {
        boolean z;
        AppMethodBeat.m2504i(36409);
        if (this.qKB.contains(Integer.valueOf(i))) {
            z = false;
            AppMethodBeat.m2505o(36409);
        } else {
            this.qKB.add(Integer.valueOf(i));
            z = true;
            AppMethodBeat.m2505o(36409);
        }
        return z;
    }

    /* renamed from: CV */
    public final synchronized boolean mo37396CV(int i) {
        AppMethodBeat.m2504i(36410);
        this.qKB.remove(Integer.valueOf(i));
        this.qKC.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(36410);
        return true;
    }

    /* renamed from: fk */
    public final synchronized boolean mo37407fk(int i, int i2) {
        AppMethodBeat.m2504i(36411);
        this.qKC.put(Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(36411);
        return true;
    }

    /* renamed from: CW */
    public final synchronized boolean mo37397CW(int i) {
        AppMethodBeat.m2504i(36412);
        this.qKC.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(36412);
        return true;
    }

    /* renamed from: CX */
    public final synchronized int mo37398CX(int i) {
        int intValue;
        AppMethodBeat.m2504i(36413);
        if (this.qKC.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.qKC.get(Integer.valueOf(i))).intValue();
            AppMethodBeat.m2505o(36413);
        } else {
            intValue = -1;
            AppMethodBeat.m2505o(36413);
        }
        return intValue;
    }
}
