package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel.C11113b;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19975a;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b */
public final class C45738b implements C19975a {
    public static final byte[] jrm = "GSMW".getBytes();
    private Socket iSP = null;
    private Boolean jyZ = Boolean.FALSE;
    private ServerSocket jza = null;
    private C7306ak jzb = null;
    private C7306ak jzc = new C7306ak(Looper.getMainLooper());
    private DataOutputStream jzd = null;
    private int jze = 0;
    private int jzf = 0;
    private long jzg = 0;
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b$5 */
    class C111145 implements Runnable {
        C111145() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17811);
            Looper.prepare();
            C45738b.this.jzb = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(17811);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m84522c(C45738b c45738b) {
        AppMethodBeat.m2504i(17824);
        c45738b.aUG();
        AppMethodBeat.m2505o(17824);
    }

    static {
        AppMethodBeat.m2504i(17825);
        AppMethodBeat.m2505o(17825);
    }

    public C45738b() {
        AppMethodBeat.m2504i(17812);
        aUH();
        AppMethodBeat.m2505o(17812);
    }

    /* renamed from: e */
    public final void mo73538e(final int i, final List<C7284ua> list) {
        AppMethodBeat.m2504i(17813);
        C4990ab.m7417i("MicroMsg.BakOldJavaEngine", "connect type:%d", Integer.valueOf(i));
        aUH();
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17807);
                switch (i) {
                    case 0:
                        C45738b.m84516a(C45738b.this, ((Integer) ((C7284ua) list.get(0)).wbp.getFirst()).intValue());
                        break;
                    case 1:
                        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo == null) {
                            AppMethodBeat.m2505o(17807);
                            return;
                        }
                        int i = dhcpInfo.netmask;
                        String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                        C4990ab.m7413e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                        String str2 = null;
                        int i2 = 0;
                        for (C7284ua c7284ua : list) {
                            C4990ab.m7417i("MicroMsg.BakOldJavaEngine", "try ip:%s", c7284ua.vYA);
                            if (c7284ua.vYA != null) {
                                if (c7284ua.vYA.split("\\.").length >= 4) {
                                    int A = C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(c7284ua.vYA.split("\\.")[0], 0) & 255), (byte) (C5046bo.getInt(c7284ua.vYA.split("\\.")[1], 0) & 255), (byte) (C5046bo.getInt(c7284ua.vYA.split("\\.")[2], 0) & 255), (byte) (C5046bo.getInt(c7284ua.vYA.split("\\.")[3], 0) & 255)});
                                    if ((i & A) == (i & ipAddress)) {
                                        C45738b.m84518a(C45738b.this, c7284ua.vYA, ((Integer) c7284ua.wbp.getFirst()).intValue());
                                        AppMethodBeat.m2505o(17807);
                                        return;
                                    }
                                    int intValue;
                                    if ((A & CdnLogic.kBizGeneric) == (CdnLogic.kBizGeneric & ipAddress)) {
                                        String str3 = c7284ua.vYA;
                                        intValue = ((Integer) c7284ua.wbp.getFirst()).intValue();
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
                            C4990ab.m7421w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                            C45738b.m84518a(C45738b.this, str2, i2);
                            AppMethodBeat.m2505o(17807);
                            return;
                        }
                        C45738b.m84517a(C45738b.this, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                        C4990ab.m7413e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                        AppMethodBeat.m2505o(17807);
                        return;
                }
                AppMethodBeat.m2505o(17807);
            }
        }, "BackupJavaEngine_connect");
        AppMethodBeat.m2505o(17813);
    }

    public final void aUF() {
        AppMethodBeat.m2504i(17814);
        C4990ab.m7416i("MicroMsg.BakOldJavaEngine", "close connect");
        aUG();
        m84520a(true, 0, 10003, null);
        AppMethodBeat.m2505o(17814);
    }

    private void aUG() {
        AppMethodBeat.m2504i(17815);
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
                AppMethodBeat.m2505o(17815);
            }
        }
        try {
            if (this.iSP != null) {
                this.iSP.close();
            }
            AppMethodBeat.m2505o(17815);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(17815);
        }
    }

    /* renamed from: a */
    private void m84520a(boolean z, int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(17816);
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        this.jzc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17808);
                C19978b.m30887b(z2, i3, i4, bArr2);
                AppMethodBeat.m2505o(17808);
            }
        });
        AppMethodBeat.m2505o(17816);
    }

    /* renamed from: i */
    public final void mo35222i(final int i, final byte[] bArr) {
        AppMethodBeat.m2504i(17817);
        if (this.jzb != null) {
            mo73537aq(bArr);
            AppMethodBeat.m2505o(17817);
            return;
        }
        this.jzc.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17809);
                C45738b.this.mo73537aq(bArr);
                AppMethodBeat.m2505o(17809);
            }
        }, 200);
        AppMethodBeat.m2505o(17817);
    }

    /* renamed from: j */
    public final int mo35223j(int i, byte[] bArr) {
        return 0;
    }

    /* renamed from: aq */
    public final void mo73537aq(final byte[] bArr) {
        AppMethodBeat.m2504i(17818);
        if (this.jyZ.booleanValue()) {
            C4990ab.m7412e("MicroMsg.BakOldJavaEngine", "engine has stop");
            AppMethodBeat.m2505o(17818);
            return;
        }
        this.jzb.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17810);
                int e;
                try {
                    synchronized (C45738b.this.lock) {
                        C45738b.this.jzd.write(bArr);
                        e = C45738b.this.jzd;
                        e.flush();
                    }
                    AppMethodBeat.m2505o(e);
                } catch (Exception e2) {
                    e = e2;
                    String str = "MicroMsg.BakOldJavaEngine";
                    String str2 = "send_error %s";
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(17810);
                }
            }
        });
        AppMethodBeat.m2505o(17818);
    }

    private void aUH() {
        AppMethodBeat.m2504i(17819);
        if (this.jzb == null || !this.jzb.getLooper().getThread().isAlive()) {
            C7305d.m12301h(new C111145(), "BackupJavaEngine_handler").start();
        }
        AppMethodBeat.m2505o(17819);
    }

    /* renamed from: a */
    private void m84519a(DataInputStream dataInputStream) {
        String format;
        AppMethodBeat.m2504i(17820);
        while (!this.jyZ.booleanValue() && this.jze != 4) {
            try {
                if (jrm[this.jze] == dataInputStream.readByte()) {
                    this.jze++;
                } else {
                    Object obj;
                    long anT = C5046bo.anT();
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
                        C4990ab.m7412e("MicroMsg.BakOldJavaEngine", format);
                        m84520a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                    }
                    this.jze = 0;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BakOldJavaEngine", "loopRead %s", e);
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.jyZ.booleanValue()) {
                    m84520a(true, 0, 10006, "read_error ".concat(String.valueOf(e)).getBytes());
                }
                aUG();
                AppMethodBeat.m2505o(17820);
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
            C4990ab.m7412e("MicroMsg.BakOldJavaEngine", format);
            this.jyZ = Boolean.TRUE;
            m84520a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
            AppMethodBeat.m2505o(17820);
            return;
        }
        int readInt3 = dataInputStream.readInt();
        C4990ab.m7416i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(readInt2)));
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
            C4990ab.m7412e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -1;
        } else if (C19978b.aSx() != 1 || readInt3 == C11113b.m18826a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = C1182l.m2607c(bArr, C38634d.aSy());
            }
            pByteArray.value = bArr;
            i = 0;
        } else {
            new CRC32().update(bArr);
            String ap = C11113b.m18827ap(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), ap});
            C4990ab.m7412e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -2;
        }
        C4990ab.m7411d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", Integer.valueOf(i));
        if (i != 0) {
            m84520a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            AppMethodBeat.m2505o(17820);
            return;
        }
        C4990ab.m7411d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", Integer.valueOf(i), Integer.valueOf(readInt), Short.valueOf(readShort2));
        m84520a(false, readInt, readShort2, pByteArray.value);
        AppMethodBeat.m2505o(17820);
    }
}
