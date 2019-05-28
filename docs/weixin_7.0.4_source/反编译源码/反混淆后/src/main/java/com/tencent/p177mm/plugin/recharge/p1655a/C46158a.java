package com.tencent.p177mm.plugin.recharge.p1655a;

import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.recharge.a.a */
public class C46158a implements C1816at {
    private List<C43420a> pFJ = null;

    public static C46158a cea() {
        AppMethodBeat.m2504i(44176);
        C46158a c46158a = (C46158a) C7485q.m12925Y(C46158a.class);
        AppMethodBeat.m2505o(44176);
        return c46158a;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
    }

    public final void onAccountRelease() {
    }

    /* renamed from: a */
    public final boolean mo74108a(C43420a c43420a) {
        AppMethodBeat.m2504i(44177);
        if (c43420a == null || !PhoneNumberUtils.isGlobalPhoneNumber(c43420a.pFM)) {
            AppMethodBeat.m2505o(44177);
            return false;
        }
        List<C43420a> ceb = ceb();
        for (C43420a c43420a2 : ceb) {
            if (c43420a.pFM.equals(c43420a2.pFM)) {
                if (C5046bo.isNullOrNil(c43420a.name)) {
                    c43420a.name = c43420a2.name;
                }
                ceb.remove(c43420a2);
                ceb.add(0, c43420a);
                mo74109cK(ceb);
                AppMethodBeat.m2505o(44177);
                return true;
            }
        }
        ceb.add(0, c43420a);
        mo74109cK(ceb);
        AppMethodBeat.m2505o(44177);
        return true;
    }

    /* renamed from: cK */
    public final void mo74109cK(List<C43420a> list) {
        AppMethodBeat.m2504i(44178);
        this.pFJ = list;
        if (list == null || list.size() == 0) {
            this.pFJ = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (C43420a toJson : this.pFJ) {
            jSONArray.put(toJson.toJson());
            C4990ab.m7417i("MicroMsg.SubCoreRecharge", "number: %s", toJson.name);
        }
        C4990ab.m7410d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        C1720g.m3536RP().mo5239Ry().set(270337, jSONArray.toString());
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(44178);
    }

    public final List<C43420a> ceb() {
        AppMethodBeat.m2504i(44179);
        if (this.pFJ != null) {
            List list = this.pFJ;
            AppMethodBeat.m2505o(44179);
            return list;
        }
        this.pFJ = new LinkedList();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(270337, null);
        List<C43420a> list2;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.SubCoreRecharge", "empty history");
            list2 = this.pFJ;
            AppMethodBeat.m2505o(44179);
            return list2;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < Math.min(jSONArray.length(), 100); i++) {
                C43420a aj = C43420a.m77502aj(jSONArray.getJSONObject(i));
                if (aj != null) {
                    this.pFJ.add(aj);
                }
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreRecharge", e, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < Math.min(split.length, 100); i2++) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        this.pFJ.add(new C43420a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.pFJ.add(new C43420a(split2[0], "", 2));
                    }
                }
            }
        }
        C4990ab.m7416i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.pFJ.size());
        list2 = this.pFJ;
        AppMethodBeat.m2505o(44179);
        return list2;
    }

    public static C43420a cec() {
        AppMethodBeat.m2504i(44180);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(44180);
            return null;
        }
        C43420a c43420a = new C43420a(str, C4996ah.getContext().getString(C25738R.string.fr5), 3);
        AppMethodBeat.m2505o(44180);
        return c43420a;
    }
}
