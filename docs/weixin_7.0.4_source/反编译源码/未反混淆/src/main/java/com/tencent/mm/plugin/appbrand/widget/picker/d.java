package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.j;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class d extends RelativeLayout {
    private static final int jkW = Color.parseColor("#F9F9F9");
    private final int jkP;
    private final int jkQ;
    private com.tencent.mm.plugin.appbrand.jsapi.m.b jkR;
    private FrameLayout jkS;
    private a jkT;
    private boolean jkU;
    b jkV;

    public interface a<T> {
        void b(boolean z, T t);
    }

    public interface b<T> {
        void bw(T t);
    }

    static /* synthetic */ void a(d dVar, boolean z, Object obj) {
        AppMethodBeat.i(126739);
        dVar.c(z, obj);
        AppMethodBeat.o(126739);
    }

    public void setOnResultListener(a aVar) {
        this.jkT = aVar;
    }

    public void setOnValueUpdateListener(b bVar) {
        this.jkV = bVar;
    }

    private void aRL() {
        this.jkT = null;
        this.jkV = null;
    }

    private void c(boolean z, Object obj) {
        AppMethodBeat.i(126729);
        if (!(this.jkU || this.jkT == null)) {
            this.jkU = true;
            this.jkT.b(z, obj);
            this.jkU = false;
        }
        AppMethodBeat.o(126729);
    }

    static {
        AppMethodBeat.i(126740);
        AppMethodBeat.o(126740);
    }

    public d(Context context) {
        super(context);
        AppMethodBeat.i(126730);
        this.jkP = com.tencent.mm.bz.a.fromDPToPix(context, 48);
        this.jkQ = com.tencent.mm.bz.a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new LayoutParams(-1, this.jkQ);
        layoutParams.addRule(12);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(R.id.a4);
        frameLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(jkW);
        this.jkS = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new LayoutParams(-1, this.jkP);
        layoutParams.addRule(2, R.id.a4);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        View dv = dv(R.string.cud, R.color.r8);
        dv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126727);
                d.a(d.this, true, d.this.jkR == null ? null : d.this.jkR.aEG());
                AppMethodBeat.o(126727);
            }
        });
        LayoutParams layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(dv, layoutParams2);
        dv = dv(R.string.cuc, R.color.im);
        dv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126728);
                d.a(d.this, false, null);
                AppMethodBeat.o(126728);
            }
        });
        layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        relativeLayout.addView(dv, layoutParams2);
        relativeLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        relativeLayout.setBackgroundColor(jkW);
        addView(relativeLayout, layoutParams);
        AppMethodBeat.o(126730);
    }

    /* Access modifiers changed, original: protected */
    public void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.m.b bVar) {
        AppMethodBeat.i(126731);
        if (this.jkR != null) {
            this.jkR.aEI();
        }
        this.jkR = bVar;
        if (this.jkR != null) {
            this.jkR.b(this);
        }
        if (this.jkS == null || this.jkR == null || this.jkR.getView() == null) {
            AppMethodBeat.o(126731);
            return;
        }
        this.jkS.removeAllViews();
        aRL();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.jkS.addView(this.jkR.getView(), layoutParams);
        AppMethodBeat.o(126731);
    }

    public com.tencent.mm.plugin.appbrand.jsapi.m.b getPicker() {
        return this.jkR;
    }

    public void show() {
        AppMethodBeat.i(126732);
        if (this.jkR == null) {
            setVisibility(8);
            AppMethodBeat.o(126732);
            return;
        }
        setVisibility(0);
        if (this.jkR != null) {
            this.jkR.a(this);
        }
        AppMethodBeat.o(126732);
    }

    public void hide() {
        AppMethodBeat.i(126733);
        super.setVisibility(8);
        c(false, null);
        if (this.jkR != null) {
            this.jkR.aEH();
        }
        AppMethodBeat.o(126733);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(126734);
        if (i != 0) {
            hide();
            AppMethodBeat.o(126734);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.o(126734);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getPanelContentHeight() {
        return this.jkP + this.jkQ;
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    public final void du(int i, int i2) {
        AppMethodBeat.i(126735);
        super.onMeasure(i, i2);
        AppMethodBeat.o(126735);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(126736);
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.jkP + this.jkQ, ErrorDialogData.SUPPRESSED));
            AppMethodBeat.o(126736);
            return;
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, j.INVALID_ID));
        AppMethodBeat.o(126736);
    }

    private View dv(int i, int i2) {
        AppMethodBeat.i(126737);
        TextView textView = new TextView(new ContextThemeWrapper(getContext(), R.style.dg));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        AppMethodBeat.o(126737);
        return textView;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(126738);
        super.onDetachedFromWindow();
        aRL();
        removeAllViews();
        AppMethodBeat.o(126738);
    }
}
