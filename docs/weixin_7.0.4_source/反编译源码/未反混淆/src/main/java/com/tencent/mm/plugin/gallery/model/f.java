package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    boolean dirty = true;
    private File mNW;
    List<RandomAccessFile> mNX;
    SparseArray<auo> mNY;
    int mNZ;

    f(File file) {
        AppMethodBeat.i(21262);
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            ab.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", file.getAbsolutePath(), Boolean.valueOf(mkdirs));
        }
        this.mNW = file;
        this.mNY = new SparseArray();
        AppMethodBeat.o(21262);
    }

    /* Access modifiers changed, original: final */
    public final void bCh() {
        AppMethodBeat.i(21263);
        File file = new File(this.mNW, "cache.idx");
        aun aun = new aun();
        String absolutePath = file.getAbsolutePath();
        if (!bo.isNullOrNil(absolutePath)) {
            try {
                aun.parseFrom(bo.readFromFile(absolutePath));
            } catch (Exception e) {
                ab.e("MicroMsg.DiskCache", "load index file error");
                ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                wm(-1);
                aun = new aun();
            } catch (OutOfMemoryError e2) {
                ab.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", Long.valueOf(file.length()));
                ab.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                wm(-1);
                aun = new aun();
            }
        }
        this.mNY.clear();
        Iterator it = aun.wyI.iterator();
        while (it.hasNext()) {
            auo auo = (auo) it.next();
            this.mNY.put(auo.key, auo);
        }
        AppMethodBeat.o(21263);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void wl(int i) {
        synchronized (this) {
            AppMethodBeat.i(21264);
            if (i >= 0) {
                try {
                    if (this.mNX != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mNW, wo(i)), "rw");
                        this.mNX.remove(i);
                        this.mNX.add(i, randomAccessFile);
                        AppMethodBeat.o(21264);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.DiskCache", "create data file error: %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.mNX = null;
                    AppMethodBeat.o(21264);
                }
            }
            this.mNX = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.mNX.add(new RandomAccessFile(new File(this.mNW, wo(i2)), "rw"));
            }
            AppMethodBeat.o(21264);
        }
        return;
    }

    /* Access modifiers changed, original: final */
    public final void wm(int i) {
        int i2 = 0;
        AppMethodBeat.i(21265);
        if (this.mNX == null || this.mNX.size() <= 0) {
            AppMethodBeat.o(21265);
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
                ab.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", Integer.valueOf(auo.key), Long.valueOf(auo.wyJ), Integer.valueOf(auo.length));
            }
            this.mNY = sparseArray;
            bCi();
        }
        if (i < 0) {
            bCj();
            while (i2 < 25) {
                new File(this.mNW, wo(25)).delete();
                i2++;
            }
            AppMethodBeat.o(21265);
            return;
        }
        d((Closeable) this.mNX.get(i));
        new File(this.mNW, wo(i)).delete();
        AppMethodBeat.o(21265);
    }

    static void d(Closeable closeable) {
        AppMethodBeat.i(21266);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(21266);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.DiskCache", "want close %s fail: %s", closeable.getClass().getName(), e.getMessage());
                ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(21266);
    }

    /* Access modifiers changed, original: final */
    public final void bCi() {
        AppMethodBeat.i(21267);
        aun aun = new aun();
        for (int i = 0; i < this.mNY.size(); i++) {
            aun.wyI.add(0, (auo) this.mNY.valueAt(i));
            ab.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", Integer.valueOf(r0.key), Long.valueOf(r0.wyJ), Integer.valueOf(r0.length), Integer.valueOf(r0.wyK));
        }
        try {
            bo.z(new File(this.mNW, "cache.idx").getAbsolutePath(), aun.toByteArray());
            AppMethodBeat.o(21267);
        } catch (Exception e) {
            ab.e("MicroMsg.DiskCache", "save index data error: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            AppMethodBeat.o(21267);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bCj() {
        AppMethodBeat.i(21268);
        if (this.mNX == null || this.mNX.size() <= 0) {
            AppMethodBeat.o(21268);
        } else {
            for (RandomAccessFile d : this.mNX) {
                d(d);
            }
            AppMethodBeat.o(21268);
        }
    }

    public final Bitmap wn(int i) {
        AppMethodBeat.i(21269);
        if (this.mNX == null || this.mNX.size() <= 0) {
            ab.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            AppMethodBeat.o(21269);
            return null;
        }
        auo auo = (auo) this.mNY.get(i);
        if (auo != null) {
            byte[] bArr = new byte[auo.length];
            try {
                ab.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", Long.valueOf(auo.wyJ), Integer.valueOf(auo.length));
                RandomAccessFile randomAccessFile = (RandomAccessFile) this.mNX.get(auo.wyK);
                randomAccessFile.seek(auo.wyJ);
                randomAccessFile.read(bArr, 0, auo.length);
                Bitmap bQ = d.bQ(bArr);
                if (bQ != null) {
                    ab.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
                } else {
                    this.mNY.remove(i);
                }
                AppMethodBeat.o(21269);
                return bQ;
            } catch (Exception e) {
                ab.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", Integer.valueOf(i), e.getMessage());
                ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                this.mNY.remove(i);
                AppMethodBeat.o(21269);
                return null;
            }
        }
        AppMethodBeat.o(21269);
        return null;
    }

    private static String wo(int i) {
        AppMethodBeat.i(21270);
        String str = "cache.data" + (i == 0 ? "" : ".".concat(String.valueOf(i)));
        AppMethodBeat.o(21270);
        return str;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized int bCk() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(21271);
            if (this.mNX == null || this.mNX.size() <= 0) {
                AppMethodBeat.o(21271);
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
                    ab.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
                AppMethodBeat.o(21271);
            }
        }
        return i;
    }

    public final void bCl() {
        AppMethodBeat.i(21272);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.mNZ).commit();
        AppMethodBeat.o(21272);
    }
}
