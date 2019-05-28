package com.tencent.mm.plugin.card.b;

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
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i implements f {
    public volatile boolean bZi = false;
    public volatile float ecs = -85.0f;
    public volatile float ect = -1000.0f;
    String kaE;
    private com.tencent.mm.plugin.card.base.b kaS;
    public MMActivity kbc;
    private volatile boolean kbd = false;
    public Object kbe = new Object();
    private boolean kbf = false;
    boolean kbg = false;
    private boolean kbh = false;
    lh kbi;
    private b kbj;
    public a kbk;
    private int kbl = 60;
    private long kbm = 0;
    private long kbn = 0;
    private long kbo = 10000;
    public ap kbp = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(87701);
            i.this.IF();
            i.this.baB();
            AppMethodBeat.o(87701);
            return true;
        }
    }, false);

    public class a {
        public BroadcastReceiver hDr;
        private BluetoothAdapter hJY;
        private volatile boolean kbr;
        boolean kbs;
        Map<String, b> kbt;
        long kbu;
        Runnable kbv;
        private LeScanCallback kbw;

        private a() {
            AppMethodBeat.i(87706);
            this.kbr = false;
            this.kbs = false;
            this.kbt = new ConcurrentHashMap();
            this.kbu = 3000;
            this.kbv = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87703);
                    a.this.baI();
                    a.this.baH();
                    AppMethodBeat.o(87703);
                }
            };
            this.kbw = new LeScanCallback() {
                public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                    AppMethodBeat.i(87705);
                    if (bluetoothDevice == null) {
                        ab.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
                        AppMethodBeat.o(87705);
                    } else if (i.this.kbi == null || bo.isNullOrNil(i.this.kbi.name)) {
                        AppMethodBeat.o(87705);
                    } else {
                        String nullAsNil = bo.nullAsNil(bluetoothDevice.getName());
                        String address = bluetoothDevice.getAddress();
                        if (nullAsNil.equals(i.this.kbi.name)) {
                            ab.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i));
                            a.this.kbt.put(address, new b(address, i, nullAsNil, a.aw(bArr)));
                            AppMethodBeat.o(87705);
                            return;
                        }
                        ab.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i));
                        AppMethodBeat.o(87705);
                    }
                }
            };
            AppMethodBeat.o(87706);
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final void reset() {
            AppMethodBeat.i(87707);
            this.kbt.clear();
            AppMethodBeat.o(87707);
        }

        public final b baG() {
            AppMethodBeat.i(87708);
            b bVar = new b("", -100, "", null);
            if (this.kbt.size() <= 0) {
                AppMethodBeat.o(87708);
                return bVar;
            }
            Iterator it = this.kbt.values().iterator();
            while (true) {
                b bVar2 = bVar;
                if (it.hasNext()) {
                    bVar = (b) it.next();
                    if (bVar2.cyC >= bVar.cyC) {
                        bVar = bVar2;
                    }
                } else {
                    AppMethodBeat.o(87708);
                    return bVar2;
                }
            }
        }

        @TargetApi(18)
        public final void baH() {
            AppMethodBeat.i(87709);
            if (VERSION.SDK_INT < 18) {
                ab.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.o(87709);
            } else if (this.kbr) {
                ab.i("MicroMsg.CardLbsOrBluetooth", "already start");
                AppMethodBeat.o(87709);
            } else {
                this.kbt.clear();
                BluetoothManager bluetoothManager = (BluetoothManager) ah.getContext().getSystemService("bluetooth");
                if (bluetoothManager == null) {
                    this.kbs = false;
                    ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
                    AppMethodBeat.o(87709);
                    return;
                }
                this.kbs = true;
                this.hJY = bluetoothManager.getAdapter();
                if (this.hJY == null || !this.hJY.isEnabled()) {
                    this.kbs = false;
                    ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                    AppMethodBeat.o(87709);
                    return;
                }
                boolean startLeScan = this.hJY.startLeScan(this.kbw);
                ab.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", Boolean.valueOf(startLeScan));
                this.kbr = true;
                AppMethodBeat.o(87709);
            }
        }

        @TargetApi(18)
        public final void baI() {
            AppMethodBeat.i(87710);
            if (VERSION.SDK_INT < 18) {
                ab.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.o(87710);
            } else if (!this.kbr) {
                ab.i("MicroMsg.CardLbsOrBluetooth", "not start");
                AppMethodBeat.o(87710);
            } else if (this.hJY == null || !this.hJY.isEnabled()) {
                this.kbs = false;
                ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                AppMethodBeat.o(87710);
            } else {
                this.kbs = true;
                this.hJY.stopLeScan(this.kbw);
                ab.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
                this.kbr = false;
                AppMethodBeat.o(87710);
            }
        }

        public static byte[] aw(byte[] bArr) {
            byte[] bArr2 = null;
            AppMethodBeat.i(87711);
            if (bArr == null) {
                AppMethodBeat.o(87711);
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
                        AppMethodBeat.o(87711);
                    }
                }
                AppMethodBeat.o(87711);
            }
            return bArr2;
        }
    }

    static class b {
        String ceI;
        int cyC;
        byte[] kby;
        String name;

        public b(String str, int i, String str2, byte[] bArr) {
            this.ceI = str;
            this.cyC = i;
            this.name = str2;
            this.kby = bArr;
        }

        public final String toString() {
            AppMethodBeat.i(87712);
            String str = "DeviceInfo{deviceId='" + this.ceI + '\'' + ", rssi=" + this.cyC + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.kby) + '}';
            AppMethodBeat.o(87712);
            return str;
        }
    }

    public i() {
        AppMethodBeat.i(87713);
        AppMethodBeat.o(87713);
    }

    public final void a(MMActivity mMActivity, String str, com.tencent.mm.plugin.card.base.b bVar, float f, float f2) {
        int i;
        boolean z;
        AppMethodBeat.i(87714);
        this.bZi = true;
        this.kbc = mMActivity;
        this.kaE = str;
        this.kaS = bVar;
        this.ecs = f;
        this.ect = f2;
        this.kbf = bVar.aZV().vUF;
        this.kbg = bVar.aZW().vSr;
        this.kbi = bVar.aZV().vUG;
        if (bVar.aZV().vUG == null) {
            i = 60;
        } else {
            i = bVar.aZV().vUG.vON;
        }
        this.kbl = i;
        if (bVar.aZV().vUG == null || bo.isNullOrNil(bVar.aZV().vUG.name)) {
            z = false;
        } else {
            z = true;
        }
        this.kbh = z;
        ab.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", str, Boolean.valueOf(this.kbf), Boolean.valueOf(this.kbg), Boolean.valueOf(this.kbh), Integer.valueOf(this.kbl));
        if (this.kbf && !this.kbg) {
            String str2 = bo.isNullOrNil(this.kaS.aZV().vUH) ? this.kaS.aZV().title : this.kaS.aZV().vUH;
            h.a(this.kbc, this.kbc.getString(R.string.agk, new Object[]{str2}), this.kbc.getString(R.string.tz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(87702);
                    i.this.kbg = true;
                    i.a(i.this.kaE, new byte[0], -85.0f, -1000.0f, 0, false, true);
                    AppMethodBeat.o(87702);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.this.kbg = false;
                }
            });
        }
        if (this.kbh) {
            ab.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", this.kbi.name);
            this.kbk = new a(this, (byte) 0);
            a aVar = this.kbk;
            ab.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
            aVar.hDr = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(87704);
                    if (intent == null) {
                        ab.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
                        AppMethodBeat.o(87704);
                        return;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        int state = defaultAdapter.getState();
                        ab.d("MicroMsg.CardLbsOrBluetooth", "state:%d", Integer.valueOf(state));
                        if (state == 12) {
                            a.this.kbs = true;
                            al.n(a.this.kbv, a.this.kbu);
                            AppMethodBeat.o(87704);
                            return;
                        } else if (state == 10) {
                            al.af(a.this.kbv);
                            a.this.kbs = false;
                            a.this.kbt.clear();
                        }
                    }
                    AppMethodBeat.o(87704);
                }
            };
            ah.getContext().registerReceiver(aVar.hDr, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        start();
        IF();
        AppMethodBeat.o(87714);
    }

    public final void start() {
        AppMethodBeat.i(87715);
        if (baF()) {
            ab.i("MicroMsg.CardLbsOrBluetooth", "start");
            if (this.bZi) {
                if (this.kbf) {
                    axU();
                }
                if (this.kbk != null && this.kbh) {
                    this.kbk.baH();
                }
                baB();
                g.RO().eJo.a(2574, (f) this);
                AppMethodBeat.o(87715);
                return;
            }
            ab.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", Boolean.valueOf(this.bZi));
            AppMethodBeat.o(87715);
            return;
        }
        AppMethodBeat.o(87715);
    }

    public final void baB() {
        AppMethodBeat.i(87716);
        baC();
        if (this.kbl > 0) {
            long j = (long) (this.kbl * 1000);
            this.kbp.ae(j, j);
            ab.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
            AppMethodBeat.o(87716);
            return;
        }
        ab.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
        AppMethodBeat.o(87716);
    }

    public final void baC() {
        AppMethodBeat.i(87717);
        ab.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
        if (!this.kbp.doT()) {
            this.kbp.stopTimer();
        }
        AppMethodBeat.o(87717);
    }

    public final void IF() {
        AppMethodBeat.i(87718);
        if (!baF()) {
            ab.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
            AppMethodBeat.o(87718);
        } else if (this.kbd) {
            ab.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
            AppMethodBeat.o(87718);
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
            ab.i(str, str2, objArr);
            if (baE && baD) {
                b baG = this.kbk.baG();
                ab.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", baG);
                ab.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.ect), Float.valueOf(this.ecs));
                a(this.kaE, baG.kby, this.ect, this.ecs, baG.cyC, this.kbk.kbs);
                this.kbn = System.currentTimeMillis();
                this.kbm = System.currentTimeMillis();
                this.kbk.reset();
                this.kbj = baG;
                AppMethodBeat.o(87718);
            } else if (baE) {
                b baG2 = this.kbk.baG();
                ab.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", baG2);
                a(this.kaE, baG2.kby, baG2.cyC, this.kbk.kbs);
                this.kbm = System.currentTimeMillis();
                this.kbk.reset();
                this.kbj = baG2;
                AppMethodBeat.o(87718);
            } else if (baD) {
                ab.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                ab.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.ect), Float.valueOf(this.ecs));
                b(this.kaE, this.ect, this.ecs);
                this.kbn = System.currentTimeMillis();
                AppMethodBeat.o(87718);
            } else {
                ab.e("MicroMsg.CardLbsOrBluetooth", "not report");
                this.kbd = false;
                AppMethodBeat.o(87718);
            }
        }
    }

    private boolean baD() {
        boolean z = true;
        AppMethodBeat.i(87719);
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
                AppMethodBeat.o(87719);
            }
        }
        return z;
    }

    private boolean baE() {
        AppMethodBeat.i(87720);
        if (!this.kbh) {
            AppMethodBeat.o(87720);
            return false;
        } else if (this.kbk == null) {
            ab.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
            AppMethodBeat.o(87720);
            return false;
        } else if (this.kbk.baG().ceI.equals("")) {
            AppMethodBeat.o(87720);
            return false;
        } else if (System.currentTimeMillis() - this.kbm >= this.kbo) {
            AppMethodBeat.o(87720);
            return true;
        } else {
            AppMethodBeat.o(87720);
            return false;
        }
    }

    private void b(String str, float f, float f2) {
        AppMethodBeat.i(87721);
        a(str, new byte[0], f, f2, 0, false, this.kbg);
        AppMethodBeat.o(87721);
    }

    private void a(String str, byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(87722);
        a(str, bArr, -1000.0f, -85.0f, i, z, this.kbg);
        AppMethodBeat.o(87722);
    }

    private void a(String str, byte[] bArr, float f, float f2, int i, boolean z) {
        AppMethodBeat.i(87723);
        a(str, bArr, f, f2, i, z, this.kbg);
        AppMethodBeat.o(87723);
    }

    static void a(String str, byte[] bArr, float f, float f2, int i, boolean z, boolean z2) {
        AppMethodBeat.i(87724);
        g.RO().eJo.a(new ai(str, bArr, f, f2, (float) i, z, z2), 0);
        AppMethodBeat.o(87724);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87725);
        ab.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kbd = false;
        AppMethodBeat.o(87725);
    }

    private static void axU() {
        AppMethodBeat.i(87726);
        LocationManager locationManager = (LocationManager) ah.getContext().getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        if (locationManager != null) {
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            ab.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", Boolean.valueOf(isProviderEnabled), Boolean.valueOf(isProviderEnabled2));
        }
        AppMethodBeat.o(87726);
    }

    public final boolean baF() {
        return this.kbf || this.kbh;
    }
}
