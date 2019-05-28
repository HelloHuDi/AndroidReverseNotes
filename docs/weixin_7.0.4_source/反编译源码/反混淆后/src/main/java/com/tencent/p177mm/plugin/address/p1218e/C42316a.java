package com.tencent.p177mm.plugin.address.p1218e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.e.a */
public final class C42316a {
    /* renamed from: b */
    public static Intent m74836b(C38090b c38090b) {
        AppMethodBeat.m2504i(17010);
        if (c38090b == null) {
            C4990ab.m7412e("MicroMsg.AddrUtil", "addressObj == null");
            AppMethodBeat.m2505o(17010);
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", c38090b.gJh);
        intent.putExtra("userName", c38090b.gJf);
        intent.putExtra("telNumber", c38090b.gJg);
        intent.putExtra("addressPostalCode", c38090b.gJd);
        intent.putExtra("proviceFirstStageName", c38090b.gJa);
        intent.putExtra("addressCitySecondStageName", c38090b.gJb);
        intent.putExtra("addressCountiesThirdStageName", c38090b.gJc);
        intent.putExtra("addressDetailInfo", c38090b.gJe);
        AppMethodBeat.m2505o(17010);
        return intent;
    }
}
