package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameBestSellingMore extends LinearLayout implements OnClickListener {
    private d neV;
    private TextView neW;
    private ImageView neX;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111732);
        super.onFinishInflate();
        this.neW = (TextView) findViewById(R.id.c0h);
        this.neX = (ImageView) findViewById(R.id.c0i);
        setOnClickListener(this);
        AppMethodBeat.o(111732);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111733);
        this.neV = dVar;
        if (dVar == null || dVar.mVH == null || dVar.mVH.naG == null || bo.isNullOrNil(dVar.mVH.naG.naP)) {
            this.neW.setVisibility(8);
            this.neX.setVisibility(8);
            setPadding(0, 0, 0, 0);
            AppMethodBeat.o(111733);
            return;
        }
        setPadding(getResources().getDimensionPixelSize(R.dimen.ju), 0, getResources().getDimensionPixelSize(R.dimen.ju), getResources().getDimensionPixelSize(R.dimen.ju));
        this.neW.setVisibility(0);
        this.neX.setVisibility(0);
        this.neW.setText(dVar.mVH.naG.naP);
        AppMethodBeat.o(111733);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111734);
        if (this.neV == null || this.neV.mVH == null || this.neV.mVH.naG == null || bo.isNullOrNil(this.neV.mVH.naG.nbi)) {
            AppMethodBeat.o(111734);
            return;
        }
        b.a(getContext(), 10, 1022, 999, c.ax(getContext(), this.neV.mVH.naG.nbi), null, GameIndexListView.getSourceScene(), a.kY(this.neV.mVH.mZL));
        AppMethodBeat.o(111734);
    }
}
