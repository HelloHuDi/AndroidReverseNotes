package android.support.constraint.p780a;

import java.util.Arrays;

/* renamed from: android.support.constraint.a.h */
public final class C41479h {
    /* renamed from: gJ */
    private static int f16679gJ = 1;
    /* renamed from: gK */
    private static int f16680gK = 1;
    /* renamed from: gL */
    private static int f16681gL = 1;
    /* renamed from: gM */
    private static int f16682gM = 1;
    /* renamed from: gN */
    private static int f16683gN = 1;
    /* renamed from: gO */
    int f16684gO = -1;
    /* renamed from: gP */
    public int f16685gP = 0;
    /* renamed from: gQ */
    public float f16686gQ;
    /* renamed from: gR */
    float[] f16687gR = new float[7];
    /* renamed from: gS */
    C41480a f16688gS;
    /* renamed from: gT */
    C36667b[] f16689gT = new C36667b[8];
    /* renamed from: gU */
    int f16690gU = 0;
    /* renamed from: gV */
    public int f16691gV = 0;
    /* renamed from: id */
    public int f16692id = -1;
    private String mName;

    /* renamed from: android.support.constraint.a.h$a */
    public enum C41480a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* renamed from: aB */
    static void m72403aB() {
        f16680gK++;
    }

    public C41479h(C41480a c41480a) {
        this.f16688gS = c41480a;
    }

    /* renamed from: d */
    public final void mo66156d(C36667b c36667b) {
        int i = 0;
        while (i < this.f16690gU) {
            if (this.f16689gT[i] != c36667b) {
                i++;
            } else {
                return;
            }
        }
        if (this.f16690gU >= this.f16689gT.length) {
            this.f16689gT = (C36667b[]) Arrays.copyOf(this.f16689gT, this.f16689gT.length * 2);
        }
        this.f16689gT[this.f16690gU] = c36667b;
        this.f16690gU++;
    }

    /* renamed from: e */
    public final void mo66157e(C36667b c36667b) {
        int i = 0;
        int i2 = this.f16690gU;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f16689gT[i3] == c36667b) {
                while (i < (i2 - i3) - 1) {
                    this.f16689gT[i3 + i] = this.f16689gT[(i3 + i) + 1];
                    i++;
                }
                this.f16690gU--;
                return;
            }
        }
    }

    /* renamed from: f */
    public final void mo66158f(C36667b c36667b) {
        int i = this.f16690gU;
        for (int i2 = 0; i2 < i; i2++) {
            this.f16689gT[i2].f15473fI.mo31504a(this.f16689gT[i2], c36667b);
        }
        this.f16690gU = 0;
    }

    public final void reset() {
        this.mName = null;
        this.f16688gS = C41480a.UNKNOWN;
        this.f16685gP = 0;
        this.f16692id = -1;
        this.f16684gO = -1;
        this.f16686gQ = 0.0f;
        this.f16690gU = 0;
        this.f16691gV = 0;
    }

    public final String toString() {
        return "" + this.mName;
    }
}
