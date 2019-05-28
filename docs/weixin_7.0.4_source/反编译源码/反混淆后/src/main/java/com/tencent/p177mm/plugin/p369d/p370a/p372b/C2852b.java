package com.tencent.p177mm.plugin.p369d.p370a.p372b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C2861c.C2862a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C33891g.C2872a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.b */
public final class C2852b {
    /* renamed from: Gn */
    public Context f1263Gn;
    public BluetoothAdapter jEU;
    public final HashMap<String, C2865d> jFA;
    volatile boolean jFB;
    public C2861c jFC;
    public C33891g jFD;
    final HashSet<Long> jFE;
    private C2862a jFF;
    private C2872a jFG;
    public C2854a jFz;
    public C7306ak mHandler;
    public volatile boolean mIsInit;
    private Runnable mRunnable;

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$b */
    public final class C2853b implements Runnable {
        private long jFL = 0;
        private long jFM = 0;

        public C2853b(long j, long j2) {
            this.jFL = j;
            this.jFM = j2;
        }

        public final void run() {
            AppMethodBeat.m2504i(18370);
            C2852b c2852b = C2852b.this;
            C2865d c2865d = new C2865d(this.jFL, c2852b.f1263Gn, c2852b);
            String valueOf = String.valueOf(c2865d.mSessionId);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", Integer.valueOf(c2865d.hashCode()), Long.valueOf(r2), valueOf);
            C2865d c2865d2 = (C2865d) c2852b.jFA.remove(valueOf);
            if (c2865d2 != null) {
                c2865d2.close();
            }
            c2852b.jFA.put(valueOf, c2865d);
            long j = c2865d.mSessionId;
            if (C2852b.this.jFz != null) {
                C2852b.this.jFz.mo6978g(j, this.jFL, this.jFM);
            }
            AppMethodBeat.m2505o(18370);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$a */
    public static abstract class C2854a {
        /* renamed from: g */
        public void mo6978g(long j, long j2, long j3) {
        }

        /* renamed from: l */
        public void mo6979l(long j, boolean z) {
        }

        /* renamed from: b */
        public void mo6977b(long j, byte[] bArr) {
        }

        /* renamed from: m */
        public void mo6980m(long j, boolean z) {
        }

        /* renamed from: a */
        public void mo6975a(String str, String str2, int i, byte[] bArr) {
        }

        public void aVx() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$1 */
    class C28551 implements Runnable {
        C28551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18363);
            C2852b.this.jFB = false;
            C2852b.this.mo6973fv(false);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
            C2852b.this.aVv();
            if (C2852b.this.jFz != null) {
                C2852b.this.jFz.aVx();
            }
            AppMethodBeat.m2505o(18363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$2 */
    class C28562 implements C2862a {
        C28562() {
        }

        /* renamed from: a */
        public final void mo6982a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
            AppMethodBeat.m2504i(18365);
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(C42992b.m76346KK(bluetoothDevice.getAddress())));
            C2852b.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18364);
                    C2852b.m5085a(C2852b.this, bluetoothDevice, i, bArr);
                    AppMethodBeat.m2505o(18364);
                }
            });
            AppMethodBeat.m2505o(18365);
        }

        public final void aVx() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$3 */
    class C28583 implements C2872a {

        /* renamed from: com.tencent.mm.plugin.d.a.b.b$3$2 */
        class C28592 implements Runnable {
            C28592() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18367);
                if (!C2852b.this.jFE.isEmpty()) {
                    Iterator it = C2852b.this.jFE.iterator();
                    while (it.hasNext()) {
                        C4990ab.m7413e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                        if (C2852b.this.jFz != null) {
                            C2852b.this.jFz.mo6979l(r0.longValue(), false);
                        }
                    }
                    C2852b.this.jFE.clear();
                }
                AppMethodBeat.m2505o(18367);
            }
        }

        C28583() {
        }

        /* renamed from: a */
        public final void mo6985a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
            AppMethodBeat.m2504i(18368);
            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(C42992b.m76346KK(bluetoothDevice.getAddress())));
            C2852b.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18366);
                    C2852b.m5085a(C2852b.this, bluetoothDevice, i, bArr);
                    AppMethodBeat.m2505o(18366);
                }
            });
            AppMethodBeat.m2505o(18368);
        }

        /* renamed from: rR */
        public final void mo6986rR(int i) {
            AppMethodBeat.m2504i(18369);
            C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", Integer.valueOf(i));
            if (i != 1) {
                C2852b.this.mHandler.post(new C28592());
            }
            AppMethodBeat.m2505o(18369);
        }
    }

    public C2852b(C5004al c5004al) {
        AppMethodBeat.m2504i(18371);
        this.jFz = null;
        this.f1263Gn = null;
        this.jFA = new HashMap();
        this.jEU = null;
        this.mHandler = null;
        this.mRunnable = null;
        this.jFB = false;
        this.mIsInit = false;
        this.jFE = new HashSet();
        this.jFF = new C28562();
        this.jFG = new C28583();
        this.mRunnable = new C28551();
        this.mHandler = new C7306ak(c5004al.oAl.getLooper());
        AppMethodBeat.m2505o(18371);
    }

    /* Access modifiers changed, original: final */
    public final void aVv() {
        AppMethodBeat.m2504i(18372);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.jFE.isEmpty()) {
            Iterator it = this.jFE.iterator();
            while (it.hasNext()) {
                C4990ab.m7413e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                if (this.jFz != null) {
                    this.jFz.mo6979l(r0.longValue(), false);
                }
            }
            this.jFE.clear();
        }
        AppMethodBeat.m2505o(18372);
    }

    private void stopScan() {
        AppMethodBeat.m2504i(18374);
        if (this.jFB) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.jFB = false;
            mo6973fv(false);
            aVv();
            if (this.jFz != null) {
                this.jFz.aVx();
            }
            AppMethodBeat.m2505o(18374);
            return;
        }
        AppMethodBeat.m2505o(18374);
    }

    /* renamed from: a */
    public final boolean mo6969a(boolean z, int... iArr) {
        String str;
        AppMethodBeat.m2504i(18375);
        String str2 = "MicroMsg.exdevice.BluetoothLEManager";
        StringBuilder stringBuilder = new StringBuilder("------scanLEDevice------");
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        C4990ab.m7416i(str2, stringBuilder.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!aVw()) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            AppMethodBeat.m2505o(18375);
            return false;
        } else if (!z) {
            stopScan();
            AppMethodBeat.m2505o(18375);
            return true;
        } else if (this.jFB) {
            AppMethodBeat.m2505o(18375);
            return true;
        } else if (mo6973fv(z)) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
            } else {
                this.mHandler.removeCallbacks(this.mRunnable);
            }
            this.jFB = true;
            AppMethodBeat.m2505o(18375);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.jFE.isEmpty()) {
                Iterator it = this.jFE.iterator();
                while (it.hasNext()) {
                    C4990ab.m7413e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                    if (this.jFz != null) {
                        this.jFz.mo6979l(r0.longValue(), false);
                    }
                }
                this.jFE.clear();
            }
            AppMethodBeat.m2505o(18375);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fv */
    public final boolean mo6973fv(boolean z) {
        AppMethodBeat.m2504i(18376);
        boolean z2 = false;
        if (C1443d.m3068iW(21) && this.jFD != null) {
            z2 = this.jFD.mo54448a(z, this.jFG);
        } else if (this.jFC != null) {
            z2 = this.jFC.mo6989a(z, this.jFF);
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        }
        AppMethodBeat.m2505o(18376);
        return z2;
    }

    public final boolean connect(long j) {
        AppMethodBeat.m2504i(18377);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", Long.valueOf(j));
        Assert.assertTrue(this.mIsInit);
        if (aVw()) {
            boolean connect;
            C2865d c2865d = (C2865d) this.jFA.get(String.valueOf(j));
            Assert.assertTrue(c2865d != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.f1263Gn.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", address.getAddress(), Long.valueOf(C42992b.m76346KK(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName());
                        if (j == C42992b.m76346KK(((BluetoothDevice) r3.next()).getAddress())) {
                            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            connect = c2865d.connect();
                            AppMethodBeat.m2505o(18377);
                            return connect;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", VERSION.RELEASE);
                    if (!C1443d.m3068iW(23) || ((LocationManager) this.f1263Gn.getSystemService(C8741b.LOCATION)).isProviderEnabled("gps") || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                        if (bondedDevices == null) {
                            C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                        } else {
                            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                                C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", bluetoothDevice.getAddress(), Long.valueOf(C42992b.m76346KK(bluetoothDevice.getAddress())), bluetoothDevice.getName());
                                if (j == C42992b.m76346KK(bluetoothDevice.getAddress())) {
                                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                    InputManager inputManager = (InputManager) this.f1263Gn.getSystemService("input");
                                    int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                    if (inputDeviceIds == null) {
                                        C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                        break;
                                    }
                                    for (int inputDevice : inputDeviceIds) {
                                        InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                        if (inputDevice2 != null) {
                                            String name = inputDevice2.getName();
                                            C4990ab.m7411d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", name);
                                            if (name != null && name.equals(bluetoothDevice.getName())) {
                                                C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                                connect = c2865d.connect();
                                                AppMethodBeat.m2505o(18377);
                                                return connect;
                                            }
                                        }
                                    }
                                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                                }
                            }
                        }
                    } else {
                        connect = c2865d.connect();
                        AppMethodBeat.m2505o(18377);
                        return connect;
                    }
                }
            }
            this.jFE.add(Long.valueOf(j));
            connect = mo6969a(true, new int[0]);
            AppMethodBeat.m2505o(18377);
            return connect;
        }
        C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        AppMethodBeat.m2505o(18377);
        return false;
    }

    @TargetApi(18)
    public final boolean aVw() {
        AppMethodBeat.m2504i(18373);
        Assert.assertTrue(this.mIsInit);
        boolean hasSystemFeature = this.f1263Gn.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.m2505o(18373);
        return hasSystemFeature;
    }

    /* renamed from: a */
    static /* synthetic */ void m5085a(C2852b c2852b, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        AppMethodBeat.m2504i(18378);
        C4990ab.m7410d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!c2852b.jFE.isEmpty()) {
            long KK = C42992b.m76346KK(bluetoothDevice.getAddress());
            if (c2852b.jFE.contains(Long.valueOf(KK))) {
                C4990ab.m7417i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", Long.valueOf(KK));
                C2865d c2865d = (C2865d) c2852b.jFA.get(String.valueOf(KK));
                if (c2865d == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (c2852b.jFz != null) {
                        c2852b.jFz.mo6979l(KK, false);
                    }
                } else if (!c2865d.connect()) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (c2852b.jFz != null) {
                        c2852b.jFz.mo6979l(KK, false);
                    }
                }
                c2852b.jFE.remove(Long.valueOf(KK));
                if (c2852b.jFE.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (c2852b.jFz != null) {
            c2852b.jFz.mo6975a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
        AppMethodBeat.m2505o(18378);
    }
}
