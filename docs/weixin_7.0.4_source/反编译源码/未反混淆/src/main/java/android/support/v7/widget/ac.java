package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.s;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.view.MotionEvent;
import com.tencent.rtmp.TXLivePushConfig;

final class ac extends h implements l {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] PRESSED_STATE_SET = new int[]{16842919};
    private int SG = 0;
    int aiA = 0;
    RecyclerView aiB;
    boolean aiC = false;
    boolean aiD = false;
    private final int[] aiE = new int[2];
    private final int[] aiF = new int[2];
    final ValueAnimator aiG = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    int aiH = 0;
    private final m aiI = new m() {
        public final void a(RecyclerView recyclerView, int i, int i2) {
            ac acVar = ac.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = acVar.aiB.computeVerticalScrollRange();
            int i3 = acVar.aiA;
            boolean z = computeVerticalScrollRange - i3 > 0 && acVar.aiA >= acVar.aik;
            acVar.aiC = z;
            int computeHorizontalScrollRange = acVar.aiB.computeHorizontalScrollRange();
            int i4 = acVar.aiz;
            if (computeHorizontalScrollRange - i4 <= 0 || acVar.aiz < acVar.aik) {
                z = false;
            } else {
                z = true;
            }
            acVar.aiD = z;
            if (acVar.aiC || acVar.aiD) {
                if (acVar.aiC) {
                    acVar.aiu = (int) (((((float) computeVerticalScrollOffset) + (((float) i3) / 2.0f)) * ((float) i3)) / ((float) computeVerticalScrollRange));
                    acVar.ait = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (acVar.aiD) {
                    acVar.aix = (int) (((((float) computeHorizontalScrollOffset) + (((float) i4) / 2.0f)) * ((float) i4)) / ((float) computeHorizontalScrollRange));
                    acVar.aiw = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                if (acVar.mState == 0 || acVar.mState == 1) {
                    acVar.setState(1);
                }
            } else if (acVar.mState != 0) {
                acVar.setState(0);
            }
        }
    };
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
    private final int hz;
    private final Runnable mHideRunnable = new Runnable() {
        public final void run() {
            ac acVar = ac.this;
            switch (acVar.aiH) {
                case 1:
                    acVar.aiG.cancel();
                    break;
                case 2:
                    break;
                default:
                    return;
            }
            acVar.aiH = 3;
            acVar.aiG.setFloatValues(new float[]{((Float) acVar.aiG.getAnimatedValue()).floatValue(), 0.0f});
            acVar.aiG.setDuration(500);
            acVar.aiG.start();
        }
    };
    int mState = 0;

    class a extends AnimatorListenerAdapter {
        private boolean xH;

        private a() {
            this.xH = false;
        }

        /* synthetic */ a(ac acVar, byte b) {
            this();
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.xH) {
                this.xH = false;
            } else if (((Float) ac.this.aiG.getAnimatedValue()).floatValue() == 0.0f) {
                ac.this.aiH = 0;
                ac.this.setState(0);
            } else {
                ac.this.aiH = 2;
                ac.this.aiB.invalidate();
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.xH = true;
        }
    }

    class b implements AnimatorUpdateListener {
        private b() {
        }

        /* synthetic */ b(ac acVar, byte b) {
            this();
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            ac.this.ail.setAlpha(floatValue);
            ac.this.aim.setAlpha(floatValue);
            ac.this.aiB.invalidate();
        }
    }

    ac(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.ail = stateListDrawable;
        this.aim = drawable;
        this.aip = stateListDrawable2;
        this.aiq = drawable2;
        this.ain = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.aio = Math.max(i, drawable.getIntrinsicWidth());
        this.air = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.ais = Math.max(i, drawable2.getIntrinsicWidth());
        this.aik = i2;
        this.hz = i3;
        this.ail.setAlpha(255);
        this.aim.setAlpha(255);
        this.aiG.addListener(new a(this, (byte) 0));
        this.aiG.addUpdateListener(new b(this, (byte) 0));
        if (this.aiB != recyclerView) {
            if (this.aiB != null) {
                this.aiB.c((h) this);
                this.aiB.b((l) this);
                this.aiB.b(this.aiI);
                ic();
            }
            this.aiB = recyclerView;
            if (this.aiB != null) {
                this.aiB.a((h) this);
                this.aiB.a((l) this);
                this.aiB.a(this.aiI);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void setState(int i) {
        if (i == 2 && this.mState != 2) {
            this.ail.setState(PRESSED_STATE_SET);
            ic();
        }
        if (i == 0) {
            this.aiB.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            this.ail.setState(EMPTY_STATE_SET);
            bL(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        } else if (i == 1) {
            bL(1500);
        }
        this.mState = i;
    }

    private boolean ib() {
        return s.T(this.aiB) == 1;
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

    private void ic() {
        this.aiB.removeCallbacks(this.mHideRunnable);
    }

    private void bL(int i) {
        ic();
        this.aiB.postDelayed(this.mHideRunnable, (long) i);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
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
                if (ib()) {
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

    public final boolean h(MotionEvent motionEvent) {
        if (this.mState == 1) {
            boolean v = v(motionEvent.getX(), motionEvent.getY());
            boolean w = w(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0 || (!v && !w)) {
                return false;
            }
            if (w) {
                this.SG = 1;
                this.aiy = (float) ((int) motionEvent.getX());
            } else if (v) {
                this.SG = 2;
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

    public final void i(MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean v = v(motionEvent.getX(), motionEvent.getY());
                boolean w = w(motionEvent.getX(), motionEvent.getY());
                if (v || w) {
                    if (w) {
                        this.SG = 1;
                        this.aiy = (float) ((int) motionEvent.getX());
                    } else if (v) {
                        this.SG = 2;
                        this.aiv = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.aiv = 0.0f;
                this.aiy = 0.0f;
                setState(1);
                this.SG = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                float x;
                int[] iArr;
                float max;
                int a;
                show();
                if (this.SG == 1) {
                    x = motionEvent.getX();
                    this.aiF[0] = this.hz;
                    this.aiF[1] = this.aiz - this.hz;
                    iArr = this.aiF;
                    max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.aix) - max) >= 2.0f) {
                        a = a(this.aiy, max, iArr, this.aiB.computeHorizontalScrollRange(), this.aiB.computeHorizontalScrollOffset(), this.aiz);
                        if (a != 0) {
                            this.aiB.scrollBy(a, 0);
                        }
                        this.aiy = max;
                    }
                }
                if (this.SG == 2) {
                    x = motionEvent.getY();
                    this.aiE[0] = this.hz;
                    this.aiE[1] = this.aiA - this.hz;
                    iArr = this.aiE;
                    max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.aiu) - max) >= 2.0f) {
                        a = a(this.aiv, max, iArr, this.aiB.computeVerticalScrollRange(), this.aiB.computeVerticalScrollOffset(), this.aiA);
                        if (a != 0) {
                            this.aiB.scrollBy(0, a);
                        }
                        this.aiv = max;
                    }
                }
            }
        }
    }

    public final void ab(boolean z) {
    }

    private static int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
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

    private boolean v(float f, float f2) {
        if (ib() ? f <= ((float) (this.ain / 2)) : f >= ((float) (this.aiz - this.ain))) {
            if (f2 >= ((float) (this.aiu - (this.ait / 2))) && f2 <= ((float) (this.aiu + (this.ait / 2)))) {
                return true;
            }
        }
        return false;
    }

    private boolean w(float f, float f2) {
        return f2 >= ((float) (this.aiA - this.air)) && f >= ((float) (this.aix - (this.aiw / 2))) && f <= ((float) (this.aix + (this.aiw / 2)));
    }
}
