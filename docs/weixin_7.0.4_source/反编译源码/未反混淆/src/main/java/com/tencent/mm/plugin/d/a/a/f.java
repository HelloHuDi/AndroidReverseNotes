package com.tencent.mm.plugin.d.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, b, r {
    private static boolean jER = false;
    public static boolean jET = false;
    private final b jEM;
    private final d jEP = new d(this);
    private final HashSet<UUID> jEQ = new HashSet();
    private boolean jES = false;
    private BluetoothAdapter jEU;
    private boolean jEV = true;
    private int jEW = 0;
    private String jEX = "";
    private e jEY = null;
    private Map<String, Long> jEZ = new ConcurrentHashMap();
    private final ap jFa = new ap(v.bpz().fPG.oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(18334);
            f.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18333);
                    f.this.jEP.a(f.this.jEW, f.this.jEX, f.this.jEY);
                    AppMethodBeat.o(18333);
                }
            });
            AppMethodBeat.o(18334);
            return false;
        }
    }, true);
    private final ap jFb = new ap(v.bpz().fPG.oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(18335);
            if (f.this.jEQ.size() > 0) {
                ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                if (f.g(f.this).booleanValue()) {
                    ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                f.jET = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                if (!f.jET) {
                    if (!f.this.jFc.doT()) {
                        f.this.jFc.stopTimer();
                    }
                    if (!f.this.jFb.doT()) {
                        f.this.jFb.stopTimer();
                    }
                }
            }
            AppMethodBeat.o(18335);
            return false;
        }
    }, true);
    private final ap jFc = new ap(v.bpz().fPG.oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(18336);
            if (f.this.jEQ.size() > 0) {
                ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
                f.j(f.this);
                if (f.this.jFb.doT()) {
                    f.this.jFb.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
                AppMethodBeat.o(18336);
                return true;
            }
            AppMethodBeat.o(18336);
            return false;
        }
    }, true);
    private final ap jFd = new ap(v.bpz().fPG.oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(18337);
            ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            f.jER = false;
            AppMethodBeat.o(18337);
            return false;
        }
    }, true);
    private final ap jFe = new ap(v.bpz().fPG.oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(18338);
            ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            f.k(f.this);
            AppMethodBeat.o(18338);
            return false;
        }
    }, true);
    public final ak mHandler;

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ UUID jFh;

        public AnonymousClass7(UUID uuid) {
            this.jFh = uuid;
        }

        public final void run() {
            AppMethodBeat.i(18340);
            if (!f.b(f.this, this.jFh)) {
                ab.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
            AppMethodBeat.o(18340);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ UUID jFh;

        public AnonymousClass6(UUID uuid) {
            this.jFh = uuid;
        }

        public final void run() {
            AppMethodBeat.i(18339);
            if (!f.a(f.this, this.jFh)) {
                ab.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
            }
            AppMethodBeat.o(18339);
        }
    }

    static /* synthetic */ void k(f fVar) {
        AppMethodBeat.i(18353);
        fVar.stopScan();
        AppMethodBeat.o(18353);
    }

    public f(b bVar) {
        AppMethodBeat.i(18343);
        this.jEM = bVar;
        this.mHandler = new ak(v.bpz().fPG.oAl.getLooper());
        this.jEU = ((BluetoothManager) ah.getContext().getSystemService("bluetooth")).getAdapter();
        AppMethodBeat.o(18343);
    }

    private void stopScan() {
        AppMethodBeat.i(18344);
        this.jEZ.clear();
        jER = false;
        if (!this.jFd.doT()) {
            this.jFd.stopTimer();
        }
        if (!this.jFc.doT()) {
            this.jFc.stopTimer();
        }
        if (!this.jFb.doT()) {
            this.jFb.stopTimer();
        }
        if (!this.jFa.doT()) {
            this.jFa.stopTimer();
        }
        if (!this.jFe.doT()) {
            this.jFe.stopTimer();
        }
        if (this.jES && this.jEU != null) {
            if (this.jEU != null) {
                this.jEU.stopLeScan(this);
            }
            this.jES = false;
        }
        AppMethodBeat.o(18344);
    }

    private synchronized void aVs() {
        AppMethodBeat.i(18345);
        if (this.jFd.doT()) {
            this.jFd.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        if (jET && this.jFc.doT()) {
            this.jFc.ae(10000, 10000);
        }
        if (this.jFe.doT()) {
            if (jET) {
                this.jFe.ae(1800000, 1800000);
            } else {
                this.jFe.ae(120000, 120000);
            }
        }
        if (!jER) {
            this.jEV = true;
            Boolean valueOf = Boolean.valueOf(this.jEU.startLeScan(this));
            if (valueOf.booleanValue() || jER) {
                this.jES = true;
                jER = true;
                ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !jER) {
                    i++;
                    this.jEU.stopLeScan(this);
                    ab.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.jEU.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        jER = true;
                        this.jES = true;
                        ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
                AppMethodBeat.o(18345);
            }
        }
        AppMethodBeat.o(18345);
    }

    public final void a(double d, c cVar) {
        AppMethodBeat.i(18346);
        ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", Double.valueOf(d));
        String aN = b.aN(cVar.jEK.jEO.jFp);
        if (aN.length() >= 32) {
            aN = aN.substring(0, 8) + "-" + aN.substring(8, 12) + "-" + aN.substring(12, 16) + "-" + aN.substring(16, 20) + "-" + aN.substring(20);
        }
        String str = aN + cVar.jEK.jEO.jFq + cVar.jEK.jEO.jFr;
        if (this.jEZ.containsKey(str)) {
            long longValue = ((Long) this.jEZ.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.jEZ.put(str, Long.valueOf(currentTimeMillis));
                this.jEM.a(d, cVar);
            }
            AppMethodBeat.o(18346);
            return;
        }
        this.jEZ.put(str, Long.valueOf(System.currentTimeMillis()));
        this.jEM.a(d, cVar);
        ab.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + aN + ",major = " + cVar.jEK.jEO.jFq + ",minor = " + (cVar.jEK.jEO.jFr & CdnLogic.kBizGeneric));
        AppMethodBeat.o(18346);
    }

    public final void rQ(int i) {
        AppMethodBeat.i(18347);
        if (i != 0) {
            AppMethodBeat.o(18347);
            return;
        }
        stopScan();
        AppMethodBeat.o(18347);
    }

    public final void a(final String str, String str2, int i, final int i2, byte[] bArr) {
        AppMethodBeat.i(18348);
        ab.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.aN(bArr));
        if (i != 0) {
            AppMethodBeat.o(18348);
            return;
        }
        final e eVar = new e();
        if (eVar.ar(bArr)) {
            UUID aP = b.aP(eVar.jEO.jFp);
            if (aP == null) {
                ab.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                AppMethodBeat.o(18348);
                return;
            } else if (this.jEQ.contains(aP)) {
                if (this.jEV) {
                    this.jEX = str;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18341);
                        f.this.jEP.a(i2, str, eVar);
                        AppMethodBeat.o(18341);
                    }
                });
                AppMethodBeat.o(18348);
                return;
            } else {
                ab.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                AppMethodBeat.o(18348);
                return;
            }
        }
        ab.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        AppMethodBeat.o(18348);
    }

    public final void Fy(String str) {
        AppMethodBeat.i(18349);
        ab.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", Integer.valueOf(-1), str);
        AppMethodBeat.o(18349);
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
        AppMethodBeat.i(18350);
        final e eVar = new e();
        if (eVar.ar(bArr)) {
            UUID aP = b.aP(eVar.jEO.jFp);
            if (aP == null) {
                ab.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                AppMethodBeat.o(18350);
                return;
            } else if (this.jEQ.contains(aP)) {
                if (this.jEV) {
                    this.jEW = i;
                    this.jEY = eVar;
                    if (this.jFa.doT()) {
                        this.jFa.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    this.jEV = false;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18342);
                        f.this.jEP.a(i, bluetoothDevice.getAddress(), eVar);
                        AppMethodBeat.o(18342);
                    }
                });
                AppMethodBeat.o(18350);
                return;
            } else {
                ab.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                AppMethodBeat.o(18350);
                return;
            }
        }
        ab.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        AppMethodBeat.o(18350);
    }

    static /* synthetic */ Boolean g(f fVar) {
        AppMethodBeat.i(18351);
        Boolean valueOf;
        if (fVar.jEU != null) {
            valueOf = Boolean.valueOf(fVar.jEU.startLeScan(fVar));
            AppMethodBeat.o(18351);
            return valueOf;
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.o(18351);
        return valueOf;
    }

    static /* synthetic */ void j(f fVar) {
        AppMethodBeat.i(18352);
        if (fVar.jEU != null) {
            fVar.jEU.stopLeScan(fVar);
        }
        AppMethodBeat.o(18352);
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        AppMethodBeat.i(18355);
        ab.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            ab.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            AppMethodBeat.o(18355);
            return false;
        }
        fVar.jEQ.remove(uuid);
        fVar.stopScan();
        AppMethodBeat.o(18355);
        return true;
    }
}
