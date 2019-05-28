package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d implements b {
    public static d fwu;
    double bDJ = 0.0d;
    List<WeakReference<a>> bkF = new ArrayList();
    public boolean fBD = false;
    h fBE;
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
    private f fBT = new f() {
        public final void a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
            AppMethodBeat.i(78125);
            d.a(d.this, z, d, d2, d4, true);
            if (z) {
                d.this.fBJ = d;
                d.this.fBK = d2;
                d.this.fBL = i;
                d.this.fBM = d3;
                d.this.fBN = d4;
                d.this.bDJ = d5;
                d.this.fBO = str;
                d.this.fBP = str2;
                d.this.fBQ = i2;
                d.this.fBG = System.currentTimeMillis();
                d.this.fBH = true;
                d.this.fBI = false;
                d.a(d.this, 67592);
            }
            ab.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i3 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78124);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", d.this.fBP);
                    bundle.putString("indoor_building_id", d.this.fBO);
                    bundle.putInt("indoor_building_type", d.this.fBQ);
                    d.a(d.this, z2, d6, d7, i3, d8, d9, d10, bundle);
                    AppMethodBeat.o(78124);
                }
            });
            AppMethodBeat.o(78125);
        }

        public final void onStatusUpdate(String str, int i, String str2) {
            AppMethodBeat.i(78126);
            ab.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", str, Integer.valueOf(i));
            AppMethodBeat.o(78126);
        }
    };
    private g fBU = new g() {
        public final void a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
            AppMethodBeat.i(78128);
            d.a(d.this, z, d, d2, d4, false);
            if (z) {
                d.this.fBJ = d;
                d.this.fBK = d2;
                d.this.fBL = i;
                d.this.fBM = d3;
                d.this.fBN = d4;
                d.this.bDJ = d5;
                d.this.fBO = str;
                d.this.fBP = str2;
                d.this.fBQ = i2;
                d.this.fBI = true;
                d.this.fBH = false;
                d.this.fBG = System.currentTimeMillis();
                d.a(d.this, 67591);
            }
            ab.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d6 = d;
            final double d7 = d2;
            final int i3 = i;
            final double d8 = d3;
            final double d9 = d4;
            final double d10 = d5;
            new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78127);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", d.this.fBP);
                    bundle.putString("indoor_building_id", d.this.fBO);
                    bundle.putInt("indoor_building_type", d.this.fBQ);
                    d.a(d.this, z2, d6, d7, i3, d8, d9, d10, bundle);
                    AppMethodBeat.o(78127);
                }
            }, 200);
            AppMethodBeat.o(78128);
        }
    };
    private ak fbD = new ak(Looper.getMainLooper());
    private Context mContext;

    public static d agz() {
        AppMethodBeat.i(78130);
        if (fwu == null) {
            fwu = new d(ah.getContext());
        }
        d dVar = fwu;
        AppMethodBeat.o(78130);
        return dVar;
    }

    private d(Context context) {
        AppMethodBeat.i(78131);
        this.mContext = context;
        this.fBE = h.bY(context);
        AppMethodBeat.o(78131);
    }

    public final void a(a aVar, boolean z) {
        Object obj;
        AppMethodBeat.i(78132);
        ab.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", aVar, Boolean.valueOf(z), Integer.valueOf(0));
        if (this.fBD && this.bkF.size() > 0) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                h.agE();
                h.a(this.fBU, 0, Looper.getMainLooper());
            } catch (h.a e) {
                ab.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.fBD = false;
        for (WeakReference weakReference : this.bkF) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.bkF.add(new WeakReference(aVar));
        }
        ab.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.bkF.size()));
        if (this.bkF.size() == 1 && obj2 != null) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                h.a(this.fBU, 0, Looper.getMainLooper());
            } catch (h.a e2) {
                ab.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.fBI && System.currentTimeMillis() - this.fBG < 60000) {
            this.fBU.a(true, this.fBJ, this.fBK, this.fBL, this.fBM, this.fBN, this.bDJ, this.fBO, this.fBP, this.fBQ);
        }
        AppMethodBeat.o(78132);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(139132);
        a(aVar, true);
        AppMethodBeat.o(139132);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(78134);
        b(aVar, true);
        AppMethodBeat.o(78134);
    }

    public final void b(a aVar, boolean z) {
        Object obj;
        AppMethodBeat.i(78135);
        if (!this.fBD && this.bkF.size() > 0) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                h.agE();
                h.a(this.fBT, 1, Looper.getMainLooper());
            } catch (h.a e) {
                ab.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.fBD = true;
        for (WeakReference weakReference : this.bkF) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            this.bkF.add(new WeakReference(aVar));
        }
        ab.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.bkF.size()));
        if (this.bkF.size() == 1 && obj2 != null) {
            try {
                this.fBF = System.currentTimeMillis();
                this.fBR = false;
                this.fBS = false;
                h.a(this.fBT, 1, Looper.getMainLooper());
            } catch (h.a e2) {
                ab.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.fBH && System.currentTimeMillis() - this.fBG < 60000) {
            this.fBT.a(true, this.fBJ, this.fBK, this.fBL, this.fBM, this.fBN, this.bDJ, this.fBO, this.fBP, this.fBQ);
        }
        AppMethodBeat.o(78135);
    }

    public final void c(final a aVar) {
        AppMethodBeat.i(78136);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78129);
                ArrayList<WeakReference> arrayList = new ArrayList();
                for (WeakReference weakReference : d.this.bkF) {
                    if (weakReference == null || weakReference.get() == null || ((a) weakReference.get()).equals(aVar)) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    d.this.bkF.remove(weakReference2);
                }
                ab.i("MicroMsg.LocationGeo", "stop listeners size %d", Integer.valueOf(d.this.bkF.size()));
                if (d.this.bkF.size() == 0 && d.this.fBE != null) {
                    h.agE();
                }
                AppMethodBeat.o(78129);
            }
        });
        AppMethodBeat.o(78136);
    }

    public static boolean agA() {
        AppMethodBeat.i(78137);
        try {
            boolean isProviderEnabled = ((LocationManager) ah.getContext().getSystemService(b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.o(78137);
            return isProviderEnabled;
        } catch (Exception e) {
            ab.e("MicroMsg.LocationGeo", "exception:%s", bo.l(e));
            AppMethodBeat.o(78137);
            return false;
        }
    }

    public static boolean agB() {
        AppMethodBeat.i(78139);
        try {
            boolean isProviderEnabled = ((LocationManager) ah.getContext().getSystemService(b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.o(78139);
            return isProviderEnabled;
        } catch (Exception e) {
            ab.e("MicroMsg.LocationGeo", "exception:%s", bo.l(e));
            AppMethodBeat.o(78139);
            return false;
        }
    }

    public final boolean agC() {
        AppMethodBeat.i(78140);
        if (this.fBG <= 0 || !this.fBI || System.currentTimeMillis() - this.fBG >= 600000) {
            AppMethodBeat.o(78140);
            return false;
        }
        AppMethodBeat.o(78140);
        return true;
    }

    public static void bX(Context context) {
        AppMethodBeat.i(78138);
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, -1);
            AppMethodBeat.o(78138);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.o(78138);
    }

    static /* synthetic */ void a(d dVar, boolean z, double d, double d2, double d3, boolean z2) {
        AppMethodBeat.i(78141);
        if (!(z && dVar.fBR) && (z || !dVar.fBS)) {
            int i = 10;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - dVar.fBF <= 500) {
                i = 10;
            } else if (currentTimeMillis - dVar.fBF <= 1000) {
                i = 12;
            } else if (currentTimeMillis - dVar.fBF <= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                i = 14;
            } else if (currentTimeMillis - dVar.fBF <= 4000) {
                i = 16;
            } else if (currentTimeMillis - dVar.fBF <= 8000) {
                i = 18;
            }
            if (!z) {
                i++;
            }
            h.pYm.a(584, (long) i, 1, true);
            if (z) {
                h.pYm.a(584, 30, 1, true);
                h.pYm.a(584, 31, currentTimeMillis - dVar.fBF, true);
                dVar.fBR = true;
                h hVar = h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf((int) (1000000.0d * d));
                objArr[1] = Integer.valueOf((int) (1000000.0d * d2));
                objArr[2] = Integer.valueOf((int) (1000000.0d * d3));
                objArr[3] = Integer.valueOf((int) d3);
                objArr[4] = Integer.valueOf(z2 ? 1 : 2);
                hVar.e(15391, objArr);
                AppMethodBeat.o(78141);
                return;
            }
            dVar.fBS = true;
        }
        AppMethodBeat.o(78141);
    }

    static /* synthetic */ void a(d dVar, boolean z, double d, double d2, int i, double d3, double d4, double d5, Bundle bundle) {
        AppMethodBeat.i(78143);
        LinkedList<a> linkedList = new LinkedList();
        for (WeakReference weakReference : dVar.bkF) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((a) weakReference.get());
            }
        }
        if (linkedList.isEmpty()) {
            ab.w("MicroMsg.LocationGeo", "no location listener weakrefers, may have leak, stop location");
            dVar.bkF.clear();
            h.agE();
        }
        for (a aVar : linkedList) {
            if (ae.ghY && com.tencent.mm.sdk.a.b.dnO()) {
                boolean z2 = z;
                aVar.a(z2, (float) ae.lng, (float) ae.lat, i, (double) ((float) d3), d4, d5);
            } else {
                aVar.a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, d5);
            }
            if (aVar instanceof b.b) {
                ((b.b) aVar).a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, bundle);
            }
        }
        AppMethodBeat.o(78143);
    }
}
