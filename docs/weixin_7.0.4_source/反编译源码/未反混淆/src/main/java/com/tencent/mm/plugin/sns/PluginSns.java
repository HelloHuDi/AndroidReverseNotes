package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.sns.a.a;
import com.tencent.mm.plugin.sns.a.a.e;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;

public class PluginSns extends f implements b {
    l qCd = new l();
    a qCe = new a();
    o qCf = new o();
    a qCg = new a();

    public PluginSns() {
        AppMethodBeat.i(35613);
        AppMethodBeat.o(35613);
    }

    public void dependency() {
        AppMethodBeat.i(35614);
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.normsg.a.class);
        AppMethodBeat.o(35614);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(35615);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.a(i.class, this.qCd);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.a(c.class, this.qCg);
        a aVar = this.qCg;
        aVar.a(new e());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.d());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.b());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.c());
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginSns", "PluginSns configure");
            pin(new q(af.class));
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.a.class, this.qCe);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.a(m.class, this.qCf);
        }
        AppMethodBeat.o(35615);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(35616);
        com.tencent.mm.bp.c.aks("sns");
        AppMethodBeat.o(35616);
    }

    public String getAccSnsPath() {
        AppMethodBeat.i(35617);
        String str = com.tencent.mm.kernel.g.RP().eJM + "sns/";
        AppMethodBeat.o(35617);
        return str;
    }

    public String getAccSnsTmpPath() {
        AppMethodBeat.i(35618);
        String str = com.tencent.mm.kernel.g.RP().eJM + "sns/temp/";
        AppMethodBeat.o(35618);
        return str;
    }

    public MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.i(35619);
        MMFragment mMFragment = (MMFragment) Fragment.instantiate(context, SnsAlbumUI.class.getName(), bundle);
        AppMethodBeat.o(35619);
        return mMFragment;
    }
}
