package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C36810c.C3948a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C36811d.C29090a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e */
public final class C34990e {

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$4 */
    static class C219774 implements Runnable {
        final /* synthetic */ C3948a rdZ;
        final /* synthetic */ String val$filePath;

        C219774(C3948a c3948a, String str) {
            this.rdZ = c3948a;
            this.val$filePath = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(37702);
            this.rdZ.mo8719lW(this.val$filePath);
            AppMethodBeat.m2505o(37702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$5 */
    static class C349925 implements C3948a {
        final /* synthetic */ C3948a rdZ;
        final /* synthetic */ String val$url;

        C349925(C3948a c3948a, String str) {
            this.rdZ = c3948a;
            this.val$url = str;
        }

        /* renamed from: de */
        public final void mo8718de(final String str, final int i) {
            AppMethodBeat.m2504i(37706);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37703);
                    C349925.this.rdZ.mo8718de(str, i);
                    AppMethodBeat.m2505o(37703);
                }
            });
            AppMethodBeat.m2505o(37706);
        }

        /* renamed from: BD */
        public final void mo8717BD(final String str) {
            AppMethodBeat.m2504i(37707);
            C4990ab.m7413e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for big file %s", this.val$url);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37704);
                    C349925.this.rdZ.mo8717BD(str);
                    AppMethodBeat.m2505o(37704);
                }
            });
            AppMethodBeat.m2505o(37707);
        }

        /* renamed from: lW */
        public final void mo8719lW(final String str) {
            AppMethodBeat.m2504i(37708);
            C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", " download success big file for %s", this.val$url);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37705);
                    C349925.this.rdZ.mo8719lW(str);
                    AppMethodBeat.m2505o(37705);
                }
            });
            AppMethodBeat.m2505o(37708);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$6 */
    static class C349946 implements Runnable {
        final /* synthetic */ C3948a rdZ;

        C349946(C3948a c3948a) {
            this.rdZ = c3948a;
        }

        public final void run() {
            AppMethodBeat.m2504i(37709);
            this.rdZ.mo8717BD("filePath is null!");
            AppMethodBeat.m2505o(37709);
        }
    }

    /* renamed from: a */
    public static void m57457a(final String str, final String str2, boolean z, int i, final C3951a c3951a) {
        AppMethodBeat.m2504i(37715);
        if (C5046bo.isNullOrNil(str2)) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37701);
                    c3951a.cmD();
                    AppMethodBeat.m2505o(37701);
                }
            });
            AppMethodBeat.m2505o(37715);
        } else if (C5730e.m8628ct(str2)) {
            C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", str2);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37694);
                    c3951a.mo8627YJ(str2);
                    AppMethodBeat.m2505o(37694);
                }
            });
            AppMethodBeat.m2505o(37715);
        } else {
            new C3950f(str, str2, z, i, 0, new C3951a() {

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$2$1 */
                class C219751 implements Runnable {
                    C219751() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(37695);
                        c3951a.cpu();
                        AppMethodBeat.m2505o(37695);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$2$2 */
                class C219762 implements Runnable {
                    C219762() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(37696);
                        c3951a.cmD();
                        AppMethodBeat.m2505o(37696);
                    }
                }

                public final void cpu() {
                    AppMethodBeat.m2504i(37698);
                    C5004al.m7441d(new C219751());
                    AppMethodBeat.m2505o(37698);
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37699);
                    C4990ab.m7413e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", str);
                    C5004al.m7441d(new C219762());
                    AppMethodBeat.m2505o(37699);
                }

                /* renamed from: YJ */
                public final void mo8627YJ(final String str) {
                    AppMethodBeat.m2504i(37700);
                    C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", str);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(37697);
                            c3951a.mo8627YJ(str);
                            AppMethodBeat.m2505o(37697);
                        }
                    });
                    AppMethodBeat.m2505o(37700);
                }
            }).execute(new Void[0]);
            AppMethodBeat.m2505o(37715);
        }
    }

    /* renamed from: a */
    public static void m57456a(final String str, String str2, String str3, final C3951a c3951a) {
        AppMethodBeat.m2504i(37716);
        final String str4 = str2 + str3;
        if (!C5046bo.isNullOrNil(str4)) {
            if (C5730e.m8628ct(str4)) {
                C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", str4);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37710);
                        c3951a.mo8627YJ(str4);
                        AppMethodBeat.m2505o(37710);
                    }
                });
                AppMethodBeat.m2505o(37716);
                return;
            }
            new C36811d(str, str2, str3, new C29090a() {

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$8$2 */
                class C219782 implements Runnable {
                    C219782() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(37712);
                        c3951a.mo8627YJ(str4);
                        AppMethodBeat.m2505o(37712);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$8$1 */
                class C290921 implements Runnable {
                    C290921() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(37711);
                        c3951a.cmD();
                        AppMethodBeat.m2505o(37711);
                    }
                }

                public final void cmD() {
                    AppMethodBeat.m2504i(37713);
                    C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", str);
                    C5004al.m7441d(new C290921());
                    AppMethodBeat.m2505o(37713);
                }

                /* renamed from: YJ */
                public final void mo47196YJ(String str) {
                    AppMethodBeat.m2504i(37714);
                    C4990ab.m7417i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", str, str);
                    C5004al.m7441d(new C219782());
                    AppMethodBeat.m2505o(37714);
                }
            }).execute(new Void[0]);
        }
        AppMethodBeat.m2505o(37716);
    }
}
