package com.tencent.p177mm.plugin.backup.p344c;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.lan_cs.Client;
import com.tencent.p177mm.lan_cs.Client.C1746a;
import com.tencent.p177mm.lan_cs.Server;
import com.tencent.p177mm.lan_cs.Server.C1747a;
import com.tencent.p177mm.lan_cs.Server.Java2C;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19975a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.backup.c.a */
public final class C33682a implements C19975a {
    public static final byte[] jrm = "GSMW".getBytes();
    private String jrn;
    private int jro;
    public C7306ak jrp = null;
    public C11132a jrq;
    private int mode = 0;

    /* renamed from: com.tencent.mm.plugin.backup.c.a$3 */
    public class C26463 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(17155);
            C33682a.this.stop();
            AppMethodBeat.m2505o(17155);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.a$2 */
    class C67912 implements C1746a {
        C67912() {
        }

        public final void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.m2504i(17153);
            C33682a.this.jrn = str;
            C33682a.this.jro = i;
            try {
                C33682a.m54994a(C33682a.this, bArr);
                AppMethodBeat.m2505o(17153);
            } catch (IOException e) {
                C33682a.m54993a(C33682a.this, 10006, ("client readErr:" + e.toString()).getBytes());
                AppMethodBeat.m2505o(17153);
            }
        }

        /* renamed from: SX */
        public final void mo5278SX() {
            AppMethodBeat.m2504i(17154);
            C33682a.m54993a(C33682a.this, CdnLogic.kMediaTypeBeatificFile, "client onDisconnect".getBytes());
            AppMethodBeat.m2505o(17154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.a$a */
    public interface C11132a {
        /* renamed from: c */
        void mo22838c(int i, int i2, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.a$1 */
    class C336801 implements C1747a {
        C336801() {
        }

        /* renamed from: jW */
        public final void mo5281jW(int i) {
            AppMethodBeat.m2504i(17149);
            if (C33682a.this.mode == 1) {
                C19978b.m30893rz(i);
            }
            AppMethodBeat.m2505o(17149);
        }

        public final void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.m2504i(17150);
            C33682a.this.jrn = str;
            C33682a.this.jro = i;
            try {
                C33682a.m54994a(C33682a.this, bArr);
                AppMethodBeat.m2505o(17150);
            } catch (IOException e) {
                C33682a.m54993a(C33682a.this, 10006, ("server readErr:" + e.toString()).getBytes());
                AppMethodBeat.m2505o(17150);
            }
        }

        /* renamed from: SX */
        public final void mo5280SX() {
            AppMethodBeat.m2504i(17151);
            C33682a.m54993a(C33682a.this, CdnLogic.kMediaTypeBeatificFile, "listen server onDisconnect".getBytes());
            AppMethodBeat.m2505o(17151);
        }

        public final void onConnect(String str, int i) {
            AppMethodBeat.m2504i(17152);
            C33682a.this.jrn = str;
            C33682a.this.jro = i;
            AppMethodBeat.m2505o(17152);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m54993a(C33682a c33682a, int i, byte[] bArr) {
        AppMethodBeat.m2504i(17165);
        c33682a.m54995a(true, 0, i, bArr);
        AppMethodBeat.m2505o(17165);
    }

    static {
        AppMethodBeat.m2504i(17166);
        AppMethodBeat.m2505o(17166);
    }

    /* renamed from: a */
    public final boolean mo54233a(PString pString, PInt pInt) {
        AppMethodBeat.m2504i(17158);
        this.mode = 0;
        C4990ab.m7416i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Java2C.stop();
        C4990ab.m7416i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.eOu = new C336801();
        Object[] access$000 = Java2C.access$000();
        if (access$000 == null || access$000.length != 3) {
            C4990ab.m7412e("MicroMsg.BackupCEngine", "listen error");
            AppMethodBeat.m2505o(17158);
            return false;
        }
        C4990ab.m7417i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", access$000[0], access$000[1], access$000[2]);
        if (((Integer) access$000[0]).intValue() != 1) {
            AppMethodBeat.m2505o(17158);
            return false;
        }
        pString.value = (String) access$000[1];
        pInt.value = ((Integer) access$000[2]).intValue();
        this.mode = 1;
        AppMethodBeat.m2505o(17158);
        return true;
    }

    public final void connect(String str, int i) {
        AppMethodBeat.m2504i(17159);
        this.mode = 2;
        this.jrn = str;
        this.jro = i;
        Client.eOt = new C67912();
        AppMethodBeat.m2505o(17159);
    }

    public final void stop() {
        AppMethodBeat.m2504i(17160);
        C4990ab.m7416i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            C19978b.aTm();
            this.mode = 0;
            AppMethodBeat.m2505o(17160);
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            C19978b.aTm();
            this.mode = 0;
            AppMethodBeat.m2505o(17160);
        } else {
            AppMethodBeat.m2505o(17160);
        }
    }

    /* renamed from: i */
    public final void mo35222i(int i, byte[] bArr) {
        AppMethodBeat.m2504i(17161);
        final long anU = C5046bo.anU();
        C4990ab.m7419v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", Integer.valueOf(i), Integer.valueOf(C5046bo.m7541cc(bArr)));
        if (this.jrp == null || !this.jrp.getLooper().getThread().isAlive()) {
            HandlerThread anM = C7305d.anM("BackupCEngine_sendHandler");
            anM.setPriority(10);
            anM.start();
            this.jrp = new C7306ak(anM.getLooper());
            C4990ab.m7421w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", Long.valueOf(anM.getId()));
        }
        final int i2 = i;
        final byte[] bArr2 = bArr;
        this.jrp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17156);
                long anU = C5046bo.anU();
                C4990ab.m7417i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", Integer.valueOf(C33682a.this.mode), Integer.valueOf(i2), Integer.valueOf(C5046bo.m7541cc(bArr2)), Long.valueOf(anU - anU));
                if (C33682a.this.mode == 0) {
                    C4990ab.m7416i("MicroMsg.BackupCEngine", "sendImp err mode!!");
                    AppMethodBeat.m2505o(17156);
                    return;
                }
                int send;
                if (C33682a.this.mode == 1) {
                    send = Java2C.send(C33682a.this.jrn, C33682a.this.jro, bArr2);
                    if (send != 0) {
                    }
                } else {
                    send = C33682a.this.mode == 2 ? Client.Java2C.send(C33682a.this.jrn, C33682a.this.jro, bArr2) : 0;
                }
                C19978b.m30893rz(C5046bo.m7541cc(bArr2));
                C4990ab.m7417i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", Integer.valueOf(send), Integer.valueOf(i2), Integer.valueOf(C5046bo.m7541cc(bArr2)), Long.valueOf(C5046bo.m7566gb(anU)), Long.valueOf(C5046bo.m7566gb(anU)));
                AppMethodBeat.m2505o(17156);
            }
        });
        AppMethodBeat.m2505o(17161);
    }

    /* renamed from: j */
    public final int mo35223j(int i, byte[] bArr) {
        int send;
        AppMethodBeat.m2504i(17162);
        long anU = C5046bo.anU();
        if (this.mode == 1) {
            send = Java2C.send(this.jrn, this.jro, bArr);
        } else if (this.mode == 2) {
            send = Client.Java2C.send(this.jrn, this.jro, bArr);
            C19978b.m30893rz(C5046bo.m7541cc(bArr));
        } else {
            send = 0;
        }
        C4990ab.m7417i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(C5046bo.m7541cc(bArr)), Long.valueOf(C5046bo.m7566gb(anU)));
        AppMethodBeat.m2505o(17162);
        return send;
    }

    /* renamed from: a */
    private void m54995a(boolean z, int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(17163);
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17157);
                C19978b.m30887b(z2, i3, i4, bArr2);
                AppMethodBeat.m2505o(17157);
            }
        });
        AppMethodBeat.m2505o(17163);
    }
}
