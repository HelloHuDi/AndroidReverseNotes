package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.ui.chatting.c.b.h;

public final class af {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (i == 35) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33264);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.mj, null);
                b bVar = new b();
                bVar.enf = (TextView) view.findViewById(R.id.ag);
                bVar.qkY = (TextView) view.findViewById(R.id.od);
                bVar.zdN = (ImageView) view.findViewById(R.id.arx);
                bVar.zgd = (TextView) view.findViewById(R.id.ary);
                bVar.zfC = (TextView) view.findViewById(R.id.oe);
                bVar.jPL = view.findViewById(R.id.ap9);
                view.setTag(bVar);
            }
            AppMethodBeat.o(33264);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33265);
            this.yJI = aVar2;
            b bVar = (b) aVar;
            aw.ZK();
            c Rl = com.tencent.mm.model.c.XO().Rl(biVar.field_content);
            bVar.zgd.setText(Rl.title);
            bVar.zfC.setText(Rl.content);
            c.a((com.tencent.mm.ui.chatting.viewitems.c.a) bVar, (CharSequence) Rl.fOt);
            bVar.zdN.setVisibility(Rl.mpz ? 0 : 8);
            bVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            bVar.jPL.setOnClickListener(d(aVar2));
            bVar.jPL.setOnLongClickListener(c(aVar2));
            bVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            AppMethodBeat.o(33265);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33266);
            int i = ((ay) view.getTag()).position;
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
            }
            AppMethodBeat.o(33266);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33267);
            ay ayVar = (ay) view.getTag();
            aw.ZK();
            c Rl = com.tencent.mm.model.c.XO().Rl(ayVar.cKd.field_content);
            if (ah.nullAsNil(Rl.ptI).length() > 0) {
                d.b(aVar.yTx.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", ayVar.cKd.field_msgId));
            } else if (ah.nullAsNil(Rl.xZu).length() > 0) {
                d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(Rl.xZu)));
            }
            AppMethodBeat.o(33267);
            return true;
        }
    }

    static class b extends com.tencent.mm.ui.chatting.viewitems.c.a {
        ImageView zdN;
        TextView zfC;
        TextView zgd;

        b() {
        }
    }
}
