package com.tencent.p177mm.plugin.brandservice;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C45309aj;
import com.tencent.p177mm.p230g.p231a.C9293ai;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.brandservice.C38680a.C38681a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p1241a.C27510c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C33733c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g;
import com.tencent.p177mm.plugin.brandservice.p926b.C20027h;
import com.tencent.p177mm.plugin.brandservice.p926b.C42790b.C42791a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40634c;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.brandservice.PluginBrandService */
public class PluginBrandService extends C7597f implements C1671c, C27510c {
    private C3457a jKo = new C200203();
    private C40634c jKp = new C200214();

    /* renamed from: com.tencent.mm.plugin.brandservice.PluginBrandService$3 */
    class C200203 implements C3457a {
        C200203() {
        }

        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, C3460c c3460c) {
            int i = 0;
            AppMethodBeat.m2504i(13805);
            int i2;
            if (c6977h == null || c3460c == null) {
                AppMethodBeat.m2505o(13805);
            } else if (("insert".equals(c3460c.oqJ) || "update".equals(c3460c.oqJ)) && c3460c.oqK != null) {
                while (true) {
                    i2 = i;
                    if (i2 < c3460c.oqK.size()) {
                        C7620bi c7620bi = (C7620bi) c3460c.oqK.get(i2);
                        if (c7620bi.field_isSend != 1) {
                            C30309s.m48270an(c7620bi);
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(13805);
                        return;
                    }
                }
            } else {
                if ("delete".equals(c3460c.oqJ) && c3460c.oqK != null) {
                    while (true) {
                        i2 = i;
                        if (i2 >= c3460c.oqK.size()) {
                            break;
                        }
                        C30309s.m48271ao((C7620bi) c3460c.oqK.get(i2));
                        i = i2 + 1;
                    }
                }
                AppMethodBeat.m2505o(13805);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.PluginBrandService$4 */
    class C200214 implements C40634c {
        C200214() {
        }

        /* renamed from: a */
        public final void mo22929a(Object obj, C40633a c40633a) {
            AppMethodBeat.m2504i(13806);
            C30309s.drP();
            AppMethodBeat.m2505o(13806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.PluginBrandService$2 */
    class C386782 extends C4884c<C9293ai> {
        C386782() {
            AppMethodBeat.m2504i(13803);
            this.xxI = C9293ai.class.getName().hashCode();
            AppMethodBeat.m2505o(13803);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(13804);
            C41747z.aeX().aol(((C9293ai) c4883b).ctg.userName);
            AppMethodBeat.m2505o(13804);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.PluginBrandService$1 */
    class C386791 extends C4884c<C45309aj> {
        C386791() {
            AppMethodBeat.m2504i(13801);
            this.xxI = C45309aj.class.getName().hashCode();
            AppMethodBeat.m2505o(13801);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(13802);
            C45309aj c45309aj = (C45309aj) c4883b;
            if (c45309aj == null || !(c45309aj instanceof C45309aj)) {
                AppMethodBeat.m2505o(13802);
                return false;
            }
            C45309aj c45309aj2 = c45309aj;
            switch (c45309aj2.cth.action) {
                case 1:
                    Context context = c45309aj2.cth.context;
                    String str = c45309aj2.cth.ctj;
                    String str2 = c45309aj2.cth.title;
                    int i = c45309aj2.cth.fromScene;
                    long j = c45309aj2.cth.ctk;
                    int i2 = c45309aj2.cth.offset;
                    boolean z = c45309aj2.cth.ctl;
                    if (context == null || C5046bo.isNullOrNil(str)) {
                        C4990ab.m7413e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", context, str);
                        AppMethodBeat.m2505o(13802);
                        return false;
                    }
                    C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, new C42791a(context, str, j, i2, i, str2, z, c45309aj2));
                    C1720g.m3540Rg().mo14541a(new C20027h(str, j, i2, i, ""), 0);
                    AppMethodBeat.m2505o(13802);
                    return true;
                default:
                    C4990ab.m7411d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", Integer.valueOf(c45309aj2.cth.action));
                    AppMethodBeat.m2505o(13802);
                    return false;
            }
        }
    }

    public PluginBrandService() {
        AppMethodBeat.m2504i(13807);
        AppMethodBeat.m2505o(13807);
    }

    public void installed() {
        AppMethodBeat.m2504i(13808);
        alias(C27510c.class);
        AppMethodBeat.m2505o(13808);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(13809);
        addBrandServiceEvent();
        addPlaceTopChangeListener();
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C6808d.class));
        }
        AppMethodBeat.m2505o(13809);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(13810);
        C9204c.aks("brandservice");
        if (c1681g.mo5181SG() || c1681g.mo5183lQ(":tools") || c1681g.mo5183lQ(":toolsmp")) {
            C1720g.m3542a(C20023b.class, new C2681c());
        }
        C33739g.axy();
        C38681a c38681a = C38680a.jKf;
        C44042b.m79163a(new C38680a(), C38680a.jKe);
        AppMethodBeat.m2505o(13810);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(13811);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15287a(this.jKo, Looper.getMainLooper());
        C41747z.aeX().mo64101a(this.jKp, Looper.getMainLooper());
        C41747z.aeY().mo39191a(this.jKp, Looper.getMainLooper());
        if (C30309s.aVO()) {
            C33733c c33733c = new C33733c();
            C4990ab.m7416i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue();
            if ((intValue & 1) == 0) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb("officialaccounts");
                C41747z.aeX().drK();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 1));
            }
        }
        AppMethodBeat.m2505o(13811);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(13812);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15286a(this.jKo);
        C41747z.aeX().mo64100a(this.jKp);
        C41747z.aeY().mo39190a(this.jKp);
        AppMethodBeat.m2505o(13812);
    }

    private void addBrandServiceEvent() {
        AppMethodBeat.m2504i(13813);
        C4879a.xxA.mo10052c(new C386791());
        AppMethodBeat.m2505o(13813);
    }

    private void addPlaceTopChangeListener() {
        AppMethodBeat.m2504i(13814);
        C4879a.xxA.mo10051b(new C386782());
        AppMethodBeat.m2505o(13814);
    }
}
