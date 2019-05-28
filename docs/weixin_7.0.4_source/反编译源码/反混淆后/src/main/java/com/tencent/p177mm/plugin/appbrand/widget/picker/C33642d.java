package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d */
public class C33642d extends RelativeLayout {
    private static final int jkW = Color.parseColor("#F9F9F9");
    private final int jkP;
    private final int jkQ;
    private C19427b jkR;
    private FrameLayout jkS;
    private C33643a jkT;
    private boolean jkU;
    C33644b jkV;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$3 */
    class C110463 implements OnClickListener {
        C110463() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$1 */
    class C274261 implements OnClickListener {
        C274261() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126727);
            C33642d.m54933a(C33642d.this, true, C33642d.this.jkR == null ? null : C33642d.this.jkR.aEG());
            AppMethodBeat.m2505o(126727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$2 */
    class C274272 implements OnClickListener {
        C274272() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126728);
            C33642d.m54933a(C33642d.this, false, null);
            AppMethodBeat.m2505o(126728);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$a */
    public interface C33643a<T> {
        /* renamed from: b */
        void mo6189b(boolean z, T t);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$b */
    public interface C33644b<T> {
        /* renamed from: bw */
        void mo34564bw(T t);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.d$4 */
    class C336454 implements OnClickListener {
        C336454() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m54933a(C33642d c33642d, boolean z, Object obj) {
        AppMethodBeat.m2504i(126739);
        c33642d.m54935c(z, obj);
        AppMethodBeat.m2505o(126739);
    }

    public void setOnResultListener(C33643a c33643a) {
        this.jkT = c33643a;
    }

    public void setOnValueUpdateListener(C33644b c33644b) {
        this.jkV = c33644b;
    }

    private void aRL() {
        this.jkT = null;
        this.jkV = null;
    }

    /* renamed from: c */
    private void m54935c(boolean z, Object obj) {
        AppMethodBeat.m2504i(126729);
        if (!(this.jkU || this.jkT == null)) {
            this.jkU = true;
            this.jkT.mo6189b(z, obj);
            this.jkU = false;
        }
        AppMethodBeat.m2505o(126729);
    }

    static {
        AppMethodBeat.m2504i(126740);
        AppMethodBeat.m2505o(126740);
    }

    public C33642d(Context context) {
        super(context);
        AppMethodBeat.m2504i(126730);
        this.jkP = C1338a.fromDPToPix(context, 48);
        this.jkQ = C1338a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new LayoutParams(-1, this.jkQ);
        layoutParams.addRule(12);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(2131820574);
        frameLayout.setOnClickListener(new C336454());
        frameLayout.setBackgroundColor(jkW);
        this.jkS = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new LayoutParams(-1, this.jkP);
        layoutParams.addRule(2, 2131820574);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        View dv = m54936dv(C25738R.string.cud, C25738R.color.f12069r8);
        dv.setOnClickListener(new C274261());
        LayoutParams layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(dv, layoutParams2);
        dv = m54936dv(C25738R.string.cuc, C25738R.color.f11829im);
        dv.setOnClickListener(new C274272());
        layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        relativeLayout.addView(dv, layoutParams2);
        relativeLayout.setOnClickListener(new C110463());
        relativeLayout.setBackgroundColor(jkW);
        addView(relativeLayout, layoutParams);
        AppMethodBeat.m2505o(126730);
    }

    /* Access modifiers changed, original: protected */
    public void setPickerImpl(C19427b c19427b) {
        AppMethodBeat.m2504i(126731);
        if (this.jkR != null) {
            this.jkR.aEI();
        }
        this.jkR = c19427b;
        if (this.jkR != null) {
            this.jkR.mo22731b(this);
        }
        if (this.jkS == null || this.jkR == null || this.jkR.getView() == null) {
            AppMethodBeat.m2505o(126731);
            return;
        }
        this.jkS.removeAllViews();
        aRL();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.jkS.addView(this.jkR.getView(), layoutParams);
        AppMethodBeat.m2505o(126731);
    }

    public C19427b getPicker() {
        return this.jkR;
    }

    public void show() {
        AppMethodBeat.m2504i(126732);
        if (this.jkR == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(126732);
            return;
        }
        setVisibility(0);
        if (this.jkR != null) {
            this.jkR.mo22726a(this);
        }
        AppMethodBeat.m2505o(126732);
    }

    public void hide() {
        AppMethodBeat.m2504i(126733);
        super.setVisibility(8);
        m54935c(false, null);
        if (this.jkR != null) {
            this.jkR.aEH();
        }
        AppMethodBeat.m2505o(126733);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(126734);
        if (i != 0) {
            hide();
            AppMethodBeat.m2505o(126734);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(126734);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getPanelContentHeight() {
        return this.jkP + this.jkQ;
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    /* renamed from: du */
    public final void mo54201du(int i, int i2) {
        AppMethodBeat.m2504i(126735);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(126735);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(126736);
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.jkP + this.jkQ, ErrorDialogData.SUPPRESSED));
            AppMethodBeat.m2505o(126736);
            return;
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(126736);
    }

    /* renamed from: dv */
    private View m54936dv(int i, int i2) {
        AppMethodBeat.m2504i(126737);
        TextView textView = new TextView(new ContextThemeWrapper(getContext(), C25738R.style.f10753dg));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        AppMethodBeat.m2505o(126737);
        return textView;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(126738);
        super.onDetachedFromWindow();
        aRL();
        removeAllViews();
        AppMethodBeat.m2505o(126738);
    }
}
