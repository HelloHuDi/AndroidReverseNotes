package com.tencent.p177mm.plugin.fts.p419a;

import android.content.Context;
import com.tencent.p177mm.kernel.p241b.C7481d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C20847d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3157b;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fts.a.n */
public interface C12029n extends C7481d {
    void addSOSHistory(String str);

    void cancelSearchTask(C28106a c28106a);

    C45970e createFTSUIUnit(int i, Context context, C39133b c39133b, int i2);

    LinkedList<C45970e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, C39133b c39133b, int i);

    void deleteSOSHistory();

    void deleteSOSHistory(String str);

    C3159c getFTSImageLoader();

    C34206h getFTSIndexDB();

    C34207i getFTSIndexStorage(int i);

    C28113j getFTSMainDB();

    C12028m getFTSTaskDaemon();

    C3157b getItemClickHandler(int i);

    boolean isFTSContextReady();

    boolean isFTSIndexReady();

    void registerFTSUILogic(C20847d c20847d);

    void registerIndexStorage(C34207i c34207i);

    void registerItemClickHandler(int i, C3157b c3157b);

    void registerNativeLogic(int i, C20848k c20848k);

    C28106a search(int i, C20846i c20846i);

    int stringCompareUtfBinary(String str, String str2);

    void unregisterFTSUILogic(int i);

    void unregisterIndexStorage(int i);

    void unregisterItemClickHandler(int i);

    void unregisterNativeLogic(int i);

    void updateTopHitsRank(String str, C45966l c45966l, int i);
}
