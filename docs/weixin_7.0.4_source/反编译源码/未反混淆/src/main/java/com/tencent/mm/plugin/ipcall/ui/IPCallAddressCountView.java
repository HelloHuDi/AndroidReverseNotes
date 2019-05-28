package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View gbS;
    private TextView nBf;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22044);
        init();
        AppMethodBeat.o(22044);
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        AppMethodBeat.i(22045);
        init();
        AppMethodBeat.o(22045);
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        AppMethodBeat.i(22046);
        setAddressCount(i);
        AppMethodBeat.o(22046);
    }

    private void init() {
        AppMethodBeat.i(22047);
        inflate(getContext(), R.layout.a8f, this);
        this.gbS = findViewById(R.id.b1e);
        this.nBf = (TextView) findViewById(R.id.b1f);
        AppMethodBeat.o(22047);
    }

    public void setAddressCount(int i) {
        AppMethodBeat.i(22048);
        this.nBf.setText(getContext().getResources().getQuantityString(R.plurals.b, i, new Object[]{Integer.valueOf(i)}));
        AppMethodBeat.o(22048);
    }
}
