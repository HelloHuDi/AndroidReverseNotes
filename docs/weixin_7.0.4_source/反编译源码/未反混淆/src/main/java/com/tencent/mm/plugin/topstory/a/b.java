package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.xweb.WebView;

public interface b extends d {
    e getRedDotMgr();

    f getReporter();

    WebView.d getWebViewType();

    void onVideoListUIDestroy(chv chv);

    void onVideoListUIPause();

    void onVideoListUIResume();
}
