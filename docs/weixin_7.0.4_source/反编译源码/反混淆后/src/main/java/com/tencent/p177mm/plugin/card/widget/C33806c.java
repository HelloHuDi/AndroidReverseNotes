package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C23446tm;

/* renamed from: com.tencent.mm.plugin.card.widget.c */
public final class C33806c extends C2788a {
    protected TextView ksp;
    protected TextView ksq;

    public C33806c(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.m2504i(88974);
        this.ksq = (TextView) beI().findViewById(2131822336);
        this.ksp = (TextView) beI().findViewById(2131822335);
        AppMethodBeat.m2505o(88974);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.m2504i(88975);
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            C23446tm c23446tm = (C23446tm) this.kaS.aZV().vTW.get(0);
            if (this.iPD != null) {
                this.iPD.setText(c23446tm.title);
            }
            if (this.ksp != null) {
                if (TextUtils.isEmpty(c23446tm.kbW)) {
                    this.ksp.setVisibility(8);
                } else {
                    this.ksp.setText(c23446tm.kbW);
                }
            }
            if (this.ksq != null) {
                if (TextUtils.isEmpty(c23446tm.kbX)) {
                    this.ksq.setVisibility(8);
                } else {
                    this.ksq.setText(c23446tm.kbX);
                    AppMethodBeat.m2505o(88975);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(88975);
    }

    /* renamed from: x */
    public final void mo6897x(boolean z, boolean z2) {
    }
}
