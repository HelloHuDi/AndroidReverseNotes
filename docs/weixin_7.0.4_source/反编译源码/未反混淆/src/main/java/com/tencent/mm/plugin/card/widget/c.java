package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.tm;

public final class c extends a {
    protected TextView ksp;
    protected TextView ksq;

    public c(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.i(88974);
        this.ksq = (TextView) beI().findViewById(R.id.ake);
        this.ksp = (TextView) beI().findViewById(R.id.akd);
        AppMethodBeat.o(88974);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.i(88975);
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            tm tmVar = (tm) this.kaS.aZV().vTW.get(0);
            if (this.iPD != null) {
                this.iPD.setText(tmVar.title);
            }
            if (this.ksp != null) {
                if (TextUtils.isEmpty(tmVar.kbW)) {
                    this.ksp.setVisibility(8);
                } else {
                    this.ksp.setText(tmVar.kbW);
                }
            }
            if (this.ksq != null) {
                if (TextUtils.isEmpty(tmVar.kbX)) {
                    this.ksq.setVisibility(8);
                } else {
                    this.ksq.setText(tmVar.kbX);
                    AppMethodBeat.o(88975);
                    return;
                }
            }
        }
        AppMethodBeat.o(88975);
    }

    public final void x(boolean z, boolean z2) {
    }
}
