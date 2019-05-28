package com.tencent.p177mm.p707ba;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C18333mn;
import com.tencent.p177mm.p230g.p231a.C32648tu;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.alw;
import com.tencent.p177mm.protocal.protobuf.alx;
import com.tencent.p177mm.protocal.protobuf.bic;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ba.k */
public final class C45181k extends C1207m implements C17895o, C1918k {
    private int cvz;
    private C7472b ehh;
    private C1202f ehi;
    private boolean fMo;
    private int flags;

    public C45181k(boolean z) {
        AppMethodBeat.m2504i(78458);
        this.fMo = false;
        this.flags = -1;
        this.cvz = 26;
        this.fMo = false;
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
        C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
        AppMethodBeat.m2505o(78458);
    }

    public C45181k(int i) {
        AppMethodBeat.m2504i(78459);
        this.fMo = false;
        this.flags = -1;
        this.cvz = i;
        this.fMo = false;
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(78459);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78460);
        this.ehi = c1202f;
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.cvz);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alw();
        c1196a.fsK = new alx();
        c1196a.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        c1196a.fsI = JsApiGetBackgroundAudioState.CTRL_INDEX;
        c1196a.fsL = 51;
        c1196a.fsM = 1000000051;
        this.ehh = c1196a.acD();
        alw alw = (alw) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        if (C1720g.m3534RN().mo5161QY()) {
            C25854m[] lU = C41787r.aix().mo20547lU(this.cvz);
            if (lU != null && lU.length > 0) {
                for (int i = 0; i < lU.length; i++) {
                    bic bic = new bic();
                    bic.ndE = lU[i].f13661id;
                    if (C1947ae.gip && this.cvz == 7) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                        bic.Version = 0;
                    } else {
                        bic.Version = lU[i].version;
                    }
                    C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(bic.ndE), Integer.valueOf(bic.Version));
                    linkedList.add(bic);
                }
            }
            alw.jBw = linkedList;
            alw.jBv = linkedList.size();
            alw.jCt = this.cvz;
            if (this.flags != -1) {
                alw.vEq = this.flags;
            }
            int a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(78460);
            return a;
        }
        AppMethodBeat.m2505o(78460);
        return -1;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    public final boolean acI() {
        return true;
    }

    /* renamed from: a */
    private C25854m m83216a(bic bic) {
        AppMethodBeat.m2504i(78461);
        C25854m c25854m = new C25854m();
        c25854m.f13661id = bic.ndE;
        c25854m.version = bic.Version;
        c25854m.name = bic.Name;
        c25854m.size = bic.jCo;
        c25854m.fMt = bic.PackName;
        c25854m.status = 5;
        c25854m.cBc = this.cvz;
        AppMethodBeat.m2505o(78461);
        return c25854m;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78462);
        C4990ab.m7417i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.cvz), str);
        if (i2 == 0 || i3 == 0) {
            alx alx = (alx) ((C7472b) c1929q).fsH.fsP;
            if (alx.jCt != this.cvz) {
                C4990ab.m7413e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(alx.jCt));
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(78462);
                return;
            }
            LinkedList linkedList = alx.jBw;
            C4990ab.m7416i("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.cvz + " resp.Type: " + alx.jCt);
            bic bic;
            C25854m cv;
            C25854m a;
            if (this.cvz == 2) {
                m83222i(linkedList);
            } else if (this.cvz == 1) {
                m83221h(linkedList);
            } else if (this.cvz == 4) {
                m83223j(linkedList);
            } else if (this.cvz == 6) {
                C4990ab.m7416i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.cvz == 7) {
                m83224k(linkedList);
            } else if (this.cvz == 9) {
                m83220g(linkedList);
            } else if (this.cvz == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    bic = (bic) linkedList.get(0);
                    cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                    a = m83216a(bic);
                    a.bJt = -1;
                    if (cv == null) {
                        C41787r.aix().mo20538a(a);
                    } else {
                        C41787r.aix().mo20540b(a);
                    }
                }
            } else if (this.cvz != 11) {
                if (this.cvz == 12) {
                    m83226m(linkedList);
                } else if (this.cvz == 5) {
                    m83227n(linkedList);
                } else if (this.cvz == 20) {
                    m83225l(linkedList);
                } else if (this.cvz == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        bic = (bic) linkedList.get(0);
                        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
                        cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                        C25854m a2 = m83216a(bic);
                        a2.bJt = -1;
                        if (cv == null) {
                            C41787r.aix().mo20538a(a2);
                        } else {
                            C41787r.aix().mo20540b(a2);
                        }
                        C4883b c18333mn = new C18333mn();
                        try {
                            c18333mn.cIq.content = C1946aa.m4150a(bic.vFG);
                            if (c18333mn.cIq.content != null) {
                                C4879a.xxA.mo10048a(c18333mn, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.cvz != 18) {
                    if (this.cvz == 19) {
                        m83217ae(linkedList);
                    } else if (this.cvz == 21) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                        } else {
                            bic = (bic) linkedList.get(0);
                            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + bic + "|id = " + bic.ndE + "|Name = " + bic.Name + "|PackName = " + bic.PackName + "|Size = " + bic.jCo + "|Version = " + bic.Version);
                            cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                            a = m83216a(bic);
                            a.bJt = -1;
                            if (cv == null) {
                                C41787r.aix().mo20538a(a);
                            } else if (cv.version < a.version) {
                                C41787r.aix().mo20540b(a);
                            } else {
                                C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(cv.version), Integer.valueOf(a.version));
                            }
                        }
                    } else if (23 == this.cvz) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                        } else {
                            bic = (bic) linkedList.get(0);
                            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + bic + "|id = " + bic.ndE + "|Name = " + bic.Name + "|PackName = " + bic.PackName + "|Size = " + bic.jCo + "|Version = " + bic.Version);
                            cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                            a = m83216a(bic);
                            a.bJt = -1;
                            if (cv == null) {
                                C41787r.aix().mo20538a(a);
                            } else if (cv.version < a.version) {
                                C41787r.aix().mo20540b(a);
                            }
                        }
                    } else if (this.cvz == 26) {
                        m83218af(linkedList);
                    } else if (this.cvz == 36) {
                        m83219ag(linkedList);
                    } else if (this.cvz == 37) {
                        m83228o(linkedList);
                    }
                }
            }
            C32648tu c32648tu = new C32648tu();
            c32648tu.cPV.cPW = linkedList;
            c32648tu.cPV.cvz = this.cvz;
            C4879a.xxA.mo10055m(c32648tu);
            if (alx.vQe <= 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(78462);
                return;
            } else if (mo4456a(this.ftf, this.ehi) == -1) {
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.m2505o(78462);
                return;
            } else {
                AppMethodBeat.m2505o(78462);
                return;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78462);
    }

    /* renamed from: b */
    public final boolean mo4469b(C1207m c1207m) {
        if ((c1207m instanceof C45181k) && this.cvz == ((C45181k) c1207m).cvz) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private void m83220g(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78463);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            AppMethodBeat.m2505o(78463);
            return;
        }
        C41787r.aix();
        String aiu = C9067n.aiu();
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                C1173e.deleteFile(aiu + C41787r.aix().mo20542cx(bic.ndE, this.cvz));
                C25854m a = m83216a(bic);
                a.bJt = -1;
                if (cv == null) {
                    C41787r.aix().mo20538a(a);
                } else {
                    C41787r.aix().mo20540b(a);
                }
                C1720g.m3535RO().eJo.mo14541a(new C32329j(a.f13661id, 9), 0);
            }
            if (C1946aa.m4150a(bic.vFG) != null) {
                C4990ab.m7418v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(C1946aa.m4150a(bic.vFG)))));
            }
            if (C1946aa.m4150a(bic.wLt) != null) {
                C4990ab.m7418v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(C1946aa.m4150a(bic.wLt)))));
            }
            C4990ab.m7418v("MicroMsg.NetSceneGetPackageList", "xml3:" + bic.toString());
            C4990ab.m7418v("MicroMsg.NetSceneGetPackageList", "xml4:" + bic.Name);
            C4990ab.m7418v("MicroMsg.NetSceneGetPackageList", "xml5:" + bic.PackName);
        }
        AppMethodBeat.m2505o(78463);
    }

    /* renamed from: h */
    private void m83221h(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78464);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            AppMethodBeat.m2505o(78464);
            return;
        }
        C41787r.aix();
        String aiu = C9067n.aiu();
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                boolean a;
                C1173e.deleteFile(aiu + C41787r.aix().mo20542cx(bic.ndE, this.cvz));
                C25854m a2 = m83216a(bic);
                a2.bJt = -1;
                if (cv == null) {
                    a = C41787r.aix().mo20538a(a2);
                } else {
                    a = C41787r.aix().mo20540b(a2);
                }
                C4990ab.m7417i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", Boolean.valueOf(a), a2);
            }
            byte[] a3 = C1946aa.m4150a(bic.vFG);
            if (a3 != null && a3.length > 0) {
                C41787r.aix();
                String cw = C9067n.m16440cw(bic.ndE, this.cvz);
                C1173e.deleteFile(aiu + cw);
                if (C1173e.m2558b(aiu, cw, a3) < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
                }
            }
        }
        AppMethodBeat.m2505o(78464);
    }

    @Deprecated
    /* renamed from: i */
    private void m83222i(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78465);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.m2505o(78465);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                bic bic = (bic) linkedList.get(i2);
                C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                C25854m a = m83216a(bic);
                a.bJt = -1;
                if (cv == null) {
                    C41787r.aix().mo20538a(a);
                } else {
                    C41787r.aix().mo20540b(a);
                }
                byte[] a2 = C1946aa.m4150a(bic.vFG);
                if (a2 != null && a2.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new String(a2));
                    arrayList.size();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(78465);
                return;
            }
        }
    }

    /* renamed from: j */
    private void m83223j(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78466);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.m2505o(78466);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        C41787r.aix();
        String aiu = C9067n.aiu();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                bic bic = (bic) linkedList.get(i2);
                C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
                byte[] a = C1946aa.m4150a(bic.vFG);
                if (bic.vFG == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
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
                        C1173e.deleteFile(aiu + str);
                        C1173e.deleteFile(aiu + str2 + "_ARTISTF.mm");
                        C1173e.m2558b(aiu, str, a);
                    }
                    C25854m a2 = m83216a(bic);
                    a2.bJt = -1;
                    if (cv == null) {
                        C41787r.aix().mo20538a(a2);
                    } else {
                        C41787r.aix().mo20540b(a2);
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(78466);
                return;
            }
        }
    }

    /* renamed from: k */
    private void m83224k(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78467);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty config list");
            AppMethodBeat.m2505o(78467);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            C25854m a = m83216a(bic);
            a.bJt = -1;
            if (cv == null) {
                C41787r.aix().mo20538a(a);
            } else {
                C41787r.aix().mo20540b(a);
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
            byte[] a2 = C1946aa.m4150a(bic.vFG);
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String(a2))));
            C1763c Nv = ((C7234a) C1720g.m3528K(C7234a.class)).mo15609Nv();
            int i2 = bic.ndE;
            File file = new File(C1763c.evW);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(C1763c.m3628iY(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                C1173e.m2559b(C1763c.m3628iY(i2), a2, a2.length);
                Nv.mo5305o(i2, new String(a2));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(78467);
    }

    /* renamed from: l */
    private void m83225l(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78468);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            AppMethodBeat.m2505o(78468);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            C25854m a = m83216a(bic);
            a.bJt = -1;
            if (cv == null) {
                C41787r.aix().mo20538a(a);
            } else {
                C41787r.aix().mo20540b(a);
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", bic.Name + " - " + bic.ndE + " - " + bic.PackName + " - " + bic.jCo);
        }
        AppMethodBeat.m2505o(78468);
    }

    /* renamed from: m */
    private void m83226m(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78469);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            AppMethodBeat.m2505o(78469);
            return;
        }
        C4990ab.m7416i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            bic bic = (bic) linkedList.get(i);
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            C25854m a = m83216a(bic);
            a.bJt = -1;
            if (cv == null) {
                C41787r.aix().mo20538a(a);
            } else {
                C41787r.aix().mo20540b(a);
            }
            C1720g.m3535RO().eJo.mo14541a(new C32329j(a.f13661id, 12), 0);
        }
        AppMethodBeat.m2505o(78469);
    }

    /* renamed from: ae */
    private void m83217ae(List<bic> list) {
        AppMethodBeat.m2504i(78470);
        if (list == null || list.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            AppMethodBeat.m2505o(78470);
            return;
        }
        C41787r.aix();
        String aiu = C9067n.aiu();
        for (int i = 0; i < list.size(); i++) {
            bic bic = (bic) list.get(i);
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                C1173e.deleteFile(aiu + C41787r.aix().mo20542cx(bic.ndE, this.cvz));
                C25854m a = m83216a(bic);
                a.bJt = -1;
                if (cv == null) {
                    C41787r.aix().mo20538a(a);
                } else {
                    C41787r.aix().mo20540b(a);
                }
                C1720g.m3535RO().eJo.mo14541a(new C32329j(a.f13661id, 19), 0);
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", bic.Name, bic.PackName);
        }
        AppMethodBeat.m2505o(78470);
    }

    /* renamed from: af */
    private void m83218af(List<bic> list) {
        AppMethodBeat.m2504i(78471);
        if (list == null || list.size() == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            AppMethodBeat.m2505o(78471);
            return;
        }
        C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(-1))).intValue();
        C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue == -1) {
            AppMethodBeat.m2505o(78471);
            return;
        }
        C25854m cv = C41787r.aix().mo20541cv(intValue, this.cvz);
        for (bic a : list) {
            C25854m a2 = m83216a(a);
            C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.f13661id), Integer.valueOf(a2.version));
            if (cv != null && a2.f13661id == intValue) {
                C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                C41787r.aix().mo20540b(a2);
                AppMethodBeat.m2505o(78471);
                return;
            } else if (cv == null && a2.f13661id == intValue) {
                C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                C41787r.aix().mo20538a(a2);
                AppMethodBeat.m2505o(78471);
                return;
            }
        }
        AppMethodBeat.m2505o(78471);
    }

    /* renamed from: ag */
    private void m83219ag(List<bic> list) {
        AppMethodBeat.m2504i(78472);
        if (list == null || list.size() == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            AppMethodBeat.m2505o(78472);
            return;
        }
        C4990ab.m7416i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (bic bic : list) {
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                C25854m a = m83216a(bic);
                a.bJt = -1;
                if (cv == null) {
                    C41787r.aix().mo20538a(a);
                } else {
                    C41787r.aix().mo20540b(a);
                }
                C1720g.m3535RO().eJo.mo14541a(new C32329j(a.f13661id, 36), 0);
            }
        }
        AppMethodBeat.m2505o(78472);
    }

    /* renamed from: n */
    private void m83227n(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78473);
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            AppMethodBeat.m2505o(78473);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            C4990ab.m7411d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", bic.toString());
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            C25854m a = m83216a(bic);
            a.bJt = -1;
            if (cv == null) {
                C41787r.aix().mo20538a(a);
            } else {
                C41787r.aix().mo20540b(a);
            }
        }
        AppMethodBeat.m2505o(78473);
    }

    /* renamed from: o */
    private void m83228o(LinkedList<bic> linkedList) {
        AppMethodBeat.m2504i(78474);
        C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            AppMethodBeat.m2505o(78474);
            return;
        }
        C4990ab.m7416i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bic bic = (bic) it.next();
            C25854m cv = C41787r.aix().mo20541cv(bic.ndE, this.cvz);
            if (cv == null || cv.version != bic.Version) {
                C25854m a = m83216a(bic);
                a.bJt = -1;
                if (cv == null) {
                    C41787r.aix().mo20538a(a);
                } else {
                    C41787r.aix().mo20540b(a);
                }
                C1720g.m3535RO().eJo.mo14541a(new C32329j(a.f13661id, 37), 0);
            }
        }
        AppMethodBeat.m2505o(78474);
    }

    public final int getType() {
        return JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    public final int acR() {
        return this.cvz;
    }
}
