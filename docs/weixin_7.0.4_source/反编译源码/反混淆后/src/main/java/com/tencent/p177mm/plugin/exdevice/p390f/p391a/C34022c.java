package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.c */
public final class C34022c implements C1628a {
    String appName = null;
    String lvp = null;

    /* renamed from: a */
    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    /* renamed from: l */
    public final byte[] mo5084l(String str, byte[] bArr) {
        return null;
    }

    /* renamed from: a */
    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
        AppMethodBeat.m2504i(19435);
        C4990ab.m7411d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
        if (c9545d == null || !str.equals(this.lvp)) {
            if (c18496c != null) {
                C4990ab.m7410d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i == 0 && c9545d.field_retCode == 0) {
            C4990ab.m7410d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            C4990ab.m7417i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", str, c9545d.toString());
            C11646a c11646a = new C11646a();
            c11646a.field_championUrl = c9545d.field_fileUrl;
            c11646a.field_username = C1853r.m3846Yz();
            C45881b.m85009Kl(c11646a.field_championUrl);
            C45891ad.bpa().mo61825a(c11646a);
            C45891ad.bpe();
            C9638aw.m17182Rg().mo14541a(new C34026m(c11646a.field_championUrl, c11646a.field_championMotto), 0);
        } else {
            C4990ab.m7420w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        AppMethodBeat.m2505o(19435);
        return 0;
    }
}
