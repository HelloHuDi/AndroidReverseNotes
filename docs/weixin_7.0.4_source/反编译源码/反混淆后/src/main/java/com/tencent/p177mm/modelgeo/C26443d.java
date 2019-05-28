package com.tencent.p177mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelgeo.C42207b.C42208b;
import com.tencent.p177mm.modelgeo.C45449h.C42209a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.modelgeo.d */
public final class C26443d implements C42207b {
    public static C26443d fwu;
    double bDJ = 0.0d;
    List<WeakReference<C42206a>> bkF = new ArrayList();
    public boolean fBD = false;
    C45449h fBE;
    long fBF = 0;
    long fBG = 0;
    boolean fBH = false;
    boolean fBI = false;
    double fBJ = 23.0d;
    double fBK = 100.0d;
    int fBL = 0;
    double fBM = 0.0d;
    double fBN = 0.0d;
    String fBO;
    String fBP;
    int fBQ;
    private boolean fBR = false;
    private boolean fBS = false;
    private C26447f fBT = new C264441();
    private C37940g fBU = new C264462();
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private Context mContext;

    /* renamed from: com.tencent.mm.modelgeo.d$1 */
    class C264441 extends C26447f {
        C264441() {
        }

        /* renamed from: a */
        public final void mo44209a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
            AppMethodBeat.m2504i(78125);
            C26443d.m42101a(C26443d.this, z, d, d2, d4, true);
            if (z) {
                C26443d.this.fBJ = d;
                C26443d.this.fBK = d2;
                C26443d.this.fBL = i;
                C26443d.this.fBM = d3;
                C26443d.this.fBN = d4;
                C26443d.this.bDJ = d5;
                C26443d.this.fBO = str;
                C26443d.this.fBP = str2;
                C26443d.this.fBQ = i2;
                C26443d.this.fBG = System.currentTimeMillis();
                C26443d.this.fBH = true;
                C26443d.this.fBI = false;
                C26443d.m42100a(C26443d.this, 67592);
            }
            C4990ab.m7411d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i3 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78124);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", C26443d.this.fBP);
                    bundle.putString("indoor_building_id", C26443d.this.fBO);
                    bundle.putInt("indoor_building_type", C26443d.this.fBQ);
                    C26443d.m42102a(C26443d.this, z2, d6, d7, i3, d8, d9, d10, bundle);
                    AppMethodBeat.m2505o(78124);
                }
            });
            AppMethodBeat.m2505o(78125);
        }

        public final void onStatusUpdate(String str, int i, String str2) {
            AppMethodBeat.m2504i(78126);
            C4990ab.m7417i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(78126);
        }
    }

    /* renamed from: com.tencent.mm.modelgeo.d$2 */
    class C264462 extends C37940g {
        C264462() {
        }

        /* renamed from: a */
        public final void mo44211a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
            AppMethodBeat.m2504i(78128);
            C26443d.m42101a(C26443d.this, z, d, d2, d4, false);
            if (z) {
                C26443d.this.fBJ = d;
                C26443d.this.fBK = d2;
                C26443d.this.fBL = i;
                C26443d.this.fBM = d3;
                C26443d.this.fBN = d4;
                C26443d.this.bDJ = d5;
                C26443d.this.fBO = str;
                C26443d.this.fBP = str2;
                C26443d.this.fBQ = i2;
                C26443d.this.fBI = true;
                C26443d.this.fBH = false;
                C26443d.this.fBG = System.currentTimeMillis();
                C26443d.m42100a(C26443d.this, 67591);
            }
            C4990ab.m7411d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i3 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new C7306ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78127);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", C26443d.this.fBP);
                    bundle.putString("indoor_building_id", C26443d.this.fBO);
                    bundle.putInt("indoor_building_type", C26443d.this.fBQ);
                    C26443d.m42102a(C26443d.this, z2, d6, d7, i3, d8, d9, d10, bundle);
                    AppMethodBeat.m2505o(78127);
                }
            }, 200);
            AppMethodBeat.m2505o(78128);
        }
    }

    public static C26443d agz() {
        AppMethodBeat.m2504i(78130);
        if (fwu == null) {
            fwu = new C26443d(C4996ah.getContext());
        }
        C26443d c26443d = fwu;
        AppMethodBeat.m2505o(78130);
        return c26443d;
    }

    private C26443d(Context context) {
        AppMethodBeat.m2504i(78131);
        this.mContext = context;
        this.fBE = C45449h.m83721bY(context);
        AppMethodBeat.m2505o(78131);
    }

    /* renamed from: a */
    public final void mo44204a(C42206a c42206a, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(78132);
        C4990ab.m7417i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", c42206a, Boolean.valueOf(z), Integer.valueOf(0));
        if (this.fBD && this.bkF.size() > 0) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                C45449h.agE();
                C45449h.m83720a(this.fBU, 0, Looper.getMainLooper());
            } catch (C42209a e) {
                C4990ab.m7410d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.fBD = false;
        for (WeakReference weakReference : this.bkF) {
            if (weakReference != null && weakReference.get() != null && ((C42206a) weakReference.get()).equals(c42206a)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.bkF.add(new WeakReference(c42206a));
        }
        C4990ab.m7417i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.bkF.size()));
        if (this.bkF.size() == 1 && obj2 != null) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                C45449h.m83720a(this.fBU, 0, Looper.getMainLooper());
            } catch (C42209a e2) {
                C4990ab.m7410d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.fBI && System.currentTimeMillis() - this.fBG < 60000) {
            this.fBU.mo44211a(true, this.fBJ, this.fBK, this.fBL, this.fBM, this.fBN, this.bDJ, this.fBO, this.fBP, this.fBQ);
        }
        AppMethodBeat.m2505o(78132);
    }

    /* renamed from: b */
    public final void mo44206b(C42206a c42206a) {
        AppMethodBeat.m2504i(139132);
        mo44204a(c42206a, true);
        AppMethodBeat.m2505o(139132);
    }

    /* renamed from: a */
    public final void mo44203a(C42206a c42206a) {
        AppMethodBeat.m2504i(78134);
        mo44207b(c42206a, true);
        AppMethodBeat.m2505o(78134);
    }

    /* renamed from: b */
    public final void mo44207b(C42206a c42206a, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(78135);
        if (!this.fBD && this.bkF.size() > 0) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                C45449h.agE();
                C45449h.m83720a(this.fBT, 1, Looper.getMainLooper());
            } catch (C42209a e) {
                C4990ab.m7410d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.fBD = true;
        for (WeakReference weakReference : this.bkF) {
            if (weakReference != null && weakReference.get() != null && ((C42206a) weakReference.get()).equals(c42206a)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.bkF.add(new WeakReference(c42206a));
        }
        C4990ab.m7417i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.bkF.size()));
        if (this.bkF.size() == 1 && obj2 != null) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                C45449h.m83720a(this.fBT, 1, Looper.getMainLooper());
            } catch (C42209a e2) {
                C4990ab.m7410d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.fBH && System.currentTimeMillis() - this.fBG < 60000) {
            this.fBT.mo44209a(true, this.fBJ, this.fBK, this.fBL, this.fBM, this.fBN, this.bDJ, this.fBO, this.fBP, this.fBQ);
        }
        AppMethodBeat.m2505o(78135);
    }

    /* renamed from: c */
    public final void mo44208c(final C42206a c42206a) {
        AppMethodBeat.m2504i(78136);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78129);
                ArrayList<WeakReference> arrayList = new ArrayList();
                for (WeakReference weakReference : C26443d.this.bkF) {
                    if (weakReference == null || weakReference.get() == null || ((C42206a) weakReference.get()).equals(c42206a)) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    C26443d.this.bkF.remove(weakReference2);
                }
                C4990ab.m7417i("MicroMsg.LocationGeo", "stop listeners size %d", Integer.valueOf(C26443d.this.bkF.size()));
                if (C26443d.this.bkF.size() == 0 && C26443d.this.fBE != null) {
                    C45449h.agE();
                }
                AppMethodBeat.m2505o(78129);
            }
        });
        AppMethodBeat.m2505o(78136);
    }

    public static boolean agA() {
        AppMethodBeat.m2504i(78137);
        try {
            boolean isProviderEnabled = ((LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.m2505o(78137);
            return isProviderEnabled;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.LocationGeo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78137);
            return false;
        }
    }

    public static boolean agB() {
        AppMethodBeat.m2504i(78139);
        try {
            boolean isProviderEnabled = ((LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.m2505o(78139);
            return isProviderEnabled;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.LocationGeo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78139);
            return false;
        }
    }

    public final boolean agC() {
        AppMethodBeat.m2504i(78140);
        if (this.fBG <= 0 || !this.fBI || System.currentTimeMillis() - this.fBG >= 600000) {
            AppMethodBeat.m2505o(78140);
            return false;
        }
        AppMethodBeat.m2505o(78140);
        return true;
    }

    /* renamed from: bX */
    public static void m42103bX(Context context) {
        AppMethodBeat.m2504i(78138);
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, -1);
            AppMethodBeat.m2505o(78138);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.m2505o(78138);
    }

    /* renamed from: a */
    static /* synthetic */ void m42101a(C26443d c26443d, boolean z, double d, double d2, double d3, boolean z2) {
        AppMethodBeat.m2504i(78141);
        if (!(z && c26443d.fBR) && (z || !c26443d.fBS)) {
            int i = 10;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c26443d.fBF <= 500) {
                i = 10;
            } else if (currentTimeMillis - c26443d.fBF <= 1000) {
                i = 12;
            } else if (currentTimeMillis - c26443d.fBF <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                i = 14;
            } else if (currentTimeMillis - c26443d.fBF <= 4000) {
                i = 16;
            } else if (currentTimeMillis - c26443d.fBF <= 8000) {
                i = 18;
            }
            if (!z) {
                i++;
            }
            C7060h.pYm.mo8378a(584, (long) i, 1, true);
            if (z) {
                C7060h.pYm.mo8378a(584, 30, 1, true);
                C7060h.pYm.mo8378a(584, 31, currentTimeMillis - c26443d.fBF, true);
                c26443d.fBR = true;
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf((int) (1000000.0d * d));
                objArr[1] = Integer.valueOf((int) (1000000.0d * d2));
                objArr[2] = Integer.valueOf((int) (1000000.0d * d3));
                objArr[3] = Integer.valueOf((int) d3);
                objArr[4] = Integer.valueOf(z2 ? 1 : 2);
                c7060h.mo8381e(15391, objArr);
                AppMethodBeat.m2505o(78141);
                return;
            }
            c26443d.fBS = true;
        }
        AppMethodBeat.m2505o(78141);
    }

    /* renamed from: a */
    static /* synthetic */ void m42102a(C26443d c26443d, boolean z, double d, double d2, int i, double d3, double d4, double d5, Bundle bundle) {
        AppMethodBeat.m2504i(78143);
        LinkedList<C42206a> linkedList = new LinkedList();
        for (WeakReference weakReference : c26443d.bkF) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((C42206a) weakReference.get());
            }
        }
        if (linkedList.isEmpty()) {
            C4990ab.m7420w("MicroMsg.LocationGeo", "no location listener weakrefers, may have leak, stop location");
            c26443d.bkF.clear();
            C45449h.agE();
        }
        for (C42206a c42206a : linkedList) {
            if (C1947ae.ghY && C4872b.dnO()) {
                boolean z2 = z;
                c42206a.mo5861a(z2, (float) C1947ae.lng, (float) C1947ae.lat, i, (double) ((float) d3), d4, d5);
            } else {
                c42206a.mo5861a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, d5);
            }
            if (c42206a instanceof C42208b) {
                ((C42208b) c42206a).mo26902a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, bundle);
            }
        }
        AppMethodBeat.m2505o(78143);
    }
}
