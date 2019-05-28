package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.h;
import com.tencent.view.d;
import java.io.IOException;

public final class i extends m implements k {
    private f eIc;
    private final b ehh;
    private String kWM;

    public i(String str) {
        AppMethodBeat.i(53117);
        a aVar = new a();
        aVar.fsJ = new aib();
        aVar.fsK = new aic();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.fsI = d.MIC_PTU_SHISHANG2;
        this.ehh = aVar.acD();
        this.kWM = str;
        AppMethodBeat.o(53117);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53118);
        ab.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            h hVar = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYt;
            String str2 = this.kWM;
            aic bkx = bkx();
            if (bo.isNullOrNil(str2) || bkx == null) {
                ab.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    com.tencent.mm.storage.emotion.g gVar = new com.tencent.mm.storage.emotion.g();
                    gVar.field_designerIDAndType = str2 + h.a.DesignerSimpleInfo.value;
                    gVar.field_content = bkx.toByteArray();
                    ContentValues Hl = gVar.Hl();
                    new String[1][0] = str2 + h.a.DesignerSimpleInfo.value;
                    if (hVar.bSd.replace("EmotionDesignerInfo", "designerIDAndType", Hl) > 0) {
                        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", str2);
                    } else {
                        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", str2);
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", bo.l(e));
                }
            }
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53118);
    }

    public final aic bkx() {
        if (this.ehh == null) {
            return null;
        }
        return (aic) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return d.MIC_PTU_SHISHANG2;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53119);
        this.eIc = fVar;
        ((aib) this.ehh.fsG.fsP).wdC = this.kWM;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53119);
        return a;
    }
}
