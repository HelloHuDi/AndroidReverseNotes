package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13469p;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13470q;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13471s;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C34986x;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C3947z;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46232m;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46233o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34990e.C219774;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34990e.C349925;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34990e.C349946;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C36810c.C3948a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j */
public final class C34998j {
    private static C34998j rev = new C34998j();
    ConcurrentLinkedQueue<String> reu = new ConcurrentLinkedQueue();

    static {
        AppMethodBeat.m2504i(37781);
        AppMethodBeat.m2505o(37781);
    }

    public static C34998j cql() {
        return rev;
    }

    private C34998j() {
        AppMethodBeat.m2504i(37775);
        AppMethodBeat.m2505o(37775);
    }

    /* renamed from: YP */
    private boolean m57466YP(String str) {
        AppMethodBeat.m2504i(37776);
        boolean contains = this.reu.contains(str);
        AppMethodBeat.m2505o(37776);
        return contains;
    }

    /* renamed from: a */
    private void m57469a(String str, C29086r c29086r) {
        AppMethodBeat.m2504i(37777);
        final C39780n c39780n;
        if (C3953i.m6286Dz(c29086r.type)) {
            ArrayList<C29086r> arrayList = new ArrayList();
            if (C3953i.m6281DA(c29086r.type)) {
                arrayList.addAll(((C34986x) c29086r).cpf());
            } else if (C3953i.m6284DD(c29086r.type)) {
                arrayList.addAll(((C13469p) c29086r).bnR);
            } else if (C3953i.m6282DB(c29086r.type)) {
                arrayList.addAll(((C13471s) c29086r).cpf());
            } else if (C3953i.m6283DC(c29086r.type)) {
                arrayList.addAll(((C13470q) c29086r).cpf());
            }
            for (C29086r a : arrayList) {
                m57469a(str, a);
            }
            AppMethodBeat.m2505o(37777);
        } else if (c29086r.qWP == 41) {
            c39780n = (C39780n) c29086r;
            if (m57466YP(c39780n.qWD)) {
                AppMethodBeat.m2505o(37777);
                return;
            }
            this.reu.add(c39780n.qWD);
            C13473h.m21623c(str, c39780n.qWD, true, c29086r.qWP, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37759);
                    C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c39780n.qWD + "is error");
                    C34998j.m57468a(C34998j.this, c39780n.qWD);
                    AppMethodBeat.m2505o(37759);
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(37760);
                    C34998j.m57468a(C34998j.this, c39780n.qWD);
                    AppMethodBeat.m2505o(37760);
                }
            });
            AppMethodBeat.m2505o(37777);
        } else if (c29086r.qWP == 44) {
            final C46232m c46232m = (C46232m) c29086r;
            if (m57466YP(c46232m.qWD)) {
                AppMethodBeat.m2505o(37777);
                return;
            }
            this.reu.add(c46232m.qWD);
            C13473h.m21623c(str, c46232m.qWD, true, c29086r.qWP, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37761);
                    C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c46232m.qWD + "is error");
                    C34998j.m57468a(C34998j.this, c46232m.qWD);
                    AppMethodBeat.m2505o(37761);
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(37762);
                    C34998j.m57468a(C34998j.this, c46232m.qWD);
                    AppMethodBeat.m2505o(37762);
                }
            });
            AppMethodBeat.m2505o(37777);
        } else if (c29086r.qWP == 45) {
            c39780n = (C39780n) c29086r;
            if (m57466YP(c39780n.qWD)) {
                AppMethodBeat.m2505o(37777);
                return;
            }
            this.reu.add(c39780n.qWD);
            C13473h.m21623c(str, c39780n.qWD, true, c29086r.qWP, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37763);
                    C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c39780n.qWD + "is error");
                    C34998j.m57468a(C34998j.this, c39780n.qWD);
                    AppMethodBeat.m2505o(37763);
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(37764);
                    C34998j.m57468a(C34998j.this, c39780n.qWD);
                    AppMethodBeat.m2505o(37764);
                }
            });
            AppMethodBeat.m2505o(37777);
        } else if (c29086r.qWP == 61) {
            final C46233o c46233o = (C46233o) c29086r;
            if (!m57466YP(c46233o.qWF)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                C37938c.afC();
                if (C37938c.m64120a(pInt, pInt2)) {
                    this.reu.add(c46233o.qWF);
                    C13473h.m21624d(str, c46233o.qWF, true, 61, new C3951a() {
                        public final void cpu() {
                        }

                        public final void cmD() {
                            AppMethodBeat.m2504i(37765);
                            C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c46233o.qWF + "is error");
                            C34998j.m57468a(C34998j.this, c46233o.qWF);
                            AppMethodBeat.m2505o(37765);
                        }

                        /* renamed from: YJ */
                        public final void mo8627YJ(String str) {
                            AppMethodBeat.m2504i(37766);
                            C34998j.m57468a(C34998j.this, c46233o.qWF);
                            AppMethodBeat.m2505o(37766);
                        }
                    });
                }
            }
            if (!m57466YP(c46233o.qWG)) {
                this.reu.add(c46233o.qWG);
                C13473h.m21623c(str, c46233o.qWG, true, 1000000001, new C3951a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                        AppMethodBeat.m2504i(37767);
                        C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c46233o.qWG + "is error");
                        C34998j.m57468a(C34998j.this, c46233o.qWG);
                        AppMethodBeat.m2505o(37767);
                    }

                    /* renamed from: YJ */
                    public final void mo8627YJ(String str) {
                        AppMethodBeat.m2504i(37768);
                        C34998j.m57468a(C34998j.this, c46233o.qWG);
                        AppMethodBeat.m2505o(37768);
                    }
                });
            }
            AppMethodBeat.m2505o(37777);
        } else {
            if (c29086r.qWP == 62) {
                boolean z = C26373g.m41964Nu().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
                C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(z)));
                final C3947z c3947z = (C3947z) c29086r;
                if (z && !m57466YP(c3947z.qWH)) {
                    this.reu.add(c3947z.qWH);
                    String str2 = c3947z.qWH;
                    int i = c29086r.qWP;
                    C349976 c349976 = new C3948a() {
                        /* renamed from: de */
                        public final void mo8718de(String str, int i) {
                        }

                        /* renamed from: BD */
                        public final void mo8717BD(String str) {
                            AppMethodBeat.m2504i(37769);
                            C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c3947z.qWH + "is error");
                            C34998j.m57468a(C34998j.this, c3947z.qWH);
                            AppMethodBeat.m2505o(37769);
                        }

                        /* renamed from: lW */
                        public final void mo8719lW(String str) {
                            AppMethodBeat.m2504i(37770);
                            C34998j.m57468a(C34998j.this, c3947z.qWH);
                            AppMethodBeat.m2505o(37770);
                        }
                    };
                    if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
                        c349976.mo8717BD("the res or adId is null");
                    } else {
                        C4990ab.m7416i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
                        String cqi = C13473h.cqi();
                        String str3 = str + "_stream_" + C4995ag.m7428ck(str2);
                        String str4 = cqi + str3;
                        if (C5046bo.isNullOrNil(str4)) {
                            C5004al.m7441d(new C349946(c349976));
                        } else if (C5730e.m8628ct(str4)) {
                            C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", str4);
                            C5004al.m7441d(new C219774(c349976, str4));
                        } else {
                            new C36810c(cqi, str3, i, new C349925(c349976, str2)).execute(new Void[0]);
                        }
                    }
                }
                if (!m57466YP(c3947z.qXv)) {
                    this.reu.add(c3947z.qXv);
                    C13473h.m21623c("adId", c3947z.qXv, true, c29086r.qWP, new C3951a() {
                        public final void cpu() {
                        }

                        public final void cmD() {
                            AppMethodBeat.m2504i(37771);
                            C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + c3947z.qXv + "is error");
                            C34998j.m57468a(C34998j.this, c3947z.qWH);
                            AppMethodBeat.m2505o(37771);
                        }

                        /* renamed from: YJ */
                        public final void mo8627YJ(String str) {
                            AppMethodBeat.m2504i(37772);
                            C34998j.m57468a(C34998j.this, c3947z.qXv);
                            AppMethodBeat.m2505o(37772);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(37777);
        }
    }

    /* renamed from: YQ */
    private void m57467YQ(final String str) {
        AppMethodBeat.m2504i(37778);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(37778);
        } else if (m57466YP(str)) {
            AppMethodBeat.m2505o(37778);
        } else {
            this.reu.add(str);
            C13473h.m21623c("adId", str, true, 0, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37773);
                    C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", " pre download " + str + "is error");
                    C34998j.m57468a(C34998j.this, str);
                    AppMethodBeat.m2505o(37773);
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(37774);
                    C34998j.m57468a(C34998j.this, str);
                    AppMethodBeat.m2505o(37774);
                }
            });
            AppMethodBeat.m2505o(37778);
        }
    }

    /* renamed from: f */
    public final void mo55575f(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(37779);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList gn = C3953i.m6304gn(str2, str3);
        int i2;
        int i3;
        Iterator it;
        int i4;
        C3952g c3952g;
        Iterator it2;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = C26373g.m41964Nu().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = C26373g.m41964Nu().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (gn.size() > 0) {
                    it = gn.iterator();
                    i4 = i2;
                    while (it.hasNext()) {
                        c3952g = (C3952g) it.next();
                        m57467YQ(c3952g.reh);
                        if (i3 <= 0 || i4 <= 0) {
                            break;
                        }
                        it2 = c3952g.rej.iterator();
                        while (it2.hasNext()) {
                            m57469a(str, (C29086r) it2.next());
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
                AppMethodBeat.m2505o(37779);
                return;
            }
            C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = gn.iterator();
            while (it3.hasNext()) {
                C3952g c3952g2 = (C3952g) it3.next();
                it = c3952g2.rej.iterator();
                while (it.hasNext()) {
                    m57469a(str, (C29086r) it.next());
                }
                for (String str4 : c3952g2.rek.keySet()) {
                    m57469a(str, (C29086r) c3952g2.rek.get(str4));
                }
                m57467YQ(c3952g2.reh);
            }
            AppMethodBeat.m2505o(37779);
        } else if (i == 1) {
            C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                Iterator it4 = gn.iterator();
                while (it4.hasNext()) {
                    m57467YQ(((C3952g) it4.next()).reh);
                }
                AppMethodBeat.m2505o(37779);
                return;
            }
            C4990ab.m7416i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = C26373g.m41964Nu().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = C26373g.m41964Nu().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (gn.size() > 0) {
                it = gn.iterator();
                i4 = i2;
                while (it.hasNext()) {
                    c3952g = (C3952g) it.next();
                    m57467YQ(c3952g.reh);
                    if (i3 <= 0 || i4 <= 0) {
                        break;
                    }
                    it2 = c3952g.rej.iterator();
                    while (it2.hasNext()) {
                        m57469a(str, (C29086r) it2.next());
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
            AppMethodBeat.m2505o(37779);
        } else {
            C4990ab.m7412e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
            AppMethodBeat.m2505o(37779);
        }
    }
}
