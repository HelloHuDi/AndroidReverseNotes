package com.tencent.p177mm.plugin.sns.model.p519a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.plugin.sns.p517i.C39737c;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.model.a.e */
public final class C16865e extends C13368f {
    public C16865e(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
    }

    public final boolean cor() {
        Object obj;
        long yz;
        AppMethodBeat.m2504i(36750);
        long j = -1;
        Object obj2 = (C5046bo.isNullOrNil(this.qOa.qFR) || C5046bo.isNullOrNil(this.qOa.qFS)) ? null : 1;
        String l = obj2 != null ? this.qOa.qFS : C29036i.m46121l(this.cNr);
        String str = this.qOa.getPath() + this.qOa.cop();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long asZ = C5730e.asZ(str);
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
                C7060h.pYm.mo8378a(22, 64, 1, true);
                C5730e.deleteFile(this.qOa.getPath() + l);
                yz = C5046bo.m7588yz();
                C13478s.m21645e(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l, false);
                az = C5046bo.m7525az(yz);
                C5730e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                j = C5046bo.m7525az(yz);
                C39737c.m67954a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, asZ, az);
                break;
            case 1:
                C4990ab.m7417i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", this.qOa.getPath() + this.qOa.cop());
                C5730e.deleteFile(this.qOa.getPath() + l);
                yz = C5046bo.m7588yz();
                C13478s.m21645e(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l, false);
                az = C5046bo.m7525az(yz);
                C5730e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                j = C5046bo.m7525az(yz);
                C39737c.m67954a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, asZ, az);
                break;
            case 2:
                az = -1;
                if (C29036i.m46093Xp(this.qOa.getPath() + this.qOa.cop())) {
                    C4990ab.m7420w("MicroMsg.SnsDownloadImage", "the " + this.qOa.cHr + " is too max ! " + this.qOa.url);
                    C5730e.deleteFile(this.qOa.getPath() + l);
                    yz = C5046bo.m7588yz();
                    C13478s.m21642aj(this.qOa.getPath(), this.qOa.getPath() + this.qOa.cop(), l);
                    az = C5046bo.m7525az(yz);
                    C5730e.deleteFile(this.qOa.getPath() + this.qOa.cop());
                    j = C5046bo.m7525az(yz);
                } else {
                    C5730e.m8633h(this.qOa.getPath(), this.qOa.cop(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.qOa.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                C39737c.m67954a(this.qOa.getPath() + l, this.qOa.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, asZ, az);
                break;
        }
        C4990ab.m7416i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj3 == null));
        yz = C5730e.asZ(this.qOa.getPath() + l);
        C7060h.pYm.mo8381e(11696, Integer.valueOf(3), Long.valueOf(j), Long.valueOf(yz), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
        Object obj4 = this.qOa.qNV != 3 ? 1 : null;
        if (!(this.qOa.qFJ == null || this.qOa.qFJ.qFQ == 4 || this.qOa.qFJ.qFQ == 5)) {
            obj4 = null;
        }
        if (obj4 != null) {
            toLowerCase = C29036i.m46108e(this.cNr);
            if (C5730e.m8628ct(this.qOa.getPath() + toLowerCase)) {
                C5730e.deleteFile(this.qOa.getPath() + toLowerCase);
            }
            long yz2 = C5046bo.m7588yz();
            C13478s.m21641a(this.qOa.getPath(), l, toLowerCase, (float) C13373af.cnO());
            yz2 = C5046bo.m7525az(yz2);
            C5730e.asZ(this.qOa.getPath() + toLowerCase);
            C7060h.pYm.mo8381e(11696, Integer.valueOf(3), Long.valueOf(yz2), Long.valueOf(yz), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
            toLowerCase = C29036i.m46110f(this.cNr);
            if (!C5730e.m8628ct(this.qOa.getPath() + toLowerCase)) {
                C13478s.m21644b(this.qOa.getPath(), l, toLowerCase, (float) C13373af.cnN());
            }
        }
        AppMethodBeat.m2505o(36750);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 1;
    }
}
