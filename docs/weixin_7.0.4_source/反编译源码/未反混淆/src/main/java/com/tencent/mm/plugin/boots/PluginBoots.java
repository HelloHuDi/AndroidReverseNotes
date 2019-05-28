package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class PluginBoots extends f implements com.tencent.mm.kernel.api.bucket.a, d, c, com.tencent.mm.plugin.boots.a.d {
    private com.tencent.mm.plugin.boots.b.a jJi;
    private com.tencent.mm.plugin.hp.b.c jJj = new com.tencent.mm.plugin.hp.b.c();
    private com.tencent.mm.sdk.b.c<bh> jJk = new com.tencent.mm.sdk.b.c<bh>() {
        {
            AppMethodBeat.i(90514);
            this.xxI = bh.class.getName().hashCode();
            AppMethodBeat.o(90514);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(90515);
            bh bhVar = (bh) bVar;
            if (29 == bhVar.cuB.cut && bhVar.cuB.cuy == 0) {
                ab.d("MicroMsg.Boots.PluginBoots", "hp_res received new hotpatch cache request");
                com.tencent.mm.plugin.hp.b.b.wW(0);
            }
            AppMethodBeat.o(90515);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<bf> jJl = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(90516);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(90516);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(90517);
            bf bfVar = (bf) bVar;
            if (29 == bfVar.cus.cut && bfVar.cus.cuw) {
                ab.d("MicroMsg.Boots.PluginBoots", "hp_res received new/updated download resource, path=%s", bfVar.cus.filePath);
                com.tencent.mm.plugin.hp.b.b.wX(0);
                PluginBoots.this.jJj;
                com.tencent.mm.plugin.hp.b.c.OF(bfVar.cus.filePath);
            }
            AppMethodBeat.o(90517);
            return false;
        }
    };

    static final class a extends q implements com.tencent.mm.kernel.a.b.b {
        a() {
            super(com.tencent.mm.plugin.hp.b.d.class);
        }

        public final void parallelsDependency() {
        }
    }

    public PluginBoots() {
        AppMethodBeat.i(90518);
        AppMethodBeat.o(90518);
    }

    public String name() {
        return "plugin-boots";
    }

    public void installed() {
        AppMethodBeat.i(90519);
        ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots installed");
        alias(com.tencent.mm.plugin.boots.a.d.class);
        AppMethodBeat.o(90519);
    }

    public void uninstalled() {
        AppMethodBeat.i(90520);
        ab.d("MicroMsg.Boots.PluginBoots", "uninstalled");
        super.uninstalled();
        AppMethodBeat.o(90520);
    }

    public void dependency() {
        AppMethodBeat.i(90521);
        ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots dependency");
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        AppMethodBeat.o(90521);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(90522);
        super.configure(gVar);
        AppMethodBeat.o(90522);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(90523);
        ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots execute %s", gVar.eHT);
        if (com.tencent.mm.plugin.boots.b.a.jJA == null) {
            com.tencent.mm.plugin.boots.b.a.jJA = new com.tencent.mm.plugin.boots.b.a();
        }
        this.jJi = com.tencent.mm.plugin.boots.b.a.jJA;
        if (gVar.SG() || gVar.lQ(":patch")) {
            com.tencent.mm.plugin.hp.tinker.d.bGq();
            com.tencent.mm.plugin.hp.tinker.d.b(com.tencent.mm.app.b.cdV);
            com.tencent.mm.sdk.b.a.xxA.c(this.jJj);
            com.tencent.mm.sdk.b.a.xxA.c(this.jJl);
            com.tencent.mm.sdk.b.a.xxA.c(this.jJk);
        }
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(a.class, new e(new a()));
        }
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.boots.a.c.class, new e(new a()));
        }
        AppMethodBeat.o(90523);
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(90524);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.boots.b.a.a.fnj;
            }
        });
        AppMethodBeat.o(90524);
        return hashMap;
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(90525);
        ab.d("MicroMsg.Boots.PluginBoots", "[cpan] boots onDataBaseOpened");
        if (this.jJi != null) {
            this.jJi.jJB = new com.tencent.mm.plugin.boots.b.a.a(hVar);
        }
        AppMethodBeat.o(90525);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    public com.tencent.mm.plugin.boots.a.e getTinkerLogic() {
        return this.jJi;
    }

    public String getBootsPath() {
        AppMethodBeat.i(90526);
        String str = com.tencent.mm.kernel.g.RP().eJM + "boots/";
        AppMethodBeat.o(90526);
        return str;
    }

    public String getBootsTempPath() {
        AppMethodBeat.i(90527);
        String str = com.tencent.mm.kernel.g.RP().eJM + "boots/temp/";
        AppMethodBeat.o(90527);
        return str;
    }

    private void checkDir() {
        AppMethodBeat.i(90528);
        FileOp.tf(getBootsTempPath());
        AppMethodBeat.o(90528);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(90529);
        checkDir();
        AppMethodBeat.o(90529);
    }

    public void onAccountRelease() {
    }
}
