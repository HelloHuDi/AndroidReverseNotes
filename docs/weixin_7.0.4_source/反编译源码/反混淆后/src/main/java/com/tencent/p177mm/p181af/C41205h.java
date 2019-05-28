package com.tencent.p177mm.p181af;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.protocal.protobuf.cde;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.tencent.mm.af.h */
public final class C41205h extends C37435f {
    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(16194);
        C41205h c41205h = new C41205h();
        AppMethodBeat.m2505o(16194);
        return c41205h;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        AppMethodBeat.m2504i(16195);
        if (!C5046bo.isNullOrNil(c8910b.appId)) {
            String str2 = c8910b.cMn;
            cdg cdg = new cdg();
            if (str2 != null) {
                try {
                    cdg.parseFrom(Base64.decode(str2, 0));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            cdg.xcU = new cde();
            cdg.xcU.mVX = c8910b.appId;
            try {
                str2 = Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, "");
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e2, "", new Object[0]);
            }
            c8910b.cMn = str2;
        }
        stringBuilder.append("<statextstr>" + C5046bo.ani(c8910b.cMn) + "</statextstr>");
        AppMethodBeat.m2505o(16195);
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
    }
}
