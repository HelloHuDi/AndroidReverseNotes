package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;

public final class t implements com.tencent.mm.i.g.a {
    String lvp = null;
    a nXU;
    String nXV;
    boolean nXW = true;

    public interface a {
        void aS(String str, boolean z);
    }

    public final int a(String str, int i, c cVar, d dVar, boolean z) {
        AppMethodBeat.i(42350);
        ab.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
        if (dVar != null && this.lvp.equals(str) && !bo.isNullOrNil(dVar.field_fileId)) {
            ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + dVar.field_retCode);
            if (i == 0 && dVar.field_retCode == 0) {
                if (this.nXW) {
                    ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", str, dVar.toString());
                if (this.nXU != null) {
                    this.nXU.aS(this.nXV, true);
                }
            } else {
                ab.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.nXU != null) {
                    this.nXU.aS(this.nXV, false);
                }
            }
        } else if (dVar != null && this.lvp.equals(str) && dVar.field_retCode != 0) {
            ab.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + dVar.field_retCode);
            if (this.nXU != null) {
                this.nXU.aS(this.nXV, false);
            }
        } else if (cVar != null) {
            ab.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        AppMethodBeat.o(42350);
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] l(String str, byte[] bArr) {
        return null;
    }
}
