package com.tencent.p177mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.api.b */
public final class C17915b {
    /* renamed from: a */
    public static void m28130a(Intent intent, buv buv, int i) {
        AppMethodBeat.m2504i(11203);
        ((C32250j) C1720g.m3528K(C32250j.class)).mo20992a(intent, buv, i);
        AppMethodBeat.m2505o(11203);
    }

    /* renamed from: a */
    public static void m28129a(Intent intent, but but) {
        AppMethodBeat.m2504i(11204);
        ((C32250j) C1720g.m3528K(C32250j.class)).mo20991a(intent, but, 15);
        AppMethodBeat.m2505o(11204);
    }

    /* renamed from: a */
    public static void m28131a(Intent intent, bvk bvk, int i) {
        AppMethodBeat.m2504i(11205);
        intent.putExtra("Contact_User", bvk.jBB);
        intent.putExtra("Contact_Nick", bvk.jCH);
        intent.putExtra("Contact_PyInitial", bvk.wbs);
        intent.putExtra("Contact_QuanPin", bvk.wbt);
        intent.putExtra("Contact_Sex", bvk.guN);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra(C5495b.yfT, bvk.wlF);
        intent.putExtra("key_add_contact_openim_appid", bvk.fKh);
        intent.putExtra("key_add_contact_match_type", bvk.wWh);
        intent.putExtra("key_add_contact_custom_detail_visible", bvk.wWy.wKo);
        intent.putExtra("key_add_contact_custom_detail", bvk.wWy.naq);
        C4990ab.m7417i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", bvk.wlF);
        AppMethodBeat.m2505o(11205);
    }
}
