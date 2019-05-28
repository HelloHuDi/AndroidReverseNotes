package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.base.C42837b;

/* renamed from: com.tencent.mm.plugin.card.ui.view.c */
public final class C38777c extends C45800i {
    private View kqx;
    private TextView kqy;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88736);
        if (this.kqx == null) {
            this.kqx = ((ViewStub) findViewById(2131822022)).inflate();
            this.kqy = (TextView) this.kqx.findViewById(2131821940);
        }
        this.kqx.setVisibility(0);
        this.kqx.setOnClickListener(this.kqK.bcz());
        C42837b bcv = this.kqK.bcv();
        if (TextUtils.isEmpty(bcv.aZV().vUo.wcT)) {
            this.kqy.setText(getString(C25738R.string.afy));
            AppMethodBeat.m2505o(88736);
            return;
        }
        this.kqy.setText(bcv.aZV().vUo.wcT);
        AppMethodBeat.m2505o(88736);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88737);
        if (this.kqx != null) {
            this.kqx.setVisibility(8);
        }
        AppMethodBeat.m2505o(88737);
    }
}
