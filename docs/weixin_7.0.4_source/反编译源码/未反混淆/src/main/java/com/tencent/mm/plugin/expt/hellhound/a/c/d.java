package com.tencent.mm.plugin.expt.hellhound.a.c;

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
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.j.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static volatile d lMX;
    private int acV = -1;
    private int iJp = -1;
    private AbsListView kSO = null;
    private Class<?> lMY;
    private Field lMZ;
    private Method lNa;
    private Field lNb;
    private OnScrollListener lNc;
    private a lNd;
    private int lNe = ViewConfiguration.get(ah.getContext()).getScaledTouchSlop();
    private Class<?> lNf;
    private Map<String, a> lNg;
    private cci lNh;
    private long lNi = 0;
    private e lNj;
    private c lNk;
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

    final class a implements OnScrollListener {
        Activity activity;

        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(73466);
            if (d.this.lNc != null) {
                d.this.lNc.onScrollStateChanged(absListView, i);
            }
            d.this.mScrollState = i;
            if (i == 1) {
                d.a(d.this, absListView);
                AppMethodBeat.o(73466);
            } else if (i == 2) {
                d.b(d.this, absListView);
                AppMethodBeat.o(73466);
            } else {
                if (i == 0) {
                    d.this.lNo = 0;
                }
                AppMethodBeat.o(73466);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.i(73467);
            if (d.this.lNc != null) {
                d.this.lNc.onScroll(absListView, i, i2, i3);
            }
            d.this.kSO = absListView;
            d.this.lNl = i2;
            d.a(d.this, this.activity, absListView, i2);
            AppMethodBeat.o(73467);
        }
    }

    private static d bqI() {
        AppMethodBeat.i(73468);
        if (lMX == null) {
            synchronized (d.class) {
                try {
                    if (lMX == null) {
                        lMX = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73468);
                    }
                }
            }
        }
        d dVar = lMX;
        AppMethodBeat.o(73468);
        return dVar;
    }

    @SuppressLint({"NewApi"})
    private d() {
        AppMethodBeat.i(73469);
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
            ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, TimelineMonitor OnScrollListener", new Object[0]);
        }
        this.lNd = new a(this, (byte) 0);
        this.lNg = new HashMap();
        AppMethodBeat.o(73469);
    }

    private void bqJ() {
        AppMethodBeat.i(73471);
        ab.i("TimelineMonitor", "habbyge-mali, reNewSession");
        this.lNh = new cci();
        this.lNh.xbJ = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.lNh.cvF = "1000".concat(String.valueOf(currentTimeMillis));
        this.lNh.xbK = 0;
        this.lNh.xbL = 0;
        this.lNg.clear();
        this.lNj = new e();
        this.lNk = new c();
        AppMethodBeat.o(73471);
    }

    private void bqK() {
        AppMethodBeat.i(73472);
        if (this.lNh == null) {
            AppMethodBeat.o(73472);
            return;
        }
        bqL();
        bqM();
        final cci cci = this.lNh;
        this.lNh = null;
        com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(73465);
                b.a(cci);
                AppMethodBeat.o(73465);
            }
        }, "_reportTimeline");
        AppMethodBeat.o(73472);
    }

    private void bqL() {
        AppMethodBeat.i(73473);
        ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime");
        if (this.lNj == null) {
            AppMethodBeat.o(73473);
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
            a(this.kSO, this.lNl, currentTimeMillis, false);
        }
        if (this.lNj.lNA > 0) {
            this.lNj.lNB = currentTimeMillis;
            if (this.lNh != null) {
                j = this.lNj.lNB - this.lNj.lNA;
                cci = this.lNh;
                cci.xbL = j + cci.xbL;
            } else {
                ab.e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 2");
            }
            this.lNj.bqO();
        }
        if (this.lNj.lNC > 0) {
            this.lNj.lND = currentTimeMillis;
            ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.endTimeFront = ".concat(String.valueOf(currentTimeMillis)));
            if (this.lNh != null) {
                j = this.lNj.lND - this.lNj.lNC;
                cci = this.lNh;
                cci.xbJ = j + cci.xbJ;
                ab.i("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mTimelineTime.frontTime = " + this.lNh.xbJ);
            } else {
                ab.e("TimelineMonitor", "habbyge-mali, _stopComputeTimelineSliceTime mSnsTimeline = NULL 3");
            }
            this.lNj.bqP();
        }
        AppMethodBeat.o(73473);
    }

    private void bqM() {
        AppMethodBeat.i(73474);
        if (this.lNg == null || this.lNg.isEmpty()) {
            AppMethodBeat.o(73474);
            return;
        }
        ab.i("TimelineMonitor", "habbyge-mali, _moveMonitoringFeed2ReadyReport");
        for (Entry entry : this.lNg.entrySet()) {
            if (entry != null) {
                a aVar = (a) entry.getValue();
                if (!(aVar == null || this.lNh == null)) {
                    this.lNh.xbM.add(aVar.lMV);
                }
            }
        }
        this.lNg.clear();
        AppMethodBeat.o(73474);
    }

    private void L(Activity activity) {
        AppMethodBeat.i(73475);
        ab.i("TimelineMonitor", "habbyge-mali, restoreScrollListener");
        try {
            this.lMZ.set((ListView) this.lNa.invoke(this.lNb.get(activity), new Object[0]), this.lNc);
            AppMethodBeat.o(73475);
        } catch (Exception e) {
            ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, restoreScrollListener", new Object[0]);
            AppMethodBeat.o(73475);
        }
    }

    private void a(AbsListView absListView, int i, long j, boolean z) {
        AppMethodBeat.i(73476);
        if (absListView == null) {
            AppMethodBeat.o(73476);
            return;
        }
        if (this.lNk.startTime > 0) {
            this.lNk.endTime = j;
            long j2 = this.lNk.endTime - this.lNk.startTime;
            if (j2 <= 0) {
                AppMethodBeat.o(73476);
                return;
            }
            c a = a(absListView, i);
            Map map = (Map) a.get(0);
            int intValue = ((Integer) a.get(1)).intValue();
            if (intValue <= 0) {
                AppMethodBeat.o(73476);
                return;
            }
            double d = ((double) j2) / ((double) intValue);
            for (Entry entry : map.entrySet()) {
                a aVar = (a) entry.getKey();
                if (((Boolean) entry.getValue()).booleanValue()) {
                    if (this.lNg.containsKey(aVar.lMV.feedId)) {
                        a aVar2 = (a) this.lNg.get(aVar.lMV.feedId);
                        if (aVar2 != null) {
                            caz caz = aVar2.lMV;
                            caz.xai += d;
                            caz = aVar2.lMV;
                            caz.xaj += (double) j2;
                            a(aVar2, aVar);
                            this.lNg.put(aVar.lMV.feedId, aVar2);
                        }
                    } else {
                        aVar.lMV.xai = d;
                        aVar.lMV.xaj = (double) j2;
                        this.lNg.put(aVar.lMV.feedId, aVar);
                    }
                }
            }
            if (z) {
                this.lNk.startTime = j;
                AppMethodBeat.o(73476);
                return;
            }
            this.lNk.startTime = 0;
        }
        AppMethodBeat.o(73476);
    }

    private static void a(a aVar, a aVar2) {
        aVar.lMV.y = aVar2.lMV.y;
        aVar.lMV.height = aVar2.lMV.height;
        aVar.lMV.lqq = aVar2.lMV.lqq;
        aVar.lMV.rBZ = aVar2.lMV.rBZ;
        aVar.lMV.iev = aVar2.lMV.iev;
        aVar.lMV.xae = aVar2.lMV.xae;
    }

    private c<Map<a, Boolean>, Integer> a(AbsListView absListView, int i) {
        AppMethodBeat.i(73477);
        HashMap hashMap = new HashMap();
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0) {
            int i4;
            View childAt = absListView.getChildAt(i2);
            if (this.lNf.isInstance(childAt)) {
                c di = di(childAt);
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
        c F = com.tencent.mm.vending.j.a.F(hashMap, Integer.valueOf(i3));
        AppMethodBeat.o(73477);
        return F;
    }

    private c<a, Boolean> di(View view) {
        AppMethodBeat.i(73478);
        String dl = dl(view);
        c dj = dj(view);
        int intValue = ((Integer) dj.get(0)).intValue();
        int intValue2 = ((Integer) dj.get(1)).intValue();
        a aVar = new a();
        aVar.lMV = new caz();
        aVar.lMV.feedId = dl;
        aVar.lMV.y = intValue;
        aVar.lMV.height = intValue2;
        aVar.lMV.iev = this.lNv;
        aVar.lMV.xae = this.lNv - this.mScreenHeight;
        aVar.lMV.qDY = this.iJp;
        aVar.lMV.xaf = this.acV <= 0 ? 144 : this.acV;
        aVar.lMV.lqq = this.mScrollState;
        aVar.lMV.rBZ = this.lNo;
        c F = com.tencent.mm.vending.j.a.F(aVar, Boolean.valueOf(aVar.bqH()));
        AppMethodBeat.o(73478);
        return F;
    }

    private static c<Integer, Integer> dj(View view) {
        AppMethodBeat.i(73479);
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        c F = com.tencent.mm.vending.j.a.F(Integer.valueOf(iArr[1]), Integer.valueOf(height));
        AppMethodBeat.o(73479);
        return F;
    }

    private static int dk(View view) {
        AppMethodBeat.i(73480);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        AppMethodBeat.o(73480);
        return i;
    }

    private String dl(View view) {
        AppMethodBeat.i(73481);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(73481);
            return null;
        }
        try {
            if (this.lNs.isInstance(tag)) {
                tag = this.lNt.get(tag);
                if (tag == null) {
                    AppMethodBeat.o(73481);
                    return null;
                }
                String str;
                try {
                    str = (String) this.lNu.get(tag);
                } catch (Exception e) {
                    ab.printErrStackTrace("TimelineMonitor", e, "habbyge-mali, getFeedParams.feedId: ", new Object[0]);
                    str = null;
                }
                AppMethodBeat.o(73481);
                return str;
            }
            AppMethodBeat.o(73481);
            return null;
        } catch (Exception e2) {
            AppMethodBeat.o(73481);
            return null;
        }
    }

    public static void a(int i, String str, Activity activity) {
        AppMethodBeat.i(73470);
        if (!"com.tencent.mm.plugin.sns.ui.SnsTimeLineUI".equals(str)) {
            AppMethodBeat.o(73470);
        } else if (com.tencent.mm.plugin.expt.hellhound.a.bql()) {
            d bqI = bqI();
            switch (i) {
                case 0:
                    Display defaultDisplay;
                    ab.i("TimelineMonitor", "habbyge-mali, TimelineMonitor.startMonitor");
                    bqI.mScrollState = 0;
                    if (bqI.iJp <= 0) {
                        Resources resources = activity.getResources();
                        bqI.iJp = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
                        if (bqI.iJp <= 0) {
                            bqI.iJp = resources.getDimensionPixelSize(R.dimen.a1m);
                        }
                        ab.i("TimelineMonitor", "habbyge-mali, initStatusBarHeight: " + bqI.iJp);
                    }
                    try {
                        if (bqI.lca == null) {
                            bqI.lca = (WindowManager) ah.getContext().getSystemService("window");
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
                    ab.i("TimelineMonitor", "habbyge-mali, initScreenHeight = " + bqI.mScreenHeight + " / " + bqI.lNv);
                    int bqA = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.bqA();
                    ab.i("TimelineMonitor", "habbyge-mali, startMonitor activityMethod: ".concat(String.valueOf(bqA)));
                    switch (bqA) {
                        case 0:
                            bqI.bqJ();
                            break;
                        case 1:
                            ab.d("TimelineMonitor", "habbyge-mali, ActivityActionWrapper.FINISH_ACTIVITY");
                            break;
                        case 7:
                            if (System.currentTimeMillis() - bqI.lNi <= 30000) {
                                ab.i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: Old Session");
                                break;
                            }
                            ab.i("TimelineMonitor", "habbyge-mali, _handleActivityMethod.BACK_2_FRONT: New Session");
                            bqI.bqK();
                            bqI.bqJ();
                            break;
                    }
                    if (activity == null || activity.isFinishing()) {
                        AppMethodBeat.o(73470);
                        return;
                    }
                    bqI.lNd.activity = activity;
                    try {
                        ListView listView = (ListView) bqI.lNa.invoke(bqI.lNb.get(activity), new Object[0]);
                        bqI.lNc = (OnScrollListener) bqI.lMZ.get(listView);
                        if (bqI.lNc instanceof a) {
                            ab.i("TimelineMonitor", "habbyge-mali, mOldScrollListener is OnProxyScrollListener !!");
                            AppMethodBeat.o(73470);
                            return;
                        }
                        ab.i("TimelineMonitor", "habbyge-mali, oldScrollListener: " + bqI.lNc);
                        listView.setOnScrollListener(bqI.lNd);
                        AppMethodBeat.o(73470);
                        return;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("TimelineMonitor", e2, "habbyge-mali, setProxyScrollListener", new Object[0]);
                        AppMethodBeat.o(73470);
                        return;
                    }
                case 1:
                    ab.i("TimelineMonitor", "habbyge-mali, stopMonitor");
                    try {
                        switch (com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.bqA()) {
                            case 0:
                                ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.START_ACTIVITY");
                                bqI.bqL();
                                break;
                            case 1:
                                ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.FINISH_ACTIVITY");
                                bqI.bqK();
                                break;
                            case 8:
                                bqI.bqL();
                                bqI.lNi = System.currentTimeMillis();
                                ab.i("TimelineMonitor", "habbyge-mali, stopMonitor.FRONT_2_BACK");
                                break;
                        }
                        bqI.L(activity);
                        if (bqI.lNd != null) {
                            bqI.lNd.activity = null;
                            AppMethodBeat.o(73470);
                            return;
                        }
                        AppMethodBeat.o(73470);
                        return;
                    } catch (Throwable th) {
                        bqI.L(activity);
                        if (bqI.lNd != null) {
                            bqI.lNd.activity = null;
                        }
                        AppMethodBeat.o(73470);
                    }
                case 2:
                    ab.i("TimelineMonitor", "habbyge-mali, TimelineMonitor, freeOnDestroy !");
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
                    AppMethodBeat.o(73470);
                    return;
                case 3:
                    bqI.bqK();
                    break;
            }
            AppMethodBeat.o(73470);
        } else {
            AppMethodBeat.o(73470);
        }
    }
}
