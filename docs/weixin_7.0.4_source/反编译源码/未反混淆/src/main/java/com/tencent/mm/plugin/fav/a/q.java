package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public interface q extends g {
    public static final String[] fnj = new String[]{j.a(c.ccO, "FavCdnInfo")};

    c LR(String str);

    void a(p pVar);

    boolean a(c cVar, String... strArr);

    void b(p pVar);

    boolean b(c cVar, String... strArr);

    void buL();

    LinkedList<c> buM();

    Cursor buN();

    Cursor buO();

    boolean e(c cVar);

    List<c> iA(long j);

    void iB(long j);

    boolean iC(long j);

    List<c> iz(long j);

    int r(long j, int i);

    void x(g gVar);
}
