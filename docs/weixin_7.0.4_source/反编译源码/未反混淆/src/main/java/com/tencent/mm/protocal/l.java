package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l {

    public interface a {
        boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    public interface b {
        byte[] ZT();

        int ZU();

        long ads();

        int dmr();

        boolean dms();
    }

    public interface c {
        int P(byte[] bArr);

        boolean dms();
    }

    public static class d {
        public byte[] bFT = new byte[0];
        public long bufferSize = 0;
        public int fsO = 0;
        public int vyb = 0;
        public int vyc = 0;
        public String vyd = "";
        public String vye = "";
        public int vyf = 0;
        public boolean vyg = true;
        public a vyh;
        public byte[] vyi;
        public z vyj = new z("", "", 0);
        public long vyk = 0;

        public d() {
            AppMethodBeat.i(58839);
            AppMethodBeat.o(58839);
        }

        public void hB(int i) {
            this.vyb = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean dms() {
            return false;
        }

        public boolean adr() {
            return this.vyg;
        }

        public final void a(z zVar) {
            AppMethodBeat.i(58840);
            this.vyj = zVar;
            ab.i("MicroMsg.MMBase.Req", "summerauths setRsaInfo cgi[%s], stack[%s]", Integer.valueOf(getCmdId()), bo.dpG());
            AppMethodBeat.o(58840);
        }

        public final int dmr() {
            return this.fsO;
        }

        public final long ads() {
            return this.vyk;
        }
    }

    public static class e {
        public long bufferSize = 0;
        public int vyl = -99;
        public int vym = 255;
        public String vyn = "";

        public int getCmdId() {
            return 0;
        }

        public boolean dms() {
            return false;
        }
    }

    public static hl a(d dVar) {
        AppMethodBeat.i(58841);
        hl hlVar = new hl();
        hlVar.vKd = dVar.vyc;
        hlVar.Scene = dVar.vyf;
        hlVar.luF = dVar.vyb;
        hlVar.vKc = com.tencent.mm.bt.b.bI(dVar.vye.getBytes());
        if (hlVar.vKc.wR.length >= 16) {
            hlVar.vKc = hlVar.vKc.Lv(16);
        }
        hlVar.vKe = com.tencent.mm.bt.b.bI(dVar.vyd.getBytes());
        if (hlVar.vKe.wR.length >= 132) {
            hlVar.vKe = hlVar.vKe.Lv(132);
        }
        hlVar.vKb = com.tencent.mm.bt.b.bI(dVar.bFT);
        if (hlVar.vKb.wR.length >= 36) {
            hlVar.vKb = hlVar.vKb.Lv(36);
        }
        AppMethodBeat.o(58841);
        return hlVar;
    }

    public static void a(e eVar, BaseResponse baseResponse) {
        AppMethodBeat.i(58842);
        if (baseResponse.ErrMsg != null) {
            eVar.vyn = baseResponse.ErrMsg.wVI;
            AppMethodBeat.o(58842);
            return;
        }
        eVar.vyn = "";
        ab.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
        AppMethodBeat.o(58842);
    }
}
