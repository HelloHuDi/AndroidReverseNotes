package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBestSellingMore */
public class GameBestSellingMore extends LinearLayout implements OnClickListener {
    private C28226d neV;
    private TextView neW;
    private ImageView neX;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111732);
        super.onFinishInflate();
        this.neW = (TextView) findViewById(2131824299);
        this.neX = (ImageView) findViewById(2131824300);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111732);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111733);
        this.neV = c28226d;
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naG == null || C5046bo.isNullOrNil(c28226d.mVH.naG.naP)) {
            this.neW.setVisibility(8);
            this.neX.setVisibility(8);
            setPadding(0, 0, 0, 0);
            AppMethodBeat.m2505o(111733);
            return;
        }
        setPadding(getResources().getDimensionPixelSize(C25738R.dimen.f9908ju), 0, getResources().getDimensionPixelSize(C25738R.dimen.f9908ju), getResources().getDimensionPixelSize(C25738R.dimen.f9908ju));
        this.neW.setVisibility(0);
        this.neX.setVisibility(0);
        this.neW.setText(c28226d.mVH.naG.naP);
        AppMethodBeat.m2505o(111733);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111734);
        if (this.neV == null || this.neV.mVH == null || this.neV.mVH.naG == null || C5046bo.isNullOrNil(this.neV.mVH.naG.nbi)) {
            AppMethodBeat.m2505o(111734);
            return;
        }
        C34277b.m56211a(getContext(), 10, 1022, 999, C46001c.m85455ax(getContext(), this.neV.mVH.naG.nbi), null, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.neV.mVH.mZL));
        AppMethodBeat.m2505o(111734);
    }
}
