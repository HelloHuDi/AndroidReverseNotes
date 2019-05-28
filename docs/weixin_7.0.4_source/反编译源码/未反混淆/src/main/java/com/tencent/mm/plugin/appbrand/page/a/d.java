package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public interface d {

    public enum a {
        BLACK(WebView.NIGHT_MODE_COLOR),
        WHITE(-1);
        
        public final int ivl;

        static {
            AppMethodBeat.o(87351);
        }

        private a(int i) {
            this.ivl = i;
        }

        public static a Dk(String str) {
            AppMethodBeat.i(87350);
            if (!TextUtils.isEmpty(str)) {
                for (a aVar : values()) {
                    if (aVar.name().equalsIgnoreCase(str)) {
                        AppMethodBeat.o(87350);
                        return aVar;
                    }
                }
            }
            a aVar2 = WHITE;
            AppMethodBeat.o(87350);
            return aVar2;
        }
    }
}
