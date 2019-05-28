package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5137c;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.af */
public final class C30583af {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.af$a */
    public static class C30582a extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == 35) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33264);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(2130969066, null);
                C30584b c30584b = new C30584b();
                c30584b.enf = (TextView) view.findViewById(2131820587);
                c30584b.qkY = (TextView) view.findViewById(2131821102);
                c30584b.zdN = (ImageView) view.findViewById(2131822614);
                c30584b.zgd = (TextView) view.findViewById(2131822615);
                c30584b.zfC = (TextView) view.findViewById(2131821103);
                c30584b.jPL = view.findViewById(2131822515);
                view.setTag(c30584b);
            }
            AppMethodBeat.m2505o(33264);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33265);
            this.yJI = c46650a;
            C30584b c30584b = (C30584b) c5379a;
            C9638aw.m17190ZK();
            C5137c Rl = C18628c.m29080XO().mo15258Rl(c7620bi.field_content);
            c30584b.zgd.setText(Rl.title);
            c30584b.zfC.setText(Rl.content);
            C5378c.m8134a((C5379a) c30584b, (CharSequence) Rl.fOt);
            c30584b.zdN.setVisibility(Rl.mpz ? 0 : 8);
            c30584b.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c30584b.jPL.setOnClickListener(mo11022d(c46650a));
            c30584b.jPL.setOnLongClickListener(mo11021c(c46650a));
            c30584b.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33265);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33266);
            int i = ((C40814ay) view.getTag()).position;
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33266);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33267);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C9638aw.m17190ZK();
            C5137c Rl = C18628c.m29080XO().mo15258Rl(c40814ay.cKd.field_content);
            if (C42252ah.nullAsNil(Rl.ptI).length() > 0) {
                C25985d.m41467b(c46650a.yTx.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", c40814ay.cKd.field_msgId));
            } else if (C42252ah.nullAsNil(Rl.xZu).length() > 0) {
                C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(Rl.xZu)));
            }
            AppMethodBeat.m2505o(33267);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.af$b */
    static class C30584b extends C5379a {
        ImageView zdN;
        TextView zfC;
        TextView zgd;

        C30584b() {
        }
    }
}
