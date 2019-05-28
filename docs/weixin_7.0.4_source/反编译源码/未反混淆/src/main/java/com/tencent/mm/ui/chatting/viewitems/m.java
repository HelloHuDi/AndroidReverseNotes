package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.e.f;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class m {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 704643121) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32969);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m7);
                view.setTag(new a().eX(view));
            }
            AppMethodBeat.o(32969);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32970);
            this.yJI = aVar2;
            a.a((a) aVar, i, aVar2, biVar, this);
            AppMethodBeat.o(32970);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32971);
            int i = ((ay) view.getTag()).position;
            if (biVar != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32971);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 704643121) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32972);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n6);
                view.setTag(new a().eX(view));
            }
            AppMethodBeat.o(32972);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32973);
            this.yJI = aVar2;
            a.a((a) aVar, i, aVar2, biVar, this);
            AppMethodBeat.o(32973);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32974);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32974);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        private ProgressBar pyf;
        private MMNeat7extView zdZ;

        a() {
        }

        public final a eX(View view) {
            AppMethodBeat.i(32967);
            super.eP(view);
            this.zdZ = (MMNeat7extView) view.findViewById(R.id.oe);
            this.zdZ.setOnTouchListener(new f(this.zdZ, new com.tencent.mm.pluginsdk.ui.e.m(this.zdZ.getContext())));
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.pyf = (ProgressBar) view.findViewById(R.id.at6);
            AppMethodBeat.o(32967);
            return this;
        }

        public static void a(a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, c cVar) {
            AppMethodBeat.i(32968);
            com.tencent.mm.af.j.b bVar = null;
            String str = biVar.field_content;
            if (aVar2.dFx()) {
                int indexOf = biVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    str = biVar.field_content.substring(indexOf + 1);
                }
            }
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null && bVar.type == 47) {
                CharSequence charSequence = bVar.content;
                Object bundle = new Bundle();
                bundle.putString("rawUrl", bVar.url);
                bundle.putString("sender_name", biVar.field_talker);
                aVar.zdZ.a(j.a(ah.getContext(), charSequence, (int) aVar.zdZ.getTextSize(), bundle, true), BufferType.SPANNABLE);
                aVar.zdZ.setTag(new ay(biVar, aVar2.dFx(), i, biVar.field_talker, 0));
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    aVar.zdZ.setOnLongClickListener(cVar.c(aVar2));
                }
            }
            AppMethodBeat.o(32968);
        }
    }
}
