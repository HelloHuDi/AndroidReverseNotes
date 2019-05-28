package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.widget.g;

@SuppressLint({"ViewConstructor"})
public final class e extends LinearLayout {
    private ImageView iqT = ((ImageView) findViewById(R.id.ok));
    private TextView iqU = ((TextView) findViewById(R.id.q_));
    private Button iqV = ((Button) findViewById(R.id.qa));

    public e(Context context, b bVar) {
        int i = 1;
        super(context);
        AppMethodBeat.i(102213);
        inflate(getContext(), R.layout.c3, this);
        this.iqU.setText(getResources().getString(R.string.cu3, new Object[]{bVar.xZ().cwz}));
        LayoutParams layoutParams = (LayoutParams) this.iqT.getLayoutParams();
        if (bVar.getAppConfig() == null || bVar.getAppConfig().heS == null || !bVar.getAppConfig().heS.ayx()) {
            i = 0;
        }
        if (i != 0) {
            layoutParams.topMargin = a.am(getContext(), R.dimen.r4);
            this.iqT.setLayoutParams(layoutParams);
            requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.iqT.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        com.tencent.mm.modelappbrand.a.b.abR().a(this.iqT, bVar.xZ().hgW, ((g) bVar.K(g.class)).aOG(), f.fqH);
        this.iqV.setVisibility(8);
        setBackgroundColor(-1);
        AppMethodBeat.o(102213);
    }
}
