package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.h */
public final class C13679h extends LinearLayout {
    private Context context;
    private int jJF = 0;
    private int rhk = 6;
    private LinearLayout rhl;

    public final void setLineMaxCounte(int i) {
        if (i > 0) {
            this.rhk = i;
        }
    }

    public C13679h(Context context) {
        super(context);
        AppMethodBeat.m2504i(38162);
        this.context = context;
        setOrientation(1);
        AppMethodBeat.m2505o(38162);
    }

    public final void addView(View view) {
        AppMethodBeat.m2504i(38163);
        if (this.jJF % this.rhk == 0) {
            this.rhl = new LinearLayout(this.context);
            this.rhl.setOrientation(0);
            this.rhl.addView(view);
            super.addView(this.rhl);
        } else {
            this.rhl.addView(view);
        }
        this.jJF++;
        AppMethodBeat.m2505o(38163);
    }
}
