package com.tencent.mm.plugin.q;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    boolean oFo = false;
    com.tencent.mm.plugin.q.a.a oFp;

    public static class a {
        public String jrd;

        public a(String str) {
            this.jrd = str;
        }
    }

    public final LinkedList<a> bQW() {
        AppMethodBeat.i(22894);
        long anU = bo.anU();
        LinkedList<a> linkedList = new LinkedList();
        Cursor c = d.aUr().aUs().XR().c(t.fkP, g.Ko(), "*");
        if (c.getCount() == 0) {
            ab.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
            c.close();
            AppMethodBeat.o(22894);
            return linkedList;
        }
        ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", Integer.valueOf(c.getCount()));
        int i = 0;
        while (c.moveToNext()) {
            if (this.oFo) {
                c.close();
                ab.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
                AppMethodBeat.o(22894);
                return linkedList;
            } else if (i >= b.oFj) {
                ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", Integer.valueOf(i));
                break;
            } else {
                ak akVar = new ak();
                akVar.d(c);
                if (!bo.isNullOrNil(akVar.field_username)) {
                    ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", akVar.field_username, Integer.valueOf(d.aUr().aUs().XO().Rp(akVar.field_username)), Integer.valueOf(i));
                    if (d.aUr().aUs().XO().Rp(akVar.field_username) > 0) {
                        linkedList.add(new a(akVar.field_username));
                        i++;
                    }
                }
            }
        }
        c.close();
        ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bo.gb(anU));
        AppMethodBeat.o(22894);
        return linkedList;
    }

    public static LinkedList<a> RR(String str) {
        AppMethodBeat.i(22895);
        LinkedList linkedList = new LinkedList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(22895);
        } else {
            ab.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", str, Integer.valueOf(d.aUr().aUs().XO().Rp(str)));
            if (d.aUr().aUs().XO().Rp(str) <= 0) {
                AppMethodBeat.o(22895);
            } else {
                linkedList.add(new a(str));
                AppMethodBeat.o(22895);
            }
        }
        return linkedList;
    }

    public final void a(d dVar, LinkedList<a> linkedList, long j, long j2, int i) {
        AppMethodBeat.i(22896);
        final LinkedList<a> linkedList2 = linkedList;
        final d dVar2 = dVar;
        final long j3 = j;
        final long j4 = j2;
        final int i2 = i;
        com.tencent.mm.sdk.g.d.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22893);
                long anU = bo.anU();
                String str;
                if (linkedList2 == null || linkedList2.size() <= 0) {
                    str = "MicroMsg.MsgSynchronizePack";
                    String str2 = "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(linkedList2 == null ? -1 : linkedList2.size());
                    ab.e(str, str2, objArr);
                    if (c.this.oFp != null) {
                        c.this.oFp.onCancel();
                    }
                    AppMethodBeat.o(22893);
                    return;
                }
                e.N(g.bQY(), true);
                e.N(g.bQZ(), true);
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                e.N(stringBuilder.append(com.tencent.mm.model.c.getAccPath()).append("msgsynchronize/").toString(), true);
                stringBuilder = new StringBuilder();
                aw.ZK();
                e.N(stringBuilder.append(com.tencent.mm.model.c.getAccPath()).append("msgsynchronize.zip").toString(), true);
                LinkedList linkedList = new LinkedList();
                String str3 = (String) d.aUr().aUs().Ry().get(2, null);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PLong pLong = new PLong();
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (!c.this.oFo) {
                        int i;
                        ak aoZ = d.aUr().aUs().XR().aoZ(aVar.jrd);
                        if (aoZ != null) {
                            i = aoZ.field_unReadCount;
                        } else {
                            i = 0;
                        }
                        if (!dVar2.action.equals(b.oFd)) {
                            if (pInt2.value >= b.oFj) {
                                break;
                            }
                            k kVar = new k();
                            kVar.jBB = aVar.jrd;
                            kVar.jBz = (int) (d.aUr().aUs().XO().Rt(aVar.jrd) / 1000);
                            kVar.jBA = i;
                            linkedList.add(kVar);
                            pInt2.value++;
                            if (pInt.value < b.oFh) {
                                c.this.a(dVar2, aVar, j3, j4, str3, i, pInt, pLong, i2);
                            }
                        } else {
                            c.this.a(dVar2, aVar, j3, j4, str3, i, pInt, pLong, i2);
                            if (pLong.value >= ((long) b.oFn)) {
                                ab.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", Long.valueOf(pLong.value));
                                break;
                            }
                        }
                    } else {
                        ab.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
                        break;
                    }
                }
                if (c.this.oFo) {
                    ab.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
                    AppMethodBeat.o(22893);
                    return;
                }
                if (!dVar2.action.equals(b.oFd)) {
                    l lVar = new l();
                    lVar.jBC = linkedList;
                    lVar.jBD = com.tencent.mm.bi.d.akP().dtd();
                    try {
                        g.f(g.bQX(), "sessionlist", lVar.toByteArray());
                        ab.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", Integer.valueOf(lVar.jBC.size()), e.getMessage());
                    }
                }
                String bQY = g.bQY();
                str = g.bQZ();
                if (!(bQY == null || bQY.isEmpty())) {
                    e.m(Collections.singletonList(bQY), str);
                }
                ab.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", Integer.valueOf(pInt.value), Long.valueOf(pLong.value), Long.valueOf(e.asZ(g.bQZ()) / 1024), Long.valueOf(bo.gb(anU)));
                d dVar = dVar2;
                long j = (long) pInt.value;
                long j2 = pLong.value;
                long j3 /= 1024;
                dVar.oFv = j;
                dVar.oFw = j2;
                dVar.oFx = j3;
                dVar.ecX = new String(str3);
                if (c.this.oFp != null) {
                    c.this.oFp.a(dVar2, g.bQZ(), linkedList2.size());
                }
                AppMethodBeat.o(22893);
            }
        }, "msgSynchronizePackThread", 10).start();
        AppMethodBeat.o(22896);
    }

    public final boolean a(d dVar, a aVar, long j, long j2, String str, int i, PInt pInt, PLong pLong, int i2) {
        AppMethodBeat.i(22897);
        boolean equals = dVar.action.equals(b.oFd);
        aw.ZK();
        if (ad.Mn(com.tencent.mm.model.c.XM().aoO(aVar.jrd).field_verifyFlag)) {
            AppMethodBeat.o(22897);
            return true;
        }
        ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", aVar.jrd, Integer.valueOf(i));
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList(i2);
        int u = d.aUr().aUs().XO().u(aVar.jrd, j, j2);
        if (u <= 0) {
            ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.o(22897);
            return false;
        }
        Cursor b = d.aUr().aUs().XO().b(aVar.jrd, j, j2, i2);
        if (equals) {
            if (u > i2) {
                dVar.oFz = 0;
            } else {
                dVar.oFz = 1;
            }
        }
        while (b.moveToNext()) {
            if (this.oFo) {
                ab.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                b.close();
                AppMethodBeat.o(22897);
                return false;
            }
            bi biVar = new bi();
            biVar.d(b);
            if (biVar.field_createTime >= j && biVar.field_createTime <= j2) {
                arrayList.add(biVar);
            }
        }
        b.close();
        if (arrayList.size() <= 0) {
            ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.o(22897);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bi biVar2 = (bi) it.next();
            if (this.oFo) {
                ab.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                AppMethodBeat.o(22897);
                return false;
            }
            Object a;
            try {
                a = h.a(biVar2, false, str, new PLong(), new LinkedList(), null, i > 0, true, 0);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "packMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i--;
            }
        }
        ab.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", Integer.valueOf(linkedList.size()));
        gv gvVar = new gv();
        gvVar.jBw = linkedList;
        gvVar.jBv = linkedList.size();
        try {
            g.f(g.bQX(), "MSG_" + linkedList.size() + "_" + aVar.jrd + "_" + bo.anU(), gvVar.toByteArray());
            ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", r4);
        } catch (Exception e2) {
            ab.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", Integer.valueOf(gvVar.jBv), e2.getMessage());
        }
        pInt.value++;
        AppMethodBeat.o(22897);
        return true;
    }
}
