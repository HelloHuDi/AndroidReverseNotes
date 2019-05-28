package com.tencent.p177mm.plugin.p1014q;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p346f.C45745h;
import com.tencent.p177mm.plugin.backup.p921i.C19989l;
import com.tencent.p177mm.plugin.backup.p921i.C38663k;
import com.tencent.p177mm.plugin.p1014q.C12870a.C12871a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.C46545gv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.q.c */
public final class C21515c {
    boolean oFo = false;
    C12871a oFp;

    /* renamed from: com.tencent.mm.plugin.q.c$a */
    public static class C21516a {
        public String jrd;

        public C21516a(String str) {
            this.jrd = str;
        }
    }

    public final LinkedList<C21516a> bQW() {
        AppMethodBeat.m2504i(22894);
        long anU = C5046bo.anU();
        LinkedList<C21516a> linkedList = new LinkedList();
        Cursor c = C38658d.aUr().aUs().mo61499XR().mo15804c(C1855t.fkP, C38635g.m65509Ko(), "*");
        if (c.getCount() == 0) {
            C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
            c.close();
            AppMethodBeat.m2505o(22894);
            return linkedList;
        }
        C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", Integer.valueOf(c.getCount()));
        int i = 0;
        while (c.moveToNext()) {
            if (this.oFo) {
                c.close();
                C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
                AppMethodBeat.m2505o(22894);
                return linkedList;
            } else if (i >= C28723b.oFj) {
                C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", Integer.valueOf(i));
                break;
            } else {
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(c);
                if (!C5046bo.isNullOrNil(c7617ak.field_username)) {
                    C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", c7617ak.field_username, Integer.valueOf(C38658d.aUr().aUs().mo61498XO().mo15262Rp(c7617ak.field_username)), Integer.valueOf(i));
                    if (C38658d.aUr().aUs().mo61498XO().mo15262Rp(c7617ak.field_username) > 0) {
                        linkedList.add(new C21516a(c7617ak.field_username));
                        i++;
                    }
                }
            }
        }
        c.close();
        C4990ab.m7416i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + C5046bo.m7566gb(anU));
        AppMethodBeat.m2505o(22894);
        return linkedList;
    }

    /* renamed from: RR */
    public static LinkedList<C21516a> m32969RR(String str) {
        AppMethodBeat.m2504i(22895);
        LinkedList linkedList = new LinkedList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22895);
        } else {
            C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", str, Integer.valueOf(C38658d.aUr().aUs().mo61498XO().mo15262Rp(str)));
            if (C38658d.aUr().aUs().mo61498XO().mo15262Rp(str) <= 0) {
                AppMethodBeat.m2505o(22895);
            } else {
                linkedList.add(new C21516a(str));
                AppMethodBeat.m2505o(22895);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public final void mo36992a(C46141d c46141d, LinkedList<C21516a> linkedList, long j, long j2, int i) {
        AppMethodBeat.m2504i(22896);
        final LinkedList<C21516a> linkedList2 = linkedList;
        final C46141d c46141d2 = c46141d;
        final long j3 = j;
        final long j4 = j2;
        final int i2 = i;
        C7305d.m12285a(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(22893);
                long anU = C5046bo.anU();
                String str;
                if (linkedList2 == null || linkedList2.size() <= 0) {
                    str = "MicroMsg.MsgSynchronizePack";
                    String str2 = "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(linkedList2 == null ? -1 : linkedList2.size());
                    C4990ab.m7413e(str, str2, objArr);
                    if (C21515c.this.oFp != null) {
                        C21515c.this.oFp.onCancel();
                    }
                    AppMethodBeat.m2505o(22893);
                    return;
                }
                C5730e.m8618N(C43398g.bQY(), true);
                C5730e.m8618N(C43398g.bQZ(), true);
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                C5730e.m8618N(stringBuilder.append(C18628c.getAccPath()).append("msgsynchronize/").toString(), true);
                stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                C5730e.m8618N(stringBuilder.append(C18628c.getAccPath()).append("msgsynchronize.zip").toString(), true);
                LinkedList linkedList = new LinkedList();
                String str3 = (String) C38658d.aUr().aUs().mo61496Ry().get(2, null);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PLong pLong = new PLong();
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    C21516a c21516a = (C21516a) it.next();
                    if (!C21515c.this.oFo) {
                        int i;
                        C7617ak aoZ = C38658d.aUr().aUs().mo61499XR().aoZ(c21516a.jrd);
                        if (aoZ != null) {
                            i = aoZ.field_unReadCount;
                        } else {
                            i = 0;
                        }
                        if (!c46141d2.action.equals(C28723b.oFd)) {
                            if (pInt2.value >= C28723b.oFj) {
                                break;
                            }
                            C38663k c38663k = new C38663k();
                            c38663k.jBB = c21516a.jrd;
                            c38663k.jBz = (int) (C38658d.aUr().aUs().mo61498XO().mo15266Rt(c21516a.jrd) / 1000);
                            c38663k.jBA = i;
                            linkedList.add(c38663k);
                            pInt2.value++;
                            if (pInt.value < C28723b.oFh) {
                                C21515c.this.mo36993a(c46141d2, c21516a, j3, j4, str3, i, pInt, pLong, i2);
                            }
                        } else {
                            C21515c.this.mo36993a(c46141d2, c21516a, j3, j4, str3, i, pInt, pLong, i2);
                            if (pLong.value >= ((long) C28723b.oFn)) {
                                C4990ab.m7413e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", Long.valueOf(pLong.value));
                                break;
                            }
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
                        break;
                    }
                }
                if (C21515c.this.oFo) {
                    C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
                    AppMethodBeat.m2505o(22893);
                    return;
                }
                if (!c46141d2.action.equals(C28723b.oFd)) {
                    C19989l c19989l = new C19989l();
                    c19989l.jBC = linkedList;
                    c19989l.jBD = C41789d.akP().dtd();
                    try {
                        C43398g.m77455f(C43398g.bQX(), "sessionlist", c19989l.toByteArray());
                        C4990ab.m7416i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", Integer.valueOf(c19989l.jBC.size()), e.getMessage());
                    }
                }
                String bQY = C43398g.bQY();
                str = C43398g.bQZ();
                if (!(bQY == null || bQY.isEmpty())) {
                    C5730e.m8637m(Collections.singletonList(bQY), str);
                }
                C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", Integer.valueOf(pInt.value), Long.valueOf(pLong.value), Long.valueOf(C5730e.asZ(C43398g.bQZ()) / 1024), Long.valueOf(C5046bo.m7566gb(anU)));
                C46141d c46141d = c46141d2;
                long j = (long) pInt.value;
                long j2 = pLong.value;
                long j3 /= 1024;
                c46141d.oFv = j;
                c46141d.oFw = j2;
                c46141d.oFx = j3;
                c46141d.ecX = new String(str3);
                if (C21515c.this.oFp != null) {
                    C21515c.this.oFp.mo24894a(c46141d2, C43398g.bQZ(), linkedList2.size());
                }
                AppMethodBeat.m2505o(22893);
            }
        }, "msgSynchronizePackThread", 10).start();
        AppMethodBeat.m2505o(22896);
    }

    /* renamed from: a */
    public final boolean mo36993a(C46141d c46141d, C21516a c21516a, long j, long j2, String str, int i, PInt pInt, PLong pLong, int i2) {
        AppMethodBeat.m2504i(22897);
        boolean equals = c46141d.action.equals(C28723b.oFd);
        C9638aw.m17190ZK();
        if (C7616ad.m13547Mn(C18628c.m29078XM().aoO(c21516a.jrd).field_verifyFlag)) {
            AppMethodBeat.m2505o(22897);
            return true;
        }
        C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", c21516a.jrd, Integer.valueOf(i));
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList(i2);
        int u = C38658d.aUr().aUs().mo61498XO().mo15352u(c21516a.jrd, j, j2);
        if (u <= 0) {
            C4990ab.m7416i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.m2505o(22897);
            return false;
        }
        Cursor b = C38658d.aUr().aUs().mo61498XO().mo15301b(c21516a.jrd, j, j2, i2);
        if (equals) {
            if (u > i2) {
                c46141d.oFz = 0;
            } else {
                c46141d.oFz = 1;
            }
        }
        while (b.moveToNext()) {
            if (this.oFo) {
                C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                b.close();
                AppMethodBeat.m2505o(22897);
                return false;
            }
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(b);
            if (c7620bi.field_createTime >= j && c7620bi.field_createTime <= j2) {
                arrayList.add(c7620bi);
            }
        }
        b.close();
        if (arrayList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.m2505o(22897);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C7620bi c7620bi2 = (C7620bi) it.next();
            if (this.oFo) {
                C4990ab.m7412e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                AppMethodBeat.m2505o(22897);
                return false;
            }
            Object a;
            try {
                a = C45745h.m84542a(c7620bi2, false, str, new PLong(), new LinkedList(), null, i > 0, true, 0);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "packMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i--;
            }
        }
        C4990ab.m7411d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", Integer.valueOf(linkedList.size()));
        C46545gv c46545gv = new C46545gv();
        c46545gv.jBw = linkedList;
        c46545gv.jBv = linkedList.size();
        try {
            C43398g.m77455f(C43398g.bQX(), "MSG_" + linkedList.size() + "_" + c21516a.jrd + "_" + C5046bo.anU(), c46545gv.toByteArray());
            C4990ab.m7417i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", r4);
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", Integer.valueOf(c46545gv.jBv), e2.getMessage());
        }
        pInt.value++;
        AppMethodBeat.m2505o(22897);
        return true;
    }
}
