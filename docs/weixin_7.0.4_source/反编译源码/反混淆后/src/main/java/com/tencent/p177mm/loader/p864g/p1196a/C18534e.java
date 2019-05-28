package com.tencent.p177mm.loader.p864g.p1196a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C44855v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.g.a.e */
public final class C18534e {
    private static final String TAG = TAG;
    public static final C18534e eRA = new C18534e();
    private static volatile C26366d<C26365c> eRz;

    private C18534e() {
    }

    /* renamed from: TV */
    public static C26366d<C26365c> m28845TV() {
        if (eRz == null) {
            synchronized (C44855v.m82055aN(C26366d.class)) {
                eRz = new C26366d(new C18536g(new C46886a(BaseClientBuilder.API_PRIORITY_OTHER), new C18537h(3), new C18537h(3), new C18537h(3), 3, "imageLoader"));
                C37091y c37091y = C37091y.AUy;
            }
        }
        C26366d c26366d = eRz;
        if (c26366d == null) {
            C25052j.dWJ();
        }
        return c26366d;
    }
}
