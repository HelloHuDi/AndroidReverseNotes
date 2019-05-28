package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwipeBackLayout extends FrameLayout {
    private static final int[] BTh = new int[]{1, 2, 8, 11};
    private int BTi;
    private a BTj;
    private CopyOnWriteArrayList<a> BTk;
    private Drawable BTl;
    private int BTm;
    private int Qa;
    private float Qb;
    private Drawable Qw;
    private Drawable Qx;
    private View WL;
    private boolean mEnable;
    private boolean mInLayout;
    private Rect oT;
    private float zOf;
    private int zOg;
    private int zOh;
    private float zOj;

    public interface a {
        boolean ba(boolean z);

        void h(int i, float f);

        void l(MotionEvent motionEvent);

        void xv();
    }

    class c extends me.imid.swipebacklayout.lib.a.a {
        private boolean BTn;

        private c() {
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        public final boolean PG(int i) {
            int i2 = 1;
            AppMethodBeat.i(91200);
            boolean iu = SwipeBackLayout.this.BTj.iu(SwipeBackLayout.this.BTi, i);
            if (iu) {
                if (SwipeBackLayout.this.BTj.iu(1, i)) {
                    SwipeBackLayout.this.BTm = 1;
                } else if (SwipeBackLayout.this.BTj.iu(2, i)) {
                    SwipeBackLayout.this.BTm = 2;
                } else if (SwipeBackLayout.this.BTj.iu(8, i)) {
                    SwipeBackLayout.this.BTm = 8;
                }
                if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                    Iterator it = SwipeBackLayout.this.BTk.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        SwipeBackLayout.this.BTm;
                        aVar.xv();
                    }
                }
                this.BTn = true;
            }
            if (SwipeBackLayout.this.BTi == 1 || SwipeBackLayout.this.BTi == 2) {
                i2 = !SwipeBackLayout.this.BTj.it(2, i) ? 1 : 0;
            } else if (SwipeBackLayout.this.BTi == 8) {
                if (SwipeBackLayout.this.BTj.it(1, i)) {
                    i2 = 0;
                }
            } else if (SwipeBackLayout.this.BTi != 11) {
                i2 = 0;
            }
            int i3 = iu & i2;
            AppMethodBeat.o(91200);
            return i3;
        }

        public final int dJm() {
            AppMethodBeat.i(91201);
            int a = SwipeBackLayout.this.BTi & 3;
            AppMethodBeat.o(91201);
            return a;
        }

        public final int bL() {
            AppMethodBeat.i(91202);
            int a = SwipeBackLayout.this.BTi & 8;
            AppMethodBeat.o(91202);
            return a;
        }

        public final void o(View view, int i, int i2, int i3, int i4) {
            Iterator it;
            AppMethodBeat.i(91203);
            super.o(view, i, i2, i3, i4);
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.WL.getWidth() + SwipeBackLayout.this.Qw.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.WL.getWidth() + SwipeBackLayout.this.Qx.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.BTm & 8) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.WL.getHeight() + SwipeBackLayout.this.BTl.getIntrinsicHeight())));
            }
            SwipeBackLayout.this.zOg = i;
            SwipeBackLayout.this.zOh = i2;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.zOj < SwipeBackLayout.this.zOf && !this.BTn) {
                this.BTn = true;
            }
            if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).h(SwipeBackLayout.this.BTj.SG, SwipeBackLayout.this.zOj);
                }
            }
            if (SwipeBackLayout.this.BTk != null && !SwipeBackLayout.this.BTk.isEmpty() && SwipeBackLayout.this.BTj.SG == 1 && SwipeBackLayout.this.zOj >= SwipeBackLayout.this.zOf && this.BTn) {
                this.BTn = false;
                Iterator it2 = SwipeBackLayout.this.BTk.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            if (!(SwipeBackLayout.this.zOj < 1.0f || SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar instanceof b) {
                        ((b) aVar).aJd();
                    }
                }
            }
            AppMethodBeat.o(91203);
        }

        public final void a(View view, float f, float f2) {
            int i;
            AppMethodBeat.i(91204);
            int width = view.getWidth();
            int height = view.getHeight();
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? (width + SwipeBackLayout.this.Qw.getIntrinsicWidth()) + 10 : 0;
                i = 0;
                height = width;
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                width = (f < 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? -((width + SwipeBackLayout.this.Qw.getIntrinsicWidth()) + 10) : 0;
                i = 0;
                height = width;
            } else if ((SwipeBackLayout.this.BTm & 8) != 0) {
                width = (f2 < 0.0f || (f2 == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? -((SwipeBackLayout.this.BTl.getIntrinsicHeight() + height) + 10) : 0;
                i = width;
                height = 0;
            } else {
                i = 0;
                height = 0;
            }
            if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                Iterator it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    if (((a) it.next()).ba(height != 0)) {
                        AppMethodBeat.o(91204);
                        return;
                    }
                }
            }
            a b = SwipeBackLayout.this.BTj;
            if (b.SV) {
                width = (int) b.mVelocityTracker.getXVelocity(b.mActivePointerId);
                int yVelocity = (int) b.mVelocityTracker.getYVelocity(b.mActivePointerId);
                int left = b.SU.getLeft();
                int top = b.SU.getTop();
                height -= left;
                i -= top;
                if (height == 0 && i == 0) {
                    b.jlU.qN.abortAnimation();
                    b.ba(0);
                } else {
                    int i2 = a.i(width, (int) b.SQ, (int) b.SP);
                    int i3 = a.i(yVelocity, (int) b.SQ, (int) b.SP);
                    width = Math.abs(height);
                    int abs = Math.abs(i);
                    yVelocity = Math.abs(i2);
                    int abs2 = Math.abs(i3);
                    int i4 = yVelocity + abs2;
                    int i5 = width + abs;
                    b.jlU.startScroll(left, top, height, i, (int) (((i3 != 0 ? ((float) abs2) / ((float) i4) : ((float) abs) / ((float) i5)) * ((float) b.h(i, i3, b.BTq.bL()))) + ((i2 != 0 ? ((float) yVelocity) / ((float) i4) : ((float) width) / ((float) i5)) * ((float) b.h(height, i2, b.BTq.dJm())))));
                    b.ba(2);
                }
                SwipeBackLayout.this.invalidate();
                AppMethodBeat.o(91204);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.o(91204);
            throw illegalStateException;
        }

        public final int d(View view, int i) {
            int i2 = 0;
            AppMethodBeat.i(91205);
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                i2 = Math.min(view.getWidth(), Math.max(i, 0));
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                i2 = Math.min(0, Math.max(i, -view.getWidth()));
            }
            AppMethodBeat.o(91205);
            return i2;
        }

        public final int c(View view, int i) {
            int i2 = 0;
            AppMethodBeat.i(91206);
            if ((SwipeBackLayout.this.BTm & 8) != 0) {
                i2 = Math.min(0, Math.max(i, -view.getHeight()));
            }
            AppMethodBeat.o(91206);
            return i2;
        }

        public final void N(int i) {
            AppMethodBeat.i(91207);
            super.N(i);
            if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                Iterator it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).h(i, SwipeBackLayout.this.zOj);
                }
            }
            AppMethodBeat.o(91207);
        }
    }

    public interface b extends a {
        void aJd();
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(91208);
        this.zOf = 0.3f;
        this.mEnable = true;
        this.Qa = -1728053248;
        this.oT = new Rect();
        this.BTj = a.a(this, new c(this, (byte) 0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.a.a.SwipeBackLayout, i, R.style.rr);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(BTh[obtainStyledAttributes.getInt(1, 0)]);
        dimensionPixelSize = obtainStyledAttributes.getResourceId(2, R.drawable.atq);
        int resourceId = obtainStyledAttributes.getResourceId(3, R.drawable.atr);
        int resourceId2 = obtainStyledAttributes.getResourceId(4, R.drawable.atp);
        is(dimensionPixelSize, 1);
        is(resourceId, 2);
        is(resourceId2, 8);
        obtainStyledAttributes.recycle();
        float f = getResources().getDisplayMetrics().density * 400.0f;
        this.BTj.SQ = f;
        this.BTj.SP = f * 2.0f;
        AppMethodBeat.o(91208);
    }

    public void setMinVelocity(float f) {
        this.BTj.SQ = f;
    }

    public void setMaxVelocity(float f) {
        this.BTj.SP = f;
    }

    public void setContentView(View view) {
        this.WL = view;
    }

    public View getTargetView() {
        return this.WL;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.BTi = i;
        this.BTj.SS = this.BTi;
    }

    public void setScrimColor(int i) {
        AppMethodBeat.i(91209);
        this.Qa = i;
        invalidate();
        AppMethodBeat.o(91209);
    }

    public void setEdgeSize(int i) {
        this.BTj.SR = i;
    }

    @Deprecated
    public void setSwipeListener(a aVar) {
        AppMethodBeat.i(91210);
        a(aVar);
        AppMethodBeat.o(91210);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(91211);
        if (this.BTk == null) {
            this.BTk = new CopyOnWriteArrayList();
        }
        this.BTk.add(aVar);
        AppMethodBeat.o(91211);
    }

    public void setScrollThresHold(float f) {
        AppMethodBeat.i(91212);
        if (f >= 1.0f || f <= 0.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Threshold value should be between 0 and 1.0");
            AppMethodBeat.o(91212);
            throw illegalArgumentException;
        }
        this.zOf = f;
        AppMethodBeat.o(91212);
    }

    private void f(Drawable drawable, int i) {
        AppMethodBeat.i(91213);
        if ((i & 1) != 0) {
            this.Qw = drawable;
        } else if ((i & 2) != 0) {
            this.Qx = drawable;
        } else if ((i & 8) != 0) {
            this.BTl = drawable;
        }
        invalidate();
        AppMethodBeat.o(91213);
    }

    private void is(int i, int i2) {
        AppMethodBeat.i(91214);
        f(getResources().getDrawable(i), i2);
        AppMethodBeat.o(91214);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(91215);
        if (this.mEnable) {
            if (!(this.BTk == null || this.BTk.isEmpty())) {
                Iterator it = this.BTk.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).l(motionEvent);
                }
            }
            if (this.BTj.SG == 1) {
                this.BTj.g(motionEvent);
                AppMethodBeat.o(91215);
                return true;
            }
            try {
                Object obj;
                a aVar = this.BTj;
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    aVar.cancel();
                }
                if (aVar.mVelocityTracker == null) {
                    aVar.mVelocityTracker = VelocityTracker.obtain();
                }
                aVar.mVelocityTracker.addMovement(motionEvent);
                float y;
                int pointerId;
                switch (actionMasked) {
                    case 0:
                        float x = motionEvent.getX();
                        y = motionEvent.getY();
                        pointerId = motionEvent.getPointerId(0);
                        aVar.a(x, y, pointerId);
                        View F = aVar.F((int) x, (int) y);
                        if (F == aVar.SU && aVar.SG == 2) {
                            aVar.v(F, pointerId);
                        }
                        if ((aVar.BTp[pointerId] & aVar.SS) != 0) {
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        aVar.cancel();
                        break;
                    case 2:
                        actionIndex = motionEvent.getPointerCount();
                        actionMasked = 0;
                        while (actionMasked < actionIndex) {
                            pointerId = motionEvent.getPointerId(actionMasked);
                            float x2 = motionEvent.getX(actionMasked);
                            float y2 = motionEvent.getY(actionMasked);
                            float f = x2 - aVar.SH[pointerId];
                            float f2 = y2 - aVar.SI[pointerId];
                            aVar.b(f, f2, pointerId);
                            if (aVar.SG != 1) {
                                View F2 = aVar.F((int) x2, (int) y2);
                                if (F2 == null || !aVar.c(F2, f, f2) || !aVar.v(F2, pointerId)) {
                                    actionMasked++;
                                }
                            }
                            aVar.e(motionEvent);
                            break;
                        }
                        aVar.e(motionEvent);
                        break;
                    case 5:
                        actionMasked = motionEvent.getPointerId(actionIndex);
                        float x3 = motionEvent.getX(actionIndex);
                        y = motionEvent.getY(actionIndex);
                        aVar.a(x3, y, actionMasked);
                        if (aVar.SG != 0 && aVar.SG == 2) {
                            View F3 = aVar.F((int) x3, (int) y);
                            if (F3 == aVar.SU) {
                                aVar.v(F3, actionMasked);
                                break;
                            }
                        }
                        break;
                    case 6:
                        aVar.aY(motionEvent.getPointerId(actionIndex));
                        break;
                }
                if (aVar.SG == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    motionEvent.setAction(3);
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(91215);
                    return true;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(91215);
                return true;
            } catch (NullPointerException e) {
                AppMethodBeat.o(91215);
                return false;
            } catch (IllegalArgumentException e2) {
                AppMethodBeat.o(91215);
                return false;
            } catch (ArrayIndexOutOfBoundsException e3) {
                AppMethodBeat.o(91215);
                return false;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(91215);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(91216);
        if (this.mEnable) {
            this.BTj.g(motionEvent);
            AppMethodBeat.o(91216);
            return true;
        }
        AppMethodBeat.o(91216);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(91217);
        this.mInLayout = true;
        if (this.WL != null) {
            this.WL.layout(this.zOg, this.zOh, this.zOg + this.WL.getMeasuredWidth(), this.zOh + this.WL.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.o(91217);
    }

    public void requestLayout() {
        AppMethodBeat.i(91218);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.o(91218);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.i(91219);
        int i = view == this.WL ? 1 : 0;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(this.Qb <= 0.0f || i == 0 || this.BTj.SG == 0)) {
            Rect rect = this.oT;
            view.getHitRect(rect);
            if ((this.BTi & 1) != 0) {
                this.Qw.setBounds(rect.left - this.Qw.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.Qw.setAlpha((int) (this.Qb * 255.0f));
                this.Qw.draw(canvas);
            }
            if ((this.BTi & 2) != 0) {
                this.Qx.setBounds(rect.right, rect.top, rect.right + this.Qx.getIntrinsicWidth(), rect.bottom);
                this.Qx.setAlpha((int) (this.Qb * 255.0f));
                this.Qx.draw(canvas);
            }
            if ((this.BTi & 8) != 0) {
                this.BTl.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.BTl.getIntrinsicHeight());
                this.BTl.setAlpha((int) (this.Qb * 255.0f));
                this.BTl.draw(canvas);
            }
            i = (((int) (((float) ((this.Qa & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.Qb)) << 24) | (this.Qa & 16777215);
            if ((this.BTm & 1) != 0) {
                canvas.clipRect(0, 0, view.getLeft(), getHeight());
            } else if ((this.BTm & 2) != 0) {
                canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
            } else if ((this.BTm & 8) != 0) {
                canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
            }
            canvas.drawColor(i);
        }
        AppMethodBeat.o(91219);
        return drawChild;
    }

    public void computeScroll() {
        Object obj;
        AppMethodBeat.i(91220);
        this.Qb = 1.0f - this.zOj;
        a aVar = this.BTj;
        if (aVar.SG == 2) {
            boolean isFinished;
            boolean computeScrollOffset = aVar.jlU.qN.computeScrollOffset();
            int currX = aVar.jlU.qN.getCurrX();
            int currY = aVar.jlU.qN.getCurrY();
            int left = currX - aVar.SU.getLeft();
            int top = currY - aVar.SU.getTop();
            if (left != 0) {
                aVar.SU.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.SU.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.BTq.o(aVar.SU, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == aVar.jlU.qN.getFinalX() && currY == aVar.jlU.qN.getFinalY()) {
                aVar.jlU.qN.abortAnimation();
                isFinished = aVar.jlU.qN.isFinished();
            } else {
                isFinished = computeScrollOffset;
            }
            if (!isFinished) {
                aVar.SW.post(aVar.SX);
            }
        }
        if (aVar.SG == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            s.R(this);
        }
        AppMethodBeat.o(91220);
    }
}
