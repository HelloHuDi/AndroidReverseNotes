package com.tencent.p177mm.plugin.expt.hellhound.p958a.p960c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.expt.hellhound.C11755a;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.C27897a;
import com.tencent.p177mm.protocal.protobuf.caz;
import com.tencent.p177mm.protocal.protobuf.cci;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.c.d */
public final class C27893d {
    private static volatile C27893d lMX;
    private int acV = -1;
    private int iJp = -1;
    private AbsListView kSO = null;
    private Class<?> lMY;
    private Field lMZ;
    private Method lNa;
    private Field lNb;
    private OnScrollListener lNc;
    private C20597a lNd;
    private int lNe = ViewConfiguration.get(C4996ah.getContext()).getScaledTouchSlop();
    private Class<?> lNf;
    private Map<String, C34075a> lNg;
    private cci lNh;
    private long lNi = 0;
    private C20598e lNj;
    private C11754c lNk;
    private int lNl = 0;
    private Field lNm;
    private int lNn = 0;
    private int lNo = 0;
    private int lNp = -1;
    private long lNq = 0;
    private String lNr = "";
    private Class<?> lNs;
    private Field lNt;
    private Field lNu;
    private int lNv = 0;
    private WindowManager lca = null;
    private long mLastTimestamp = -1;
    private int mScreenHeight = 0;
    private int mScrollState = 0;

    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.c.d$a */
    final class C20597a implements OnScrollListener {
        Activity activity;

        private C20597a() {
        }

        /* synthetic */ C20597a(C27893d c27893d, byte b) {
            this();
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(73466);
            if (C27893d.this.lNc != null) {
                C27893d.this.lNc.onScrollStateChanged(absListView, i);
            }
            C27893d.this.mScrollState = i;
            if (i == 1) {
                C27893d.m44348a(C27893d.this, absListView);
                AppMethodBeat.m2505o(73466);
            } else if (i == 2) {
                C27893d.m44351b(C27893d.this, absListView);
                AppMethodBeat.m2505o(73466);
            } else {
                if (i == 0) {
                    C27893d.this.lNo = 0;
                }
                AppMethodBeat.m2505o(73466);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(73467);
            if (C27893d.this.lNc != null) {
                C27893d.this.lNc.onScroll(absListView, i, i2, i3);
            }
            C27893d.this.kSO = absListView;
            C27893d.this.lNl = i2;
            C27893d.m44347a(C27893d.this, this.activity, absListView, i2);
            AppMethodBeat.m2505o(73467);
        }
    }

    private static C27893d bqI() {
        AppMethodBeat.m2504i(73468);
        if (lMX == null) {
            synchronized (C27893d.class) {
                try {
                    if (lMX == null) {
                        lMX = new C27893d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73468);
                    }
                }
            }
        }
        C27893d c27893d = lMX;
        AppMethodBeat.m2505o(73468);
        return c27893d;
    }

    @SuppressLint({"NewApi"})
    private C27893d() {
        AppMethodBeat.m2504i(73469);
        try {
            this.lMY = Class.forName("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
            this.lNb = this.lMY.getDeclaredField("mUIAction");
            this.lNb.setAccessible(true);
            this.lNa = Class.forName("com.tencent.mm.plugin.sns.ui.SnsUIAction").getDeclaredMethod("getSnsListView", new Class[0]);
            this.lNa.setAccessible(true);
            this.lMZ = AbsListView.class.getDeclaredField("mOnScrollListener");
            this.lMZ.setAccessible(true);
            this.lNf = Class.forName("com.tencent.mm.plugin.sns.ui.AdFrameLayout");
            this.lNm = AbsListView.class.getDeclaredField("mMotionY");
            this.lNm.setAccessible(true);
            this.lNs = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
            this.lNt = this.lNs.getDeclaredField("timeLineObject");
            this.lNt.setAccessible(true);
            this.lNu = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
            this.lNu.setAccessible(true);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, TimelineMonitor OnScrollListener", new Object[0]);
        }
        this.lNd = new C20597a(this, (byte) 0);
        this.lNg = new HashMap();
        AppMethodBeat.m2505o(73469);
    }

    private void bqJ() {
        AppMethodBeat.m2504i(73471);
        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, reNewSession");
        this.lNh = new cci();
        this.lNh.xbJ = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.lNh.cvF = "1000".concat(String.valueOf(currentTimeMillis));
        this.lNh.xbK = 0;
        this.lNh.xbL = 0;
        this.lNg.clear();
        this.lNj = new C20598e();
        this.lNk = new C11754c();
        AppMethodBeat.m2505o(73471);
    }

    private void bqK() {
        AppMethodBeat.m2504i(73472);
        if (this.lNh == null) {
            AppMethodBeat.m2505o(73472);
            return;
        }
        bqL();
        bqM();
        final cci cci = this.lNh;
        this.lNh = null;
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(73465);
                C11753b.m19563a(cci);
                AppMethodBeat.m2505o(73465);
            }
        }, "_reportTimeline");
        AppMethodBeat.m2505o(73472);
    }

    private void bqL() {
        AppMethodBeat.m2504i(73473);
        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime");
        if (this.lNj == null) {
            AppMethodBeat.m2505o(73473);
            return;
        }
        long j;
        cci cci;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lNj.lNy > 0) {
            this.lNj.lNz = currentTimeMillis;
            if (this.lNh != null) {
                j = this.lNj.lNz - this.lNj.lNy;
                cci = this.lNh;
                cci.xbK = j + cci.xbK;
            }
            this.lNj.bqN();
            m44345a(this.kSO, this.lNl, currentTimeMillis, false);
        }
        if (this.lNj.lNA > 0) {
            this.lNj.lNB = currentTimeMillis;
            if (this.lNh != null) {
                j = this.lNj.lNB - this.lNj.lNA;
                cci = this.lNh;
                cci.xbL = j + cci.xbL;
            } else {
                C4990ab.m7412e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 2");
            }
            this.lNj.bqO();
        }
        if (this.lNj.lNC > 0) {
            this.lNj.lND = currentTimeMillis;
            C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.endTimeFront = ".concat(String.valueOf(currentTimeMillis)));
            if (this.lNh != null) {
                j = this.lNj.lND - this.lNj.lNC;
                cci = this.lNh;
                cci.xbJ = j + cci.xbJ;
                C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.frontTime = " + this.lNh.xbJ);
            } else {
                C4990ab.m7412e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 3");
            }
            this.lNj.bqP();
        }
        AppMethodBeat.m2505o(73473);
    }

    private void bqM() {
        AppMethodBeat.m2504i(73474);
        if (this.lNg == null || this.lNg.isEmpty()) {
            AppMethodBeat.m2505o(73474);
            return;
        }
        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _moveMonitoringFeed2ReadyReport");
        for (Entry entry : this.lNg.entrySet()) {
            if (entry != null) {
                C34075a c34075a = (C34075a) entry.getValue();
                if (!(c34075a == null || this.lNh == null)) {
                    this.lNh.xbM.add(c34075a.lMV);
                }
            }
        }
        this.lNg.clear();
        AppMethodBeat.m2505o(73474);
    }

    /* renamed from: L */
    private void m44340L(Activity activity) {
        AppMethodBeat.m2504i(73475);
        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, restoreScrollListener");
        try {
            this.lMZ.set((ListView) this.lNa.invoke(this.lNb.get(activity), new Object[0]), this.lNc);
            AppMethodBeat.m2505o(73475);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, restoreScrollListener", new Object[0]);
            AppMethodBeat.m2505o(73475);
        }
    }

    /* renamed from: a */
    private void m44345a(AbsListView absListView, int i, long j, boolean z) {
        AppMethodBeat.m2504i(73476);
        if (absListView == null) {
            AppMethodBeat.m2505o(73476);
            return;
        }
        if (this.lNk.startTime > 0) {
            this.lNk.endTime = j;
            long j2 = this.lNk.endTime - this.lNk.startTime;
            if (j2 <= 0) {
                AppMethodBeat.m2505o(73476);
                return;
            }
            C7583c a = m44343a(absListView, i);
            Map map = (Map) a.get(0);
            int intValue = ((Integer) a.get(1)).intValue();
            if (intValue <= 0) {
                AppMethodBeat.m2505o(73476);
                return;
            }
            double d = ((double) j2) / ((double) intValue);
            for (Entry entry : map.entrySet()) {
                C34075a c34075a = (C34075a) entry.getKey();
                if (((Boolean) entry.getValue()).booleanValue()) {
                    if (this.lNg.containsKey(c34075a.lMV.feedId)) {
                        C34075a c34075a2 = (C34075a) this.lNg.get(c34075a.lMV.feedId);
                        if (c34075a2 != null) {
                            caz caz = c34075a2.lMV;
                            caz.xai += d;
                            caz = c34075a2.lMV;
                            caz.xaj += (double) j2;
                            C27893d.m44346a(c34075a2, c34075a);
                            this.lNg.put(c34075a.lMV.feedId, c34075a2);
                        }
                    } else {
                        c34075a.lMV.xai = d;
                        c34075a.lMV.xaj = (double) j2;
                        this.lNg.put(c34075a.lMV.feedId, c34075a);
                    }
                }
            }
            if (z) {
                this.lNk.startTime = j;
                AppMethodBeat.m2505o(73476);
                return;
            }
            this.lNk.startTime = 0;
        }
        AppMethodBeat.m2505o(73476);
    }

    /* renamed from: a */
    private static void m44346a(C34075a c34075a, C34075a c34075a2) {
        c34075a.lMV.f17916y = c34075a2.lMV.f17916y;
        c34075a.lMV.height = c34075a2.lMV.height;
        c34075a.lMV.lqq = c34075a2.lMV.lqq;
        c34075a.lMV.rBZ = c34075a2.lMV.rBZ;
        c34075a.lMV.iev = c34075a2.lMV.iev;
        c34075a.lMV.xae = c34075a2.lMV.xae;
    }

    /* renamed from: a */
    private C7583c<Map<C34075a, Boolean>, Integer> m44343a(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(73477);
        HashMap hashMap = new HashMap();
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0) {
            int i4;
            View childAt = absListView.getChildAt(i2);
            if (this.lNf.isInstance(childAt)) {
                C7583c di = m44353di(childAt);
                boolean booleanValue = ((Boolean) di.get(1)).booleanValue();
                hashMap.put(di.get(0), Boolean.valueOf(booleanValue));
                if (booleanValue) {
                    i4 = i3 + 1;
                    i2--;
                    i3 = i4;
                }
            }
            i4 = i3;
            i2--;
            i3 = i4;
        }
        C7583c F = C5710a.m8574F(hashMap, Integer.valueOf(i3));
        AppMethodBeat.m2505o(73477);
        return F;
    }

    /* renamed from: di */
    private C7583c<C34075a, Boolean> m44353di(View view) {
        AppMethodBeat.m2504i(73478);
        String dl = m44356dl(view);
        C7583c dj = C27893d.m44354dj(view);
        int intValue = ((Integer) dj.get(0)).intValue();
        int intValue2 = ((Integer) dj.get(1)).intValue();
        C34075a c34075a = new C34075a();
        c34075a.lMV = new caz();
        c34075a.lMV.feedId = dl;
        c34075a.lMV.f17916y = intValue;
        c34075a.lMV.height = intValue2;
        c34075a.lMV.iev = this.lNv;
        c34075a.lMV.xae = this.lNv - this.mScreenHeight;
        c34075a.lMV.qDY = this.iJp;
        c34075a.lMV.xaf = this.acV <= 0 ? 144 : this.acV;
        c34075a.lMV.lqq = this.mScrollState;
        c34075a.lMV.rBZ = this.lNo;
        C7583c F = C5710a.m8574F(c34075a, Boolean.valueOf(c34075a.bqH()));
        AppMethodBeat.m2505o(73478);
        return F;
    }

    /* renamed from: dj */
    private static C7583c<Integer, Integer> m44354dj(View view) {
        AppMethodBeat.m2504i(73479);
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        C7583c F = C5710a.m8574F(Integer.valueOf(iArr[1]), Integer.valueOf(height));
        AppMethodBeat.m2505o(73479);
        return F;
    }

    /* renamed from: dk */
    private static int m44355dk(View view) {
        AppMethodBeat.m2504i(73480);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        AppMethodBeat.m2505o(73480);
        return i;
    }

    /* renamed from: dl */
    private String m44356dl(View view) {
        AppMethodBeat.m2504i(73481);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.m2505o(73481);
            return null;
        }
        try {
            if (this.lNs.isInstance(tag)) {
                tag = this.lNt.get(tag);
                if (tag == null) {
                    AppMethodBeat.m2505o(73481);
                    return null;
                }
                String str;
                try {
                    str = (String) this.lNu.get(tag);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, getFeedParams.feedId: ", new Object[0]);
                    str = null;
                }
                AppMethodBeat.m2505o(73481);
                return str;
            }
            AppMethodBeat.m2505o(73481);
            return null;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(73481);
            return null;
        }
    }

    /* renamed from: a */
    public static void m44344a(int i, String str, Activity activity) {
        AppMethodBeat.m2504i(73470);
        if (!"com.tencent.mm.plugin.sns.ui.SnsTimeLineUI".equals(str)) {
            AppMethodBeat.m2505o(73470);
        } else if (C11755a.bql()) {
            C27893d bqI = C27893d.bqI();
            switch (i) {
                case 0:
                    Display defaultDisplay;
                    C4990ab.m7416i("TimelineMonitor", "habbyge-mali, TimelineMonitor.startMonitor");
                    bqI.mScrollState = 0;
                    if (bqI.iJp <= 0) {
                        Resources resources = activity.getResources();
                        bqI.iJp = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
                        if (bqI.iJp <= 0) {
                            bqI.iJp = resources.getDimensionPixelSize(C25738R.dimen.a1m);
                        }
                        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, initStatusBarHeight: " + bqI.iJp);
                    }
                    try {
                        if (bqI.lca == null) {
                            bqI.lca = (WindowManager) C4996ah.getContext().getSystemService("window");
                        }
                        defaultDisplay = bqI.lca.getDefaultDisplay();
                    } catch (Exception e) {
                        defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                    }
                    Point point = new Point();
                    if (VERSION.SDK_INT >= 13) {
                        defaultDisplay.getSize(point);
                    }
                    Point point2 = new Point();
                    if (VERSION.SDK_INT >= 17) {
                        defaultDisplay.getRealSize(point2);
                    }
                    bqI.mScreenHeight = point.y;
                    bqI.lNv = point2.y;
                    C4990ab.m7416i("TimelineMonitor", "habbyge-mali, initScreenHeight = " + bqI.mScreenHeight + " / " + bqI.lNv);
                    int bqA = C27897a.bqA();
                    C4990ab.m7416i("TimelineMonitor", "habbyge-mali, startMonitor activityMethod: ".concat(String.valueOf(bqA)));
                    switch (bqA) {
                        case 0:
                            bqI.bqJ();
                            break;
                        case 1:
                            C4990ab.m7410d("TimelineMonitor", "habbyge-mali, ActivityActionWrapper.FINISH_ACTIVITY");
                            break;
                        case 7:
                            if (System.currentTimeMillis() - bqI.lNi <= 30000) {
                                C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: Old Session");
                                break;
                            }
                            C4990ab.m7416i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: New Session");
                            bqI.bqK();
                            bqI.bqJ();
                            break;
                    }
                    if (activity == null || activity.isFinishing()) {
                        AppMethodBeat.m2505o(73470);
                        return;
                    }
                    bqI.lNd.activity = activity;
                    try {
                        ListView listView = (ListView) bqI.lNa.invoke(bqI.lNb.get(activity), new Object[0]);
                        bqI.lNc = (OnScrollListener) bqI.lMZ.get(listView);
                        if (bqI.lNc instanceof C20597a) {
                            C4990ab.m7416i("TimelineMonitor", "habbyge-mali, mOldScrollListener is OnProxyScrollListener !!");
                            AppMethodBeat.m2505o(73470);
                            return;
                        }
                        C4990ab.m7416i("TimelineMonitor", "habbyge-mali, oldScrollListener: " + bqI.lNc);
                        listView.setOnScrollListener(bqI.lNd);
                        AppMethodBeat.m2505o(73470);
                        return;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("TimelineMonitor", e2, "habbyge-mali, setProxyScrollListener", new Object[0]);
                        AppMethodBeat.m2505o(73470);
                        return;
                    }
                case 1:
                    C4990ab.m7416i("TimelineMonitor", "habbyge-mali, stopMonitor");
                    try {
                        switch (C27897a.bqA()) {
                            case 0:
                                C4990ab.m7416i("TimelineMonitor", "habbyge-mali, stopMonitor.START_ACTIVITY");
                                bqI.bqL();
                                break;
                            case 1:
                                C4990ab.m7416i("TimelineMonitor", "habbyge-mali, stopMonitor.FINISH_ACTIVITY");
                                bqI.bqK();
                                break;
                            case 8:
                                bqI.bqL();
                                bqI.lNi = System.currentTimeMillis();
                                C4990ab.m7416i("TimelineMonitor", "habbyge-mali, stopMonitor.FRONT_2_BACK");
                                break;
                        }
                        bqI.m44340L(activity);
                        if (bqI.lNd != null) {
                            bqI.lNd.activity = null;
                            AppMethodBeat.m2505o(73470);
                            return;
                        }
                        AppMethodBeat.m2505o(73470);
                        return;
                    } catch (Throwable th) {
                        bqI.m44340L(activity);
                        if (bqI.lNd != null) {
                            bqI.lNd.activity = null;
                        }
                        AppMethodBeat.m2505o(73470);
                    }
                case 2:
                    C4990ab.m7416i("TimelineMonitor", "habbyge-mali, TimelineMonitor, freeOnDestroy !");
                    bqI.lMY = null;
                    bqI.lNc = null;
                    bqI.lNd = null;
                    if (bqI.lNg != null) {
                        bqI.lNg.clear();
                    }
                    bqI.lNh = null;
                    bqI.lca = null;
                    bqI.kSO = null;
                    lMX = null;
                    AppMethodBeat.m2505o(73470);
                    return;
                case 3:
                    bqI.bqK();
                    break;
            }
            AppMethodBeat.m2505o(73470);
        } else {
            AppMethodBeat.m2505o(73470);
        }
    }
}
