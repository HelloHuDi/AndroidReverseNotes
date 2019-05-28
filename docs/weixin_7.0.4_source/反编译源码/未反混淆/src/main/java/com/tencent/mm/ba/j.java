package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;

public final class j extends m implements o, k {
    private int cvz;
    private b ehh;
    private f ehi;
    public int fMn;
    private int offset = 0;

    public j(int i, int i2) {
        AppMethodBeat.i(78452);
        this.fMn = i;
        this.cvz = i2;
        m cv = r.aix().cv(i, i2);
        if (cv == null) {
            ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:".concat(String.valueOf(i)));
            AppMethodBeat.o(78452);
            return;
        }
        cv.status = 3;
        cv.bJt = 64;
        r.aix().b(cv);
        if (i2 == 5) {
            e.deleteFile(g.RP().cachePath + "brand_i18n.apk");
            AppMethodBeat.o(78452);
            return;
        }
        e.deleteFile(n.aiu() + r.aix().cx(i, i2));
        AppMethodBeat.o(78452);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(78453);
        this.ehi = fVar;
        ab.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.fMn), Integer.valueOf(this.cvz));
        m cv = r.aix().cv(this.fMn, this.cvz);
        if (cv == null) {
            ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.fMn + " type:" + this.cvz);
            AppMethodBeat.o(78453);
            return -1;
        } else if (cv.status != 3) {
            ab.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.fMn + " stat:" + cv.status);
            AppMethodBeat.o(78453);
            return -1;
        } else if (cv.size <= 0) {
            ab.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.fMn + " size:" + cv.size);
            AppMethodBeat.o(78453);
            return -1;
        } else {
            a aVar = new a();
            aVar.fsJ = new xh();
            aVar.fsK = new xi();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.fsI = 160;
            aVar.fsL = 0;
            aVar.fsM = 0;
            this.ehh = aVar.acD();
            xh xhVar = (xh) this.ehh.fsG.fsP;
            bic bic = new bic();
            bic.ndE = cv.id;
            bic.Version = cv.version;
            xhVar.wde = bic;
            xhVar.vOq = this.offset;
            xhVar.wdf = 65536;
            xhVar.jCt = this.cvz;
            int a = a(eVar, this.ehh, this);
            AppMethodBeat.o(78453);
            return a;
        }
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(78454);
        xh xhVar = (xh) ((b) qVar).fsG.fsP;
        m cv = r.aix().cv(this.fMn, this.cvz);
        m.b bVar;
        if (cv == null) {
            ab.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.fMn);
            bVar = m.b.EFailed;
            AppMethodBeat.o(78454);
            return bVar;
        } else if (xhVar.wde.ndE == this.fMn && xhVar.vOq == this.offset && xhVar.vOq < cv.size && xhVar.wdf == 65536 && cv.size > 0 && cv.status == 3) {
            bVar = m.b.EOk;
            AppMethodBeat.o(78454);
            return bVar;
        } else {
            ab.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.fMn);
            bVar = m.b.EFailed;
            AppMethodBeat.o(78454);
            return bVar;
        }
    }

    public final int acn() {
        return 50;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(78455);
        r.aix().cz(this.fMn, this.cvz);
        AppMethodBeat.o(78455);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78456);
        ab.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.fMn + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            xi xiVar = (xi) ((b) qVar).fsH.fsP;
            if (xiVar.jCt != this.cvz) {
                ab.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                r.aix().cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(78456);
                return;
            }
            byte[] a = aa.a(xiVar.wdg);
            if (a == null || a.length == 0) {
                ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.fMn);
                r.aix().cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(78456);
                return;
            }
            m cv = r.aix().cv(this.fMn, this.cvz);
            if (cv == null) {
                ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.fMn);
                r.aix().cz(this.fMn, this.cvz);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(78456);
                return;
            } else if (cv.size != xiVar.wdh) {
                ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                r.aix().cz(this.fMn, this.cvz);
                g.RO().eJo.a(new k(this.cvz), 0);
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(78456);
                return;
            } else {
                Object obj;
                Object obj2;
                if (this.cvz == 5) {
                    obj = g.RP().cachePath;
                    obj2 = "brand_i18n.apk";
                } else {
                    r.aix();
                    obj = n.aiu();
                    obj2 = r.aix().cx(this.fMn, this.cvz);
                }
                ab.d("MicroMsg.NetSceneDownloadPackage", "packagePath ".concat(String.valueOf(obj)));
                ab.d("MicroMsg.NetSceneDownloadPackage", "packageName ".concat(String.valueOf(obj2)));
                e.tf(obj);
                int a2 = e.a(obj + IOUtils.DIR_SEPARATOR_UNIX + obj2, a, a.length);
                if (a2 != 0) {
                    r.aix().cz(this.fMn, this.cvz);
                    ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = ".concat(String.valueOf(a2)));
                    this.ehi.onSceneEnd(3, -1, str, this);
                    AppMethodBeat.o(78456);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= cv.size) {
                    String cy;
                    boolean z = false;
                    if (this.cvz == 1) {
                        cy = r.aix().cy(this.fMn, this.cvz);
                        a2 = bo.hU(obj + obj2, cy);
                        if (a2 < 0) {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + obj + obj2 + ", unzipPath = " + cy);
                            r.aix().cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.cvz == 23) {
                        if (bo.isNullOrNil(obj) || bo.isNullOrNil(obj2)) {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", obj, obj2);
                            r.aix().cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new com.tencent.mm.vfs.b(obj + obj2).exists()) {
                            if (-1 == e.y(obj + obj2, com.tencent.mm.compatible.util.e.eSj + "permissioncfg.cfg")) {
                                ab.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.aix().cz(this.fMn, this.cvz);
                                this.ehi.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", obj, obj2);
                            r.aix().cz(this.fMn, this.cvz);
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
                        ab.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.cvz == 12) {
                        nc ncVar = new nc();
                        ncVar.cJi.cJk = obj + obj2;
                        com.tencent.mm.sdk.b.a.xxA.m(ncVar);
                        z = true;
                    }
                    if (this.cvz == 18) {
                        cy = r.aix().cy(this.fMn, this.cvz);
                        a2 = bo.hU(obj + obj2, cy);
                        if (a2 < 0) {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + obj + obj2 + ", unzipPath = " + cy);
                            r.aix().cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            ab.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", cy);
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
                        if (bo.isNullOrNil(obj) || bo.isNullOrNil(obj2)) {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", obj, obj2);
                            this.ehi.onSceneEnd(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new com.tencent.mm.vfs.b(obj + obj2).exists()) {
                            if (-1 == e.y(obj + obj2, com.tencent.mm.compatible.util.e.eSj + "ipcallCountryCodeConfig.cfg")) {
                                ab.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.aix().cz(this.fMn, this.cvz);
                                this.ehi.onSceneEnd(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                ab.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            ab.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", obj, obj2);
                            r.aix().cz(this.fMn, this.cvz);
                            this.ehi.onSceneEnd(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.cvz == 36) {
                        z = aN(obj, obj2);
                    }
                    if (z) {
                        cv.status = 2;
                        cv.bJt = 64;
                        r.aix().b(cv);
                        this.ehi.onSceneEnd(0, 0, "", this);
                    }
                    AppMethodBeat.o(78456);
                    return;
                }
                if (a(this.ftf, this.ehi) < 0) {
                    r.aix().cz(this.fMn, this.cvz);
                    this.ehi.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.o(78456);
                return;
            }
        }
        ab.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        r.aix().cz(this.fMn, this.cvz);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78456);
    }

    private static boolean aN(String str, String str2) {
        Throwable e;
        boolean z = true;
        AppMethodBeat.i(78457);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(78457);
            return false;
        }
        try {
            String str3 = str + str2;
            Object cy = e.cy(str3);
            if (bo.isNullOrNil(cy)) {
                z = false;
            } else {
                g.RP().Ry().set(ac.a.USERINFO_SENSE_WHERE_LOCATION_STRING, cy);
            }
            try {
                e.deleteFile(str3);
                ab.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, bo.anv(cy));
            } catch (IOException e2) {
                e = e2;
                ab.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
                AppMethodBeat.o(78457);
                return z;
            }
        } catch (IOException e3) {
            e = e3;
            z = false;
            ab.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            AppMethodBeat.o(78457);
            return z;
        }
        AppMethodBeat.o(78457);
        return z;
    }

    public final int getType() {
        return 160;
    }

    public final int acR() {
        return this.cvz;
    }
}
