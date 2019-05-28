package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C30656f.C30657a;
import com.tencent.p177mm.p612ui.contact.p625a.C30656f.C30658b;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.a.d */
public final class C46673d extends C30656f {
    public C7616ad ehM;
    public CharSequence zpK;
    public boolean zpL;
    private C15814a zpM = new C15814a();

    /* renamed from: com.tencent.mm.ui.contact.a.d$a */
    class C15814a extends C30658b {
        C15814a() {
            super();
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105276);
            super.mo11087a(context, c5446a, c5445a, z, z2);
            C30657a c30657a = (C30657a) c5446a;
            if (C5046bo.m7519ac(C46673d.this.zpK)) {
                c30657a.gnC.setVisibility(8);
                AppMethodBeat.m2505o(105276);
                return;
            }
            c30657a.gnC.setVisibility(0);
            C46673d.this.zpK = C44089j.m79294b(context, C46673d.this.zpK, C1338a.m2856al(context, C25738R.dimen.f9980m5));
            c30657a.gnC.setText(c30657a.gnC.getContext().getResources().getString(C46673d.this.zpL ? C25738R.string.ave : C25738R.string.avd, new Object[]{C46673d.this.zpK}));
            AppMethodBeat.m2505o(105276);
        }
    }

    public C46673d(int i, C7616ad c7616ad) {
        boolean z = true;
        super(i);
        AppMethodBeat.m2504i(105277);
        this.ehM = c7616ad;
        if (c7616ad.dtS != 1) {
            z = false;
        }
        this.zpL = z;
        AppMethodBeat.m2505o(105277);
    }

    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        boolean z = true;
        AppMethodBeat.m2504i(105278);
        super.mo11082a(context, c5446a);
        if (this.ehM.dtS != 1) {
            z = false;
        }
        this.zpL = z;
        this.zpK = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.ehM.field_username).mo16807mJ(this.ehM.field_username);
        AppMethodBeat.m2505o(105278);
    }

    public final C5447b aou() {
        return this.zpM;
    }
}
