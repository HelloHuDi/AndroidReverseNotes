package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.t */
public final class C21208t implements C1628a {
    String lvp = null;
    C21209a nXU;
    String nXV;
    boolean nXW = true;

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.t$a */
    public interface C21209a {
        /* renamed from: aS */
        void mo36588aS(String str, boolean z);
    }

    /* renamed from: a */
    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
        AppMethodBeat.m2504i(42350);
        C4990ab.m7411d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
        if (c9545d != null && this.lvp.equals(str) && !C5046bo.isNullOrNil(c9545d.field_fileId)) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + c9545d.field_retCode);
            if (i == 0 && c9545d.field_retCode == 0) {
                if (this.nXW) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", str, c9545d.toString());
                if (this.nXU != null) {
                    this.nXU.mo36588aS(this.nXV, true);
                }
            } else {
                C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.nXU != null) {
                    this.nXU.mo36588aS(this.nXV, false);
                }
            }
        } else if (c9545d != null && this.lvp.equals(str) && c9545d.field_retCode != 0) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + c9545d.field_retCode);
            if (this.nXU != null) {
                this.nXU.mo36588aS(this.nXV, false);
            }
        } else if (c18496c != null) {
            C4990ab.m7410d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        AppMethodBeat.m2505o(42350);
        return 0;
    }

    /* renamed from: a */
    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    /* renamed from: l */
    public final byte[] mo5084l(String str, byte[] bArr) {
        return null;
    }
}
