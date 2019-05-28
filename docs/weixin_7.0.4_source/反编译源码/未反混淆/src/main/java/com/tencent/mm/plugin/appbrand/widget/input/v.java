package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.v4.view.s;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class v extends LinearLayout implements ac {
    private static final int huq = R.id.q;
    private a jfA;
    private AppBrandNumberKeyboardView jfB;
    private boolean jfz = false;
    EditText tc;

    public interface a {
        void onDone();
    }

    static /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(123754);
        vVar.onDone();
        AppMethodBeat.o(123754);
    }

    public static v cL(View view) {
        AppMethodBeat.i(123742);
        v vVar = (v) view.getRootView().findViewById(huq);
        AppMethodBeat.o(123742);
        return vVar;
    }

    public static v cM(View view) {
        AppMethodBeat.i(123743);
        v cL = cL(view);
        if (cL == null) {
            n cG = n.cG(view);
            if (cG == null) {
                AppMethodBeat.o(123743);
                return null;
            }
            cL = new v(view.getContext());
            cG.n(cL, false);
        }
        AppMethodBeat.o(123743);
        return cL;
    }

    private v(Context context) {
        super(context);
        AppMethodBeat.i(123744);
        super.setId(huq);
        setOrientation(1);
        setBackgroundColor(-1);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 30));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123741);
                v.a(v.this);
                v.this.setVisibility(8);
                AppMethodBeat.o(123741);
            }
        });
        relativeLayout.setBackgroundResource(R.drawable.a3_);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.biv);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 240));
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
        this.jfB = appBrandNumberKeyboardView;
        addView(appBrandNumberKeyboardView, layoutParams);
        AppMethodBeat.o(123744);
    }

    public final boolean aQV() {
        AppMethodBeat.i(123745);
        boolean as = s.as(this);
        AppMethodBeat.o(123745);
        return as;
    }

    public final void setOnDoneListener(a aVar) {
        this.jfA = aVar;
    }

    private void onDone() {
        AppMethodBeat.i(123746);
        if (!(this.jfz || this.jfA == null)) {
            this.jfz = true;
            this.jfA.onDone();
            this.jfz = false;
        }
        AppMethodBeat.o(123746);
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(123747);
        if (getVisibility() == i && (getVisibility() == 0 || getVisibility() == 8)) {
            AppMethodBeat.o(123747);
        } else if (i != 0) {
            super.setVisibility(8);
            onDone();
            AppMethodBeat.o(123747);
        } else {
            super.setVisibility(i);
            AppMethodBeat.o(123747);
        }
    }

    public final int getPanelHeight() {
        AppMethodBeat.i(123748);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 270);
        AppMethodBeat.o(123748);
        return fromDPToPix;
    }

    public final <_Input extends EditText & com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input _input) {
        AppMethodBeat.i(123749);
        this.tc = _input;
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = this.jfB;
        com.tencent.mm.plugin.appbrand.widget.input.numberpad.a aVar = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a) _input;
        if (appBrandNumberKeyboardView.jfG != aVar) {
            if (aVar == null) {
                appBrandNumberKeyboardView.jfF = null;
                AppMethodBeat.o(123749);
                return;
            }
            if (aVar instanceof View) {
                ((View) aVar).requestFocus();
            }
            if (aVar instanceof EditText) {
                a.setNoSystemInputOnEditText((EditText) aVar);
                a.c((EditText) aVar);
            }
            appBrandNumberKeyboardView.jfF = aVar.aQU();
        }
        AppMethodBeat.o(123749);
    }

    public final EditText getAttachedEditText() {
        return this.tc;
    }

    public final void setXMode(int i) {
        AppMethodBeat.i(123750);
        this.jfB.setXMode(i);
        AppMethodBeat.o(123750);
    }

    /* Access modifiers changed, original: final */
    public final void aQW() {
        AppMethodBeat.i(123751);
        if (this.tc != null) {
            this.tc.clearFocus();
            this.tc = null;
            this.jfA = null;
            this.jfz = false;
        }
        AppMethodBeat.o(123751);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(123752);
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(getPanelHeight(), ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(123752);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(123753);
        super.onDetachedFromWindow();
        removeAllViews();
        AppMethodBeat.o(123753);
    }
}
