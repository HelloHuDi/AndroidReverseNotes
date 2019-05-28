package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.ad;
import java.util.List;

public interface j {
    ad MU(String str);

    boolean MV(String str);

    long MW(String str);

    List<String> MX(String str);

    Cursor i(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
