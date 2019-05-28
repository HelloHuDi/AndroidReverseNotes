package com.tencent.mm.ar;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.FaceMoveUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c implements b {
    Queue<aht> fCA = new LinkedList();
    Queue<a> fCB = new LinkedList();
    long fCC = 0;
    final int fCD = 500;
    final int fCE = Downloads.MIN_WAIT_FOR_NETWORK;
    ap fCF = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(16471);
            ab.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            c.this.agK();
            AppMethodBeat.o(16471);
            return false;
        }
    }, false);
    final ap fCG = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(16477);
            if (c.this.fCB.isEmpty()) {
                ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                AppMethodBeat.o(16477);
                return false;
            }
            boolean z;
            int i;
            int intValue;
            long anU = bo.anU();
            int i2 = c.this.frc ? 5 : 15;
            ArrayList arrayList = new ArrayList(i2 * 2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < i2) {
                    a aVar = (a) c.this.fCB.peek();
                    if (aVar == null) {
                        ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                        z = false;
                    } else {
                        LinkedList linkedList = aVar.fCO.woe;
                        LinkedList linkedList2 = aVar.fCO.wof;
                        i = aVar.fCP;
                        if (linkedList2.size() != linkedList.size()) {
                            ab.w("MicroMsg.GetContactService", "find warn %s %s", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList.size()));
                        }
                        if (Math.min(linkedList2.size(), linkedList.size()) <= i) {
                            c.this.fCB.poll();
                            if (c.this.fCB.isEmpty()) {
                                ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i), Integer.valueOf(r8));
                                c.this.fCC = 0;
                                c.this.fCF.ae(0, 0);
                                z = false;
                            } else {
                                ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i), Integer.valueOf(r8));
                            }
                        } else {
                            bbv bbv = (bbv) linkedList.get(i);
                            intValue = ((Integer) linkedList2.get(i)).intValue();
                            String bc = bo.bc(aa.a(bbv.wcB), "");
                            String bc2 = bo.bc(bbv.guS, "");
                            arrayList.add(bc);
                            arrayList.add(bc2);
                            switch (intValue) {
                                case -477:
                                    z = d.agM().rY(bc);
                                    boolean rY = d.agM().rY(bc2);
                                    boolean mu = n.mu(bc);
                                    ab.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", Integer.valueOf(intValue), bc, bc2, Boolean.valueOf(z), Boolean.valueOf(rY), Boolean.valueOf(mu));
                                    e.pXa.a(832, 1, 1, false);
                                    z = false;
                                    break;
                                case 0:
                                    String bc3;
                                    if (aVar.fCO.wog != null && aVar.fCO.wog.size() > i) {
                                        if (bc.equals(((cnj) aVar.fCO.wog.get(i)).username)) {
                                            bc3 = bo.bc(((cnj) aVar.fCO.wog.get(i)).xkS, "");
                                            ab.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", bc, bc2, bc3);
                                            com.tencent.mm.plugin.subapp.b.gkF.a(bbv, bc3);
                                            e.pXa.a(832, 0, 1, false);
                                            z = true;
                                            break;
                                        }
                                    }
                                    String str = "MicroMsg.GetContactService";
                                    String str2 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                                    Object[] objArr = new Object[3];
                                    if (aVar.fCO.wog == null) {
                                        bc3 = BuildConfig.COMMAND;
                                    } else {
                                        bc3 = Integer.valueOf(aVar.fCO.wog.size());
                                    }
                                    objArr[0] = bc3;
                                    objArr[1] = Integer.valueOf(i);
                                    objArr[2] = bc;
                                    ab.w(str, str2, objArr);
                                    bc3 = "";
                                    ab.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", bc, bc2, bc3);
                                    com.tencent.mm.plugin.subapp.b.gkF.a(bbv, bc3);
                                    e.pXa.a(832, 0, 1, false);
                                    z = true;
                                default:
                                    z = n.mu(bc);
                                    ab.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", Integer.valueOf(intValue), bc, bc2, Boolean.valueOf(z));
                                    e.pXa.a(832, 2, 1, false);
                                    z = false;
                                    break;
                            }
                            final String str3 = bc;
                            final String str4 = bc2;
                            new ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(16476);
                                    com.tencent.mm.model.ao.b.a aVar = (com.tencent.mm.model.ao.b.a) c.this.fCz.remove(str3);
                                    com.tencent.mm.model.ao.b.a aVar2 = bo.isNullOrNil(str4) ? null : (com.tencent.mm.model.ao.b.a) c.this.fCz.remove(str4);
                                    if (aVar != null) {
                                        aVar.o(str3, z);
                                    }
                                    if (!(aVar2 == null || bo.isNullOrNil(str4))) {
                                        aVar2.o(str4, z);
                                    }
                                    AppMethodBeat.o(16476);
                                }
                            });
                            aVar.fCP++;
                        }
                        i3 = i4 + 1;
                    }
                } else {
                    z = true;
                }
            }
            i = arrayList.size();
            if (i > 0) {
                aw.ZK();
                long iV = com.tencent.mm.model.c.Ru().iV(Thread.currentThread().getId());
                b agM = d.agM();
                for (intValue = 0; intValue < i; intValue++) {
                    agM.rY((String) arrayList.get(intValue));
                }
                aw.ZK();
                com.tencent.mm.model.c.Ru().mB(iV);
            }
            ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.frc + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (bo.anU() - anU) + "ms");
            AppMethodBeat.o(16477);
            return z;
        }
    }, true);
    f<String, Integer> fCy = new com.tencent.mm.memory.a.c(200);
    Map<String, com.tencent.mm.model.ao.b.a> fCz = new HashMap();
    boolean frc = false;
    private long frn = 0;

    class a {
        String aIm;
        int errCode;
        int errType;
        ahu fCO;
        int fCP = 0;

        a() {
        }
    }

    c() {
        AppMethodBeat.i(16478);
        AppMethodBeat.o(16478);
    }

    public final void or(String str) {
        AppMethodBeat.i(16479);
        this.fCz.remove(str);
        AppMethodBeat.o(16479);
    }

    public final void ai(String str, String str2) {
        AppMethodBeat.i(16480);
        ab.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + bo.dpG());
        if (aK(str, str2)) {
            this.fCF.ae(500, 500);
        }
        AppMethodBeat.o(16480);
    }

    public final void a(String str, String str2, com.tencent.mm.model.ao.b.a aVar) {
        AppMethodBeat.i(16482);
        ab.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + bo.dpG());
        if (aK(str, str2)) {
            this.fCz.put(str, aVar);
            this.fCF.ae(0, 0);
        }
        AppMethodBeat.o(16482);
    }

    public final void os(final String str) {
        AppMethodBeat.i(16483);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(16470);
                Object[] toArray = c.this.fCy.keySet().toArray();
                for (Object obj : toArray) {
                    String str = (String) obj;
                    if (str.startsWith(str)) {
                        ab.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", str);
                        c.this.fCy.remove(str);
                    }
                }
                AppMethodBeat.o(16470);
            }
        });
        AppMethodBeat.o(16483);
    }

    private static boolean aK(String str, String str2) {
        AppMethodBeat.i(16484);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(16484);
            return false;
        }
        String Yz = r.Yz();
        String YA = r.YA();
        if (str.equals(Yz) || str.equals(YA)) {
            ab.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + Yz + " alias: " + YA + " ret");
            AppMethodBeat.o(16484);
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.fng = bo.nullAsNil(str2);
        aVar.fCv = bo.anU();
        boolean a = d.agM().a(aVar);
        AppMethodBeat.o(16484);
        return a;
    }

    private void agJ() {
        AppMethodBeat.i(16485);
        String[] strArr = new String[]{String.valueOf(this.fCC), "80"};
        Cursor a = d.agM().fni.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", strArr, 0);
        if (a == null) {
            AppMethodBeat.o(16485);
            return;
        }
        ab.i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(a.getCount()));
        if (a.getCount() <= 0) {
            a.close();
            AppMethodBeat.o(16485);
            return;
        }
        int a2;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        while (a.moveToNext()) {
            LinkedList linkedList5;
            a aVar = new a();
            aVar.username = a.getString(0);
            aVar.fCv = a.getLong(1);
            aVar.type = a.getInt(2);
            aVar.fCw = a.getInt(3);
            aVar.fne = a.getInt(4);
            aVar.fCx = a.getInt(5);
            aVar.fng = a.getString(6);
            aVar.fnh = a.getString(7);
            String username = aVar.getUsername();
            String nullAsNil = bo.nullAsNil(aVar.agH());
            int h = bo.h(Integer.valueOf(aVar.fCx));
            String nullAsNil2 = bo.nullAsNil(aVar.agI());
            this.fCC = aVar.fCv;
            String str = username + "#" + nullAsNil;
            a2 = bo.a((Integer) this.fCy.ai(str), 0);
            if (a2 < 3) {
                this.fCy.k(str, Integer.valueOf(a2 + 1));
                aht aht;
                if (t.mP(username)) {
                    aht = new aht();
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    aht.vEg = linkedList;
                    aht.woa = linkedList2;
                    this.fCA.add(aht);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    ab.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht.vEg.size()), username);
                    linkedList = linkedList2;
                } else if (ad.aox(username)) {
                    aht = new aht();
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    aht.vEg = linkedList;
                    aht.woa = linkedList2;
                    this.fCA.add(aht);
                    linkedList2 = new LinkedList();
                    linkedList5 = new LinkedList();
                    ab.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht.vEg.size()), username);
                    linkedList = linkedList2;
                } else if (h == 1) {
                    linkedList3.add(new Pair(new bts().alV(username), new bts().alV(nullAsNil2)));
                    ab.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", username, Integer.valueOf(h), nullAsNil2);
                    linkedList5 = linkedList2;
                } else {
                    linkedList.add(new bts().alV(username));
                    linkedList2.add(new bts().alV(nullAsNil));
                    ab.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", username, nullAsNil);
                    linkedList5 = linkedList2;
                }
            } else {
                linkedList4.add(username);
                H(username, false);
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
                ab.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", Integer.valueOf(this.fCA.size()), Integer.valueOf(aht2.vEg.size()));
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
                ab.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", str2, Boolean.valueOf(t.kH(str2)));
                if (t.kH(str2)) {
                    d.agM().rY(str2);
                }
                boolean mQ = t.mQ(str2);
                ab.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", str2, Boolean.valueOf(r1));
                if (mQ) {
                    d.agM().rY(str2);
                    e.pXa.a(832, 3, 1, false);
                }
                a2 = i + 1;
            } else {
                AppMethodBeat.o(16485);
                return;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void H(final String str, final boolean z) {
        AppMethodBeat.i(16486);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(16472);
                if (c.this.fCz.containsKey(str)) {
                    com.tencent.mm.model.ao.b.a aVar = (com.tencent.mm.model.ao.b.a) c.this.fCz.get(str);
                    if (aVar != null) {
                        aVar.o(str, z);
                    }
                    c.this.fCz.remove(str);
                }
                AppMethodBeat.o(16472);
            }
        });
        AppMethodBeat.o(16486);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void agK() {
        AppMethodBeat.i(16487);
        if (com.tencent.mm.plugin.subapp.b.gkF.BZ()) {
            ab.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
            AppMethodBeat.o(16487);
        } else {
            long anU = bo.anU();
            if (this.frc && anU - this.frn > 600000) {
                ab.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(anU - this.frn));
                this.frc = false;
            }
            if (this.frc) {
                ab.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.frc + " ret");
                AppMethodBeat.o(16487);
            } else {
                String a;
                aht aht = (aht) this.fCA.poll();
                if (aht == null) {
                    agJ();
                    aht = (aht) this.fCA.poll();
                    if (aht == null || aht.vEg == null || aht.vEg.size() == 0) {
                        ab.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
                        AppMethodBeat.o(16487);
                    }
                }
                aht aht2 = aht;
                this.frn = anU;
                this.frc = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Iterator it = aht2.vEg.iterator();
                while (it.hasNext()) {
                    a = aa.a((bts) it.next());
                    if (t.mP(a)) {
                        linkedList.add(a);
                    }
                    if (ad.aox(a)) {
                        linkedList2.add(a);
                    }
                }
                if (linkedList.size() > 0) {
                    a = (String) linkedList.get(0);
                    if (t.mP(a)) {
                        com.tencent.mm.roomsdk.a.b.alY(a).kd(a).d(new com.tencent.mm.roomsdk.a.b.b() {
                            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                                AppMethodBeat.i(16473);
                                c.this.frc = false;
                                if (i == 0 && i2 == 0) {
                                    if (!c.this.fCA.isEmpty() && c.this.fCF.doT()) {
                                        c.this.fCF.ae(500, 500);
                                    }
                                    boolean rY = d.agM().rY(a);
                                    ab.i("MicroMsg.ActionCallbackFunc", "getChatRoomInfoDetail onResult %s %s", Boolean.valueOf(rY), a);
                                    c.this.H(a, true);
                                    AppMethodBeat.o(16473);
                                    return;
                                }
                                ab.e("MicroMsg.ActionCallbackFunc", "tryStartNetscene onSceneEnd openRoom errType:" + i + " errCode:" + i2 + " will retry");
                                c.this.fCF.ae(10000, 10000);
                                c.this.H(a, false);
                                AppMethodBeat.o(16473);
                            }
                        }).dmX();
                    }
                    AppMethodBeat.o(16487);
                } else if (linkedList2.size() > 0) {
                    a = (String) linkedList2.get(0);
                    alk alk = new alk();
                    alk.geZ = a;
                    String str = "";
                    if (aht2.woa != null && aht2.woa.size() > 0) {
                        str = aa.a((bts) aht2.woa.get(0));
                    }
                    alk.geY = str;
                    com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                    aVar.fsJ = alk;
                    aVar.fsK = new all();
                    aVar.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
                    aVar.fsI = 881;
                    ab.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", str, a);
                    w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                            AppMethodBeat.i(16474);
                            if (mVar.getType() != 881) {
                                AppMethodBeat.o(16474);
                            } else {
                                c.this.frc = false;
                                if (i == 0 && i2 == 0) {
                                    if (!c.this.fCA.isEmpty() && c.this.fCF.doT()) {
                                        c.this.fCF.ae(500, 500);
                                    }
                                    s.a((all) bVar.fsH.fsP);
                                    boolean rY = d.agM().rY(a);
                                    ab.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", Boolean.valueOf(rY), a);
                                    c.this.H(a, true);
                                    AppMethodBeat.o(16474);
                                } else {
                                    ab.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", Integer.valueOf(i), Integer.valueOf(i2), a);
                                    if (i == 4) {
                                        d.agM().rY(a);
                                    }
                                    c.this.fCF.ae(10000, 10000);
                                    c.this.H(a, false);
                                    AppMethodBeat.o(16474);
                                }
                            }
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(16487);
                } else {
                    com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
                    aVar2.fsJ = aht2;
                    aVar2.fsK = new ahu();
                    aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                    aVar2.fsI = FaceMoveUtil.TRIANGLE_COUNT;
                    w.a(aVar2.acD(), new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                            AppMethodBeat.i(16475);
                            if (mVar.getType() != FaceMoveUtil.TRIANGLE_COUNT) {
                                AppMethodBeat.o(16475);
                            } else {
                                c.this.frc = false;
                                if (i == 0 && i2 == 0) {
                                    if (!c.this.fCA.isEmpty() && c.this.fCF.doT()) {
                                        c.this.fCF.ae(500, 500);
                                    }
                                    if (bVar != null) {
                                        a aVar = new a();
                                        aVar.errType = i;
                                        aVar.errCode = i2;
                                        aVar.aIm = str;
                                        aVar.fCO = (ahu) bVar.fsH.fsP;
                                        c.this.fCB.add(aVar);
                                    }
                                    if (!c.this.fCB.isEmpty() && c.this.fCG.doT()) {
                                        c.this.fCG.ae(50, 50);
                                    }
                                    AppMethodBeat.o(16475);
                                } else {
                                    ab.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                                    c.this.fCF.ae(10000, 10000);
                                    AppMethodBeat.o(16475);
                                }
                            }
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(16487);
                }
            }
        }
    }

    public final void aj(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(16481);
        if (!bo.isNullOrNil(str)) {
            String Yz = r.Yz();
            String YA = r.YA();
            if (str.equals(Yz) || str.equals(YA)) {
                ab.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + Yz + " alias: " + YA + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.fnh = bo.nullAsNil(str2);
                aVar.fCx = bo.h(Integer.valueOf(1));
                aVar.fCv = bo.anU();
                z = d.agM().a(aVar);
            }
        }
        if (z) {
            this.fCF.ae(500, 500);
        }
        AppMethodBeat.o(16481);
    }
}
