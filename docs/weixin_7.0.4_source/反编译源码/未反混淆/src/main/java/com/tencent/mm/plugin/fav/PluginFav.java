package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.b.e.a;
import com.tencent.mm.plugin.fav.b.e.d;
import com.tencent.mm.plugin.fav.b.e.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class PluginFav extends f implements b, c, ae {
    private a mej;
    private x mek;
    private q mel;
    private aa mem;
    private t men;
    private s meo;
    private l mep;
    private e meq;
    private d mer;
    private a mes;
    private com.tencent.mm.plugin.fav.b.e.b met;
    private com.tencent.mm.plugin.fav.b.e.c meu;
    private com.tencent.mm.plugin.fav.b.b.a mev = new com.tencent.mm.plugin.fav.b.b.a();
    private com.tencent.mm.plugin.fav.b.b.b mew = new com.tencent.mm.plugin.fav.b.b.b();
    private com.tencent.mm.sdk.b.c mex = new com.tencent.mm.sdk.b.c<sf>() {
        {
            AppMethodBeat.i(5285);
            this.xxI = sf.class.getName().hashCode();
            AppMethodBeat.o(5285);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(5286);
            ab.i("MicroMsg.Fav.PluginFav", "runService");
            if (PluginFav.this.met != null) {
                PluginFav.this.met.run();
            }
            if (PluginFav.this.mes != null) {
                PluginFav.this.mes.run();
            }
            if (PluginFav.this.meq != null) {
                PluginFav.this.meq.run();
            }
            if (PluginFav.this.mer != null) {
                PluginFav.this.mer.run();
            }
            if (PluginFav.this.meu != null) {
                PluginFav.this.meu.run();
            }
            AppMethodBeat.o(5286);
            return false;
        }
    };

    public PluginFav() {
        AppMethodBeat.i(5287);
        AppMethodBeat.o(5287);
    }

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(5288);
        this.mej = new a();
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("uploadfavitem", this.mej);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("resendfavitem", this.mej);
        this.mek = new com.tencent.mm.plugin.fav.b.f.d(ga.HI());
        this.mel = new com.tencent.mm.plugin.fav.b.f.a(ga.HI());
        this.mem = new com.tencent.mm.plugin.fav.b.f.e(ga.HI());
        this.men = new com.tencent.mm.plugin.fav.b.f.c(ga.HI());
        this.meo = new com.tencent.mm.plugin.fav.b.f.b(ga.HI());
        this.meq = new e();
        this.mer = new d();
        this.mes = new a();
        this.met = new com.tencent.mm.plugin.fav.b.e.b();
        this.meu = new com.tencent.mm.plugin.fav.b.e.c();
        this.mep = new l();
        ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                AppMethodBeat.i(5282);
                com.tencent.mm.plugin.fav.b.a.a aVar = new com.tencent.mm.plugin.fav.b.a.a();
                ((n) com.tencent.mm.kernel.g.M(n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.fav.b.a.b bVar = new com.tencent.mm.plugin.fav.b.a.b();
                ((n) com.tencent.mm.kernel.g.M(n.class)).registerNativeLogic(6, bVar);
                bVar.create();
                AppMethodBeat.o(5282);
                return true;
            }

            public final String getName() {
                return "InitFTSFavPluginTask";
            }
        });
        this.mex.dnU();
        this.mev.dnU();
        this.mew.dnU();
        checkDir();
        AppMethodBeat.o(5288);
    }

    public void onAccountRelease() {
        com.tencent.mm.ai.f fVar;
        AppMethodBeat.i(5289);
        this.mex.dead();
        this.mev.dead();
        this.mew.dead();
        ah.bvd();
        ((n) com.tencent.mm.kernel.g.M(n.class)).unregisterIndexStorage(256);
        ((n) com.tencent.mm.kernel.g.M(n.class)).unregisterNativeLogic(6);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("uploadfavitem", this.mej);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("resendfavitem", this.mej);
        this.mej = null;
        if (this.meq != null) {
            fVar = this.meq;
            ab.i("MicroMsg.Fav.FavSendService", "stop");
            fVar.Fb();
            fVar.cra.stopTimer();
            fVar.cqV = 0;
            com.tencent.mm.kernel.g.Rg().b(401, fVar);
            this.meq = null;
        }
        if (this.mer != null) {
            fVar = this.mer;
            ab.i("MicroMsg.Fav.FavModService", "stop");
            fVar.Fb();
            fVar.cra.stopTimer();
            fVar.cqV = 0;
            com.tencent.mm.kernel.g.Rg().b((int) v2helper.EMethodSetAgcRxOn, fVar);
            this.mer = null;
        }
        if (this.mes != null) {
            a aVar = this.mes;
            aVar.Fb();
            aVar.cra.stopTimer();
            aVar.cqV = 0;
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().b(aVar.fyJ);
            this.mes = null;
        }
        if (this.met != null) {
            fVar = this.met;
            ab.i("MicroMsg.Fav.FavCheckCdnService", "stop");
            fVar.Fb();
            fVar.cra.stopTimer();
            com.tencent.mm.kernel.g.Rg().b(404, fVar);
            com.tencent.mm.kernel.g.RO().b(fVar.fyJ);
            this.met = null;
        }
        if (this.meu != null) {
            fVar = this.meu;
            ab.i("MicroMsg.Fav.FavEditService", "stop");
            com.tencent.mm.kernel.g.Rg().b((int) v2helper.EMethodSetAgcRxOn, fVar);
            com.tencent.mm.kernel.g.Rg().b(401, fVar);
            fVar.mhd.clear();
            this.meu = null;
        }
        this.mek = null;
        this.mel = null;
        this.mem = null;
        this.men = null;
        this.meo = null;
        this.mep = null;
        AppMethodBeat.o(5289);
    }

    public void checkFavItem(List<aax> list) {
        AppMethodBeat.i(5290);
        final com.tencent.mm.plugin.fav.b.d.a aVar = new com.tencent.mm.plugin.fav.b.d.a((List) list);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5283);
                com.tencent.mm.kernel.g.Rg().a(aVar, 0);
                AppMethodBeat.o(5283);
            }
        });
        AppMethodBeat.o(5290);
    }

    public void checkFavItem(abi abi) {
        AppMethodBeat.i(5291);
        final com.tencent.mm.plugin.fav.b.d.a aVar = new com.tencent.mm.plugin.fav.b.d.a(abi);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5284);
                com.tencent.mm.kernel.g.Rg().a(aVar, 0);
                AppMethodBeat.o(5284);
            }
        });
        AppMethodBeat.o(5291);
    }

    public x getFavItemInfoStorage() {
        return this.mek;
    }

    public q getFavCdnStorage() {
        return this.mel;
    }

    public s getFavConfigStorage() {
        return this.meo;
    }

    public t getFavEditInfoStorage() {
        return this.men;
    }

    public aa getFavSearchStorage() {
        return this.mem;
    }

    public l getFavTagSetMgr() {
        return this.mep;
    }

    public ac getSendService() {
        return this.meq;
    }

    public d getModService() {
        return this.mer;
    }

    public a getFavCdnService() {
        return this.mes;
    }

    public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService() {
        return this.met;
    }

    public com.tencent.mm.plugin.fav.b.e.c getEditService() {
        return this.meu;
    }

    private static void checkDir() {
        AppMethodBeat.i(5292);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bum());
        if (!(bVar.exists() && bVar.isDirectory())) {
            ab.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bue());
        if (!(bVar.exists() && bVar.isDirectory())) {
            ab.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bul());
        if (!(bVar.exists() && bVar.isDirectory())) {
            ab.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bun());
        if (!(bVar.exists() && bVar.isDirectory())) {
            ab.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
            bVar.mkdirs();
        }
        AppMethodBeat.o(5292);
    }
}
