package com.tencent.p177mm.openim.room.p266a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.room.p266a.C18742b.C1938c;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p230g.p231a.C45332hj;
import com.tencent.p177mm.p230g.p231a.C45339km;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7280qe;
import com.tencent.p177mm.protocal.protobuf.bfz;
import com.tencent.p177mm.protocal.protobuf.bga;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.room.a.a */
public final class C42249a {

    /* renamed from: com.tencent.mm.openim.room.a.a$1 */
    public static class C67011 implements C5015a {
        final /* synthetic */ LinkedList ehw;
        final /* synthetic */ C17881i ehx;
        final /* synthetic */ C18743c gfO;

        public C67011(LinkedList linkedList, C18743c c18743c, C17881i c17881i) {
            this.ehw = linkedList;
            this.gfO = c18743c;
            this.ehx = c17881i;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78967);
            int size = this.ehw.size() < 25 ? this.ehw.size() : 25;
            C4990ab.m7411d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", Integer.valueOf(this.ehw.size()), Integer.valueOf(size));
            if (size == 0) {
                if (this.gfO != null) {
                    this.gfO.mo34003mH(1);
                }
                C4990ab.m7416i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
                AppMethodBeat.m2505o(78967);
                return false;
            } else if (this.ehw.isEmpty()) {
                if (this.gfO != null) {
                    this.gfO.mo34003mH(1);
                }
                C4990ab.m7416i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                AppMethodBeat.m2505o(78967);
                return false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                for (int i = 0; i < size; i++) {
                    C17880h c17880h = (C17880h) this.ehw.poll();
                    if (c17880h == null) {
                        break;
                    }
                    this.ehx.mo33391b(c17880h);
                }
                C1720g.m3536RP().eJN.mo15640mB(iV);
                C4990ab.m7411d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (this.ehw.isEmpty()) {
                    if (this.gfO != null) {
                        this.gfO.mo34003mH(1);
                    }
                    C4990ab.m7416i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                    AppMethodBeat.m2505o(78967);
                    return false;
                }
                AppMethodBeat.m2505o(78967);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.openim.room.a.a$2 */
    public static class C97762 implements C5015a {
        final /* synthetic */ C7309bd ehA;
        final /* synthetic */ LinkedList ehz;
        final /* synthetic */ C18743c gfO;

        public C97762(LinkedList linkedList, C18743c c18743c, C7309bd c7309bd) {
            this.ehz = linkedList;
            this.gfO = c18743c;
            this.ehA = c7309bd;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78968);
            int size = this.ehz.size() < 25 ? this.ehz.size() : 25;
            C4990ab.m7411d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", Integer.valueOf(this.ehz.size()), Integer.valueOf(size));
            if (size == 0) {
                if (this.gfO != null) {
                    this.gfO.mo34003mH(2);
                }
                C4990ab.m7416i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
                AppMethodBeat.m2505o(78968);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) this.ehz.poll();
                this.ehA.mo15724b((String) pair.first, (C7616ad) pair.second);
            }
            C1720g.m3536RP().eJN.mo15640mB(iV);
            C4990ab.m7411d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (this.ehz.isEmpty()) {
                if (this.gfO != null) {
                    this.gfO.mo34003mH(2);
                }
                C4990ab.m7416i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
                AppMethodBeat.m2505o(78968);
                return false;
            }
            AppMethodBeat.m2505o(78968);
            return true;
        }
    }

    /* renamed from: a */
    private static void m74597a(bfz bfz) {
        int i;
        LinkedList linkedList;
        AppMethodBeat.m2504i(78969);
        String str = bfz.gfa;
        C6592a c6592a = new C6592a();
        c6592a.ehD = bfz.wJR.wKd;
        c6592a.eoy = bfz.wqI;
        if (bfz.wqI != 0) {
            c6592a.cGj = bfz.wqI;
        }
        if (((C33811b) C1720g.m3528K(C33811b.class)).mo54364N(str, c6592a.cGj)) {
            C4879a.xxA.mo10055m(new C45332hj());
        }
        C45339km c45339km = new C45339km();
        c45339km.cGi.chatroomName = str;
        c45339km.cGi.cGj = c6592a.cGj;
        C7280qe c7280qe = new C7280qe();
        if (bfz.wqJ == null) {
            i = 0;
        } else {
            i = bfz.wqJ.vEN.size();
        }
        c7280qe.ehB = i;
        c7280qe.vXk = C1946aa.m4154vy(bfz.gfa);
        c7280qe.vXj = bfz.wqJ.wKf;
        if (bfz.wqJ == null) {
            linkedList = new LinkedList();
        } else {
            linkedList = C1938c.m4138ao(bfz.wqJ.vEN);
        }
        c7280qe.vXi = linkedList;
        ((C33811b) C1720g.m3528K(C33811b.class)).mo54366a(str, bfz.wJR.bfz, c7280qe, C1853r.m3846Yz(), c6592a, c45339km);
        AppMethodBeat.m2505o(78969);
    }

    /* renamed from: b */
    public static void m74599b(bfz bfz) {
        AppMethodBeat.m2504i(78970);
        if (bfz.gfa.toLowerCase().endsWith("@im.chatroom")) {
            int i;
            C42249a.m74597a(bfz);
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(bfz.gfa);
            if (oa == null) {
                oa = new C7577u();
                oa.field_chatroomname = bfz.gfa;
            }
            oa.field_chatroomVersion = bfz.wqI;
            oa.drR().type = bfz.wJR.wKe;
            oa.mo16795c(oa.drR());
            C42249a.m74598a(bfz.gfa, oa, bfz.wJR);
            C1720g.m3537RQ();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bfz.gfa);
            int i2 = aoO.field_type;
            aoO.mo14712iK(bfz.app_id);
            int i3 = bfz.wJR != null ? 1 : 0;
            if (C5046bo.isNullOrNil(bfz.wJR.cFW)) {
                i = 0;
            } else {
                i = 1;
            }
            if ((i3 & i) != 0) {
                aoO.mo14703iB(bfz.wJR.cFW);
            }
            aoO.setUsername(bfz.gfa);
            aoO.mo14688hD(bfz.wJV);
            aoO.setType(bfz.wJU & bfz.oqG);
            aoO.mo14688hD(bfz.wJV);
            aoO.mo14689hE(bfz.wJT);
            C4990ab.m7417i("OpenIMChatRoomContactLogic", "updateChatroom done %s", aoO.field_username);
            C1720g.m3537RQ();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(aoO);
            if ((aoO.field_type & 2048) != 0) {
                if (aoO == null || (i2 & 2048) != (aoO.field_type & 2048)) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(aoO.field_username);
                }
            } else if (aoO == null || (i2 & 2048) != (aoO.field_type & 2048)) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apg(aoO.field_username);
            }
            if (!C5046bo.isNullOrNil(bfz.app_id)) {
                ((C32873b) C1720g.m3528K(C32873b.class)).mo44309u(bfz.app_id, C4988aa.m7403gw(C4996ah.getContext()), "");
            }
            AppMethodBeat.m2505o(78970);
            return;
        }
        C4990ab.m7412e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + bfz.gfa + "]");
        AppMethodBeat.m2505o(78970);
    }

    /* renamed from: a */
    private static void m74598a(String str, C7577u c7577u, bga bga) {
        AppMethodBeat.m2504i(78971);
        C17881i act = C17884o.act();
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(bga.wJX))) {
            C17880h qo = act.mo33392qo(str);
            if (qo == null) {
                qo = new C17880h();
                qo.username = str;
            }
            qo.frW = bga.wJW;
            qo.frV = bga.wJX;
            qo.dtR = 3;
            qo.mo33385cB(!C5046bo.isNullOrNil(bga.wJW));
            act.mo33391b(qo);
            if (bga.wJY == 2 && !C1853r.m3846Yz().equals(str)) {
                C17884o.acd();
                C41732d.m73516E(str, false);
                C17884o.acd();
                C41732d.m73516E(str, true);
                C17884o.acv().mo67495pZ(str);
            }
        }
        c7577u.field_roomowner = bga.bfz;
        if (c7577u.field_chatroomnoticePublishTime <= ((long) bga.wKc)) {
            c7577u.field_chatroomnotice = bga.kfO;
            c7577u.field_chatroomnoticeEditor = bga.wKb;
            c7577u.field_chatroomnoticePublishTime = (long) bga.wKc;
        }
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10099a(c7577u);
        AppMethodBeat.m2505o(78971);
    }

    /* renamed from: z */
    public static boolean m74600z(C7616ad c7616ad) {
        AppMethodBeat.m2504i(78972);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(78972);
            return false;
        } else if (!C7616ad.aox(c7616ad.field_username)) {
            AppMethodBeat.m2505o(78972);
            return false;
        } else if (C5046bo.isNullOrNil(c7616ad.field_openImAppid)) {
            AppMethodBeat.m2505o(78972);
            return false;
        } else if ("3552365301".equals(c7616ad.field_openImAppid)) {
            AppMethodBeat.m2505o(78972);
            return true;
        } else {
            AppMethodBeat.m2505o(78972);
            return false;
        }
    }

    /* renamed from: a */
    public static CharSequence m74596a(C7616ad c7616ad, CharSequence charSequence) {
        AppMethodBeat.m2504i(78973);
        String A = C42249a.m74595A(c7616ad);
        if (A == null) {
            AppMethodBeat.m2505o(78973);
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(A);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(C4996ah.getContext().getResources().getColor(C25738R.color.f12217wf)), length, spannableStringBuilder.length(), 33);
        AppMethodBeat.m2505o(78973);
        return spannableStringBuilder;
    }

    /* renamed from: A */
    public static String m74595A(C7616ad c7616ad) {
        AppMethodBeat.m2504i(78974);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(78974);
            return null;
        } else if (!C7616ad.aox(c7616ad.field_username)) {
            AppMethodBeat.m2505o(78974);
            return null;
        } else if (C5046bo.isNullOrNil(c7616ad.field_openImAppid)) {
            AppMethodBeat.m2505o(78974);
            return null;
        } else {
            String ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(c7616ad.field_openImAppid, c7616ad.field_descWordingId);
            if (C5046bo.isNullOrNil(ba)) {
                AppMethodBeat.m2505o(78974);
                return null;
            }
            ba = "＠".concat(String.valueOf(ba));
            AppMethodBeat.m2505o(78974);
            return ba;
        }
    }
}
