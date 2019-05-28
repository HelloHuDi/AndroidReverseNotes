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
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.aib;
import com.tencent.p177mm.protocal.protobuf.aic;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C44223g;
import com.tencent.p177mm.storage.emotion.C46624h;
import com.tencent.p177mm.storage.emotion.C46624h.C23518a;
import com.tencent.view.C31128d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emoji.f.i */
public final class C42947i extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;
    private String kWM;

    public C42947i(String str) {
        AppMethodBeat.m2504i(53117);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aib();
        c1196a.fsK = new aic();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        c1196a.fsI = C31128d.MIC_PTU_SHISHANG2;
        this.ehh = c1196a.acD();
        this.kWM = str;
        AppMethodBeat.m2505o(53117);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53118);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C46624h c46624h = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYt;
            String str2 = this.kWM;
            aic bkx = bkx();
            if (C5046bo.isNullOrNil(str2) || bkx == null) {
                C4990ab.m7420w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    C44223g c44223g = new C44223g();
                    c44223g.field_designerIDAndType = str2 + C23518a.DesignerSimpleInfo.value;
                    c44223g.field_content = bkx.toByteArray();
                    ContentValues Hl = c44223g.mo10098Hl();
                    new String[1][0] = str2 + C23518a.DesignerSimpleInfo.value;
                    if (c46624h.bSd.replace("EmotionDesignerInfo", "designerIDAndType", Hl) > 0) {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", str2);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", str2);
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53118);
    }

    public final aic bkx() {
        if (this.ehh == null) {
            return null;
        }
        return (aic) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return C31128d.MIC_PTU_SHISHANG2;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53119);
        this.eIc = c1202f;
        ((aib) this.ehh.fsG.fsP).wdC = this.kWM;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53119);
        return a;
    }
}
