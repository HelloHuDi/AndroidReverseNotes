package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.a.b */
public final class C46672b extends C30656f {
    public String bCu;
    public int resId = 0;
    private boolean zpE;

    public C46672b(int i) {
        super(i);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105269);
        if (this.resId == 0 || this.bCu == null) {
            C7616ad c7616ad = this.ehM;
            if (!this.zpE) {
                C1720g.m3537RQ();
                c7616ad = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
                this.ehM = c7616ad;
                this.zpE = true;
            }
            C7616ad c7616ad2 = c7616ad;
            if (c7616ad2 == null) {
                this.gnx = "";
                AppMethodBeat.m2505o(105269);
                return;
            }
            this.gnx = C44089j.m79294b(context, ((C34530b) C1720g.m3528K(C34530b.class)).mo55063c(c7616ad2), C1338a.m2856al(context, C25738R.dimen.f9980m5));
            this.username = c7616ad2.field_username;
            AppMethodBeat.m2505o(105269);
            return;
        }
        this.zpV = this.resId;
        this.zpU = this.bCu;
        AppMethodBeat.m2505o(105269);
    }
}
