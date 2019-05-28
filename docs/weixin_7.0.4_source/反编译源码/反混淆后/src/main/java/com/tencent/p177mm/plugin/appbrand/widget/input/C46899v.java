package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.p057v4.view.C0477s;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45720aj.C42731a;
import com.tencent.p177mm.plugin.appbrand.widget.input.numberpad.C42741a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.v */
public final class C46899v extends LinearLayout implements C45719ac {
    private static final int huq = 2131820560;
    private C2576a jfA;
    private AppBrandNumberKeyboardView jfB;
    private boolean jfz = false;
    /* renamed from: tc */
    EditText f18290tc;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.v$a */
    public interface C2576a {
        void onDone();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.v$1 */
    class C386071 implements OnClickListener {
        C386071() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123741);
            C46899v.m89262a(C46899v.this);
            C46899v.this.setVisibility(8);
            AppMethodBeat.m2505o(123741);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m89262a(C46899v c46899v) {
        AppMethodBeat.m2504i(123754);
        c46899v.onDone();
        AppMethodBeat.m2505o(123754);
    }

    /* renamed from: cL */
    public static C46899v m89263cL(View view) {
        AppMethodBeat.m2504i(123742);
        C46899v c46899v = (C46899v) view.getRootView().findViewById(huq);
        AppMethodBeat.m2505o(123742);
        return c46899v;
    }

    /* renamed from: cM */
    public static C46899v m89264cM(View view) {
        AppMethodBeat.m2504i(123743);
        C46899v cL = C46899v.m89263cL(view);
        if (cL == null) {
            C42740n cG = C42740n.m75740cG(view);
            if (cG == null) {
                AppMethodBeat.m2505o(123743);
                return null;
            }
            cL = new C46899v(view.getContext());
            cG.mo68198n(cL, false);
        }
        AppMethodBeat.m2505o(123743);
        return cL;
    }

    private C46899v(Context context) {
        super(context);
        AppMethodBeat.m2504i(123744);
        super.setId(huq);
        setOrientation(1);
        setBackgroundColor(-1);
        LayoutParams layoutParams = new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 30));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new C386071());
        relativeLayout.setBackgroundResource(C25738R.drawable.a3_);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C25738R.drawable.biv);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 240));
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
        this.jfB = appBrandNumberKeyboardView;
        addView(appBrandNumberKeyboardView, layoutParams);
        AppMethodBeat.m2505o(123744);
    }

    public final boolean aQV() {
        AppMethodBeat.m2504i(123745);
        boolean as = C0477s.m927as(this);
        AppMethodBeat.m2505o(123745);
        return as;
    }

    public final void setOnDoneListener(C2576a c2576a) {
        this.jfA = c2576a;
    }

    private void onDone() {
        AppMethodBeat.m2504i(123746);
        if (!(this.jfz || this.jfA == null)) {
            this.jfz = true;
            this.jfA.onDone();
            this.jfz = false;
        }
        AppMethodBeat.m2505o(123746);
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(123747);
        if (getVisibility() == i && (getVisibility() == 0 || getVisibility() == 8)) {
            AppMethodBeat.m2505o(123747);
        } else if (i != 0) {
            super.setVisibility(8);
            onDone();
            AppMethodBeat.m2505o(123747);
        } else {
            super.setVisibility(i);
            AppMethodBeat.m2505o(123747);
        }
    }

    public final int getPanelHeight() {
        AppMethodBeat.m2504i(123748);
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 270);
        AppMethodBeat.m2505o(123748);
        return fromDPToPix;
    }

    public final <_Input extends EditText & C42741a> void setInputEditText(_Input _input) {
        AppMethodBeat.m2504i(123749);
        this.f18290tc = _input;
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = this.jfB;
        C42741a c42741a = (C42741a) _input;
        if (appBrandNumberKeyboardView.jfG != c42741a) {
            if (c42741a == null) {
                appBrandNumberKeyboardView.jfF = null;
                AppMethodBeat.m2505o(123749);
                return;
            }
            if (c42741a instanceof View) {
                ((View) c42741a).requestFocus();
            }
            if (c42741a instanceof EditText) {
                C42731a.setNoSystemInputOnEditText((EditText) c42741a);
                C42731a.m75727c((EditText) c42741a);
            }
            appBrandNumberKeyboardView.jfF = c42741a.aQU();
        }
        AppMethodBeat.m2505o(123749);
    }

    public final EditText getAttachedEditText() {
        return this.f18290tc;
    }

    public final void setXMode(int i) {
        AppMethodBeat.m2504i(123750);
        this.jfB.setXMode(i);
        AppMethodBeat.m2505o(123750);
    }

    /* Access modifiers changed, original: final */
    public final void aQW() {
        AppMethodBeat.m2504i(123751);
        if (this.f18290tc != null) {
            this.f18290tc.clearFocus();
            this.f18290tc = null;
            this.jfA = null;
            this.jfz = false;
        }
        AppMethodBeat.m2505o(123751);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(123752);
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(getPanelHeight(), ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(123752);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(123753);
        super.onDetachedFromWindow();
        removeAllViews();
        AppMethodBeat.m2505o(123753);
    }
}
