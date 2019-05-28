package com.tencent.p177mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.music.cache.C21343c;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.p1554c.C39442b;
import com.tencent.p177mm.plugin.music.model.p998a.C43330c;
import com.tencent.p177mm.plugin.music.p1651a.C46091a;
import com.tencent.p177mm.plugin.music.p460b.C12657d;
import com.tencent.p177mm.plugin.music.p460b.p996a.C28540d;
import com.tencent.p177mm.plugin.music.p460b.p996a.C39425c;
import com.tencent.p177mm.plugin.music.p462e.C43324l;
import com.tencent.p177mm.plugin.music.p462e.C44752b;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C12665a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.music.PluginMusic */
public class PluginMusic extends C7597f implements C46091a {
    public void installed() {
        AppMethodBeat.m2504i(104809);
        alias(C46091a.class);
        AppMethodBeat.m2505o(104809);
    }

    public String name() {
        return "plugin-music";
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(104810);
        C43329b.init(C4996ah.getContext());
        C43329b.m77294a(C21343c.class, new C43330c());
        C43329b.m77294a(C28540d.class, new C39425c());
        C43329b.m77294a(C44752b.class, new C43324l());
        C12657d.init();
        C12665a.m20659a(new C39442b());
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
            pin(new C7485q(C39445e.class));
        }
        AppMethodBeat.m2505o(104810);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(104811);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
            C9204c.aks("music");
        }
        AppMethodBeat.m2505o(104811);
    }

    public void uninstalled() {
        AppMethodBeat.m2504i(104812);
        super.uninstalled();
        C12657d.release();
        C43329b.m77293L(C21343c.class);
        C43329b.m77293L(C28540d.class);
        C43329b.m77293L(C44752b.class);
        C43329b.release();
        AppMethodBeat.m2505o(104812);
    }
}
