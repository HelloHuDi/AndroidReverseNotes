package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class i extends f {
    private boolean flo = false;

    public i(a aVar, a aVar2) {
        super(aVar, aVar2);
        AppMethodBeat.i(36754);
        h.pYm.a(150, 10, 1, true);
        AppMethodBeat.o(36754);
    }

    public final boolean cor() {
        AppMethodBeat.i(36755);
        if (this.qOa.qFJ != null) {
            int queryQuality;
            String str;
            String e = com.tencent.mm.plugin.sns.data.i.e(this.cNr);
            this.flo = s.Zj(this.qOa.getPath() + this.qOa.cop());
            if (this.qOB) {
                this.flo = true;
            }
            if (this.flo) {
                h.pYm.a(22, 64, 1, true);
            }
            String str2 = this.qOa.getPath() + this.qOa.cop();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bo.isNullOrNil(options.outMimeType)) {
                h.pYm.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long asZ = e.asZ(str2);
            if (asZ <= 0) {
                h.pYm.a(150, 23, 1, true);
            }
            long yz = bo.yz();
            String i = com.tencent.mm.plugin.sns.data.i.i(this.cNr);
            e.y(this.qOa.getPath() + this.qOa.cop(), this.qOa.getPath() + i);
            ab.v("MicroMsg.SnsDownloadThumb", "file src" + e.ct(this.qOa.getPath() + i));
            long yz2 = bo.yz();
            if (!s.a(this.qOa.getPath(), this.qOa.cop(), e, (float) af.cnO())) {
                ab.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                h.pYm.a(150, 27, 1, true);
            }
            yz2 = bo.az(yz2);
            boolean ct = e.ct(this.qOa.getPath() + this.qOa.cop());
            e.deleteFile(this.qOa.getPath() + this.qOa.cop());
            yz = bo.az(yz);
            if (!e.ct(this.qOa.getPath() + e)) {
                ab.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", Long.valueOf(e.asZ(this.qOa.getPath() + e)));
                h.pYm.a(150, 31, 1, true);
                if (ct && !e.ct(this.qOa.getPath() + e)) {
                    ab.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(b.oTO.bVR()));
                    h.pYm.a(150, 32, 1, true);
                    if (b.oTO.bVR()) {
                        h.pYm.a(150, 33, 1, true);
                    }
                }
            }
            h.pYm.e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
            if (this.qOa.qFJ.qFQ == 0 || this.qOa.qFJ.qFQ == 5) {
                i = com.tencent.mm.plugin.sns.data.i.f(this.cNr);
                s.b(this.qOa.getPath(), e, i, (float) af.cnN());
                str = i;
            } else {
                str = e;
            }
            c.a(this.qOa.getPath() + str, this.qOa.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, asZ, yz2);
            this.qNZ = com.tencent.mm.plugin.sns.data.i.Xk(this.qOa.getPath() + str);
            boolean b = com.tencent.mm.plugin.sns.data.i.b(this.qNZ);
            ab.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ);
            if (!b) {
                h.pYm.a(150, 65, 1, true);
                if (this.qOD) {
                    h.pYm.a(150, 50, 1, true);
                } else {
                    h.pYm.a(150, 51, 1, true);
                }
                if (this.qOC) {
                    h.pYm.a(150, 54, 1, true);
                }
                if (this.qOB) {
                    h.pYm.a(150, 57, 1, true);
                }
            }
            if (this.flo && !b) {
                h.pYm.a(22, 65, 1, true);
            }
            if (this.qOD && b) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
            }
        }
        AppMethodBeat.o(36755);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x036a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Dj(int i) {
        AppMethodBeat.i(36756);
        if (this.qOa.qFK != null && this.qOa.qFK.size() > 0) {
            com.tencent.mm.plugin.sns.data.e eVar = (com.tencent.mm.plugin.sns.data.e) this.qOa.qFK.get(i);
            bau bau = (bau) this.qOa.qFU.get(i);
            if (eVar == null || bau == null) {
                ab.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
                AppMethodBeat.o(36756);
                return false;
            }
            int i2;
            long asZ;
            long yz;
            String i3;
            long yz2;
            boolean ct;
            String f;
            boolean b;
            ab.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", Integer.valueOf(i));
            String str = an.fZ(af.getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.n(bau);
            String e = com.tencent.mm.plugin.sns.data.i.e(bau);
            this.flo = s.Zj(str);
            if (this.qOB) {
                this.flo = true;
            }
            if (this.flo) {
                h.pYm.a(22, 64, 1, true);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str, options);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bo.isNullOrNil(options.outMimeType)) {
                h.pYm.a(150, 35, 1, true);
            }
            int i4 = -1;
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                i4 = MMNativeJpeg.queryQuality(str);
                if (i4 == 0) {
                    i2 = -1;
                    asZ = e.asZ(str);
                    if (asZ <= 0) {
                        h.pYm.a(150, 23, 1, true);
                    }
                    yz = bo.yz();
                    i3 = com.tencent.mm.plugin.sns.data.i.i(bau);
                    e.y(str, an.fZ(af.getAccSnsPath(), bau.Id) + i3);
                    ab.v("MicroMsg.SnsDownloadThumb", "file exist " + e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i3));
                    yz2 = bo.yz();
                    if (!s.a(an.fZ(af.getAccSnsPath(), bau.Id), com.tencent.mm.plugin.sns.data.i.n(bau), e, (float) af.cnO())) {
                        ab.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                        h.pYm.a(150, 27, 1, true);
                    }
                    yz2 = bo.az(yz2);
                    ct = e.ct(str);
                    e.deleteFile(str);
                    yz = bo.az(yz);
                    if (!e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + e)) {
                        ab.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", Long.valueOf(e.asZ(this.qOa.getPath() + e)));
                        h.pYm.a(150, 31, 1, true);
                        if (ct) {
                            if (!e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + e)) {
                                ab.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(b.oTO.bVR()));
                                h.pYm.a(150, 32, 1, true);
                                if (b.oTO.bVR()) {
                                    h.pYm.a(150, 33, 1, true);
                                }
                            }
                        }
                    }
                    h.pYm.e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
                    if (eVar.qFQ != 0 || this.qOa.qFJ.qFQ == 5) {
                        f = com.tencent.mm.plugin.sns.data.i.f(bau);
                        s.b(an.fZ(af.getAccSnsPath(), bau.Id), e, f, (float) af.cnN());
                    } else {
                        f = e;
                    }
                    c.a(an.fZ(af.getAccSnsPath(), bau.Id) + f, bau.wEH, 1, options.outMimeType, options.outWidth, options.outHeight, i2, asZ, yz2);
                    this.qNZ = com.tencent.mm.plugin.sns.data.i.Xk(an.fZ(af.getAccSnsPath(), bau.Id) + f);
                    this.qOu.put(i, this.qNZ);
                    b = com.tencent.mm.plugin.sns.data.i.b(this.qNZ);
                    ab.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ + " index: " + i);
                    if (!b) {
                        h.pYm.a(150, 65, 1, true);
                        if (this.qOD) {
                            h.pYm.a(150, 50, 1, true);
                        } else {
                            h.pYm.a(150, 51, 1, true);
                        }
                        if (this.qOC) {
                            h.pYm.a(150, 54, 1, true);
                        }
                        if (this.qOB) {
                            h.pYm.a(150, 57, 1, true);
                        }
                    }
                    if (this.flo && !b) {
                        h.pYm.a(22, 65, 1, true);
                    }
                    if (this.qOD && b) {
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
                    }
                }
            }
            i2 = i4;
            asZ = e.asZ(str);
            if (asZ <= 0) {
            }
            yz = bo.yz();
            i3 = com.tencent.mm.plugin.sns.data.i.i(bau);
            e.y(str, an.fZ(af.getAccSnsPath(), bau.Id) + i3);
            ab.v("MicroMsg.SnsDownloadThumb", "file exist " + e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i3));
            yz2 = bo.yz();
            if (s.a(an.fZ(af.getAccSnsPath(), bau.Id), com.tencent.mm.plugin.sns.data.i.n(bau), e, (float) af.cnO())) {
            }
            yz2 = bo.az(yz2);
            ct = e.ct(str);
            e.deleteFile(str);
            yz = bo.az(yz);
            if (e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + e)) {
            }
            h.pYm.e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), af.cnR(), com.tencent.mm.compatible.util.e.eSl);
            if (eVar.qFQ != 0) {
            }
            f = com.tencent.mm.plugin.sns.data.i.f(bau);
            s.b(an.fZ(af.getAccSnsPath(), bau.Id), e, f, (float) af.cnN());
            c.a(an.fZ(af.getAccSnsPath(), bau.Id) + f, bau.wEH, 1, options.outMimeType, options.outWidth, options.outHeight, i2, asZ, yz2);
            this.qNZ = com.tencent.mm.plugin.sns.data.i.Xk(an.fZ(af.getAccSnsPath(), bau.Id) + f);
            this.qOu.put(i, this.qNZ);
            b = com.tencent.mm.plugin.sns.data.i.b(this.qNZ);
            ab.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ + " index: " + i);
            if (b) {
            }
            h.pYm.a(22, 65, 1, true);
            com.tencent.mm.plugin.sns.lucky.a.b.kT(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
        }
        AppMethodBeat.o(36756);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 3;
    }
}
