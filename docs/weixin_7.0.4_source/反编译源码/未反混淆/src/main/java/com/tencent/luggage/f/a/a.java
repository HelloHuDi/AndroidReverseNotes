package com.tencent.luggage.f.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.s.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a implements com.tencent.mm.plugin.appbrand.s.b.a {
    private volatile TencentLocationManager bRp;
    @SuppressLint({"NewApi"})
    private final List<b> bRq = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<b> bRr = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<b> bRs = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<b> bRt = new CopyOnWriteArrayList();
    TencentLocationListener bRu = new TencentLocationListener() {
        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            AppMethodBeat.i(51135);
            ab.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i), str);
            if (i != 0) {
                ab.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i), str);
            }
            if (a.this.bRr != null && a.this.bRr.size() > 0) {
                a.a(a.this.bRr, i, str, a.a(tencentLocation, false));
                a.this.bRr.clear();
            }
            if (a.this.bRq != null && a.this.bRq.size() > 0) {
                a.a(a.this.bRq, i, str, a.a(tencentLocation, true));
                a.this.bRq.clear();
            }
            if (a.this.bRt != null && a.this.bRt.size() > 0) {
                a.a(a.this.bRt, i, str, a.a(tencentLocation, false));
            }
            if (a.this.bRs != null && a.this.bRs.size() > 0) {
                a.a(a.this.bRs, i, str, a.a(tencentLocation, true));
            }
            a.e(a.this);
            AppMethodBeat.o(51135);
        }

        public final void onStatusUpdate(String str, int i, String str2) {
            AppMethodBeat.i(51136);
            ab.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", str, Integer.valueOf(i), str2);
            AppMethodBeat.o(51136);
        }
    };
    private Set<String> bRv = new HashSet();
    private Runnable bRw = new Runnable() {
        public final void run() {
            AppMethodBeat.i(51137);
            if (a.this.bRr != null && a.this.bRr.size() > 0) {
                a.a(a.this.bRr, -1, "timeout", null);
            }
            if (a.this.bRr != null && a.this.bRr.size() > 0) {
                a.a(a.this.bRr, -1, "timeout", null);
            }
            AppMethodBeat.o(51137);
        }
    };

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(51146);
        aVar.yi();
        AppMethodBeat.o(51146);
    }

    public a() {
        AppMethodBeat.i(51138);
        ab.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", ah.getProcessName());
        AppMethodBeat.o(51138);
    }

    private TencentLocationManager yg() {
        AppMethodBeat.i(51139);
        if (this.bRp == null) {
            synchronized (this) {
                if (this.bRp == null) {
                    if (yh()) {
                        try {
                            TencentExtraKeys.setTencentLog(ah.getContext(), new File(com.tencent.mm.loader.j.b.eSn + "/lbs" + ah.getProcessName().substring(ah.getPackageName().length() + 1)));
                        } catch (Exception e) {
                            ab.c("MicroMsg.DefaultTencentLocationManager", "", e);
                        } catch (Throwable th) {
                            AppMethodBeat.o(51139);
                        }
                    }
                    this.bRp = TencentLocationManager.getInstance(ah.getContext());
                    this.bRp.setCoordinateType(0);
                    TencentExtraKeys.setContext(ah.getContext());
                    try {
                        TencentExtraKeys.setTencentLogCallback(new LocationLogCallback() {
                            public final void onLog(int i, String str, String str2, Throwable th) {
                                AppMethodBeat.i(51134);
                                switch (i) {
                                    case 2:
                                        ab.v("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                        AppMethodBeat.o(51134);
                                        return;
                                    case 3:
                                        ab.d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                        AppMethodBeat.o(51134);
                                        return;
                                    case 4:
                                        ab.i("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                        AppMethodBeat.o(51134);
                                        return;
                                    case 5:
                                        ab.w("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                        AppMethodBeat.o(51134);
                                        return;
                                    case 6:
                                        String str3 = "MicroMsg.DefaultTencentLocationManager";
                                        String str4 = "tag:%s msg:%s th:%s";
                                        Object[] objArr = new Object[3];
                                        objArr[0] = str;
                                        objArr[1] = str2;
                                        objArr[2] = th != null ? th.getMessage() : "";
                                        ab.e(str3, str4, objArr);
                                        break;
                                }
                                AppMethodBeat.o(51134);
                            }
                        });
                    } catch (Exception e2) {
                        ab.c("MicroMsg.DefaultTencentLocationManager", "", e2);
                    }
                }
            }
        }
        TencentLocationManager tencentLocationManager = this.bRp;
        AppMethodBeat.o(51139);
        return tencentLocationManager;
    }

    /* Access modifiers changed, original: protected */
    public boolean yh() {
        return false;
    }

    public final void a(String str, b bVar, Bundle bundle) {
        AppMethodBeat.i(51140);
        if ("wgs84".equals(str)) {
            this.bRq.add(bVar);
        } else {
            this.bRr.add(bVar);
        }
        m.aNS().doN().removeCallbacks(this.bRw);
        m.aNS().m(this.bRw, 20000);
        boolean z = bundle.getBoolean("enableIndoor");
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        create.setIndoorLocationMode(z);
        create.setSmallAppKey(bundle.getString("smallAppKey"));
        int requestSingleFreshLocation = yg().requestSingleFreshLocation(create, this.bRu, m.aNS().oAl.getLooper());
        ab.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", bundle.getString("smallAppKey"));
        ab.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestSingleFreshLocation));
        AppMethodBeat.o(51140);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(String str, b bVar, Bundle bundle) {
        AppMethodBeat.i(51141);
        ab.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", str);
        boolean z;
        TencentLocationRequest create;
        long j;
        StringBuilder stringBuilder;
        int requestLocationUpdates;
        if ("wgs84".equals(str)) {
            String string;
            boolean z2;
            for (b bVar2 : this.bRs) {
                if (bVar2 != null && bVar2.equals(bVar)) {
                    ab.w("MicroMsg.DefaultTencentLocationManager", "already register");
                    AppMethodBeat.o(51141);
                    break;
                }
            }
            this.bRs.add(bVar);
            if (bundle != null) {
                string = bundle.getString("smallAppKey");
                if (!bo.isNullOrNil(string)) {
                    this.bRv.add(string);
                }
            }
            if (bundle == null && bundle.getBoolean("enableIndoor")) {
                z = true;
            } else {
                z = false;
            }
            if (this.bRs.size() + this.bRt.size() != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || z) {
                create = TencentLocationRequest.create();
                create.setIndoorLocationMode(z);
                if (z) {
                    j = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                } else {
                    j = 1000;
                }
                create.setInterval(j);
                stringBuilder = new StringBuilder();
                for (String string2 : this.bRv) {
                    stringBuilder.append(string2);
                }
                ab.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", stringBuilder.toString());
                create.setSmallAppKey(stringBuilder.toString());
                requestLocationUpdates = yg().requestLocationUpdates(create, this.bRu, m.aNS().oAl.getLooper());
                ab.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
            }
            AppMethodBeat.o(51141);
        } else {
            for (b bVar22 : this.bRt) {
                if (bVar22 != null && bVar22.equals(bVar)) {
                    ab.w("MicroMsg.DefaultTencentLocationManager", "already register");
                    AppMethodBeat.o(51141);
                    break;
                }
            }
            this.bRt.add(bVar);
            if (bundle != null) {
            }
            if (bundle == null) {
            }
            z = false;
            if (this.bRs.size() + this.bRt.size() != 1) {
            }
            create = TencentLocationRequest.create();
            create.setIndoorLocationMode(z);
            if (z) {
            }
            create.setInterval(j);
            stringBuilder = new StringBuilder();
            while (r3.hasNext()) {
            }
            ab.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", stringBuilder.toString());
            create.setSmallAppKey(stringBuilder.toString());
            requestLocationUpdates = yg().requestLocationUpdates(create, this.bRu, m.aNS().oAl.getLooper());
            ab.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
            AppMethodBeat.o(51141);
        }
        return false;
    }

    public final synchronized boolean c(String str, b bVar, Bundle bundle) {
        AppMethodBeat.i(51142);
        ab.i("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", str);
        if ("wgs84".equals(str)) {
            this.bRs.remove(bVar);
        } else {
            this.bRt.remove(bVar);
        }
        if (bundle != null) {
            this.bRv.remove(bundle.getString("smallAppKey"));
        }
        yi();
        AppMethodBeat.o(51142);
        return false;
    }

    private void yi() {
        AppMethodBeat.i(51143);
        if (this.bRr.size() <= 0 && this.bRq.size() <= 0 && this.bRs.size() <= 0 && this.bRt.size() <= 0) {
            ab.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
            yg().removeUpdates(null);
        }
        AppMethodBeat.o(51143);
    }

    static /* synthetic */ com.tencent.mm.plugin.appbrand.s.b.a.a a(TencentLocation tencentLocation, boolean z) {
        String str;
        AppMethodBeat.i(51144);
        com.tencent.mm.plugin.appbrand.s.b.a.a aVar = new com.tencent.mm.plugin.appbrand.s.b.a.a();
        if (z) {
            aVar.latitude = tencentLocation.getLatitude();
            aVar.longitude = tencentLocation.getLongitude();
        } else {
            double[] dArr = new double[2];
            TencentLocationUtils.wgs84ToGcj02(new double[]{tencentLocation.getLatitude(), tencentLocation.getLongitude()}, dArr);
            aVar.latitude = dArr[0];
            aVar.longitude = dArr[1];
        }
        if ("gps".equals(tencentLocation.getProvider())) {
            str = "gps";
        } else {
            str = TencentLocation.NETWORK_PROVIDER;
        }
        aVar.bIy = str;
        aVar.iSf = (double) tencentLocation.getSpeed();
        aVar.iSg = (double) tencentLocation.getAccuracy();
        aVar.altitude = tencentLocation.getAltitude();
        ab.v("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s", tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor());
        if (bo.isNullOrNil(tencentLocation.getIndoorBuildingId())) {
            aVar.buildingId = "";
            aVar.floorName = "";
        } else {
            aVar.buildingId = tencentLocation.getIndoorBuildingId();
            aVar.floorName = tencentLocation.getIndoorBuildingFloor();
        }
        AppMethodBeat.o(51144);
        return aVar;
    }

    static /* synthetic */ void a(List list, int i, String str, com.tencent.mm.plugin.appbrand.s.b.a.a aVar) {
        AppMethodBeat.i(51145);
        for (b bVar : list) {
            if (bVar != null) {
                bVar.a(i, str, aVar);
            }
        }
        AppMethodBeat.o(51145);
    }
}
