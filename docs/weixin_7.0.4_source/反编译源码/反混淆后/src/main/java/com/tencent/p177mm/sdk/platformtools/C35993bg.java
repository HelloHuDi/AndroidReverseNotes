package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.bg */
public class C35993bg<T> {
    /* renamed from: gH */
    public Object[] f15079gH;
    /* renamed from: gI */
    public int f15080gI;

    public C35993bg(int i) {
        AppMethodBeat.m2504i(52275);
        if (i <= 0) {
            C4990ab.m7412e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
            AppMethodBeat.m2505o(52275);
            return;
        }
        this.f15079gH = new Object[i];
        AppMethodBeat.m2505o(52275);
    }

    /* renamed from: aA */
    public T mo56734aA() {
        if (this.f15079gH == null || this.f15080gI <= 0) {
            return null;
        }
        int i = this.f15080gI - 1;
        T t = this.f15079gH[i];
        this.f15079gH[i] = null;
        this.f15080gI--;
        return t;
    }

    public boolean release(T t) {
        AppMethodBeat.m2504i(52276);
        if (this.f15079gH == null) {
            AppMethodBeat.m2505o(52276);
            return false;
        }
        int i;
        if (this.f15079gH != null) {
            for (i = 0; i < this.f15080gI; i++) {
                if (this.f15079gH[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            AppMethodBeat.m2505o(52276);
            return false;
        } else if (this.f15080gI >= this.f15079gH.length || this.f15080gI < 0) {
            C4990ab.m7413e("MicroMsg.SimpleObjectPool", "error index %d %d", Integer.valueOf(this.f15080gI), Integer.valueOf(this.f15079gH.length));
            AppMethodBeat.m2505o(52276);
            return false;
        } else {
            this.f15079gH[this.f15080gI] = t;
            this.f15080gI++;
            AppMethodBeat.m2505o(52276);
            return true;
        }
    }
}
