package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.s.n;

public final class ah {

    static class c extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView moL;
        TextView zfC;

        c() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fe(View view) {
            AppMethodBeat.i(33276);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zfC = (TextView) view.findViewById(R.id.oe);
            this.moL = (TextView) view.findViewById(R.id.at5);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(33276);
            return this;
        }
    }

    public static class a extends com.tencent.mm.ui.chatting.viewitems.al.a {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean aH(int i, boolean z) {
            if (z || (i != 55 && i != 57)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33271);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.my);
                view.setTag(new c().fe(view));
            }
            AppMethodBeat.o(33271);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33272);
            this.yJI = aVar2;
            c cVar = (c) aVar;
            com.tencent.mm.ak.a.a rE = com.tencent.mm.ak.a.a.rE(biVar.field_content);
            if (rE == null) {
                AppMethodBeat.o(33272);
                return;
            }
            String str2 = rE.cEV;
            a((com.tencent.mm.ui.chatting.viewitems.c.a) cVar, aVar2, biVar, str2);
            a((com.tencent.mm.ui.chatting.viewitems.c.a) cVar, aVar2, str2, biVar);
            j.a(cVar.zfC.getContext(), com.tencent.mm.ak.a.a(rE), (int) cVar.zfC.getTextSize(), 1, null, "");
            cVar.zfC.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            cVar.zfC.setOnLongClickListener(c(aVar2));
            AppMethodBeat.o(33272);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33273);
            if (biVar.dtE()) {
                int i = ((ay) view.getTag()).position;
                if (biVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                }
            }
            AppMethodBeat.o(33273);
            return true;
        }
    }

    public static class b extends com.tencent.mm.ui.chatting.viewitems.al.b {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean aH(int i, boolean z) {
            if (z && (i == 55 || i == 57)) {
                return true;
            }
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33274);
            this.yJI = aVar2;
            aVar = (f) aVar;
            com.tencent.mm.ak.a.a rE = com.tencent.mm.ak.a.a.rE(biVar.field_content);
            if (biVar.field_status >= 2) {
                aVar.pyf.setVisibility(8);
            } else {
                aVar.pyf.setVisibility(0);
            }
            j.a(aVar.zgQ.getContext(), com.tencent.mm.ak.a.a(rE), (int) aVar.zgQ.getTextSize(), 1, null, "");
            aVar.zgQ.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aVar.zgQ.setOnLongClickListener(c(aVar2));
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33274);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33275);
            if (biVar.dtE()) {
                int i = ((ay) view.getTag()).position;
                if (biVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                }
            }
            AppMethodBeat.o(33275);
            return true;
        }
    }
}
