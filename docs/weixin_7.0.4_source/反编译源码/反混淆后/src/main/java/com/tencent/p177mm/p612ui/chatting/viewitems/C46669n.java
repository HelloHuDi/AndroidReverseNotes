package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.n */
public final class C46669n {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.n$c */
    public static class C30611c extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == -1879048186) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32981);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969091);
                view.setTag(new C46668a().mo74909eY(view));
            }
            AppMethodBeat.m2505o(32981);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32982);
            C46668a c46668a = (C46668a) c5379a;
            this.yJI = c46650a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                c46668a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
                c46668a.jPL.setOnClickListener(mo11022d(c46650a));
                if (this.kuU) {
                    c46668a.jPL.setOnLongClickListener(mo11021c(c46650a));
                    c46668a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                }
                c46668a.zea.setText(X.title);
            }
            if (C25859d.fUu == null || !C25859d.fUu.mo20565tQ(c46650a.getTalkerUserName())) {
                c46668a.zea.setTextColor(-8750470);
                c46668a.jPL.setClickable(false);
                c46668a.jPL.setEnabled(false);
                AppMethodBeat.m2505o(32982);
                return;
            }
            c46668a.zea.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4));
            c46668a.jPL.setClickable(true);
            c46668a.jPL.setEnabled(true);
            AppMethodBeat.m2505o(32982);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32983);
            int i = ((C40814ay) view.getTag()).position;
            C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C40439f bT = C46494g.m87739bT(me.appId, false);
            if (C25985d.afj("favorite") && (bT == null || !bT.mo63847xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                        break;
                }
            }
            if (!c7620bi.drC() && c7620bi.bAC() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32983);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32984);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32984);
                    break;
                default:
                    AppMethodBeat.m2505o(32984);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32985);
            C40723af c40723af = (C40723af) c46650a.mo74857aF(C40723af.class);
            c46650a.getTalkerUserName();
            c40723af.mo41852cg("fromMessage", true);
            AppMethodBeat.m2505o(32985);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.n$b */
    public static class C40818b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != -1879048186) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32976);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969054);
                view.setTag(new C46668a().mo74909eY(view));
            }
            AppMethodBeat.m2505o(32976);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            String substring;
            String str2;
            String str3;
            Object[] objArr;
            boolean z;
            C8910b c8910b;
            AppMethodBeat.m2504i(32977);
            C46668a c46668a = (C46668a) c5379a;
            this.yJI = c46650a;
            C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
            String str4 = c7620bi.field_content;
            if (c46650a.dFx()) {
                int indexOf = c7620bi.field_content.indexOf(58);
                if (indexOf != -1) {
                    substring = c7620bi.field_content.substring(indexOf + 1);
                    if (ma != null || substring == null) {
                        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                        str3 = "amessage:%b, %s, %s";
                        objArr = new Object[4];
                        if (ma != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        objArr[1] = substring;
                        objArr[2] = Long.valueOf(c7620bi.field_msgId);
                        objArr[3] = str;
                        C4990ab.m7413e(str2, str3, objArr);
                        c8910b = null;
                    } else {
                        c8910b = C8910b.m16058X(substring, c7620bi.field_reserved);
                    }
                    if (c8910b != null) {
                        c46668a.zea.setText(c8910b.title);
                        c46668a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
                        c46668a.jPL.setOnClickListener(mo11022d(c46650a));
                        if (this.kuU) {
                            c46668a.jPL.setOnLongClickListener(mo11021c(c46650a));
                            c46668a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                        }
                    }
                    if (C25859d.fUu == null && C25859d.fUu.mo20565tQ(c46650a.getTalkerUserName())) {
                        c46668a.zea.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4));
                        c46668a.jPL.setClickable(true);
                        c46668a.jPL.setEnabled(true);
                        AppMethodBeat.m2505o(32977);
                        return;
                    }
                    c46668a.zea.setTextColor(-8750470);
                    c46668a.jPL.setClickable(false);
                    c46668a.jPL.setEnabled(false);
                    AppMethodBeat.m2505o(32977);
                }
            }
            substring = str4;
            if (ma != null) {
            }
            str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
            str3 = "amessage:%b, %s, %s";
            objArr = new Object[4];
            if (ma != null) {
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = substring;
            objArr[2] = Long.valueOf(c7620bi.field_msgId);
            objArr[3] = str;
            C4990ab.m7413e(str2, str3, objArr);
            c8910b = null;
            if (c8910b != null) {
            }
            if (C25859d.fUu == null) {
            }
            c46668a.zea.setTextColor(-8750470);
            c46668a.jPL.setClickable(false);
            c46668a.jPL.setEnabled(false);
            AppMethodBeat.m2505o(32977);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32978);
            int i = ((C40814ay) view.getTag()).position;
            C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C40439f bT = C46494g.m87739bT(me.appId, false);
            if (C25985d.afj("favorite") && (bT == null || !bT.mo63847xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                        break;
                }
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32978);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32979);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32979);
                    break;
                default:
                    AppMethodBeat.m2505o(32979);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32980);
            C40723af c40723af = (C40723af) c46650a.mo74857aF(C40723af.class);
            c46650a.getTalkerUserName();
            c40723af.mo41852cg("fromMessage", true);
            AppMethodBeat.m2505o(32980);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.n$a */
    static class C46668a extends C5379a {
        protected TextView zea;

        C46668a() {
        }

        /* renamed from: eY */
        public final C46668a mo74909eY(View view) {
            AppMethodBeat.m2504i(32975);
            super.mo11031eP(view);
            this.zea = (TextView) view.findViewById(2131822513);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(32975);
            return this;
        }
    }
}
