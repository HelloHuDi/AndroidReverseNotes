package com.tencent.mm.plugin.hp.tinker;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f extends a {
    public final boolean bGs() {
        AppMethodBeat.i(90658);
        boolean bGs = super.bGs();
        AppMethodBeat.o(90658);
        return bGs;
    }

    public final void L(Map<String, String> map) {
        AppMethodBeat.i(90659);
        super.L(map);
        b.wW(2);
        String str = "tinker_id_" + com.tencent.mm.loader.j.a.Ul();
        String str2 = com.tencent.mm.loader.j.a.eSh == null ? "" : "tinker_id_" + com.tencent.mm.loader.j.a.eSh;
        LinkedList linkedList = new LinkedList();
        for (String str3 : map.keySet()) {
            bhv bhv = new bhv();
            bhv.key = str3;
            bhv.value = (String) map.get(str3);
            linkedList.add(bhv);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bhv bhv2 = (bhv) it.next();
            stringBuilder.append(bhv2.key).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(bhv2.value).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        ab.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", str, str2, stringBuilder.toString());
        g.Rg().a(new com.tencent.mm.plugin.hp.c.b(str, str2, linkedList), 0);
        AppMethodBeat.o(90659);
    }

    public final void bGt() {
        AppMethodBeat.i(90660);
        super.bGt();
        com.tinkerboots.sdk.a.dWj().iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.Ra()) & 4294967295L)).iN(TencentLocation.NETWORK_PROVIDER, String.valueOf(at.isWifi(ah.getContext()) ? 3 : 2));
        List<com.tencent.mm.plugin.boots.a.a> aVJ = ((c) g.K(c.class)).aVJ();
        if (aVJ != null) {
            for (com.tencent.mm.plugin.boots.a.a aVar : aVJ) {
                com.tinkerboots.sdk.a.dWj().iN(Integer.toHexString(aVar.field_key), String.valueOf(aVar.field_dau));
            }
        }
        AppMethodBeat.o(90660);
    }
}
