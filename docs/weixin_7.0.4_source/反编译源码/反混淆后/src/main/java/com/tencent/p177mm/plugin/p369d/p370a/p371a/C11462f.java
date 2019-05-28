package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C20549v;
import com.tencent.p177mm.plugin.exdevice.service.C43002r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.a.f */
public final class C11462f implements LeScanCallback, C27698b, C43002r {
    private static boolean jER = false;
    public static boolean jET = false;
    private final C27698b jEM;
    private final C11458d jEP = new C11458d(this);
    private final HashSet<UUID> jEQ = new HashSet();
    private boolean jES = false;
    private BluetoothAdapter jEU;
    private boolean jEV = true;
    private int jEW = 0;
    private String jEX = "";
    private C11459e jEY = null;
    private Map<String, Long> jEZ = new ConcurrentHashMap();
    private final C7564ap jFa = new C7564ap(C20549v.bpz().fPG.oAl.getLooper(), new C114631(), true);
    private final C7564ap jFb = new C7564ap(C20549v.bpz().fPG.oAl.getLooper(), new C114602(), true);
    private final C7564ap jFc = new C7564ap(C20549v.bpz().fPG.oAl.getLooper(), new C114613(), true);
    private final C7564ap jFd = new C7564ap(C20549v.bpz().fPG.oAl.getLooper(), new C114644(), true);
    private final C7564ap jFe = new C7564ap(C20549v.bpz().fPG.oAl.getLooper(), new C114655(), true);
    public final C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$2 */
    class C114602 implements C5015a {
        C114602() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18335);
            if (C11462f.this.jEQ.size() > 0) {
                C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                if (C11462f.m19226g(C11462f.this).booleanValue()) {
                    C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                C11462f.jET = C4996ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                if (!C11462f.jET) {
                    if (!C11462f.this.jFc.doT()) {
                        C11462f.this.jFc.stopTimer();
                    }
                    if (!C11462f.this.jFb.doT()) {
                        C11462f.this.jFb.stopTimer();
                    }
                }
            }
            AppMethodBeat.m2505o(18335);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$3 */
    class C114613 implements C5015a {
        C114613() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18336);
            if (C11462f.this.jEQ.size() > 0) {
                C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
                C11462f.m19229j(C11462f.this);
                if (C11462f.this.jFb.doT()) {
                    C11462f.this.jFb.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
                AppMethodBeat.m2505o(18336);
                return true;
            }
            AppMethodBeat.m2505o(18336);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$1 */
    class C114631 implements C5015a {

        /* renamed from: com.tencent.mm.plugin.d.a.a.f$1$1 */
        class C28491 implements Runnable {
            C28491() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18333);
                C11462f.this.jEP.mo23189a(C11462f.this.jEW, C11462f.this.jEX, C11462f.this.jEY);
                AppMethodBeat.m2505o(18333);
            }
        }

        C114631() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18334);
            C11462f.this.mHandler.post(new C28491());
            AppMethodBeat.m2505o(18334);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$4 */
    class C114644 implements C5015a {
        C114644() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18337);
            C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            C11462f.jER = false;
            AppMethodBeat.m2505o(18337);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$5 */
    class C114655 implements C5015a {
        C114655() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18338);
            C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            C11462f.m19230k(C11462f.this);
            AppMethodBeat.m2505o(18338);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$7 */
    public class C114677 implements Runnable {
        final /* synthetic */ UUID jFh;

        public C114677(UUID uuid) {
            this.jFh = uuid;
        }

        public final void run() {
            AppMethodBeat.m2504i(18340);
            if (!C11462f.m19220b(C11462f.this, this.jFh)) {
                C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
            AppMethodBeat.m2505o(18340);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.a.f$6 */
    public class C114686 implements Runnable {
        final /* synthetic */ UUID jFh;

        public C114686(UUID uuid) {
            this.jFh = uuid;
        }

        public final void run() {
            AppMethodBeat.m2504i(18339);
            if (!C11462f.m19218a(C11462f.this, this.jFh)) {
                C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
            }
            AppMethodBeat.m2505o(18339);
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m19230k(C11462f c11462f) {
        AppMethodBeat.m2504i(18353);
        c11462f.stopScan();
        AppMethodBeat.m2505o(18353);
    }

    public C11462f(C27698b c27698b) {
        AppMethodBeat.m2504i(18343);
        this.jEM = c27698b;
        this.mHandler = new C7306ak(C20549v.bpz().fPG.oAl.getLooper());
        this.jEU = ((BluetoothManager) C4996ah.getContext().getSystemService("bluetooth")).getAdapter();
        AppMethodBeat.m2505o(18343);
    }

    private void stopScan() {
        AppMethodBeat.m2504i(18344);
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
        AppMethodBeat.m2505o(18344);
    }

    private synchronized void aVs() {
        AppMethodBeat.m2504i(18345);
        if (this.jFd.doT()) {
            this.jFd.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        if (jET && this.jFc.doT()) {
            this.jFc.mo16770ae(10000, 10000);
        }
        if (this.jFe.doT()) {
            if (jET) {
                this.jFe.mo16770ae(1800000, 1800000);
            } else {
                this.jFe.mo16770ae(120000, 120000);
            }
        }
        if (!jER) {
            this.jEV = true;
            Boolean valueOf = Boolean.valueOf(this.jEU.startLeScan(this));
            if (valueOf.booleanValue() || jER) {
                this.jES = true;
                jER = true;
                C4990ab.m7416i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !jER) {
                    i++;
                    this.jEU.stopLeScan(this);
                    C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.jEU.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        jER = true;
                        this.jES = true;
                        C4990ab.m7416i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
                AppMethodBeat.m2505o(18345);
            }
        }
        AppMethodBeat.m2505o(18345);
    }

    /* renamed from: a */
    public final void mo23192a(double d, C11457c c11457c) {
        AppMethodBeat.m2504i(18346);
        C4990ab.m7411d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", Double.valueOf(d));
        String aN = C42992b.m76349aN(c11457c.jEK.jEO.jFp);
        if (aN.length() >= 32) {
            aN = aN.substring(0, 8) + "-" + aN.substring(8, 12) + "-" + aN.substring(12, 16) + "-" + aN.substring(16, 20) + "-" + aN.substring(20);
        }
        String str = aN + c11457c.jEK.jEO.jFq + c11457c.jEK.jEO.jFr;
        if (this.jEZ.containsKey(str)) {
            long longValue = ((Long) this.jEZ.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.jEZ.put(str, Long.valueOf(currentTimeMillis));
                this.jEM.mo23192a(d, c11457c);
            }
            AppMethodBeat.m2505o(18346);
            return;
        }
        this.jEZ.put(str, Long.valueOf(System.currentTimeMillis()));
        this.jEM.mo23192a(d, c11457c);
        C4990ab.m7416i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + aN + ",major = " + c11457c.jEK.jEO.jFq + ",minor = " + (c11457c.jEK.jEO.jFr & CdnLogic.kBizGeneric));
        AppMethodBeat.m2505o(18346);
    }

    /* renamed from: rQ */
    public final void mo23195rQ(int i) {
        AppMethodBeat.m2504i(18347);
        if (i != 0) {
            AppMethodBeat.m2505o(18347);
            return;
        }
        stopScan();
        AppMethodBeat.m2505o(18347);
    }

    /* renamed from: a */
    public final void mo23193a(final String str, String str2, int i, final int i2, byte[] bArr) {
        AppMethodBeat.m2504i(18348);
        C4990ab.m7411d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), C42992b.m76349aN(bArr));
        if (i != 0) {
            AppMethodBeat.m2505o(18348);
            return;
        }
        final C11459e c11459e = new C11459e();
        if (c11459e.mo23190ar(bArr)) {
            UUID aP = C42992b.m76351aP(c11459e.jEO.jFp);
            if (aP == null) {
                C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                AppMethodBeat.m2505o(18348);
                return;
            } else if (this.jEQ.contains(aP)) {
                if (this.jEV) {
                    this.jEX = str;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18341);
                        C11462f.this.jEP.mo23189a(i2, str, c11459e);
                        AppMethodBeat.m2505o(18341);
                    }
                });
                AppMethodBeat.m2505o(18348);
                return;
            } else {
                C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                AppMethodBeat.m2505o(18348);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        AppMethodBeat.m2505o(18348);
    }

    /* renamed from: Fy */
    public final void mo23191Fy(String str) {
        AppMethodBeat.m2504i(18349);
        C4990ab.m7413e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", Integer.valueOf(-1), str);
        AppMethodBeat.m2505o(18349);
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
        AppMethodBeat.m2504i(18350);
        final C11459e c11459e = new C11459e();
        if (c11459e.mo23190ar(bArr)) {
            UUID aP = C42992b.m76351aP(c11459e.jEO.jFp);
            if (aP == null) {
                C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                AppMethodBeat.m2505o(18350);
                return;
            } else if (this.jEQ.contains(aP)) {
                if (this.jEV) {
                    this.jEW = i;
                    this.jEY = c11459e;
                    if (this.jFa.doT()) {
                        this.jFa.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    this.jEV = false;
                }
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18342);
                        C11462f.this.jEP.mo23189a(i, bluetoothDevice.getAddress(), c11459e);
                        AppMethodBeat.m2505o(18342);
                    }
                });
                AppMethodBeat.m2505o(18350);
                return;
            } else {
                C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                AppMethodBeat.m2505o(18350);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        AppMethodBeat.m2505o(18350);
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m19226g(C11462f c11462f) {
        AppMethodBeat.m2504i(18351);
        Boolean valueOf;
        if (c11462f.jEU != null) {
            valueOf = Boolean.valueOf(c11462f.jEU.startLeScan(c11462f));
            AppMethodBeat.m2505o(18351);
            return valueOf;
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.m2505o(18351);
        return valueOf;
    }

    /* renamed from: j */
    static /* synthetic */ void m19229j(C11462f c11462f) {
        AppMethodBeat.m2504i(18352);
        if (c11462f.jEU != null) {
            c11462f.jEU.stopLeScan(c11462f);
        }
        AppMethodBeat.m2505o(18352);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m19220b(C11462f c11462f, UUID uuid) {
        AppMethodBeat.m2504i(18355);
        C4990ab.m7416i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            C4990ab.m7412e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            AppMethodBeat.m2505o(18355);
            return false;
        }
        c11462f.jEQ.remove(uuid);
        c11462f.stopScan();
        AppMethodBeat.m2505o(18355);
        return true;
    }
}
