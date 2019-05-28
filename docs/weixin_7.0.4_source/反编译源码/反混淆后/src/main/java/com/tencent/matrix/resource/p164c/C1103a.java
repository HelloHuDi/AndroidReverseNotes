package com.tencent.matrix.resource.p164c;

import com.facebook.internal.Utility;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;
import com.tencent.matrix.resource.p161a.p162a.C1093a;
import com.tencent.matrix.resource.p164c.p165a.C1100a;
import com.tencent.matrix.resource.p164c.p165a.C1101b;
import com.tencent.matrix.resource.p164c.p165a.C1102c;
import com.tencent.matrix.resource.p164c.p166b.C1111a;
import com.tencent.tinker.p676d.p677a.C5931f;
import com.tencent.tinker.p676d.p677a.C5934g;
import com.tencent.tinker.p676d.p677a.C5935h;
import com.tencent.tinker.p676d.p677a.C5936i;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.zip.CRC32;

/* renamed from: com.tencent.matrix.resource.c.a */
public final class C1103a {
    final Set<C1101b> bWY = new HashSet();
    final Map<C1101b, byte[]> bWZ = new HashMap();
    final Map<C1101b, C1101b> bXa = new HashMap();
    final Set<C1101b> bXb = new HashSet();
    C1101b bXc = null;
    C1101b bXd = null;
    C1101b bXe = null;
    C1101b bXf = null;
    C1101b bXg = null;
    C1101b bXh = null;
    C1101b bXi = null;
    int bXj = 0;
    C1101b bXk = null;
    C1100a[] bXl = null;
    C1100a[] bXm = null;

    /* renamed from: com.tencent.matrix.resource.c.a$a */
    public class C1104a extends C1114d {
        public C1104a(C6288e c6288e) {
            super(c6288e);
        }

        /* renamed from: a */
        public final C1112b mo4307a(int i, int i2, long j) {
            return new C1112b(super.mo4307a(i, i2, j)) {
                /* renamed from: a */
                public final void mo4309a(C1101b c1101b, int i, C1101b c1101b2, byte[] bArr) {
                    try {
                        if (c1101b2.equals(C1103a.this.bXd)) {
                            Object obj;
                            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            C1100a[] c1100aArr = C1103a.this.bXl;
                            int length = c1100aArr.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                C1100a c1100a = c1100aArr[i2];
                                C1101b c1101b3 = c1100a.bXA;
                                C1102c fW = C1102c.m2413fW(c1100a.bXz);
                                if (fW == null) {
                                    throw new IllegalStateException("visit instance failed, lost type def of typeId: " + c1100a.bXz);
                                } else if (C1103a.this.bXe.equals(c1101b3)) {
                                    obj = (C1101b) C1111a.m2429a(byteArrayInputStream, fW, C1103a.this.bXj);
                                    break;
                                } else {
                                    i2++;
                                    i3 = C1111a.m2434b(byteArrayInputStream, fW, C1103a.this.bXj) + i3;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                C1101b c1101b4 = (C1101b) C1103a.this.bXa.get(obj);
                                if (!(c1101b4 == null || obj.equals(c1101b4) || obj.equals(C1103a.this.bXk))) {
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.position(i3);
                                    wrap.put(c1101b4.bXC);
                                }
                            }
                        }
                        super.mo4309a(c1101b, i, c1101b2, bArr);
                    } catch (Throwable th) {
                        RuntimeException runtimeException = new RuntimeException(th);
                    }
                }

                /* renamed from: a */
                public final void mo4308a(int i, C1101b c1101b, int i2, int i3, int i4, byte[] bArr) {
                    C1101b c1101b2 = (C1101b) C1103a.this.bXa.get(c1101b);
                    if ((c1101b2 != null && c1101b.equals(c1101b2)) || C1103a.this.bXb.contains(c1101b)) {
                        super.mo4308a(i, c1101b, i2, i3, i4, bArr);
                    }
                }
            };
        }
    }

    /* renamed from: com.tencent.matrix.resource.c.a$b */
    public class C1106b extends C1114d {

        /* renamed from: com.tencent.matrix.resource.c.a$b$1 */
        class C11071 extends C1112b {
            C11071() {
                super(null);
            }

            /* renamed from: a */
            public final void mo4313a(C1101b c1101b, int i, C1101b c1101b2, C1101b c1101b3, int i2, C1100a[] c1100aArr, C1100a[] c1100aArr2) {
                if (C1103a.this.bXl == null && C1103a.this.bXd != null && C1103a.this.bXd.equals(c1101b)) {
                    C1103a.this.bXl = c1100aArr2;
                } else if (C1103a.this.bXm == null && C1103a.this.bXh != null && C1103a.this.bXh.equals(c1101b)) {
                    C1103a.this.bXm = c1100aArr2;
                }
            }
        }

        public C1106b() {
            super(null);
        }

        /* renamed from: a */
        public final void mo4312a(String str, int i, long j) {
            C1103a.this.bXj = i;
            C1103a.this.bXk = new C1101b(new byte[i]);
        }

        /* renamed from: a */
        public final void mo4311a(C1101b c1101b, String str, int i, long j) {
            if (C1103a.this.bXc == null && "android.graphics.Bitmap".equals(str)) {
                C1103a.this.bXc = c1101b;
            } else if (C1103a.this.bXe == null && "mBuffer".equals(str)) {
                C1103a.this.bXe = c1101b;
            } else if (C1103a.this.bXf == null && "mRecycled".equals(str)) {
                C1103a.this.bXf = c1101b;
            } else if (C1103a.this.bXg == null && "java.lang.String".equals(str)) {
                C1103a.this.bXg = c1101b;
            } else if (C1103a.this.bXi == null && "value".equals(str)) {
                C1103a.this.bXi = c1101b;
            }
        }

        /* renamed from: a */
        public final void mo4310a(int i, C1101b c1101b, int i2, C1101b c1101b2, int i3, long j) {
            if (C1103a.this.bXd == null && C1103a.this.bXc != null && C1103a.this.bXc.equals(c1101b2)) {
                C1103a.this.bXd = c1101b;
            } else if (C1103a.this.bXh == null && C1103a.this.bXg != null && C1103a.this.bXg.equals(c1101b2)) {
                C1103a.this.bXh = c1101b;
            }
        }

        /* renamed from: a */
        public final C1112b mo4307a(int i, int i2, long j) {
            return new C11071();
        }
    }

    /* renamed from: com.tencent.matrix.resource.c.a$c */
    public class C1108c extends C1114d {

        /* renamed from: com.tencent.matrix.resource.c.a$c$1 */
        class C11091 extends C1112b {
            C11091() {
                super(null);
            }

            /* renamed from: a */
            public final void mo4309a(C1101b c1101b, int i, C1101b c1101b2, byte[] bArr) {
                C1101b c1101b3 = null;
                Object obj = null;
                try {
                    if (C1103a.this.bXd != null && C1103a.this.bXd.equals(c1101b2)) {
                        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        Boolean bool = null;
                        C1101b c1101b4 = null;
                        for (C1100a c1100a : C1103a.this.bXl) {
                            C1101b c1101b5 = c1100a.bXA;
                            C1102c fW = C1102c.m2413fW(c1100a.bXz);
                            if (fW == null) {
                                throw new IllegalStateException("visit bmp instance failed, lost type def of typeId: " + c1100a.bXz);
                            }
                            if (!C1103a.this.bXe.equals(c1101b5)) {
                                if (!C1103a.this.bXf.equals(c1101b5)) {
                                    if (c1101b4 != null && bool != null) {
                                        break;
                                    }
                                    C1111a.m2434b(byteArrayInputStream, fW, C1103a.this.bXj);
                                } else {
                                    bool = (Boolean) C1111a.m2429a(byteArrayInputStream, fW, C1103a.this.bXj);
                                }
                            } else {
                                c1101b4 = (C1101b) C1111a.m2429a(byteArrayInputStream, fW, C1103a.this.bXj);
                            }
                        }
                        byteArrayInputStream.close();
                        if (bool == null || !bool.booleanValue()) {
                            obj = 1;
                        }
                        if (c1101b4 != null && obj != null && !c1101b4.equals(C1103a.this.bXk)) {
                            C1103a.this.bWY.add(c1101b4);
                        }
                    } else if (C1103a.this.bXh != null && C1103a.this.bXh.equals(c1101b2)) {
                        InputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                        for (C1100a c1100a2 : C1103a.this.bXm) {
                            C1101b c1101b6 = c1100a2.bXA;
                            C1102c fW2 = C1102c.m2413fW(c1100a2.bXz);
                            if (fW2 == null) {
                                throw new IllegalStateException("visit string instance failed, lost type def of typeId: " + c1100a2.bXz);
                            }
                            if (!C1103a.this.bXi.equals(c1101b6)) {
                                if (c1101b3 != null) {
                                    break;
                                }
                                C1111a.m2434b(byteArrayInputStream2, fW2, C1103a.this.bXj);
                            } else {
                                c1101b3 = (C1101b) C1111a.m2429a(byteArrayInputStream2, fW2, C1103a.this.bXj);
                            }
                        }
                        byteArrayInputStream2.close();
                        if (c1101b3 != null && !c1101b3.equals(C1103a.this.bXk)) {
                            C1103a.this.bXb.add(c1101b3);
                        }
                    }
                } catch (Throwable th) {
                    RuntimeException runtimeException = new RuntimeException(th);
                }
            }

            /* renamed from: a */
            public final void mo4308a(int i, C1101b c1101b, int i2, int i3, int i4, byte[] bArr) {
                C1103a.this.bWZ.put(c1101b, bArr);
            }
        }

        public C1108c() {
            super(null);
        }

        /* renamed from: a */
        public final C1112b mo4307a(int i, int i2, long j) {
            return new C11091();
        }

        /* renamed from: zn */
        public final void mo4314zn() {
            Set<Entry> entrySet = C1103a.this.bWZ.entrySet();
            HashMap hashMap = new HashMap();
            for (Entry entry : entrySet) {
                C1101b c1101b = (C1101b) entry.getKey();
                byte[] bArr = (byte[]) entry.getValue();
                if (C1103a.this.bWY.contains(c1101b)) {
                    String w = C1093a.m2408w(bArr);
                    C1101b c1101b2 = (C1101b) hashMap.get(w);
                    if (c1101b2 == null) {
                        hashMap.put(w, c1101b);
                    } else {
                        C1103a.this.bXa.put(c1101b2, c1101b2);
                        C1103a.this.bXa.put(c1101b, c1101b2);
                    }
                }
            }
            C1103a.this.bWZ.clear();
        }
    }

    /* renamed from: a */
    public static boolean m2414a(File file, Properties properties) {
        Object e;
        Closeable closeable;
        Throwable th;
        Object obj;
        if (!file.exists()) {
            return false;
        }
        if (properties.isEmpty()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(file.getParentFile(), "extra.info");
        File file3 = new File(file.getAbsolutePath() + "_temp");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, false));
            try {
                properties.store(bufferedOutputStream, null);
                C1073d.closeQuietly(bufferedOutputStream);
                Closeable c5935h;
                Closeable c5934g;
                try {
                    c5935h = new C5935h(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        c5934g = new C5934g(file);
                        try {
                            Enumeration entries = c5934g.entries();
                            while (entries.hasMoreElements()) {
                                C5931f c5931f = (C5931f) entries.nextElement();
                                if (c5931f == null) {
                                    throw new RuntimeException("zipEntry is null when get from oldApk");
                                } else if (!c5931f.name.contains("../")) {
                                    C5936i.m9251a((C5934g) c5934g, c5931f, (C5935h) c5935h);
                                }
                            }
                            Long r = C1103a.m2415r(file2);
                            if (r == null) {
                                C1070c.m2367e("Matrix.HprofBufferShrinker", "new crc is null", new Object[0]);
                                C1073d.closeQuietly(c5934g);
                                C1073d.closeQuietly(c5935h);
                                file2.delete();
                                return false;
                            }
                            C5936i.m9249a(new C5931f(file2.getName()), file2, r.longValue(), c5935h);
                            C1073d.closeQuietly(c5934g);
                            C1073d.closeQuietly(c5935h);
                            file2.delete();
                            file.delete();
                            if (file3.renameTo(file)) {
                                C1070c.m2368i("Matrix.HprofBufferShrinker", "addExtraInfo end, path: %s, cost time: %d", file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                return true;
                            }
                            C1070c.m2367e("Matrix.HprofBufferShrinker", "rename error", new Object[0]);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            closeable = c5934g;
                            try {
                                C1070c.m2367e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                                C1073d.closeQuietly(closeable);
                                C1073d.closeQuietly(c5935h);
                                file2.delete();
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                c5934g = closeable;
                                C1073d.closeQuietly(c5934g);
                                C1073d.closeQuietly(c5935h);
                                file2.delete();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            C1073d.closeQuietly(c5934g);
                            C1073d.closeQuietly(c5935h);
                            file2.delete();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        closeable = null;
                        C1070c.m2367e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                        C1073d.closeQuietly(closeable);
                        C1073d.closeQuietly(c5935h);
                        file2.delete();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        c5934g = null;
                        C1073d.closeQuietly(c5934g);
                        C1073d.closeQuietly(c5935h);
                        file2.delete();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    closeable = null;
                    c5935h = null;
                    C1070c.m2367e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                    C1073d.closeQuietly(closeable);
                    C1073d.closeQuietly(c5935h);
                    file2.delete();
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    c5934g = null;
                    c5935h = null;
                    C1073d.closeQuietly(c5934g);
                    C1073d.closeQuietly(c5935h);
                    file2.delete();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                obj = bufferedOutputStream;
                C1073d.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            closeable = null;
            C1073d.closeQuietly(closeable);
            throw th;
        }
    }

    /* renamed from: r */
    private static Long m2415r(File file) {
        Throwable th;
        Closeable closeable;
        Long l = null;
        CRC32 crc32 = new CRC32();
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                l = Long.valueOf(crc32.getValue());
                C1073d.closeQuietly(fileInputStream);
            } catch (IOException e) {
                C1073d.closeQuietly(fileInputStream);
                return l;
            } catch (Throwable th2) {
                th = th2;
                closeable = fileInputStream;
                C1073d.closeQuietly(closeable);
                throw th;
            }
        } catch (IOException e2) {
            Object fileInputStream2 = l;
            C1073d.closeQuietly(fileInputStream2);
            return l;
        } catch (Throwable th3) {
            th = th3;
            closeable = l;
            C1073d.closeQuietly(closeable);
            throw th;
        }
        return l;
    }
}
