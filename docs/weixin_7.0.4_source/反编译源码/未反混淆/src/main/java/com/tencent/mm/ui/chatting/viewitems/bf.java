package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c.a;

final class bf extends a {
    TextView gnC;

    bf() {
    }

    public final a fl(View view) {
        AppMethodBeat.i(33455);
        super.eP(view);
        this.enf = (TextView) view.findViewById(R.id.ag);
        this.qkY = (TextView) view.findViewById(R.id.od);
        this.gnC = (TextView) view.findViewById(R.id.oe);
        this.moo = (CheckBox) view.findViewById(R.id.a_);
        this.iVh = view.findViewById(R.id.af);
        AppMethodBeat.o(33455);
        return this;
    }
}
