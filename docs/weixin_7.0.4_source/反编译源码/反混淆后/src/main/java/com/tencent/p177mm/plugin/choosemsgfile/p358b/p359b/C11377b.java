package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.b */
public final class C11377b extends C27639g {
    private C8910b kul;
    private String kum;

    private C8910b bfv() {
        AppMethodBeat.m2504i(54287);
        if (this.kul == null) {
            this.kul = C8910b.m16064me(this.kua.field_content);
        }
        C8910b c8910b = this.kul;
        AppMethodBeat.m2505o(54287);
        return c8910b;
    }

    public final String bfo() {
        AppMethodBeat.m2504i(54288);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.m2505o(54288);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54288);
        return str;
    }

    public final String getFileName() {
        AppMethodBeat.m2504i(54289);
        String str;
        if (bfv() != null) {
            str = bfv().title;
            AppMethodBeat.m2505o(54289);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54289);
        return str;
    }

    public final int bfp() {
        AppMethodBeat.m2504i(54290);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.m2505o(54290);
            return i;
        }
        AppMethodBeat.m2505o(54290);
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aan() {
        AppMethodBeat.m2504i(54291);
        if (this.kum == null && bfv() != null && bfv().csD != null && bfv().csD.length() > 0) {
            C30065b aiE = C34832a.aUq().aiE(bfv().csD);
            if (aiE != null) {
                this.kum = aiE.field_fileFullPath;
            }
        }
        String str;
        if (this.kum != null) {
            str = this.kum;
            AppMethodBeat.m2505o(54291);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(54291);
        return str;
    }

    public C11377b(C33817g c33817g, C7620bi c7620bi) {
        super(c33817g, c7620bi);
    }
}
