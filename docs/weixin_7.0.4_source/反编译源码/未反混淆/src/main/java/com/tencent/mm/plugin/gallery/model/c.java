package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;

public final class c {
    private static final int mNu = (d.fP(14) ? 20 : 40);
    private volatile boolean isDecoding = false;
    d mNv = new d();
    private a mNw = new a(this, (byte) 0);
    private h<String> mNx = new h();
    private h<b> mNy = new h();

    class a {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void d(final com.tencent.mm.sdk.platformtools.az.a aVar) {
            AppMethodBeat.i(21227);
            if (e.bCa() == null) {
                ab.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                AppMethodBeat.o(21227);
                return;
            }
            e.bCa().X(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21225);
                    if (aVar.acf()) {
                        aVar.acg();
                    }
                    c.this.isDecoding = false;
                    c.d(c.this);
                    AppMethodBeat.o(21225);
                }

                public final String toString() {
                    AppMethodBeat.i(21226);
                    String str = super.toString() + "|QueueWorkerThreadForGallery";
                    AppMethodBeat.o(21226);
                    return str;
                }
            });
            AppMethodBeat.o(21227);
        }
    }

    class b implements com.tencent.mm.sdk.platformtools.az.a {
        private Bitmap bitmap;
        private int cyQ;
        String mFilePath;
        private String mNC;
        private long mND;
        private int mNE;

        public b(c cVar, String str, int i, String str2, long j) {
            this(str, i, str2, j, (byte) 0);
        }

        private b(String str, int i, String str2, long j, byte b) {
            this.mFilePath = str;
            this.mND = j;
            this.mNC = str2;
            this.mNE = 12288;
            this.cyQ = i;
        }

        public final boolean acf() {
            Bitmap bitmap;
            AppMethodBeat.i(21228);
            d a = c.this.mNv;
            String str = this.mFilePath;
            String str2 = this.mNC;
            long j = this.mND;
            str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
            if (a.mNG == null) {
                bitmap = null;
            } else {
                bitmap = a.mNG.wn(str.hashCode());
            }
            this.bitmap = bitmap;
            if (this.bitmap != null) {
                ab.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", this.mFilePath);
                AppMethodBeat.o(21228);
            } else {
                this.bitmap = k.a(this.mND, this.cyQ, this.mFilePath, this.mNC);
                if (this.bitmap != null) {
                    a = c.this.mNv;
                    str = this.mFilePath;
                    str2 = this.mNC;
                    j = this.mND;
                    Bitmap bitmap2 = this.bitmap;
                    if (bitmap2 != null) {
                        str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
                        if (a.mNG != null) {
                            f fVar = a.mNG;
                            int hashCode = str.hashCode();
                            if (fVar.mNX == null || fVar.mNX.size() <= 0) {
                                ab.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                            } else if (bitmap2 == null) {
                                ab.e("MicroMsg.DiskCache", "put bmp, value error: null");
                            } else {
                                int i;
                                ab.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", Integer.valueOf(hashCode), Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()));
                                if (fVar.mNX == null || fVar.mNX.size() <= 0) {
                                    i = -1;
                                } else {
                                    int bCk = fVar.bCk();
                                    if (bCk < 0) {
                                        ab.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", Integer.valueOf(fVar.mNZ));
                                        if (fVar.mNZ + 1 >= 25) {
                                            bCk = 0;
                                        } else {
                                            bCk = fVar.mNZ + 1;
                                        }
                                        ab.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", Integer.valueOf(bCk));
                                        fVar.wm(bCk);
                                        fVar.wl(bCk);
                                    }
                                    i = bCk;
                                }
                                if (i < 0) {
                                    ab.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                                } else {
                                    auo auo;
                                    auo auo2 = (auo) fVar.mNY.get(hashCode);
                                    if (auo2 == null) {
                                        auo2 = new auo();
                                        auo2.key = hashCode;
                                        auo = auo2;
                                    } else {
                                        auo = auo2;
                                    }
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        bitmap2.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                                        try {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            RandomAccessFile randomAccessFile = (RandomAccessFile) fVar.mNX.get(i);
                                            auo.wyJ = randomAccessFile.length();
                                            auo.wyK = i;
                                            auo.length = byteArrayOutputStream.size();
                                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                            randomAccessFile.seek(auo.wyJ);
                                            randomAccessFile.write(toByteArray);
                                            fVar.mNZ = i;
                                            ab.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(auo.key), Long.valueOf(auo.wyJ), Integer.valueOf(auo.length), Integer.valueOf(auo.wyK));
                                            f.d(byteArrayOutputStream);
                                            fVar.dirty = true;
                                            fVar.mNY.put(hashCode, auo);
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.DiskCache", "write data error:%s", e.getMessage());
                                            f.d(byteArrayOutputStream);
                                        } catch (Throwable th) {
                                            f.d(byteArrayOutputStream);
                                            AppMethodBeat.o(21228);
                                        }
                                    } catch (Exception e2) {
                                        ab.e("MicroMsg.DiskCache", "compress bmp error:%s", e2.getMessage());
                                        ab.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                                        f.d(byteArrayOutputStream);
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(21228);
                } else {
                    AppMethodBeat.o(21228);
                }
            }
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(21229);
            ab.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", this.mFilePath);
            c.this.mNx.bV(this.mFilePath);
            ab.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", Integer.valueOf(c.this.mNx.size()));
            if (this.bitmap == null) {
                ab.e("MircoMsg.CacheService", "decode file failed, %s ", this.mFilePath);
                AppMethodBeat.o(21229);
                return false;
            }
            d a = c.this.mNv;
            String str = this.mFilePath;
            Bitmap bitmap = this.bitmap;
            int i = this.mNE;
            if (a.mNF == null) {
                ab.e("MicroMsg.GalleryCache", "cache is null");
            } else {
                a.mNF.k(str, new a(bitmap, i));
                a.fry.cF(str);
                a.fry.doNotify();
            }
            this.bitmap = null;
            AppMethodBeat.o(21229);
            return true;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(21230);
            if (obj == null) {
                AppMethodBeat.o(21230);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(21230);
                return true;
            } else if (obj instanceof b) {
                boolean equals = bo.bc(this.mFilePath, "").equals(((b) obj).mFilePath);
                AppMethodBeat.o(21230);
                return equals;
            } else {
                AppMethodBeat.o(21230);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(21231);
            int hashCode = bo.bc(this.mFilePath, "").hashCode();
            AppMethodBeat.o(21231);
            return hashCode;
        }
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(21238);
        cVar.bBW();
        AppMethodBeat.o(21238);
    }

    static {
        AppMethodBeat.i(21239);
        AppMethodBeat.o(21239);
    }

    public c() {
        AppMethodBeat.i(21232);
        AppMethodBeat.o(21232);
    }

    public final Bitmap b(String str, int i, String str2, long j) {
        AppMethodBeat.i(21233);
        if (bo.isNullOrNil(str)) {
            ab.w("MircoMsg.CacheService", "file path is null");
            AppMethodBeat.o(21233);
            return null;
        }
        Bitmap bitmap = this.mNv.getBitmap(str);
        if (bitmap != null) {
            ab.v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
            AppMethodBeat.o(21233);
            return bitmap;
        }
        ab.v("MircoMsg.CacheService", "filePathInService size is : [%d]", Integer.valueOf(this.mNx.size()));
        if (this.mNx.aj(str)) {
            ab.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", str);
            bBW();
            AppMethodBeat.o(21233);
            return null;
        }
        if (this.mNx.size() > mNu) {
            ab.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", Integer.valueOf(this.mNx.size()), Integer.valueOf(this.mNy.size()));
            if (!this.mNy.isEmpty()) {
                b bVar = (b) this.mNy.bCr();
                if (bVar != null) {
                    this.mNx.bV(bVar.mFilePath);
                    ab.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one! path:%s", r0);
                }
            }
        }
        this.mNx.add(str);
        this.mNy.add(new b(this, str, i, str2, j));
        bBW();
        AppMethodBeat.o(21233);
        return null;
    }

    public final Bitmap Nz(String str) {
        AppMethodBeat.i(21234);
        if (bo.isNullOrNil(str)) {
            ab.w("MircoMsg.CacheService", "file path is null");
            AppMethodBeat.o(21234);
            return null;
        }
        Bitmap bitmap = this.mNv.getBitmap(str);
        if (bitmap != null) {
            ab.v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
            AppMethodBeat.o(21234);
            return bitmap;
        }
        AppMethodBeat.o(21234);
        return null;
    }

    private void bBW() {
        AppMethodBeat.i(21235);
        if (this.isDecoding) {
            ab.w("MircoMsg.CacheService", "is decoding now, wait a minute");
            AppMethodBeat.o(21235);
        } else if (this.mNy == null || this.mNy.size() <= 0) {
            ab.i("MircoMsg.CacheService", "all job empty");
            if (e.bCa() == null) {
                AppMethodBeat.o(21235);
                return;
            }
            e.bCa().W(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21223);
                    d a = c.this.mNv;
                    if (a.mNG != null) {
                        f fVar = a.mNG;
                        if (fVar.dirty) {
                            fVar.dirty = false;
                            fVar.bCi();
                            fVar.bCj();
                            fVar.wl(-1);
                            fVar.bCl();
                        }
                    }
                    AppMethodBeat.o(21223);
                }

                public final String toString() {
                    AppMethodBeat.i(21224);
                    String str = super.toString() + "|tryStartDocode";
                    AppMethodBeat.o(21224);
                    return str;
                }
            });
            AppMethodBeat.o(21235);
        } else {
            this.isDecoding = true;
            c((b) this.mNy.bCr());
            AppMethodBeat.o(21235);
        }
    }

    private void c(com.tencent.mm.sdk.platformtools.az.a aVar) {
        AppMethodBeat.i(21236);
        if (aVar == null) {
            ab.e("MircoMsg.CacheService", "obj is null");
            this.isDecoding = false;
            bBW();
            AppMethodBeat.o(21236);
            return;
        }
        this.mNw.d(aVar);
        AppMethodBeat.o(21236);
    }

    public final void a(com.tencent.mm.plugin.gallery.model.d.b bVar) {
        AppMethodBeat.i(21237);
        d dVar = this.mNv;
        if (dVar.ghp.size() > 64) {
            com.tencent.mm.plugin.gallery.model.d.b bVar2 = (com.tencent.mm.plugin.gallery.model.d.b) dVar.ghp.remove(0);
            ab.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", Integer.valueOf(64), bVar2);
        }
        ab.v("MicroMsg.GalleryCache", "try add listener[%s]", bVar);
        if (!dVar.ghp.contains(bVar)) {
            ab.d("MicroMsg.GalleryCache", "add listener[%s] ok", bVar);
            dVar.ghp.add(bVar);
        }
        AppMethodBeat.o(21237);
    }

    public final void b(com.tencent.mm.plugin.gallery.model.d.b bVar) {
        AppMethodBeat.i(138608);
        d dVar = this.mNv;
        if (bVar == null) {
            if (dVar.ghp != null) {
                dVar.ghp.clear();
            }
            AppMethodBeat.o(138608);
            return;
        }
        if (dVar.ghp != null && dVar.ghp.contains(bVar)) {
            dVar.ghp.remove(bVar);
        }
        AppMethodBeat.o(138608);
    }
}
