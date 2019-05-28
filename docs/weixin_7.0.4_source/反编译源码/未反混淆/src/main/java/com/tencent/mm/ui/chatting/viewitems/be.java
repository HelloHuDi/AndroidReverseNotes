package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c.a;

final class be extends a {
    protected TextView gnC;
    protected ImageView zjv;

    be() {
    }

    public final be fk(View view) {
        AppMethodBeat.i(33454);
        super.eP(view);
        this.gnC = (TextView) view.findViewById(R.id.apr);
        this.zjv = (ImageView) view.findViewById(R.id.apt);
        this.moo = (CheckBox) view.findViewById(R.id.a_);
        this.iVh = view.findViewById(R.id.af);
        AppMethodBeat.o(33454);
        return this;
    }
}
