package com.tencent.matrix.resource.p164c;

import com.tencent.matrix.resource.p164c.p165a.C1100a;
import com.tencent.matrix.resource.p164c.p165a.C1101b;
import com.tencent.matrix.resource.p164c.p165a.C1102c;
import com.tencent.matrix.resource.p164c.p166b.C1111a;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.matrix.resource.c.c */
public final class C1113c {
    private int bXj = 0;
    private final InputStream bXs;

    public C1113c(InputStream inputStream) {
        this.bXs = inputStream;
    }

    /* renamed from: a */
    public final void mo4325a(C1114d c1114d) {
        m2463b(c1114d);
        m2466c(c1114d);
        c1114d.mo4314zn();
    }

    /* renamed from: b */
    private void m2463b(C1114d c1114d) {
        String o = C1111a.m2442o(this.bXs);
        int m = C1111a.m2440m(this.bXs);
        if (m <= 0 || m >= 1073741823) {
            throw new IOException("bad idSize: ".concat(String.valueOf(m)));
        }
        long n = C1111a.m2441n(this.bXs);
        this.bXj = m;
        c1114d.mo4312a(o, m, n);
    }

    /* renamed from: c */
    private void m2466c(C1114d c1114d) {
        while (true) {
            try {
                int read = this.bXs.read();
                int m = C1111a.m2440m(this.bXs);
                long m2 = 4294967295L & ((long) C1111a.m2440m(this.bXs));
                switch (read) {
                    case 1:
                        m2459a(m, m2, c1114d);
                        break;
                    case 2:
                        m2462b(m, m2, c1114d);
                        break;
                    case 4:
                        m2465c(m, m2, c1114d);
                        break;
                    case 5:
                        m2468d(m, m2, c1114d);
                        break;
                    case 12:
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        m2458a(read, m, m2, c1114d);
                        break;
                    default:
                        m2461b(read, m, m2, c1114d);
                        break;
                }
            } catch (EOFException e) {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m2459a(int i, long j, C1114d c1114d) {
        c1114d.mo4311a(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2437c(this.bXs, j - ((long) this.bXj)), i, j);
    }

    /* renamed from: b */
    private void m2462b(int i, long j, C1114d c1114d) {
        c1114d.mo4310a(C1111a.m2440m(this.bXs), C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2428a(this.bXs, this.bXj), i, j);
    }

    /* renamed from: c */
    private void m2465c(int i, long j, C1114d c1114d) {
        c1114d.mo4328a(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2428a(this.bXs, this.bXj), C1111a.m2428a(this.bXs, this.bXj), C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2440m(this.bXs), i, j);
    }

    /* renamed from: d */
    private void m2468d(int i, long j, C1114d c1114d) {
        int m = C1111a.m2440m(this.bXs);
        int m2 = C1111a.m2440m(this.bXs);
        int m3 = C1111a.m2440m(this.bXs);
        C1101b[] c1101bArr = new C1101b[m3];
        for (int i2 = 0; i2 < m3; i2++) {
            c1101bArr[i2] = C1111a.m2428a(this.bXs, this.bXj);
        }
        c1114d.mo4327a(m, m2, c1101bArr, i, j);
    }

    /* renamed from: a */
    private void m2458a(int i, int i2, long j, C1114d c1114d) {
        C1112b a = c1114d.mo4307a(i, i2, j);
        if (a == null) {
            C1111a.m2438d(this.bXs, j);
            return;
        }
        while (j > 0) {
            int read = this.bXs.read();
            long j2 = j - 1;
            switch (read) {
                case 1:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    C1111a.m2438d(this.bXs, (long) this.bXj);
                    j = j2 - ((long) (this.bXj << 1));
                    break;
                case 2:
                    j = j2 - ((long) m2460b(a));
                    break;
                case 3:
                    j = j2 - ((long) m2464c(a));
                    break;
                case 4:
                    j = j2 - ((long) m2467d(a));
                    break;
                case 5:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 6:
                    j = j2 - ((long) m2469e(a));
                    break;
                case 7:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 8:
                    j = j2 - ((long) m2470f(a));
                    break;
                case 32:
                    j = j2 - ((long) m2471g(a));
                    break;
                case 33:
                    j = j2 - ((long) m2472h(a));
                    break;
                case 34:
                    j = j2 - ((long) m2473i(a));
                    break;
                case 35:
                    j = j2 - ((long) m2456a(read, a));
                    break;
                case 137:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 138:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case C33333a.CTRL_INDEX /*139*/:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 140:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 141:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    j = j2 - ((long) m2474j(a));
                    break;
                case 144:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
                    j = j2 - ((long) m2456a(read, a));
                    break;
                case C31128d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                    j = j2 - ((long) m2457a(a));
                    break;
                case 255:
                    a.mo4319b(read, C1111a.m2428a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                default:
                    throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + read + " with " + this.bXs.available() + " bytes possibly remaining");
            }
        }
        a.mo4324zn();
    }

    /* renamed from: b */
    private void m2461b(int i, int i2, long j, C1114d c1114d) {
        byte[] bArr = new byte[((int) j)];
        C1111a.m2430a(this.bXs, bArr, j);
        c1114d.mo4326a(i, i2, j, bArr);
    }

    /* renamed from: a */
    private int m2457a(C1112b c1112b) {
        c1112b.mo4315a(C1111a.m2440m(this.bXs), C1111a.m2428a(this.bXs, this.bXj));
        return this.bXj + 4;
    }

    /* renamed from: b */
    private int m2460b(C1112b c1112b) {
        c1112b.mo4317a(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2440m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    /* renamed from: c */
    private int m2464c(C1112b c1112b) {
        c1112b.mo4321b(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2440m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    /* renamed from: d */
    private int m2467d(C1112b c1112b) {
        c1112b.mo4316a(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs));
        return this.bXj + 4;
    }

    /* renamed from: e */
    private int m2469e(C1112b c1112b) {
        c1112b.mo4320b(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs));
        return this.bXj + 4;
    }

    /* renamed from: f */
    private int m2470f(C1112b c1112b) {
        c1112b.mo4322c(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2440m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    /* renamed from: g */
    private int m2471g(C1112b c1112b) {
        C1101b a = C1111a.m2428a(this.bXs, this.bXj);
        int m = C1111a.m2440m(this.bXs);
        C1101b a2 = C1111a.m2428a(this.bXs, this.bXj);
        C1101b a3 = C1111a.m2428a(this.bXs, this.bXj);
        C1111a.m2438d(this.bXs, (long) (this.bXj << 2));
        int m2 = C1111a.m2440m(this.bXs);
        int i = ((this.bXj * 7) + 4) + 4;
        short l = C1111a.m2439l(this.bXs);
        int i2 = i + 2;
        short s = (short) 0;
        int i3 = i2;
        while (s < l) {
            C1111a.m2438d(this.bXs, 2);
            s++;
            i3 = (m2475zo() + 2) + i3;
        }
        short l2 = C1111a.m2439l(this.bXs);
        C1100a[] c1100aArr = new C1100a[l2];
        s = (short) 0;
        int i4 = i3 + 2;
        while (s < l2) {
            C1101b a4 = C1111a.m2428a(this.bXs, this.bXj);
            int read = this.bXs.read();
            C1102c fW = C1102c.m2413fW(read);
            if (fW == null) {
                throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(read)));
            }
            c1100aArr[s] = new C1100a(read, a4, C1111a.m2429a(this.bXs, fW, this.bXj));
            s++;
            i4 = ((this.bXj + 1) + fW.getSize(this.bXj)) + i4;
        }
        l2 = C1111a.m2439l(this.bXs);
        C1100a[] c1100aArr2 = new C1100a[l2];
        i4 += 2;
        for (s = (short) 0; s < l2; s++) {
            c1100aArr2[s] = new C1100a(this.bXs.read(), C1111a.m2428a(this.bXs, this.bXj), null);
            i4 += this.bXj + 1;
        }
        c1112b.mo4313a(a, m, a2, a3, m2, c1100aArr, c1100aArr2);
        return i4;
    }

    /* renamed from: h */
    private int m2472h(C1112b c1112b) {
        C1101b a = C1111a.m2428a(this.bXs, this.bXj);
        int m = C1111a.m2440m(this.bXs);
        C1101b a2 = C1111a.m2428a(this.bXs, this.bXj);
        int m2 = C1111a.m2440m(this.bXs);
        byte[] bArr = new byte[m2];
        C1111a.m2430a(this.bXs, bArr, (long) m2);
        c1112b.mo4309a(a, m, a2, bArr);
        return (((this.bXj + 4) + this.bXj) + 4) + m2;
    }

    /* renamed from: i */
    private int m2473i(C1112b c1112b) {
        C1101b a = C1111a.m2428a(this.bXs, this.bXj);
        int m = C1111a.m2440m(this.bXs);
        int m2 = C1111a.m2440m(this.bXs);
        C1101b a2 = C1111a.m2428a(this.bXs, this.bXj);
        int i = m2 * this.bXj;
        byte[] bArr = new byte[i];
        C1111a.m2430a(this.bXs, bArr, (long) i);
        c1112b.mo4318a(a, m, m2, a2, bArr);
        return (((this.bXj + 4) + 4) + this.bXj) + i;
    }

    /* renamed from: a */
    private int m2456a(int i, C1112b c1112b) {
        C1101b a = C1111a.m2428a(this.bXs, this.bXj);
        int m = C1111a.m2440m(this.bXs);
        int m2 = C1111a.m2440m(this.bXs);
        int read = this.bXs.read();
        C1102c fW = C1102c.m2413fW(read);
        if (fW == null) {
            throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(read)));
        }
        int size = m2 * fW.getSize(this.bXj);
        byte[] bArr = new byte[size];
        C1111a.m2430a(this.bXs, bArr, (long) size);
        c1112b.mo4308a(i, a, m, m2, read, bArr);
        return (((this.bXj + 4) + 4) + 1) + size;
    }

    /* renamed from: j */
    private int m2474j(C1112b c1112b) {
        c1112b.mo4323d(C1111a.m2428a(this.bXs, this.bXj), C1111a.m2440m(this.bXs), C1111a.m2440m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    /* renamed from: zo */
    private int m2475zo() {
        int read = this.bXs.read();
        C1102c fW = C1102c.m2413fW(read);
        if (fW == null) {
            throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(read)));
        }
        read = fW.getSize(this.bXj);
        C1111a.m2438d(this.bXs, (long) read);
        return read + 1;
    }
}
