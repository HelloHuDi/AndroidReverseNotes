package com.google.android.exoplayer2.p110h;

import android.text.TextUtils;
import com.google.android.exoplayer2.p110h.C0867f.C0868a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C8686n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.h.r */
public interface C17668r extends C0867f {
    public static final C8686n<String> bqE = new C176691();

    /* renamed from: com.google.android.exoplayer2.h.r$b */
    public interface C0870b extends C0868a {
    }

    /* renamed from: com.google.android.exoplayer2.h.r$a */
    public static abstract class C8681a implements C0870b {
        private final C17672f bqx = new C17672f();

        /* renamed from: a */
        public abstract C17668r mo19211a(C17672f c17672f);

        /* renamed from: tm */
        public final /* synthetic */ C0867f mo2587tm() {
            return mo19211a(this.bqx);
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.r$c */
    public static class C8682c extends IOException {
        public final C17665i bib;
        public final int type;

        public C8682c(String str, C17665i c17665i) {
            super(str);
            this.bib = c17665i;
            this.type = 1;
        }

        public C8682c(IOException iOException, C17665i c17665i, int i) {
            super(iOException);
            this.bib = c17665i;
            this.type = i;
        }

        public C8682c(String str, IOException iOException, C17665i c17665i) {
            super(str, iOException);
            this.bib = c17665i;
            this.type = 1;
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.r$1 */
    static class C176691 implements C8686n<String> {
        C176691() {
        }

        /* renamed from: af */
        public final /* synthetic */ boolean mo19224af(Object obj) {
            AppMethodBeat.m2504i(95839);
            String aR = C17675v.m27560aR((String) obj);
            if (TextUtils.isEmpty(aR) || ((aR.contains("text") && !aR.contains("text/vtt")) || aR.contains("html") || aR.contains(BaseTemplateParser.POSTFIX_ORIG))) {
                AppMethodBeat.m2505o(95839);
                return false;
            }
            AppMethodBeat.m2505o(95839);
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.r$e */
    public static final class C17670e extends C8682c {
        public final Map<String, List<String>> bqG;
        public final int responseCode;

        public C17670e(int i, Map<String, List<String>> map, C17665i c17665i) {
            super("Response code: ".concat(String.valueOf(i)), c17665i);
            AppMethodBeat.m2504i(95841);
            this.responseCode = i;
            this.bqG = map;
            AppMethodBeat.m2505o(95841);
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.r$d */
    public static final class C17671d extends C8682c {
        public final String bqF;

        public C17671d(String str, C17665i c17665i) {
            super("Invalid content type: ".concat(String.valueOf(str)), c17665i);
            AppMethodBeat.m2504i(95840);
            this.bqF = str;
            AppMethodBeat.m2505o(95840);
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.r$f */
    public static final class C17672f {
        private final Map<String, String> bqH = new HashMap();
        private Map<String, String> bqI;

        public C17672f() {
            AppMethodBeat.m2504i(95842);
            AppMethodBeat.m2505o(95842);
        }

        /* renamed from: tv */
        public final synchronized Map<String, String> mo32361tv() {
            Map map;
            AppMethodBeat.m2504i(95843);
            if (this.bqI == null) {
                this.bqI = Collections.unmodifiableMap(new HashMap(this.bqH));
            }
            map = this.bqI;
            AppMethodBeat.m2505o(95843);
            return map;
        }
    }
}
