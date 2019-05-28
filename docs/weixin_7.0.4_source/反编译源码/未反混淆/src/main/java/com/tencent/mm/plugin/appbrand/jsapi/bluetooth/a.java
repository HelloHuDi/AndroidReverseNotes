package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker$3;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static BroadcastReceiver hDr;
    public static boolean hDs;
    public static com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a hDt = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.a() {
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(94162);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(94162);
        }

        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(94163);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(94163);
        }

        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(94164);
            ab.i(str, str2, objArr);
            AppMethodBeat.o(94164);
        }

        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(94165);
            ab.d(str, str2, objArr);
            AppMethodBeat.o(94165);
        }
    };
    private static Map<String, b> map = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(94172);
        AppMethodBeat.o(94172);
    }

    public static j a(String str, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a aVar, h hVar, g gVar) {
        int i;
        AppMethodBeat.i(94167);
        ab.i("MicroMsg.Ble.BleManager", "open appId:%s", str);
        if (d.fP(18) || !ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            i = 0;
        } else {
            i = 1;
        }
        j jVar;
        if (i == 0) {
            ab.e("MicroMsg.Ble.BleManager", "api version is below 18");
            jVar = j.hEW;
            AppMethodBeat.o(94167);
            return jVar;
        }
        if (!map.containsKey(str)) {
            b bVar;
            ab.w("MicroMsg.Ble.BleManager", "already open appId:%s", str);
            c bVar2 = new b(str);
            bVar2.hDu = new b(ah.getContext());
            b bVar3 = bVar2.hDu;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar3.hDY;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
            if (cVar.hEg == null) {
                cVar.hEg = new ConcurrentHashMap();
            }
            cVar.hEg.clear();
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a aVar2 = bVar3.hDZ;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "init", new Object[0]);
            aVar2.cnu.set(true);
            aVar2.hFg = new HashMap();
            aVar2.hFi = new ArrayList();
            aVar2.hFe = new e() {
                public final void a(int i, ScanResultCompat scanResultCompat) {
                    int i2 = 0;
                    AppMethodBeat.i(94286);
                    if (scanResultCompat.getDevice() == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]result is null, err", new Object[0]);
                        AppMethodBeat.o(94286);
                    } else if (!a.this.cnu.get()) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]not init, err", new Object[0]);
                        AppMethodBeat.o(94286);
                    } else if (a.this.hFg == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "[onScanResult]may be close, err", new Object[0]);
                        AppMethodBeat.o(94286);
                    } else {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.d("MicroMsg.Ble.BleScanWorker", "callbackType:%d, result:%s", Integer.valueOf(i), scanResultCompat);
                        String address = scanResultCompat.getDevice().getAddress();
                        if (!a.this.hFg.containsKey(address) || com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.hDL) {
                            i2 = 1;
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d dVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(scanResultCompat);
                        if (i2 != 0) {
                            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDK.eCL > 0) {
                                if (a.this.hFi != null) {
                                    a.this.hFi.add(dVar);
                                }
                            } else if (a.this.hFk != null) {
                                a.this.hFk.a(dVar);
                            }
                        }
                        a.this.hFg.put(address, dVar);
                        AppMethodBeat.o(94286);
                    }
                }

                public final void onScanFailed(int i) {
                    AppMethodBeat.i(94287);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]onScanFailed, errorCode:%d", Integer.valueOf(i));
                    AppMethodBeat.o(94287);
                }
            };
            String str2 = "middle";
            if (str2.equals("low")) {
                aVar2.hFf = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a().of(0).aCW();
            } else if (str2.equals("middle")) {
                aVar2.hFf = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a().of(1).aCW();
            } else if (str2.equals("high")) {
                aVar2.hFf = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a().of(2).aCW();
            } else {
                aVar2.hFf = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a().of(0).aCW();
            }
            if (aVar2.hDr == null) {
                ab.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener init");
                aVar2.hDr = new BleScanWorker$3(aVar2);
                aVar2.context.registerReceiver(aVar2.hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            }
            bVar2.hDv = aVar;
            if (bVar2.hDu != null) {
                bVar = bVar2.hDu;
                if (bVar.hDY != null) {
                    bVar.hDY.hEh = hVar;
                }
            }
            if (bVar2.hDu != null) {
                bVar = bVar2.hDu;
                if (bVar.hDY != null) {
                    bVar.hDY.hEi = gVar;
                }
            }
            map.put(str, bVar2);
            com.tencent.mm.plugin.appbrand.g.a(str, bVar2);
            aCM();
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.hGh = hDt;
        }
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCZ()) {
            jVar = j.hEL;
            AppMethodBeat.o(94167);
            return jVar;
        }
        ab.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
        jVar = j.hEO;
        AppMethodBeat.o(94167);
        return jVar;
    }

    public static b AT(String str) {
        AppMethodBeat.i(94168);
        b bVar = (b) map.get(str);
        AppMethodBeat.o(94168);
        return bVar;
    }

    public static j AU(String str) {
        AppMethodBeat.i(94169);
        ab.i("MicroMsg.Ble.BleManager", "close appId:%s", str);
        j jVar;
        if (map.containsKey(str)) {
            b bVar = (b) map.remove(str);
            com.tencent.mm.plugin.appbrand.g.b(str, bVar);
            bVar.uninit();
            if (map.size() == 0) {
                aCN();
            }
            jVar = j.hEL;
            AppMethodBeat.o(94169);
            return jVar;
        }
        jVar = j.hEL;
        AppMethodBeat.o(94169);
        return jVar;
    }

    private static synchronized void aCM() {
        synchronized (a.class) {
            AppMethodBeat.i(94170);
            if (hDr == null) {
                ab.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
                hDr = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        boolean z = false;
                        AppMethodBeat.i(94166);
                        if (intent == null) {
                            ab.i("MicroMsg.Ble.BleManager", "Receive intent failed");
                            AppMethodBeat.o(94166);
                            return;
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            ab.d("MicroMsg.Ble.BleManager", "state:%d", Integer.valueOf(state));
                            if (state == 12) {
                                z = true;
                            } else if (state == 10) {
                            }
                            if ((a.hDs && !z) || (!a.hDs && z)) {
                                for (b bVar : a.map.values()) {
                                    if (bVar.hDv != null) {
                                        bVar.hDv.dV(z);
                                    }
                                }
                            }
                            a.hDs = z;
                        }
                        AppMethodBeat.o(94166);
                    }
                };
                ah.getContext().registerReceiver(hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                hDs = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCZ();
            }
            AppMethodBeat.o(94170);
        }
    }

    private static synchronized void aCN() {
        synchronized (a.class) {
            AppMethodBeat.i(94171);
            if (hDr != null) {
                ab.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
                ah.getContext().unregisterReceiver(hDr);
                hDr = null;
            }
            AppMethodBeat.o(94171);
        }
    }
}
