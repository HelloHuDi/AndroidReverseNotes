package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class p {

    public static class c extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 16777265) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33004);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n_);
                view.setTag(new a().fa(view));
            }
            AppMethodBeat.o(33004);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33005);
            a aVar3 = (a) aVar;
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null && X.type == 1) {
                aVar3.zef.ah(com.tencent.mm.pluginsdk.ui.e.j.d(aVar3.zef.getContext(), X.title, (int) aVar3.zef.getTextSize()));
                aVar3.zef.setClickable(true);
                f bT = g.bT(X.appId, true);
                String str3 = (bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0) ? X.appName : bT.field_appName;
                if (X.appId == null || X.appId.length() <= 0 || !g.dg(str3)) {
                    aVar3.moL.setVisibility(8);
                } else {
                    aVar3.moL.setText(aVar2.yTx.getMMResources().getString(R.string.aoo, new Object[]{g.b(aVar2.yTx.getContext(), bT, str3)}));
                    aVar3.moL.setVisibility(0);
                    c.a(aVar2, (View) aVar3.moL, X.appId);
                    c.a(aVar2, aVar3.moL, X.appId);
                }
                if (biVar.field_status == 2 || biVar.field_status == 5) {
                    aVar3.pyf.setVisibility(8);
                } else {
                    aVar3.pyf.setVisibility(0);
                }
                a(i, (com.tencent.mm.ui.chatting.viewitems.c.a) aVar3, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            }
            aVar3.zef.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                aVar3.zef.setOnLongClickListener(c(aVar2));
                if (X != null && X.type == 1) {
                    aVar3.zef.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                }
            }
            AppMethodBeat.o(33005);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33006);
            int i = ((ay) view.getTag()).position;
            contextMenu.add(i, 102, 0, this.yJI.yTx.getMMResources().getString(R.string.am4));
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
            if (d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(R.string.dcq));
            }
            if (!biVar.drC() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(33006);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33007);
            switch (menuItem.getItemId()) {
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                    String str = com.tencent.mm.af.j.b.me(biVar.field_content).title;
                    clipboardManager.setText(str);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                    com.tencent.mm.plugin.secinforeport.a.a.h(1, biVar.field_msgSvrId, bo.ana(str));
                    AppMethodBeat.o(33007);
                    break;
                case 111:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", biVar.field_content);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(33007);
                    break;
                default:
                    AppMethodBeat.o(33007);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33008);
            if (biVar.bAA()) {
                l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(33008);
                return;
            }
            AppMethodBeat.o(33008);
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 16777265) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33000);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.ma);
                view.setTag(new a().fa(view));
            }
            AppMethodBeat.o(33000);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33001);
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (aVar2.dFx()) {
                int indexOf = biVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = biVar.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null && X.type == 1) {
                f bT = g.bT(X.appId, true);
                String str3 = (bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0) ? X.appName : bT.field_appName;
                if (X.appId == null || X.appId.length() <= 0 || !g.dg(str3)) {
                    aVar3.moL.setVisibility(8);
                } else {
                    aVar3.moL.setText(aVar2.yTx.getMMResources().getString(R.string.aoo, new Object[]{g.b(aVar2.yTx.getContext(), bT, str3)}));
                    aVar3.moL.setVisibility(0);
                    c.a(aVar2, (View) aVar3.moL, X.appId);
                    c.a(aVar2, aVar3.moL, X.appId);
                }
                if (X.dJv == null || X.dJv.length() <= 0) {
                    aVar3.zbU.setVisibility(8);
                } else {
                    b(aVar2, (View) aVar3.zbU, (Object) ay.arL(X.dJv));
                    aVar3.zbU.setVisibility(0);
                }
                aVar3.zef.setClickable(true);
                aVar3.zef.ah(com.tencent.mm.pluginsdk.ui.e.j.d(aVar3.zef.getContext(), X.title, (int) aVar3.zef.getTextSize()));
            }
            aVar3.zef.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                aVar3.zef.setOnLongClickListener(c(aVar2));
                if (X != null && X.type == 1) {
                    aVar3.zef.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                }
            }
            AppMethodBeat.o(33001);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33002);
            int i = ((ay) view.getTag()).position;
            contextMenu.add(i, 102, 0, this.yJI.yTx.getMMResources().getString(R.string.am4));
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
            if (d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(R.string.dcq));
            }
            if (bh.o(biVar)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(33002);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33003);
            switch (menuItem.getItemId()) {
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                    String str = com.tencent.mm.af.j.b.me(bf.b(aVar.dFw(), biVar.field_content, biVar.field_isSend)).title;
                    clipboardManager.setText(str);
                    com.tencent.mm.plugin.secinforeport.a.a aVar2 = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                    com.tencent.mm.plugin.secinforeport.a.a.h(1, biVar.field_msgSvrId, bo.ana(str));
                    AppMethodBeat.o(33003);
                    break;
                case 111:
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(33003);
                    break;
                default:
                    AppMethodBeat.o(33003);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    static final class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected TextView moL;
        protected ProgressBar pyf;
        protected TextView zbU;
        protected ImageView zby;
        protected MMNeat7extView zef;

        a() {
        }

        public final a fa(View view) {
            AppMethodBeat.i(32999);
            super.eP(view);
            this.zef = (MMNeat7extView) view.findViewById(R.id.oe);
            this.pyf = (ProgressBar) view.findViewById(R.id.at6);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.moL = (TextView) view.findViewById(R.id.aq0);
            this.zbU = (TextView) view.findViewById(R.id.anl);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(32999);
            return this;
        }
    }
}
