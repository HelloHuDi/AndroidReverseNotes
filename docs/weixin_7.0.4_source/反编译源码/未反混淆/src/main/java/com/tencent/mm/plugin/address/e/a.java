package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static Intent b(b bVar) {
        AppMethodBeat.i(17010);
        if (bVar == null) {
            ab.e("MicroMsg.AddrUtil", "addressObj == null");
            AppMethodBeat.o(17010);
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.gJh);
        intent.putExtra("userName", bVar.gJf);
        intent.putExtra("telNumber", bVar.gJg);
        intent.putExtra("addressPostalCode", bVar.gJd);
        intent.putExtra("proviceFirstStageName", bVar.gJa);
        intent.putExtra("addressCitySecondStageName", bVar.gJb);
        intent.putExtra("addressCountiesThirdStageName", bVar.gJc);
        intent.putExtra("addressDetailInfo", bVar.gJe);
        AppMethodBeat.o(17010);
        return intent;
    }
}
