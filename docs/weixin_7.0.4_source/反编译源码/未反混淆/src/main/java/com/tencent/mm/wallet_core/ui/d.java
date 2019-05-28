package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d implements OnClickListener {
    private long iBO = 0;
    private OnClickListener pLd;

    public void onClick(View view) {
        AppMethodBeat.i(49240);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.iBO >= 500) {
            this.pLd.onClick(view);
            this.iBO = currentTimeMillis;
        }
        AppMethodBeat.o(49240);
    }
}
