package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public interface g extends a {
    void C(Context context, int i);

    void a(Context context, String str, String str2, List<WxaEntryInfo> list);

    void b(Context context, int i, boolean z);

    void cB(Context context);
}
