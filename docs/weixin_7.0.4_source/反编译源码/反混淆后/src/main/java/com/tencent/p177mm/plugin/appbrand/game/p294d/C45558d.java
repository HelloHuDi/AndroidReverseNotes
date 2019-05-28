package com.tencent.p177mm.plugin.appbrand.game.p294d;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.game.p895g.C16612c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.d.d */
public class C45558d {
    private static volatile C45558d hrJ;
    public MBRuntime bSv;
    public C38219c hrH;
    public volatile C33198b hrI;
    public final Queue<String> hrK = new LinkedList();
    private C26886c hrL = new C26886c();
    public Context mContext;
    public volatile int mState = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.d$a */
    public enum C10236a {
        DEBUG,
        INFO,
        WARNING,
        ERROR;

        static {
            AppMethodBeat.m2505o(130178);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.d$b */
    static class C10237b implements Runnable {
        private C38219c hrH;
        private C26886c hrL;

        private C10237b() {
        }

        /* synthetic */ C10237b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(130179);
            if (this.hrH == null) {
                AppMethodBeat.m2505o(130179);
                return;
            }
            if (this.hrL != null) {
                this.hrL.release(this);
            }
            AppMethodBeat.m2505o(130179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.d$c */
    static class C26886c extends C16612c<C10237b> {
        private C26886c() {
        }

        /* synthetic */ C26886c(byte b) {
            this();
        }

        public final /* synthetic */ Object aAJ() {
            AppMethodBeat.m2504i(130180);
            C10237b c10237b = new C10237b();
            AppMethodBeat.m2505o(130180);
            return c10237b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.d$1 */
    public class C424411 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(130173);
            for (String log : C45558d.this.hrK) {
                C45558d.this.hrI.log(log);
            }
            C45558d.this.hrK.clear();
            AppMethodBeat.m2505o(130173);
        }
    }

    public static C45558d aAI() {
        AppMethodBeat.m2504i(130181);
        if (hrJ == null) {
            synchronized (C45558d.class) {
                try {
                    if (hrJ == null) {
                        hrJ = new C45558d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(130181);
                    }
                }
            }
        }
        C45558d c45558d = hrJ;
        AppMethodBeat.m2505o(130181);
        return c45558d;
    }

    public static void release() {
        AppMethodBeat.m2504i(130182);
        if (hrJ != null) {
            synchronized (C45558d.class) {
                try {
                    if (hrJ != null) {
                        C45558d c45558d = hrJ;
                        c45558d.mState = 2;
                        c45558d.hrL.hup.clear();
                        c45558d.bSv = null;
                        if (c45558d.hrI != null) {
                            c45558d.hrI.destroy();
                            c45558d.hrI = null;
                        }
                        if (c45558d.hrH != null) {
                            c45558d.hrH.gyS.stopTimer();
                            c45558d.hrH = null;
                        }
                        hrJ = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(130182);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(130182);
    }

    private C45558d() {
        AppMethodBeat.m2504i(130183);
        AppMethodBeat.m2505o(130183);
    }

    /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            if (r4.hrI != null) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130184);
     */
    /* JADX WARNING: Missing block: B:16:0x0027, code skipped:
            r4.hrI.post(new com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d.C424422(r4));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130184);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ax */
    public final void mo73366Ax(final String str) {
        AppMethodBeat.m2504i(130184);
        synchronized (this.hrK) {
            try {
                if (this.mState != 1) {
                    this.hrK.add(str);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130184);
            }
        }
    }

    /* renamed from: b */
    public final void mo73367b(C10236a c10236a, String str) {
        int i = 0;
        AppMethodBeat.m2504i(130185);
        if (c10236a == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameInspector", "hy: not valid console!");
            AppMethodBeat.m2505o(130185);
            return;
        }
        switch (c10236a) {
            case INFO:
                i = 1;
                break;
            case WARNING:
                i = 2;
                break;
            case ERROR:
                i = 3;
                break;
        }
        m84032O(i, str);
        AppMethodBeat.m2505o(130185);
    }

    /* renamed from: O */
    private void m84032O(int i, String str) {
        AppMethodBeat.m2504i(130186);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: ".concat(String.valueOf(str)));
            jSONObject.put("logs", jSONArray);
            mo73366Ax(jSONObject.toString());
            AppMethodBeat.m2505o(130186);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.GameInspector", e, "hy: vConsole json error", new Object[0]);
            AppMethodBeat.m2505o(130186);
        }
    }
}
