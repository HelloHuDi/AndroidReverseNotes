package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C46809a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.k */
public final class C44545k extends C31087a<C44545k> {
    public byte[] data;

    /* renamed from: com.tencent.tinker.a.a.k$1 */
    class C410821 implements C46809a {
        private int position = 0;

        C410821() {
        }

        public final byte readByte() {
            byte[] bArr = C44545k.this.data;
            int i = this.position;
            this.position = i + 1;
            return bArr[i];
        }
    }

    public C44545k(int i, byte[] bArr) {
        super(i);
        this.data = bArr;
    }

    /* renamed from: b */
    public final int compareTo(C44545k c44545k) {
        return C5910c.m9196o(this.data, c44545k.data);
    }
}
