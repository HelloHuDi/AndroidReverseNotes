package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class n {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == -1879048186) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32981);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n7);
                view.setTag(new a().eY(view));
            }
            AppMethodBeat.o(32981);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32982);
            a aVar3 = (a) aVar;
            this.yJI = aVar2;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                aVar3.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
                aVar3.jPL.setOnClickListener(d(aVar2));
                if (this.kuU) {
                    aVar3.jPL.setOnLongClickListener(c(aVar2));
                    aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                }
                aVar3.zea.setText(X.title);
            }
            if (d.fUu == null || !d.fUu.tQ(aVar2.getTalkerUserName())) {
                aVar3.zea.setTextColor(-8750470);
                aVar3.jPL.setClickable(false);
                aVar3.jPL.setEnabled(false);
                AppMethodBeat.o(32982);
                return;
            }
            aVar3.zea.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.w4));
            aVar3.jPL.setClickable(true);
            aVar3.jPL.setEnabled(true);
            AppMethodBeat.o(32982);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32983);
            int i = ((ay) view.getTag()).position;
            l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            f bT = g.bT(me.appId, false);
            if (com.tencent.mm.bp.d.afj("favorite") && (bT == null || !bT.xy())) {
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
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                        break;
                }
            }
            if (!biVar.drC() && biVar.bAC() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32983);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32984);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32984);
                    break;
                default:
                    AppMethodBeat.o(32984);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32985);
            af afVar = (af) aVar.aF(af.class);
            aVar.getTalkerUserName();
            afVar.cg("fromMessage", true);
            AppMethodBeat.o(32985);
            return true;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != -1879048186) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32976);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m8);
                view.setTag(new a().eY(view));
            }
            AppMethodBeat.o(32976);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            String substring;
            String str2;
            String str3;
            Object[] objArr;
            boolean z;
            com.tencent.mm.af.j.b bVar;
            AppMethodBeat.i(32977);
            a aVar3 = (a) aVar;
            this.yJI = aVar2;
            j ma = am.dhN().ma(biVar.field_msgId);
            String str4 = biVar.field_content;
            if (aVar2.dFx()) {
                int indexOf = biVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    substring = biVar.field_content.substring(indexOf + 1);
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
                        objArr[2] = Long.valueOf(biVar.field_msgId);
                        objArr[3] = str;
                        ab.e(str2, str3, objArr);
                        bVar = null;
                    } else {
                        bVar = com.tencent.mm.af.j.b.X(substring, biVar.field_reserved);
                    }
                    if (bVar != null) {
                        aVar3.zea.setText(bVar.title);
                        aVar3.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
                        aVar3.jPL.setOnClickListener(d(aVar2));
                        if (this.kuU) {
                            aVar3.jPL.setOnLongClickListener(c(aVar2));
                            aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                        }
                    }
                    if (d.fUu == null && d.fUu.tQ(aVar2.getTalkerUserName())) {
                        aVar3.zea.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.w4));
                        aVar3.jPL.setClickable(true);
                        aVar3.jPL.setEnabled(true);
                        AppMethodBeat.o(32977);
                        return;
                    }
                    aVar3.zea.setTextColor(-8750470);
                    aVar3.jPL.setClickable(false);
                    aVar3.jPL.setEnabled(false);
                    AppMethodBeat.o(32977);
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
            objArr[2] = Long.valueOf(biVar.field_msgId);
            objArr[3] = str;
            ab.e(str2, str3, objArr);
            bVar = null;
            if (bVar != null) {
            }
            if (d.fUu == null) {
            }
            aVar3.zea.setTextColor(-8750470);
            aVar3.jPL.setClickable(false);
            aVar3.jPL.setEnabled(false);
            AppMethodBeat.o(32977);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32978);
            int i = ((ay) view.getTag()).position;
            l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            f bT = g.bT(me.appId, false);
            if (com.tencent.mm.bp.d.afj("favorite") && (bT == null || !bT.xy())) {
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
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                        break;
                }
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32978);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32979);
            switch (menuItem.getItemId()) {
                case 111:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32979);
                    break;
                default:
                    AppMethodBeat.o(32979);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32980);
            af afVar = (af) aVar.aF(af.class);
            aVar.getTalkerUserName();
            afVar.cg("fromMessage", true);
            AppMethodBeat.o(32980);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected TextView zea;

        a() {
        }

        public final a eY(View view) {
            AppMethodBeat.i(32975);
            super.eP(view);
            this.zea = (TextView) view.findViewById(R.id.ap7);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(32975);
            return this;
        }
    }
}
