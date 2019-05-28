package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG = FacebookWebFallbackDialog.class.getName();
    private boolean waitingForDialogToClose;

    /* renamed from: com.facebook.internal.FacebookWebFallbackDialog$1 */
    class C85961 implements Runnable {
        C85961() {
        }

        public void run() {
            AppMethodBeat.m2504i(96640);
            FacebookWebFallbackDialog.access$001(FacebookWebFallbackDialog.this);
            AppMethodBeat.m2505o(96640);
        }
    }

    static /* synthetic */ void access$001(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        AppMethodBeat.m2504i(96645);
        super.cancel();
        AppMethodBeat.m2505o(96645);
    }

    static {
        AppMethodBeat.m2504i(96646);
        AppMethodBeat.m2505o(96646);
    }

    public static FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        AppMethodBeat.m2504i(96641);
        WebDialog.initDefaultTheme(context);
        FacebookWebFallbackDialog facebookWebFallbackDialog = new FacebookWebFallbackDialog(context, str, str2);
        AppMethodBeat.m2505o(96641);
        return facebookWebFallbackDialog;
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        AppMethodBeat.m2504i(96642);
        setExpectedRedirectUrl(str2);
        AppMethodBeat.m2505o(96642);
    }

    /* Access modifiers changed, original: protected */
    public Bundle parseResponseUri(String str) {
        AppMethodBeat.m2504i(96643);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        if (!Utility.isNullOrEmpty(string)) {
            if (Utility.isNullOrEmpty(string)) {
                string = "{}";
            }
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e2) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove("version");
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        AppMethodBeat.m2505o(96643);
        return parseUrlQueryString;
    }

    public void cancel() {
        AppMethodBeat.m2504i(96644);
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
            AppMethodBeat.m2505o(96644);
        } else if (this.waitingForDialogToClose) {
            AppMethodBeat.m2505o(96644);
        } else {
            this.waitingForDialogToClose = true;
            webView.loadUrl("javascript:".concat(String.valueOf("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();")));
            new Handler(Looper.getMainLooper()).postDelayed(new C85961(), 1500);
            AppMethodBeat.m2505o(96644);
        }
    }
}
