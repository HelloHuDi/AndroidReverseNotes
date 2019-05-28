package com.tencent.p177mm.plugin.product.p481b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p482ui.C39492c;
import com.tencent.p177mm.plugin.product.p482ui.C46135e;
import com.tencent.p177mm.plugin.product.p737c.C12816l;
import com.tencent.p177mm.plugin.product.p737c.C28671a;
import com.tencent.p177mm.plugin.product.p737c.C34682m;
import com.tencent.p177mm.plugin.product.p737c.C46133h;
import com.tencent.p177mm.protocal.protobuf.C35905au;
import com.tencent.p177mm.protocal.protobuf.C35968ze;
import com.tencent.p177mm.protocal.protobuf.C40508cx;
import com.tencent.p177mm.protocal.protobuf.C44188xd;
import com.tencent.p177mm.protocal.protobuf.axa;
import com.tencent.p177mm.protocal.protobuf.blq;
import com.tencent.p177mm.protocal.protobuf.bpz;
import com.tencent.p177mm.protocal.protobuf.btx;
import com.tencent.p177mm.protocal.protobuf.cad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.product.b.c */
public final class C12808c {
    public int mCount = 1;
    private C12810d pgN = null;
    public C12812m pgO;
    public List<C12813n> pgP;
    public String pgQ;
    public String pgR;
    public String pgS;
    public C35968ze pgT;
    public C40508cx pgU;
    public bpz pgV;
    public String pgW;
    public String pgX;
    public int pgY;
    public Map<String, C3595e> pgZ;
    public Map<String, String> pha = new HashMap();
    public LinkedList<C35968ze> phb;
    public LinkedList<C35905au> phc;
    public C3595e phd;
    private C46135e phe;
    public Map<String, LinkedList<C44188xd>> phf = null;

    /* renamed from: com.tencent.mm.plugin.product.b.c$1 */
    static class C128091 implements Comparator<Entry<String, String>> {
        C128091() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(43951);
            int compareTo = ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
            AppMethodBeat.m2505o(43951);
            return compareTo;
        }
    }

    public C12808c() {
        AppMethodBeat.m2504i(43952);
        AppMethodBeat.m2505o(43952);
    }

    public final void clear() {
        AppMethodBeat.m2504i(43953);
        this.pgO = null;
        if (this.pgP != null) {
            this.pgP.clear();
            this.pgP = null;
        }
        this.pgQ = null;
        this.pgR = null;
        this.mCount = 1;
        this.pgS = null;
        this.pgT = null;
        this.pgV = null;
        this.pgW = null;
        this.pgY = 0;
        this.phd = null;
        if (this.pgZ != null) {
            this.pgZ.clear();
            this.pgZ = null;
        }
        if (this.pha != null) {
            this.pha.clear();
        }
        if (this.phb != null) {
            this.phb.clear();
            this.phb = null;
        }
        if (this.phf != null) {
            this.phf.clear();
            this.phf = null;
        }
        AppMethodBeat.m2505o(43953);
    }

    /* renamed from: a */
    public final void mo24811a(C12812m c12812m, List<C12813n> list) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(43954);
        clear();
        this.pgO = c12812m;
        this.pgP = list;
        if (C5046bo.isNullOrNil(this.pgO.phw)) {
            this.pgO.phw = this.pgR;
        }
        m20803ai(this.pgO.phu);
        if (!(this.pgO.phs == null || this.pgO.phs.phM == null)) {
            this.pgY = this.pgO.phs.phM.size();
        }
        if (!(this.pgO.phs == null || this.pgO.phs.phG == null || this.pgO.phs.phG.size() <= 0)) {
            this.pgW = (String) this.pgO.phs.phG.get(0);
        }
        if (!C5046bo.isNullOrNil(this.pgO.bZY())) {
            C18764x.m29325a(new C39492c(this.pgO.bZY()));
            C4990ab.m7410d("MicroMsg.MallProductManager", "product img path : " + bZM());
        }
        if (this.pgO.phv == null || this.pgO.phv.phQ == null) {
            i = 0;
        } else {
            i = this.pgO.phv.phQ.bJt;
        }
        if (this.pgO.pht != null) {
            i2 = this.pgO.pht.bJt;
        }
        this.phe = new C46135e(i, i2);
        AppMethodBeat.m2505o(43954);
    }

    public final C46135e bZF() {
        AppMethodBeat.m2504i(43955);
        if (this.phe == null) {
            this.phe = new C46135e(0, 0);
        }
        C46135e c46135e = this.phe;
        AppMethodBeat.m2505o(43955);
        return c46135e;
    }

    public final String bZG() {
        AppMethodBeat.m2504i(43956);
        String str;
        if (this.phd == null || C5046bo.isNullOrNil(this.phd.url)) {
            str = this.pgW;
            AppMethodBeat.m2505o(43956);
            return str;
        }
        str = this.phd.url;
        AppMethodBeat.m2505o(43956);
        return str;
    }

    public final String bZH() {
        AppMethodBeat.m2504i(43957);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.pgO.phs.phM.iterator();
        while (it.hasNext()) {
            C34682m c34682m = (C34682m) it.next();
            String str = (String) this.pha.get(c34682m.phX);
            if (str != null) {
                Iterator it2 = c34682m.phZ.iterator();
                while (it2.hasNext()) {
                    C46133h c46133h = (C46133h) it2.next();
                    if (str.equals(c46133h.f17901id)) {
                        stringBuilder.append(c46133h.name).append(" ");
                        break;
                    }
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(43957);
        return stringBuilder2;
    }

    /* renamed from: al */
    public final void mo24812al(Intent intent) {
        AppMethodBeat.m2504i(43958);
        C40508cx c40508cx = new C40508cx();
        c40508cx.jBB = C5046bo.m7532bc(intent.getStringExtra("userName"), "");
        c40508cx.vEV = C5046bo.m7532bc(intent.getStringExtra("telNumber"), "");
        c40508cx.vEW = C5046bo.m7532bc(intent.getStringExtra("addressPostalCode"), "");
        c40508cx.guO = C5046bo.m7532bc(intent.getStringExtra("proviceFirstStageName"), "");
        c40508cx.guP = C5046bo.m7532bc(intent.getStringExtra("addressCitySecondStageName"), "");
        c40508cx.guW = C5046bo.m7532bc(intent.getStringExtra("addressCountiesThirdStageName"), "");
        c40508cx.naq = C5046bo.m7532bc(intent.getStringExtra("addressDetailInfo"), "");
        if (!(C5046bo.isNullOrNil(c40508cx.jBB) || C5046bo.isNullOrNil(c40508cx.vEV))) {
            this.pgU = c40508cx;
        }
        AppMethodBeat.m2505o(43958);
    }

    /* renamed from: X */
    public final LinkedList<C28671a> mo24809X(Activity activity) {
        AppMethodBeat.m2504i(43959);
        LinkedList linkedList = new LinkedList();
        if (this.phc != null) {
            Iterator it = this.phc.iterator();
            while (it.hasNext()) {
                C35905au c35905au = (C35905au) it.next();
                C28671a c28671a = new C28671a();
                c28671a.Name = c35905au.Name;
                c28671a.phA = c35905au.phA;
                c28671a.ncM = c35905au.ncM;
                c28671a.jCt = c35905au.jCt;
                c28671a.IconUrl = c35905au.IconUrl;
                if (c28671a.jCt == 1 && m20800UI(c28671a.ncM) > 0) {
                    c28671a.phA = activity.getString(C25738R.string.cxy, new Object[]{C12807b.m20798d((double) m20800UI(c28671a.ncM), this.pgO.phs.pcl)});
                }
                linkedList.add(c28671a);
            }
        }
        AppMethodBeat.m2505o(43959);
        return linkedList;
    }

    /* renamed from: AL */
    public final void mo24808AL(int i) {
        AppMethodBeat.m2504i(43960);
        if (this.phb == null) {
            AppMethodBeat.m2505o(43960);
            return;
        }
        if (i < this.phb.size() && i >= 0) {
            this.pgT = (C35968ze) this.phb.get(i);
        }
        AppMethodBeat.m2505o(43960);
    }

    public final int bZI() {
        AppMethodBeat.m2504i(43961);
        int i = 0;
        if (!(bZF().cab() || this.pgT == null)) {
            i = this.pgT.vQt + 0;
        }
        if (this.phd != null) {
            i += this.phd.phh * this.mCount;
        } else {
            i += this.pgO.phs.phE * this.mCount;
        }
        i -= bZJ();
        AppMethodBeat.m2505o(43961);
        return i;
    }

    public final int bZJ() {
        AppMethodBeat.m2504i(43962);
        int i = 0;
        if (this.phf != null && this.phf.size() > 0) {
            int i2;
            Iterator it = this.phf.values().iterator();
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                LinkedList linkedList = (LinkedList) it.next();
                if (linkedList != null && linkedList.size() > 0) {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        i2 += ((C44188xd) it2.next()).vQt;
                    }
                }
                i = i2;
            }
            i = i2;
        }
        AppMethodBeat.m2505o(43962);
        return i;
    }

    /* renamed from: UI */
    private int m20800UI(String str) {
        AppMethodBeat.m2504i(43963);
        int i = 0;
        if (this.phf != null && this.phf.size() > 0) {
            LinkedList linkedList = (LinkedList) this.phf.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((C44188xd) it.next()).vQt + i;
                }
            }
        }
        AppMethodBeat.m2505o(43963);
        return i;
    }

    public final bpz bZK() {
        AppMethodBeat.m2504i(43964);
        bpz bpz;
        if (this.pgV != null) {
            bpz = this.pgV;
            AppMethodBeat.m2505o(43964);
            return bpz;
        }
        String str;
        if (this.pgN == null) {
            this.pgN = C34676a.bZC().bZE();
        }
        C12810d c12810d = this.pgN;
        if (c12810d.phg == null || c12810d.phg.size() <= 0) {
            str = null;
        } else {
            str = (String) c12810d.phg.get(0);
        }
        if (C5046bo.isNullOrNil(str)) {
            C40508cx c40508cx = this.pgU;
            if (c40508cx == null || C5046bo.isNullOrNil(c40508cx.jBB)) {
                AppMethodBeat.m2505o(43964);
                return null;
            }
            this.pgV = new bpz();
            this.pgV.naq = c40508cx.jBB;
            this.pgV.wSm = 1;
            bpz = this.pgV;
            AppMethodBeat.m2505o(43964);
            return bpz;
        }
        this.pgV = new bpz();
        this.pgV.naq = str;
        this.pgV.wSm = 1;
        bpz = this.pgV;
        AppMethodBeat.m2505o(43964);
        return bpz;
    }

    public final String getAppId() {
        if (this.pgO.pht != null) {
            return this.pgO.pht.csB;
        }
        return null;
    }

    public final String bZL() {
        if (this.pgO.pht != null) {
            return this.pgO.pht.username;
        }
        return null;
    }

    public final String bZM() {
        AppMethodBeat.m2504i(43965);
        if (C5046bo.isNullOrNil(this.pgO.bZY())) {
            AppMethodBeat.m2505o(43965);
            return null;
        }
        String UK = C39492c.m67475UK(this.pgO.bZY());
        AppMethodBeat.m2505o(43965);
        return UK;
    }

    public final String bZN() {
        AppMethodBeat.m2504i(43966);
        String str;
        if (this.pgO.phs != null && this.pgO.phs.phO != null) {
            str = this.pgO.phs.phO.url;
            AppMethodBeat.m2505o(43966);
            return str;
        } else if (C5046bo.isNullOrNil(this.pgO.phw)) {
            str = this.pgR;
            AppMethodBeat.m2505o(43966);
            return str;
        } else {
            str = this.pgO.phw;
            AppMethodBeat.m2505o(43966);
            return str;
        }
    }

    public final int bZO() {
        int i = this.pgO.phq;
        if (this.phd == null || i <= this.phd.phq) {
            return i;
        }
        return this.phd.phq;
    }

    public final boolean bZP() {
        AppMethodBeat.m2504i(43967);
        if (this.mCount <= 0 || this.pgO == null || this.mCount > bZO() || this.pgO.phs == null || this.pgO.phs.phM == null) {
            AppMethodBeat.m2505o(43967);
            return false;
        }
        AppMethodBeat.m2505o(43967);
        return true;
    }

    public final boolean bZQ() {
        AppMethodBeat.m2504i(43968);
        if (bZP()) {
            if (this.pha != null && this.pha.size() == this.pgY) {
                if (this.pgY > 0) {
                    if (this.phd != null && this.mCount > 0 && this.mCount <= bZO()) {
                        AppMethodBeat.m2505o(43968);
                        return true;
                    }
                } else if (this.pgY == 0) {
                    AppMethodBeat.m2505o(43968);
                    return true;
                }
            }
            AppMethodBeat.m2505o(43968);
            return false;
        }
        AppMethodBeat.m2505o(43968);
        return false;
    }

    public final boolean bZR() {
        AppMethodBeat.m2504i(43969);
        if (!bZQ()) {
            AppMethodBeat.m2505o(43969);
            return false;
        } else if (this.pgU == null) {
            AppMethodBeat.m2505o(43969);
            return false;
        } else if (bZF().cab() || this.pgT != null) {
            AppMethodBeat.m2505o(43969);
            return true;
        } else {
            AppMethodBeat.m2505o(43969);
            return false;
        }
    }

    public final LinkedList<btx> bZS() {
        AppMethodBeat.m2504i(43970);
        LinkedList linkedList = new LinkedList();
        btx btx = new btx();
        btx.jBv = this.mCount;
        btx.wrm = this.pgO.pho;
        btx.wOG = this.pgO.phw;
        btx.wOH = this.pgS;
        linkedList.add(btx);
        AppMethodBeat.m2505o(43970);
        return linkedList;
    }

    public final cad bZT() {
        AppMethodBeat.m2504i(43971);
        cad cad = new cad();
        cad.vRN = this.pgQ;
        cad.pdi = 1;
        cad.wZm = new LinkedList();
        blq blq = new blq();
        blq.jBv = this.mCount;
        blq.wrm = this.pgO.pho;
        blq.Name = this.pgO.phs.name;
        if (this.phd != null) {
            blq.wOF = this.phd.phh;
        } else {
            blq.wOF = this.pgO.phs.phE;
        }
        blq.wOG = this.pgO.phw;
        blq.wOH = this.pgS;
        blq.jCt = this.pgO.php;
        blq.wOD = this.pgY;
        blq.wOE = new LinkedList();
        for (String str : this.pha.keySet()) {
            String str2 = (String) this.pha.get(str);
            axa axa = new axa();
            axa.vMU = str;
            axa.pXM = str2;
            blq.wOE.add(axa);
        }
        blq.wOL = new LinkedList();
        blq.wOK = 0;
        if (this.phf != null && this.phf.size() > 0) {
            for (LinkedList linkedList : this.phf.values()) {
                blq.wOL.addAll(linkedList);
                blq.wOK = linkedList.size() + blq.wOK;
            }
        }
        cad.wZm.add(blq);
        cad.wZo = new LinkedList();
        cad.wZp = 1;
        this.pgV = bZK();
        if (this.pgV != null) {
            cad.wZo.add(this.pgV);
        } else {
            this.pgV = new bpz();
            this.pgV.wSm = 0;
            cad.wZo.add(this.pgV);
        }
        cad.wpB = this.pgU;
        cad.wZn = this.pgT;
        AppMethodBeat.m2505o(43971);
        return cad;
    }

    public final void bZU() {
        AppMethodBeat.m2504i(43972);
        if (this.pha == null) {
            AppMethodBeat.m2505o(43972);
            return;
        }
        Iterator it = this.pgO.phs.phM.iterator();
        while (it.hasNext()) {
            C34682m c34682m = (C34682m) it.next();
            Iterator it2 = c34682m.phZ.iterator();
            while (it2.hasNext()) {
                boolean z;
                C46133h c46133h = (C46133h) it2.next();
                String str = c34682m.phX;
                String str2 = c46133h.f17901id;
                String str3;
                C3595e c3595e;
                if (this.pha == null || this.pgZ == null) {
                    z = false;
                } else if (this.pha.containsKey(str)) {
                    str3 = (String) this.pha.get(str);
                    this.pha.put(str, str2);
                    str2 = C12808c.m20801V(this.pha);
                    this.pha.put(str, str3);
                    c3595e = (C3595e) this.pgZ.get(str2);
                    z = c3595e != null ? c3595e.phq > 0 : false;
                } else {
                    this.pha.put(str, str2);
                    str3 = C12808c.m20801V(this.pha);
                    this.pha.remove(str);
                    c3595e = (C3595e) this.pgZ.get(str3);
                    z = c3595e != null ? c3595e.phq > 0 : false;
                }
                c46133h.phS = z;
                C4990ab.m7410d("MicroMsg.MallProductManager", "(" + c34682m.phX + " , " + c46133h.f17901id + ") hasStock--> " + c46133h.phS);
            }
        }
        AppMethodBeat.m2505o(43972);
    }

    /* renamed from: V */
    public static String m20801V(Map<String, String> map) {
        AppMethodBeat.m2504i(43973);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.m2505o(43973);
            return null;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new C128091());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(43973);
        return stringBuilder2;
    }

    /* renamed from: ai */
    private void m20803ai(LinkedList<C12816l> linkedList) {
        AppMethodBeat.m2504i(43974);
        this.pgZ = new HashMap();
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.m2505o(43974);
            return;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            C12816l c12816l = (C12816l) linkedList.get(i);
            m20802a(c12816l.phU.split(";"), c12816l);
        }
        bZU();
        AppMethodBeat.m2505o(43974);
    }

    /* renamed from: a */
    private void m20802a(String[] strArr, C12816l c12816l) {
        AppMethodBeat.m2504i(43975);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.m2505o(43975);
            return;
        }
        int length = strArr.length;
        int i = -1 >>> (32 - length);
        for (int i2 = 1; i2 <= i; i2++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i3 = 0; i3 < length; i3++) {
                if (((i2 << (31 - i3)) >> 31) == -1) {
                    stringBuilder.append(strArr[i3]).append(";");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
            C3595e c3595e = (C3595e) this.pgZ.get(stringBuilder.toString());
            if (c3595e != null) {
                if (c3595e.phh < c12816l.phV) {
                    c3595e.phh = c12816l.phV;
                }
                if (c3595e.phi > c12816l.phV) {
                    c3595e.phi = c12816l.phV;
                }
                c3595e.phq += c12816l.phq;
            } else {
                c3595e = new C3595e();
                c3595e.phh = c12816l.phV;
                c3595e.phi = c12816l.phV;
                c3595e.phq = c12816l.phq;
                c3595e.phW = c12816l.phW;
                c3595e.url = c12816l.url;
                this.pgZ.put(stringBuilder.toString(), c3595e);
            }
        }
        AppMethodBeat.m2505o(43975);
    }

    public final String bZV() {
        AppMethodBeat.m2504i(43976);
        C8910b c8910b = new C8910b();
        c8910b.title = this.pgO.phs.name;
        c8910b.description = bZW();
        c8910b.type = 13;
        c8910b.url = bZN();
        c8910b.thumburl = this.pgO.bZY();
        c8910b.fgV = this.pgO.php;
        c8910b.fgW = mo24810a(this.pgO);
        String a = C8910b.m16061a(c8910b, null, null);
        AppMethodBeat.m2505o(43976);
        return a;
    }

    public final String bZW() {
        AppMethodBeat.m2504i(43977);
        String d = C12807b.m20798d((double) this.pgO.phs.phF, this.pgO.phs.pcl);
        AppMethodBeat.m2505o(43977);
        return d;
    }

    /* renamed from: a */
    public final String mo24810a(C12812m c12812m) {
        AppMethodBeat.m2504i(43978);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(c12812m.php).append("</type>");
        stringBuilder.append("<id>").append(c12812m.pho).append("</id>");
        stringBuilder.append("<version>").append(c12812m.phs.version).append("</version>");
        stringBuilder.append("<name>").append(C5046bo.ani(c12812m.phs.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(c12812m.phs.phE).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(c12812m.phs.phF).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(c12812m.phs.phD).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(C5046bo.ani(this.pgO.phw)).append("</sourceUrl>");
        if (c12812m.phs.phG != null) {
            stringBuilder.append("<imgCount>").append(c12812m.phs.phG.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = c12812m.phs.phG.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(C5046bo.ani((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(C5046bo.ani(bZN())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(C5046bo.ani(c12812m.bZY())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.pgO.pht != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(c12812m.pht.csB).append("</appID>");
            stringBuilder.append("<appName>").append(c12812m.pht.name).append("</appName>");
            stringBuilder.append("<usrName>").append(c12812m.pht.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(43978);
        return stringBuilder2;
    }
}
