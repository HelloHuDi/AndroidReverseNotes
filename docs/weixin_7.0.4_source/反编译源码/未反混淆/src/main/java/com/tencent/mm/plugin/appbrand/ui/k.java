package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.performance.d;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.ui.statusbar.c;

@SuppressLint({"ViewConstructor"})
public final class k extends LinearLayout implements com.tencent.mm.ui.statusbar.c.a {
    private final a[] iJm = new a[4];
    private final SparseArray<b> iJn = new SparseArray();
    private final SparseArray<b> iJo = new SparseArray();
    private int iJp;
    public final com.tencent.luggage.sdk.b.b ivC;

    @SuppressLint({"AppCompatCustomView"})
    class a extends TextView {
        public a(Context context) {
            super(context);
            AppMethodBeat.i(102336);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 5);
            layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(-7171438);
            AppMethodBeat.o(102336);
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    class b extends TextView {
        private String mTitle;
        private String mValue;

        public b(Context context) {
            super(context);
            AppMethodBeat.i(102337);
            setLayoutParams(new LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(-419430401);
            AppMethodBeat.o(102337);
        }

        private void update() {
            AppMethodBeat.i(102338);
            setText(String.format("%s: %s", new Object[]{this.mTitle, this.mValue}));
            AppMethodBeat.o(102338);
        }

        static /* synthetic */ void a(b bVar, String str) {
            AppMethodBeat.i(102339);
            bVar.mValue = str;
            bVar.update();
            AppMethodBeat.o(102339);
        }

        static /* synthetic */ void b(b bVar, String str) {
            AppMethodBeat.i(102340);
            bVar.mTitle = str;
            bVar.update();
            AppMethodBeat.o(102340);
        }
    }

    public k(Context context, com.tencent.luggage.sdk.b.b bVar) {
        super(context);
        AppMethodBeat.i(102341);
        this.ivC = bVar;
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(getContext(), 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        aMu();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LayoutParams layoutParams2 = new LayoutParams(-1, -2);
        LayoutParams layoutParams3 = new LayoutParams(-1, 2);
        TextView textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(R.string.lz));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.bz.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        aMv();
        c.az((Activity) getContext()).a(this);
        AppMethodBeat.o(102341);
    }

    private void aMu() {
        AppMethodBeat.i(102342);
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.a.de(getContext()) + this.iJp;
            requestLayout();
        }
        AppMethodBeat.o(102342);
    }

    private void aMv() {
        AppMethodBeat.i(102343);
        for (int i = 0; i < 4; i++) {
            a aVar = new a(getContext());
            aVar.setText(getContext().getString(d.ivQ[i]));
            this.iJm[i] = aVar;
            addView(aVar);
        }
        AppMethodBeat.o(102343);
    }

    public final void ae(final int i, final String str) {
        AppMethodBeat.i(102344);
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102334);
                k.a(k.this, i, str);
                AppMethodBeat.o(102334);
            }
        });
        AppMethodBeat.o(102344);
    }

    public final void cP(final String str, final String str2) {
        AppMethodBeat.i(102345);
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102335);
                k.a(k.this, str, str2);
                AppMethodBeat.o(102335);
            }
        });
        AppMethodBeat.o(102345);
    }

    public final void pO(int i) {
        AppMethodBeat.i(102346);
        this.iJp = i;
        aMu();
        AppMethodBeat.o(102346);
    }
}
