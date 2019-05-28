package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.j;

public final class l extends m implements k {
    private int cD;
    private final b ehh;
    private f ehi;
    private int gOW;
    public String kWz;

    public l(String str, int i, int i2) {
        AppMethodBeat.i(53127);
        this.kWz = str;
        this.gOW = i;
        this.cD = i2;
        a aVar = new a();
        aVar.fsJ = new GetEmotionDetailRequest();
        aVar.fsK = new GetEmotionDetailResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.fsI = 412;
        aVar.fsL = 211;
        aVar.fsM = 1000000211;
        this.ehh = aVar.acD();
        AppMethodBeat.o(53127);
    }

    public l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53128);
        ab.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", this.kWz, Integer.valueOf(this.gOW), Integer.valueOf(this.cD));
        this.ehi = fVar;
        GetEmotionDetailRequest getEmotionDetailRequest = (GetEmotionDetailRequest) this.ehh.fsG.fsP;
        getEmotionDetailRequest.ProductID = this.kWz;
        getEmotionDetailRequest.Scene = this.gOW;
        getEmotionDetailRequest.Version = this.cD;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53128);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53129);
        ab.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                j jVar = ((d) g.M(d.class)).getEmojiStorageMgr().xYr;
                String str2 = this.kWz;
                GetEmotionDetailResponse getEmotionDetailResponse = (GetEmotionDetailResponse) this.ehh.fsH.fsP;
                String gw = aa.gw(ah.getContext());
                if (bo.isNullOrNil(str2) || getEmotionDetailResponse == null) {
                    ab.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    i iVar = new i();
                    iVar.field_productID = str2;
                    iVar.field_content = getEmotionDetailResponse.toByteArray();
                    iVar.field_lan = gw;
                    if (jVar.bSd.replace("EmotionDetailInfo", "productID", iVar.Hl()) > 0) {
                        ab.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", str2);
                    } else {
                        ab.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", str2);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", bo.l(e));
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(53129);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53129);
    }

    public final EmotionDetail bkz() {
        AppMethodBeat.i(53130);
        EmotionDetail emotionDetail = new EmotionDetail();
        emotionDetail = ((GetEmotionDetailResponse) this.ehh.fsH.fsP).EmotionDetail;
        AppMethodBeat.o(53130);
        return emotionDetail;
    }
}
