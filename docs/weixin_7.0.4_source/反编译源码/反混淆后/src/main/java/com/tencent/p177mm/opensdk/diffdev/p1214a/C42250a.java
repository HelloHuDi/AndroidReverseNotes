package com.tencent.p177mm.opensdk.diffdev.p1214a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p177mm.opensdk.diffdev.OAuthListener;
import com.tencent.p177mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
public final class C42250a implements IDiffDevOAuth {
    /* renamed from: c */
    private List<OAuthListener> f17170c = new ArrayList();
    /* renamed from: d */
    private C37981d f17171d;
    /* renamed from: e */
    private OAuthListener f17172e = new C37980b(this);
    private Handler handler = null;

    public C42250a() {
        AppMethodBeat.m2504i(128037);
        AppMethodBeat.m2505o(128037);
    }

    public final void addListener(OAuthListener oAuthListener) {
        AppMethodBeat.m2504i(128040);
        if (!this.f17170c.contains(oAuthListener)) {
            this.f17170c.add(oAuthListener);
        }
        AppMethodBeat.m2505o(128040);
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        AppMethodBeat.m2504i(128038);
        Log.m4141i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m4139d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2}));
            AppMethodBeat.m2505o(128038);
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f17171d != null) {
            Log.m4139d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            AppMethodBeat.m2505o(128038);
            return true;
        }
        this.f17171d = new C37981d(str, str2, str3, str4, str5, this.f17172e);
        C37981d c37981d = this.f17171d;
        if (VERSION.SDK_INT >= 11) {
            c37981d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            c37981d.execute(new Void[0]);
        }
        AppMethodBeat.m2505o(128038);
        return true;
    }

    public final void detach() {
        AppMethodBeat.m2504i(128043);
        Log.m4141i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f17170c.clear();
        stopAuth();
        AppMethodBeat.m2505o(128043);
    }

    public final void removeAllListeners() {
        AppMethodBeat.m2504i(128042);
        this.f17170c.clear();
        AppMethodBeat.m2505o(128042);
    }

    public final void removeListener(OAuthListener oAuthListener) {
        AppMethodBeat.m2504i(128041);
        this.f17170c.remove(oAuthListener);
        AppMethodBeat.m2505o(128041);
    }

    public final boolean stopAuth() {
        boolean a;
        AppMethodBeat.m2504i(128039);
        Log.m4141i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            a = this.f17171d == null ? true : this.f17171d.mo60755a();
        } catch (Exception e) {
            Log.m4143w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            a = false;
        }
        this.f17171d = null;
        AppMethodBeat.m2505o(128039);
        return a;
    }
}
