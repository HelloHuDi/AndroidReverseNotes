package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.g */
public class C27639g extends C33813d {
    private String kum;

    public C27639g(C33817g c33817g, C7620bi c7620bi) {
        super(c33817g, c7620bi);
    }

    /* Access modifiers changed, original: protected */
    public String aan() {
        AppMethodBeat.m2504i(54302);
        if (this.kum == null) {
            this.kum = C32291o.ahl().mo73108c(this.kua.field_imgPath, false, false);
            if (!(C5046bo.isNullOrNil(this.kum) || this.kum.endsWith("hd") || !C5730e.m8628ct(this.kum + "hd"))) {
                this.kum += "hd";
            }
        }
        String str = this.kum;
        AppMethodBeat.m2505o(54302);
        return str;
    }

    public final int getType() {
        return 2;
    }

    /* renamed from: a */
    public final void mo6913a(View view, C11376a c11376a) {
        AppMethodBeat.m2504i(54303);
        C42887b.m76158a(this.kuj.bfy().getContext(), view, c11376a);
        AppMethodBeat.m2505o(54303);
    }
}
