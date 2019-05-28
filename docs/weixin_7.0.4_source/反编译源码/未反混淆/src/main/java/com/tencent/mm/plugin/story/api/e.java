package com.tencent.mm.plugin.story.api;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.story.api.k.c;
import com.tencent.mm.protocal.protobuf.cfc;
import java.util.List;

public interface e extends d {
    void addStoryStatusNotifyListener(l lVar);

    boolean canPostStory();

    void checkPost();

    boolean checkReportFromChatting(int i, String str);

    void enterGallery(List<String> list);

    String getAccStoryCachePath();

    String getAccStoryPath();

    String getAccStoryTmpPath();

    c getContactFetcher();

    b getFavourUserChecker();

    f getStoryBasicConfig();

    k getStoryStateFetcher(String str);

    m getStoryUIFactory();

    cfc getStoryUserInfo();

    boolean hasNewStory(String str);

    boolean isShowStoryCheck();

    boolean isStoryExist(String str);

    boolean isStoryUnread(String str);

    void loadStory(String str, String str2);

    boolean preLoadVideoViewMgr(String str);

    void preloadForSnsUser(String str, boolean z);

    void reportWaitPlayList(List<String> list, long j);

    boolean showStoryEntranceDialog(Context context, String str, int i);

    void updateStoryUserInfo(String str, cfc cfc);
}
