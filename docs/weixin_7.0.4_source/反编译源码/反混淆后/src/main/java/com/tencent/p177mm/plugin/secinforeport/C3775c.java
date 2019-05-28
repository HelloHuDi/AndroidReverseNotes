package com.tencent.p177mm.plugin.secinforeport;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.normsg.Normsg.C21379b;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C43500c;
import com.tencent.p177mm.protocal.protobuf.brp;
import com.tencent.p177mm.protocal.protobuf.brq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.Deflater;

/* renamed from: com.tencent.mm.plugin.secinforeport.c */
enum C3775c implements C43500c {
    ;

    /* renamed from: com.tencent.mm.plugin.secinforeport.c$a */
    static final class C3776a {
        private static final Map<Integer, Long> qjl = null;

        static {
            AppMethodBeat.m2504i(57493);
            qjl = new HashMap();
            AppMethodBeat.m2505o(57493);
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00c2 A:{Catch:{ Exception -> 0x00b2 }} */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A:{SYNTHETIC, Splitter:B:17:0x0052} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A:{SYNTHETIC, Splitter:B:31:0x0078} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: sg */
        private static synchronized void m6089sg() {
            Exception e;
            Throwable th;
            synchronized (C3776a.class) {
                AppMethodBeat.m2504i(57490);
                DataInputStream dataInputStream;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File(C1720g.m3536RP().cachePath, C6998b.oTO.mo8093TQ("!#?'8/f((6(1$\u001f2*>(s826"))));
                    try {
                        IllegalStateException illegalStateException;
                        if (dataInputStream.readShort() != (short) -774) {
                            illegalStateException = new IllegalStateException("bad magic.");
                            AppMethodBeat.m2505o(57490);
                            throw illegalStateException;
                        }
                        dataInputStream.readShort();
                        int readInt = dataInputStream.readInt();
                        if (readInt < 0) {
                            illegalStateException = new IllegalStateException("bad pair count.");
                            AppMethodBeat.m2505o(57490);
                            throw illegalStateException;
                        }
                        for (int i = 0; i < readInt; i++) {
                            qjl.put(Integer.valueOf(dataInputStream.readInt()), Long.valueOf(dataInputStream.readLong()));
                        }
                        C4990ab.m7416i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                        try {
                            dataInputStream.close();
                            AppMethodBeat.m2505o(57490);
                        } catch (Exception e2) {
                            AppMethodBeat.m2505o(57490);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C4990ab.m7413e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", e);
                            if (dataInputStream == null) {
                                try {
                                    dataInputStream.close();
                                    AppMethodBeat.m2505o(57490);
                                } catch (Exception e4) {
                                    AppMethodBeat.m2505o(57490);
                                }
                            } else {
                                AppMethodBeat.m2505o(57490);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            AppMethodBeat.m2505o(57490);
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    dataInputStream = null;
                    C4990ab.m7413e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", e);
                    if (dataInputStream == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataInputStream != null) {
                    }
                    AppMethodBeat.m2505o(57490);
                    throw th;
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba A:{SYNTHETIC, Splitter:B:48:0x00ba} */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00c4 A:{Catch:{ Exception -> 0x00a6 }} */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{SYNTHETIC, Splitter:B:22:0x0085} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba A:{SYNTHETIC, Splitter:B:48:0x00ba} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void save() {
            Throwable th;
            synchronized (C3776a.class) {
                AppMethodBeat.m2504i(57491);
                File file = new File(C1720g.m3536RP().cachePath, C6998b.oTO.mo8093TQ("!#?'8/f((6(1$\u001f2*>(s826"));
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                DataOutputStream dataOutputStream = null;
                DataOutputStream dataOutputStream2;
                try {
                    dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                    try {
                        dataOutputStream2.writeShort(-774);
                        dataOutputStream2.writeShort(1);
                        dataOutputStream2.writeInt(qjl.size());
                        for (Entry entry : qjl.entrySet()) {
                            dataOutputStream2.writeInt(((Integer) entry.getKey()).intValue());
                            dataOutputStream2.writeLong(((Long) entry.getValue()).longValue());
                        }
                        C4990ab.m7416i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                        try {
                            dataOutputStream2.close();
                            AppMethodBeat.m2505o(57491);
                        } catch (Exception e) {
                            AppMethodBeat.m2505o(57491);
                        }
                    } catch (Exception e2) {
                        dataOutputStream = dataOutputStream2;
                        try {
                            C4990ab.m7412e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                            if (dataOutputStream == null) {
                                try {
                                    dataOutputStream.close();
                                    AppMethodBeat.m2505o(57491);
                                } catch (Exception e3) {
                                    AppMethodBeat.m2505o(57491);
                                }
                            } else {
                                AppMethodBeat.m2505o(57491);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                            }
                            AppMethodBeat.m2505o(57491);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(57491);
                        throw th;
                    }
                } catch (Exception e5) {
                    C4990ab.m7412e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                    if (dataOutputStream == null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataOutputStream2 = null;
                    if (dataOutputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(57491);
                    throw th;
                }
            }
        }

        /* renamed from: Y */
        static synchronized boolean m6088Y(int i, long j) {
            boolean z;
            synchronized (C3776a.class) {
                AppMethodBeat.m2504i(57492);
                if (j < 0) {
                    C4990ab.m7421w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", Long.valueOf(j));
                    AppMethodBeat.m2505o(57492);
                    z = false;
                } else {
                    if (!qjl.containsKey(Integer.valueOf(i))) {
                        C3776a.m6089sg();
                    }
                    Long l = (Long) qjl.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null || currentTimeMillis < l.longValue()) {
                        qjl.put(Integer.valueOf(i), Long.valueOf(0));
                        C3776a.save();
                        AppMethodBeat.m2505o(57492);
                        z = false;
                    } else if (currentTimeMillis - l.longValue() > j) {
                        qjl.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                        C3776a.save();
                        AppMethodBeat.m2505o(57492);
                        z = true;
                    } else {
                        AppMethodBeat.m2505o(57492);
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private C3775c(String str) {
    }

    static {
        AppMethodBeat.m2505o(57501);
    }

    /* renamed from: Y */
    public final boolean mo8447Y(int i, long j) {
        AppMethodBeat.m2504i(57496);
        boolean Y = C3776a.m6088Y(i, j);
        AppMethodBeat.m2505o(57496);
        return Y;
    }

    /* renamed from: ff */
    public final void mo8448ff(int i, int i2) {
        AppMethodBeat.m2504i(57497);
        byte[] Aj = C21379b.m32780Aj(i2);
        if (Aj != null) {
            mo8449o(i, Aj);
        }
        AppMethodBeat.m2505o(57497);
    }

    /* renamed from: Ch */
    public final void mo8446Ch(int i) {
        AppMethodBeat.m2504i(57498);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display>");
        if (i == -2147483646) {
            stringBuilder.append("<FingerPrint>").append(Build.FINGERPRINT).append("</FingerPrint><NDM>").append(C3775c.cip()).append("</NDM>");
        }
        stringBuilder.append("</st>");
        C4990ab.m7410d("MicroMsg.SecInfoReporterImpl", "report msg:\n" + stringBuilder.toString());
        mo8449o(i, stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
        AppMethodBeat.m2505o(57498);
    }

    private static String cip() {
        AppMethodBeat.m2504i(57499);
        byte[] bArr = null;
        try {
            byte[] bytes = C6998b.oTO.mo8108jE(false).getBytes();
            int length = bytes.length;
            if (bytes == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataIn is null.");
                AppMethodBeat.m2505o(57499);
                throw illegalArgumentException;
            }
            Deflater deflater = new Deflater();
            deflater.setLevel(9);
            deflater.setInput(bytes, 0, length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            deflater.finish();
            byte[] bArr2 = new byte[4096];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            byteArrayOutputStream.close();
            bArr = Base64.encode(byteArrayOutputStream.toByteArray(), 2);
            C4990ab.m7410d("MicroMsg.SecInfoReporterImpl", "Base64 length = " + bArr.length + "\n content = " + Arrays.toString(bArr));
            String str = bArr == null ? "" : new String(bArr);
            if (str.length() > 5120) {
                C7060h.pYm.mo8378a(633, 4, 1, false);
                C4990ab.m7410d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + str.length());
            }
            AppMethodBeat.m2505o(57499);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SecInfoReporterImpl", e, "exception when compressing dump maps", new Object[0]);
        }
    }

    /* renamed from: o */
    public final void mo8449o(final int i, byte[] bArr) {
        AppMethodBeat.m2504i(57500);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.SecInfoReporterImpl", "data is null.");
            AppMethodBeat.m2505o(57500);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.uri = C6998b.oTO.mo8093TQ("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        c1196a.fsI = 771;
        c1196a.fsJ = new brp();
        c1196a.fsK = new brq();
        C7472b acD = c1196a.acD();
        brp brp = (brp) acD.fsG.fsP;
        brp.wTQ = i;
        brp.wTP = new C1332b(bArr);
        C7053e.pXa.mo8378a(416, 0, 1, false);
        C1226w.m2655a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(57489);
                if (i == 0 && i2 == 0) {
                    C4990ab.m7417i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", Integer.valueOf(i));
                    C7053e.pXa.mo8378a(416, 1, 1, false);
                } else {
                    C4990ab.m7421w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2), str);
                    C7053e.pXa.mo8378a(416, 2, 1, false);
                }
                AppMethodBeat.m2505o(57489);
                return 0;
            }
        }, false);
        AppMethodBeat.m2505o(57500);
    }
}
