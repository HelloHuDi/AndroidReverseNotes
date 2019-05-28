package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c {

    public static final class a {
        BluetoothSocket jIG;
        final boolean jIH = true;
        public final b jII;
        public final a jIJ;
        boolean jIK = false;
        final BluetoothDevice jIL;
        public final ak mHandler;
        private final HandlerThread mThread;

        static class a extends ak {
            private WeakReference<a> jGh = null;

            public a(Looper looper, a aVar) {
                super(looper);
                AppMethodBeat.i(18485);
                this.jGh = new WeakReference(aVar);
                AppMethodBeat.o(18485);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(18486);
                a aVar = (a) this.jGh.get();
                if (aVar == null) {
                    ab.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    AppMethodBeat.o(18486);
                    return;
                }
                switch (message.what) {
                    case 0:
                        ab.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (aVar.jIK) {
                            ab.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            AppMethodBeat.o(18486);
                            return;
                        }
                        try {
                            if (aVar.jIH) {
                                aVar.jIG = aVar.jIL.createRfcommSocketToServiceRecord(a.jIw);
                            } else {
                                aVar.jIG = aVar.jIL.createInsecureRfcommSocketToServiceRecord(a.jIx);
                            }
                            try {
                                aVar.jIG.connect();
                                aVar.jIK = true;
                                b bVar = aVar.jII;
                                a aVar2 = aVar.jIJ;
                                BluetoothSocket bluetoothSocket = aVar.jIG;
                                ab.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                bVar.mState = 3;
                                if (bVar.jIE != null) {
                                    bVar.jIE.cancel();
                                    bVar.jIE = null;
                                }
                                if (bVar.jIF != null) {
                                    bVar.jIF.cancel();
                                    bVar.jIF = null;
                                }
                                bVar.jIE = new b(bVar, aVar2, bluetoothSocket);
                                d.h(bVar.jIE, "BluetoothChatSession_recv").start();
                                bVar.jIF = new c(bVar, aVar2, bluetoothSocket);
                                d.h(bVar.jIF, "BluetoothChatSession_send").start();
                                if (aVar.jIJ != null) {
                                    aVar.jIJ.jIy.l(aVar.jII.mSessionId, true);
                                }
                                AppMethodBeat.o(18486);
                                return;
                            } catch (IOException e) {
                                ab.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", e.toString());
                                try {
                                    aVar.jIG.close();
                                } catch (IOException e2) {
                                    ab.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", e2.toString());
                                }
                                if (aVar.jIJ != null) {
                                    aVar.jIJ.jIy.l(aVar.jII.mSessionId, false);
                                }
                                AppMethodBeat.o(18486);
                                return;
                            }
                        } catch (IOException e22) {
                            aVar.jIG = null;
                            ab.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", e22.toString());
                            if (aVar.jIJ != null) {
                                aVar.jIJ.jIy.l(aVar.jII.mSessionId, false);
                            }
                            AppMethodBeat.o(18486);
                            return;
                        }
                    case 1:
                        if (aVar.jIK) {
                            try {
                                aVar.jIG.close();
                                AppMethodBeat.o(18486);
                                return;
                            } catch (IOException e3) {
                                ab.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", e3.toString());
                                break;
                            }
                        }
                        ab.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                        AppMethodBeat.o(18486);
                        return;
                }
                AppMethodBeat.o(18486);
            }
        }

        public a(b bVar, a aVar, BluetoothDevice bluetoothDevice) {
            AppMethodBeat.i(18487);
            this.jIJ = aVar;
            this.jII = bVar;
            this.jIL = bluetoothDevice;
            this.mThread = d.anM("BluetoothChatThreads_handlerThread");
            this.mThread.start();
            this.mHandler = new a(this.mThread.getLooper(), this);
            AppMethodBeat.o(18487);
        }

        public final void disconnect() {
            AppMethodBeat.i(18488);
            ab.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                ab.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", Integer.valueOf(1));
            }
            if (com.tencent.mm.compatible.util.d.iW(18)) {
                this.mThread.quitSafely();
                AppMethodBeat.o(18488);
                return;
            }
            this.mThread.quit();
            AppMethodBeat.o(18488);
        }
    }

    public static final class c implements Runnable {
        private b jII = null;
        private a jIJ = null;
        private volatile boolean jIN = false;
        private volatile Runnable jIO = null;
        private OutputStream jIP = null;
        private final LinkedList<byte[]> jIQ = new LinkedList();
        private final LinkedList<byte[]> jIR = new LinkedList();

        public c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.i(18492);
            this.jII = bVar;
            this.jIJ = aVar;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.jIO = this;
                this.jIP = outputStream;
                AppMethodBeat.o(18492);
            } catch (IOException e) {
                ab.e("MicroMsg.exdevice.SendThread", "temp sockets not created", e);
                this.jIP = null;
                if (this.jIJ != null) {
                    this.jIJ.jIy.c(this.jII.mSessionId, 11, "Can not get write stream");
                }
                AppMethodBeat.o(18492);
            }
        }

        public final void run() {
            AppMethodBeat.i(18493);
            ab.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
            if (this.jIP == null) {
                AppMethodBeat.o(18493);
                return;
            }
            while (!this.jIN) {
                if (this.jIO == null) {
                    ab.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                    AppMethodBeat.o(18493);
                    return;
                } else if (!this.jIR.isEmpty()) {
                    try {
                        this.jIP.write((byte[]) this.jIR.pop());
                        if (this.jIJ != null) {
                            this.jIJ.jIy.m(this.jII.mSessionId, true);
                        }
                    } catch (IOException e) {
                        if (this.jIJ != null) {
                            this.jIJ.jIy.m(this.jII.mSessionId, false);
                        }
                    }
                } else if (this.jIQ.isEmpty()) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            ab.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                            ab.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                        } catch (Throwable th) {
                            AppMethodBeat.o(18493);
                        }
                    }
                } else {
                    synchronized (this.jIQ) {
                        try {
                            Assert.assertTrue(this.jIR.addAll(this.jIQ));
                            this.jIQ.clear();
                        } catch (Throwable th2) {
                            AppMethodBeat.o(18493);
                        }
                    }
                }
            }
            AppMethodBeat.o(18493);
        }

        public final boolean av(byte[] bArr) {
            AppMethodBeat.i(18494);
            ab.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", Integer.valueOf(bArr.length));
            if (this.jIO == null) {
                ab.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                AppMethodBeat.o(18494);
                return false;
            }
            synchronized (this) {
                try {
                    this.jIQ.add(bArr);
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(18494);
                }
            }
            return true;
        }

        public final void cancel() {
            AppMethodBeat.i(18495);
            this.jIO = null;
            this.jIN = true;
            synchronized (this) {
                try {
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(18495);
                }
            }
            this.jIR.clear();
            this.jIQ.clear();
        }
    }

    public static final class b implements Runnable {
        private final BluetoothSocket jIG;
        private b jII;
        a jIJ;
        private InputStream jIM = null;
        private volatile boolean jIN = false;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.i(18489);
            this.jIG = bluetoothSocket;
            this.jII = bVar;
            this.jIJ = aVar;
            try {
                this.jIM = bluetoothSocket.getInputStream();
                AppMethodBeat.o(18489);
            } catch (IOException e) {
                this.jIM = null;
                ab.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", e.toString());
                AppMethodBeat.o(18489);
            }
        }

        public final void run() {
            AppMethodBeat.i(18490);
            ab.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.jIM == null) {
                ab.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                AppMethodBeat.o(18490);
                return;
            }
            byte[] bArr = new byte[2048];
            while (!this.jIN) {
                try {
                    int read = this.jIM.read(bArr);
                    if (read > 0) {
                        ab.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", Integer.valueOf(read));
                        ab.d("MicroMsg.exdevice.RecvThread", "data dump = %s", com.tencent.mm.plugin.exdevice.j.b.S(bArr, read));
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        if (this.jIJ != null) {
                            this.jIJ.jIy.b(this.jII.mSessionId, bArr2);
                        }
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", e.toString());
                    try {
                        this.jIG.close();
                        AppMethodBeat.o(18490);
                        return;
                    } catch (IOException e2) {
                        ab.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", e2.toString());
                        AppMethodBeat.o(18490);
                        return;
                    }
                }
            }
            ab.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
            AppMethodBeat.o(18490);
        }

        public final void cancel() {
            AppMethodBeat.i(18491);
            ab.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.jIN) {
                ab.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                AppMethodBeat.o(18491);
                return;
            }
            this.jIN = true;
            try {
                this.jIG.close();
                AppMethodBeat.o(18491);
            } catch (IOException e) {
                ab.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", e);
                AppMethodBeat.o(18491);
            }
        }
    }
}
