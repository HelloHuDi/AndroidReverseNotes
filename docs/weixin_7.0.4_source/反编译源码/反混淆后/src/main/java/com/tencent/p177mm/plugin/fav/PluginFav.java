package com.tencent.p177mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p230g.p231a.C32629sf;
import com.tencent.p177mm.p230g.p711c.C18482ga;
import com.tencent.p177mm.plugin.fav.p407a.C11856x;
import com.tencent.p177mm.plugin.fav.p407a.C20672ac;
import com.tencent.p177mm.plugin.fav.p407a.C34123aa;
import com.tencent.p177mm.plugin.fav.p407a.C34125ah;
import com.tencent.p177mm.plugin.fav.p407a.C34129t;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C45927l;
import com.tencent.p177mm.plugin.fav.p407a.C6894q;
import com.tencent.p177mm.plugin.fav.p407a.C6895s;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p408b.p1548d.C39040a;
import com.tencent.p177mm.plugin.fav.p408b.p1612b.C43059a;
import com.tencent.p177mm.plugin.fav.p408b.p1612b.C43060b;
import com.tencent.p177mm.plugin.fav.p408b.p409e.C20683c;
import com.tencent.p177mm.plugin.fav.p408b.p409e.C39041e;
import com.tencent.p177mm.plugin.fav.p408b.p409e.C45928d;
import com.tencent.p177mm.plugin.fav.p408b.p409e.C6896a;
import com.tencent.p177mm.plugin.fav.p408b.p409e.C6903b;
import com.tencent.p177mm.plugin.fav.p408b.p968a.C11857a;
import com.tencent.p177mm.plugin.fav.p408b.p968a.C27976b;
import com.tencent.p177mm.plugin.fav.p408b.p970f.C11861a;
import com.tencent.p177mm.plugin.fav.p408b.p970f.C34132b;
import com.tencent.p177mm.plugin.fav.p408b.p970f.C36765c;
import com.tencent.p177mm.plugin.fav.p408b.p970f.C36766e;
import com.tencent.p177mm.plugin.fav.p408b.p970f.C45929d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.protocal.protobuf.aax;
import com.tencent.p177mm.protocal.protobuf.abi;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.wxmm.v2helper;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.PluginFav */
public class PluginFav extends C7597f implements C1655b, C9562c, C7604ae {
    private C20680a mej;
    private C11856x mek;
    private C6894q mel;
    private C34123aa mem;
    private C34129t men;
    private C6895s meo;
    private C45927l mep;
    private C39041e meq;
    private C45928d mer;
    private C6896a mes;
    private C6903b met;
    private C20683c meu;
    private C43059a mev = new C43059a();
    private C43060b mew = new C43060b();
    private C4884c mex = new C279594();

    /* renamed from: com.tencent.mm.plugin.fav.PluginFav$1 */
    class C279571 extends C28106a {
        C279571() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(5282);
            C11857a c11857a = new C11857a();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerIndexStorage(c11857a);
            c11857a.create();
            C27976b c27976b = new C27976b();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerNativeLogic(6, c27976b);
            c27976b.create();
            AppMethodBeat.m2505o(5282);
            return true;
        }

        public final String getName() {
            return "InitFTSFavPluginTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.PluginFav$4 */
    class C279594 extends C4884c<C32629sf> {
        C279594() {
            AppMethodBeat.m2504i(5285);
            this.xxI = C32629sf.class.getName().hashCode();
            AppMethodBeat.m2505o(5285);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5286);
            C4990ab.m7416i("MicroMsg.Fav.PluginFav", "runService");
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
            AppMethodBeat.m2505o(5286);
            return false;
        }
    }

    public PluginFav() {
        AppMethodBeat.m2504i(5287);
        AppMethodBeat.m2505o(5287);
    }

    public void execute(C1681g c1681g) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(5288);
        this.mej = new C20680a();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("uploadfavitem", this.mej);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("resendfavitem", this.mej);
        this.mek = new C45929d(C18482ga.m28777HI());
        this.mel = new C11861a(C18482ga.m28777HI());
        this.mem = new C36766e(C18482ga.m28777HI());
        this.men = new C36765c(C18482ga.m28777HI());
        this.meo = new C34132b(C18482ga.m28777HI());
        this.meq = new C39041e();
        this.mer = new C45928d();
        this.mes = new C6896a();
        this.met = new C6903b();
        this.meu = new C20683c();
        this.mep = new C45927l();
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(-86016, new C279571());
        this.mex.dnU();
        this.mev.dnU();
        this.mew.dnU();
        PluginFav.checkDir();
        AppMethodBeat.m2505o(5288);
    }

    public void onAccountRelease() {
        C1202f c1202f;
        AppMethodBeat.m2504i(5289);
        this.mex.dead();
        this.mev.dead();
        this.mew.dead();
        C34125ah.bvd();
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterIndexStorage(256);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterNativeLogic(6);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("uploadfavitem", this.mej);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("resendfavitem", this.mej);
        this.mej = null;
        if (this.meq != null) {
            c1202f = this.meq;
            C4990ab.m7416i("MicroMsg.Fav.FavSendService", "stop");
            c1202f.mo61949Fb();
            c1202f.cra.stopTimer();
            c1202f.cqV = 0;
            C1720g.m3540Rg().mo14546b(401, c1202f);
            this.meq = null;
        }
        if (this.mer != null) {
            c1202f = this.mer;
            C4990ab.m7416i("MicroMsg.Fav.FavModService", "stop");
            c1202f.mo73777Fb();
            c1202f.cra.stopTimer();
            c1202f.cqV = 0;
            C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetAgcRxOn, c1202f);
            this.mer = null;
        }
        if (this.mes != null) {
            C6896a c6896a = this.mes;
            c6896a.mo15174Fb();
            c6896a.cra.stopTimer();
            c6896a.cqV = 0;
            C1720g.m3537RQ();
            C1720g.m3535RO().mo5188b(c6896a.fyJ);
            this.mes = null;
        }
        if (this.met != null) {
            c1202f = this.met;
            C4990ab.m7416i("MicroMsg.Fav.FavCheckCdnService", "stop");
            c1202f.mo15181Fb();
            c1202f.cra.stopTimer();
            C1720g.m3540Rg().mo14546b(404, c1202f);
            C1720g.m3535RO().mo5188b(c1202f.fyJ);
            this.met = null;
        }
        if (this.meu != null) {
            c1202f = this.meu;
            C4990ab.m7416i("MicroMsg.Fav.FavEditService", "stop");
            C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetAgcRxOn, c1202f);
            C1720g.m3540Rg().mo14546b(401, c1202f);
            c1202f.mhd.clear();
            this.meu = null;
        }
        this.mek = null;
        this.mel = null;
        this.mem = null;
        this.men = null;
        this.meo = null;
        this.mep = null;
        AppMethodBeat.m2505o(5289);
    }

    public void checkFavItem(List<aax> list) {
        AppMethodBeat.m2504i(5290);
        final C39040a c39040a = new C39040a((List) list);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5283);
                C1720g.m3540Rg().mo14541a(c39040a, 0);
                AppMethodBeat.m2505o(5283);
            }
        });
        AppMethodBeat.m2505o(5290);
    }

    public void checkFavItem(abi abi) {
        AppMethodBeat.m2504i(5291);
        final C39040a c39040a = new C39040a(abi);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5284);
                C1720g.m3540Rg().mo14541a(c39040a, 0);
                AppMethodBeat.m2505o(5284);
            }
        });
        AppMethodBeat.m2505o(5291);
    }

    public C11856x getFavItemInfoStorage() {
        return this.mek;
    }

    public C6894q getFavCdnStorage() {
        return this.mel;
    }

    public C6895s getFavConfigStorage() {
        return this.meo;
    }

    public C34129t getFavEditInfoStorage() {
        return this.men;
    }

    public C34123aa getFavSearchStorage() {
        return this.mem;
    }

    public C45927l getFavTagSetMgr() {
        return this.mep;
    }

    public C20672ac getSendService() {
        return this.meq;
    }

    public C45928d getModService() {
        return this.mer;
    }

    public C6896a getFavCdnService() {
        return this.mes;
    }

    public C6903b getCheckCdnService() {
        return this.met;
    }

    public C20683c getEditService() {
        return this.meu;
    }

    private static void checkDir() {
        AppMethodBeat.m2504i(5292);
        C5728b c5728b = new C5728b(C39037b.bum());
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            C4990ab.m7416i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
            c5728b.mkdirs();
        }
        c5728b = new C5728b(C39037b.bue());
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            C4990ab.m7416i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
            c5728b.mkdirs();
        }
        c5728b = new C5728b(C39037b.bul());
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            C4990ab.m7416i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
            c5728b.mkdirs();
        }
        c5728b = new C5728b(C39037b.bun());
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            C4990ab.m7416i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(5292);
    }
}
