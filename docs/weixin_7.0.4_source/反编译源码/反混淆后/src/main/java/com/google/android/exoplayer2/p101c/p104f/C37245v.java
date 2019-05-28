package com.google.android.exoplayer2.p101c.p104f;

import android.support.p057v4.widget.C8415j;
import android.util.SparseArray;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.v */
public interface C37245v {

    /* renamed from: com.google.android.exoplayer2.c.f.v$b */
    public static final class C8660b {
        public final String aOt;
        public final List<C25529a> bdJ;
        public final byte[] bdK;
        public final int streamType;

        public C8660b(int i, String str, List<C25529a> list, byte[] bArr) {
            List emptyList;
            AppMethodBeat.m2504i(95178);
            this.streamType = i;
            this.aOt = str;
            if (list == null) {
                emptyList = Collections.emptyList();
            } else {
                emptyList = Collections.unmodifiableList(list);
            }
            this.bdJ = emptyList;
            this.bdK = bArr;
            AppMethodBeat.m2505o(95178);
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.v$d */
    public static final class C8661d {
        private String bbx;
        private final String bdL;
        private final int bdM;
        private final int bdN;
        private int bdO;

        public C8661d(int i, int i2) {
            this(C8415j.INVALID_ID, i, i2);
        }

        public C8661d(int i, int i2, int i3) {
            AppMethodBeat.m2504i(95179);
            this.bdL = i != C8415j.INVALID_ID ? i + "/" : "";
            this.bdM = i2;
            this.bdN = i3;
            this.bdO = C8415j.INVALID_ID;
            AppMethodBeat.m2505o(95179);
        }

        /* renamed from: rz */
        public final void mo19155rz() {
            AppMethodBeat.m2504i(95180);
            this.bdO = this.bdO == C8415j.INVALID_ID ? this.bdM : this.bdO + this.bdN;
            this.bbx = this.bdL + this.bdO;
            AppMethodBeat.m2505o(95180);
        }

        /* renamed from: rA */
        public final int mo19153rA() {
            AppMethodBeat.m2504i(95181);
            m15360rC();
            int i = this.bdO;
            AppMethodBeat.m2505o(95181);
            return i;
        }

        /* renamed from: rB */
        public final String mo19154rB() {
            AppMethodBeat.m2504i(95182);
            m15360rC();
            String str = this.bbx;
            AppMethodBeat.m2505o(95182);
            return str;
        }

        /* renamed from: rC */
        private void m15360rC() {
            AppMethodBeat.m2504i(95183);
            if (this.bdO == C8415j.INVALID_ID) {
                IllegalStateException illegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
                AppMethodBeat.m2505o(95183);
                throw illegalStateException;
            }
            AppMethodBeat.m2505o(95183);
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.v$a */
    public static final class C25529a {
        public final String aOt;
        public final byte[] bdI;
        public final int type;

        public C25529a(String str, int i, byte[] bArr) {
            this.aOt = str;
            this.type = i;
            this.bdI = bArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.v$c */
    public interface C25530c {
        /* renamed from: a */
        C37245v mo42786a(int i, C8660b c8660b);

        /* renamed from: rv */
        SparseArray<C37245v> mo42787rv();
    }

    /* renamed from: a */
    void mo42783a(C32065l c32065l, boolean z);

    /* renamed from: a */
    void mo42784a(C45042s c45042s, C8662g c8662g, C8661d c8661d);

    /* renamed from: rn */
    void mo42785rn();
}
