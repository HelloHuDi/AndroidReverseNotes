package com.tencent.p177mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.p576f.C31470a;
import com.tencent.p177mm.pluginsdk.C44068p.C30088c.C14897a;
import com.tencent.p177mm.protocal.protobuf.ctv;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.wear.model.c */
public final class C40182c implements C14897a {
    public final String cUp() {
        AppMethodBeat.m2504i(26286);
        ctv ctv = C43841a.cUn().tXt.tXK.tYz;
        String str;
        if (ctv != null) {
            str = ctv.xqv + IOUtils.LINE_SEPARATOR_UNIX + ctv.xqw + IOUtils.LINE_SEPARATOR_UNIX + ctv.xqx;
            AppMethodBeat.m2505o(26286);
            return str;
        }
        str = "Not Connect";
        AppMethodBeat.m2505o(26286);
        return str;
    }

    public final void cUq() {
        AppMethodBeat.m2504i(26287);
        C43841a.cUn().tXz.mo69532a(new C31470a());
        AppMethodBeat.m2505o(26287);
    }

    public final boolean cUr() {
        String str = null;
        AppMethodBeat.m2504i(26288);
        ctv ctv = C43841a.cUn().tXt.tXK.tYz;
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str)) {
            if (ctv != null) {
                AppMethodBeat.m2505o(26288);
                return true;
            }
            AppMethodBeat.m2505o(26288);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            if (ctv == null || !str.equals("gh_43f2581f6fd6")) {
                AppMethodBeat.m2505o(26288);
                return false;
            }
            AppMethodBeat.m2505o(26288);
            return true;
        } else if (C5046bo.isNullOrNil(str)) {
            if (ctv == null || !str.equals(ctv.xqs)) {
                AppMethodBeat.m2505o(26288);
                return false;
            }
            AppMethodBeat.m2505o(26288);
            return true;
        } else if (ctv != null && str.equals("gh_43f2581f6fd6") && str.equals(ctv.xqs)) {
            AppMethodBeat.m2505o(26288);
            return true;
        } else {
            AppMethodBeat.m2505o(26288);
            return false;
        }
    }
}
