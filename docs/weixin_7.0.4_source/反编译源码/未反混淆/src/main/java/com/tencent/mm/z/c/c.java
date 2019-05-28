package com.tencent.mm.z.c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    a eIh;
    private com.tencent.mm.z.d.a eIi;
    public d eIj;
    b eIk;

    static final class a implements a {
        e eIn;
        b eIo = new b();
        Context mContext;

        a(Context context, e eVar) {
            AppMethodBeat.i(115303);
            this.mContext = context;
            this.eIn = eVar;
            AppMethodBeat.o(115303);
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final b Qy() {
            return this.eIo;
        }
    }

    public c(Context context, e eVar, com.tencent.mm.z.d.a aVar, b bVar) {
        AppMethodBeat.i(115304);
        this.eIh = new a(context, eVar);
        this.eIi = aVar;
        this.eIk = bVar;
        AppMethodBeat.o(115304);
    }

    public final String c(String str, String str2, final int i) {
        AppMethodBeat.i(115305);
        try {
            com.tencent.mm.z.b.b bVar;
            String lp;
            d dVar = this.eIj;
            if (bo.isNullOrNil(str)) {
                bVar = null;
            } else {
                bVar = (com.tencent.mm.z.b.b) dVar.eIp.get(str);
            }
            if (bVar == null) {
                lp = this.eIk.lp(str);
                AppMethodBeat.o(115305);
            } else {
                lp = this.eIk.a(this.eIh, this.eIi, bVar, str2, new com.tencent.mm.z.b.b.a() {
                    public final void au(Object obj) {
                        String str;
                        AppMethodBeat.i(115302);
                        e eVar = c.this.eIh.eIn;
                        int i = i;
                        if (obj == null) {
                            str = "";
                        } else {
                            str = obj.toString();
                        }
                        if (bo.isNullOrNil(str)) {
                            str = "{}";
                        }
                        eVar.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
                        AppMethodBeat.o(115302);
                    }
                });
                AppMethodBeat.o(115305);
            }
            return lp;
        } catch (Exception e) {
            ab.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", str, Log.getStackTraceString(e));
            AppMethodBeat.o(115305);
            throw e;
        }
    }
}
