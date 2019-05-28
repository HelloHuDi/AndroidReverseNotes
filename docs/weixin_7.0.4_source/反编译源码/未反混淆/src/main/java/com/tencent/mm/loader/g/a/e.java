package com.tencent.mm.loader.g.a;

import a.f.b.j;
import a.f.b.v;
import a.l;
import a.y;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.d;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
public final class e {
    private static final String TAG = TAG;
    public static final e eRA = new e();
    private static volatile d<c> eRz;

    private e() {
    }

    public static d<c> TV() {
        if (eRz == null) {
            synchronized (v.aN(d.class)) {
                eRz = new d(new g(new a(BaseClientBuilder.API_PRIORITY_OTHER), new h(3), new h(3), new h(3), 3, "imageLoader"));
                y yVar = y.AUy;
            }
        }
        d dVar = eRz;
        if (dVar == null) {
            j.dWJ();
        }
        return dVar;
    }
}
