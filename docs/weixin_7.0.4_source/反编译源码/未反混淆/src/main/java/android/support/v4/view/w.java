package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class w {
    private WeakReference<View> Nw;
    Runnable Nx = null;
    Runnable Ny = null;
    int Nz = -1;

    static class a implements x {
        w ND;
        boolean NE;

        a(w wVar) {
            this.ND = wVar;
        }

        public final void az(View view) {
            x xVar;
            this.NE = false;
            if (this.ND.Nz >= 0) {
                view.setLayerType(2, null);
            }
            if (this.ND.Nx != null) {
                Runnable runnable = this.ND.Nx;
                this.ND.Nx = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof x) {
                xVar = (x) tag;
            } else {
                xVar = null;
            }
            if (xVar != null) {
                xVar.az(view);
            }
        }

        public final void aA(View view) {
            if (this.ND.Nz >= 0) {
                view.setLayerType(this.ND.Nz, null);
                this.ND.Nz = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.NE) {
                x xVar;
                if (this.ND.Ny != null) {
                    Runnable runnable = this.ND.Ny;
                    this.ND.Ny = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof x) {
                    xVar = (x) tag;
                } else {
                    xVar = null;
                }
                if (xVar != null) {
                    xVar.aA(view);
                }
                this.NE = true;
            }
        }

        public final void aB(View view) {
            x xVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof x) {
                xVar = (x) tag;
            } else {
                xVar = null;
            }
            if (xVar != null) {
                xVar.aB(view);
            }
        }
    }

    w(View view) {
        this.Nw = new WeakReference(view);
    }

    public final w l(long j) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final w t(float f) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public final w u(float f) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final long getDuration() {
        View view = (View) this.Nw.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public final w c(Interpolator interpolator) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final w m(long j) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final w v(float f) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    public final w A(float f) {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void start() {
        View view = (View) this.Nw.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final w a(x xVar) {
        View view = (View) this.Nw.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                a(view, xVar);
            } else {
                view.setTag(2113929216, xVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final x xVar) {
        if (xVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    xVar.aB(view);
                }

                public final void onAnimationEnd(Animator animator) {
                    xVar.aA(view);
                }

                public final void onAnimationStart(Animator animator) {
                    xVar.az(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public final w a(final z zVar) {
        final View view = (View) this.Nw.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (zVar != null) {
                animatorUpdateListener = new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        zVar.es();
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
