package com.p782a.p783a;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.p782a.p783a.C31906b.C31907a;
import com.p782a.p783a.C31909c.C25388a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.a.a.a */
public final class C44974a {
    private C31909c bBV;
    private C31906b bBW;
    C31905a bBX;
    private int bBY;
    C8478b bBZ;
    int bCa = -1;
    private DeathRecipient bCb = new C253871();

    /* renamed from: com.a.a.a$b */
    public interface C8478b {
        /* renamed from: bJ */
        void mo18532bJ(int i, int i2);

        /* renamed from: vR */
        void mo18533vR();
    }

    /* renamed from: com.a.a.a$1 */
    class C253871 implements DeathRecipient {
        C253871() {
        }

        public final void binderDied() {
            AppMethodBeat.m2504i(118244);
            if (C44974a.this.bBZ != null) {
                C44974a.this.bBZ.mo18532bJ(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL, -1);
            }
            AppMethodBeat.m2505o(118244);
        }
    }

    /* renamed from: com.a.a.a$a */
    class C31905a extends Handler {
        private final int bCd = 2001;
        private final int bCe = 2002;
        private final int bCf = 2003;
        private final int bCg = 2004;
        private final int bCh = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        private final int bCi = TXLiveConstants.PLAY_EVT_PLAY_END;

        public C31905a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
            AppMethodBeat.m2504i(118245);
            new StringBuilder("what = ").append(message.what);
            switch (message.what) {
                case 1:
                    if (C44974a.this.bBZ != null) {
                        C44974a.this.bBZ.mo18533vR();
                        AppMethodBeat.m2505o(118245);
                        return;
                    }
                    break;
                case 2:
                    if (C44974a.this.bBZ != null) {
                        C44974a.this.bBZ.mo18533vR();
                        AppMethodBeat.m2505o(118245);
                        return;
                    }
                    break;
                case 3:
                    if (C44974a.this.bBZ != null) {
                        C44974a.this.bBZ.mo18533vR();
                        AppMethodBeat.m2505o(118245);
                        return;
                    }
                    break;
                case 6:
                    if (C44974a.this.bBZ != null) {
                        C44974a.this.bBZ.mo18532bJ(0, message.arg1);
                    }
                    removeMessages(8);
                    AppMethodBeat.m2505o(118245);
                    return;
                case 7:
                    if (C44974a.this.bBZ != null) {
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
                        C44974a.this.bBZ.mo18532bJ(i, -1);
                    }
                    removeMessages(8);
                    AppMethodBeat.m2505o(118245);
                    return;
                case 8:
                    if (C44974a.this.bBZ != null) {
                        C44974a.this.bBZ.mo18532bJ(2001, -1);
                    }
                    removeMessages(8);
                    C44974a.this.abort();
                    break;
            }
            AppMethodBeat.m2505o(118245);
        }
    }

    /* renamed from: com.a.a.a$2 */
    class C369172 extends C31907a {
        C369172() {
        }

        /* renamed from: b */
        public final void mo52020b(int i, int i2, int i3, byte[] bArr) {
            AppMethodBeat.m2504i(118243);
            C44974a.this.bBX.sendMessage(C44974a.this.bBX.obtainMessage(i, i2, i3, bArr));
            AppMethodBeat.m2505o(118243);
        }
    }

    /* renamed from: vN */
    public static C44974a m82340vN() {
        AppMethodBeat.m2504i(118218);
        C31909c vQ = C44974a.m82342vQ();
        if (vQ == null) {
            AppMethodBeat.m2505o(118218);
            return null;
        }
        try {
            C44974a c44974a = new C44974a(vQ, Looper.getMainLooper());
            AppMethodBeat.m2505o(118218);
            return c44974a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(118218);
            return null;
        }
    }

    private C44974a(C31909c c31909c, Looper looper) {
        AppMethodBeat.m2504i(118219);
        this.bBV = c31909c;
        C31905a c31905a = new C31905a(looper);
        this.bBY = 1;
        this.bBW = new C369172();
        if (this.bBV.mo18537a(this.bBW, 1)) {
            this.bBX = c31905a;
            c31909c.asBinder().linkToDeath(this.bCb, 0);
            AppMethodBeat.m2505o(118219);
            return;
        }
        RuntimeException runtimeException = new RuntimeException();
        AppMethodBeat.m2505o(118219);
        throw runtimeException;
    }

    public final void release() {
        AppMethodBeat.m2504i(118220);
        if (this.bBX != null) {
            this.bBX.removeMessages(8);
        }
        try {
            this.bBV.mo18541b(this.bBW);
            this.bBV.asBinder().unlinkToDeath(this.bCb, 0);
            AppMethodBeat.m2505o(118220);
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(118220);
        }
    }

    /* renamed from: vO */
    public final int[] mo72257vO() {
        AppMethodBeat.m2504i(118221);
        int[] c;
        try {
            c = this.bBV.mo18543c(this.bBW);
            AppMethodBeat.m2505o(118221);
            return c;
        } catch (RemoteException e) {
            c = new int[0];
            AppMethodBeat.m2505o(118221);
            return c;
        }
    }

    /* renamed from: a */
    public final int mo72254a(C8478b c8478b, int[] iArr) {
        int i = -1;
        AppMethodBeat.m2504i(118222);
        if (iArr == null || c8478b == null) {
            AppMethodBeat.m2505o(118222);
        } else {
            this.bBZ = c8478b;
            this.bCa = 0;
            try {
                i = this.bBV.mo18534a(this.bBW, iArr, null);
                AppMethodBeat.m2505o(118222);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(118222);
            }
        }
        return i;
    }

    public final void abort() {
        AppMethodBeat.m2504i(118223);
        if (this.bBX != null) {
            this.bBX.removeMessages(8);
        }
        try {
            this.bBV.mo18536a(this.bBW);
            AppMethodBeat.m2505o(118223);
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(118223);
        }
    }

    /* renamed from: vP */
    public static int[] m82341vP() {
        AppMethodBeat.m2504i(118224);
        C31909c vQ = C44974a.m82342vQ();
        int[] iArr;
        if (vQ == null) {
            iArr = new int[0];
            AppMethodBeat.m2505o(118224);
            return iArr;
        }
        try {
            iArr = vQ.mo18550vS();
            AppMethodBeat.m2505o(118224);
            return iArr;
        } catch (RemoteException e) {
            iArr = new int[0];
            AppMethodBeat.m2505o(118224);
            return iArr;
        }
    }

    /* renamed from: vQ */
    private static C31909c m82342vQ() {
        AppMethodBeat.m2504i(118225);
        C31909c i = C25388a.m40092i(ServiceManager.getService("authentication_service"));
        AppMethodBeat.m2505o(118225);
        return i;
    }
}
