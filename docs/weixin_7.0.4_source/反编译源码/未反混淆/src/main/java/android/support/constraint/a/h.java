package android.support.constraint.a;

import java.util.Arrays;

public final class h {
    private static int gJ = 1;
    private static int gK = 1;
    private static int gL = 1;
    private static int gM = 1;
    private static int gN = 1;
    int gO = -1;
    public int gP = 0;
    public float gQ;
    float[] gR = new float[7];
    a gS;
    b[] gT = new b[8];
    int gU = 0;
    public int gV = 0;
    public int id = -1;
    private String mName;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void aB() {
        gK++;
    }

    public h(a aVar) {
        this.gS = aVar;
    }

    public final void d(b bVar) {
        int i = 0;
        while (i < this.gU) {
            if (this.gT[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
        if (this.gU >= this.gT.length) {
            this.gT = (b[]) Arrays.copyOf(this.gT, this.gT.length * 2);
        }
        this.gT[this.gU] = bVar;
        this.gU++;
    }

    public final void e(b bVar) {
        int i = 0;
        int i2 = this.gU;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.gT[i3] == bVar) {
                while (i < (i2 - i3) - 1) {
                    this.gT[i3 + i] = this.gT[(i3 + i) + 1];
                    i++;
                }
                this.gU--;
                return;
            }
        }
    }

    public final void f(b bVar) {
        int i = this.gU;
        for (int i2 = 0; i2 < i; i2++) {
            this.gT[i2].fI.a(this.gT[i2], bVar);
        }
        this.gU = 0;
    }

    public final void reset() {
        this.mName = null;
        this.gS = a.UNKNOWN;
        this.gP = 0;
        this.id = -1;
        this.gO = -1;
        this.gQ = 0.0f;
        this.gU = 0;
        this.gV = 0;
    }

    public final String toString() {
        return "" + this.mName;
    }
}
