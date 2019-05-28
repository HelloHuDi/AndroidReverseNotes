package com.tencent.mm.ba;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends m implements o, com.tencent.mm.network.k {
    private int cvz;
    private b ehh;
    private f ehi;
    private boolean fMo;
    private int flags;

    public k(boolean z) {
        AppMethodBeat.i(78458);
        this.fMo = false;
        this.flags = -1;
        this.cvz = 26;
        this.fMo = false;
        ab.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
        ab.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
        AppMethodBeat.o(78458);
    }

    public k(int i) {
        AppMethodBeat.i(78459);
        this.fMo = false;
        this.flags = -1;
        this.cvz = i;
        this.fMo = false;
        ab.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(i)));
        AppMethodBeat.o(78459);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78460);
        this.ehi = fVar;
        ab.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.cvz);
        a aVar = new a();
        aVar.fsJ = new alw();
        aVar.fsK = new alx();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.fsI = JsApiGetBackgroundAudioState.CTRL_INDEX;
        aVar.fsL = 51;
        aVar.fsM = 1000000051;
        this.ehh = aVar.acD();
        alw alw = (alw) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        if (g.RN().QY()) {
            m[] lU = r.aix().lU(this.cvz);
            if (lU != null && lU.length > 0) {
                for (int i = 0; i < lU.length; i++) {
                    bic bic = new bic();
                    bic.ndE = lU[i].id;
                    if (ae.gip && this.cvz == 7) {
                        ab.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                        bic.Version = 0;
                    } else {
                        bic.Version = lU[i].version;
                    }
                    ab.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(bic.ndE), Integer.valueOf(bic.Version));
                    linkedList.add(bic);
                }
            }
            alw.jBw = linkedList;
            alw.jBv = linkedList.size();
            alw.jCt = this.cvz;
            if (this.flags != -1) {
                alw.vEq = this.flags;
            }
            int a = a(eVar, this.ehh, this);
            AppMethodBeat.o(78460);
            return a;
        }
        AppMethodBeat.o(78460);
        return -1;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 20;
    }

    public final void a(m.a aVar) {
    }

    public final boolean acI() {
        return true;
    }

    private m a(bic bic) {
        AppMethodBeat.i(78461);
        m mVar = new m();
        mVar.id = bic.ndE;
        mVar.version = bic.Version;
        mVar.name = bic.Name;
        mVar.size = bic.jCo;
        mVar.fMt = bic.PackName;
        mVar.status = 5;
        mVar.cBc = this.cvz;
        AppMethodBeat.o(78461);
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78462);
        ab.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.cvz), str);
        if (i2 == 0 || i3 == 0) {
            alx alx = (alx) ((b) qVar).fsH.fsP;
            if (alx.jCt != this.cvz) {
                ab.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(alx.jCt));
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(78462);
                return;
            }
            LinkedList linkedList = alx.jBw;
            ab.i("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.cvz + " resp.Type: " + alx.jCt);
            bic bic;
            m cv;
            m a;
            if (this.cvz == 2) {
                i(linkedList);
            } else if (this.cvz == 1) {
                h(linkedList);
            } else if (this.cvz == 4) {
                j(linkedList);
            } else if (this.cvz == 6) {
                ab.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.cvz == 7) {
                k(linkedList);
            } else if (this.cvz == 9) {
                g(linkedList);
            } else if (this.cvz == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    ab.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    bic = (bic) linkedList.get(0);
                    cv = r.aix().cv(bic.ndE, this.cvz);
                    a = a(bic);
                    a.bJt = -1;
                    if (cv == null) {
                        r.aix().a(a);
                    } else {
                        r.aix().b(a);
                    }
                }
            } else if (this.cvz != 11) {
                if (this.cvz == 12) {
                    m(linkedList);
                } else if (this.cvz == 5) {
                    n(linkedList);
                } else if (this.cvz == 20) {
                    l(linkedList);
                } else if (this.cvz == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        ab.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        bic = (bic) linkedList.get(0);
                        ab.d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
                        cv = r.aix().cv(bic.ndE, this.cvz);
                        m a2 = a(bic);
                        a2.bJt = -1;
                        if (cv == null) {
                            r.aix().a(a2);
                        } else {
                            r.aix().b(a2);
                        }
                        com.tencent.mm.sdk.b.b mnVar = new mn();
                        try {
                            mnVar.cIq.content = aa.a(bic.vFG);
                            if (mnVar.cIq.content != null) {
                                com.tencent.mm.sdk.b.a.xxA.a(mnVar, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.cvz != 18) {
                    if (this.cvz == 19) {
                        ae(linkedList);
                    } else if (this.cvz == 21) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            ab.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                        } else {
                            bic = (bic) linkedList.get(0);
                            ab.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + bic + "|id = " + bic.ndE + "|Name = " + bic.Name + "|PackName = " + bic.PackName + "|Size = " + bic.jCo + "|Version = " + bic.Version);
                            cv = r.aix().cv(bic.ndE, this.cvz);
                            a = a(bic);
                            a.bJt = -1;
                            if (cv == null) {
                                r.aix().a(a);
                            } else if (cv.version < a.version) {
                                r.aix().b(a);
                            } else {
                                ab.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(cv.version), Integer.valueOf(a.version));
                            }
                        }
                    } else if (23 == this.cvz) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            ab.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                        } else {
                            bic = (bic) linkedList.get(0);
                            ab.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + bic + "|id = " + bic.ndE + "|Name = " + bic.Name + "|PackName = " + bic.PackName + "|Size = " + bic.jCo + "|Version = " + bic.Version);
                            cv = r.aix().cv(bic.ndE, this.cvz);
                            a = a(bic);
                            a.bJt = -1;
                            if (cv == null) {
                                r.aix().a(a);
                            } else if (cv.version < a.version) {
                                r.aix().b(a);
                            }
                        }
                    } else if (this.cvz == 26) {
                        af(linkedList);
                    } else if (this.cvz == 36) {
                        ag(linkedList);
                    } else if (this.cvz == 37) {
                        o(linkedList);
                    }
                }
            }
            tu tuVar = new tu();
            tuVar.cPV.cPW = linkedList;
            tuVar.cPV.cvz = this.cvz;
            com.tencent.mm.sdk.b.a.xxA.m(tuVar);
            if (alx.vQe <= 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(78462);
                return;
            } else if (a(this.ftf, this.ehi) == -1) {
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(78462);
                return;
            } else {
                AppMethodBeat.o(78462);
                return;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78462);
    }

    public final boolean b(m mVar) {
        if ((mVar instanceof k) && this.cvz == ((k) mVar).cvz) {
            return false;
        }
        return true;
    }

    private void g(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78463);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            AppMethodBeat.o(78463);
            return;
        }
        r.aix();
        String aiu = n.aiu();
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            m cv = r.aix().cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                com.tencent.mm.a.e.deleteFile(aiu + r.aix().cx(bic.ndE, this.cvz));
                m a = a(bic);
                a.bJt = -1;
                if (cv == null) {
                    r.aix().a(a);
                } else {
                    r.aix().b(a);
                }
                g.RO().eJo.a(new j(a.id, 9), 0);
            }
            if (aa.a(bic.vFG) != null) {
                ab.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(aa.a(bic.vFG)))));
            }
            if (aa.a(bic.wLt) != null) {
                ab.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(aa.a(bic.wLt)))));
            }
            ab.v("MicroMsg.NetSceneGetPackageList", "xml3:" + bic.toString());
            ab.v("MicroMsg.NetSceneGetPackageList", "xml4:" + bic.Name);
            ab.v("MicroMsg.NetSceneGetPackageList", "xml5:" + bic.PackName);
        }
        AppMethodBeat.o(78463);
    }

    private void h(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78464);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            AppMethodBeat.o(78464);
            return;
        }
        r.aix();
        String aiu = n.aiu();
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            m cv = r.aix().cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                boolean a;
                com.tencent.mm.a.e.deleteFile(aiu + r.aix().cx(bic.ndE, this.cvz));
                m a2 = a(bic);
                a2.bJt = -1;
                if (cv == null) {
                    a = r.aix().a(a2);
                } else {
                    a = r.aix().b(a2);
                }
                ab.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", Boolean.valueOf(a), a2);
            }
            byte[] a3 = aa.a(bic.vFG);
            if (a3 != null && a3.length > 0) {
                r.aix();
                String cw = n.cw(bic.ndE, this.cvz);
                com.tencent.mm.a.e.deleteFile(aiu + cw);
                if (com.tencent.mm.a.e.b(aiu, cw, a3) < 0) {
                    ab.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
                }
            }
        }
        AppMethodBeat.o(78464);
    }

    @Deprecated
    private void i(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78465);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.o(78465);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                bic bic = (bic) linkedList.get(i2);
                m cv = r.aix().cv(bic.ndE, this.cvz);
                m a = a(bic);
                a.bJt = -1;
                if (cv == null) {
                    r.aix().a(a);
                } else {
                    r.aix().b(a);
                }
                byte[] a2 = aa.a(bic.vFG);
                if (a2 != null && a2.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new String(a2));
                    arrayList.size();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(78465);
                return;
            }
        }
    }

    private void j(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78466);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.o(78466);
            return;
        }
        ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        r.aix();
        String aiu = n.aiu();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                bic bic = (bic) linkedList.get(i2);
                m cv = r.aix().cv(bic.ndE, this.cvz);
                byte[] a = aa.a(bic.vFG);
                if (bic.vFG == null) {
                    ab.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
                } else {
                    if (cv == null || cv.version != bic.Version) {
                        String str = new String(a);
                        String str2 = "zh_CN";
                        if (str.indexOf(str2) < 0) {
                            str2 = "en";
                            if (str.indexOf(str2) < 0) {
                                str2 = "zh_TW";
                                if (str.indexOf(str2) < 0) {
                                    str2 = "en";
                                }
                            }
                        }
                        str = str2 + "_ARTIST.mm";
                        com.tencent.mm.a.e.deleteFile(aiu + str);
                        com.tencent.mm.a.e.deleteFile(aiu + str2 + "_ARTISTF.mm");
                        com.tencent.mm.a.e.b(aiu, str, a);
                    }
                    m a2 = a(bic);
                    a2.bJt = -1;
                    if (cv == null) {
                        r.aix().a(a2);
                    } else {
                        r.aix().b(a2);
                    }
                    ab.d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(78466);
                return;
            }
        }
    }

    private void k(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78467);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            AppMethodBeat.o(78467);
            return;
        }
        ab.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            m cv = r.aix().cv(bic.ndE, this.cvz);
            m a = a(bic);
            a.bJt = -1;
            if (cv == null) {
                r.aix().a(a);
            } else {
                r.aix().b(a);
            }
            ab.d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
            byte[] a2 = aa.a(bic.vFG);
            ab.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String(a2))));
            c Nv = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nv();
            int i2 = bic.ndE;
            File file = new File(c.evW);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(c.iY(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.tencent.mm.a.e.b(c.iY(i2), a2, a2.length);
                Nv.o(i2, new String(a2));
            } catch (Exception e) {
                ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
            }
        }
        AppMethodBeat.o(78467);
    }

    private void l(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78468);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            AppMethodBeat.o(78468);
            return;
        }
        ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            m cv = r.aix().cv(bic.ndE, this.cvz);
            m a = a(bic);
            a.bJt = -1;
            if (cv == null) {
                r.aix().a(a);
            } else {
                r.aix().b(a);
            }
            ab.d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
        }
        AppMethodBeat.o(78468);
    }

    private void m(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78469);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            AppMethodBeat.o(78469);
            return;
        }
        ab.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            m cv = r.aix().cv(bic.ndE, this.cvz);
            m a = a(bic);
            a.bJt = -1;
            if (cv == null) {
                r.aix().a(a);
            } else {
                r.aix().b(a);
            }
            g.RO().eJo.a(new j(a.id, 12), 0);
        }
        AppMethodBeat.o(78469);
    }

    private void ae(List<bic> list) {
        AppMethodBeat.i(78470);
        if (list == null || list.size() <= 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            AppMethodBeat.o(78470);
            return;
        }
        r.aix();
        String aiu = n.aiu();
        for (int i = 0; i < list.size(); i++) {
            bic bic = (bic) list.get(i);
            m cv = r.aix().cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                com.tencent.mm.a.e.deleteFile(aiu + r.aix().cx(bic.ndE, this.cvz));
                m a = a(bic);
                a.bJt = -1;
                if (cv == null) {
                    r.aix().a(a);
                } else {
                    r.aix().b(a);
                }
                g.RO().eJo.a(new j(a.id, 19), 0);
            }
            ab.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", bic.Name, bic.PackName);
        }
        AppMethodBeat.o(78470);
    }

    private void af(List<bic> list) {
        AppMethodBeat.i(78471);
        if (list == null || list.size() == 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            AppMethodBeat.o(78471);
            return;
        }
        ab.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(-1))).intValue();
        ab.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue == -1) {
            AppMethodBeat.o(78471);
            return;
        }
        m cv = r.aix().cv(intValue, this.cvz);
        for (bic a : list) {
            m a2 = a(a);
            ab.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.id), Integer.valueOf(a2.version));
            if (cv != null && a2.id == intValue) {
                ab.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                r.aix().b(a2);
                AppMethodBeat.o(78471);
                return;
            } else if (cv == null && a2.id == intValue) {
                ab.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                r.aix().a(a2);
                AppMethodBeat.o(78471);
                return;
            }
        }
        AppMethodBeat.o(78471);
    }

    private void ag(List<bic> list) {
        AppMethodBeat.i(78472);
        if (list == null || list.size() == 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            AppMethodBeat.o(78472);
            return;
        }
        ab.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (bic bic : list) {
            m cv = r.aix().cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                m a = a(bic);
                a.bJt = -1;
                if (cv == null) {
                    r.aix().a(a);
                } else {
                    r.aix().b(a);
                }
                g.RO().eJo.a(new j(a.id, 36), 0);
            }
        }
        AppMethodBeat.o(78472);
    }

    private void n(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78473);
        ab.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            AppMethodBeat.o(78473);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            ab.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", bic.toString());
            m cv = r.aix().cv(bic.ndE, this.cvz);
            m a = a(bic);
            a.bJt = -1;
            if (cv == null) {
                r.aix().a(a);
            } else {
                r.aix().b(a);
            }
        }
        AppMethodBeat.o(78473);
    }

    private void o(LinkedList<bic> linkedList) {
        AppMethodBeat.i(78474);
        ab.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            ab.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            AppMethodBeat.o(78474);
            return;
        }
        ab.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            m cv = r.aix().cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                m a = a(bic);
                a.bJt = -1;
                if (cv == null) {
                    r.aix().a(a);
                } else {
                    r.aix().b(a);
                }
                g.RO().eJo.a(new j(a.id, 37), 0);
            }
        }
        AppMethodBeat.o(78474);
    }

    public final int getType() {
        return JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    public final int acR() {
        return this.cvz;
    }
}
