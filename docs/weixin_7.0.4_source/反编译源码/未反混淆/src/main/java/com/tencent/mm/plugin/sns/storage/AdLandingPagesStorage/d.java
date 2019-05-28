package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class d extends b {
    private final String fileName;
    private final String filePath;
    private final String rdT;
    private final a rdU;

    public interface a {
        void YJ(String str);

        void cmD();
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(37693);
        String cqh = cqh();
        AppMethodBeat.o(37693);
        return cqh;
    }

    public d(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(37691);
        e.tf(str2);
        this.url = str;
        this.rdT = str2;
        this.fileName = str3;
        this.filePath = str2 + "/" + str3;
        this.rdU = aVar;
        AppMethodBeat.o(37691);
    }

    private String cqh() {
        AppMethodBeat.i(37692);
        try {
            AdLandingPagesProxy.getInstance().downloadLandingPagesImage(this.rdT, this.fileName, this.url, new g() {
                public final void cmD() {
                    AppMethodBeat.i(37688);
                    if (d.this.rdU != null) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37686);
                                d.this.rdU.cmD();
                                AppMethodBeat.o(37686);
                            }
                        });
                    }
                    AppMethodBeat.o(37688);
                }

                public final void cmE() {
                    AppMethodBeat.i(37689);
                    if (d.this.rdU != null) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37687);
                                d.this.rdU.YJ(d.this.filePath);
                                AppMethodBeat.o(37687);
                            }
                        });
                    }
                    AppMethodBeat.o(37689);
                }
            });
        } catch (Exception e) {
            ab.i("MicroMsg.AdLandingPageDownloadCDNFileTask", "maybe wrong download scene, res[%s], stack[%s]", this.url, bo.l(e));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37690);
                    d.this.rdU.cmD();
                    AppMethodBeat.o(37690);
                }
            });
        }
        AppMethodBeat.o(37692);
        return null;
    }
}
