package android.support.v4.view;

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

public final class c {
    private final a LI;

    static class b implements a {
        private static final int LN = ViewConfiguration.getLongPressTimeout();
        private static final int LO = ViewConfiguration.getTapTimeout();
        private static final int LP = ViewConfiguration.getDoubleTapTimeout();
        private int LJ;
        private int LK;
        private int LL;
        private int LM;
        final OnGestureListener LQ;
        OnDoubleTapListener LR;
        boolean LS;
        boolean LU;
        boolean LV;
        private boolean LW;
        private boolean LX;
        MotionEvent LY;
        private MotionEvent LZ;
        private boolean Ma;
        private float Mb;
        private float Mc;
        private float Md;
        private float Me;
        private boolean Mf;
        final Handler mHandler = new a();
        private VelocityTracker mVelocityTracker;

        class a extends Handler {
            a() {
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.LQ.onShowPress(b.this.LY);
                        return;
                    case 2:
                        b bVar = b.this;
                        bVar.mHandler.removeMessages(3);
                        bVar.LU = false;
                        bVar.LV = true;
                        bVar.LQ.onLongPress(bVar.LY);
                        return;
                    case 3:
                        if (b.this.LR == null) {
                            return;
                        }
                        if (b.this.LS) {
                            b.this.LU = true;
                            return;
                        } else {
                            b.this.LR.onSingleTapConfirmed(b.this.LY);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
                }
            }
        }

        b(Context context, OnGestureListener onGestureListener) {
            this.LQ = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                this.LR = (OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.LQ == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.Mf = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.LL = viewConfiguration.getScaledMinimumFlingVelocity();
                this.LM = viewConfiguration.getScaledMaximumFlingVelocity();
                this.LJ = scaledTouchSlop * scaledTouchSlop;
                this.LK = scaledDoubleTapSlop * scaledDoubleTapSlop;
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
                    if (this.LR != null) {
                        hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        if (!(this.LY == null || this.LZ == null || !hasMessages)) {
                            MotionEvent motionEvent2 = this.LY;
                            MotionEvent motionEvent3 = this.LZ;
                            if (this.LX && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) LP)) {
                                pointerCount = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                                actionIndex = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                                if ((actionIndex * actionIndex) + (pointerCount * pointerCount) < this.LK) {
                                    actionIndex = 1;
                                    if (actionIndex != 0) {
                                        this.Ma = true;
                                        actionIndex = (this.LR.onDoubleTap(this.LY) | 0) | this.LR.onDoubleTapEvent(motionEvent);
                                        this.Mb = f2;
                                        this.Md = f2;
                                        this.Mc = f;
                                        this.Me = f;
                                        if (this.LY != null) {
                                            this.LY.recycle();
                                        }
                                        this.LY = MotionEvent.obtain(motionEvent);
                                        this.LW = true;
                                        this.LX = true;
                                        this.LS = true;
                                        this.LV = false;
                                        this.LU = false;
                                        if (this.Mf) {
                                            this.mHandler.removeMessages(2);
                                            this.mHandler.sendEmptyMessageAtTime(2, (this.LY.getDownTime() + ((long) LO)) + ((long) LN));
                                        }
                                        this.mHandler.sendEmptyMessageAtTime(1, this.LY.getDownTime() + ((long) LO));
                                        return actionIndex | this.LQ.onDown(motionEvent);
                                    }
                                }
                            }
                            hasMessages = false;
                            if (actionIndex != 0) {
                            }
                        }
                        this.mHandler.sendEmptyMessageDelayed(3, (long) LP);
                    }
                    actionIndex = 0;
                    this.Mb = f2;
                    this.Md = f2;
                    this.Mc = f;
                    this.Me = f;
                    if (this.LY != null) {
                    }
                    this.LY = MotionEvent.obtain(motionEvent);
                    this.LW = true;
                    this.LX = true;
                    this.LS = true;
                    this.LV = false;
                    this.LU = false;
                    if (this.Mf) {
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.LY.getDownTime() + ((long) LO));
                    return actionIndex | this.LQ.onDown(motionEvent);
                case 1:
                    this.LS = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.Ma) {
                        hasMessages = this.LR.onDoubleTapEvent(motionEvent) | 0;
                    } else if (this.LV) {
                        this.mHandler.removeMessages(3);
                        this.LV = false;
                        hasMessages = false;
                    } else if (this.LW) {
                        hasMessages = this.LQ.onSingleTapUp(motionEvent);
                        if (this.LU && this.LR != null) {
                            this.LR.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, (float) this.LM);
                        yVelocity = velocityTracker.getYVelocity(pointerId);
                        xVelocity = velocityTracker.getXVelocity(pointerId);
                        hasMessages = (Math.abs(yVelocity) > ((float) this.LL) || Math.abs(xVelocity) > ((float) this.LL)) ? this.LQ.onFling(this.LY, motionEvent, xVelocity, yVelocity) : false;
                    }
                    if (this.LZ != null) {
                        this.LZ.recycle();
                    }
                    this.LZ = obtain;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.Ma = false;
                    this.LU = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    return hasMessages;
                case 2:
                    if (this.LV) {
                        return false;
                    }
                    xVelocity = this.Mb - f2;
                    yVelocity = this.Mc - f;
                    if (this.Ma) {
                        return this.LR.onDoubleTapEvent(motionEvent) | 0;
                    }
                    if (this.LW) {
                        i2 = (int) (f2 - this.Md);
                        int i4 = (int) (f - this.Me);
                        i2 = (i2 * i2) + (i4 * i4);
                        if (i2 > this.LJ) {
                            hasMessages = this.LQ.onScroll(this.LY, motionEvent, xVelocity, yVelocity);
                            this.Mb = f2;
                            this.Mc = f;
                            this.LW = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            hasMessages = false;
                        }
                        if (i2 > this.LJ) {
                            this.LX = false;
                        }
                        return hasMessages;
                    } else if (Math.abs(xVelocity) < 1.0f && Math.abs(yVelocity) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.LQ.onScroll(this.LY, motionEvent, xVelocity, yVelocity);
                        this.Mb = f2;
                        this.Mc = f;
                        return onScroll;
                    }
                case 3:
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    this.Ma = false;
                    this.LS = false;
                    this.LW = false;
                    this.LX = false;
                    this.LU = false;
                    if (!this.LV) {
                        return false;
                    }
                    this.LV = false;
                    return false;
                case 5:
                    this.Mb = f2;
                    this.Md = f2;
                    this.Mc = f;
                    this.Me = f;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    this.mHandler.removeMessages(3);
                    this.Ma = false;
                    this.LW = false;
                    this.LX = false;
                    this.LU = false;
                    if (!this.LV) {
                        return false;
                    }
                    this.LV = false;
                    return false;
                case 6:
                    this.Mb = f2;
                    this.Md = f2;
                    this.Mc = f;
                    this.Me = f;
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.LM);
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

    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    static class c implements a {
        private final GestureDetector Mh;

        c(Context context, OnGestureListener onGestureListener) {
            this.Mh = new GestureDetector(context, onGestureListener, null);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return this.Mh.onTouchEvent(motionEvent);
        }
    }

    public c(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private c(Context context, OnGestureListener onGestureListener, byte b) {
        if (VERSION.SDK_INT > 17) {
            this.LI = new c(context, onGestureListener);
        } else {
            this.LI = new b(context, onGestureListener);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.LI.onTouchEvent(motionEvent);
    }
}
