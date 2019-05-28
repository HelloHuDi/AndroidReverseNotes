package com.tencent.p177mm.plugin.p436hp.tinker;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C2678a;
import com.tencent.p177mm.plugin.p436hp.p1552c.C46030b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.protocal.protobuf.bhv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tinkerboots.sdk.C44598a;
import com.tinkerboots.sdk.p688a.p1579a.C46841a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.hp.tinker.f */
public final class C21074f extends C46841a {
    public final boolean bGs() {
        AppMethodBeat.m2504i(90658);
        boolean bGs = super.bGs();
        AppMethodBeat.m2505o(90658);
        return bGs;
    }

    /* renamed from: L */
    public final void mo36395L(Map<String, String> map) {
        AppMethodBeat.m2504i(90659);
        super.mo36395L(map);
        C46028b.m85603wW(2);
        String str = "tinker_id_" + C1760a.m3622Ul();
        String str2 = C1760a.eSh == null ? "" : "tinker_id_" + C1760a.eSh;
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
        C4990ab.m7417i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", str, str2, stringBuilder.toString());
        C1720g.m3540Rg().mo14541a(new C46030b(str, str2, linkedList), 0);
        AppMethodBeat.m2505o(90659);
    }

    public final void bGt() {
        AppMethodBeat.m2504i(90660);
        super.bGt();
        C44598a.dWj().mo71471iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) C1668a.m3396Ra()) & 4294967295L)).mo71471iN(TencentLocation.NETWORK_PROVIDER, String.valueOf(C5023at.isWifi(C4996ah.getContext()) ? 3 : 2));
        List<C2678a> aVJ = ((C20015c) C1720g.m3528K(C20015c.class)).aVJ();
        if (aVJ != null) {
            for (C2678a c2678a : aVJ) {
                C44598a.dWj().mo71471iN(Integer.toHexString(c2678a.field_key), String.valueOf(c2678a.field_dau));
            }
        }
        AppMethodBeat.m2505o(90660);
    }
}
