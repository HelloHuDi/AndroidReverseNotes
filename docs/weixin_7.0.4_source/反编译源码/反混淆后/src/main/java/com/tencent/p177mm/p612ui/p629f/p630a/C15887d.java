package com.tencent.p177mm.p612ui.p629f.p630a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.f.a.d */
public final class C15887d {
    private final String mAppId;
    long zxC;
    public AccessToken zxJ;
    private CallbackManager zxK;
    C15886b zxL;
    private FacebookCallback zxM = new C158891();

    /* renamed from: com.tencent.mm.ui.f.a.d$b */
    public interface C15886b {
        void onCancel();

        void onError(String str);

        void onSuccess();
    }

    /* renamed from: com.tencent.mm.ui.f.a.d$a */
    public interface C15888a {
        /* renamed from: g */
        void mo28128g(JSONObject jSONObject);

        void onError(String str);
    }

    /* renamed from: com.tencent.mm.ui.f.a.d$1 */
    class C158891 implements FacebookCallback<LoginResult> {
        C158891() {
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            AppMethodBeat.m2504i(80312);
            LoginResult loginResult = (LoginResult) obj;
            C15887d.this.zxJ = loginResult.getAccessToken();
            C15887d.this.zxC = loginResult.getAccessToken().getExpires().getTime();
            if (C15887d.this.zxJ != null) {
                C4990ab.m7417i("MicroMsg.FacebookAndroid", "facebook auth success! token %s, expire %d", C15887d.this.zxJ.getToken(), Long.valueOf(C15887d.this.zxC));
            }
            if (C15887d.this.zxL != null) {
                C15887d.this.zxL.onSuccess();
            }
            AppMethodBeat.m2505o(80312);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(80310);
            C4990ab.m7416i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
            if (C15887d.this.zxL != null) {
                C15887d.this.zxL.onCancel();
            }
            AppMethodBeat.m2505o(80310);
        }

        public final void onError(FacebookException facebookException) {
            AppMethodBeat.m2504i(80311);
            C4990ab.m7413e("MicroMsg.FacebookAndroid", "facebook auth error! %s", facebookException.getMessage());
            if (C15887d.this.zxL != null) {
                C15887d.this.zxL.onError(facebookException.getMessage());
            }
            AppMethodBeat.m2505o(80311);
        }
    }

    public C15887d(String str) {
        AppMethodBeat.m2504i(80314);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.m2505o(80314);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.m2505o(80314);
    }

    public final void dJd() {
        AppMethodBeat.m2504i(80315);
        C15887d.dJe();
        FacebookSdk.setApplicationId(this.mAppId);
        FacebookSdk.sdkInitialize(C4996ah.getContext());
        C4990ab.m7417i("MicroMsg.FacebookAndroid", "installerPkg %s", AttributionIdentifiers.getAttributionIdentifiers(C4996ah.getContext()).getAndroidInstallerPackage());
        this.zxK = Factory.create();
        AppMethodBeat.m2505o(80315);
    }

    private static void dJe() {
        AppMethodBeat.m2504i(80316);
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(1, instance.get(1) + 100);
            Class cls = AttributionIdentifiers.class;
            Field declaredField = cls.getDeclaredField("recentlyFetchedIdentifiers");
            Field declaredField2 = cls.getDeclaredField("fetchTime");
            declaredField2.setAccessible(true);
            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
            declaredField2.set(attributionIdentifiers, Long.valueOf(instance.getTimeInMillis()));
            declaredField.setAccessible(true);
            declaredField.set(cls, attributionIdentifiers);
            AppMethodBeat.m2505o(80316);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FacebookAndroid", e.getMessage());
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(80316);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    public final void mo28122a(Activity activity, C15886b c15886b, String[] strArr) {
        AppMethodBeat.m2504i(80317);
        LoginManager.getInstance().registerCallback(this.zxK, this.zxM);
        this.zxL = c15886b;
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList(strArr));
        AppMethodBeat.m2505o(80317);
    }

    /* renamed from: a */
    public final void mo28123a(String str, final C15888a c15888a) {
        AppMethodBeat.m2504i(80318);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, str);
        new GraphRequest(this.zxJ, "me", bundle, HttpMethod.GET, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.m2504i(80313);
                if (graphResponse != null) {
                    try {
                        c15888a.mo28128g(graphResponse.getJSONObject());
                        AppMethodBeat.m2505o(80313);
                        return;
                    } catch (Exception e) {
                        c15888a.onError("Retrieve Failed, Error Format!");
                        AppMethodBeat.m2505o(80313);
                        return;
                    }
                }
                c15888a.onError("Retrieve Failed, No response!");
                AppMethodBeat.m2505o(80313);
            }
        }).executeAsync();
        AppMethodBeat.m2505o(80318);
    }

    public final boolean dJc() {
        AppMethodBeat.m2504i(80319);
        if (this.zxJ == null || (this.zxC != 0 && System.currentTimeMillis() >= this.zxC)) {
            AppMethodBeat.m2505o(80319);
            return false;
        }
        AppMethodBeat.m2505o(80319);
        return true;
    }

    /* renamed from: h */
    public final void mo28126h(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(80320);
        if (this.zxK != null) {
            this.zxK.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.m2505o(80320);
    }

    public final void logout() {
        AppMethodBeat.m2504i(80321);
        this.zxJ = null;
        this.zxC = 0;
        this.zxL = null;
        LoginManager.getInstance().logOut();
        AppMethodBeat.m2505o(80321);
    }
}
