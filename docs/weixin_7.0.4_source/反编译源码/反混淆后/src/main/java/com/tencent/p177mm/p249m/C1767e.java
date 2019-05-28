package com.tencent.p177mm.p249m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.m.e */
public class C1767e {
    private HashMap<String, String> ewb = new HashMap();
    protected boolean ewc = false;

    public C1767e() {
        AppMethodBeat.m2504i(57871);
        AppMethodBeat.m2505o(57871);
    }

    public final synchronized String getValue(String str) {
        String str2;
        AppMethodBeat.m2504i(57872);
        if (!this.ewc) {
            C4990ab.m7412e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            mo5312sg();
        }
        C4990ab.m7411d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.ewb.get(str));
        str2 = (String) this.ewb.get(str);
        AppMethodBeat.m2505o(57872);
        return str2;
    }

    public final int getInt(String str, int i) {
        AppMethodBeat.m2504i(57873);
        try {
            i = Integer.parseInt(getValue(str));
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(57873);
        return i;
    }

    /* renamed from: kC */
    public final synchronized List<String> mo5309kC(String str) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(57874);
        if (!this.ewc) {
            C4990ab.m7412e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            mo5312sg();
        }
        arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(str)) {
            for (String str2 : this.ewb.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.ewb.get(str2));
                }
            }
        }
        C4990ab.m7411d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(57874);
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        AppMethodBeat.m2504i(57875);
        if (!(str == null || str2 == null)) {
            C4990ab.m7411d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.ewb.put(str, str2);
        }
        AppMethodBeat.m2505o(57875);
    }

    /* renamed from: sg */
    public synchronized void mo5312sg() {
        AppMethodBeat.m2504i(57876);
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                this.ewc = true;
                C1720g.m3537RQ();
                mo5310p((String) C1720g.m3536RP().mo5239Ry().get(278529, null), false);
            }
        }
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                this.ewc = true;
                C1720g.m3537RQ();
                mo5310p((String) C1720g.m3536RP().mo5239Ry().get(278530, null), true);
            }
        }
        AppMethodBeat.m2505o(57876);
    }

    /* renamed from: a */
    public final synchronized void mo5306a(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.m2504i(57877);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(57877);
        } else {
            C4990ab.m7417i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), C1178g.m2587cz(str));
            if (z) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(278530, (Object) str);
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(278529, (Object) str);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(278530, (Object) "");
            }
            if (map != null) {
                m3642b(map, z);
            } else {
                mo5310p(str, z);
            }
            C4879a.xxA.mo10055m(new C6471cq());
            AppMethodBeat.m2505o(57877);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final void mo5310p(String str, boolean z) {
        AppMethodBeat.m2504i(57878);
        m3642b(C5049br.m7595z(str, "sysmsg"), z);
        AppMethodBeat.m2505o(57878);
    }

    /* renamed from: b */
    private void m3642b(Map<String, String> map, boolean z) {
        AppMethodBeat.m2504i(57879);
        if (map == null) {
            AppMethodBeat.m2505o(57879);
            return;
        }
        if (!z) {
            this.ewb.clear();
        }
        int i = 0;
        while (i < Downloads.MIN_WAIT_FOR_NETWORK) {
            String str;
            if (z) {
                str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? "" : Integer.valueOf(i));
            } else {
                str = ".sysmsg.dynacfg.Item" + (i == 0 ? "" : Integer.valueOf(i));
            }
            String str2 = str + ".$key";
            str = (String) map.get(str);
            str2 = (String) map.get(str2);
            if (str2 == null || C5046bo.isNullOrNil(str2.trim())) {
                break;
            }
            this.ewb.put(str2.trim(), str != null ? str : "");
            C4990ab.m7411d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
            i++;
        }
        C4990ab.m7411d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.ewb.toString());
        AppMethodBeat.m2505o(57879);
    }
}
