package com.tencent.p177mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32521bh;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C33719e;
import com.tencent.p177mm.plugin.boots.p348a.C7602d;
import com.tencent.p177mm.plugin.boots.p923b.C11183a;
import com.tencent.p177mm.plugin.boots.p923b.p1240a.C20016a;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.p436hp.p437b.C34359c;
import com.tencent.p177mm.plugin.p436hp.p437b.C34360d;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.plugin.p436hp.tinker.C34364d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.boots.PluginBoots */
public class PluginBoots extends C7597f implements C18523a, C26346d, C1671c, C7602d {
    private C11183a jJi;
    private C34359c jJj = new C34359c();
    private C4884c<C32521bh> jJk = new C111801();
    private C4884c<C32519bf> jJl = new C111812();

    /* renamed from: com.tencent.mm.plugin.boots.PluginBoots$a */
    static final class C7601a extends C7485q implements C1655b {
        C7601a() {
            super(C34360d.class);
        }

        public final void parallelsDependency() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.boots.PluginBoots$1 */
    class C111801 extends C4884c<C32521bh> {
        C111801() {
            AppMethodBeat.m2504i(90514);
            this.xxI = C32521bh.class.getName().hashCode();
            AppMethodBeat.m2505o(90514);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(90515);
            C32521bh c32521bh = (C32521bh) c4883b;
            if (29 == c32521bh.cuB.cut && c32521bh.cuB.cuy == 0) {
                C4990ab.m7410d("MicroMsg.Boots.PluginBoots", "hp_res received new hotpatch cache request");
                C46028b.m85603wW(0);
            }
            AppMethodBeat.m2505o(90515);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.boots.PluginBoots$2 */
    class C111812 extends C4884c<C32519bf> {
        C111812() {
            AppMethodBeat.m2504i(90516);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(90516);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(90517);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (29 == c32519bf.cus.cut && c32519bf.cus.cuw) {
                C4990ab.m7411d("MicroMsg.Boots.PluginBoots", "hp_res received new/updated download resource, path=%s", c32519bf.cus.filePath);
                C46028b.m85604wX(0);
                PluginBoots.this.jJj;
                C34359c.m56333OF(c32519bf.cus.filePath);
            }
            AppMethodBeat.m2505o(90517);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.boots.PluginBoots$3 */
    class C111823 implements C1366d {
        C111823() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20016a.fnj;
        }
    }

    public PluginBoots() {
        AppMethodBeat.m2504i(90518);
        AppMethodBeat.m2505o(90518);
    }

    public String name() {
        return "plugin-boots";
    }

    public void installed() {
        AppMethodBeat.m2504i(90519);
        C4990ab.m7410d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
        alias(C7602d.class);
        AppMethodBeat.m2505o(90519);
    }

    public void uninstalled() {
        AppMethodBeat.m2504i(90520);
        C4990ab.m7410d("MicroMsg.Boots.PluginBoots", "uninstalled");
        super.uninstalled();
        AppMethodBeat.m2505o(90520);
    }

    public void dependency() {
        AppMethodBeat.m2504i(90521);
        C4990ab.m7410d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
        dependsOn(C27697a.class);
        AppMethodBeat.m2505o(90521);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(90522);
        super.configure(c1681g);
        AppMethodBeat.m2505o(90522);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(90523);
        C4990ab.m7411d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", c1681g.eHT);
        if (C11183a.jJA == null) {
            C11183a.jJA = new C11183a();
        }
        this.jJi = C11183a.jJA;
        if (c1681g.mo5181SG() || c1681g.mo5183lQ(":patch")) {
            C34364d.bGq();
            C34364d.m56347b(C1244b.cdV);
            C4879a.xxA.mo10052c(this.jJj);
            C4879a.xxA.mo10052c(this.jJl);
            C4879a.xxA.mo10052c(this.jJk);
        }
        if (c1681g.mo5181SG()) {
            C1720g.m3543a(C7601a.class, new C6625e(new C7601a()));
        }
        if (c1681g.mo5181SG()) {
            C1720g.m3543a(C20015c.class, new C6625e(new C2679a()));
        }
        AppMethodBeat.m2505o(90523);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(90524);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new C111823());
        AppMethodBeat.m2505o(90524);
        return hashMap;
    }

    public void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(90525);
        C4990ab.m7410d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
        if (this.jJi != null) {
            this.jJi.jJB = new C20016a(c7480h);
        }
        AppMethodBeat.m2505o(90525);
    }

    public void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public C33719e getTinkerLogic() {
        return this.jJi;
    }

    public String getBootsPath() {
        AppMethodBeat.m2504i(90526);
        String str = C1720g.m3536RP().eJM + "boots/";
        AppMethodBeat.m2505o(90526);
        return str;
    }

    public String getBootsTempPath() {
        AppMethodBeat.m2504i(90527);
        String str = C1720g.m3536RP().eJM + "boots/temp/";
        AppMethodBeat.m2505o(90527);
        return str;
    }

    private void checkDir() {
        AppMethodBeat.m2504i(90528);
        FileOp.m64147tf(getBootsTempPath());
        AppMethodBeat.m2505o(90528);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(90529);
        checkDir();
        AppMethodBeat.m2505o(90529);
    }

    public void onAccountRelease() {
    }
}
