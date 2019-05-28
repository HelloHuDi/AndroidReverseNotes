package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements f {
    private static c fpB;
    private ArrayList<a> eES = new ArrayList();
    private SharedPreferences ehZ = ah.doB();
    private volatile boolean fpA = false;
    private final int fpx = 21;
    private final String fpy = "trace_config_last_update_time";
    private final long fpz = 86400000;

    public interface a {
        void abn();
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(16424);
        cVar.release();
        AppMethodBeat.o(16424);
    }

    private c() {
        AppMethodBeat.i(16418);
        AppMethodBeat.o(16418);
    }

    public static c abt() {
        AppMethodBeat.i(16419);
        if (fpB == null) {
            synchronized (c.class) {
                try {
                    if (fpB == null) {
                        fpB = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(16419);
                    }
                }
            }
        }
        c cVar = fpB;
        AppMethodBeat.o(16419);
        return cVar;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(16420);
        int type = mVar.getType();
        ab.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(mVar instanceof o) || ((o) mVar).acR() != 21) {
            ab.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
            AppMethodBeat.o(16420);
        } else if (type != JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (type == 160) {
                if (i == 0 && i2 == 0) {
                    kP(((j) mVar).fMn);
                }
                release();
            }
            AppMethodBeat.o(16420);
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.ba.m[] lU = r.aix().lU(21);
            if (lU == null || lU.length == 0) {
                ab.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                release();
                AppMethodBeat.o(16420);
                return;
            }
            com.tencent.mm.ba.m mVar2 = lU[0];
            ab.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar2.id + " version:" + mVar2.version + " status:" + mVar2.status + " type:" + mVar2.cBc);
            if (5 == mVar2.status) {
                aw.Rg().a(new j(mVar2.id, 21), 0);
                AppMethodBeat.o(16420);
                return;
            }
            ab.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
            this.ehZ.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            release();
            AppMethodBeat.o(16420);
        } else {
            release();
            AppMethodBeat.o(16420);
        }
    }

    private void kP(int i) {
        AppMethodBeat.i(16421);
        r.aix();
        try {
            Map z = br.z(e.cy(new File(new File(n.aiu()), r.aix().cx(i, 21)).getPath()), "TraceConfig");
            if (z == null) {
                ab.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                AppMethodBeat.o(16421);
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
                long j = bo.getLong((String) z.get(str2), -1);
                if (j >= 0) {
                    ab.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
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
            ab.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.eES.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.eES.get(i3)).abn();
            }
            com.tencent.mm.ba.m cv = r.aix().cv(i, 21);
            cv.status = 2;
            r.aix().b(cv);
            AppMethodBeat.o(16421);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    private void release() {
        AppMethodBeat.i(16422);
        ab.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.fpA = false;
        aw.Rg().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        aw.Rg().b(160, (f) this);
        AppMethodBeat.o(16422);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(16423);
        if (aVar == null || this.eES.contains(aVar)) {
            AppMethodBeat.o(16423);
            return false;
        }
        boolean add = this.eES.add(aVar);
        AppMethodBeat.o(16423);
        return add;
    }
}
