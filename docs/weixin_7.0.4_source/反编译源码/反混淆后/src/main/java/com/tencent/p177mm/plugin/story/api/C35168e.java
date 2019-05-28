package com.tencent.p177mm.plugin.story.api;

import android.content.Context;
import com.tencent.p177mm.kernel.p241b.C7481d;
import com.tencent.p177mm.plugin.story.api.C29269k.C29272c;
import com.tencent.p177mm.protocal.protobuf.cfc;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.story.api.e */
public interface C35168e extends C7481d {
    void addStoryStatusNotifyListener(C13736l c13736l);

    boolean canPostStory();

    void checkPost();

    boolean checkReportFromChatting(int i, String str);

    void enterGallery(List<String> list);

    String getAccStoryCachePath();

    String getAccStoryPath();

    String getAccStoryTmpPath();

    C29272c getContactFetcher();

    C4107b getFavourUserChecker();

    C35169f getStoryBasicConfig();

    C29269k getStoryStateFetcher(String str);

    C46269m getStoryUIFactory();

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
