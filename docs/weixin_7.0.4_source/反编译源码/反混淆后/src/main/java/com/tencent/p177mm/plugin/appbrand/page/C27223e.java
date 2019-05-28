package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.widget.C10979g;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.e */
public final class C27223e extends LinearLayout {
    private ImageView iqT = ((ImageView) findViewById(2131821109));
    private TextView iqU = ((TextView) findViewById(2131821172));
    private Button iqV = ((Button) findViewById(2131821173));

    public C27223e(Context context, C25697b c25697b) {
        int i = 1;
        super(context);
        AppMethodBeat.m2504i(102213);
        C27223e.inflate(getContext(), 2130968679, this);
        this.iqU.setText(getResources().getString(C25738R.string.cu3, new Object[]{c25697b.mo43489xZ().cwz}));
        LayoutParams layoutParams = (LayoutParams) this.iqT.getLayoutParams();
        if (c25697b.getAppConfig() == null || c25697b.getAppConfig().heS == null || !c25697b.getAppConfig().heS.ayx()) {
            i = 0;
        }
        if (i != 0) {
            layoutParams.topMargin = C1338a.m2857am(getContext(), C25738R.dimen.f10134r4);
            this.iqT.setLayoutParams(layoutParams);
            requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.iqT.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        C37926b.abR().mo60683a(this.iqT, c25697b.mo43489xZ().hgW, ((C10979g) c25697b.mo14978K(C10979g.class)).aOG(), C42201f.fqH);
        this.iqV.setVisibility(8);
        setBackgroundColor(-1);
        AppMethodBeat.m2505o(102213);
    }
}
