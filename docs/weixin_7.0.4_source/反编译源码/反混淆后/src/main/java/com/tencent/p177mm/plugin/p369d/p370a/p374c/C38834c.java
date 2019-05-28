package com.tencent.p177mm.plugin.p369d.p370a.p374c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.d.a.c.c */
public final class C38834c {

    /* renamed from: com.tencent.mm.plugin.d.a.c.c$a */
    public static final class C38833a {
        BluetoothSocket jIG;
        final boolean jIH = true;
        public final C27699b jII;
        public final C20291a jIJ;
        boolean jIK = false;
        final BluetoothDevice jIL;
        public final C7306ak mHandler;
        private final HandlerThread mThread;

        /* renamed from: com.tencent.mm.plugin.d.a.c.c$a$a */
        static class C20294a extends C7306ak {
            private WeakReference<C38833a> jGh = null;

            public C20294a(Looper looper, C38833a c38833a) {
                super(looper);
                AppMethodBeat.m2504i(18485);
                this.jGh = new WeakReference(c38833a);
                AppMethodBeat.m2505o(18485);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(18486);
                C38833a c38833a = (C38833a) this.jGh.get();
                if (c38833a == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    AppMethodBeat.m2505o(18486);
                    return;
                }
                switch (message.what) {
                    case 0:
                        C4990ab.m7416i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (c38833a.jIK) {
                            C4990ab.m7420w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            AppMethodBeat.m2505o(18486);
                            return;
                        }
                        try {
                            if (c38833a.jIH) {
                                c38833a.jIG = c38833a.jIL.createRfcommSocketToServiceRecord(C20291a.jIw);
                            } else {
                                c38833a.jIG = c38833a.jIL.createInsecureRfcommSocketToServiceRecord(C20291a.jIx);
                            }
                            try {
                                c38833a.jIG.connect();
                                c38833a.jIK = true;
                                C27699b c27699b = c38833a.jII;
                                C20291a c20291a = c38833a.jIJ;
                                BluetoothSocket bluetoothSocket = c38833a.jIG;
                                C4990ab.m7416i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                c27699b.mState = 3;
                                if (c27699b.jIE != null) {
                                    c27699b.jIE.cancel();
                                    c27699b.jIE = null;
                                }
                                if (c27699b.jIF != null) {
                                    c27699b.jIF.cancel();
                                    c27699b.jIF = null;
                                }
                                c27699b.jIE = new C38836b(c27699b, c20291a, bluetoothSocket);
                                C7305d.m12301h(c27699b.jIE, "BluetoothChatSession_recv").start();
                                c27699b.jIF = new C38835c(c27699b, c20291a, bluetoothSocket);
                                C7305d.m12301h(c27699b.jIF, "BluetoothChatSession_send").start();
                                if (c38833a.jIJ != null) {
                                    c38833a.jIJ.jIy.mo7010l(c38833a.jII.mSessionId, true);
                                }
                                AppMethodBeat.m2505o(18486);
                                return;
                            } catch (IOException e) {
                                C4990ab.m7413e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", e.toString());
                                try {
                                    c38833a.jIG.close();
                                } catch (IOException e2) {
                                    C4990ab.m7413e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", e2.toString());
                                }
                                if (c38833a.jIJ != null) {
                                    c38833a.jIJ.jIy.mo7010l(c38833a.jII.mSessionId, false);
                                }
                                AppMethodBeat.m2505o(18486);
                                return;
                            }
                        } catch (IOException e22) {
                            c38833a.jIG = null;
                            C4990ab.m7413e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", e22.toString());
                            if (c38833a.jIJ != null) {
                                c38833a.jIJ.jIy.mo7010l(c38833a.jII.mSessionId, false);
                            }
                            AppMethodBeat.m2505o(18486);
                            return;
                        }
                    case 1:
                        if (c38833a.jIK) {
                            try {
                                c38833a.jIG.close();
                                AppMethodBeat.m2505o(18486);
                                return;
                            } catch (IOException e3) {
                                C4990ab.m7413e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", e3.toString());
                                break;
                            }
                        }
                        C4990ab.m7420w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                        AppMethodBeat.m2505o(18486);
                        return;
                }
                AppMethodBeat.m2505o(18486);
            }
        }

        public C38833a(C27699b c27699b, C20291a c20291a, BluetoothDevice bluetoothDevice) {
            AppMethodBeat.m2504i(18487);
            this.jIJ = c20291a;
            this.jII = c27699b;
            this.jIL = bluetoothDevice;
            this.mThread = C7305d.anM("BluetoothChatThreads_handlerThread");
            this.mThread.start();
            this.mHandler = new C20294a(this.mThread.getLooper(), this);
            AppMethodBeat.m2505o(18487);
        }

        public final void disconnect() {
            AppMethodBeat.m2504i(18488);
            C4990ab.m7416i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                C4990ab.m7413e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", Integer.valueOf(1));
            }
            if (C1443d.m3068iW(18)) {
                this.mThread.quitSafely();
                AppMethodBeat.m2505o(18488);
                return;
            }
            this.mThread.quit();
            AppMethodBeat.m2505o(18488);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.c$c */
    public static final class C38835c implements Runnable {
        private C27699b jII = null;
        private C20291a jIJ = null;
        private volatile boolean jIN = false;
        private volatile Runnable jIO = null;
        private OutputStream jIP = null;
        private final LinkedList<byte[]> jIQ = new LinkedList();
        private final LinkedList<byte[]> jIR = new LinkedList();

        public C38835c(C27699b c27699b, C20291a c20291a, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.m2504i(18492);
            this.jII = c27699b;
            this.jIJ = c20291a;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.jIO = this;
                this.jIP = outputStream;
                AppMethodBeat.m2505o(18492);
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.exdevice.SendThread", "temp sockets not created", e);
                this.jIP = null;
                if (this.jIJ != null) {
                    this.jIJ.jIy.mo7007c(this.jII.mSessionId, 11, "Can not get write stream");
                }
                AppMethodBeat.m2505o(18492);
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(18493);
            C4990ab.m7416i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
            if (this.jIP == null) {
                AppMethodBeat.m2505o(18493);
                return;
            }
            while (!this.jIN) {
                if (this.jIO == null) {
                    C4990ab.m7420w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                    AppMethodBeat.m2505o(18493);
                    return;
                } else if (!this.jIR.isEmpty()) {
                    try {
                        this.jIP.write((byte[]) this.jIR.pop());
                        if (this.jIJ != null) {
                            this.jIJ.jIy.mo7011m(this.jII.mSessionId, true);
                        }
                    } catch (IOException e) {
                        if (this.jIJ != null) {
                            this.jIJ.jIy.mo7011m(this.jII.mSessionId, false);
                        }
                    }
                } else if (this.jIQ.isEmpty()) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                            C4990ab.m7420w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(18493);
                        }
                    }
                } else {
                    synchronized (this.jIQ) {
                        try {
                            Assert.assertTrue(this.jIR.addAll(this.jIQ));
                            this.jIQ.clear();
                        } catch (Throwable th2) {
                            AppMethodBeat.m2505o(18493);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(18493);
        }

        /* renamed from: av */
        public final boolean mo61715av(byte[] bArr) {
            AppMethodBeat.m2504i(18494);
            C4990ab.m7417i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", Integer.valueOf(bArr.length));
            if (this.jIO == null) {
                C4990ab.m7412e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                AppMethodBeat.m2505o(18494);
                return false;
            }
            synchronized (this) {
                try {
                    this.jIQ.add(bArr);
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(18494);
                }
            }
            return true;
        }

        public final void cancel() {
            AppMethodBeat.m2504i(18495);
            this.jIO = null;
            this.jIN = true;
            synchronized (this) {
                try {
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(18495);
                }
            }
            this.jIR.clear();
            this.jIQ.clear();
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.c$b */
    public static final class C38836b implements Runnable {
        private final BluetoothSocket jIG;
        private C27699b jII;
        C20291a jIJ;
        private InputStream jIM = null;
        private volatile boolean jIN = false;

        public C38836b(C27699b c27699b, C20291a c20291a, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.m2504i(18489);
            this.jIG = bluetoothSocket;
            this.jII = c27699b;
            this.jIJ = c20291a;
            try {
                this.jIM = bluetoothSocket.getInputStream();
                AppMethodBeat.m2505o(18489);
            } catch (IOException e) {
                this.jIM = null;
                C4990ab.m7413e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", e.toString());
                AppMethodBeat.m2505o(18489);
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(18490);
            C4990ab.m7416i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.jIM == null) {
                C4990ab.m7412e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                AppMethodBeat.m2505o(18490);
                return;
            }
            byte[] bArr = new byte[2048];
            while (!this.jIN) {
                try {
                    int read = this.jIM.read(bArr);
                    if (read > 0) {
                        C4990ab.m7417i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", Integer.valueOf(read));
                        C4990ab.m7411d("MicroMsg.exdevice.RecvThread", "data dump = %s", C42992b.m76348S(bArr, read));
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        if (this.jIJ != null) {
                            this.jIJ.jIy.mo7006b(this.jII.mSessionId, bArr2);
                        }
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", e.toString());
                    try {
                        this.jIG.close();
                        AppMethodBeat.m2505o(18490);
                        return;
                    } catch (IOException e2) {
                        C4990ab.m7413e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", e2.toString());
                        AppMethodBeat.m2505o(18490);
                        return;
                    }
                }
            }
            C4990ab.m7420w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
            AppMethodBeat.m2505o(18490);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(18491);
            C4990ab.m7416i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.jIN) {
                C4990ab.m7420w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                AppMethodBeat.m2505o(18491);
                return;
            }
            this.jIN = true;
            try {
                this.jIG.close();
                AppMethodBeat.m2505o(18491);
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", e);
                AppMethodBeat.m2505o(18491);
            }
        }
    }
}
