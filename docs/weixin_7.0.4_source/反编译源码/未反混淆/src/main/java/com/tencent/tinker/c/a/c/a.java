package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;
import com.tencent.view.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public abstract class a {

    /* renamed from: com.tencent.tinker.c.a.c.a$1 */
    public class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream AAG;

        public AnonymousClass1(ByteArrayInputStream byteArrayInputStream) {
            this.AAG = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.AAG.read() & 255);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$4 */
    public class AnonymousClass4 implements b {
        final /* synthetic */ ByteArrayOutputStream AAI;

        public AnonymousClass4(ByteArrayOutputStream byteArrayOutputStream) {
            this.AAI = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AAI.write(i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$3 */
    public class AnonymousClass3 implements b {
        final /* synthetic */ ByteArrayOutputStream AAI;

        public AnonymousClass3(ByteArrayOutputStream byteArrayOutputStream) {
            this.AAI = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AAI.write(i);
        }
    }

    public final class a {
        private final b AAJ;

        public a(b bVar) {
            this.AAJ = bVar;
        }

        private void a(m mVar) {
            int i = 0;
            switch (mVar.dRL()) {
                case 0:
                    l.a(this.AAJ, 0, (long) mVar.readByte());
                    return;
                case 2:
                    l.a(this.AAJ, 2, (long) mVar.readShort());
                    return;
                case 3:
                    l.b(this.AAJ, 3, (long) mVar.readChar());
                    return;
                case 4:
                    l.a(this.AAJ, 4, (long) mVar.readInt());
                    return;
                case 6:
                    l.a(this.AAJ, 6, mVar.readLong());
                    return;
                case 16:
                    l.c(this.AAJ, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                    return;
                case 17:
                    l.c(this.AAJ, 17, Double.doubleToLongBits(mVar.readDouble()));
                    return;
                case 23:
                    l.b(this.AAJ, 23, (long) a.this.RL(mVar.dRP()));
                    return;
                case 24:
                    l.b(this.AAJ, 24, (long) a.this.RM(mVar.dRQ()));
                    return;
                case 25:
                    l.b(this.AAJ, 25, (long) a.this.RO(mVar.dRR()));
                    return;
                case 26:
                    l.b(this.AAJ, 26, (long) a.this.RP(mVar.dRT()));
                    return;
                case 27:
                    l.b(this.AAJ, 27, (long) a.this.RO(mVar.dRS()));
                    return;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    id(28, 0);
                    c(mVar);
                    return;
                case 29:
                    id(29, 0);
                    b(mVar);
                    return;
                case 30:
                    mVar.dRU();
                    id(30, 0);
                    return;
                case 31:
                    if (mVar.readBoolean()) {
                        i = 1;
                    }
                    id(31, i);
                    return;
                default:
                    throw new j("Unexpected type: " + Integer.toHexString(mVar.dRL()));
            }
        }

        public final void b(m mVar) {
            int dRN = mVar.dRN();
            o.a(this.AAJ, a.this.RM(mVar.Ayk));
            o.a(this.AAJ, dRN);
            for (int i = 0; i < dRN; i++) {
                o.a(this.AAJ, a.this.RL(mVar.dRO()));
                a(mVar);
            }
        }

        public final void c(m mVar) {
            int dRM = mVar.dRM();
            o.a(this.AAJ, dRM);
            for (int i = 0; i < dRM; i++) {
                a(mVar);
            }
        }

        private void id(int i, int i2) {
            this.AAJ.writeByte((i2 << 5) | i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$2 */
    public class AnonymousClass2 implements b {
        final /* synthetic */ ByteArrayOutputStream AyW;

        public AnonymousClass2(ByteArrayOutputStream byteArrayOutputStream) {
            this.AyW = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AyW.write(i);
        }
    }

    public abstract int RL(int i);

    public abstract int RM(int i);

    public abstract int RN(int i);

    public abstract int RO(int i);

    public abstract int RP(int i);

    public abstract int RQ(int i);

    public abstract int RR(int i);

    public abstract int RS(int i);

    public abstract int RT(int i);

    public abstract int RU(int i);

    public abstract int RV(int i);

    public abstract int RW(int i);

    public abstract int RX(int i);

    public abstract int RY(int i);

    public final com.tencent.tinker.a.a.e.a[] b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(RO(aVar.Axw), aVar.Axx);
        }
        return aVarArr2;
    }

    public final e.b[] b(e.b[] bVarArr) {
        e.b[] bVarArr2 = new e.b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            e.b bVar = bVarArr[i];
            bVarArr2[i] = new e.b(RP(bVar.Axy), bVar.Axx, RY(bVar.Axz));
        }
        return bVarArr2;
    }
}
