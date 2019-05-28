package com.tencent.p177mm.plugin.walletlock.gesture.p751ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.widget.PatternLockView;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.a */
final class C22725a {
    View mView = null;
    TextView tWc = null;
    FrameLayout tWd = null;
    PatternLockView tWe = null;
    TextView tWf = null;

    public C22725a(Activity activity) {
        AppMethodBeat.m2504i(51648);
        this.mView = View.inflate(activity, 2130969864, null);
        this.tWc = (TextView) this.mView.findViewById(2131825011);
        this.tWd = (FrameLayout) this.mView.findViewById(2131825013);
        this.tWe = (PatternLockView) this.mView.findViewById(2131825014);
        this.tWf = (TextView) this.mView.findViewById(2131825012);
        AppMethodBeat.m2505o(51648);
    }
}
