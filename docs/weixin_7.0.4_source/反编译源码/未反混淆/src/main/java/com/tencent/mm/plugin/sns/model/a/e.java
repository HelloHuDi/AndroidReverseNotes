package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends f {
    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean cor() {
        Object obj;
        long yz;
        AppMethodBeat.i(36750);
        long j = -1;
        Object obj2 = (bo.isNullOrNil(this.qOa.qFR) || bo.isNullOrNil(this.qOa.qFS)) ? null : 1;
        String l = obj2 != null ? this.qOa.qFS : i.l(this.cNr);
        String str = this.qOa.getPath() + this.qOa.cop();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long asZ = com.tencent.mm.vfs.e.asZ(str);
        int obj3;
        if (this.qOB || toLowerCase.contains("webp")) {
            obj3 = null;
        } else if (this.qOC || toLowerCase.contains("vcodec")) {
            obj3 = 1;
        } else {
            obj3 = 2;
        }
        long az;
        switch (obj3) {
            case null:
                h.pYm.a(22, 64, 1, true);
                com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + l);
                yz = bo.yz();
                s.e(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l, false);
                az = bo.az(yz);
                com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                j = bo.az(yz);
                c.a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, asZ, az);
                break;
            case 1:
                ab.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", this.qOa.getPath() + this.qOa.cop());
                com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + l);
                yz = bo.yz();
                s.e(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l, false);
                az = bo.az(yz);
                com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                j = bo.az(yz);
                c.a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, asZ, az);
                break;
            case 2:
                az = -1;
                if (i.Xp(this.qOa.getPath() + this.qOa.cop())) {
                    ab.w("MicroMsg.SnsDownloadImage", "the " + this.qOa.cHr + " is too max ! " + this.qOa.url);
                    com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + l);
                    yz = bo.yz();
                    s.aj(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l);
                    az = bo.az(yz);
                    com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                    j = bo.az(yz);
                } else {
                    com.tencent.mm.vfs.e.h(this.qOa.getPath(), this.qOa.cop(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.qOa.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, asZ, az);
                break;
        }
        ab.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj3 == null));
        yz = com.tencent.mm.vfs.e.asZ(this.qOa.getPath() + l);
        h.pYm.e(11696, Integer.valueOf(3), Long.valueOf(j), Long.valueOf(yz), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
        Object obj4 = this.qOa.qNV != 3 ? 1 : null;
        if (!(this.qOa.qFJ == null || this.qOa.qFJ.qFQ == 4 || this.qOa.qFJ.qFQ == 5)) {
            obj4 = null;
        }
        if (obj4 != null) {
            toLowerCase = i.e(this.cNr);
            if (com.tencent.mm.vfs.e.ct(this.qOa.getPath() + toLowerCase)) {
                com.tencent.mm.vfs.e.deleteFile(this.qOa.getPath() + toLowerCase);
            }
            long yz2 = bo.yz();
            s.a(this.qOa.getPath(), l, toLowerCase, (float) af.cnO());
            yz2 = bo.az(yz2);
            com.tencent.mm.vfs.e.asZ(this.qOa.getPath() + toLowerCase);
            h.pYm.e(11696, Integer.valueOf(3), Long.valueOf(yz2), Long.valueOf(yz), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
            toLowerCase = i.f(this.cNr);
            if (!com.tencent.mm.vfs.e.ct(this.qOa.getPath() + toLowerCase)) {
                s.b(this.qOa.getPath(), l, toLowerCase, (float) af.cnN());
            }
        }
        AppMethodBeat.o(36750);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 1;
    }
}
