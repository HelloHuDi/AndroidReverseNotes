package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p720a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C33094d;
import com.tencent.p177mm.plugin.appbrand.appcache.C42356k;
import com.tencent.p177mm.plugin.appbrand.appcache.C42357l;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C38113c;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40431k;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.protocal.protobuf.arb;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.protocal.protobuf.bie;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a.a */
public final class C38107a implements C5681a<Boolean, C38113c> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a.a$a */
    static class C6738a implements C5681a<Boolean, C7583c<arb, arc>> {
        C6738a() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129458);
            Boolean a = m11167a((C7583c) obj);
            AppMethodBeat.m2505o(129458);
            return a;
        }

        /* renamed from: a */
        private Boolean m11167a(C7583c<arb, arc> c7583c) {
            C10100y c10100y;
            AppMethodBeat.m2504i(129457);
            arb arb = (arb) c7583c.get(0);
            arc arc = (arc) c7583c.get(1);
            if (arb.type == 0) {
                c10100y = new C10100y(arb.csB);
            } else if (arb.type == 4) {
                c10100y = new C10100y(arb.csB, arb.wsY);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("not support request.type %d", new Object[]{Integer.valueOf(arb.type)}));
                AppMethodBeat.m2505o(129457);
                throw illegalArgumentException;
            }
            final C5688b dMj = C5698f.dMj();
            dMj.dMi();
            C67391 c67391 = new C26734a<C40432m, C40431k>() {
                /* renamed from: bl */
                public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
                }

                /* renamed from: a */
                public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                    AppMethodBeat.m2504i(129456);
                    C5688b c5688b = dMj;
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(c10067a == C10067a.OK);
                    c5688b.mo11581B(objArr);
                    C4990ab.m7417i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s onPkgUpdateResult, ret %s", str, c10067a.name());
                    AppMethodBeat.m2505o(129456);
                }
            };
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", c10100y.toString(), arc.cDL, arc.url);
            C42357l c42357l = new C42357l(c10100y.toString(), arb.wuN.wLw, arb.vOP, arc.url);
            C42356k c42356k = C42356k.gSx;
            C2055az awq = C2055az.awq();
            if (awq != null) {
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", c42357l.toShortString(), Integer.valueOf(awq.gVr.mo21430b(c42357l)));
                switch (awq.gVr.mo21430b(c42357l)) {
                    case 4:
                        c67391.mo14965a(c42357l.appId, C10067a.ENV_ERR, null);
                        break;
                    default:
                        c42356k.gSy.mo44963f(c42357l.vdC, c67391);
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
            c67391.mo14965a(c42357l.appId, C10067a.ENV_ERR, null);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129457);
            return bool;
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(129459);
        C38113c c38113c = (C38113c) obj;
        String str = c38113c.field_appId;
        int i = c38113c.field_version;
        String str2 = c38113c.field_pkgMd5;
        C10100y c10100y = new C10100y(str, "");
        final boolean z = c38113c.field_retriedCount > 0;
        final int i2 = c38113c.field_reportId;
        final C5688b dMj = C5698f.dMj();
        dMj.dMi();
        arb arb = new arb();
        arb.csB = str;
        arb.vOP = i;
        arb.wtb = 0;
        arb.wuL = str2;
        if (C5046bo.isNullOrNil("")) {
            arb.wtb = 0;
        } else {
            arb.wsY = "";
            arb.wtb = 4;
        }
        arb.wuN = new bie();
        arb.wuN.wLv = 0;
        arb.wuN.wLw = 1;
        int i3 = z ? 51 : 46;
        C19050a c19050a = C19050a.gWl;
        C19050a.m29623z((long) i2, (long) i3);
        new C33094d(arb).acy().mo60494j(new C5681a<C7583c<arb, arc>, C37441a<arc>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129455);
                C37441a c37441a = (C37441a) obj;
                if (C42597a.m75415b(c37441a)) {
                    C7472b c7472b = (C7472b) c37441a.cwn.ftl;
                    Object F = C5710a.m8574F((arb) c7472b.fsG.fsP, (arc) c7472b.fsH.fsP);
                    AppMethodBeat.m2505o(129455);
                    return F;
                }
                dMj.mo11581B(Boolean.FALSE);
                C5698f.dMj().mo11582cR(Boolean.FALSE);
                int i = z ? 50 : 49;
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) i2, (long) i);
                AppMethodBeat.m2505o(129455);
                return null;
            }
        }).mo60491g(new C6738a()).mo60491g(new C5681a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129454);
                int i = ((Boolean) obj).booleanValue() ? z ? 52 : 47 : z ? 53 : 48;
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) i2, (long) i);
                dMj.mo11581B(r6);
                Void voidR = zXH;
                AppMethodBeat.m2505o(129454);
                return voidR;
            }
        });
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.m2505o(129459);
        return bool;
    }
}
