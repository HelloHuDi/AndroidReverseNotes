package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.h;

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
        AppMethodBeat.i(39629);
        AppMethodBeat.o(39629);
    }

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39623);
        LayoutInflater.from(getContext()).inflate(R.layout.b0r, this);
        this.rBu = (TextView) findViewById(R.id.ezb);
        this.qeY = (TextView) findViewById(R.id.ezc);
        this.rBv = findViewById(R.id.eza);
        this.fHj = getResources().getDrawable(R.drawable.ap0);
        this.fHj.setBounds(0, 0, (int) (this.qeY.getTextSize() * 0.8f), (int) (this.qeY.getTextSize() * 0.8f));
        this.fHj.setColorFilter(rBw, Mode.SRC_IN);
        AppMethodBeat.o(39623);
    }

    public final void El(int i) {
        AppMethodBeat.i(39624);
        this.qeY.setCompoundDrawables(this.fHj, null, null, null);
        this.qeY.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.qeY.setText(R.string.eq8);
        h.a(this.qeY, null);
        this.rBu.setVisibility(4);
        this.rxe = i;
        this.qeY.setTextSize(0, this.rBu.getTextSize());
        this.qeY.setTextColor(getContext().getResources().getColor(R.color.a14));
        AppMethodBeat.o(39624);
    }

    public TextView getResultTextView() {
        return this.qeY;
    }

    public View getSplitlineView() {
        return this.rBv;
    }

    public final void setResultTextSize$255e752(float f) {
        AppMethodBeat.i(39625);
        this.qeY.setTextSize(1, f);
        this.rBx = f;
        this.rBy = 1;
        AppMethodBeat.o(39625);
    }

    public void setResultTextSize(float f) {
        AppMethodBeat.i(39626);
        this.qeY.setTextSize(0, f);
        this.rBx = f;
        this.rBy = 0;
        AppMethodBeat.o(39626);
    }

    private void cuv() {
        AppMethodBeat.i(39627);
        if (this.rBx != -1.0f || this.rBy != -1) {
            this.qeY.setTextSize(this.rBy, this.rBx);
        } else if (this.rxe == 2) {
            this.qeY.setTextSize(1, 14.0f * a.dm(getContext()));
        } else if (this.rxe == 1) {
            this.qeY.setTextSize(1, 15.0f * a.dm(getContext()));
        }
        if (this.rxe == 2) {
            this.qeY.setTextColor(getContext().getResources().getColor(R.color.a13));
            AppMethodBeat.o(39627);
            return;
        }
        if (this.rxe == 1) {
            this.qeY.setTextColor(getContext().getResources().getColor(R.color.a15));
        }
        AppMethodBeat.o(39627);
    }

    @TargetApi(11)
    public final void a(final b bVar, int i, String str, String str2, boolean z) {
        AppMethodBeat.i(39628);
        this.rxe = i;
        cuv();
        if (bo.isNullOrNil(str)) {
            this.qeY.setText(R.string.eq6);
        } else {
            this.qeY.setText(str);
            j.h(this.qeY, 2);
        }
        this.qeY.setCompoundDrawables(null, null, null, null);
        if (z && d.iW(11)) {
            h.a(this.qeY, new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(39622);
                    if (bVar != null) {
                        ap.a(bVar);
                    }
                    AppMethodBeat.o(39622);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (bo.isNullOrNil(str2)) {
            this.rBu.setText(R.string.aox);
        } else {
            this.rBu.setText(str2);
        }
        this.rBu.setVisibility(0);
        AppMethodBeat.o(39628);
    }
}
