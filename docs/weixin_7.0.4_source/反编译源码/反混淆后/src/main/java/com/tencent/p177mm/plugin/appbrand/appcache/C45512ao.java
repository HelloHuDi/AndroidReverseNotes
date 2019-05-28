package com.tencent.p177mm.plugin.appbrand.appcache;

import android.support.p057v4.p065f.C6197a;
import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42366k;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ao */
public final class C45512ao implements Closeable {
    public static final ByteOrder gUb = ByteOrder.BIG_ENDIAN;
    /* renamed from: cD */
    private volatile int f17881cD;
    public final File gUc;
    private volatile FileChannel gUd;
    public volatile boolean gUe;
    private volatile int gUf;
    private volatile int gUg;
    private volatile int gUh;
    public volatile Map<String, C26739a> gUi;
    public volatile C42366k gUj;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ao$a */
    public static class C26739a {
        public final String fileName;
        public final String gUk;
        public final int gUl;
        public final int gUm;

        public C26739a(String str, String str2, int i, int i2) {
            this.gUk = str;
            this.fileName = str2;
            this.gUl = i;
            this.gUm = i2;
        }
    }

    public C45512ao(File file) {
        int i;
        boolean z = true;
        AppMethodBeat.m2504i(105316);
        this.gUd = null;
        this.gUe = true;
        this.f17881cD = -1;
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
        AppMethodBeat.m2505o(105316);
    }

    public C45512ao(String str) {
        this(new File(str));
        AppMethodBeat.m2504i(105317);
        AppMethodBeat.m2505o(105317);
    }

    public final void close() {
        AppMethodBeat.m2504i(105318);
        if (this.gUd != null) {
            try {
                this.gUd.close();
                this.gUd = null;
                AppMethodBeat.m2505o(105318);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(105318);
    }

    /* renamed from: xx */
    public final C26739a mo73323xx(String str) {
        int i = 0;
        AppMethodBeat.m2504i(105319);
        if (this.gUi == null || C5046bo.isNullOrNil(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.gUi == null);
            if (this.gUi != null) {
                i = this.gUi.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(105319);
            return null;
        }
        C26739a c26739a = (C26739a) this.gUi.get(C42367l.m74946yk(str));
        AppMethodBeat.m2505o(105319);
        return c26739a;
    }

    /* renamed from: xy */
    public final InputStream mo73324xy(String str) {
        AppMethodBeat.m2504i(105320);
        C26739a xx = mo73323xx(str);
        InputStream a;
        if (xx == null) {
            AppMethodBeat.m2505o(105320);
            return null;
        } else if (Thread.currentThread().isInterrupted()) {
            a = m83909a(xx);
            AppMethodBeat.m2505o(105320);
            return a;
        } else {
            try {
                MappedByteBuffer map = this.gUd.map(MapMode.READ_ONLY, (long) xx.gUl, (long) xx.gUm);
                map.order(gUb);
                map.limit(xx.gUm);
                a = new C37399a(map);
                AppMethodBeat.m2505o(105320);
                return a;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", str, Integer.valueOf(xx.gUl), Integer.valueOf(xx.gUm), C5046bo.m7574l(e));
                AppMethodBeat.m2505o(105320);
                return null;
            }
        }
    }

    /* renamed from: a */
    private InputStream m83909a(C26739a c26739a) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(105321);
        Closeable randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(this.gUc, "r");
            try {
                byte[] bArr = new byte[c26739a.gUm];
                randomAccessFile.seek((long) c26739a.gUl);
                randomAccessFile.readFully(bArr);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                C5046bo.m7527b(randomAccessFile);
                AppMethodBeat.m2505o(105321);
                return byteArrayInputStream;
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.gUc.getPath(), c26739a.fileName, e);
                    C5046bo.m7527b(randomAccessFile);
                    AppMethodBeat.m2505o(105321);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(randomAccessFile);
                    AppMethodBeat.m2505o(105321);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.gUc.getPath(), c26739a.fileName, e);
            C5046bo.m7527b(randomAccessFile);
            AppMethodBeat.m2505o(105321);
            return null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            C5046bo.m7527b(randomAccessFile);
            AppMethodBeat.m2505o(105321);
            throw th;
        }
    }

    /* renamed from: C */
    private static int m83908C(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105324);
        if (bArr == null) {
            AppMethodBeat.m2505o(105324);
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i2 = wrap.getInt();
        AppMethodBeat.m2505o(105324);
        return i2;
    }

    public final boolean avW() {
        AppMethodBeat.m2504i(105322);
        if (!this.gUe || this.gUd == null || this.gUf <= 4) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", Boolean.valueOf(this.gUe), this.gUd, Integer.valueOf(this.gUg));
            AppMethodBeat.m2505o(105322);
            return false;
        } else if (this.gUi == null || this.gUh < 0 || this.gUh != this.gUi.size()) {
            try {
                this.gUd.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.gUf);
                allocate.order(gUb);
                this.gUd.read(allocate);
                byte[] array = allocate.array();
                this.gUh = C45512ao.m83908C(array, 0);
                C6197a c6197a = new C6197a();
                C26739a c26739a = null;
                int i = 4;
                for (int i2 = 0; i2 < this.gUh; i2++) {
                    int C = C45512ao.m83908C(array, i);
                    i += 4;
                    String str = new String(array, i, C);
                    i += C;
                    int C2 = C45512ao.m83908C(array, i);
                    i += 4;
                    int C3 = C45512ao.m83908C(array, i);
                    i += 4;
                    c26739a = new C26739a(this.gUc.getAbsolutePath(), str, C2, C3);
                    c6197a.put(str, c26739a);
                }
                this.gUi = c6197a;
                if (c26739a == null || ((long) (c26739a.gUl + c26739a.gUm)) <= this.gUc.length()) {
                    AppMethodBeat.m2505o(105322);
                    return true;
                }
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", Integer.valueOf(c26739a.gUl), Integer.valueOf(c26739a.gUm), Long.valueOf(this.gUc.length()));
                AppMethodBeat.m2505o(105322);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(105322);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(105322);
            return true;
        }
    }

    private boolean avX() {
        AppMethodBeat.m2504i(105323);
        if (this.gUd == null) {
            try {
                this.gUd = new RandomAccessFile(this.gUc, "r").getChannel();
            } catch (FileNotFoundException e) {
                C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", C5046bo.m7574l(e));
            }
        }
        if (this.gUd == null) {
            AppMethodBeat.m2505o(105323);
            return false;
        }
        try {
            this.gUd.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(gUb);
            this.gUd.read(allocate);
            if ((byte) -66 == allocate.get(0) && (byte) -19 == allocate.get(13)) {
                byte[] array = allocate.array();
                this.f17881cD = C45512ao.m83908C(array, 1);
                this.gUf = C45512ao.m83908C(array, 5);
                this.gUg = C45512ao.m83908C(array, 9);
                AppMethodBeat.m2505o(105323);
                return true;
            }
            AppMethodBeat.m2505o(105323);
            return false;
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", C5046bo.m7574l(e2));
        }
    }
}
