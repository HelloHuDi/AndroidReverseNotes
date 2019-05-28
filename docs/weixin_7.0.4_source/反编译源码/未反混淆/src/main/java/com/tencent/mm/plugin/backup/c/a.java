package com.tencent.mm.plugin.backup.c;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class a implements com.tencent.mm.plugin.backup.g.b.a {
    public static final byte[] jrm = "GSMW".getBytes();
    private String jrn;
    private int jro;
    public ak jrp = null;
    public a jrq;
    private int mode = 0;

    public interface a {
        void c(int i, int i2, byte[] bArr);
    }

    static /* synthetic */ void a(a aVar, int i, byte[] bArr) {
        AppMethodBeat.i(17165);
        aVar.a(true, 0, i, bArr);
        AppMethodBeat.o(17165);
    }

    static {
        AppMethodBeat.i(17166);
        AppMethodBeat.o(17166);
    }

    public final boolean a(PString pString, PInt pInt) {
        AppMethodBeat.i(17158);
        this.mode = 0;
        ab.i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Java2C.stop();
        ab.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.eOu = new com.tencent.mm.lan_cs.Server.a() {
            public final void jW(int i) {
                AppMethodBeat.i(17149);
                if (a.this.mode == 1) {
                    b.rz(i);
                }
                AppMethodBeat.o(17149);
            }

            public final void onRecv(String str, int i, byte[] bArr) {
                AppMethodBeat.i(17150);
                a.this.jrn = str;
                a.this.jro = i;
                try {
                    a.a(a.this, bArr);
                    AppMethodBeat.o(17150);
                } catch (IOException e) {
                    a.a(a.this, 10006, ("server readErr:" + e.toString()).getBytes());
                    AppMethodBeat.o(17150);
                }
            }

            public final void SX() {
                AppMethodBeat.i(17151);
                a.a(a.this, CdnLogic.kMediaTypeBeatificFile, "listen server onDisconnect".getBytes());
                AppMethodBeat.o(17151);
            }

            public final void onConnect(String str, int i) {
                AppMethodBeat.i(17152);
                a.this.jrn = str;
                a.this.jro = i;
                AppMethodBeat.o(17152);
            }
        };
        Object[] access$000 = Java2C.access$000();
        if (access$000 == null || access$000.length != 3) {
            ab.e("MicroMsg.BackupCEngine", "listen error");
            AppMethodBeat.o(17158);
            return false;
        }
        ab.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", access$000[0], access$000[1], access$000[2]);
        if (((Integer) access$000[0]).intValue() != 1) {
            AppMethodBeat.o(17158);
            return false;
        }
        pString.value = (String) access$000[1];
        pInt.value = ((Integer) access$000[2]).intValue();
        this.mode = 1;
        AppMethodBeat.o(17158);
        return true;
    }

    public final void connect(String str, int i) {
        AppMethodBeat.i(17159);
        this.mode = 2;
        this.jrn = str;
        this.jro = i;
        Client.eOt = new com.tencent.mm.lan_cs.Client.a() {
            public final void onRecv(String str, int i, byte[] bArr) {
                AppMethodBeat.i(17153);
                a.this.jrn = str;
                a.this.jro = i;
                try {
                    a.a(a.this, bArr);
                    AppMethodBeat.o(17153);
                } catch (IOException e) {
                    a.a(a.this, 10006, ("client readErr:" + e.toString()).getBytes());
                    AppMethodBeat.o(17153);
                }
            }

            public final void SX() {
                AppMethodBeat.i(17154);
                a.a(a.this, CdnLogic.kMediaTypeBeatificFile, "client onDisconnect".getBytes());
                AppMethodBeat.o(17154);
            }
        };
        AppMethodBeat.o(17159);
    }

    public final void stop() {
        AppMethodBeat.i(17160);
        ab.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            b.aTm();
            this.mode = 0;
            AppMethodBeat.o(17160);
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.aTm();
            this.mode = 0;
            AppMethodBeat.o(17160);
        } else {
            AppMethodBeat.o(17160);
        }
    }

    public final void i(int i, byte[] bArr) {
        AppMethodBeat.i(17161);
        final long anU = bo.anU();
        ab.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", Integer.valueOf(i), Integer.valueOf(bo.cc(bArr)));
        if (this.jrp == null || !this.jrp.getLooper().getThread().isAlive()) {
            HandlerThread anM = d.anM("BackupCEngine_sendHandler");
            anM.setPriority(10);
            anM.start();
            this.jrp = new ak(anM.getLooper());
            ab.w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", Long.valueOf(anM.getId()));
        }
        final int i2 = i;
        final byte[] bArr2 = bArr;
        this.jrp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17156);
                long anU = bo.anU();
                ab.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", Integer.valueOf(a.this.mode), Integer.valueOf(i2), Integer.valueOf(bo.cc(bArr2)), Long.valueOf(anU - anU));
                if (a.this.mode == 0) {
                    ab.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
                    AppMethodBeat.o(17156);
                    return;
                }
                int send;
                if (a.this.mode == 1) {
                    send = Java2C.send(a.this.jrn, a.this.jro, bArr2);
                    if (send != 0) {
                    }
                } else {
                    send = a.this.mode == 2 ? Client.Java2C.send(a.this.jrn, a.this.jro, bArr2) : 0;
                }
                b.rz(bo.cc(bArr2));
                ab.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", Integer.valueOf(send), Integer.valueOf(i2), Integer.valueOf(bo.cc(bArr2)), Long.valueOf(bo.gb(anU)), Long.valueOf(bo.gb(anU)));
                AppMethodBeat.o(17156);
            }
        });
        AppMethodBeat.o(17161);
    }

    public final int j(int i, byte[] bArr) {
        int send;
        AppMethodBeat.i(17162);
        long anU = bo.anU();
        if (this.mode == 1) {
            send = Java2C.send(this.jrn, this.jro, bArr);
        } else if (this.mode == 2) {
            send = Client.Java2C.send(this.jrn, this.jro, bArr);
            b.rz(bo.cc(bArr));
        } else {
            send = 0;
        }
        ab.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(bo.cc(bArr)), Long.valueOf(bo.gb(anU)));
        AppMethodBeat.o(17162);
        return send;
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(17163);
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17157);
                b.b(z2, i3, i4, bArr2);
                AppMethodBeat.o(17157);
            }
        });
        AppMethodBeat.o(17163);
    }
}
