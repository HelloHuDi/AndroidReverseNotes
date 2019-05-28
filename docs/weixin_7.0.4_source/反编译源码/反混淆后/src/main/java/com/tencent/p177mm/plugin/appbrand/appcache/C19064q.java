package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.cwk;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.q */
public final class C19064q extends C4887d implements Runnable {
    private final int gSF;
    private final String gSG;
    private final C7292c gSH = new C190651();
    private final C7292c gSI = new C190672();
    final C7292c gSJ = new C190703();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$1 */
    class C190651 extends C7292c {
        C190651() {
        }

        public final void enter() {
            AppMethodBeat.m2504i(129350);
            super.enter();
            C4990ab.m7416i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
            String avT = C38104an.avT();
            if (C5046bo.isNullOrNil(avT)) {
                C19064q.m29633a(C19064q.this, "!!MockLibInfo Path Error!!");
                AppMethodBeat.m2505o(129350);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", C19064q.this.gSF);
                File file = new File(avT);
                file.delete();
                file.createNewFile();
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                int b = C1173e.m2559b(file.getAbsolutePath(), bytes, bytes.length);
                if (b != 0) {
                    C19064q.m29633a(C19064q.this, "MockLibInfo Write Error ".concat(String.valueOf(b)));
                    AppMethodBeat.m2505o(129350);
                    return;
                }
                C19064q.m29632a(C19064q.this, C19064q.this.gSI);
                AppMethodBeat.m2505o(129350);
            } catch (Exception e) {
                C19064q.m29633a(C19064q.this, "MockLibInfo Write Exception " + e.getMessage());
                AppMethodBeat.m2505o(129350);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$2 */
    class C190672 extends C7292c {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$2$1 */
        class C190681 implements C2057a {

            /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$2$1$1 */
            class C190691 implements Runnable {
                C190691() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(129351);
                    C19064q.this.mo10075b((C4886a) C19064q.this.gSJ);
                    C19064q.this.sendMessage(0);
                    AppMethodBeat.m2505o(129351);
                }
            }

            C190681() {
            }

            /* renamed from: bl */
            public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
            }

            /* renamed from: a */
            public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                AppMethodBeat.m2504i(129352);
                C4990ab.m7417i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", c10067a);
                if (c10067a != C10067a.OK) {
                    C19064q.m29633a(C19064q.this, "Download MockLibInfo Error: " + c10067a.name());
                    AppMethodBeat.m2505o(129352);
                    return;
                }
                C5004al.m7441d(new C190691());
                AppMethodBeat.m2505o(129352);
            }
        }

        C190672() {
        }

        public final void enter() {
            AppMethodBeat.m2504i(129353);
            super.enter();
            C4990ab.m7416i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
            cwk cwk = new cwk();
            cwk.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[]{Integer.valueOf(C19064q.this.gSF)});
            cwk.version = C19064q.this.gSF;
            cwk.cvZ = C19064q.this.gSG;
            cwk.wPu = 1;
            C42340f.auV().mo60845a(cwk, new PInt());
            C2055az.m4221a(cwk.url, cwk.version, new C190681());
            AppMethodBeat.m2505o(129353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$3 */
    class C190703 extends C7292c {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$3$1 */
        class C100971 implements C1202f {

            /* renamed from: com.tencent.mm.plugin.appbrand.appcache.q$3$1$1 */
            class C100981 implements C2057a {
                C100981() {
                }

                /* renamed from: bl */
                public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
                }

                /* renamed from: a */
                public final /* bridge */ /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                    AppMethodBeat.m2504i(129354);
                    if (c10067a == C10067a.OK) {
                        C19064q.m29633a(C19064q.this, "公共库增量(maybe)更新成功，重启微信确认是否生效");
                        AppMethodBeat.m2505o(129354);
                        return;
                    }
                    C19064q.m29633a(C19064q.this, "公共库增量失败");
                    AppMethodBeat.m2505o(129354);
                }
            }

            C100971() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(129355);
                if (c1207m != null && (c1207m.ftl instanceof C7472b)) {
                    cwk cwk = (cwk) ((C7472b) c1207m.ftl).fsH.fsP;
                    int a = C19064q.this.gSF;
                    int i3 = cwk.version;
                    C2055az.m4215a(C38103al.m64444t("@LibraryAppId", a, i3), new C100981());
                }
                C1720g.m3535RO().eJo.mo14546b(1168, (C1202f) this);
                AppMethodBeat.m2505o(129355);
            }
        }

        C190703() {
        }

        public final void enter() {
            AppMethodBeat.m2504i(129356);
            super.enter();
            C4990ab.m7416i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
            C10068aj.m17654dC(true);
            C1720g.m3535RO().eJo.mo14539a(1168, new C100971());
            AppMethodBeat.m2505o(129356);
        }
    }

    public C19064q(int i, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        AppMethodBeat.m2504i(129358);
        this.gSF = i;
        this.gSG = str;
        AppMethodBeat.m2505o(129358);
    }

    public final void run() {
        AppMethodBeat.m2504i(129359);
        mo10073a(this.gSH);
        mo10073a(this.gSI);
        mo10073a(this.gSJ);
        mo10076b(this.gSH);
        start();
        AppMethodBeat.m2505o(129359);
    }

    public final void avC() {
        AppMethodBeat.m2504i(129360);
        super.avC();
        C4990ab.m7416i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
        AppMethodBeat.m2505o(129360);
    }
}
