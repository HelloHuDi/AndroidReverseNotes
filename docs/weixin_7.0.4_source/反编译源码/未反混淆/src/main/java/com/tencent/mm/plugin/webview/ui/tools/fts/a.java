package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Array;
import java.util.Arrays;

public class a {
    protected boolean isAnimating;
    protected int oIe;
    protected AnimatorUpdateListener uCA = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(8564);
            a.this.uCn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            a.this.uCn.setX(a.this.uCw[1][1]);
            a.this.uCn.setY(a.this.uCw[0][1]);
            a.this.uCn.setPadding(a.this.uCm, 0, 0, 0);
            LayoutParams layoutParams = (LayoutParams) a.this.uCn.getLayoutParams();
            if (layoutParams.leftMargin != 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.width = ((int) a.this.uCw[2][0]) + (a.this.uCj * 2);
                a.this.uCn.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(8564);
        }
    };
    protected AnimatorUpdateListener uCB = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(8565);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((a.this.uCw[0][0] - a.this.uCw[0][1]) * floatValue) + a.this.uCw[0][1];
            a.this.uCn.setX(((a.this.uCw[1][0] - a.this.uCw[1][1]) * floatValue) + a.this.uCw[1][1]);
            a.this.uCn.setY(f);
            a.this.uCn.setPadding((int) ((((float) (a.this.uCl - a.this.uCm)) * floatValue) + ((float) a.this.uCm)), 0, 0, 0);
            LayoutParams layoutParams = (LayoutParams) a.this.uCn.getLayoutParams();
            int i = (int) (floatValue * ((float) a.this.uCj));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((a.this.uCj - i) * 2) + ((int) a.this.uCw[2][0]);
            a.this.uCn.setLayoutParams(layoutParams);
            AppMethodBeat.o(8565);
        }
    };
    protected AnimatorUpdateListener uCC = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(8566);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
                a.this.uCn.setX(a.this.uCw[1][0]);
                a.this.uCn.setY(a.this.uCw[0][0]);
                a.this.uCn.setPadding(0, 0, 0, 0);
                LayoutParams layoutParams = (LayoutParams) a.this.uCn.getLayoutParams();
                layoutParams.leftMargin = a.this.uCj;
                layoutParams.rightMargin = a.this.uCj;
                layoutParams.width = (int) a.this.uCw[2][0];
                a.this.uCn.setLayoutParams(layoutParams);
                a.this.uCn.setAlpha(1.0f);
                AppMethodBeat.o(8566);
                return;
            }
            a.this.uCn.setAlpha(1.0f - floatValue);
            AppMethodBeat.o(8566);
        }
    };
    protected int uCj;
    protected int uCk;
    protected int uCl;
    protected int uCm;
    protected View uCn;
    protected View uCo;
    protected View uCp;
    protected View uCq;
    protected View uCr;
    protected View uCs;
    protected View uCt;
    protected View uCu;
    protected View uCv;
    protected float[][] uCw;
    protected b uCx = b.Init;
    protected a uCy;
    protected AnimatorUpdateListener uCz = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(8563);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((a.this.uCw[0][1] - a.this.uCw[0][0]) * floatValue) + a.this.uCw[0][0];
            a.this.uCn.setX(((a.this.uCw[1][1] - a.this.uCw[1][0]) * floatValue) + a.this.uCw[1][0]);
            a.this.uCn.setY(f);
            a.this.uCn.setPadding((int) ((((float) (a.this.uCm - a.this.uCl)) * floatValue) + ((float) a.this.uCl)), 0, 0, 0);
            ab.v("MicroMsg.FTS.SosAnimatorBaseController", "searchBarView.paddingLeft %d", Integer.valueOf(a.this.uCn.getPaddingLeft()));
            LayoutParams layoutParams = (LayoutParams) a.this.uCn.getLayoutParams();
            int i = (int) ((1.0f - floatValue) * ((float) a.this.uCj));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((a.this.uCj - i) * 2) + ((int) a.this.uCw[2][0]);
            a.this.uCn.setLayoutParams(layoutParams);
            AppMethodBeat.o(8563);
        }
    };

    public interface a {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public enum b {
        Init,
        Search;

        static {
            AppMethodBeat.o(8570);
        }
    }

    public a(Context context, final View view, View view2, View view3, View view4, View view5, View view6, View view7, final View view8, View view9) {
        AppMethodBeat.i(8571);
        this.uCj = com.tencent.mm.bz.a.fromDPToPix(context, 48) / 2;
        this.oIe = (int) context.getResources().getDimension(R.dimen.a9t);
        this.uCw = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.uCn = view;
        this.uCo = view2;
        this.uCp = view3;
        this.uCq = view4;
        this.uCr = view5;
        this.uCs = view6;
        this.uCt = view7;
        this.uCu = view8;
        this.uCv = view9;
        this.uCn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8561);
                a.this.uCw[0][0] = view.getY();
                a.this.uCw[0][1] = 0.0f;
                a.this.uCw[1][0] = view.getX();
                a.this.uCw[1][1] = 0.0f;
                a.this.uCw[2][0] = (float) view.getMeasuredWidth();
                a.this.uCw[2][1] = (float) (view.getMeasuredWidth() + (a.this.uCj * 2));
                ab.i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", Arrays.toString(a.this.uCw));
                AppMethodBeat.o(8561);
            }
        });
        this.uCu.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8562);
                a.this.uCk = view8.getMeasuredHeight();
                AppMethodBeat.o(8562);
            }
        });
        AppMethodBeat.o(8571);
    }

    public final void JG(int i) {
        this.uCw[0][0] = (float) i;
    }

    public final void a(b bVar) {
        this.uCx = bVar;
    }

    public void b(b bVar) {
        AppMethodBeat.i(8572);
        if (bVar == this.uCx) {
            AppMethodBeat.o(8572);
            return;
        }
        switch (bVar) {
            case Init:
                dbQ();
                break;
            case Search:
                dbR();
                break;
        }
        this.uCx = bVar;
        AppMethodBeat.o(8572);
    }

    /* Access modifiers changed, original: protected */
    public void dbQ() {
    }

    /* Access modifiers changed, original: protected */
    public void dbR() {
    }

    public final void a(a aVar) {
        this.uCy = aVar;
    }
}
