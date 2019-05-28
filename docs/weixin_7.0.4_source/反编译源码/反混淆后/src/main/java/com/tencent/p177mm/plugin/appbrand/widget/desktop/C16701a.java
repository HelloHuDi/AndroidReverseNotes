package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p230g.p231a.C26112db;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.C38583b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b.C2543d;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b.C2543d.C25441;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b.C33603b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b.C36736a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b.C38578c;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Timer;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a */
public final class C16701a extends C10985b {
    private View aus;
    private View iJO;
    private boolean iVA = false;
    private View iVB;
    private int iVC = 0;
    private int iVD = 0;
    private Runnable iVE = null;
    private Runnable iVF = null;
    private Runnable iVG = null;
    private Runnable iVH = null;
    private boolean iVI = false;
    private boolean iVJ = false;
    private boolean iVK = true;
    private boolean iVL = false;
    private boolean iVM = false;
    private int iVN = 0;
    private boolean iVO = false;
    private boolean iVP = true;
    private boolean iVQ = true;
    private boolean iVR = false;
    private boolean iVS = false;
    private int iVT = -2;
    private boolean iVU = false;
    private boolean iVV = false;
    private Runnable iVW;
    private boolean iVX;
    private PointF iVY = new PointF();
    private PointF iVZ = new PointF();
    private HeaderContainer iVo;
    private float iVp = 0.3f;
    private float iVq = 0.05f;
    private int iVr = 0;
    private int iVs = 0;
    private Vibrator iVt;
    private int iVu;
    private C10984a iVv;
    private DynamicBackgroundGLSurfaceView iVw;
    private View iVx;
    private boolean iVy = true;
    private boolean iVz = false;
    private boolean iWa = false;
    private Runnable iWb = new C167036();
    private boolean iWc = true;
    private GyroView iWd;
    private View iWe;
    private boolean iWf = true;
    private boolean iWg = false;
    private boolean iWh = false;
    private Context mContext;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$10 */
    class C1095110 implements Runnable {
        C1095110() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133675);
            if (!C38578c.jbx.eCM) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
                C38578c c38578c = C38578c.jbx;
                if (!c38578c.eCM) {
                    c38578c.eCM = true;
                    C4990ab.m7417i("MicroMsg.Metronome", "[start] stack:%s", C5046bo.dpG());
                    c38578c.bsZ.postFrameCallback(c38578c);
                }
                C2543d c2543d = C2543d.jbz;
                synchronized (c2543d.eCR) {
                    try {
                        if (c2543d.isRunning) {
                            C4990ab.m7420w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
                        } else {
                            if (c2543d.mTimer != null) {
                                c2543d.mTimer.cancel();
                            }
                            System.gc();
                            c2543d.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
                            c2543d.eCQ.clear();
                            c2543d.eCQ.put(Integer.valueOf(1), new C36736a());
                            c2543d.mTimer.scheduleAtFixedRate(new C25441(), 0, 5);
                            c2543d.isRunning = true;
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(133675);
                    }
                }
                C16701a.m25723n(C16701a.this);
            }
            AppMethodBeat.m2505o(133675);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$1 */
    class C167021 implements Runnable {
        C167021() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133664);
            C16701a.this.iVu = C5230ak.m7987de(C16701a.this.mContext) + C5230ak.m7984J(C16701a.this.mContext, 0);
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + C16701a.this.iVu);
            AppMethodBeat.m2505o(133664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$6 */
    class C167036 implements Runnable {
        C167036() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133670);
            C16701a.this.iVX = false;
            AppMethodBeat.m2505o(133670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$7 */
    class C167047 implements AnimatorListener {
        C167047() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133671);
            C16701a.this.aus.setVisibility(4);
            C16701a.this.aus.animate().setListener(null);
            AppMethodBeat.m2505o(133671);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$8 */
    class C167058 implements AnimatorListener {
        C167058() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133672);
            C16701a.this.aus.animate().setListener(null);
            C16701a.this.aus.setTranslationY(0.0f);
            C16701a.m25721l(C16701a.this);
            AppMethodBeat.m2505o(133672);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133673);
            C16701a.this.aus.animate().setListener(null);
            C16701a.this.aus.setTranslationY(0.0f);
            C16701a.m25721l(C16701a.this);
            AppMethodBeat.m2505o(133673);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$9 */
    class C167069 implements Runnable {
        C167069() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133674);
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayHideBackgroundView");
            C16701a.m25722m(C16701a.this);
            AppMethodBeat.m2505o(133674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$2 */
    class C167072 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$2$1 */
        class C167081 implements Runnable {
            C167081() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133665);
                C16701a.this.iVI = false;
                C16701a.this.iVJ = false;
                AppMethodBeat.m2505o(133665);
            }
        }

        C167072() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133666);
            if (C38578c.jbx.eCM) {
                C36736a c36736a;
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor");
                C38578c c38578c = C38578c.jbx;
                c38578c.frameStartTime = 0;
                c38578c.eCJ = 0;
                c38578c.eCM = false;
                C4990ab.m7417i("MicroMsg.Metronome", "[stop] stack:%s", C5046bo.dpG());
                c38578c.bsZ.removeFrameCallback(c38578c);
                C2543d.jbz.mo6510Pz();
                C33603b c33603b = (C33603b) C2543d.jbz.eCQ.get(Integer.valueOf(1));
                if (c33603b instanceof C36736a) {
                    c33603b.mo54169Pw();
                    c36736a = (C36736a) c33603b;
                } else {
                    c36736a = null;
                }
                if (c36736a != null) {
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor dump fps, max: %f, min: %f, average: %f", Double.valueOf(c36736a.jbw), Double.valueOf(c36736a.jbv), Double.valueOf(c36736a.jbu));
                    C38583b c38583b = C38583b.iZg;
                    double d = c36736a.jbu;
                    C4990ab.m7417i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps currentDrawFps: %d, appFps: %f", Integer.valueOf(C38583b.iZd), Double.valueOf(d));
                    if (d >= 45.0d) {
                        C2545b.m4793eT(true);
                        if (d >= 55.0d) {
                            C38583b.iZd = 20;
                        } else if (d >= 50.0d) {
                            C38583b.iZd = 15;
                        } else if (d >= 45.0d) {
                            C38583b.iZd = 5;
                        }
                    } else if (C38583b.iZd == 2) {
                        C4990ab.m7416i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps disable DynamicBackground");
                        C2545b.m4793eT(false);
                    } else {
                        C38583b.iZd = 2;
                        C2545b.m4793eT(true);
                    }
                    C38583b.iZf = (int) d;
                    SharedPreferences doB = C4996ah.doB();
                    if (doB != null) {
                        Editor edit = doB.edit();
                        if (edit != null) {
                            edit = edit.putInt("current_draw_fps", C38583b.iZd);
                            if (edit != null) {
                                edit.apply();
                            }
                        }
                    }
                    if (doB != null) {
                        Editor edit2 = doB.edit();
                        if (edit2 != null) {
                            edit2 = edit2.putInt("current_app_fps", (int) d);
                            if (edit2 != null) {
                                edit2.apply();
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps appFps: %f, FRAME_PER_SECOND: %d", Double.valueOf(d), Integer.valueOf(C38583b.iZd));
                    C38583b.aPB();
                }
                C2543d.jbz.release();
                C5004al.m7441d(new C167081());
            }
            AppMethodBeat.m2505o(133666);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a$3 */
    class C167093 implements Runnable {
        C167093() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133667);
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
            C16701a.this.mListView.smoothScrollBy(C16701a.this.iVo.getTop(), 600);
            C16701a.m25713e(C16701a.this);
            AppMethodBeat.m2505o(133667);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m25710b(C16701a c16701a, int i) {
        AppMethodBeat.m2504i(133703);
        c16701a.mo22619b(false, false, i);
        AppMethodBeat.m2505o(133703);
    }

    /* renamed from: e */
    static /* synthetic */ void m25713e(C16701a c16701a) {
        AppMethodBeat.m2504i(133702);
        c16701a.mo22632t(true, false);
        AppMethodBeat.m2505o(133702);
    }

    /* renamed from: l */
    static /* synthetic */ void m25721l(C16701a c16701a) {
        AppMethodBeat.m2504i(133704);
        c16701a.m25714eS(true);
        AppMethodBeat.m2505o(133704);
    }

    /* renamed from: m */
    static /* synthetic */ void m25722m(C16701a c16701a) {
        AppMethodBeat.m2504i(133705);
        c16701a.aPb();
        AppMethodBeat.m2505o(133705);
    }

    public C16701a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.m2504i(133676);
        this.mContext = context;
        this.mListView = listView;
        this.iVo = headerContainer;
        this.iVt = (Vibrator) context.getSystemService("vibrator");
        this.iVu = C5230ak.m7987de(this.mContext) + C5230ak.m7984J(this.mContext, 0);
        boolean post = listView.post(new C167021());
        this.iVQ = C2545b.aPe();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", Boolean.valueOf(this.iVQ), Integer.valueOf(this.iVu), Boolean.valueOf(post));
        aOY();
        aOZ();
        aOR();
        AppMethodBeat.m2505o(133676);
    }

    private void aOR() {
        AppMethodBeat.m2504i(133677);
        this.iVC = this.mContext.getResources().getDisplayMetrics().heightPixels / 4;
        this.iVD = this.iVC;
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d", Integer.valueOf(this.iVC), Integer.valueOf(this.iVD));
        AppMethodBeat.m2505o(133677);
    }

    public final void aOS() {
        AppMethodBeat.m2504i(133678);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", Boolean.valueOf(aOV()), Boolean.valueOf(this.iVR));
        if (aOV()) {
            if (this.iWf && this.iWg) {
                C35988ay.m59202gL(this.mContext);
            }
            this.iVU = true;
            this.iVM = false;
            this.mListView.removeCallbacks(this.iVW);
            ListView listView = this.mListView;
            C167093 c167093 = new C167093();
            this.iVW = c167093;
            listView.post(c167093);
            if (this.iVQ) {
                C38583b c38583b = C38583b.iZg;
                if (C38583b.aPA()) {
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", Boolean.valueOf(this.iVI), Boolean.valueOf(this.iVJ));
                    if (!(this.iVI || this.iVJ)) {
                        this.iVI = true;
                        if (this.iVG != null) {
                            C7305d.xDG.remove(this.iVG);
                        }
                        this.iVG = new C1095110();
                        C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
                        C7305d.xDG.mo10151b(this.iVG, "AppBrandDesktopPerformanceMonitor");
                    }
                    AppMethodBeat.m2505o(133678);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
                AppMethodBeat.m2505o(133678);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
            AppMethodBeat.m2505o(133678);
            return;
        }
        AppMethodBeat.m2505o(133678);
    }

    /* renamed from: qh */
    public final void mo22628qh(final int i) {
        AppMethodBeat.m2504i(133679);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", Boolean.valueOf(aOV()), Integer.valueOf(i));
        this.iVM = true;
        m25714eS(true);
        if (aOV()) {
            this.iVU = true;
            this.mListView.removeCallbacks(this.iVW);
            ListView listView = this.mListView;
            C167104 c167104 = new Runnable() {
                public final void run() {
                    int h;
                    AppMethodBeat.m2504i(133668);
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", Integer.valueOf(C16701a.this.iVo.getBottom()), Integer.valueOf(C16701a.this.iVo.getBottom()));
                    C16701a.this.mListView.smoothScrollBy(C16701a.this.iVo.getBottom(), C16701a.this.iVO ? 10 : 600);
                    C16701a.m25716g(C16701a.this);
                    C16701a.this.iVO = false;
                    if (C16701a.this.iVN != 0) {
                        h = C16701a.this.iVN;
                        C16701a.this.iVN = 0;
                    } else {
                        h = i;
                    }
                    C16701a.m25710b(C16701a.this, h);
                    AppMethodBeat.m2505o(133668);
                }
            };
            this.iVW = c167104;
            listView.post(c167104);
            AppMethodBeat.m2505o(133679);
            return;
        }
        mo22624eR(false);
        AppMethodBeat.m2505o(133679);
    }

    /* renamed from: c */
    public final void mo22620c(long j, final int i, final boolean z) {
        AppMethodBeat.m2504i(133680);
        super.mo22620c(j, i, z);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.iVF != null) {
            this.mListView.removeCallbacks(this.iVF);
        }
        ListView listView = this.mListView;
        C167115 c167115 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(133669);
                C16701a.this.iVO = z;
                C16701a.this.mo22628qh(i);
                AppMethodBeat.m2505o(133669);
            }
        };
        this.iVF = c167115;
        listView.postDelayed(c167115, j);
        AppMethodBeat.m2505o(133680);
    }

    private boolean aOT() {
        AppMethodBeat.m2504i(133681);
        int bottom = this.iVo.getBottom();
        if (aOW()) {
            if (this.iVs == 0) {
                this.iVs = (int) (((float) this.iVo.getHeight()) * this.iVq);
            }
            if (bottom < this.iVs) {
                AppMethodBeat.m2505o(133681);
                return true;
            }
            AppMethodBeat.m2505o(133681);
            return false;
        } else if (bottom > aOX()) {
            AppMethodBeat.m2505o(133681);
            return true;
        } else {
            AppMethodBeat.m2505o(133681);
            return false;
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133682);
        if (motionEvent.getAction() == 0) {
            mo22615F(motionEvent);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.iVZ.set(motionEvent.getRawX(), motionEvent.getRawY());
            if (this.iVo != null && this.iVo.getBackUpFooterRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && aOW()) {
                if (this.iVN == 0) {
                    this.iVN = 12;
                }
                C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", Integer.valueOf(this.iVN));
            }
            onScrollStateChanged(this.mListView, -1);
        }
        AppMethodBeat.m2505o(133682);
        return false;
    }

    /* renamed from: F */
    public final void mo22615F(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(138153);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        this.mListView.removeCallbacks(this.iVW);
        this.mListView.removeCallbacks(this.iVF);
        this.iVY.set(motionEvent.getRawX(), motionEvent.getRawY());
        this.iVV = false;
        AppMethodBeat.m2505o(138153);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(133683);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", Integer.valueOf(i), Boolean.valueOf(aOW()));
        this.iVA = true;
        int i2 = this.iVT;
        this.iVT = i;
        if (i == 0 || i == -1) {
            this.iVS = false;
            if (this.iVU && i == 0) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
                this.iVU = false;
                if (i2 == -1) {
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", Boolean.valueOf(aOT()));
                    if (this.iVo.getBottom() < 200 || this.mListView.getFirstVisiblePosition() != 0 || this.iVR) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0 && aOT()) {
                        C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
                        this.iVM = false;
                        mo22632t(true, false);
                    }
                }
                AppMethodBeat.m2505o(133683);
                return;
            } else if (aOT()) {
                aOS();
                AppMethodBeat.m2505o(133683);
                return;
            } else if (aOW() && i == -1) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
                mo22628qh(4);
                AppMethodBeat.m2505o(133683);
                return;
            } else if (i == -1) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
                mo22628qh(0);
                this.iVL = true;
                AppMethodBeat.m2505o(133683);
                return;
            }
        } else if (i == 2) {
            this.iVX = true;
            this.iVS = true;
            AppMethodBeat.m2505o(133683);
            return;
        } else if (i == 1) {
            this.iVX = false;
            this.iVP = true;
            this.iVS = true;
            if (aOW()) {
                this.iVX = false;
                this.iVN = 4;
            }
        }
        AppMethodBeat.m2505o(133683);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(133684);
        if (!absListView.isInLayout() || this.iVM || this.iVo.getBottom() >= this.iVo.getHeight() || !this.iVR) {
            int height;
            int i4;
            float f;
            if (this.iVV && !this.iVU && this.iVX && i <= 0 && aOV()) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
                this.mListView.scrollBy(0, 0);
                mo22628qh(4);
            }
            String str = "MicroMsg.AppBrandDesktopAnimController";
            String str2 = "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d,isNeedCheckStopFling: %b, mHeaderContainer != null: %b";
            Object[] objArr = new Object[6];
            objArr[0] = Boolean.valueOf(this.iVX);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Boolean.valueOf(this.iVV);
            objArr[5] = Boolean.valueOf(this.iVo != null);
            C4990ab.m7411d(str, str2, objArr);
            if (!(this.iVV || i != 0 || this.iVo == null)) {
                C4990ab.m7411d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", Integer.valueOf(0), Integer.valueOf(this.iVo.getBottom()), Integer.valueOf(this.iVu), Integer.valueOf(this.iVo.getHeight()), Integer.valueOf(this.iVo.getBottom()), Boolean.valueOf(this.iVA));
                if (!(this.iVw == null || this.iVB == null)) {
                    if (!this.iVQ) {
                        this.iVy = true;
                        this.iVz = true;
                        this.iVw.setVisibility(8);
                        this.iVw.iZQ.onPause();
                        if (aOV()) {
                            this.iVB.setAlpha(1.0f);
                            this.iVB.setVisibility(0);
                        }
                    } else if (aOV() && this.iVy && this.iVA) {
                        this.iVy = false;
                        aPa();
                        if (this.iVz) {
                            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
                            this.iVw.onResume();
                            this.iVz = false;
                        }
                    }
                }
                if (!this.iVP) {
                    C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
                } else if (this.iJO != null) {
                    height = i4 - (this.iVo.getHeight() - this.iVC);
                    f = (((float) height) * 1.0f) / ((float) this.iVD);
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    float f2 = f > 1.0f ? 1.0f : f;
                    if (height >= 0) {
                        m25708aw(0.0f);
                    } else {
                        m25708aw(1.0f);
                    }
                    if (((double) Math.abs(1.0f - f2)) <= 0.01d) {
                        m25708aw(0.0f);
                    } else {
                        m25708aw(1.0f - f2);
                    }
                    i4 = i;
                    while (i4 < i + i2) {
                        View childAt = absListView.getChildAt(i4);
                        if (!(childAt == null || i4 == 0)) {
                            childAt.setAlpha(1.0f - f2);
                        }
                        i4++;
                    }
                    if (f2 == 0.0f) {
                        absListView.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f12207vz));
                        if (this.iVB != null) {
                            C4990ab.m7410d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader show GradientBackgroundView");
                            this.iVB.setAlpha(1.0f);
                            this.iVB.setVisibility(0);
                        }
                    } else if (f2 == 1.0f) {
                        if (this.iVQ) {
                            aPa();
                        }
                        absListView.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.a3p));
                    }
                }
            }
            if (this.mListView != null && ((VERSION.SDK_INT < 23 || C1448h.m3077Mt()) && VERSION.SDK_INT >= 21)) {
                if (aOV() && this.iVR) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (i4 == 0) {
                    if (this.iVo != null && this.iVo.getBottom() <= this.iVu + 20) {
                        if (this.iVB != null) {
                            this.iVB.setVisibility(8);
                        }
                        if (this.iVw != null) {
                            this.iVw.iZQ.onPause();
                            this.iVy = true;
                            this.iVz = true;
                            this.iVw.setVisibility(8);
                        }
                    }
                    if (this.mListView.getFirstVisiblePosition() > 0 || (this.mListView.getFirstVisiblePosition() == 0 && !aOV())) {
                        this.mListView.setBackgroundColor(this.mListView.getResources().getColor(C25738R.color.a3p));
                        if (this.iVx != null) {
                            this.iVx.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.a3p));
                        }
                        if (this.iVB != null) {
                            this.iVB.setVisibility(4);
                        }
                    }
                }
            }
            if (aOV()) {
                this.iVV = false;
            } else {
                this.iVV = true;
                if (!aOT() && this.iVS) {
                    mo22632t(false, true);
                } else if (this.iWa && this.iVS) {
                    mo22632t(false, true);
                }
            }
            int aOX = aOX();
            if (this.iWd == null) {
                this.iWd = (GyroView) this.iVo.findViewById(2131820627);
            }
            if (this.iWe == null) {
                this.iWe = this.iVo.findViewById(2131820554);
                this.iWe.setTranslationY((float) (aOX * 2));
            }
            height = this.iVo.getBottom();
            if ((!this.iVX && height >= 5) || this.iVL) {
                if (aOX >= height) {
                    this.iWd.mo22610b((float) height, aOX);
                    this.iWd.setTranslationY((float) ((((-height) / 2) + (this.iWd.getHeight() / 2)) + this.iVo.getPaddingBottom()));
                } else {
                    this.iWd.mo22610b((float) aOX, aOX);
                }
            }
            if (this.iWf) {
                f = (float) this.iVo.getHeight();
                int i5 = (int) (((((float) (aOX * 2)) * 1.0f) * ((float) height)) / f);
                this.iWe.setTranslationY((float) ((aOX * 2) - i5));
                C4990ab.m7410d("MicroMsg.AppBrandDesktopAnimController", "[transHeader] TranY:" + ((aOX * 2) - i5));
                f = (1.0f * ((float) (height - aOX))) / (f - ((float) aOX));
                if (f < 0.0f) {
                    f = 0.0f;
                }
                this.iWe.setAlpha(f);
                this.iWd.setAlpha(((1.2f * ((float) aOX)) - ((float) height)) / ((float) aOX));
            }
            if (aOX <= height && this.iWh && aOV() && !absListView.isInLayout()) {
                this.iVt.vibrate(10);
                this.iWh = false;
            }
            if (this.iWe.getTranslationY() <= 10.0f) {
                this.iWf = false;
            }
            if (height < 50) {
                aOY();
            }
            this.iWa = aOV();
            if (aOV()) {
                m25714eS(false);
            } else {
                m25714eS(true);
            }
            C5004al.m7439af(this.iWb);
            C5004al.m7442n(this.iWb, 60);
            AppMethodBeat.m2505o(133684);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
        mo22628qh(0);
        AppMethodBeat.m2505o(133684);
    }

    /* renamed from: eQ */
    public final void mo22623eQ(boolean z) {
        AppMethodBeat.m2504i(133685);
        super.mo22623eQ(z);
        this.iVR = true;
        if (this.iVB != null && this.iVB.getVisibility() == 0) {
            this.iVB.invalidate();
        }
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", Boolean.valueOf(this.iVM), Boolean.valueOf(this.iVQ));
        if (this.aus == null) {
            AppMethodBeat.m2505o(133685);
        } else if (this.iVM) {
            AppMethodBeat.m2505o(133685);
        } else if (aOV()) {
            this.aus.animate().translationY((float) this.aus.getHeight()).setDuration(260).setListener(new C167047()).start();
            AppMethodBeat.m2505o(133685);
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
            this.aus.setTranslationY(0.0f);
            AppMethodBeat.m2505o(133685);
        }
    }

    /* renamed from: eR */
    public final void mo22624eR(boolean z) {
        AppMethodBeat.m2504i(133686);
        super.mo22624eR(z);
        this.iVR = false;
        aOZ();
        aOU();
        if (this.aus == null) {
            AppMethodBeat.m2505o(133686);
            return;
        }
        long j;
        this.aus.setVisibility(0);
        ViewPropertyAnimator translationY = this.aus.animate().translationY(0.0f);
        if (this.aus.getTranslationY() == 0.0f) {
            j = 130;
        } else {
            j = 260;
        }
        translationY.setDuration(j).setListener(new C167058()).start();
        AppMethodBeat.m2505o(133686);
    }

    private void aOU() {
        AppMethodBeat.m2504i(133687);
        if (this.iVE != null) {
            C5004al.m7439af(this.iVE);
        }
        if (this.iVK) {
            C167069 c167069 = new C167069();
            this.iVE = c167069;
            C5004al.m7442n(c167069, 500);
            AppMethodBeat.m2505o(133687);
            return;
        }
        aPb();
        AppMethodBeat.m2505o(133687);
    }

    /* renamed from: gY */
    public final void mo22625gY() {
        AppMethodBeat.m2504i(133688);
        aOR();
        this.iVP = false;
        AppMethodBeat.m2505o(133688);
    }

    /* renamed from: eS */
    private void m25714eS(boolean z) {
        AppMethodBeat.m2504i(133689);
        if (this.iVo.isFullScreen() && z != this.iWc) {
            this.iWc = z;
            C26112db c26112db = new C26112db();
            c26112db.cwi.enable = z;
            C4879a.xxA.mo10055m(c26112db);
        }
        AppMethodBeat.m2505o(133689);
    }

    public final boolean aOV() {
        AppMethodBeat.m2504i(133690);
        if (this.iVo.getBottom() < 10 || this.mListView.getFirstVisiblePosition() != 0) {
            AppMethodBeat.m2505o(133690);
            return false;
        }
        AppMethodBeat.m2505o(133690);
        return true;
    }

    private boolean aOW() {
        AppMethodBeat.m2504i(133691);
        if (Math.abs(this.iVZ.y - this.iVY.y) <= 5.0f || this.iVZ.y <= this.iVY.y) {
            AppMethodBeat.m2505o(133691);
            return true;
        }
        AppMethodBeat.m2505o(133691);
        return false;
    }

    private int aOX() {
        AppMethodBeat.m2504i(133692);
        if (this.iVr == 0) {
            this.iVr = (int) (((float) this.iVo.getHeight()) * this.iVp);
        }
        int i = this.iVr;
        AppMethodBeat.m2505o(133692);
        return i;
    }

    private void aOY() {
        AppMethodBeat.m2504i(133693);
        if (this.iWe != null) {
            this.iWe.setTranslationY((float) (aOX() * 2));
            this.iWe.setAlpha(0.0f);
        }
        this.iWh = true;
        this.iWf = true;
        AppMethodBeat.m2505o(133693);
    }

    private void aOZ() {
        AppMethodBeat.m2504i(133694);
        if (this.iWd != null) {
            this.iWd.mo22610b(0.0f, aOX());
            this.iWd.setTranslationY(0.0f);
        }
        AppMethodBeat.m2505o(133694);
    }

    public final void setTabView(View view) {
        this.aus = view;
    }

    /* renamed from: cD */
    public final void mo22621cD(View view) {
        this.iJO = view;
    }

    private void aPa() {
        AppMethodBeat.m2504i(133695);
        if (this.iVw != null) {
            this.iVw.setVisibility(0);
            this.iVw.setShowGradientView(false);
        }
        AppMethodBeat.m2505o(133695);
    }

    private void aPb() {
        AppMethodBeat.m2504i(133696);
        boolean z = this.iVQ;
        boolean z2 = C2545b.aPe() && this.iVw != null;
        this.iVQ = z2;
        aPc();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", Boolean.valueOf(this.iVQ), Boolean.valueOf(z));
        if (this.iVK && aOV()) {
            AppMethodBeat.m2505o(133696);
            return;
        }
        if (z) {
            if (!(this.iVw == null || this.iVy)) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
                this.iVw.iZQ.onPause();
                this.iVy = true;
                this.iVz = true;
                this.iVw.setVisibility(8);
            }
        } else if (this.iVw != null) {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
            this.iVw.setVisibility(8);
        }
        if (this.iVB != null) {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
            this.iVB.setVisibility(8);
        }
        AppMethodBeat.m2505o(133696);
    }

    public final void setActionBarUpdateCallback(C10984a c10984a) {
        this.iVv = c10984a;
    }

    /* renamed from: e */
    public final void mo22622e(View view, View view2) {
        AppMethodBeat.m2504i(133697);
        if (view instanceof DynamicBackgroundGLSurfaceView) {
            this.iVw = (DynamicBackgroundGLSurfaceView) view;
        }
        if (this.iVw == null) {
            this.iVQ = false;
        }
        this.iVB = view2;
        if (this.iVw != null && (this.iVB instanceof GradientColorBackgroundView)) {
            this.iVw.setGradientBackgroundView((GradientColorBackgroundView) this.iVB);
            aPc();
        }
        AppMethodBeat.m2505o(133697);
    }

    public final void setStatusBarMaskView(View view) {
        this.iVx = view;
    }

    private void aPc() {
        AppMethodBeat.m2504i(133698);
        if (this.iVB instanceof GradientColorBackgroundView) {
            ((GradientColorBackgroundView) this.iVB).setUpdateMode(1);
        }
        AppMethodBeat.m2505o(133698);
    }

    /* renamed from: aw */
    private void m25708aw(float f) {
        AppMethodBeat.m2504i(133699);
        if (this.iVv != null) {
            this.iVv.mo22614a(f, 0, 0, 0);
        }
        AppMethodBeat.m2505o(133699);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133700);
        super.onResume();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d", Boolean.valueOf(aOV()), Integer.valueOf(this.iVo.getBottom()), Integer.valueOf(this.iVo.getHeight()));
        if (aOV() && this.iVo.getBottom() < this.iVo.getHeight()) {
            if (this.iVZ.y - this.iVY.y > 50.0f) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume openHeader");
                aOS();
                AppMethodBeat.m2505o(133700);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume closeHeader");
            mo22628qh(4);
        }
        AppMethodBeat.m2505o(133700);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133701);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
        if (this.mListView != null) {
            if (this.iVF != null) {
                this.mListView.removeCallbacks(this.iVF);
                this.iVF = null;
            }
            if (this.iVE != null) {
                this.mListView.removeCallbacks(this.iVE);
                this.iVE = null;
            }
        }
        C7305d.xDG.remove("AppBrandDesktopPerformanceMonitor");
        C2543d.jbz.mo6510Pz();
        C2543d.jbz.release();
        this.iVI = false;
        AppMethodBeat.m2505o(133701);
    }

    /* renamed from: g */
    static /* synthetic */ void m25716g(C16701a c16701a) {
        boolean z;
        if (c16701a.iVO) {
            z = false;
        } else {
            z = true;
        }
        c16701a.iVK = z;
    }

    /* renamed from: n */
    static /* synthetic */ void m25723n(C16701a c16701a) {
        AppMethodBeat.m2504i(133706);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayStopMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b, delay: %d", Boolean.valueOf(c16701a.iVI), Boolean.valueOf(c16701a.iVJ), Long.valueOf(10000));
        if (c16701a.iVI && !c16701a.iVJ) {
            if (c16701a.iVH != null) {
                C7305d.xDG.remove(c16701a.iVH);
            }
            c16701a.iVH = new C167072();
            C4990ab.m7416i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute stopMonitorRunnable");
            c16701a.iVJ = true;
            C7305d.xDG.mo10152b(c16701a.iVH, "AppBrandDesktopPerformanceMonitor", 10000);
        }
        AppMethodBeat.m2505o(133706);
    }
}
