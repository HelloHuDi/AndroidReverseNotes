package com.tencent.tinker.p673c.p674a.p675c;

import com.tencent.tinker.p668a.p669a.C16316o;
import com.tencent.tinker.p668a.p669a.C31085l;
import com.tencent.tinker.p668a.p669a.C36548j;
import com.tencent.tinker.p668a.p669a.C5914e.C5912a;
import com.tencent.tinker.p668a.p669a.C5914e.C5913b;
import com.tencent.tinker.p668a.p669a.C5915m;
import com.tencent.tinker.p668a.p669a.p670b.C24423b;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;
import com.tencent.view.C31128d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.tinker.c.a.c.a */
public abstract class C5920a {

    /* renamed from: com.tencent.tinker.c.a.c.a$1 */
    public class C59191 implements C46809a {
        final /* synthetic */ ByteArrayInputStream AAG;

        public C59191(ByteArrayInputStream byteArrayInputStream) {
            this.AAG = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.AAG.read() & 255);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$4 */
    public class C59214 implements C24423b {
        final /* synthetic */ ByteArrayOutputStream AAI;

        public C59214(ByteArrayOutputStream byteArrayOutputStream) {
            this.AAI = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AAI.write(i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$3 */
    public class C59223 implements C24423b {
        final /* synthetic */ ByteArrayOutputStream AAI;

        public C59223(ByteArrayOutputStream byteArrayOutputStream) {
            this.AAI = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AAI.write(i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$a */
    public final class C5923a {
        private final C24423b AAJ;

        public C5923a(C24423b c24423b) {
            this.AAJ = c24423b;
        }

        /* renamed from: a */
        private void m9222a(C5915m c5915m) {
            int i = 0;
            switch (c5915m.dRL()) {
                case 0:
                    C31085l.m50143a(this.AAJ, 0, (long) c5915m.readByte());
                    return;
                case 2:
                    C31085l.m50143a(this.AAJ, 2, (long) c5915m.readShort());
                    return;
                case 3:
                    C31085l.m50144b(this.AAJ, 3, (long) c5915m.readChar());
                    return;
                case 4:
                    C31085l.m50143a(this.AAJ, 4, (long) c5915m.readInt());
                    return;
                case 6:
                    C31085l.m50143a(this.AAJ, 6, c5915m.readLong());
                    return;
                case 16:
                    C31085l.m50145c(this.AAJ, 16, ((long) Float.floatToIntBits(c5915m.readFloat())) << 32);
                    return;
                case 17:
                    C31085l.m50145c(this.AAJ, 17, Double.doubleToLongBits(c5915m.readDouble()));
                    return;
                case 23:
                    C31085l.m50144b(this.AAJ, 23, (long) C5920a.this.mo12572RL(c5915m.dRP()));
                    return;
                case 24:
                    C31085l.m50144b(this.AAJ, 24, (long) C5920a.this.mo12573RM(c5915m.dRQ()));
                    return;
                case 25:
                    C31085l.m50144b(this.AAJ, 25, (long) C5920a.this.mo12575RO(c5915m.dRR()));
                    return;
                case 26:
                    C31085l.m50144b(this.AAJ, 26, (long) C5920a.this.mo12576RP(c5915m.dRT()));
                    return;
                case 27:
                    C31085l.m50144b(this.AAJ, 27, (long) C5920a.this.mo12575RO(c5915m.dRS()));
                    return;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    m9223id(28, 0);
                    mo12590c(c5915m);
                    return;
                case 29:
                    m9223id(29, 0);
                    mo12589b(c5915m);
                    return;
                case 30:
                    c5915m.dRU();
                    m9223id(30, 0);
                    return;
                case 31:
                    if (c5915m.readBoolean()) {
                        i = 1;
                    }
                    m9223id(31, i);
                    return;
                default:
                    throw new C36548j("Unexpected type: " + Integer.toHexString(c5915m.dRL()));
            }
        }

        /* renamed from: b */
        public final void mo12589b(C5915m c5915m) {
            int dRN = c5915m.dRN();
            C16316o.m25140a(this.AAJ, C5920a.this.mo12573RM(c5915m.Ayk));
            C16316o.m25140a(this.AAJ, dRN);
            for (int i = 0; i < dRN; i++) {
                C16316o.m25140a(this.AAJ, C5920a.this.mo12572RL(c5915m.dRO()));
                m9222a(c5915m);
            }
        }

        /* renamed from: c */
        public final void mo12590c(C5915m c5915m) {
            int dRM = c5915m.dRM();
            C16316o.m25140a(this.AAJ, dRM);
            for (int i = 0; i < dRM; i++) {
                m9222a(c5915m);
            }
        }

        /* renamed from: id */
        private void m9223id(int i, int i2) {
            this.AAJ.writeByte((i2 << 5) | i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$2 */
    public class C59242 implements C24423b {
        final /* synthetic */ ByteArrayOutputStream AyW;

        public C59242(ByteArrayOutputStream byteArrayOutputStream) {
            this.AyW = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AyW.write(i);
        }
    }

    /* renamed from: RL */
    public abstract int mo12572RL(int i);

    /* renamed from: RM */
    public abstract int mo12573RM(int i);

    /* renamed from: RN */
    public abstract int mo12574RN(int i);

    /* renamed from: RO */
    public abstract int mo12575RO(int i);

    /* renamed from: RP */
    public abstract int mo12576RP(int i);

    /* renamed from: RQ */
    public abstract int mo12577RQ(int i);

    /* renamed from: RR */
    public abstract int mo12578RR(int i);

    /* renamed from: RS */
    public abstract int mo12579RS(int i);

    /* renamed from: RT */
    public abstract int mo12580RT(int i);

    /* renamed from: RU */
    public abstract int mo12581RU(int i);

    /* renamed from: RV */
    public abstract int mo12582RV(int i);

    /* renamed from: RW */
    public abstract int mo12583RW(int i);

    /* renamed from: RX */
    public abstract int mo12584RX(int i);

    /* renamed from: RY */
    public abstract int mo12585RY(int i);

    /* renamed from: b */
    public final C5912a[] mo12586b(C5912a[] c5912aArr) {
        C5912a[] c5912aArr2 = new C5912a[c5912aArr.length];
        for (int i = 0; i < c5912aArr.length; i++) {
            C5912a c5912a = c5912aArr[i];
            c5912aArr2[i] = new C5912a(mo12575RO(c5912a.Axw), c5912a.Axx);
        }
        return c5912aArr2;
    }

    /* renamed from: b */
    public final C5913b[] mo12587b(C5913b[] c5913bArr) {
        C5913b[] c5913bArr2 = new C5913b[c5913bArr.length];
        for (int i = 0; i < c5913bArr.length; i++) {
            C5913b c5913b = c5913bArr[i];
            c5913bArr2[i] = new C5913b(mo12576RP(c5913b.Axy), c5913b.Axx, mo12585RY(c5913b.Axz));
        }
        return c5913bArr2;
    }
}
