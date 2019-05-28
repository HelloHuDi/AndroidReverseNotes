package android.support.p057v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.c */
public final class C37130c {
    /* renamed from: LI */
    private final C37131a f15803LI;

    /* renamed from: android.support.v4.view.c$b */
    static class C37128b implements C37131a {
        /* renamed from: LN */
        private static final int f15780LN = ViewConfiguration.getLongPressTimeout();
        /* renamed from: LO */
        private static final int f15781LO = ViewConfiguration.getTapTimeout();
        /* renamed from: LP */
        private static final int f15782LP = ViewConfiguration.getDoubleTapTimeout();
        /* renamed from: LJ */
        private int f15783LJ;
        /* renamed from: LK */
        private int f15784LK;
        /* renamed from: LL */
        private int f15785LL;
        /* renamed from: LM */
        private int f15786LM;
        /* renamed from: LQ */
        final OnGestureListener f15787LQ;
        /* renamed from: LR */
        OnDoubleTapListener f15788LR;
        /* renamed from: LS */
        boolean f15789LS;
        /* renamed from: LU */
        boolean f15790LU;
        /* renamed from: LV */
        boolean f15791LV;
        /* renamed from: LW */
        private boolean f15792LW;
        /* renamed from: LX */
        private boolean f15793LX;
        /* renamed from: LY */
        MotionEvent f15794LY;
        /* renamed from: LZ */
        private MotionEvent f15795LZ;
        /* renamed from: Ma */
        private boolean f15796Ma;
        /* renamed from: Mb */
        private float f15797Mb;
        /* renamed from: Mc */
        private float f15798Mc;
        /* renamed from: Md */
        private float f15799Md;
        /* renamed from: Me */
        private float f15800Me;
        /* renamed from: Mf */
        private boolean f15801Mf;
        final Handler mHandler = new C37129a();
        private VelocityTracker mVelocityTracker;

        /* renamed from: android.support.v4.view.c$b$a */
        class C37129a extends Handler {
            C37129a() {
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C37128b.this.f15787LQ.onShowPress(C37128b.this.f15794LY);
                        return;
                    case 2:
                        C37128b c37128b = C37128b.this;
                        c37128b.mHandler.removeMessages(3);
                        c37128b.f15790LU = false;
                        c37128b.f15791LV = true;
                        c37128b.f15787LQ.onLongPress(c37128b.f15794LY);
                        return;
                    case 3:
                        if (C37128b.this.f15788LR == null) {
                            return;
                        }
                        if (C37128b.this.f15789LS) {
                            C37128b.this.f15790LU = true;
                            return;
                        } else {
                            C37128b.this.f15788LR.onSingleTapConfirmed(C37128b.this.f15794LY);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
                }
            }
        }

        C37128b(Context context, OnGestureListener onGestureListener) {
            this.f15787LQ = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                this.f15788LR = (OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f15787LQ == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.f15801Mf = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f15785LL = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f15786LM = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f15783LJ = scaledTouchSlop * scaledTouchSlop;
                this.f15784LK = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0133  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x014c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            int i;
            int i2;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if ((action & 255) == 6) {
                i = 1;
            } else {
                boolean i3 = false;
            }
            int actionIndex = i3 != 0 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f2 += motionEvent.getX(i2);
                    f += motionEvent.getY(i2);
                }
            }
            actionIndex = i3 != 0 ? pointerCount - 1 : pointerCount;
            f2 /= (float) actionIndex;
            f /= (float) actionIndex;
            boolean hasMessages;
            float yVelocity;
            float xVelocity;
            switch (action & 255) {
                case 0:
                    if (this.f15788LR != null) {
                        hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        if (!(this.f15794LY == null || this.f15795LZ == null || !hasMessages)) {
                            MotionEvent motionEvent2 = this.f15794LY;
                            MotionEvent motionEvent3 = this.f15795LZ;
                            if (this.f15793LX && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) f15782LP)) {
                                pointerCount = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                                actionIndex = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                                if ((actionIndex * actionIndex) + (pointerCount * pointerCount) < this.f15784LK) {
                                    actionIndex = 1;
                                    if (actionIndex != 0) {
                                        this.f15796Ma = true;
                                        actionIndex = (this.f15788LR.onDoubleTap(this.f15794LY) | 0) | this.f15788LR.onDoubleTapEvent(motionEvent);
                                        this.f15797Mb = f2;
                                        this.f15799Md = f2;
                                        this.f15798Mc = f;
                                        this.f15800Me = f;
                                        if (this.f15794LY != null) {
                                            this.f15794LY.recycle();
                                        }
                                        this.f15794LY = MotionEvent.obtain(motionEvent);
                                        this.f15792LW = true;
                                        this.f15793LX = true;
                                        this.f15789LS = true;
                                        this.f15791LV = false;
                                        this.f15790LU = false;
                                        if (this.f15801Mf) {
                                            this.mHandler.removeMessages(2);
                                            this.mHandler.sendEmptyMessageAtTime(2, (this.f15794LY.getDownTime() + ((long) f15781LO)) + ((long) f15780LN));
                                        }
                                        this.mHandler.sendEmptyMessageAtTime(1, this.f15794LY.getDownTime() + ((long) f15781LO));
                                        return actionIndex | this.f15787LQ.onDown(motionEvent);
                                    }
                                }
                            }
                            hasMessages = false;
                            if (actionIndex != 0) {
                            }
                        }
                        this.mHandler.sendEmptyMessageDelayed(3, (long) f15782LP);
                    }
                    actionIndex = 0;
                    this.f15797Mb = f2;
                    this.f15799Md = f2;
                    this.f15798Mc = f;
                    this.f15800Me = f;
                    if (this.f15794LY != null) {
                    }
                    this.f15794LY = MotionEvent.obtain(motionEvent);
                    this.f15792LW = true;
                    this.f15793LX = true;
                    this.f15789LS = true;
                    this.f15791LV = false;
                    this.f15790LU = false;
                    if (this.f15801Mf) {
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.f15794LY.getDownTime() + ((long) f15781LO));
                    return actionIndex | this.f15787LQ.onDown(motionEvent);
                case 1:
                    this.f15789LS = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.f15796Ma) {
                        hasMessages = this.f15788LR.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.f15791LV) {
                        this.mHandler.removeMessages(3);
                        this.f15791LV = false;
                        hasMessages = false;
                    } else if (this.f15792LW) {
                        hasMessages = this.f15787LQ.onSingleTapUp(motionEvent);
                        if (this.f15790LU && this.f15788LR != null) {
                            this.f15788LR.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.f15786LM);
                        yVelocity = velocityTracker.getYVelocity(pointerId);
                        xVelocity = velocityTracker.getXVelocity(pointerId);
                        hasMessages = (Math.abs(yVelocity) > ((float) this.f15785LL) || Math.abs(xVelocity) > ((float) this.f15785LL)) ? this.f15787LQ.onFling(this.f15794LY, motionEvent, xVelocity, yVelocity) : false;
                    }
                    if (this.f15795LZ != null) {
                        this.f15795LZ.recycle();
                    }
                    this.f15795LZ = obtain;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.f15796Ma = false;
                    this.f15790LU = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    return hasMessages;
                case 2:
                    if (this.f15791LV) {
                        return false;
                    }
                    xVelocity = this.f15797Mb - f2;
                    yVelocity = this.f15798Mc - f;
                    if (this.f15796Ma) {
                        return this.f15788LR.onDoubleTapEvent(motionEvent) | 0;
                    }
                    if (this.f15792LW) {
                        i2 = (int) (f2 - this.f15799Md);
                        int i4 = (int) (f - this.f15800Me);
                        i2 = (i2 * i2) + (i4 * i4);
                        if (i2 > this.f15783LJ) {
                            hasMessages = this.f15787LQ.onScroll(this.f15794LY, motionEvent, xVelocity, yVelocity);
                            this.f15797Mb = f2;
                            this.f15798Mc = f;
                            this.f15792LW = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i2 > this.f15783LJ) {
                            this.f15793LX = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(xVelocity) < 1.0f && Math.abs(yVelocity) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f15787LQ.onScroll(this.f15794LY, motionEvent, xVelocity, yVelocity);
                        this.f15797Mb = f2;
                        this.f15798Mc = f;
                        return onScroll;
                    }
                case 3:
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.f15796Ma = false;
                    this.f15789LS = false;
                    this.f15792LW = false;
                    this.f15793LX = false;
                    this.f15790LU = false;
                    if (!this.f15791LV) {
                        return false;
                    }
                    this.f15791LV = false;
                    return false;
                case 5:
                    this.f15797Mb = f2;
                    this.f15799Md = f2;
                    this.f15798Mc = f;
                    this.f15800Me = f;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.f15796Ma = false;
                    this.f15792LW = false;
                    this.f15793LX = false;
                    this.f15790LU = false;
                    if (!this.f15791LV) {
                        return false;
                    }
                    this.f15791LV = false;
                    return false;
                case 6:
                    this.f15797Mb = f2;
                    this.f15799Md = f2;
                    this.f15798Mc = f;
                    this.f15800Me = f;
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.f15786LM);
                    int actionIndex2 = motionEvent.getActionIndex();
                    actionIndex = motionEvent.getPointerId(actionIndex2);
                    f2 = this.mVelocityTracker.getXVelocity(actionIndex);
                    float yVelocity2 = this.mVelocityTracker.getYVelocity(actionIndex);
                    for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                        if (actionIndex != actionIndex2) {
                            i2 = motionEvent.getPointerId(actionIndex);
                            if ((this.mVelocityTracker.getYVelocity(i2) * yVelocity2) + (this.mVelocityTracker.getXVelocity(i2) * f2) < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.c$a */
    interface C37131a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* renamed from: android.support.v4.view.c$c */
    static class C37132c implements C37131a {
        /* renamed from: Mh */
        private final GestureDetector f15804Mh;

        C37132c(Context context, OnGestureListener onGestureListener) {
            this.f15804Mh = new GestureDetector(context, onGestureListener, null);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f15804Mh.onTouchEvent(motionEvent);
        }
    }

    public C37130c(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private C37130c(Context context, OnGestureListener onGestureListener, byte b) {
        if (VERSION.SDK_INT > 17) {
            this.f15803LI = new C37132c(context, onGestureListener);
        } else {
            this.f15803LI = new C37128b(context, onGestureListener);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f15803LI.onTouchEvent(motionEvent);
    }
}
