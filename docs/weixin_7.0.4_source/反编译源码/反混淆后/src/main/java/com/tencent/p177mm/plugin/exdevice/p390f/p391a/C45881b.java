package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.b */
public final class C45881b {

    /* renamed from: com.tencent.mm.plugin.exdevice.f.a.b$a */
    static class C45880a implements Runnable {
        private C5728b lvo;
        private String url;

        C45880a(String str, C5728b c5728b) {
            this.url = str;
            this.lvo = c5728b;
        }

        public final void run() {
            AppMethodBeat.m2504i(19432);
            byte[] ano = C5046bo.ano(this.url);
            if (ano != null) {
                C5730e.m8624b(C5736j.m8649w(this.lvo.mUri), ano, ano.length);
            }
            AppMethodBeat.m2505o(19432);
        }

        public final String toString() {
            AppMethodBeat.m2504i(19433);
            String str = super.toString() + "|DownloadRunnable";
            AppMethodBeat.m2505o(19433);
            return str;
        }
    }

    /* renamed from: Kl */
    public static String m85009Kl(String str) {
        AppMethodBeat.m2504i(19434);
        String str2;
        if (C5046bo.isNullOrNil(str) || "#".equals(str)) {
            str2 = "";
            AppMethodBeat.m2505o(19434);
            return str2;
        }
        C5728b c5728b = new C5728b(C38935d.bpj(), C4995ag.m7428ck(str));
        if (c5728b.exists()) {
            str2 = C5736j.m8649w(c5728b.dMD());
            AppMethodBeat.m2505o(19434);
            return str2;
        }
        try {
            c5728b.createNewFile();
        } catch (IOException e) {
            C4990ab.m7411d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", e.toString());
        }
        C9638aw.m17180RS().mo10302aa(new C45880a(str, c5728b));
        str2 = "";
        AppMethodBeat.m2505o(19434);
        return str2;
    }
}
