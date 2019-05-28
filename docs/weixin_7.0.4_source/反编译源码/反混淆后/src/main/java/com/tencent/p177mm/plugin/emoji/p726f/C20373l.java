package com.tencent.p177mm.plugin.emoji.p726f;

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
import com.tencent.p177mm.protocal.protobuf.EmotionDetail;
import com.tencent.p177mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.p177mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C44224i;
import com.tencent.p177mm.storage.emotion.C44225j;

/* renamed from: com.tencent.mm.plugin.emoji.f.l */
public final class C20373l extends C1207m implements C1918k {
    /* renamed from: cD */
    private int f4374cD;
    private final C7472b ehh;
    private C1202f ehi;
    private int gOW;
    public String kWz;

    public C20373l(String str, int i, int i2) {
        AppMethodBeat.m2504i(53127);
        this.kWz = str;
        this.gOW = i;
        this.f4374cD = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new GetEmotionDetailRequest();
        c1196a.fsK = new GetEmotionDetailResponse();
        c1196a.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        c1196a.fsI = 412;
        c1196a.fsL = 211;
        c1196a.fsM = 1000000211;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(53127);
    }

    public C20373l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53128);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", this.kWz, Integer.valueOf(this.gOW), Integer.valueOf(this.f4374cD));
        this.ehi = c1202f;
        GetEmotionDetailRequest getEmotionDetailRequest = (GetEmotionDetailRequest) this.ehh.fsG.fsP;
        getEmotionDetailRequest.ProductID = this.kWz;
        getEmotionDetailRequest.Scene = this.gOW;
        getEmotionDetailRequest.Version = this.f4374cD;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53128);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53129);
        C4990ab.m7416i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                C44225j c44225j = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYr;
                String str2 = this.kWz;
                GetEmotionDetailResponse getEmotionDetailResponse = (GetEmotionDetailResponse) this.ehh.fsH.fsP;
                String gw = C4988aa.m7403gw(C4996ah.getContext());
                if (C5046bo.isNullOrNil(str2) || getEmotionDetailResponse == null) {
                    C4990ab.m7420w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    C44224i c44224i = new C44224i();
                    c44224i.field_productID = str2;
                    c44224i.field_content = getEmotionDetailResponse.toByteArray();
                    c44224i.field_lan = gw;
                    if (c44225j.bSd.replace("EmotionDetailInfo", "productID", c44224i.mo10098Hl()) > 0) {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", str2);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", str2);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", C5046bo.m7574l(e));
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(53129);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53129);
    }

    public final EmotionDetail bkz() {
        AppMethodBeat.m2504i(53130);
        EmotionDetail emotionDetail = new EmotionDetail();
        emotionDetail = ((GetEmotionDetailResponse) this.ehh.fsH.fsP).EmotionDetail;
        AppMethodBeat.m2505o(53130);
        return emotionDetail;
    }
}
