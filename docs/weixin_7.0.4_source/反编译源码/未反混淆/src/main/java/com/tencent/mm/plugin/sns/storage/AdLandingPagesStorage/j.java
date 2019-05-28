package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j {
    private static j rev = new j();
    ConcurrentLinkedQueue<String> reu = new ConcurrentLinkedQueue();

    static {
        AppMethodBeat.i(37781);
        AppMethodBeat.o(37781);
    }

    public static j cql() {
        return rev;
    }

    private j() {
        AppMethodBeat.i(37775);
        AppMethodBeat.o(37775);
    }

    private boolean YP(String str) {
        AppMethodBeat.i(37776);
        boolean contains = this.reu.contains(str);
        AppMethodBeat.o(37776);
        return contains;
    }

    private void a(String str, r rVar) {
        AppMethodBeat.i(37777);
        final n nVar;
        if (i.Dz(rVar.type)) {
            ArrayList<r> arrayList = new ArrayList();
            if (i.DA(rVar.type)) {
                arrayList.addAll(((x) rVar).cpf());
            } else if (i.DD(rVar.type)) {
                arrayList.addAll(((p) rVar).bnR);
            } else if (i.DB(rVar.type)) {
                arrayList.addAll(((s) rVar).cpf());
            } else if (i.DC(rVar.type)) {
                arrayList.addAll(((q) rVar).cpf());
            }
            for (r a : arrayList) {
                a(str, a);
            }
            AppMethodBeat.o(37777);
        } else if (rVar.qWP == 41) {
            nVar = (n) rVar;
            if (YP(nVar.qWD)) {
                AppMethodBeat.o(37777);
                return;
            }
            this.reu.add(nVar.qWD);
            h.c(str, nVar.qWD, true, rVar.qWP, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37759);
                    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + nVar.qWD + "is error");
                    j.a(j.this, nVar.qWD);
                    AppMethodBeat.o(37759);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37760);
                    j.a(j.this, nVar.qWD);
                    AppMethodBeat.o(37760);
                }
            });
            AppMethodBeat.o(37777);
        } else if (rVar.qWP == 44) {
            final m mVar = (m) rVar;
            if (YP(mVar.qWD)) {
                AppMethodBeat.o(37777);
                return;
            }
            this.reu.add(mVar.qWD);
            h.c(str, mVar.qWD, true, rVar.qWP, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37761);
                    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + mVar.qWD + "is error");
                    j.a(j.this, mVar.qWD);
                    AppMethodBeat.o(37761);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37762);
                    j.a(j.this, mVar.qWD);
                    AppMethodBeat.o(37762);
                }
            });
            AppMethodBeat.o(37777);
        } else if (rVar.qWP == 45) {
            nVar = (n) rVar;
            if (YP(nVar.qWD)) {
                AppMethodBeat.o(37777);
                return;
            }
            this.reu.add(nVar.qWD);
            h.c(str, nVar.qWD, true, rVar.qWP, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37763);
                    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + nVar.qWD + "is error");
                    j.a(j.this, nVar.qWD);
                    AppMethodBeat.o(37763);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37764);
                    j.a(j.this, nVar.qWD);
                    AppMethodBeat.o(37764);
                }
            });
            AppMethodBeat.o(37777);
        } else if (rVar.qWP == 61) {
            final o oVar = (o) rVar;
            if (!YP(oVar.qWF)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.afC();
                if (c.a(pInt, pInt2)) {
                    this.reu.add(oVar.qWF);
                    h.d(str, oVar.qWF, true, 61, new a() {
                        public final void cpu() {
                        }

                        public final void cmD() {
                            AppMethodBeat.i(37765);
                            ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + oVar.qWF + "is error");
                            j.a(j.this, oVar.qWF);
                            AppMethodBeat.o(37765);
                        }

                        public final void YJ(String str) {
                            AppMethodBeat.i(37766);
                            j.a(j.this, oVar.qWF);
                            AppMethodBeat.o(37766);
                        }
                    });
                }
            }
            if (!YP(oVar.qWG)) {
                this.reu.add(oVar.qWG);
                h.c(str, oVar.qWG, true, 1000000001, new a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                        AppMethodBeat.i(37767);
                        ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + oVar.qWG + "is error");
                        j.a(j.this, oVar.qWG);
                        AppMethodBeat.o(37767);
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37768);
                        j.a(j.this, oVar.qWG);
                        AppMethodBeat.o(37768);
                    }
                });
            }
            AppMethodBeat.o(37777);
        } else {
            if (rVar.qWP == 62) {
                boolean z = g.Nu().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
                ab.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(z)));
                final z zVar = (z) rVar;
                if (z && !YP(zVar.qWH)) {
                    this.reu.add(zVar.qWH);
                    String str2 = zVar.qWH;
                    int i = rVar.qWP;
                    AnonymousClass6 anonymousClass6 = new c.a() {
                        public final void de(String str, int i) {
                        }

                        public final void BD(String str) {
                            AppMethodBeat.i(37769);
                            ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + zVar.qWH + "is error");
                            j.a(j.this, zVar.qWH);
                            AppMethodBeat.o(37769);
                        }

                        public final void lW(String str) {
                            AppMethodBeat.i(37770);
                            j.a(j.this, zVar.qWH);
                            AppMethodBeat.o(37770);
                        }
                    };
                    if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
                        anonymousClass6.BD("the res or adId is null");
                    } else {
                        ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
                        String cqi = h.cqi();
                        String str3 = str + "_stream_" + ag.ck(str2);
                        String str4 = cqi + str3;
                        if (bo.isNullOrNil(str4)) {
                            al.d(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass6(anonymousClass6));
                        } else if (e.ct(str4)) {
                            ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", str4);
                            al.d(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass4(anonymousClass6, str4));
                        } else {
                            new c(cqi, str3, i, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass5(anonymousClass6, str2)).execute(new Void[0]);
                        }
                    }
                }
                if (!YP(zVar.qXv)) {
                    this.reu.add(zVar.qXv);
                    h.c("adId", zVar.qXv, true, rVar.qWP, new a() {
                        public final void cpu() {
                        }

                        public final void cmD() {
                            AppMethodBeat.i(37771);
                            ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + zVar.qXv + "is error");
                            j.a(j.this, zVar.qWH);
                            AppMethodBeat.o(37771);
                        }

                        public final void YJ(String str) {
                            AppMethodBeat.i(37772);
                            j.a(j.this, zVar.qXv);
                            AppMethodBeat.o(37772);
                        }
                    });
                }
            }
            AppMethodBeat.o(37777);
        }
    }

    private void YQ(final String str) {
        AppMethodBeat.i(37778);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(37778);
        } else if (YP(str)) {
            AppMethodBeat.o(37778);
        } else {
            this.reu.add(str);
            h.c("adId", str, true, 0, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37773);
                    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + str + "is error");
                    j.a(j.this, str);
                    AppMethodBeat.o(37773);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37774);
                    j.a(j.this, str);
                    AppMethodBeat.o(37774);
                }
            });
            AppMethodBeat.o(37778);
        }
    }

    public final void f(String str, String str2, String str3, int i) {
        AppMethodBeat.i(37779);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList gn = i.gn(str2, str3);
        int i2;
        int i3;
        Iterator it;
        int i4;
        g gVar;
        Iterator it2;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = g.Nu().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = g.Nu().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (gn.size() > 0) {
                    it = gn.iterator();
                    i4 = i2;
                    while (it.hasNext()) {
                        gVar = (g) it.next();
                        YQ(gVar.reh);
                        if (i3 <= 0 || i4 <= 0) {
                            break;
                        }
                        it2 = gVar.rej.iterator();
                        while (it2.hasNext()) {
                            a(str, (r) it2.next());
                            i2 = i3 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            i3 = i2;
                        }
                        i2 = i3;
                        i4--;
                        i3 = i2;
                    }
                }
                AppMethodBeat.o(37779);
                return;
            }
            ab.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = gn.iterator();
            while (it3.hasNext()) {
                g gVar2 = (g) it3.next();
                it = gVar2.rej.iterator();
                while (it.hasNext()) {
                    a(str, (r) it.next());
                }
                for (String str4 : gVar2.rek.keySet()) {
                    a(str, (r) gVar2.rek.get(str4));
                }
                YQ(gVar2.reh);
            }
            AppMethodBeat.o(37779);
        } else if (i == 1) {
            ab.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                Iterator it4 = gn.iterator();
                while (it4.hasNext()) {
                    YQ(((g) it4.next()).reh);
                }
                AppMethodBeat.o(37779);
                return;
            }
            ab.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = g.Nu().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = g.Nu().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (gn.size() > 0) {
                it = gn.iterator();
                i4 = i2;
                while (it.hasNext()) {
                    gVar = (g) it.next();
                    YQ(gVar.reh);
                    if (i3 <= 0 || i4 <= 0) {
                        break;
                    }
                    it2 = gVar.rej.iterator();
                    while (it2.hasNext()) {
                        a(str, (r) it2.next());
                        i2 = i3 - 1;
                        if (i2 <= 0) {
                            break;
                        }
                        i3 = i2;
                    }
                    i2 = i3;
                    i4--;
                    i3 = i2;
                }
            }
            AppMethodBeat.o(37779);
        } else {
            ab.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
            AppMethodBeat.o(37779);
        }
    }
}
