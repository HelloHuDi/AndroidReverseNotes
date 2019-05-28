package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.protocal.C46518p.C40498a;
import com.tencent.p177mm.protocal.C46518p.C46517b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelsimple.f */
public final class C32824f extends C1207m implements C1918k {
    public byte[] content;
    private C1202f ehi;
    public String fOt = "";
    private C1929q ftU;

    /* renamed from: com.tencent.mm.modelsimple.f$a */
    public static class C26469a extends C6297k {
        private final C40498a fOu = new C40498a();
        private final C46517b fOv = new C46517b();

        public C26469a() {
            AppMethodBeat.m2504i(16567);
            AppMethodBeat.m2505o(16567);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fOu;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fOv;
        }

        public final int getType() {
            return 10;
        }

        public final String getUri() {
            return null;
        }
    }

    public C32824f(List<String> list, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.m2504i(16568);
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.ftU = new C26469a();
        C40498a c40498a = (C40498a) this.ftU.acF();
        c40498a.cAd = 111;
        c40498a.bJt = 0;
        c40498a.fQi = currentTimeMillis;
        Assert.assertTrue(str != null);
        c40498a.vyw = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        c40498a.vyx = bArr;
        C4990ab.m7410d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=".concat(String.valueOf(currentTimeMillis)));
        C4990ab.m7410d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + C37432o.m63092t(bArr, 0));
        AppMethodBeat.m2505o(16568);
    }

    public C32824f(C4835e c4835e) {
        AppMethodBeat.m2504i(16569);
        C46517b c46517b = (C46517b) c4835e;
        this.fOt = c46517b.fOt;
        this.content = c46517b.content;
        AppMethodBeat.m2505o(16569);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16570);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(16570);
        return a;
    }

    public final int getType() {
        return 10;
    }

    public final boolean acI() {
        return true;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16571);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16571);
    }
}
