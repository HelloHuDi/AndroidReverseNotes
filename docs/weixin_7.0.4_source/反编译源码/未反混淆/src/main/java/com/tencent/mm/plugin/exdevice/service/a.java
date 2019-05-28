package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a lwh = null;
    private Object cli = new Object();
    private final HashMap<Long, Long> lwi = new HashMap();
    private g lwj = null;
    ak mHandler = new a(v.bpz().fPG.oAl.getLooper());

    static final class g {
        long lwo;
        p lwp;

        public g(long j, p pVar) {
            this.lwo = j;
            this.lwp = pVar;
        }
    }

    static final class e {
        String hxN = null;
        int lqL = 0;
        int lqz = 0;
        long lwo = 0;
    }

    static final class f {
        long jJa;
        byte[] mData;

        public f(long j, byte[] bArr) {
            this.jJa = j;
            this.mData = bArr;
        }
    }

    static final class c {
        int hGc;
        String jJe;
        byte[] jJf;
        String mDeviceName;

        public c(String str, String str2, int i, byte[] bArr) {
            this.jJe = str;
            this.mDeviceName = str2;
            this.hGc = i;
            this.jJf = bArr;
        }
    }

    final class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(19521);
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    a.this.lwj.a(1, 0, null, cVar.jJe, cVar.mDeviceName, cVar.hGc, cVar.jJf);
                    AppMethodBeat.o(19521);
                    return;
                case 2:
                    a.this.lwj.a(2, 0, null, null, null, 0, null);
                    AppMethodBeat.o(19521);
                    return;
                case 3:
                    e eVar = (e) message.obj;
                    a.this.lwj.c(eVar.lwo, eVar.lqL, eVar.lqz, eVar.hxN);
                    AppMethodBeat.o(19521);
                    return;
                case 4:
                    d dVar = (d) message.obj;
                    a.this.lwj.b(dVar.jJa, dVar.lwm, dVar.lwn, dVar.lqz);
                    AppMethodBeat.o(19521);
                    return;
                case 5:
                    b bVar = (b) message.obj;
                    a.this.lwj.a(message.arg1, bVar.jJa, bVar.lqG, bVar.lwl, bVar.lqA);
                    AppMethodBeat.o(19521);
                    return;
                case 6:
                    AppMethodBeat.o(19521);
                    return;
                case 7:
                    AppMethodBeat.o(19521);
                    return;
                case 8:
                    g gVar = (g) message.obj;
                    a.a(a.this, gVar.lwo, gVar.lwp);
                    AppMethodBeat.o(19521);
                    return;
                case 9:
                    a.hQ(((Long) message.obj).longValue());
                    AppMethodBeat.o(19521);
                    return;
                case 10:
                    f fVar = (f) message.obj;
                    a.a(a.this, fVar.jJa, fVar.mData);
                    AppMethodBeat.o(19521);
                    return;
                case 11:
                    synchronized (a.this.cli) {
                        try {
                            a.a(a.this, ((Long) message.obj).longValue());
                        } finally {
                            while (true) {
                                AppMethodBeat.o(19521);
                                break;
                            }
                        }
                    }
                    return;
                case 12:
                    synchronized (a.this.cli) {
                        try {
                            a.b(a.this, ((Long) message.obj).longValue());
                        } finally {
                            while (true) {
                                AppMethodBeat.o(19521);
                                break;
                            }
                        }
                    }
                    return;
                default:
                    AppMethodBeat.o(19521);
                    return;
            }
        }
    }

    static final class b {
        long jJa;
        byte[] lqA;
        short lqG;
        short lwl;

        private b() {
            this.jJa = 0;
            this.lqG = (short) 0;
            this.lwl = (short) 0;
            this.lqA = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class d {
        long jJa;
        int lqz;
        int lwm;
        int lwn;

        private d() {
            this.jJa = 0;
            this.lwm = 0;
            this.lwn = 0;
            this.lqz = 0;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static /* synthetic */ boolean b(a aVar, long j) {
        AppMethodBeat.i(19538);
        boolean hO = aVar.hO(j);
        AppMethodBeat.o(19538);
        return hO;
    }

    public a(g gVar) {
        AppMethodBeat.i(19522);
        this.lwj = gVar;
        lwh = this;
        AppMethodBeat.o(19522);
    }

    public static boolean uL(int i) {
        AppMethodBeat.i(19523);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.uL(i)) {
            AppMethodBeat.o(19523);
            return true;
        }
        ab.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        AppMethodBeat.o(19523);
        return false;
    }

    public static long[] bpl() {
        AppMethodBeat.i(19524);
        long[] Kt = com.tencent.mm.plugin.exdevice.h.a.Kt("conneted_device");
        AppMethodBeat.o(19524);
        return Kt;
    }

    private boolean hO(long j) {
        AppMethodBeat.i(19525);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(j)));
        ab.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j));
        if (!com.tencent.mm.plugin.exdevice.h.a.E("conneted_device", j)) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.lwi.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.lwi.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.lwi.get(Long.valueOf(j))).longValue());
            AppMethodBeat.o(19525);
            return true;
        }
        ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        AppMethodBeat.o(19525);
        return false;
    }

    private int a(long j, p pVar) {
        AppMethodBeat.i(19526);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        try {
            long bpp = pVar.bpu().bpp();
            if (!com.tencent.mm.plugin.exdevice.h.a.C("conneted_device", bpp)) {
                ab.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.lwo = j;
                eVar.lqz = -1;
                eVar.lqL = -1;
                eVar.hxN = "Channel is close aready!!!";
                Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(3, 0, 0, eVar)));
                AppMethodBeat.o(19526);
                return -1;
            } else if (this.lwi.containsKey(Long.valueOf(bpp))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.lwi.get(Long.valueOf(bpp))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.bpu().bpr();
                    accessoryCmd.respCmdID = pVar.bpu().bps();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.bpu().bpt(), accessoryCmd, pVar.bpu().bpq()) != 0) {
                            ab.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            AppMethodBeat.o(19526);
                            return -1;
                        }
                        ab.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Long.valueOf(bpp), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.bpu().bpt()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        AppMethodBeat.o(19526);
                        return 0;
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e.getMessage());
                        ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.lwj.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        AppMethodBeat.o(19526);
                        return -1;
                    }
                } catch (RemoteException e2) {
                    ab.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e2.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.lwj.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    AppMethodBeat.o(19526);
                    return -1;
                }
            } else {
                ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", Long.valueOf(bpp));
                this.lwj.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                AppMethodBeat.o(19526);
                return -1;
            }
        } catch (RemoteException e22) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e22.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.lwj.c(j, -1, -1, "Remote getDeviceId failed!!!");
            AppMethodBeat.o(19526);
            return -1;
        }
    }

    public static void c(long j, int i, int i2, String str) {
        AppMethodBeat.i(19527);
        Assert.assertNotNull(lwh);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.lwo = j;
        eVar.lqz = i2;
        eVar.lqL = i;
        eVar.hxN = str;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(3, 0, 0, eVar)));
        AppMethodBeat.o(19527);
    }

    public static void b(long j, int i, int i2, int i3) {
        AppMethodBeat.i(19528);
        Assert.assertNotNull(lwh);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long hP = lwh.hP(j);
        if (-1 == hP) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.o(19528);
            return;
        }
        d dVar = new d();
        dVar.jJa = hP;
        dVar.lqz = i3;
        dVar.lwn = i2;
        dVar.lwm = i;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(4, 0, 0, dVar)));
        AppMethodBeat.o(19528);
    }

    private long hP(long j) {
        AppMethodBeat.i(19529);
        if (this.lwi.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.lwi.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    long longValue = ((Long) entry.getKey()).longValue();
                    AppMethodBeat.o(19529);
                    return longValue;
                }
            }
            Assert.assertTrue(false);
            AppMethodBeat.o(19529);
            return -1;
        }
        ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        AppMethodBeat.o(19529);
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        AppMethodBeat.i(19530);
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        ab.i(str, str2, objArr);
        Assert.assertNotNull(lwh);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long hP = lwh.hP(j);
        if (-1 == hP) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.o(19530);
            return;
        }
        b bVar = new b();
        bVar.jJa = hP;
        bVar.lqA = bArr;
        bVar.lwl = s2;
        bVar.lqG = s;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(5, i, 0, bVar)));
        AppMethodBeat.o(19530);
    }

    public final void rQ(int i) {
        AppMethodBeat.i(19531);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(i)));
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
        AppMethodBeat.o(19531);
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(19532);
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        ab.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
        AppMethodBeat.o(19532);
    }

    public final void Fy(String str) {
        AppMethodBeat.i(19533);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", Integer.valueOf(-1), Integer.valueOf(-1));
        if (!this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19520);
                a.this.lwj.a(0, -1, "", "", "", 0, null);
                AppMethodBeat.o(19520);
            }
        })) {
            ab.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
        AppMethodBeat.o(19533);
    }

    static /* synthetic */ void hQ(long j) {
        AppMethodBeat.i(19536);
        ab.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j));
        Java2CExDevice.stopTask(j);
        AppMethodBeat.o(19536);
    }
}
