package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10346i;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33263d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a */
public final class C26945a {
    public AtomicBoolean cnu = new AtomicBoolean(false);
    public Context context;
    public BroadcastReceiver hDr;
    public C42487e hFe;
    public ScanSettingsCompat hFf;
    public Map<String, C33263d> hFg;
    public AtomicBoolean hFh = new AtomicBoolean(false);
    public List<C33263d> hFi;
    Runnable hFj = new C103481();
    C10346i hFk;
    final Handler mHandler = new Handler();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a$1 */
    class C103481 implements Runnable {
        C103481() {
        }

        public final void run() {
            AppMethodBeat.m2504i(94285);
            if (C26945a.this.hFh.get()) {
                if (C26945a.this.hFk != null && C26945a.this.hFi.size() > 0) {
                    C26945a.this.hFk.mo21818aK(C26945a.this.hFi);
                    C26945a.this.hFi.clear();
                }
                C26945a.this.mHandler.postDelayed(C26945a.this.hFj, (long) C38281a.hDK.eCL);
                AppMethodBeat.m2505o(94285);
                return;
            }
            AppMethodBeat.m2505o(94285);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a$2 */
    public class C103492 extends C42487e {
        /* renamed from: a */
        public final void mo21822a(int i, ScanResultCompat scanResultCompat) {
            int i2 = 0;
            AppMethodBeat.m2504i(94286);
            if (scanResultCompat.getDevice() == null) {
                C26944a.m42896e("MicroMsg.Ble.BleScanWorker", "[onScanResult]result is null, err", new Object[0]);
                AppMethodBeat.m2505o(94286);
            } else if (!C26945a.this.cnu.get()) {
                C26944a.m42896e("MicroMsg.Ble.BleScanWorker", "[onScanResult]not init, err", new Object[0]);
                AppMethodBeat.m2505o(94286);
            } else if (C26945a.this.hFg == null) {
                C26944a.m42898w("MicroMsg.Ble.BleScanWorker", "[onScanResult]may be close, err", new Object[0]);
                AppMethodBeat.m2505o(94286);
            } else {
                C26944a.m42895d("MicroMsg.Ble.BleScanWorker", "callbackType:%d, result:%s", Integer.valueOf(i), scanResultCompat);
                String address = scanResultCompat.getDevice().getAddress();
                if (!C26945a.this.hFg.containsKey(address) || C38281a.hDK.hDL) {
                    i2 = 1;
                }
                C33263d c33263d = new C33263d(scanResultCompat);
                if (i2 != 0) {
                    if (C38281a.hDK.eCL > 0) {
                        if (C26945a.this.hFi != null) {
                            C26945a.this.hFi.add(c33263d);
                        }
                    } else if (C26945a.this.hFk != null) {
                        C26945a.this.hFk.mo21817a(c33263d);
                    }
                }
                C26945a.this.hFg.put(address, c33263d);
                AppMethodBeat.m2505o(94286);
            }
        }

        public final void onScanFailed(int i) {
            AppMethodBeat.m2504i(94287);
            C26944a.m42896e("MicroMsg.Ble.BleScanWorker", "[onScanResult]onScanFailed, errorCode:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(94287);
        }
    }

    public C26945a(Context context) {
        AppMethodBeat.m2504i(94289);
        this.context = context;
        AppMethodBeat.m2505o(94289);
    }

    /* renamed from: a */
    public final synchronized void mo44682a(C2237b c2237b, List<ScanFilterCompat> list, C10346i c10346i) {
        AppMethodBeat.m2504i(94290);
        if (!this.cnu.get()) {
            c2237b.mo6097a(C26942j.hEV);
            AppMethodBeat.m2505o(94290);
        } else if (this.hFh.get()) {
            C26944a.m42898w("MicroMsg.Ble.BleScanWorker", "already scan", new Object[0]);
            c2237b.mo6097a(C26942j.hEL);
            AppMethodBeat.m2505o(94290);
        } else {
            BluetoothAdapter aCY = C38283b.aCY();
            if (aCY == null || !C38283b.aCZ()) {
                C26944a.m42896e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                c2237b.mo6097a(C26942j.hEO);
                AppMethodBeat.m2505o(94290);
            } else {
                List list2;
                if (VERSION.SDK_INT >= 23) {
                    boolean z;
                    boolean isProviderEnabled;
                    if (C38283b.m64774AW("android.permission.ACCESS_COARSE_LOCATION") || C38283b.m64774AW("android.permission.ACCESS_FINE_LOCATION")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "checkLocationPermission :%b", Boolean.valueOf(z));
                    LocationManager locationManager = (LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION);
                    if (locationManager != null) {
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        z = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        C26944a.m42897i("MicroMsg.Ble.BleHelper", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + z, new Object[0]);
                    } else {
                        z = false;
                        isProviderEnabled = false;
                    }
                    if (isProviderEnabled && r0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "checkGpsEnable:%b", Boolean.valueOf(z));
                }
                this.hFh.set(true);
                if (list2 != null && list2.size() == 0) {
                    C26944a.m42898w("MicroMsg.Ble.BleScanWorker", "scanFilterCompats size:%d", Integer.valueOf(list2.size()));
                    list2 = null;
                }
                C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "startBleScan isOk:%b", Boolean.valueOf(C10350b.m18050a(aCY, list2, this.hFf, this.hFe)));
                if (C10350b.m18050a(aCY, list2, this.hFf, this.hFe)) {
                    this.hFk = c10346i;
                    if (C38281a.hDK.eCL > 0) {
                        this.mHandler.postDelayed(this.hFj, (long) C38281a.hDK.eCL);
                    }
                    c2237b.mo6097a(C26942j.hEL);
                    AppMethodBeat.m2505o(94290);
                } else {
                    c2237b.mo6097a(C26942j.hEV);
                    AppMethodBeat.m2505o(94290);
                }
            }
        }
    }

    public final synchronized C26942j aCU() {
        C26942j c26942j;
        AppMethodBeat.m2504i(94291);
        if (!this.cnu.get()) {
            c26942j = C26942j.hEN;
            AppMethodBeat.m2505o(94291);
        } else if (this.hFh.get()) {
            BluetoothAdapter aCY = C38283b.aCY();
            if (aCY == null || !C38283b.aCZ()) {
                C26944a.m42896e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                c26942j = C26942j.hEO;
                AppMethodBeat.m2505o(94291);
            } else {
                this.hFh.set(false);
                C10350b.m18049a(aCY, this.hFe);
                c26942j = C26942j.hEL;
                AppMethodBeat.m2505o(94291);
            }
        } else {
            C26944a.m42898w("MicroMsg.Ble.BleScanWorker", "not scan", new Object[0]);
            c26942j = C26942j.hEL;
            AppMethodBeat.m2505o(94291);
        }
        return c26942j;
    }
}
