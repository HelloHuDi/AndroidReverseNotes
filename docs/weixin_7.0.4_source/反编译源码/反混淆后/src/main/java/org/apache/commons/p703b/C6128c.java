package org.apache.commons.p703b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: org.apache.commons.b.c */
final class C6128c {
    private transient C6129a[] BWZ;
    private final float BXa;
    private transient int count;
    private int yrA;

    /* renamed from: org.apache.commons.b.c$a */
    static class C6129a {
        C6129a BXb;
        final int key;
        final int puf;
        Object value;

        protected C6129a(int i, int i2, Object obj, C6129a c6129a) {
            this.puf = i;
            this.key = i2;
            this.value = obj;
            this.BXb = c6129a;
        }
    }

    public C6128c() {
        this((byte) 0);
    }

    private C6128c(byte b) {
        AppMethodBeat.m2504i(116954);
        this.BXa = 0.75f;
        this.BWZ = new C6129a[20];
        this.yrA = 15;
        AppMethodBeat.m2505o(116954);
    }

    /* renamed from: v */
    public final Object mo13572v(int i, Object obj) {
        C6129a c6129a;
        AppMethodBeat.m2504i(116955);
        C6129a[] c6129aArr = this.BWZ;
        int length = (i & BaseClientBuilder.API_PRIORITY_OTHER) % c6129aArr.length;
        for (c6129a = c6129aArr[length]; c6129a != null; c6129a = c6129a.BXb) {
            if (c6129a.puf == i) {
                Object obj2 = c6129a.value;
                c6129a.value = obj;
                AppMethodBeat.m2505o(116955);
                return obj2;
            }
        }
        if (this.count >= this.yrA) {
            length = this.BWZ.length;
            C6129a[] c6129aArr2 = this.BWZ;
            int i2 = (length * 2) + 1;
            C6129a[] c6129aArr3 = new C6129a[i2];
            this.yrA = (int) (((float) i2) * this.BXa);
            this.BWZ = c6129aArr3;
            while (true) {
                int i3 = length - 1;
                if (length <= 0) {
                    break;
                }
                C6129a c6129a2 = c6129aArr2[i3];
                while (c6129a2 != null) {
                    c6129a = c6129a2.BXb;
                    int i4 = (c6129a2.puf & BaseClientBuilder.API_PRIORITY_OTHER) % i2;
                    c6129a2.BXb = c6129aArr3[i4];
                    c6129aArr3[i4] = c6129a2;
                    c6129a2 = c6129a;
                }
                length = i3;
            }
            c6129aArr = this.BWZ;
            length = (i & BaseClientBuilder.API_PRIORITY_OTHER) % c6129aArr.length;
        }
        c6129aArr[length] = new C6129a(i, i, obj, c6129aArr[length]);
        this.count++;
        AppMethodBeat.m2505o(116955);
        return null;
    }
}
