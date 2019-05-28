package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ac */
public final class C36207ac extends C5378c {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ac$a */
    final class C36208a extends C5379a {
        protected ImageView gvq;
        protected TextView zfU;

        C36208a() {
        }

        /* renamed from: fh */
        public final C36208a mo57090fh(View view) {
            AppMethodBeat.m2504i(33224);
            super.mo11031eP(view);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.gvq = (ImageView) view.findViewById(2131822649);
            this.zfU = (TextView) view.findViewById(2131822641);
            AppMethodBeat.m2505o(33224);
            return this;
        }
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048176) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33225);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969078);
            view.setTag(new C36208a().mo57090fh(view));
        }
        AppMethodBeat.m2505o(33225);
        return view;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        C8910b c8910b;
        AppMethodBeat.m2504i(33226);
        C36208a c36208a = (C36208a) c5379a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str2 = c7620bi.field_content;
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
            objArr[2] = Long.valueOf(c7620bi.field_msgId);
            objArr[3] = str;
            C4990ab.m7413e(str3, str4, objArr);
            c8910b = null;
        } else {
            c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
        }
        C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
        if (c8910b != null && (c8910b.showType == 3 || c8910b.fhn == 3)) {
            c36208a.gvq.setImageResource(C25738R.drawable.agt);
            c36208a.zfU.setText(c8910b.fhs);
        }
        c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
        c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
        c5379a.jPL.setTag(c40814ay);
        AppMethodBeat.m2505o(33226);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33227);
        contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, view.getContext().getString(C25738R.string.am7));
        AppMethodBeat.m2505o(33227);
        return false;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33228);
        menuItem.getItemId();
        AppMethodBeat.m2505o(33228);
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        return false;
    }
}
