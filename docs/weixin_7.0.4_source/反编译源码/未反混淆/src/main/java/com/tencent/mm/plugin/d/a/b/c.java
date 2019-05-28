package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c jFN;
    private BluetoothAdapter jEU;
    private ArrayList<a> jFO;
    private boolean jFP;
    private Context mContext;
    private ak mHandler;

    public interface a {
        void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void aVx();
    }

    public static c aVy() {
        AppMethodBeat.i(18381);
        c cVar;
        if (jFN != null) {
            cVar = jFN;
            AppMethodBeat.o(18381);
            return cVar;
        }
        cVar = new c(ah.getContext());
        jFN = cVar;
        AppMethodBeat.o(18381);
        return cVar;
    }

    private c(Context context) {
        AppMethodBeat.i(18382);
        if (context == null) {
            ab.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            AppMethodBeat.o(18382);
            return;
        }
        this.mContext = context;
        this.jFO = new ArrayList();
        this.jFP = false;
        this.jEU = null;
        this.mHandler = null;
        this.jEU = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new ak(new al("BluetoothLEScanerThread").oAl.getLooper());
        AppMethodBeat.o(18382);
    }

    public final boolean a(final boolean z, final a aVar) {
        AppMethodBeat.i(18383);
        Boolean bool = (Boolean) new bj<Boolean>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(18379);
                Boolean valueOf = Boolean.valueOf(c.a(c.this, z, aVar));
                AppMethodBeat.o(18379);
                return valueOf;
            }
        }.b(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(18383);
        return booleanValue;
    }

    private boolean a(a aVar) {
        boolean z = false;
        AppMethodBeat.i(18384);
        if (aVar == null) {
            ab.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            AppMethodBeat.o(18384);
        } else {
            int i;
            while (true) {
                i = z;
                if (i >= this.jFO.size()) {
                    i = -1;
                    break;
                } else if (((a) this.jFO.get(i)) == aVar) {
                    break;
                } else {
                    z = i + 1;
                }
            }
            if (i < 0) {
                z = this.jFO.add(aVar);
                ab.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                ab.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
            }
            AppMethodBeat.o(18384);
        }
        return z;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        AppMethodBeat.i(18385);
        ab.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.aN(bArr));
        ab.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", Integer.valueOf(this.jFO.size()));
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18380);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < c.this.jFO.size()) {
                        ((a) c.this.jFO.get(i2)).a(bluetoothDevice, i, bArr);
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(18380);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(18385);
    }

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean z2;
        AppMethodBeat.i(18386);
        if (cVar.mContext == null) {
            ab.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            ab.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            AppMethodBeat.o(18386);
            return false;
        } else if (cVar.jEU == null) {
            ab.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            AppMethodBeat.o(18386);
            return false;
        } else {
            if (z) {
                if (cVar.jFP) {
                    ab.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    AppMethodBeat.o(18386);
                    return true;
                }
                ab.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = cVar.jEU.startLeScan(cVar);
                if (z2) {
                    cVar.jFP = true;
                    cVar.a(aVar);
                } else if (cVar.jFO.size() <= 0) {
                    ab.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.jEU.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        cVar.jEU.stopLeScan(cVar);
                        cVar.jFP = false;
                        ab.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        z2 = cVar.jEU.startLeScan(cVar);
                        if (z2) {
                            cVar.jFP = true;
                            cVar.a(aVar);
                        }
                        i++;
                    }
                    AppMethodBeat.o(18386);
                    return z2;
                } else if (cVar.jEU.getState() == 12) {
                    ab.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.jFP = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    ab.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (cVar.jFP) {
                if (aVar == null) {
                    ab.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    ab.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback ".concat(String.valueOf(cVar.jFO.remove(aVar))));
                }
                if (aVar != null) {
                    aVar.aVx();
                }
                ab.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.jFO.size() <= 0) {
                    ab.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.jEU.stopLeScan(cVar);
                    cVar.jFP = false;
                }
                z2 = true;
            } else {
                ab.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", Integer.valueOf(cVar.jFO.size()));
                AppMethodBeat.o(18386);
                return true;
            }
            AppMethodBeat.o(18386);
            return z2;
        }
    }
}
