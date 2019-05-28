package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface e extends com.tencent.mm.kernel.c.a {

    public interface c {
        void bOi();
    }

    public interface a {
        String g(Map<String, String> map, String str);
    }

    public interface b {
        CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference);
    }

    void QB(String str);

    void QC(String str);

    CharSequence QD(String str);

    CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference);

    void a(String str, a aVar);

    void a(String str, b bVar);

    void a(String str, c cVar);

    void b(String str, c cVar);
}
