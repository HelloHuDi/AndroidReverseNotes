package com.tencent.p177mm.plugin.messenger.p993a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.p177mm.kernel.p242c.C1694a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.messenger.a.e */
public interface C12514e extends C1694a {

    /* renamed from: com.tencent.mm.plugin.messenger.a.e$c */
    public interface C12515c {
        void bOi();
    }

    /* renamed from: com.tencent.mm.plugin.messenger.a.e$a */
    public interface C12516a {
        /* renamed from: g */
        String mo24443g(Map<String, String> map, String str);
    }

    /* renamed from: com.tencent.mm.plugin.messenger.a.e$b */
    public interface C12517b {
        /* renamed from: a */
        CharSequence mo7904a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference);
    }

    /* renamed from: QB */
    void mo24434QB(String str);

    /* renamed from: QC */
    void mo24435QC(String str);

    /* renamed from: QD */
    CharSequence mo24436QD(String str);

    /* renamed from: a */
    CharSequence mo24437a(String str, Bundle bundle, WeakReference<Context> weakReference);

    /* renamed from: a */
    void mo24438a(String str, C12516a c12516a);

    /* renamed from: a */
    void mo24439a(String str, C12517b c12517b);

    /* renamed from: a */
    void mo24440a(String str, C12515c c12515c);

    /* renamed from: b */
    void mo24441b(String str, C12515c c12515c);
}
