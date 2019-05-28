package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.sns.data.C21881h;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C15329dj;
import com.tencent.p177mm.protocal.protobuf.C35904at;
import com.tencent.p177mm.protocal.protobuf.C44113ds;
import com.tencent.p177mm.protocal.protobuf.C44115du;
import com.tencent.p177mm.protocal.protobuf.C7252av;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ayq;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cba;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbp;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.protocal.protobuf.cfg;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.sns.model.ax */
public final class C29054ax {
    private static final Pattern gIU = Pattern.compile("(\n){3,}");
    public int aPA;
    public baa cNJ;
    private String ecX;
    int qFX;
    int qFY;
    List<C21881h> qNF;
    String qNG;
    String qNH;
    LinkedList<cco> qNI;
    LinkedList<Long> qNJ;
    public TimeLineObject qNK = C37953e.ajM();
    public bav qNL = new bav();
    C46236n qNM = new C46236n();
    cbf qNN = null;
    C7252av qNO;
    public cfg qNP;
    public cvi qNQ;
    private boolean qNR;

    public C29054ax(int i) {
        AppMethodBeat.m2504i(36714);
        C7252av c7252av = new C7252av();
        c7252av.vCy = new C35904at();
        c7252av.vCA = new C15329dj();
        c7252av.vCB = new C44115du();
        this.qNO = c7252av;
        this.qNP = new cfg();
        this.cNJ = new baa();
        this.qNQ = null;
        this.ecX = "";
        this.qNR = false;
        this.ecX = C13373af.cnk();
        this.aPA = i;
        this.qNK.xfI.wbJ = i;
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(i)));
        this.qNK.wEJ = 0;
        this.qNK.jBB = this.ecX;
        this.qNL.ptv = C1178g.m2591x((C13373af.cnk() + C5046bo.m7588yz() + System.currentTimeMillis()).getBytes());
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
        cbf.vHl = C13373af.cnk();
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
        C46236n c46236n = this.qNM;
        c46236n.field_localFlag |= 16;
        this.qNM.mo74294ls((int) (System.currentTimeMillis() / 1000));
        this.qNM.field_type = i;
        this.qNM.field_userName = this.ecX;
        this.qNM.field_pravited = 0;
        this.qNM.field_stringSeq = "0000099999999999999999999";
        this.qNM.mo74252DF(2);
        this.qNM.cqR();
        if (i == 1 || i == 2) {
            this.qNM.mo74252DF(4);
        }
        if (i == 7) {
            this.qNM.mo74254DJ(2);
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
        AppMethodBeat.m2505o(36714);
    }

    static {
        AppMethodBeat.m2504i(36740);
        AppMethodBeat.m2505o(36740);
    }

    /* renamed from: Yl */
    private static String m46158Yl(String str) {
        String str2;
        AppMethodBeat.m2504i(36715);
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                C4990ab.m7412e("MicroMsg.UploadPackHelper", "filter desc error ");
                AppMethodBeat.m2505o(36715);
                return str2;
            }
        }
        str2 = str;
        try {
            str2 = gIU.matcher(str2.trim().replace(IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX)).replaceAll("\n\n");
            AppMethodBeat.m2505o(36715);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "filter desc error ");
            AppMethodBeat.m2505o(36715);
            return str2;
        }
        return str2;
    }

    /* renamed from: Ym */
    public final C29054ax mo47144Ym(String str) {
        AppMethodBeat.m2504i(36716);
        this.qNG = C29054ax.m46158Yl(str);
        this.qNK.xfF = this.qNG;
        AppMethodBeat.m2505o(36716);
        return this;
    }

    /* renamed from: gc */
    public final C29054ax mo47165gc(String str, String str2) {
        this.qNL.token = str;
        this.qNL.wFn = str2;
        return this;
    }

    /* renamed from: Dd */
    public final C29054ax mo47138Dd(int i) {
        this.qNK.xfK = 1;
        this.qNK.xfL = i;
        return this;
    }

    /* renamed from: Yn */
    public final C29054ax mo47145Yn(String str) {
        this.qNK.xfM = str;
        this.qNO.vCy.vCs = str;
        return this;
    }

    /* renamed from: Yo */
    public final C29054ax mo47146Yo(String str) {
        this.qNK.rCK = str;
        return this;
    }

    /* renamed from: af */
    public final C29054ax mo47157af(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36717);
        C35904at c35904at = this.qNO.vCy;
        if (C5046bo.isNullOrNil(str)) {
            str = "";
        }
        c35904at.fKh = str;
        c35904at = this.qNO.vCy;
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "";
        }
        c35904at.vCt = str2;
        c35904at = this.qNO.vCy;
        if (C5046bo.isNullOrNil(str3)) {
            str3 = "";
        }
        c35904at.vCu = str3;
        AppMethodBeat.m2505o(36717);
        return this;
    }

    /* renamed from: Yp */
    public final C29054ax mo47147Yp(String str) {
        this.qNH = str;
        this.qNK.xfI.Desc = str;
        return this;
    }

    /* renamed from: Yq */
    public final C29054ax mo47148Yq(String str) {
        this.qNK.xfI.Url = str;
        return this;
    }

    /* renamed from: Yr */
    public final C29054ax mo47149Yr(String str) {
        this.qNK.xfI.Title = str;
        return this;
    }

    /* renamed from: De */
    public final void mo47139De(int i) {
        AppMethodBeat.m2504i(36718);
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(i)));
        this.qNL.wFj = i;
        AppMethodBeat.m2505o(36718);
    }

    /* renamed from: a */
    public final C29054ax mo47154a(ayt ayt) {
        if (ayt != null) {
            this.qNK.xfG = ayt;
        }
        return this;
    }

    /* renamed from: Df */
    public final C29054ax mo47140Df(int i) {
        AppMethodBeat.m2504i(36719);
        this.qFY = i;
        this.qNL.wEJ = i;
        this.qNK.wEJ = i;
        if (i > 0) {
            this.qNM.field_pravited = i;
            this.qNM.cqO();
            this.qNM.mo74254DJ(2);
            this.qNM.cqS();
        }
        AppMethodBeat.m2505o(36719);
        return this;
    }

    /* renamed from: Dg */
    public final C29054ax mo47141Dg(int i) {
        this.qFX = i;
        this.qNL.wFe = i;
        return this;
    }

    /* renamed from: ar */
    public final C29054ax mo47158ar(LinkedList<cco> linkedList) {
        AppMethodBeat.m2504i(36720);
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
        AppMethodBeat.m2505o(36720);
        return this;
    }

    /* renamed from: Dh */
    public final C29054ax mo47142Dh(int i) {
        this.qNL.wFl = i;
        return this;
    }

    /* renamed from: Ys */
    public final C29054ax mo47150Ys(String str) {
        AppMethodBeat.m2504i(36721);
        C44113ds c44113ds = this.qNK.xfH;
        if (c44113ds == null) {
            c44113ds = new C44113ds();
        }
        c44113ds.f17242Id = str;
        this.qNK.xfH = c44113ds;
        AppMethodBeat.m2505o(36721);
        return this;
    }

    /* renamed from: Yt */
    public final C29054ax mo47151Yt(String str) {
        AppMethodBeat.m2504i(36722);
        C44113ds c44113ds = this.qNK.xfH;
        if (c44113ds == null) {
            c44113ds = new C44113ds();
        }
        c44113ds.ncH = str;
        this.qNK.xfH = c44113ds;
        AppMethodBeat.m2505o(36722);
        return this;
    }

    /* renamed from: Yu */
    public final C29054ax mo47152Yu(String str) {
        AppMethodBeat.m2504i(36723);
        this.qNK.ijx = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(36723);
        return this;
    }

    /* renamed from: Yv */
    public final C29054ax mo47153Yv(String str) {
        AppMethodBeat.m2504i(36724);
        this.qNK.vjM = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(36724);
        return this;
    }

    /* renamed from: dg */
    public final C29054ax mo47162dg(List<String> list) {
        AppMethodBeat.m2504i(36725);
        if (list == null || list.size() == 0) {
            this.qNN.wGz = 1;
            AppMethodBeat.m2505o(36725);
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
            AppMethodBeat.m2505o(36725);
        }
        return this;
    }

    /* renamed from: Di */
    public final C29054ax mo47143Di(int i) {
        if (i == 1) {
            this.qNN.wGz = 3;
        } else if (i == 0) {
            this.qNN.wGz = 5;
        }
        this.qNL.wFo = i;
        return this;
    }

    /* renamed from: A */
    private static bau m46157A(String str, byte[] bArr) {
        AppMethodBeat.m2504i(36726);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", C1447g.m3075Mq() + " attachBuf is null");
            AppMethodBeat.m2505o(36726);
            return null;
        }
        String str2 = C13373af.getAccSnsTmpPath() + C1178g.m2591x((" " + System.currentTimeMillis()).getBytes());
        C5730e.m8643tf(C13373af.getAccSnsTmpPath());
        C4990ab.m7410d("MicroMsg.UploadPackHelper", C1447g.m3075Mq() + " buildUploadAttachInfo file:" + str2);
        if (C5730e.m8624b(str2, bArr, bArr.length) < 0) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", C1447g.m3075Mq() + " writeFile error file:" + str2);
            AppMethodBeat.m2505o(36726);
            return null;
        }
        bau gd = C29054ax.m46162gd(str, str2);
        AppMethodBeat.m2505o(36726);
        return gd;
    }

    /* renamed from: c */
    public static bau m46161c(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(36727);
        bau ajN = C37953e.ajN();
        ajN.f17915Id = str;
        C4990ab.m7417i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", Integer.valueOf(6), str2, str4, str5, str6);
        ajN.jCt = 6;
        if (C5730e.asZ(str2) <= 0) {
            AppMethodBeat.m2505o(36727);
            return null;
        }
        baw baw;
        C21881h c21881h = new C21881h(str2, 6);
        c21881h.qGb = str4;
        c21881h = C13373af.cnu().mo25632a(c21881h, str2, str3, str5, str6);
        if (c21881h.height <= 0 || c21881h.width <= 0 || c21881h.fileSize <= 0) {
            baw = null;
        } else {
            baw = new baw();
            baw.wFy = (float) c21881h.height;
            baw.wFx = (float) c21881h.width;
            baw.wFz = (float) c21881h.fileSize;
        }
        ajN.f17915Id = "Locall_path" + c21881h.cNE;
        ajN.wEK = baw;
        ajN.cNE = c21881h.cNE;
        AppMethodBeat.m2505o(36727);
        return ajN;
    }

    /* renamed from: gd */
    private static bau m46162gd(String str, String str2) {
        baw baw = null;
        AppMethodBeat.m2504i(36728);
        bau ajN = C37953e.ajN();
        ajN.f17915Id = str;
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        ajN.jCt = 2;
        if (C5730e.asZ(str2) <= 0) {
            AppMethodBeat.m2505o(36728);
            return null;
        }
        String str3 = C13373af.getAccSnsTmpPath() + C1178g.m2591x((str2 + System.currentTimeMillis()).getBytes());
        C5730e.m8644y(str2, str3);
        C21881h c21881h = new C21881h(str3, 2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(c21881h);
        List dn = C13373af.cnu().mo25634dn(linkedList);
        if (dn == null || dn.size() == 0) {
            AppMethodBeat.m2505o(36728);
            return null;
        }
        C21881h c21881h2 = (C21881h) dn.get(0);
        if (c21881h2.height > 0 && c21881h2.width > 0 && c21881h2.fileSize > 0) {
            baw = new baw();
            baw.wFy = (float) c21881h2.height;
            baw.wFx = (float) c21881h2.width;
            baw.wFz = (float) c21881h2.fileSize;
        }
        ajN.f17915Id = "Locall_path" + c21881h2.cNE;
        ajN.wEK = baw;
        ajN.cNE = c21881h2.cNE;
        AppMethodBeat.m2505o(36728);
        return ajN;
    }

    /* renamed from: ag */
    public static bau m46160ag(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36729);
        bau ajN = C37953e.ajN();
        ajN.f17915Id = str;
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        ajN.jCt = 2;
        ajN.Url = str2;
        ajN.wEG = 0;
        ajN.wEH = str3;
        ajN.wEI = 0;
        ajN.wEN = 1;
        AppMethodBeat.m2505o(36729);
        return ajN;
    }

    /* renamed from: t */
    public final boolean mo47168t(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(36730);
        String str5 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str.getBytes());
        C29054ax.m46159Yw(str5);
        C5730e.m8644y(str, str5);
        String str6 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str2.getBytes());
        C5730e.m8644y(str2, str6);
        bau c = C29054ax.m46161c("", str5, str6, str4, "", "");
        if (c == null) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.m2505o(36730);
            return false;
        }
        c.Desc = str3;
        if (C5046bo.isNullOrNil(c.Title)) {
            c.Title = str3;
        }
        this.qNK.xfI.wbK.add(c);
        ayq ayq = new ayq();
        ayq.wCt = c.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.m2505o(36730);
        return true;
    }

    /* renamed from: Yw */
    public static void m46159Yw(String str) {
        AppMethodBeat.m2504i(36731);
        C5730e.m8643tf(C5730e.atb(str));
        AppMethodBeat.m2505o(36731);
    }

    /* renamed from: ge */
    public final boolean mo47166ge(String str, String str2) {
        AppMethodBeat.m2504i(36732);
        String str3 = C13373af.getAccSnsTmpPath() + C1178g.m2591x(str.getBytes());
        C29054ax.m46159Yw(str3);
        C5730e.m8644y(str, str3);
        bau gd = C29054ax.m46162gd("", str3);
        if (gd == null) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            AppMethodBeat.m2505o(36732);
            return false;
        }
        gd.Desc = str2;
        if (C5046bo.isNullOrNil(gd.Title)) {
            gd.Title = str2;
        }
        this.qNK.xfI.wbK.add(gd);
        ayq ayq = new ayq();
        ayq.wCt = gd.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.m2505o(36732);
        return true;
    }

    @Deprecated
    /* renamed from: b */
    public final boolean mo47159b(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(36733);
        bau ag = C29054ax.m46160ag("", str, str2);
        if (ag == null) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            AppMethodBeat.m2505o(36733);
            return false;
        }
        ag.Desc = str3;
        if (i > 0) {
            ag.cuu = i;
        }
        if (!C5046bo.isNullOrNil(str4)) {
            ag.rik = str4;
        }
        this.qNK.xfI.wbK.add(ag);
        AppMethodBeat.m2505o(36733);
        return true;
    }

    /* renamed from: b */
    public final boolean mo47160b(byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(36734);
        boolean a = mo47155a(bArr, str, str2, -1, "");
        AppMethodBeat.m2505o(36734);
        return a;
    }

    /* renamed from: a */
    public final boolean mo47155a(byte[] bArr, String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(36735);
        bau A = C29054ax.m46157A("", bArr);
        if (A == null) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            AppMethodBeat.m2505o(36735);
            return false;
        }
        A.Desc = str;
        if (i > 0) {
            A.cuu = i;
        }
        if (!C5046bo.isNullOrNil(str3)) {
            A.rik = str3;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            A.Title = str2;
        }
        if (!C5046bo.isNullOrNil(str)) {
            A.Desc = str;
        }
        this.qNK.xfI.wbK.add(A);
        ayq ayq = new ayq();
        ayq.wCt = A.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.m2505o(36735);
        return true;
    }

    /* renamed from: a */
    public final boolean mo47156a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.m2504i(36736);
        bau A = C29054ax.m46157A("", bArr);
        if (A == null || (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3))) {
            C4990ab.m7412e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            AppMethodBeat.m2505o(36736);
            return false;
        }
        if (!C5046bo.isNullOrNil(str)) {
            this.qNK.xfI.Url = str;
        }
        if (!C5046bo.isNullOrNil(str3)) {
            A.Url = str3;
            A.wEG = 0;
        } else if (!C5046bo.isNullOrNil(str2)) {
            A.Url = str2;
            A.wEG = 0;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            A.wEL = str2;
            A.wEM = 0;
        }
        A.jCt = i;
        A.Title = C5046bo.m7532bc(str4, "");
        A.Desc = C5046bo.m7532bc(str5, "");
        this.qNK.xfI.wbK.add(A);
        ayq ayq = new ayq();
        ayq.wCt = A.cNE;
        this.qNL.wFf.add(ayq);
        AppMethodBeat.m2505o(36736);
        return true;
    }

    /* renamed from: dh */
    public final void mo47163dh(List<C21881h> list) {
        AppMethodBeat.m2504i(36737);
        this.qNF = list;
        List<C21881h> dn = C13373af.cnu().mo25634dn(this.qNF);
        LinkedList linkedList = new LinkedList();
        if (dn == null) {
            AppMethodBeat.m2505o(36737);
            return;
        }
        for (C21881h c21881h : dn) {
            ayq ayq = new ayq();
            ayq.wCt = c21881h.cNE;
            linkedList.add(ayq);
        }
        this.qNL.wFf = linkedList;
        for (C21881h c21881h2 : dn) {
            baw baw = new baw();
            baw.wFy = 0.0f;
            baw.wFx = 0.0f;
            baw.wFz = 0.0f;
            if (c21881h2.height > 0 && c21881h2.width > 0 && c21881h2.fileSize > 0) {
                baw.wFy = (float) c21881h2.height;
                baw.wFx = (float) c21881h2.width;
                baw.wFz = (float) c21881h2.fileSize;
            }
            this.qNK.xfI.wbK.add(C37953e.m64184a("Locall_path" + c21881h2.cNE, c21881h2.type, "", "", 0, 0, this.qFY, "", baw));
        }
        AppMethodBeat.m2505o(36737);
    }

    /* renamed from: g */
    public final void mo47164g(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(36738);
        cbp cbp = new cbp();
        cbp.vFJ = str;
        cbp.vFK = str2;
        cbp.vFL = str3;
        cbp.rnf = i;
        cbp.rng = i2;
        this.qNL.wFq = cbp;
        AppMethodBeat.m2505o(36738);
    }

    public final void setSessionId(String str) {
        this.qNL.cvF = str;
    }

    public final int commit() {
        AppMethodBeat.m2504i(36739);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qNL.wFi = System.currentTimeMillis();
            this.qNL.eRu = 0;
            this.qNM.mo74256bi(this.qNN.toByteArray());
            this.qNM.field_postBuf = this.qNL.toByteArray();
            C4990ab.m7410d("MicroMsg.UploadPackHelper", "snsObj " + this.qNN.toString());
            C4990ab.m7410d("MicroMsg.UploadPackHelper", "postinfo " + this.qNL.toString());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "timelineObj " + this.qNK.toString());
        if (this.qNK.xfI.wbK != null) {
            C4990ab.m7411d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", Integer.valueOf(this.qNK.xfI.wbK.size()));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.qNK.xfI.wbK.size()) {
                    break;
                }
                if (((bau) this.qNK.xfI.wbK.get(i2)) != null) {
                    C4990ab.m7411d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", Integer.valueOf(((bau) this.qNK.xfI.wbK.get(i2)).cNE), C5046bo.m7532bc(((bau) this.qNK.xfI.wbK.get(i2)).Url, ""));
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
        this.qNM.mo74257c(this.qNK);
        int A = C13373af.cnF().mo62911A(this.qNM);
        Iterator it = this.qNL.wFf.iterator();
        int i3 = 0;
        String str = null;
        while (it.hasNext()) {
            ayq ayq = (ayq) it.next();
            C29098r kE = C13373af.cnu().mo25635kE((long) ayq.wCt);
            try {
                bax bax = (bax) new bax().parseFrom(kE.rfI);
                if (this.qNK.xfH != null) {
                    bax.csB = this.qNK.xfH.f17242Id;
                }
                if (this.cNJ != null) {
                    this.cNJ.wDQ = 0;
                }
                bax.wFH = this.cNJ;
                bax.aPA = this.qNK.xfI.wbJ;
                if (bax.aPA == 1 || bax.aPA == 15) {
                    int i4;
                    bax bax2;
                    if (!C5046bo.isNullOrNil(bax.csB)) {
                        i4 = 5;
                        bax2 = bax;
                    } else if (bax.wFH != null && bax.aPA == 15) {
                        if (bax.wFH.wDP) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        bax.wFI = i4;
                    } else if (((C21881h) this.qNF.get(i3)).qGc) {
                        i4 = 1;
                        bax2 = bax;
                    } else {
                        i4 = 2;
                        bax2 = bax;
                    }
                    bax2.wFI = i4;
                }
                kE.rfI = bax.toByteArray();
                C13373af.cnu().mo25631a(ayq.wCt, kE);
                i3++;
                str = bax.cvZ;
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        C4990ab.m7417i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", Integer.valueOf(A), Integer.valueOf(this.qNM.field_type), str);
        if (A > 0 && this.qNM.field_type == 15) {
            C34957aq.m57419gb(C35002v.m57489ao("sns_table_", (long) A), str);
        }
        C4990ab.m7410d("MicroMsg.UploadPackHelper", "pack commit result " + A + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(36739);
        return A;
    }
}
