package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C0553t;
import android.support.p057v4.widget.C0553t.C0552a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.n */
public class C24637n<V extends View> extends Behavior<V> {
    /* renamed from: nl */
    C0553t f4935nl;
    /* renamed from: nv */
    private final C0552a f4936nv = new C246391();
    /* renamed from: rE */
    C8350a f4937rE;
    /* renamed from: rF */
    private boolean f4938rF;
    /* renamed from: rG */
    private float f4939rG = 0.0f;
    /* renamed from: rH */
    private boolean f4940rH;
    /* renamed from: rI */
    int f4941rI = 2;
    /* renamed from: rJ */
    float f4942rJ = 0.5f;
    /* renamed from: rK */
    float f4943rK = 0.0f;
    /* renamed from: rL */
    float f4944rL = 0.5f;

    /* renamed from: android.support.design.widget.n$a */
    public interface C8350a {
        /* renamed from: I */
        void mo446I(int i);

        void onDismiss(View view);
    }

    /* renamed from: android.support.design.widget.n$b */
    class C24638b implements Runnable {
        private final View mView;
        /* renamed from: rO */
        private final boolean f4946rO;

        C24638b(View view, boolean z) {
            this.mView = view;
            this.f4946rO = z;
        }

        public final void run() {
            if (C24637n.this.f4935nl != null && C24637n.this.f4935nl.mo1322eX()) {
                C0477s.m934b(this.mView, (Runnable) this);
            } else if (this.f4946rO && C24637n.this.f4937rE != null) {
                C24637n.this.f4937rE.onDismiss(this.mView);
            }
        }
    }

    /* renamed from: android.support.design.widget.n$1 */
    class C246391 extends C0552a {
        private int mActivePointerId = -1;
        /* renamed from: rM */
        private int f4947rM;

        C246391() {
        }

        /* renamed from: b */
        public final boolean mo1218b(View view, int i) {
            return this.mActivePointerId == -1 && C24637n.this.mo443h(view);
        }

        /* renamed from: k */
        public final void mo1224k(View view, int i) {
            this.mActivePointerId = i;
            this.f4947rM = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: N */
        public final void mo1215N(int i) {
            if (C24637n.this.f4937rE != null) {
                C24637n.this.f4937rE.mo446I(i);
            }
        }

        /* renamed from: a */
        public final void mo1216a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.mActivePointerId = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = C0477s.m893T(view) == 1;
                z = C24637n.this.f4941rI == 2 ? true : C24637n.this.f4941rI == 0 ? z ? f < 0.0f : f > 0.0f : C24637n.this.f4941rI == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.f4947rM) >= Math.round(((float) view.getWidth()) * C24637n.this.f4942rJ);
            }
            if (z) {
                i = view.getLeft() < this.f4947rM ? this.f4947rM - width : this.f4947rM + width;
            } else {
                i = this.f4947rM;
                z2 = false;
            }
            if (C24637n.this.f4935nl.mo1316D(i, view.getTop())) {
                C0477s.m934b(view, new C24638b(view, z2));
            } else if (z2 && C24637n.this.f4937rE != null) {
                C24637n.this.f4937rE.onDismiss(view);
            }
        }

        /* renamed from: s */
        public final int mo1225s(View view) {
            return view.getWidth();
        }

        /* renamed from: d */
        public final int mo1220d(View view, int i) {
            int width;
            int i2;
            Object obj = C0477s.m893T(view) == 1 ? 1 : null;
            if (C24637n.this.f4941rI == 0) {
                if (obj != null) {
                    width = this.f4947rM - view.getWidth();
                    i2 = this.f4947rM;
                } else {
                    width = this.f4947rM;
                    i2 = this.f4947rM + view.getWidth();
                }
            } else if (C24637n.this.f4941rI != 1) {
                width = this.f4947rM - view.getWidth();
                i2 = this.f4947rM + view.getWidth();
            } else if (obj != null) {
                width = this.f4947rM;
                i2 = this.f4947rM + view.getWidth();
            } else {
                width = this.f4947rM - view.getWidth();
                i2 = this.f4947rM;
            }
            return C24637n.clamp(width, i, i2);
        }

        /* renamed from: c */
        public final int mo1219c(View view, int i) {
            return view.getTop();
        }

        /* renamed from: b */
        public final void mo1217b(View view, int i, int i2) {
            float width = ((float) this.f4947rM) + (((float) view.getWidth()) * C24637n.this.f4943rK);
            float width2 = ((float) this.f4947rM) + (((float) view.getWidth()) * C24637n.this.f4944rL);
            if (((float) i) <= width) {
                view.setAlpha(1.0f);
            } else if (((float) i) >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(C24637n.m38345p(1.0f - C24637n.m38344c(width, width2, (float) i)));
            }
        }
    }

    /* renamed from: a */
    public boolean mo442a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f4938rF;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f4938rF = coordinatorLayout.mo66176d(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.f4938rF;
                break;
            case 1:
            case 3:
                this.f4938rF = false;
                break;
        }
        if (!z) {
            return false;
        }
        if (this.f4935nl == null) {
            C0553t a;
            if (this.f4940rH) {
                a = C0553t.m1196a((ViewGroup) coordinatorLayout, this.f4939rG, this.f4936nv);
            } else {
                a = C0553t.m1197a(coordinatorLayout, this.f4936nv);
            }
            this.f4935nl = a;
        }
        return this.f4935nl.mo1323f(motionEvent);
    }

    /* renamed from: b */
    public final boolean mo31556b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f4935nl == null) {
            return false;
        }
        this.f4935nl.mo1324g(motionEvent);
        return true;
    }

    /* renamed from: h */
    public boolean mo443h(View view) {
        return true;
    }

    /* renamed from: p */
    static float m38345p(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* renamed from: c */
    static float m38344c(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
