package com.tencent.p177mm.plugin.emoji.p726f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ahz;
import com.tencent.p177mm.protocal.protobuf.aia;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C44223g;
import com.tencent.p177mm.storage.emotion.C46624h;
import com.tencent.p177mm.storage.emotion.C46624h.C23518a;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emoji.f.h */
public final class C42946h extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;
    public int gvO;
    private int kWH;
    public byte[] kWI;
    private int kWJ;
    private String kWK;
    private int kWL;

    public C42946h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        AppMethodBeat.m2504i(53114);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahz();
        c1196a.fsK = new aia();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        this.ehh = c1196a.acD();
        this.gvO = i;
        this.kWH = i2;
        this.kWJ = i3;
        this.kWK = str;
        this.kWI = bArr;
        this.kWL = i4;
        AppMethodBeat.m2505o(53114);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53115);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.kWI == null || this.kWI.length <= 0) && this.gvO != 3)) {
            C46624h c46624h = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYt;
            String str2 = this.kWH;
            aia bkw = bkw();
            if (C5046bo.isNullOrNil(str2) || bkw == null) {
                C4990ab.m7420w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    C44223g c44223g = new C44223g();
                    c44223g.field_designerIDAndType = str2 + C23518a.DesignerEmojiList.value;
                    c44223g.field_content = bkw.toByteArray();
                    ContentValues Hl = c44223g.mo10098Hl();
                    new String[1][0] = str2 + C23518a.DesignerEmojiList.value;
                    if (c46624h.bSd.replace("EmotionDesignerInfo", "designerIDAndType", Hl) > 0) {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", str2);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", str2);
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        aia aia = (aia) ((C7472b) c1929q).fsH.fsP;
        if (aia.wok != null) {
            this.kWI = C1946aa.m4150a(aia.wok);
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53115);
    }

    public final int getType() {
        return 821;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53116);
        this.eIc = c1202f;
        ahz ahz = (ahz) this.ehh.fsG.fsP;
        if (this.kWI != null) {
            ahz.wok = C1946aa.m4152ad(this.kWI);
        } else {
            ahz.wok = new SKBuiltinBuffer_t();
        }
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", ahz.wok == null ? "Buf is NULL" : ahz.wok.toString());
        ahz.DesignerUin = this.kWH;
        ahz.OpCode = this.gvO;
        ahz.wdI = this.kWJ;
        ahz.wol = this.kWK;
        ahz.wom = this.kWL;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53116);
        return a;
    }

    public final aia bkw() {
        if (this.ehh == null) {
            return null;
        }
        return (aia) this.ehh.fsH.fsP;
    }
}
