package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.BitSet;

public final class d {
    public String cFI = "";
    public int count = 0;
    public long gjQ = -1;
    public String mUrl;
    public BitSet oLc = new BitSet();

    public static class a {
        public static byte[] a(BitSet bitSet) {
            AppMethodBeat.i(137402);
            byte[] bArr = new byte[(bitSet.size() / 8)];
            for (int i = 0; i < bitSet.size(); i++) {
                int i2;
                int i3 = i / 8;
                int i4 = 7 - (i % 8);
                byte b = bArr[i3];
                if (bitSet.get(i)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                bArr[i3] = (byte) ((i2 << i4) | b);
            }
            AppMethodBeat.o(137402);
            return bArr;
        }

        public static BitSet bb(byte[] bArr) {
            AppMethodBeat.i(137403);
            BitSet bitSet = new BitSet(bArr.length * 8);
            int i = 0;
            for (byte b : bArr) {
                int i2 = 7;
                while (i2 >= 0) {
                    boolean z;
                    int i3 = i + 1;
                    if (((b & (1 << i2)) >> i2) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bitSet.set(i, z);
                    i2--;
                    i = i3;
                }
            }
            AppMethodBeat.o(137403);
            return bitSet;
        }
    }

    public d(String str) {
        AppMethodBeat.i(137404);
        this.mUrl = str;
        AppMethodBeat.o(137404);
    }

    public final void bTE() {
        AppMethodBeat.i(137405);
        if (!TextUtils.isEmpty(this.cFI)) {
            e.y(this.cFI, a.a(this.oLc));
        }
        ab.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", this.oLc.toString());
        ab.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.oLc.cardinality());
        if (bTF()) {
            zx(1);
        }
        AppMethodBeat.o(137405);
    }

    public final void clearCache() {
        AppMethodBeat.i(137406);
        ab.i("MicroMsg.Music.IndexBitMgr", "clearCache");
        this.oLc = new BitSet(this.count);
        zx(0);
        if (!TextUtils.isEmpty(this.cFI)) {
            e.y(this.cFI, null);
        }
        AppMethodBeat.o(137406);
    }

    public final void zx(int i) {
        AppMethodBeat.i(137407);
        ab.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", Integer.valueOf(i));
        if (!TextUtils.isEmpty(this.cFI)) {
            e.cH(this.cFI, i);
        }
        AppMethodBeat.o(137407);
    }

    public final int getIndex(int i) {
        AppMethodBeat.i(137408);
        if (((long) i) > this.gjQ) {
            ab.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", Integer.valueOf(i), Long.valueOf(this.gjQ));
            AppMethodBeat.o(137408);
            return 0;
        }
        int i2 = i / Utility.DEFAULT_STREAM_BUFFER_SIZE;
        AppMethodBeat.o(137408);
        return i2;
    }

    public final boolean zy(int i) {
        AppMethodBeat.i(137409);
        boolean z = this.oLc.get(i);
        AppMethodBeat.o(137409);
        return z;
    }

    public final void zz(int i) {
        AppMethodBeat.i(137410);
        this.oLc.set(i);
        AppMethodBeat.o(137410);
    }

    public final void zA(int i) {
        AppMethodBeat.i(137411);
        this.oLc.set(i, false);
        AppMethodBeat.o(137411);
    }

    public final boolean eE(int i, int i2) {
        AppMethodBeat.i(137412);
        if (i < 0 || i2 < 0 || ((long) i) > this.gjQ || ((long) (i + i2)) > this.gjQ) {
            ab.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(this.gjQ));
            ab.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
            AppMethodBeat.o(137412);
            return false;
        }
        int index = getIndex(i);
        int index2 = getIndex(i + i2);
        int i3 = index;
        while (i3 <= index2) {
            if (zy(index)) {
                i3++;
            } else {
                ab.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", Integer.valueOf(i3));
                AppMethodBeat.o(137412);
                return false;
            }
        }
        AppMethodBeat.o(137412);
        return true;
    }

    private boolean bTF() {
        AppMethodBeat.i(137413);
        ab.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", Integer.valueOf(this.count), Integer.valueOf(this.oLc.cardinality()));
        if (this.count <= 0 || this.count != this.oLc.cardinality()) {
            AppMethodBeat.o(137413);
            return false;
        }
        AppMethodBeat.o(137413);
        return true;
    }
}
