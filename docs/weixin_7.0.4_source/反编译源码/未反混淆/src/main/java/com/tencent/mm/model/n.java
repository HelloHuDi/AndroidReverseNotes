package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.a.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class n {
    public static f<String, String> fkH = new h(100);

    private static boolean mp(String str) {
        AppMethodBeat.i(5513);
        if (str.toLowerCase().endsWith("@chatroom")) {
            AppMethodBeat.o(5513);
            return true;
        } else if (str.toLowerCase().endsWith("@im.chatroom")) {
            AppMethodBeat.o(5513);
            return true;
        } else {
            AppMethodBeat.o(5513);
            return false;
        }
    }

    public static boolean mq(String str) {
        AppMethodBeat.i(5514);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5514);
            return false;
        }
        boolean drX = oa.drX();
        AppMethodBeat.o(5514);
        return drX;
    }

    public static boolean f(String str, Map<String, String> map) {
        AppMethodBeat.i(5515);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5515);
            return false;
        }
        for (String str2 : oa.afg()) {
            map.put(str2, oa.mJ(str2));
        }
        AppMethodBeat.o(5515);
        return true;
    }

    public static boolean mr(String str) {
        AppMethodBeat.i(5516);
        String oc = ((c) g.K(c.class)).XV().oc(str);
        String Yz = r.Yz();
        if (bo.isNullOrNil(oc) || bo.isNullOrNil(Yz) || !oc.equals(Yz)) {
            AppMethodBeat.o(5516);
            return false;
        }
        AppMethodBeat.o(5516);
        return true;
    }

    public static void a(String str, u uVar, boolean z) {
        AppMethodBeat.i(5517);
        uVar.pq(z);
        ((c) g.K(c.class)).XV().c(uVar, new String[0]);
        String Yz = r.Yz();
        b.alY(str).c(str, Yz, z).dmX();
        bbs bbs = new bbs();
        bbs.vEf = str;
        bbs.jBB = Yz;
        bbs.wGd = 1;
        bbs.pXD = z ? 1 : 2;
        ((j) g.K(j.class)).XL().c(new a(49, bbs));
        AppMethodBeat.o(5517);
    }

    public static String T(List<String> list) {
        AppMethodBeat.i(5518);
        String f = f((List) list, -1);
        AppMethodBeat.o(5518);
        return f;
    }

    public static String f(List<String> list, int i) {
        AppMethodBeat.i(5519);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.o(5519);
            return str;
        }
        str = "";
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                str2 = str + ((j) g.K(j.class)).XM().aoO(str2).Oj();
                if (i3 == i2 && i3 < list.size()) {
                    str = str2 + "...";
                    break;
                } else if (i3 < list.size() - 1) {
                    str2 = str2 + ah.getContext().getString(R.string.ajw);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        AppMethodBeat.o(5519);
        return str;
    }

    public static boolean ms(String str) {
        AppMethodBeat.i(5520);
        String str2 = (String) g.RP().Ry().get(2, null);
        List my = my(str);
        if (my == null) {
            ab.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            AppMethodBeat.o(5520);
            return false;
        } else if (my.size() == 0 || !my.contains(str2)) {
            ab.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + my.size() + " ");
            AppMethodBeat.o(5520);
            return false;
        } else {
            AppMethodBeat.o(5520);
            return true;
        }
    }

    public static boolean mt(String str) {
        AppMethodBeat.i(5521);
        if (!t.mN(str)) {
            AppMethodBeat.o(5521);
            return false;
        } else if (((c) g.K(c.class)).XV().of(str)) {
            List oe = ((c) g.K(c.class)).XV().oe(str);
            if (oe == null || oe.size() == 0) {
                AppMethodBeat.o(5521);
                return true;
            }
            AppMethodBeat.o(5521);
            return false;
        } else {
            ab.d("MicroMsg.ChatroomMembersLogic", "state is die");
            AppMethodBeat.o(5521);
            return true;
        }
    }

    public static boolean mu(String str) {
        AppMethodBeat.i(5522);
        if (t.mN(str)) {
            ab.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
            ag XV = ((c) g.K(c.class)).XV();
            u oa = XV.oa(str);
            if (oa == null) {
                AppMethodBeat.o(5522);
                return false;
            }
            oa.field_roomflag = 1;
            boolean a = XV.a(oa);
            AppMethodBeat.o(5522);
            return a;
        }
        AppMethodBeat.o(5522);
        return false;
    }

    public static boolean a(String str, String str2, qe qeVar, int i, String str3, com.tencent.mm.j.a.a.a aVar, com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(5523);
        if (str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@im.chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) {
            boolean z;
            bd XM = ((j) g.K(j.class)).XM();
            u oa = ((c) g.K(c.class)).XV().oa(str);
            if (oa != null) {
                aVar.cGj = oa.drT();
            } else {
                aVar.cGj = 0;
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            ab.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + qeVar.ehB);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= qeVar.ehB) {
                    break;
                }
                qf qfVar = (qf) qeVar.vXi.get(i3);
                ad aoO = XM.aoO(qfVar.jBB);
                if (aoO == null) {
                    ab.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    com.tencent.mm.j.a.a.b bVar2 = new com.tencent.mm.j.a.a.b();
                    bVar2.userName = qfVar.jBB;
                    bVar2.eoB = qfVar.vXp;
                    bVar2.eoA = qfVar.vXo;
                    if (qeVar.vXj == 0) {
                        bVar2.eoz = qfVar.vXl;
                        if (!bo.isNullOrNil(qfVar.vXn)) {
                            com.tencent.mm.ah.h qo = o.act().qo(qfVar.jBB);
                            if (qo == null) {
                                qo = new com.tencent.mm.ah.h();
                                qo.username = qfVar.jBB;
                            }
                            qo.frW = qfVar.vXm;
                            qo.frV = qfVar.vXn;
                            qo.dtR = 3;
                            qo.cB(!bo.isNullOrNil(qfVar.vXm));
                            o.act().b(qo);
                        }
                    }
                    if (oa != null) {
                        com.tencent.mm.j.a.a.b aon = oa.aon(qfVar.jBB);
                        if (aon != null) {
                            bVar2.eoz = aon.eoz;
                            bVar2.eoB = bo.isNullOrNil(bVar2.eoB) ? aon.eoB : bVar2.eoB;
                        }
                    }
                    aVar.eow.add(bVar2);
                    if (((int) aoO.ewQ) == 0) {
                        aoO.setUsername(qfVar.jBB);
                        if (qfVar.jCH != null) {
                            aoO.iB(qfVar.jCH);
                        }
                        aoO.NA();
                        XM.Z(aoO);
                        z2 = true;
                    }
                    arrayList.add(aoO.field_username);
                }
                i2 = i3 + 1;
            }
            ab.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + bVar + " publish: " + z2 + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z2) {
                b.alY(str).D(str, aVar.cGj).dmX();
            } else if (oa == null) {
                b.alY(str).D(str, 0).dmX();
            }
            u oa2 = ((c) g.K(c.class)).XV().oa(str);
            if (oa2 == null) {
                oa2 = new u();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            oa2.field_chatroomname = str;
            oa2.field_roomowner = str2;
            u ep = oa2.ep(arrayList);
            ep.field_chatroomStatus = i;
            ep.field_displayname = T(arrayList);
            if (qeVar.vXj != 0) {
                z = true;
            } else {
                z = false;
            }
            ep.a(str3, aVar, z).field_memberCount = arrayList.size();
            z2 = a(oa2);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            String str4 = "MicroMsg.ChatroomMembersLogic";
            String str5 = "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Long.valueOf(currentTimeMillis2);
            objArr[2] = Boolean.valueOf(oa2.drU());
            objArr[3] = Integer.valueOf(oa2.drR() == null ? 0 : oa2.drR().cGj);
            objArr[4] = Integer.valueOf(oa2.drR() == null ? 0 : oa2.drR().eoy);
            ab.i(str4, str5, objArr);
            if (oa2.drU()) {
                ab.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(oa2.drT()));
                as asVar = new as();
                asVar.ctO.username = str;
                com.tencent.mm.sdk.b.a.xxA.m(asVar);
            }
            AppMethodBeat.o(5523);
            return z2;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + qeVar.ehB);
        AppMethodBeat.o(5523);
        return false;
    }

    static {
        AppMethodBeat.i(5546);
        AppMethodBeat.o(5546);
    }

    public static boolean a(String str, qe qeVar) {
        AppMethodBeat.i(5524);
        if (qeVar == null) {
            ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            AppMethodBeat.o(5524);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            AppMethodBeat.o(5524);
            return false;
        } else if (t.kH(str)) {
            ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", str);
            AppMethodBeat.o(5524);
            return false;
        } else {
            String a = aa.a(qeVar.vXk);
            if (bo.isNullOrNil(a)) {
                ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
                AppMethodBeat.o(5524);
                return false;
            }
            ab.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", a, Integer.valueOf(qeVar.vXi.size()));
            u oa = ((c) g.K(c.class)).XV().oa(a);
            if (oa != null && qeVar.vXi.size() > 0 && oa.afg().contains(((qf) qeVar.vXi.get(0)).jBB)) {
                com.tencent.mm.j.a.a.b aon = oa.aon(((qf) qeVar.vXi.get(0)).jBB);
                if (aon != null) {
                    ab.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", r0, aon.eoz);
                    aon.eoB = ((qf) qeVar.vXi.get(0)).vXp;
                    a(oa);
                } else {
                    ab.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", r0);
                }
                AppMethodBeat.o(5524);
                return true;
            } else if (oa == null || qeVar.vXi.size() <= 0) {
                if (qeVar.vXi.size() <= 0) {
                    ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (oa != null) {
                    ab.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                AppMethodBeat.o(5524);
                return false;
            } else {
                at atVar = new at();
                atVar.ctP.username = ((qf) qeVar.vXi.get(0)).jBB;
                atVar.ctP.ctQ = ((qf) qeVar.vXi.get(0)).vXp;
                fkH.put(a + "#" + atVar.ctP.username, atVar.ctP.ctQ);
                com.tencent.mm.sdk.b.a.xxA.m(atVar);
                AppMethodBeat.o(5524);
                return false;
            }
        }
    }

    public static String Z(String str, String str2) {
        AppMethodBeat.i(5525);
        String str3 = str2 + "#" + str;
        if (fkH.ak(str3)) {
            str3 = (String) fkH.get(str3);
            AppMethodBeat.o(5525);
            return str3;
        }
        str3 = "";
        AppMethodBeat.o(5525);
        return str3;
    }

    public static boolean a(u uVar) {
        AppMethodBeat.i(5526);
        if (uVar == null) {
            ab.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            AppMethodBeat.o(5526);
            return false;
        }
        boolean a = ((c) g.K(c.class)).XV().a(uVar);
        if (a) {
            aa(uVar.field_chatroomname, uVar.field_roomowner);
        }
        AppMethodBeat.o(5526);
        return a;
    }

    private static void aa(String str, String str2) {
        AppMethodBeat.i(5527);
        ab.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", Integer.valueOf(1));
        bd XM = ((j) g.K(j.class)).XM();
        ad aoO = XM.aoO(str);
        if (!(((int) aoO.ewQ) == 0 || bo.isNullOrNil(str2) || bo.isNullOrNil(r.Yz()))) {
            if (str2.equals(r.Yz())) {
                aoO.ji(1);
            } else {
                aoO.ji(0);
            }
            XM.b(str, aoO);
        }
        AppMethodBeat.o(5527);
    }

    public static boolean a(String str, vk vkVar) {
        AppMethodBeat.i(5528);
        if (!mp(str) || vkVar.ehB == 0) {
            ab.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + vkVar.ehB);
            AppMethodBeat.o(5528);
            return false;
        }
        ag XV = ((c) g.K(c.class)).XV();
        u oa = XV.oa(str);
        List aor = u.aor(oa.field_memberlist);
        ab.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + aor.size());
        Iterator it = vkVar.vEh.iterator();
        while (it.hasNext()) {
            aor.remove(aa.a(((vu) it.next()).wcG));
        }
        ab.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + aor.size());
        u ep = oa.ep(aor);
        ep.field_displayname = T(aor);
        ep.field_memberCount = aor.size();
        boolean a = XV.a(oa);
        ab.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(a)));
        AppMethodBeat.o(5528);
        return a;
    }

    public static boolean a(String str, cb cbVar) {
        AppMethodBeat.i(5529);
        if (!mp(str) || cbVar.ehB == 0) {
            ab.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + cbVar.ehB);
            AppMethodBeat.o(5529);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        bd XM = ((j) g.K(j.class)).XM();
        for (int i = 0; i < cbVar.ehB; i++) {
            String a = aa.a(((baz) cbVar.vEh.get(i)).wcG);
            if (((baz) cbVar.vEh.get(i)).wFJ == 0) {
                if (bo.isNullOrNil(a)) {
                    ab.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    ap apVar;
                    ad aoO = XM.aoO(a);
                    if (((int) aoO.ewQ) != 0) {
                        aoO.NA();
                        XM.b(aoO.field_username, aoO);
                        apVar = aoO;
                    } else {
                        apVar = a(aoO, (baz) cbVar.vEh.get(i));
                        XM.Z(apVar);
                    }
                    arrayList.add(apVar.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(5529);
            return false;
        }
        boolean a2 = a(str, arrayList, null);
        AppMethodBeat.o(5529);
        return a2;
    }

    public static boolean mv(String str) {
        AppMethodBeat.i(5530);
        if (str.toLowerCase().endsWith("@groupcard")) {
            bd XM = ((j) g.K(j.class)).XM();
            if (XM.aoQ(str)) {
                XM.aoU(str);
            } else {
                ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
            }
            boolean mx = mx(str);
            AppMethodBeat.o(5530);
            return mx;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
        AppMethodBeat.o(5530);
        return false;
    }

    public static boolean mw(String str) {
        AppMethodBeat.i(5531);
        if (mp(str)) {
            bd XM = ((j) g.K(j.class)).XM();
            if (XM.aoQ(str)) {
                XM.aoU(str);
            } else {
                ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            boolean mx = mx(str);
            AppMethodBeat.o(5531);
            return mx;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        AppMethodBeat.o(5531);
        return false;
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List my;
        int i = 0;
        AppMethodBeat.i(5532);
        ag XV = ((c) g.K(c.class)).XV();
        u ob = XV.ob(str);
        if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            my = my(str);
        } else {
            my = new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        u ep;
        boolean a;
        if (my != null) {
            for (int i2 = 0; i2 < my.size(); i2++) {
                linkedList.add(my.get(i2));
            }
            while (i < arrayList.size()) {
                if (!my.contains(arrayList.get(i))) {
                    linkedList.add(arrayList.get(i));
                }
                i++;
            }
            if (!bo.isNullOrNil(str2)) {
                ob.field_roomowner = str2;
            }
            ep = ob.ep(linkedList);
            ep.field_displayname = T(linkedList);
            ep.field_memberCount = linkedList.size();
            a = XV.a(ob);
            AppMethodBeat.o(5532);
            return a;
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!bo.isNullOrNil(str2)) {
            ob.field_roomowner = str2;
        }
        ep = ob.ep(linkedList);
        ep.field_displayname = T(linkedList);
        ep.field_memberCount = linkedList.size();
        ob.field_roomowner = str2;
        a = XV.a(ob);
        ab.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(a)));
        AppMethodBeat.o(5532);
        return a;
    }

    private static boolean mx(String str) {
        AppMethodBeat.i(5533);
        boolean og = ((c) g.K(c.class)).XV().og(str);
        AppMethodBeat.o(5533);
        return og;
    }

    public static List<String> my(String str) {
        AppMethodBeat.i(5534);
        if (str == null) {
            ab.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            AppMethodBeat.o(5534);
            return null;
        } else if (mp(str)) {
            List<String> oe = ((c) g.K(c.class)).XV().oe(str);
            AppMethodBeat.o(5534);
            return oe;
        } else {
            ab.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            AppMethodBeat.o(5534);
            return null;
        }
    }

    public static List<String> mz(String str) {
        AppMethodBeat.i(5535);
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> oe = ((c) g.K(c.class)).XV().oe(str);
            AppMethodBeat.o(5535);
            return oe;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        AppMethodBeat.o(5535);
        return null;
    }

    public static int mA(String str) {
        AppMethodBeat.i(5536);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ag XV = ((c) g.K(c.class)).XV();
            if (XV != null) {
                int oh = XV.oh(str);
                ab.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(5536);
                return oh;
            }
            ab.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(5536);
            return 0;
        } catch (Throwable th) {
            ab.i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(5536);
        }
    }

    public static List<String> mB(String str) {
        int i = 0;
        AppMethodBeat.i(5537);
        if (mp(str)) {
            List<String> my = my(str);
            if (my == null || my.size() <= 0) {
                AppMethodBeat.o(5537);
                return null;
            }
            String str2 = (String) g.RP().Ry().get(2, null);
            boolean z = str2 != null && str2.length() > 0;
            Assert.assertTrue(z);
            while (i < my.size()) {
                if (((String) my.get(i)).equals(str2)) {
                    my.remove(i);
                    break;
                }
                i++;
            }
            if (my.size() <= 0) {
                AppMethodBeat.o(5537);
                return null;
            }
            AppMethodBeat.o(5537);
            return my;
        }
        ab.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        AppMethodBeat.o(5537);
        return null;
    }

    public static ad a(ad adVar, baz baz) {
        AppMethodBeat.i(5538);
        adVar.setUsername(aa.a(baz.wcG));
        adVar.iB(aa.a(baz.wcG));
        adVar.iC(aa.a(baz.wcG));
        adVar.iD(aa.a(baz.wcf));
        adVar.hA(baz.guN);
        adVar.iz(aa.a(baz.wFK));
        adVar.iG(aa.a(baz.wFL));
        adVar.iF(aa.a(baz.wcf));
        adVar.hD(baz.wbA);
        adVar.hF(baz.guR);
        adVar.iW(RegionCodeDecoder.aC(baz.guW, baz.guO, baz.guP));
        adVar.iQ(baz.guQ);
        AppMethodBeat.o(5538);
        return adVar;
    }

    public static String ab(String str, String str2) {
        AppMethodBeat.i(5539);
        ag XV = ((c) g.K(c.class)).XV();
        if (XV == null) {
            ab.e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
            AppMethodBeat.o(5539);
            return null;
        }
        u oa = XV.oa(str2);
        if (oa == null) {
            AppMethodBeat.o(5539);
            return null;
        }
        String mJ = oa.mJ(str);
        AppMethodBeat.o(5539);
        return mJ;
    }

    public static String mC(String str) {
        AppMethodBeat.i(5540);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5540);
            return null;
        }
        String str2 = oa.field_chatroomnotice;
        AppMethodBeat.o(5540);
        return str2;
    }

    public static boolean N(String str, int i) {
        AppMethodBeat.i(5541);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5541);
            return false;
        } else if (oa.field_chatroomVersion < i) {
            AppMethodBeat.o(5541);
            return true;
        } else {
            AppMethodBeat.o(5541);
            return false;
        }
    }

    public static String mD(String str) {
        AppMethodBeat.i(5542);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5542);
            return null;
        }
        String str2 = oa.field_chatroomnoticeEditor;
        AppMethodBeat.o(5542);
        return str2;
    }

    public static long mE(String str) {
        AppMethodBeat.i(5543);
        u oa = ((c) g.K(c.class)).XV().oa(str);
        if (oa == null) {
            AppMethodBeat.o(5543);
            return -1;
        }
        long j = oa.field_chatroomnoticePublishTime;
        AppMethodBeat.o(5543);
        return j;
    }

    public static void a(String str, String str2, String str3, long j, int i, int i2) {
        AppMethodBeat.i(5544);
        ag XV = ((c) g.K(c.class)).XV();
        u oa = XV.oa(str);
        if (oa == null) {
            AppMethodBeat.o(5544);
            return;
        }
        oa.field_chatroomVersion = i;
        oa.field_chatroomnoticePublishTime = j;
        oa.field_chatroomnoticeEditor = str3;
        oa.field_chatroomnotice = str2;
        oa.field_chatroomStatus = i2;
        XV.a(oa);
        AppMethodBeat.o(5544);
    }

    public static void O(String str, int i) {
        AppMethodBeat.i(5545);
        ag XV = ((c) g.K(c.class)).XV();
        u oa = XV.oa(str);
        if (oa == null) {
            AppMethodBeat.o(5545);
            return;
        }
        com.tencent.mm.j.a.a.a drY = oa.drY();
        drY.type = i;
        oa.a(str, drY, false);
        XV.a(oa);
        AppMethodBeat.o(5545);
    }
}
