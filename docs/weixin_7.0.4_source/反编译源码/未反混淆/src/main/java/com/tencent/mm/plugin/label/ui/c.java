package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMTextView;

public final class c {
    MMTextView nJb;
    TextView nJc;
    LinearLayout nJd;

    public c(View view) {
        AppMethodBeat.i(22701);
        this.nJb = (MMTextView) view.findViewById(R.id.b42);
        this.nJc = (TextView) view.findViewById(R.id.b43);
        this.nJd = (LinearLayout) view.findViewById(R.id.b41);
        AppMethodBeat.o(22701);
    }
}
