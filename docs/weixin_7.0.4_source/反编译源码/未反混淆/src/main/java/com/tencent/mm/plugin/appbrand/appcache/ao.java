package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

public final class ao implements Closeable {
    public static final ByteOrder gUb = ByteOrder.BIG_ENDIAN;
    private volatile int cD;
    public final File gUc;
    private volatile FileChannel gUd;
    public volatile boolean gUe;
    private volatile int gUf;
    private volatile int gUg;
    private volatile int gUh;
    public volatile Map<String, a> gUi;
    public volatile k gUj;

    public static class a {
        public final String fileName;
        public final String gUk;
        public final int gUl;
        public final int gUm;

        public a(String str, String str2, int i, int i2) {
            this.gUk = str;
            this.fileName = str2;
            this.gUl = i;
            this.gUm = i2;
        }
    }

    public ao(File file) {
        int i;
        boolean z = true;
        AppMethodBeat.i(105316);
        this.gUd = null;
        this.gUe = true;
        this.cD = -1;
        this.gUf = 0;
        this.gUg = 0;
        this.gUh = -1;
        this.gUi = null;
        this.gUc = file;
        if (this.gUc == null || !this.gUc.exists()) {
            i = 0;
        } else if (this.gUc.length() <= 14) {
            i = 0;
        } else {
            boolean i2 = true;
        }
        if (i2 == 0 || !avX()) {
            z = false;
        }
        this.gUe = z;
        AppMethodBeat.o(105316);
    }

    public ao(String str) {
        this(new File(str));
        AppMethodBeat.i(105317);
        AppMethodBeat.o(105317);
    }

    public final void close() {
        AppMethodBeat.i(105318);
        if (this.gUd != null) {
            try {
                this.gUd.close();
                this.gUd = null;
                AppMethodBeat.o(105318);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(105318);
    }

    public final a xx(String str) {
        int i = 0;
        AppMethodBeat.i(105319);
        if (this.gUi == null || bo.isNullOrNil(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.gUi == null);
            if (this.gUi != null) {
                i = this.gUi.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(105319);
            return null;
        }
        a aVar = (a) this.gUi.get(l.yk(str));
        AppMethodBeat.o(105319);
        return aVar;
    }

    public final InputStream xy(String str) {
        AppMethodBeat.i(105320);
        a xx = xx(str);
        InputStream a;
        if (xx == null) {
            AppMethodBeat.o(105320);
            return null;
        } else if (Thread.currentThread().isInterrupted()) {
            a = a(xx);
            AppMethodBeat.o(105320);
            return a;
        } else {
            try {
                MappedByteBuffer map = this.gUd.map(MapMode.READ_ONLY, (long) xx.gUl, (long) xx.gUm);
                map.order(gUb);
                map.limit(xx.gUm);
                a = new com.tencent.luggage.g.a(map);
                AppMethodBeat.o(105320);
                return a;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", str, Integer.valueOf(xx.gUl), Integer.valueOf(xx.gUm), bo.l(e));
                AppMethodBeat.o(105320);
                return null;
            }
        }
    }

    private InputStream a(a aVar) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(105321);
        Closeable randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(this.gUc, "r");
            try {
                byte[] bArr = new byte[aVar.gUm];
                randomAccessFile.seek((long) aVar.gUl);
                randomAccessFile.readFully(bArr);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                bo.b(randomAccessFile);
                AppMethodBeat.o(105321);
                return byteArrayInputStream;
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.gUc.getPath(), aVar.fileName, e);
                    bo.b(randomAccessFile);
                    AppMethodBeat.o(105321);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(randomAccessFile);
                    AppMethodBeat.o(105321);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            ab.e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.gUc.getPath(), aVar.fileName, e);
            bo.b(randomAccessFile);
            AppMethodBeat.o(105321);
            return null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            bo.b(randomAccessFile);
            AppMethodBeat.o(105321);
            throw th;
        }
    }

    private static int C(byte[] bArr, int i) {
        AppMethodBeat.i(105324);
        if (bArr == null) {
            AppMethodBeat.o(105324);
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i2 = wrap.getInt();
        AppMethodBeat.o(105324);
        return i2;
    }

    public final boolean avW() {
        AppMethodBeat.i(105322);
        if (!this.gUe || this.gUd == null || this.gUf <= 4) {
            ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", Boolean.valueOf(this.gUe), this.gUd, Integer.valueOf(this.gUg));
            AppMethodBeat.o(105322);
            return false;
        } else if (this.gUi == null || this.gUh < 0 || this.gUh != this.gUi.size()) {
            try {
                this.gUd.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.gUf);
                allocate.order(gUb);
                this.gUd.read(allocate);
                byte[] array = allocate.array();
                this.gUh = C(array, 0);
                android.support.v4.f.a aVar = new android.support.v4.f.a();
                a aVar2 = null;
                int i = 4;
                for (int i2 = 0; i2 < this.gUh; i2++) {
                    int C = C(array, i);
                    i += 4;
                    String str = new String(array, i, C);
                    i += C;
                    int C2 = C(array, i);
                    i += 4;
                    int C3 = C(array, i);
                    i += 4;
                    aVar2 = new a(this.gUc.getAbsolutePath(), str, C2, C3);
                    aVar.put(str, aVar2);
                }
                this.gUi = aVar;
                if (aVar2 == null || ((long) (aVar2.gUl + aVar2.gUm)) <= this.gUc.length()) {
                    AppMethodBeat.o(105322);
                    return true;
                }
                ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", Integer.valueOf(aVar2.gUl), Integer.valueOf(aVar2.gUm), Long.valueOf(this.gUc.length()));
                AppMethodBeat.o(105322);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", bo.l(e));
                AppMethodBeat.o(105322);
                return false;
            }
        } else {
            AppMethodBeat.o(105322);
            return true;
        }
    }

    private boolean avX() {
        AppMethodBeat.i(105323);
        if (this.gUd == null) {
            try {
                this.gUd = new RandomAccessFile(this.gUc, "r").getChannel();
            } catch (FileNotFoundException e) {
                ab.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", bo.l(e));
            }
        }
        if (this.gUd == null) {
            AppMethodBeat.o(105323);
            return false;
        }
        try {
            this.gUd.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(gUb);
            this.gUd.read(allocate);
            if ((byte) -66 == allocate.get(0) && (byte) -19 == allocate.get(13)) {
                byte[] array = allocate.array();
                this.cD = C(array, 1);
                this.gUf = C(array, 5);
                this.gUg = C(array, 9);
                AppMethodBeat.o(105323);
                return true;
            }
            AppMethodBeat.o(105323);
            return false;
        } catch (IOException e2) {
            ab.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", bo.l(e2));
        }
    }
}
