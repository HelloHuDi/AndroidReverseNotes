package com.tencent.mm.ai;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends k {
    public int azs;
    public int cQh;
    public b fsG;
    public c fsH;
    public int fsI;
    public String uri;

    public static class a {
        public int azs = 0;
        public int fsI = 1357;
        public com.tencent.mm.bt.a fsJ;
        public com.tencent.mm.bt.a fsK;
        public int fsL = 0;
        public int fsM = 0;
        public boolean fsN = true;
        public int fsO = 0;
        public String uri;

        public final void a(com.tencent.mm.bt.a aVar) {
            this.fsJ = aVar;
        }

        public final void b(com.tencent.mm.bt.a aVar) {
            this.fsK = aVar;
        }

        public final void qq(String str) {
            this.uri = str;
        }

        public final void kU(int i) {
            this.fsI = i;
        }

        public final void kV(int i) {
            this.fsL = i;
        }

        public final void kW(int i) {
            this.fsM = i;
        }

        public final b acD() {
            boolean z = true;
            AppMethodBeat.i(58156);
            if (this.fsJ == null || this.fsK == null || bo.isNullOrNil(this.uri) || this.fsI <= 0 || this.fsL == j.INVALID_ID || this.fsM == j.INVALID_ID) {
                String str = "%s %s %s %s %s %s";
                Object[] objArr = new Object[6];
                objArr[0] = Boolean.valueOf(this.fsJ == null);
                objArr[1] = Boolean.valueOf(this.fsK == null);
                objArr[2] = Boolean.valueOf(bo.isNullOrNil(this.uri));
                objArr[3] = Boolean.valueOf(this.fsI <= 0);
                objArr[4] = Boolean.valueOf(this.fsL == j.INVALID_ID);
                if (this.fsM != j.INVALID_ID) {
                    z = false;
                }
                objArr[5] = Boolean.valueOf(z);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(str, objArr));
                AppMethodBeat.o(58156);
                throw illegalArgumentException;
            }
            b bVar = new b(this.fsJ, this.fsK, this.uri, this.fsI, this.fsL, this.fsM, this.fsN, this.azs, this.fsO, (byte) 0);
            AppMethodBeat.o(58156);
            return bVar;
        }
    }

    public static final class b extends d implements com.tencent.mm.protocal.l.b {
        public int cmdId;
        private int fsI;
        public com.tencent.mm.bt.a fsP;
        private boolean fsQ;

        public b(com.tencent.mm.bt.a aVar, int i, int i2, boolean z, int i3) {
            this.fsP = aVar;
            this.fsI = i;
            this.cmdId = i2;
            this.fsQ = z;
            this.fsO = i3;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int ZU() {
            return this.fsI;
        }

        public final byte[] ZT() {
            AppMethodBeat.i(58157);
            if (this.fsP instanceof bsr) {
                ((bsr) this.fsP).setBaseRequest(l.a(this));
            }
            byte[] toByteArray = this.fsP.toByteArray();
            AppMethodBeat.o(58157);
            return toByteArray;
        }
    }

    public static final class c extends e implements com.tencent.mm.protocal.l.c {
        public int cmdId;
        public com.tencent.mm.bt.a fsP = null;
        private boolean fsQ;

        public c(com.tencent.mm.bt.a aVar, int i, boolean z) {
            this.fsP = aVar;
            this.cmdId = i;
            this.fsQ = z;
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58158);
            this.fsP = this.fsP.parseFrom(bArr);
            int ret;
            if (this.fsP instanceof bzw) {
                ret = ((bzw) this.fsP).getRet();
                AppMethodBeat.o(58158);
                return ret;
            }
            l.a(this, ((btd) this.fsP).getBaseResponse());
            ret = ((btd) this.fsP).getBaseResponse().Ret;
            AppMethodBeat.o(58158);
            return ret;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    /* synthetic */ b(com.tencent.mm.bt.a aVar, com.tencent.mm.bt.a aVar2, String str, int i, int i2, int i3, boolean z, int i4, int i5, byte b) {
        this(aVar, aVar2, str, i, i2, i3, z, i4, i5);
    }

    private b(com.tencent.mm.bt.a aVar, com.tencent.mm.bt.a aVar2, String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        AppMethodBeat.i(58159);
        this.fsG = null;
        this.fsH = null;
        this.cQh = 0;
        boolean z2 = z && (aVar instanceof bsr);
        this.fsG = new b(aVar, i, i2, z2, i5);
        this.fsH = new c(aVar2, i3, z);
        this.uri = str;
        this.fsI = i;
        this.azs = i4;
        AppMethodBeat.o(58159);
    }

    public final com.tencent.mm.bt.a acz() {
        return this.fsG.fsP;
    }

    public final com.tencent.mm.bt.a acA() {
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

    public final void a(z zVar) {
        AppMethodBeat.i(58160);
        this.fsG.a(zVar);
        AppMethodBeat.o(58160);
    }

    public final int acC() {
        return this.cQh;
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ d ZR() {
        return this.fsG;
    }

    public final /* bridge */ /* synthetic */ e ZS() {
        return this.fsH;
    }
}
