package com.tencent.p177mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.wear.model.p1320a.C22726b;
import com.tencent.p177mm.plugin.wear.model.p1320a.C22726b.C22727a;
import com.tencent.p177mm.plugin.wear.model.p1320a.C29721a;
import com.tencent.p177mm.plugin.wear.model.p575e.C22731b;
import com.tencent.p177mm.plugin.wear.model.p575e.C35560i;
import com.tencent.p177mm.plugin.wear.model.p575e.C35561j;
import com.tencent.p177mm.plugin.wear.model.p575e.C40184p;
import com.tencent.p177mm.plugin.wear.p1624a.C43839a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.plugin.wear.model.d */
public final class C35556d {
    C22726b tXI = new C29721a();
    C22731b tXJ = new C22731b();
    public C35560i tXK = new C35560i();
    C35561j tXL = new C35561j();
    C40184p tXM = new C40184p();

    public C35556d() {
        AppMethodBeat.m2504i(26289);
        AppMethodBeat.m2505o(26289);
    }

    public final boolean cUs() {
        AppMethodBeat.m2504i(26290);
        if (cUt() == null || cUt().cUx().size() <= 0) {
            AppMethodBeat.m2505o(26290);
            return false;
        }
        AppMethodBeat.m2505o(26290);
        return true;
    }

    public final C22726b cUt() {
        AppMethodBeat.m2504i(26291);
        if (this.tXI.isAvailable() && this.tXI.cUy()) {
            C22726b c22726b = this.tXI;
            AppMethodBeat.m2505o(26291);
            return c22726b;
        }
        AppMethodBeat.m2505o(26291);
        return null;
    }

    /* renamed from: bA */
    public final boolean mo56290bA(byte[] bArr) {
        AppMethodBeat.m2504i(26292);
        if (bArr == null) {
            AppMethodBeat.m2505o(26292);
            return false;
        } else if (cUs()) {
            C4996ah.getContext();
            String format = String.format("/wechat/%s/%d", new Object[]{"phone", Long.valueOf(System.currentTimeMillis())});
            C22726b cUt = cUt();
            if (cUt == null) {
                AppMethodBeat.m2505o(26292);
                return false;
            }
            C22727a C;
            if (bArr.length > 92160) {
                C = cUt.mo38299C(format, bArr);
            } else {
                C = cUt.mo38298B(format, bArr);
            }
            if (C.code == 0) {
                AppMethodBeat.m2505o(26292);
                return true;
            }
            AppMethodBeat.m2505o(26292);
            return false;
        } else {
            AppMethodBeat.m2505o(26292);
            return false;
        }
    }

    /* renamed from: bB */
    public final byte[] mo56291bB(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(26293);
        byte[] adl = this.tXJ.adl();
        if (bArr == null || adl == null) {
            AppMethodBeat.m2505o(26293);
        } else {
            try {
                C4990ab.m7411d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", C1178g.m2591x(adl));
                SecretKeySpec secretKeySpec = new SecretKeySpec(adl, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
                AppMethodBeat.m2505o(26293);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(26293);
            }
        }
        return bArr2;
    }

    /* renamed from: bC */
    public final byte[] mo56292bC(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(26294);
        byte[] adl = this.tXJ.adl();
        if (bArr == null || adl == null) {
            AppMethodBeat.m2505o(26294);
        } else {
            try {
                C4990ab.m7411d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", C1178g.m2591x(adl));
                bArr2 = C43839a.m78618i(bArr, adl);
                AppMethodBeat.m2505o(26294);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(26294);
            }
        }
        return bArr2;
    }
}
