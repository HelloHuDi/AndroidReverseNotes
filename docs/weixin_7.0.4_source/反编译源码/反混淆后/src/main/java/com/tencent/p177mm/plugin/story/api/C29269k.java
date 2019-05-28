package com.tencent.p177mm.plugin.story.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.story.api.k */
public interface C29269k {

    /* renamed from: com.tencent.mm.plugin.story.api.k$b */
    public interface C29270b {
        void cvv();
    }

    /* renamed from: com.tencent.mm.plugin.story.api.k$a */
    public interface C29271a {
        /* renamed from: L */
        void mo47449L(boolean z, boolean z2);

        /* renamed from: a */
        void mo47450a(List<String> list, ArrayList<String> arrayList);

        /* renamed from: bs */
        void mo47451bs(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.story.api.k$c */
    public interface C29272c {
        /* renamed from: a */
        void mo47452a(C29270b c29270b);

        /* renamed from: b */
        void mo47453b(C29270b c29270b);

        List<String> cwY();

        List<String> cwZ();

        LinkedHashMap<String, ArrayList<Long>> cxa();

        int cxb();

        List<String> cxc();

        void cxd();
    }

    /* renamed from: ZW */
    boolean mo47443ZW(String str);

    /* renamed from: a */
    void mo47444a(C29271a c29271a);

    void destroy();

    void pause();

    void resume();

    void start();
}
