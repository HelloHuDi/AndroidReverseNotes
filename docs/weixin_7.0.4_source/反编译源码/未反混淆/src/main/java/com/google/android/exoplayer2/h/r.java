package com.google.android.exoplayer2.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.n;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface r extends f {
    public static final n<String> bqE = new n<String>() {
        public final /* synthetic */ boolean af(Object obj) {
            AppMethodBeat.i(95839);
            String aR = v.aR((String) obj);
            if (TextUtils.isEmpty(aR) || ((aR.contains("text") && !aR.contains("text/vtt")) || aR.contains("html") || aR.contains(BaseTemplateParser.POSTFIX_ORIG))) {
                AppMethodBeat.o(95839);
                return false;
            }
            AppMethodBeat.o(95839);
            return true;
        }
    };

    public interface b extends com.google.android.exoplayer2.h.f.a {
    }

    public static abstract class a implements b {
        private final f bqx = new f();

        public abstract r a(f fVar);

        public final /* synthetic */ f tm() {
            return a(this.bqx);
        }
    }

    public static class c extends IOException {
        public final i bib;
        public final int type;

        public c(String str, i iVar) {
            super(str);
            this.bib = iVar;
            this.type = 1;
        }

        public c(IOException iOException, i iVar, int i) {
            super(iOException);
            this.bib = iVar;
            this.type = i;
        }

        public c(String str, IOException iOException, i iVar) {
            super(str, iOException);
            this.bib = iVar;
            this.type = 1;
        }
    }

    public static final class e extends c {
        public final Map<String, List<String>> bqG;
        public final int responseCode;

        public e(int i, Map<String, List<String>> map, i iVar) {
            super("Response code: ".concat(String.valueOf(i)), iVar);
            AppMethodBeat.i(95841);
            this.responseCode = i;
            this.bqG = map;
            AppMethodBeat.o(95841);
        }
    }

    public static final class d extends c {
        public final String bqF;

        public d(String str, i iVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), iVar);
            AppMethodBeat.i(95840);
            this.bqF = str;
            AppMethodBeat.o(95840);
        }
    }

    public static final class f {
        private final Map<String, String> bqH = new HashMap();
        private Map<String, String> bqI;

        public f() {
            AppMethodBeat.i(95842);
            AppMethodBeat.o(95842);
        }

        public final synchronized Map<String, String> tv() {
            Map map;
            AppMethodBeat.i(95843);
            if (this.bqI == null) {
                this.bqI = Collections.unmodifiableMap(new HashMap(this.bqH));
            }
            map = this.bqI;
            AppMethodBeat.o(95843);
            return map;
        }
    }
}
