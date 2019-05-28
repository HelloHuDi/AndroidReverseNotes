package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static void a(Intent intent, buv buv, int i) {
        AppMethodBeat.i(11203);
        ((j) g.K(j.class)).a(intent, buv, i);
        AppMethodBeat.o(11203);
    }

    public static void a(Intent intent, but but) {
        AppMethodBeat.i(11204);
        ((j) g.K(j.class)).a(intent, but, 15);
        AppMethodBeat.o(11204);
    }

    public static void a(Intent intent, bvk bvk, int i) {
        AppMethodBeat.i(11205);
        intent.putExtra("Contact_User", bvk.jBB);
        intent.putExtra("Contact_Nick", bvk.jCH);
        intent.putExtra("Contact_PyInitial", bvk.wbs);
        intent.putExtra("Contact_QuanPin", bvk.wbt);
        intent.putExtra("Contact_Sex", bvk.guN);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra(com.tencent.mm.ui.e.b.yfT, bvk.wlF);
        intent.putExtra("key_add_contact_openim_appid", bvk.fKh);
        intent.putExtra("key_add_contact_match_type", bvk.wWh);
        intent.putExtra("key_add_contact_custom_detail_visible", bvk.wWy.wKo);
        intent.putExtra("key_add_contact_custom_detail", bvk.wWy.naq);
        ab.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", bvk.wlF);
        AppMethodBeat.o(11205);
    }
}
