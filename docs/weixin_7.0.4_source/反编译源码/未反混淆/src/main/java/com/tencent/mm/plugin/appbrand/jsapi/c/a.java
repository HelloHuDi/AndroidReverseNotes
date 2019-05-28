package com.tencent.mm.plugin.appbrand.jsapi.c;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class a {
    public static BroadcastReceiver hDr;
    public static boolean hDs;
    public static Map<String, a> map = new ConcurrentHashMap();

    public static class a {
        volatile boolean cFy = false;
        BluetoothAdapter hJY;
        Map<String, JSONObject> hJZ = new ConcurrentHashMap();
        UUID[] hKa = null;
        a hKb;
        long hKc = 0;
        Map<String, JSONObject> hKd = new ConcurrentHashMap();
        LeScanCallback hKe = new LeScanCallback() {
            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                AppMethodBeat.i(94352);
                if (bo.cb(bArr)) {
                    ab.e("MicroMsg.BeaconManager", "valueByte is null or nil");
                    AppMethodBeat.o(94352);
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
                    if (bo.isNullOrNil(toUpperCase)) {
                        ab.e("MicroMsg.BeaconManager", "hexString is null, err");
                        AppMethodBeat.o(94352);
                        return;
                    }
                    int i6;
                    UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
                    obj = null;
                    for (UUID equals : a.this.hKa) {
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
                            a.this.hJZ.put(address, jSONObject);
                            a.this.hKd.put(address, jSONObject);
                            ab.d("MicroMsg.BeaconManager", "found device ibeacon %s", jSONObject);
                        } catch (JSONException e) {
                            ab.e("MicroMsg.BeaconManager", "put JSON data error : %s", e);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a.this.hKc > 500) {
                            if (a.this.hKb != null) {
                                a.this.hKb.z(a.this.hKd);
                            }
                            a.this.hKc = currentTimeMillis;
                            a.this.hKd.clear();
                        }
                    }
                }
                AppMethodBeat.o(94352);
            }
        };

        public interface a {
            void dV(boolean z);

            void z(Map<String, JSONObject> map);
        }

        public a() {
            AppMethodBeat.i(94353);
            BluetoothManager bluetoothManager = (BluetoothManager) ah.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                ab.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
                AppMethodBeat.o(94353);
                return;
            }
            this.hJY = bluetoothManager.getAdapter();
            if (this.hJY == null) {
                ab.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
                AppMethodBeat.o(94353);
                return;
            }
            a.hDs = this.hJY.isEnabled();
            AppMethodBeat.o(94353);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean isStart() {
            return this.cFy;
        }

        public final boolean EH() {
            AppMethodBeat.i(94354);
            ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", Integer.valueOf(hashCode()));
            if (isStart()) {
                this.hJZ.clear();
                this.hJY.stopLeScan(this.hKe);
                this.cFy = false;
                AppMethodBeat.o(94354);
                return true;
            }
            ab.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", Integer.valueOf(hashCode()));
            AppMethodBeat.o(94354);
            return false;
        }
    }

    static {
        AppMethodBeat.i(94358);
        AppMethodBeat.o(94358);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(94355);
        map.put(str, aVar);
        if (hDr == null) {
            ab.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            hDr = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    boolean z = false;
                    AppMethodBeat.i(94351);
                    if (intent == null) {
                        ab.i("MicroMsg.BeaconManager", "Receive intent failed");
                        AppMethodBeat.o(94351);
                        return;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        int state = defaultAdapter.getState();
                        ab.d("MicroMsg.BeaconManager", "state:%d", Integer.valueOf(state));
                        if (state == 12) {
                            z = true;
                        } else if (state == 10) {
                        }
                        if ((a.hDs && !z) || (!a.hDs && z)) {
                            for (a aVar : a.map.values()) {
                                if (aVar.isStart() && !z) {
                                    aVar.EH();
                                }
                                if (aVar.hKb != null) {
                                    aVar.hKb.dV(z);
                                }
                            }
                        }
                        a.hDs = z;
                    }
                    AppMethodBeat.o(94351);
                }
            };
            ah.getContext().registerReceiver(hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        AppMethodBeat.o(94355);
    }

    public static a AZ(String str) {
        AppMethodBeat.i(94356);
        a aVar = (a) map.get(str);
        AppMethodBeat.o(94356);
        return aVar;
    }

    public static void remove(String str) {
        AppMethodBeat.i(94357);
        map.remove(str);
        ab.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", str);
        if (map.size() == 0 && hDr != null) {
            ab.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            ah.getContext().unregisterReceiver(hDr);
            hDr = null;
        }
        AppMethodBeat.o(94357);
    }
}
