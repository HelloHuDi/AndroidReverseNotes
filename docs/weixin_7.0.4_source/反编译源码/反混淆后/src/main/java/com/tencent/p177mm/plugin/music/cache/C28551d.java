package com.tencent.p177mm.plugin.music.cache;

import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.BitSet;

/* renamed from: com.tencent.mm.plugin.music.cache.d */
public final class C28551d {
    public String cFI = "";
    public int count = 0;
    public long gjQ = -1;
    public String mUrl;
    public BitSet oLc = new BitSet();

    /* renamed from: com.tencent.mm.plugin.music.cache.d$a */
    public static class C12660a {
        /* renamed from: a */
        public static byte[] m20650a(BitSet bitSet) {
            AppMethodBeat.m2504i(137402);
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
            AppMethodBeat.m2505o(137402);
            return bArr;
        }

        /* renamed from: bb */
        public static BitSet m20651bb(byte[] bArr) {
            AppMethodBeat.m2504i(137403);
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
            AppMethodBeat.m2505o(137403);
            return bitSet;
        }
    }

    public C28551d(String str) {
        AppMethodBeat.m2504i(137404);
        this.mUrl = str;
        AppMethodBeat.m2505o(137404);
    }

    public final void bTE() {
        AppMethodBeat.m2504i(137405);
        if (!TextUtils.isEmpty(this.cFI)) {
            C39432e.m67342y(this.cFI, C12660a.m20650a(this.oLc));
        }
        C4990ab.m7411d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", this.oLc.toString());
        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.oLc.cardinality());
        if (bTF()) {
            mo46619zx(1);
        }
        AppMethodBeat.m2505o(137405);
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(137406);
        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "clearCache");
        this.oLc = new BitSet(this.count);
        mo46619zx(0);
        if (!TextUtils.isEmpty(this.cFI)) {
            C39432e.m67342y(this.cFI, null);
        }
        AppMethodBeat.m2505o(137406);
    }

    /* renamed from: zx */
    public final void mo46619zx(int i) {
        AppMethodBeat.m2504i(137407);
        C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", Integer.valueOf(i));
        if (!TextUtils.isEmpty(this.cFI)) {
            C39432e.m67341cH(this.cFI, i);
        }
        AppMethodBeat.m2505o(137407);
    }

    public final int getIndex(int i) {
        AppMethodBeat.m2504i(137408);
        if (((long) i) > this.gjQ) {
            C4990ab.m7413e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", Integer.valueOf(i), Long.valueOf(this.gjQ));
            AppMethodBeat.m2505o(137408);
            return 0;
        }
        int i2 = i / Utility.DEFAULT_STREAM_BUFFER_SIZE;
        AppMethodBeat.m2505o(137408);
        return i2;
    }

    /* renamed from: zy */
    public final boolean mo46620zy(int i) {
        AppMethodBeat.m2504i(137409);
        boolean z = this.oLc.get(i);
        AppMethodBeat.m2505o(137409);
        return z;
    }

    /* renamed from: zz */
    public final void mo46621zz(int i) {
        AppMethodBeat.m2504i(137410);
        this.oLc.set(i);
        AppMethodBeat.m2505o(137410);
    }

    /* renamed from: zA */
    public final void mo46618zA(int i) {
        AppMethodBeat.m2504i(137411);
        this.oLc.set(i, false);
        AppMethodBeat.m2505o(137411);
    }

    /* renamed from: eE */
    public final boolean mo46616eE(int i, int i2) {
        AppMethodBeat.m2504i(137412);
        if (i < 0 || i2 < 0 || ((long) i) > this.gjQ || ((long) (i + i2)) > this.gjQ) {
            C4990ab.m7413e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(this.gjQ));
            C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
            AppMethodBeat.m2505o(137412);
            return false;
        }
        int index = getIndex(i);
        int index2 = getIndex(i + i2);
        int i3 = index;
        while (i3 <= index2) {
            if (mo46620zy(index)) {
                i3++;
            } else {
                C4990ab.m7411d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", Integer.valueOf(i3));
                AppMethodBeat.m2505o(137412);
                return false;
            }
        }
        AppMethodBeat.m2505o(137412);
        return true;
    }

    private boolean bTF() {
        AppMethodBeat.m2504i(137413);
        C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", Integer.valueOf(this.count), Integer.valueOf(this.oLc.cardinality()));
        if (this.count <= 0 || this.count != this.oLc.cardinality()) {
            AppMethodBeat.m2505o(137413);
            return false;
        }
        AppMethodBeat.m2505o(137413);
        return true;
    }
}
