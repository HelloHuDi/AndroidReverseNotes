package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class c {
    public int mCount = 1;
    private d pgN = null;
    public m pgO;
    public List<n> pgP;
    public String pgQ;
    public String pgR;
    public String pgS;
    public ze pgT;
    public cx pgU;
    public bpz pgV;
    public String pgW;
    public String pgX;
    public int pgY;
    public Map<String, e> pgZ;
    public Map<String, String> pha = new HashMap();
    public LinkedList<ze> phb;
    public LinkedList<au> phc;
    public e phd;
    private e phe;
    public Map<String, LinkedList<xd>> phf = null;

    public c() {
        AppMethodBeat.i(43952);
        AppMethodBeat.o(43952);
    }

    public final void clear() {
        AppMethodBeat.i(43953);
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
        AppMethodBeat.o(43953);
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(43954);
        clear();
        this.pgO = mVar;
        this.pgP = list;
        if (bo.isNullOrNil(this.pgO.phw)) {
            this.pgO.phw = this.pgR;
        }
        ai(this.pgO.phu);
        if (!(this.pgO.phs == null || this.pgO.phs.phM == null)) {
            this.pgY = this.pgO.phs.phM.size();
        }
        if (!(this.pgO.phs == null || this.pgO.phs.phG == null || this.pgO.phs.phG.size() <= 0)) {
            this.pgW = (String) this.pgO.phs.phG.get(0);
        }
        if (!bo.isNullOrNil(this.pgO.bZY())) {
            x.a(new com.tencent.mm.plugin.product.ui.c(this.pgO.bZY()));
            ab.d("MicroMsg.MallProductManager", "product img path : " + bZM());
        }
        if (this.pgO.phv == null || this.pgO.phv.phQ == null) {
            i = 0;
        } else {
            i = this.pgO.phv.phQ.bJt;
        }
        if (this.pgO.pht != null) {
            i2 = this.pgO.pht.bJt;
        }
        this.phe = new e(i, i2);
        AppMethodBeat.o(43954);
    }

    public final e bZF() {
        AppMethodBeat.i(43955);
        if (this.phe == null) {
            this.phe = new e(0, 0);
        }
        e eVar = this.phe;
        AppMethodBeat.o(43955);
        return eVar;
    }

    public final String bZG() {
        AppMethodBeat.i(43956);
        String str;
        if (this.phd == null || bo.isNullOrNil(this.phd.url)) {
            str = this.pgW;
            AppMethodBeat.o(43956);
            return str;
        }
        str = this.phd.url;
        AppMethodBeat.o(43956);
        return str;
    }

    public final String bZH() {
        AppMethodBeat.i(43957);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.pgO.phs.phM.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.pha.get(mVar.phX);
            if (str != null) {
                Iterator it2 = mVar.phZ.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(43957);
        return stringBuilder2;
    }

    public final void al(Intent intent) {
        AppMethodBeat.i(43958);
        cx cxVar = new cx();
        cxVar.jBB = bo.bc(intent.getStringExtra("userName"), "");
        cxVar.vEV = bo.bc(intent.getStringExtra("telNumber"), "");
        cxVar.vEW = bo.bc(intent.getStringExtra("addressPostalCode"), "");
        cxVar.guO = bo.bc(intent.getStringExtra("proviceFirstStageName"), "");
        cxVar.guP = bo.bc(intent.getStringExtra("addressCitySecondStageName"), "");
        cxVar.guW = bo.bc(intent.getStringExtra("addressCountiesThirdStageName"), "");
        cxVar.naq = bo.bc(intent.getStringExtra("addressDetailInfo"), "");
        if (!(bo.isNullOrNil(cxVar.jBB) || bo.isNullOrNil(cxVar.vEV))) {
            this.pgU = cxVar;
        }
        AppMethodBeat.o(43958);
    }

    public final LinkedList<a> X(Activity activity) {
        AppMethodBeat.i(43959);
        LinkedList linkedList = new LinkedList();
        if (this.phc != null) {
            Iterator it = this.phc.iterator();
            while (it.hasNext()) {
                au auVar = (au) it.next();
                a aVar = new a();
                aVar.Name = auVar.Name;
                aVar.phA = auVar.phA;
                aVar.ncM = auVar.ncM;
                aVar.jCt = auVar.jCt;
                aVar.IconUrl = auVar.IconUrl;
                if (aVar.jCt == 1 && UI(aVar.ncM) > 0) {
                    aVar.phA = activity.getString(R.string.cxy, new Object[]{b.d((double) UI(aVar.ncM), this.pgO.phs.pcl)});
                }
                linkedList.add(aVar);
            }
        }
        AppMethodBeat.o(43959);
        return linkedList;
    }

    public final void AL(int i) {
        AppMethodBeat.i(43960);
        if (this.phb == null) {
            AppMethodBeat.o(43960);
            return;
        }
        if (i < this.phb.size() && i >= 0) {
            this.pgT = (ze) this.phb.get(i);
        }
        AppMethodBeat.o(43960);
    }

    public final int bZI() {
        AppMethodBeat.i(43961);
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
        AppMethodBeat.o(43961);
        return i;
    }

    public final int bZJ() {
        AppMethodBeat.i(43962);
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
                        i2 += ((xd) it2.next()).vQt;
                    }
                }
                i = i2;
            }
            i = i2;
        }
        AppMethodBeat.o(43962);
        return i;
    }

    private int UI(String str) {
        AppMethodBeat.i(43963);
        int i = 0;
        if (this.phf != null && this.phf.size() > 0) {
            LinkedList linkedList = (LinkedList) this.phf.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((xd) it.next()).vQt + i;
                }
            }
        }
        AppMethodBeat.o(43963);
        return i;
    }

    public final bpz bZK() {
        AppMethodBeat.i(43964);
        bpz bpz;
        if (this.pgV != null) {
            bpz = this.pgV;
            AppMethodBeat.o(43964);
            return bpz;
        }
        String str;
        if (this.pgN == null) {
            this.pgN = com.tencent.mm.plugin.product.a.a.bZC().bZE();
        }
        d dVar = this.pgN;
        if (dVar.phg == null || dVar.phg.size() <= 0) {
            str = null;
        } else {
            str = (String) dVar.phg.get(0);
        }
        if (bo.isNullOrNil(str)) {
            cx cxVar = this.pgU;
            if (cxVar == null || bo.isNullOrNil(cxVar.jBB)) {
                AppMethodBeat.o(43964);
                return null;
            }
            this.pgV = new bpz();
            this.pgV.naq = cxVar.jBB;
            this.pgV.wSm = 1;
            bpz = this.pgV;
            AppMethodBeat.o(43964);
            return bpz;
        }
        this.pgV = new bpz();
        this.pgV.naq = str;
        this.pgV.wSm = 1;
        bpz = this.pgV;
        AppMethodBeat.o(43964);
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
        AppMethodBeat.i(43965);
        if (bo.isNullOrNil(this.pgO.bZY())) {
            AppMethodBeat.o(43965);
            return null;
        }
        String UK = com.tencent.mm.plugin.product.ui.c.UK(this.pgO.bZY());
        AppMethodBeat.o(43965);
        return UK;
    }

    public final String bZN() {
        AppMethodBeat.i(43966);
        String str;
        if (this.pgO.phs != null && this.pgO.phs.phO != null) {
            str = this.pgO.phs.phO.url;
            AppMethodBeat.o(43966);
            return str;
        } else if (bo.isNullOrNil(this.pgO.phw)) {
            str = this.pgR;
            AppMethodBeat.o(43966);
            return str;
        } else {
            str = this.pgO.phw;
            AppMethodBeat.o(43966);
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
        AppMethodBeat.i(43967);
        if (this.mCount <= 0 || this.pgO == null || this.mCount > bZO() || this.pgO.phs == null || this.pgO.phs.phM == null) {
            AppMethodBeat.o(43967);
            return false;
        }
        AppMethodBeat.o(43967);
        return true;
    }

    public final boolean bZQ() {
        AppMethodBeat.i(43968);
        if (bZP()) {
            if (this.pha != null && this.pha.size() == this.pgY) {
                if (this.pgY > 0) {
                    if (this.phd != null && this.mCount > 0 && this.mCount <= bZO()) {
                        AppMethodBeat.o(43968);
                        return true;
                    }
                } else if (this.pgY == 0) {
                    AppMethodBeat.o(43968);
                    return true;
                }
            }
            AppMethodBeat.o(43968);
            return false;
        }
        AppMethodBeat.o(43968);
        return false;
    }

    public final boolean bZR() {
        AppMethodBeat.i(43969);
        if (!bZQ()) {
            AppMethodBeat.o(43969);
            return false;
        } else if (this.pgU == null) {
            AppMethodBeat.o(43969);
            return false;
        } else if (bZF().cab() || this.pgT != null) {
            AppMethodBeat.o(43969);
            return true;
        } else {
            AppMethodBeat.o(43969);
            return false;
        }
    }

    public final LinkedList<btx> bZS() {
        AppMethodBeat.i(43970);
        LinkedList linkedList = new LinkedList();
        btx btx = new btx();
        btx.jBv = this.mCount;
        btx.wrm = this.pgO.pho;
        btx.wOG = this.pgO.phw;
        btx.wOH = this.pgS;
        linkedList.add(btx);
        AppMethodBeat.o(43970);
        return linkedList;
    }

    public final cad bZT() {
        AppMethodBeat.i(43971);
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
        AppMethodBeat.o(43971);
        return cad;
    }

    public final void bZU() {
        AppMethodBeat.i(43972);
        if (this.pha == null) {
            AppMethodBeat.o(43972);
            return;
        }
        Iterator it = this.pgO.phs.phM.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            Iterator it2 = mVar.phZ.iterator();
            while (it2.hasNext()) {
                boolean z;
                h hVar = (h) it2.next();
                String str = mVar.phX;
                String str2 = hVar.id;
                String str3;
                e eVar;
                if (this.pha == null || this.pgZ == null) {
                    z = false;
                } else if (this.pha.containsKey(str)) {
                    str3 = (String) this.pha.get(str);
                    this.pha.put(str, str2);
                    str2 = V(this.pha);
                    this.pha.put(str, str3);
                    eVar = (e) this.pgZ.get(str2);
                    z = eVar != null ? eVar.phq > 0 : false;
                } else {
                    this.pha.put(str, str2);
                    str3 = V(this.pha);
                    this.pha.remove(str);
                    eVar = (e) this.pgZ.get(str3);
                    z = eVar != null ? eVar.phq > 0 : false;
                }
                hVar.phS = z;
                ab.d("MicroMsg.MallProductManager", "(" + mVar.phX + " , " + hVar.id + ") hasStock--> " + hVar.phS);
            }
        }
        AppMethodBeat.o(43972);
    }

    public static String V(Map<String, String> map) {
        AppMethodBeat.i(43973);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(43973);
            return null;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(43951);
                int compareTo = ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
                AppMethodBeat.o(43951);
                return compareTo;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(43973);
        return stringBuilder2;
    }

    private void ai(LinkedList<l> linkedList) {
        AppMethodBeat.i(43974);
        this.pgZ = new HashMap();
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.o(43974);
            return;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            l lVar = (l) linkedList.get(i);
            a(lVar.phU.split(";"), lVar);
        }
        bZU();
        AppMethodBeat.o(43974);
    }

    private void a(String[] strArr, l lVar) {
        AppMethodBeat.i(43975);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(43975);
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
            e eVar = (e) this.pgZ.get(stringBuilder.toString());
            if (eVar != null) {
                if (eVar.phh < lVar.phV) {
                    eVar.phh = lVar.phV;
                }
                if (eVar.phi > lVar.phV) {
                    eVar.phi = lVar.phV;
                }
                eVar.phq += lVar.phq;
            } else {
                eVar = new e();
                eVar.phh = lVar.phV;
                eVar.phi = lVar.phV;
                eVar.phq = lVar.phq;
                eVar.phW = lVar.phW;
                eVar.url = lVar.url;
                this.pgZ.put(stringBuilder.toString(), eVar);
            }
        }
        AppMethodBeat.o(43975);
    }

    public final String bZV() {
        AppMethodBeat.i(43976);
        b bVar = new b();
        bVar.title = this.pgO.phs.name;
        bVar.description = bZW();
        bVar.type = 13;
        bVar.url = bZN();
        bVar.thumburl = this.pgO.bZY();
        bVar.fgV = this.pgO.php;
        bVar.fgW = a(this.pgO);
        String a = b.a(bVar, null, null);
        AppMethodBeat.o(43976);
        return a;
    }

    public final String bZW() {
        AppMethodBeat.i(43977);
        String d = b.d((double) this.pgO.phs.phF, this.pgO.phs.pcl);
        AppMethodBeat.o(43977);
        return d;
    }

    public final String a(m mVar) {
        AppMethodBeat.i(43978);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.php).append("</type>");
        stringBuilder.append("<id>").append(mVar.pho).append("</id>");
        stringBuilder.append("<version>").append(mVar.phs.version).append("</version>");
        stringBuilder.append("<name>").append(bo.ani(mVar.phs.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.phs.phE).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.phs.phF).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.phs.phD).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(bo.ani(this.pgO.phw)).append("</sourceUrl>");
        if (mVar.phs.phG != null) {
            stringBuilder.append("<imgCount>").append(mVar.phs.phG.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.phs.phG.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(bo.ani((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(bo.ani(bZN())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(bo.ani(mVar.bZY())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.pgO.pht != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.pht.csB).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.pht.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.pht.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(43978);
        return stringBuilder2;
    }
}
