package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.p */
public final class C46670p {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.p$c */
    public static class C7348c extends C5378c implements C5365n {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 16777265) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33004);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969094);
                view.setTag(new C36228a().mo57099fa(view));
            }
            AppMethodBeat.m2505o(33004);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33005);
            C36228a c36228a = (C36228a) c5379a;
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null && X.type == 1) {
                c36228a.zef.mo15921ah(C44089j.m79301d(c36228a.zef.getContext(), X.title, (int) c36228a.zef.getTextSize()));
                c36228a.zef.setClickable(true);
                C40439f bT = C46494g.m87739bT(X.appId, true);
                String str3 = (bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0) ? X.appName : bT.field_appName;
                if (X.appId == null || X.appId.length() <= 0 || !C46494g.m87743dg(str3)) {
                    c36228a.moL.setVisibility(8);
                } else {
                    c36228a.moL.setText(c46650a.yTx.getMMResources().getString(C25738R.string.aoo, new Object[]{C46494g.m87733b(c46650a.yTx.getContext(), bT, str3)}));
                    c36228a.moL.setVisibility(0);
                    C5378c.m8126a(c46650a, (View) c36228a.moL, X.appId);
                    C5378c.m8130a(c46650a, c36228a.moL, X.appId);
                }
                if (c7620bi.field_status == 2 || c7620bi.field_status == 5) {
                    c36228a.pyf.setVisibility(8);
                } else {
                    c36228a.pyf.setVisibility(0);
                }
                mo11007a(i, (C5379a) c36228a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            }
            c36228a.zef.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                c36228a.zef.setOnLongClickListener(mo11021c(c46650a));
                if (X != null && X.type == 1) {
                    c36228a.zef.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                }
            }
            AppMethodBeat.m2505o(33005);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33006);
            int i = ((C40814ay) view.getTag()).position;
            contextMenu.add(i, 102, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am4));
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
            if (C25985d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dcq));
            }
            if (!c7620bi.drC() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33006);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33007);
            switch (menuItem.getItemId()) {
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    String str = C8910b.m16064me(c7620bi.field_content).title;
                    clipboardManager.setText(str);
                    C21734a c21734a = C21734a.qjm;
                    C21734a.m33275h(1, c7620bi.field_msgSvrId, C5046bo.ana(str));
                    AppMethodBeat.m2505o(33007);
                    break;
                case 111:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", c7620bi.field_content);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(33007);
                    break;
                default:
                    AppMethodBeat.m2505o(33007);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33008);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(33008);
                return;
            }
            AppMethodBeat.m2505o(33008);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.p$b */
    public static class C15758b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 16777265) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33000);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969057);
                view.setTag(new C36228a().mo57099fa(view));
            }
            AppMethodBeat.m2505o(33000);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33001);
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            C36228a c36228a = (C36228a) c5379a;
            String str2 = c7620bi.field_content;
            if (c46650a.dFx()) {
                int indexOf = c7620bi.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = c7620bi.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null && X.type == 1) {
                C40439f bT = C46494g.m87739bT(X.appId, true);
                String str3 = (bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0) ? X.appName : bT.field_appName;
                if (X.appId == null || X.appId.length() <= 0 || !C46494g.m87743dg(str3)) {
                    c36228a.moL.setVisibility(8);
                } else {
                    c36228a.moL.setText(c46650a.yTx.getMMResources().getString(C25738R.string.aoo, new Object[]{C46494g.m87733b(c46650a.yTx.getContext(), bT, str3)}));
                    c36228a.moL.setVisibility(0);
                    C5378c.m8126a(c46650a, (View) c36228a.moL, X.appId);
                    C5378c.m8130a(c46650a, c36228a.moL, X.appId);
                }
                if (X.dJv == null || X.dJv.length() <= 0) {
                    c36228a.zbU.setVisibility(8);
                } else {
                    mo11018b(c46650a, (View) c36228a.zbU, (Object) C40814ay.arL(X.dJv));
                    c36228a.zbU.setVisibility(0);
                }
                c36228a.zef.setClickable(true);
                c36228a.zef.mo15921ah(C44089j.m79301d(c36228a.zef.getContext(), X.title, (int) c36228a.zef.getTextSize()));
            }
            c36228a.zef.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                c36228a.zef.setOnLongClickListener(mo11021c(c46650a));
                if (X != null && X.type == 1) {
                    c36228a.zef.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                }
            }
            AppMethodBeat.m2505o(33001);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33002);
            int i = ((C40814ay) view.getTag()).position;
            contextMenu.add(i, 102, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am4));
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
            if (C25985d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dcq));
            }
            if (C1831bh.m3770o(c7620bi)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33002);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33003);
            switch (menuItem.getItemId()) {
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    String str = C8910b.m16064me(C1829bf.m3745b(c46650a.dFw(), c7620bi.field_content, c7620bi.field_isSend)).title;
                    clipboardManager.setText(str);
                    C21734a c21734a = C21734a.qjm;
                    C21734a.m33275h(1, c7620bi.field_msgSvrId, C5046bo.ana(str));
                    AppMethodBeat.m2505o(33003);
                    break;
                case 111:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(33003);
                    break;
                default:
                    AppMethodBeat.m2505o(33003);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.p$a */
    static final class C36228a extends C5379a {
        protected TextView moL;
        protected ProgressBar pyf;
        protected TextView zbU;
        protected ImageView zby;
        protected MMNeat7extView zef;

        C36228a() {
        }

        /* renamed from: fa */
        public final C36228a mo57099fa(View view) {
            AppMethodBeat.m2504i(32999);
            super.mo11031eP(view);
            this.zef = (MMNeat7extView) view.findViewById(2131821103);
            this.pyf = (ProgressBar) view.findViewById(2131822660);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.moL = (TextView) view.findViewById(2131822543);
            this.zbU = (TextView) view.findViewById(2131822454);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(32999);
            return this;
        }
    }
}
