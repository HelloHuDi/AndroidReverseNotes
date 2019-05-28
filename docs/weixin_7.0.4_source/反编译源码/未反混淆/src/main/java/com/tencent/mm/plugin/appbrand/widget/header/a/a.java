package com.tencent.mm.plugin.appbrand.widget.header.a;

import android.content.res.Configuration;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;

public interface a {

    public interface a {
        void fa(boolean z);
    }

    public interface b {
        void aQg();

        void aQh();
    }

    void a(Configuration configuration);

    void aQb();

    void aQc();

    void aQd();

    int getRecentAppBrandCount();

    int getStarAppBrandCount();

    void qu(int i);

    void refresh();

    void setCollectionRefreshListener(e eVar);

    void setIOnLaunchUIListener(b bVar);

    void setOnEmptyViewListener(a aVar);

    void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b bVar);

    void setUsageRefreshListener(e eVar);
}
