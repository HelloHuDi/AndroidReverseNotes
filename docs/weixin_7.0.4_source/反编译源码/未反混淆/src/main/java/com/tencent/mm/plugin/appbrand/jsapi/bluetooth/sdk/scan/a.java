package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    public AtomicBoolean cnu = new AtomicBoolean(false);
    public Context context;
    public BroadcastReceiver hDr;
    public e hFe;
    public ScanSettingsCompat hFf;
    public Map<String, d> hFg;
    public AtomicBoolean hFh = new AtomicBoolean(false);
    public List<d> hFi;
    Runnable hFj = new Runnable() {
        public final void run() {
            AppMethodBeat.i(94285);
            if (a.this.hFh.get()) {
                if (a.this.hFk != null && a.this.hFi.size() > 0) {
                    a.this.hFk.aK(a.this.hFi);
                    a.this.hFi.clear();
                }
                a.this.mHandler.postDelayed(a.this.hFj, (long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.eCL);
                AppMethodBeat.o(94285);
                return;
            }
            AppMethodBeat.o(94285);
        }
    };
    i hFk;
    final Handler mHandler = new Handler();

    public a(Context context) {
        AppMethodBeat.i(94289);
        this.context = context;
        AppMethodBeat.o(94289);
    }

    public final synchronized void a(b bVar, List<ScanFilterCompat> list, i iVar) {
        AppMethodBeat.i(94290);
        if (!this.cnu.get()) {
            bVar.a(j.hEV);
            AppMethodBeat.o(94290);
        } else if (this.hFh.get()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "already scan", new Object[0]);
            bVar.a(j.hEL);
            AppMethodBeat.o(94290);
        } else {
            BluetoothAdapter aCY = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY();
            if (aCY == null || !com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCZ()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                bVar.a(j.hEO);
                AppMethodBeat.o(94290);
            } else {
                List list2;
                if (VERSION.SDK_INT >= 23) {
                    boolean z;
                    boolean isProviderEnabled;
                    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.AW("android.permission.ACCESS_COARSE_LOCATION") || com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.AW("android.permission.ACCESS_FINE_LOCATION")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkLocationPermission :%b", Boolean.valueOf(z));
                    LocationManager locationManager = (LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
                    if (locationManager != null) {
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        z = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + z, new Object[0]);
                    } else {
                        z = false;
                        isProviderEnabled = false;
                    }
                    if (isProviderEnabled && r0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkGpsEnable:%b", Boolean.valueOf(z));
                }
                this.hFh.set(true);
                if (list2 != null && list2.size() == 0) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "scanFilterCompats size:%d", Integer.valueOf(list2.size()));
                    list2 = null;
                }
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "startBleScan isOk:%b", Boolean.valueOf(b.a(aCY, list2, this.hFf, this.hFe)));
                if (b.a(aCY, list2, this.hFf, this.hFe)) {
                    this.hFk = iVar;
                    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.eCL > 0) {
                        this.mHandler.postDelayed(this.hFj, (long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.eCL);
                    }
                    bVar.a(j.hEL);
                    AppMethodBeat.o(94290);
                } else {
                    bVar.a(j.hEV);
                    AppMethodBeat.o(94290);
                }
            }
        }
    }

    public final synchronized j aCU() {
        j jVar;
        AppMethodBeat.i(94291);
        if (!this.cnu.get()) {
            jVar = j.hEN;
            AppMethodBeat.o(94291);
        } else if (this.hFh.get()) {
            BluetoothAdapter aCY = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY();
            if (aCY == null || !com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCZ()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                jVar = j.hEO;
                AppMethodBeat.o(94291);
            } else {
                this.hFh.set(false);
                b.a(aCY, this.hFe);
                jVar = j.hEL;
                AppMethodBeat.o(94291);
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "not scan", new Object[0]);
            jVar = j.hEL;
            AppMethodBeat.o(94291);
        }
        return jVar;
    }
}
