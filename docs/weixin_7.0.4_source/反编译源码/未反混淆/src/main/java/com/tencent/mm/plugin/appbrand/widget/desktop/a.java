package com.tencent.mm.plugin.appbrand.widget.desktop;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.db;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ak;
import java.util.Timer;
import java.util.TimerTask;

public final class a extends b {
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
    private com.tencent.mm.plugin.appbrand.widget.header.a iVv;
    private DynamicBackgroundGLSurfaceView iVw;
    private View iVx;
    private boolean iVy = true;
    private boolean iVz = false;
    private boolean iWa = false;
    private Runnable iWb = new Runnable() {
        public final void run() {
            AppMethodBeat.i(133670);
            a.this.iVX = false;
            AppMethodBeat.o(133670);
        }
    };
    private boolean iWc = true;
    private GyroView iWd;
    private View iWe;
    private boolean iWf = true;
    private boolean iWg = false;
    private boolean iWh = false;
    private Context mContext;
    private ListView mListView;

    static /* synthetic */ void b(a aVar, int i) {
        AppMethodBeat.i(133703);
        aVar.b(false, false, i);
        AppMethodBeat.o(133703);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(133702);
        aVar.t(true, false);
        AppMethodBeat.o(133702);
    }

    static /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(133704);
        aVar.eS(true);
        AppMethodBeat.o(133704);
    }

    static /* synthetic */ void m(a aVar) {
        AppMethodBeat.i(133705);
        aVar.aPb();
        AppMethodBeat.o(133705);
    }

    public a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.i(133676);
        this.mContext = context;
        this.mListView = listView;
        this.iVo = headerContainer;
        this.iVt = (Vibrator) context.getSystemService("vibrator");
        this.iVu = ak.de(this.mContext) + ak.J(this.mContext, 0);
        boolean post = listView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133664);
                a.this.iVu = ak.de(a.this.mContext) + ak.J(a.this.mContext, 0);
                ab.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.this.iVu);
                AppMethodBeat.o(133664);
            }
        });
        this.iVQ = b.aPe();
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", Boolean.valueOf(this.iVQ), Integer.valueOf(this.iVu), Boolean.valueOf(post));
        aOY();
        aOZ();
        aOR();
        AppMethodBeat.o(133676);
    }

    private void aOR() {
        AppMethodBeat.i(133677);
        this.iVC = this.mContext.getResources().getDisplayMetrics().heightPixels / 4;
        this.iVD = this.iVC;
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d", Integer.valueOf(this.iVC), Integer.valueOf(this.iVD));
        AppMethodBeat.o(133677);
    }

    public final void aOS() {
        AppMethodBeat.i(133678);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", Boolean.valueOf(aOV()), Boolean.valueOf(this.iVR));
        if (aOV()) {
            if (this.iWf && this.iWg) {
                ay.gL(this.mContext);
            }
            this.iVU = true;
            this.iVM = false;
            this.mListView.removeCallbacks(this.iVW);
            ListView listView = this.mListView;
            AnonymousClass3 anonymousClass3 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133667);
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
                    a.this.mListView.smoothScrollBy(a.this.iVo.getTop(), 600);
                    a.e(a.this);
                    AppMethodBeat.o(133667);
                }
            };
            this.iVW = anonymousClass3;
            listView.post(anonymousClass3);
            if (this.iVQ) {
                com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b bVar = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZg;
                if (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPA()) {
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", Boolean.valueOf(this.iVI), Boolean.valueOf(this.iVJ));
                    if (!(this.iVI || this.iVJ)) {
                        this.iVI = true;
                        if (this.iVG != null) {
                            d.xDG.remove(this.iVG);
                        }
                        this.iVG = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(133675);
                                if (!c.jbx.eCM) {
                                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
                                    c cVar = c.jbx;
                                    if (!cVar.eCM) {
                                        cVar.eCM = true;
                                        ab.i("MicroMsg.Metronome", "[start] stack:%s", bo.dpG());
                                        cVar.bsZ.postFrameCallback(cVar);
                                    }
                                    com.tencent.mm.plugin.appbrand.widget.desktop.b.d dVar = com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz;
                                    synchronized (dVar.eCR) {
                                        try {
                                            if (dVar.isRunning) {
                                                ab.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
                                            } else {
                                                if (dVar.mTimer != null) {
                                                    dVar.mTimer.cancel();
                                                }
                                                System.gc();
                                                dVar.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
                                                dVar.eCQ.clear();
                                                dVar.eCQ.put(Integer.valueOf(1), new com.tencent.mm.plugin.appbrand.widget.desktop.b.a());
                                                dVar.mTimer.scheduleAtFixedRate(new TimerTask() {
                                                    public final void run() {
                                                        AppMethodBeat.i(134244);
                                                        synchronized (d.this.eCR) {
                                                            try {
                                                                if (d.this.isRunning) {
                                                                    for (b Px : d.this.eCQ.values()) {
                                                                        Px.Px();
                                                                    }
                                                                } else {
                                                                    ab.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                                                                    cancel();
                                                                }
                                                            } finally {
                                                                AppMethodBeat.o(134244);
                                                            }
                                                        }
                                                    }
                                                }, 0, 5);
                                                dVar.isRunning = true;
                                            }
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(133675);
                                        }
                                    }
                                    a.n(a.this);
                                }
                                AppMethodBeat.o(133675);
                            }
                        };
                        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
                        d.xDG.b(this.iVG, "AppBrandDesktopPerformanceMonitor");
                    }
                    AppMethodBeat.o(133678);
                    return;
                }
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
                AppMethodBeat.o(133678);
                return;
            }
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
            AppMethodBeat.o(133678);
            return;
        }
        AppMethodBeat.o(133678);
    }

    public final void qh(final int i) {
        AppMethodBeat.i(133679);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", Boolean.valueOf(aOV()), Integer.valueOf(i));
        this.iVM = true;
        eS(true);
        if (aOV()) {
            this.iVU = true;
            this.mListView.removeCallbacks(this.iVW);
            ListView listView = this.mListView;
            AnonymousClass4 anonymousClass4 = new Runnable() {
                public final void run() {
                    int h;
                    AppMethodBeat.i(133668);
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", Integer.valueOf(a.this.iVo.getBottom()), Integer.valueOf(a.this.iVo.getBottom()));
                    a.this.mListView.smoothScrollBy(a.this.iVo.getBottom(), a.this.iVO ? 10 : 600);
                    a.g(a.this);
                    a.this.iVO = false;
                    if (a.this.iVN != 0) {
                        h = a.this.iVN;
                        a.this.iVN = 0;
                    } else {
                        h = i;
                    }
                    a.b(a.this, h);
                    AppMethodBeat.o(133668);
                }
            };
            this.iVW = anonymousClass4;
            listView.post(anonymousClass4);
            AppMethodBeat.o(133679);
            return;
        }
        eR(false);
        AppMethodBeat.o(133679);
    }

    public final void c(long j, final int i, final boolean z) {
        AppMethodBeat.i(133680);
        super.c(j, i, z);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.iVF != null) {
            this.mListView.removeCallbacks(this.iVF);
        }
        ListView listView = this.mListView;
        AnonymousClass5 anonymousClass5 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(133669);
                a.this.iVO = z;
                a.this.qh(i);
                AppMethodBeat.o(133669);
            }
        };
        this.iVF = anonymousClass5;
        listView.postDelayed(anonymousClass5, j);
        AppMethodBeat.o(133680);
    }

    private boolean aOT() {
        AppMethodBeat.i(133681);
        int bottom = this.iVo.getBottom();
        if (aOW()) {
            if (this.iVs == 0) {
                this.iVs = (int) (((float) this.iVo.getHeight()) * this.iVq);
            }
            if (bottom < this.iVs) {
                AppMethodBeat.o(133681);
                return true;
            }
            AppMethodBeat.o(133681);
            return false;
        } else if (bottom > aOX()) {
            AppMethodBeat.o(133681);
            return true;
        } else {
            AppMethodBeat.o(133681);
            return false;
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(133682);
        if (motionEvent.getAction() == 0) {
            F(motionEvent);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.iVZ.set(motionEvent.getRawX(), motionEvent.getRawY());
            if (this.iVo != null && this.iVo.getBackUpFooterRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && aOW()) {
                if (this.iVN == 0) {
                    this.iVN = 12;
                }
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", Integer.valueOf(this.iVN));
            }
            onScrollStateChanged(this.mListView, -1);
        }
        AppMethodBeat.o(133682);
        return false;
    }

    public final void F(MotionEvent motionEvent) {
        AppMethodBeat.i(138153);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        this.mListView.removeCallbacks(this.iVW);
        this.mListView.removeCallbacks(this.iVF);
        this.iVY.set(motionEvent.getRawX(), motionEvent.getRawY());
        this.iVV = false;
        AppMethodBeat.o(138153);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(133683);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", Integer.valueOf(i), Boolean.valueOf(aOW()));
        this.iVA = true;
        int i2 = this.iVT;
        this.iVT = i;
        if (i == 0 || i == -1) {
            this.iVS = false;
            if (this.iVU && i == 0) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
                this.iVU = false;
                if (i2 == -1) {
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged checkOpen: %b", Boolean.valueOf(aOT()));
                    if (this.iVo.getBottom() < 200 || this.mListView.getFirstVisiblePosition() != 0 || this.iVR) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0 && aOT()) {
                        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged header is visible but not open");
                        this.iVM = false;
                        t(true, false);
                    }
                }
                AppMethodBeat.o(133683);
                return;
            } else if (aOT()) {
                aOS();
                AppMethodBeat.o(133683);
                return;
            } else if (aOW() && i == -1) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
                qh(4);
                AppMethodBeat.o(133683);
                return;
            } else if (i == -1) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
                qh(0);
                this.iVL = true;
                AppMethodBeat.o(133683);
                return;
            }
        } else if (i == 2) {
            this.iVX = true;
            this.iVS = true;
            AppMethodBeat.o(133683);
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
        AppMethodBeat.o(133683);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(133684);
        if (!absListView.isInLayout() || this.iVM || this.iVo.getBottom() >= this.iVo.getHeight() || !this.iVR) {
            int height;
            int i4;
            float f;
            if (this.iVV && !this.iVU && this.iVX && i <= 0 && aOV()) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
                this.mListView.scrollBy(0, 0);
                qh(4);
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
            ab.d(str, str2, objArr);
            if (!(this.iVV || i != 0 || this.iVo == null)) {
                ab.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", Integer.valueOf(0), Integer.valueOf(this.iVo.getBottom()), Integer.valueOf(this.iVu), Integer.valueOf(this.iVo.getHeight()), Integer.valueOf(this.iVo.getBottom()), Boolean.valueOf(this.iVA));
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
                            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
                            this.iVw.onResume();
                            this.iVz = false;
                        }
                    }
                }
                if (!this.iVP) {
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
                } else if (this.iJO != null) {
                    height = i4 - (this.iVo.getHeight() - this.iVC);
                    f = (((float) height) * 1.0f) / ((float) this.iVD);
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    float f2 = f > 1.0f ? 1.0f : f;
                    if (height >= 0) {
                        aw(0.0f);
                    } else {
                        aw(1.0f);
                    }
                    if (((double) Math.abs(1.0f - f2)) <= 0.01d) {
                        aw(0.0f);
                    } else {
                        aw(1.0f - f2);
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
                        absListView.setBackgroundColor(this.mContext.getResources().getColor(R.color.vz));
                        if (this.iVB != null) {
                            ab.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader show GradientBackgroundView");
                            this.iVB.setAlpha(1.0f);
                            this.iVB.setVisibility(0);
                        }
                    } else if (f2 == 1.0f) {
                        if (this.iVQ) {
                            aPa();
                        }
                        absListView.setBackgroundColor(this.mContext.getResources().getColor(R.color.a3p));
                    }
                }
            }
            if (this.mListView != null && ((VERSION.SDK_INT < 23 || h.Mt()) && VERSION.SDK_INT >= 21)) {
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
                        this.mListView.setBackgroundColor(this.mListView.getResources().getColor(R.color.a3p));
                        if (this.iVx != null) {
                            this.iVx.setBackgroundColor(this.mContext.getResources().getColor(R.color.a3p));
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
                    t(false, true);
                } else if (this.iWa && this.iVS) {
                    t(false, true);
                }
            }
            int aOX = aOX();
            if (this.iWd == null) {
                this.iWd = (GyroView) this.iVo.findViewById(R.id.bj);
            }
            if (this.iWe == null) {
                this.iWe = this.iVo.findViewById(R.id.k);
                this.iWe.setTranslationY((float) (aOX * 2));
            }
            height = this.iVo.getBottom();
            if ((!this.iVX && height >= 5) || this.iVL) {
                if (aOX >= height) {
                    this.iWd.b((float) height, aOX);
                    this.iWd.setTranslationY((float) ((((-height) / 2) + (this.iWd.getHeight() / 2)) + this.iVo.getPaddingBottom()));
                } else {
                    this.iWd.b((float) aOX, aOX);
                }
            }
            if (this.iWf) {
                f = (float) this.iVo.getHeight();
                int i5 = (int) (((((float) (aOX * 2)) * 1.0f) * ((float) height)) / f);
                this.iWe.setTranslationY((float) ((aOX * 2) - i5));
                ab.d("MicroMsg.AppBrandDesktopAnimController", "[transHeader] TranY:" + ((aOX * 2) - i5));
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
                eS(false);
            } else {
                eS(true);
            }
            al.af(this.iWb);
            al.n(this.iWb, 60);
            AppMethodBeat.o(133684);
            return;
        }
        ab.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
        qh(0);
        AppMethodBeat.o(133684);
    }

    public final void eQ(boolean z) {
        AppMethodBeat.i(133685);
        super.eQ(z);
        this.iVR = true;
        if (this.iVB != null && this.iVB.getVisibility() == 0) {
            this.iVB.invalidate();
        }
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", Boolean.valueOf(this.iVM), Boolean.valueOf(this.iVQ));
        if (this.aus == null) {
            AppMethodBeat.o(133685);
        } else if (this.iVM) {
            AppMethodBeat.o(133685);
        } else if (aOV()) {
            this.aus.animate().translationY((float) this.aus.getHeight()).setDuration(260).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133671);
                    a.this.aus.setVisibility(4);
                    a.this.aus.animate().setListener(null);
                    AppMethodBeat.o(133671);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.o(133685);
        } else {
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
            this.aus.setTranslationY(0.0f);
            AppMethodBeat.o(133685);
        }
    }

    public final void eR(boolean z) {
        AppMethodBeat.i(133686);
        super.eR(z);
        this.iVR = false;
        aOZ();
        aOU();
        if (this.aus == null) {
            AppMethodBeat.o(133686);
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
        translationY.setDuration(j).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(133672);
                a.this.aus.animate().setListener(null);
                a.this.aus.setTranslationY(0.0f);
                a.l(a.this);
                AppMethodBeat.o(133672);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(133673);
                a.this.aus.animate().setListener(null);
                a.this.aus.setTranslationY(0.0f);
                a.l(a.this);
                AppMethodBeat.o(133673);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.o(133686);
    }

    private void aOU() {
        AppMethodBeat.i(133687);
        if (this.iVE != null) {
            al.af(this.iVE);
        }
        if (this.iVK) {
            AnonymousClass9 anonymousClass9 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133674);
                    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayHideBackgroundView");
                    a.m(a.this);
                    AppMethodBeat.o(133674);
                }
            };
            this.iVE = anonymousClass9;
            al.n(anonymousClass9, 500);
            AppMethodBeat.o(133687);
            return;
        }
        aPb();
        AppMethodBeat.o(133687);
    }

    public final void gY() {
        AppMethodBeat.i(133688);
        aOR();
        this.iVP = false;
        AppMethodBeat.o(133688);
    }

    private void eS(boolean z) {
        AppMethodBeat.i(133689);
        if (this.iVo.isFullScreen() && z != this.iWc) {
            this.iWc = z;
            db dbVar = new db();
            dbVar.cwi.enable = z;
            com.tencent.mm.sdk.b.a.xxA.m(dbVar);
        }
        AppMethodBeat.o(133689);
    }

    public final boolean aOV() {
        AppMethodBeat.i(133690);
        if (this.iVo.getBottom() < 10 || this.mListView.getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(133690);
            return false;
        }
        AppMethodBeat.o(133690);
        return true;
    }

    private boolean aOW() {
        AppMethodBeat.i(133691);
        if (Math.abs(this.iVZ.y - this.iVY.y) <= 5.0f || this.iVZ.y <= this.iVY.y) {
            AppMethodBeat.o(133691);
            return true;
        }
        AppMethodBeat.o(133691);
        return false;
    }

    private int aOX() {
        AppMethodBeat.i(133692);
        if (this.iVr == 0) {
            this.iVr = (int) (((float) this.iVo.getHeight()) * this.iVp);
        }
        int i = this.iVr;
        AppMethodBeat.o(133692);
        return i;
    }

    private void aOY() {
        AppMethodBeat.i(133693);
        if (this.iWe != null) {
            this.iWe.setTranslationY((float) (aOX() * 2));
            this.iWe.setAlpha(0.0f);
        }
        this.iWh = true;
        this.iWf = true;
        AppMethodBeat.o(133693);
    }

    private void aOZ() {
        AppMethodBeat.i(133694);
        if (this.iWd != null) {
            this.iWd.b(0.0f, aOX());
            this.iWd.setTranslationY(0.0f);
        }
        AppMethodBeat.o(133694);
    }

    public final void setTabView(View view) {
        this.aus = view;
    }

    public final void cD(View view) {
        this.iJO = view;
    }

    private void aPa() {
        AppMethodBeat.i(133695);
        if (this.iVw != null) {
            this.iVw.setVisibility(0);
            this.iVw.setShowGradientView(false);
        }
        AppMethodBeat.o(133695);
    }

    private void aPb() {
        AppMethodBeat.i(133696);
        boolean z = this.iVQ;
        boolean z2 = b.aPe() && this.iVw != null;
        this.iVQ = z2;
        aPc();
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", Boolean.valueOf(this.iVQ), Boolean.valueOf(z));
        if (this.iVK && aOV()) {
            AppMethodBeat.o(133696);
            return;
        }
        if (z) {
            if (!(this.iVw == null || this.iVy)) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView onPause and set GONE");
                this.iVw.iZQ.onPause();
                this.iVy = true;
                this.iVz = true;
                this.iVw.setVisibility(8);
            }
        } else if (this.iVw != null) {
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView SurfaceView set GONE");
            this.iVw.setVisibility(8);
        }
        if (this.iVB != null) {
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo hideBackgroundView GradientColorView set GONE");
            this.iVB.setVisibility(8);
        }
        AppMethodBeat.o(133696);
    }

    public final void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a aVar) {
        this.iVv = aVar;
    }

    public final void e(View view, View view2) {
        AppMethodBeat.i(133697);
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
        AppMethodBeat.o(133697);
    }

    public final void setStatusBarMaskView(View view) {
        this.iVx = view;
    }

    private void aPc() {
        AppMethodBeat.i(133698);
        if (this.iVB instanceof GradientColorBackgroundView) {
            ((GradientColorBackgroundView) this.iVB).setUpdateMode(1);
        }
        AppMethodBeat.o(133698);
    }

    private void aw(float f) {
        AppMethodBeat.i(133699);
        if (this.iVv != null) {
            this.iVv.a(f, 0, 0, 0);
        }
        AppMethodBeat.o(133699);
    }

    public final void onResume() {
        AppMethodBeat.i(133700);
        super.onResume();
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d", Boolean.valueOf(aOV()), Integer.valueOf(this.iVo.getBottom()), Integer.valueOf(this.iVo.getHeight()));
        if (aOV() && this.iVo.getBottom() < this.iVo.getHeight()) {
            if (this.iVZ.y - this.iVY.y > 50.0f) {
                ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume openHeader");
                aOS();
                AppMethodBeat.o(133700);
                return;
            }
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume closeHeader");
            qh(4);
        }
        AppMethodBeat.o(133700);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133701);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
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
        d.xDG.remove("AppBrandDesktopPerformanceMonitor");
        com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz.Pz();
        com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz.release();
        this.iVI = false;
        AppMethodBeat.o(133701);
    }

    static /* synthetic */ void g(a aVar) {
        boolean z;
        if (aVar.iVO) {
            z = false;
        } else {
            z = true;
        }
        aVar.iVK = z;
    }

    static /* synthetic */ void n(a aVar) {
        AppMethodBeat.i(133706);
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayStopMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b, delay: %d", Boolean.valueOf(aVar.iVI), Boolean.valueOf(aVar.iVJ), Long.valueOf(10000));
        if (aVar.iVI && !aVar.iVJ) {
            if (aVar.iVH != null) {
                d.xDG.remove(aVar.iVH);
            }
            aVar.iVH = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133666);
                    if (c.jbx.eCM) {
                        com.tencent.mm.plugin.appbrand.widget.desktop.b.a aVar;
                        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor");
                        c cVar = c.jbx;
                        cVar.frameStartTime = 0;
                        cVar.eCJ = 0;
                        cVar.eCM = false;
                        ab.i("MicroMsg.Metronome", "[stop] stack:%s", bo.dpG());
                        cVar.bsZ.removeFrameCallback(cVar);
                        com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz.Pz();
                        com.tencent.mm.plugin.appbrand.widget.desktop.b.b bVar = (com.tencent.mm.plugin.appbrand.widget.desktop.b.b) com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz.eCQ.get(Integer.valueOf(1));
                        if (bVar instanceof com.tencent.mm.plugin.appbrand.widget.desktop.b.a) {
                            bVar.Pw();
                            aVar = (com.tencent.mm.plugin.appbrand.widget.desktop.b.a) bVar;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null) {
                            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor dump fps, max: %f, min: %f, average: %f", Double.valueOf(aVar.jbw), Double.valueOf(aVar.jbv), Double.valueOf(aVar.jbu));
                            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b bVar2 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZg;
                            double d = aVar.jbu;
                            ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps currentDrawFps: %d, appFps: %f", Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd), Double.valueOf(d));
                            if (d >= 45.0d) {
                                b.eT(true);
                                if (d >= 55.0d) {
                                    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd = 20;
                                } else if (d >= 50.0d) {
                                    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd = 15;
                                } else if (d >= 45.0d) {
                                    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd = 5;
                                }
                            } else if (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd == 2) {
                                ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps disable DynamicBackground");
                                b.eT(false);
                            } else {
                                com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd = 2;
                                b.eT(true);
                            }
                            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZf = (int) d;
                            SharedPreferences doB = ah.doB();
                            if (doB != null) {
                                Editor edit = doB.edit();
                                if (edit != null) {
                                    edit = edit.putInt("current_draw_fps", com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd);
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
                            ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps appFps: %f, FRAME_PER_SECOND: %d", Double.valueOf(d), Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.iZd));
                            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPB();
                        }
                        com.tencent.mm.plugin.appbrand.widget.desktop.b.d.jbz.release();
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(133665);
                                a.this.iVI = false;
                                a.this.iVJ = false;
                                AppMethodBeat.o(133665);
                            }
                        });
                    }
                    AppMethodBeat.o(133666);
                }
            };
            ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute stopMonitorRunnable");
            aVar.iVJ = true;
            d.xDG.b(aVar.iVH, "AppBrandDesktopPerformanceMonitor", 10000);
        }
        AppMethodBeat.o(133706);
    }
}
