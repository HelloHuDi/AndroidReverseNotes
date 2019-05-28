package com.tencent.mm.plugin.secinforeport;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.Normsg;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.sdk.platformtools.ab;
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

enum c implements com.tencent.mm.plugin.secinforeport.a.c {
    ;

    static final class a {
        private static final Map<Integer, Long> qjl = null;

        static {
            AppMethodBeat.i(57493);
            qjl = new HashMap();
            AppMethodBeat.o(57493);
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00c2 A:{Catch:{ Exception -> 0x00b2 }} */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A:{SYNTHETIC, Splitter:B:17:0x0052} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A:{SYNTHETIC, Splitter:B:31:0x0078} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void sg() {
            Exception e;
            Throwable th;
            synchronized (a.class) {
                AppMethodBeat.i(57490);
                DataInputStream dataInputStream;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File(g.RP().cachePath, b.oTO.TQ("!#?'8/f((6(1$\u001f2*>(s826"))));
                    try {
                        IllegalStateException illegalStateException;
                        if (dataInputStream.readShort() != (short) -774) {
                            illegalStateException = new IllegalStateException("bad magic.");
                            AppMethodBeat.o(57490);
                            throw illegalStateException;
                        }
                        dataInputStream.readShort();
                        int readInt = dataInputStream.readInt();
                        if (readInt < 0) {
                            illegalStateException = new IllegalStateException("bad pair count.");
                            AppMethodBeat.o(57490);
                            throw illegalStateException;
                        }
                        for (int i = 0; i < readInt; i++) {
                            qjl.put(Integer.valueOf(dataInputStream.readInt()), Long.valueOf(dataInputStream.readLong()));
                        }
                        ab.i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                        try {
                            dataInputStream.close();
                            AppMethodBeat.o(57490);
                        } catch (Exception e2) {
                            AppMethodBeat.o(57490);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            ab.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", e);
                            if (dataInputStream == null) {
                                try {
                                    dataInputStream.close();
                                    AppMethodBeat.o(57490);
                                } catch (Exception e4) {
                                    AppMethodBeat.o(57490);
                                }
                            } else {
                                AppMethodBeat.o(57490);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            AppMethodBeat.o(57490);
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    dataInputStream = null;
                    ab.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", e);
                    if (dataInputStream == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataInputStream != null) {
                    }
                    AppMethodBeat.o(57490);
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
            synchronized (a.class) {
                AppMethodBeat.i(57491);
                File file = new File(g.RP().cachePath, b.oTO.TQ("!#?'8/f((6(1$\u001f2*>(s826"));
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
                        ab.i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                        try {
                            dataOutputStream2.close();
                            AppMethodBeat.o(57491);
                        } catch (Exception e) {
                            AppMethodBeat.o(57491);
                        }
                    } catch (Exception e2) {
                        dataOutputStream = dataOutputStream2;
                        try {
                            ab.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                            if (dataOutputStream == null) {
                                try {
                                    dataOutputStream.close();
                                    AppMethodBeat.o(57491);
                                } catch (Exception e3) {
                                    AppMethodBeat.o(57491);
                                }
                            } else {
                                AppMethodBeat.o(57491);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                            }
                            AppMethodBeat.o(57491);
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
                        AppMethodBeat.o(57491);
                        throw th;
                    }
                } catch (Exception e5) {
                    ab.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                    if (dataOutputStream == null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataOutputStream2 = null;
                    if (dataOutputStream2 != null) {
                    }
                    AppMethodBeat.o(57491);
                    throw th;
                }
            }
        }

        static synchronized boolean Y(int i, long j) {
            boolean z;
            synchronized (a.class) {
                AppMethodBeat.i(57492);
                if (j < 0) {
                    ab.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", Long.valueOf(j));
                    AppMethodBeat.o(57492);
                    z = false;
                } else {
                    if (!qjl.containsKey(Integer.valueOf(i))) {
                        sg();
                    }
                    Long l = (Long) qjl.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null || currentTimeMillis < l.longValue()) {
                        qjl.put(Integer.valueOf(i), Long.valueOf(0));
                        save();
                        AppMethodBeat.o(57492);
                        z = false;
                    } else if (currentTimeMillis - l.longValue() > j) {
                        qjl.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                        save();
                        AppMethodBeat.o(57492);
                        z = true;
                    } else {
                        AppMethodBeat.o(57492);
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private c(String str) {
    }

    static {
        AppMethodBeat.o(57501);
    }

    public final boolean Y(int i, long j) {
        AppMethodBeat.i(57496);
        boolean Y = a.Y(i, j);
        AppMethodBeat.o(57496);
        return Y;
    }

    public final void ff(int i, int i2) {
        AppMethodBeat.i(57497);
        byte[] Aj = Normsg.b.Aj(i2);
        if (Aj != null) {
            o(i, Aj);
        }
        AppMethodBeat.o(57497);
    }

    public final void Ch(int i) {
        AppMethodBeat.i(57498);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display>");
        if (i == -2147483646) {
            stringBuilder.append("<FingerPrint>").append(Build.FINGERPRINT).append("</FingerPrint><NDM>").append(cip()).append("</NDM>");
        }
        stringBuilder.append("</st>");
        ab.d("MicroMsg.SecInfoReporterImpl", "report msg:\n" + stringBuilder.toString());
        o(i, stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
        AppMethodBeat.o(57498);
    }

    private static String cip() {
        AppMethodBeat.i(57499);
        byte[] bArr = null;
        try {
            byte[] bytes = b.oTO.jE(false).getBytes();
            int length = bytes.length;
            if (bytes == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataIn is null.");
                AppMethodBeat.o(57499);
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
            ab.d("MicroMsg.SecInfoReporterImpl", "Base64 length = " + bArr.length + "\n content = " + Arrays.toString(bArr));
            String str = bArr == null ? "" : new String(bArr);
            if (str.length() > 5120) {
                h.pYm.a(633, 4, 1, false);
                ab.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + str.length());
            }
            AppMethodBeat.o(57499);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SecInfoReporterImpl", e, "exception when compressing dump maps", new Object[0]);
        }
    }

    public final void o(final int i, byte[] bArr) {
        AppMethodBeat.i(57500);
        if (bArr == null) {
            ab.e("MicroMsg.SecInfoReporterImpl", "data is null.");
            AppMethodBeat.o(57500);
            return;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.uri = b.oTO.TQ("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.fsI = 771;
        aVar.fsJ = new brp();
        aVar.fsK = new brq();
        com.tencent.mm.ai.b acD = aVar.acD();
        brp brp = (brp) acD.fsG.fsP;
        brp.wTQ = i;
        brp.wTP = new com.tencent.mm.bt.b(bArr);
        e.pXa.a(416, 0, 1, false);
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(57489);
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", Integer.valueOf(i));
                    e.pXa.a(416, 1, 1, false);
                } else {
                    ab.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2), str);
                    e.pXa.a(416, 2, 1, false);
                }
                AppMethodBeat.o(57489);
                return 0;
            }
        }, false);
        AppMethodBeat.o(57500);
    }
}
