package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ a rdZ;
        final /* synthetic */ String val$filePath;

        AnonymousClass4(a aVar, String str) {
            this.rdZ = aVar;
            this.val$filePath = str;
        }

        public final void run() {
            AppMethodBeat.i(37702);
            this.rdZ.lW(this.val$filePath);
            AppMethodBeat.o(37702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$5 */
    static class AnonymousClass5 implements a {
        final /* synthetic */ a rdZ;
        final /* synthetic */ String val$url;

        AnonymousClass5(a aVar, String str) {
            this.rdZ = aVar;
            this.val$url = str;
        }

        public final void de(final String str, final int i) {
            AppMethodBeat.i(37706);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37703);
                    AnonymousClass5.this.rdZ.de(str, i);
                    AppMethodBeat.o(37703);
                }
            });
            AppMethodBeat.o(37706);
        }

        public final void BD(final String str) {
            AppMethodBeat.i(37707);
            ab.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for big file %s", this.val$url);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37704);
                    AnonymousClass5.this.rdZ.BD(str);
                    AppMethodBeat.o(37704);
                }
            });
            AppMethodBeat.o(37707);
        }

        public final void lW(final String str) {
            AppMethodBeat.i(37708);
            ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success big file for %s", this.val$url);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37705);
                    AnonymousClass5.this.rdZ.lW(str);
                    AppMethodBeat.o(37705);
                }
            });
            AppMethodBeat.o(37708);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$6 */
    static class AnonymousClass6 implements Runnable {
        final /* synthetic */ a rdZ;

        AnonymousClass6(a aVar) {
            this.rdZ = aVar;
        }

        public final void run() {
            AppMethodBeat.i(37709);
            this.rdZ.BD("filePath is null!");
            AppMethodBeat.o(37709);
        }
    }

    public static void a(final String str, final String str2, boolean z, int i, final f.a aVar) {
        AppMethodBeat.i(37715);
        if (bo.isNullOrNil(str2)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37701);
                    aVar.cmD();
                    AppMethodBeat.o(37701);
                }
            });
            AppMethodBeat.o(37715);
        } else if (com.tencent.mm.vfs.e.ct(str2)) {
            ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", str2);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37694);
                    aVar.YJ(str2);
                    AppMethodBeat.o(37694);
                }
            });
            AppMethodBeat.o(37715);
        } else {
            new f(str, str2, z, i, 0, new f.a() {
                public final void cpu() {
                    AppMethodBeat.i(37698);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37695);
                            aVar.cpu();
                            AppMethodBeat.o(37695);
                        }
                    });
                    AppMethodBeat.o(37698);
                }

                public final void cmD() {
                    AppMethodBeat.i(37699);
                    ab.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37696);
                            aVar.cmD();
                            AppMethodBeat.o(37696);
                        }
                    });
                    AppMethodBeat.o(37699);
                }

                public final void YJ(final String str) {
                    AppMethodBeat.i(37700);
                    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37697);
                            aVar.YJ(str);
                            AppMethodBeat.o(37697);
                        }
                    });
                    AppMethodBeat.o(37700);
                }
            }).execute(new Void[0]);
            AppMethodBeat.o(37715);
        }
    }

    public static void a(final String str, String str2, String str3, final f.a aVar) {
        AppMethodBeat.i(37716);
        final String str4 = str2 + str3;
        if (!bo.isNullOrNil(str4)) {
            if (com.tencent.mm.vfs.e.ct(str4)) {
                ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", str4);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37710);
                        aVar.YJ(str4);
                        AppMethodBeat.o(37710);
                    }
                });
                AppMethodBeat.o(37716);
                return;
            }
            new d(str, str2, str3, new d.a() {
                public final void cmD() {
                    AppMethodBeat.i(37713);
                    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37711);
                            aVar.cmD();
                            AppMethodBeat.o(37711);
                        }
                    });
                    AppMethodBeat.o(37713);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37714);
                    ab.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", str, str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37712);
                            aVar.YJ(str4);
                            AppMethodBeat.o(37712);
                        }
                    });
                    AppMethodBeat.o(37714);
                }
            }).execute(new Void[0]);
        }
        AppMethodBeat.o(37716);
    }
}
