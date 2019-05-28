package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C23519l;
import com.tencent.p177mm.storage.emotion.C44226k;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emoji.f.o */
public final class C27738o extends C1207m implements C1918k {
    public static int kWX = 0;
    public static int kWY = 1;
    public static int kWZ = 1;
    public static int kXa = 2;
    public static int kXb = 256;
    private final C7472b ehh;
    private C1202f ehi;
    private String kWl;
    private int kXc;

    public C27738o(String str, int i) {
        AppMethodBeat.m2504i(53140);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new GetEmotionRewardRequest();
        c1196a.fsK = new GetEmotionRewardResponse();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        this.ehh = c1196a.acD();
        this.kWl = str;
        this.kXc = i;
        AppMethodBeat.m2505o(53140);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53141);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            if (this.kXc == kWX) {
                C23519l c23519l = C42952j.getEmojiStorageMgr().xYs;
                String str2 = this.kWl;
                GetEmotionRewardResponse bkD = bkD();
                if (C5046bo.isNullOrNil(str2) || bkD == null) {
                    C4990ab.m7420w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        C44226k c44226k = new C44226k();
                        c44226k.field_productID = str2;
                        c44226k.field_content = bkD.toByteArray();
                        if (c23519l.bSd.replace("EmotionRewardInfo", "productID", c44226k.mo10098Hl()) > 0) {
                            C4990ab.m7417i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", str2);
                        } else {
                            C4990ab.m7417i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", str2);
                        }
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", C5046bo.m7574l(e));
                    }
                }
            }
            if (bkD() == null || bkD().Reward == null) {
                C4990ab.m7416i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                C42952j.getEmojiStorageMgr().xYu.mo27481eu(this.kWl, kXb);
                C42952j.bkm().mo61752ca(this.kWl, kXb);
            } else {
                C42952j.getEmojiStorageMgr().xYu.mo27481eu(this.kWl, bkD().Reward.vEq);
                C42952j.bkm().mo61752ca(this.kWl, bkD().Reward.vEq);
            }
        } else if (i3 == 1) {
            C42952j.getEmojiStorageMgr().xYu.mo27481eu(this.kWl, kXb);
            C42952j.bkm().mo61752ca(this.kWl, kXb);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53141);
    }

    public final int getType() {
        return 822;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53142);
        this.ehi = c1202f;
        GetEmotionRewardRequest getEmotionRewardRequest = (GetEmotionRewardRequest) this.ehh.fsG.fsP;
        getEmotionRewardRequest.ProductID = this.kWl;
        getEmotionRewardRequest.OpCode = this.kXc;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53142);
        return a;
    }

    public final GetEmotionRewardResponse bkD() {
        return (GetEmotionRewardResponse) this.ehh.fsH.fsP;
    }
}
