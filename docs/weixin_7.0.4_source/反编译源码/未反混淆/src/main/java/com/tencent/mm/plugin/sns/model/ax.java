package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class ax {
    private static final Pattern gIU = Pattern.compile("(\n){3,}");
    public int aPA;
    public baa cNJ;
    private String ecX;
    int qFX;
    int qFY;
    List<h> qNF;
    String qNG;
    String qNH;
    LinkedList<cco> qNI;
    LinkedList<Long> qNJ;
    public TimeLineObject qNK = e.ajM();
    public bav qNL = new bav();
    n qNM = new n();
    cbf qNN = null;
    av qNO;
    public cfg qNP;
    public cvi qNQ;
    private boolean qNR;

    public ax(int i) {
        AppMethodBeat.i(36714);
        av avVar = new av();
        avVar.vCy = new at();
        avVar.vCA = new dj();
        avVar.vCB = new du();
        this.qNO = avVar;
        this.qNP = new cfg();
        this.cNJ = new baa();
        this.qNQ = null;
        this.ecX = "";
        this.qNR = false;
        this.ecX = af.cnk();
        this.aPA = i;
        this.qNK.xfI.wbJ = i;
        ab.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(i)));
        this.qNK.wEJ = 0;
        this.qNK.jBB = this.ecX;
        this.qNL.ptv = g.x((af.cnk() + bo.yz() + System.currentTimeMillis()).getBytes());
        this.qNL.wFd = 0;
        this.qNL.wFe = 0;
        this.qNL.wEJ = 0;
        this.qNL.wFh = 0;
        this.qNL.eRu = 0;
        this.qNL.wFj = 0;
        this.qNL.wFl = 0;
        cbf cbf = new cbf();
        cbf.vQE = 0;
        cbf.pcX = 0;
        cbf.xan = 0;
        cbf.vHl = af.cnk();
        cbf.xaq = new LinkedList();
        cbf.xao = 0;
        cbf.xap = 0;
        cbf.xaw = new LinkedList();
        cbf.xau = 0;
        cbf.xav = 0;
        cbf.xat = new LinkedList();
        cbf.xar = 0;
        cbf.xas = 0;
        cbf.wGz = 1;
        cbf.xan = 0;
        cbf.xax = 0;
        cbf.xam = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.qNN = cbf;
        n nVar = this.qNM;
        nVar.field_localFlag |= 16;
        this.qNM.ls((int) (System.currentTimeMillis() / 1000));
        this.qNM.field_type = i;
        this.qNM.field_userName = this.ecX;
        this.qNM.field_pravited = 0;
        this.qNM.field_stringSeq = "0000099999999999999999999";
        this.qNM.DF(2);
        this.qNM.cqR();
        if (i == 1 || i == 2) {
            this.qNM.DF(4);
        }
        if (i == 7) {
            this.qNM.DJ(2);
        }
        this.qNJ = new LinkedList();
        this.qNL.wFk = this.qNJ;
        Iterator it = this.qNJ.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            cba cba = new cba();
            cba.xak = longValue;
            this.qNN.vFk.add(cba);
        }
        this.qNN.wHG = this.qNJ.size();
        AppMethodBeat.o(36714);
    }

    static {
        AppMethodBeat.i(36740);
        AppMethodBeat.o(36740);
    }

    private static String Yl(String str) {
        String str2;
        AppMethodBeat.i(36715);
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                ab.e("MicroMsg.UploadPackHelper", "filter desc error ");
                AppMethodBeat.o(36715);
                return str2;
            }
        }
        str2 = str;
        try {
            str2 = gIU.matcher(str2.trim().replace(IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX)).replaceAll("\n\n");
            AppMethodBeat.o(36715);
        } catch (Exception e2) {
            ab.e("MicroMsg.UploadPackHelper", "filter desc error ");
            AppMethodBeat.o(36715);
            return str2;
        }
        return str2;
    }

    public final ax Ym(String str) {
        AppMethodBeat.i(36716);
        this.qNG = Yl(str);
        this.qNK.xfF = this.qNG;
        AppMethodBeat.o(36716);
        return this;
    }

    public final ax gc(String str, String str2) {
        this.qNL.token = str;
        this.qNL.wFn = str2;
        return this;
    }

    public final ax Dd(int i) {
        this.qNK.xfK = 1;
        this.qNK.xfL = i;
        return this;
    }

    public final ax Yn(String str) {
        this.qNK.xfM = str;
        this.qNO.vCy.vCs = str;
        return this;
    }

    public final ax Yo(String str) {
        this.qNK.rCK = str;
        return this;
    }

    public final ax af(String str, String str2, String str3) {
        AppMethodBeat.i(36717);
        at atVar = this.qNO.vCy;
        if (bo.isNullOrNil(str)) {
            str = "";
        }
        atVar.fKh = str;
        atVar = this.qNO.vCy;
        if (bo.isNullOrNil(str2)) {
            str2 = "";
        }
        atVar.vCt = str2;
        atVar = this.qNO.vCy;
        if (bo.isNullOrNil(str3)) {
            str3 = "";
        }
        atVar.vCu = str3;
        AppMethodBeat.o(36717);
        return this;
    }

    public final ax Yp(String str) {
        this.qNH = str;
        this.qNK.xfI.Desc = str;
        return this;
    }

    public final ax Yq(String str) {
        this.qNK.xfI.Url = str;
        return this;
    }

    public final ax Yr(String str) {
        this.qNK.xfI.Title = str;
        return this;
    }

    public final void De(int i) {
        AppMethodBeat.i(36718);
        ab.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(i)));
        this.qNL.wFj = i;
        AppMethodBeat.o(36718);
    }

    public final ax a(ayt ayt) {
        if (ayt != null) {
            this.qNK.xfG = ayt;
        }
        return this;
    }

    public final ax Df(int i) {
        AppMethodBeat.i(36719);
        this.qFY = i;
        this.qNL.wEJ = i;
        this.qNK.wEJ = i;
        if (i > 0) {
            this.qNM.field_pravited = i;
            this.qNM.cqO();
            this.qNM.DJ(2);
            this.qNM.cqS();
        }
        AppMethodBeat.o(36719);
        return this;
    }

    public final ax Dg(int i) {
        this.qFX = i;
        this.qNL.wFe = i;
        return this;
    }

    public final ax ar(LinkedList<cco> linkedList) {
        AppMethodBeat.i(36720);
        this.qNI = linkedList;
        this.qNL.wFg = linkedList;
        Iterator it = this.qNI.iterator();
        while (it.hasNext()) {
            cco cco = (cco) it.next();
            cat cat = new cat();
            cat.vHl = cco.jBB;
            this.qNN.xaw.add(cat);
        }
        this.qNN.xau = this.qNI.size();
        this.qNN.xav = this.qNI.size();
        AppMethodBeat.o(36720);
        return this;
    }

    public final ax Dh(int i) {
        this.qNL.wFl = i;
        return this;
    }

    public final ax Ys(String str) {
        AppMethodBeat.i(36721);
        ds dsVar = this.qNK.xfH;
        if (dsVar == null) {
            dsVar = new ds();
        }
        dsVar.Id = str;
        this.qNK.xfH = dsVar;
        AppMethodBeat.o(36721);
        return this;
    }

    public final ax Yt(String str) {
        AppMethodBeat.i(36722);
        ds dsVar = this.qNK.xfH;
        if (dsVar == null) {
            dsVar = new ds();
        }
        dsVar.ncH = str;
        this.qNK.xfH = dsVar;
        AppMethodBeat.o(36722);
        return this;
    }

    public final ax Yu(String str) {
        AppMethodBeat.i(36723);
        this.qNK.ijx = bo.nullAsNil(str);
        AppMethodBeat.o(36723);
        return this;
    }

    public final ax Yv(String str) {
        AppMethodBeat.i(36724);
        this.qNK.vjM = bo.nullAsNil(str);
        AppMethodBeat.o(36724);
        return this;
    }

    public final ax dg(List<String> list) {
        AppMethodBeat.i(36725);
        if (list == null || list.size() == 0) {
            this.qNN.wGz = 1;
            AppMethodBeat.o(36725);
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bts bts = new bts();
                bts.alV(str);
                linkedList.add(bts);
            }
            this.qNL.wFp = linkedList;
            if (this.qNN.wGz == 3) {
                this.qNN.xaB = linkedList;
                this.qNN.xaA = linkedList.size();
            } else if (this.qNN.wGz == 5) {
                this.qNN.wFp = linkedList;
                this.qNN.xaC = linkedList.size();
            }
            AppMethodBeat.o(36725);
        }
        return this;
    }

    public final ax Di(int i) {
        if (i == 1) {
            this.qNN.wGz = 3;
        } else if (i == 0) {
            this.qNN.wGz = 5;
        }
        this.qNL.wFo = i;
        return this;
    }

    private static bau A(String str, byte[] bArr) {
        AppMethodBeat.i(36726);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Mq() + " attachBuf is null");
            AppMethodBeat.o(36726);
            return null;
        }
        String str2 = af.getAccSnsTmpPath() + g.x((" " + System.currentTimeMillis()).getBytes());
        com.tencent.mm.vfs.e.tf(af.getAccSnsTmpPath());
        ab.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Mq() + " buildUploadAttachInfo file:" + str2);
        if (com.tencent.mm.vfs.e.b(str2, bArr, bArr.length) < 0) {
            ab.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Mq() + " writeFile error file:" + str2);
            AppMethodBeat.o(36726);
            return null;
        }
        bau gd = gd(str, str2);
        AppMethodBeat.o(36726);
        return gd;
    }

    public static bau c(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(36727);
        bau ajN = e.ajN();
        ajN.Id = str;
        ab.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", Integer.valueOf(6), str2, str4, str5, str6);
        ajN.jCt = 6;
        if (com.tencent.mm.vfs.e.asZ(str2) <= 0) {
            AppMethodBeat.o(36727);
            return null;
        }
        baw baw;
        h hVar = new h(str2, 6);
        hVar.qGb = str4;
        hVar = af.cnu().a(hVar, str2, str3, str5, str6);
        if (hVar.height <= 0 || hVar.width <= 0 || hVar.fileSize <= 0) {
            baw = null;
        } else {
            baw = new baw();
            baw.wFy = (float) hVar.height;
            baw.wFx = (float) hVar.width;
            baw.wFz = (float) hVar.fileSize;
        }
        ajN.Id = "Locall_path" + hVar.cNE;
        ajN.wEK = baw;
        ajN.cNE = hVar.cNE;
        AppMethodBeat.o(36727);
        return ajN;
    }

    private static bau gd(String str, String str2) {
        baw baw = null;
        AppMethodBeat.i(36728);
        bau ajN = e.ajN();
        ajN.Id = str;
        ab.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        ajN.jCt = 2;
        if (com.tencent.mm.vfs.e.asZ(str2) <= 0) {
            AppMethodBeat.o(36728);
            return null;
        }
        String str3 = af.getAccSnsTmpPath() + g.x((str2 + System.currentTimeMillis()).getBytes());
        com.tencent.mm.vfs.e.y(str2, str3);
        h hVar = new h(str3, 2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(hVar);
        List dn = af.cnu().dn(linkedList);
        if (dn == null || dn.size() == 0) {
            AppMethodBeat.o(36728);
            return null;
        }
        h hVar2 = (h) dn.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            baw = new baw();
            baw.wFy = (float) hVar2.height;
            baw.wFx = (float) hVar2.width;
            baw.wFz = (float) hVar2.fileSize;
        }
        ajN.Id = "Locall_path" + hVar2.cNE;
        ajN.wEK = baw;
        ajN.cNE = hVar2.cNE;
        AppMethodBeat.o(36728);
        return ajN;
    }

    public static bau ag(String str, String str2, String str3) {
        AppMethodBeat.i(36729);
        bau ajN = e.ajN();
        ajN.Id = str;
        ab.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        ajN.jCt = 2;
        ajN.Url = str2;
        ajN.wEG = 0;
        ajN.wEH = str3;
        ajN.wEI = 0;
        ajN.wEN = 1;
        AppMethodBeat.o(36729);
        return ajN;
    }

    public final boolean t(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(36730);
        String str5 = af.getAccSnsTmpPath() + g.x(str.getBytes());
        Yw(str5);
        com.tencent.mm.vfs.e.y(str, str5);
        String str6 = af.getAccSnsTmpPath() + g.x(str2.getBytes());
        com.tencent.mm.vfs.e.y(str2, str6);
        bau c = c("", str5, str6, str4, "", "");
        if (c == null) {
            ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.o(36730);
            return false;
        }
        c.Desc = str3;
        if (bo.isNullOrNil(c.Title)) {
            c.Title = str3;
        }
        this.qNK.xfI.wbK.add(c);
        ayq ayq = new ayq();
        ayq.wCt = c.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.o(36730);
        return true;
    }

    public static void Yw(String str) {
        AppMethodBeat.i(36731);
        com.tencent.mm.vfs.e.tf(com.tencent.mm.vfs.e.atb(str));
        AppMethodBeat.o(36731);
    }

    public final boolean ge(String str, String str2) {
        AppMethodBeat.i(36732);
        String str3 = af.getAccSnsTmpPath() + g.x(str.getBytes());
        Yw(str3);
        com.tencent.mm.vfs.e.y(str, str3);
        bau gd = gd("", str3);
        if (gd == null) {
            ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.o(36732);
            return false;
        }
        gd.Desc = str2;
        if (bo.isNullOrNil(gd.Title)) {
            gd.Title = str2;
        }
        this.qNK.xfI.wbK.add(gd);
        ayq ayq = new ayq();
        ayq.wCt = gd.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.o(36732);
        return true;
    }

    @Deprecated
    public final boolean b(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.i(36733);
        bau ag = ag("", str, str2);
        if (ag == null) {
            ab.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            AppMethodBeat.o(36733);
            return false;
        }
        ag.Desc = str3;
        if (i > 0) {
            ag.cuu = i;
        }
        if (!bo.isNullOrNil(str4)) {
            ag.rik = str4;
        }
        this.qNK.xfI.wbK.add(ag);
        AppMethodBeat.o(36733);
        return true;
    }

    public final boolean b(byte[] bArr, String str, String str2) {
        AppMethodBeat.i(36734);
        boolean a = a(bArr, str, str2, -1, "");
        AppMethodBeat.o(36734);
        return a;
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        AppMethodBeat.i(36735);
        bau A = A("", bArr);
        if (A == null) {
            ab.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            AppMethodBeat.o(36735);
            return false;
        }
        A.Desc = str;
        if (i > 0) {
            A.cuu = i;
        }
        if (!bo.isNullOrNil(str3)) {
            A.rik = str3;
        }
        if (!bo.isNullOrNil(str2)) {
            A.Title = str2;
        }
        if (!bo.isNullOrNil(str)) {
            A.Desc = str;
        }
        this.qNK.xfI.wbK.add(A);
        ayq ayq = new ayq();
        ayq.wCt = A.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.o(36735);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.i(36736);
        bau A = A("", bArr);
        if (A == null || (bo.isNullOrNil(str2) && bo.isNullOrNil(str3))) {
            ab.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            AppMethodBeat.o(36736);
            return false;
        }
        if (!bo.isNullOrNil(str)) {
            this.qNK.xfI.Url = str;
        }
        if (!bo.isNullOrNil(str3)) {
            A.Url = str3;
            A.wEG = 0;
        } else if (!bo.isNullOrNil(str2)) {
            A.Url = str2;
            A.wEG = 0;
        }
        if (!bo.isNullOrNil(str2)) {
            A.wEL = str2;
            A.wEM = 0;
        }
        A.jCt = i;
        A.Title = bo.bc(str4, "");
        A.Desc = bo.bc(str5, "");
        this.qNK.xfI.wbK.add(A);
        ayq ayq = new ayq();
        ayq.wCt = A.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.o(36736);
        return true;
    }

    public final void dh(List<h> list) {
        AppMethodBeat.i(36737);
        this.qNF = list;
        List<h> dn = af.cnu().dn(this.qNF);
        LinkedList linkedList = new LinkedList();
        if (dn == null) {
            AppMethodBeat.o(36737);
            return;
        }
        for (h hVar : dn) {
            ayq ayq = new ayq();
            ayq.wCt = hVar.cNE;
            linkedList.add(ayq);
        }
        this.qNL.wFf = linkedList;
        for (h hVar2 : dn) {
            baw baw = new baw();
            baw.wFy = 0.0f;
            baw.wFx = 0.0f;
            baw.wFz = 0.0f;
            if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                baw.wFy = (float) hVar2.height;
                baw.wFx = (float) hVar2.width;
                baw.wFz = (float) hVar2.fileSize;
            }
            this.qNK.xfI.wbK.add(e.a("Locall_path" + hVar2.cNE, hVar2.type, "", "", 0, 0, this.qFY, "", baw));
        }
        AppMethodBeat.o(36737);
    }

    public final void g(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(36738);
        cbp cbp = new cbp();
        cbp.vFJ = str;
        cbp.vFK = str2;
        cbp.vFL = str3;
        cbp.rnf = i;
        cbp.rng = i2;
        this.qNL.wFq = cbp;
        AppMethodBeat.o(36738);
    }

    public final void setSessionId(String str) {
        this.qNL.cvF = str;
    }

    public final int commit() {
        AppMethodBeat.i(36739);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qNL.wFi = System.currentTimeMillis();
            this.qNL.eRu = 0;
            this.qNM.bi(this.qNN.toByteArray());
            this.qNM.field_postBuf = this.qNL.toByteArray();
            ab.d("MicroMsg.UploadPackHelper", "snsObj " + this.qNN.toString());
            ab.d("MicroMsg.UploadPackHelper", "postinfo " + this.qNL.toString());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        ab.d("MicroMsg.UploadPackHelper", "timelineObj " + this.qNK.toString());
        if (this.qNK.xfI.wbK != null) {
            ab.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", Integer.valueOf(this.qNK.xfI.wbK.size()));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.qNK.xfI.wbK.size()) {
                    break;
                }
                if (((bau) this.qNK.xfI.wbK.get(i2)) != null) {
                    ab.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", Integer.valueOf(((bau) this.qNK.xfI.wbK.get(i2)).cNE), bo.bc(((bau) this.qNK.xfI.wbK.get(i2)).Url, ""));
                }
                i = i2 + 1;
            }
        }
        if (this.qNO != null) {
            this.qNK.qNO = this.qNO;
        }
        if (this.qNQ != null) {
            this.qNK.qNQ = this.qNQ;
        }
        this.qNM.c(this.qNK);
        int A = af.cnF().A(this.qNM);
        Iterator it = this.qNL.wFf.iterator();
        int i3 = 0;
        String str = null;
        while (it.hasNext()) {
            ayq ayq = (ayq) it.next();
            r kE = af.cnu().kE((long) ayq.wCt);
            try {
                bax bax = (bax) new bax().parseFrom(kE.rfI);
                if (this.qNK.xfH != null) {
                    bax.csB = this.qNK.xfH.Id;
                }
                if (this.cNJ != null) {
                    this.cNJ.wDQ = 0;
                }
                bax.wFH = this.cNJ;
                bax.aPA = this.qNK.xfI.wbJ;
                if (bax.aPA == 1 || bax.aPA == 15) {
                    int i4;
                    bax bax2;
                    if (!bo.isNullOrNil(bax.csB)) {
                        i4 = 5;
                        bax2 = bax;
                    } else if (bax.wFH != null && bax.aPA == 15) {
                        if (bax.wFH.wDP) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        bax.wFI = i4;
                    } else if (((h) this.qNF.get(i3)).qGc) {
                        i4 = 1;
                        bax2 = bax;
                    } else {
                        i4 = 2;
                        bax2 = bax;
                    }
                    bax2.wFI = i4;
                }
                kE.rfI = bax.toByteArray();
                af.cnu().a(ayq.wCt, kE);
                i3++;
                str = bax.cvZ;
            } catch (Exception e2) {
                ab.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        ab.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", Integer.valueOf(A), Integer.valueOf(this.qNM.field_type), str);
        if (A > 0 && this.qNM.field_type == 15) {
            aq.gb(v.ao("sns_table_", (long) A), str);
        }
        ab.d("MicroMsg.UploadPackHelper", "pack commit result " + A + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(36739);
        return A;
    }
}
