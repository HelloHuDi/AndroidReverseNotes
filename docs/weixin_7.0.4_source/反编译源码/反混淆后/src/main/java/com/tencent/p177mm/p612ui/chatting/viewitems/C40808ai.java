package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ai */
public final class C40808ai extends C5378c {
    private C46666aj zgA = new C46666aj();
    private C15723ag zgB = new C15723ag();
    private C40809ak zgC = new C40809ak();
    private C44339at zgD = new C44339at();

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ai$b */
    final class C23819b extends C5379a {
        View mRR;
        NeatTextView zgE;

        C23819b() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ai$a */
    interface C30585a {
        /* renamed from: b */
        void mo27952b(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi);
    }

    public C40808ai() {
        AppMethodBeat.m2504i(33279);
        AppMethodBeat.m2505o(33279);
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == Downloads.MIN_WAIT_FOR_NETWORK || i == 10002 || i == 570425393 || i == 64 || i == 603979825) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33280);
        if (view == null || view.getTag() == null) {
            view = layoutInflater.inflate(2130969083, null);
            C23819b c23819b = new C23819b();
            c23819b.mRR = view;
            c23819b.enf = (TextView) view.findViewById(2131820587);
            c23819b.zgE = (MMNeat7extView) view.findViewById(2131821103);
            c23819b.zgE.setOnTouchListener(new C23306f(c23819b.zgE, new C30132m(c23819b.zgE.getContext())));
            view.setTag(c23819b);
        }
        AppMethodBeat.m2505o(33280);
        return view;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
        C30585a c30585a;
        AppMethodBeat.m2504i(33281);
        if (c7620bi.getType() == 10002) {
            c30585a = this.zgB;
        } else if (c7620bi.getType() == 570425393) {
            c30585a = this.zgC;
        } else if (c7620bi.getType() == 603979825) {
            c30585a = this.zgD;
        } else {
            c30585a = this.zgA;
        }
        c30585a.mo27952b(c5379a, i, c46650a, c7620bi);
        AppMethodBeat.m2505o(33281);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
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
