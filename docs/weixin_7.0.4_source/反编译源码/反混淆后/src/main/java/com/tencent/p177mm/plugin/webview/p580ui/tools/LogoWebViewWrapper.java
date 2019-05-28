package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper */
public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    WebView ejN;
    private int mTouchSlop;
    private int startY;
    private boolean urA = false;
    private boolean urB = false;
    private int urC = -1;
    FrameLayout uro;
    private boolean urp = false;
    private int urq;
    private int urr;
    private C22917c urs;
    private int urt = 0;
    boolean uru = false;
    private boolean urv = false;
    private int urw = 0;
    C29857a urx;
    C22916b ury;
    private boolean urz = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper$1 */
    class C145531 implements Runnable {
        C145531() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7391);
            LogoWebViewWrapper.this.urz = false;
            AppMethodBeat.m2505o(7391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper$b */
    public interface C22916b {
        /* renamed from: as */
        void mo38495as(int i, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper$c */
    final class C22917c implements Runnable {
        private final long duration;
        private long startTime = -1;
        private final Interpolator urE;
        private final int urF;
        private final int urG;
        private boolean urH = true;
        private int urI = -1;

        public C22917c(int i, int i2, long j) {
            AppMethodBeat.m2504i(7392);
            this.urG = i;
            this.urF = i2;
            this.urE = LogoWebViewWrapper.this.urv ? new AccelerateInterpolator() : new DecelerateInterpolator();
            this.duration = j;
            AppMethodBeat.m2505o(7392);
        }

        public final void run() {
            AppMethodBeat.m2504i(7393);
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                long j = 500;
                if (this.duration > 0) {
                    j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000), 0);
                }
                this.urI = this.urG - Math.round(this.urE.getInterpolation(((float) j) / 1000.0f) * ((float) (this.urG - this.urF)));
                LogoWebViewWrapper.this.mo48078Ji(this.urI);
                if (LogoWebViewWrapper.this.ury != null) {
                    LogoWebViewWrapper.this.ury.mo38495as(this.urI, false);
                }
            }
            if (this.urH && this.urF != this.urI) {
                C0477s.m934b(LogoWebViewWrapper.this, (Runnable) this);
            }
            AppMethodBeat.m2505o(7393);
        }

        public final void stop() {
            AppMethodBeat.m2504i(7394);
            this.urH = false;
            LogoWebViewWrapper.this.removeCallbacks(this);
            AppMethodBeat.m2505o(7394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper$a */
    public interface C29857a {
        void cZy();
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(7395);
        this.context = context;
        init();
        AppMethodBeat.m2505o(7395);
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(7396);
        this.context = context;
        init();
        AppMethodBeat.m2505o(7396);
    }

    public void setReleaseTargetHeight(int i) {
        this.urw = i;
    }

    private void init() {
        AppMethodBeat.m2504i(7397);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop();
        AppMethodBeat.m2505o(7397);
    }

    public void setFastScrollBack(boolean z) {
        this.urv = z;
    }

    public FrameLayout getWebViewContainer() {
        AppMethodBeat.m2504i(7398);
        if (this.uro == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == 2131823603) {
                    this.uro = (FrameLayout) childAt;
                    break;
                }
            }
        }
        FrameLayout frameLayout = this.uro;
        AppMethodBeat.m2505o(7398);
        return frameLayout;
    }

    public WebView getWebView() {
        return this.ejN;
    }

    /* renamed from: nM */
    public final void mo48081nM(boolean z) {
        this.uru = z;
        if (this.uru) {
            this.urp = false;
            this.urt = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(7399);
        if (!this.uru || this.urz) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.urp = false;
                this.urt = 0;
                this.urA = false;
                AppMethodBeat.m2505o(7399);
                return false;
            } else if (action == 2 && this.urp) {
                AppMethodBeat.m2505o(7399);
                return true;
            } else {
                boolean z;
                switch (action) {
                    case 0:
                        if (this.ejN.isOverScrollStart()) {
                            this.urq = (int) motionEvent.getY();
                            this.startY = (int) motionEvent.getY();
                            this.urr = (int) motionEvent.getX();
                            this.urp = false;
                            this.urt = 0;
                            this.urz = true;
                            this.urA = true;
                            break;
                        }
                        break;
                    case 2:
                        if (this.ejN.isOverScrollStart()) {
                            if (this.urA) {
                                action = (int) motionEvent.getY();
                                int x = (int) motionEvent.getX();
                                int i = action - this.urq;
                                int i2 = x - this.urr;
                                if (Math.abs(i) > this.mTouchSlop && Math.abs(i) > Math.abs(i2) && i > 0) {
                                    this.urq = action;
                                    this.urr = x;
                                    if (this.urt != 1) {
                                        this.urt++;
                                        break;
                                    }
                                    this.urp = true;
                                    this.urA = false;
                                    C4990ab.m7416i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                                    if (this.urx != null) {
                                        this.urx.cZy();
                                        break;
                                    }
                                }
                            }
                            this.urq = (int) motionEvent.getY();
                            this.startY = (int) motionEvent.getY();
                            this.urr = (int) motionEvent.getX();
                            this.urp = false;
                            this.urt = 0;
                            this.urz = true;
                            this.urA = true;
                            z = this.urp;
                            AppMethodBeat.m2505o(7399);
                            return z;
                        }
                        break;
                }
                z = this.urp;
                AppMethodBeat.m2505o(7399);
                return z;
            }
        }
        AppMethodBeat.m2505o(7399);
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(7400);
        if (this.uru && !this.urz) {
            AppMethodBeat.m2505o(7400);
            return false;
        } else if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.urz = true;
                    if (this.ejN.isOverScrollStart()) {
                        this.urq = (int) motionEvent.getY();
                        this.startY = (int) motionEvent.getY();
                        this.urr = (int) motionEvent.getX();
                        this.urB = true;
                        AppMethodBeat.m2505o(7400);
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    this.urB = false;
                    if (this.urp || this.urz) {
                        this.urp = false;
                        mo48088z(-this.urw, getScrollBackDuration());
                        post(new C145531());
                        AppMethodBeat.m2505o(7400);
                        return true;
                    }
                case 2:
                    if (this.urp) {
                        if (this.urB) {
                            this.urq = (int) motionEvent.getY();
                            this.urr = (int) motionEvent.getX();
                            int min = Math.min(this.startY - this.urq, 0) >> 1;
                            int overScrollDistance = getOverScrollDistance();
                            int sqrt = ((int) Math.sqrt((double) ((getLogoHeight() >> 1) * Math.abs(min)))) << 1;
                            if (sqrt <= Math.abs(min)) {
                                min = -sqrt;
                            } else if (Math.abs(min) > overScrollDistance) {
                                min = -overScrollDistance;
                            }
                            mo48078Ji(min);
                            if (this.ury != null) {
                                this.ury.mo38495as(min, true);
                            }
                            AppMethodBeat.m2505o(7400);
                            return true;
                        }
                        this.urq = (int) motionEvent.getY();
                        this.startY = (int) motionEvent.getY();
                        this.urr = (int) motionEvent.getX();
                        this.urB = true;
                        AppMethodBeat.m2505o(7400);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.m2505o(7400);
            return false;
        } else {
            AppMethodBeat.m2505o(7400);
            return false;
        }
    }

    private long getScrollBackDuration() {
        AppMethodBeat.m2504i(7401);
        long abs = (long) Math.abs(getScrollY());
        long abs2 = Math.abs(abs - ((long) Math.abs(this.urw)));
        if (abs2 >= abs) {
            AppMethodBeat.m2505o(7401);
            return 300;
        }
        abs = (long) ((((float) abs2) / ((float) abs)) * 300.0f);
        AppMethodBeat.m2505o(7401);
        return abs;
    }

    private int getLogoHeight() {
        AppMethodBeat.m2504i(7402);
        if (this.urC < 0) {
            this.urC = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
        }
        int i = this.urC;
        AppMethodBeat.m2505o(7402);
        return i;
    }

    private int getOverScrollDistance() {
        AppMethodBeat.m2504i(7403);
        int height = getHeight();
        AppMethodBeat.m2505o(7403);
        return height;
    }

    /* renamed from: Ji */
    public final void mo48078Ji(int i) {
        AppMethodBeat.m2504i(7404);
        int overScrollDistance = getOverScrollDistance();
        scrollTo(0, Math.min(overScrollDistance, Math.max(-overScrollDistance, i)));
        AppMethodBeat.m2505o(7404);
    }

    /* renamed from: z */
    public final void mo48088z(int i, long j) {
        AppMethodBeat.m2504i(7405);
        if (this.urs != null) {
            this.urs.stop();
        }
        int scrollY = getScrollY();
        C4990ab.m7417i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", Integer.valueOf(scrollY), Integer.valueOf(i));
        if (scrollY != i) {
            this.urs = new C22917c(scrollY, i, j);
            post(this.urs);
        }
        AppMethodBeat.m2505o(7405);
    }

    public void setMMOverScrollListener(C29857a c29857a) {
        this.urx = c29857a;
    }

    public void setMMOverScrollOffsetListener(C22916b c22916b) {
        this.ury = c22916b;
    }
}
