package com.tencent.p177mm.plugin.p878a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.a.h */
public final class C41215h extends C37990a {
    private int[] aZD;
    long duration;
    private long[] gkA;
    private int[] gkB;
    private int[] gkC;
    long gki;
    long[] gkl;
    List<C26533g> gkn = new LinkedList();
    List<Pair> gko = new LinkedList();
    private long gks;
    private long gkt;
    private long gku;
    private long gkv;
    private long gkw;
    private int[] gkx;
    private int[] gky;
    private int[] gkz;

    public C41215h(int i, long j, int i2) {
        super(i, j, i2, 0);
        AppMethodBeat.m2504i(117852);
        AppMethodBeat.m2505o(117852);
    }

    /* renamed from: d */
    public final void mo65874d(RandomAccessFile randomAccessFile) {
        AppMethodBeat.m2504i(117853);
        byte[] bArr = new byte[8];
        int read = randomAccessFile.read(bArr);
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        while (true) {
            int i = read;
            if (i < 8) {
                break;
            }
            Object obj6;
            Object obj7;
            Object obj8;
            int readInt = C42258c.readInt(bArr, 0);
            int readInt2 = C42258c.readInt(bArr, 4);
            long j = 0;
            int i2;
            long j2;
            int i3;
            byte[] bArr2;
            if (readInt2 == C37990a.aWT) {
                this.gks = randomAccessFile.getFilePointer();
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    byte[] bArr3 = new byte[8];
                    if (randomAccessFile.read(bArr3, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr3, 0);
                        long j3 = 8 * ((long) read);
                        if (j3 > ((long) (readInt - 16)) || j3 <= 0) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(read)));
                            j = -1;
                        } else {
                            int i4 = 0;
                            int i5 = 0;
                            this.gkl = new long[(((int) (this.duration / this.gki)) + 2)];
                            read = 1;
                            this.gkl[0] = 1;
                            long j4 = 0;
                            int read2 = randomAccessFile.read(bArr3);
                            while (read2 >= 8) {
                                j4 += (long) read2;
                                int readInt3 = C42258c.readInt(bArr3, 0);
                                int readInt4 = C42258c.readInt(bArr3, 4);
                                read2 = 0;
                                i2 = i5;
                                while (read2 < readInt3) {
                                    C26533g c26533g = new C26533g();
                                    c26533g.gkq = (long) readInt4;
                                    this.gkn.add(c26533g);
                                    i5 = i4 + readInt4;
                                    i2++;
                                    while (((long) i5) >= this.gki && read < this.gkl.length) {
                                        i5 = (int) (((long) i5) - this.gki);
                                        this.gkl[read] = (long) i2;
                                        read++;
                                    }
                                    read2++;
                                    i4 = i5;
                                }
                                if (j4 >= j3) {
                                    C4990ab.m7410d("MicroMsg.StblAtom", "read stts Atom end");
                                    i5 = i2;
                                    break;
                                }
                                read2 = randomAccessFile.read(bArr3);
                                i5 = i2;
                            }
                            if (read < this.gkl.length) {
                                this.gkl[read] = (long) i5;
                            }
                            j = 8 + j4;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (readInt2 == C37990a.aWW) {
                this.gkt = randomAccessFile.getFilePointer();
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    byte[] bArr4 = new byte[12];
                    if (randomAccessFile.read(bArr4, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "stsc read entry count error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr4, 0);
                        j2 = 12 * ((long) read);
                        if (j2 > ((long) (readInt - 16)) || j2 <= 0) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(read)));
                            j = -1;
                        } else {
                            C4990ab.m7410d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(read)));
                            this.gkx = new int[read];
                            this.gky = new int[read];
                            i3 = 0;
                            j = 0;
                            readInt2 = randomAccessFile.read(bArr4);
                            while (readInt2 >= 12) {
                                j += (long) readInt2;
                                this.gkx[i3] = C42258c.readInt(bArr4, 0);
                                this.gky[i3] = C42258c.readInt(bArr4, 4);
                                i3++;
                                if (j >= j2) {
                                    C4990ab.m7410d("MicroMsg.StblAtom", "read stsc atom end");
                                    break;
                                }
                                readInt2 = randomAccessFile.read(bArr4);
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj8 = 1;
                obj6 = obj5;
                obj7 = obj4;
            } else if (readInt2 == C37990a.aWZ) {
                this.gku = randomAccessFile.getFilePointer();
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    bArr2 = new byte[4];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "stco read entry count error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr2, 0);
                        j2 = 4 * ((long) read);
                        if (j2 <= 0 || j2 > ((long) (readInt - 16))) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(read)));
                            j = -1;
                        } else {
                            this.gkz = new int[(read + 1)];
                            i3 = 1;
                            j = 0;
                            readInt2 = randomAccessFile.read(bArr2);
                            while (readInt2 >= 4) {
                                j += (long) readInt2;
                                i2 = i3 + 1;
                                this.gkz[i3] = C42258c.readInt(bArr2, 0);
                                if (j >= j2) {
                                    C4990ab.m7410d("MicroMsg.StblAtom", "read stco atom end");
                                    break;
                                } else {
                                    readInt2 = randomAccessFile.read(bArr2);
                                    i3 = i2;
                                }
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj2 = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (readInt2 == C37990a.aXa) {
                this.gkv = randomAccessFile.getFilePointer();
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "co64 read entry count error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr2, 0);
                        j2 = 8 * ((long) read);
                        if (j2 <= 0 || j2 > ((long) (readInt - 16))) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(read)));
                            j = -1;
                        } else {
                            this.gkA = new long[(read + 1)];
                            i3 = 1;
                            readInt2 = randomAccessFile.read(bArr2);
                            j = 0;
                            while (readInt2 >= 8) {
                                j += (long) readInt2;
                                i2 = i3 + 1;
                                this.gkA[i3] = C42258c.m74642af(bArr2);
                                if (j >= j2) {
                                    C4990ab.m7410d("MicroMsg.StblAtom", "read stco atom end");
                                    break;
                                } else {
                                    readInt2 = randomAccessFile.read(bArr2);
                                    i3 = i2;
                                }
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj2 = 1;
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            } else if (readInt2 == C37990a.aWX) {
                this.gkw = randomAccessFile.getFilePointer();
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    byte[] bArr5 = new byte[4];
                    if (randomAccessFile.read(bArr5, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "stsz read sample size error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr5, 0);
                        if (read > 0) {
                            this.aZD = new int[1];
                            this.aZD[0] = read;
                            C4990ab.m7416i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(read)));
                            j = 8;
                        } else if (randomAccessFile.read(bArr5, 0, 4) < 4) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stsz read entry count error");
                            j = -1;
                        } else {
                            read = C42258c.readInt(bArr5, 0);
                            j2 = 4 * ((long) read);
                            if (j2 <= 0 || j2 > ((long) (readInt - 20))) {
                                C4990ab.m7420w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(read)));
                                j = -1;
                            } else {
                                this.aZD = new int[(read + 1)];
                                i3 = 1;
                                readInt2 = randomAccessFile.read(bArr5);
                                j = 0;
                                while (readInt2 >= 4) {
                                    j += (long) readInt2;
                                    i2 = i3 + 1;
                                    this.aZD[i3] = C42258c.readInt(bArr5, 0);
                                    if (j >= j2) {
                                        C4990ab.m7410d("MicroMsg.StblAtom", "read stsz atom end");
                                        break;
                                    } else {
                                        readInt2 = randomAccessFile.read(bArr5);
                                        i3 = i2;
                                    }
                                }
                                j += 12;
                            }
                        }
                    }
                } else {
                    j = -1;
                }
                obj7 = 1;
                obj6 = obj5;
                obj8 = obj3;
            } else if (readInt2 == C37990a.aWU) {
                if (C42258c.m74640a(randomAccessFile, 4)) {
                    byte[] bArr6 = new byte[4];
                    if (randomAccessFile.read(bArr6, 0, 4) < 4) {
                        C4990ab.m7420w("MicroMsg.StblAtom", "stss rread entry count error");
                        j = -1;
                    } else {
                        read = C42258c.readInt(bArr6, 0);
                        j2 = 4 * ((long) read);
                        if (j2 <= 0 || j2 > ((long) (readInt - 16))) {
                            C4990ab.m7420w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(read)));
                            j = -1;
                        } else {
                            this.gkB = new int[read];
                            i3 = 0;
                            readInt2 = randomAccessFile.read(bArr6);
                            j = 0;
                            while (readInt2 >= 4) {
                                j += (long) readInt2;
                                i2 = i3 + 1;
                                this.gkB[i3] = C42258c.readInt(bArr6, 0);
                                if (j >= j2) {
                                    C4990ab.m7410d("MicroMsg.StblAtom", "read stss atom end");
                                    break;
                                } else {
                                    readInt2 = randomAccessFile.read(bArr6);
                                    i3 = i2;
                                }
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj6 = 1;
                obj7 = obj4;
                obj8 = obj3;
            } else {
                obj6 = obj5;
                obj7 = obj4;
                obj8 = obj3;
            }
            if (C42258c.m74640a(randomAccessFile, (((long) readInt) - j) - ((long) i))) {
                if (obj != null && obj2 != null && obj8 != null && obj7 != null && obj6 != null) {
                    C4990ab.m7416i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                read = randomAccessFile.read(bArr);
                obj5 = obj6;
                obj4 = obj7;
                obj3 = obj8;
            } else {
                IOException iOException = new IOException("skip file error.");
                AppMethodBeat.m2505o(117853);
                throw iOException;
            }
        }
        aoa();
        AppMethodBeat.m2505o(117853);
    }

    /* renamed from: mM */
    private int m71752mM(int i) {
        for (int i2 = 0; i2 < this.gkC.length; i2++) {
            if (i <= this.gkC[i2]) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: mN */
    private long m71753mN(int i) {
        if (this.gkz != null) {
            return (long) this.gkz[i];
        }
        if (this.gkA != null) {
            return this.gkA[i];
        }
        return 0;
    }

    private boolean aoa() {
        int i;
        int i2;
        int i3;
        long j;
        C26533g c26533g;
        AppMethodBeat.m2504i(117854);
        int length = (this.gkz != null ? this.gkz.length : this.gkA.length) - 1;
        int length2 = this.gkx.length;
        for (i = 1; i < length2; i++) {
            this.gkx[i - 1] = this.gkx[i] - this.gkx[i - 1];
        }
        this.gkx[length2 - 1] = (length - this.gkx[length2 - 1]) + 1;
        this.gkC = new int[(length + 1)];
        this.gkC[0] = 0;
        length = 1;
        for (int i4 = 0; i4 < length2; i4++) {
            i2 = this.gkx[i4];
            i3 = this.gky[i4];
            for (i = 0; i < i2; i++) {
                int[] iArr = this.gkC;
                iArr[length] = iArr[length - 1] + i3;
                length++;
            }
        }
        for (i = 0; i < this.gkl.length; i++) {
            i2 = (int) this.gkl[i];
            i3 = m71752mM(i2);
            length = this.gkC[i3 - 1] + 1;
            if (this.aZD.length == 1) {
                j = ((long) this.aZD[0]) * ((long) (i2 - length));
            } else {
                j = 0;
                while (length <= i2) {
                    j += (long) this.aZD[length];
                    length++;
                }
            }
            this.gkl[i] = j + m71753mN(i3);
        }
        int i5 = 1;
        int i6 = 0;
        long j2 = 0;
        j = 0;
        for (C26533g c26533g2 : this.gkn) {
            c26533g2.size = this.aZD[i5];
            length = m71752mM(i5);
            if (length != i6) {
                c26533g2.start = m71753mN(length);
            } else {
                c26533g2.start = j;
            }
            j = c26533g2.start + ((long) c26533g2.size);
            j2 += c26533g2.gkq;
            c26533g2.gkq = (long) ((((((float) j2) * 1.0f) / ((float) this.gki)) * 1000.0f) * 1000.0f);
            c26533g2.f13667id = i5;
            i5++;
            i6 = length;
        }
        i = 0;
        while (true) {
            length = i;
            if (length < this.gkB.length) {
                c26533g2 = (C26533g) this.gkn.get(this.gkB[length] - 1);
                c26533g2.gkr = 1;
                C4990ab.m7411d("MicroMsg.StblAtom", "stss key frame [%s %s]", r2.first, new Pair(Integer.valueOf(this.gkB[length] - 1), Long.valueOf(c26533g2.gkq)).second);
                this.gko.add(r2);
                i = length + 1;
            } else {
                AppMethodBeat.m2505o(117854);
                return true;
            }
        }
    }
}
