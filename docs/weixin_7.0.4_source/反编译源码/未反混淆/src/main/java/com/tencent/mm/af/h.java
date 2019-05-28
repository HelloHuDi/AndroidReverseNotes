package com.tencent.mm.af;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.Map;

public final class h extends f {
    public final f Xz() {
        AppMethodBeat.i(16194);
        h hVar = new h();
        AppMethodBeat.o(16194);
        return hVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
        AppMethodBeat.i(16195);
        if (!bo.isNullOrNil(bVar.appId)) {
            String str2 = bVar.cMn;
            cdg cdg = new cdg();
            if (str2 != null) {
                try {
                    cdg.parseFrom(Base64.decode(str2, 0));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            cdg.xcU = new cde();
            cdg.xcU.mVX = bVar.appId;
            try {
                str2 = Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, "");
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e2, "", new Object[0]);
            }
            bVar.cMn = str2;
        }
        stringBuilder.append("<statextstr>" + bo.ani(bVar.cMn) + "</statextstr>");
        AppMethodBeat.o(16195);
    }

    public final void a(Map<String, String> map, b bVar) {
    }
}
