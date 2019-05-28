package com.tencent.p177mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.plugin.selectcontact.p1620a.C43501a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.plugin.selectcontact.PluginSelectContact */
public class PluginSelectContact extends C7597f implements C9562c, C43501a {
    private C4884c qjs = new C217361();

    /* renamed from: com.tencent.mm.plugin.selectcontact.PluginSelectContact$1 */
    class C217361 extends C4884c<C6471cq> {
        C217361() {
            AppMethodBeat.m2504i(105150);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(105150);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(105151);
            C15830s.init();
            AppMethodBeat.m2505o(105151);
            return false;
        }
    }

    public PluginSelectContact() {
        AppMethodBeat.m2504i(105152);
        AppMethodBeat.m2505o(105152);
    }

    public String name() {
        return "plugin-selectcontact";
    }

    public void installed() {
        AppMethodBeat.m2504i(105153);
        alias(PluginSelectContact.class);
        AppMethodBeat.m2505o(105153);
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(105154);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(105154);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(105155);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(105155);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(105156);
        C15830s.init();
        this.qjs.dnU();
        AppMethodBeat.m2505o(105156);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(105157);
        this.qjs.dead();
        AppMethodBeat.m2505o(105157);
    }
}
