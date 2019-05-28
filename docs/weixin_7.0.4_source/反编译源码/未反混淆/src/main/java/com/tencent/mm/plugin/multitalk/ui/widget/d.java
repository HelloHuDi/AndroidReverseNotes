package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private View mKk;
    private int oIA = (b.oIb * 4);
    public int oIB;
    private int oIb = b.oIb;
    private int oIh = b.oIh;
    private LinearLayout oIt;
    public LinearLayout oIu;
    public LinearLayout oIv;
    private int oIw;
    private int oIx;
    private int oIy = (b.oIb + b.oIa);
    private int oIz = ((b.oIb * 2) + b.oIa);
    public int size = 0;

    public d(Activity activity) {
        AppMethodBeat.i(54192);
        this.context = activity.getBaseContext();
        int gd = a.gd(this.context) - (this.oIA * 2);
        this.oIw = (gd - (this.oIy * 10)) / 5;
        this.oIx = (gd - (this.oIz * 10)) / 5;
        gd = (this.oIx * 2) + (this.oIb * 12);
        this.mKk = activity.findViewById(R.id.it);
        this.mKk.getLayoutParams().height = gd;
        this.oIt = (LinearLayout) activity.findViewById(R.id.df6);
        LayoutParams layoutParams = (LayoutParams) this.oIt.getLayoutParams();
        layoutParams.topMargin = this.oIb * 2;
        layoutParams.bottomMargin = this.oIb * 2;
        layoutParams.leftMargin = this.oIA;
        layoutParams.rightMargin = this.oIA;
        this.oIt.setLayoutParams(layoutParams);
        this.oIu = new LinearLayout(this.context);
        this.oIv = new LinearLayout(this.context);
        this.oIu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.oIv.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.oIv);
        relativeLayout.setLayoutParams(layoutParams2);
        this.oIt.addView(this.oIu);
        this.oIt.addView(relativeLayout);
        AppMethodBeat.o(54192);
    }

    public final void setVisible(boolean z) {
        AppMethodBeat.i(54193);
        if (z) {
            this.mKk.setVisibility(0);
            AppMethodBeat.o(54193);
            return;
        }
        this.mKk.setVisibility(8);
        AppMethodBeat.o(54193);
    }

    public final void Sp(String str) {
        AppMethodBeat.i(54194);
        this.size++;
        ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.b(imageView, str);
        if (this.size <= 5) {
            this.oIu.addView(imageView);
        } else {
            this.oIv.addView(imageView);
        }
        zj(this.size);
        zk(this.size);
        AppMethodBeat.o(54194);
    }

    public final void zj(int i) {
        AppMethodBeat.i(54195);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oIu.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.oIv.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.oIw;
            this.oIv.setVisibility(8);
            AppMethodBeat.o(54195);
            return;
        }
        layoutParams.height = this.oIx;
        layoutParams.topMargin = this.oIb * 2;
        layoutParams.bottomMargin = this.oIb * 2;
        this.oIv.setVisibility(0);
        layoutParams2.height = this.oIx;
        layoutParams2.topMargin = this.oIb * 2;
        layoutParams2.bottomMargin = this.oIb * 2;
        AppMethodBeat.o(54195);
    }

    public final void zk(int i) {
        int i2 = 0;
        AppMethodBeat.i(54196);
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.oIu.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.oIu.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.oIw;
                layoutParams.height = this.oIw;
                layoutParams.rightMargin = this.oIy;
                layoutParams.leftMargin = this.oIy;
            }
            while (i2 < this.oIv.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.oIv.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.oIx;
                layoutParams.height = this.oIx;
                layoutParams.rightMargin = this.oIy;
                layoutParams.leftMargin = this.oIy;
                i2++;
            }
            AppMethodBeat.o(54196);
            return;
        }
        for (i3 = 0; i3 < this.oIu.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.oIu.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.oIx;
            layoutParams.height = this.oIx;
            layoutParams.rightMargin = this.oIz;
            layoutParams.leftMargin = this.oIz;
        }
        while (i2 < this.oIv.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.oIv.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.oIx;
            layoutParams.height = this.oIx;
            layoutParams.rightMargin = this.oIz;
            layoutParams.leftMargin = this.oIz;
            i2++;
        }
        AppMethodBeat.o(54196);
    }

    public final void onClick(View view) {
        this.oIB++;
    }
}
