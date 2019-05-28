package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36136e;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.u */
public final class C30618u {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.u$b */
    public static class C15762b extends C5378c {
        private C46650a yJI;
        private String zeJ;
        private String zeK;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || (i != 42 && i != 66)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33107);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969060);
                view.setTag(new C30619a().mo48999z(view, true));
            }
            AppMethodBeat.m2505o(33107);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(33108);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(33108);
            return dFx;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            String oz;
            int i2;
            AppMethodBeat.m2504i(33109);
            this.yJI = c46650a;
            C30619a c30619a = (C30619a) c5379a;
            if (c46650a.dFx()) {
                oz = C1829bf.m3763oz(c7620bi.field_content);
            } else {
                oz = c7620bi.field_content;
            }
            C9638aw.m17190ZK();
            C5135a Rn = C18628c.m29080XO().mo15260Rn(oz);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                C4990ab.m7412e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            this.zeK = "";
            if (!C42252ah.isNullOrNil(oz)) {
                Map z = C5049br.m7595z(oz, "msg");
                if (z.containsKey(".msg.$wechatid")) {
                    this.zeK = (String) z.get(".msg.$wechatid");
                }
            }
            C41730b.m73489U(this.zeJ, Rn.xZh);
            C5379a.m8170an(c30619a.jPL, c30619a.zcJ);
            if (C1855t.m3897kv(Rn.ufB)) {
                c30619a.zeH.setText(C25738R.string.ak2);
                c30619a.zeI.setVisibility(8);
                if (C1443d.m3068iW(16)) {
                    c30619a.zeG.setBackground(null);
                } else {
                    c30619a.zeG.setBackgroundDrawable(null);
                }
                C5378c.m8147w(c30619a.zeG, this.zeJ);
            } else {
                c30619a.zeH.setText(C25738R.string.an7);
                c30619a.zeG.setBackgroundResource(C25738R.drawable.ad2);
                C5378c.m8146v(c30619a.zeG, this.zeJ);
            }
            String str2 = this.zeK;
            if (C42252ah.isNullOrNil(str2) || C7616ad.aoA(str2) || C1855t.m3911mX(str2)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            boolean kv = C1855t.m3897kv(Rn.ufB);
            if (i2 != 0 || kv) {
                oz = "";
            } else {
                oz = str2;
            }
            if (C42252ah.isNullOrNil(oz)) {
                c30619a.zeI.setVisibility(8);
            } else {
                c30619a.zeI.setVisibility(0);
                c30619a.zeI.setText(oz);
            }
            c30619a.ejp.setText(C44089j.m79294b(c46650a.yTx.getContext(), Rn.nickname, (int) c30619a.ejp.getTextSize()));
            C30618u.m48825a(c46650a, this.zeJ, Rn, c30619a);
            c30619a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, str, 0));
            c30619a.jPL.setOnClickListener(mo11022d(c46650a));
            c30619a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c30619a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33109);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33110);
            int i = ((C40814ay) view.getTag()).position;
            C9638aw.m17190ZK();
            C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                C4990ab.m7412e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            if (C1855t.m3897kv(Rn.ufB)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(C25738R.string.dr1));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33110);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33111);
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(33111);
                    break;
                default:
                    AppMethodBeat.m2505o(33111);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33112);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C30618u.m48826a(c46650a, c40814ay.userName, c7620bi.field_content, c40814ay.yFW, c7620bi.field_isSend == 0, c7620bi);
            AppMethodBeat.m2505o(33112);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.u$a */
    static class C30619a extends C5379a {
        TextView ejp;
        public int zcJ;
        ImageView zci;
        ImageView zeG;
        TextView zeH;
        TextView zeI;

        C30619a() {
        }

        /* renamed from: z */
        public final C5379a mo48999z(View view, boolean z) {
            AppMethodBeat.m2504i(33106);
            super.mo11031eP(view);
            this.zeG = (ImageView) view.findViewById(2131822591);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zeH = (TextView) view.findViewById(2131822594);
            this.zeI = (TextView) view.findViewById(2131822593);
            this.ejp = (TextView) view.findViewById(2131822592);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.jPL = view.findViewById(2131822515);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            if (!z) {
                this.zby = (ImageView) view.findViewById(2131822629);
                this.zci = (ImageView) view.findViewById(2131822661);
                this.pyf = (ProgressBar) view.findViewById(2131822660);
            }
            this.zcJ = C5378c.m8145hV(C4996ah.getContext());
            AppMethodBeat.m2505o(33106);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.u$c */
    public static class C30620c extends C5378c implements C5365n {
        private C46650a yJI;
        private String zeJ;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && (i == 42 || i == 66)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33113);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969097);
                view.setTag(new C30619a().mo48999z(view, false));
            }
            AppMethodBeat.m2505o(33113);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0192  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0131  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            char c;
            char c2;
            boolean kv;
            int c22 = 1;
            AppMethodBeat.m2504i(33114);
            this.yJI = c46650a;
            c5379a = (C30619a) c5379a;
            C9638aw.m17190ZK();
            C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                C4990ab.m7412e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            C4990ab.m7411d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(C1855t.m3913mZ(this.zeJ)), this.zeJ);
            C5379a.m8170an(c5379a.jPL, c5379a.zcJ);
            if (C1855t.m3897kv(Rn.ufB)) {
                c5379a.zeH.setText(C25738R.string.ak2);
                c5379a.zeI.setVisibility(8);
                if (C1443d.m3068iW(16)) {
                    c5379a.zeG.setBackground(null);
                } else {
                    c5379a.zeG.setBackgroundDrawable(null);
                }
                C5378c.m8147w(c5379a.zeG, this.zeJ);
            } else {
                c5379a.zeH.setText(C25738R.string.an7);
                c5379a.zeG.setBackgroundResource(C25738R.drawable.ad2);
                C5378c.m8146v(c5379a.zeG, this.zeJ);
            }
            c5379a.ejp.setText(C44089j.m79293b(c46650a.yTx.getContext(), Rn.nickname, c5379a.ejp.getTextSize()));
            String str2 = Rn.dFl;
            if (!C42252ah.isNullOrNil(this.zeJ)) {
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(this.zeJ);
                if (aoO != null && C7486a.m12942jh(aoO.field_type)) {
                    c = 0;
                    if (c == 0 || !C42252ah.isNullOrNil(str2)) {
                        c22 = c;
                    } else {
                        str2 = this.zeJ;
                        if (!(C42252ah.isNullOrNil(str2) || C7616ad.aoA(str2) || C1855t.m3911mX(str2))) {
                            c22 = 0;
                        }
                    }
                    kv = C1855t.m3897kv(Rn.ufB);
                    if (c22 != 0 || kv) {
                        str2 = "";
                    }
                    if (C42252ah.isNullOrNil(str2)) {
                        c5379a.zeI.setVisibility(0);
                        c5379a.zeI.setText(str2);
                    } else {
                        c5379a.zeI.setVisibility(8);
                    }
                    C30618u.m48825a(c46650a, this.zeJ, Rn, c5379a);
                    c5379a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
                    c5379a.jPL.setOnClickListener(mo11022d(c46650a));
                    c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
                    c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                    if (!C5378c.dHm()) {
                        if (c5379a.pyf != null) {
                            c5379a.pyf.setVisibility(8);
                        }
                        if (c7620bi.field_status == 2 && C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                            if (c5379a.zci != null) {
                                c5379a.zci.setVisibility(0);
                            }
                        } else if (c5379a.zci != null) {
                            c5379a.zci.setVisibility(8);
                        }
                    } else if (c5379a.pyf != null) {
                        c5379a.pyf.setVisibility(0);
                        if (c7620bi.field_status >= 2) {
                            c5379a.pyf.setVisibility(8);
                        }
                    }
                    mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
                    AppMethodBeat.m2505o(33114);
                }
            }
            c = 1;
            if (c == 0) {
            }
            c22 = c;
            kv = C1855t.m3897kv(Rn.ufB);
            str2 = "";
            if (C42252ah.isNullOrNil(str2)) {
            }
            C30618u.m48825a(c46650a, this.zeJ, Rn, c5379a);
            c5379a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            if (!C5378c.dHm()) {
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33114);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33115);
            int i = ((C40814ay) view.getTag()).position;
            C9638aw.m17190ZK();
            C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
            if (Rn.svN == null || Rn.svN.length() <= 0) {
                C4990ab.m7412e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.zeJ = Rn.svN;
            if (C1855t.m3897kv(Rn.ufB)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(C25738R.string.dr1));
            }
            if (!c7620bi.drC() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && c7620bi.dtw() && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33115);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33116);
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(33116);
                    break;
                default:
                    AppMethodBeat.m2505o(33116);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33117);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C30618u.m48826a(c46650a, c40814ay.userName, c7620bi.field_content, c40814ay.yFW, c7620bi.field_isSend == 0, c7620bi);
            AppMethodBeat.m2505o(33117);
            return true;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33118);
            c7620bi.dtJ();
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            ((C36136e) c46650a.mo74857aF(C36136e.class)).mo57025bb(c7620bi);
            AppMethodBeat.m2505o(33118);
        }
    }

    /* renamed from: a */
    public static void m48825a(C46650a c46650a, String str, C5135a c5135a, C30619a c30619a) {
        AppMethodBeat.m2504i(33119);
        if (C7616ad.aox(str)) {
            CharSequence a;
            String a2 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(c5135a.xZm, "openim_card_type_name", C32874a.TYPE_WORDING);
            if (TextUtils.isEmpty(a2)) {
                c30619a.zeH.setText(C25738R.string.an7);
            } else {
                c30619a.zeH.setText(a2);
            }
            c30619a.zeG.setBackgroundResource(C25738R.drawable.ad2);
            C5378c.m8146v(c30619a.zeG, str);
            String str2 = c5135a.xZo;
            String str3 = c5135a.xZn;
            if (C42252ah.isNullOrNil(str2)) {
                Object a3 = str3;
            } else {
                a3 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44299a(c46650a.yTx.getContext(), str2, str3, c30619a.zeI.getTextSize());
            }
            if (TextUtils.isEmpty(a3)) {
                c30619a.zeI.setVisibility(8);
                AppMethodBeat.m2505o(33119);
                return;
            }
            c30619a.zeI.setVisibility(0);
            c30619a.zeI.setText(a3);
            AppMethodBeat.m2505o(33119);
            return;
        }
        AppMethodBeat.m2505o(33119);
    }

    /* renamed from: a */
    public static void m48826a(C46650a c46650a, String str, String str2, boolean z, boolean z2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33120);
        if (z && z2) {
            str2 = C1829bf.m3763oz(str2);
        }
        C9638aw.m17190ZK();
        C5135a Rn = C18628c.m29080XO().mo15260Rn(str2);
        if (Rn == null) {
            AppMethodBeat.m2505o(33120);
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
        intent.putExtra("source_from_nick_name", C1854s.m3865mI(str));
        intent.putExtra(C5495b.yfT, Rn.vqs);
        intent.putExtra("key_add_contact_openim_appid", Rn.xZm);
        intent.putExtra("key_add_contact_custom_detail", Rn.xZp);
        if ((Rn.ufB & 8) > 0) {
            if (!C42252ah.isNullOrNil(str)) {
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().aoO(str).dsf()) {
                    intent.putExtra("Contact_Scene", 41);
                    C7060h.pYm.mo8374X(10298, Rn.svN + ",41");
                }
            }
            intent.putExtra("Contact_Scene", 17);
            C7060h.pYm.mo8374X(10298, Rn.svN + ",17");
        }
        if (C7616ad.aox(Rn.svN) && Rn.scene == 0) {
            intent.putExtra("Contact_Scene", 17);
        }
        if (C1855t.m3897kv(Rn.ufB)) {
            if (c46650a.dFx()) {
                intent.putExtra("preChatTYPE", 2);
            } else {
                intent.putExtra("preChatTYPE", 1);
            }
            intent.putExtra("prePublishId", "msg_" + c7620bi.field_msgSvrId);
            if (C42252ah.isNullOrNil(str)) {
                str = C1853r.m3846Yz();
            }
            intent.putExtra("preUsername", str);
            intent.putExtra("preChatName", c7620bi.field_talker);
        }
        C25985d.m41467b(c46650a.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        C18114a.m28535Lu(Rn.scene);
        AppMethodBeat.m2505o(33120);
    }
}
