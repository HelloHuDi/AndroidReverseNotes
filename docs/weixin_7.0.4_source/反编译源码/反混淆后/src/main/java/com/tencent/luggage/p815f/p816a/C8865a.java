package com.tencent.luggage.p815f.p816a;

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
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C19712a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C2459b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.luggage.f.a.a */
public class C8865a implements C33523a {
    private volatile TencentLocationManager bRp;
    @SuppressLint({"NewApi"})
    private final List<C2459b> bRq = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<C2459b> bRr = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<C2459b> bRs = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<C2459b> bRt = new CopyOnWriteArrayList();
    TencentLocationListener bRu = new C88642();
    private Set<String> bRv = new HashSet();
    private Runnable bRw = new C88673();

    /* renamed from: com.tencent.luggage.f.a.a$2 */
    class C88642 implements TencentLocationListener {
        C88642() {
        }

        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            AppMethodBeat.m2504i(51135);
            C4990ab.m7419v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i), str);
            if (i != 0) {
                C4990ab.m7413e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i), str);
            }
            if (C8865a.this.bRr != null && C8865a.this.bRr.size() > 0) {
                C8865a.m15826a(C8865a.this.bRr, i, str, C8865a.m15824a(tencentLocation, false));
                C8865a.this.bRr.clear();
            }
            if (C8865a.this.bRq != null && C8865a.this.bRq.size() > 0) {
                C8865a.m15826a(C8865a.this.bRq, i, str, C8865a.m15824a(tencentLocation, true));
                C8865a.this.bRq.clear();
            }
            if (C8865a.this.bRt != null && C8865a.this.bRt.size() > 0) {
                C8865a.m15826a(C8865a.this.bRt, i, str, C8865a.m15824a(tencentLocation, false));
            }
            if (C8865a.this.bRs != null && C8865a.this.bRs.size() > 0) {
                C8865a.m15826a(C8865a.this.bRs, i, str, C8865a.m15824a(tencentLocation, true));
            }
            C8865a.m15830e(C8865a.this);
            AppMethodBeat.m2505o(51135);
        }

        public final void onStatusUpdate(String str, int i, String str2) {
            AppMethodBeat.m2504i(51136);
            C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", str, Integer.valueOf(i), str2);
            AppMethodBeat.m2505o(51136);
        }
    }

    /* renamed from: com.tencent.luggage.f.a.a$1 */
    class C88661 implements LocationLogCallback {
        C88661() {
        }

        public final void onLog(int i, String str, String str2, Throwable th) {
            AppMethodBeat.m2504i(51134);
            switch (i) {
                case 2:
                    C4990ab.m7419v("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                    AppMethodBeat.m2505o(51134);
                    return;
                case 3:
                    C4990ab.m7411d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                    AppMethodBeat.m2505o(51134);
                    return;
                case 4:
                    C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                    AppMethodBeat.m2505o(51134);
                    return;
                case 5:
                    C4990ab.m7421w("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                    AppMethodBeat.m2505o(51134);
                    return;
                case 6:
                    String str3 = "MicroMsg.DefaultTencentLocationManager";
                    String str4 = "tag:%s msg:%s th:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[1] = str2;
                    objArr[2] = th != null ? th.getMessage() : "";
                    C4990ab.m7413e(str3, str4, objArr);
                    break;
            }
            AppMethodBeat.m2505o(51134);
        }
    }

    /* renamed from: com.tencent.luggage.f.a.a$3 */
    class C88673 implements Runnable {
        C88673() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51137);
            if (C8865a.this.bRr != null && C8865a.this.bRr.size() > 0) {
                C8865a.m15826a(C8865a.this.bRr, -1, "timeout", null);
            }
            if (C8865a.this.bRr != null && C8865a.this.bRr.size() > 0) {
                C8865a.m15826a(C8865a.this.bRr, -1, "timeout", null);
            }
            AppMethodBeat.m2505o(51137);
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m15830e(C8865a c8865a) {
        AppMethodBeat.m2504i(51146);
        c8865a.m15832yi();
        AppMethodBeat.m2505o(51146);
    }

    public C8865a() {
        AppMethodBeat.m2504i(51138);
        C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", C4996ah.getProcessName());
        AppMethodBeat.m2505o(51138);
    }

    /* renamed from: yg */
    private TencentLocationManager m15831yg() {
        AppMethodBeat.m2504i(51139);
        if (this.bRp == null) {
            synchronized (this) {
                if (this.bRp == null) {
                    if (mo20057yh()) {
                        try {
                            TencentExtraKeys.setTencentLog(C4996ah.getContext(), new File(C1761b.eSn + "/lbs" + C4996ah.getProcessName().substring(C4996ah.getPackageName().length() + 1)));
                        } catch (Exception e) {
                            C4990ab.m7409c("MicroMsg.DefaultTencentLocationManager", "", e);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(51139);
                        }
                    }
                    this.bRp = TencentLocationManager.getInstance(C4996ah.getContext());
                    this.bRp.setCoordinateType(0);
                    TencentExtraKeys.setContext(C4996ah.getContext());
                    try {
                        TencentExtraKeys.setTencentLogCallback(new C88661());
                    } catch (Exception e2) {
                        C4990ab.m7409c("MicroMsg.DefaultTencentLocationManager", "", e2);
                    }
                }
            }
        }
        TencentLocationManager tencentLocationManager = this.bRp;
        AppMethodBeat.m2505o(51139);
        return tencentLocationManager;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: yh */
    public boolean mo20057yh() {
        return false;
    }

    /* renamed from: a */
    public final void mo20054a(String str, C2459b c2459b, Bundle bundle) {
        AppMethodBeat.m2504i(51140);
        if ("wgs84".equals(str)) {
            this.bRq.add(c2459b);
        } else {
            this.bRr.add(c2459b);
        }
        C45673m.aNS().doN().removeCallbacks(this.bRw);
        C45673m.aNS().mo10310m(this.bRw, 20000);
        boolean z = bundle.getBoolean("enableIndoor");
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        create.setIndoorLocationMode(z);
        create.setSmallAppKey(bundle.getString("smallAppKey"));
        int requestSingleFreshLocation = m15831yg().requestSingleFreshLocation(create, this.bRu, C45673m.aNS().oAl.getLooper());
        C4990ab.m7411d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", bundle.getString("smallAppKey"));
        C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestSingleFreshLocation));
        AppMethodBeat.m2505o(51140);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final synchronized boolean mo20055b(String str, C2459b c2459b, Bundle bundle) {
        AppMethodBeat.m2504i(51141);
        C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", str);
        boolean z;
        TencentLocationRequest create;
        long j;
        StringBuilder stringBuilder;
        int requestLocationUpdates;
        if ("wgs84".equals(str)) {
            String string;
            boolean z2;
            for (C2459b c2459b2 : this.bRs) {
                if (c2459b2 != null && c2459b2.equals(c2459b)) {
                    C4990ab.m7420w("MicroMsg.DefaultTencentLocationManager", "already register");
                    AppMethodBeat.m2505o(51141);
                    break;
                }
            }
            this.bRs.add(c2459b);
            if (bundle != null) {
                string = bundle.getString("smallAppKey");
                if (!C5046bo.isNullOrNil(string)) {
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
                C4990ab.m7411d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", stringBuilder.toString());
                create.setSmallAppKey(stringBuilder.toString());
                requestLocationUpdates = m15831yg().requestLocationUpdates(create, this.bRu, C45673m.aNS().oAl.getLooper());
                C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
            }
            AppMethodBeat.m2505o(51141);
        } else {
            for (C2459b c2459b22 : this.bRt) {
                if (c2459b22 != null && c2459b22.equals(c2459b)) {
                    C4990ab.m7420w("MicroMsg.DefaultTencentLocationManager", "already register");
                    AppMethodBeat.m2505o(51141);
                    break;
                }
            }
            this.bRt.add(c2459b);
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
            C4990ab.m7411d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", stringBuilder.toString());
            create.setSmallAppKey(stringBuilder.toString());
            requestLocationUpdates = m15831yg().requestLocationUpdates(create, this.bRu, C45673m.aNS().oAl.getLooper());
            C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
            AppMethodBeat.m2505o(51141);
        }
        return false;
    }

    /* renamed from: c */
    public final synchronized boolean mo20056c(String str, C2459b c2459b, Bundle bundle) {
        AppMethodBeat.m2504i(51142);
        C4990ab.m7417i("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", str);
        if ("wgs84".equals(str)) {
            this.bRs.remove(c2459b);
        } else {
            this.bRt.remove(c2459b);
        }
        if (bundle != null) {
            this.bRv.remove(bundle.getString("smallAppKey"));
        }
        m15832yi();
        AppMethodBeat.m2505o(51142);
        return false;
    }

    /* renamed from: yi */
    private void m15832yi() {
        AppMethodBeat.m2504i(51143);
        if (this.bRr.size() <= 0 && this.bRq.size() <= 0 && this.bRs.size() <= 0 && this.bRt.size() <= 0) {
            C4990ab.m7416i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
            m15831yg().removeUpdates(null);
        }
        AppMethodBeat.m2505o(51143);
    }

    /* renamed from: a */
    static /* synthetic */ C19712a m15824a(TencentLocation tencentLocation, boolean z) {
        String str;
        AppMethodBeat.m2504i(51144);
        C19712a c19712a = new C19712a();
        if (z) {
            c19712a.latitude = tencentLocation.getLatitude();
            c19712a.longitude = tencentLocation.getLongitude();
        } else {
            double[] dArr = new double[2];
            TencentLocationUtils.wgs84ToGcj02(new double[]{tencentLocation.getLatitude(), tencentLocation.getLongitude()}, dArr);
            c19712a.latitude = dArr[0];
            c19712a.longitude = dArr[1];
        }
        if ("gps".equals(tencentLocation.getProvider())) {
            str = "gps";
        } else {
            str = TencentLocation.NETWORK_PROVIDER;
        }
        c19712a.bIy = str;
        c19712a.iSf = (double) tencentLocation.getSpeed();
        c19712a.iSg = (double) tencentLocation.getAccuracy();
        c19712a.altitude = tencentLocation.getAltitude();
        C4990ab.m7419v("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s", tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor());
        if (C5046bo.isNullOrNil(tencentLocation.getIndoorBuildingId())) {
            c19712a.buildingId = "";
            c19712a.floorName = "";
        } else {
            c19712a.buildingId = tencentLocation.getIndoorBuildingId();
            c19712a.floorName = tencentLocation.getIndoorBuildingFloor();
        }
        AppMethodBeat.m2505o(51144);
        return c19712a;
    }

    /* renamed from: a */
    static /* synthetic */ void m15826a(List list, int i, String str, C19712a c19712a) {
        AppMethodBeat.m2504i(51145);
        for (C2459b c2459b : list) {
            if (c2459b != null) {
                c2459b.mo6153a(i, str, c19712a);
            }
        }
        AppMethodBeat.m2505o(51145);
    }
}
