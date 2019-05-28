package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g jGB;
    private BluetoothAdapter jEU;
    private ArrayList<a> jFO;
    private boolean jFP;
    private BluetoothManager jGC;
    private BluetoothLeScanner jGD;
    private Context mContext;
    private ak mHandler;

    public interface a {
        void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void rR(int i);
    }

    public static g aVD() {
        AppMethodBeat.i(18448);
        g gVar;
        if (jGB != null) {
            gVar = jGB;
            AppMethodBeat.o(18448);
            return gVar;
        }
        gVar = new g(ah.getContext());
        jGB = gVar;
        AppMethodBeat.o(18448);
        return gVar;
    }

    private g(Context context) {
        AppMethodBeat.i(18449);
        if (context == null) {
            ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            AppMethodBeat.o(18449);
            return;
        }
        this.mContext = context;
        this.jFO = new ArrayList();
        this.jFP = false;
        this.jEU = null;
        this.jGD = null;
        this.mHandler = null;
        this.jGC = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.jEU = this.jGC.getAdapter();
        if (this.jEU != null) {
            ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.jGD = this.jEU.getBluetoothLeScanner();
        }
        this.mHandler = new ak(new al("NewBluetoothLEScannerThread").oAl.getLooper());
        AppMethodBeat.o(18449);
    }

    public final boolean a(final boolean z, final a aVar) {
        AppMethodBeat.i(18450);
        ab.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
        Boolean bool = (Boolean) new bj<Boolean>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(18445);
                Boolean valueOf = Boolean.valueOf(g.a(g.this, z, aVar));
                AppMethodBeat.o(18445);
                return valueOf;
            }
        }.b(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(18450);
        return booleanValue;
    }

    private boolean a(a aVar) {
        boolean z = false;
        AppMethodBeat.i(18451);
        if (aVar == null) {
            ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            AppMethodBeat.o(18451);
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
                ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                ab.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
            }
            AppMethodBeat.o(18451);
        }
        return z;
    }

    public final void onScanFailed(final int i) {
        AppMethodBeat.i(18452);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18447);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < g.this.jFO.size()) {
                        ((a) g.this.jFO.get(i2)).rR(i);
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(18447);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(18452);
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        AppMethodBeat.i(18453);
        if (!(scanResult == null || scanResult.getScanRecord() == null)) {
            ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aN(scanResult.getScanRecord().getBytes()));
            ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", Integer.valueOf(this.jFO.size()));
            final BluetoothDevice device = scanResult.getDevice();
            final int rssi = scanResult.getRssi();
            final byte[] bytes = scanResult.getScanRecord().getBytes();
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18446);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < g.this.jFO.size()) {
                            ((a) g.this.jFO.get(i2)).a(device, rssi, bytes);
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(18446);
                            return;
                        }
                    }
                }
            });
        }
        AppMethodBeat.o(18453);
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        AppMethodBeat.i(18454);
        if (list != null) {
            for (ScanResult scanResult : list) {
                ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aN(scanResult.getScanRecord().getBytes()));
            }
        }
        AppMethodBeat.o(18454);
    }

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean z2;
        AppMethodBeat.i(18455);
        if (gVar.mContext == null) {
            ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (gVar.jGD == null) {
                gVar.jEU = gVar.jGC.getAdapter();
                if (gVar.jEU != null) {
                    ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    gVar.jGD = gVar.jEU.getBluetoothLeScanner();
                    if (gVar.jGD == null) {
                        AppMethodBeat.o(18455);
                        return false;
                    }
                }
                ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                AppMethodBeat.o(18455);
                return false;
            }
            if (!com.tencent.mm.plugin.d.a.e.a.aVH()) {
                ab.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (gVar.jFP) {
                    ab.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    gVar.a(aVar);
                } else {
                    gVar.jGD.startScan(gVar);
                    gVar.a(aVar);
                    gVar.jFP = true;
                }
            } else if (gVar.jFP) {
                if (aVar == null) {
                    ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback ".concat(String.valueOf(gVar.jFO.remove(aVar))));
                }
                if (gVar.jFO.size() <= 0) {
                    ab.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    gVar.jGD.stopScan(gVar);
                    gVar.jFP = false;
                }
            } else {
                ab.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", Integer.valueOf(gVar.jFO.size()));
            }
            AppMethodBeat.o(18455);
            return true;
        }
        ab.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        AppMethodBeat.o(18455);
        return false;
    }
}
