package com.tencent.p177mm.plugin.music.cache;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p1362g.p1493a.C34584a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.cache.a */
public final class C28550a {
    /* renamed from: Lp */
    public int f13697Lp = -1;
    private byte[] buffer = new byte[81920];
    public int mSize = 0;
    public C34584a oKV;
    public C28551d oKW;
    public C43322h oKX;
    public int oKY = -1;
    public int oKZ = 0;

    public C28550a(C34584a c34584a) {
        AppMethodBeat.m2504i(137398);
        this.oKV = c34584a;
        AppMethodBeat.m2505o(137398);
    }

    /* renamed from: zu */
    public final synchronized boolean mo46611zu(int i) {
        boolean z;
        z = this.f13697Lp <= i && i <= this.f13697Lp + 81920;
        return z;
    }

    /* renamed from: zv */
    public final synchronized boolean mo46612zv(int i) {
        boolean z;
        z = this.f13697Lp <= i && i <= this.f13697Lp + this.mSize;
        return z;
    }

    public final synchronized boolean bTx() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(137399);
            if (this.f13697Lp < 0 || this.mSize <= 0) {
                C4990ab.m7413e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", Integer.valueOf(this.f13697Lp), Integer.valueOf(this.mSize));
                AppMethodBeat.m2505o(137399);
            } else {
                int[] iArr;
                byte[] bArr = new byte[this.mSize];
                System.arraycopy(this.buffer, 0, bArr, 0, this.mSize);
                this.oKX.mo68872c(bArr, (long) this.f13697Lp, this.mSize);
                C28551d c28551d = this.oKW;
                int i = this.f13697Lp;
                int i2 = this.mSize;
                if (i < 0 || i2 < 0 || ((long) i) > c28551d.gjQ || ((long) (i + i2)) > c28551d.gjQ) {
                    C4990ab.m7417i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(c28551d.gjQ));
                    C4990ab.m7412e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    int[] iArr2 = new int[]{-1, -1};
                    int i3 = i + i2;
                    int index = c28551d.getIndex(i);
                    int index2 = c28551d.getIndex(i3);
                    for (i2 = index; i2 <= index2; i2++) {
                        int i4 = (i2 + 1) * Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        if (i2 * Utility.DEFAULT_STREAM_BUFFER_SIZE >= i && i4 <= i3) {
                            if (iArr2[0] == -1) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[0] > i2) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[1] == -1) {
                                iArr2[1] = i2;
                            }
                            if (iArr2[1] < i2) {
                                iArr2[1] = i2;
                            }
                        }
                    }
                    if (((long) i3) == c28551d.gjQ && ((index2 == 0 && i == 0) || (index2 > 0 && i <= index2 * Utility.DEFAULT_STREAM_BUFFER_SIZE))) {
                        C4990ab.m7416i("MicroMsg.Music.IndexBitMgr", "write to file end!");
                        iArr2[0] = index;
                        iArr2[1] = index2;
                    }
                    iArr = iArr2;
                }
                if (iArr == null) {
                    C4990ab.m7412e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
                    AppMethodBeat.m2505o(137399);
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    C4990ab.m7411d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    AppMethodBeat.m2505o(137399);
                } else {
                    int i5;
                    for (i5 = iArr[0]; i5 <= iArr[1]; i5++) {
                        this.oKW.mo46621zz(i5);
                    }
                    i5 = iArr[0];
                    if (i5 > 0) {
                        if (!this.oKW.mo46620zy(i5 - 1) && this.oKY + this.oKZ == this.f13697Lp && this.mSize > 0 && this.oKZ >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                            C4990ab.m7417i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", Integer.valueOf(i5));
                            z = true;
                        }
                    }
                    if (z) {
                        this.oKW.mo46621zz(iArr[0] - 1);
                    }
                    this.oKW.bTE();
                    AppMethodBeat.m2505o(137399);
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: zw */
    public final synchronized void mo46613zw(int i) {
        this.oKY = this.f13697Lp;
        this.oKZ = this.mSize;
        this.f13697Lp = i;
        this.mSize = 0;
    }

    /* renamed from: u */
    public final synchronized void mo46610u(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(137400);
        int i3 = i - this.f13697Lp;
        this.mSize = i3 + i2;
        System.arraycopy(bArr, 0, this.buffer, i3, i2);
        AppMethodBeat.m2505o(137400);
    }

    /* renamed from: d */
    public final synchronized void mo46609d(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(137401);
        int i4 = i2 - this.f13697Lp;
        this.mSize = i4 + i3;
        System.arraycopy(bArr, i, this.buffer, i4, i3);
        AppMethodBeat.m2505o(137401);
    }
}
