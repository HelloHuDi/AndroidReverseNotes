package com.tencent.tinker.p668a.p669a;

import com.facebook.internal.Utility;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import java.util.Arrays;

/* renamed from: com.tencent.tinker.a.a.t */
public final class C41083t {
    public final C31086a AyA = new C31086a(4097, true);
    public final C31086a AyB = new C31086a(4098, true);
    public final C31086a AyC = new C31086a(4099, true);
    public final C31086a AyD = new C31086a(Utility.DEFAULT_STREAM_BUFFER_SIZE, false);
    public final C31086a AyE = new C31086a(8193, true);
    public final C31086a AyF = new C31086a(8194, false);
    public final C31086a AyG = new C31086a(8195, false);
    public final C31086a AyH = new C31086a(8196, false);
    public final C31086a AyI = new C31086a(8197, false);
    public final C31086a AyJ = new C31086a(8198, true);
    public final C31086a[] AyK = new C31086a[]{this.Ays, this.Ayt, this.Ayu, this.Ayv, this.Ayw, this.Ayx, this.Ayy, this.Ayz, this.AyA, this.AyB, this.AyC, this.AyD, this.AyE, this.AyF, this.AyG, this.AyH, this.AyI, this.AyJ};
    public int AyL;
    public int AyM;
    public int AyN;
    public final C31086a Ays = new C31086a(0, true);
    public final C31086a Ayt = new C31086a(1, true);
    public final C31086a Ayu = new C31086a(2, true);
    public final C31086a Ayv = new C31086a(3, true);
    public final C31086a Ayw = new C31086a(4, true);
    public final C31086a Ayx = new C31086a(5, true);
    public final C31086a Ayy = new C31086a(6, true);
    public final C31086a Ayz = new C31086a(4096, true);
    public int fileSize;
    public int gai;
    public int lgV;
    public byte[] nTL = new byte[20];

    /* renamed from: com.tencent.tinker.a.a.t$a */
    public static class C31086a implements Comparable<C31086a> {
        public final short AyO;
        public boolean AyP;
        public int byteCount = 0;
        public int off = -1;
        public int size = 0;

        /* renamed from: com.tencent.tinker.a.a.t$a$a */
        public static abstract class C31087a<T> implements Comparable<T> {
            public int off;

            public C31087a(int i) {
                this.off = i;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            C31086a c31086a = (C31086a) obj;
            if (this.off == c31086a.off) {
                int Rp = C31086a.m50146Rp(this.AyO);
                int Rp2 = C31086a.m50146Rp(c31086a.AyO);
                if (Rp == Rp2) {
                    return 0;
                }
                if (Rp >= Rp2) {
                    return 1;
                }
                return -1;
            } else if (this.off < c31086a.off) {
                return -1;
            } else {
                return 1;
            }
        }

        public C31086a(int i, boolean z) {
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

        /* renamed from: Rp */
        private static int m50146Rp(int i) {
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
    /* renamed from: a */
    public final void mo65175a(C36544e c36544e) {
        int i;
        int i2 = c36544e.aEY.getInt();
        int i3 = 0;
        C31086a c31086a = null;
        while (i3 < i2) {
            short s = c36544e.aEY.getShort();
            c36544e.aEY.getShort();
            for (C31086a c31086a2 : this.AyK) {
                if (c31086a2.AyO == s) {
                    i = c36544e.aEY.getInt();
                    int i4 = c36544e.aEY.getInt();
                    if ((c31086a2.size == 0 || c31086a2.size == i) && (c31086a2.off == -1 || c31086a2.off == i4)) {
                        c31086a2.size = i;
                        c31086a2.off = i4;
                        if (c31086a == null || c31086a.off <= c31086a2.off) {
                            i3++;
                            c31086a = c31086a2;
                        } else {
                            throw new C36548j("Map is unsorted at " + c31086a + ", " + c31086a2);
                        }
                    }
                    throw new C36548j("Unexpected map value for 0x" + Integer.toHexString(s));
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
            C31086a c31086a = this.AyK[length];
            if (c31086a.off != -1) {
                if (c31086a.off > i) {
                    throw new C36548j("Map is unsorted at ".concat(String.valueOf(c31086a)));
                }
                c31086a.byteCount = i - c31086a.off;
                i = c31086a.off;
            }
        }
        this.AyN = (((((this.Ays.byteCount + this.Ayt.byteCount) + this.Ayu.byteCount) + this.Ayv.byteCount) + this.Ayw.byteCount) + this.Ayx.byteCount) + this.Ayy.byteCount;
        this.lgV = this.fileSize - this.AyN;
    }

    /* renamed from: b */
    public final void mo65176b(C36544e c36544e) {
        int i = 0;
        for (C31086a exists : this.AyK) {
            if (exists.exists()) {
                i++;
            }
        }
        c36544e.writeInt(i);
        for (C31086a c31086a : this.AyK) {
            if (c31086a.exists()) {
                c36544e.writeShort(c31086a.AyO);
                c36544e.writeShort((short) 0);
                c36544e.writeInt(c31086a.size);
                c36544e.writeInt(c31086a.off);
            }
        }
    }
}
