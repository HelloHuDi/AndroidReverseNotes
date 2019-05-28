package com.tencent.p177mm.plugin.card.p355ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.protocal.protobuf.C23446tm;

/* renamed from: com.tencent.mm.plugin.card.ui.view.z */
public final class C38779z extends C45800i {
    private View kru;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88792);
        if (this.kru == null) {
            this.kru = ((ViewStub) findViewById(2131822035)).inflate();
        }
        C23446tm c23446tm = this.kqK.bcv().aZW().vSg;
        if (this.kru != null) {
            int i;
            ((TextView) this.kru.findViewById(2131822322)).setText(c23446tm.title);
            ((TextView) this.kru.findViewById(2131822323)).setText(c23446tm.kbW);
            if (this.kqK.bcA().bdy() && this.kqK.bcA().bdz()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.kru).getLayoutParams()).bottomMargin = 0;
                AppMethodBeat.m2505o(88792);
                return;
            }
            ((LayoutParams) ((LinearLayout) this.kru).getLayoutParams()).bottomMargin = this.kqK.bcy().getResources().getDimensionPixelSize(C25738R.dimen.f10001n3);
        }
        AppMethodBeat.m2505o(88792);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88793);
        if (this.kru != null) {
            this.kru.setVisibility(8);
        }
        AppMethodBeat.m2505o(88793);
    }
}
