package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a */
public class C40306a {
    protected boolean isAnimating;
    protected int oIe;
    protected AnimatorUpdateListener uCA = new C229664();
    protected AnimatorUpdateListener uCB = new C229675();
    protected AnimatorUpdateListener uCC = new C356736();
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
    protected C40305b uCx = C40305b.Init;
    protected C29904a uCy;
    protected AnimatorUpdateListener uCz = new C229653();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$3 */
    class C229653 implements AnimatorUpdateListener {
        C229653() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(8563);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((C40306a.this.uCw[0][1] - C40306a.this.uCw[0][0]) * floatValue) + C40306a.this.uCw[0][0];
            C40306a.this.uCn.setX(((C40306a.this.uCw[1][1] - C40306a.this.uCw[1][0]) * floatValue) + C40306a.this.uCw[1][0]);
            C40306a.this.uCn.setY(f);
            C40306a.this.uCn.setPadding((int) ((((float) (C40306a.this.uCm - C40306a.this.uCl)) * floatValue) + ((float) C40306a.this.uCl)), 0, 0, 0);
            C4990ab.m7419v("MicroMsg.FTS.SosAnimatorBaseController", "searchBarView.paddingLeft %d", Integer.valueOf(C40306a.this.uCn.getPaddingLeft()));
            LayoutParams layoutParams = (LayoutParams) C40306a.this.uCn.getLayoutParams();
            int i = (int) ((1.0f - floatValue) * ((float) C40306a.this.uCj));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((C40306a.this.uCj - i) * 2) + ((int) C40306a.this.uCw[2][0]);
            C40306a.this.uCn.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(8563);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$4 */
    class C229664 implements AnimatorUpdateListener {
        C229664() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(8564);
            C40306a.this.uCn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            C40306a.this.uCn.setX(C40306a.this.uCw[1][1]);
            C40306a.this.uCn.setY(C40306a.this.uCw[0][1]);
            C40306a.this.uCn.setPadding(C40306a.this.uCm, 0, 0, 0);
            LayoutParams layoutParams = (LayoutParams) C40306a.this.uCn.getLayoutParams();
            if (layoutParams.leftMargin != 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.width = ((int) C40306a.this.uCw[2][0]) + (C40306a.this.uCj * 2);
                C40306a.this.uCn.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(8564);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$5 */
    class C229675 implements AnimatorUpdateListener {
        C229675() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(8565);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((C40306a.this.uCw[0][0] - C40306a.this.uCw[0][1]) * floatValue) + C40306a.this.uCw[0][1];
            C40306a.this.uCn.setX(((C40306a.this.uCw[1][0] - C40306a.this.uCw[1][1]) * floatValue) + C40306a.this.uCw[1][1]);
            C40306a.this.uCn.setY(f);
            C40306a.this.uCn.setPadding((int) ((((float) (C40306a.this.uCl - C40306a.this.uCm)) * floatValue) + ((float) C40306a.this.uCm)), 0, 0, 0);
            LayoutParams layoutParams = (LayoutParams) C40306a.this.uCn.getLayoutParams();
            int i = (int) (floatValue * ((float) C40306a.this.uCj));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((C40306a.this.uCj - i) * 2) + ((int) C40306a.this.uCw[2][0]);
            C40306a.this.uCn.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(8565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$a */
    public interface C29904a {
        void onAnimationEnd();

        void onAnimationStart();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$6 */
    class C356736 implements AnimatorUpdateListener {
        C356736() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(8566);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
                C40306a.this.uCn.setX(C40306a.this.uCw[1][0]);
                C40306a.this.uCn.setY(C40306a.this.uCw[0][0]);
                C40306a.this.uCn.setPadding(0, 0, 0, 0);
                LayoutParams layoutParams = (LayoutParams) C40306a.this.uCn.getLayoutParams();
                layoutParams.leftMargin = C40306a.this.uCj;
                layoutParams.rightMargin = C40306a.this.uCj;
                layoutParams.width = (int) C40306a.this.uCw[2][0];
                C40306a.this.uCn.setLayoutParams(layoutParams);
                C40306a.this.uCn.setAlpha(1.0f);
                AppMethodBeat.m2505o(8566);
                return;
            }
            C40306a.this.uCn.setAlpha(1.0f - floatValue);
            AppMethodBeat.m2505o(8566);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$b */
    public enum C40305b {
        Init,
        Search;

        static {
            AppMethodBeat.m2505o(8570);
        }
    }

    public C40306a(Context context, final View view, View view2, View view3, View view4, View view5, View view6, View view7, final View view8, View view9) {
        AppMethodBeat.m2504i(8571);
        this.uCj = C1338a.fromDPToPix(context, 48) / 2;
        this.oIe = (int) context.getResources().getDimension(C25738R.dimen.a9t);
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
                AppMethodBeat.m2504i(8561);
                C40306a.this.uCw[0][0] = view.getY();
                C40306a.this.uCw[0][1] = 0.0f;
                C40306a.this.uCw[1][0] = view.getX();
                C40306a.this.uCw[1][1] = 0.0f;
                C40306a.this.uCw[2][0] = (float) view.getMeasuredWidth();
                C40306a.this.uCw[2][1] = (float) (view.getMeasuredWidth() + (C40306a.this.uCj * 2));
                C4990ab.m7417i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", Arrays.toString(C40306a.this.uCw));
                AppMethodBeat.m2505o(8561);
            }
        });
        this.uCu.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8562);
                C40306a.this.uCk = view8.getMeasuredHeight();
                AppMethodBeat.m2505o(8562);
            }
        });
        AppMethodBeat.m2505o(8571);
    }

    /* renamed from: JG */
    public final void mo63664JG(int i) {
        this.uCw[0][0] = (float) i;
    }

    /* renamed from: a */
    public final void mo63666a(C40305b c40305b) {
        this.uCx = c40305b;
    }

    /* renamed from: b */
    public void mo48143b(C40305b c40305b) {
        AppMethodBeat.m2504i(8572);
        if (c40305b == this.uCx) {
            AppMethodBeat.m2505o(8572);
            return;
        }
        switch (c40305b) {
            case Init:
                dbQ();
                break;
            case Search:
                dbR();
                break;
        }
        this.uCx = c40305b;
        AppMethodBeat.m2505o(8572);
    }

    /* Access modifiers changed, original: protected */
    public void dbQ() {
    }

    /* Access modifiers changed, original: protected */
    public void dbR() {
    }

    /* renamed from: a */
    public final void mo63665a(C29904a c29904a) {
        this.uCy = c29904a;
    }
}
