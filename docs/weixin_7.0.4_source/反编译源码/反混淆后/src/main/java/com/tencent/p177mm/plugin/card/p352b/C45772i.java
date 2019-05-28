package com.tencent.p177mm.plugin.card.p352b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C20138ai;
import com.tencent.p177mm.protocal.protobuf.C40543lh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.card.b.i */
public final class C45772i implements C1202f {
    public volatile boolean bZi = false;
    public volatile float ecs = -85.0f;
    public volatile float ect = -1000.0f;
    String kaE;
    private C42837b kaS;
    public MMActivity kbc;
    private volatile boolean kbd = false;
    public Object kbe = new Object();
    private boolean kbf = false;
    boolean kbg = false;
    private boolean kbh = false;
    C40543lh kbi;
    private C45771b kbj;
    public C38730a kbk;
    private int kbl = 60;
    private long kbm = 0;
    private long kbn = 0;
    private long kbo = 10000;
    public C7564ap kbp = new C7564ap(new C201211(), false);

    /* renamed from: com.tencent.mm.plugin.card.b.i$3 */
    class C112723 implements OnClickListener {
        C112723() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C45772i.this.kbg = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.i$1 */
    class C201211 implements C5015a {
        C201211() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(87701);
            C45772i.this.mo73566IF();
            C45772i.this.baB();
            AppMethodBeat.m2505o(87701);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.i$2 */
    class C337552 implements OnClickListener {
        C337552() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(87702);
            C45772i.this.kbg = true;
            C45772i.m84613a(C45772i.this.kaE, new byte[0], -85.0f, -1000.0f, 0, false, true);
            AppMethodBeat.m2505o(87702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.i$a */
    public class C38730a {
        public BroadcastReceiver hDr;
        private BluetoothAdapter hJY;
        private volatile boolean kbr;
        boolean kbs;
        Map<String, C45771b> kbt;
        long kbu;
        Runnable kbv;
        private LeScanCallback kbw;

        /* renamed from: com.tencent.mm.plugin.card.b.i$a$1 */
        class C112731 implements Runnable {
            C112731() {
            }

            public final void run() {
                AppMethodBeat.m2504i(87703);
                C38730a.this.baI();
                C38730a.this.baH();
                AppMethodBeat.m2505o(87703);
            }
        }

        /* renamed from: com.tencent.mm.plugin.card.b.i$a$2 */
        class C112742 extends BroadcastReceiver {
            C112742() {
            }

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.m2504i(87704);
                if (intent == null) {
                    C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
                    AppMethodBeat.m2505o(87704);
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    int state = defaultAdapter.getState();
                    C4990ab.m7411d("MicroMsg.CardLbsOrBluetooth", "state:%d", Integer.valueOf(state));
                    if (state == 12) {
                        C38730a.this.kbs = true;
                        C5004al.m7442n(C38730a.this.kbv, C38730a.this.kbu);
                        AppMethodBeat.m2505o(87704);
                        return;
                    } else if (state == 10) {
                        C5004al.m7439af(C38730a.this.kbv);
                        C38730a.this.kbs = false;
                        C38730a.this.kbt.clear();
                    }
                }
                AppMethodBeat.m2505o(87704);
            }
        }

        /* renamed from: com.tencent.mm.plugin.card.b.i$a$3 */
        class C387313 implements LeScanCallback {
            C387313() {
            }

            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                AppMethodBeat.m2504i(87705);
                if (bluetoothDevice == null) {
                    C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
                    AppMethodBeat.m2505o(87705);
                } else if (C45772i.this.kbi == null || C5046bo.isNullOrNil(C45772i.this.kbi.name)) {
                    AppMethodBeat.m2505o(87705);
                } else {
                    String nullAsNil = C5046bo.nullAsNil(bluetoothDevice.getName());
                    String address = bluetoothDevice.getAddress();
                    if (nullAsNil.equals(C45772i.this.kbi.name)) {
                        C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i));
                        C38730a.this.kbt.put(address, new C45771b(address, i, nullAsNil, C38730a.m65695aw(bArr)));
                        AppMethodBeat.m2505o(87705);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i));
                    AppMethodBeat.m2505o(87705);
                }
            }
        }

        private C38730a() {
            AppMethodBeat.m2504i(87706);
            this.kbr = false;
            this.kbs = false;
            this.kbt = new ConcurrentHashMap();
            this.kbu = 3000;
            this.kbv = new C112731();
            this.kbw = new C387313();
            AppMethodBeat.m2505o(87706);
        }

        /* synthetic */ C38730a(C45772i c45772i, byte b) {
            this();
        }

        public final void reset() {
            AppMethodBeat.m2504i(87707);
            this.kbt.clear();
            AppMethodBeat.m2505o(87707);
        }

        public final C45771b baG() {
            AppMethodBeat.m2504i(87708);
            C45771b c45771b = new C45771b("", -100, "", null);
            if (this.kbt.size() <= 0) {
                AppMethodBeat.m2505o(87708);
                return c45771b;
            }
            Iterator it = this.kbt.values().iterator();
            while (true) {
                C45771b c45771b2 = c45771b;
                if (it.hasNext()) {
                    c45771b = (C45771b) it.next();
                    if (c45771b2.cyC >= c45771b.cyC) {
                        c45771b = c45771b2;
                    }
                } else {
                    AppMethodBeat.m2505o(87708);
                    return c45771b2;
                }
            }
        }

        @TargetApi(18)
        public final void baH() {
            AppMethodBeat.m2504i(87709);
            if (VERSION.SDK_INT < 18) {
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.m2505o(87709);
            } else if (this.kbr) {
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "already start");
                AppMethodBeat.m2505o(87709);
            } else {
                this.kbt.clear();
                BluetoothManager bluetoothManager = (BluetoothManager) C4996ah.getContext().getSystemService("bluetooth");
                if (bluetoothManager == null) {
                    this.kbs = false;
                    C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
                    AppMethodBeat.m2505o(87709);
                    return;
                }
                this.kbs = true;
                this.hJY = bluetoothManager.getAdapter();
                if (this.hJY == null || !this.hJY.isEnabled()) {
                    this.kbs = false;
                    C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                    AppMethodBeat.m2505o(87709);
                    return;
                }
                boolean startLeScan = this.hJY.startLeScan(this.kbw);
                C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", Boolean.valueOf(startLeScan));
                this.kbr = true;
                AppMethodBeat.m2505o(87709);
            }
        }

        @TargetApi(18)
        public final void baI() {
            AppMethodBeat.m2504i(87710);
            if (VERSION.SDK_INT < 18) {
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.m2505o(87710);
            } else if (!this.kbr) {
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "not start");
                AppMethodBeat.m2505o(87710);
            } else if (this.hJY == null || !this.hJY.isEnabled()) {
                this.kbs = false;
                C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                AppMethodBeat.m2505o(87710);
            } else {
                this.kbs = true;
                this.hJY.stopLeScan(this.kbw);
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
                this.kbr = false;
                AppMethodBeat.m2505o(87710);
            }
        }

        /* renamed from: aw */
        public static byte[] m65695aw(byte[] bArr) {
            byte[] bArr2 = null;
            AppMethodBeat.m2504i(87711);
            if (bArr == null) {
                AppMethodBeat.m2505o(87711);
            } else {
                int i = 0;
                while (i < bArr.length) {
                    int i2 = i + 1;
                    i = bArr[i] & 255;
                    if (i != 0) {
                        i--;
                        int i3 = i2 + 1;
                        switch (bArr[i2] & 255) {
                            case 255:
                                bArr2 = new byte[i];
                                System.arraycopy(bArr, i3, bArr2, 0, i);
                                break;
                            default:
                                break;
                        }
                        i += i3;
                    } else {
                        AppMethodBeat.m2505o(87711);
                    }
                }
                AppMethodBeat.m2505o(87711);
            }
            return bArr2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.i$b */
    static class C45771b {
        String ceI;
        int cyC;
        byte[] kby;
        String name;

        public C45771b(String str, int i, String str2, byte[] bArr) {
            this.ceI = str;
            this.cyC = i;
            this.name = str2;
            this.kby = bArr;
        }

        public final String toString() {
            AppMethodBeat.m2504i(87712);
            String str = "DeviceInfo{deviceId='" + this.ceI + '\'' + ", rssi=" + this.cyC + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.kby) + '}';
            AppMethodBeat.m2505o(87712);
            return str;
        }
    }

    public C45772i() {
        AppMethodBeat.m2504i(87713);
        AppMethodBeat.m2505o(87713);
    }

    /* renamed from: a */
    public final void mo73567a(MMActivity mMActivity, String str, C42837b c42837b, float f, float f2) {
        int i;
        boolean z;
        AppMethodBeat.m2504i(87714);
        this.bZi = true;
        this.kbc = mMActivity;
        this.kaE = str;
        this.kaS = c42837b;
        this.ecs = f;
        this.ect = f2;
        this.kbf = c42837b.aZV().vUF;
        this.kbg = c42837b.aZW().vSr;
        this.kbi = c42837b.aZV().vUG;
        if (c42837b.aZV().vUG == null) {
            i = 60;
        } else {
            i = c42837b.aZV().vUG.vON;
        }
        this.kbl = i;
        if (c42837b.aZV().vUG == null || C5046bo.isNullOrNil(c42837b.aZV().vUG.name)) {
            z = false;
        } else {
            z = true;
        }
        this.kbh = z;
        C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", str, Boolean.valueOf(this.kbf), Boolean.valueOf(this.kbg), Boolean.valueOf(this.kbh), Integer.valueOf(this.kbl));
        if (this.kbf && !this.kbg) {
            String str2 = C5046bo.isNullOrNil(this.kaS.aZV().vUH) ? this.kaS.aZV().title : this.kaS.aZV().vUH;
            C30379h.m48440a(this.kbc, this.kbc.getString(C25738R.string.agk, new Object[]{str2}), this.kbc.getString(C25738R.string.f9238tz), new C337552(), new C112723());
        }
        if (this.kbh) {
            C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", this.kbi.name);
            this.kbk = new C38730a(this, (byte) 0);
            C38730a c38730a = this.kbk;
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
            c38730a.hDr = new C112742();
            C4996ah.getContext().registerReceiver(c38730a.hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        start();
        mo73566IF();
        AppMethodBeat.m2505o(87714);
    }

    public final void start() {
        AppMethodBeat.m2504i(87715);
        if (baF()) {
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "start");
            if (this.bZi) {
                if (this.kbf) {
                    C45772i.axU();
                }
                if (this.kbk != null && this.kbh) {
                    this.kbk.baH();
                }
                baB();
                C1720g.m3535RO().eJo.mo14539a(2574, (C1202f) this);
                AppMethodBeat.m2505o(87715);
                return;
            }
            C4990ab.m7413e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", Boolean.valueOf(this.bZi));
            AppMethodBeat.m2505o(87715);
            return;
        }
        AppMethodBeat.m2505o(87715);
    }

    public final void baB() {
        AppMethodBeat.m2504i(87716);
        baC();
        if (this.kbl > 0) {
            long j = (long) (this.kbl * 1000);
            this.kbp.mo16770ae(j, j);
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
            AppMethodBeat.m2505o(87716);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
        AppMethodBeat.m2505o(87716);
    }

    public final void baC() {
        AppMethodBeat.m2504i(87717);
        C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
        if (!this.kbp.doT()) {
            this.kbp.stopTimer();
        }
        AppMethodBeat.m2505o(87717);
    }

    /* renamed from: IF */
    public final void mo73566IF() {
        AppMethodBeat.m2504i(87718);
        if (!baF()) {
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
            AppMethodBeat.m2505o(87718);
        } else if (this.kbd) {
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
            AppMethodBeat.m2505o(87718);
        } else {
            boolean z;
            this.kbd = true;
            boolean baE = baE();
            boolean baD = baD();
            String str = "MicroMsg.CardLbsOrBluetooth";
            String str2 = "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(this.kbf);
            objArr[1] = Boolean.valueOf(this.kbg);
            if (this.kbk == null) {
                z = false;
            } else {
                z = this.kbk.kbs;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(baE);
            objArr[4] = Boolean.valueOf(baD);
            C4990ab.m7417i(str, str2, objArr);
            if (baE && baD) {
                C45771b baG = this.kbk.baG();
                C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", baG);
                C4990ab.m7411d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.ect), Float.valueOf(this.ecs));
                m84612a(this.kaE, baG.kby, this.ect, this.ecs, baG.cyC, this.kbk.kbs);
                this.kbn = System.currentTimeMillis();
                this.kbm = System.currentTimeMillis();
                this.kbk.reset();
                this.kbj = baG;
                AppMethodBeat.m2505o(87718);
            } else if (baE) {
                C45771b baG2 = this.kbk.baG();
                C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", baG2);
                m84614a(this.kaE, baG2.kby, baG2.cyC, this.kbk.kbs);
                this.kbm = System.currentTimeMillis();
                this.kbk.reset();
                this.kbj = baG2;
                AppMethodBeat.m2505o(87718);
            } else if (baD) {
                C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                C4990ab.m7411d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.ect), Float.valueOf(this.ecs));
                m84615b(this.kaE, this.ect, this.ecs);
                this.kbn = System.currentTimeMillis();
                AppMethodBeat.m2505o(87718);
            } else {
                C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "not report");
                this.kbd = false;
                AppMethodBeat.m2505o(87718);
            }
        }
    }

    private boolean baD() {
        boolean z = true;
        AppMethodBeat.m2504i(87719);
        synchronized (this.kbe) {
            try {
                boolean z2;
                if (System.currentTimeMillis() - this.kbn >= this.kbo) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z3;
                if (Float.compare(this.ecs, -85.0f) == 0 || Float.compare(this.ect, -1000.0f) == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!(this.kbg && this.kbf && z3 && z2)) {
                    z = false;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87719);
            }
        }
        return z;
    }

    private boolean baE() {
        AppMethodBeat.m2504i(87720);
        if (!this.kbh) {
            AppMethodBeat.m2505o(87720);
            return false;
        } else if (this.kbk == null) {
            C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
            AppMethodBeat.m2505o(87720);
            return false;
        } else if (this.kbk.baG().ceI.equals("")) {
            AppMethodBeat.m2505o(87720);
            return false;
        } else if (System.currentTimeMillis() - this.kbm >= this.kbo) {
            AppMethodBeat.m2505o(87720);
            return true;
        } else {
            AppMethodBeat.m2505o(87720);
            return false;
        }
    }

    /* renamed from: b */
    private void m84615b(String str, float f, float f2) {
        AppMethodBeat.m2504i(87721);
        C45772i.m84613a(str, new byte[0], f, f2, 0, false, this.kbg);
        AppMethodBeat.m2505o(87721);
    }

    /* renamed from: a */
    private void m84614a(String str, byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(87722);
        C45772i.m84613a(str, bArr, -1000.0f, -85.0f, i, z, this.kbg);
        AppMethodBeat.m2505o(87722);
    }

    /* renamed from: a */
    private void m84612a(String str, byte[] bArr, float f, float f2, int i, boolean z) {
        AppMethodBeat.m2504i(87723);
        C45772i.m84613a(str, bArr, f, f2, i, z, this.kbg);
        AppMethodBeat.m2505o(87723);
    }

    /* renamed from: a */
    static void m84613a(String str, byte[] bArr, float f, float f2, int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(87724);
        C1720g.m3535RO().eJo.mo14541a(new C20138ai(str, bArr, f, f2, (float) i, z, z2), 0);
        AppMethodBeat.m2505o(87724);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87725);
        C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kbd = false;
        AppMethodBeat.m2505o(87725);
    }

    private static void axU() {
        AppMethodBeat.m2504i(87726);
        LocationManager locationManager = (LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION);
        if (locationManager != null) {
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            C4990ab.m7417i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", Boolean.valueOf(isProviderEnabled), Boolean.valueOf(isProviderEnabled2));
        }
        AppMethodBeat.m2505o(87726);
    }

    public final boolean baF() {
        return this.kbf || this.kbh;
    }
}
