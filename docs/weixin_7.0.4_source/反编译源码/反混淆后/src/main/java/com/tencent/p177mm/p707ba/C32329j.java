package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C9420nc;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C23462xh;
import com.tencent.p177mm.protocal.protobuf.C23463xi;
import com.tencent.p177mm.protocal.protobuf.bic;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;

/* renamed from: com.tencent.mm.ba.j */
public final class C32329j extends C1207m implements C17895o, C1918k {
    private int cvz;
    private C7472b ehh;
    private C1202f ehi;
    public int fMn;
    private int offset = 0;

    public C32329j(int i, int i2) {
        AppMethodBeat.m2504i(78452);
        this.fMn = i;
        this.cvz = i2;
        C25854m cv = C41787r.aix().mo20541cv(i, i2);
        if (cv == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(78452);
            return;
        }
        cv.status = 3;
        cv.bJt = 64;
        C41787r.aix().mo20540b(cv);
        if (i2 == 5) {
            C5730e.deleteFile(C1720g.m3536RP().cachePath + "brand_i18n.apk");
            AppMethodBeat.m2505o(78452);
            return;
        }
        C5730e.deleteFile(C9067n.aiu() + C41787r.aix().mo20542cx(i, i2));
        AppMethodBeat.m2505o(78452);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78453);
        this.ehi = c1202f;
        C4990ab.m7411d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.fMn), Integer.valueOf(this.cvz));
        C25854m cv = C41787r.aix().mo20541cv(this.fMn, this.cvz);
        if (cv == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.fMn + " type:" + this.cvz);
            AppMethodBeat.m2505o(78453);
            return -1;
        } else if (cv.status != 3) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.fMn + " stat:" + cv.status);
            AppMethodBeat.m2505o(78453);
            return -1;
        } else if (cv.size <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.fMn + " size:" + cv.size);
            AppMethodBeat.m2505o(78453);
            return -1;
        } else {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C23462xh();
            c1196a.fsK = new C23463xi();
            c1196a.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            c1196a.fsI = 160;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            this.ehh = c1196a.acD();
            C23462xh c23462xh = (C23462xh) this.ehh.fsG.fsP;
            bic bic = new bic();
            bic.ndE = cv.f13661id;
            bic.Version = cv.version;
            c23462xh.wde = bic;
            c23462xh.vOq = this.offset;
            c23462xh.wdf = 65536;
            c23462xh.jCt = this.cvz;
            int a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(78453);
            return a;
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(78454);
        C23462xh c23462xh = (C23462xh) ((C7472b) c1929q).fsG.fsP;
        C25854m cv = C41787r.aix().mo20541cv(this.fMn, this.cvz);
        C1206b c1206b;
        if (cv == null) {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.fMn);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(78454);
            return c1206b;
        } else if (c23462xh.wde.ndE == this.fMn && c23462xh.vOq == this.offset && c23462xh.vOq < cv.size && c23462xh.wdf == 65536 && cv.size > 0 && cv.status == 3) {
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(78454);
            return c1206b;
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.fMn);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(78454);
            return c1206b;
        }
    }

    public final int acn() {
        return 50;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(78455);
        C41787r.aix().mo20544cz(this.fMn, this.cvz);
        AppMethodBeat.m2505o(78455);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78456);
        C4990ab.m7410d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.fMn + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            C23463xi c23463xi = (C23463xi) ((C7472b) c1929q).fsH.fsP;
            if (c23463xi.jCt != this.cvz) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(78456);
                return;
            }
            byte[] a = C1946aa.m4150a(c23463xi.wdg);
            if (a == null || a.length == 0) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.fMn);
                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(78456);
                return;
            }
            C25854m cv = C41787r.aix().mo20541cv(this.fMn, this.cvz);
            if (cv == null) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.fMn);
                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(78456);
                return;
            } else if (cv.size != c23463xi.wdh) {
                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                C1720g.m3535RO().eJo.mo14541a(new C45181k(this.cvz), 0);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(78456);
                return;
            } else {
                Object obj;
                Object obj2;
                if (this.cvz == 5) {
                    obj = C1720g.m3536RP().cachePath;
                    obj2 = "brand_i18n.apk";
                } else {
                    C41787r.aix();
                    obj = C9067n.aiu();
                    obj2 = C41787r.aix().mo20542cx(this.fMn, this.cvz);
                }
                C4990ab.m7410d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(obj)));
                C4990ab.m7410d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(obj2)));
                C5730e.m8643tf(obj);
                int a2 = C5730e.m8619a(obj + IOUtils.DIR_SEPARATOR_UNIX + obj2, a, a.length);
                if (a2 != 0) {
                    C41787r.aix().mo20544cz(this.fMn, this.cvz);
                    C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(a2)));
                    this.ehi.onSceneEnd(3, -1, str, this);
                    AppMethodBeat.m2505o(78456);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= cv.size) {
                    String cy;
                    boolean z = false;
                    if (this.cvz == 1) {
                        cy = C41787r.aix().mo20543cy(this.fMn, this.cvz);
                        a2 = C5046bo.m7570hU(obj + obj2, cy);
                        if (a2 < 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + obj + obj2 + ", unzipPath = " + cy);
                            C41787r.aix().mo20544cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.cvz == 23) {
                        if (C5046bo.isNullOrNil(obj) || C5046bo.isNullOrNil(obj2)) {
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", obj, obj2);
                            C41787r.aix().mo20544cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new C5728b(obj + obj2).exists()) {
                            if (-1 == C5730e.m8644y(obj + obj2, C6457e.eSj + "permissioncfg.cfg")) {
                                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                                this.ehi.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", obj, obj2);
                            C41787r.aix().mo20544cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.cvz == 7) {
                        z = true;
                    }
                    if (this.cvz == 9) {
                        z = true;
                    }
                    if (this.cvz == 5) {
                        z = true;
                        C4990ab.m7416i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.cvz == 12) {
                        C9420nc c9420nc = new C9420nc();
                        c9420nc.cJi.cJk = obj + obj2;
                        C4879a.xxA.mo10055m(c9420nc);
                        z = true;
                    }
                    if (this.cvz == 18) {
                        cy = C41787r.aix().mo20543cy(this.fMn, this.cvz);
                        a2 = C5046bo.m7570hU(obj + obj2, cy);
                        if (a2 < 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + obj + obj2 + ", unzipPath = " + cy);
                            C41787r.aix().mo20544cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            C4990ab.m7417i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", cy);
                            z = true;
                        }
                    }
                    if (this.cvz == 20) {
                        z = true;
                    }
                    if (this.cvz == 21) {
                        z = true;
                    }
                    if (this.cvz == 26) {
                        if (C5046bo.isNullOrNil(obj) || C5046bo.isNullOrNil(obj2)) {
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", obj, obj2);
                            this.ehi.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new C5728b(obj + obj2).exists()) {
                            if (-1 == C5730e.m8644y(obj + obj2, C6457e.eSj + "ipcallCountryCodeConfig.cfg")) {
                                C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                C41787r.aix().mo20544cz(this.fMn, this.cvz);
                                this.ehi.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                C4990ab.m7410d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            C4990ab.m7413e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", obj, obj2);
                            C41787r.aix().mo20544cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.cvz == 36) {
                        z = C32329j.m52871aN(obj, obj2);
                    }
                    if (z) {
                        cv.status = 2;
                        cv.bJt = 64;
                        C41787r.aix().mo20540b(cv);
                        this.ehi.onSceneEnd(0, 0, "", this);
                    }
                    AppMethodBeat.m2505o(78456);
                    return;
                }
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    C41787r.aix().mo20544cz(this.fMn, this.cvz);
                    this.ehi.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.m2505o(78456);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        C41787r.aix().mo20544cz(this.fMn, this.cvz);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78456);
    }

    /* renamed from: aN */
    private static boolean m52871aN(String str, String str2) {
        Throwable e;
        boolean z = true;
        AppMethodBeat.m2504i(78457);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(78457);
            return false;
        }
        try {
            String str3 = str + str2;
            Object cy = C5730e.m8631cy(str3);
            if (C5046bo.isNullOrNil(cy)) {
                z = false;
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SENSE_WHERE_LOCATION_STRING, cy);
            }
            try {
                C5730e.deleteFile(str3);
                C4990ab.m7417i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, C5046bo.anv(cy));
            } catch (IOException e2) {
                e = e2;
                C4990ab.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
                AppMethodBeat.m2505o(78457);
                return z;
            }
        } catch (IOException e3) {
            e = e3;
            z = false;
            C4990ab.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            AppMethodBeat.m2505o(78457);
            return z;
        }
        AppMethodBeat.m2505o(78457);
        return z;
    }

    public final int getType() {
        return 160;
    }

    public final int acR() {
        return this.cvz;
    }
}
