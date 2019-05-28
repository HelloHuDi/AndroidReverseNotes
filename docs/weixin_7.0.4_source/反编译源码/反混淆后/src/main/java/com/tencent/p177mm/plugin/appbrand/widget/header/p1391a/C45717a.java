package com.tencent.p177mm.plugin.appbrand.widget.header.p1391a;

import android.content.res.Configuration;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38619e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.header.a.a */
public interface C45717a {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.header.a.a$a */
    public interface C27395a {
        /* renamed from: fa */
        void mo39738fa(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.header.a.a$b */
    public interface C42729b {
        void aQg();

        void aQh();
    }

    /* renamed from: a */
    void mo68131a(Configuration configuration);

    void aQb();

    void aQc();

    void aQd();

    int getRecentAppBrandCount();

    int getStarAppBrandCount();

    /* renamed from: qu */
    void mo68138qu(int i);

    void refresh();

    void setCollectionRefreshListener(C38619e c38619e);

    void setIOnLaunchUIListener(C42729b c42729b);

    void setOnEmptyViewListener(C27395a c27395a);

    void setReporter(C19916b c19916b);

    void setUsageRefreshListener(C38619e c38619e);
}
