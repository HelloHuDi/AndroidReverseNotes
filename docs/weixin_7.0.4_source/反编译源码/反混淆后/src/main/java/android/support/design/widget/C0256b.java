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
import android.support.design.C37097a.C37096a;
import android.support.design.widget.C17395l.C17396a;
import android.support.design.widget.C24637n.C8350a;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p057v4.view.C0477s;
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
import com.tencent.p177mm.C25738R;
import java.util.List;

/* renamed from: android.support.design.widget.b */
public abstract class C0256b<B extends C0256b<B>> {
    /* renamed from: mK */
    private static final boolean f161mK;
    static final Handler sHandler = new Handler(Looper.getMainLooper(), new C02571());
    /* renamed from: mL */
    final ViewGroup f162mL;
    /* renamed from: mM */
    final C0263e f163mM;
    /* renamed from: mN */
    private final C0269b f164mN;
    /* renamed from: mO */
    private List<Object<B>> f165mO;
    /* renamed from: mP */
    private final AccessibilityManager f166mP;
    /* renamed from: mQ */
    final C17396a f167mQ;

    /* renamed from: android.support.design.widget.b$1 */
    static class C02571 implements Callback {
        C02571() {
        }

        public final boolean handleMessage(Message message) {
            C0256b c0256b;
            switch (message.what) {
                case 0:
                    c0256b = (C0256b) message.obj;
                    if (c0256b.f163mM.getParent() == null) {
                        LayoutParams layoutParams = c0256b.f163mM.getLayoutParams();
                        if (layoutParams instanceof C31839d) {
                            C31839d c31839d = (C31839d) layoutParams;
                            C0268a c0268a = new C0268a();
                            c0268a.f4943rK = C24637n.m38345p(0.1f);
                            c0268a.f4944rL = C24637n.m38345p(0.6f);
                            c0268a.f4941rI = 0;
                            c0268a.f4937rE = new C02715();
                            c31839d.mo51801a(c0268a);
                            c31839d.f14564pL = 80;
                        }
                        c0256b.f162mL.addView(c0256b.f163mM);
                    }
                    c0256b.f163mM.setOnAttachStateChangeListener(new C02656());
                    if (!C0477s.m927as(c0256b.f163mM)) {
                        c0256b.f163mM.setOnLayoutChangeListener(new C02727());
                    } else if (c0256b.mo420bG()) {
                        c0256b.mo417bD();
                    } else {
                        c0256b.mo418bE();
                    }
                    return true;
                case 1:
                    c0256b = (C0256b) message.obj;
                    int i = message.arg1;
                    if (!c0256b.mo420bG() || c0256b.f163mM.getVisibility() != 0) {
                        c0256b.mo419bF();
                    } else if (VERSION.SDK_INT >= 12) {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(new int[]{0, c0256b.f163mM.getHeight()});
                        valueAnimator.setInterpolator(C31841a.f14580mg);
                        valueAnimator.setDuration(250);
                        valueAnimator.addListener(new C02582(i));
                        valueAnimator.addUpdateListener(new C02643());
                        valueAnimator.start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(c0256b.f163mM.getContext(), C25738R.anim.f8313ai);
                        loadAnimation.setInterpolator(C31841a.f14580mg);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new C02594(i));
                        c0256b.f163mM.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.b$2 */
    class C02582 extends AnimatorListenerAdapter {
        final /* synthetic */ int val$event;

        C02582(int i) {
            this.val$event = i;
        }

        public final void onAnimationStart(Animator animator) {
            C0256b.this.f164mN.mo445bx();
        }

        public final void onAnimationEnd(Animator animator) {
            C0256b.this.mo419bF();
        }
    }

    /* renamed from: android.support.design.widget.b$4 */
    class C02594 implements AnimationListener {
        final /* synthetic */ int val$event;

        C02594(int i) {
            this.val$event = i;
        }

        public final void onAnimationEnd(Animation animation) {
            C0256b.this.mo419bF();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.b$10 */
    class C026010 implements AnimationListener {
        C026010() {
        }

        public final void onAnimationEnd(Animation animation) {
            C0256b.this.mo418bE();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.b$d */
    interface C0262d {
        /* renamed from: bI */
        void mo431bI();
    }

    /* renamed from: android.support.design.widget.b$e */
    static class C0263e extends FrameLayout {
        /* renamed from: mV */
        private C0262d f174mV;
        /* renamed from: mW */
        private C0270c f175mW;

        C0263e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(1)) {
                C0477s.m945h(this, (float) obtainStyledAttributes.getDimensionPixelSize(1, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        /* Access modifiers changed, original: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f174mV != null) {
                this.f174mV.mo431bI();
            }
        }

        /* Access modifiers changed, original: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            C0477s.m919ak(this);
        }

        /* Access modifiers changed, original: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f175mW != null) {
                this.f175mW.mo438bH();
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void setOnLayoutChangeListener(C0262d c0262d) {
            this.f174mV = c0262d;
        }

        /* Access modifiers changed, original: 0000 */
        public void setOnAttachStateChangeListener(C0270c c0270c) {
            this.f175mW = c0270c;
        }
    }

    /* renamed from: android.support.design.widget.b$3 */
    class C02643 implements AnimatorUpdateListener {
        /* renamed from: mS */
        private int f177mS = 0;

        C02643() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (C0256b.f161mK) {
                C0477s.m951q(C0256b.this.f163mM, intValue - this.f177mS);
            } else {
                C0256b.this.f163mM.setTranslationY((float) intValue);
            }
            this.f177mS = intValue;
        }
    }

    /* renamed from: android.support.design.widget.b$6 */
    class C02656 implements C0270c {

        /* renamed from: android.support.design.widget.b$6$1 */
        class C02661 implements Runnable {
            C02661() {
            }

            public final void run() {
                C0256b.this.mo419bF();
            }
        }

        C02656() {
        }

        /* renamed from: bH */
        public final void mo438bH() {
            if (C17395l.m27011co().mo31613c(C0256b.this.f167mQ)) {
                C0256b.sHandler.post(new C02661());
            }
        }
    }

    /* renamed from: android.support.design.widget.b$8 */
    class C02678 extends AnimatorListenerAdapter {
        C02678() {
        }

        public final void onAnimationStart(Animator animator) {
            C0256b.this.f164mN.mo444bw();
        }

        public final void onAnimationEnd(Animator animator) {
            C0256b.this.mo418bE();
        }
    }

    /* renamed from: android.support.design.widget.b$a */
    final class C0268a extends C24637n<C0263e> {
        C0268a() {
        }

        /* renamed from: h */
        public final boolean mo443h(View view) {
            return view instanceof C0263e;
        }

        /* renamed from: a */
        private boolean m436a(CoordinatorLayout coordinatorLayout, C0263e c0263e, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.mo66176d(c0263e, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        C17395l.m27011co().mo31609a(C0256b.this.f167mQ);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    C17395l.m27011co().mo31611b(C0256b.this.f167mQ);
                    break;
            }
            return super.mo442a(coordinatorLayout, c0263e, motionEvent);
        }
    }

    /* renamed from: android.support.design.widget.b$b */
    public interface C0269b {
        /* renamed from: bw */
        void mo444bw();

        /* renamed from: bx */
        void mo445bx();
    }

    /* renamed from: android.support.design.widget.b$c */
    interface C0270c {
        /* renamed from: bH */
        void mo438bH();
    }

    /* renamed from: android.support.design.widget.b$5 */
    class C02715 implements C8350a {
        C02715() {
        }

        public final void onDismiss(View view) {
            view.setVisibility(8);
            C0256b c0256b = C0256b.this;
            C17395l co = C17395l.m27011co();
            C17396a c17396a = c0256b.f167mQ;
            synchronized (co.mLock) {
                if (co.mo31614d(c17396a)) {
                    co.mo31610a(co.f3801rs);
                } else if (co.mo31615e(c17396a)) {
                    co.mo31610a(co.f3802rt);
                }
            }
        }

        /* renamed from: I */
        public final void mo446I(int i) {
            switch (i) {
                case 0:
                    C17395l.m27011co().mo31611b(C0256b.this.f167mQ);
                    return;
                case 1:
                case 2:
                    C17395l.m27011co().mo31609a(C0256b.this.f167mQ);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.design.widget.b$7 */
    class C02727 implements C0262d {
        C02727() {
        }

        /* renamed from: bI */
        public final void mo431bI() {
            C0256b.this.f163mM.setOnLayoutChangeListener(null);
            if (C0256b.this.mo420bG()) {
                C0256b.this.mo417bD();
            } else {
                C0256b.this.mo418bE();
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        f161mK = z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bD */
    public final void mo417bD() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.f163mM.getHeight();
            if (f161mK) {
                C0477s.m951q(this.f163mM, height);
            } else {
                this.f163mM.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(C31841a.f14580mg);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new C02678());
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                /* renamed from: mS */
                private int f172mS = height;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (C0256b.f161mK) {
                        C0477s.m951q(C0256b.this.f163mM, intValue - this.f172mS);
                    } else {
                        C0256b.this.f163mM.setTranslationY((float) intValue);
                    }
                    this.f172mS = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f163mM.getContext(), C25738R.anim.f8312ah);
        loadAnimation.setInterpolator(C31841a.f14580mg);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C026010());
        this.f163mM.startAnimation(loadAnimation);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bE */
    public final void mo418bE() {
        C17395l co = C17395l.m27011co();
        C17396a c17396a = this.f167mQ;
        synchronized (co.mLock) {
            if (co.mo31614d(c17396a)) {
                co.mo31612b(co.f3801rs);
            }
        }
        if (this.f165mO != null) {
            for (int size = this.f165mO.size() - 1; size >= 0; size--) {
                this.f165mO.get(size);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bF */
    public final void mo419bF() {
        C17395l co = C17395l.m27011co();
        C17396a c17396a = this.f167mQ;
        synchronized (co.mLock) {
            if (co.mo31614d(c17396a)) {
                co.f3801rs = null;
                if (!(co.f3802rt == null || co.f3802rt == null)) {
                    co.f3801rs = co.f3802rt;
                    co.f3802rt = null;
                    if (((C17396a) co.f3801rs.f3803rv.get()) == null) {
                        co.f3801rs = null;
                    }
                }
            }
        }
        if (this.f165mO != null) {
            for (int size = this.f165mO.size() - 1; size >= 0; size--) {
                this.f165mO.get(size);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f163mM.setVisibility(8);
        }
        ViewParent parent = this.f163mM.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f163mM);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bG */
    public final boolean mo420bG() {
        return !this.f166mP.isEnabled();
    }
}
