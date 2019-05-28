package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.m */
public final class C15754m {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.m$b */
    public static class C15755b extends C5378c {
        private C46650a yJI;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 704643121) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32969);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969053);
                view.setTag(new C15757a().mo27966eX(view));
            }
            AppMethodBeat.m2505o(32969);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32970);
            this.yJI = c46650a;
            C15757a.m24098a((C15757a) c5379a, i, c46650a, c7620bi, this);
            AppMethodBeat.m2505o(32970);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32971);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi != null) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32971);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.m$c */
    public static class C15756c extends C5378c {
        private C46650a yJI;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 704643121) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32972);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969090);
                view.setTag(new C15757a().mo27966eX(view));
            }
            AppMethodBeat.m2505o(32972);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32973);
            this.yJI = c46650a;
            C15757a.m24098a((C15757a) c5379a, i, c46650a, c7620bi, this);
            AppMethodBeat.m2505o(32973);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32974);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32974);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.m$a */
    static class C15757a extends C5379a {
        private ProgressBar pyf;
        private MMNeat7extView zdZ;

        C15757a() {
        }

        /* renamed from: eX */
        public final C15757a mo27966eX(View view) {
            AppMethodBeat.m2504i(32967);
            super.mo11031eP(view);
            this.zdZ = (MMNeat7extView) view.findViewById(2131821103);
            this.zdZ.setOnTouchListener(new C23306f(this.zdZ, new C30132m(this.zdZ.getContext())));
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.pyf = (ProgressBar) view.findViewById(2131822660);
            AppMethodBeat.m2505o(32967);
            return this;
        }

        /* renamed from: a */
        public static void m24098a(C15757a c15757a, int i, C46650a c46650a, C7620bi c7620bi, C5378c c5378c) {
            AppMethodBeat.m2504i(32968);
            C8910b c8910b = null;
            String str = c7620bi.field_content;
            if (c46650a.dFx()) {
                int indexOf = c7620bi.field_content.indexOf(58);
                if (indexOf != -1) {
                    str = c7620bi.field_content.substring(indexOf + 1);
                }
            }
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null && c8910b.type == 47) {
                CharSequence charSequence = c8910b.content;
                Object bundle = new Bundle();
                bundle.putString("rawUrl", c8910b.url);
                bundle.putString("sender_name", c7620bi.field_talker);
                c15757a.zdZ.mo15920a(C44089j.m79286a(C4996ah.getContext(), charSequence, (int) c15757a.zdZ.getTextSize(), bundle, true), BufferType.SPANNABLE);
                c15757a.zdZ.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c7620bi.field_talker, 0));
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    c15757a.zdZ.setOnLongClickListener(c5378c.mo11021c(c46650a));
                }
            }
            AppMethodBeat.m2505o(32968);
        }
    }
}
