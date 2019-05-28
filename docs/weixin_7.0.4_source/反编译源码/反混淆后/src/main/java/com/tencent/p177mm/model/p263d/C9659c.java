package com.tencent.p177mm.model.p263d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17895o;
import com.tencent.p177mm.p707ba.C25854m;
import com.tencent.p177mm.p707ba.C32329j;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.model.d.c */
public class C9659c implements C1202f {
    private static C9659c fpB;
    private ArrayList<C9660a> eES = new ArrayList();
    private SharedPreferences ehZ = C4996ah.doB();
    private volatile boolean fpA = false;
    private final int fpx = 21;
    private final String fpy = "trace_config_last_update_time";
    private final long fpz = 86400000;

    /* renamed from: com.tencent.mm.model.d.c$1 */
    public class C18501 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(16417);
            if (C9659c.this.fpA) {
                C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                AppMethodBeat.m2505o(16417);
                return;
            }
            long j = C9659c.this.ehZ.getLong("trace_config_last_update_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                C9659c.m17224c(C9659c.this);
                C9659c.this.fpA = true;
                C9638aw.m17182Rg().mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, C9659c.this);
                C9638aw.m17182Rg().mo14539a(160, C9659c.this);
                C9638aw.m17182Rg().mo14541a(new C45181k(21), 0);
                AppMethodBeat.m2505o(16417);
                return;
            }
            C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
            AppMethodBeat.m2505o(16417);
        }
    }

    /* renamed from: com.tencent.mm.model.d.c$a */
    public interface C9660a {
        void abn();
    }

    /* renamed from: c */
    static /* synthetic */ void m17224c(C9659c c9659c) {
        AppMethodBeat.m2504i(16424);
        c9659c.release();
        AppMethodBeat.m2505o(16424);
    }

    private C9659c() {
        AppMethodBeat.m2504i(16418);
        AppMethodBeat.m2505o(16418);
    }

    public static C9659c abt() {
        AppMethodBeat.m2504i(16419);
        if (fpB == null) {
            synchronized (C9659c.class) {
                try {
                    if (fpB == null) {
                        fpB = new C9659c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(16419);
                    }
                }
            }
        }
        C9659c c9659c = fpB;
        AppMethodBeat.m2505o(16419);
        return c9659c;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(16420);
        int type = c1207m.getType();
        C4990ab.m7417i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(c1207m instanceof C17895o) || ((C17895o) c1207m).acR() != 21) {
            C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
            AppMethodBeat.m2505o(16420);
        } else if (type != JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (type == 160) {
                if (i == 0 && i2 == 0) {
                    m17226kP(((C32329j) c1207m).fMn);
                }
                release();
            }
            AppMethodBeat.m2505o(16420);
        } else if (i == 0 && i2 == 0) {
            C25854m[] lU = C41787r.aix().mo20547lU(21);
            if (lU == null || lU.length == 0) {
                C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                release();
                AppMethodBeat.m2505o(16420);
                return;
            }
            C25854m c25854m = lU[0];
            C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + c25854m.f13661id + " version:" + c25854m.version + " status:" + c25854m.status + " type:" + c25854m.cBc);
            if (5 == c25854m.status) {
                C9638aw.m17182Rg().mo14541a(new C32329j(c25854m.f13661id, 21), 0);
                AppMethodBeat.m2505o(16420);
                return;
            }
            C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
            this.ehZ.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            release();
            AppMethodBeat.m2505o(16420);
        } else {
            release();
            AppMethodBeat.m2505o(16420);
        }
    }

    /* renamed from: kP */
    private void m17226kP(int i) {
        AppMethodBeat.m2504i(16421);
        C41787r.aix();
        try {
            Map z = C5049br.m7595z(C1173e.m2566cy(new File(new File(C9067n.aiu()), C41787r.aix().mo20542cx(i, 21)).getPath()), "TraceConfig");
            if (z == null) {
                C4990ab.m7410d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                AppMethodBeat.m2505o(16421);
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            HashMap hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = (String) z.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = C5046bo.getLong((String) z.get(str2), -1);
                if (j >= 0) {
                    C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.ehZ.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            C4990ab.m7410d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.eES.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((C9660a) this.eES.get(i3)).abn();
            }
            C25854m cv = C41787r.aix().mo20541cv(i, 21);
            cv.status = 2;
            C41787r.aix().mo20540b(cv);
            AppMethodBeat.m2505o(16421);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    private void release() {
        AppMethodBeat.m2504i(16422);
        C4990ab.m7416i("MicroMsg.TraceConfigUpdater", "summer release");
        this.fpA = false;
        C9638aw.m17182Rg().mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(160, (C1202f) this);
        AppMethodBeat.m2505o(16422);
    }

    /* renamed from: a */
    public final boolean mo20980a(C9660a c9660a) {
        AppMethodBeat.m2504i(16423);
        if (c9660a == null || this.eES.contains(c9660a)) {
            AppMethodBeat.m2505o(16423);
            return false;
        }
        boolean add = this.eES.add(c9660a);
        AppMethodBeat.m2505o(16423);
        return add;
    }
}
