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
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class h extends m implements k {
    private f eIc;
    private final b ehh;
    public int gvO;
    private int kWH;
    public byte[] kWI;
    private int kWJ;
    private String kWK;
    private int kWL;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        AppMethodBeat.i(53114);
        a aVar = new a();
        aVar.fsJ = new ahz();
        aVar.fsK = new aia();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        this.ehh = aVar.acD();
        this.gvO = i;
        this.kWH = i2;
        this.kWJ = i3;
        this.kWK = str;
        this.kWI = bArr;
        this.kWL = i4;
        AppMethodBeat.o(53114);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53115);
        ab.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.kWI == null || this.kWI.length <= 0) && this.gvO != 3)) {
            com.tencent.mm.storage.emotion.h hVar = ((d) g.M(d.class)).getEmojiStorageMgr().xYt;
            String str2 = this.kWH;
            aia bkw = bkw();
            if (bo.isNullOrNil(str2) || bkw == null) {
                ab.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    com.tencent.mm.storage.emotion.g gVar = new com.tencent.mm.storage.emotion.g();
                    gVar.field_designerIDAndType = str2 + com.tencent.mm.storage.emotion.h.a.DesignerEmojiList.value;
                    gVar.field_content = bkw.toByteArray();
                    ContentValues Hl = gVar.Hl();
                    new String[1][0] = str2 + com.tencent.mm.storage.emotion.h.a.DesignerEmojiList.value;
                    if (hVar.bSd.replace("EmotionDesignerInfo", "designerIDAndType", Hl) > 0) {
                        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", str2);
                    } else {
                        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", str2);
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", bo.l(e));
                }
            }
        }
        aia aia = (aia) ((b) qVar).fsH.fsP;
        if (aia.wok != null) {
            this.kWI = aa.a(aia.wok);
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53115);
    }

    public final int getType() {
        return 821;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53116);
        this.eIc = fVar;
        ahz ahz = (ahz) this.ehh.fsG.fsP;
        if (this.kWI != null) {
            ahz.wok = aa.ad(this.kWI);
        } else {
            ahz.wok = new SKBuiltinBuffer_t();
        }
        ab.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", ahz.wok == null ? "Buf is NULL" : ahz.wok.toString());
        ahz.DesignerUin = this.kWH;
        ahz.OpCode = this.gvO;
        ahz.wdI = this.kWJ;
        ahz.wol = this.kWK;
        ahz.wom = this.kWL;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53116);
        return a;
    }

    public final aia bkw() {
        if (this.ehh == null) {
            return null;
        }
        return (aia) this.ehh.fsH.fsP;
    }
}
