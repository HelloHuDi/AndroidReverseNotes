package com.tencent.p177mm.plugin.sns.model.p519a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.plugin.sns.p517i.C39737c;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.model.a.i */
public final class C39746i extends C13368f {
    private boolean flo = false;

    public C39746i(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
        AppMethodBeat.m2504i(36754);
        C7060h.pYm.mo8378a(150, 10, 1, true);
        AppMethodBeat.m2505o(36754);
    }

    public final boolean cor() {
        AppMethodBeat.m2504i(36755);
        if (this.qOa.qFJ != null) {
            int queryQuality;
            String str;
            String e = C29036i.m46108e(this.cNr);
            this.flo = C13478s.m21633Zj(this.qOa.getPath() + this.qOa.cop());
            if (this.qOB) {
                this.flo = true;
            }
            if (this.flo) {
                C7060h.pYm.mo8378a(22, 64, 1, true);
            }
            String str2 = this.qOa.getPath() + this.qOa.cop();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || C5046bo.isNullOrNil(options.outMimeType)) {
                C7060h.pYm.mo8378a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long asZ = C5730e.asZ(str2);
            if (asZ <= 0) {
                C7060h.pYm.mo8378a(150, 23, 1, true);
            }
            long yz = C5046bo.m7588yz();
            String i = C29036i.m46113i(this.cNr);
            C5730e.m8644y(this.qOa.getPath() + this.qOa.cop(), this.qOa.getPath() + i);
            C4990ab.m7418v("MicroMsg.SnsDownloadThumb", "file src" + C5730e.m8628ct(this.qOa.getPath() + i));
            long yz2 = C5046bo.m7588yz();
            if (!C13478s.m21641a(this.qOa.getPath(), this.qOa.cop(), e, (float) C13373af.cnO())) {
                C4990ab.m7412e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                C7060h.pYm.mo8378a(150, 27, 1, true);
            }
            yz2 = C5046bo.m7525az(yz2);
            boolean ct = C5730e.m8628ct(this.qOa.getPath() + this.qOa.cop());
            C5730e.deleteFile(this.qOa.getPath() + this.qOa.cop());
            yz = C5046bo.m7525az(yz);
            if (!C5730e.m8628ct(this.qOa.getPath() + e)) {
                C4990ab.m7417i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", Long.valueOf(C5730e.asZ(this.qOa.getPath() + e)));
                C7060h.pYm.mo8378a(150, 31, 1, true);
                if (ct && !C5730e.m8628ct(this.qOa.getPath() + e)) {
                    C4990ab.m7417i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(C6998b.oTO.bVR()));
                    C7060h.pYm.mo8378a(150, 32, 1, true);
                    if (C6998b.oTO.bVR()) {
                        C7060h.pYm.mo8378a(150, 33, 1, true);
                    }
                }
            }
            C7060h.pYm.mo8381e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
            if (this.qOa.qFJ.qFQ == 0 || this.qOa.qFJ.qFQ == 5) {
                i = C29036i.m46110f(this.cNr);
                C13478s.m21644b(this.qOa.getPath(), e, i, (float) C13373af.cnN());
                str = i;
            } else {
                str = e;
            }
            C39737c.m67954a(this.qOa.getPath() + str, this.qOa.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, asZ, yz2);
            this.qNZ = C29036i.m46088Xk(this.qOa.getPath() + str);
            boolean b = C29036i.m46101b(this.qNZ);
            C4990ab.m7416i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ);
            if (!b) {
                C7060h.pYm.mo8378a(150, 65, 1, true);
                if (this.qOD) {
                    C7060h.pYm.mo8378a(150, 50, 1, true);
                } else {
                    C7060h.pYm.mo8378a(150, 51, 1, true);
                }
                if (this.qOC) {
                    C7060h.pYm.mo8378a(150, 54, 1, true);
                }
                if (this.qOB) {
                    C7060h.pYm.mo8378a(150, 57, 1, true);
                }
            }
            if (this.flo && !b) {
                C7060h.pYm.mo8378a(22, 65, 1, true);
            }
            if (this.qOD && b) {
                C21904b.m33474kT(C33333a.CTRL_INDEX);
            }
        }
        AppMethodBeat.m2505o(36755);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x036a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Dj */
    public final boolean mo55534Dj(int i) {
        AppMethodBeat.m2504i(36756);
        if (this.qOa.qFK != null && this.qOa.qFK.size() > 0) {
            C39731e c39731e = (C39731e) this.qOa.qFK.get(i);
            bau bau = (bau) this.qOa.qFU.get(i);
            if (c39731e == null || bau == null) {
                C4990ab.m7412e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
                AppMethodBeat.m2505o(36756);
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
            C4990ab.m7417i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", Integer.valueOf(i));
            String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46123n(bau);
            String e = C29036i.m46108e(bau);
            this.flo = C13478s.m21633Zj(str);
            if (this.qOB) {
                this.flo = true;
            }
            if (this.flo) {
                C7060h.pYm.mo8378a(22, 64, 1, true);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str, options);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || C5046bo.isNullOrNil(options.outMimeType)) {
                C7060h.pYm.mo8378a(150, 35, 1, true);
            }
            int i4 = -1;
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                i4 = MMNativeJpeg.queryQuality(str);
                if (i4 == 0) {
                    i2 = -1;
                    asZ = C5730e.asZ(str);
                    if (asZ <= 0) {
                        C7060h.pYm.mo8378a(150, 23, 1, true);
                    }
                    yz = C5046bo.m7588yz();
                    i3 = C29036i.m46113i(bau);
                    C5730e.m8644y(str, C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + i3);
                    C4990ab.m7418v("MicroMsg.SnsDownloadThumb", "file exist " + C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + i3));
                    yz2 = C5046bo.m7588yz();
                    if (!C13478s.m21641a(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id), C29036i.m46123n(bau), e, (float) C13373af.cnO())) {
                        C4990ab.m7412e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                        C7060h.pYm.mo8378a(150, 27, 1, true);
                    }
                    yz2 = C5046bo.m7525az(yz2);
                    ct = C5730e.m8628ct(str);
                    C5730e.deleteFile(str);
                    yz = C5046bo.m7525az(yz);
                    if (!C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + e)) {
                        C4990ab.m7417i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", Long.valueOf(C5730e.asZ(this.qOa.getPath() + e)));
                        C7060h.pYm.mo8378a(150, 31, 1, true);
                        if (ct) {
                            if (!C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + e)) {
                                C4990ab.m7417i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(C6998b.oTO.bVR()));
                                C7060h.pYm.mo8378a(150, 32, 1, true);
                                if (C6998b.oTO.bVR()) {
                                    C7060h.pYm.mo8378a(150, 33, 1, true);
                                }
                            }
                        }
                    }
                    C7060h.pYm.mo8381e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
                    if (c39731e.qFQ != 0 || this.qOa.qFJ.qFQ == 5) {
                        f = C29036i.m46110f(bau);
                        C13478s.m21644b(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id), e, f, (float) C13373af.cnN());
                    } else {
                        f = e;
                    }
                    C39737c.m67954a(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + f, bau.wEH, 1, options.outMimeType, options.outWidth, options.outHeight, i2, asZ, yz2);
                    this.qNZ = C29036i.m46088Xk(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + f);
                    this.qOu.put(i, this.qNZ);
                    b = C29036i.m46101b(this.qNZ);
                    C4990ab.m7416i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ + " index: " + i);
                    if (!b) {
                        C7060h.pYm.mo8378a(150, 65, 1, true);
                        if (this.qOD) {
                            C7060h.pYm.mo8378a(150, 50, 1, true);
                        } else {
                            C7060h.pYm.mo8378a(150, 51, 1, true);
                        }
                        if (this.qOC) {
                            C7060h.pYm.mo8378a(150, 54, 1, true);
                        }
                        if (this.qOB) {
                            C7060h.pYm.mo8378a(150, 57, 1, true);
                        }
                    }
                    if (this.flo && !b) {
                        C7060h.pYm.mo8378a(22, 65, 1, true);
                    }
                    if (this.qOD && b) {
                        C21904b.m33474kT(C33333a.CTRL_INDEX);
                    }
                }
            }
            i2 = i4;
            asZ = C5730e.asZ(str);
            if (asZ <= 0) {
            }
            yz = C5046bo.m7588yz();
            i3 = C29036i.m46113i(bau);
            C5730e.m8644y(str, C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + i3);
            C4990ab.m7418v("MicroMsg.SnsDownloadThumb", "file exist " + C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + i3));
            yz2 = C5046bo.m7588yz();
            if (C13478s.m21641a(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id), C29036i.m46123n(bau), e, (float) C13373af.cnO())) {
            }
            yz2 = C5046bo.m7525az(yz2);
            ct = C5730e.m8628ct(str);
            C5730e.deleteFile(str);
            yz = C5046bo.m7525az(yz);
            if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + e)) {
            }
            C7060h.pYm.mo8381e(11696, Integer.valueOf(3), Long.valueOf(yz), Integer.valueOf(this.qOt), Thread.currentThread().getName(), C13373af.cnR(), C6457e.eSl);
            if (c39731e.qFQ != 0) {
            }
            f = C29036i.m46110f(bau);
            C13478s.m21644b(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id), e, f, (float) C13373af.cnN());
            C39737c.m67954a(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + f, bau.wEH, 1, options.outMimeType, options.outWidth, options.outHeight, i2, asZ, yz2);
            this.qNZ = C29036i.m46088Xk(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + f);
            this.qOu.put(i, this.qNZ);
            b = C29036i.m46101b(this.qNZ);
            C4990ab.m7416i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.flo + " srcImgFileSize: " + asZ + " index: " + i);
            if (b) {
            }
            C7060h.pYm.mo8378a(22, 65, 1, true);
            C21904b.m33474kT(C33333a.CTRL_INDEX);
        }
        AppMethodBeat.m2505o(36756);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 3;
    }
}
