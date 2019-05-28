package com.tencent.p177mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.normsg.C21383a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p1024b.C29032b;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.sns.p1024b.C39727a;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.plugin.sns.p514a.C39724a;
import com.tencent.p177mm.plugin.sns.p514a.p1023a.C13340b;
import com.tencent.p177mm.plugin.sns.p514a.p1023a.C34924c;
import com.tencent.p177mm.plugin.sns.p514a.p1023a.C34925e;
import com.tencent.p177mm.plugin.sns.p514a.p1023a.C39723d;
import com.tencent.p177mm.plugin.sns.p520ui.album.SnsAlbumUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.PluginSns */
public class PluginSns extends C7597f implements C29032b {
    C34942l qCd = new C34942l();
    C29030a qCe = new C29030a();
    C34964o qCf = new C34964o();
    C39724a qCg = new C39724a();

    public PluginSns() {
        AppMethodBeat.m2504i(35613);
        AppMethodBeat.m2505o(35613);
    }

    public void dependency() {
        AppMethodBeat.m2504i(35614);
        dependsOn(C6835d.class);
        dependsOn(C21383a.class);
        AppMethodBeat.m2505o(35614);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(35615);
        C1720g.m3537RQ();
        C1720g.m3542a(C46210i.class, this.qCd);
        C1720g.m3537RQ();
        C1720g.m3542a(C13356c.class, this.qCg);
        C39724a c39724a = this.qCg;
        c39724a.mo62706a(new C34925e());
        c39724a.mo62706a(new C39723d());
        c39724a.mo62706a(new C13340b());
        c39724a.mo62706a(new C34924c());
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginSns", "PluginSns configure");
            pin(new C7485q(C13373af.class));
            C1720g.m3537RQ();
            C1720g.m3542a(C39727a.class, this.qCe);
            C1720g.m3537RQ();
            C1720g.m3542a(C29034m.class, this.qCf);
        }
        AppMethodBeat.m2505o(35615);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(35616);
        C9204c.aks("sns");
        AppMethodBeat.m2505o(35616);
    }

    public String getAccSnsPath() {
        AppMethodBeat.m2504i(35617);
        String str = C1720g.m3536RP().eJM + "sns/";
        AppMethodBeat.m2505o(35617);
        return str;
    }

    public String getAccSnsTmpPath() {
        AppMethodBeat.m2504i(35618);
        String str = C1720g.m3536RP().eJM + "sns/temp/";
        AppMethodBeat.m2505o(35618);
        return str;
    }

    public MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(35619);
        MMFragment mMFragment = (MMFragment) Fragment.instantiate(context, SnsAlbumUI.class.getName(), bundle);
        AppMethodBeat.m2505o(35619);
        return mMFragment;
    }
}
