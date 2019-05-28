package android.support.p069v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C37137l;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.MotionEvent;
import com.tencent.rtmp.TXLivePushConfig;

/* renamed from: android.support.v7.widget.ac */
final class C8463ac extends C25373h implements C37137l {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] PRESSED_STATE_SET = new int[]{16842919};
    /* renamed from: SG */
    private int f2413SG = 0;
    int aiA = 0;
    RecyclerView aiB;
    boolean aiC = false;
    boolean aiD = false;
    private final int[] aiE = new int[2];
    private final int[] aiF = new int[2];
    final ValueAnimator aiG = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    int aiH = 0;
    private final C41530m aiI = new C84652();
    final int aik;
    private final StateListDrawable ail;
    private final Drawable aim;
    private final int ain;
    private final int aio;
    private final StateListDrawable aip;
    private final Drawable aiq;
    private final int air;
    private final int ais;
    int ait;
    int aiu;
    float aiv;
    int aiw;
    int aix;
    float aiy;
    int aiz = 0;
    /* renamed from: hz */
    private final int f2414hz;
    private final Runnable mHideRunnable = new C84661();
    int mState = 0;

    /* renamed from: android.support.v7.widget.ac$a */
    class C8462a extends AnimatorListenerAdapter {
        /* renamed from: xH */
        private boolean f2412xH;

        private C8462a() {
            this.f2412xH = false;
        }

        /* synthetic */ C8462a(C8463ac c8463ac, byte b) {
            this();
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.f2412xH) {
                this.f2412xH = false;
            } else if (((Float) C8463ac.this.aiG.getAnimatedValue()).floatValue() == 0.0f) {
                C8463ac.this.aiH = 0;
                C8463ac.this.setState(0);
            } else {
                C8463ac.this.aiH = 2;
                C8463ac.this.aiB.invalidate();
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f2412xH = true;
        }
    }

    /* renamed from: android.support.v7.widget.ac$b */
    class C8464b implements AnimatorUpdateListener {
        private C8464b() {
        }

        /* synthetic */ C8464b(C8463ac c8463ac, byte b) {
            this();
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C8463ac.this.ail.setAlpha(floatValue);
            C8463ac.this.aim.setAlpha(floatValue);
            C8463ac.this.aiB.invalidate();
        }
    }

    /* renamed from: android.support.v7.widget.ac$2 */
    class C84652 extends C41530m {
        C84652() {
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            C8463ac c8463ac = C8463ac.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = c8463ac.aiB.computeVerticalScrollRange();
            int i3 = c8463ac.aiA;
            boolean z = computeVerticalScrollRange - i3 > 0 && c8463ac.aiA >= c8463ac.aik;
            c8463ac.aiC = z;
            int computeHorizontalScrollRange = c8463ac.aiB.computeHorizontalScrollRange();
            int i4 = c8463ac.aiz;
            if (computeHorizontalScrollRange - i4 <= 0 || c8463ac.aiz < c8463ac.aik) {
                z = false;
            } else {
                z = true;
            }
            c8463ac.aiD = z;
            if (c8463ac.aiC || c8463ac.aiD) {
                if (c8463ac.aiC) {
                    c8463ac.aiu = (int) (((((float) computeVerticalScrollOffset) + (((float) i3) / 2.0f)) * ((float) i3)) / ((float) computeVerticalScrollRange));
                    c8463ac.ait = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (c8463ac.aiD) {
                    c8463ac.aix = (int) (((((float) computeHorizontalScrollOffset) + (((float) i4) / 2.0f)) * ((float) i4)) / ((float) computeHorizontalScrollRange));
                    c8463ac.aiw = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                if (c8463ac.mState == 0 || c8463ac.mState == 1) {
                    c8463ac.setState(1);
                }
            } else if (c8463ac.mState != 0) {
                c8463ac.setState(0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ac$1 */
    class C84661 implements Runnable {
        C84661() {
        }

        public final void run() {
            C8463ac c8463ac = C8463ac.this;
            switch (c8463ac.aiH) {
                case 1:
                    c8463ac.aiG.cancel();
                    break;
                case 2:
                    break;
                default:
                    return;
            }
            c8463ac.aiH = 3;
            c8463ac.aiG.setFloatValues(new float[]{((Float) c8463ac.aiG.getAnimatedValue()).floatValue(), 0.0f});
            c8463ac.aiG.setDuration(500);
            c8463ac.aiG.start();
        }
    }

    C8463ac(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.ail = stateListDrawable;
        this.aim = drawable;
        this.aip = stateListDrawable2;
        this.aiq = drawable2;
        this.ain = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.aio = Math.max(i, drawable.getIntrinsicWidth());
        this.air = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.ais = Math.max(i, drawable2.getIntrinsicWidth());
        this.aik = i2;
        this.f2414hz = i3;
        this.ail.setAlpha(255);
        this.aim.setAlpha(255);
        this.aiG.addListener(new C8462a(this, (byte) 0));
        this.aiG.addUpdateListener(new C8464b(this, (byte) 0));
        if (this.aiB != recyclerView) {
            if (this.aiB != null) {
                this.aiB.mo66354c((C25373h) this);
                this.aiB.mo66347b((C37137l) this);
                this.aiB.mo66348b(this.aiI);
                m14999ic();
            }
            this.aiB = recyclerView;
            if (this.aiB != null) {
                this.aiB.mo66330a((C25373h) this);
                this.aiB.mo66331a((C37137l) this);
                this.aiB.mo66332a(this.aiI);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void setState(int i) {
        if (i == 2 && this.mState != 2) {
            this.ail.setState(PRESSED_STATE_SET);
            m14999ic();
        }
        if (i == 0) {
            this.aiB.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            this.ail.setState(EMPTY_STATE_SET);
            m14994bL(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        } else if (i == 1) {
            m14994bL(1500);
        }
        this.mState = i;
    }

    /* renamed from: ib */
    private boolean m14998ib() {
        return C0477s.m893T(this.aiB) == 1;
    }

    private void show() {
        switch (this.aiH) {
            case 0:
                break;
            case 3:
                this.aiG.cancel();
                break;
            default:
                return;
        }
        this.aiH = 1;
        this.aiG.setFloatValues(new float[]{((Float) this.aiG.getAnimatedValue()).floatValue(), 1.0f});
        this.aiG.setDuration(500);
        this.aiG.setStartDelay(0);
        this.aiG.start();
    }

    /* renamed from: ic */
    private void m14999ic() {
        this.aiB.removeCallbacks(this.mHideRunnable);
    }

    /* renamed from: bL */
    private void m14994bL(int i) {
        m14999ic();
        this.aiB.postDelayed(this.mHideRunnable, (long) i);
    }

    /* renamed from: a */
    public final void mo18494a(Canvas canvas, RecyclerView recyclerView) {
        if (this.aiz != this.aiB.getWidth() || this.aiA != this.aiB.getHeight()) {
            this.aiz = this.aiB.getWidth();
            this.aiA = this.aiB.getHeight();
            setState(0);
        } else if (this.aiH != 0) {
            int i;
            int i2;
            if (this.aiC) {
                i = this.aiz - this.ain;
                i2 = this.aiu - (this.ait / 2);
                this.ail.setBounds(0, 0, this.ain, this.ait);
                this.aim.setBounds(0, 0, this.aio, this.aiA);
                if (m14998ib()) {
                    this.aim.draw(canvas);
                    canvas.translate((float) this.ain, (float) i2);
                    canvas.scale(-1.0f, 1.0f);
                    this.ail.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.ain), (float) (-i2));
                } else {
                    canvas.translate((float) i, 0.0f);
                    this.aim.draw(canvas);
                    canvas.translate(0.0f, (float) i2);
                    this.ail.draw(canvas);
                    canvas.translate((float) (-i), (float) (-i2));
                }
            }
            if (this.aiD) {
                i = this.aiA - this.air;
                i2 = this.aix - (this.aiw / 2);
                this.aip.setBounds(0, 0, this.aiw, this.air);
                this.aiq.setBounds(0, 0, this.aiz, this.ais);
                canvas.translate(0.0f, (float) i);
                this.aiq.draw(canvas);
                canvas.translate((float) i2, 0.0f);
                this.aip.draw(canvas);
                canvas.translate((float) (-i2), (float) (-i));
            }
        }
    }

    /* renamed from: h */
    public final boolean mo18506h(MotionEvent motionEvent) {
        if (this.mState == 1) {
            boolean v = m15000v(motionEvent.getX(), motionEvent.getY());
            boolean w = m15001w(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0 || (!v && !w)) {
                return false;
            }
            if (w) {
                this.f2413SG = 1;
                this.aiy = (float) ((int) motionEvent.getX());
            } else if (v) {
                this.f2413SG = 2;
                this.aiv = (float) ((int) motionEvent.getY());
            }
            setState(2);
            return true;
        } else if (this.mState != 2) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: i */
    public final void mo18507i(MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean v = m15000v(motionEvent.getX(), motionEvent.getY());
                boolean w = m15001w(motionEvent.getX(), motionEvent.getY());
                if (v || w) {
                    if (w) {
                        this.f2413SG = 1;
                        this.aiy = (float) ((int) motionEvent.getX());
                    } else if (v) {
                        this.f2413SG = 2;
                        this.aiv = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.aiv = 0.0f;
                this.aiy = 0.0f;
                setState(1);
                this.f2413SG = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                float x;
                int[] iArr;
                float max;
                int a;
                show();
                if (this.f2413SG == 1) {
                    x = motionEvent.getX();
                    this.aiF[0] = this.f2414hz;
                    this.aiF[1] = this.aiz - this.f2414hz;
                    iArr = this.aiF;
                    max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.aix) - max) >= 2.0f) {
                        a = C8463ac.m14990a(this.aiy, max, iArr, this.aiB.computeHorizontalScrollRange(), this.aiB.computeHorizontalScrollOffset(), this.aiz);
                        if (a != 0) {
                            this.aiB.scrollBy(a, 0);
                        }
                        this.aiy = max;
                    }
                }
                if (this.f2413SG == 2) {
                    x = motionEvent.getY();
                    this.aiE[0] = this.f2414hz;
                    this.aiE[1] = this.aiA - this.f2414hz;
                    iArr = this.aiE;
                    max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.aiu) - max) >= 2.0f) {
                        a = C8463ac.m14990a(this.aiv, max, iArr, this.aiB.computeVerticalScrollRange(), this.aiB.computeVerticalScrollOffset(), this.aiA);
                        if (a != 0) {
                            this.aiB.scrollBy(0, a);
                        }
                        this.aiv = max;
                    }
                }
            }
        }
    }

    /* renamed from: ab */
    public final void mo18505ab(boolean z) {
    }

    /* renamed from: a */
    private static int m14990a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        i4 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i6 = i2 + i4;
        if (i6 >= i5 || i6 < 0) {
            return 0;
        }
        return i4;
    }

    /* renamed from: v */
    private boolean m15000v(float f, float f2) {
        if (m14998ib() ? f <= ((float) (this.ain / 2)) : f >= ((float) (this.aiz - this.ain))) {
            if (f2 >= ((float) (this.aiu - (this.ait / 2))) && f2 <= ((float) (this.aiu + (this.ait / 2)))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w */
    private boolean m15001w(float f, float f2) {
        return f2 >= ((float) (this.aiA - this.air)) && f >= ((float) (this.aix - (this.aiw / 2))) && f <= ((float) (this.aix + (this.aiw / 2)));
    }
}
