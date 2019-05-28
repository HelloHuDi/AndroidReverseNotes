package com.tencent.p177mm.plugin.p369d.p370a.p372b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.c */
public final class C2861c implements LeScanCallback {
    private static C2861c jFN;
    private BluetoothAdapter jEU;
    private ArrayList<C2862a> jFO;
    private boolean jFP;
    private Context mContext;
    private C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.d.a.b.c$a */
    public interface C2862a {
        /* renamed from: a */
        void mo6982a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void aVx();
    }

    public static C2861c aVy() {
        AppMethodBeat.m2504i(18381);
        C2861c c2861c;
        if (jFN != null) {
            c2861c = jFN;
            AppMethodBeat.m2505o(18381);
            return c2861c;
        }
        c2861c = new C2861c(C4996ah.getContext());
        jFN = c2861c;
        AppMethodBeat.m2505o(18381);
        return c2861c;
    }

    private C2861c(Context context) {
        AppMethodBeat.m2504i(18382);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            AppMethodBeat.m2505o(18382);
            return;
        }
        this.mContext = context;
        this.jFO = new ArrayList();
        this.jFP = false;
        this.jEU = null;
        this.mHandler = null;
        this.jEU = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new C7306ak(new C5004al("BluetoothLEScanerThread").oAl.getLooper());
        AppMethodBeat.m2505o(18382);
    }

    /* renamed from: a */
    public final boolean mo6989a(final boolean z, final C2862a c2862a) {
        AppMethodBeat.m2504i(18383);
        Boolean bool = (Boolean) new C5039bj<Boolean>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(18379);
                Boolean valueOf = Boolean.valueOf(C2861c.m5098a(C2861c.this, z, c2862a));
                AppMethodBeat.m2505o(18379);
                return valueOf;
            }
        }.mo10372b(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(18383);
        return booleanValue;
    }

    /* renamed from: a */
    private boolean m5097a(C2862a c2862a) {
        boolean z = false;
        AppMethodBeat.m2504i(18384);
        if (c2862a == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            AppMethodBeat.m2505o(18384);
        } else {
            int i;
            while (true) {
                i = z;
                if (i >= this.jFO.size()) {
                    i = -1;
                    break;
                } else if (((C2862a) this.jFO.get(i)) == c2862a) {
                    break;
                } else {
                    z = i + 1;
                }
            }
            if (i < 0) {
                z = this.jFO.add(c2862a);
                C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                C4990ab.m7420w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
            }
            AppMethodBeat.m2505o(18384);
        }
        return z;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        AppMethodBeat.m2504i(18385);
        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", bluetoothDevice.getAddress(), bluetoothDevice.getName(), C42992b.m76349aN(bArr));
        C4990ab.m7411d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", Integer.valueOf(this.jFO.size()));
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18380);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < C2861c.this.jFO.size()) {
                        ((C2862a) C2861c.this.jFO.get(i2)).mo6982a(bluetoothDevice, i, bArr);
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(18380);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.m2505o(18385);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m5098a(C2861c c2861c, boolean z, C2862a c2862a) {
        boolean z2;
        AppMethodBeat.m2504i(18386);
        if (c2861c.mContext == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = c2861c.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            AppMethodBeat.m2505o(18386);
            return false;
        } else if (c2861c.jEU == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            AppMethodBeat.m2505o(18386);
            return false;
        } else {
            if (z) {
                if (c2861c.jFP) {
                    C4990ab.m7420w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    c2861c.m5097a(c2862a);
                    AppMethodBeat.m2505o(18386);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = c2861c.jEU.startLeScan(c2861c);
                if (z2) {
                    c2861c.jFP = true;
                    c2861c.m5097a(c2862a);
                } else if (c2861c.jFO.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + c2861c.jEU.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        c2861c.jEU.stopLeScan(c2861c);
                        c2861c.jFP = false;
                        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        z2 = c2861c.jEU.startLeScan(c2861c);
                        if (z2) {
                            c2861c.jFP = true;
                            c2861c.m5097a(c2862a);
                        }
                        i++;
                    }
                    AppMethodBeat.m2505o(18386);
                    return z2;
                } else if (c2861c.jEU.getState() == 12) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    c2861c.jFP = true;
                    c2861c.m5097a(c2862a);
                    z2 = true;
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (c2861c.jFP) {
                if (c2862a == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback ".concat(String.valueOf(c2861c.jFO.remove(c2862a))));
                }
                if (c2862a != null) {
                    c2862a.aVx();
                }
                C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (c2861c.jFO.size() <= 0) {
                    C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    c2861c.jEU.stopLeScan(c2861c);
                    c2861c.jFP = false;
                }
                z2 = true;
            } else {
                C4990ab.m7421w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", Integer.valueOf(c2861c.jFO.size()));
                AppMethodBeat.m2505o(18386);
                return true;
            }
            AppMethodBeat.m2505o(18386);
            return z2;
        }
    }
}
