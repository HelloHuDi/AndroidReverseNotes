package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.ui.view.y */
public final class C27633y extends C45800i {
    private MMActivity jiE;
    private C42837b kaS;
    private View krt;

    public final void initView() {
        AppMethodBeat.m2504i(88789);
        this.jiE = this.kqK.bcy();
        AppMethodBeat.m2505o(88789);
    }

    public final void update() {
        AppMethodBeat.m2504i(88790);
        this.kaS = this.kqK.bcv();
        if (this.krt == null) {
            this.krt = ((ViewStub) findViewById(2131822024)).inflate();
        }
        if (this.kaS.aZF()) {
            this.krt.setBackgroundDrawable(C38736l.m65700H(this.jiE, this.jiE.getResources().getColor(C25738R.color.f11836it)));
        }
        TextView textView = (TextView) this.krt.findViewById(2131822320);
        if (this.kaS.aZW() == null) {
            C4990ab.m7412e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            AppMethodBeat.m2505o(88790);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.jiE.getResources().getColor(C25738R.color.f12073rb));
        if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
            C45778m.m84646c(textView, this.kaS.aZW().status);
            AppMethodBeat.m2505o(88790);
            return;
        }
        textView.setText(this.kaS.aZV().vUu);
        AppMethodBeat.m2505o(88790);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88791);
        if (this.krt != null) {
            this.krt.setVisibility(8);
        }
        AppMethodBeat.m2505o(88791);
    }
}
