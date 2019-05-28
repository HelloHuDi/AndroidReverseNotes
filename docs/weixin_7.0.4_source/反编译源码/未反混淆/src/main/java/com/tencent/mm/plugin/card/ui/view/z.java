package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.tm;

public final class z extends i {
    private View kru;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88792);
        if (this.kru == null) {
            this.kru = ((ViewStub) findViewById(R.id.ac_)).inflate();
        }
        tm tmVar = this.kqK.bcv().aZW().vSg;
        if (this.kru != null) {
            int i;
            ((TextView) this.kru.findViewById(R.id.ak1)).setText(tmVar.title);
            ((TextView) this.kru.findViewById(R.id.ak2)).setText(tmVar.kbW);
            if (this.kqK.bcA().bdy() && this.kqK.bcA().bdz()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.kru).getLayoutParams()).bottomMargin = 0;
                AppMethodBeat.o(88792);
                return;
            }
            ((LayoutParams) ((LinearLayout) this.kru).getLayoutParams()).bottomMargin = this.kqK.bcy().getResources().getDimensionPixelSize(R.dimen.n3);
        }
        AppMethodBeat.o(88792);
    }

    public final void bes() {
        AppMethodBeat.i(88793);
        if (this.kru != null) {
            this.kru.setVisibility(8);
        }
        AppMethodBeat.o(88793);
    }
}
