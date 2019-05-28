package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33262c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33263d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33264e;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C10341d;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c.C166432;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c.C332611;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C38279b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C38279b.C382801;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.C26945a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b */
public final class C44696b extends C33186c {
    private String appId;
    C45588b hDu;
    C33257a hDv;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b$a */
    public interface C33257a {
        /* renamed from: dV */
        void mo21793dV(boolean z);
    }

    public C44696b(String str) {
        this.appId = str;
    }

    public final List<C33263d> aCO() {
        AppMethodBeat.m2504i(94173);
        if (this.hDu != null) {
            C45588b c45588b = this.hDu;
            if (c45588b.hDY != null) {
                C33260c c33260c = c45588b.hDY;
                ArrayList arrayList = new ArrayList();
                for (C10341d c10341d : c33260c.hEg.values()) {
                    if (c10341d.hEl != null) {
                        arrayList.add(new C33263d(C5046bo.nullAsNil(c10341d.hEl.getDevice().getName()), c10341d.ceI));
                    }
                }
                AppMethodBeat.m2505o(94173);
                return arrayList;
            }
            AppMethodBeat.m2505o(94173);
            return null;
        }
        AppMethodBeat.m2505o(94173);
        return null;
    }

    /* renamed from: a */
    public final void mo71732a(String str, C10343a c10343a, C2237b c2237b) {
        AppMethodBeat.m2504i(94174);
        if (this.hDu != null) {
            C45588b c45588b = this.hDu;
            if (c45588b.hDY != null) {
                C33260c c33260c = c45588b.hDY;
                C10341d c10341d = (C10341d) c33260c.hEg.get(str);
                if (c10341d == null) {
                    c10341d = new C10341d(c33260c.context, str);
                    C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "init deviceId:%s", c10341d.ceI);
                    if (c10341d.hEk == null) {
                        c10341d.hEk = new C38279b();
                        C38279b c38279b = c10341d.hEk;
                        c38279b.hEb = new ConcurrentLinkedQueue();
                        c38279b.hEd = new ArrayList();
                    }
                    c10341d.hEk = c10341d.hEk;
                    c10341d.hEn = new ConcurrentHashMap();
                    c10341d.hEi = new C332611();
                    c10341d.hEh = new C166432();
                    c33260c.hEg.put(str, c10341d);
                }
                C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s aciton:%s", c10341d.ceI, c10343a);
                c10343a.mo21807a(c10341d);
                c10343a.mo21806a(c10341d.hEk);
                c10343a.hEv = c2237b;
                C38279b c38279b2 = c10341d.hEk;
                C26944a.m42897i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", c10343a);
                if (c10343a.hDR) {
                    c38279b2.hEb.add(c10343a);
                    c38279b2.aCQ();
                    AppMethodBeat.m2505o(94174);
                    return;
                } else if (c10343a.hDP) {
                    c38279b2.awA.postDelayed(new C382801(c10343a), c10343a.hEy);
                    AppMethodBeat.m2505o(94174);
                    return;
                } else {
                    c10343a.aCS();
                }
            }
        }
        AppMethodBeat.m2505o(94174);
    }

    /* renamed from: AV */
    public final List<C33264e> mo71731AV(String str) {
        AppMethodBeat.m2504i(94175);
        if (this.hDu != null) {
            C45588b c45588b = this.hDu;
            if (c45588b.hDY != null) {
                C33260c c33260c = c45588b.hDY;
                if (c33260c.hEg.get(str) != null) {
                    C10341d c10341d = (C10341d) c33260c.hEg.get(str);
                    if (c10341d.hEl == null) {
                        C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGatt is null, err", new Object[0]);
                    } else if (C5046bo.isNullOrNil(c10341d.ceI)) {
                        C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getServices] deviceId is null, err", new Object[0]);
                    } else {
                        if (c10341d.hEm == null) {
                            List<BluetoothGattService> services = c10341d.hEl.getServices();
                            if (services == null) {
                                C26944a.m42898w("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                c10341d.hEm = new ArrayList();
                                ArrayList arrayList = new ArrayList();
                                for (BluetoothGattService bluetoothGattService : services) {
                                    boolean z;
                                    C33264e c33264e = new C33264e();
                                    c33264e.eCq = bluetoothGattService.getUuid().toString().toUpperCase();
                                    if (bluetoothGattService.getType() == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    c33264e.hEK = z;
                                    if (c33264e.eCq.equals("00001800-0000-1000-8000-00805F9B34FB") || c33264e.eCq.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                                        arrayList.add(c33264e);
                                    } else {
                                        c10341d.hEm.add(c33264e);
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    c10341d.hEm.addAll(arrayList);
                                }
                            }
                        }
                        List<C33264e> list = c10341d.hEm;
                        AppMethodBeat.m2505o(94175);
                        return list;
                    }
                }
            }
            AppMethodBeat.m2505o(94175);
            return null;
        }
        AppMethodBeat.m2505o(94175);
        return null;
    }

    /* renamed from: ca */
    public final List<C33262c> mo71734ca(String str, String str2) {
        AppMethodBeat.m2504i(94176);
        if (this.hDu != null) {
            C45588b c45588b = this.hDu;
            if (c45588b.hDY != null) {
                C33260c c33260c = c45588b.hDY;
                if (c33260c.hEg.get(str) != null) {
                    C10341d c10341d = (C10341d) c33260c.hEg.get(str);
                    if (c10341d.hEl == null) {
                        C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
                    } else if (C5046bo.isNullOrNil(str2)) {
                        C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is null, err", new Object[0]);
                    } else if (C38283b.m64775AX(str2)) {
                        List<C33262c> list = (List) c10341d.hEn.get(str2);
                        if (list == null) {
                            BluetoothGattService service = c10341d.hEl.getService(UUID.fromString(str2));
                            if (service == null) {
                                C26944a.m42898w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
                            } else {
                                List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                                if (characteristics == null) {
                                    C26944a.m42898w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristics is null, err", new Object[0]);
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                        C33262c c33262c = new C33262c();
                                        c33262c.eCq = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                                        int properties = bluetoothGattCharacteristic.getProperties();
                                        c33262c.hEC = C38283b.m64777og(properties);
                                        c33262c.hED = C38283b.m64778oh(properties);
                                        c33262c.hEE = C38283b.m64779oi(properties);
                                        c33262c.flq = C38283b.m64780oj(properties);
                                        c33262c.hEF = C38283b.m64781ok(properties);
                                        arrayList.add(c33262c);
                                    }
                                    c10341d.hEn.put(str2, arrayList);
                                    list = arrayList;
                                }
                            }
                        }
                        AppMethodBeat.m2505o(94176);
                        return list;
                    } else {
                        C26944a.m42896e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                    }
                }
            }
            AppMethodBeat.m2505o(94176);
            return null;
        }
        AppMethodBeat.m2505o(94176);
        return null;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(94177);
        C42483a.m75251AU(this.appId);
        AppMethodBeat.m2505o(94177);
    }

    public final synchronized void uninit() {
        AppMethodBeat.m2504i(94178);
        if (this.hDu != null) {
            C45588b c45588b = this.hDu;
            if (c45588b.hDY != null) {
                C33260c c33260c = c45588b.hDY;
                C26944a.m42897i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
                if (c33260c.hEg != null) {
                    for (C10341d c10341d : c33260c.hEg.values()) {
                        C26944a.m42897i("MicroMsg.Ble.BleConnectWorker", "uninit deviceId:%s", c10341d.ceI);
                        c10341d.mo21794dW(true);
                        if (c10341d.hEk != null) {
                            C38279b c38279b = c10341d.hEk;
                            if (c38279b.hEb != null) {
                                c38279b.hEb.clear();
                                c38279b.hEb = null;
                            }
                            if (c38279b.hEd != null) {
                                c38279b.hEd.clear();
                                c38279b.hEd = null;
                            }
                            c10341d.hEk = null;
                        }
                        if (c10341d.hEm != null) {
                            c10341d.hEm.clear();
                            c10341d.hEm = null;
                        }
                        if (c10341d.hEn != null) {
                            c10341d.hEn.clear();
                            c10341d.hEn = null;
                        }
                    }
                    c33260c.hEg.clear();
                    c33260c.hEg = null;
                }
            }
            if (c45588b.hDZ != null) {
                C26945a c26945a = c45588b.hDZ;
                C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "uninit", new Object[0]);
                c26945a.cnu.set(false);
                c26945a.aCU();
                if (c26945a.hFg != null) {
                    c26945a.hFg.clear();
                }
                if (c26945a.hFi != null) {
                    c26945a.hFi.clear();
                }
                if (C38283b.aCY() != null && C38283b.aCY().isDiscovering()) {
                    C38283b.aCY().cancelDiscovery();
                }
                if (!(c26945a.hDr == null || c26945a.context == null)) {
                    C4990ab.m7416i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener uninit");
                    c26945a.context.unregisterReceiver(c26945a.hDr);
                    c26945a.hDr = null;
                }
                c26945a.hFe = null;
                c26945a.context = null;
            }
            this.hDu = null;
        }
        AppMethodBeat.m2505o(94178);
    }
}
