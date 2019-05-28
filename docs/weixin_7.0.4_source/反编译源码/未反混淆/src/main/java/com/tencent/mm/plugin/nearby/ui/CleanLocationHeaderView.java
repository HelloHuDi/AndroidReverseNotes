package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private ImageView iyo;
    private TextView oPI;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55408);
        cA(context);
        AppMethodBeat.o(55408);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(55409);
        cA(context);
        AppMethodBeat.o(55409);
    }

    private void cA(Context context) {
        AppMethodBeat.i(55410);
        View inflate = View.inflate(context, R.layout.aie, this);
        this.oPI = (TextView) inflate.findViewById(R.id.dgg);
        this.oPI.setSingleLine(false);
        this.iyo = (ImageView) inflate.findViewById(R.id.dgf);
        this.oPI.setText(R.string.aq6);
        this.iyo.setImageResource(R.raw.peoplenearby_icon);
        AppMethodBeat.o(55410);
    }
}
