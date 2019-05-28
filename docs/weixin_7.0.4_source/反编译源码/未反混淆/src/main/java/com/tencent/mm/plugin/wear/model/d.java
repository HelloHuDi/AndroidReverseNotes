package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b tXI = new a();
    com.tencent.mm.plugin.wear.model.e.b tXJ = new com.tencent.mm.plugin.wear.model.e.b();
    public i tXK = new i();
    j tXL = new j();
    p tXM = new p();

    public d() {
        AppMethodBeat.i(26289);
        AppMethodBeat.o(26289);
    }

    public final boolean cUs() {
        AppMethodBeat.i(26290);
        if (cUt() == null || cUt().cUx().size() <= 0) {
            AppMethodBeat.o(26290);
            return false;
        }
        AppMethodBeat.o(26290);
        return true;
    }

    public final b cUt() {
        AppMethodBeat.i(26291);
        if (this.tXI.isAvailable() && this.tXI.cUy()) {
            b bVar = this.tXI;
            AppMethodBeat.o(26291);
            return bVar;
        }
        AppMethodBeat.o(26291);
        return null;
    }

    public final boolean bA(byte[] bArr) {
        AppMethodBeat.i(26292);
        if (bArr == null) {
            AppMethodBeat.o(26292);
            return false;
        } else if (cUs()) {
            ah.getContext();
            String format = String.format("/wechat/%s/%d", new Object[]{"phone", Long.valueOf(System.currentTimeMillis())});
            b cUt = cUt();
            if (cUt == null) {
                AppMethodBeat.o(26292);
                return false;
            }
            b.a C;
            if (bArr.length > 92160) {
                C = cUt.C(format, bArr);
            } else {
                C = cUt.B(format, bArr);
            }
            if (C.code == 0) {
                AppMethodBeat.o(26292);
                return true;
            }
            AppMethodBeat.o(26292);
            return false;
        } else {
            AppMethodBeat.o(26292);
            return false;
        }
    }

    public final byte[] bB(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.i(26293);
        byte[] adl = this.tXJ.adl();
        if (bArr == null || adl == null) {
            AppMethodBeat.o(26293);
        } else {
            try {
                ab.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", g.x(adl));
                SecretKeySpec secretKeySpec = new SecretKeySpec(adl, "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                bArr2 = instance.doFinal(bArr);
                AppMethodBeat.o(26293);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
                AppMethodBeat.o(26293);
            }
        }
        return bArr2;
    }

    public final byte[] bC(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.i(26294);
        byte[] adl = this.tXJ.adl();
        if (bArr == null || adl == null) {
            AppMethodBeat.o(26294);
        } else {
            try {
                ab.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", g.x(adl));
                bArr2 = com.tencent.mm.plugin.wear.a.a.i(bArr, adl);
                AppMethodBeat.o(26294);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
                AppMethodBeat.o(26294);
            }
        }
        return bArr2;
    }
}
