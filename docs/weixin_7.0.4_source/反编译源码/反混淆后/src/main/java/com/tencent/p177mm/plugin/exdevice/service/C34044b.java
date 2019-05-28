package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.p369d.p370a.p375d.C38840c;
import com.tencent.p177mm.plugin.p369d.p370a.p375d.C45825b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.service.b */
public final class C34044b implements C38840c {
    private static C34044b lwu = null;
    private CountDownLatch countDownLatch;
    private C45825b lwq = null;
    private final Vector<C43002r> lwr = new Vector();
    private final HashMap<Long, Integer> lws = new HashMap();
    private final HashMap<Long, Integer> lwt = new HashMap();
    private C7306ak mHandler = new C7306ak(C20549v.bpz().fPG.oAl.getLooper());

    /* renamed from: com.tencent.mm.plugin.exdevice.service.b$1 */
    class C278571 implements Runnable {
        C278571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19539);
            C34044b.this.lwq = new C45825b(C4996ah.getContext(), C34044b.this, C20549v.bpz().fPG);
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
            C34044b.this.countDownLatch.countDown();
            AppMethodBeat.m2505o(19539);
        }
    }

    public C34044b() {
        AppMethodBeat.m2504i(19546);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId()));
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.lwq = new C45825b(C4996ah.getContext(), this, C20549v.bpz().fPG);
            AppMethodBeat.m2505o(19546);
        } else if (r0 == r2) {
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.lwq = new C45825b(C4996ah.getContext(), this, C20549v.bpz().fPG);
            AppMethodBeat.m2505o(19546);
        } else {
            new C7306ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new C278571());
            this.countDownLatch = new CountDownLatch(1);
            try {
                this.countDownLatch.await();
            } catch (InterruptedException e) {
            }
            C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
            AppMethodBeat.m2505o(19546);
        }
    }

    private static C34044b bpm() {
        AppMethodBeat.m2504i(19547);
        C34044b c34044b;
        if (lwu != null) {
            c34044b = lwu;
            AppMethodBeat.m2505o(19547);
            return c34044b;
        }
        c34044b = new C34044b();
        lwu = c34044b;
        AppMethodBeat.m2505o(19547);
        return c34044b;
    }

    /* renamed from: a */
    public static boolean m55781a(final int i, final C43002r c43002r, final int... iArr) {
        AppMethodBeat.m2504i(19548);
        C34044b bpm = C34044b.bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19540);
                if (!C34044b.m55783a(this.lww, i, c43002r, iArr)) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
                AppMethodBeat.m2505o(19540);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19548);
        return post;
    }

    /* renamed from: uL */
    public static boolean m55787uL(final int i) {
        AppMethodBeat.m2504i(19549);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", Integer.valueOf(i));
        C34044b bpm = C34044b.bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19541);
                if (!C34044b.m55782a(this.lww, i)) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
                AppMethodBeat.m2505o(19541);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19549);
        return post;
    }

    public static void createSession(long j, long j2) {
        AppMethodBeat.m2504i(19550);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", Long.valueOf(j), Long.valueOf(j2));
        C34044b bpm = C34044b.bpm();
        final long j3 = j;
        final long j4 = j2;
        if (!bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19542);
                C34044b.m55780a(this.lww, j3, j4);
                AppMethodBeat.m2505o(19542);
            }
        })) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19550);
    }

    public static boolean sendData(final long j, final byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(19551);
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        C34044b bpm = C34044b.bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19543);
                if (!C34044b.m55785a(this.lww, j, bArr)) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
                AppMethodBeat.m2505o(19543);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19551);
        return post;
    }

    public static boolean connect(final long j) {
        AppMethodBeat.m2504i(19552);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", Long.valueOf(j));
        C34044b bpm = C34044b.bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19544);
                if (!C34044b.m55784a(this.lww, j)) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
                AppMethodBeat.m2505o(19544);
            }
        });
        if (!post) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19552);
        return post;
    }

    public static void destroySession(final long j) {
        AppMethodBeat.m2504i(19553);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", Long.valueOf(j));
        C34044b bpm = C34044b.bpm();
        if (!bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ C34044b lww;

            public final void run() {
                AppMethodBeat.m2504i(19545);
                C34044b.m55786b(this.lww, j);
                AppMethodBeat.m2505o(19545);
            }
        })) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.m2505o(19553);
    }

    /* renamed from: g */
    public final void mo54572g(long j, long j2, long j3) {
        AppMethodBeat.m2504i(19554);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.lws.containsKey(Long.valueOf(j2)));
        if (!this.lwt.containsKey(Long.valueOf(j))) {
            this.lwt.put(Long.valueOf(j), this.lws.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
        AppMethodBeat.m2505o(19554);
    }

    /* renamed from: rQ */
    public final void mo54576rQ(int i) {
        AppMethodBeat.m2504i(19555);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", Integer.valueOf(i));
        if (this.lwr.isEmpty()) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.m2505o(19555);
            return;
        }
        Iterator it = this.lwr.iterator();
        while (it.hasNext()) {
            C43002r c43002r = (C43002r) it.next();
            if (c43002r != null) {
                c43002r.mo23195rQ(i);
            }
        }
        this.lwr.clear();
        AppMethodBeat.m2505o(19555);
    }

    /* renamed from: a */
    public final void mo54570a(String str, String str2, int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(19556);
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        C4990ab.m7411d(str3, str4, objArr);
        if (this.lwr.isEmpty()) {
            C4990ab.m7420w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.m2505o(19556);
            return;
        }
        Iterator it = this.lwr.iterator();
        while (it.hasNext()) {
            ((C43002r) it.next()).mo23193a(str, str2, i, i2, bArr);
        }
        AppMethodBeat.m2505o(19556);
    }

    /* renamed from: l */
    public final void mo54574l(long j, boolean z) {
        AppMethodBeat.m2504i(19557);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
            AppMethodBeat.m2505o(19557);
            return;
        }
        Java2CExDevice.onBluetoothDisconnected(j);
        AppMethodBeat.m2505o(19557);
    }

    /* renamed from: b */
    public final void mo54571b(long j, byte[] bArr) {
        AppMethodBeat.m2504i(19558);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = ".concat(String.valueOf(j)));
        Java2CExDevice.onBluetoothRecvData(j, bArr);
        AppMethodBeat.m2505o(19558);
    }

    /* renamed from: m */
    public final void mo54575m(long j, boolean z) {
        AppMethodBeat.m2504i(19559);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
            AppMethodBeat.m2505o(19559);
            return;
        }
        Java2CExDevice.onBluetoothError(j, 0);
        AppMethodBeat.m2505o(19559);
    }

    /* renamed from: gB */
    public final void mo54573gB(long j) {
        AppMethodBeat.m2504i(19560);
        Java2CExDevice.onBluetoothError(j, 0);
        AppMethodBeat.m2505o(19560);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m55783a(C34044b c34044b, int i, C43002r c43002r, int[] iArr) {
        AppMethodBeat.m2504i(19561);
        if (c43002r == null) {
            C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
            AppMethodBeat.m2505o(19561);
            throw illegalArgumentException;
        }
        boolean d;
        if (iArr == null) {
            d = c34044b.lwq.mo73627d(i, new int[0]);
        } else {
            d = c34044b.lwq.mo73627d(i, iArr);
        }
        if (d) {
            c34044b.lwr.add(c43002r);
            AppMethodBeat.m2505o(19561);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (c43002r != null) {
            c43002r.mo23191Fy("scanImp: mBTSDKMrg.scan failed!!!");
        }
        AppMethodBeat.m2505o(19561);
        return false;
    }
}
