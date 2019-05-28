package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public Context Gn;
    public BluetoothAdapter jEU;
    public final HashMap<String, d> jFA;
    volatile boolean jFB;
    public c jFC;
    public g jFD;
    final HashSet<Long> jFE;
    private com.tencent.mm.plugin.d.a.b.c.a jFF;
    private com.tencent.mm.plugin.d.a.b.g.a jFG;
    public a jFz;
    public ak mHandler;
    public volatile boolean mIsInit;
    private Runnable mRunnable;

    public final class b implements Runnable {
        private long jFL = 0;
        private long jFM = 0;

        public b(long j, long j2) {
            this.jFL = j;
            this.jFM = j2;
        }

        public final void run() {
            AppMethodBeat.i(18370);
            b bVar = b.this;
            d dVar = new d(this.jFL, bVar.Gn, bVar);
            String valueOf = String.valueOf(dVar.mSessionId);
            ab.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", Integer.valueOf(dVar.hashCode()), Long.valueOf(r2), valueOf);
            d dVar2 = (d) bVar.jFA.remove(valueOf);
            if (dVar2 != null) {
                dVar2.close();
            }
            bVar.jFA.put(valueOf, dVar);
            long j = dVar.mSessionId;
            if (b.this.jFz != null) {
                b.this.jFz.g(j, this.jFL, this.jFM);
            }
            AppMethodBeat.o(18370);
        }
    }

    public static abstract class a {
        public void g(long j, long j2, long j3) {
        }

        public void l(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void m(long j, boolean z) {
        }

        public void a(String str, String str2, int i, byte[] bArr) {
        }

        public void aVx() {
        }
    }

    public b(al alVar) {
        AppMethodBeat.i(18371);
        this.jFz = null;
        this.Gn = null;
        this.jFA = new HashMap();
        this.jEU = null;
        this.mHandler = null;
        this.mRunnable = null;
        this.jFB = false;
        this.mIsInit = false;
        this.jFE = new HashSet();
        this.jFF = new com.tencent.mm.plugin.d.a.b.c.a() {
            public final void a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                AppMethodBeat.i(18365);
                ab.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.KK(bluetoothDevice.getAddress())));
                b.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18364);
                        b.a(b.this, bluetoothDevice, i, bArr);
                        AppMethodBeat.o(18364);
                    }
                });
                AppMethodBeat.o(18365);
            }

            public final void aVx() {
            }
        };
        this.jFG = new com.tencent.mm.plugin.d.a.b.g.a() {
            public final void a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                AppMethodBeat.i(18368);
                ab.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.KK(bluetoothDevice.getAddress())));
                b.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18366);
                        b.a(b.this, bluetoothDevice, i, bArr);
                        AppMethodBeat.o(18366);
                    }
                });
                AppMethodBeat.o(18368);
            }

            public final void rR(int i) {
                AppMethodBeat.i(18369);
                ab.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", Integer.valueOf(i));
                if (i != 1) {
                    b.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(18367);
                            if (!b.this.jFE.isEmpty()) {
                                Iterator it = b.this.jFE.iterator();
                                while (it.hasNext()) {
                                    ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                                    if (b.this.jFz != null) {
                                        b.this.jFz.l(r0.longValue(), false);
                                    }
                                }
                                b.this.jFE.clear();
                            }
                            AppMethodBeat.o(18367);
                        }
                    });
                }
                AppMethodBeat.o(18369);
            }
        };
        this.mRunnable = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18363);
                b.this.jFB = false;
                b.this.fv(false);
                ab.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
                b.this.aVv();
                if (b.this.jFz != null) {
                    b.this.jFz.aVx();
                }
                AppMethodBeat.o(18363);
            }
        };
        this.mHandler = new ak(alVar.oAl.getLooper());
        AppMethodBeat.o(18371);
    }

    /* Access modifiers changed, original: final */
    public final void aVv() {
        AppMethodBeat.i(18372);
        ab.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.jFE.isEmpty()) {
            Iterator it = this.jFE.iterator();
            while (it.hasNext()) {
                ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                if (this.jFz != null) {
                    this.jFz.l(r0.longValue(), false);
                }
            }
            this.jFE.clear();
        }
        AppMethodBeat.o(18372);
    }

    private void stopScan() {
        AppMethodBeat.i(18374);
        if (this.jFB) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.jFB = false;
            fv(false);
            aVv();
            if (this.jFz != null) {
                this.jFz.aVx();
            }
            AppMethodBeat.o(18374);
            return;
        }
        AppMethodBeat.o(18374);
    }

    public final boolean a(boolean z, int... iArr) {
        String str;
        AppMethodBeat.i(18375);
        String str2 = "MicroMsg.exdevice.BluetoothLEManager";
        StringBuilder stringBuilder = new StringBuilder("------scanLEDevice------");
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        ab.i(str2, stringBuilder.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!aVw()) {
            ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            AppMethodBeat.o(18375);
            return false;
        } else if (!z) {
            stopScan();
            AppMethodBeat.o(18375);
            return true;
        } else if (this.jFB) {
            AppMethodBeat.o(18375);
            return true;
        } else if (fv(z)) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
            } else {
                this.mHandler.removeCallbacks(this.mRunnable);
            }
            this.jFB = true;
            AppMethodBeat.o(18375);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.jFE.isEmpty()) {
                Iterator it = this.jFE.iterator();
                while (it.hasNext()) {
                    ab.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", (Long) it.next());
                    if (this.jFz != null) {
                        this.jFz.l(r0.longValue(), false);
                    }
                }
                this.jFE.clear();
            }
            AppMethodBeat.o(18375);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean fv(boolean z) {
        AppMethodBeat.i(18376);
        boolean z2 = false;
        if (d.iW(21) && this.jFD != null) {
            z2 = this.jFD.a(z, this.jFG);
        } else if (this.jFC != null) {
            z2 = this.jFC.a(z, this.jFF);
        } else {
            ab.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        }
        AppMethodBeat.o(18376);
        return z2;
    }

    public final boolean connect(long j) {
        AppMethodBeat.i(18377);
        ab.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", Long.valueOf(j));
        Assert.assertTrue(this.mIsInit);
        if (aVw()) {
            boolean connect;
            d dVar = (d) this.jFA.get(String.valueOf(j));
            Assert.assertTrue(dVar != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.Gn.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                ab.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        ab.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", address.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.KK(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName());
                        if (j == com.tencent.mm.plugin.exdevice.j.b.KK(((BluetoothDevice) r3.next()).getAddress())) {
                            ab.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            connect = dVar.connect();
                            AppMethodBeat.o(18377);
                            return connect;
                        }
                    }
                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", VERSION.RELEASE);
                    if (!d.iW(23) || ((LocationManager) this.Gn.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps") || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                        if (bondedDevices == null) {
                            ab.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                        } else {
                            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                                ab.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.KK(bluetoothDevice.getAddress())), bluetoothDevice.getName());
                                if (j == com.tencent.mm.plugin.exdevice.j.b.KK(bluetoothDevice.getAddress())) {
                                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                    InputManager inputManager = (InputManager) this.Gn.getSystemService("input");
                                    int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                    if (inputDeviceIds == null) {
                                        ab.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                        break;
                                    }
                                    for (int inputDevice : inputDeviceIds) {
                                        InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                        if (inputDevice2 != null) {
                                            String name = inputDevice2.getName();
                                            ab.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", name);
                                            if (name != null && name.equals(bluetoothDevice.getName())) {
                                                ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                                connect = dVar.connect();
                                                AppMethodBeat.o(18377);
                                                return connect;
                                            }
                                        }
                                    }
                                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                                }
                            }
                        }
                    } else {
                        connect = dVar.connect();
                        AppMethodBeat.o(18377);
                        return connect;
                    }
                }
            }
            this.jFE.add(Long.valueOf(j));
            connect = a(true, new int[0]);
            AppMethodBeat.o(18377);
            return connect;
        }
        ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        AppMethodBeat.o(18377);
        return false;
    }

    @TargetApi(18)
    public final boolean aVw() {
        AppMethodBeat.i(18373);
        Assert.assertTrue(this.mIsInit);
        boolean hasSystemFeature = this.Gn.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.o(18373);
        return hasSystemFeature;
    }

    static /* synthetic */ void a(b bVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        AppMethodBeat.i(18378);
        ab.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!bVar.jFE.isEmpty()) {
            long KK = com.tencent.mm.plugin.exdevice.j.b.KK(bluetoothDevice.getAddress());
            if (bVar.jFE.contains(Long.valueOf(KK))) {
                ab.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", Long.valueOf(KK));
                d dVar = (d) bVar.jFA.get(String.valueOf(KK));
                if (dVar == null) {
                    ab.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (bVar.jFz != null) {
                        bVar.jFz.l(KK, false);
                    }
                } else if (!dVar.connect()) {
                    ab.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (bVar.jFz != null) {
                        bVar.jFz.l(KK, false);
                    }
                }
                bVar.jFE.remove(Long.valueOf(KK));
                if (bVar.jFE.isEmpty()) {
                    ab.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (bVar.jFz != null) {
            bVar.jFz.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
        AppMethodBeat.o(18378);
    }
}
