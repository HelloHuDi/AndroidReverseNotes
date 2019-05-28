package com.tencent.p177mm.plugin.fav.p410ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.fav.p410ui.p411b.C3080d;
import com.tencent.p177mm.plugin.fav.p410ui.p411b.C34156b;
import com.tencent.p177mm.plugin.fav.p410ui.p971c.C11885a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;

/* renamed from: com.tencent.mm.plugin.fav.ui.PluginFavUI */
public class PluginFavUI extends C7597f implements C1655b, C9562c {
    private C11885a mkV = new C11885a();
    private C34152a mkW = new C34152a();
    private C43082m mkX = new C43082m();

    /* renamed from: com.tencent.mm.plugin.fav.ui.PluginFavUI$1 */
    class C390541 extends C28106a {
        C390541() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(74288);
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C3080d());
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C34156b());
            AppMethodBeat.m2505o(74288);
            return true;
        }

        public final String getName() {
            return "InitFTSFavUIPluginTask";
        }
    }

    public PluginFavUI() {
        AppMethodBeat.m2504i(74289);
        AppMethodBeat.m2505o(74289);
    }

    public void execute(C1681g c1681g) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(74290);
        this.mkV.dnU();
        this.mkW.dnU();
        this.mkX.dnU();
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(-86016, new C390541());
        AppMethodBeat.m2505o(74290);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(74291);
        this.mkV.dead();
        this.mkW.dead();
        this.mkX.dead();
        AppMethodBeat.m2505o(74291);
    }
}
