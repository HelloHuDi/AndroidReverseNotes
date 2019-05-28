package com.tencent.p177mm.plugin.p369d.p370a.p372b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

@TargetApi(21)
/* renamed from: com.tencent.mm.plugin.d.a.b.g */
public final class C33891g extends ScanCallback {
    private static C33891g jGB;
    private BluetoothAdapter jEU;
    private ArrayList<C2872a> jFO;
    private boolean jFP;
    private BluetoothManager jGC;
    private BluetoothLeScanner jGD;
    private Context mContext;
    private C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.d.a.b.g$a */
    public interface C2872a {
        /* renamed from: a */
        void mo6985a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        /* renamed from: rR */
        void mo6986rR(int i);
    }

    public static C33891g aVD() {
        AppMethodBeat.m2504i(18448);
        C33891g c33891g;
        if (jGB != null) {
            c33891g = jGB;
            AppMethodBeat.m2505o(18448);
            return c33891g;
        }
        c33891g = new C33891g(C4996ah.getContext());
        jGB = c33891g;
        AppMethodBeat.m2505o(18448);
        return c33891g;
    }

    private C33891g(Context context) {
        AppMethodBeat.m2504i(18449);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            AppMethodBeat.m2505o(18449);
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
            C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.jGD = this.jEU.getBluetoothLeScanner();
        }
        this.mHandler = new C7306ak(new C5004al("NewBluetoothLEScannerThread").oAl.getLooper());
        AppMethodBeat.m2505o(18449);
    }

    /* renamed from: a */
    public final boolean mo54448a(final boolean z, final C2872a c2872a) {
        AppMethodBeat.m2504i(18450);
        C4990ab.m7416i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
        Boolean bool = (Boolean) new C5039bj<Boolean>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(18445);
                Boolean valueOf = Boolean.valueOf(C33891g.m55465a(C33891g.this, z, c2872a));
                AppMethodBeat.m2505o(18445);
                return valueOf;
            }
        }.mo10372b(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(18450);
        return booleanValue;
    }

    /* renamed from: a */
    private boolean m55464a(C2872a c2872a) {
        boolean z = false;
        AppMethodBeat.m2504i(18451);
        if (c2872a == null) {
            C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            AppMethodBeat.m2505o(18451);
        } else {
            int i;
            while (true) {
                i = z;
                if (i >= this.jFO.size()) {
                    i = -1;
                    break;
                } else if (((C2872a) this.jFO.get(i)) == c2872a) {
                    break;
                } else {
                    z = i + 1;
                }
            }
            if (i < 0) {
                z = this.jFO.add(c2872a);
                C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                C4990ab.m7420w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
            }
            AppMethodBeat.m2505o(18451);
        }
        return z;
    }

    public final void onScanFailed(final int i) {
        AppMethodBeat.m2504i(18452);
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18447);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < C33891g.this.jFO.size()) {
                        ((C2872a) C33891g.this.jFO.get(i2)).mo6986rR(i);
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(18447);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.m2505o(18452);
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        AppMethodBeat.m2504i(18453);
        if (!(scanResult == null || scanResult.getScanRecord() == null)) {
            C4990ab.m7411d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), C42992b.m76349aN(scanResult.getScanRecord().getBytes()));
            C4990ab.m7411d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", Integer.valueOf(this.jFO.size()));
            final BluetoothDevice device = scanResult.getDevice();
            final int rssi = scanResult.getRssi();
            final byte[] bytes = scanResult.getScanRecord().getBytes();
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18446);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < C33891g.this.jFO.size()) {
                            ((C2872a) C33891g.this.jFO.get(i2)).mo6985a(device, rssi, bytes);
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(18446);
                            return;
                        }
                    }
                }
            });
        }
        AppMethodBeat.m2505o(18453);
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        AppMethodBeat.m2504i(18454);
        if (list != null) {
            for (ScanResult scanResult : list) {
                C4990ab.m7411d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), C42992b.m76349aN(scanResult.getScanRecord().getBytes()));
            }
        }
        AppMethodBeat.m2505o(18454);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m55465a(C33891g c33891g, boolean z, C2872a c2872a) {
        boolean z2;
        AppMethodBeat.m2504i(18455);
        if (c33891g.mContext == null) {
            C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = c33891g.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (c33891g.jGD == null) {
                c33891g.jEU = c33891g.jGC.getAdapter();
                if (c33891g.jEU != null) {
                    C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    c33891g.jGD = c33891g.jEU.getBluetoothLeScanner();
                    if (c33891g.jGD == null) {
                        AppMethodBeat.m2505o(18455);
                        return false;
                    }
                }
                C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                AppMethodBeat.m2505o(18455);
                return false;
            }
            if (!C42904a.aVH()) {
                C4990ab.m7416i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (c33891g.jFP) {
                    C4990ab.m7420w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    c33891g.m55464a(c2872a);
                } else {
                    c33891g.jGD.startScan(c33891g);
                    c33891g.m55464a(c2872a);
                    c33891g.jFP = true;
                }
            } else if (c33891g.jFP) {
                if (c2872a == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback ".concat(String.valueOf(c33891g.jFO.remove(c2872a))));
                }
                if (c33891g.jFO.size() <= 0) {
                    C4990ab.m7410d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    c33891g.jGD.stopScan(c33891g);
                    c33891g.jFP = false;
                }
            } else {
                C4990ab.m7421w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", Integer.valueOf(c33891g.jFO.size()));
            }
            AppMethodBeat.m2505o(18455);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        AppMethodBeat.m2505o(18455);
        return false;
    }
}
