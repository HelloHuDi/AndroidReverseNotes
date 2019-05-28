package com.tencent.p177mm.p183ai;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.C4836l;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.protobuf.bsr;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.bzw;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ai.b */
public final class C7472b extends C6297k {
    public int azs;
    public int cQh;
    public C6295b fsG;
    public C6296c fsH;
    public int fsI;
    public String uri;

    /* renamed from: com.tencent.mm.ai.b$a */
    public static class C1196a {
        public int azs = 0;
        public int fsI = 1357;
        public C1331a fsJ;
        public C1331a fsK;
        public int fsL = 0;
        public int fsM = 0;
        public boolean fsN = true;
        public int fsO = 0;
        public String uri;

        /* renamed from: a */
        public final void mo4444a(C1331a c1331a) {
            this.fsJ = c1331a;
        }

        /* renamed from: b */
        public final void mo4446b(C1331a c1331a) {
            this.fsK = c1331a;
        }

        /* renamed from: qq */
        public final void mo4450qq(String str) {
            this.uri = str;
        }

        /* renamed from: kU */
        public final void mo4447kU(int i) {
            this.fsI = i;
        }

        /* renamed from: kV */
        public final void mo4448kV(int i) {
            this.fsL = i;
        }

        /* renamed from: kW */
        public final void mo4449kW(int i) {
            this.fsM = i;
        }

        public final C7472b acD() {
            boolean z = true;
            AppMethodBeat.m2504i(58156);
            if (this.fsJ == null || this.fsK == null || C5046bo.isNullOrNil(this.uri) || this.fsI <= 0 || this.fsL == C8415j.INVALID_ID || this.fsM == C8415j.INVALID_ID) {
                String str = "%s %s %s %s %s %s";
                Object[] objArr = new Object[6];
                objArr[0] = Boolean.valueOf(this.fsJ == null);
                objArr[1] = Boolean.valueOf(this.fsK == null);
                objArr[2] = Boolean.valueOf(C5046bo.isNullOrNil(this.uri));
                objArr[3] = Boolean.valueOf(this.fsI <= 0);
                objArr[4] = Boolean.valueOf(this.fsL == C8415j.INVALID_ID);
                if (this.fsM != C8415j.INVALID_ID) {
                    z = false;
                }
                objArr[5] = Boolean.valueOf(z);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(str, objArr));
                AppMethodBeat.m2505o(58156);
                throw illegalArgumentException;
            }
            C7472b c7472b = new C7472b(this.fsJ, this.fsK, this.uri, this.fsI, this.fsL, this.fsM, this.fsN, this.azs, this.fsO, (byte) 0);
            AppMethodBeat.m2505o(58156);
            return c7472b;
        }
    }

    /* renamed from: com.tencent.mm.ai.b$b */
    public static final class C6295b extends C4834d implements C4832b {
        public int cmdId;
        private int fsI;
        public C1331a fsP;
        private boolean fsQ;

        public C6295b(C1331a c1331a, int i, int i2, boolean z, int i3) {
            this.fsP = c1331a;
            this.fsI = i;
            this.cmdId = i2;
            this.fsQ = z;
            this.fsO = i3;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return this.fsI;
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58157);
            if (this.fsP instanceof bsr) {
                ((bsr) this.fsP).setBaseRequest(C4836l.m7194a(this));
            }
            byte[] toByteArray = this.fsP.toByteArray();
            AppMethodBeat.m2505o(58157);
            return toByteArray;
        }
    }

    /* renamed from: com.tencent.mm.ai.b$c */
    public static final class C6296c extends C4835e implements C4833c {
        public int cmdId;
        public C1331a fsP = null;
        private boolean fsQ;

        public C6296c(C1331a c1331a, int i, boolean z) {
            this.fsP = c1331a;
            this.cmdId = i;
            this.fsQ = z;
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58158);
            this.fsP = this.fsP.parseFrom(bArr);
            int ret;
            if (this.fsP instanceof bzw) {
                ret = ((bzw) this.fsP).getRet();
                AppMethodBeat.m2505o(58158);
                return ret;
            }
            C4836l.m7195a(this, ((btd) this.fsP).getBaseResponse());
            ret = ((btd) this.fsP).getBaseResponse().Ret;
            AppMethodBeat.m2505o(58158);
            return ret;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    /* synthetic */ C7472b(C1331a c1331a, C1331a c1331a2, String str, int i, int i2, int i3, boolean z, int i4, int i5, byte b) {
        this(c1331a, c1331a2, str, i, i2, i3, z, i4, i5);
    }

    private C7472b(C1331a c1331a, C1331a c1331a2, String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        AppMethodBeat.m2504i(58159);
        this.fsG = null;
        this.fsH = null;
        this.cQh = 0;
        boolean z2 = z && (c1331a instanceof bsr);
        this.fsG = new C6295b(c1331a, i, i2, z2, i5);
        this.fsH = new C6296c(c1331a2, i3, z);
        this.uri = str;
        this.fsI = i;
        this.azs = i4;
        AppMethodBeat.m2505o(58159);
    }

    public final C1331a acz() {
        return this.fsG.fsP;
    }

    public final C1331a acA() {
        return this.fsH.fsP;
    }

    public final int acB() {
        return this.azs;
    }

    public final int getType() {
        return this.fsI;
    }

    public final String getUri() {
        return this.uri;
    }

    /* renamed from: a */
    public final void mo16652a(C4851z c4851z) {
        AppMethodBeat.m2504i(58160);
        this.fsG.mo9995a(c4851z);
        AppMethodBeat.m2505o(58160);
    }

    public final int acC() {
        return this.cQh;
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    /* renamed from: ZR */
    public final /* bridge */ /* synthetic */ C4834d mo14537ZR() {
        return this.fsG;
    }

    /* renamed from: ZS */
    public final /* bridge */ /* synthetic */ C4835e mo5618ZS() {
        return this.fsH;
    }
}
