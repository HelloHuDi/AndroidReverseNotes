package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    private static final int DEFAULT_THEME = R.style.z7;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static volatile int webDialogTheme;
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private String expectedRedirectUrl;
    private boolean isDetached;
    private boolean isPageFinished;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private UploadStagingResourcesTask uploadTask;
    private String url;
    private WebView webView;
    private LayoutParams windowParams;

    class DialogWebViewClient extends WebViewClient {
        private DialogWebViewClient() {
        }

        /* synthetic */ DialogWebViewClient(WebDialog webDialog, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AppMethodBeat.i(96663);
            Utility.logd(WebDialog.LOG_TAG, "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(WebDialog.this.expectedRedirectUrl)) {
                int i;
                Bundle parseResponseUri = WebDialog.this.parseResponseUri(str);
                String string = parseResponseUri.getString("error");
                if (string == null) {
                    string = parseResponseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                String string2 = parseResponseUri.getString("error_msg");
                if (string2 == null) {
                    string2 = parseResponseUri.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
                }
                if (string2 == null) {
                    string2 = parseResponseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                String string3 = parseResponseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
                if (Utility.isNullOrEmpty(string3)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException e) {
                        i = -1;
                    }
                }
                if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                    WebDialog.this.sendSuccessToListener(parseResponseUri);
                } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    WebDialog.this.cancel();
                } else if (i == WebDialog.API_EC_DIALOG_CANCEL) {
                    WebDialog.this.cancel();
                } else {
                    WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                }
                AppMethodBeat.o(96663);
                return true;
            } else if (str.startsWith(ServerProtocol.DIALOG_CANCEL_URI)) {
                WebDialog.this.cancel();
                AppMethodBeat.o(96663);
                return true;
            } else if (str.contains("touch")) {
                AppMethodBeat.o(96663);
                return false;
            } else {
                try {
                    WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    AppMethodBeat.o(96663);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    AppMethodBeat.o(96663);
                    return false;
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(96664);
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i, str2));
            AppMethodBeat.o(96664);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(96665);
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
            AppMethodBeat.o(96665);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(96666);
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: ".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.show();
            }
            AppMethodBeat.o(96666);
        }

        public void onPageFinished(WebView webView, String str) {
            AppMethodBeat.i(96667);
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
            WebDialog.this.isPageFinished = true;
            AppMethodBeat.o(96667);
        }
    }

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
        private String action;
        private Exception[] exceptions;
        private Bundle parameters;

        UploadStagingResourcesTask(String str, Bundle bundle) {
            this.action = str;
            this.parameters = bundle;
        }

        /* Access modifiers changed, original: protected|varargs */
        public String[] doInBackground(Void... voidArr) {
            AppMethodBeat.i(96669);
            String[] stringArray = this.parameters.getStringArray("media");
            final String[] strArr = new String[stringArray.length];
            this.exceptions = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            int i = 0;
            while (i < stringArray.length) {
                Iterator it;
                try {
                    if (isCancelled()) {
                        it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        AppMethodBeat.o(96669);
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i]);
                    if (Utility.isWebUri(parse)) {
                        strArr[i] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, parse, new Callback() {
                            public void onCompleted(GraphResponse graphResponse) {
                                AppMethodBeat.i(96668);
                                try {
                                    FacebookRequestError error = graphResponse.getError();
                                    String errorMessage;
                                    if (error != null) {
                                        errorMessage = error.getErrorMessage();
                                        if (errorMessage == null) {
                                            errorMessage = "Error staging photo.";
                                        }
                                        FacebookGraphResponseException facebookGraphResponseException = new FacebookGraphResponseException(graphResponse, errorMessage);
                                        AppMethodBeat.o(96668);
                                        throw facebookGraphResponseException;
                                    }
                                    JSONObject jSONObject = graphResponse.getJSONObject();
                                    FacebookException facebookException;
                                    if (jSONObject == null) {
                                        facebookException = new FacebookException("Error staging photo.");
                                        AppMethodBeat.o(96668);
                                        throw facebookException;
                                    }
                                    errorMessage = jSONObject.optString(ShareConstants.MEDIA_URI);
                                    if (errorMessage == null) {
                                        facebookException = new FacebookException("Error staging photo.");
                                        AppMethodBeat.o(96668);
                                        throw facebookException;
                                    }
                                    strArr[i] = errorMessage;
                                    countDownLatch.countDown();
                                    AppMethodBeat.o(96668);
                                } catch (Exception e) {
                                    UploadStagingResourcesTask.this.exceptions[i] = e;
                                }
                            }
                        }).executeAsync());
                    }
                    i++;
                } catch (Exception e) {
                    it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        ((AsyncTask) it.next()).cancel(true);
                    }
                    AppMethodBeat.o(96669);
                    return null;
                }
            }
            countDownLatch.await();
            AppMethodBeat.o(96669);
            return strArr;
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(String[] strArr) {
            AppMethodBeat.i(96670);
            WebDialog.this.spinner.dismiss();
            for (Throwable th : this.exceptions) {
                if (th != null) {
                    WebDialog.this.sendErrorToListener(th);
                    AppMethodBeat.o(96670);
                    return;
                }
            }
            if (strArr == null) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                AppMethodBeat.o(96670);
                return;
            }
            List asList = Arrays.asList(strArr);
            if (asList.contains(null)) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                AppMethodBeat.o(96670);
                return;
            }
            Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray(asList));
            WebDialog.this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
            WebDialog.access$1000(WebDialog.this, (WebDialog.this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            AppMethodBeat.o(96670);
        }
    }

    public static class Builder {
        private AccessToken accessToken;
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme;

        public Builder(Context context, String str, Bundle bundle) {
            AppMethodBeat.i(96659);
            this.accessToken = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    FacebookException facebookException = new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                    AppMethodBeat.o(96659);
                    throw facebookException;
                }
            }
            finishInit(context, str, bundle);
            AppMethodBeat.o(96659);
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            AppMethodBeat.i(96660);
            if (str == null) {
                str = Utility.getMetadataApplicationId(context);
            }
            Validate.notNullOrEmpty(str, "applicationId");
            this.applicationId = str;
            finishInit(context, str2, bundle);
            AppMethodBeat.o(96660);
        }

        public Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public WebDialog build() {
            AppMethodBeat.i(96661);
            if (this.accessToken != null) {
                this.parameters.putString("app_id", this.accessToken.getApplicationId());
                this.parameters.putString("access_token", this.accessToken.getToken());
            } else {
                this.parameters.putString("app_id", this.applicationId);
            }
            WebDialog newInstance = WebDialog.newInstance(this.context, this.action, this.parameters, this.theme, this.listener);
            AppMethodBeat.o(96661);
            return newInstance;
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public Context getContext() {
            return this.context;
        }

        public int getTheme() {
            return this.theme;
        }

        public Bundle getParameters() {
            return this.parameters;
        }

        public OnCompleteListener getListener() {
            return this.listener;
        }

        private void finishInit(Context context, String str, Bundle bundle) {
            AppMethodBeat.i(96662);
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
                AppMethodBeat.o(96662);
                return;
            }
            this.parameters = new Bundle();
            AppMethodBeat.o(96662);
        }
    }

    static /* synthetic */ void access$1000(WebDialog webDialog, int i) {
        AppMethodBeat.i(96694);
        webDialog.setUpWebView(i);
        AppMethodBeat.o(96694);
    }

    protected static void initDefaultTheme(Context context) {
        AppMethodBeat.i(96673);
        if (context == null) {
            AppMethodBeat.o(96673);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                AppMethodBeat.o(96673);
                return;
            }
            if (webDialogTheme == 0) {
                setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
            }
            AppMethodBeat.o(96673);
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(96673);
        }
    }

    public static WebDialog newInstance(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
        AppMethodBeat.i(96674);
        initDefaultTheme(context);
        WebDialog webDialog = new WebDialog(context, str, bundle, i, onCompleteListener);
        AppMethodBeat.o(96674);
        return webDialog;
    }

    public static int getWebDialogTheme() {
        AppMethodBeat.i(96675);
        Validate.sdkInitialized();
        int i = webDialogTheme;
        AppMethodBeat.o(96675);
        return i;
    }

    public static void setWebDialogTheme(int i) {
        if (i == 0) {
            i = DEFAULT_THEME;
        }
        webDialogTheme = i;
    }

    protected WebDialog(Context context, String str) {
        this(context, str, getWebDialogTheme());
        AppMethodBeat.i(96676);
        AppMethodBeat.o(96676);
    }

    private WebDialog(Context context, String str, int i) {
        if (i == 0) {
            i = getWebDialogTheme();
        }
        super(context, i);
        AppMethodBeat.i(96677);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        this.url = str;
        AppMethodBeat.o(96677);
    }

    private WebDialog(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
        if (i == 0) {
            i = getWebDialogTheme();
        }
        super(context, i);
        AppMethodBeat.i(96678);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.expectedRedirectUrl = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.expectedRedirectUrl);
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", new Object[]{FacebookSdk.getSdkVersion()}));
        this.onCompleteListener = onCompleteListener;
        if (str.equals("share") && bundle.containsKey("media")) {
            this.uploadTask = new UploadStagingResourcesTask(str, bundle);
            AppMethodBeat.o(96678);
            return;
        }
        this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle).toString();
        AppMethodBeat.o(96678);
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(96679);
        if (i == 4) {
            cancel();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(96679);
        return onKeyDown;
    }

    public void dismiss() {
        AppMethodBeat.i(96680);
        if (this.webView != null) {
            this.webView.stopLoading();
        }
        if (!(this.isDetached || this.spinner == null || !this.spinner.isShowing())) {
            this.spinner.dismiss();
        }
        super.dismiss();
        AppMethodBeat.o(96680);
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        AppMethodBeat.i(96681);
        super.onStart();
        if (this.uploadTask == null || this.uploadTask.getStatus() != Status.PENDING) {
            resize();
            AppMethodBeat.o(96681);
            return;
        }
        this.uploadTask.execute(new Void[0]);
        this.spinner.show();
        AppMethodBeat.o(96681);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.i(96682);
        if (this.uploadTask != null) {
            this.uploadTask.cancel(true);
            this.spinner.dismiss();
        }
        super.onStop();
        AppMethodBeat.o(96682);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(96683);
        this.isDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(96683);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(96684);
        this.isDetached = false;
        if (Utility.mustFixWindowParamsForAutofill(getContext()) && this.windowParams != null && this.windowParams.token == null) {
            this.windowParams.token = getOwnerActivity().getWindow().getAttributes().token;
            Utility.logd(LOG_TAG, "Set token on onAttachedToWindow(): " + this.windowParams.token);
        }
        super.onAttachedToWindow();
        AppMethodBeat.o(96684);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        AppMethodBeat.i(96685);
        if (layoutParams.token == null) {
            this.windowParams = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
        AppMethodBeat.o(96685);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(96686);
        super.onCreate(bundle);
        this.spinner = new ProgressDialog(getContext());
        this.spinner.requestWindowFeature(1);
        this.spinner.setMessage(getContext().getString(R.string.a0));
        this.spinner.setCanceledOnTouchOutside(false);
        this.spinner.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(96655);
                WebDialog.this.cancel();
                AppMethodBeat.o(96655);
            }
        });
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        createCrossImage();
        if (this.url != null) {
            setUpWebView((this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.contentFrameLayout);
        AppMethodBeat.o(96686);
    }

    /* Access modifiers changed, original: protected */
    public void setExpectedRedirectUrl(String str) {
        this.expectedRedirectUrl = str;
    }

    /* Access modifiers changed, original: protected */
    public Bundle parseResponseUri(String str) {
        AppMethodBeat.i(96687);
        Uri parse = Uri.parse(str);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        AppMethodBeat.o(96687);
        return parseUrlQueryString;
    }

    /* Access modifiers changed, original: protected */
    public boolean isListenerCalled() {
        return this.listenerCalled;
    }

    /* Access modifiers changed, original: protected */
    public boolean isPageFinished() {
        return this.isPageFinished;
    }

    /* Access modifiers changed, original: protected */
    public WebView getWebView() {
        return this.webView;
    }

    public void resize() {
        AppMethodBeat.i(96688);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
        AppMethodBeat.o(96688);
    }

    private int getScaledSize(int i, float f, int i2, int i3) {
        double d = MIN_SCALE_FACTOR;
        int i4 = (int) (((float) i) / f);
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = MIN_SCALE_FACTOR + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * MIN_SCALE_FACTOR);
        }
        return (int) (d * ((double) i));
    }

    /* Access modifiers changed, original: protected */
    public void sendSuccessToListener(Bundle bundle) {
        AppMethodBeat.i(96689);
        if (!(this.onCompleteListener == null || this.listenerCalled)) {
            this.listenerCalled = true;
            this.onCompleteListener.onComplete(bundle, null);
            dismiss();
        }
        AppMethodBeat.o(96689);
    }

    /* Access modifiers changed, original: protected */
    public void sendErrorToListener(Throwable th) {
        AppMethodBeat.i(96690);
        if (!(this.onCompleteListener == null || this.listenerCalled)) {
            FacebookException facebookException;
            this.listenerCalled = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            this.onCompleteListener.onComplete(null, facebookException);
            dismiss();
        }
        AppMethodBeat.o(96690);
    }

    public void cancel() {
        AppMethodBeat.i(96691);
        if (!(this.onCompleteListener == null || this.listenerCalled)) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
        AppMethodBeat.o(96691);
    }

    private void createCrossImage() {
        AppMethodBeat.i(96692);
        this.crossImageView = new ImageView(getContext());
        this.crossImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AppMethodBeat.i(96656);
                WebDialog.this.cancel();
                AppMethodBeat.o(96656);
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.a__));
        this.crossImageView.setVisibility(4);
        AppMethodBeat.o(96692);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setUpWebView(int i) {
        AppMethodBeat.i(96693);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebView(getContext()) {
            public void onWindowFocusChanged(boolean z) {
                AppMethodBeat.i(96657);
                try {
                    super.onWindowFocusChanged(z);
                    AppMethodBeat.o(96657);
                } catch (NullPointerException e) {
                    AppMethodBeat.o(96657);
                }
            }
        };
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new DialogWebViewClient(this, null));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setSaveFormData(false);
        this.webView.setFocusable(true);
        this.webView.setFocusableInTouchMode(true);
        this.webView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(96658);
                if (!view.hasFocus()) {
                    view.requestFocus();
                }
                AppMethodBeat.o(96658);
                return false;
            }
        });
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        this.contentFrameLayout.addView(linearLayout);
        AppMethodBeat.o(96693);
    }
}
