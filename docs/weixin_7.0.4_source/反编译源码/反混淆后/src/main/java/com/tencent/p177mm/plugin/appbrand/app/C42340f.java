package com.tencent.p177mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.sdk.config.C6276a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p181af.p1175a.C25745c;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18336n;
import com.tencent.p177mm.p230g.p231a.C18361p;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C26186l;
import com.tencent.p177mm.p230g.p231a.C32603o;
import com.tencent.p177mm.p230g.p231a.C45312bw;
import com.tencent.p177mm.p230g.p231a.C45374tz;
import com.tencent.p177mm.p230g.p231a.C6496jd;
import com.tencent.p177mm.p230g.p231a.C6503jz;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p230g.p231a.C6527nk;
import com.tencent.p177mm.p230g.p231a.C9357gk;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.C33215h;
import com.tencent.p177mm.plugin.appbrand.app.C19004a.C2047a;
import com.tencent.p177mm.plugin.appbrand.appcache.C10068aj;
import com.tencent.p177mm.plugin.appbrand.appcache.C19033ab;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C33076av;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C38115ba;
import com.tencent.p177mm.plugin.appbrand.appcache.C42348am;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.C19044a.C190452;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.C19044a.C190461;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C2060e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42353i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42365d;
import com.tencent.p177mm.plugin.appbrand.appusage.C19104i;
import com.tencent.p177mm.plugin.appbrand.appusage.C26769j;
import com.tencent.p177mm.plugin.appbrand.appusage.C26769j.C267702;
import com.tencent.p177mm.plugin.appbrand.appusage.C26769j.C267711;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C26774b;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s.C10130a;
import com.tencent.p177mm.plugin.appbrand.appusage.C38135v.C10131a;
import com.tencent.p177mm.plugin.appbrand.appusage.C45522w;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C26758b;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C41223g;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C26798h;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C42385b.C423861;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C42388d;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C26844q;
import com.tencent.p177mm.plugin.appbrand.config.C33134c;
import com.tencent.p177mm.plugin.appbrand.config.C33136e;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.C7488f;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2146g;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C45547b;
import com.tencent.p177mm.plugin.appbrand.game.p292b.C16611f;
import com.tencent.p177mm.plugin.appbrand.game.p292b.C2156d;
import com.tencent.p177mm.plugin.appbrand.game.p292b.C38215a;
import com.tencent.p177mm.plugin.appbrand.game.p292b.C45556b;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C45555c;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.launching.C38418a;
import com.tencent.p177mm.plugin.appbrand.launching.C38432z;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.plugin.appbrand.p1231o.C38454c;
import com.tencent.p177mm.plugin.appbrand.p1231o.C38454c.C33463a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38095c;
import com.tencent.p177mm.plugin.appbrand.p1602p.C42640a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandGuideUI.C38522a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19771b;
import com.tencent.p177mm.plugin.appbrand.p884c.C19128c;
import com.tencent.p177mm.plugin.appbrand.p884c.C26799b;
import com.tencent.p177mm.plugin.appbrand.p894f.C16610e;
import com.tencent.p177mm.plugin.appbrand.p894f.C26879g;
import com.tencent.p177mm.plugin.appbrand.p894f.C38211c;
import com.tencent.p177mm.plugin.appbrand.p894f.C45552b;
import com.tencent.p177mm.plugin.appbrand.p911q.C19676a;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.appbrand.widget.C19858i;
import com.tencent.p177mm.plugin.appbrand.widget.C33639m;
import com.tencent.p177mm.plugin.appbrand.widget.C45716f;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4824j.C4827a;
import com.tencent.p177mm.protocal.C4824j.C4829d;
import com.tencent.p177mm.protocal.C4824j.C4830e;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.xweb.C31146m;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.appbrand.app.f */
public final class C42340f implements C1816at {
    private static C26799b gRA;
    private static volatile C42362b gRj;
    private static volatile C33134c gRk;
    private static volatile C38105ax gRl;
    private static volatile C45522w gRm;
    private static volatile C26844q gRn;
    private static volatile C38432z gRo;
    private static volatile C45716f gRp;
    private static volatile C19858i gRq;
    private static volatile C1953a gRr;
    private static volatile C33639m gRs;
    private static volatile C25745c gRt;
    private static volatile C19676a gRu;
    private static volatile C19033ab gRv;
    private static volatile C45555c gRw;
    private static volatile C42348am gRx;
    private static volatile C38115ba gRy;
    private static C19128c gRz;
    private C4931a foI = new C4234331();
    private final C1923n fyJ = new C4233625();
    private C5132a gRB = new C42640a();
    private C7358b gRC = null;
    private final C19933a gRD = new C4234111();
    private final Set<C4884c> gRE = new HashSet();
    private final C4884c<C26171jl> gRF = new C4234213();
    private final C4884c<C45374tz> gRG = new C4233414();
    private final C4884c<C6503jz> gRH = new C1005615();
    private final C4884c<C6527nk> gRI = new C2672516();
    private final C4884c<C26186l> gRJ = new C1902617();
    private final C4884c<C18361p> gRK = new C3306618();
    private final C4884c<C32603o> gRL = new C3809819();
    private final C4884c<C6504k> gRM = new C2672620();
    private final C4884c<C18336n> gRN = new C1902721();
    private final C4884c<C45312bw> gRO = new C1902822();
    private final C4884c<C6496jd> gRP = new C4233524();
    private final C1837a gRQ = new C33076av();
    private C4884c gRR = new C4233726();
    private C4884c gRS = new C4233827();
    private C4884c gRT = new C1903028();
    private final C4884c<C6504k> gRU = new C3306829();
    private C4931a gRV = new C3809930();
    private final C38522a gRW = new C38522a();

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$15 */
    class C1005615 extends C4884c<C6503jz> {
        C1005615() {
            AppMethodBeat.m2504i(129256);
            this.xxI = C6503jz.class.getName().hashCode();
            AppMethodBeat.m2505o(129256);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129257);
            C7616ad c7616ad = ((C6503jz) c4883b).cFm.cFn;
            if (C7616ad.m13549mg(c7616ad.field_username)) {
                c7616ad.setType(0);
                C42406r.m75079zt(c7616ad.field_username);
            }
            AppMethodBeat.m2505o(129257);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$34 */
    class C1005734 implements C1366d {
        C1005734() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26844q.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$4 */
    class C100584 implements C1366d {
        C100584() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C19676a.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$6 */
    class C100596 implements C1366d {
        C100596() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45555c.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$7 */
    class C100607 implements C1366d {
        C100607() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26758b.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$17 */
    class C1902617 extends C4884c<C26186l> {
        C1902617() {
            AppMethodBeat.m2504i(129260);
            this.xxI = C26186l.class.getName().hashCode();
            AppMethodBeat.m2505o(129260);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129261);
            C26186l c26186l = (C26186l) c4883b;
            if (!C5046bo.isNullOrNil(c26186l.csj.csl)) {
                c26186l.csk.csm = C5046bo.getInt(C42340f.m74880xH().get(c26186l.csj.csl + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            }
            AppMethodBeat.m2505o(129261);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$21 */
    class C1902721 extends C4884c<C18336n> {
        C1902721() {
            AppMethodBeat.m2504i(129268);
            this.xxI = C18336n.class.getName().hashCode();
            AppMethodBeat.m2505o(129268);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129269);
            C18336n c18336n = (C18336n) c4883b;
            C19690c.m30499a(c18336n.csr.csl, c18336n.csr.appId, c18336n.csr.css, c18336n.csr.scene, c18336n.csr.cst, c18336n.csr.csu, c18336n.csr.action, c18336n.csr.csv, c18336n.csr.csw, c18336n.csr.csx, c18336n.csr.csy);
            AppMethodBeat.m2505o(129269);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$22 */
    class C1902822 extends C4884c<C45312bw> {
        C1902822() {
            AppMethodBeat.m2504i(129270);
            this.xxI = C45312bw.class.getName().hashCode();
            AppMethodBeat.m2505o(129270);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129271);
            C45312bw c45312bw = (C45312bw) c4883b;
            if (!C5046bo.isNullOrNil(c45312bw.cuV.username) && C1720g.m3534RN().eJb) {
                WxaAttributes d = C42340f.auO().mo21572d(c45312bw.cuV.username, "roundedSquareIconURL", "brandIconURL", "bigHeadURL", "appId", "nickname");
                if (d != null) {
                    String[] strArr = new String[]{d.field_roundedSquareIconURL, d.field_brandIconURL, d.field_bigHeadURL};
                    c45312bw.cuW.bQQ = strArr;
                    c45312bw.cuW.appId = d.field_appId;
                    c45312bw.cuW.nickname = d.field_nickname;
                }
            }
            AppMethodBeat.m2505o(129271);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$23 */
    class C1902923 implements C1366d {
        C1902923() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C33134c.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$28 */
    class C1903028 extends C4884c<C26111d> {
        C1903028() {
            AppMethodBeat.m2504i(129279);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(129279);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129280);
            if (!((C26111d) c4883b).crQ.crR) {
                ((C9687e) C1720g.m3528K(C9687e.class)).aby().exit();
            }
            AppMethodBeat.m2505o(129280);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$16 */
    class C2672516 extends C4884c<C6527nk> {
        C2672516() {
            AppMethodBeat.m2504i(129258);
            this.xxI = C6527nk.class.getName().hashCode();
            AppMethodBeat.m2505o(129258);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129259);
            C7620bi c7620bi = ((C6527nk) c4883b).cJI.csG;
            if (c7620bi != null) {
                String str = c7620bi.field_talker;
                if (C7616ad.m13549mg(str)) {
                    int i;
                    C42340f.m74880xH().mo53682bG(str + "_unreadCount", String.valueOf(C5046bo.getInt(C42340f.m74880xH().get(str + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) + 1));
                    C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str);
                    if (aoZ != null) {
                        i = aoZ.field_unReadCount;
                    } else {
                        i = 0;
                    }
                    C10276d.m17933bf(C26842p.m42740zm(str), i);
                }
            }
            AppMethodBeat.m2505o(129259);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$20 */
    class C2672620 extends C4884c<C6504k> {
        C2672620() {
            AppMethodBeat.m2504i(129266);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(129266);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129267);
            C6504k c6504k = (C6504k) c4883b;
            if (c6504k == null || c6504k.csh == null) {
                AppMethodBeat.m2505o(129267);
            } else if (c6504k.csh.csi) {
                AppMethodBeat.m2505o(129267);
            } else if (C1720g.m3534RN().eJb) {
                C10068aj.m17654dC(false);
                C45673m.aNS().mo10302aa(new C267702());
                C41930g.m74067da(Boolean.TRUE).mo60493i(new C190452(new C190461()));
                C42353i.gWd.awv();
                C42340f.m74878E(C2060e.class);
                C41223g.m71760dF(false);
                AppMethodBeat.m2505o(129267);
            } else {
                AppMethodBeat.m2505o(129267);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$33 */
    class C2672733 implements C1366d {
        C2672733() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26779s.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$35 */
    class C2672835 implements C1366d {
        C2672835() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return new String[]{C38432z.ihX};
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$36 */
    class C2672936 implements C1366d {
        C2672936() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45716f.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$5 */
    class C267305 implements C1366d {
        C267305() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C19033ab.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$18 */
    class C3306618 extends C4884c<C18361p> {
        C3306618() {
            AppMethodBeat.m2504i(129262);
            this.xxI = C18361p.class.getName().hashCode();
            AppMethodBeat.m2505o(129262);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129263);
            C18361p c18361p = (C18361p) c4883b;
            if (!C5046bo.isNullOrNil(c18361p.csz.csl)) {
                String str = c18361p.csz.csl;
                C42340f.m74880xH().mo53682bG(str + "_unreadCount", c18361p.csz.csm);
                C10276d.m17933bf(C26842p.m42740zm(str), c18361p.csz.csm);
            }
            AppMethodBeat.m2505o(129263);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$1 */
    class C330671 implements C1366d {
        C330671() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C42362b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$29 */
    class C3306829 extends C4884c<C6504k> {
        C3306829() {
            AppMethodBeat.m2504i(129281);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(129281);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129282);
            C6504k c6504k = (C6504k) c4883b;
            if (c6504k != null && c6504k.csh.csi) {
                if (C5023at.isWifi(C4996ah.getContext())) {
                    C7305d.m12298f(new C423861(), String.format(Locale.US, "AppBrandPeroidBackgroundFetchData[%s]", new Object[]{Long.valueOf(C5046bo.anU())}));
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "peroidFetchDataWhenAppEnterForground, not wifi network");
                }
            }
            AppMethodBeat.m2505o(129282);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$2 */
    class C330692 implements C1366d {
        C330692() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C33639m.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$3 */
    class C330703 implements C1366d {
        C330703() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C25745c.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$10 */
    class C3809610 extends C28106a {
        C3809610() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(129250);
            C38215a c38215a = new C38215a();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerIndexStorage(c38215a);
            c38215a.create();
            C45556b c45556b = new C45556b();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerNativeLogic(10, c45556b);
            c45556b.create();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C16611f());
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C2156d());
            AppMethodBeat.m2505o(129250);
            return true;
        }

        public final String getName() {
            return "InitFTSMiniGamePluginTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$12 */
    class C3809712 implements C1366d {
        C3809712() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C38105ax.gVi;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$19 */
    class C3809819 extends C4884c<C32603o> {
        C3809819() {
            AppMethodBeat.m2504i(129264);
            this.xxI = C32603o.class.getName().hashCode();
            AppMethodBeat.m2505o(129264);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129265);
            boolean hY = C42340f.m74880xH().gTC.mo10108hY("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
            C4990ab.m7417i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(hY));
            AppMethodBeat.m2505o(129265);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$30 */
    class C3809930 implements C4931a {
        C3809930() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(129283);
            if (c4935m != null && !C5046bo.isNullOrNil(c4935m.ctq) && c4935m.ctq.equalsIgnoreCase("single") && c4935m.hsh == 5 && c4935m.obj != null && (c4935m.obj instanceof C10130a)) {
                String str2 = ((C10130a) c4935m.obj).field_username;
                int i = ((C10130a) c4935m.obj).field_versionType;
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7420w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "handleStarAppChangeEvent, username is null");
                    AppMethodBeat.m2505o(129283);
                    return;
                }
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "handleRemoveStarAppEvent, delete star app(%s_v%d)", str2, Integer.valueOf(i));
                ((C26798h) C1720g.m3528K(C26798h.class)).mo21502ao(str2, 0);
                ((C26798h) C1720g.m3528K(C26798h.class)).mo21502ao(str2, 1);
            }
            AppMethodBeat.m2505o(129283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$32 */
    class C3810032 implements C1366d {
        C3810032() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45522w.fjY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$9 */
    class C381029 extends C28106a {
        C381029() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(129249);
            C38211c c38211c = new C38211c();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerIndexStorage(c38211c);
            c38211c.create();
            C45552b c45552b = new C45552b();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerNativeLogic(7, c45552b);
            c45552b.create();
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C26879g());
            ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C16610e());
            AppMethodBeat.m2505o(129249);
            return true;
        }

        public final String getName() {
            return "InitFTSWeAppPluginTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$14 */
    class C4233414 extends C4884c<C45374tz> {
        C4233414() {
            AppMethodBeat.m2504i(129254);
            this.xxI = C45374tz.class.getName().hashCode();
            AppMethodBeat.m2505o(129254);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = true;
            AppMethodBeat.m2504i(129255);
            C45374tz c45374tz = (C45374tz) c4883b;
            if (C5046bo.isNullOrNil(c45374tz.cQf.csl)) {
                AppMethodBeat.m2505o(129255);
            } else {
                C26842p.ayH();
                String str = c45374tz.cQf.csl;
                int i = c45374tz.cQf.cQh;
                if (c45374tz.cQf.action != 1) {
                    z = false;
                }
                c45374tz.cQg.cQi = C26842p.m42734k(str, i, z);
                AppMethodBeat.m2505o(129255);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$24 */
    class C4233524 extends C4884c<C6496jd> {
        C4233524() {
            AppMethodBeat.m2504i(129272);
            this.xxI = C6496jd.class.getName().hashCode();
            AppMethodBeat.m2505o(129272);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129273);
            C19771b.m30600M(((C6496jd) c4883b).cEo.cEp);
            AppMethodBeat.m2505o(129273);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$25 */
    class C4233625 extends C1924a {
        C4233625() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(129274);
            C45694h.onNetworkChange();
            C42353i.gWd.awv();
            AppMethodBeat.m2505o(129274);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$26 */
    class C4233726 extends C4884c<C26111d> {
        C4233726() {
            super(0);
            AppMethodBeat.m2504i(129275);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(129275);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129276);
            C26111d c26111d = (C26111d) c4883b;
            if (c26111d == null || c26111d.crQ == null) {
                AppMethodBeat.m2505o(129276);
            } else if (c26111d.crQ.crR) {
                C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "SubCoreAppBrand trigger ActivateEvent. tryPreloadNextTaskProcess (both waservice and wagame)");
                C45694h.m84420b(C38519g.WASERVICE);
                C45694h.m84420b(C38519g.WAGAME);
                AppMethodBeat.m2505o(129276);
            } else {
                AppMethodBeat.m2505o(129276);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$27 */
    class C4233827 extends C4884c<C9357gk> {
        C4233827() {
            super(0);
            AppMethodBeat.m2504i(129277);
            this.xxI = C9357gk.class.getName().hashCode();
            AppMethodBeat.m2505o(129277);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129278);
            C9357gk c9357gk = (C9357gk) c4883b;
            C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            c9357gk.cBa.appId = C19601a.ikU.ikS;
            c9357gk.cBa.cBb = C19601a.ikU.cBb;
            c9357gk.cBa.cwz = C19601a.ikU.cwz;
            c9357gk.cBa.cBc = C19601a.ikU.cBc;
            AppMethodBeat.m2505o(129278);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$37 */
    class C4233937 implements C1366d {
        C4233937() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return new String[]{C19858i.ihX};
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$11 */
    class C4234111 implements C19933a {
        C4234111() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            boolean z2;
            boolean z3 = false;
            AppMethodBeat.m2504i(129251);
            if (c4826g != null && (c4826g instanceof C4830e)) {
                C45673m.aNS().mo10302aa(new C267711());
                C10068aj.m17654dC(true);
            }
            if (z && (c4825f instanceof C4827a) && c4825f.vyf == 12) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                C10068aj.m17654dC(true);
            }
            if (((c4825f instanceof C4829d) && c4825f.vyf == 1) || ((c4825f instanceof C4827a) && c4825f.vyf == 12)) {
                z3 = true;
            }
            if (z3) {
                C41223g.m71760dF(true);
            }
            AppMethodBeat.m2505o(129251);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$13 */
    class C4234213 extends C4884c<C26171jl> {
        C4234213() {
            AppMethodBeat.m2504i(129252);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(129252);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129253);
            switch (((C26171jl) c4883b).cEK.boZ) {
                case 1:
                case 3:
                    C45694h.m84430pN(1);
                    break;
                default:
                    C45694h.m84430pN(0);
                    break;
            }
            C45547b.aAe();
            AppMethodBeat.m2505o(129253);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.f$31 */
    class C4234331 implements C4931a {
        C4234331() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(129284);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                C42340f.avf();
                C42340f.avg();
                C42340f.avh();
                C42340f.avi();
                C42340f.avj();
            }
            AppMethodBeat.m2505o(129284);
        }
    }

    private HashMap<Integer, C1366d> auJ() {
        AppMethodBeat.m2504i(129285);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new C330671());
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new C3809712());
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new C1902923());
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new C3810032());
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new C2672733());
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new C1005734());
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new C2672835());
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new C2672936());
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new C4233937());
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new C330692());
        hashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new C330703());
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new C100584());
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new C267305());
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new C100596());
        hashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new C100607());
        for (Entry entry : C19004a.gQL.entrySet()) {
            final String[] strArr = (String[]) entry.getValue();
            hashMap.put(Integer.valueOf(((C2047a) entry.getKey()).hashCode()), new C1366d() {
                /* renamed from: Af */
                public final String[] mo4750Af() {
                    return strArr;
                }
            });
        }
        AppMethodBeat.m2505o(129285);
        return hashMap;
    }

    public static C1953a auK() {
        return gRr;
    }

    public static C42340f auL() {
        C42340f core;
        AppMethodBeat.m2504i(129286);
        C38095c c38095c = (C38095c) C1720g.m3530M(C38095c.class);
        if (c38095c != null) {
            core = ((PluginAppBrand) c38095c).getCore();
        } else {
            core = null;
        }
        AppMethodBeat.m2505o(129286);
        return core;
    }

    public final C1953a auM() {
        AppMethodBeat.m2504i(129287);
        String str = C1720g.m3536RP().cachePath + "AppBrandComm.db";
        C1953a a;
        if (gRr == null || !str.equals(gRr.getPath())) {
            a = C1952t.m4171a(hashCode(), str, auJ(), true);
            gRr = a;
            AppMethodBeat.m2505o(129287);
            return a;
        }
        a = gRr;
        AppMethodBeat.m2505o(129287);
        return a;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(129288);
        C4990ab.m7411d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", Boolean.valueOf(z));
        this.gRC = ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(this.gRD);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                if (stringSet.add(stringBuilder.append(C1668a.m3383QF()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (C4884c dnU : this.gRE) {
            dnU.dnU();
        }
        for (String a : C33076av.gUU.keySet()) {
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a(a, this.gRQ, true);
        }
        C26774b.axy();
        C10131a.axy();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15805c(this.gRB);
        auM();
        gRj = new C42362b(gRr);
        gRk = new C33134c(gRr);
        gRl = new C38105ax(gRr);
        gRm = new C45522w(gRr);
        gRo = new C38432z(gRr);
        gRp = new C45716f(gRr);
        gRq = new C19858i(gRr);
        gRs = new C33639m(gRr);
        gRt = new C25745c(gRr);
        gRu = new C19676a(gRr);
        gRv = new C19033ab(gRr);
        gRw = new C45555c(gRr);
        gRx = new C42348am();
        gRy = new C38115ba();
        C42340f.auO();
        C19004a.m29580a(gRr);
        C33215h.setup();
        C26842p.ayH();
        C33463a.iDD.prepare();
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(-86016, new C381029());
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(-86016, new C3809610());
        C1720g.m3535RO().mo5187a(this.fyJ);
        C2146g.initialize();
        C18624c.abi().mo10116c(this.foI);
        if (C42340f.auU() != null) {
            C42340f.auU().mo10116c(this.gRV);
        }
        C7488f.init();
        C38522a c38522a = this.gRW;
        C38522a.aMe().registerActivityLifecycleCallbacks(c38522a);
        C19771b.m30603d(c38522a);
        c38522a.iGD = false;
        AppMethodBeat.m2505o(129288);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(129289);
        C4990ab.m7410d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.gRC != null) {
            this.gRC.dead();
            this.gRC = null;
        }
        for (C4884c dead : this.gRE) {
            dead.dead();
        }
        C33215h.release();
        for (String b : C33076av.gUU.keySet()) {
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b(b, this.gRQ, true);
        }
        C26774b.unregister();
        C10131a.unregister();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15808d(this.gRB);
        C2055az.shutdown();
        gRj = null;
        gRn = null;
        gRk = null;
        gRl = null;
        gRm = null;
        gRo = null;
        gRp = null;
        gRq = null;
        gRs = null;
        gRt = null;
        gRu = null;
        gRv = null;
        gRw = null;
        gRx = null;
        gRy = null;
        C19004a.auD();
        if (gRA != null) {
            C26799b c26799b = gRA;
            c26799b.heu.clear();
            c26799b.hev.clear();
            gRA = null;
        }
        gRz = null;
        if (gRr != null) {
            gRr.mo5709mJ(hashCode());
            gRr = null;
        }
        C26769j.release();
        C26842p.release();
        C42353i.gWd.cleanup();
        C38454c c38454c = C33463a.iDD;
        C4990ab.m7410d("MicroMsg.WxaFTSSearchCore", "reset");
        C4879a.xxA.mo10053d(c38454c.iDz);
        C4879a.xxA.mo10053d(c38454c.iDA);
        c38454c.iDB.dead();
        C42677e.aNR();
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterIndexStorage(512);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterNativeLogic(7);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(144);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4224);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterIndexStorage(8);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterNativeLogic(10);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(208);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4240);
        C1720g.m3535RO().mo5188b(this.fyJ);
        C2146g.release();
        C18624c.abi().mo10117d(this.foI);
        C6276a.release();
        C38522a c38522a = this.gRW;
        C38522a.aMe().unregisterActivityLifecycleCallbacks(c38522a);
        C19771b.m30602c(c38522a);
        c38522a.iGD = false;
        AppMethodBeat.m2505o(129289);
    }

    public C42340f() {
        AppMethodBeat.m2504i(129290);
        this.gRE.add(this.gRM);
        this.gRE.add(new C38418a());
        this.gRE.add(this.gRN);
        this.gRE.add(this.gRH);
        this.gRE.add(this.gRI);
        this.gRE.add(this.gRG);
        this.gRE.add(new C33136e());
        this.gRE.add(this.gRF);
        this.gRE.add(C19104i.gZa);
        this.gRE.add(this.gRJ);
        this.gRE.add(this.gRK);
        this.gRE.add(this.gRL);
        this.gRE.add(this.gRR);
        this.gRE.add(this.gRO);
        this.gRE.add(this.gRP);
        this.gRE.add(this.gRS);
        this.gRE.add(this.gRT);
        this.gRE.add(this.gRU);
        AppMethodBeat.m2505o(129290);
    }

    public static C38522a auN() {
        AppMethodBeat.m2504i(129291);
        if (C42340f.auL() == null) {
            AppMethodBeat.m2505o(129291);
            return null;
        }
        C38522a c38522a = C42340f.auL().gRW;
        AppMethodBeat.m2505o(129291);
        return c38522a;
    }

    /* renamed from: xG */
    public static C42362b m74879xG() {
        return gRj;
    }

    public static C26844q auO() {
        AppMethodBeat.m2504i(129292);
        synchronized (C42340f.class) {
            try {
                if (!((gRn != null && gRn.ayG()) || gRr == null || gRr.dpU())) {
                    gRn = new C26844q(gRr);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129292);
            }
        }
        C26844q c26844q = gRn;
        return c26844q;
    }

    public static C38432z auP() {
        return gRo;
    }

    public static C19858i auQ() {
        return gRq;
    }

    public static C33639m auR() {
        return gRs;
    }

    public static C25745c auS() {
        return gRt;
    }

    /* renamed from: xH */
    public static C33134c m74880xH() {
        AppMethodBeat.m2504i(129293);
        if (!(gRk != null || gRr == null || gRr.dpU())) {
            gRk = new C33134c(gRr);
        }
        C33134c c33134c = gRk;
        AppMethodBeat.m2505o(129293);
        return c33134c;
    }

    public static C45522w auT() {
        return gRm;
    }

    @Deprecated
    public static C26779s auU() {
        AppMethodBeat.m2504i(129294);
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        AppMethodBeat.m2505o(129294);
        return c26779s;
    }

    public static C38105ax auV() {
        return gRl;
    }

    public static C45716f auW() {
        return gRp;
    }

    public static C19128c auX() {
        AppMethodBeat.m2504i(129295);
        if (gRz == null) {
            gRz = new C19128c();
        }
        C19128c c19128c = gRz;
        AppMethodBeat.m2505o(129295);
        return c19128c;
    }

    public static C26799b auY() {
        AppMethodBeat.m2504i(129296);
        if (gRA == null) {
            gRA = new C26799b();
        }
        C26799b c26799b = gRA;
        AppMethodBeat.m2505o(129296);
        return c26799b;
    }

    public static C19676a auZ() {
        return gRu;
    }

    public static C19033ab ava() {
        return gRv;
    }

    public static C45555c avb() {
        return gRw;
    }

    /* renamed from: E */
    public static <T> T m74878E(Class<T> cls) {
        AppMethodBeat.m2504i(129297);
        if (cls == C45522w.class) {
            C45522w c45522w = gRm;
            AppMethodBeat.m2505o(129297);
            return c45522w;
        }
        T E = C19004a.m29578E(cls);
        AppMethodBeat.m2505o(129297);
        return E;
    }

    public static C42348am avc() {
        return gRx;
    }

    public static C38115ba avd() {
        return gRy;
    }

    public static C42388d ave() {
        AppMethodBeat.m2504i(129298);
        C42388d c42388d = (C42388d) C42340f.m74878E(C42388d.class);
        AppMethodBeat.m2505o(129298);
        return c42388d;
    }

    static /* synthetic */ void avf() {
        int i;
        AppMethodBeat.m2504i(129299);
        C5141c ll = C18624c.abi().mo17131ll("100249");
        if (ll.isValid()) {
            i = C5046bo.getInt((String) ll.dru().get("appbrand_player"), -1);
        } else {
            i = -1;
        }
        C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putInt("appbrand_video_player", i).commit();
        C4990ab.m7417i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", Integer.valueOf(i));
        AppMethodBeat.m2505o(129299);
    }

    static /* synthetic */ void avg() {
        AppMethodBeat.m2504i(129300);
        try {
            C31146m.m50231jy(C4996ah.getContext());
            C5141c ll = C18624c.abi().mo17131ll("100367");
            if (ll.isValid()) {
                C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
                Map dru = ll.dru();
                if (C5046bo.getInt((String) dru.get("WebCoreTestFlag"), 0) == 1) {
                    C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                    int i = C5046bo.getInt((String) dru.get("ModuleToolsType"), 2);
                    int i2 = C5046bo.getInt((String) dru.get("ModuleAppbrandType"), 2);
                    int i3 = C5046bo.getInt((String) dru.get("ModuleSupportType"), 2);
                    C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i + ";moduleAppbrandType:" + i2 + ";moduleSupportType" + i3 + ":jsRuntimeType" + C5046bo.getInt((String) dru.get("JsRuntimeType"), 0));
                    Editor edit = C4996ah.getContext().getSharedPreferences("wcwebview", C1448h.m3078Mu()).edit();
                    edit.putString("ABTestWebViewtools", C44570d.values()[i].toString());
                    edit.putString("ABTestWebViewtoolsmp", C44570d.values()[i].toString());
                    edit.putString("ABTestWebViewmm", C44570d.values()[i].toString());
                    edit.putString("ABTestWebViewappbrand", C44570d.values()[i2].toString());
                    edit.putString("ABTestWebViewsupport", C44570d.values()[i3].toString());
                    edit.commit();
                    if (i == 1 || i2 == 1 || i3 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
            AppMethodBeat.m2505o(129300);
        } catch (Exception e) {
            AppMethodBeat.m2505o(129300);
        }
    }

    static /* synthetic */ void avh() {
        AppMethodBeat.m2504i(129301);
        C5141c ll = C18624c.abi().mo17131ll("100371");
        C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (ll.isValid()) {
            C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i = C5046bo.getInt((String) ll.dru().get("bEnableLocalDebug"), 0);
            Editor edit = C4996ah.getContext().getSharedPreferences("wcwebview", C1448h.m3078Mu()).edit();
            if (i == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
                AppMethodBeat.m2505o(129301);
                return;
            }
            edit.putBoolean("m_bEnableLocalDebug", false).commit();
        }
        AppMethodBeat.m2505o(129301);
    }

    static /* synthetic */ void avi() {
        AppMethodBeat.m2504i(129302);
        try {
            C31146m.m50231jy(C4996ah.getContext());
            C5141c ll = C18624c.abi().mo17131ll("100449");
            if (ll.isValid()) {
                C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "abtest of xweb command received");
                Map dru = ll.dru();
                if (C5046bo.getInt((String) dru.get("WebCoreTestFlag"), 0) == 1) {
                    C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "WebCoreTestFlag is on");
                    String str = (String) dru.get("XWebConfigName");
                    if (str != null && str.trim().length() > 1) {
                        str = str.trim();
                        C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "abtest xweb config url  is ".concat(String.valueOf(str)));
                        C45287c.m83506iw(C4996ah.getContext());
                        XWalkEnvironment.setTestDownLoadUrl(C4996ah.getContext(), str);
                        C44572a.m80956a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                        edit.putLong("nLastFetchConfigTime", 0);
                        edit.putBoolean("bCanUseCellular", true);
                        edit.putLong("nTimeToUpdate", 100);
                        edit.commit();
                        C4996ah.getContext();
                        C30086a.m47649Kv(5);
                    }
                    str = (String) dru.get("XWebCommand");
                    if (str != null && str.length() > 15) {
                        try {
                            new WebView(C4996ah.getContext()).loadUrl(str);
                            C4990ab.m7416i("MicroMsg.SubCoreAppBrand", "excute xwebcmd finished");
                            AppMethodBeat.m2505o(129302);
                            return;
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.SubCoreAppBrand", "excute xwebcmd failed : " + e.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(129302);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(129302);
        }
    }

    static /* synthetic */ void avj() {
        AppMethodBeat.m2504i(129303);
        C42365d.gXk.mo67882sg();
        AppMethodBeat.m2505o(129303);
    }
}
