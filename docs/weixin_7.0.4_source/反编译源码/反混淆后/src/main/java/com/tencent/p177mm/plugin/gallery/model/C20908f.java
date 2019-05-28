package com.tencent.p177mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.aun;
import com.tencent.p177mm.protocal.protobuf.auo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.gallery.model.f */
public final class C20908f {
    boolean dirty = true;
    private File mNW;
    List<RandomAccessFile> mNX;
    SparseArray<auo> mNY;
    int mNZ;

    C20908f(File file) {
        AppMethodBeat.m2504i(21262);
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            C4990ab.m7411d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", file.getAbsolutePath(), Boolean.valueOf(mkdirs));
        }
        this.mNW = file;
        this.mNY = new SparseArray();
        AppMethodBeat.m2505o(21262);
    }

    /* Access modifiers changed, original: final */
    public final void bCh() {
        AppMethodBeat.m2504i(21263);
        File file = new File(this.mNW, "cache.idx");
        aun aun = new aun();
        String absolutePath = file.getAbsolutePath();
        if (!C5046bo.isNullOrNil(absolutePath)) {
            try {
                aun.parseFrom(C5046bo.readFromFile(absolutePath));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.DiskCache", "load index file error");
                C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                mo36229wm(-1);
                aun = new aun();
            } catch (OutOfMemoryError e2) {
                C4990ab.m7413e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", Long.valueOf(file.length()));
                C4990ab.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                mo36229wm(-1);
                aun = new aun();
            }
        }
        this.mNY.clear();
        Iterator it = aun.wyI.iterator();
        while (it.hasNext()) {
            auo auo = (auo) it.next();
            this.mNY.put(auo.key, auo);
        }
        AppMethodBeat.m2505o(21263);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: wl */
    public final synchronized void mo36228wl(int i) {
        synchronized (this) {
            AppMethodBeat.m2504i(21264);
            if (i >= 0) {
                try {
                    if (this.mNX != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mNW, C20908f.m32148wo(i)), "rw");
                        this.mNX.remove(i);
                        this.mNX.add(i, randomAccessFile);
                        AppMethodBeat.m2505o(21264);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.DiskCache", "create data file error: %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.mNX = null;
                    AppMethodBeat.m2505o(21264);
                }
            }
            this.mNX = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.mNX.add(new RandomAccessFile(new File(this.mNW, C20908f.m32148wo(i2)), "rw"));
            }
            AppMethodBeat.m2505o(21264);
        }
        return;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wm */
    public final void mo36229wm(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(21265);
        if (this.mNX == null || this.mNX.size() <= 0) {
            AppMethodBeat.m2505o(21265);
            return;
        }
        if (i < 0) {
            new File(this.mNW, "cache.idx").delete();
            this.mNY.clear();
        } else {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = 0; i3 < this.mNY.size(); i3++) {
                auo auo = (auo) this.mNY.valueAt(i3);
                if (auo.wyK != i) {
                    sparseArray.put(this.mNY.keyAt(i3), auo);
                }
                C4990ab.m7419v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", Integer.valueOf(auo.key), Long.valueOf(auo.wyJ), Integer.valueOf(auo.length));
            }
            this.mNY = sparseArray;
            bCi();
        }
        if (i < 0) {
            bCj();
            while (i2 < 25) {
                new File(this.mNW, C20908f.m32148wo(25)).delete();
                i2++;
            }
            AppMethodBeat.m2505o(21265);
            return;
        }
        C20908f.m32147d((Closeable) this.mNX.get(i));
        new File(this.mNW, C20908f.m32148wo(i)).delete();
        AppMethodBeat.m2505o(21265);
    }

    /* renamed from: d */
    static void m32147d(Closeable closeable) {
        AppMethodBeat.m2504i(21266);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(21266);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.DiskCache", "want close %s fail: %s", closeable.getClass().getName(), e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(21266);
    }

    /* Access modifiers changed, original: final */
    public final void bCi() {
        AppMethodBeat.m2504i(21267);
        aun aun = new aun();
        for (int i = 0; i < this.mNY.size(); i++) {
            aun.wyI.add(0, (auo) this.mNY.valueAt(i));
            C4990ab.m7419v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", Integer.valueOf(r0.key), Long.valueOf(r0.wyJ), Integer.valueOf(r0.length), Integer.valueOf(r0.wyK));
        }
        try {
            C5046bo.m7591z(new File(this.mNW, "cache.idx").getAbsolutePath(), aun.toByteArray());
            AppMethodBeat.m2505o(21267);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.DiskCache", "save index data error: %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            AppMethodBeat.m2505o(21267);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bCj() {
        AppMethodBeat.m2504i(21268);
        if (this.mNX == null || this.mNX.size() <= 0) {
            AppMethodBeat.m2505o(21268);
        } else {
            for (RandomAccessFile d : this.mNX) {
                C20908f.m32147d(d);
            }
            AppMethodBeat.m2505o(21268);
        }
    }

    /* renamed from: wn */
    public final Bitmap mo36230wn(int i) {
        AppMethodBeat.m2504i(21269);
        if (this.mNX == null || this.mNX.size() <= 0) {
            C4990ab.m7412e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            AppMethodBeat.m2505o(21269);
            return null;
        }
        auo auo = (auo) this.mNY.get(i);
        if (auo != null) {
            byte[] bArr = new byte[auo.length];
            try {
                C4990ab.m7411d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", Long.valueOf(auo.wyJ), Integer.valueOf(auo.length));
                RandomAccessFile randomAccessFile = (RandomAccessFile) this.mNX.get(auo.wyK);
                randomAccessFile.seek(auo.wyJ);
                randomAccessFile.read(bArr, 0, auo.length);
                Bitmap bQ = C5056d.m7652bQ(bArr);
                if (bQ != null) {
                    C4990ab.m7411d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
                } else {
                    this.mNY.remove(i);
                }
                AppMethodBeat.m2505o(21269);
                return bQ;
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", Integer.valueOf(i), e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                this.mNY.remove(i);
                AppMethodBeat.m2505o(21269);
                return null;
            }
        }
        AppMethodBeat.m2505o(21269);
        return null;
    }

    /* renamed from: wo */
    private static String m32148wo(int i) {
        AppMethodBeat.m2504i(21270);
        String str = "cache.data" + (i == 0 ? "" : ".".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(21270);
        return str;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized int bCk() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(21271);
            if (this.mNX == null || this.mNX.size() <= 0) {
                AppMethodBeat.m2505o(21271);
            } else {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.mNX) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
                AppMethodBeat.m2505o(21271);
            }
        }
        return i;
    }

    public final void bCl() {
        AppMethodBeat.m2504i(21272);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.mNZ).commit();
        AppMethodBeat.m2505o(21272);
    }
}
