package com.tencent.p177mm.plugin.sns.p520ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTranslateResultView */
public class SnsTranslateResultView extends LinearLayout {
    private static final int rBw = Color.parseColor("#19000000");
    private Drawable fHj;
    private TextView qeY;
    private TextView rBu;
    private View rBv;
    private float rBx = -1.0f;
    private int rBy = -1;
    private int rxe = -1;

    static {
        AppMethodBeat.m2504i(39629);
        AppMethodBeat.m2505o(39629);
    }

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39623);
        LayoutInflater.from(getContext()).inflate(2130970967, this);
        this.rBu = (TextView) findViewById(2131828362);
        this.qeY = (TextView) findViewById(2131828363);
        this.rBv = findViewById(2131828361);
        this.fHj = getResources().getDrawable(C25738R.drawable.ap0);
        this.fHj.setBounds(0, 0, (int) (this.qeY.getTextSize() * 0.8f), (int) (this.qeY.getTextSize() * 0.8f));
        this.fHj.setColorFilter(rBw, Mode.SRC_IN);
        AppMethodBeat.m2505o(39623);
    }

    /* renamed from: El */
    public final void mo62985El(int i) {
        AppMethodBeat.m2504i(39624);
        this.qeY.setCompoundDrawables(this.fHj, null, null, null);
        this.qeY.setCompoundDrawablePadding(C1338a.fromDPToPix(getContext(), 3));
        this.qeY.setText(C25738R.string.eq8);
        C5587h.m8388a(this.qeY, null);
        this.rBu.setVisibility(4);
        this.rxe = i;
        this.qeY.setTextSize(0, this.rBu.getTextSize());
        this.qeY.setTextColor(getContext().getResources().getColor(C25738R.color.a14));
        AppMethodBeat.m2505o(39624);
    }

    public TextView getResultTextView() {
        return this.qeY;
    }

    public View getSplitlineView() {
        return this.rBv;
    }

    public final void setResultTextSize$255e752(float f) {
        AppMethodBeat.m2504i(39625);
        this.qeY.setTextSize(1, f);
        this.rBx = f;
        this.rBy = 1;
        AppMethodBeat.m2505o(39625);
    }

    public void setResultTextSize(float f) {
        AppMethodBeat.m2504i(39626);
        this.qeY.setTextSize(0, f);
        this.rBx = f;
        this.rBy = 0;
        AppMethodBeat.m2505o(39626);
    }

    private void cuv() {
        AppMethodBeat.m2504i(39627);
        if (this.rBx != -1.0f || this.rBy != -1) {
            this.qeY.setTextSize(this.rBy, this.rBx);
        } else if (this.rxe == 2) {
            this.qeY.setTextSize(1, 14.0f * C1338a.m2860dm(getContext()));
        } else if (this.rxe == 1) {
            this.qeY.setTextSize(1, 15.0f * C1338a.m2860dm(getContext()));
        }
        if (this.rxe == 2) {
            this.qeY.setTextColor(getContext().getResources().getColor(C25738R.color.a13));
            AppMethodBeat.m2505o(39627);
            return;
        }
        if (this.rxe == 1) {
            this.qeY.setTextColor(getContext().getResources().getColor(C25738R.color.a15));
        }
        AppMethodBeat.m2505o(39627);
    }

    @TargetApi(11)
    /* renamed from: a */
    public final void mo62986a(final C13414b c13414b, int i, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(39628);
        this.rxe = i;
        cuv();
        if (C5046bo.isNullOrNil(str)) {
            this.qeY.setText(C25738R.string.eq6);
        } else {
            this.qeY.setText(str);
            C44089j.m79307h(this.qeY, 2);
        }
        this.qeY.setCompoundDrawables(null, null, null, null);
        if (z && C1443d.m3068iW(11)) {
            C5587h.m8388a(this.qeY, new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(39622);
                    if (c13414b != null) {
                        C13413ap.m21542a(c13414b);
                    }
                    AppMethodBeat.m2505o(39622);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (C5046bo.isNullOrNil(str2)) {
            this.rBu.setText(C25738R.string.aox);
        } else {
            this.rBu.setText(str2);
        }
        this.rBu.setVisibility(0);
        AppMethodBeat.m2505o(39628);
    }
}
