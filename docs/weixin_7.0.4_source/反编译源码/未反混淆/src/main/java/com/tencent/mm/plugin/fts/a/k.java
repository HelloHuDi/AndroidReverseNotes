package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.HashMap;

public interface k {
    a a(i iVar);

    void a(String str, l lVar, int i, HashMap<String, String> hashMap);

    void addSOSHistory(String str);

    void create();

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    void destroy();

    String getName();

    boolean isCreated();
}
