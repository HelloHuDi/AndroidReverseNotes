package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.statusbar.C5544c;
import com.tencent.p177mm.p612ui.statusbar.C5544c.C5543a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.performance.C27257d;
import com.tencent.p177mm.plugin.appbrand.widget.C33575a;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.k */
public final class C19789k extends LinearLayout implements C5543a {
    private final C19788a[] iJm = new C19788a[4];
    private final SparseArray<C19790b> iJn = new SparseArray();
    private final SparseArray<C19790b> iJo = new SparseArray();
    private int iJp;
    public final C25697b ivC;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.k$1 */
    public class C197871 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(102333);
            C19789k.this.setVisibility(8);
            AppMethodBeat.m2505o(102333);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.k$a */
    class C19788a extends TextView {
        public C19788a(Context context) {
            super(context);
            AppMethodBeat.m2504i(102336);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            int fromDPToPix = C1338a.fromDPToPix(getContext(), 5);
            layoutParams.setMargins(0, fromDPToPix, 0, fromDPToPix);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(-7171438);
            AppMethodBeat.m2505o(102336);
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.k$b */
    class C19790b extends TextView {
        private String mTitle;
        private String mValue;

        public C19790b(Context context) {
            super(context);
            AppMethodBeat.m2504i(102337);
            setLayoutParams(new LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(-419430401);
            AppMethodBeat.m2505o(102337);
        }

        private void update() {
            AppMethodBeat.m2504i(102338);
            setText(String.format("%s: %s", new Object[]{this.mTitle, this.mValue}));
            AppMethodBeat.m2505o(102338);
        }

        /* renamed from: a */
        static /* synthetic */ void m30628a(C19790b c19790b, String str) {
            AppMethodBeat.m2504i(102339);
            c19790b.mValue = str;
            c19790b.update();
            AppMethodBeat.m2505o(102339);
        }

        /* renamed from: b */
        static /* synthetic */ void m30629b(C19790b c19790b, String str) {
            AppMethodBeat.m2504i(102340);
            c19790b.mTitle = str;
            c19790b.update();
            AppMethodBeat.m2505o(102340);
        }
    }

    public C19789k(Context context, C25697b c25697b) {
        super(context);
        AppMethodBeat.m2504i(102341);
        this.ivC = c25697b;
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = C1338a.fromDPToPix(getContext(), 4);
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
        textView.setText(getContext().getString(C25738R.string.f8997lz));
        addView(textView);
        layoutParams3.setMargins(0, C1338a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        aMv();
        C5544c.m8364az((Activity) getContext()).mo11253a(this);
        AppMethodBeat.m2505o(102341);
    }

    private void aMu() {
        AppMethodBeat.m2504i(102342);
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = C33575a.m54827de(getContext()) + this.iJp;
            requestLayout();
        }
        AppMethodBeat.m2505o(102342);
    }

    private void aMv() {
        AppMethodBeat.m2504i(102343);
        for (int i = 0; i < 4; i++) {
            C19788a c19788a = new C19788a(getContext());
            c19788a.setText(getContext().getString(C27257d.ivQ[i]));
            this.iJm[i] = c19788a;
            addView(c19788a);
        }
        AppMethodBeat.m2505o(102343);
    }

    /* renamed from: ae */
    public final void mo35017ae(final int i, final String str) {
        AppMethodBeat.m2504i(102344);
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102334);
                C19789k.m30623a(C19789k.this, i, str);
                AppMethodBeat.m2505o(102334);
            }
        });
        AppMethodBeat.m2505o(102344);
    }

    /* renamed from: cP */
    public final void mo35018cP(final String str, final String str2) {
        AppMethodBeat.m2504i(102345);
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102335);
                C19789k.m30624a(C19789k.this, str, str2);
                AppMethodBeat.m2505o(102335);
            }
        });
        AppMethodBeat.m2505o(102345);
    }

    /* renamed from: pO */
    public final void mo11252pO(int i) {
        AppMethodBeat.m2504i(102346);
        this.iJp = i;
        aMu();
        AppMethodBeat.m2505o(102346);
    }
}
