package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;

public final class o extends b implements i {
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private b ehh;
    private f ehi;
    public bst pLG;

    public o(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, String str5, String str6, com.tencent.mm.bt.b bVar, int i5) {
        AppMethodBeat.i(44482);
        ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", bo.nullAsNil(str6), Base64.encodeToString(bVar.toByteArray(), 2), Integer.valueOf(i5));
        a aVar = new a();
        aVar.fsJ = new bss();
        aVar.fsK = new bst();
        aVar.fsI = 1380;
        aVar.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bss bss = (bss) this.ehh.fsG.fsP;
        bss.pMd = str;
        bss.pMe = str2;
        bss.pbn = str3;
        bss.pLQ = i;
        bss.wUL = i2;
        bss.wUM = str4;
        bss.wUN = i3;
        bss.wUO = i4;
        bss.vHu = str5;
        bss.wKQ = str6;
        bss.wUP = bVar;
        bss.vPy = i5;
        AppMethodBeat.o(44482);
    }

    public final int getType() {
        return 1380;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44483);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44483);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44484);
        ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLG = (bst) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLG.kCl), this.pLG.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44484);
    }

    public final void f(q qVar) {
        bst bst = (bst) ((b) qVar).fsH.fsP;
        this.AfC = bst.kCl;
        this.AfD = bst.kCm;
    }

    public final boolean bgR() {
        if (this.pLG.wUQ == null || this.pLG.wUQ.bJt != 1) {
            return true;
        }
        return false;
    }
}
