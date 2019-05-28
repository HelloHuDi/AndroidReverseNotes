package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.d.f;

public final class x implements OnClickListener {
    a yod;

    public x(a aVar) {
        this.yod = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(29683);
        if (view.getTag() instanceof f) {
            r.eK(view);
            this.yod.aWv();
        }
        AppMethodBeat.o(29683);
    }
}
