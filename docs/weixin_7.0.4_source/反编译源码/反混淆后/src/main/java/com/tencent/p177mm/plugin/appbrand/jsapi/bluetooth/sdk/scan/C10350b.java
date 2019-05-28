package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.support.p057v4.p065f.C0417m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C38281a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b */
public final class C10350b {
    static final C10352e hFm;

    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$c */
    static class C2239c implements C10352e {
        static final C0417m<C42487e, C2240d> hFn = new C0417m();

        C2239c() {
        }

        static {
            AppMethodBeat.m2504i(94299);
            AppMethodBeat.m2505o(94299);
        }

        /* renamed from: a */
        public final boolean mo6102a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, C42487e c42487e) {
            List arrayList;
            AppMethodBeat.m2504i(94297);
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (ScanFilterCompat scanFilterCompat : list) {
                    Builder builder = new Builder();
                    if (scanFilterCompat.mDeviceName != null) {
                        builder.setDeviceName(scanFilterCompat.mDeviceName);
                    }
                    if (scanFilterCompat.hFL != null) {
                        builder.setServiceUuid(scanFilterCompat.hFL, scanFilterCompat.hFM);
                    }
                    if (scanFilterCompat.hFK != null) {
                        builder.setDeviceAddress(scanFilterCompat.hFK);
                    }
                    if (scanFilterCompat.hFN != null) {
                        builder.setServiceData(scanFilterCompat.hFN, scanFilterCompat.hFO, scanFilterCompat.hFP);
                    }
                    if (scanFilterCompat.hFQ < 0) {
                        builder.setManufacturerData(scanFilterCompat.hFQ, scanFilterCompat.hFR, scanFilterCompat.hFS);
                    }
                    arrayList.add(builder.build());
                }
            } else {
                arrayList = null;
            }
            if (scanSettingsCompat == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Scan settings are null");
                AppMethodBeat.m2505o(94297);
                throw illegalStateException;
            }
            ScanSettings build = new ScanSettings.Builder().setReportDelay(scanSettingsCompat.hGg).setScanMode(scanSettingsCompat.hGe).build();
            if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                C4990ab.m7412e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.m2505o(94297);
                return false;
            }
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            ScanCallback scanCallback = (C2240d) hFn.get(c42487e);
            if (scanCallback == null) {
                scanCallback = new C2240d(c42487e);
                hFn.put(c42487e, scanCallback);
            }
            bluetoothLeScanner.startScan(arrayList, build, scanCallback);
            AppMethodBeat.m2505o(94297);
            return true;
        }

        /* renamed from: a */
        public final boolean mo6101a(BluetoothAdapter bluetoothAdapter, C42487e c42487e) {
            AppMethodBeat.m2504i(94298);
            C2240d c2240d = (C2240d) hFn.remove(c42487e);
            if (c2240d == null) {
                AppMethodBeat.m2505o(94298);
                return false;
            } else if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                C4990ab.m7412e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.m2505o(94298);
                return false;
            } else {
                bluetoothAdapter.getBluetoothLeScanner().stopScan(c2240d);
                AppMethodBeat.m2505o(94298);
                return true;
            }
        }
    }

    @TargetApi(21)
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$d */
    static class C2240d extends ScanCallback {
        private final WeakReference<C42487e> hFo;

        C2240d(C42487e c42487e) {
            AppMethodBeat.m2504i(94300);
            this.hFo = new WeakReference(c42487e);
            AppMethodBeat.m2505o(94300);
        }

        public final void onScanResult(int i, ScanResult scanResult) {
            AppMethodBeat.m2504i(94301);
            C42487e c42487e = (C42487e) this.hFo.get();
            if (c42487e != null) {
                c42487e.mo21822a(i, new ScanResultCompat(scanResult));
            }
            AppMethodBeat.m2505o(94301);
        }

        public final void onBatchScanResults(List<ScanResult> list) {
            AppMethodBeat.m2504i(94302);
            if (((C42487e) this.hFo.get()) == null) {
                AppMethodBeat.m2505o(94302);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ScanResult scanResultCompat : list) {
                arrayList.add(new ScanResultCompat(scanResultCompat));
            }
            AppMethodBeat.m2505o(94302);
        }

        public final void onScanFailed(int i) {
            AppMethodBeat.m2504i(94303);
            C42487e c42487e = (C42487e) this.hFo.get();
            if (c42487e != null) {
                c42487e.onScanFailed(i);
            }
            AppMethodBeat.m2505o(94303);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$b */
    static class C10351b implements LeScanCallback {
        private final List<ScanFilterCompat> filters;
        private final WeakReference<C42487e> hFo;

        C10351b(List<ScanFilterCompat> list, C42487e c42487e) {
            AppMethodBeat.m2504i(94295);
            this.filters = list;
            this.hFo = new WeakReference(c42487e);
            AppMethodBeat.m2505o(94295);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            AppMethodBeat.m2504i(94296);
            C42487e c42487e = (C42487e) this.hFo.get();
            if (c42487e == null) {
                AppMethodBeat.m2505o(94296);
                return;
            }
            ScanResultCompat scanResultCompat = new ScanResultCompat(bluetoothDevice, C42488f.m75261aj(bArr), i, System.currentTimeMillis());
            if (this.filters == null) {
                c42487e.mo21822a(1, scanResultCompat);
                AppMethodBeat.m2505o(94296);
                return;
            }
            for (ScanFilterCompat scanFilterCompat : this.filters) {
                Object obj;
                BluetoothDevice device = scanResultCompat.getDevice();
                if (scanFilterCompat.hFK == null || (device != null && scanFilterCompat.hFK.equals(device.getAddress()))) {
                    C42488f c42488f = scanResultCompat.hGb;
                    if (c42488f == null && (scanFilterCompat.mDeviceName != null || scanFilterCompat.hFL != null || scanFilterCompat.hFR != null || scanFilterCompat.hFO != null || scanFilterCompat.hFN != null || scanFilterCompat.hFQ >= 0)) {
                        obj = null;
                        continue;
                    } else if (scanFilterCompat.mDeviceName == null || scanFilterCompat.mDeviceName.equals(c42488f.mDeviceName)) {
                        ParcelUuid parcelUuid;
                        if (scanFilterCompat.hFL != null) {
                            ParcelUuid parcelUuid2 = scanFilterCompat.hFL;
                            ParcelUuid parcelUuid3 = scanFilterCompat.hFM;
                            List<ParcelUuid> list = c42488f.hFW;
                            if (parcelUuid2 == null) {
                                obj = 1;
                            } else {
                                if (list != null) {
                                    for (ParcelUuid parcelUuid4 : list) {
                                        if (ScanFilterCompat.m75257a(parcelUuid2.getUuid(), parcelUuid3 == null ? null : parcelUuid3.getUuid(), parcelUuid4.getUuid())) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                }
                                obj = null;
                            }
                            if (obj == null) {
                                obj = null;
                                continue;
                            }
                        }
                        if (scanFilterCompat.hFN != null) {
                            byte[] bArr2;
                            byte[] bArr3 = scanFilterCompat.hFO;
                            byte[] bArr4 = scanFilterCompat.hFP;
                            parcelUuid4 = scanFilterCompat.hFN;
                            if (parcelUuid4 == null) {
                                bArr2 = null;
                            } else {
                                bArr2 = (byte[]) c42488f.hFY.get(parcelUuid4);
                            }
                            if (!ScanFilterCompat.m75258a(bArr3, bArr4, bArr2)) {
                                obj = null;
                                continue;
                            }
                        }
                        if (scanFilterCompat.hFQ >= 0 && c42488f != null) {
                            if (!ScanFilterCompat.m75258a(scanFilterCompat.hFR, scanFilterCompat.hFS, (byte[]) c42488f.hFX.get(scanFilterCompat.hFQ))) {
                                obj = null;
                                continue;
                            }
                        }
                        obj = 1;
                        continue;
                    } else {
                        obj = null;
                        continue;
                    }
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    c42487e.mo21822a(1, scanResultCompat);
                    AppMethodBeat.m2505o(94296);
                    return;
                }
            }
            AppMethodBeat.m2505o(94296);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$e */
    interface C10352e {
        /* renamed from: a */
        boolean mo6101a(BluetoothAdapter bluetoothAdapter, C42487e c42487e);

        /* renamed from: a */
        boolean mo6102a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, C42487e c42487e);
    }

    @TargetApi(18)
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$a */
    static class C10353a implements C10352e {
        static final C0417m<C42487e, C10351b> hFn = new C0417m();

        C10353a() {
        }

        static {
            AppMethodBeat.m2504i(94294);
            AppMethodBeat.m2505o(94294);
        }

        /* renamed from: a */
        public final boolean mo6101a(BluetoothAdapter bluetoothAdapter, C42487e c42487e) {
            AppMethodBeat.m2504i(94293);
            C10351b c10351b = (C10351b) hFn.remove(c42487e);
            if (c10351b == null) {
                AppMethodBeat.m2505o(94293);
                return false;
            }
            bluetoothAdapter.stopLeScan(c10351b);
            AppMethodBeat.m2505o(94293);
            return true;
        }

        /* renamed from: a */
        public final boolean mo6102a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, C42487e c42487e) {
            AppMethodBeat.m2504i(94292);
            LeScanCallback leScanCallback = (C10351b) hFn.get(c42487e);
            if (leScanCallback == null) {
                leScanCallback = new C10351b(list, c42487e);
                hFn.put(c42487e, leScanCallback);
            }
            boolean startLeScan = bluetoothAdapter.startLeScan(leScanCallback);
            AppMethodBeat.m2505o(94292);
            return startLeScan;
        }
    }

    /* renamed from: a */
    public static boolean m18050a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, C42487e c42487e) {
        AppMethodBeat.m2504i(94304);
        boolean a = hFm.mo6102a(bluetoothAdapter, list, scanSettingsCompat, c42487e);
        AppMethodBeat.m2505o(94304);
        return a;
    }

    /* renamed from: a */
    public static boolean m18049a(BluetoothAdapter bluetoothAdapter, C42487e c42487e) {
        AppMethodBeat.m2504i(94305);
        boolean a = hFm.mo6101a(bluetoothAdapter, c42487e);
        AppMethodBeat.m2505o(94305);
        return a;
    }

    static {
        AppMethodBeat.m2504i(94306);
        int i = VERSION.SDK_INT;
        if (!C38281a.hDX) {
            C4990ab.m7416i("MicroMsg.ble.BleScannerCompat", "use 18");
            hFm = new C10353a();
            AppMethodBeat.m2505o(94306);
        } else if (i >= 21) {
            C4990ab.m7416i("MicroMsg.ble.BleScannerCompat", "use 21");
            hFm = new C2239c();
            AppMethodBeat.m2505o(94306);
        } else {
            C4990ab.m7416i("MicroMsg.ble.BleScannerCompat", "use 18");
            hFm = new C10353a();
            AppMethodBeat.m2505o(94306);
        }
    }
}
