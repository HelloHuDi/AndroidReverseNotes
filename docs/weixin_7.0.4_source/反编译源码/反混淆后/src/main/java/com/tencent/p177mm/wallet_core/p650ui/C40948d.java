package com.tencent.p177mm.wallet_core.p650ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.wallet_core.ui.d */
public class C40948d implements OnClickListener {
    private long iBO = 0;
    private OnClickListener pLd;

    public void onClick(View view) {
        AppMethodBeat.m2504i(49240);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.iBO >= 500) {
            this.pLd.onClick(view);
            this.iBO = currentTimeMillis;
        }
        AppMethodBeat.m2505o(49240);
    }
}
