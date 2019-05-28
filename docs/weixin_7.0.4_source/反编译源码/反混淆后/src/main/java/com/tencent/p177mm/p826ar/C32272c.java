package com.tencent.p177mm.p826ar;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C9635b;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p716b.C37976s;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.protocal.protobuf.aht;
import com.tencent.p177mm.protocal.protobuf.ahu;
import com.tencent.p177mm.protocal.protobuf.alk;
import com.tencent.p177mm.protocal.protobuf.all;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cnj;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44204b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceMoveUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.ar.c */
final class C32272c implements C9635b {
    Queue<aht> fCA = new LinkedList();
    Queue<C32271a> fCB = new LinkedList();
    long fCC = 0;
    final int fCD = 500;
    final int fCE = Downloads.MIN_WAIT_FOR_NETWORK;
    C7564ap fCF = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C322732(), false);
    final C7564ap fCG = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C90097(), true);
    C1177f<String, Integer> fCy = new C7598c(200);
    Map<String, C9636a> fCz = new HashMap();
    boolean frc = false;
    private long frn = 0;

    /* renamed from: com.tencent.mm.ar.c$7 */
    class C90097 implements C5015a {
        C90097() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(16477);
            if (C32272c.this.fCB.isEmpty()) {
                C4990ab.m7416i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                AppMethodBeat.m2505o(16477);
                return false;
            }
            boolean z;
            int i;
            int intValue;
            long anU = C5046bo.anU();
            int i2 = C32272c.this.frc ? 5 : 15;
            ArrayList arrayList = new ArrayList(i2 * 2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < i2) {
                    C32271a c32271a = (C32271a) C32272c.this.fCB.peek();
                    if (c32271a == null) {
                        C4990ab.m7416i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                        z = false;
                    } else {
                        LinkedList linkedList = c32271a.fCO.woe;
                        LinkedList linkedList2 = c32271a.fCO.wof;
                        i = c32271a.fCP;
                        if (linkedList2.size() != linkedList.size()) {
                            C4990ab.m7421w("MicroMsg.GetContactService", "find warn %s %s", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList.size()));
                        }
                        if (Math.min(linkedList2.size(), linkedList.size()) <= i) {
                            C32272c.this.fCB.poll();
                            if (C32272c.this.fCB.isEmpty()) {
                                C4990ab.m7417i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i), Integer.valueOf(r8));
                                C32272c.this.fCC = 0;
                                C32272c.this.fCF.mo16770ae(0, 0);
                                z = false;
                            } else {
                                C4990ab.m7417i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i), Integer.valueOf(r8));
                            }
                        } else {
                            bbv bbv = (bbv) linkedList.get(i);
                            intValue = ((Integer) linkedList2.get(i)).intValue();
                            String bc = C5046bo.m7532bc(C1946aa.m4148a(bbv.wcB), "");
                            String bc2 = C5046bo.m7532bc(bbv.guS, "");
                            arrayList.add(bc);
                            arrayList.add(bc2);
                            switch (intValue) {
                                case -477:
                                    z = C32275d.agM().mo52978rY(bc);
                                    boolean rY = C32275d.agM().mo52978rY(bc2);
                                    boolean mu = C37921n.m64070mu(bc);
                                    C4990ab.m7413e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", Integer.valueOf(intValue), bc, bc2, Boolean.valueOf(z), Boolean.valueOf(rY), Boolean.valueOf(mu));
                                    C7053e.pXa.mo8378a(832, 1, 1, false);
                                    z = false;
                                    break;
                                case 0:
                                    String bc3;
                                    if (c32271a.fCO.wog != null && c32271a.fCO.wog.size() > i) {
                                        if (bc.equals(((cnj) c32271a.fCO.wog.get(i)).username)) {
                                            bc3 = C5046bo.m7532bc(((cnj) c32271a.fCO.wog.get(i)).xkS, "");
                                            C4990ab.m7417i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", bc, bc2, bc3);
                                            C24837b.gkF.mo38857a(bbv, bc3);
                                            C7053e.pXa.mo8378a(832, 0, 1, false);
                                            z = true;
                                            break;
                                        }
                                    }
                                    String str = "MicroMsg.GetContactService";
                                    String str2 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                                    Object[] objArr = new Object[3];
                                    if (c32271a.fCO.wog == null) {
                                        bc3 = BuildConfig.COMMAND;
                                    } else {
                                        bc3 = Integer.valueOf(c32271a.fCO.wog.size());
                                    }
                                    objArr[0] = bc3;
                                    objArr[1] = Integer.valueOf(i);
                                    objArr[2] = bc;
                                    C4990ab.m7421w(str, str2, objArr);
                                    bc3 = "";
                                    C4990ab.m7417i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", bc, bc2, bc3);
                                    C24837b.gkF.mo38857a(bbv, bc3);
                                    C7053e.pXa.mo8378a(832, 0, 1, false);
                                    z = true;
                                default:
                                    z = C37921n.m64070mu(bc);
                                    C4990ab.m7413e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", Integer.valueOf(intValue), bc, bc2, Boolean.valueOf(z));
                                    C7053e.pXa.mo8378a(832, 2, 1, false);
                                    z = false;
                                    break;
                            }
                            final String str3 = bc;
                            final String str4 = bc2;
                            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(16476);
                                    C9636a c9636a = (C9636a) C32272c.this.fCz.remove(str3);
                                    C9636a c9636a2 = C5046bo.isNullOrNil(str4) ? null : (C9636a) C32272c.this.fCz.remove(str4);
                                    if (c9636a != null) {
                                        c9636a.mo6218o(str3, z);
                                    }
                                    if (!(c9636a2 == null || C5046bo.isNullOrNil(str4))) {
                                        c9636a2.mo6218o(str4, z);
                                    }
                                    AppMethodBeat.m2505o(16476);
                                }
                            });
                            c32271a.fCP++;
                        }
                        i3 = i4 + 1;
                    }
                } else {
                    z = true;
                }
            }
            i = arrayList.size();
            if (i > 0) {
                C9638aw.m17190ZK();
                long iV = C18628c.m29069Ru().mo15639iV(Thread.currentThread().getId());
                C32269b agM = C32275d.agM();
                for (intValue = 0; intValue < i; intValue++) {
                    agM.mo52978rY((String) arrayList.get(intValue));
                }
                C9638aw.m17190ZK();
                C18628c.m29069Ru().mo15640mB(iV);
            }
            C4990ab.m7416i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + C32272c.this.frc + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (C5046bo.anU() - anU) + "ms");
            AppMethodBeat.m2505o(16477);
            return z;
        }
    }

    /* renamed from: com.tencent.mm.ar.c$6 */
    class C258116 implements C1224a {
        C258116() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(16475);
            if (c1207m.getType() != FaceMoveUtil.TRIANGLE_COUNT) {
                AppMethodBeat.m2505o(16475);
            } else {
                C32272c.this.frc = false;
                if (i == 0 && i2 == 0) {
                    if (!C32272c.this.fCA.isEmpty() && C32272c.this.fCF.doT()) {
                        C32272c.this.fCF.mo16770ae(500, 500);
                    }
                    if (c7472b != null) {
                        C32271a c32271a = new C32271a();
                        c32271a.errType = i;
                        c32271a.errCode = i2;
                        c32271a.aIm = str;
                        c32271a.fCO = (ahu) c7472b.fsH.fsP;
                        C32272c.this.fCB.add(c32271a);
                    }
                    if (!C32272c.this.fCB.isEmpty() && C32272c.this.fCG.doT()) {
                        C32272c.this.fCG.mo16770ae(50, 50);
                    }
                    AppMethodBeat.m2505o(16475);
                } else {
                    C4990ab.m7412e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                    C32272c.this.fCF.mo16770ae(10000, 10000);
                    AppMethodBeat.m2505o(16475);
                }
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.ar.c$a */
    class C32271a {
        String aIm;
        int errCode;
        int errType;
        ahu fCO;
        int fCP = 0;

        C32271a() {
        }
    }

    /* renamed from: com.tencent.mm.ar.c$2 */
    class C322732 implements C5015a {
        C322732() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(16471);
            C4990ab.m7410d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            C32272c.this.agK();
            AppMethodBeat.m2505o(16471);
            return false;
        }
    }

    C32272c() {
        AppMethodBeat.m2504i(16478);
        AppMethodBeat.m2505o(16478);
    }

    /* renamed from: or */
    public final void mo20969or(String str) {
        AppMethodBeat.m2504i(16479);
        this.fCz.remove(str);
        AppMethodBeat.m2505o(16479);
    }

    /* renamed from: ai */
    public final void mo20967ai(String str, String str2) {
        AppMethodBeat.m2504i(16480);
        C4990ab.m7416i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + C5046bo.dpG());
        if (C32272c.m52695aK(str, str2)) {
            this.fCF.mo16770ae(500, 500);
        }
        AppMethodBeat.m2505o(16480);
    }

    /* renamed from: a */
    public final void mo20966a(String str, String str2, C9636a c9636a) {
        AppMethodBeat.m2504i(16482);
        C4990ab.m7416i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + C5046bo.dpG());
        if (C32272c.m52695aK(str, str2)) {
            this.fCz.put(str, c9636a);
            this.fCF.mo16770ae(0, 0);
        }
        AppMethodBeat.m2505o(16482);
    }

    /* renamed from: os */
    public final void mo20970os(final String str) {
        AppMethodBeat.m2504i(16483);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(16470);
                Object[] toArray = C32272c.this.fCy.keySet().toArray();
                for (Object obj : toArray) {
                    String str = (String) obj;
                    if (str.startsWith(str)) {
                        C4990ab.m7411d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", str);
                        C32272c.this.fCy.remove(str);
                    }
                }
                AppMethodBeat.m2505o(16470);
            }
        });
        AppMethodBeat.m2505o(16483);
    }

    /* renamed from: aK */
    private static boolean m52695aK(String str, String str2) {
        AppMethodBeat.m2504i(16484);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16484);
            return false;
        }
        String Yz = C1853r.m3846Yz();
        String YA = C1853r.m3819YA();
        if (str.equals(Yz) || str.equals(YA)) {
            C4990ab.m7416i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + Yz + " alias: " + YA + " ret");
            AppMethodBeat.m2505o(16484);
            return false;
        }
        C37471a c37471a = new C37471a();
        c37471a.username = str;
        c37471a.fng = C5046bo.nullAsNil(str2);
        c37471a.fCv = C5046bo.anU();
        boolean a = C32275d.agM().mo52977a(c37471a);
        AppMethodBeat.m2505o(16484);
        return a;
    }

    private void agJ() {
        AppMethodBeat.m2504i(16485);
        String[] strArr = new String[]{String.valueOf(this.fCC), "80"};
        Cursor a = C32275d.agM().fni.mo10104a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (a == null) {
            AppMethodBeat.m2505o(16485);
            return;
        }
        C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(a.getCount()));
        if (a.getCount() <= 0) {
            a.close();
            AppMethodBeat.m2505o(16485);
            return;
        }
        int a2;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        while (a.moveToNext()) {
            LinkedList linkedList5;
            C37471a c37471a = new C37471a();
            c37471a.username = a.getString(0);
            c37471a.fCv = a.getLong(1);
            c37471a.type = a.getInt(2);
            c37471a.fCw = a.getInt(3);
            c37471a.fne = a.getInt(4);
            c37471a.fCx = a.getInt(5);
            c37471a.fng = a.getString(6);
            c37471a.fnh = a.getString(7);
            String username = c37471a.getUsername();
            String nullAsNil = C5046bo.nullAsNil(c37471a.agH());
            int h = C5046bo.m7567h(Integer.valueOf(c37471a.fCx));
            String nullAsNil2 = C5046bo.nullAsNil(c37471a.agI());
            this.fCC = c37471a.fCv;
            String str = username + "#" + nullAsNil;
            a2 = C5046bo.m7512a((Integer) this.fCy.mo4404ai(str), 0);
            if (a2 < 3) {
                this.fCy.mo4412k(str, Integer.valueOf(a2 + 1));
                aht aht;
                if (C1855t.m3903mP(username)) {
                    aht = new aht();
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    aht.vEg = linkedList;
                    aht.woa = linkedList2;
                    this.fCA.add(aht);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht.vEg.size()), username);
                    linkedList = linkedList2;
                } else if (C7616ad.aox(username)) {
                    aht = new aht();
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    aht.vEg = linkedList;
                    aht.woa = linkedList2;
                    this.fCA.add(aht);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht.vEg.size()), username);
                    linkedList = linkedList2;
                } else if (h == 1) {
                    linkedList3.add(new Pair(new bts().alV(username), new bts().alV(nullAsNil2)));
                    C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", username, Integer.valueOf(h), nullAsNil2);
                    linkedList5 = linkedList2;
                } else {
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", username, nullAsNil);
                    linkedList5 = linkedList2;
                }
            } else {
                linkedList4.add(username);
                mo52980H(username, false);
                linkedList5 = linkedList2;
            }
            if (linkedList.size() >= 20 || a.isLast()) {
                aht aht2 = new aht();
                aht2.vEg = linkedList;
                aht2.wnW = linkedList.size();
                aht2.woa = linkedList5;
                aht2.wnZ = linkedList5.size();
                this.fCA.add(aht2);
                linkedList = new LinkedList();
                linkedList5 = new LinkedList();
                C4990ab.m7417i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht2.vEg.size()));
            }
            linkedList2 = linkedList5;
        }
        a.close();
        Iterator it = linkedList3.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            aht aht3 = new aht();
            LinkedList linkedList6 = new LinkedList();
            linkedList6.add(pair.first);
            aht3.vEg = linkedList6;
            aht3.wnW = linkedList6.size();
            aht3.wob = 1;
            aht3.woc = (bts) pair.second;
            this.fCA.add(aht3);
        }
        linkedList3.clear();
        a2 = 0;
        while (true) {
            int i = a2;
            if (i < linkedList4.size()) {
                String str2 = (String) linkedList4.get(i);
                C4990ab.m7421w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", str2, Boolean.valueOf(C1855t.m3896kH(str2)));
                if (C1855t.m3896kH(str2)) {
                    C32275d.agM().mo52978rY(str2);
                }
                boolean mQ = C1855t.m3904mQ(str2);
                C4990ab.m7421w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", str2, Boolean.valueOf(r1));
                if (mQ) {
                    C32275d.agM().mo52978rY(str2);
                    C7053e.pXa.mo8378a(832, 3, 1, false);
                }
                a2 = i + 1;
            } else {
                AppMethodBeat.m2505o(16485);
                return;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: H */
    public final void mo52980H(final String str, final boolean z) {
        AppMethodBeat.m2504i(16486);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(16472);
                if (C32272c.this.fCz.containsKey(str)) {
                    C9636a c9636a = (C9636a) C32272c.this.fCz.get(str);
                    if (c9636a != null) {
                        c9636a.mo6218o(str, z);
                    }
                    C32272c.this.fCz.remove(str);
                }
                AppMethodBeat.m2505o(16472);
            }
        });
        AppMethodBeat.m2505o(16486);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void agK() {
        AppMethodBeat.m2504i(16487);
        if (C24837b.gkF.mo38850BZ()) {
            C4990ab.m7420w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
            AppMethodBeat.m2505o(16487);
        } else {
            long anU = C5046bo.anU();
            if (this.frc && anU - this.frn > 600000) {
                C4990ab.m7421w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(anU - this.frn));
                this.frc = false;
            }
            if (this.frc) {
                C4990ab.m7416i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.frc + " ret");
                AppMethodBeat.m2505o(16487);
            } else {
                String a;
                aht aht = (aht) this.fCA.poll();
                if (aht == null) {
                    agJ();
                    aht = (aht) this.fCA.poll();
                    if (aht == null || aht.vEg == null || aht.vEg.size() == 0) {
                        C4990ab.m7416i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                        AppMethodBeat.m2505o(16487);
                    }
                }
                aht aht2 = aht;
                this.frn = anU;
                this.frc = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Iterator it = aht2.vEg.iterator();
                while (it.hasNext()) {
                    a = C1946aa.m4148a((bts) it.next());
                    if (C1855t.m3903mP(a)) {
                        linkedList.add(a);
                    }
                    if (C7616ad.aox(a)) {
                        linkedList2.add(a);
                    }
                }
                if (linkedList.size() > 0) {
                    a = (String) linkedList.get(0);
                    if (C1855t.m3903mP(a)) {
                        C30262b.alY(a).mo20640kd(a).mo74755d(new C44204b() {
                            /* renamed from: a */
                            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                                AppMethodBeat.m2504i(16473);
                                C32272c.this.frc = false;
                                if (i == 0 && i2 == 0) {
                                    if (!C32272c.this.fCA.isEmpty() && C32272c.this.fCF.doT()) {
                                        C32272c.this.fCF.mo16770ae(500, 500);
                                    }
                                    boolean rY = C32275d.agM().mo52978rY(a);
                                    C4990ab.m7417i("MicroMsg.ActionCallbackFunc", "getChatRoomInfoDetail onResult %s %s", Boolean.valueOf(rY), a);
                                    C32272c.this.mo52980H(a, true);
                                    AppMethodBeat.m2505o(16473);
                                    return;
                                }
                                C4990ab.m7412e("MicroMsg.ActionCallbackFunc", "tryStartNetscene onSceneEnd openRoom errType:" + i + " errCode:" + i2 + " will retry");
                                C32272c.this.fCF.mo16770ae(10000, 10000);
                                C32272c.this.mo52980H(a, false);
                                AppMethodBeat.m2505o(16473);
                            }
                        }).dmX();
                    }
                    AppMethodBeat.m2505o(16487);
                } else if (linkedList2.size() > 0) {
                    a = (String) linkedList2.get(0);
                    alk alk = new alk();
                    alk.geZ = a;
                    String str = "";
                    if (aht2.woa != null && aht2.woa.size() > 0) {
                        str = C1946aa.m4148a((bts) aht2.woa.get(0));
                    }
                    alk.geY = str;
                    C1196a c1196a = new C1196a();
                    c1196a.fsJ = alk;
                    c1196a.fsK = new all();
                    c1196a.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
                    c1196a.fsI = 881;
                    C4990ab.m7417i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", str, a);
                    C1226w.m2655a(c1196a.acD(), new C1224a() {
                        /* renamed from: a */
                        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                            AppMethodBeat.m2504i(16474);
                            if (c1207m.getType() != 881) {
                                AppMethodBeat.m2505o(16474);
                            } else {
                                C32272c.this.frc = false;
                                if (i == 0 && i2 == 0) {
                                    if (!C32272c.this.fCA.isEmpty() && C32272c.this.fCF.doT()) {
                                        C32272c.this.fCF.mo16770ae(500, 500);
                                    }
                                    C37976s.m64266a((all) c7472b.fsH.fsP);
                                    boolean rY = C32275d.agM().mo52978rY(a);
                                    C4990ab.m7417i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", Boolean.valueOf(rY), a);
                                    C32272c.this.mo52980H(a, true);
                                    AppMethodBeat.m2505o(16474);
                                } else {
                                    C4990ab.m7413e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", Integer.valueOf(i), Integer.valueOf(i2), a);
                                    if (i == 4) {
                                        C32275d.agM().mo52978rY(a);
                                    }
                                    C32272c.this.fCF.mo16770ae(10000, 10000);
                                    C32272c.this.mo52980H(a, false);
                                    AppMethodBeat.m2505o(16474);
                                }
                            }
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.m2505o(16487);
                } else {
                    C1196a c1196a2 = new C1196a();
                    c1196a2.fsJ = aht2;
                    c1196a2.fsK = new ahu();
                    c1196a2.uri = "/cgi-bin/micromsg-bin/getcontact";
                    c1196a2.fsI = FaceMoveUtil.TRIANGLE_COUNT;
                    C1226w.m2655a(c1196a2.acD(), new C258116(), true);
                    AppMethodBeat.m2505o(16487);
                }
            }
        }
    }

    /* renamed from: aj */
    public final void mo20968aj(String str, String str2) {
        boolean z = false;
        AppMethodBeat.m2504i(16481);
        if (!C5046bo.isNullOrNil(str)) {
            String Yz = C1853r.m3846Yz();
            String YA = C1853r.m3819YA();
            if (str.equals(Yz) || str.equals(YA)) {
                C4990ab.m7416i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + Yz + " alias: " + YA + " ret");
            } else {
                C37471a c37471a = new C37471a();
                c37471a.username = str;
                c37471a.fnh = C5046bo.nullAsNil(str2);
                c37471a.fCx = C5046bo.m7567h(Integer.valueOf(1));
                c37471a.fCv = C5046bo.anU();
                z = C32275d.agM().mo52977a(c37471a);
            }
        }
        if (z) {
            this.fCF.mo16770ae(500, 500);
        }
        AppMethodBeat.m2505o(16481);
    }
}
