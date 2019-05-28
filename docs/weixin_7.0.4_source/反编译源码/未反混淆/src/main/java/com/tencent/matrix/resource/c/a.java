package com.tencent.matrix.resource.c;

import com.facebook.internal.Utility;
import com.tencent.matrix.d.d;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
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

public final class a {
    final Set<com.tencent.matrix.resource.c.a.b> bWY = new HashSet();
    final Map<com.tencent.matrix.resource.c.a.b, byte[]> bWZ = new HashMap();
    final Map<com.tencent.matrix.resource.c.a.b, com.tencent.matrix.resource.c.a.b> bXa = new HashMap();
    final Set<com.tencent.matrix.resource.c.a.b> bXb = new HashSet();
    com.tencent.matrix.resource.c.a.b bXc = null;
    com.tencent.matrix.resource.c.a.b bXd = null;
    com.tencent.matrix.resource.c.a.b bXe = null;
    com.tencent.matrix.resource.c.a.b bXf = null;
    com.tencent.matrix.resource.c.a.b bXg = null;
    com.tencent.matrix.resource.c.a.b bXh = null;
    com.tencent.matrix.resource.c.a.b bXi = null;
    int bXj = 0;
    com.tencent.matrix.resource.c.a.b bXk = null;
    com.tencent.matrix.resource.c.a.a[] bXl = null;
    com.tencent.matrix.resource.c.a.a[] bXm = null;

    public class a extends d {
        public a(e eVar) {
            super(eVar);
        }

        public final b a(int i, int i2, long j) {
            return new b(super.a(i, i2, j)) {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, byte[] bArr) {
                    try {
                        if (bVar2.equals(a.this.bXd)) {
                            Object obj;
                            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            com.tencent.matrix.resource.c.a.a[] aVarArr = a.this.bXl;
                            int length = aVarArr.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                com.tencent.matrix.resource.c.a.a aVar = aVarArr[i2];
                                com.tencent.matrix.resource.c.a.b bVar3 = aVar.bXA;
                                com.tencent.matrix.resource.c.a.c fW = com.tencent.matrix.resource.c.a.c.fW(aVar.bXz);
                                if (fW == null) {
                                    throw new IllegalStateException("visit instance failed, lost type def of typeId: " + aVar.bXz);
                                } else if (a.this.bXe.equals(bVar3)) {
                                    obj = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, fW, a.this.bXj);
                                    break;
                                } else {
                                    i2++;
                                    i3 = com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, fW, a.this.bXj) + i3;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com.tencent.matrix.resource.c.a.b bVar4 = (com.tencent.matrix.resource.c.a.b) a.this.bXa.get(obj);
                                if (!(bVar4 == null || obj.equals(bVar4) || obj.equals(a.this.bXk))) {
                                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                    wrap.position(i3);
                                    wrap.put(bVar4.bXC);
                                }
                            }
                        }
                        super.a(bVar, i, bVar2, bArr);
                    } catch (Throwable th) {
                        RuntimeException runtimeException = new RuntimeException(th);
                    }
                }

                public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, int i3, int i4, byte[] bArr) {
                    com.tencent.matrix.resource.c.a.b bVar2 = (com.tencent.matrix.resource.c.a.b) a.this.bXa.get(bVar);
                    if ((bVar2 != null && bVar.equals(bVar2)) || a.this.bXb.contains(bVar)) {
                        super.a(i, bVar, i2, i3, i4, bArr);
                    }
                }
            };
        }
    }

    public class b extends d {
        public b() {
            super(null);
        }

        public final void a(String str, int i, long j) {
            a.this.bXj = i;
            a.this.bXk = new com.tencent.matrix.resource.c.a.b(new byte[i]);
        }

        public final void a(com.tencent.matrix.resource.c.a.b bVar, String str, int i, long j) {
            if (a.this.bXc == null && "android.graphics.Bitmap".equals(str)) {
                a.this.bXc = bVar;
            } else if (a.this.bXe == null && "mBuffer".equals(str)) {
                a.this.bXe = bVar;
            } else if (a.this.bXf == null && "mRecycled".equals(str)) {
                a.this.bXf = bVar;
            } else if (a.this.bXg == null && "java.lang.String".equals(str)) {
                a.this.bXg = bVar;
            } else if (a.this.bXi == null && "value".equals(str)) {
                a.this.bXi = bVar;
            }
        }

        public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, com.tencent.matrix.resource.c.a.b bVar2, int i3, long j) {
            if (a.this.bXd == null && a.this.bXc != null && a.this.bXc.equals(bVar2)) {
                a.this.bXd = bVar;
            } else if (a.this.bXh == null && a.this.bXg != null && a.this.bXg.equals(bVar2)) {
                a.this.bXh = bVar;
            }
        }

        public final b a(int i, int i2, long j) {
            return new b() {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, com.tencent.matrix.resource.c.a.b bVar3, int i2, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
                    if (a.this.bXl == null && a.this.bXd != null && a.this.bXd.equals(bVar)) {
                        a.this.bXl = aVarArr2;
                    } else if (a.this.bXm == null && a.this.bXh != null && a.this.bXh.equals(bVar)) {
                        a.this.bXm = aVarArr2;
                    }
                }
            };
        }
    }

    public class c extends d {
        public c() {
            super(null);
        }

        public final b a(int i, int i2, long j) {
            return new b() {
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i, com.tencent.matrix.resource.c.a.b bVar2, byte[] bArr) {
                    com.tencent.matrix.resource.c.a.b bVar3 = null;
                    Object obj = null;
                    try {
                        if (a.this.bXd != null && a.this.bXd.equals(bVar2)) {
                            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            Boolean bool = null;
                            com.tencent.matrix.resource.c.a.b bVar4 = null;
                            for (com.tencent.matrix.resource.c.a.a aVar : a.this.bXl) {
                                com.tencent.matrix.resource.c.a.b bVar5 = aVar.bXA;
                                com.tencent.matrix.resource.c.a.c fW = com.tencent.matrix.resource.c.a.c.fW(aVar.bXz);
                                if (fW == null) {
                                    throw new IllegalStateException("visit bmp instance failed, lost type def of typeId: " + aVar.bXz);
                                }
                                if (!a.this.bXe.equals(bVar5)) {
                                    if (!a.this.bXf.equals(bVar5)) {
                                        if (bVar4 != null && bool != null) {
                                            break;
                                        }
                                        com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, fW, a.this.bXj);
                                    } else {
                                        bool = (Boolean) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, fW, a.this.bXj);
                                    }
                                } else {
                                    bVar4 = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, fW, a.this.bXj);
                                }
                            }
                            byteArrayInputStream.close();
                            if (bool == null || !bool.booleanValue()) {
                                obj = 1;
                            }
                            if (bVar4 != null && obj != null && !bVar4.equals(a.this.bXk)) {
                                a.this.bWY.add(bVar4);
                            }
                        } else if (a.this.bXh != null && a.this.bXh.equals(bVar2)) {
                            InputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                            for (com.tencent.matrix.resource.c.a.a aVar2 : a.this.bXm) {
                                com.tencent.matrix.resource.c.a.b bVar6 = aVar2.bXA;
                                com.tencent.matrix.resource.c.a.c fW2 = com.tencent.matrix.resource.c.a.c.fW(aVar2.bXz);
                                if (fW2 == null) {
                                    throw new IllegalStateException("visit string instance failed, lost type def of typeId: " + aVar2.bXz);
                                }
                                if (!a.this.bXi.equals(bVar6)) {
                                    if (bVar3 != null) {
                                        break;
                                    }
                                    com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream2, fW2, a.this.bXj);
                                } else {
                                    bVar3 = (com.tencent.matrix.resource.c.a.b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream2, fW2, a.this.bXj);
                                }
                            }
                            byteArrayInputStream2.close();
                            if (bVar3 != null && !bVar3.equals(a.this.bXk)) {
                                a.this.bXb.add(bVar3);
                            }
                        }
                    } catch (Throwable th) {
                        RuntimeException runtimeException = new RuntimeException(th);
                    }
                }

                public final void a(int i, com.tencent.matrix.resource.c.a.b bVar, int i2, int i3, int i4, byte[] bArr) {
                    a.this.bWZ.put(bVar, bArr);
                }
            };
        }

        public final void zn() {
            Set<Entry> entrySet = a.this.bWZ.entrySet();
            HashMap hashMap = new HashMap();
            for (Entry entry : entrySet) {
                com.tencent.matrix.resource.c.a.b bVar = (com.tencent.matrix.resource.c.a.b) entry.getKey();
                byte[] bArr = (byte[]) entry.getValue();
                if (a.this.bWY.contains(bVar)) {
                    String w = com.tencent.matrix.resource.a.a.a.w(bArr);
                    com.tencent.matrix.resource.c.a.b bVar2 = (com.tencent.matrix.resource.c.a.b) hashMap.get(w);
                    if (bVar2 == null) {
                        hashMap.put(w, bVar);
                    } else {
                        a.this.bXa.put(bVar2, bVar2);
                        a.this.bXa.put(bVar, bVar2);
                    }
                }
            }
            a.this.bWZ.clear();
        }
    }

    public static boolean a(File file, Properties properties) {
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
                d.closeQuietly(bufferedOutputStream);
                Closeable hVar;
                Closeable gVar;
                try {
                    hVar = new h(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        gVar = new g(file);
                        try {
                            Enumeration entries = gVar.entries();
                            while (entries.hasMoreElements()) {
                                f fVar = (f) entries.nextElement();
                                if (fVar == null) {
                                    throw new RuntimeException("zipEntry is null when get from oldApk");
                                } else if (!fVar.name.contains("../")) {
                                    i.a((g) gVar, fVar, (h) hVar);
                                }
                            }
                            Long r = r(file2);
                            if (r == null) {
                                com.tencent.matrix.d.c.e("Matrix.HprofBufferShrinker", "new crc is null", new Object[0]);
                                d.closeQuietly(gVar);
                                d.closeQuietly(hVar);
                                file2.delete();
                                return false;
                            }
                            i.a(new f(file2.getName()), file2, r.longValue(), hVar);
                            d.closeQuietly(gVar);
                            d.closeQuietly(hVar);
                            file2.delete();
                            file.delete();
                            if (file3.renameTo(file)) {
                                com.tencent.matrix.d.c.i("Matrix.HprofBufferShrinker", "addExtraInfo end, path: %s, cost time: %d", file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                return true;
                            }
                            com.tencent.matrix.d.c.e("Matrix.HprofBufferShrinker", "rename error", new Object[0]);
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            closeable = gVar;
                            try {
                                com.tencent.matrix.d.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                                d.closeQuietly(closeable);
                                d.closeQuietly(hVar);
                                file2.delete();
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                gVar = closeable;
                                d.closeQuietly(gVar);
                                d.closeQuietly(hVar);
                                file2.delete();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            d.closeQuietly(gVar);
                            d.closeQuietly(hVar);
                            file2.delete();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        closeable = null;
                        com.tencent.matrix.d.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                        d.closeQuietly(closeable);
                        d.closeQuietly(hVar);
                        file2.delete();
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        gVar = null;
                        d.closeQuietly(gVar);
                        d.closeQuietly(hVar);
                        file2.delete();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    closeable = null;
                    hVar = null;
                    com.tencent.matrix.d.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                    d.closeQuietly(closeable);
                    d.closeQuietly(hVar);
                    file2.delete();
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    gVar = null;
                    hVar = null;
                    d.closeQuietly(gVar);
                    d.closeQuietly(hVar);
                    file2.delete();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                obj = bufferedOutputStream;
                d.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            closeable = null;
            d.closeQuietly(closeable);
            throw th;
        }
    }

    private static Long r(File file) {
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
                d.closeQuietly(fileInputStream);
            } catch (IOException e) {
                d.closeQuietly(fileInputStream);
                return l;
            } catch (Throwable th2) {
                th = th2;
                closeable = fileInputStream;
                d.closeQuietly(closeable);
                throw th;
            }
        } catch (IOException e2) {
            Object fileInputStream2 = l;
            d.closeQuietly(fileInputStream2);
            return l;
        } catch (Throwable th3) {
            th = th3;
            closeable = l;
            d.closeQuietly(closeable);
            throw th;
        }
        return l;
    }
}
