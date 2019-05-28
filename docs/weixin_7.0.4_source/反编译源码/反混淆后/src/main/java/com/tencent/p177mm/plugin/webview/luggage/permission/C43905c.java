package com.tencent.p177mm.plugin.webview.luggage.permission;

import com.tencent.luggage.p146d.p1171a.C25685a;
import com.tencent.luggage.p146d.p1171a.C41704b;
import com.tencent.luggage.p146d.p1171a.C45121c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.protocal.C15045c.C15081g;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.luggage.permission.c */
public final class C43905c implements C25685a {
    private C24905d uiI;
    private LuggageGetA8Key uii;
    private Set<String> ulu = new HashSet();

    public C43905c(C24905d c24905d, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.m2504i(6490);
        this.uiI = c24905d;
        this.uii = luggageGetA8Key;
        AppMethodBeat.m2505o(6490);
    }

    public final void aen(String str) {
        AppMethodBeat.m2504i(6491);
        this.ulu.add(str);
        AppMethodBeat.m2505o(6491);
    }

    /* renamed from: a */
    public final void mo32974a(C45121c c45121c) {
        AppMethodBeat.m2504i(6492);
        c45121c.mo52837a(C41704b.PASS);
        AppMethodBeat.m2505o(6492);
    }

    /* renamed from: a */
    public final void mo32975a(String str, C45121c c45121c) {
        AppMethodBeat.m2504i(6493);
        if (this.ulu.contains(str)) {
            this.ulu.remove(str);
            c45121c.mo52837a(C41704b.PASS);
            AppMethodBeat.m2505o(6493);
            return;
        }
        int i;
        LuggageGetA8Key luggageGetA8Key = this.uii;
        String url = this.uiI.getUrl();
        C15081g akD = C15045c.akD(str);
        if (akD == null) {
            i = -1;
        } else {
            i = akD.dmb();
        }
        c45121c.mo52837a(luggageGetA8Key.mo74640dA(url, i) ? C41704b.PASS : C41704b.REJECT);
        AppMethodBeat.m2505o(6493);
    }
}
