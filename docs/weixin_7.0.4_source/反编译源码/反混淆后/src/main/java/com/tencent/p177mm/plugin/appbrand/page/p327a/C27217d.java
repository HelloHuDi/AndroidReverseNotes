package com.tencent.p177mm.plugin.appbrand.page.p327a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.page.a.d */
public interface C27217d {

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a.d$a */
    public enum C10657a {
        BLACK(WebView.NIGHT_MODE_COLOR),
        WHITE(-1);
        
        public final int ivl;

        static {
            AppMethodBeat.m2505o(87351);
        }

        private C10657a(int i) {
            this.ivl = i;
        }

        /* renamed from: Dk */
        public static C10657a m18353Dk(String str) {
            AppMethodBeat.m2504i(87350);
            if (!TextUtils.isEmpty(str)) {
                for (C10657a c10657a : C10657a.values()) {
                    if (c10657a.name().equalsIgnoreCase(str)) {
                        AppMethodBeat.m2505o(87350);
                        return c10657a;
                    }
                }
            }
            C10657a c10657a2 = WHITE;
            AppMethodBeat.m2505o(87350);
            return c10657a2;
        }
    }
}
