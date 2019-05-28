package com.tencent.matrix.resource.c.a;

public final class a {
    public final b bXA;
    public final Object bXB;
    public final int bXz;

    public a(int i, b bVar, Object obj) {
        this.bXz = i;
        this.bXA = bVar;
        this.bXB = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.bXz != aVar.bXz) {
            return false;
        }
        if (!this.bXA.equals(aVar.bXA)) {
            return false;
        }
        if ((this.bXB == null || this.bXB.equals(aVar.bXB)) && (aVar.bXB == null || aVar.bXB.equals(this.bXB))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.bXA.hashCode() << 31) + this.bXz;
    }
}
