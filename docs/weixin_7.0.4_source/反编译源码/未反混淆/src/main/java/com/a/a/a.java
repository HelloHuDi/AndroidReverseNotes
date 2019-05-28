package com.a.a;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;

public final class a {
    private c bBV;
    private b bBW;
    a bBX;
    private int bBY;
    b bBZ;
    int bCa = -1;
    private DeathRecipient bCb = new DeathRecipient() {
        public final void binderDied() {
            AppMethodBeat.i(118244);
            if (a.this.bBZ != null) {
                a.this.bBZ.bJ(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL, -1);
            }
            AppMethodBeat.o(118244);
        }
    };

    public interface b {
        void bJ(int i, int i2);

        void vR();
    }

    class a extends Handler {
        private final int bCd = 2001;
        private final int bCe = 2002;
        private final int bCf = 2003;
        private final int bCg = 2004;
        private final int bCh = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        private final int bCi = TXLiveConstants.PLAY_EVT_PLAY_END;

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
            AppMethodBeat.i(118245);
            new StringBuilder("what = ").append(message.what);
            switch (message.what) {
                case 1:
                    if (a.this.bBZ != null) {
                        a.this.bBZ.vR();
                        AppMethodBeat.o(118245);
                        return;
                    }
                    break;
                case 2:
                    if (a.this.bBZ != null) {
                        a.this.bBZ.vR();
                        AppMethodBeat.o(118245);
                        return;
                    }
                    break;
                case 3:
                    if (a.this.bBZ != null) {
                        a.this.bBZ.vR();
                        AppMethodBeat.o(118245);
                        return;
                    }
                    break;
                case 6:
                    if (a.this.bBZ != null) {
                        a.this.bBZ.bJ(0, message.arg1);
                    }
                    removeMessages(8);
                    AppMethodBeat.o(118245);
                    return;
                case 7:
                    if (a.this.bBZ != null) {
                        switch (message.arg1) {
                            case 2001:
                                i = 2002;
                                break;
                            case 2002:
                                i = 2003;
                                break;
                            case 2003:
                            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                                break;
                            case 2004:
                                i = 2000;
                                break;
                            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                                i = TXLiveConstants.PLAY_EVT_PLAY_END;
                                break;
                            default:
                                i = 2020;
                                break;
                        }
                        a.this.bBZ.bJ(i, -1);
                    }
                    removeMessages(8);
                    AppMethodBeat.o(118245);
                    return;
                case 8:
                    if (a.this.bBZ != null) {
                        a.this.bBZ.bJ(2001, -1);
                    }
                    removeMessages(8);
                    a.this.abort();
                    break;
            }
            AppMethodBeat.o(118245);
        }
    }

    public static a vN() {
        AppMethodBeat.i(118218);
        c vQ = vQ();
        if (vQ == null) {
            AppMethodBeat.o(118218);
            return null;
        }
        try {
            a aVar = new a(vQ, Looper.getMainLooper());
            AppMethodBeat.o(118218);
            return aVar;
        } catch (Exception e) {
            AppMethodBeat.o(118218);
            return null;
        }
    }

    private a(c cVar, Looper looper) {
        AppMethodBeat.i(118219);
        this.bBV = cVar;
        a aVar = new a(looper);
        this.bBY = 1;
        this.bBW = new com.a.a.b.a() {
            public final void b(int i, int i2, int i3, byte[] bArr) {
                AppMethodBeat.i(118243);
                a.this.bBX.sendMessage(a.this.bBX.obtainMessage(i, i2, i3, bArr));
                AppMethodBeat.o(118243);
            }
        };
        if (this.bBV.a(this.bBW, 1)) {
            this.bBX = aVar;
            cVar.asBinder().linkToDeath(this.bCb, 0);
            AppMethodBeat.o(118219);
            return;
        }
        RuntimeException runtimeException = new RuntimeException();
        AppMethodBeat.o(118219);
        throw runtimeException;
    }

    public final void release() {
        AppMethodBeat.i(118220);
        if (this.bBX != null) {
            this.bBX.removeMessages(8);
        }
        try {
            this.bBV.b(this.bBW);
            this.bBV.asBinder().unlinkToDeath(this.bCb, 0);
            AppMethodBeat.o(118220);
        } catch (RemoteException e) {
            AppMethodBeat.o(118220);
        }
    }

    public final int[] vO() {
        AppMethodBeat.i(118221);
        int[] c;
        try {
            c = this.bBV.c(this.bBW);
            AppMethodBeat.o(118221);
            return c;
        } catch (RemoteException e) {
            c = new int[0];
            AppMethodBeat.o(118221);
            return c;
        }
    }

    public final int a(b bVar, int[] iArr) {
        int i = -1;
        AppMethodBeat.i(118222);
        if (iArr == null || bVar == null) {
            AppMethodBeat.o(118222);
        } else {
            this.bBZ = bVar;
            this.bCa = 0;
            try {
                i = this.bBV.a(this.bBW, iArr, null);
                AppMethodBeat.o(118222);
            } catch (RemoteException e) {
                AppMethodBeat.o(118222);
            }
        }
        return i;
    }

    public final void abort() {
        AppMethodBeat.i(118223);
        if (this.bBX != null) {
            this.bBX.removeMessages(8);
        }
        try {
            this.bBV.a(this.bBW);
            AppMethodBeat.o(118223);
        } catch (RemoteException e) {
            AppMethodBeat.o(118223);
        }
    }

    public static int[] vP() {
        AppMethodBeat.i(118224);
        c vQ = vQ();
        int[] iArr;
        if (vQ == null) {
            iArr = new int[0];
            AppMethodBeat.o(118224);
            return iArr;
        }
        try {
            iArr = vQ.vS();
            AppMethodBeat.o(118224);
            return iArr;
        } catch (RemoteException e) {
            iArr = new int[0];
            AppMethodBeat.o(118224);
            return iArr;
        }
    }

    private static c vQ() {
        AppMethodBeat.i(118225);
        c i = com.a.a.c.a.i(ServiceManager.getService("authentication_service"));
        AppMethodBeat.o(118225);
        return i;
    }
}
