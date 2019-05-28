package p690e.p691a.p692a.p695b.p696a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.view.C31128d;
import java.io.InputStream;
import java.util.LinkedList;
import p690e.p691a.p692a.p695b.C6090a;

/* renamed from: e.a.a.b.a.a */
public final class C6088a {
    private int Bzw = 0;
    private byte[] buffer;
    public int bufferSize;
    private int bxl = 0;
    public int bxm;
    public int bxn = 0;
    private int bxo = BaseClientBuilder.API_PRIORITY_OTHER;
    private int bxr = 67108864;
    private InputStream input;

    public final LinkedList<Integer> emt() {
        AppMethodBeat.m2504i(51876);
        LinkedList linkedList = new LinkedList();
        while (this.bxm < this.bufferSize) {
            linkedList.add(Integer.valueOf(mo13458vd()));
        }
        AppMethodBeat.m2505o(51876);
        return linkedList;
    }

    public final boolean ehX() {
        AppMethodBeat.m2504i(51877);
        if (mo13458vd() != 0) {
            AppMethodBeat.m2505o(51877);
            return true;
        }
        AppMethodBeat.m2505o(51877);
        return false;
    }

    /* renamed from: Vh */
    public final LinkedList<byte[]> mo13450Vh(int i) {
        AppMethodBeat.m2504i(51878);
        LinkedList<byte[]> linkedList = new LinkedList();
        int vd = mo13458vd();
        try {
            byte[] bArr = new byte[vd];
            System.arraycopy(this.buffer, this.bxm, bArr, 0, vd);
            linkedList.add(bArr);
            this.bxm = vd + this.bxm;
            vd = this.bxm;
            if (this.bxm == this.bufferSize) {
                AppMethodBeat.m2505o(51878);
                return linkedList;
            }
            int[] Vi = m9558Vi(vd);
            vd = Vi[0];
            while (C6090a.m9569fz(vd) == i) {
                this.bxm = Vi[1];
                vd = mo13458vd();
                bArr = new byte[vd];
                System.arraycopy(this.buffer, this.bxm, bArr, 0, vd);
                linkedList.add(bArr);
                this.bxm = vd + this.bxm;
                if (this.bxm == this.bufferSize) {
                    break;
                }
                Vi = m9558Vi(this.bxm);
                vd = Vi[0];
            }
            AppMethodBeat.m2505o(51878);
            return linkedList;
        } catch (OutOfMemoryError e) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("alloc bytes:".concat(String.valueOf(vd)));
            AppMethodBeat.m2505o(51878);
            throw outOfMemoryError;
        }
    }

    public final String readString() {
        AppMethodBeat.m2504i(51879);
        int vd = mo13458vd();
        String str;
        if (vd >= this.bufferSize - this.bxm || vd <= 0) {
            str = new String(m9559fr(vd), "UTF-8");
            AppMethodBeat.m2505o(51879);
            return str;
        }
        str = new String(this.buffer, this.bxm, vd, "UTF-8");
        this.bxm = vd + this.bxm;
        AppMethodBeat.m2505o(51879);
        return str;
    }

    public final C1332b emu() {
        AppMethodBeat.m2504i(51880);
        int vd = mo13458vd();
        C1332b bI;
        if (vd >= this.bufferSize - this.bxm || vd <= 0) {
            bI = C1332b.m2847bI(m9559fr(vd));
            AppMethodBeat.m2505o(51880);
            return bI;
        }
        bI = C1332b.m2848y(this.buffer, this.bxm, vd);
        this.bxm = vd + this.bxm;
        AppMethodBeat.m2505o(51880);
        return bI;
    }

    /* renamed from: vd */
    public final int mo13458vd() {
        AppMethodBeat.m2504i(51882);
        int vh = m9562vh();
        if (vh >= 0) {
            AppMethodBeat.m2505o(51882);
        } else {
            vh &= C31128d.MIC_SketchMark;
            byte vh2 = m9562vh();
            if (vh2 >= (byte) 0) {
                vh |= vh2 << 7;
            } else {
                vh |= (vh2 & C31128d.MIC_SketchMark) << 7;
                vh2 = m9562vh();
                if (vh2 >= (byte) 0) {
                    vh |= vh2 << 14;
                } else {
                    vh |= (vh2 & C31128d.MIC_SketchMark) << 14;
                    vh2 = m9562vh();
                    if (vh2 >= (byte) 0) {
                        vh |= vh2 << 21;
                    } else {
                        vh |= (vh2 & C31128d.MIC_SketchMark) << 21;
                        vh2 = m9562vh();
                        vh |= vh2 << 28;
                        if (vh2 < (byte) 0) {
                            int i = 0;
                            while (i < 5) {
                                if (m9562vh() >= (byte) 0) {
                                    AppMethodBeat.m2505o(51882);
                                } else {
                                    i++;
                                }
                            }
                            C6089b emx = C6089b.emx();
                            AppMethodBeat.m2505o(51882);
                            throw emx;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(51882);
        }
        return vh;
    }

    /* renamed from: ve */
    public final long mo13459ve() {
        AppMethodBeat.m2504i(51883);
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte vh = m9562vh();
            j |= ((long) (vh & C31128d.MIC_SketchMark)) << i;
            if ((vh & 128) == 0) {
                AppMethodBeat.m2505o(51883);
                return j;
            }
        }
        C6089b emx = C6089b.emx();
        AppMethodBeat.m2505o(51883);
        throw emx;
    }

    public final int eia() {
        AppMethodBeat.m2504i(51884);
        int vh = (((m9562vh() & 255) | ((m9562vh() & 255) << 8)) | ((m9562vh() & 255) << 16)) | ((m9562vh() & 255) << 24);
        AppMethodBeat.m2505o(51884);
        return vh;
    }

    public final long eib() {
        AppMethodBeat.m2504i(51885);
        byte vh = m9562vh();
        byte vh2 = m9562vh();
        long j = (((long) vh2) & 255) << 8;
        j = ((((((j | (((long) vh) & 255)) | ((((long) m9562vh()) & 255) << 16)) | ((((long) m9562vh()) & 255) << 24)) | ((((long) m9562vh()) & 255) << 32)) | ((((long) m9562vh()) & 255) << 40)) | ((((long) m9562vh()) & 255) << 48)) | ((((long) m9562vh()) & 255) << 56);
        AppMethodBeat.m2505o(51885);
        return j;
    }

    public C6088a(byte[] bArr, int i) {
        AppMethodBeat.m2504i(51886);
        this.buffer = bArr;
        this.bufferSize = i + 0;
        this.bxm = 0;
        this.input = null;
        AppMethodBeat.m2505o(51886);
    }

    /* renamed from: vf */
    private void m9561vf() {
        this.bufferSize += this.bxl;
        int i = this.Bzw + this.bufferSize;
        if (i > this.bxo) {
            this.bxl = i - this.bxo;
            this.bufferSize -= this.bxl;
            return;
        }
        this.bxl = 0;
    }

    /* renamed from: sd */
    public final boolean mo13457sd(boolean z) {
        AppMethodBeat.m2504i(51887);
        C6089b emv;
        if (this.bxm < this.bufferSize) {
            IllegalStateException illegalStateException = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
            AppMethodBeat.m2505o(51887);
            throw illegalStateException;
        } else if (this.Bzw + this.bufferSize != this.bxo) {
            this.Bzw += this.bufferSize;
            this.bxm = 0;
            this.bufferSize = this.input == null ? -1 : this.input.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (z) {
                    emv = C6089b.emv();
                    AppMethodBeat.m2505o(51887);
                    throw emv;
                }
                AppMethodBeat.m2505o(51887);
                return false;
            }
            m9561vf();
            int i = (this.Bzw + this.bufferSize) + this.bxl;
            if (i > this.bxr || i < 0) {
                emv = C6089b.emz();
                AppMethodBeat.m2505o(51887);
                throw emv;
            }
            AppMethodBeat.m2505o(51887);
            return true;
        } else if (z) {
            emv = C6089b.emv();
            AppMethodBeat.m2505o(51887);
            throw emv;
        } else {
            AppMethodBeat.m2505o(51887);
            return false;
        }
    }

    /* renamed from: vh */
    private byte m9562vh() {
        AppMethodBeat.m2504i(51888);
        if (this.bxm == this.bufferSize) {
            mo13457sd(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bxm;
        this.bxm = i + 1;
        byte b = bArr[i];
        AppMethodBeat.m2505o(51888);
        return b;
    }

    /* renamed from: fr */
    private byte[] m9559fr(int i) {
        AppMethodBeat.m2504i(51889);
        C6089b emw;
        byte[] bArr;
        int i2;
        if (i < 0) {
            emw = C6089b.emw();
            AppMethodBeat.m2505o(51889);
            throw emw;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            m9560fs((this.bxo - this.Bzw) - this.bxm);
            emw = C6089b.emv();
            AppMethodBeat.m2505o(51889);
            throw emw;
        } else if (i <= this.bufferSize - this.bxm) {
            bArr = new byte[i];
            System.arraycopy(this.buffer, this.bxm, bArr, 0, i);
            this.bxm += i;
            AppMethodBeat.m2505o(51889);
            return bArr;
        } else if (i < 2048) {
            byte[] bArr2 = new byte[i];
            i2 = this.bufferSize - this.bxm;
            System.arraycopy(this.buffer, this.bxm, bArr2, 0, i2);
            this.bxm = this.bufferSize;
            mo13457sd(true);
            while (i - i2 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, bArr2, i2, this.bufferSize);
                i2 += this.bufferSize;
                this.bxm = this.bufferSize;
                mo13457sd(true);
            }
            System.arraycopy(this.buffer, 0, bArr2, i2, i - i2);
            this.bxm = i - i2;
            AppMethodBeat.m2505o(51889);
            return bArr2;
        } else {
            int read;
            int i3 = this.bxm;
            int i4 = this.bufferSize;
            this.Bzw += this.bufferSize;
            this.bxm = 0;
            this.bufferSize = 0;
            i2 = i - (i4 - i3);
            LinkedList linkedList = new LinkedList();
            int i5 = i2;
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 2048)];
                i2 = 0;
                while (i2 < bArr3.length) {
                    read = this.input == null ? -1 : this.input.read(bArr3, i2, bArr3.length - i2);
                    if (read == -1) {
                        emw = C6089b.emv();
                        AppMethodBeat.m2505o(51889);
                        throw emw;
                    }
                    this.Bzw += read;
                    i2 += read;
                }
                i2 = i5 - bArr3.length;
                linkedList.add(bArr3);
                i5 = i2;
            }
            byte[] bArr4 = new byte[i];
            i2 = i4 - i3;
            System.arraycopy(this.buffer, i3, bArr4, 0, i2);
            int i6 = i2;
            for (read = 0; read < linkedList.size(); read++) {
                bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, bArr4, i6, bArr.length);
                i6 += bArr.length;
            }
            AppMethodBeat.m2505o(51889);
            return bArr4;
        }
    }

    /* renamed from: fs */
    private void m9560fs(int i) {
        AppMethodBeat.m2504i(51890);
        C6089b emw;
        if (i < 0) {
            emw = C6089b.emw();
            AppMethodBeat.m2505o(51890);
            throw emw;
        } else if ((this.Bzw + this.bxm) + i > this.bxo) {
            m9560fs((this.bxo - this.Bzw) - this.bxm);
            emw = C6089b.emv();
            AppMethodBeat.m2505o(51890);
            throw emw;
        } else if (i < this.bufferSize - this.bxm) {
            this.bxm += i;
            AppMethodBeat.m2505o(51890);
        } else {
            int i2 = this.bufferSize - this.bxm;
            this.Bzw += i2;
            this.bxm = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.input == null ? -1 : (int) this.input.skip((long) (i - i3));
                if (i2 <= 0) {
                    emw = C6089b.emv();
                    AppMethodBeat.m2505o(51890);
                    throw emw;
                }
                i3 += i2;
                this.Bzw = i2 + this.Bzw;
            }
            AppMethodBeat.m2505o(51890);
        }
    }

    /* renamed from: Vi */
    private int[] m9558Vi(int i) {
        AppMethodBeat.m2504i(51881);
        byte b = this.buffer[i];
        int i2 = i + 1;
        int[] iArr;
        if (b >= (byte) 0) {
            iArr = new int[]{b, i2};
            AppMethodBeat.m2505o(51881);
            return iArr;
        }
        int i3;
        int i4 = b & C31128d.MIC_SketchMark;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & C31128d.MIC_SketchMark) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & C31128d.MIC_SketchMark) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & C31128d.MIC_SketchMark) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                iArr = new int[]{b2, i3};
                                AppMethodBeat.m2505o(51881);
                                return iArr;
                            }
                        }
                        C6089b emx = C6089b.emx();
                        AppMethodBeat.m2505o(51881);
                        throw emx;
                    }
                }
            }
        }
        int[] iArr2 = new int[]{i4, i3};
        AppMethodBeat.m2505o(51881);
        return iArr2;
    }
}
