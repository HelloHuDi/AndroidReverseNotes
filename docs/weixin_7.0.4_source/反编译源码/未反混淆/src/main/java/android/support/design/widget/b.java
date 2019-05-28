package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import java.util.List;

public abstract class b<B extends b<B>> {
    private static final boolean mK;
    static final Handler sHandler = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            b bVar;
            switch (message.what) {
                case 0:
                    bVar = (b) message.obj;
                    if (bVar.mM.getParent() == null) {
                        LayoutParams layoutParams = bVar.mM.getLayoutParams();
                        if (layoutParams instanceof android.support.design.widget.CoordinatorLayout.d) {
                            android.support.design.widget.CoordinatorLayout.d dVar = (android.support.design.widget.CoordinatorLayout.d) layoutParams;
                            a aVar = new a();
                            aVar.rK = n.p(0.1f);
                            aVar.rL = n.p(0.6f);
                            aVar.rI = 0;
                            aVar.rE = new android.support.design.widget.n.a() {
                                public final void onDismiss(View view) {
                                    view.setVisibility(8);
                                    b bVar = b.this;
                                    l co = l.co();
                                    a aVar = bVar.mQ;
                                    synchronized (co.mLock) {
                                        if (co.d(aVar)) {
                                            co.a(co.rs);
                                        } else if (co.e(aVar)) {
                                            co.a(co.rt);
                                        }
                                    }
                                }

                                public final void I(int i) {
                                    switch (i) {
                                        case 0:
                                            l.co().b(b.this.mQ);
                                            return;
                                        case 1:
                                        case 2:
                                            l.co().a(b.this.mQ);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            dVar.a(aVar);
                            dVar.pL = 80;
                        }
                        bVar.mL.addView(bVar.mM);
                    }
                    bVar.mM.setOnAttachStateChangeListener(new c() {
                        public final void bH() {
                            if (l.co().c(b.this.mQ)) {
                                b.sHandler.post(new Runnable() {
                                    public final void run() {
                                        b.this.bF();
                                    }
                                });
                            }
                        }
                    });
                    if (!s.as(bVar.mM)) {
                        bVar.mM.setOnLayoutChangeListener(new d() {
                            public final void bI() {
                                b.this.mM.setOnLayoutChangeListener(null);
                                if (b.this.bG()) {
                                    b.this.bD();
                                } else {
                                    b.this.bE();
                                }
                            }
                        });
                    } else if (bVar.bG()) {
                        bVar.bD();
                    } else {
                        bVar.bE();
                    }
                    return true;
                case 1:
                    bVar = (b) message.obj;
                    int i = message.arg1;
                    if (!bVar.bG() || bVar.mM.getVisibility() != 0) {
                        bVar.bF();
                    } else if (VERSION.SDK_INT >= 12) {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(new int[]{0, bVar.mM.getHeight()});
                        valueAnimator.setInterpolator(a.mg);
                        valueAnimator.setDuration(250);
                        valueAnimator.addListener(new AnonymousClass2(i));
                        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                            private int mS = 0;

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                if (b.mK) {
                                    s.q(b.this.mM, intValue - this.mS);
                                } else {
                                    b.this.mM.setTranslationY((float) intValue);
                                }
                                this.mS = intValue;
                            }
                        });
                        valueAnimator.start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(bVar.mM.getContext(), R.anim.ai);
                        loadAnimation.setInterpolator(a.mg);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass4(i));
                        bVar.mM.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final ViewGroup mL;
    final e mM;
    private final b mN;
    private List<Object<B>> mO;
    private final AccessibilityManager mP;
    final a mQ;

    /* renamed from: android.support.design.widget.b$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ int val$event;

        AnonymousClass2(int i) {
            this.val$event = i;
        }

        public final void onAnimationStart(Animator animator) {
            b.this.mN.bx();
        }

        public final void onAnimationEnd(Animator animator) {
            b.this.bF();
        }
    }

    /* renamed from: android.support.design.widget.b$4 */
    class AnonymousClass4 implements AnimationListener {
        final /* synthetic */ int val$event;

        AnonymousClass4(int i) {
            this.val$event = i;
        }

        public final void onAnimationEnd(Animation animation) {
            b.this.bF();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    interface d {
        void bI();
    }

    static class e extends FrameLayout {
        private d mV;
        private c mW;

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(1)) {
                s.h(this, (float) obtainStyledAttributes.getDimensionPixelSize(1, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        /* Access modifiers changed, original: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mV != null) {
                this.mV.bI();
            }
        }

        /* Access modifiers changed, original: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            s.ak(this);
        }

        /* Access modifiers changed, original: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.mW != null) {
                this.mW.bH();
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void setOnLayoutChangeListener(d dVar) {
            this.mV = dVar;
        }

        /* Access modifiers changed, original: 0000 */
        public void setOnAttachStateChangeListener(c cVar) {
            this.mW = cVar;
        }
    }

    final class a extends n<e> {
        a() {
        }

        public final boolean h(View view) {
            return view instanceof e;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, e eVar, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.d(eVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        l.co().a(b.this.mQ);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    l.co().b(b.this.mQ);
                    break;
            }
            return super.a(coordinatorLayout, eVar, motionEvent);
        }
    }

    public interface b {
        void bw();

        void bx();
    }

    interface c {
        void bH();
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        mK = z;
    }

    /* Access modifiers changed, original: final */
    public final void bD() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.mM.getHeight();
            if (mK) {
                s.q(this.mM, height);
            } else {
                this.mM.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(a.mg);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    b.this.mN.bw();
                }

                public final void onAnimationEnd(Animator animator) {
                    b.this.bE();
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                private int mS = height;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.mK) {
                        s.q(b.this.mM, intValue - this.mS);
                    } else {
                        b.this.mM.setTranslationY((float) intValue);
                    }
                    this.mS = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mM.getContext(), R.anim.ah);
        loadAnimation.setInterpolator(a.mg);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
                b.this.bE();
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.mM.startAnimation(loadAnimation);
    }

    /* Access modifiers changed, original: final */
    public final void bE() {
        l co = l.co();
        a aVar = this.mQ;
        synchronized (co.mLock) {
            if (co.d(aVar)) {
                co.b(co.rs);
            }
        }
        if (this.mO != null) {
            for (int size = this.mO.size() - 1; size >= 0; size--) {
                this.mO.get(size);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void bF() {
        l co = l.co();
        a aVar = this.mQ;
        synchronized (co.mLock) {
            if (co.d(aVar)) {
                co.rs = null;
                if (!(co.rt == null || co.rt == null)) {
                    co.rs = co.rt;
                    co.rt = null;
                    if (((a) co.rs.rv.get()) == null) {
                        co.rs = null;
                    }
                }
            }
        }
        if (this.mO != null) {
            for (int size = this.mO.size() - 1; size >= 0; size--) {
                this.mO.get(size);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.mM.setVisibility(8);
        }
        ViewParent parent = this.mM.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mM);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean bG() {
        return !this.mP.isEnabled();
    }
}
