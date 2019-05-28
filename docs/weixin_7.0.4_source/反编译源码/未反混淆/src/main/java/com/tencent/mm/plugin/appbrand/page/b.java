package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.view.View;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0001J\u0019\u0010\t\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0001J\u0019\u0010\r\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u000e0\u000eH\u0001J\u0019\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00100\u0010H\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00120\u0012H\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u0001J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001c\u001a\u00020\u0005H\u0004J\u0014\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fJ\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!J\t\u0010\"\u001a\u00020\u0005H\u0001J\u0019\u0010#\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0001J\u0019\u0010$\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010%\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0001J\u0019\u0010&\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u000e0\u000eH\u0001J\u0019\u0010'\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00100\u0010H\u0001J\u0019\u0010(\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00120\u0012H\u0001J\b\u0010)\u001a\u00020\u0005H\u0004¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callOnBackPressed", "", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", "hide", "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "removeAllLifecycleListeners", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnReadyListener", "removeOnWillDisappearListener", "show", "luggage-wxa-app_release"})
public abstract class b extends d implements f {
    public final /* synthetic */ g iqN = new g();

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f.b bVar) {
        this.iqN.a(bVar);
    }

    public final void a(c cVar) {
        this.iqN.a(cVar);
    }

    public final void a(f.d dVar) {
        this.iqN.a(dVar);
    }

    public final void a(e eVar) {
        this.iqN.a(eVar);
    }

    public final void b(com.tencent.mm.plugin.appbrand.jsapi.f.b bVar) {
        this.iqN.b(bVar);
    }

    public final void b(c cVar) {
        this.iqN.b(cVar);
    }

    public final void b(f.d dVar) {
        this.iqN.b(dVar);
    }

    public final void b(e eVar) {
        this.iqN.b(eVar);
    }

    public abstract View getContentView();

    public final void f(Runnable runnable) {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.post(runnable);
        }
    }
}
