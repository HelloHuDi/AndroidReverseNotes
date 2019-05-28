package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p230g.p231a.C41965as;
import com.tencent.p177mm.p230g.p231a.C41966at;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.p712j.p713a.p714a.C6593b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.C30236vu;
import com.tencent.p177mm.protocal.protobuf.C35910cb;
import com.tencent.p177mm.protocal.protobuf.C7280qe;
import com.tencent.p177mm.protocal.protobuf.C7281qf;
import com.tencent.p177mm.protocal.protobuf.C7555vk;
import com.tencent.p177mm.protocal.protobuf.baz;
import com.tencent.p177mm.protocal.protobuf.bbs;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.n */
public final class C37921n {
    public static C1177f<String, String> fkH = new C6294h(100);

    /* renamed from: mp */
    private static boolean m64065mp(String str) {
        AppMethodBeat.m2504i(5513);
        if (str.toLowerCase().endsWith("@chatroom")) {
            AppMethodBeat.m2505o(5513);
            return true;
        } else if (str.toLowerCase().endsWith("@im.chatroom")) {
            AppMethodBeat.m2505o(5513);
            return true;
        } else {
            AppMethodBeat.m2505o(5513);
            return false;
        }
    }

    /* renamed from: mq */
    public static boolean m64066mq(String str) {
        AppMethodBeat.m2504i(5514);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5514);
            return false;
        }
        boolean drX = oa.drX();
        AppMethodBeat.m2505o(5514);
        return drX;
    }

    /* renamed from: f */
    public static boolean m64059f(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(5515);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5515);
            return false;
        }
        for (String str2 : oa.afg()) {
            map.put(str2, oa.mo16807mJ(str2));
        }
        AppMethodBeat.m2505o(5515);
        return true;
    }

    /* renamed from: mr */
    public static boolean m64067mr(String str) {
        AppMethodBeat.m2504i(5516);
        String oc = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14887oc(str);
        String Yz = C1853r.m3846Yz();
        if (C5046bo.isNullOrNil(oc) || C5046bo.isNullOrNil(Yz) || !oc.equals(Yz)) {
            AppMethodBeat.m2505o(5516);
            return false;
        }
        AppMethodBeat.m2505o(5516);
        return true;
    }

    /* renamed from: a */
    public static void m64048a(String str, C7577u c7577u, boolean z) {
        AppMethodBeat.m2504i(5517);
        c7577u.mo16808pq(z);
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10103c(c7577u, new String[0]);
        String Yz = C1853r.m3846Yz();
        C30262b.alY(str).mo20637c(str, Yz, z).dmX();
        bbs bbs = new bbs();
        bbs.vEf = str;
        bbs.jBB = Yz;
        bbs.wGd = 1;
        bbs.pXD = z ? 1 : 2;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(49, bbs));
        AppMethodBeat.m2505o(5517);
    }

    /* renamed from: T */
    public static String m64045T(List<String> list) {
        AppMethodBeat.m2504i(5518);
        String f = C37921n.m64058f((List) list, -1);
        AppMethodBeat.m2505o(5518);
        return f;
    }

    /* renamed from: f */
    public static String m64058f(List<String> list, int i) {
        AppMethodBeat.m2504i(5519);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(5519);
            return str;
        }
        str = "";
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                str2 = str + ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2).mo16707Oj();
                if (i3 == i2 && i3 < list.size()) {
                    str = str2 + "...";
                    break;
                } else if (i3 < list.size() - 1) {
                    str2 = str2 + C4996ah.getContext().getString(C25738R.string.ajw);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        AppMethodBeat.m2505o(5519);
        return str;
    }

    /* renamed from: ms */
    public static boolean m64068ms(String str) {
        AppMethodBeat.m2504i(5520);
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        List my = C37921n.m64074my(str);
        if (my == null) {
            C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            AppMethodBeat.m2505o(5520);
            return false;
        } else if (my.size() == 0 || !my.contains(str2)) {
            C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + my.size() + " ");
            AppMethodBeat.m2505o(5520);
            return false;
        } else {
            AppMethodBeat.m2505o(5520);
            return true;
        }
    }

    /* renamed from: mt */
    public static boolean m64069mt(String str) {
        AppMethodBeat.m2504i(5521);
        if (!C1855t.m3901mN(str)) {
            AppMethodBeat.m2505o(5521);
            return false;
        } else if (((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14890of(str)) {
            List oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(str);
            if (oe == null || oe.size() == 0) {
                AppMethodBeat.m2505o(5521);
                return true;
            }
            AppMethodBeat.m2505o(5521);
            return false;
        } else {
            C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "state is die");
            AppMethodBeat.m2505o(5521);
            return true;
        }
    }

    /* renamed from: mu */
    public static boolean m64070mu(String str) {
        AppMethodBeat.m2504i(5522);
        if (C1855t.m3901mN(str)) {
            C4990ab.m7411d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
            C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
            C7577u oa = XV.mo14885oa(str);
            if (oa == null) {
                AppMethodBeat.m2505o(5522);
                return false;
            }
            oa.field_roomflag = 1;
            boolean a = XV.mo10099a(oa);
            AppMethodBeat.m2505o(5522);
            return a;
        }
        AppMethodBeat.m2505o(5522);
        return false;
    }

    /* renamed from: a */
    public static boolean m64054a(String str, String str2, C7280qe c7280qe, int i, String str3, C6592a c6592a, C4883b c4883b) {
        AppMethodBeat.m2504i(5523);
        if (str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@im.chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) {
            boolean z;
            C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
            if (oa != null) {
                c6592a.cGj = oa.drT();
            } else {
                c6592a.cGj = 0;
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            C4990ab.m7416i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + c7280qe.ehB);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= c7280qe.ehB) {
                    break;
                }
                C7281qf c7281qf = (C7281qf) c7280qe.vXi.get(i3);
                C7616ad aoO = XM.aoO(c7281qf.jBB);
                if (aoO == null) {
                    C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    C6593b c6593b = new C6593b();
                    c6593b.userName = c7281qf.jBB;
                    c6593b.eoB = c7281qf.vXp;
                    c6593b.eoA = c7281qf.vXo;
                    if (c7280qe.vXj == 0) {
                        c6593b.eoz = c7281qf.vXl;
                        if (!C5046bo.isNullOrNil(c7281qf.vXn)) {
                            C17880h qo = C17884o.act().mo33392qo(c7281qf.jBB);
                            if (qo == null) {
                                qo = new C17880h();
                                qo.username = c7281qf.jBB;
                            }
                            qo.frW = c7281qf.vXm;
                            qo.frV = c7281qf.vXn;
                            qo.dtR = 3;
                            qo.mo33385cB(!C5046bo.isNullOrNil(c7281qf.vXm));
                            C17884o.act().mo33391b(qo);
                        }
                    }
                    if (oa != null) {
                        C6593b aon = oa.aon(c7281qf.jBB);
                        if (aon != null) {
                            c6593b.eoz = aon.eoz;
                            c6593b.eoB = C5046bo.isNullOrNil(c6593b.eoB) ? aon.eoB : c6593b.eoB;
                        }
                    }
                    c6592a.eow.add(c6593b);
                    if (((int) aoO.ewQ) == 0) {
                        aoO.setUsername(c7281qf.jBB);
                        if (c7281qf.jCH != null) {
                            aoO.mo14703iB(c7281qf.jCH);
                        }
                        aoO.mo16675NA();
                        XM.mo15702Z(aoO);
                        z2 = true;
                    }
                    arrayList.add(aoO.field_username);
                }
                i2 = i3 + 1;
            }
            C4990ab.m7416i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + c4883b + " publish: " + z2 + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z2) {
                C30262b.alY(str).mo20626D(str, c6592a.cGj).dmX();
            } else if (oa == null) {
                C30262b.alY(str).mo20626D(str, 0).dmX();
            }
            C7577u oa2 = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
            if (oa2 == null) {
                oa2 = new C7577u();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            oa2.field_chatroomname = str;
            oa2.field_roomowner = str2;
            C7577u ep = oa2.mo16804ep(arrayList);
            ep.field_chatroomStatus = i;
            ep.field_displayname = C37921n.m64045T(arrayList);
            if (c7280qe.vXj != 0) {
                z = true;
            } else {
                z = false;
            }
            ep.mo16788a(str3, c6592a, z).field_memberCount = arrayList.size();
            z2 = C37921n.m64050a(oa2);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            String str4 = "MicroMsg.ChatroomMembersLogic";
            String str5 = "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s %s oldVer:%s newVer:%s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Long.valueOf(currentTimeMillis2);
            objArr[2] = Boolean.valueOf(oa2.drU());
            objArr[3] = Integer.valueOf(oa2.drR() == null ? 0 : oa2.drR().cGj);
            objArr[4] = Integer.valueOf(oa2.drR() == null ? 0 : oa2.drR().eoy);
            C4990ab.m7417i(str4, str5, objArr);
            if (oa2.drU()) {
                C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(oa2.drT()));
                C41965as c41965as = new C41965as();
                c41965as.ctO.username = str;
                C4879a.xxA.mo10055m(c41965as);
            }
            AppMethodBeat.m2505o(5523);
            return z2;
        }
        C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + c7280qe.ehB);
        AppMethodBeat.m2505o(5523);
        return false;
    }

    static {
        AppMethodBeat.m2504i(5546);
        AppMethodBeat.m2505o(5546);
    }

    /* renamed from: a */
    public static boolean m64052a(String str, C7280qe c7280qe) {
        AppMethodBeat.m2504i(5524);
        if (c7280qe == null) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            AppMethodBeat.m2505o(5524);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            AppMethodBeat.m2505o(5524);
            return false;
        } else if (C1855t.m3896kH(str)) {
            C4990ab.m7413e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", str);
            AppMethodBeat.m2505o(5524);
            return false;
        } else {
            String a = C1946aa.m4148a(c7280qe.vXk);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
                AppMethodBeat.m2505o(5524);
                return false;
            }
            C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", a, Integer.valueOf(c7280qe.vXi.size()));
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(a);
            if (oa != null && c7280qe.vXi.size() > 0 && oa.afg().contains(((C7281qf) c7280qe.vXi.get(0)).jBB)) {
                C6593b aon = oa.aon(((C7281qf) c7280qe.vXi.get(0)).jBB);
                if (aon != null) {
                    C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", r0, aon.eoz);
                    aon.eoB = ((C7281qf) c7280qe.vXi.get(0)).vXp;
                    C37921n.m64050a(oa);
                } else {
                    C4990ab.m7413e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", r0);
                }
                AppMethodBeat.m2505o(5524);
                return true;
            } else if (oa == null || c7280qe.vXi.size() <= 0) {
                if (c7280qe.vXi.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (oa != null) {
                    C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                AppMethodBeat.m2505o(5524);
                return false;
            } else {
                C41966at c41966at = new C41966at();
                c41966at.ctP.username = ((C7281qf) c7280qe.vXi.get(0)).jBB;
                c41966at.ctP.ctQ = ((C7281qf) c7280qe.vXi.get(0)).vXp;
                fkH.put(a + "#" + c41966at.ctP.username, c41966at.ctP.ctQ);
                C4879a.xxA.mo10055m(c41966at);
                AppMethodBeat.m2505o(5524);
                return false;
            }
        }
    }

    /* renamed from: Z */
    public static String m64046Z(String str, String str2) {
        AppMethodBeat.m2504i(5525);
        String str3 = str2 + "#" + str;
        if (fkH.mo4406ak(str3)) {
            str3 = (String) fkH.get(str3);
            AppMethodBeat.m2505o(5525);
            return str3;
        }
        str3 = "";
        AppMethodBeat.m2505o(5525);
        return str3;
    }

    /* renamed from: a */
    public static boolean m64050a(C7577u c7577u) {
        AppMethodBeat.m2504i(5526);
        if (c7577u == null) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            AppMethodBeat.m2505o(5526);
            return false;
        }
        boolean a = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10099a(c7577u);
        if (a) {
            C37921n.m64056aa(c7577u.field_chatroomname, c7577u.field_roomowner);
        }
        AppMethodBeat.m2505o(5526);
        return a;
    }

    /* renamed from: aa */
    private static void m64056aa(String str, String str2) {
        AppMethodBeat.m2504i(5527);
        C4990ab.m7411d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", Integer.valueOf(1));
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        C7616ad aoO = XM.aoO(str);
        if (!(((int) aoO.ewQ) == 0 || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(C1853r.m3846Yz()))) {
            if (str2.equals(C1853r.m3846Yz())) {
                aoO.mo16711ji(1);
            } else {
                aoO.mo16711ji(0);
            }
            XM.mo15724b(str, aoO);
        }
        AppMethodBeat.m2505o(5527);
    }

    /* renamed from: a */
    public static boolean m64053a(String str, C7555vk c7555vk) {
        AppMethodBeat.m2504i(5528);
        if (!C37921n.m64065mp(str) || c7555vk.ehB == 0) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + c7555vk.ehB);
            AppMethodBeat.m2505o(5528);
            return false;
        }
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        C7577u oa = XV.mo14885oa(str);
        List aor = C7577u.aor(oa.field_memberlist);
        C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + aor.size());
        Iterator it = c7555vk.vEh.iterator();
        while (it.hasNext()) {
            aor.remove(C1946aa.m4148a(((C30236vu) it.next()).wcG));
        }
        C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + aor.size());
        C7577u ep = oa.mo16804ep(aor);
        ep.field_displayname = C37921n.m64045T(aor);
        ep.field_memberCount = aor.size();
        boolean a = XV.mo10099a(oa);
        C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "delChatroomMember ".concat(String.valueOf(a)));
        AppMethodBeat.m2505o(5528);
        return a;
    }

    /* renamed from: a */
    public static boolean m64051a(String str, C35910cb c35910cb) {
        AppMethodBeat.m2504i(5529);
        if (!C37921n.m64065mp(str) || c35910cb.ehB == 0) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + c35910cb.ehB);
            AppMethodBeat.m2505o(5529);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        for (int i = 0; i < c35910cb.ehB; i++) {
            String a = C1946aa.m4148a(((baz) c35910cb.vEh.get(i)).wcG);
            if (((baz) c35910cb.vEh.get(i)).wFJ == 0) {
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7413e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    C6562ap c6562ap;
                    C7616ad aoO = XM.aoO(a);
                    if (((int) aoO.ewQ) != 0) {
                        aoO.mo16675NA();
                        XM.mo15724b(aoO.field_username, aoO);
                        c6562ap = aoO;
                    } else {
                        c6562ap = C37921n.m64047a(aoO, (baz) c35910cb.vEh.get(i));
                        XM.mo15702Z(c6562ap);
                    }
                    arrayList.add(c6562ap.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            AppMethodBeat.m2505o(5529);
            return false;
        }
        boolean a2 = C37921n.m64055a(str, arrayList, null);
        AppMethodBeat.m2505o(5529);
        return a2;
    }

    /* renamed from: mv */
    public static boolean m64071mv(String str) {
        AppMethodBeat.m2504i(5530);
        if (str.toLowerCase().endsWith("@groupcard")) {
            C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
            if (XM.aoQ(str)) {
                XM.aoU(str);
            } else {
                C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
            }
            boolean mx = C37921n.m64073mx(str);
            AppMethodBeat.m2505o(5530);
            return mx;
        }
        C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
        AppMethodBeat.m2505o(5530);
        return false;
    }

    /* renamed from: mw */
    public static boolean m64072mw(String str) {
        AppMethodBeat.m2504i(5531);
        if (C37921n.m64065mp(str)) {
            C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
            if (XM.aoQ(str)) {
                XM.aoU(str);
            } else {
                C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            boolean mx = C37921n.m64073mx(str);
            AppMethodBeat.m2505o(5531);
            return mx;
        }
        C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        AppMethodBeat.m2505o(5531);
        return false;
    }

    /* renamed from: a */
    public static boolean m64055a(String str, ArrayList<String> arrayList, String str2) {
        List my;
        int i = 0;
        AppMethodBeat.m2504i(5532);
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        C7577u ob = XV.mo14886ob(str);
        if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            my = C37921n.m64074my(str);
        } else {
            my = new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        C7577u ep;
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
            if (!C5046bo.isNullOrNil(str2)) {
                ob.field_roomowner = str2;
            }
            ep = ob.mo16804ep(linkedList);
            ep.field_displayname = C37921n.m64045T(linkedList);
            ep.field_memberCount = linkedList.size();
            a = XV.mo10099a(ob);
            AppMethodBeat.m2505o(5532);
            return a;
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            ob.field_roomowner = str2;
        }
        ep = ob.mo16804ep(linkedList);
        ep.field_displayname = C37921n.m64045T(linkedList);
        ep.field_memberCount = linkedList.size();
        ob.field_roomowner = str2;
        a = XV.mo10099a(ob);
        C4990ab.m7410d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName ".concat(String.valueOf(a)));
        AppMethodBeat.m2505o(5532);
        return a;
    }

    /* renamed from: mx */
    private static boolean m64073mx(String str) {
        AppMethodBeat.m2504i(5533);
        boolean og = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14891og(str);
        AppMethodBeat.m2505o(5533);
        return og;
    }

    /* renamed from: my */
    public static List<String> m64074my(String str) {
        AppMethodBeat.m2504i(5534);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            AppMethodBeat.m2505o(5534);
            return null;
        } else if (C37921n.m64065mp(str)) {
            List<String> oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(str);
            AppMethodBeat.m2505o(5534);
            return oe;
        } else {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            AppMethodBeat.m2505o(5534);
            return null;
        }
    }

    /* renamed from: mz */
    public static List<String> m64075mz(String str) {
        AppMethodBeat.m2504i(5535);
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(str);
            AppMethodBeat.m2505o(5535);
            return oe;
        }
        C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        AppMethodBeat.m2505o(5535);
        return null;
    }

    /* renamed from: mA */
    public static int m64060mA(String str) {
        AppMethodBeat.m2504i(5536);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
            if (XV != null) {
                int oh = XV.mo14892oh(str);
                C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(5536);
                return oh;
            }
            C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(5536);
            return 0;
        } catch (Throwable th) {
            C4990ab.m7417i("MicroMsg.ChatroomMembersLogic", "[getMembersCountByChatRoomName] cost:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(5536);
        }
    }

    /* renamed from: mB */
    public static List<String> m64061mB(String str) {
        int i = 0;
        AppMethodBeat.m2504i(5537);
        if (C37921n.m64065mp(str)) {
            List<String> my = C37921n.m64074my(str);
            if (my == null || my.size() <= 0) {
                AppMethodBeat.m2505o(5537);
                return null;
            }
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
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
                AppMethodBeat.m2505o(5537);
                return null;
            }
            AppMethodBeat.m2505o(5537);
            return my;
        }
        C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        AppMethodBeat.m2505o(5537);
        return null;
    }

    /* renamed from: a */
    public static C7616ad m64047a(C7616ad c7616ad, baz baz) {
        AppMethodBeat.m2504i(5538);
        c7616ad.setUsername(C1946aa.m4148a(baz.wcG));
        c7616ad.mo14703iB(C1946aa.m4148a(baz.wcG));
        c7616ad.mo14704iC(C1946aa.m4148a(baz.wcG));
        c7616ad.mo14705iD(C1946aa.m4148a(baz.wcf));
        c7616ad.mo14685hA(baz.guN);
        c7616ad.mo14729iz(C1946aa.m4148a(baz.wFK));
        c7616ad.mo14708iG(C1946aa.m4148a(baz.wFL));
        c7616ad.mo14707iF(C1946aa.m4148a(baz.wcf));
        c7616ad.mo14688hD(baz.wbA);
        c7616ad.mo14690hF(baz.guR);
        c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(baz.guW, baz.guO, baz.guP));
        c7616ad.mo14718iQ(baz.guQ);
        AppMethodBeat.m2505o(5538);
        return c7616ad;
    }

    /* renamed from: ab */
    public static String m64057ab(String str, String str2) {
        AppMethodBeat.m2504i(5539);
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        if (XV == null) {
            C4990ab.m7412e("MicroMsg.ChatroomMembersLogic", "[getDisplayNameInRoom] null == mStg");
            AppMethodBeat.m2505o(5539);
            return null;
        }
        C7577u oa = XV.mo14885oa(str2);
        if (oa == null) {
            AppMethodBeat.m2505o(5539);
            return null;
        }
        String mJ = oa.mo16807mJ(str);
        AppMethodBeat.m2505o(5539);
        return mJ;
    }

    /* renamed from: mC */
    public static String m64062mC(String str) {
        AppMethodBeat.m2504i(5540);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5540);
            return null;
        }
        String str2 = oa.field_chatroomnotice;
        AppMethodBeat.m2505o(5540);
        return str2;
    }

    /* renamed from: N */
    public static boolean m64043N(String str, int i) {
        AppMethodBeat.m2504i(5541);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5541);
            return false;
        } else if (oa.field_chatroomVersion < i) {
            AppMethodBeat.m2505o(5541);
            return true;
        } else {
            AppMethodBeat.m2505o(5541);
            return false;
        }
    }

    /* renamed from: mD */
    public static String m64063mD(String str) {
        AppMethodBeat.m2504i(5542);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5542);
            return null;
        }
        String str2 = oa.field_chatroomnoticeEditor;
        AppMethodBeat.m2505o(5542);
        return str2;
    }

    /* renamed from: mE */
    public static long m64064mE(String str) {
        AppMethodBeat.m2504i(5543);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5543);
            return -1;
        }
        long j = oa.field_chatroomnoticePublishTime;
        AppMethodBeat.m2505o(5543);
        return j;
    }

    /* renamed from: a */
    public static void m64049a(String str, String str2, String str3, long j, int i, int i2) {
        AppMethodBeat.m2504i(5544);
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        C7577u oa = XV.mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5544);
            return;
        }
        oa.field_chatroomVersion = i;
        oa.field_chatroomnoticePublishTime = j;
        oa.field_chatroomnoticeEditor = str3;
        oa.field_chatroomnotice = str2;
        oa.field_chatroomStatus = i2;
        XV.mo10099a(oa);
        AppMethodBeat.m2505o(5544);
    }

    /* renamed from: O */
    public static void m64044O(String str, int i) {
        AppMethodBeat.m2504i(5545);
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        C7577u oa = XV.mo14885oa(str);
        if (oa == null) {
            AppMethodBeat.m2505o(5545);
            return;
        }
        C6592a drY = oa.drY();
        drY.type = i;
        oa.mo16788a(str, drY, false);
        XV.mo10099a(oa);
        AppMethodBeat.m2505o(5545);
    }
}
