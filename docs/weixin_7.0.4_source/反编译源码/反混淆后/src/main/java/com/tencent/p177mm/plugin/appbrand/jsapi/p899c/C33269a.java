package com.tencent.p177mm.plugin.appbrand.jsapi.p899c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.a */
public final class C33269a {
    public static BroadcastReceiver hDr;
    public static boolean hDs;
    public static Map<String, C10354a> map = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.a$a */
    public static class C10354a {
        volatile boolean cFy = false;
        BluetoothAdapter hJY;
        Map<String, JSONObject> hJZ = new ConcurrentHashMap();
        UUID[] hKa = null;
        C10355a hKb;
        long hKc = 0;
        Map<String, JSONObject> hKd = new ConcurrentHashMap();
        LeScanCallback hKe = new C103561();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.a$a$a */
        public interface C10355a {
            /* renamed from: dV */
            void mo21827dV(boolean z);

            /* renamed from: z */
            void mo21828z(Map<String, JSONObject> map);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.a$a$1 */
        class C103561 implements LeScanCallback {
            C103561() {
            }

            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                AppMethodBeat.m2504i(94352);
                if (C5046bo.m7540cb(bArr)) {
                    C4990ab.m7412e("MicroMsg.BeaconManager", "valueByte is null or nil");
                    AppMethodBeat.m2505o(94352);
                    return;
                }
                int i2;
                int i3 = 2;
                Object obj = null;
                while (true) {
                    i2 = i3;
                    if (i2 <= 5) {
                        if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                            obj = 1;
                            break;
                        }
                        i3 = i2 + 1;
                    } else {
                        break;
                    }
                }
                if (obj != null) {
                    int i4;
                    byte[] bArr2 = new byte[16];
                    System.arraycopy(bArr, i2 + 4, bArr2, 0, 16);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i5 = 0; i5 < 16; i5++) {
                        i4 = bArr2[i5] & 255;
                        if (i4 < 16) {
                            stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        stringBuilder.append(Integer.toHexString(i4));
                    }
                    String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                    if (C5046bo.isNullOrNil(toUpperCase)) {
                        C4990ab.m7412e("MicroMsg.BeaconManager", "hexString is null, err");
                        AppMethodBeat.m2505o(94352);
                        return;
                    }
                    int i6;
                    UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
                    obj = null;
                    for (UUID equals : C10354a.this.hKa) {
                        if (equals.equals(fromString)) {
                            obj = 1;
                            break;
                        }
                    }
                    if (obj != null) {
                        double d;
                        i4 = ((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255);
                        i6 = ((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255);
                        byte b = bArr[i2 + 24];
                        double d2 = (double) i;
                        if (d2 == 0.0d) {
                            d = -1.0d;
                        } else {
                            d = (d2 * 1.0d) / ((double) b);
                            if (d < 1.0d) {
                                d = Math.pow(d, 10.0d);
                            } else {
                                d = (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
                            }
                        }
                        String address = bluetoothDevice.getAddress();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("uuid", fromString);
                            jSONObject.put("major", i4);
                            jSONObject.put("minor", i6);
                            jSONObject.put("proximity", 0);
                            jSONObject.put("accuracy", d);
                            jSONObject.put("rssi", i);
                            C10354a.this.hJZ.put(address, jSONObject);
                            C10354a.this.hKd.put(address, jSONObject);
                            C4990ab.m7411d("MicroMsg.BeaconManager", "found device ibeacon %s", jSONObject);
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.BeaconManager", "put JSON data error : %s", e);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - C10354a.this.hKc > 500) {
                            if (C10354a.this.hKb != null) {
                                C10354a.this.hKb.mo21828z(C10354a.this.hKd);
                            }
                            C10354a.this.hKc = currentTimeMillis;
                            C10354a.this.hKd.clear();
                        }
                    }
                }
                AppMethodBeat.m2505o(94352);
            }
        }

        public C10354a() {
            AppMethodBeat.m2504i(94353);
            BluetoothManager bluetoothManager = (BluetoothManager) C4996ah.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                C4990ab.m7412e("MicroMsg.BeaconManager", "bluetoothManager is null!");
                AppMethodBeat.m2505o(94353);
                return;
            }
            this.hJY = bluetoothManager.getAdapter();
            if (this.hJY == null) {
                C4990ab.m7412e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
                AppMethodBeat.m2505o(94353);
                return;
            }
            C33269a.hDs = this.hJY.isEnabled();
            AppMethodBeat.m2505o(94353);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean isStart() {
            return this.cFy;
        }

        /* renamed from: EH */
        public final boolean mo21825EH() {
            AppMethodBeat.m2504i(94354);
            C4990ab.m7417i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", Integer.valueOf(hashCode()));
            if (isStart()) {
                this.hJZ.clear();
                this.hJY.stopLeScan(this.hKe);
                this.cFy = false;
                AppMethodBeat.m2505o(94354);
                return true;
            }
            C4990ab.m7417i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(94354);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.a$1 */
    static class C332701 extends BroadcastReceiver {
        C332701() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z = false;
            AppMethodBeat.m2504i(94351);
            if (intent == null) {
                C4990ab.m7416i("MicroMsg.BeaconManager", "Receive intent failed");
                AppMethodBeat.m2505o(94351);
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int state = defaultAdapter.getState();
                C4990ab.m7411d("MicroMsg.BeaconManager", "state:%d", Integer.valueOf(state));
                if (state == 12) {
                    z = true;
                } else if (state == 10) {
                }
                if ((C33269a.hDs && !z) || (!C33269a.hDs && z)) {
                    for (C10354a c10354a : C33269a.map.values()) {
                        if (c10354a.isStart() && !z) {
                            c10354a.mo21825EH();
                        }
                        if (c10354a.hKb != null) {
                            c10354a.hKb.mo21827dV(z);
                        }
                    }
                }
                C33269a.hDs = z;
            }
            AppMethodBeat.m2505o(94351);
        }
    }

    static {
        AppMethodBeat.m2504i(94358);
        AppMethodBeat.m2505o(94358);
    }

    /* renamed from: a */
    public static void m54419a(String str, C10354a c10354a) {
        AppMethodBeat.m2504i(94355);
        map.put(str, c10354a);
        if (hDr == null) {
            C4990ab.m7416i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            hDr = new C332701();
            C4996ah.getContext().registerReceiver(hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        AppMethodBeat.m2505o(94355);
    }

    /* renamed from: AZ */
    public static C10354a m54418AZ(String str) {
        AppMethodBeat.m2504i(94356);
        C10354a c10354a = (C10354a) map.get(str);
        AppMethodBeat.m2505o(94356);
        return c10354a;
    }

    public static void remove(String str) {
        AppMethodBeat.m2504i(94357);
        map.remove(str);
        C4990ab.m7417i("MicroMsg.BeaconManager", "remove Beacon appid:%s", str);
        if (map.size() == 0 && hDr != null) {
            C4990ab.m7416i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            C4996ah.getContext().unregisterReceiver(hDr);
            hDr = null;
        }
        AppMethodBeat.m2505o(94357);
    }
}
