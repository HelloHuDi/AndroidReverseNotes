package com.tencent.p177mm.plugin.fts.p424ui;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C20876e;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C20877f;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C20878g;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C20879h;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C20880i;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C43132b;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C43133c;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C43134d;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C43135j;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C43136k;
import com.tencent.p177mm.plugin.fts.p424ui.p1266b.C45975a;

/* renamed from: com.tencent.mm.plugin.fts.ui.PluginFTSUI */
public class PluginFTSUI extends C7597f implements C1655b, C9562c {
    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(61965);
        registerUILogic();
        AppMethodBeat.m2505o(61965);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(61966);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(16);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(32);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(48);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(64);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(112);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4112);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4128);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4176);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(160);
        AppMethodBeat.m2505o(61966);
    }

    public void execute(C1681g c1681g) {
    }

    private void registerUILogic() {
        AppMethodBeat.m2504i(61967);
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C43136k());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C20876e());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C43133c());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C20879h());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C20878g());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C43135j());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C43134d());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C43132b());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C20880i());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C45975a());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C20877f());
        AppMethodBeat.m2505o(61967);
    }
}
