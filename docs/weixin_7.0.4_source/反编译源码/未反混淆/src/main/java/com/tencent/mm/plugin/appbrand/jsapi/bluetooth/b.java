package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b extends c {
    private String appId;
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b hDu;
    a hDv;

    public interface a {
        void dV(boolean z);
    }

    public b(String str) {
        this.appId = str;
    }

    public final List<d> aCO() {
        AppMethodBeat.i(94173);
        if (this.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.hDu;
            if (bVar.hDY != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar.hDY;
                ArrayList arrayList = new ArrayList();
                for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar : cVar.hEg.values()) {
                    if (dVar.hEl != null) {
                        arrayList.add(new d(bo.nullAsNil(dVar.hEl.getDevice().getName()), dVar.ceI));
                    }
                }
                AppMethodBeat.o(94173);
                return arrayList;
            }
            AppMethodBeat.o(94173);
            return null;
        }
        AppMethodBeat.o(94173);
        return null;
    }

    public final void a(String str, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a aVar, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b bVar) {
        AppMethodBeat.i(94174);
        if (this.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar2 = this.hDu;
            if (bVar2.hDY != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar2.hDY;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d) cVar.hEg.get(str);
                if (dVar == null) {
                    dVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d(cVar.context, str);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "init deviceId:%s", dVar.ceI);
                    if (dVar.hEk == null) {
                        dVar.hEk = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b();
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b bVar3 = dVar.hEk;
                        bVar3.hEb = new ConcurrentLinkedQueue();
                        bVar3.hEd = new ArrayList();
                    }
                    dVar.hEk = dVar.hEk;
                    dVar.hEn = new ConcurrentHashMap();
                    dVar.hEi = new g() {
                        public final void f(String str, String str2, String str3, String str4) {
                            AppMethodBeat.i(94244);
                            if (c.this.hEi != null) {
                                c.this.hEi.f(str, str2, str3, str4);
                            }
                            AppMethodBeat.o(94244);
                        }
                    };
                    dVar.hEh = new h() {
                        public final void ag(String str, boolean z) {
                            AppMethodBeat.i(94245);
                            if (c.this.hEh != null) {
                                c.this.hEh.ag(str, z);
                            }
                            AppMethodBeat.o(94245);
                        }
                    };
                    cVar.hEg.put(str, dVar);
                }
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s aciton:%s", dVar.ceI, aVar);
                aVar.a(dVar);
                aVar.a(dVar.hEk);
                aVar.hEv = bVar;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b bVar4 = dVar.hEk;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", aVar);
                if (aVar.hDR) {
                    bVar4.hEb.add(aVar);
                    bVar4.aCQ();
                    AppMethodBeat.o(94174);
                    return;
                } else if (aVar.hDP) {
                    bVar4.awA.postDelayed(new AnonymousClass1(aVar), aVar.hEy);
                    AppMethodBeat.o(94174);
                    return;
                } else {
                    aVar.aCS();
                }
            }
        }
        AppMethodBeat.o(94174);
    }

    public final List<e> AV(String str) {
        AppMethodBeat.i(94175);
        if (this.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.hDu;
            if (bVar.hDY != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar.hDY;
                if (cVar.hEg.get(str) != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d) cVar.hEg.get(str);
                    if (dVar.hEl == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGatt is null, err", new Object[0]);
                    } else if (bo.isNullOrNil(dVar.ceI)) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] deviceId is null, err", new Object[0]);
                    } else {
                        if (dVar.hEm == null) {
                            List<BluetoothGattService> services = dVar.hEl.getServices();
                            if (services == null) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                dVar.hEm = new ArrayList();
                                ArrayList arrayList = new ArrayList();
                                for (BluetoothGattService bluetoothGattService : services) {
                                    boolean z;
                                    e eVar = new e();
                                    eVar.eCq = bluetoothGattService.getUuid().toString().toUpperCase();
                                    if (bluetoothGattService.getType() == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    eVar.hEK = z;
                                    if (eVar.eCq.equals("00001800-0000-1000-8000-00805F9B34FB") || eVar.eCq.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                                        arrayList.add(eVar);
                                    } else {
                                        dVar.hEm.add(eVar);
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    dVar.hEm.addAll(arrayList);
                                }
                            }
                        }
                        List<e> list = dVar.hEm;
                        AppMethodBeat.o(94175);
                        return list;
                    }
                }
            }
            AppMethodBeat.o(94175);
            return null;
        }
        AppMethodBeat.o(94175);
        return null;
    }

    public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> ca(String str, String str2) {
        AppMethodBeat.i(94176);
        if (this.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.hDu;
            if (bVar.hDY != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar.hDY;
                if (cVar.hEg.get(str) != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d) cVar.hEg.get(str);
                    if (dVar.hEl == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
                    } else if (bo.isNullOrNil(str2)) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is null, err", new Object[0]);
                    } else if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.AX(str2)) {
                        List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> list = (List) dVar.hEn.get(str2);
                        if (list == null) {
                            BluetoothGattService service = dVar.hEl.getService(UUID.fromString(str2));
                            if (service == null) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                                if (characteristics == null) {
                                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristics is null, err", new Object[0]);
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
                                        cVar2.eCq = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                                        int properties = bluetoothGattCharacteristic.getProperties();
                                        cVar2.hEC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.og(properties);
                                        cVar2.hED = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.oh(properties);
                                        cVar2.hEE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.oi(properties);
                                        cVar2.flq = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.oj(properties);
                                        cVar2.hEF = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.ok(properties);
                                        arrayList.add(cVar2);
                                    }
                                    dVar.hEn.put(str2, arrayList);
                                    list = arrayList;
                                }
                            }
                        }
                        AppMethodBeat.o(94176);
                        return list;
                    } else {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(94176);
            return null;
        }
        AppMethodBeat.o(94176);
        return null;
    }

    public final void onDestroy() {
        AppMethodBeat.i(94177);
        a.AU(this.appId);
        AppMethodBeat.o(94177);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(94178);
        if (this.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.hDu;
            if (bVar.hDY != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bVar.hDY;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
                if (cVar.hEg != null) {
                    for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar : cVar.hEg.values()) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "uninit deviceId:%s", dVar.ceI);
                        dVar.dW(true);
                        if (dVar.hEk != null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b bVar2 = dVar.hEk;
                            if (bVar2.hEb != null) {
                                bVar2.hEb.clear();
                                bVar2.hEb = null;
                            }
                            if (bVar2.hEd != null) {
                                bVar2.hEd.clear();
                                bVar2.hEd = null;
                            }
                            dVar.hEk = null;
                        }
                        if (dVar.hEm != null) {
                            dVar.hEm.clear();
                            dVar.hEm = null;
                        }
                        if (dVar.hEn != null) {
                            dVar.hEn.clear();
                            dVar.hEn = null;
                        }
                    }
                    cVar.hEg.clear();
                    cVar.hEg = null;
                }
            }
            if (bVar.hDZ != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a aVar = bVar.hDZ;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "uninit", new Object[0]);
                aVar.cnu.set(false);
                aVar.aCU();
                if (aVar.hFg != null) {
                    aVar.hFg.clear();
                }
                if (aVar.hFi != null) {
                    aVar.hFi.clear();
                }
                if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY() != null && com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY().isDiscovering()) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCY().cancelDiscovery();
                }
                if (!(aVar.hDr == null || aVar.context == null)) {
                    ab.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener uninit");
                    aVar.context.unregisterReceiver(aVar.hDr);
                    aVar.hDr = null;
                }
                aVar.hFe = null;
                aVar.context = null;
            }
            this.hDu = null;
        }
        AppMethodBeat.o(94178);
    }
}
