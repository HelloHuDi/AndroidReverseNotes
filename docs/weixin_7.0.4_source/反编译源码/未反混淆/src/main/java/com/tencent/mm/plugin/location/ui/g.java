package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;

public final class g extends FrameLayout {
    private Context mContext;
    public boolean nLR = false;
    private ImageView nMi;
    public d nMj;

    public g(Context context, d dVar) {
        super(context);
        AppMethodBeat.i(113471);
        this.nMj = dVar;
        this.mContext = context;
        this.nMi = (ImageView) View.inflate(this.mContext, R.layout.akm, this).findViewById(R.id.dnn);
        AppMethodBeat.o(113471);
    }

    public final void remove() {
        AppMethodBeat.i(113472);
        if (this.nLR) {
            this.nMj.removeView(this);
        }
        this.nLR = false;
        AppMethodBeat.o(113472);
    }
}
