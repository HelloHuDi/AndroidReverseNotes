package com.tencent.p177mm.p612ui.p629f.p630a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C24526c;

/* renamed from: com.tencent.mm.ui.f.a.c */
public final class C30704c {
    protected static String zxA = "https://api.facebook.com/restserver.php";
    protected static String zxy = "https://m.facebook.com/dialog/";
    protected static String zxz = "https://graph.facebook.com/";
    public String gqE = null;
    private String mAppId;
    private long zxB = 0;
    public long zxC = 0;
    private Activity zxD;
    private String[] zxE;
    private int zxF;
    private C30705a zxG;
    private final long zxH = 86400000;

    /* renamed from: com.tencent.mm.ui.f.a.c$1 */
    class C307031 implements C30705a {
        C307031() {
        }

        /* renamed from: p */
        public final void mo5794p(Bundle bundle) {
            AppMethodBeat.m2504i(80294);
            C24526c.dTT();
            C24526c.sync();
            C30704c.this.arX(bundle.getString("access_token"));
            C30704c.this.arY(bundle.getString(AccessToken.EXPIRES_IN_KEY));
            if (C30704c.this.dJc()) {
                C4990ab.m7410d("Facebook-authorize", "Login Success! access_token=" + C30704c.this.gqE + " expires=" + C30704c.this.zxC);
                C30704c.this.zxG.mo5794p(bundle);
                AppMethodBeat.m2505o(80294);
                return;
            }
            C30704c.this.zxG.mo5792a(new C30706e("Failed to receive access token."));
            AppMethodBeat.m2505o(80294);
        }

        /* renamed from: a */
        public final void mo5791a(C15885b c15885b) {
            AppMethodBeat.m2504i(80295);
            C4990ab.m7410d("Facebook-authorize", "Login failed: ".concat(String.valueOf(c15885b)));
            C30704c.this.zxG.mo5791a(c15885b);
            AppMethodBeat.m2505o(80295);
        }

        /* renamed from: a */
        public final void mo5792a(C30706e c30706e) {
            AppMethodBeat.m2504i(80296);
            C4990ab.m7410d("Facebook-authorize", "Login failed: ".concat(String.valueOf(c30706e)));
            C30704c.this.zxG.mo5792a(c30706e);
            AppMethodBeat.m2505o(80296);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(80297);
            C4990ab.m7410d("Facebook-authorize", "Login canceled");
            C30704c.this.zxG.onCancel();
            AppMethodBeat.m2505o(80297);
        }
    }

    /* renamed from: com.tencent.mm.ui.f.a.c$a */
    public interface C30705a {
        /* renamed from: a */
        void mo5791a(C15885b c15885b);

        /* renamed from: a */
        void mo5792a(C30706e c30706e);

        void onCancel();

        /* renamed from: p */
        void mo5794p(Bundle bundle);
    }

    public C30704c(String str) {
        AppMethodBeat.m2504i(80298);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.m2505o(80298);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.m2505o(80298);
    }

    /* renamed from: a */
    public final void mo49070a(Activity activity, String[] strArr, C30705a c30705a) {
        AppMethodBeat.m2504i(80299);
        m48943b(activity, strArr, c30705a);
        C7060h.pYm.mo8378a(582, 0, 1, false);
        AppMethodBeat.m2505o(80299);
    }

    /* renamed from: b */
    private void m48943b(Activity activity, String[] strArr, C30705a c30705a) {
        AppMethodBeat.m2504i(80300);
        this.zxG = c30705a;
        m48942a(activity, strArr);
        AppMethodBeat.m2505o(80300);
    }

    /* renamed from: a */
    private void m48942a(Activity activity, String[] strArr) {
        AppMethodBeat.m2504i(80301);
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        C24526c.m38159jx(activity);
        mo49071a(activity, "oauth", bundle, new C307031());
        AppMethodBeat.m2505o(80301);
    }

    /* renamed from: h */
    public final void mo49075h(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(80302);
        if (i == this.zxF) {
            if (i2 == -1) {
                Object stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (stringExtra == null) {
                    arX(intent.getStringExtra("access_token"));
                    arY(intent.getStringExtra(AccessToken.EXPIRES_IN_KEY));
                    if (dJc()) {
                        C4990ab.m7410d("Facebook-authorize", "Login Success! access_token=" + this.gqE + " expires=" + this.zxC);
                        this.zxG.mo5794p(intent.getExtras());
                        AppMethodBeat.m2505o(80302);
                        return;
                    }
                    this.zxG.mo5792a(new C30706e("Failed to receive access token."));
                    AppMethodBeat.m2505o(80302);
                    return;
                } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                    C4990ab.m7410d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                    m48942a(this.zxD, this.zxE);
                    AppMethodBeat.m2505o(80302);
                    return;
                } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                    C4990ab.m7410d("Facebook-authorize", "Login canceled by user.");
                    this.zxG.onCancel();
                    AppMethodBeat.m2505o(80302);
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                    if (stringExtra2 != null) {
                        stringExtra = stringExtra + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stringExtra2;
                    }
                    C4990ab.m7410d("Facebook-authorize", "Login failed: ".concat(String.valueOf(stringExtra)));
                    this.zxG.mo5792a(new C30706e(stringExtra));
                    AppMethodBeat.m2505o(80302);
                    return;
                }
            } else if (i2 == 0) {
                if (intent != null) {
                    C4990ab.m7410d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.zxG.mo5791a(new C15885b(intent.getStringExtra("error"), intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1), intent.getStringExtra("failing_url")));
                    AppMethodBeat.m2505o(80302);
                    return;
                }
                C4990ab.m7410d("Facebook-authorize", "Login canceled by user.");
                this.zxG.onCancel();
            }
        }
        AppMethodBeat.m2505o(80302);
    }

    /* renamed from: ie */
    public final String mo49076ie(Context context) {
        AppMethodBeat.m2504i(80303);
        C44373f.m80199if(context);
        arX(null);
        this.zxC = 0;
        AppMethodBeat.m2505o(80303);
        return null;
    }

    /* renamed from: q */
    public final String mo49077q(String str, Bundle bundle) {
        AppMethodBeat.m2504i(80304);
        String a = mo49069a(str, bundle, "GET");
        AppMethodBeat.m2505o(80304);
        return a;
    }

    /* renamed from: a */
    public final String mo49069a(String str, Bundle bundle, String str2) {
        AppMethodBeat.m2504i(80305);
        bundle.putString("format", "json");
        if (dJc()) {
            bundle.putString("access_token", this.gqE);
        }
        String e = C44373f.m80198e(str != null ? zxz + str : zxA, str2, bundle);
        AppMethodBeat.m2505o(80305);
        return e;
    }

    /* renamed from: a */
    public final void mo49071a(Context context, String str, Bundle bundle, C30705a c30705a) {
        AppMethodBeat.m2504i(80306);
        String str2 = zxy + str;
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ServerProtocol.DIALOG_REDIRECT_URI);
        if (str.equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.mAppId);
        } else {
            bundle.putString("app_id", this.mAppId);
        }
        if (dJc()) {
            bundle.putString("access_token", this.gqE);
        }
        str2 = str2 + "?" + C44373f.m80197aA(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C44373f.m80196L(context, "Error", "Application requires permission to access the Internet");
            AppMethodBeat.m2505o(80306);
            return;
        }
        new C46687g(context, str2, c30705a).show();
        AppMethodBeat.m2505o(80306);
    }

    public final void arX(String str) {
        AppMethodBeat.m2504i(80308);
        this.gqE = str;
        this.zxB = System.currentTimeMillis();
        AppMethodBeat.m2505o(80308);
    }

    public final void arY(String str) {
        AppMethodBeat.m2504i(80309);
        if (str != null) {
            long j;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                j = 0;
            } else {
                j = System.currentTimeMillis() + (C5046bo.anl(str) * 1000);
            }
            this.zxC = j;
        }
        AppMethodBeat.m2505o(80309);
    }

    public final boolean dJc() {
        AppMethodBeat.m2504i(80307);
        if (this.gqE == null || (this.zxC != 0 && System.currentTimeMillis() >= this.zxC)) {
            AppMethodBeat.m2505o(80307);
            return false;
        }
        AppMethodBeat.m2505o(80307);
        return true;
    }
}
