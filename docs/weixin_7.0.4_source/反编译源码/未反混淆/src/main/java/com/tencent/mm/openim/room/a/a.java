package com.tencent.mm.openim.room.a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.km;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.LinkedList;

public final class a {

    /* renamed from: com.tencent.mm.openim.room.a.a$1 */
    public static class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ LinkedList ehw;
        final /* synthetic */ i ehx;
        final /* synthetic */ c gfO;

        public AnonymousClass1(LinkedList linkedList, c cVar, i iVar) {
            this.ehw = linkedList;
            this.gfO = cVar;
            this.ehx = iVar;
        }

        public final boolean BI() {
            AppMethodBeat.i(78967);
            int size = this.ehw.size() < 25 ? this.ehw.size() : 25;
            ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", Integer.valueOf(this.ehw.size()), Integer.valueOf(size));
            if (size == 0) {
                if (this.gfO != null) {
                    this.gfO.mH(1);
                }
                ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
                AppMethodBeat.o(78967);
                return false;
            } else if (this.ehw.isEmpty()) {
                if (this.gfO != null) {
                    this.gfO.mH(1);
                }
                ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                AppMethodBeat.o(78967);
                return false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                for (int i = 0; i < size; i++) {
                    h hVar = (h) this.ehw.poll();
                    if (hVar == null) {
                        break;
                    }
                    this.ehx.b(hVar);
                }
                g.RP().eJN.mB(iV);
                ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (this.ehw.isEmpty()) {
                    if (this.gfO != null) {
                        this.gfO.mH(1);
                    }
                    ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
                    AppMethodBeat.o(78967);
                    return false;
                }
                AppMethodBeat.o(78967);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.openim.room.a.a$2 */
    public static class AnonymousClass2 implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ bd ehA;
        final /* synthetic */ LinkedList ehz;
        final /* synthetic */ c gfO;

        public AnonymousClass2(LinkedList linkedList, c cVar, bd bdVar) {
            this.ehz = linkedList;
            this.gfO = cVar;
            this.ehA = bdVar;
        }

        public final boolean BI() {
            AppMethodBeat.i(78968);
            int size = this.ehz.size() < 25 ? this.ehz.size() : 25;
            ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", Integer.valueOf(this.ehz.size()), Integer.valueOf(size));
            if (size == 0) {
                if (this.gfO != null) {
                    this.gfO.mH(2);
                }
                ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
                AppMethodBeat.o(78968);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) this.ehz.poll();
                this.ehA.b((String) pair.first, (ad) pair.second);
            }
            g.RP().eJN.mB(iV);
            ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (this.ehz.isEmpty()) {
                if (this.gfO != null) {
                    this.gfO.mH(2);
                }
                ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
                AppMethodBeat.o(78968);
                return false;
            }
            AppMethodBeat.o(78968);
            return true;
        }
    }

    private static void a(bfz bfz) {
        int i;
        LinkedList linkedList;
        AppMethodBeat.i(78969);
        String str = bfz.gfa;
        com.tencent.mm.j.a.a.a aVar = new com.tencent.mm.j.a.a.a();
        aVar.ehD = bfz.wJR.wKd;
        aVar.eoy = bfz.wqI;
        if (bfz.wqI != 0) {
            aVar.cGj = bfz.wqI;
        }
        if (((b) g.K(b.class)).N(str, aVar.cGj)) {
            com.tencent.mm.sdk.b.a.xxA.m(new hj());
        }
        km kmVar = new km();
        kmVar.cGi.chatroomName = str;
        kmVar.cGi.cGj = aVar.cGj;
        qe qeVar = new qe();
        if (bfz.wqJ == null) {
            i = 0;
        } else {
            i = bfz.wqJ.vEN.size();
        }
        qeVar.ehB = i;
        qeVar.vXk = aa.vy(bfz.gfa);
        qeVar.vXj = bfz.wqJ.wKf;
        if (bfz.wqJ == null) {
            linkedList = new LinkedList();
        } else {
            linkedList = c.ao(bfz.wqJ.vEN);
        }
        qeVar.vXi = linkedList;
        ((b) g.K(b.class)).a(str, bfz.wJR.bfz, qeVar, r.Yz(), aVar, kmVar);
        AppMethodBeat.o(78969);
    }

    public static void b(bfz bfz) {
        AppMethodBeat.i(78970);
        if (bfz.gfa.toLowerCase().endsWith("@im.chatroom")) {
            int i;
            a(bfz);
            u oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(bfz.gfa);
            if (oa == null) {
                oa = new u();
                oa.field_chatroomname = bfz.gfa;
            }
            oa.field_chatroomVersion = bfz.wqI;
            oa.drR().type = bfz.wJR.wKe;
            oa.c(oa.drR());
            a(bfz.gfa, oa, bfz.wJR);
            g.RQ();
            ad aoO = ((j) g.K(j.class)).XM().aoO(bfz.gfa);
            int i2 = aoO.field_type;
            aoO.iK(bfz.app_id);
            int i3 = bfz.wJR != null ? 1 : 0;
            if (bo.isNullOrNil(bfz.wJR.cFW)) {
                i = 0;
            } else {
                i = 1;
            }
            if ((i3 & i) != 0) {
                aoO.iB(bfz.wJR.cFW);
            }
            aoO.setUsername(bfz.gfa);
            aoO.hD(bfz.wJV);
            aoO.setType(bfz.wJU & bfz.oqG);
            aoO.hD(bfz.wJV);
            aoO.hE(bfz.wJT);
            ab.i("OpenIMChatRoomContactLogic", "updateChatroom done %s", aoO.field_username);
            g.RQ();
            ((j) g.K(j.class)).XM().Y(aoO);
            if ((aoO.field_type & 2048) != 0) {
                if (aoO == null || (i2 & 2048) != (aoO.field_type & 2048)) {
                    ((j) g.K(j.class)).XR().apf(aoO.field_username);
                }
            } else if (aoO == null || (i2 & 2048) != (aoO.field_type & 2048)) {
                ((j) g.K(j.class)).XR().apg(aoO.field_username);
            }
            if (!bo.isNullOrNil(bfz.app_id)) {
                ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).u(bfz.app_id, com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()), "");
            }
            AppMethodBeat.o(78970);
            return;
        }
        ab.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + bfz.gfa + "]");
        AppMethodBeat.o(78970);
    }

    private static void a(String str, u uVar, bga bga) {
        AppMethodBeat.i(78971);
        i act = o.act();
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(bga.wJX))) {
            h qo = act.qo(str);
            if (qo == null) {
                qo = new h();
                qo.username = str;
            }
            qo.frW = bga.wJW;
            qo.frV = bga.wJX;
            qo.dtR = 3;
            qo.cB(!bo.isNullOrNil(bga.wJW));
            act.b(qo);
            if (bga.wJY == 2 && !r.Yz().equals(str)) {
                o.acd();
                d.E(str, false);
                o.acd();
                d.E(str, true);
                o.acv().pZ(str);
            }
        }
        uVar.field_roomowner = bga.bfz;
        if (uVar.field_chatroomnoticePublishTime <= ((long) bga.wKc)) {
            uVar.field_chatroomnotice = bga.kfO;
            uVar.field_chatroomnoticeEditor = bga.wKb;
            uVar.field_chatroomnoticePublishTime = (long) bga.wKc;
        }
        ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().a(uVar);
        AppMethodBeat.o(78971);
    }

    public static boolean z(ad adVar) {
        AppMethodBeat.i(78972);
        if (adVar == null) {
            AppMethodBeat.o(78972);
            return false;
        } else if (!ad.aox(adVar.field_username)) {
            AppMethodBeat.o(78972);
            return false;
        } else if (bo.isNullOrNil(adVar.field_openImAppid)) {
            AppMethodBeat.o(78972);
            return false;
        } else if ("3552365301".equals(adVar.field_openImAppid)) {
            AppMethodBeat.o(78972);
            return true;
        } else {
            AppMethodBeat.o(78972);
            return false;
        }
    }

    public static CharSequence a(ad adVar, CharSequence charSequence) {
        AppMethodBeat.i(78973);
        String A = A(adVar);
        if (A == null) {
            AppMethodBeat.o(78973);
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(A);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ah.getContext().getResources().getColor(R.color.wf)), length, spannableStringBuilder.length(), 33);
        AppMethodBeat.o(78973);
        return spannableStringBuilder;
    }

    public static String A(ad adVar) {
        AppMethodBeat.i(78974);
        if (adVar == null) {
            AppMethodBeat.o(78974);
            return null;
        } else if (!ad.aox(adVar.field_username)) {
            AppMethodBeat.o(78974);
            return null;
        } else if (bo.isNullOrNil(adVar.field_openImAppid)) {
            AppMethodBeat.o(78974);
            return null;
        } else {
            String ba = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(adVar.field_openImAppid, adVar.field_descWordingId);
            if (bo.isNullOrNil(ba)) {
                AppMethodBeat.o(78974);
                return null;
            }
            ba = "＠".concat(String.valueOf(ba));
            AppMethodBeat.o(78974);
            return ba;
        }
    }
}
