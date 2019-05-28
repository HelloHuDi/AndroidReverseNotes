package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    private TextView gnj;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        AppMethodBeat.i(40720);
        init(context);
        AppMethodBeat.o(40720);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40721);
        init(context);
        AppMethodBeat.o(40721);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40722);
        init(context);
        AppMethodBeat.o(40722);
    }

    private void init(Context context) {
        AppMethodBeat.i(40723);
        this.gnj = (TextView) v.hu(context).inflate(R.layout.e, this, true).findViewById(R.id.is);
        AppMethodBeat.o(40723);
    }

    public TextView getBottomLinkTv() {
        return this.gnj;
    }
}
