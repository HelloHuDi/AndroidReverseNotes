package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;

public final class f {
    View jcl;
    private MMActivity jiE;
    b kha;
    ImageView khe;
    TextView khf;
    TextView khg;

    public f(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    public final void cu() {
        AppMethodBeat.i(88157);
        this.khf.setVisibility(0);
        this.khe.setImageDrawable(this.jiE.getResources().getDrawable(R.drawable.az5));
        this.khf.setText(R.string.agy);
        this.khg.setText(R.string.agx);
        LayoutParams layoutParams = (LayoutParams) this.khe.getLayoutParams();
        layoutParams.topMargin = this.jiE.getResources().getDimensionPixelOffset(R.dimen.wa);
        this.khe.setLayoutParams(layoutParams);
        this.khe.invalidate();
        AppMethodBeat.o(88157);
    }
}
