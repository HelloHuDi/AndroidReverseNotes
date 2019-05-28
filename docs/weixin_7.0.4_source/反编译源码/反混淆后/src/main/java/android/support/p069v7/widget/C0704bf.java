package android.support.p069v7.widget;

import android.support.p057v4.view.C0477s;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* renamed from: android.support.v7.widget.bf */
final class C0704bf implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static C0704bf auK;
    private static C0704bf auL;
    /* renamed from: ZY */
    private final CharSequence f1020ZY;
    private final View auE;
    private final Runnable auF = new C07021();
    private int auG;
    private int auH;
    private C0705bg auI;
    private boolean auJ;
    private final Runnable mHideRunnable = new C07032();

    /* renamed from: android.support.v7.widget.bf$1 */
    class C07021 implements Runnable {
        C07021() {
        }

        public final void run() {
            C0704bf.this.m1561av(false);
        }
    }

    /* renamed from: android.support.v7.widget.bf$2 */
    class C07032 implements Runnable {
        C07032() {
        }

        public final void run() {
            C0704bf.this.hide();
        }
    }

    /* renamed from: a */
    public static void m1560a(View view, CharSequence charSequence) {
        if (auK != null && auK.auE == view) {
            C0704bf.m1559a(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (auL != null && auL.auE == view) {
                auL.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        C0704bf c0704bf = new C0704bf(view, charSequence);
    }

    private C0704bf(View view, CharSequence charSequence) {
        this.auE = view;
        this.f1020ZY = charSequence;
        this.auE.setOnLongClickListener(this);
        this.auE.setOnHoverListener(this);
    }

    public final boolean onLongClick(View view) {
        this.auG = view.getWidth() / 2;
        this.auH = view.getHeight() / 2;
        m1561av(true);
        return true;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.auI == null || !this.auJ) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.auE.getContext().getSystemService("accessibility");
            if (!(accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.auE.isEnabled() && this.auI == null) {
                            this.auG = (int) motionEvent.getX();
                            this.auH = (int) motionEvent.getY();
                            C0704bf.m1559a(this);
                            break;
                        }
                    case 10:
                        hide();
                        break;
                }
            }
        }
        return false;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    /* renamed from: av */
    private void m1561av(boolean z) {
        if (C0477s.m930av(this.auE)) {
            long j;
            C0704bf.m1559a(null);
            if (auL != null) {
                auL.hide();
            }
            auL = this;
            this.auJ = z;
            this.auI = new C0705bg(this.auE.getContext());
            this.auI.mo2051a(this.auE, this.auG, this.auH, this.auJ, this.f1020ZY);
            this.auE.addOnAttachStateChangeListener(this);
            if (this.auJ) {
                j = 2500;
            } else if ((C0477s.m918aj(this.auE) & 1) == 1) {
                j = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                j = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.auE.removeCallbacks(this.mHideRunnable);
            this.auE.postDelayed(this.mHideRunnable, j);
        }
    }

    private void hide() {
        if (auL == this) {
            auL = null;
            if (this.auI != null) {
                this.auI.hide();
                this.auI = null;
                this.auE.removeOnAttachStateChangeListener(this);
            }
        }
        if (auK == this) {
            C0704bf.m1559a(null);
        }
        this.auE.removeCallbacks(this.mHideRunnable);
    }

    /* renamed from: a */
    private static void m1559a(C0704bf c0704bf) {
        if (auK != null) {
            auK.m1565lv();
        }
        auK = c0704bf;
        if (c0704bf != null) {
            auK.m1564lu();
        }
    }

    /* renamed from: lu */
    private void m1564lu() {
        this.auE.postDelayed(this.auF, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: lv */
    private void m1565lv() {
        this.auE.removeCallbacks(this.auF);
    }
}
