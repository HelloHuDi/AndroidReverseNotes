package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView extends ViewGroup {
    private g jJO;
    private c jJP;
    private d jJR;
    private boolean jZK = false;
    private int llU;
    private ak mHandler = new ak();
    private float mLastMotionX;
    private float mLastMotionY;
    private final Scroller mScroller;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private boolean nDl = true;
    long time;
    private boolean yxb = false;
    private b yxc;
    private Runnable yxd;
    private long yxe;
    private boolean yxf = false;
    private a yxg = null;
    private e yxh;

    public interface c {
        int cZ(View view);
    }

    public interface e {
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(106776);
            ab.v("MicroMsg.MMSlideDelView", "checkfortap");
            MMSlideDelView.this.setPressed(true);
            AppMethodBeat.o(106776);
        }
    }

    public interface d {
        public static final Set<MMSlideDelView> nDv = new HashSet();

        void a(MMSlideDelView mMSlideDelView, boolean z);

        boolean bIo();

        void bIp();

        void bIq();
    }

    class a extends h implements Runnable {
        private a() {
            super(MMSlideDelView.this, (byte) 0);
        }

        /* synthetic */ a(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }

        public final void run() {
            Object obj;
            AppMethodBeat.i(106775);
            if (MMSlideDelView.this.hasWindowFocus() && MMSlideDelView.c(MMSlideDelView.this) == this.yxj) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || MMSlideDelView.this.jZK)) {
                ab.i("MicroMsg.MMSlideDelView", "is long press");
                if (MMSlideDelView.this.getParent() != null) {
                    MMSlideDelView.this.yxf = true;
                    MMSlideDelView.this.performLongClick();
                }
            }
            AppMethodBeat.o(106775);
        }
    }

    public interface f {
        void bN(Object obj);
    }

    public interface g {
        void q(View view, int i, int i2);
    }

    class h {
        int yxj;

        private h() {
        }

        /* synthetic */ h(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }
    }

    static /* synthetic */ int c(MMSlideDelView mMSlideDelView) {
        AppMethodBeat.i(106793);
        int windowAttachCount = mMSlideDelView.getWindowAttachCount();
        AppMethodBeat.o(106793);
        return windowAttachCount;
    }

    public static d getItemStatusCallBack() {
        AppMethodBeat.i(106777);
        AnonymousClass1 anonymousClass1 = new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(106770);
                if (z) {
                    nDv.add(mMSlideDelView);
                    AppMethodBeat.o(106770);
                    return;
                }
                nDv.remove(mMSlideDelView);
                AppMethodBeat.o(106770);
            }

            public final boolean bIo() {
                AppMethodBeat.i(106771);
                if (nDv.size() > 0) {
                    AppMethodBeat.o(106771);
                    return true;
                }
                AppMethodBeat.o(106771);
                return false;
            }

            public final void bIp() {
                AppMethodBeat.i(106772);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzZ();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(106772);
            }

            public final void bIq() {
                AppMethodBeat.i(106773);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzY();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(106773);
            }
        };
        AppMethodBeat.o(106777);
        return anonymousClass1;
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106778);
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.yxe = (long) ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.o(106778);
    }

    public void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public void setItemStatusCallBack(d dVar) {
        this.jJR = dVar;
    }

    public void setEnable(boolean z) {
        this.nDl = z;
    }

    public void setOnDelViewShowCallback(e eVar) {
        this.yxh = eVar;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106779);
        if (getChildCount() < 2) {
            AppMethodBeat.o(106779);
            return;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                i5 += measuredWidth;
            }
        }
        AppMethodBeat.o(106779);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106780);
        if (getChildCount() < 2) {
            AppMethodBeat.o(106780);
            return;
        }
        int size = MeasureSpec.getSize(i);
        try {
            getChildAt(0).measure(i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        int max = Math.max(0, getChildAt(0).getMeasuredHeight());
        LayoutParams layoutParams = getChildAt(1).getLayoutParams();
        View childAt = getChildAt(1);
        if (!(childAt == null || childAt.getVisibility() == 8)) {
            try {
                childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(max, ErrorDialogData.SUPPRESSED));
            } catch (ArrayIndexOutOfBoundsException e2) {
            }
            max = Math.max(max, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        AppMethodBeat.o(106780);
    }

    public void setView(View view) {
        AppMethodBeat.i(106781);
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
        AppMethodBeat.o(106781);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106782);
        if (this.nDl) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.jJR.bIo() && !this.yxb) {
                ab.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
                this.yxf = false;
                this.jJR.bIp();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (this.yxf) {
                AppMethodBeat.o(106782);
                return false;
            }
            switch (action) {
                case 0:
                    if (getContext() instanceof MMActivity) {
                        ((MMActivity) getContext()).aqX();
                    }
                    this.jZK = false;
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    this.time = System.currentTimeMillis();
                    if (this.jJP != null) {
                        this.llU = this.jJP.cZ(this);
                    }
                    if (this.yxc == null) {
                        this.yxc = new b();
                    }
                    this.mHandler.postDelayed(this.yxc, (long) ViewConfiguration.getTapTimeout());
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    if (this.yxg == null) {
                        this.yxg = new a(this, (byte) 0);
                    }
                    a aVar = this.yxg;
                    aVar.yxj = MMSlideDelView.this.getWindowAttachCount();
                    this.mHandler.postDelayed(this.yxg, this.yxe);
                    break;
                case 1:
                    dzV();
                    if (this.jZK || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.jJO == null || this.yxb)) {
                        setPressed(false);
                    } else {
                        setPressed(true);
                        if (this.yxd != null) {
                            removeCallbacks(this.yxd);
                        }
                        this.yxd = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(106774);
                                MMSlideDelView.this.setPressed(false);
                                ab.v("MicroMsg.MMSlideDelView", "onClick");
                                MMSlideDelView.this.jJO.q(MMSlideDelView.this, MMSlideDelView.this.llU, 0);
                                MMSlideDelView.this.dzY();
                                AppMethodBeat.o(106774);
                            }
                        };
                        this.mHandler.postDelayed(this.yxd, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    if (this.jZK) {
                        dzW();
                    }
                    lA();
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.yxg);
                        break;
                    }
                    break;
                case 2:
                    int i = (int) (this.mLastMotionX - x);
                    action = (int) (this.mLastMotionY - y);
                    int scrollX = getScrollX();
                    if (!this.jZK) {
                        boolean z;
                        if (i >= 0 && Math.abs(i) >= this.mTouchSlop / 3) {
                            if (action == 0) {
                                action = 1;
                            }
                            if (Math.abs(i / action) > 3) {
                                z = true;
                                if (z || this.yxb) {
                                    this.jZK = true;
                                    gq(true);
                                }
                            }
                        }
                        z = false;
                        this.jZK = true;
                        gq(true);
                    }
                    if (this.jZK) {
                        View childAt = getChildAt(1);
                        if (!(childAt == null || childAt.isShown())) {
                            childAt.setVisibility(0);
                        }
                        dzV();
                        setPressed(false);
                        gq(true);
                        if (scrollX + i < 0) {
                            action = -scrollX;
                        } else if (scrollX + i > getChildAt(1).getWidth()) {
                            action = getChildAt(1).getWidth() - scrollX;
                        } else {
                            action = i;
                        }
                        if (this.mHandler != null) {
                            this.mHandler.removeCallbacks(this.yxg);
                        }
                        scrollBy(action, 0);
                    }
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    break;
                case 3:
                    dzV();
                    setPressed(false);
                    if (this.jZK) {
                        dzW();
                    }
                    lA();
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.yxg);
                        break;
                    }
                    break;
                default:
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.yxg);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(106782);
            return true;
        }
        AppMethodBeat.o(106782);
        return false;
    }

    private void lA() {
        AppMethodBeat.i(106783);
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(106783);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(106784);
        ab.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.yxf = false;
        super.onWindowFocusChanged(z);
        AppMethodBeat.o(106784);
    }

    private void dzV() {
        AppMethodBeat.i(106785);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.yxc);
        }
        AppMethodBeat.o(106785);
    }

    private void dzW() {
        AppMethodBeat.i(106786);
        setPressed(false);
        if (this.yxb) {
            dzZ();
            AppMethodBeat.o(106786);
            return;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        if (xVelocity < -600) {
            dzX();
        } else if (xVelocity > 600) {
            dzZ();
        } else {
            dAa();
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        this.jZK = false;
        gq(false);
        AppMethodBeat.o(106786);
    }

    private void gq(boolean z) {
        AppMethodBeat.i(106787);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(106787);
    }

    private void dzX() {
        AppMethodBeat.i(106788);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth() - scrollX;
        this.jJR.a(this, true);
        this.yxb = true;
        this.mScroller.startScroll(scrollX, 0, width, 0, 100);
        invalidate();
        AppMethodBeat.o(106788);
    }

    public final void dzY() {
        AppMethodBeat.i(106789);
        this.jJR.a(this, false);
        this.yxb = false;
        scrollTo(0, 0);
        invalidate();
        AppMethodBeat.o(106789);
    }

    public final void dzZ() {
        AppMethodBeat.i(106790);
        int scrollX = getScrollX();
        this.jJR.a(this, false);
        this.yxb = false;
        this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
        AppMethodBeat.o(106790);
    }

    private void dAa() {
        AppMethodBeat.i(106791);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth();
        int i = width - scrollX;
        if (scrollX > width / 2) {
            this.jJR.a(this, true);
            this.yxb = true;
            this.mScroller.startScroll(scrollX, 0, i, 0, 100);
        } else {
            this.yxb = false;
            this.jJR.a(this, false);
            this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        }
        invalidate();
        AppMethodBeat.o(106791);
    }

    public void computeScroll() {
        AppMethodBeat.i(106792);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        AppMethodBeat.o(106792);
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
