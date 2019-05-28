package com.tencent.p177mm.plugin.fts.p419a;

import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.fts.a.k */
public interface C20848k {
    /* renamed from: a */
    C28106a mo23884a(C20846i c20846i);

    /* renamed from: a */
    void mo36116a(String str, C45966l c45966l, int i, HashMap<String, String> hashMap);

    void addSOSHistory(String str);

    void create();

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    void destroy();

    String getName();

    boolean isCreated();
}
