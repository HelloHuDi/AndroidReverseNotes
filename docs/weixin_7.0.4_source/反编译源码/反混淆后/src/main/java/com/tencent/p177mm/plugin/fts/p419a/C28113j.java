package com.tencent.p177mm.plugin.fts.p419a;

import android.database.Cursor;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.j */
public interface C28113j {
    /* renamed from: MU */
    C7616ad mo46033MU(String str);

    /* renamed from: MV */
    boolean mo46034MV(String str);

    /* renamed from: MW */
    long mo46035MW(String str);

    /* renamed from: MX */
    List<String> mo46036MX(String str);

    /* renamed from: i */
    Cursor mo46037i(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
