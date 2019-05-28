package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public interface i extends com.tencent.mm.kernel.c.a {

    public static final class c {
        public int axy;
        public String haO;
        public int har;
        public String nickname;
        public String username;
    }

    public static final class b {
        public String cEh;
        public int iDI;
        public List<c> items;
    }

    public enum a {
        CLICK("1"),
        SWIPE("2");
        
        public final String tag;

        static {
            AppMethodBeat.o(114921);
        }

        private a(String str) {
            this.tag = str;
        }
    }

    void a(Context context, c cVar, String str);

    void a(Context context, String str, a aVar);

    b axP();
}
