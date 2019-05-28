package p1358me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.C45117a.C32176a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p1358me.imid.swipebacklayout.lib.C31199a.C31198a;

/* renamed from: me.imid.swipebacklayout.lib.SwipeBackLayout */
public class SwipeBackLayout extends FrameLayout {
    private static final int[] BTh = new int[]{1, 2, 8, 11};
    private int BTi;
    private C31199a BTj;
    private CopyOnWriteArrayList<C24597a> BTk;
    private Drawable BTl;
    private int BTm;
    /* renamed from: Qa */
    private int f16577Qa;
    /* renamed from: Qb */
    private float f16578Qb;
    /* renamed from: Qw */
    private Drawable f16579Qw;
    /* renamed from: Qx */
    private Drawable f16580Qx;
    /* renamed from: WL */
    private View f16581WL;
    private boolean mEnable;
    private boolean mInLayout;
    /* renamed from: oT */
    private Rect f16582oT;
    private float zOf;
    private int zOg;
    private int zOh;
    private float zOj;

    /* renamed from: me.imid.swipebacklayout.lib.SwipeBackLayout$a */
    public interface C24597a {
        /* renamed from: ba */
        boolean mo3955ba(boolean z);

        /* renamed from: h */
        void mo3956h(int i, float f);

        /* renamed from: l */
        void mo3957l(MotionEvent motionEvent);

        /* renamed from: xv */
        void mo3958xv();
    }

    /* renamed from: me.imid.swipebacklayout.lib.SwipeBackLayout$c */
    class C24598c extends C31198a {
        private boolean BTn;

        private C24598c() {
        }

        /* synthetic */ C24598c(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        /* renamed from: PG */
        public final boolean mo41389PG(int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(91200);
            boolean iu = SwipeBackLayout.this.BTj.mo50980iu(SwipeBackLayout.this.BTi, i);
            if (iu) {
                if (SwipeBackLayout.this.BTj.mo50980iu(1, i)) {
                    SwipeBackLayout.this.BTm = 1;
                } else if (SwipeBackLayout.this.BTj.mo50980iu(2, i)) {
                    SwipeBackLayout.this.BTm = 2;
                } else if (SwipeBackLayout.this.BTj.mo50980iu(8, i)) {
                    SwipeBackLayout.this.BTm = 8;
                }
                if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                    Iterator it = SwipeBackLayout.this.BTk.iterator();
                    while (it.hasNext()) {
                        C24597a c24597a = (C24597a) it.next();
                        SwipeBackLayout.this.BTm;
                        c24597a.mo3958xv();
                    }
                }
                this.BTn = true;
            }
            if (SwipeBackLayout.this.BTi == 1 || SwipeBackLayout.this.BTi == 2) {
                i2 = !SwipeBackLayout.this.BTj.mo50979it(2, i) ? 1 : 0;
            } else if (SwipeBackLayout.this.BTi == 8) {
                if (SwipeBackLayout.this.BTj.mo50979it(1, i)) {
                    i2 = 0;
                }
            } else if (SwipeBackLayout.this.BTi != 11) {
                i2 = 0;
            }
            int i3 = iu & i2;
            AppMethodBeat.m2505o(91200);
            return i3;
        }

        public final int dJm() {
            AppMethodBeat.m2504i(91201);
            int a = SwipeBackLayout.this.BTi & 3;
            AppMethodBeat.m2505o(91201);
            return a;
        }

        /* renamed from: bL */
        public final int mo41391bL() {
            AppMethodBeat.m2504i(91202);
            int a = SwipeBackLayout.this.BTi & 8;
            AppMethodBeat.m2505o(91202);
            return a;
        }

        /* renamed from: o */
        public final void mo41395o(View view, int i, int i2, int i3, int i4) {
            Iterator it;
            AppMethodBeat.m2504i(91203);
            super.mo41395o(view, i, i2, i3, i4);
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.f16581WL.getWidth() + SwipeBackLayout.this.f16579Qw.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.f16581WL.getWidth() + SwipeBackLayout.this.f16580Qx.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.BTm & 8) != 0) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.f16581WL.getHeight() + SwipeBackLayout.this.BTl.getIntrinsicHeight())));
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
                    ((C24597a) it.next()).mo3956h(SwipeBackLayout.this.BTj.f14346SG, SwipeBackLayout.this.zOj);
                }
            }
            if (SwipeBackLayout.this.BTk != null && !SwipeBackLayout.this.BTk.isEmpty() && SwipeBackLayout.this.BTj.f14346SG == 1 && SwipeBackLayout.this.zOj >= SwipeBackLayout.this.zOf && this.BTn) {
                this.BTn = false;
                Iterator it2 = SwipeBackLayout.this.BTk.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            if (!(SwipeBackLayout.this.zOj < 1.0f || SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    C24597a c24597a = (C24597a) it.next();
                    if (c24597a instanceof C25025b) {
                        ((C25025b) c24597a).aJd();
                    }
                }
            }
            AppMethodBeat.m2505o(91203);
        }

        /* renamed from: a */
        public final void mo41390a(View view, float f, float f2) {
            int i;
            AppMethodBeat.m2504i(91204);
            int width = view.getWidth();
            int height = view.getHeight();
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? (width + SwipeBackLayout.this.f16579Qw.getIntrinsicWidth()) + 10 : 0;
                i = 0;
                height = width;
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                width = (f < 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? -((width + SwipeBackLayout.this.f16579Qw.getIntrinsicWidth()) + 10) : 0;
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
                    if (((C24597a) it.next()).mo3955ba(height != 0)) {
                        AppMethodBeat.m2505o(91204);
                        return;
                    }
                }
            }
            C31199a b = SwipeBackLayout.this.BTj;
            if (b.f14359SV) {
                width = (int) b.mVelocityTracker.getXVelocity(b.mActivePointerId);
                int yVelocity = (int) b.mVelocityTracker.getYVelocity(b.mActivePointerId);
                int left = b.f14358SU.getLeft();
                int top = b.f14358SU.getTop();
                height -= left;
                i -= top;
                if (height == 0 && i == 0) {
                    b.jlU.f710qN.abortAnimation();
                    b.mo50973ba(0);
                } else {
                    int i2 = C31199a.m50307i(width, (int) b.f14355SQ, (int) b.f14354SP);
                    int i3 = C31199a.m50307i(yVelocity, (int) b.f14355SQ, (int) b.f14354SP);
                    width = Math.abs(height);
                    int abs = Math.abs(i);
                    yVelocity = Math.abs(i2);
                    int abs2 = Math.abs(i3);
                    int i4 = yVelocity + abs2;
                    int i5 = width + abs;
                    b.jlU.startScroll(left, top, height, i, (int) (((i3 != 0 ? ((float) abs2) / ((float) i4) : ((float) abs) / ((float) i5)) * ((float) b.mo50978h(i, i3, b.BTq.mo41391bL()))) + ((i2 != 0 ? ((float) yVelocity) / ((float) i4) : ((float) width) / ((float) i5)) * ((float) b.mo50978h(height, i2, b.BTq.dJm())))));
                    b.mo50973ba(2);
                }
                SwipeBackLayout.this.invalidate();
                AppMethodBeat.m2505o(91204);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.m2505o(91204);
            throw illegalStateException;
        }

        /* renamed from: d */
        public final int mo41393d(View view, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(91205);
            if ((SwipeBackLayout.this.BTm & 1) != 0) {
                i2 = Math.min(view.getWidth(), Math.max(i, 0));
            } else if ((SwipeBackLayout.this.BTm & 2) != 0) {
                i2 = Math.min(0, Math.max(i, -view.getWidth()));
            }
            AppMethodBeat.m2505o(91205);
            return i2;
        }

        /* renamed from: c */
        public final int mo41392c(View view, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(91206);
            if ((SwipeBackLayout.this.BTm & 8) != 0) {
                i2 = Math.min(0, Math.max(i, -view.getHeight()));
            }
            AppMethodBeat.m2505o(91206);
            return i2;
        }

        /* renamed from: N */
        public final void mo41388N(int i) {
            AppMethodBeat.m2504i(91207);
            super.mo41388N(i);
            if (!(SwipeBackLayout.this.BTk == null || SwipeBackLayout.this.BTk.isEmpty())) {
                Iterator it = SwipeBackLayout.this.BTk.iterator();
                while (it.hasNext()) {
                    ((C24597a) it.next()).mo3956h(i, SwipeBackLayout.this.zOj);
                }
            }
            AppMethodBeat.m2505o(91207);
        }
    }

    /* renamed from: me.imid.swipebacklayout.lib.SwipeBackLayout$b */
    public interface C25025b extends C24597a {
        void aJd();
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5463a);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91208);
        this.zOf = 0.3f;
        this.mEnable = true;
        this.f16577Qa = -1728053248;
        this.f16582oT = new Rect();
        this.BTj = C31199a.m50301a(this, new C24598c(this, (byte) 0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C32176a.SwipeBackLayout, i, C25738R.style.f11179rr);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(BTh[obtainStyledAttributes.getInt(1, 0)]);
        dimensionPixelSize = obtainStyledAttributes.getResourceId(2, C25738R.drawable.atq);
        int resourceId = obtainStyledAttributes.getResourceId(3, C25738R.drawable.atr);
        int resourceId2 = obtainStyledAttributes.getResourceId(4, C25738R.drawable.atp);
        m71609is(dimensionPixelSize, 1);
        m71609is(resourceId, 2);
        m71609is(resourceId2, 8);
        obtainStyledAttributes.recycle();
        float f = getResources().getDisplayMetrics().density * 400.0f;
        this.BTj.f14355SQ = f;
        this.BTj.f14354SP = f * 2.0f;
        AppMethodBeat.m2505o(91208);
    }

    public void setMinVelocity(float f) {
        this.BTj.f14355SQ = f;
    }

    public void setMaxVelocity(float f) {
        this.BTj.f14354SP = f;
    }

    public void setContentView(View view) {
        this.f16581WL = view;
    }

    public View getTargetView() {
        return this.f16581WL;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.BTi = i;
        this.BTj.f14357SS = this.BTi;
    }

    public void setScrimColor(int i) {
        AppMethodBeat.m2504i(91209);
        this.f16577Qa = i;
        invalidate();
        AppMethodBeat.m2505o(91209);
    }

    public void setEdgeSize(int i) {
        this.BTj.f14356SR = i;
    }

    @Deprecated
    public void setSwipeListener(C24597a c24597a) {
        AppMethodBeat.m2504i(91210);
        mo65734a(c24597a);
        AppMethodBeat.m2505o(91210);
    }

    /* renamed from: a */
    public final void mo65734a(C24597a c24597a) {
        AppMethodBeat.m2504i(91211);
        if (this.BTk == null) {
            this.BTk = new CopyOnWriteArrayList();
        }
        this.BTk.add(c24597a);
        AppMethodBeat.m2505o(91211);
    }

    public void setScrollThresHold(float f) {
        AppMethodBeat.m2504i(91212);
        if (f >= 1.0f || f <= 0.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Threshold value should be between 0 and 1.0");
            AppMethodBeat.m2505o(91212);
            throw illegalArgumentException;
        }
        this.zOf = f;
        AppMethodBeat.m2505o(91212);
    }

    /* renamed from: f */
    private void m71605f(Drawable drawable, int i) {
        AppMethodBeat.m2504i(91213);
        if ((i & 1) != 0) {
            this.f16579Qw = drawable;
        } else if ((i & 2) != 0) {
            this.f16580Qx = drawable;
        } else if ((i & 8) != 0) {
            this.BTl = drawable;
        }
        invalidate();
        AppMethodBeat.m2505o(91213);
    }

    /* renamed from: is */
    private void m71609is(int i, int i2) {
        AppMethodBeat.m2504i(91214);
        m71605f(getResources().getDrawable(i), i2);
        AppMethodBeat.m2505o(91214);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(91215);
        if (this.mEnable) {
            if (!(this.BTk == null || this.BTk.isEmpty())) {
                Iterator it = this.BTk.iterator();
                while (it.hasNext()) {
                    ((C24597a) it.next()).mo3957l(motionEvent);
                }
            }
            if (this.BTj.f14346SG == 1) {
                this.BTj.mo50977g(motionEvent);
                AppMethodBeat.m2505o(91215);
                return true;
            }
            try {
                Object obj;
                C31199a c31199a = this.BTj;
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    c31199a.cancel();
                }
                if (c31199a.mVelocityTracker == null) {
                    c31199a.mVelocityTracker = VelocityTracker.obtain();
                }
                c31199a.mVelocityTracker.addMovement(motionEvent);
                float y;
                int pointerId;
                switch (actionMasked) {
                    case 0:
                        float x = motionEvent.getX();
                        y = motionEvent.getY();
                        pointerId = motionEvent.getPointerId(0);
                        c31199a.mo50970a(x, y, pointerId);
                        View F = c31199a.mo50969F((int) x, (int) y);
                        if (F == c31199a.f14358SU && c31199a.f14346SG == 2) {
                            c31199a.mo50981v(F, pointerId);
                        }
                        if ((c31199a.BTp[pointerId] & c31199a.f14357SS) != 0) {
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        c31199a.cancel();
                        break;
                    case 2:
                        actionIndex = motionEvent.getPointerCount();
                        actionMasked = 0;
                        while (actionMasked < actionIndex) {
                            pointerId = motionEvent.getPointerId(actionMasked);
                            float x2 = motionEvent.getX(actionMasked);
                            float y2 = motionEvent.getY(actionMasked);
                            float f = x2 - c31199a.f14347SH[pointerId];
                            float f2 = y2 - c31199a.f14348SI[pointerId];
                            c31199a.mo50972b(f, f2, pointerId);
                            if (c31199a.f14346SG != 1) {
                                View F2 = c31199a.mo50969F((int) x2, (int) y2);
                                if (F2 == null || !c31199a.mo50974c(F2, f, f2) || !c31199a.mo50981v(F2, pointerId)) {
                                    actionMasked++;
                                }
                            }
                            c31199a.mo50976e(motionEvent);
                            break;
                        }
                        c31199a.mo50976e(motionEvent);
                        break;
                    case 5:
                        actionMasked = motionEvent.getPointerId(actionIndex);
                        float x3 = motionEvent.getX(actionIndex);
                        y = motionEvent.getY(actionIndex);
                        c31199a.mo50970a(x3, y, actionMasked);
                        if (c31199a.f14346SG != 0 && c31199a.f14346SG == 2) {
                            View F3 = c31199a.mo50969F((int) x3, (int) y);
                            if (F3 == c31199a.f14358SU) {
                                c31199a.mo50981v(F3, actionMasked);
                                break;
                            }
                        }
                        break;
                    case 6:
                        c31199a.mo50971aY(motionEvent.getPointerId(actionIndex));
                        break;
                }
                if (c31199a.f14346SG == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    motionEvent.setAction(3);
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(91215);
                    return true;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(91215);
                return true;
            } catch (NullPointerException e) {
                AppMethodBeat.m2505o(91215);
                return false;
            } catch (IllegalArgumentException e2) {
                AppMethodBeat.m2505o(91215);
                return false;
            } catch (ArrayIndexOutOfBoundsException e3) {
                AppMethodBeat.m2505o(91215);
                return false;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(91215);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(91216);
        if (this.mEnable) {
            this.BTj.mo50977g(motionEvent);
            AppMethodBeat.m2505o(91216);
            return true;
        }
        AppMethodBeat.m2505o(91216);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(91217);
        this.mInLayout = true;
        if (this.f16581WL != null) {
            this.f16581WL.layout(this.zOg, this.zOh, this.zOg + this.f16581WL.getMeasuredWidth(), this.zOh + this.f16581WL.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.m2505o(91217);
    }

    public void requestLayout() {
        AppMethodBeat.m2504i(91218);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.m2505o(91218);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.m2504i(91219);
        int i = view == this.f16581WL ? 1 : 0;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(this.f16578Qb <= 0.0f || i == 0 || this.BTj.f14346SG == 0)) {
            Rect rect = this.f16582oT;
            view.getHitRect(rect);
            if ((this.BTi & 1) != 0) {
                this.f16579Qw.setBounds(rect.left - this.f16579Qw.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.f16579Qw.setAlpha((int) (this.f16578Qb * 255.0f));
                this.f16579Qw.draw(canvas);
            }
            if ((this.BTi & 2) != 0) {
                this.f16580Qx.setBounds(rect.right, rect.top, rect.right + this.f16580Qx.getIntrinsicWidth(), rect.bottom);
                this.f16580Qx.setAlpha((int) (this.f16578Qb * 255.0f));
                this.f16580Qx.draw(canvas);
            }
            if ((this.BTi & 8) != 0) {
                this.BTl.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.BTl.getIntrinsicHeight());
                this.BTl.setAlpha((int) (this.f16578Qb * 255.0f));
                this.BTl.draw(canvas);
            }
            i = (((int) (((float) ((this.f16577Qa & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.f16578Qb)) << 24) | (this.f16577Qa & 16777215);
            if ((this.BTm & 1) != 0) {
                canvas.clipRect(0, 0, view.getLeft(), getHeight());
            } else if ((this.BTm & 2) != 0) {
                canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
            } else if ((this.BTm & 8) != 0) {
                canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
            }
            canvas.drawColor(i);
        }
        AppMethodBeat.m2505o(91219);
        return drawChild;
    }

    public void computeScroll() {
        Object obj;
        AppMethodBeat.m2504i(91220);
        this.f16578Qb = 1.0f - this.zOj;
        C31199a c31199a = this.BTj;
        if (c31199a.f14346SG == 2) {
            boolean isFinished;
            boolean computeScrollOffset = c31199a.jlU.f710qN.computeScrollOffset();
            int currX = c31199a.jlU.f710qN.getCurrX();
            int currY = c31199a.jlU.f710qN.getCurrY();
            int left = currX - c31199a.f14358SU.getLeft();
            int top = currY - c31199a.f14358SU.getTop();
            if (left != 0) {
                c31199a.f14358SU.offsetLeftAndRight(left);
            }
            if (top != 0) {
                c31199a.f14358SU.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                c31199a.BTq.mo41395o(c31199a.f14358SU, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == c31199a.jlU.f710qN.getFinalX() && currY == c31199a.jlU.f710qN.getFinalY()) {
                c31199a.jlU.f710qN.abortAnimation();
                isFinished = c31199a.jlU.f710qN.isFinished();
            } else {
                isFinished = computeScrollOffset;
            }
            if (!isFinished) {
                c31199a.f14360SW.post(c31199a.f14361SX);
            }
        }
        if (c31199a.f14346SG == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C0477s.m891R(this);
        }
        AppMethodBeat.m2505o(91220);
    }
}
