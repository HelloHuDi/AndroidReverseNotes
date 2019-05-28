package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class AppBrandRecentView extends RecyclerView {
    private e jaq;
    com.tencent.mm.plugin.appbrand.widget.recentview.d.a jmG;

    public interface a<T> {
        void a(MenuItem menuItem, int i, T t);
    }

    public enum f {
        RECENT_APP_BRAND,
        MY_APP_BRAND;

        static {
            AppMethodBeat.o(114930);
        }
    }

    public interface c<T> {
        List<T> qr(int i);
    }

    public interface d {
        void aQf();
    }

    public interface e {
        void qs(int i);
    }

    public interface b {
        boolean a(View view, a aVar, float f, float f2);

        boolean b(View view, a aVar, float f, float f2);
    }

    public abstract android.support.v7.widget.RecyclerView.a getAdapter();

    public abstract int getCount();

    public abstract b getOnItemClickListener();

    public abstract void refresh();

    public abstract void release();

    public abstract void setDataQuery(c cVar);

    public abstract void setOnItemClickListener(b bVar);

    public AppBrandRecentView(Context context) {
        super(context);
    }

    public AppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSceneFactory(com.tencent.mm.plugin.appbrand.widget.recentview.d.a aVar) {
        this.jmG = aVar;
    }

    public com.tencent.mm.plugin.appbrand.widget.recentview.d.a getSceneFactory() {
        return this.jmG;
    }

    public void setRefreshListener(e eVar) {
        this.jaq = eVar;
    }

    public e getRefreshListener() {
        return this.jaq;
    }
}
