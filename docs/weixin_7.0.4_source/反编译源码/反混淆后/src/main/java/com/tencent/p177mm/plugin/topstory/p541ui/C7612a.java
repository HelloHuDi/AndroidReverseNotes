package com.tencent.p177mm.plugin.topstory.p541ui;

import com.tencent.p177mm.kernel.p241b.C7481d;
import com.tencent.p177mm.plugin.topstory.p541ui.home.C4227d;

/* renamed from: com.tencent.mm.plugin.topstory.ui.a */
public interface C7612a extends C7481d {

    /* renamed from: com.tencent.mm.plugin.topstory.ui.a$a */
    public interface C7613a {
        void abA(String str);
    }

    C4227d getWebViewMgr();

    void setHaokanEventListener(C7613a c7613a);

    void tryToCreateTopStoryWebView();
}
