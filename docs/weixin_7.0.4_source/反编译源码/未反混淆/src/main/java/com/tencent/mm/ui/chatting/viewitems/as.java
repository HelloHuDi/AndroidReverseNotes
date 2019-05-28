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
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.storage.bi;

public final class as {

    static abstract class a extends c {
        a() {
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            return false;
        }

        public String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return aVar.getTalkerUserName();
        }

        public boolean dHk() {
            return false;
        }
    }

    public static class c extends c {
        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (i == -1879048188) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33436);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.nt, null);
                view.setTag(new d().fe(view));
            }
            AppMethodBeat.o(33436);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33437);
            aVar.enf.setVisibility(0);
            aVar.enf.setText(h.q(aVar2.yTx.getContext(), biVar.field_createTime));
            AppMethodBeat.o(33437);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class b extends a {
        public final /* bridge */ /* synthetic */ String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33435);
            String b = super.b(aVar, biVar);
            AppMethodBeat.o(33435);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.i(33434);
            boolean dHk = super.dHk();
            AppMethodBeat.o(33434);
            return dHk;
        }

        public final boolean aH(int i, boolean z) {
            if (i == -1879048187) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33432);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mo);
                view.setTag(new d().fe(view));
            }
            AppMethodBeat.o(33432);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33433);
            d dVar = (d) aVar;
            com.tencent.mm.ui.chatting.viewitems.c.c c = c(aVar2);
            if (dVar != null) {
                dVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
                dVar.jPL.setOnLongClickListener(c);
                dVar.jPL.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
            }
            AppMethodBeat.o(33433);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView zfC;

        d() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fe(View view) {
            AppMethodBeat.i(33438);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zfC = (TextView) view.findViewById(R.id.asd);
            this.jPL = view.findViewById(R.id.ap9);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(33438);
            return this;
        }
    }
}
