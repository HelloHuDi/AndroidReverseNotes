package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.h */
public final class C35850h implements C40437i {
    /* renamed from: a */
    public final C46633o mo56643a(C5536q c5536q, String str, String str2, String str3, String str4, String str5, C30111a c30111a) {
        AppMethodBeat.m2504i(27711);
        C46633o a = C35844g.m58758a(c5536q, str, str2, str3, str4, str5, c30111a);
        AppMethodBeat.m2505o(27711);
        return a;
    }

    /* renamed from: a */
    public final void mo56647a(C5536q c5536q, String str, String str2, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27712);
        C35844g.m58782a(c5536q, str, str2, str3, c30111a);
        AppMethodBeat.m2505o(27712);
    }

    /* renamed from: b */
    public final C5653c mo56648b(C5536q c5536q, String str, String str2, String str3, String str4, String str5, C30111a c30111a) {
        AppMethodBeat.m2504i(27713);
        C5653c b = C35844g.m58787b(c5536q, str, str2, str3, str4, str5, c30111a);
        AppMethodBeat.m2505o(27713);
        return b;
    }

    /* renamed from: a */
    public final C5653c mo56644a(Context context, String str, View view, String str2, C30111a c30111a) {
        AppMethodBeat.m2504i(27714);
        C23273a djy = new C23273a(context).mo38972cx(str).mo38976ev(view).mo38977h(Boolean.TRUE).djy();
        djy.vkn = str2;
        C5653c c5653c = djy.mo38966a(c30111a).gud;
        AppMethodBeat.m2505o(27714);
        return c5653c;
    }

    /* renamed from: a */
    public final void mo56646a(Context context, String str, String str2, String str3, String str4, String str5, C30111a c30111a) {
        AppMethodBeat.m2504i(27715);
        C23273a c23273a = new C23273a(context);
        c23273a.mo38972cx(str).ajC(str2).vkn = str3;
        c23273a.ajD(str5).djx();
        c23273a.vkm.asH(str4);
        c23273a.mo38966a(c30111a).gud.show();
        AppMethodBeat.m2505o(27715);
    }

    /* renamed from: a */
    public final void mo56645a(Context context, String str, String str2, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27716);
        C23273a c23273a = new C23273a(context);
        c23273a.mo38972cx(str);
        c23273a.ajE(str2);
        c23273a.mo38977h(Boolean.TRUE);
        c23273a.vkn = str3;
        c23273a.mo38966a(c30111a).gud.show();
        AppMethodBeat.m2505o(27716);
    }
}
