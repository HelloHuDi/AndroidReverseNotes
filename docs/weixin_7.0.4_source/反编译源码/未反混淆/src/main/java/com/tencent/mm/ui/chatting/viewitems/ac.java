package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;

public final class ac extends c {

    final class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected ImageView gvq;
        protected TextView zfU;

        a() {
        }

        public final a fh(View view) {
            AppMethodBeat.i(33224);
            super.eP(view);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.gvq = (ImageView) view.findViewById(R.id.asv);
            this.zfU = (TextView) view.findViewById(R.id.asn);
            AppMethodBeat.o(33224);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048176) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33225);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.mu);
            view.setTag(new a().fh(view));
        }
        AppMethodBeat.o(33225);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        b bVar;
        AppMethodBeat.i(33226);
        a aVar3 = (a) aVar;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str2 = biVar.field_content;
        if (ma == null || str2 == null) {
            boolean z;
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            if (ma == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(biVar.field_msgId);
            objArr[3] = str;
            ab.e(str3, str4, objArr);
            bVar = null;
        } else {
            bVar = b.X(str2, biVar.field_reserved);
        }
        ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
        if (bVar != null && (bVar.showType == 3 || bVar.fhn == 3)) {
            aVar3.gvq.setImageResource(R.drawable.agt);
            aVar3.zfU.setText(bVar.fhs);
        }
        aVar.jPL.setOnLongClickListener(c(aVar2));
        aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
        aVar.jPL.setTag(ayVar);
        AppMethodBeat.o(33226);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33227);
        contextMenu.add(((ay) view.getTag()).position, 100, 0, view.getContext().getString(R.string.am7));
        AppMethodBeat.o(33227);
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33228);
        menuItem.getItemId();
        AppMethodBeat.o(33228);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        return false;
    }
}
