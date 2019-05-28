package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.f */
public final class C27598f {
    View jcl;
    private MMActivity jiE;
    C42856b kha;
    ImageView khe;
    TextView khf;
    TextView khg;

    public C27598f(MMActivity mMActivity, View view) {
        this.jiE = mMActivity;
        this.jcl = view;
    }

    /* renamed from: cu */
    public final void mo45442cu() {
        AppMethodBeat.m2504i(88157);
        this.khf.setVisibility(0);
        this.khe.setImageDrawable(this.jiE.getResources().getDrawable(C25738R.drawable.az5));
        this.khf.setText(C25738R.string.agy);
        this.khg.setText(C25738R.string.agx);
        LayoutParams layoutParams = (LayoutParams) this.khe.getLayoutParams();
        layoutParams.topMargin = this.jiE.getResources().getDimensionPixelOffset(C25738R.dimen.f10267wa);
        this.khe.setLayoutParams(layoutParams);
        this.khe.invalidate();
        AppMethodBeat.m2505o(88157);
    }
}
