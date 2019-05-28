package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;

public final class o extends m implements k {
    public static int kWX = 0;
    public static int kWY = 1;
    public static int kWZ = 1;
    public static int kXa = 2;
    public static int kXb = 256;
    private final b ehh;
    private f ehi;
    private String kWl;
    private int kXc;

    public o(String str, int i) {
        AppMethodBeat.i(53140);
        a aVar = new a();
        aVar.fsJ = new GetEmotionRewardRequest();
        aVar.fsK = new GetEmotionRewardResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        this.ehh = aVar.acD();
        this.kWl = str;
        this.kXc = i;
        AppMethodBeat.o(53140);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53141);
        ab.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            if (this.kXc == kWX) {
                l lVar = j.getEmojiStorageMgr().xYs;
                String str2 = this.kWl;
                GetEmotionRewardResponse bkD = bkD();
                if (bo.isNullOrNil(str2) || bkD == null) {
                    ab.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        com.tencent.mm.storage.emotion.k kVar = new com.tencent.mm.storage.emotion.k();
                        kVar.field_productID = str2;
                        kVar.field_content = bkD.toByteArray();
                        if (lVar.bSd.replace("EmotionRewardInfo", "productID", kVar.Hl()) > 0) {
                            ab.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", str2);
                        } else {
                            ab.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", str2);
                        }
                    } catch (IOException e) {
                        ab.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", bo.l(e));
                    }
                }
            }
            if (bkD() == null || bkD().Reward == null) {
                ab.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                j.getEmojiStorageMgr().xYu.eu(this.kWl, kXb);
                j.bkm().ca(this.kWl, kXb);
            } else {
                j.getEmojiStorageMgr().xYu.eu(this.kWl, bkD().Reward.vEq);
                j.bkm().ca(this.kWl, bkD().Reward.vEq);
            }
        } else if (i3 == 1) {
            j.getEmojiStorageMgr().xYu.eu(this.kWl, kXb);
            j.bkm().ca(this.kWl, kXb);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53141);
    }

    public final int getType() {
        return 822;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53142);
        this.ehi = fVar;
        GetEmotionRewardRequest getEmotionRewardRequest = (GetEmotionRewardRequest) this.ehh.fsG.fsP;
        getEmotionRewardRequest.ProductID = this.kWl;
        getEmotionRewardRequest.OpCode = this.kXc;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53142);
        return a;
    }

    public final GetEmotionRewardResponse bkD() {
        return (GetEmotionRewardResponse) this.ehh.fsH.fsP;
    }
}
