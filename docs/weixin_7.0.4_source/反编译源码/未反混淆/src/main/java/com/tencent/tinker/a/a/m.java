package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.view.d;

public final class m {
    protected final a Ayj;
    public int Ayk;
    private int Ayl;
    private int type;

    public m(a aVar, int i) {
        this.type = -1;
        this.Ayj = aVar;
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
        Ro(28);
        this.type = -1;
        return o.b(this.Ayj);
    }

    public final int dRN() {
        Ro(29);
        this.type = -1;
        this.Ayk = o.b(this.Ayj);
        return o.b(this.Ayj);
    }

    public final int dRO() {
        return o.b(this.Ayj);
    }

    public final byte readByte() {
        Ro(0);
        this.type = -1;
        return (byte) l.a(this.Ayj, this.Ayl);
    }

    public final short readShort() {
        Ro(2);
        this.type = -1;
        return (short) l.a(this.Ayj, this.Ayl);
    }

    public final char readChar() {
        Ro(3);
        this.type = -1;
        return (char) l.a(this.Ayj, this.Ayl, false);
    }

    public final int readInt() {
        Ro(4);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl);
    }

    public final long readLong() {
        Ro(6);
        this.type = -1;
        a aVar = this.Ayj;
        int i = this.Ayl;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        Ro(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.Ayj, this.Ayl, true));
    }

    public final double readDouble() {
        Ro(17);
        this.type = -1;
        a aVar = this.Ayj;
        long j = 0;
        for (int i = this.Ayl; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int dRP() {
        Ro(23);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl, false);
    }

    public final int dRQ() {
        Ro(24);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl, false);
    }

    public final int dRR() {
        Ro(25);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl, false);
    }

    public final int dRS() {
        Ro(27);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl, false);
    }

    public final int dRT() {
        Ro(26);
        this.type = -1;
        return l.a(this.Ayj, this.Ayl, false);
    }

    public final void dRU() {
        Ro(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        Ro(31);
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
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                dRM = dRM();
                while (i < dRM) {
                    skipValue();
                    i++;
                }
                return;
            case 29:
                dRM = dRN();
                while (i < dRM) {
                    o.b(this.Ayj);
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
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void Ro(int i) {
        if (dRL() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(dRL())}));
        }
    }

    public m(k kVar, int i) {
        this(new a() {
            private int position = 0;

            public final byte readByte() {
                byte[] bArr = k.this.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        }, i);
    }
}
