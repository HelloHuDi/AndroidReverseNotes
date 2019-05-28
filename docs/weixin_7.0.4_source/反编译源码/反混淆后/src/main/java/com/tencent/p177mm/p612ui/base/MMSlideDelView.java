package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.ui.base.MMSlideDelView */
public class MMSlideDelView extends ViewGroup {
    private C23600g jJO;
    private C15521c jJP;
    private C23597d jJR;
    private boolean jZK = false;
    private int llU;
    private C7306ak mHandler = new C7306ak();
    private float mLastMotionX;
    private float mLastMotionY;
    private final Scroller mScroller;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private boolean nDl = true;
    long time;
    private boolean yxb = false;
    private C23596b yxc;
    private Runnable yxd;
    private long yxe;
    private boolean yxf = false;
    private C23598a yxg = null;
    private C23595e yxh;

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$c */
    public interface C15521c {
        /* renamed from: cZ */
        int mo8831cZ(View view);
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$1 */
    static class C235941 implements C23597d {
        C235941() {
        }

        /* renamed from: a */
        public final void mo25718a(MMSlideDelView mMSlideDelView, boolean z) {
            AppMethodBeat.m2504i(106770);
            if (z) {
                nDv.add(mMSlideDelView);
                AppMethodBeat.m2505o(106770);
                return;
            }
            nDv.remove(mMSlideDelView);
            AppMethodBeat.m2505o(106770);
        }

        public final boolean bIo() {
            AppMethodBeat.m2504i(106771);
            if (nDv.size() > 0) {
                AppMethodBeat.m2505o(106771);
                return true;
            }
            AppMethodBeat.m2505o(106771);
            return false;
        }

        public final void bIp() {
            AppMethodBeat.m2504i(106772);
            for (MMSlideDelView mMSlideDelView : nDv) {
                if (mMSlideDelView != null) {
                    mMSlideDelView.dzZ();
                }
            }
            nDv.clear();
            AppMethodBeat.m2505o(106772);
        }

        public final void bIq() {
            AppMethodBeat.m2504i(106773);
            for (MMSlideDelView mMSlideDelView : nDv) {
                if (mMSlideDelView != null) {
                    mMSlideDelView.dzY();
                }
            }
            nDv.clear();
            AppMethodBeat.m2505o(106773);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$e */
    public interface C23595e {
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$b */
    class C23596b implements Runnable {
        C23596b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106776);
            C4990ab.m7418v("MicroMsg.MMSlideDelView", "checkfortap");
            MMSlideDelView.this.setPressed(true);
            AppMethodBeat.m2505o(106776);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$d */
    public interface C23597d {
        public static final Set<MMSlideDelView> nDv = new HashSet();

        /* renamed from: a */
        void mo25718a(MMSlideDelView mMSlideDelView, boolean z);

        boolean bIo();

        void bIp();

        void bIq();
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$a */
    class C23598a extends C23601h implements Runnable {
        private C23598a() {
            super(MMSlideDelView.this, (byte) 0);
        }

        /* synthetic */ C23598a(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }

        public final void run() {
            Object obj;
            AppMethodBeat.m2504i(106775);
            if (MMSlideDelView.this.hasWindowFocus() && MMSlideDelView.m36421c(MMSlideDelView.this) == this.yxj) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || MMSlideDelView.this.jZK)) {
                C4990ab.m7416i("MicroMsg.MMSlideDelView", "is long press");
                if (MMSlideDelView.this.getParent() != null) {
                    MMSlideDelView.this.yxf = true;
                    MMSlideDelView.this.performLongClick();
                }
            }
            AppMethodBeat.m2505o(106775);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$f */
    public interface C23599f {
        /* renamed from: bN */
        void mo11067bN(Object obj);
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$g */
    public interface C23600g {
        /* renamed from: q */
        void mo11108q(View view, int i, int i2);
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$h */
    class C23601h {
        int yxj;

        private C23601h() {
        }

        /* synthetic */ C23601h(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMSlideDelView$2 */
    class C236022 implements Runnable {
        C236022() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106774);
            MMSlideDelView.this.setPressed(false);
            C4990ab.m7418v("MicroMsg.MMSlideDelView", "onClick");
            MMSlideDelView.this.jJO.mo11108q(MMSlideDelView.this, MMSlideDelView.this.llU, 0);
            MMSlideDelView.this.dzY();
            AppMethodBeat.m2505o(106774);
        }
    }

    /* renamed from: c */
    static /* synthetic */ int m36421c(MMSlideDelView mMSlideDelView) {
        AppMethodBeat.m2504i(106793);
        int windowAttachCount = mMSlideDelView.getWindowAttachCount();
        AppMethodBeat.m2505o(106793);
        return windowAttachCount;
    }

    public static C23597d getItemStatusCallBack() {
        AppMethodBeat.m2504i(106777);
        C235941 c235941 = new C235941();
        AppMethodBeat.m2505o(106777);
        return c235941;
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106778);
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.yxe = (long) ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.m2505o(106778);
    }

    public void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    public void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public void setItemStatusCallBack(C23597d c23597d) {
        this.jJR = c23597d;
    }

    public void setEnable(boolean z) {
        this.nDl = z;
    }

    public void setOnDelViewShowCallback(C23595e c23595e) {
        this.yxh = c23595e;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106779);
        if (getChildCount() < 2) {
            AppMethodBeat.m2505o(106779);
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
        AppMethodBeat.m2505o(106779);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106780);
        if (getChildCount() < 2) {
            AppMethodBeat.m2505o(106780);
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
        setMeasuredDimension(MMSlideDelView.resolveSize(size, i), MMSlideDelView.resolveSize(max, i2));
        AppMethodBeat.m2505o(106780);
    }

    public void setView(View view) {
        AppMethodBeat.m2504i(106781);
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(106781);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106782);
        if (this.nDl) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.jJR.bIo() && !this.yxb) {
                C4990ab.m7418v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
                this.yxf = false;
                this.jJR.bIp();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (this.yxf) {
                AppMethodBeat.m2505o(106782);
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
                        this.llU = this.jJP.mo8831cZ(this);
                    }
                    if (this.yxc == null) {
                        this.yxc = new C23596b();
                    }
                    this.mHandler.postDelayed(this.yxc, (long) ViewConfiguration.getTapTimeout());
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    if (this.yxg == null) {
                        this.yxg = new C23598a(this, (byte) 0);
                    }
                    C23598a c23598a = this.yxg;
                    c23598a.yxj = MMSlideDelView.this.getWindowAttachCount();
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
                        this.yxd = new C236022();
                        this.mHandler.postDelayed(this.yxd, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    if (this.jZK) {
                        dzW();
                    }
                    m36425lA();
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
                                    m36424gq(true);
                                }
                            }
                        }
                        z = false;
                        this.jZK = true;
                        m36424gq(true);
                    }
                    if (this.jZK) {
                        View childAt = getChildAt(1);
                        if (!(childAt == null || childAt.isShown())) {
                            childAt.setVisibility(0);
                        }
                        dzV();
                        setPressed(false);
                        m36424gq(true);
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
                    m36425lA();
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
            AppMethodBeat.m2505o(106782);
            return true;
        }
        AppMethodBeat.m2505o(106782);
        return false;
    }

    /* renamed from: lA */
    private void m36425lA() {
        AppMethodBeat.m2504i(106783);
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.m2505o(106783);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.m2504i(106784);
        C4990ab.m7418v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.yxf = false;
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2505o(106784);
    }

    private void dzV() {
        AppMethodBeat.m2504i(106785);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.yxc);
        }
        AppMethodBeat.m2505o(106785);
    }

    private void dzW() {
        AppMethodBeat.m2504i(106786);
        setPressed(false);
        if (this.yxb) {
            dzZ();
            AppMethodBeat.m2505o(106786);
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
        m36424gq(false);
        AppMethodBeat.m2505o(106786);
    }

    /* renamed from: gq */
    private void m36424gq(boolean z) {
        AppMethodBeat.m2504i(106787);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.m2505o(106787);
    }

    private void dzX() {
        AppMethodBeat.m2504i(106788);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth() - scrollX;
        this.jJR.mo25718a(this, true);
        this.yxb = true;
        this.mScroller.startScroll(scrollX, 0, width, 0, 100);
        invalidate();
        AppMethodBeat.m2505o(106788);
    }

    public final void dzY() {
        AppMethodBeat.m2504i(106789);
        this.jJR.mo25718a(this, false);
        this.yxb = false;
        scrollTo(0, 0);
        invalidate();
        AppMethodBeat.m2505o(106789);
    }

    public final void dzZ() {
        AppMethodBeat.m2504i(106790);
        int scrollX = getScrollX();
        this.jJR.mo25718a(this, false);
        this.yxb = false;
        this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
        AppMethodBeat.m2505o(106790);
    }

    private void dAa() {
        AppMethodBeat.m2504i(106791);
        int scrollX = getScrollX();
        int width = getChildAt(1).getWidth();
        int i = width - scrollX;
        if (scrollX > width / 2) {
            this.jJR.mo25718a(this, true);
            this.yxb = true;
            this.mScroller.startScroll(scrollX, 0, i, 0, 100);
        } else {
            this.yxb = false;
            this.jJR.mo25718a(this, false);
            this.mScroller.startScroll(scrollX, 0, -scrollX, 0, 100);
        }
        invalidate();
        AppMethodBeat.m2505o(106791);
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(106792);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        AppMethodBeat.m2505o(106792);
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
