package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View kqx;
    private TextView kqy;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88736);
        if (this.kqx == null) {
            this.kqx = ((ViewStub) findViewById(R.id.abx)).inflate();
            this.kqy = (TextView) this.kqx.findViewById(R.id.a_p);
        }
        this.kqx.setVisibility(0);
        this.kqx.setOnClickListener(this.kqK.bcz());
        b bcv = this.kqK.bcv();
        if (TextUtils.isEmpty(bcv.aZV().vUo.wcT)) {
            this.kqy.setText(getString(R.string.afy));
            AppMethodBeat.o(88736);
            return;
        }
        this.kqy.setText(bcv.aZV().vUo.wcT);
        AppMethodBeat.o(88736);
    }

    public final void bes() {
        AppMethodBeat.i(88737);
        if (this.kqx != null) {
            this.kqx.setVisibility(8);
        }
        AppMethodBeat.o(88737);
    }
}
