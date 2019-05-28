package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.f;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class ai extends c {
    private aj zgA = new aj();
    private ag zgB = new ag();
    private ak zgC = new ak();
    private at zgD = new at();

    final class b extends com.tencent.mm.ui.chatting.viewitems.c.a {
        View mRR;
        NeatTextView zgE;

        b() {
        }
    }

    interface a {
        void b(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar);
    }

    public ai() {
        AppMethodBeat.i(33279);
        AppMethodBeat.o(33279);
    }

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == Downloads.MIN_WAIT_FOR_NETWORK || i == 10002 || i == 570425393 || i == 64 || i == 603979825) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33280);
        if (view == null || view.getTag() == null) {
            view = layoutInflater.inflate(R.layout.mz, null);
            b bVar = new b();
            bVar.mRR = view;
            bVar.enf = (TextView) view.findViewById(R.id.ag);
            bVar.zgE = (MMNeat7extView) view.findViewById(R.id.oe);
            bVar.zgE.setOnTouchListener(new f(bVar.zgE, new m(bVar.zgE.getContext())));
            view.setTag(bVar);
        }
        AppMethodBeat.o(33280);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        a aVar3;
        AppMethodBeat.i(33281);
        if (biVar.getType() == 10002) {
            aVar3 = this.zgB;
        } else if (biVar.getType() == 570425393) {
            aVar3 = this.zgC;
        } else if (biVar.getType() == 603979825) {
            aVar3 = this.zgD;
        } else {
            aVar3 = this.zgA;
        }
        aVar3.b(aVar, i, aVar2, biVar);
        AppMethodBeat.o(33281);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dHj() {
        return false;
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
