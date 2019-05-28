package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c {
    private int bXj = 0;
    private final InputStream bXs;

    public c(InputStream inputStream) {
        this.bXs = inputStream;
    }

    public final void a(d dVar) {
        b(dVar);
        c(dVar);
        dVar.zn();
    }

    private void b(d dVar) {
        String o = a.o(this.bXs);
        int m = a.m(this.bXs);
        if (m <= 0 || m >= 1073741823) {
            throw new IOException("bad idSize: ".concat(String.valueOf(m)));
        }
        long n = a.n(this.bXs);
        this.bXj = m;
        dVar.a(o, m, n);
    }

    private void c(d dVar) {
        while (true) {
            try {
                int read = this.bXs.read();
                int m = a.m(this.bXs);
                long m2 = 4294967295L & ((long) a.m(this.bXs));
                switch (read) {
                    case 1:
                        a(m, m2, dVar);
                        break;
                    case 2:
                        b(m, m2, dVar);
                        break;
                    case 4:
                        c(m, m2, dVar);
                        break;
                    case 5:
                        d(m, m2, dVar);
                        break;
                    case 12:
                    case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        a(read, m, m2, dVar);
                        break;
                    default:
                        b(read, m, m2, dVar);
                        break;
                }
            } catch (EOFException e) {
                return;
            }
        }
    }

    private void a(int i, long j, d dVar) {
        dVar.a(a.a(this.bXs, this.bXj), a.c(this.bXs, j - ((long) this.bXj)), i, j);
    }

    private void b(int i, long j, d dVar) {
        dVar.a(a.m(this.bXs), a.a(this.bXs, this.bXj), a.m(this.bXs), a.a(this.bXs, this.bXj), i, j);
    }

    private void c(int i, long j, d dVar) {
        dVar.a(a.a(this.bXs, this.bXj), a.a(this.bXs, this.bXj), a.a(this.bXs, this.bXj), a.a(this.bXs, this.bXj), a.m(this.bXs), a.m(this.bXs), i, j);
    }

    private void d(int i, long j, d dVar) {
        int m = a.m(this.bXs);
        int m2 = a.m(this.bXs);
        int m3 = a.m(this.bXs);
        b[] bVarArr = new b[m3];
        for (int i2 = 0; i2 < m3; i2++) {
            bVarArr[i2] = a.a(this.bXs, this.bXj);
        }
        dVar.a(m, m2, bVarArr, i, j);
    }

    private void a(int i, int i2, long j, d dVar) {
        b a = dVar.a(i, i2, j);
        if (a == null) {
            a.d(this.bXs, j);
            return;
        }
        while (j > 0) {
            int read = this.bXs.read();
            long j2 = j - 1;
            switch (read) {
                case 1:
                    a.b(read, a.a(this.bXs, this.bXj));
                    a.d(this.bXs, (long) this.bXj);
                    j = j2 - ((long) (this.bXj << 1));
                    break;
                case 2:
                    j = j2 - ((long) b(a));
                    break;
                case 3:
                    j = j2 - ((long) c(a));
                    break;
                case 4:
                    j = j2 - ((long) d(a));
                    break;
                case 5:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 6:
                    j = j2 - ((long) e(a));
                    break;
                case 7:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 8:
                    j = j2 - ((long) f(a));
                    break;
                case 32:
                    j = j2 - ((long) g(a));
                    break;
                case 33:
                    j = j2 - ((long) h(a));
                    break;
                case 34:
                    j = j2 - ((long) i(a));
                    break;
                case 35:
                    j = j2 - ((long) a(read, a));
                    break;
                case 137:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 138:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX /*139*/:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 140:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case 141:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                    j = j2 - ((long) j(a));
                    break;
                case 144:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
                    j = j2 - ((long) a(read, a));
                    break;
                case d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                    j = j2 - ((long) a(a));
                    break;
                case 255:
                    a.b(read, a.a(this.bXs, this.bXj));
                    j = j2 - ((long) this.bXj);
                    break;
                default:
                    throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + read + " with " + this.bXs.available() + " bytes possibly remaining");
            }
        }
        a.zn();
    }

    private void b(int i, int i2, long j, d dVar) {
        byte[] bArr = new byte[((int) j)];
        a.a(this.bXs, bArr, j);
        dVar.a(i, i2, j, bArr);
    }

    private int a(b bVar) {
        bVar.a(a.m(this.bXs), a.a(this.bXs, this.bXj));
        return this.bXj + 4;
    }

    private int b(b bVar) {
        bVar.a(a.a(this.bXs, this.bXj), a.m(this.bXs), a.m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    private int c(b bVar) {
        bVar.b(a.a(this.bXs, this.bXj), a.m(this.bXs), a.m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    private int d(b bVar) {
        bVar.a(a.a(this.bXs, this.bXj), a.m(this.bXs));
        return this.bXj + 4;
    }

    private int e(b bVar) {
        bVar.b(a.a(this.bXs, this.bXj), a.m(this.bXs));
        return this.bXj + 4;
    }

    private int f(b bVar) {
        bVar.c(a.a(this.bXs, this.bXj), a.m(this.bXs), a.m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    private int g(b bVar) {
        b a = a.a(this.bXs, this.bXj);
        int m = a.m(this.bXs);
        b a2 = a.a(this.bXs, this.bXj);
        b a3 = a.a(this.bXs, this.bXj);
        a.d(this.bXs, (long) (this.bXj << 2));
        int m2 = a.m(this.bXs);
        int i = ((this.bXj * 7) + 4) + 4;
        short l = a.l(this.bXs);
        int i2 = i + 2;
        short s = (short) 0;
        int i3 = i2;
        while (s < l) {
            a.d(this.bXs, 2);
            s++;
            i3 = (zo() + 2) + i3;
        }
        short l2 = a.l(this.bXs);
        com.tencent.matrix.resource.c.a.a[] aVarArr = new com.tencent.matrix.resource.c.a.a[l2];
        s = (short) 0;
        int i4 = i3 + 2;
        while (s < l2) {
            b a4 = a.a(this.bXs, this.bXj);
            int read = this.bXs.read();
            com.tencent.matrix.resource.c.a.c fW = com.tencent.matrix.resource.c.a.c.fW(read);
            if (fW == null) {
                throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(read)));
            }
            aVarArr[s] = new com.tencent.matrix.resource.c.a.a(read, a4, a.a(this.bXs, fW, this.bXj));
            s++;
            i4 = ((this.bXj + 1) + fW.getSize(this.bXj)) + i4;
        }
        l2 = a.l(this.bXs);
        com.tencent.matrix.resource.c.a.a[] aVarArr2 = new com.tencent.matrix.resource.c.a.a[l2];
        i4 += 2;
        for (s = (short) 0; s < l2; s++) {
            aVarArr2[s] = new com.tencent.matrix.resource.c.a.a(this.bXs.read(), a.a(this.bXs, this.bXj), null);
            i4 += this.bXj + 1;
        }
        bVar.a(a, m, a2, a3, m2, aVarArr, aVarArr2);
        return i4;
    }

    private int h(b bVar) {
        b a = a.a(this.bXs, this.bXj);
        int m = a.m(this.bXs);
        b a2 = a.a(this.bXs, this.bXj);
        int m2 = a.m(this.bXs);
        byte[] bArr = new byte[m2];
        a.a(this.bXs, bArr, (long) m2);
        bVar.a(a, m, a2, bArr);
        return (((this.bXj + 4) + this.bXj) + 4) + m2;
    }

    private int i(b bVar) {
        b a = a.a(this.bXs, this.bXj);
        int m = a.m(this.bXs);
        int m2 = a.m(this.bXs);
        b a2 = a.a(this.bXs, this.bXj);
        int i = m2 * this.bXj;
        byte[] bArr = new byte[i];
        a.a(this.bXs, bArr, (long) i);
        bVar.a(a, m, m2, a2, bArr);
        return (((this.bXj + 4) + 4) + this.bXj) + i;
    }

    private int a(int i, b bVar) {
        b a = a.a(this.bXs, this.bXj);
        int m = a.m(this.bXs);
        int m2 = a.m(this.bXs);
        int read = this.bXs.read();
        com.tencent.matrix.resource.c.a.c fW = com.tencent.matrix.resource.c.a.c.fW(read);
        if (fW == null) {
            throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(read)));
        }
        int size = m2 * fW.getSize(this.bXj);
        byte[] bArr = new byte[size];
        a.a(this.bXs, bArr, (long) size);
        bVar.a(i, a, m, m2, read, bArr);
        return (((this.bXj + 4) + 4) + 1) + size;
    }

    private int j(b bVar) {
        bVar.d(a.a(this.bXs, this.bXj), a.m(this.bXs), a.m(this.bXs));
        return (this.bXj + 4) + 4;
    }

    private int zo() {
        int read = this.bXs.read();
        com.tencent.matrix.resource.c.a.c fW = com.tencent.matrix.resource.c.a.c.fW(read);
        if (fW == null) {
            throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(read)));
        }
        read = fW.getSize(this.bXj);
        a.d(this.bXs, (long) read);
        return read + 1;
    }
}
