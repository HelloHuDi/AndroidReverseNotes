package com.tencent.p177mm.booter.notification.p841a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C18559f;

/* renamed from: com.tencent.mm.booter.notification.a.c */
public final class C41901c {
    public int eem = -1;

    /* renamed from: B */
    public final int mo67550B(String str, int i) {
        AppMethodBeat.m2504i(16010);
        this.eem = C45186a.bWV();
        if (C18559f.m28902ja(i)) {
            if (C18559f.m28904kD(str)) {
                try {
                    this.eem = C25738R.drawable.arv;
                } catch (Exception e) {
                }
            } else if (C18559f.m28905kE(str)) {
                try {
                    this.eem = C25738R.drawable.arv;
                } catch (Exception e2) {
                }
            }
        }
        if (this.eem < 0) {
            this.eem = C45186a.bWV();
        }
        int i2 = this.eem;
        AppMethodBeat.m2505o(16010);
        return i2;
    }
}
