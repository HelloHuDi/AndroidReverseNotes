package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public interface f {

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.m.a {
        public final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.m.a m(String str, Object obj) {
            AppMethodBeat.i(91064);
            a o = o(str, obj);
            AppMethodBeat.o(91064);
            return o;
        }

        public final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.m.a v(Map map) {
            AppMethodBeat.i(91063);
            a y = y(map);
            AppMethodBeat.o(91063);
            return y;
        }

        public a(String str, Object... objArr) {
            super(str, objArr);
        }

        public final a o(String str, Object obj) {
            AppMethodBeat.i(91061);
            a aVar = (a) super.m(str, obj);
            AppMethodBeat.o(91061);
            return aVar;
        }

        public final a y(Map<String, Object> map) {
            AppMethodBeat.i(91062);
            a aVar = (a) super.v(map);
            AppMethodBeat.o(91062);
            return aVar;
        }
    }
}
