package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35918fs;
import com.tencent.p177mm.protocal.protobuf.C35919ft;
import com.tencent.p177mm.protocal.protobuf.EmotionPrice;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.text.DecimalFormat;

/* renamed from: com.tencent.mm.plugin.emoji.f.b */
public final class C38879b extends C1207m implements C1918k {
    public static int kWi = 6;
    public static int kWj = 7;
    public static int kWk = 10;
    private C1202f eIc;
    private final C7472b ehh;
    private String kWl;
    private EmotionPrice kWm;

    public C38879b(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.m2504i(53093);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35918fs();
        c1196a.fsK = new C35919ft();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        this.ehh = c1196a.acD();
        this.kWl = str;
        this.kWm = emotionPrice;
        AppMethodBeat.m2505o(53093);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53094);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53094);
    }

    public final int getType() {
        return 830;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53095);
        this.eIc = c1202f;
        C35918fs c35918fs = (C35918fs) this.ehh.fsG.fsP;
        c35918fs.ProductID = this.kWl;
        EmotionPrice emotionPrice = new EmotionPrice();
        emotionPrice.Label = this.kWm.Label;
        emotionPrice.Type = this.kWm.Type;
        emotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.kWm.Number));
        c35918fs.vHC = emotionPrice;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53095);
        return a;
    }

    public final C35919ft bkt() {
        return (C35919ft) this.ehh.fsH.fsP;
    }
}
