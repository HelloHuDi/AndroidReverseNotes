package com.tencent.p177mm.p652z.p653c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p652z.p1101b.C40953b;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p654d.C5759a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.z.c.c */
public final class C5756c {
    C5758a eIh;
    private C5759a eIi;
    public C16116d eIj;
    C36406b eIk;

    /* renamed from: com.tencent.mm.z.c.c$a */
    static final class C5758a implements C36405a {
        C30909e eIn;
        C32800b eIo = new C32800b();
        Context mContext;

        C5758a(Context context, C30909e c30909e) {
            AppMethodBeat.m2504i(115303);
            this.mContext = context;
            this.eIn = c30909e;
            AppMethodBeat.m2505o(115303);
        }

        public final Context getContext() {
            return this.mContext;
        }

        /* renamed from: Qy */
        public final C32800b mo11733Qy() {
            return this.eIo;
        }
    }

    public C5756c(Context context, C30909e c30909e, C5759a c5759a, C36406b c36406b) {
        AppMethodBeat.m2504i(115304);
        this.eIh = new C5758a(context, c30909e);
        this.eIi = c5759a;
        this.eIk = c36406b;
        AppMethodBeat.m2505o(115304);
    }

    /* renamed from: c */
    public final String mo11731c(String str, String str2, final int i) {
        AppMethodBeat.m2504i(115305);
        try {
            C40953b c40953b;
            String lp;
            C16116d c16116d = this.eIj;
            if (C5046bo.isNullOrNil(str)) {
                c40953b = null;
            } else {
                c40953b = (C40953b) c16116d.eIp.get(str);
            }
            if (c40953b == null) {
                lp = this.eIk.mo34414lp(str);
                AppMethodBeat.m2505o(115305);
            } else {
                lp = this.eIk.mo34413a(this.eIh, this.eIi, c40953b, str2, new C16115a() {
                    /* renamed from: au */
                    public final void mo11732au(Object obj) {
                        String str;
                        AppMethodBeat.m2504i(115302);
                        C30909e c30909e = C5756c.this.eIh.eIn;
                        int i = i;
                        if (obj == null) {
                            str = "";
                        } else {
                            str = obj.toString();
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            str = "{}";
                        }
                        c30909e.eIt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
                        AppMethodBeat.m2505o(115302);
                    }
                });
                AppMethodBeat.m2505o(115305);
            }
            return lp;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", str, Log.getStackTraceString(e));
            AppMethodBeat.m2505o(115305);
            throw e;
        }
    }
}
