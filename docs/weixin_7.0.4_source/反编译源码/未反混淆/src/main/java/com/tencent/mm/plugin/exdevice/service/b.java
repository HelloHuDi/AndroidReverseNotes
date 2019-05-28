package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.d.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b lwu = null;
    private CountDownLatch countDownLatch;
    private com.tencent.mm.plugin.d.a.d.b lwq = null;
    private final Vector<r> lwr = new Vector();
    private final HashMap<Long, Integer> lws = new HashMap();
    private final HashMap<Long, Integer> lwt = new HashMap();
    private ak mHandler = new ak(v.bpz().fPG.oAl.getLooper());

    public b() {
        AppMethodBeat.i(19546);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId()));
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.lwq = new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), this, v.bpz().fPG);
            AppMethodBeat.o(19546);
        } else if (r0 == r2) {
            ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.lwq = new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), this, v.bpz().fPG);
            AppMethodBeat.o(19546);
        } else {
            new ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19539);
                    b.this.lwq = new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), b.this, v.bpz().fPG);
                    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
                    b.this.countDownLatch.countDown();
                    AppMethodBeat.o(19539);
                }
            });
            this.countDownLatch = new CountDownLatch(1);
            try {
                this.countDownLatch.await();
            } catch (InterruptedException e) {
            }
            ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
            AppMethodBeat.o(19546);
        }
    }

    private static b bpm() {
        AppMethodBeat.i(19547);
        b bVar;
        if (lwu != null) {
            bVar = lwu;
            AppMethodBeat.o(19547);
            return bVar;
        }
        bVar = new b();
        lwu = bVar;
        AppMethodBeat.o(19547);
        return bVar;
    }

    public static boolean a(final int i, final r rVar, final int... iArr) {
        AppMethodBeat.i(19548);
        b bpm = bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19540);
                if (!b.a(this.lww, i, rVar, iArr)) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
                AppMethodBeat.o(19540);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19548);
        return post;
    }

    public static boolean uL(final int i) {
        AppMethodBeat.i(19549);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", Integer.valueOf(i));
        b bpm = bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19541);
                if (!b.a(this.lww, i)) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
                AppMethodBeat.o(19541);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19549);
        return post;
    }

    public static void createSession(long j, long j2) {
        AppMethodBeat.i(19550);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", Long.valueOf(j), Long.valueOf(j2));
        b bpm = bpm();
        final long j3 = j;
        final long j4 = j2;
        if (!bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19542);
                b.a(this.lww, j3, j4);
                AppMethodBeat.o(19542);
            }
        })) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19550);
    }

    public static boolean sendData(final long j, final byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(19551);
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        ab.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        b bpm = bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19543);
                if (!b.a(this.lww, j, bArr)) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
                AppMethodBeat.o(19543);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19551);
        return post;
    }

    public static boolean connect(final long j) {
        AppMethodBeat.i(19552);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", Long.valueOf(j));
        b bpm = bpm();
        boolean post = bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19544);
                if (!b.a(this.lww, j)) {
                    ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
                AppMethodBeat.o(19544);
            }
        });
        if (!post) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19552);
        return post;
    }

    public static void destroySession(final long j) {
        AppMethodBeat.i(19553);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", Long.valueOf(j));
        b bpm = bpm();
        if (!bpm.mHandler.post(new Runnable(bpm) {
            final /* synthetic */ b lww;

            public final void run() {
                AppMethodBeat.i(19545);
                b.b(this.lww, j);
                AppMethodBeat.o(19545);
            }
        })) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(19553);
    }

    public final void g(long j, long j2, long j3) {
        AppMethodBeat.i(19554);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.lws.containsKey(Long.valueOf(j2)));
        if (!this.lwt.containsKey(Long.valueOf(j))) {
            this.lwt.put(Long.valueOf(j), this.lws.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
        AppMethodBeat.o(19554);
    }

    public final void rQ(int i) {
        AppMethodBeat.i(19555);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", Integer.valueOf(i));
        if (this.lwr.isEmpty()) {
            ab.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.o(19555);
            return;
        }
        Iterator it = this.lwr.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.rQ(i);
            }
        }
        this.lwr.clear();
        AppMethodBeat.o(19555);
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(19556);
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        ab.d(str3, str4, objArr);
        if (this.lwr.isEmpty()) {
            ab.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.o(19556);
            return;
        }
        Iterator it = this.lwr.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
        AppMethodBeat.o(19556);
    }

    public final void l(long j, boolean z) {
        AppMethodBeat.i(19557);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
            AppMethodBeat.o(19557);
            return;
        }
        Java2CExDevice.onBluetoothDisconnected(j);
        AppMethodBeat.o(19557);
    }

    public final void b(long j, byte[] bArr) {
        AppMethodBeat.i(19558);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = ".concat(String.valueOf(j)));
        Java2CExDevice.onBluetoothRecvData(j, bArr);
        AppMethodBeat.o(19558);
    }

    public final void m(long j, boolean z) {
        AppMethodBeat.i(19559);
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
            AppMethodBeat.o(19559);
            return;
        }
        Java2CExDevice.onBluetoothError(j, 0);
        AppMethodBeat.o(19559);
    }

    public final void gB(long j) {
        AppMethodBeat.i(19560);
        Java2CExDevice.onBluetoothError(j, 0);
        AppMethodBeat.o(19560);
    }

    static /* synthetic */ boolean a(b bVar, int i, r rVar, int[] iArr) {
        AppMethodBeat.i(19561);
        if (rVar == null) {
            ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
            AppMethodBeat.o(19561);
            throw illegalArgumentException;
        }
        boolean d;
        if (iArr == null) {
            d = bVar.lwq.d(i, new int[0]);
        } else {
            d = bVar.lwq.d(i, iArr);
        }
        if (d) {
            bVar.lwr.add(rVar);
            AppMethodBeat.o(19561);
            return true;
        }
        ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (rVar != null) {
            rVar.Fy("scanImp: mBTSDKMrg.scan failed!!!");
        }
        AppMethodBeat.o(19561);
        return false;
    }
}
