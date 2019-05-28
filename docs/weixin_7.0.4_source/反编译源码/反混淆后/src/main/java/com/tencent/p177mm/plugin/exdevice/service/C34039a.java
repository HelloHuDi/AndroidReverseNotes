package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.p177mm.plugin.exdevice.p956h.C27836a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.service.a */
public final class C34039a implements C43002r {
    private static C34039a lwh = null;
    private Object cli = new Object();
    private final HashMap<Long, Long> lwi = new HashMap();
    private C20544g lwj = null;
    C7306ak mHandler = new C34041a(C20549v.bpz().fPG.oAl.getLooper());

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$g */
    static final class C2987g {
        long lwo;
        C11661p lwp;

        public C2987g(long j, C11661p c11661p) {
            this.lwo = j;
            this.lwp = c11661p;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$e */
    static final class C20542e {
        String hxN = null;
        int lqL = 0;
        int lqz = 0;
        long lwo = 0;
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$1 */
    class C278551 implements Runnable {
        C278551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19520);
            C34039a.this.lwj.mo35817a(0, -1, "", "", "", 0, null);
            AppMethodBeat.m2505o(19520);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$f */
    static final class C27856f {
        long jJa;
        byte[] mData;

        public C27856f(long j, byte[] bArr) {
            this.jJa = j;
            this.mData = bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$c */
    static final class C34040c {
        int hGc;
        String jJe;
        byte[] jJf;
        String mDeviceName;

        public C34040c(String str, String str2, int i, byte[] bArr) {
            this.jJe = str;
            this.mDeviceName = str2;
            this.hGc = i;
            this.jJf = bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$a */
    final class C34041a extends C7306ak {
        public C34041a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(19521);
            switch (message.what) {
                case 1:
                    C34040c c34040c = (C34040c) message.obj;
                    C34039a.this.lwj.mo35817a(1, 0, null, c34040c.jJe, c34040c.mDeviceName, c34040c.hGc, c34040c.jJf);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 2:
                    C34039a.this.lwj.mo35817a(2, 0, null, null, null, 0, null);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 3:
                    C20542e c20542e = (C20542e) message.obj;
                    C34039a.this.lwj.mo35820c(c20542e.lwo, c20542e.lqL, c20542e.lqz, c20542e.hxN);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 4:
                    C34043d c34043d = (C34043d) message.obj;
                    C34039a.this.lwj.mo35819b(c34043d.jJa, c34043d.lwm, c34043d.lwn, c34043d.lqz);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 5:
                    C34042b c34042b = (C34042b) message.obj;
                    C34039a.this.lwj.mo35818a(message.arg1, c34042b.jJa, c34042b.lqG, c34042b.lwl, c34042b.lqA);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 6:
                    AppMethodBeat.m2505o(19521);
                    return;
                case 7:
                    AppMethodBeat.m2505o(19521);
                    return;
                case 8:
                    C2987g c2987g = (C2987g) message.obj;
                    C34039a.m55763a(C34039a.this, c2987g.lwo, c2987g.lwp);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 9:
                    C34039a.m55773hQ(((Long) message.obj).longValue());
                    AppMethodBeat.m2505o(19521);
                    return;
                case 10:
                    C27856f c27856f = (C27856f) message.obj;
                    C34039a.m55765a(C34039a.this, c27856f.jJa, c27856f.mData);
                    AppMethodBeat.m2505o(19521);
                    return;
                case 11:
                    synchronized (C34039a.this.cli) {
                        try {
                            C34039a.m55766a(C34039a.this, ((Long) message.obj).longValue());
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(19521);
                                break;
                            }
                        }
                    }
                    return;
                case 12:
                    synchronized (C34039a.this.cli) {
                        try {
                            C34039a.m55769b(C34039a.this, ((Long) message.obj).longValue());
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(19521);
                                break;
                            }
                        }
                    }
                    return;
                default:
                    AppMethodBeat.m2505o(19521);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$b */
    static final class C34042b {
        long jJa;
        byte[] lqA;
        short lqG;
        short lwl;

        private C34042b() {
            this.jJa = 0;
            this.lqG = (short) 0;
            this.lwl = (short) 0;
            this.lqA = null;
        }

        /* synthetic */ C34042b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$d */
    static final class C34043d {
        long jJa;
        int lqz;
        int lwm;
        int lwn;

        private C34043d() {
            this.jJa = 0;
            this.lwm = 0;
            this.lwn = 0;
            this.lqz = 0;
        }

        /* synthetic */ C34043d(byte b) {
            this();
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m55769b(C34039a c34039a, long j) {
        AppMethodBeat.m2504i(19538);
        boolean hO = c34039a.m55771hO(j);
        AppMethodBeat.m2505o(19538);
        return hO;
    }

    public C34039a(C20544g c20544g) {
        AppMethodBeat.m2504i(19522);
        this.lwj = c20544g;
        lwh = this;
        AppMethodBeat.m2505o(19522);
    }

    /* renamed from: uL */
    public static boolean m55774uL(int i) {
        AppMethodBeat.m2504i(19523);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (C34044b.m55787uL(i)) {
            AppMethodBeat.m2505o(19523);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        AppMethodBeat.m2505o(19523);
        return false;
    }

    public static long[] bpl() {
        AppMethodBeat.m2504i(19524);
        long[] Kt = C27836a.m44245Kt("conneted_device");
        AppMethodBeat.m2505o(19524);
        return Kt;
    }

    /* renamed from: hO */
    private boolean m55771hO(long j) {
        AppMethodBeat.m2504i(19525);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(j)));
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j));
        if (!C27836a.m44244E("conneted_device", j)) {
            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.lwi.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.lwi.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.lwi.get(Long.valueOf(j))).longValue());
            AppMethodBeat.m2505o(19525);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        AppMethodBeat.m2505o(19525);
        return false;
    }

    /* renamed from: a */
    private int m55762a(long j, C11661p c11661p) {
        AppMethodBeat.m2504i(19526);
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(c11661p);
        try {
            long bpp = c11661p.bpu().bpp();
            if (!C27836a.m44242C("conneted_device", bpp)) {
                C4990ab.m7420w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                C20542e c20542e = new C20542e();
                c20542e.lwo = j;
                c20542e.lqz = -1;
                c20542e.lqL = -1;
                c20542e.hxN = "Channel is close aready!!!";
                Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(3, 0, 0, c20542e)));
                AppMethodBeat.m2505o(19526);
                return -1;
            } else if (this.lwi.containsKey(Long.valueOf(bpp))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.lwi.get(Long.valueOf(bpp))).longValue();
                try {
                    accessoryCmd.reqCmdID = c11661p.bpu().bpr();
                    accessoryCmd.respCmdID = c11661p.bpu().bps();
                    try {
                        if (Java2CExDevice.startTask(j, (short) c11661p.bpu().bpt(), accessoryCmd, c11661p.bpu().bpq()) != 0) {
                            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            AppMethodBeat.m2505o(19526);
                            return -1;
                        }
                        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Long.valueOf(bpp), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(c11661p.bpu().bpt()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        AppMethodBeat.m2505o(19526);
                        return 0;
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.lwj.mo35820c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        AppMethodBeat.m2505o(19526);
                        return -1;
                    }
                } catch (RemoteException e2) {
                    C4990ab.m7413e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e2.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.lwj.mo35820c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    AppMethodBeat.m2505o(19526);
                    return -1;
                }
            } else {
                C4990ab.m7413e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", Long.valueOf(bpp));
                this.lwj.mo35820c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                AppMethodBeat.m2505o(19526);
                return -1;
            }
        } catch (RemoteException e22) {
            C4990ab.m7413e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e22.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.lwj.mo35820c(j, -1, -1, "Remote getDeviceId failed!!!");
            AppMethodBeat.m2505o(19526);
            return -1;
        }
    }

    /* renamed from: c */
    public static void m55770c(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19527);
        Assert.assertNotNull(lwh);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        C20542e c20542e = new C20542e();
        c20542e.lwo = j;
        c20542e.lqz = i2;
        c20542e.lqL = i;
        c20542e.hxN = str;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(3, 0, 0, c20542e)));
        AppMethodBeat.m2505o(19527);
    }

    /* renamed from: b */
    public static void m55768b(long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(19528);
        Assert.assertNotNull(lwh);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long hP = lwh.m55772hP(j);
        if (-1 == hP) {
            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.m2505o(19528);
            return;
        }
        C34043d c34043d = new C34043d();
        c34043d.jJa = hP;
        c34043d.lqz = i3;
        c34043d.lwn = i2;
        c34043d.lwm = i;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(4, 0, 0, c34043d)));
        AppMethodBeat.m2505o(19528);
    }

    /* renamed from: hP */
    private long m55772hP(long j) {
        AppMethodBeat.m2504i(19529);
        if (this.lwi.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.lwi.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    long longValue = ((Long) entry.getKey()).longValue();
                    AppMethodBeat.m2505o(19529);
                    return longValue;
                }
            }
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(19529);
            return -1;
        }
        C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        AppMethodBeat.m2505o(19529);
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        AppMethodBeat.m2504i(19530);
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr);
        Assert.assertNotNull(lwh);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long hP = lwh.m55772hP(j);
        if (-1 == hP) {
            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.m2505o(19530);
            return;
        }
        C34042b c34042b = new C34042b();
        c34042b.jJa = hP;
        c34042b.lqA = bArr;
        c34042b.lwl = s2;
        c34042b.lqG = s;
        Assert.assertTrue(lwh.mHandler.sendMessage(lwh.mHandler.obtainMessage(5, i, 0, c34042b)));
        AppMethodBeat.m2505o(19530);
    }

    /* renamed from: rQ */
    public final void mo23195rQ(int i) {
        AppMethodBeat.m2504i(19531);
        C4990ab.m7416i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(i)));
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
        AppMethodBeat.m2505o(19531);
    }

    /* renamed from: a */
    public final void mo23193a(String str, String str2, int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(19532);
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        C4990ab.m7411d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new C34040c(str, str2, i2, bArr))));
        AppMethodBeat.m2505o(19532);
    }

    /* renamed from: Fy */
    public final void mo23191Fy(String str) {
        AppMethodBeat.m2504i(19533);
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", Integer.valueOf(-1), Integer.valueOf(-1));
        if (!this.mHandler.post(new C278551())) {
            C4990ab.m7412e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19533);
    }

    /* renamed from: hQ */
    static /* synthetic */ void m55773hQ(long j) {
        AppMethodBeat.m2504i(19536);
        C4990ab.m7417i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j));
        Java2CExDevice.stopTask(j);
        AppMethodBeat.m2505o(19536);
    }
}
