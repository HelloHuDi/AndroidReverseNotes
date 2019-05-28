package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p186ak.C1235a;
import com.tencent.p177mm.p186ak.C1235a.C1236a;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C30586al.C30587b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C30586al.C30591a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C30586al.C5374f;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ah */
public final class C44333ah {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ah$c */
    static class C31499c extends C5379a {
        TextView moL;
        TextView zfC;

        C31499c() {
        }

        /* renamed from: fe */
        public final C5379a mo51425fe(View view) {
            AppMethodBeat.m2504i(33276);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zfC = (TextView) view.findViewById(2131821103);
            this.moL = (TextView) view.findViewById(2131822659);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(33276);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ah$a */
    public static class C44331a extends C30591a {
        private C46650a yJI;

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || (i != 55 && i != 57)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33271);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969082);
                view.setTag(new C31499c().mo51425fe(view));
            }
            AppMethodBeat.m2505o(33271);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33272);
            this.yJI = c46650a;
            C31499c c31499c = (C31499c) c5379a;
            C1236a rE = C1236a.m2673rE(c7620bi.field_content);
            if (rE == null) {
                AppMethodBeat.m2505o(33272);
                return;
            }
            String str2 = rE.cEV;
            mo11011a((C5379a) c31499c, c46650a, c7620bi, str2);
            mo11012a((C5379a) c31499c, c46650a, str2, c7620bi);
            C44089j.m79283a(c31499c.zfC.getContext(), C1235a.m2671a(rE), (int) c31499c.zfC.getTextSize(), 1, null, "");
            c31499c.zfC.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c31499c.zfC.setOnLongClickListener(mo11021c(c46650a));
            AppMethodBeat.m2505o(33272);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33273);
            if (c7620bi.dtE()) {
                int i = ((C40814ay) view.getTag()).position;
                if (c7620bi.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                }
            }
            AppMethodBeat.m2505o(33273);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ah$b */
    public static class C44332b extends C30587b {
        private C46650a yJI;

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && (i == 55 || i == 57)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33274);
            this.yJI = c46650a;
            c5379a = (C5374f) c5379a;
            C1236a rE = C1236a.m2673rE(c7620bi.field_content);
            if (c7620bi.field_status >= 2) {
                c5379a.pyf.setVisibility(8);
            } else {
                c5379a.pyf.setVisibility(0);
            }
            C44089j.m79283a(c5379a.zgQ.getContext(), C1235a.m2671a(rE), (int) c5379a.zgQ.getTextSize(), 1, null, "");
            c5379a.zgQ.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c5379a.zgQ.setOnLongClickListener(mo11021c(c46650a));
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33274);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33275);
            if (c7620bi.dtE()) {
                int i = ((C40814ay) view.getTag()).position;
                if (c7620bi.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                }
            }
            AppMethodBeat.m2505o(33275);
            return true;
        }
    }
}
