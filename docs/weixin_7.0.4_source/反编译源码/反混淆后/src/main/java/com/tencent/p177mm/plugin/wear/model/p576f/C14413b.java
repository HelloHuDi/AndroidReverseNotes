package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.wear.model.f.b */
public abstract class C14413b extends C29724c {
    /* renamed from: b */
    protected static String m22631b(String str, C7620bi c7620bi) {
        if (C1855t.m3896kH(str)) {
            String c = C14413b.m22632c(str, c7620bi);
            return String.format(C4996ah.getContext().getString(C25738R.string.d9m), new Object[]{C43845h.adw(c), Character.valueOf(8203), C43845h.m78628aj(c7620bi).ncM});
        }
        return String.format(C4996ah.getContext().getString(C25738R.string.d9n), new Object[]{C43845h.m78628aj(c7620bi).ncM});
    }

    /* renamed from: c */
    protected static String m22632c(String str, C7620bi c7620bi) {
        if (!C1855t.m3896kH(str)) {
            return str;
        }
        int ox = C1829bf.m3761ox(c7620bi.field_content);
        if (ox == -1) {
            return str;
        }
        String trim = c7620bi.field_content.substring(0, ox).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
