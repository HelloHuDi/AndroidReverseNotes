package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a {
    View mView = null;
    TextView tWc = null;
    FrameLayout tWd = null;
    PatternLockView tWe = null;
    TextView tWf = null;

    public a(Activity activity) {
        AppMethodBeat.i(51648);
        this.mView = View.inflate(activity, R.layout.a80, null);
        this.tWc = (TextView) this.mView.findViewById(R.id.ciq);
        this.tWd = (FrameLayout) this.mView.findViewById(R.id.cis);
        this.tWe = (PatternLockView) this.mView.findViewById(R.id.cit);
        this.tWf = (TextView) this.mView.findViewById(R.id.cir);
        AppMethodBeat.o(51648);
    }
}
