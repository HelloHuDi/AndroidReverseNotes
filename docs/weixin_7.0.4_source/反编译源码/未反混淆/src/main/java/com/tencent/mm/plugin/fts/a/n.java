package com.tencent.mm.plugin.fts.a;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import java.util.HashSet;
import java.util.LinkedList;

public interface n extends d {
    void addSOSHistory(String str);

    void cancelSearchTask(a aVar);

    e createFTSUIUnit(int i, Context context, b bVar, int i2);

    LinkedList<e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, b bVar, int i);

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    c getFTSImageLoader();

    h getFTSIndexDB();

    i getFTSIndexStorage(int i);

    j getFTSMainDB();

    m getFTSTaskDaemon();

    com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int i);

    boolean isFTSContextReady();

    boolean isFTSIndexReady();

    void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d dVar);

    void registerIndexStorage(i iVar);

    void registerItemClickHandler(int i, com.tencent.mm.plugin.fts.a.d.a.b bVar);

    void registerNativeLogic(int i, k kVar);

    a search(int i, i iVar);

    int stringCompareUtfBinary(String str, String str2);

    void unregisterFTSUILogic(int i);

    void unregisterIndexStorage(int i);

    void unregisterItemClickHandler(int i);

    void unregisterNativeLogic(int i);

    void updateTopHitsRank(String str, l lVar, int i);
}
