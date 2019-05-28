package android.support.p057v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.w */
public final class C0497w {
    /* renamed from: Nw */
    private WeakReference<View> f586Nw;
    /* renamed from: Nx */
    Runnable f587Nx = null;
    /* renamed from: Ny */
    Runnable f588Ny = null;
    /* renamed from: Nz */
    int f589Nz = -1;

    /* renamed from: android.support.v4.view.w$a */
    static class C0498a implements C0499x {
        /* renamed from: ND */
        C0497w f590ND;
        /* renamed from: NE */
        boolean f591NE;

        C0498a(C0497w c0497w) {
            this.f590ND = c0497w;
        }

        /* renamed from: az */
        public final void mo1166az(View view) {
            C0499x c0499x;
            this.f591NE = false;
            if (this.f590ND.f589Nz >= 0) {
                view.setLayerType(2, null);
            }
            if (this.f590ND.f587Nx != null) {
                Runnable runnable = this.f590ND.f587Nx;
                this.f590ND.f587Nx = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof C0499x) {
                c0499x = (C0499x) tag;
            } else {
                c0499x = null;
            }
            if (c0499x != null) {
                c0499x.mo1166az(view);
            }
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            if (this.f590ND.f589Nz >= 0) {
                view.setLayerType(this.f590ND.f589Nz, null);
                this.f590ND.f589Nz = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f591NE) {
                C0499x c0499x;
                if (this.f590ND.f588Ny != null) {
                    Runnable runnable = this.f590ND.f588Ny;
                    this.f590ND.f588Ny = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof C0499x) {
                    c0499x = (C0499x) tag;
                } else {
                    c0499x = null;
                }
                if (c0499x != null) {
                    c0499x.mo1164aA(view);
                }
                this.f591NE = true;
            }
        }

        /* renamed from: aB */
        public final void mo1165aB(View view) {
            C0499x c0499x;
            Object tag = view.getTag(2113929216);
            if (tag instanceof C0499x) {
                c0499x = (C0499x) tag;
            } else {
                c0499x = null;
            }
            if (c0499x != null) {
                c0499x.mo1165aB(view);
            }
        }
    }

    C0497w(View view) {
        this.f586Nw = new WeakReference(view);
    }

    /* renamed from: l */
    public final C0497w mo1158l(long j) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: t */
    public final C0497w mo1161t(float f) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: u */
    public final C0497w mo1162u(float f) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final long getDuration() {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    /* renamed from: c */
    public final C0497w mo1155c(Interpolator interpolator) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: m */
    public final C0497w mo1159m(long j) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: v */
    public final C0497w mo1163v(float f) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    /* renamed from: A */
    public final C0497w mo1152A(float f) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void start() {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public final C0497w mo1153a(C0499x c0499x) {
        View view = (View) this.f586Nw.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m1036a(view, c0499x);
            } else {
                view.setTag(2113929216, c0499x);
                m1036a(view, new C0498a(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m1036a(final View view, final C0499x c0499x) {
        if (c0499x != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    c0499x.mo1165aB(view);
                }

                public final void onAnimationEnd(Animator animator) {
                    c0499x.mo1164aA(view);
                }

                public final void onAnimationStart(Animator animator) {
                    c0499x.mo1166az(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public final C0497w mo1154a(final C0500z c0500z) {
        final View view = (View) this.f586Nw.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (c0500z != null) {
                animatorUpdateListener = new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c0500z.mo1167es();
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
