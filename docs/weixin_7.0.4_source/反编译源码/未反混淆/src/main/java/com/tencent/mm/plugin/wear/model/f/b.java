package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;

public abstract class b extends c {
    protected static String b(String str, bi biVar) {
        if (t.kH(str)) {
            String c = c(str, biVar);
            return String.format(ah.getContext().getString(R.string.d9m), new Object[]{h.adw(c), Character.valueOf(8203), h.aj(biVar).ncM});
        }
        return String.format(ah.getContext().getString(R.string.d9n), new Object[]{h.aj(biVar).ncM});
    }

    protected static String c(String str, bi biVar) {
        if (!t.kH(str)) {
            return str;
        }
        int ox = bf.ox(biVar.field_content);
        if (ox == -1) {
            return str;
        }
        String trim = biVar.field_content.substring(0, ox).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
