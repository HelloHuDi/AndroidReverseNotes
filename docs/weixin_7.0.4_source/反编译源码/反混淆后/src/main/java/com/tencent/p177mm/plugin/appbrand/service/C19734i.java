package com.tencent.p177mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.service.i */
public interface C19734i extends C1694a {

    /* renamed from: com.tencent.mm.plugin.appbrand.service.i$c */
    public static final class C10734c {
        public int axy;
        public String haO;
        public int har;
        public String nickname;
        public String username;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.service.i$b */
    public static final class C19733b {
        public String cEh;
        public int iDI;
        public List<C10734c> items;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.service.i$a */
    public enum C19735a {
        CLICK("1"),
        SWIPE("2");
        
        public final String tag;

        static {
            AppMethodBeat.m2505o(114921);
        }

        private C19735a(String str) {
            this.tag = str;
        }
    }

    /* renamed from: a */
    void mo34967a(Context context, C10734c c10734c, String str);

    /* renamed from: a */
    void mo34968a(Context context, String str, C19735a c19735a);

    C19733b axP();
}
