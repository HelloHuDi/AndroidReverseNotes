package com.tencent.p177mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.gallery.model.C20905d.C20906a;
import com.tencent.p177mm.plugin.gallery.model.C20905d.C20907b;
import com.tencent.p177mm.protocal.protobuf.auo;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.gallery.model.c */
public final class C43141c {
    private static final int mNu = (C1443d.m3067fP(14) ? 20 : 40);
    private volatile boolean isDecoding = false;
    C20905d mNv = new C20905d();
    private C20903a mNw = new C20903a(this, (byte) 0);
    private C28158h<String> mNx = new C28158h();
    private C28158h<C43140b> mNy = new C28158h();

    /* renamed from: com.tencent.mm.plugin.gallery.model.c$a */
    class C20903a {
        private C20903a() {
        }

        /* synthetic */ C20903a(C43141c c43141c, byte b) {
            this();
        }

        /* renamed from: d */
        public final void mo36219d(final C23499a c23499a) {
            AppMethodBeat.m2504i(21227);
            if (C34237e.bCa() == null) {
                C4990ab.m7420w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                AppMethodBeat.m2505o(21227);
                return;
            }
            C34237e.bCa().mo36232X(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(21225);
                    if (c23499a.acf()) {
                        c23499a.acg();
                    }
                    C43141c.this.isDecoding = false;
                    C43141c.m76703d(C43141c.this);
                    AppMethodBeat.m2505o(21225);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(21226);
                    String str = super.toString() + "|QueueWorkerThreadForGallery";
                    AppMethodBeat.m2505o(21226);
                    return str;
                }
            });
            AppMethodBeat.m2505o(21227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.c$1 */
    class C391571 implements Runnable {
        C391571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21223);
            C20905d a = C43141c.this.mNv;
            if (a.mNG != null) {
                C20908f c20908f = a.mNG;
                if (c20908f.dirty) {
                    c20908f.dirty = false;
                    c20908f.bCi();
                    c20908f.bCj();
                    c20908f.mo36228wl(-1);
                    c20908f.bCl();
                }
            }
            AppMethodBeat.m2505o(21223);
        }

        public final String toString() {
            AppMethodBeat.m2504i(21224);
            String str = super.toString() + "|tryStartDocode";
            AppMethodBeat.m2505o(21224);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.c$b */
    class C43140b implements C23499a {
        private Bitmap bitmap;
        private int cyQ;
        String mFilePath;
        private String mNC;
        private long mND;
        private int mNE;

        public C43140b(C43141c c43141c, String str, int i, String str2, long j) {
            this(str, i, str2, j, (byte) 0);
        }

        private C43140b(String str, int i, String str2, long j, byte b) {
            this.mFilePath = str;
            this.mND = j;
            this.mNC = str2;
            this.mNE = 12288;
            this.cyQ = i;
        }

        public final boolean acf() {
            Bitmap bitmap;
            AppMethodBeat.m2504i(21228);
            C20905d a = C43141c.this.mNv;
            String str = this.mFilePath;
            String str2 = this.mNC;
            long j = this.mND;
            str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
            if (a.mNG == null) {
                bitmap = null;
            } else {
                bitmap = a.mNG.mo36230wn(str.hashCode());
            }
            this.bitmap = bitmap;
            if (this.bitmap != null) {
                C4990ab.m7411d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", this.mFilePath);
                AppMethodBeat.m2505o(21228);
            } else {
                this.bitmap = C39159k.m66637a(this.mND, this.cyQ, this.mFilePath, this.mNC);
                if (this.bitmap != null) {
                    a = C43141c.this.mNv;
                    str = this.mFilePath;
                    str2 = this.mNC;
                    j = this.mND;
                    Bitmap bitmap2 = this.bitmap;
                    if (bitmap2 != null) {
                        str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
                        if (a.mNG != null) {
                            C20908f c20908f = a.mNG;
                            int hashCode = str.hashCode();
                            if (c20908f.mNX == null || c20908f.mNX.size() <= 0) {
                                C4990ab.m7412e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                            } else if (bitmap2 == null) {
                                C4990ab.m7412e("MicroMsg.DiskCache", "put bmp, value error: null");
                            } else {
                                int i;
                                C4990ab.m7411d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", Integer.valueOf(hashCode), Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()));
                                if (c20908f.mNX == null || c20908f.mNX.size() <= 0) {
                                    i = -1;
                                } else {
                                    int bCk = c20908f.bCk();
                                    if (bCk < 0) {
                                        C4990ab.m7411d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", Integer.valueOf(c20908f.mNZ));
                                        if (c20908f.mNZ + 1 >= 25) {
                                            bCk = 0;
                                        } else {
                                            bCk = c20908f.mNZ + 1;
                                        }
                                        C4990ab.m7411d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", Integer.valueOf(bCk));
                                        c20908f.mo36229wm(bCk);
                                        c20908f.mo36228wl(bCk);
                                    }
                                    i = bCk;
                                }
                                if (i < 0) {
                                    C4990ab.m7412e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                                } else {
                                    auo auo;
                                    auo auo2 = (auo) c20908f.mNY.get(hashCode);
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
                                            RandomAccessFile randomAccessFile = (RandomAccessFile) c20908f.mNX.get(i);
                                            auo.wyJ = randomAccessFile.length();
                                            auo.wyK = i;
                                            auo.length = byteArrayOutputStream.size();
                                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                            randomAccessFile.seek(auo.wyJ);
                                            randomAccessFile.write(toByteArray);
                                            c20908f.mNZ = i;
                                            C4990ab.m7411d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(auo.key), Long.valueOf(auo.wyJ), Integer.valueOf(auo.length), Integer.valueOf(auo.wyK));
                                            C20908f.m32147d(byteArrayOutputStream);
                                            c20908f.dirty = true;
                                            c20908f.mNY.put(hashCode, auo);
                                        } catch (Exception e) {
                                            C4990ab.m7413e("MicroMsg.DiskCache", "write data error:%s", e.getMessage());
                                            C20908f.m32147d(byteArrayOutputStream);
                                        } catch (Throwable th) {
                                            C20908f.m32147d(byteArrayOutputStream);
                                            AppMethodBeat.m2505o(21228);
                                        }
                                    } catch (Exception e2) {
                                        C4990ab.m7413e("MicroMsg.DiskCache", "compress bmp error:%s", e2.getMessage());
                                        C4990ab.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                                        C20908f.m32147d(byteArrayOutputStream);
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(21228);
                } else {
                    AppMethodBeat.m2505o(21228);
                }
            }
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(21229);
            C4990ab.m7411d("MircoMsg.CacheService", "do on post execute, filePath[%s]", this.mFilePath);
            C43141c.this.mNx.mo46072bV(this.mFilePath);
            C4990ab.m7419v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", Integer.valueOf(C43141c.this.mNx.size()));
            if (this.bitmap == null) {
                C4990ab.m7413e("MircoMsg.CacheService", "decode file failed, %s ", this.mFilePath);
                AppMethodBeat.m2505o(21229);
                return false;
            }
            C20905d a = C43141c.this.mNv;
            String str = this.mFilePath;
            Bitmap bitmap = this.bitmap;
            int i = this.mNE;
            if (a.mNF == null) {
                C4990ab.m7412e("MicroMsg.GalleryCache", "cache is null");
            } else {
                a.mNF.mo4412k(str, new C20906a(bitmap, i));
                a.fry.mo10126cF(str);
                a.fry.doNotify();
            }
            this.bitmap = null;
            AppMethodBeat.m2505o(21229);
            return true;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(21230);
            if (obj == null) {
                AppMethodBeat.m2505o(21230);
                return false;
            } else if (this == obj) {
                AppMethodBeat.m2505o(21230);
                return true;
            } else if (obj instanceof C43140b) {
                boolean equals = C5046bo.m7532bc(this.mFilePath, "").equals(((C43140b) obj).mFilePath);
                AppMethodBeat.m2505o(21230);
                return equals;
            } else {
                AppMethodBeat.m2505o(21230);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(21231);
            int hashCode = C5046bo.m7532bc(this.mFilePath, "").hashCode();
            AppMethodBeat.m2505o(21231);
            return hashCode;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m76703d(C43141c c43141c) {
        AppMethodBeat.m2504i(21238);
        c43141c.bBW();
        AppMethodBeat.m2505o(21238);
    }

    static {
        AppMethodBeat.m2504i(21239);
        AppMethodBeat.m2505o(21239);
    }

    public C43141c() {
        AppMethodBeat.m2504i(21232);
        AppMethodBeat.m2505o(21232);
    }

    /* renamed from: b */
    public final Bitmap mo68659b(String str, int i, String str2, long j) {
        AppMethodBeat.m2504i(21233);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MircoMsg.CacheService", "file path is null");
            AppMethodBeat.m2505o(21233);
            return null;
        }
        Bitmap bitmap = this.mNv.getBitmap(str);
        if (bitmap != null) {
            C4990ab.m7419v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
            AppMethodBeat.m2505o(21233);
            return bitmap;
        }
        C4990ab.m7419v("MircoMsg.CacheService", "filePathInService size is : [%d]", Integer.valueOf(this.mNx.size()));
        if (this.mNx.mo46070aj(str)) {
            C4990ab.m7421w("MircoMsg.CacheService", "has already getting bitmap from file, %s", str);
            bBW();
            AppMethodBeat.m2505o(21233);
            return null;
        }
        if (this.mNx.size() > mNu) {
            C4990ab.m7421w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", Integer.valueOf(this.mNx.size()), Integer.valueOf(this.mNy.size()));
            if (!this.mNy.isEmpty()) {
                C43140b c43140b = (C43140b) this.mNy.bCr();
                if (c43140b != null) {
                    this.mNx.mo46072bV(c43140b.mFilePath);
                    C4990ab.m7421w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one! path:%s", r0);
                }
            }
        }
        this.mNx.add(str);
        this.mNy.add(new C43140b(this, str, i, str2, j));
        bBW();
        AppMethodBeat.m2505o(21233);
        return null;
    }

    /* renamed from: Nz */
    public final Bitmap mo68657Nz(String str) {
        AppMethodBeat.m2504i(21234);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MircoMsg.CacheService", "file path is null");
            AppMethodBeat.m2505o(21234);
            return null;
        }
        Bitmap bitmap = this.mNv.getBitmap(str);
        if (bitmap != null) {
            C4990ab.m7419v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
            AppMethodBeat.m2505o(21234);
            return bitmap;
        }
        AppMethodBeat.m2505o(21234);
        return null;
    }

    private void bBW() {
        AppMethodBeat.m2504i(21235);
        if (this.isDecoding) {
            C4990ab.m7420w("MircoMsg.CacheService", "is decoding now, wait a minute");
            AppMethodBeat.m2505o(21235);
        } else if (this.mNy == null || this.mNy.size() <= 0) {
            C4990ab.m7416i("MircoMsg.CacheService", "all job empty");
            if (C34237e.bCa() == null) {
                AppMethodBeat.m2505o(21235);
                return;
            }
            C34237e.bCa().mo36231W(new C391571());
            AppMethodBeat.m2505o(21235);
        } else {
            this.isDecoding = true;
            m76701c((C43140b) this.mNy.bCr());
            AppMethodBeat.m2505o(21235);
        }
    }

    /* renamed from: c */
    private void m76701c(C23499a c23499a) {
        AppMethodBeat.m2504i(21236);
        if (c23499a == null) {
            C4990ab.m7412e("MircoMsg.CacheService", "obj is null");
            this.isDecoding = false;
            bBW();
            AppMethodBeat.m2505o(21236);
            return;
        }
        this.mNw.mo36219d(c23499a);
        AppMethodBeat.m2505o(21236);
    }

    /* renamed from: a */
    public final void mo68658a(C20907b c20907b) {
        AppMethodBeat.m2504i(21237);
        C20905d c20905d = this.mNv;
        if (c20905d.ghp.size() > 64) {
            C20907b c20907b2 = (C20907b) c20905d.ghp.remove(0);
            C4990ab.m7417i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", Integer.valueOf(64), c20907b2);
        }
        C4990ab.m7419v("MicroMsg.GalleryCache", "try add listener[%s]", c20907b);
        if (!c20905d.ghp.contains(c20907b)) {
            C4990ab.m7411d("MicroMsg.GalleryCache", "add listener[%s] ok", c20907b);
            c20905d.ghp.add(c20907b);
        }
        AppMethodBeat.m2505o(21237);
    }

    /* renamed from: b */
    public final void mo68660b(C20907b c20907b) {
        AppMethodBeat.m2504i(138608);
        C20905d c20905d = this.mNv;
        if (c20907b == null) {
            if (c20905d.ghp != null) {
                c20905d.ghp.clear();
            }
            AppMethodBeat.m2505o(138608);
            return;
        }
        if (c20905d.ghp != null && c20905d.ghp.contains(c20907b)) {
            c20905d.ghp.remove(c20907b);
        }
        AppMethodBeat.m2505o(138608);
    }
}
