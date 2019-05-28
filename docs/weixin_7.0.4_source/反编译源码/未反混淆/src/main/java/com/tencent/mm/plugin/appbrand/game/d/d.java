package com.tencent.mm.plugin.appbrand.game.d;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static volatile d hrJ;
    public MBRuntime bSv;
    public c hrH;
    public volatile b hrI;
    public final Queue<String> hrK = new LinkedList();
    private c hrL = new c();
    public Context mContext;
    public volatile int mState = 0;

    public enum a {
        DEBUG,
        INFO,
        WARNING,
        ERROR;

        static {
            AppMethodBeat.o(130178);
        }
    }

    static class b implements Runnable {
        private c hrH;
        private c hrL;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(130179);
            if (this.hrH == null) {
                AppMethodBeat.o(130179);
                return;
            }
            if (this.hrL != null) {
                this.hrL.release(this);
            }
            AppMethodBeat.o(130179);
        }
    }

    static class c extends com.tencent.mm.plugin.appbrand.game.g.c<b> {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final /* synthetic */ Object aAJ() {
            AppMethodBeat.i(130180);
            b bVar = new b();
            AppMethodBeat.o(130180);
            return bVar;
        }
    }

    public static d aAI() {
        AppMethodBeat.i(130181);
        if (hrJ == null) {
            synchronized (d.class) {
                try {
                    if (hrJ == null) {
                        hrJ = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(130181);
                    }
                }
            }
        }
        d dVar = hrJ;
        AppMethodBeat.o(130181);
        return dVar;
    }

    public static void release() {
        AppMethodBeat.i(130182);
        if (hrJ != null) {
            synchronized (d.class) {
                try {
                    if (hrJ != null) {
                        d dVar = hrJ;
                        dVar.mState = 2;
                        dVar.hrL.hup.clear();
                        dVar.bSv = null;
                        if (dVar.hrI != null) {
                            dVar.hrI.destroy();
                            dVar.hrI = null;
                        }
                        if (dVar.hrH != null) {
                            dVar.hrH.gyS.stopTimer();
                            dVar.hrH = null;
                        }
                        hrJ = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(130182);
                }
            }
            return;
        }
        AppMethodBeat.o(130182);
    }

    private d() {
        AppMethodBeat.i(130183);
        AppMethodBeat.o(130183);
    }

    /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            if (r4.hrI != null) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(130184);
     */
    /* JADX WARNING: Missing block: B:16:0x0027, code skipped:
            r4.hrI.post(new com.tencent.mm.plugin.appbrand.game.d.d.AnonymousClass2(r4));
            com.tencent.matrix.trace.core.AppMethodBeat.o(130184);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ax(final String str) {
        AppMethodBeat.i(130184);
        synchronized (this.hrK) {
            try {
                if (this.mState != 1) {
                    this.hrK.add(str);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130184);
            }
        }
    }

    public final void b(a aVar, String str) {
        int i = 0;
        AppMethodBeat.i(130185);
        if (aVar == null || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameInspector", "hy: not valid console!");
            AppMethodBeat.o(130185);
            return;
        }
        switch (aVar) {
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
        O(i, str);
        AppMethodBeat.o(130185);
    }

    private void O(int i, String str) {
        AppMethodBeat.i(130186);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: ".concat(String.valueOf(str)));
            jSONObject.put("logs", jSONArray);
            Ax(jSONObject.toString());
            AppMethodBeat.o(130186);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.GameInspector", e, "hy: vConsole json error", new Object[0]);
            AppMethodBeat.o(130186);
        }
    }
}
