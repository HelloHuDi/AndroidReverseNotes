package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5382c;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.as */
public final class C44338as {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.as$a */
    static abstract class C7343a extends C5378c {
        C7343a() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            return false;
        }

        /* renamed from: b */
        public String mo11017b(C46650a c46650a, C7620bi c7620bi) {
            return c46650a.getTalkerUserName();
        }

        public boolean dHk() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.as$c */
    public static class C7344c extends C5378c {
        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == -1879048188) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33436);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(2130969115, null);
                view.setTag(new C36210d().mo57091fe(view));
            }
            AppMethodBeat.m2505o(33436);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33437);
            c5379a.enf.setVisibility(0);
            c5379a.enf.setText(C14835h.m23091q(c46650a.yTx.getContext(), c7620bi.field_createTime));
            AppMethodBeat.m2505o(33437);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.as$b */
    public static class C23842b extends C7343a {
        /* renamed from: b */
        public final /* bridge */ /* synthetic */ String mo11017b(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33435);
            String b = super.mo11017b(c46650a, c7620bi);
            AppMethodBeat.m2505o(33435);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.m2504i(33434);
            boolean dHk = super.dHk();
            AppMethodBeat.m2505o(33434);
            return dHk;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == -1879048187) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33432);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969072);
                view.setTag(new C36210d().mo57091fe(view));
            }
            AppMethodBeat.m2505o(33432);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33433);
            C36210d c36210d = (C36210d) c5379a;
            C5382c c = mo11021c(c46650a);
            if (c36210d != null) {
                c36210d.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
                c36210d.jPL.setOnLongClickListener(c);
                c36210d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            AppMethodBeat.m2505o(33433);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.as$d */
    static class C36210d extends C5379a {
        TextView zfC;

        C36210d() {
        }

        /* renamed from: fe */
        public final C5379a mo57091fe(View view) {
            AppMethodBeat.m2504i(33438);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zfC = (TextView) view.findViewById(2131822631);
            this.jPL = view.findViewById(2131822515);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(33438);
            return this;
        }
    }
}
