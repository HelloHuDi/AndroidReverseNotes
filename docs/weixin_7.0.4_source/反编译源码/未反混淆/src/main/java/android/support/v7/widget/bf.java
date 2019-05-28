package android.support.v7.widget;

import android.support.v4.view.s;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

final class bf implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static bf auK;
    private static bf auL;
    private final CharSequence ZY;
    private final View auE;
    private final Runnable auF = new Runnable() {
        public final void run() {
            bf.this.av(false);
        }
    };
    private int auG;
    private int auH;
    private bg auI;
    private boolean auJ;
    private final Runnable mHideRunnable = new Runnable() {
        public final void run() {
            bf.this.hide();
        }
    };

    public static void a(View view, CharSequence charSequence) {
        if (auK != null && auK.auE == view) {
            a(null);
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
        bf bfVar = new bf(view, charSequence);
    }

    private bf(View view, CharSequence charSequence) {
        this.auE = view;
        this.ZY = charSequence;
        this.auE.setOnLongClickListener(this);
        this.auE.setOnHoverListener(this);
    }

    public final boolean onLongClick(View view) {
        this.auG = view.getWidth() / 2;
        this.auH = view.getHeight() / 2;
        av(true);
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
                            a(this);
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

    private void av(boolean z) {
        if (s.av(this.auE)) {
            long j;
            a(null);
            if (auL != null) {
                auL.hide();
            }
            auL = this;
            this.auJ = z;
            this.auI = new bg(this.auE.getContext());
            this.auI.a(this.auE, this.auG, this.auH, this.auJ, this.ZY);
            this.auE.addOnAttachStateChangeListener(this);
            if (this.auJ) {
                j = 2500;
            } else if ((s.aj(this.auE) & 1) == 1) {
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
            a(null);
        }
        this.auE.removeCallbacks(this.mHideRunnable);
    }

    private static void a(bf bfVar) {
        if (auK != null) {
            auK.lv();
        }
        auK = bfVar;
        if (bfVar != null) {
            auK.lu();
        }
    }

    private void lu() {
        this.auE.postDelayed(this.auF, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void lv() {
        this.auE.removeCallbacks(this.auF);
    }
}
