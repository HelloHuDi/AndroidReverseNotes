package com.tencent.tinker.a.a;

import com.facebook.internal.Utility;
import com.tencent.tinker.a.a.i.e;
import java.util.Arrays;

public final class t {
    public final a AyA = new a(4097, true);
    public final a AyB = new a(4098, true);
    public final a AyC = new a(4099, true);
    public final a AyD = new a(Utility.DEFAULT_STREAM_BUFFER_SIZE, false);
    public final a AyE = new a(8193, true);
    public final a AyF = new a(8194, false);
    public final a AyG = new a(8195, false);
    public final a AyH = new a(8196, false);
    public final a AyI = new a(8197, false);
    public final a AyJ = new a(8198, true);
    public final a[] AyK = new a[]{this.Ays, this.Ayt, this.Ayu, this.Ayv, this.Ayw, this.Ayx, this.Ayy, this.Ayz, this.AyA, this.AyB, this.AyC, this.AyD, this.AyE, this.AyF, this.AyG, this.AyH, this.AyI, this.AyJ};
    public int AyL;
    public int AyM;
    public int AyN;
    public final a Ays = new a(0, true);
    public final a Ayt = new a(1, true);
    public final a Ayu = new a(2, true);
    public final a Ayv = new a(3, true);
    public final a Ayw = new a(4, true);
    public final a Ayx = new a(5, true);
    public final a Ayy = new a(6, true);
    public final a Ayz = new a(4096, true);
    public int fileSize;
    public int gai;
    public int lgV;
    public byte[] nTL = new byte[20];

    public static class a implements Comparable<a> {
        public final short AyO;
        public boolean AyP;
        public int byteCount = 0;
        public int off = -1;
        public int size = 0;

        public static abstract class a<T> implements Comparable<T> {
            public int off;

            public a(int i) {
                this.off = i;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (this.off == aVar.off) {
                int Rp = Rp(this.AyO);
                int Rp2 = Rp(aVar.AyO);
                if (Rp == Rp2) {
                    return 0;
                }
                if (Rp >= Rp2) {
                    return 1;
                }
                return -1;
            } else if (this.off < aVar.off) {
                return -1;
            } else {
                return 1;
            }
        }

        public a(int i, boolean z) {
            this.AyO = (short) i;
            this.AyP = z;
            if (i == 0) {
                this.off = 0;
                this.size = 1;
                this.byteCount = 112;
            } else if (i == 4096) {
                this.size = 1;
            }
        }

        public final boolean exists() {
            return this.size > 0;
        }

        private static int Rp(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 4096:
                    return 17;
                case 4097:
                    return 8;
                case 4098:
                    return 11;
                case 4099:
                    return 10;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    return 15;
                case 8193:
                    return 14;
                case 8194:
                    return 7;
                case 8195:
                    return 13;
                case 8196:
                    return 9;
                case 8197:
                    return 16;
                case 8198:
                    return 12;
                default:
                    throw new IllegalArgumentException("unknown section type: ".concat(String.valueOf(i)));
            }
        }

        public final String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.AyO), Integer.valueOf(this.off), Integer.valueOf(this.size)});
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(e eVar) {
        int i;
        int i2 = eVar.aEY.getInt();
        int i3 = 0;
        a aVar = null;
        while (i3 < i2) {
            short s = eVar.aEY.getShort();
            eVar.aEY.getShort();
            for (a aVar2 : this.AyK) {
                if (aVar2.AyO == s) {
                    i = eVar.aEY.getInt();
                    int i4 = eVar.aEY.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i) && (aVar2.off == -1 || aVar2.off == i4)) {
                        aVar2.size = i;
                        aVar2.off = i4;
                        if (aVar == null || aVar.off <= aVar2.off) {
                            i3++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: ".concat(String.valueOf(s)));
        }
        this.Ays.off = 0;
        Arrays.sort(this.AyK);
        for (i = 1; i < this.AyK.length; i++) {
            if (this.AyK[i].off == -1) {
                this.AyK[i].off = this.AyK[i - 1].off;
            }
        }
    }

    public final void dRV() {
        int i = this.fileSize;
        for (int length = this.AyK.length - 1; length >= 0; length--) {
            a aVar = this.AyK[length];
            if (aVar.off != -1) {
                if (aVar.off > i) {
                    throw new j("Map is unsorted at ".concat(String.valueOf(aVar)));
                }
                aVar.byteCount = i - aVar.off;
                i = aVar.off;
            }
        }
        this.AyN = (((((this.Ays.byteCount + this.Ayt.byteCount) + this.Ayu.byteCount) + this.Ayv.byteCount) + this.Ayw.byteCount) + this.Ayx.byteCount) + this.Ayy.byteCount;
        this.lgV = this.fileSize - this.AyN;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.AyK) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.AyK) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.AyO);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.off);
            }
        }
    }
}
