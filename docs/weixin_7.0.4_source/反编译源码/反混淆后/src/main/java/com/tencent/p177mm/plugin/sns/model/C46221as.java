package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C43540g;
import com.tencent.p177mm.pluginsdk.model.C23251k;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.as */
public final class C46221as extends C23251k<C43540g, String, Boolean> {
    private String cHr;
    private String fileName;
    private String fsd;
    private OutputStream output = null;
    private String qJc;
    private String qJg = "";

    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(36668);
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        C13373af.cnA().mo69145p(this.qJg, -1, true);
        AppMethodBeat.m2505o(36668);
    }

    /* renamed from: v */
    public final /* synthetic */ void mo38882v(Object[] objArr) {
        AppMethodBeat.m2504i(36669);
        C43540g[] c43540gArr = (C43540g[]) objArr;
        super.mo38882v(c43540gArr);
        C43540g c43540g = c43540gArr[0];
        if (c43540g != null) {
            this.cHr = c43540g.cHr;
            this.qJc = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cHr);
            this.qJg = C29036i.m46103bd(c43540g.requestType, this.cHr);
            this.fsd = "sns_tmpt_" + this.cHr;
            this.fileName = "snst_" + this.cHr;
        }
        AppMethodBeat.m2505o(36669);
    }

    public final C4946a cin() {
        AppMethodBeat.m2504i(36667);
        C4946a cnr = C13373af.cnr();
        AppMethodBeat.m2505o(36667);
        return cnr;
    }

    /* renamed from: dv */
    public final /* bridge */ /* synthetic */ Object mo38879dv() {
        return Boolean.TRUE;
    }
}
