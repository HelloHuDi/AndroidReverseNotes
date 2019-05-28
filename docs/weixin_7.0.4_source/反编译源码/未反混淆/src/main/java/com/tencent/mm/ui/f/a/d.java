package com.tencent.mm.ui.f.a;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONObject;

public final class d {
    private final String mAppId;
    long zxC;
    public AccessToken zxJ;
    private CallbackManager zxK;
    b zxL;
    private FacebookCallback zxM = new FacebookCallback<LoginResult>() {
        public final /* synthetic */ void onSuccess(Object obj) {
            AppMethodBeat.i(80312);
            LoginResult loginResult = (LoginResult) obj;
            d.this.zxJ = loginResult.getAccessToken();
            d.this.zxC = loginResult.getAccessToken().getExpires().getTime();
            if (d.this.zxJ != null) {
                ab.i("MicroMsg.FacebookAndroid", "facebook auth success! token %s, expire %d", d.this.zxJ.getToken(), Long.valueOf(d.this.zxC));
            }
            if (d.this.zxL != null) {
                d.this.zxL.onSuccess();
            }
            AppMethodBeat.o(80312);
        }

        public final void onCancel() {
            AppMethodBeat.i(80310);
            ab.i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
            if (d.this.zxL != null) {
                d.this.zxL.onCancel();
            }
            AppMethodBeat.o(80310);
        }

        public final void onError(FacebookException facebookException) {
            AppMethodBeat.i(80311);
            ab.e("MicroMsg.FacebookAndroid", "facebook auth error! %s", facebookException.getMessage());
            if (d.this.zxL != null) {
                d.this.zxL.onError(facebookException.getMessage());
            }
            AppMethodBeat.o(80311);
        }
    };

    public interface b {
        void onCancel();

        void onError(String str);

        void onSuccess();
    }

    public interface a {
        void g(JSONObject jSONObject);

        void onError(String str);
    }

    public d(String str) {
        AppMethodBeat.i(80314);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.o(80314);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.o(80314);
    }

    public final void dJd() {
        AppMethodBeat.i(80315);
        dJe();
        FacebookSdk.setApplicationId(this.mAppId);
        FacebookSdk.sdkInitialize(ah.getContext());
        ab.i("MicroMsg.FacebookAndroid", "installerPkg %s", AttributionIdentifiers.getAttributionIdentifiers(ah.getContext()).getAndroidInstallerPackage());
        this.zxK = Factory.create();
        AppMethodBeat.o(80315);
    }

    private static void dJe() {
        AppMethodBeat.i(80316);
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
            AppMethodBeat.o(80316);
        } catch (Exception e) {
            ab.e("MicroMsg.FacebookAndroid", e.getMessage());
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(80316);
            throw runtimeException;
        }
    }

    public final void a(Activity activity, b bVar, String[] strArr) {
        AppMethodBeat.i(80317);
        LoginManager.getInstance().registerCallback(this.zxK, this.zxM);
        this.zxL = bVar;
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList(strArr));
        AppMethodBeat.o(80317);
    }

    public final void a(String str, final a aVar) {
        AppMethodBeat.i(80318);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, str);
        new GraphRequest(this.zxJ, "me", bundle, HttpMethod.GET, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(80313);
                if (graphResponse != null) {
                    try {
                        aVar.g(graphResponse.getJSONObject());
                        AppMethodBeat.o(80313);
                        return;
                    } catch (Exception e) {
                        aVar.onError("Retrieve Failed, Error Format!");
                        AppMethodBeat.o(80313);
                        return;
                    }
                }
                aVar.onError("Retrieve Failed, No response!");
                AppMethodBeat.o(80313);
            }
        }).executeAsync();
        AppMethodBeat.o(80318);
    }

    public final boolean dJc() {
        AppMethodBeat.i(80319);
        if (this.zxJ == null || (this.zxC != 0 && System.currentTimeMillis() >= this.zxC)) {
            AppMethodBeat.o(80319);
            return false;
        }
        AppMethodBeat.o(80319);
        return true;
    }

    public final void h(int i, int i2, Intent intent) {
        AppMethodBeat.i(80320);
        if (this.zxK != null) {
            this.zxK.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.o(80320);
    }

    public final void logout() {
        AppMethodBeat.i(80321);
        this.zxJ = null;
        this.zxC = 0;
        this.zxL = null;
        LoginManager.getInstance().logOut();
        AppMethodBeat.o(80321);
    }
}
