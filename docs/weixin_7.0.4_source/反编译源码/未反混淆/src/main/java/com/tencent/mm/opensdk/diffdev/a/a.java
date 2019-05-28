package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

public final class a implements IDiffDevOAuth {
    private List<OAuthListener> c = new ArrayList();
    private d d;
    private OAuthListener e = new b(this);
    private Handler handler = null;

    public a() {
        AppMethodBeat.i(128037);
        AppMethodBeat.o(128037);
    }

    public final void addListener(OAuthListener oAuthListener) {
        AppMethodBeat.i(128040);
        if (!this.c.contains(oAuthListener)) {
            this.c.add(oAuthListener);
        }
        AppMethodBeat.o(128040);
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        AppMethodBeat.i(128038);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2}));
            AppMethodBeat.o(128038);
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.d != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            AppMethodBeat.o(128038);
            return true;
        }
        this.d = new d(str, str2, str3, str4, str5, this.e);
        d dVar = this.d;
        if (VERSION.SDK_INT >= 11) {
            dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            dVar.execute(new Void[0]);
        }
        AppMethodBeat.o(128038);
        return true;
    }

    public final void detach() {
        AppMethodBeat.i(128043);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.c.clear();
        stopAuth();
        AppMethodBeat.o(128043);
    }

    public final void removeAllListeners() {
        AppMethodBeat.i(128042);
        this.c.clear();
        AppMethodBeat.o(128042);
    }

    public final void removeListener(OAuthListener oAuthListener) {
        AppMethodBeat.i(128041);
        this.c.remove(oAuthListener);
        AppMethodBeat.o(128041);
    }

    public final boolean stopAuth() {
        boolean a;
        AppMethodBeat.i(128039);
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            a = this.d == null ? true : this.d.a();
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            a = false;
        }
        this.d = null;
        AppMethodBeat.o(128039);
        return a;
    }
}
