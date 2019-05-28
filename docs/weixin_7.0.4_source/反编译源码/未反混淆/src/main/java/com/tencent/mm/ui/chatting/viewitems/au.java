package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.c.a;

final class au extends a {
    protected TextView gnC;
    protected TextView zic;
    protected TextView zid;
    protected Button zie;
    protected Button zif;
    protected ImageView zig;

    au() {
    }

    public final au fj(View view) {
        AppMethodBeat.i(33441);
        super.eP(view);
        this.gnC = (TextView) view.findViewById(R.id.apr);
        this.zic = (TextView) view.findViewById(R.id.atq);
        this.zid = (TextView) view.findViewById(R.id.atr);
        this.zie = (Button) view.findViewById(R.id.ats);
        this.zif = (Button) view.findViewById(R.id.att);
        this.zig = (ImageView) view.findViewById(R.id.atu);
        this.moo = (CheckBox) view.findViewById(R.id.a_);
        this.iVh = view.findViewById(R.id.af);
        AppMethodBeat.o(33441);
        return this;
    }
}
