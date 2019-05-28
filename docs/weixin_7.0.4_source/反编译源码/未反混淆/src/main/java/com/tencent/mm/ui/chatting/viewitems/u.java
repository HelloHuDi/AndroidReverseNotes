package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class u {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private String zeJ;
        private String zeK;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || (i != 42 && i != 66)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33107);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.md);
                view.setTag(new a().z(view, true));
            }
            AppMethodBeat.o(33107);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33108);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(33108);
            return dFx;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            String oz;
            int i2;
            AppMethodBeat.i(33109);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            if (aVar2.dFx()) {
                oz = bf.oz(biVar.field_content);
            } else {
                oz = biVar.field_content;
            }
            aw.ZK();
            com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(oz);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                ab.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            this.zeK = "";
            if (!ah.isNullOrNil(oz)) {
                Map z = br.z(oz, "msg");
                if (z.containsKey(".msg.$wechatid")) {
                    this.zeK = (String) z.get(".msg.$wechatid");
                }
            }
            com.tencent.mm.ah.b.U(this.zeJ, Rn.xZh);
            com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.jPL, aVar3.zcJ);
            if (t.kv(Rn.ufB)) {
                aVar3.zeH.setText(R.string.ak2);
                aVar3.zeI.setVisibility(8);
                if (d.iW(16)) {
                    aVar3.zeG.setBackground(null);
                } else {
                    aVar3.zeG.setBackgroundDrawable(null);
                }
                c.w(aVar3.zeG, this.zeJ);
            } else {
                aVar3.zeH.setText(R.string.an7);
                aVar3.zeG.setBackgroundResource(R.drawable.ad2);
                c.v(aVar3.zeG, this.zeJ);
            }
            String str2 = this.zeK;
            if (ah.isNullOrNil(str2) || ad.aoA(str2) || t.mX(str2)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            boolean kv = t.kv(Rn.ufB);
            if (i2 != 0 || kv) {
                oz = "";
            } else {
                oz = str2;
            }
            if (ah.isNullOrNil(oz)) {
                aVar3.zeI.setVisibility(8);
            } else {
                aVar3.zeI.setVisibility(0);
                aVar3.zeI.setText(oz);
            }
            aVar3.ejp.setText(j.b(aVar2.yTx.getContext(), Rn.nickname, (int) aVar3.ejp.getTextSize()));
            u.a(aVar2, this.zeJ, Rn, aVar3);
            aVar3.jPL.setTag(new ay(biVar, aVar2.dFx(), i, str, 0));
            aVar3.jPL.setOnClickListener(d(aVar2));
            aVar3.jPL.setOnLongClickListener(c(aVar2));
            aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            AppMethodBeat.o(33109);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33110);
            int i = ((ay) view.getTag()).position;
            aw.ZK();
            com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                ab.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            if (t.kv(Rn.ufB)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(R.string.dr1));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
            }
            AppMethodBeat.o(33110);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33111);
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(33111);
                    break;
                default:
                    AppMethodBeat.o(33111);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33112);
            ay ayVar = (ay) view.getTag();
            u.a(aVar, ayVar.userName, biVar.field_content, ayVar.yFW, biVar.field_isSend == 0, biVar);
            AppMethodBeat.o(33112);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView ejp;
        public int zcJ;
        ImageView zci;
        ImageView zeG;
        TextView zeH;
        TextView zeI;

        a() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(33106);
            super.eP(view);
            this.zeG = (ImageView) view.findViewById(R.id.ara);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zeH = (TextView) view.findViewById(R.id.ard);
            this.zeI = (TextView) view.findViewById(R.id.arc);
            this.ejp = (TextView) view.findViewById(R.id.arb);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.jPL = view.findViewById(R.id.ap9);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            if (!z) {
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.zci = (ImageView) view.findViewById(R.id.at7);
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
            }
            this.zcJ = c.hV(com.tencent.mm.sdk.platformtools.ah.getContext());
            AppMethodBeat.o(33106);
            return this;
        }
    }

    public static class c extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private String zeJ;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && (i == 42 || i == 66)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33113);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nc);
                view.setTag(new a().z(view, false));
            }
            AppMethodBeat.o(33113);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0192  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0131  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            char c;
            char c2;
            boolean kv;
            int c22 = 1;
            AppMethodBeat.i(33114);
            this.yJI = aVar2;
            aVar = (a) aVar;
            aw.ZK();
            com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                ab.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            ab.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(t.mZ(this.zeJ)), this.zeJ);
            com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar.jPL, aVar.zcJ);
            if (t.kv(Rn.ufB)) {
                aVar.zeH.setText(R.string.ak2);
                aVar.zeI.setVisibility(8);
                if (d.iW(16)) {
                    aVar.zeG.setBackground(null);
                } else {
                    aVar.zeG.setBackgroundDrawable(null);
                }
                c.w(aVar.zeG, this.zeJ);
            } else {
                aVar.zeH.setText(R.string.an7);
                aVar.zeG.setBackgroundResource(R.drawable.ad2);
                c.v(aVar.zeG, this.zeJ);
            }
            aVar.ejp.setText(j.b(aVar2.yTx.getContext(), Rn.nickname, aVar.ejp.getTextSize()));
            String str2 = Rn.dFl;
            if (!ah.isNullOrNil(this.zeJ)) {
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(this.zeJ);
                if (aoO != null && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    c = 0;
                    if (c == 0 || !ah.isNullOrNil(str2)) {
                        c22 = c;
                    } else {
                        str2 = this.zeJ;
                        if (!(ah.isNullOrNil(str2) || ad.aoA(str2) || t.mX(str2))) {
                            c22 = 0;
                        }
                    }
                    kv = t.kv(Rn.ufB);
                    if (c22 != 0 || kv) {
                        str2 = "";
                    }
                    if (ah.isNullOrNil(str2)) {
                        aVar.zeI.setVisibility(0);
                        aVar.zeI.setText(str2);
                    } else {
                        aVar.zeI.setVisibility(8);
                    }
                    u.a(aVar2, this.zeJ, Rn, aVar);
                    aVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
                    aVar.jPL.setOnClickListener(d(aVar2));
                    aVar.jPL.setOnLongClickListener(c(aVar2));
                    aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                    if (!c.dHm()) {
                        if (aVar.pyf != null) {
                            aVar.pyf.setVisibility(8);
                        }
                        if (biVar.field_status == 2 && c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                            if (aVar.zci != null) {
                                aVar.zci.setVisibility(0);
                            }
                        } else if (aVar.zci != null) {
                            aVar.zci.setVisibility(8);
                        }
                    } else if (aVar.pyf != null) {
                        aVar.pyf.setVisibility(0);
                        if (biVar.field_status >= 2) {
                            aVar.pyf.setVisibility(8);
                        }
                    }
                    a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
                    AppMethodBeat.o(33114);
                }
            }
            c = 1;
            if (c == 0) {
            }
            c22 = c;
            kv = t.kv(Rn.ufB);
            str2 = "";
            if (ah.isNullOrNil(str2)) {
            }
            u.a(aVar2, this.zeJ, Rn, aVar);
            aVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            if (!c.dHm()) {
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33114);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33115);
            int i = ((ay) view.getTag()).position;
            aw.ZK();
            com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                ab.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            if (t.kv(Rn.ufB)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(R.string.dr1));
            }
            if (!biVar.drC() && ((biVar.field_status == 2 || biVar.dJz == 1) && biVar.dtw() && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
            }
            AppMethodBeat.o(33115);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33116);
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(33116);
                    break;
                default:
                    AppMethodBeat.o(33116);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33117);
            ay ayVar = (ay) view.getTag();
            u.a(aVar, ayVar.userName, biVar.field_content, ayVar.yFW, biVar.field_isSend == 0, biVar);
            AppMethodBeat.o(33117);
            return true;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33118);
            biVar.dtJ();
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
            ((e) aVar.aF(e.class)).bb(biVar);
            AppMethodBeat.o(33118);
        }
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, String str, com.tencent.mm.storage.bi.a aVar2, a aVar3) {
        AppMethodBeat.i(33119);
        if (ad.aox(str)) {
            CharSequence a;
            String a2 = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(aVar2.xZm, "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
            if (TextUtils.isEmpty(a2)) {
                aVar3.zeH.setText(R.string.an7);
            } else {
                aVar3.zeH.setText(a2);
            }
            aVar3.zeG.setBackgroundResource(R.drawable.ad2);
            c.v(aVar3.zeG, str);
            String str2 = aVar2.xZo;
            String str3 = aVar2.xZn;
            if (ah.isNullOrNil(str2)) {
                Object a3 = str3;
            } else {
                a3 = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(aVar.yTx.getContext(), str2, str3, aVar3.zeI.getTextSize());
            }
            if (TextUtils.isEmpty(a3)) {
                aVar3.zeI.setVisibility(8);
                AppMethodBeat.o(33119);
                return;
            }
            aVar3.zeI.setVisibility(0);
            aVar3.zeI.setText(a3);
            AppMethodBeat.o(33119);
            return;
        }
        AppMethodBeat.o(33119);
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, String str, String str2, boolean z, boolean z2, bi biVar) {
        AppMethodBeat.i(33120);
        if (z && z2) {
            str2 = bf.oz(str2);
        }
        aw.ZK();
        com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(str2);
        if (Rn == null) {
            AppMethodBeat.o(33120);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", Rn.svN);
        intent.putExtra("Contact_Alias", Rn.dFl);
        intent.putExtra("Contact_Nick", Rn.nickname);
        intent.putExtra("Contact_QuanPin", Rn.gwG);
        intent.putExtra("Contact_PyInitial", Rn.gwF);
        intent.putExtra("Contact_Uin", Rn.pnz);
        intent.putExtra("Contact_Mobile_MD5", Rn.xZi);
        intent.putExtra("Contact_full_Mobile_MD5", Rn.xZj);
        intent.putExtra("Contact_QQNick", Rn.dtZ());
        intent.putExtra("User_From_Fmessage", false);
        intent.putExtra("Contact_Scene", Rn.scene);
        intent.putExtra("Contact_FMessageCard", true);
        intent.putExtra("Contact_RemarkName", Rn.gwK);
        intent.putExtra("Contact_VUser_Info_Flag", Rn.ufB);
        intent.putExtra("Contact_VUser_Info", Rn.duh);
        intent.putExtra("Contact_BrandIconURL", Rn.pln);
        intent.putExtra("Contact_Province", Rn.getProvince());
        intent.putExtra("Contact_City", Rn.getCity());
        intent.putExtra("Contact_Sex", Rn.dtS);
        intent.putExtra("Contact_Signature", Rn.signature);
        intent.putExtra("Contact_ShowUserName", true);
        intent.putExtra("Contact_KSnsIFlag", 0);
        intent.putExtra("Contact_Source_FMessage", 17);
        intent.putExtra("source_from_user_name", str);
        intent.putExtra("source_from_nick_name", s.mI(str));
        intent.putExtra(com.tencent.mm.ui.e.b.yfT, Rn.vqs);
        intent.putExtra("key_add_contact_openim_appid", Rn.xZm);
        intent.putExtra("key_add_contact_custom_detail", Rn.xZp);
        if ((Rn.ufB & 8) > 0) {
            if (!ah.isNullOrNil(str)) {
                aw.ZK();
                if (com.tencent.mm.model.c.XM().aoO(str).dsf()) {
                    intent.putExtra("Contact_Scene", 41);
                    com.tencent.mm.plugin.report.service.h.pYm.X(10298, Rn.svN + ",41");
                }
            }
            intent.putExtra("Contact_Scene", 17);
            com.tencent.mm.plugin.report.service.h.pYm.X(10298, Rn.svN + ",17");
        }
        if (ad.aox(Rn.svN) && Rn.scene == 0) {
            intent.putExtra("Contact_Scene", 17);
        }
        if (t.kv(Rn.ufB)) {
            if (aVar.dFx()) {
                intent.putExtra("preChatTYPE", 2);
            } else {
                intent.putExtra("preChatTYPE", 1);
            }
            intent.putExtra("prePublishId", "msg_" + biVar.field_msgSvrId);
            if (ah.isNullOrNil(str)) {
                str = r.Yz();
            }
            intent.putExtra("preUsername", str);
            intent.putExtra("preChatName", biVar.field_talker);
        }
        com.tencent.mm.bp.d.b(aVar.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        com.tencent.mm.bq.a.Lu(Rn.scene);
        AppMethodBeat.o(33120);
    }
}
