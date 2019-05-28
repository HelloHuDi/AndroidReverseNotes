package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

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
import android.support.v4.f.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public final class b {
    static final e hFm;

    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    static class c implements e {
        static final m<e, d> hFn = new m();

        c() {
        }

        static {
            AppMethodBeat.i(94299);
            AppMethodBeat.o(94299);
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
            List arrayList;
            AppMethodBeat.i(94297);
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
                AppMethodBeat.o(94297);
                throw illegalStateException;
            }
            ScanSettings build = new ScanSettings.Builder().setReportDelay(scanSettingsCompat.hGg).setScanMode(scanSettingsCompat.hGe).build();
            if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                ab.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.o(94297);
                return false;
            }
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            ScanCallback scanCallback = (d) hFn.get(eVar);
            if (scanCallback == null) {
                scanCallback = new d(eVar);
                hFn.put(eVar, scanCallback);
            }
            bluetoothLeScanner.startScan(arrayList, build, scanCallback);
            AppMethodBeat.o(94297);
            return true;
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
            AppMethodBeat.i(94298);
            d dVar = (d) hFn.remove(eVar);
            if (dVar == null) {
                AppMethodBeat.o(94298);
                return false;
            } else if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                ab.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.o(94298);
                return false;
            } else {
                bluetoothAdapter.getBluetoothLeScanner().stopScan(dVar);
                AppMethodBeat.o(94298);
                return true;
            }
        }
    }

    @TargetApi(21)
    static class d extends ScanCallback {
        private final WeakReference<e> hFo;

        d(e eVar) {
            AppMethodBeat.i(94300);
            this.hFo = new WeakReference(eVar);
            AppMethodBeat.o(94300);
        }

        public final void onScanResult(int i, ScanResult scanResult) {
            AppMethodBeat.i(94301);
            e eVar = (e) this.hFo.get();
            if (eVar != null) {
                eVar.a(i, new ScanResultCompat(scanResult));
            }
            AppMethodBeat.o(94301);
        }

        public final void onBatchScanResults(List<ScanResult> list) {
            AppMethodBeat.i(94302);
            if (((e) this.hFo.get()) == null) {
                AppMethodBeat.o(94302);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ScanResult scanResultCompat : list) {
                arrayList.add(new ScanResultCompat(scanResultCompat));
            }
            AppMethodBeat.o(94302);
        }

        public final void onScanFailed(int i) {
            AppMethodBeat.i(94303);
            e eVar = (e) this.hFo.get();
            if (eVar != null) {
                eVar.onScanFailed(i);
            }
            AppMethodBeat.o(94303);
        }
    }

    static class b implements LeScanCallback {
        private final List<ScanFilterCompat> filters;
        private final WeakReference<e> hFo;

        b(List<ScanFilterCompat> list, e eVar) {
            AppMethodBeat.i(94295);
            this.filters = list;
            this.hFo = new WeakReference(eVar);
            AppMethodBeat.o(94295);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            AppMethodBeat.i(94296);
            e eVar = (e) this.hFo.get();
            if (eVar == null) {
                AppMethodBeat.o(94296);
                return;
            }
            ScanResultCompat scanResultCompat = new ScanResultCompat(bluetoothDevice, f.aj(bArr), i, System.currentTimeMillis());
            if (this.filters == null) {
                eVar.a(1, scanResultCompat);
                AppMethodBeat.o(94296);
                return;
            }
            for (ScanFilterCompat scanFilterCompat : this.filters) {
                Object obj;
                BluetoothDevice device = scanResultCompat.getDevice();
                if (scanFilterCompat.hFK == null || (device != null && scanFilterCompat.hFK.equals(device.getAddress()))) {
                    f fVar = scanResultCompat.hGb;
                    if (fVar == null && (scanFilterCompat.mDeviceName != null || scanFilterCompat.hFL != null || scanFilterCompat.hFR != null || scanFilterCompat.hFO != null || scanFilterCompat.hFN != null || scanFilterCompat.hFQ >= 0)) {
                        obj = null;
                        continue;
                    } else if (scanFilterCompat.mDeviceName == null || scanFilterCompat.mDeviceName.equals(fVar.mDeviceName)) {
                        ParcelUuid parcelUuid;
                        if (scanFilterCompat.hFL != null) {
                            ParcelUuid parcelUuid2 = scanFilterCompat.hFL;
                            ParcelUuid parcelUuid3 = scanFilterCompat.hFM;
                            List<ParcelUuid> list = fVar.hFW;
                            if (parcelUuid2 == null) {
                                obj = 1;
                            } else {
                                if (list != null) {
                                    for (ParcelUuid parcelUuid4 : list) {
                                        if (ScanFilterCompat.a(parcelUuid2.getUuid(), parcelUuid3 == null ? null : parcelUuid3.getUuid(), parcelUuid4.getUuid())) {
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
                                bArr2 = (byte[]) fVar.hFY.get(parcelUuid4);
                            }
                            if (!ScanFilterCompat.a(bArr3, bArr4, bArr2)) {
                                obj = null;
                                continue;
                            }
                        }
                        if (scanFilterCompat.hFQ >= 0 && fVar != null) {
                            if (!ScanFilterCompat.a(scanFilterCompat.hFR, scanFilterCompat.hFS, (byte[]) fVar.hFX.get(scanFilterCompat.hFQ))) {
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
                    eVar.a(1, scanResultCompat);
                    AppMethodBeat.o(94296);
                    return;
                }
            }
            AppMethodBeat.o(94296);
        }
    }

    interface e {
        boolean a(BluetoothAdapter bluetoothAdapter, e eVar);

        boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar);
    }

    @TargetApi(18)
    static class a implements e {
        static final m<e, b> hFn = new m();

        a() {
        }

        static {
            AppMethodBeat.i(94294);
            AppMethodBeat.o(94294);
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
            AppMethodBeat.i(94293);
            b bVar = (b) hFn.remove(eVar);
            if (bVar == null) {
                AppMethodBeat.o(94293);
                return false;
            }
            bluetoothAdapter.stopLeScan(bVar);
            AppMethodBeat.o(94293);
            return true;
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
            AppMethodBeat.i(94292);
            LeScanCallback leScanCallback = (b) hFn.get(eVar);
            if (leScanCallback == null) {
                leScanCallback = new b(list, eVar);
                hFn.put(eVar, leScanCallback);
            }
            boolean startLeScan = bluetoothAdapter.startLeScan(leScanCallback);
            AppMethodBeat.o(94292);
            return startLeScan;
        }
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
        AppMethodBeat.i(94304);
        boolean a = hFm.a(bluetoothAdapter, list, scanSettingsCompat, eVar);
        AppMethodBeat.o(94304);
        return a;
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
        AppMethodBeat.i(94305);
        boolean a = hFm.a(bluetoothAdapter, eVar);
        AppMethodBeat.o(94305);
        return a;
    }

    static {
        AppMethodBeat.i(94306);
        int i = VERSION.SDK_INT;
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.hDX) {
            ab.i("MicroMsg.ble.BleScannerCompat", "use 18");
            hFm = new a();
            AppMethodBeat.o(94306);
        } else if (i >= 21) {
            ab.i("MicroMsg.ble.BleScannerCompat", "use 21");
            hFm = new c();
            AppMethodBeat.o(94306);
        } else {
            ab.i("MicroMsg.ble.BleScannerCompat", "use 18");
            hFm = new a();
            AppMethodBeat.o(94306);
        }
    }
}
