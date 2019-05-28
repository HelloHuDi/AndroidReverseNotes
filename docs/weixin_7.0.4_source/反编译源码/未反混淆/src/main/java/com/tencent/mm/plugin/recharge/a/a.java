package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class a implements at {
    private List<com.tencent.mm.plugin.recharge.model.a> pFJ = null;

    public static a cea() {
        AppMethodBeat.i(44176);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(44176);
        return aVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        AppMethodBeat.i(44177);
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.pFM)) {
            AppMethodBeat.o(44177);
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> ceb = ceb();
        for (com.tencent.mm.plugin.recharge.model.a aVar2 : ceb) {
            if (aVar.pFM.equals(aVar2.pFM)) {
                if (bo.isNullOrNil(aVar.name)) {
                    aVar.name = aVar2.name;
                }
                ceb.remove(aVar2);
                ceb.add(0, aVar);
                cK(ceb);
                AppMethodBeat.o(44177);
                return true;
            }
        }
        ceb.add(0, aVar);
        cK(ceb);
        AppMethodBeat.o(44177);
        return true;
    }

    public final void cK(List<com.tencent.mm.plugin.recharge.model.a> list) {
        AppMethodBeat.i(44178);
        this.pFJ = list;
        if (list == null || list.size() == 0) {
            this.pFJ = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.recharge.model.a toJson : this.pFJ) {
            jSONArray.put(toJson.toJson());
            ab.i("MicroMsg.SubCoreRecharge", "number: %s", toJson.name);
        }
        ab.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        g.RP().Ry().set(270337, jSONArray.toString());
        g.RP().Ry().dsb();
        AppMethodBeat.o(44178);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> ceb() {
        AppMethodBeat.i(44179);
        if (this.pFJ != null) {
            List list = this.pFJ;
            AppMethodBeat.o(44179);
            return list;
        }
        this.pFJ = new LinkedList();
        String str = (String) g.RP().Ry().get(270337, null);
        List<com.tencent.mm.plugin.recharge.model.a> list2;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.SubCoreRecharge", "empty history");
            list2 = this.pFJ;
            AppMethodBeat.o(44179);
            return list2;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < Math.min(jSONArray.length(), 100); i++) {
                com.tencent.mm.plugin.recharge.model.a aj = com.tencent.mm.plugin.recharge.model.a.aj(jSONArray.getJSONObject(i));
                if (aj != null) {
                    this.pFJ.add(aj);
                }
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.SubCoreRecharge", e, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < Math.min(split.length, 100); i2++) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        this.pFJ.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.pFJ.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
            }
        }
        ab.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.pFJ.size());
        list2 = this.pFJ;
        AppMethodBeat.o(44179);
        return list2;
    }

    public static com.tencent.mm.plugin.recharge.model.a cec() {
        AppMethodBeat.i(44180);
        String str = (String) g.RP().Ry().get(6, null);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(44180);
            return null;
        }
        com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(str, ah.getContext().getString(R.string.fr5), 3);
        AppMethodBeat.o(44180);
        return aVar;
    }
}
