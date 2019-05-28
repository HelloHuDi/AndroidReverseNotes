package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class f {
    private long duration;
    private long egJ;
    private String filePath;
    private long gki;
    private long[] gkl;
    public int gkm;
    private List<g> gkn;
    private List<Pair> gko;
    public int gkp = 0;

    public final int anZ() {
        int i;
        AppMethodBeat.i(117847);
        try {
            if (this.gko != null) {
                if (this.gkp == 0) {
                    this.gkp = (int) ((((Long) ((Pair) this.gko.get(this.gko.size() - 1)).second).longValue() / 1000) / 1000);
                }
                i = this.gkp;
            } else {
                i = 0;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Mp4Parser", e, "get last key frame error.", new Object[0]);
            i = 0;
        }
        AppMethodBeat.o(117847);
        return i;
    }

    @TargetApi(5)
    public final boolean b(int i, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        AppMethodBeat.i(117848);
        try {
            if (this.gko != null) {
                boolean z2;
                int size = this.gko.size();
                long j = 1000 * (((long) i) * 1000);
                pInt2.value = 0;
                pInt.value = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    Pair pair = (Pair) this.gko.get(i2);
                    if (((Long) pair.second).longValue() > j) {
                        pInt2.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                        z2 = true;
                        break;
                    }
                    pInt.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    try {
                        pInt.value = (int) ((((Long) ((Pair) this.gko.get(size - 1)).second).longValue() / 1000) / 1000);
                        pInt2.value = i;
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = z2;
                        ab.printErrStackTrace("MicroMsg.Mp4Parser", e, "seekVFrame seekTime[%d]", Integer.valueOf(i));
                        ab.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                        AppMethodBeat.o(117848);
                        return z;
                    }
                }
                ab.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                AppMethodBeat.o(117848);
                return z;
            }
            AppMethodBeat.o(117848);
            return false;
        } catch (Exception e3) {
            e = e3;
            z = false;
            ab.printErrStackTrace("MicroMsg.Mp4Parser", e, "seekVFrame seekTime[%d]", Integer.valueOf(i));
            ab.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
            AppMethodBeat.o(117848);
            return z;
        }
    }

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (this.gkl == null) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        int length = this.gkl.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.gkl[i];
        long j2 = this.gkl[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int cK(int i, int i2) {
        int i3 = 0;
        if (this.gkl == null) {
            return 0;
        }
        int i4;
        long j = (long) (i + i2);
        int i5 = 0;
        while (true) {
            i4 = i3;
            if (i5 >= this.gkl.length) {
                break;
            } else if (this.gkl[i5] == j) {
                i4 = i5;
                break;
            } else {
                if (this.gkl[i5] >= j) {
                    if (this.gkl[i5] > j) {
                        break;
                    }
                    i3 = i4;
                } else {
                    i3 = i5;
                }
                i5++;
            }
        }
        return i4;
    }

    private static i a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        AppMethodBeat.i(117850);
        ab.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (c.a(randomAccessFile, j)) {
            i iVar = (i) c.a(randomAccessFile, bArr, a.aWk);
            AppMethodBeat.o(117850);
            return iVar;
        }
        AppMethodBeat.o(117850);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0155 A:{SYNTHETIC, Splitter:B:41:0x0155} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0173 A:{SYNTHETIC, Splitter:B:49:0x0173} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean v(String str, long j) {
        Throwable e;
        AppMethodBeat.i(117849);
        this.filePath = null;
        this.gkl = null;
        this.gkm = 0;
        this.duration = 0;
        this.gki = 0;
        this.egJ = 0;
        if (this.gkn != null) {
            this.gkn.clear();
        }
        if (this.gko != null) {
            this.gko.clear();
        }
        this.gkp = 0;
        this.filePath = str;
        this.egJ = j;
        File file = new File(this.filePath);
        if (file.exists()) {
            RandomAccessFile randomAccessFile;
            try {
                byte[] bArr = new byte[8];
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    a a = a(randomAccessFile, bArr, this.egJ);
                    while (a != null) {
                        ab.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.gjN);
                        e b = i.b(randomAccessFile, bArr);
                        if (b == null || !b.a(randomAccessFile, bArr)) {
                            ab.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                            a = null;
                        } else {
                            Object obj;
                            if (b.gkj == ((long) e.gkf)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                long endPos = a.getEndPos() - randomAccessFile.getFilePointer();
                                ab.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(endPos)));
                                a = a(randomAccessFile, bArr, endPos);
                            } else {
                                this.gki = b.gki;
                                this.duration = b.duration;
                                ab.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.gki + " duration: " + this.duration);
                                randomAccessFile.seek(b.gkk);
                                h hVar = (h) c.a(randomAccessFile, bArr, a.aWn);
                                if (hVar != null) {
                                    hVar.duration = this.duration;
                                    hVar.gki = this.gki;
                                    hVar.d(randomAccessFile);
                                    this.gkl = hVar.gkl;
                                    this.gkm = this.gkl.length - 2;
                                    this.gkn = hVar.gkn;
                                    this.gko = hVar.gko;
                                }
                            }
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(117849);
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.Mp4Parser", e, "", new Object[0]);
                        ab.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e.toString());
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(117849);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(117849);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                ab.printErrStackTrace("MicroMsg.Mp4Parser", e, "", new Object[0]);
                ab.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e.toString());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Mp4Parser", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(117849);
                return false;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                        ab.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(117849);
                throw e;
            }
        }
        AppMethodBeat.o(117849);
        return false;
    }
}
