package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.s;
import android.support.v4.widget.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class n<V extends View> extends Behavior<V> {
    t nl;
    private final android.support.v4.widget.t.a nv = new android.support.v4.widget.t.a() {
        private int mActivePointerId = -1;
        private int rM;

        public final boolean b(View view, int i) {
            return this.mActivePointerId == -1 && n.this.h(view);
        }

        public final void k(View view, int i) {
            this.mActivePointerId = i;
            this.rM = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void N(int i) {
            if (n.this.rE != null) {
                n.this.rE.I(i);
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.mActivePointerId = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = s.T(view) == 1;
                z = n.this.rI == 2 ? true : n.this.rI == 0 ? z ? f < 0.0f : f > 0.0f : n.this.rI == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.rM) >= Math.round(((float) view.getWidth()) * n.this.rJ);
            }
            if (z) {
                i = view.getLeft() < this.rM ? this.rM - width : this.rM + width;
            } else {
                i = this.rM;
                z2 = false;
            }
            if (n.this.nl.D(i, view.getTop())) {
                s.b(view, new b(view, z2));
            } else if (z2 && n.this.rE != null) {
                n.this.rE.onDismiss(view);
            }
        }

        public final int s(View view) {
            return view.getWidth();
        }

        public final int d(View view, int i) {
            int width;
            int i2;
            Object obj = s.T(view) == 1 ? 1 : null;
            if (n.this.rI == 0) {
                if (obj != null) {
                    width = this.rM - view.getWidth();
                    i2 = this.rM;
                } else {
                    width = this.rM;
                    i2 = this.rM + view.getWidth();
                }
            } else if (n.this.rI != 1) {
                width = this.rM - view.getWidth();
                i2 = this.rM + view.getWidth();
            } else if (obj != null) {
                width = this.rM;
                i2 = this.rM + view.getWidth();
            } else {
                width = this.rM - view.getWidth();
                i2 = this.rM;
            }
            return n.clamp(width, i, i2);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void b(View view, int i, int i2) {
            float width = ((float) this.rM) + (((float) view.getWidth()) * n.this.rK);
            float width2 = ((float) this.rM) + (((float) view.getWidth()) * n.this.rL);
            if (((float) i) <= width) {
                view.setAlpha(1.0f);
            } else if (((float) i) >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(n.p(1.0f - n.c(width, width2, (float) i)));
            }
        }
    };
    a rE;
    private boolean rF;
    private float rG = 0.0f;
    private boolean rH;
    int rI = 2;
    float rJ = 0.5f;
    float rK = 0.0f;
    float rL = 0.5f;

    public interface a {
        void I(int i);

        void onDismiss(View view);
    }

    class b implements Runnable {
        private final View mView;
        private final boolean rO;

        b(View view, boolean z) {
            this.mView = view;
            this.rO = z;
        }

        public final void run() {
            if (n.this.nl != null && n.this.nl.eX()) {
                s.b(this.mView, (Runnable) this);
            } else if (this.rO && n.this.rE != null) {
                n.this.rE.onDismiss(this.mView);
            }
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.rF;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.rF = coordinatorLayout.d(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.rF;
                break;
            case 1:
            case 3:
                this.rF = false;
                break;
        }
        if (!z) {
            return false;
        }
        if (this.nl == null) {
            t a;
            if (this.rH) {
                a = t.a((ViewGroup) coordinatorLayout, this.rG, this.nv);
            } else {
                a = t.a(coordinatorLayout, this.nv);
            }
            this.nl = a;
        }
        return this.nl.f(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.nl == null) {
            return false;
        }
        this.nl.g(motionEvent);
        return true;
    }

    public boolean h(View view) {
        return true;
    }

    static float p(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    static float c(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
