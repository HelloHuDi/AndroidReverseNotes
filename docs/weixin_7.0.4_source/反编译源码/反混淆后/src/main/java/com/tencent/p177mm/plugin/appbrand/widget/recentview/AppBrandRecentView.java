package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d.C11049a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView */
public abstract class AppBrandRecentView extends RecyclerView {
    private C38619e jaq;
    C11049a jmG;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$a */
    public interface C19906a<T> {
        /* renamed from: a */
        void mo35152a(MenuItem menuItem, int i, T t);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$f */
    public enum C19907f {
        RECENT_APP_BRAND,
        MY_APP_BRAND;

        static {
            AppMethodBeat.m2505o(114930);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$c */
    public interface C38617c<T> {
        /* renamed from: qr */
        List<T> mo45126qr(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$d */
    public interface C38618d {
        void aQf();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$e */
    public interface C38619e {
        /* renamed from: qs */
        void mo6518qs(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView$b */
    public interface C38620b {
        /* renamed from: a */
        boolean mo35067a(View view, C42748a c42748a, float f, float f2);

        /* renamed from: b */
        boolean mo35068b(View view, C42748a c42748a, float f, float f2);
    }

    public abstract C41523a getAdapter();

    public abstract int getCount();

    public abstract C38620b getOnItemClickListener();

    public abstract void refresh();

    public abstract void release();

    public abstract void setDataQuery(C38617c c38617c);

    public abstract void setOnItemClickListener(C38620b c38620b);

    public AppBrandRecentView(Context context) {
        super(context);
    }

    public AppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSceneFactory(C11049a c11049a) {
        this.jmG = c11049a;
    }

    public C11049a getSceneFactory() {
        return this.jmG;
    }

    public void setRefreshListener(C38619e c38619e) {
        this.jaq = c38619e;
    }

    public C38619e getRefreshListener() {
        return this.jaq;
    }
}
