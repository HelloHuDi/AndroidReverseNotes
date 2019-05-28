package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.az.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

public final class q extends d implements Runnable {
    private final int gSF;
    private final String gSG;
    private final c gSH = new c() {
        public final void enter() {
            AppMethodBeat.i(129350);
            super.enter();
            ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
            String avT = an.avT();
            if (bo.isNullOrNil(avT)) {
                q.a(q.this, "!!MockLibInfo Path Error!!");
                AppMethodBeat.o(129350);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", q.this.gSF);
                File file = new File(avT);
                file.delete();
                file.createNewFile();
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                int b = e.b(file.getAbsolutePath(), bytes, bytes.length);
                if (b != 0) {
                    q.a(q.this, "MockLibInfo Write Error ".concat(String.valueOf(b)));
                    AppMethodBeat.o(129350);
                    return;
                }
                q.a(q.this, q.this.gSI);
                AppMethodBeat.o(129350);
            } catch (Exception e) {
                q.a(q.this, "MockLibInfo Write Exception " + e.getMessage());
                AppMethodBeat.o(129350);
            }
        }
    };
    private final c gSI = new c() {
        public final void enter() {
            AppMethodBeat.i(129353);
            super.enter();
            ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
            cwk cwk = new cwk();
            cwk.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[]{Integer.valueOf(q.this.gSF)});
            cwk.version = q.this.gSF;
            cwk.cvZ = q.this.gSG;
            cwk.wPu = 1;
            f.auV().a(cwk, new PInt());
            az.a(cwk.url, cwk.version, new a() {
                public final /* bridge */ /* synthetic */ void bl(Object obj) {
                }

                public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                    AppMethodBeat.i(129352);
                    ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", aVar);
                    if (aVar != b.a.a.OK) {
                        q.a(q.this, "Download MockLibInfo Error: " + aVar.name());
                        AppMethodBeat.o(129352);
                        return;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(129351);
                            q.this.b((com.tencent.mm.sdk.d.a) q.this.gSJ);
                            q.this.sendMessage(0);
                            AppMethodBeat.o(129351);
                        }
                    });
                    AppMethodBeat.o(129352);
                }
            });
            AppMethodBeat.o(129353);
        }
    };
    final c gSJ = new c() {
        public final void enter() {
            AppMethodBeat.i(129356);
            super.enter();
            ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
            aj.dC(true);
            g.RO().eJo.a(1168, new com.tencent.mm.ai.f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(129355);
                    if (mVar != null && (mVar.ftl instanceof com.tencent.mm.ai.b)) {
                        cwk cwk = (cwk) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                        int a = q.this.gSF;
                        int i3 = cwk.version;
                        az.a(al.t("@LibraryAppId", a, i3), new a() {
                            public final /* bridge */ /* synthetic */ void bl(Object obj) {
                            }

                            public final /* bridge */ /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                                AppMethodBeat.i(129354);
                                if (aVar == b.a.a.OK) {
                                    q.a(q.this, "公共库增量(maybe)更新成功，重启微信确认是否生效");
                                    AppMethodBeat.o(129354);
                                    return;
                                }
                                q.a(q.this, "公共库增量失败");
                                AppMethodBeat.o(129354);
                            }
                        });
                    }
                    g.RO().eJo.b(1168, (com.tencent.mm.ai.f) this);
                    AppMethodBeat.o(129355);
                }
            });
            AppMethodBeat.o(129356);
        }
    };

    public q(int i, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        AppMethodBeat.i(129358);
        this.gSF = i;
        this.gSG = str;
        AppMethodBeat.o(129358);
    }

    public final void run() {
        AppMethodBeat.i(129359);
        a(this.gSH);
        a(this.gSI);
        a(this.gSJ);
        b(this.gSH);
        start();
        AppMethodBeat.o(129359);
    }

    public final void avC() {
        AppMethodBeat.i(129360);
        super.avC();
        ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
        AppMethodBeat.o(129360);
    }
}
