package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy.C21913g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d */
public final class C36811d extends C34987b {
    private final String fileName;
    private final String filePath;
    private final String rdT;
    private final C29090a rdU;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$2 */
    class C219722 implements Runnable {
        C219722() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37690);
            C36811d.this.rdU.cmD();
            AppMethodBeat.m2505o(37690);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a */
    public interface C29090a {
        /* renamed from: YJ */
        void mo47196YJ(String str);

        void cmD();
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$1 */
    class C368121 implements C21913g {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$1$1 */
        class C219701 implements Runnable {
            C219701() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37686);
                C36811d.this.rdU.cmD();
                AppMethodBeat.m2505o(37686);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$1$2 */
        class C219712 implements Runnable {
            C219712() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37687);
                C36811d.this.rdU.mo47196YJ(C36811d.this.filePath);
                AppMethodBeat.m2505o(37687);
            }
        }

        C368121() {
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37688);
            if (C36811d.this.rdU != null) {
                C5004al.m7441d(new C219701());
            }
            AppMethodBeat.m2505o(37688);
        }

        public final void cmE() {
            AppMethodBeat.m2504i(37689);
            if (C36811d.this.rdU != null) {
                C5004al.m7441d(new C219712());
            }
            AppMethodBeat.m2505o(37689);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(37693);
        String cqh = cqh();
        AppMethodBeat.m2505o(37693);
        return cqh;
    }

    public C36811d(String str, String str2, String str3, C29090a c29090a) {
        AppMethodBeat.m2504i(37691);
        C5730e.m8643tf(str2);
        this.url = str;
        this.rdT = str2;
        this.fileName = str3;
        this.filePath = str2 + "/" + str3;
        this.rdU = c29090a;
        AppMethodBeat.m2505o(37691);
    }

    private String cqh() {
        AppMethodBeat.m2504i(37692);
        try {
            AdLandingPagesProxy.getInstance().downloadLandingPagesImage(this.rdT, this.fileName, this.url, new C368121());
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.AdLandingPageDownloadCDNFileTask", "maybe wrong download scene, res[%s], stack[%s]", this.url, C5046bo.m7574l(e));
            C5004al.m7441d(new C219722());
        }
        AppMethodBeat.m2505o(37692);
        return null;
    }
}
