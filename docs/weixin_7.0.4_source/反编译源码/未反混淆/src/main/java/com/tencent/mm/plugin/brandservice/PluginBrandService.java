package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.s;
import com.tencent.ttpic.FilterEnum4Shaka;

public class PluginBrandService extends f implements c, com.tencent.mm.plugin.brandservice.a.c {
    private a jKo = new a() {
        public final void a(h hVar, h.c cVar) {
            int i = 0;
            AppMethodBeat.i(13805);
            int i2;
            if (hVar == null || cVar == null) {
                AppMethodBeat.o(13805);
            } else if (("insert".equals(cVar.oqJ) || "update".equals(cVar.oqJ)) && cVar.oqK != null) {
                while (true) {
                    i2 = i;
                    if (i2 < cVar.oqK.size()) {
                        bi biVar = (bi) cVar.oqK.get(i2);
                        if (biVar.field_isSend != 1) {
                            s.an(biVar);
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(13805);
                        return;
                    }
                }
            } else {
                if ("delete".equals(cVar.oqJ) && cVar.oqK != null) {
                    while (true) {
                        i2 = i;
                        if (i2 >= cVar.oqK.size()) {
                            break;
                        }
                        s.ao((bi) cVar.oqK.get(i2));
                        i = i2 + 1;
                    }
                }
                AppMethodBeat.o(13805);
            }
        }
    };
    private r.c jKp = new r.c() {
        public final void a(Object obj, r.a aVar) {
            AppMethodBeat.i(13806);
            s.drP();
            AppMethodBeat.o(13806);
        }
    };

    public PluginBrandService() {
        AppMethodBeat.i(13807);
        AppMethodBeat.o(13807);
    }

    public void installed() {
        AppMethodBeat.i(13808);
        alias(com.tencent.mm.plugin.brandservice.a.c.class);
        AppMethodBeat.o(13808);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(13809);
        addBrandServiceEvent();
        addPlaceTopChangeListener();
        if (gVar.SG()) {
            pin(new q(d.class));
        }
        AppMethodBeat.o(13809);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(13810);
        com.tencent.mm.bp.c.aks("brandservice");
        if (gVar.SG() || gVar.lQ(":tools") || gVar.lQ(":toolsmp")) {
            com.tencent.mm.kernel.g.a(b.class, new c());
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.axy();
        a.a aVar = a.jKf;
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), a.jKe);
        AppMethodBeat.o(13810);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(13811);
        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.jKo, Looper.getMainLooper());
        z.aeX().a(this.jKp, Looper.getMainLooper());
        z.aeY().a(this.jKp, Looper.getMainLooper());
        if (s.aVO()) {
            com.tencent.mm.plugin.brandservice.ui.timeline.c cVar2 = new com.tencent.mm.plugin.brandservice.ui.timeline.c();
            ab.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
            int intValue = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue();
            if ((intValue & 1) == 0) {
                ((j) com.tencent.mm.kernel.g.K(j.class)).XR().apb("officialaccounts");
                z.aeX().drK();
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 1));
            }
        }
        AppMethodBeat.o(13811);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(13812);
        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.jKo);
        z.aeX().a(this.jKp);
        z.aeY().a(this.jKp);
        AppMethodBeat.o(13812);
    }

    private void addBrandServiceEvent() {
        AppMethodBeat.i(13813);
        com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.sdk.b.c<aj>() {
            {
                AppMethodBeat.i(13801);
                this.xxI = aj.class.getName().hashCode();
                AppMethodBeat.o(13801);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(13802);
                aj ajVar = (aj) bVar;
                if (ajVar == null || !(ajVar instanceof aj)) {
                    AppMethodBeat.o(13802);
                    return false;
                }
                aj ajVar2 = ajVar;
                switch (ajVar2.cth.action) {
                    case 1:
                        Context context = ajVar2.cth.context;
                        String str = ajVar2.cth.ctj;
                        String str2 = ajVar2.cth.title;
                        int i = ajVar2.cth.fromScene;
                        long j = ajVar2.cth.ctk;
                        int i2 = ajVar2.cth.offset;
                        boolean z = ajVar2.cth.ctl;
                        if (context == null || bo.isNullOrNil(str)) {
                            ab.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", context, str);
                            AppMethodBeat.o(13802);
                            return false;
                        }
                        com.tencent.mm.kernel.g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, new com.tencent.mm.plugin.brandservice.b.b.a(context, str, j, i2, i, str2, z, ajVar2));
                        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.brandservice.b.h(str, j, i2, i, ""), 0);
                        AppMethodBeat.o(13802);
                        return true;
                    default:
                        ab.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", Integer.valueOf(ajVar2.cth.action));
                        AppMethodBeat.o(13802);
                        return false;
                }
            }
        });
        AppMethodBeat.o(13813);
    }

    private void addPlaceTopChangeListener() {
        AppMethodBeat.i(13814);
        com.tencent.mm.sdk.b.a.xxA.b(new com.tencent.mm.sdk.b.c<ai>() {
            {
                AppMethodBeat.i(13803);
                this.xxI = ai.class.getName().hashCode();
                AppMethodBeat.o(13803);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(13804);
                z.aeX().aol(((ai) bVar).ctg.userName);
                AppMethodBeat.o(13804);
                return true;
            }
        });
        AppMethodBeat.o(13814);
    }
}
