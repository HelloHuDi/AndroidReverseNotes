package com.tencent.matrix.resource.p164c.p165a;

/* renamed from: com.tencent.matrix.resource.c.a.a */
public final class C1100a {
    public final C1101b bXA;
    public final Object bXB;
    public final int bXz;

    public C1100a(int i, C1101b c1101b, Object obj) {
        this.bXz = i;
        this.bXA = c1101b;
        this.bXB = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1100a)) {
            return false;
        }
        C1100a c1100a = (C1100a) obj;
        if (this.bXz != c1100a.bXz) {
            return false;
        }
        if (!this.bXA.equals(c1100a.bXA)) {
            return false;
        }
        if ((this.bXB == null || this.bXB.equals(c1100a.bXB)) && (c1100a.bXB == null || c1100a.bXB.equals(this.bXB))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.bXA.hashCode() << 31) + this.bXz;
    }
}
