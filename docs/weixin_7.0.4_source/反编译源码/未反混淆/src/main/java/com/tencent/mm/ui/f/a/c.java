package com.tencent.mm.ui.f.a;

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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class c {
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
    private a zxG;
    private final long zxH = 86400000;

    public interface a {
        void a(b bVar);

        void a(e eVar);

        void onCancel();

        void p(Bundle bundle);
    }

    public c(String str) {
        AppMethodBeat.i(80298);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.o(80298);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.o(80298);
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        AppMethodBeat.i(80299);
        b(activity, strArr, aVar);
        h.pYm.a(582, 0, 1, false);
        AppMethodBeat.o(80299);
    }

    private void b(Activity activity, String[] strArr, a aVar) {
        AppMethodBeat.i(80300);
        this.zxG = aVar;
        a(activity, strArr);
        AppMethodBeat.o(80300);
    }

    private void a(Activity activity, String[] strArr) {
        AppMethodBeat.i(80301);
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        com.tencent.xweb.c.jx(activity);
        a(activity, "oauth", bundle, new a() {
            public final void p(Bundle bundle) {
                AppMethodBeat.i(80294);
                com.tencent.xweb.c.dTT();
                com.tencent.xweb.c.sync();
                c.this.arX(bundle.getString("access_token"));
                c.this.arY(bundle.getString(AccessToken.EXPIRES_IN_KEY));
                if (c.this.dJc()) {
                    ab.d("Facebook-authorize", "Login Success! access_token=" + c.this.gqE + " expires=" + c.this.zxC);
                    c.this.zxG.p(bundle);
                    AppMethodBeat.o(80294);
                    return;
                }
                c.this.zxG.a(new e("Failed to receive access token."));
                AppMethodBeat.o(80294);
            }

            public final void a(b bVar) {
                AppMethodBeat.i(80295);
                ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(bVar)));
                c.this.zxG.a(bVar);
                AppMethodBeat.o(80295);
            }

            public final void a(e eVar) {
                AppMethodBeat.i(80296);
                ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(eVar)));
                c.this.zxG.a(eVar);
                AppMethodBeat.o(80296);
            }

            public final void onCancel() {
                AppMethodBeat.i(80297);
                ab.d("Facebook-authorize", "Login canceled");
                c.this.zxG.onCancel();
                AppMethodBeat.o(80297);
            }
        });
        AppMethodBeat.o(80301);
    }

    public final void h(int i, int i2, Intent intent) {
        AppMethodBeat.i(80302);
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
                        ab.d("Facebook-authorize", "Login Success! access_token=" + this.gqE + " expires=" + this.zxC);
                        this.zxG.p(intent.getExtras());
                        AppMethodBeat.o(80302);
                        return;
                    }
                    this.zxG.a(new e("Failed to receive access token."));
                    AppMethodBeat.o(80302);
                    return;
                } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                    ab.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                    a(this.zxD, this.zxE);
                    AppMethodBeat.o(80302);
                    return;
                } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                    ab.d("Facebook-authorize", "Login canceled by user.");
                    this.zxG.onCancel();
                    AppMethodBeat.o(80302);
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                    if (stringExtra2 != null) {
                        stringExtra = stringExtra + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stringExtra2;
                    }
                    ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(stringExtra)));
                    this.zxG.a(new e(stringExtra));
                    AppMethodBeat.o(80302);
                    return;
                }
            } else if (i2 == 0) {
                if (intent != null) {
                    ab.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.zxG.a(new b(intent.getStringExtra("error"), intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1), intent.getStringExtra("failing_url")));
                    AppMethodBeat.o(80302);
                    return;
                }
                ab.d("Facebook-authorize", "Login canceled by user.");
                this.zxG.onCancel();
            }
        }
        AppMethodBeat.o(80302);
    }

    public final String ie(Context context) {
        AppMethodBeat.i(80303);
        f.m22if(context);
        arX(null);
        this.zxC = 0;
        AppMethodBeat.o(80303);
        return null;
    }

    public final String q(String str, Bundle bundle) {
        AppMethodBeat.i(80304);
        String a = a(str, bundle, "GET");
        AppMethodBeat.o(80304);
        return a;
    }

    public final String a(String str, Bundle bundle, String str2) {
        AppMethodBeat.i(80305);
        bundle.putString("format", "json");
        if (dJc()) {
            bundle.putString("access_token", this.gqE);
        }
        String e = f.e(str != null ? zxz + str : zxA, str2, bundle);
        AppMethodBeat.o(80305);
        return e;
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        AppMethodBeat.i(80306);
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
        str2 = str2 + "?" + f.aA(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            f.L(context, "Error", "Application requires permission to access the Internet");
            AppMethodBeat.o(80306);
            return;
        }
        new g(context, str2, aVar).show();
        AppMethodBeat.o(80306);
    }

    public final void arX(String str) {
        AppMethodBeat.i(80308);
        this.gqE = str;
        this.zxB = System.currentTimeMillis();
        AppMethodBeat.o(80308);
    }

    public final void arY(String str) {
        AppMethodBeat.i(80309);
        if (str != null) {
            long j;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                j = 0;
            } else {
                j = System.currentTimeMillis() + (bo.anl(str) * 1000);
            }
            this.zxC = j;
        }
        AppMethodBeat.o(80309);
    }

    public final boolean dJc() {
        AppMethodBeat.i(80307);
        if (this.gqE == null || (this.zxC != 0 && System.currentTimeMillis() >= this.zxC)) {
            AppMethodBeat.o(80307);
            return false;
        }
        AppMethodBeat.o(80307);
        return true;
    }
}
