package com.tencent.mm.plugin.music.cache;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public int Lp = -1;
    private byte[] buffer = new byte[81920];
    public int mSize = 0;
    public com.tencent.mm.plugin.music.g.a.a oKV;
    public d oKW;
    public h oKX;
    public int oKY = -1;
    public int oKZ = 0;

    public a(com.tencent.mm.plugin.music.g.a.a aVar) {
        AppMethodBeat.i(137398);
        this.oKV = aVar;
        AppMethodBeat.o(137398);
    }

    public final synchronized boolean zu(int i) {
        boolean z;
        z = this.Lp <= i && i <= this.Lp + 81920;
        return z;
    }

    public final synchronized boolean zv(int i) {
        boolean z;
        z = this.Lp <= i && i <= this.Lp + this.mSize;
        return z;
    }

    public final synchronized boolean bTx() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137399);
            if (this.Lp < 0 || this.mSize <= 0) {
                ab.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", Integer.valueOf(this.Lp), Integer.valueOf(this.mSize));
                AppMethodBeat.o(137399);
            } else {
                int[] iArr;
                byte[] bArr = new byte[this.mSize];
                System.arraycopy(this.buffer, 0, bArr, 0, this.mSize);
                this.oKX.c(bArr, (long) this.Lp, this.mSize);
                d dVar = this.oKW;
                int i = this.Lp;
                int i2 = this.mSize;
                if (i < 0 || i2 < 0 || ((long) i) > dVar.gjQ || ((long) (i + i2)) > dVar.gjQ) {
                    ab.i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(dVar.gjQ));
                    ab.e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    int[] iArr2 = new int[]{-1, -1};
                    int i3 = i + i2;
                    int index = dVar.getIndex(i);
                    int index2 = dVar.getIndex(i3);
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
                    if (((long) i3) == dVar.gjQ && ((index2 == 0 && i == 0) || (index2 > 0 && i <= index2 * Utility.DEFAULT_STREAM_BUFFER_SIZE))) {
                        ab.i("MicroMsg.Music.IndexBitMgr", "write to file end!");
                        iArr2[0] = index;
                        iArr2[1] = index2;
                    }
                    iArr = iArr2;
                }
                if (iArr == null) {
                    ab.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
                    AppMethodBeat.o(137399);
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    ab.d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    AppMethodBeat.o(137399);
                } else {
                    int i5;
                    for (i5 = iArr[0]; i5 <= iArr[1]; i5++) {
                        this.oKW.zz(i5);
                    }
                    i5 = iArr[0];
                    if (i5 > 0) {
                        if (!this.oKW.zy(i5 - 1) && this.oKY + this.oKZ == this.Lp && this.mSize > 0 && this.oKZ >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                            ab.i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", Integer.valueOf(i5));
                            z = true;
                        }
                    }
                    if (z) {
                        this.oKW.zz(iArr[0] - 1);
                    }
                    this.oKW.bTE();
                    AppMethodBeat.o(137399);
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void zw(int i) {
        this.oKY = this.Lp;
        this.oKZ = this.mSize;
        this.Lp = i;
        this.mSize = 0;
    }

    public final synchronized void u(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(137400);
        int i3 = i - this.Lp;
        this.mSize = i3 + i2;
        System.arraycopy(bArr, 0, this.buffer, i3, i2);
        AppMethodBeat.o(137400);
    }

    public final synchronized void d(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(137401);
        int i4 = i2 - this.Lp;
        this.mSize = i4 + i3;
        System.arraycopy(bArr, i, this.buffer, i4, i3);
        AppMethodBeat.o(137401);
    }
}
