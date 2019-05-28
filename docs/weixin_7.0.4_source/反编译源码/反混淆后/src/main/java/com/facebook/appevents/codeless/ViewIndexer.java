package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG = ViewIndexer.class.getCanonicalName();
    private static final String TREE_PARAM = "tree";
    private WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.appevents.codeless.ViewIndexer$4 */
    static class C175924 implements Callback {
        C175924() {
        }

        public final void onCompleted(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(72078);
            Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
            AppMethodBeat.m2505o(72078);
        }
    }

    static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        public ScreenshotTaker(View view) {
            AppMethodBeat.m2504i(72079);
            this.rootView = new WeakReference(view);
            AppMethodBeat.m2505o(72079);
        }

        public String call() {
            AppMethodBeat.m2504i(72080);
            View view = (View) this.rootView.get();
            String str;
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                str = "";
                AppMethodBeat.m2505o(72080);
                return str;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
            str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            AppMethodBeat.m2505o(72080);
            return str;
        }
    }

    static /* synthetic */ void access$200(ViewIndexer viewIndexer, String str, String str2) {
        AppMethodBeat.m2504i(72088);
        viewIndexer.sendToServer(str, str2);
        AppMethodBeat.m2505o(72088);
    }

    static {
        AppMethodBeat.m2504i(72089);
        AppMethodBeat.m2505o(72089);
    }

    public ViewIndexer(Activity activity) {
        AppMethodBeat.m2504i(72082);
        this.activityReference = new WeakReference(activity);
        AppMethodBeat.m2505o(72082);
    }

    public void schedule() {
        AppMethodBeat.m2504i(72083);
        final Activity activity = (Activity) this.activityReference.get();
        if (activity == null) {
            AppMethodBeat.m2505o(72083);
            return;
        }
        final String simpleName = activity.getClass().getSimpleName();
        FacebookSdk.getApplicationId();
        final C319951 c319951 = new TimerTask() {
            public void run() {
                AppMethodBeat.m2504i(72075);
                View rootView = activity.getWindow().getDecorView().getRootView();
                if (!ActivityLifecycleTracker.getIsAppIndexingEnabled()) {
                    AppMethodBeat.m2505o(72075);
                } else if (InternalSettings.isUnityApp()) {
                    UnityReflection.captureViewHierarchy();
                    AppMethodBeat.m2505o(72075);
                } else {
                    Object obj;
                    FutureTask futureTask = new FutureTask(new ScreenshotTaker(rootView));
                    ViewIndexer.this.uiThreadHandler.post(futureTask);
                    String str = "";
                    try {
                        obj = (String) futureTask.get(1, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        ViewIndexer.TAG;
                        String obj2 = str;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", obj2);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException e2) {
                            ViewIndexer.TAG;
                        }
                        ViewIndexer.access$200(ViewIndexer.this, jSONObject.toString(), simpleName);
                        AppMethodBeat.m2505o(72075);
                    } catch (Exception e3) {
                        ViewIndexer.TAG;
                        AppMethodBeat.m2505o(72075);
                    }
                }
            }
        };
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(72076);
                try {
                    if (ViewIndexer.this.indexingTimer != null) {
                        ViewIndexer.this.indexingTimer.cancel();
                    }
                    ViewIndexer.this.previousDigest = null;
                    ViewIndexer.this.indexingTimer = new Timer();
                    ViewIndexer.this.indexingTimer.scheduleAtFixedRate(c319951, 0, 1000);
                    AppMethodBeat.m2505o(72076);
                } catch (Exception e) {
                    ViewIndexer.TAG;
                    AppMethodBeat.m2505o(72076);
                }
            }
        });
        AppMethodBeat.m2505o(72083);
    }

    public void unschedule() {
        AppMethodBeat.m2504i(72084);
        if (((Activity) this.activityReference.get()) == null) {
            AppMethodBeat.m2505o(72084);
            return;
        }
        if (this.indexingTimer != null) {
            try {
                this.indexingTimer.cancel();
                this.indexingTimer = null;
                AppMethodBeat.m2505o(72084);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(72084);
    }

    public void sendToServerUnity(String str) {
        String simpleName;
        AppMethodBeat.m2504i(72085);
        Activity activity = (Activity) this.activityReference.get();
        String str2 = "";
        if (activity != null) {
            simpleName = activity.getClass().getSimpleName();
        } else {
            simpleName = str2;
        }
        sendToServer(str, simpleName);
        AppMethodBeat.m2505o(72085);
    }

    private void sendToServer(final String str, String str2) {
        AppMethodBeat.m2504i(72086);
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(72077);
                String applicationId = FacebookSdk.getApplicationId();
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) {
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, applicationId, Constants.APP_INDEXING);
                    if (buildAppIndexingRequest != null) {
                        GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                        try {
                            JSONObject jSONObject = executeAndWait.getJSONObject();
                            if (jSONObject != null) {
                                if (jSONObject.has("success") && jSONObject.getString("success") == "true") {
                                    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                    ViewIndexer.this.previousDigest = md5hash;
                                }
                                if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                                    ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                                    AppMethodBeat.m2505o(72077);
                                    return;
                                }
                            }
                            ViewIndexer.TAG;
                            new StringBuilder("Error sending UI component tree to Facebook: ").append(executeAndWait.getError());
                            AppMethodBeat.m2505o(72077);
                            return;
                        } catch (JSONException e) {
                            ViewIndexer.TAG;
                        }
                    }
                    AppMethodBeat.m2505o(72077);
                    return;
                }
                AppMethodBeat.m2505o(72077);
            }
        });
        AppMethodBeat.m2505o(72086);
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        AppMethodBeat.m2504i(72087);
        if (str == null) {
            AppMethodBeat.m2505o(72087);
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(TREE_PARAM, str);
        parameters.putString(APP_VERSION_PARAM, AppEventUtility.getAppVersion());
        parameters.putString(PLATFORM_PARAM, "android");
        parameters.putString(REQUEST_TYPE, str3);
        if (str3.equals(Constants.APP_INDEXING)) {
            parameters.putString(Constants.DEVICE_SESSION_ID, ActivityLifecycleTracker.getCurrentDeviceSessionID());
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new C175924());
        AppMethodBeat.m2505o(72087);
        return newPostRequest;
    }
}
