package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.C44696b.C33257a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a.C26943a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10345h;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C38282g;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker$3;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.C26945a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.C26945a.C103492;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.C19343a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a */
public final class C42483a {
    public static BroadcastReceiver hDr;
    public static boolean hDs;
    public static C26943a hDt = new C332551();
    private static Map<String, C44696b> map = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a$1 */
    static class C332551 implements C26943a {
        C332551() {
        }

        /* renamed from: e */
        public final void mo44679e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(94162);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(94162);
        }

        /* renamed from: w */
        public final void mo44681w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(94163);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(94163);
        }

        /* renamed from: i */
        public final void mo44680i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(94164);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(94164);
        }

        /* renamed from: d */
        public final void mo44678d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(94165);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(94165);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a$2 */
    static class C332562 extends BroadcastReceiver {
        C332562() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z = false;
            AppMethodBeat.m2504i(94166);
            if (intent == null) {
                C4990ab.m7416i("MicroMsg.Ble.BleManager", "Receive intent failed");
                AppMethodBeat.m2505o(94166);
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int state = defaultAdapter.getState();
                C4990ab.m7411d("MicroMsg.Ble.BleManager", "state:%d", Integer.valueOf(state));
                if (state == 12) {
                    z = true;
                } else if (state == 10) {
                }
                if ((C42483a.hDs && !z) || (!C42483a.hDs && z)) {
                    for (C44696b c44696b : C42483a.map.values()) {
                        if (c44696b.hDv != null) {
                            c44696b.hDv.mo21793dV(z);
                        }
                    }
                }
                C42483a.hDs = z;
            }
            AppMethodBeat.m2505o(94166);
        }
    }

    static {
        AppMethodBeat.m2504i(94172);
        AppMethodBeat.m2505o(94172);
    }

    /* renamed from: a */
    public static C26942j m75252a(String str, C33257a c33257a, C10345h c10345h, C38282g c38282g) {
        int i;
        AppMethodBeat.m2504i(94167);
        C4990ab.m7417i("MicroMsg.Ble.BleManager", "open appId:%s", str);
        if (C1443d.m3067fP(18) || !C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            i = 0;
        } else {
            i = 1;
        }
        C26942j c26942j;
        if (i == 0) {
            C4990ab.m7412e("MicroMsg.Ble.BleManager", "api version is below 18");
            c26942j = C26942j.hEW;
            AppMethodBeat.m2505o(94167);
            return c26942j;
        }
        if (!map.containsKey(str)) {
            C45588b c45588b;
            C4990ab.m7421w("MicroMsg.Ble.BleManager", "already open appId:%s", str);
            C33186c c44696b = new C44696b(str);
            c44696b.hDu = new C45588b(C4996ah.getContext());
            C45588b c45588b2 = c44696b.hDu;
            C33260c c33260c = c45588b2.hDY;
            C26944a.m42897i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
            if (c33260c.hEg == null) {
                c33260c.hEg = new ConcurrentHashMap();
            }
            c33260c.hEg.clear();
            C26945a c26945a = c45588b2.hDZ;
            C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "init", new Object[0]);
            c26945a.cnu.set(true);
            c26945a.hFg = new HashMap();
            c26945a.hFi = new ArrayList();
            c26945a.hFe = new C103492();
            String str2 = "middle";
            if (str2.equals("low")) {
                c26945a.hFf = new C19343a().mo34507of(0).aCW();
            } else if (str2.equals("middle")) {
                c26945a.hFf = new C19343a().mo34507of(1).aCW();
            } else if (str2.equals("high")) {
                c26945a.hFf = new C19343a().mo34507of(2).aCW();
            } else {
                c26945a.hFf = new C19343a().mo34507of(0).aCW();
            }
            if (c26945a.hDr == null) {
                C4990ab.m7416i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener init");
                c26945a.hDr = new BleScanWorker$3(c26945a);
                c26945a.context.registerReceiver(c26945a.hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            }
            c44696b.hDv = c33257a;
            if (c44696b.hDu != null) {
                c45588b = c44696b.hDu;
                if (c45588b.hDY != null) {
                    c45588b.hDY.hEh = c10345h;
                }
            }
            if (c44696b.hDu != null) {
                c45588b = c44696b.hDu;
                if (c45588b.hDY != null) {
                    c45588b.hDY.hEi = c38282g;
                }
            }
            map.put(str, c44696b);
            C33183g.m54274a(str, c44696b);
            C42483a.aCM();
            C26944a.hGh = hDt;
        }
        if (C38283b.aCZ()) {
            c26942j = C26942j.hEL;
            AppMethodBeat.m2505o(94167);
            return c26942j;
        }
        C4990ab.m7412e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
        c26942j = C26942j.hEO;
        AppMethodBeat.m2505o(94167);
        return c26942j;
    }

    /* renamed from: AT */
    public static C44696b m75250AT(String str) {
        AppMethodBeat.m2504i(94168);
        C44696b c44696b = (C44696b) map.get(str);
        AppMethodBeat.m2505o(94168);
        return c44696b;
    }

    /* renamed from: AU */
    public static C26942j m75251AU(String str) {
        AppMethodBeat.m2504i(94169);
        C4990ab.m7417i("MicroMsg.Ble.BleManager", "close appId:%s", str);
        C26942j c26942j;
        if (map.containsKey(str)) {
            C44696b c44696b = (C44696b) map.remove(str);
            C33183g.m54276b(str, c44696b);
            c44696b.uninit();
            if (map.size() == 0) {
                C42483a.aCN();
            }
            c26942j = C26942j.hEL;
            AppMethodBeat.m2505o(94169);
            return c26942j;
        }
        c26942j = C26942j.hEL;
        AppMethodBeat.m2505o(94169);
        return c26942j;
    }

    private static synchronized void aCM() {
        synchronized (C42483a.class) {
            AppMethodBeat.m2504i(94170);
            if (hDr == null) {
                C4990ab.m7416i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
                hDr = new C332562();
                C4996ah.getContext().registerReceiver(hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                hDs = C38283b.aCZ();
            }
            AppMethodBeat.m2505o(94170);
        }
    }

    private static synchronized void aCN() {
        synchronized (C42483a.class) {
            AppMethodBeat.m2504i(94171);
            if (hDr != null) {
                C4990ab.m7416i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
                C4996ah.getContext().unregisterReceiver(hDr);
                hDr = null;
            }
            AppMethodBeat.m2505o(94171);
        }
    }
}
