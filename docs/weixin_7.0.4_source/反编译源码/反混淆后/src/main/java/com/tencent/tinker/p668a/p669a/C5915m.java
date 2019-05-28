package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C44545k.C410821;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.tinker.a.a.m */
public final class C5915m {
    protected final C46809a Ayj;
    public int Ayk;
    private int Ayl;
    private int type;

    public C5915m(C46809a c46809a, int i) {
        this.type = -1;
        this.Ayj = c46809a;
        this.type = i;
    }

    public final int dRL() {
        if (this.type == -1) {
            int readByte = this.Ayj.readByte() & 255;
            this.type = readByte & 31;
            this.Ayl = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int dRM() {
        m9199Ro(28);
        this.type = -1;
        return C16316o.m25141b(this.Ayj);
    }

    public final int dRN() {
        m9199Ro(29);
        this.type = -1;
        this.Ayk = C16316o.m25141b(this.Ayj);
        return C16316o.m25141b(this.Ayj);
    }

    public final int dRO() {
        return C16316o.m25141b(this.Ayj);
    }

    public final byte readByte() {
        m9199Ro(0);
        this.type = -1;
        return (byte) C31085l.m50141a(this.Ayj, this.Ayl);
    }

    public final short readShort() {
        m9199Ro(2);
        this.type = -1;
        return (short) C31085l.m50141a(this.Ayj, this.Ayl);
    }

    public final char readChar() {
        m9199Ro(3);
        this.type = -1;
        return (char) C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final int readInt() {
        m9199Ro(4);
        this.type = -1;
        return C31085l.m50141a(this.Ayj, this.Ayl);
    }

    public final long readLong() {
        m9199Ro(6);
        this.type = -1;
        C46809a c46809a = this.Ayj;
        int i = this.Ayl;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) c46809a.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        m9199Ro(16);
        this.type = -1;
        return Float.intBitsToFloat(C31085l.m50142a(this.Ayj, this.Ayl, true));
    }

    public final double readDouble() {
        m9199Ro(17);
        this.type = -1;
        C46809a c46809a = this.Ayj;
        long j = 0;
        for (int i = this.Ayl; i >= 0; i--) {
            j = (j >>> 8) | ((((long) c46809a.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int dRP() {
        m9199Ro(23);
        this.type = -1;
        return C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final int dRQ() {
        m9199Ro(24);
        this.type = -1;
        return C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final int dRR() {
        m9199Ro(25);
        this.type = -1;
        return C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final int dRS() {
        m9199Ro(27);
        this.type = -1;
        return C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final int dRT() {
        m9199Ro(26);
        this.type = -1;
        return C31085l.m50142a(this.Ayj, this.Ayl, false);
    }

    public final void dRU() {
        m9199Ro(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        m9199Ro(31);
        this.type = -1;
        return this.Ayl != 0;
    }

    public final void skipValue() {
        int i = 0;
        int dRM;
        switch (dRL()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                dRP();
                return;
            case 24:
                dRQ();
                return;
            case 25:
                dRR();
                return;
            case 26:
                dRT();
                return;
            case 27:
                dRS();
                return;
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                dRM = dRM();
                while (i < dRM) {
                    skipValue();
                    i++;
                }
                return;
            case 29:
                dRM = dRN();
                while (i < dRM) {
                    C16316o.m25141b(this.Ayj);
                    skipValue();
                    i++;
                }
                return;
            case 30:
                dRU();
                return;
            case 31:
                readBoolean();
                return;
            default:
                throw new C36548j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    /* renamed from: Ro */
    private void m9199Ro(int i) {
        if (dRL() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(dRL())}));
        }
    }

    public C5915m(C44545k c44545k, int i) {
        this(new C410821(), i);
    }
}
