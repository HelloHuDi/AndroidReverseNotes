package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

public final class c implements a {
    String appName = null;
    String lvp = null;

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] l(String str, byte[] bArr) {
        return null;
    }

    public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
        AppMethodBeat.i(19435);
        ab.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
        if (dVar == null || !str.equals(this.lvp)) {
            if (cVar != null) {
                ab.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i == 0 && dVar.field_retCode == 0) {
            ab.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            ab.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", str, dVar.toString());
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championUrl = dVar.field_fileUrl;
            aVar.field_username = r.Yz();
            b.Kl(aVar.field_championUrl);
            ad.bpa().a(aVar);
            ad.bpe();
            aw.Rg().a(new m(aVar.field_championUrl, aVar.field_championMotto), 0);
        } else {
            ab.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        AppMethodBeat.o(19435);
        return 0;
    }
}
