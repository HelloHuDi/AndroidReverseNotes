package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements a {
    public static final byte[] jrm = "GSMW".getBytes();
    private Socket iSP = null;
    private Boolean jyZ = Boolean.FALSE;
    private ServerSocket jza = null;
    private ak jzb = null;
    private ak jzc = new ak(Looper.getMainLooper());
    private DataOutputStream jzd = null;
    private int jze = 0;
    private int jzf = 0;
    private long jzg = 0;
    private Object lock = new Object();

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(17824);
        bVar.aUG();
        AppMethodBeat.o(17824);
    }

    static {
        AppMethodBeat.i(17825);
        AppMethodBeat.o(17825);
    }

    public b() {
        AppMethodBeat.i(17812);
        aUH();
        AppMethodBeat.o(17812);
    }

    public final void e(final int i, final List<ua> list) {
        AppMethodBeat.i(17813);
        ab.i("MicroMsg.BakOldJavaEngine", "connect type:%d", Integer.valueOf(i));
        aUH();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17807);
                switch (i) {
                    case 0:
                        b.a(b.this, ((Integer) ((ua) list.get(0)).wbp.getFirst()).intValue());
                        break;
                    case 1:
                        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo == null) {
                            AppMethodBeat.o(17807);
                            return;
                        }
                        int i = dhcpInfo.netmask;
                        String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                        ab.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                        String str2 = null;
                        int i2 = 0;
                        for (ua uaVar : list) {
                            ab.i("MicroMsg.BakOldJavaEngine", "try ip:%s", uaVar.vYA);
                            if (uaVar.vYA != null) {
                                if (uaVar.vYA.split("\\.").length >= 4) {
                                    int A = o.A(new byte[]{(byte) (bo.getInt(uaVar.vYA.split("\\.")[0], 0) & 255), (byte) (bo.getInt(uaVar.vYA.split("\\.")[1], 0) & 255), (byte) (bo.getInt(uaVar.vYA.split("\\.")[2], 0) & 255), (byte) (bo.getInt(uaVar.vYA.split("\\.")[3], 0) & 255)});
                                    if ((i & A) == (i & ipAddress)) {
                                        b.a(b.this, uaVar.vYA, ((Integer) uaVar.wbp.getFirst()).intValue());
                                        AppMethodBeat.o(17807);
                                        return;
                                    }
                                    int intValue;
                                    if ((A & CdnLogic.kBizGeneric) == (CdnLogic.kBizGeneric & ipAddress)) {
                                        String str3 = uaVar.vYA;
                                        intValue = ((Integer) uaVar.wbp.getFirst()).intValue();
                                        str2 = str3;
                                    } else {
                                        intValue = i2;
                                    }
                                    i2 = intValue;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (str2 != null) {
                            ab.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                            b.a(b.this, str2, i2);
                            AppMethodBeat.o(17807);
                            return;
                        }
                        b.a(b.this, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                        ab.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                        AppMethodBeat.o(17807);
                        return;
                }
                AppMethodBeat.o(17807);
            }
        }, "BackupJavaEngine_connect");
        AppMethodBeat.o(17813);
    }

    public final void aUF() {
        AppMethodBeat.i(17814);
        ab.i("MicroMsg.BakOldJavaEngine", "close connect");
        aUG();
        a(true, 0, 10003, null);
        AppMethodBeat.o(17814);
    }

    private void aUG() {
        AppMethodBeat.i(17815);
        this.jze = 0;
        this.jzf = 0;
        this.jzg = 0;
        this.jyZ = Boolean.TRUE;
        try {
            synchronized (this.lock) {
                if (this.jzd != null) {
                    this.jzd.close();
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(17815);
            }
        }
        try {
            if (this.iSP != null) {
                this.iSP.close();
            }
            AppMethodBeat.o(17815);
        } catch (Exception e2) {
            AppMethodBeat.o(17815);
        }
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(17816);
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        this.jzc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17808);
                com.tencent.mm.plugin.backup.g.b.b(z2, i3, i4, bArr2);
                AppMethodBeat.o(17808);
            }
        });
        AppMethodBeat.o(17816);
    }

    public final void i(final int i, final byte[] bArr) {
        AppMethodBeat.i(17817);
        if (this.jzb != null) {
            aq(bArr);
            AppMethodBeat.o(17817);
            return;
        }
        this.jzc.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17809);
                b.this.aq(bArr);
                AppMethodBeat.o(17809);
            }
        }, 200);
        AppMethodBeat.o(17817);
    }

    public final int j(int i, byte[] bArr) {
        return 0;
    }

    public final void aq(final byte[] bArr) {
        AppMethodBeat.i(17818);
        if (this.jyZ.booleanValue()) {
            ab.e("MicroMsg.BakOldJavaEngine", "engine has stop");
            AppMethodBeat.o(17818);
            return;
        }
        this.jzb.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17810);
                int e;
                try {
                    synchronized (b.this.lock) {
                        b.this.jzd.write(bArr);
                        e = b.this.jzd;
                        e.flush();
                    }
                    AppMethodBeat.o(e);
                } catch (Exception e2) {
                    e = e2;
                    String str = "MicroMsg.BakOldJavaEngine";
                    String str2 = "send_error %s";
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(17810);
                }
            }
        });
        AppMethodBeat.o(17818);
    }

    private void aUH() {
        AppMethodBeat.i(17819);
        if (this.jzb == null || !this.jzb.getLooper().getThread().isAlive()) {
            d.h(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17811);
                    Looper.prepare();
                    b.this.jzb = new ak();
                    Looper.loop();
                    AppMethodBeat.o(17811);
                }
            }, "BackupJavaEngine_handler").start();
        }
        AppMethodBeat.o(17819);
    }

    private void a(DataInputStream dataInputStream) {
        String format;
        AppMethodBeat.i(17820);
        while (!this.jyZ.booleanValue() && this.jze != 4) {
            try {
                if (jrm[this.jze] == dataInputStream.readByte()) {
                    this.jze++;
                } else {
                    Object obj;
                    long anT = bo.anT();
                    if (((long) this.jzf) - (anT - this.jzg) < 10) {
                        if (this.jzf < 0) {
                            this.jzf = 0;
                        }
                        this.jzf++;
                        this.jzg = anT;
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.jze + 1), Integer.valueOf(jrm[this.jze] & 255), Integer.valueOf(r1 & 255)});
                        ab.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                    }
                    this.jze = 0;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.BakOldJavaEngine", "loopRead %s", e);
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.jyZ.booleanValue()) {
                    a(true, 0, 10006, "read_error ".concat(String.valueOf(e)).getBytes());
                }
                aUG();
                AppMethodBeat.o(17820);
                return;
            }
        }
        this.jze = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            ab.e("MicroMsg.BakOldJavaEngine", format);
            this.jyZ = Boolean.TRUE;
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
            AppMethodBeat.o(17820);
            return;
        }
        int readInt3 = dataInputStream.readInt();
        ab.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(readInt2)));
        byte[] bArr = new byte[(readInt2 - 20)];
        int i = 0;
        while (i < bArr.length) {
            int read = dataInputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = jrm;
        if (readShort != (short) 1) {
            format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
            ab.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -1;
        } else if (com.tencent.mm.plugin.backup.g.b.aSx() != 1 || readInt3 == com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = l.c(bArr, com.tencent.mm.plugin.backup.b.d.aSy());
            }
            pByteArray.value = bArr;
            i = 0;
        } else {
            new CRC32().update(bArr);
            String ap = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.ap(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), ap});
            ab.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -2;
        }
        ab.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", Integer.valueOf(i));
        if (i != 0) {
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            AppMethodBeat.o(17820);
            return;
        }
        ab.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", Integer.valueOf(i), Integer.valueOf(readInt), Short.valueOf(readShort2));
        a(false, readInt, readShort2, pByteArray.value);
        AppMethodBeat.o(17820);
    }
}
