package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings.DialogFeatureConfig;
import com.facebook.internal.NativeProtocol.ProtocolVersionQueryResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DialogPresenter {

    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    public static void setupAppCallForCannotShowError(AppCall appCall) {
        AppMethodBeat.i(96615);
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
        AppMethodBeat.o(96615);
    }

    public static void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        AppMethodBeat.i(96616);
        setupAppCallForErrorResult(appCall, facebookException);
        AppMethodBeat.o(96616);
    }

    public static void present(AppCall appCall, Activity activity) {
        AppMethodBeat.i(96617);
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
        AppMethodBeat.o(96617);
    }

    public static void present(AppCall appCall, FragmentWrapper fragmentWrapper) {
        AppMethodBeat.i(96618);
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
        AppMethodBeat.o(96618);
    }

    public static boolean canPresentNativeDialogWithFeature(DialogFeature dialogFeature) {
        AppMethodBeat.i(96619);
        if (getProtocolVersionForNativeDialog(dialogFeature).getProtocolVersion() != -1) {
            AppMethodBeat.o(96619);
            return true;
        }
        AppMethodBeat.o(96619);
        return false;
    }

    public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature dialogFeature) {
        AppMethodBeat.i(96620);
        if (getDialogWebFallbackUri(dialogFeature) != null) {
            AppMethodBeat.o(96620);
            return true;
        }
        AppMethodBeat.o(96620);
        return false;
    }

    public static void setupAppCallForErrorResult(AppCall appCall, FacebookException facebookException) {
        AppMethodBeat.i(96621);
        if (facebookException == null) {
            AppMethodBeat.o(96621);
            return;
        }
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException));
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(96621);
    }

    public static void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        AppMethodBeat.i(96622);
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(96622);
    }

    public static void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle bundle, DialogFeature dialogFeature) {
        AppMethodBeat.i(96623);
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = dialogFeature.name();
        Uri dialogWebFallbackUri = getDialogWebFallbackUri(dialogFeature);
        if (dialogWebFallbackUri == null) {
            FacebookException facebookException = new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + "'");
            AppMethodBeat.o(96623);
            throw facebookException;
        }
        Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(appCall.getCallId().toString(), NativeProtocol.getLatestKnownVersion(), bundle);
        if (queryParamsForPlatformActivityIntentWebFallback == null) {
            FacebookException facebookException2 = new FacebookException("Unable to fetch the app's key-hash");
            AppMethodBeat.o(96623);
            throw facebookException2;
        }
        Uri buildUri;
        if (dialogWebFallbackUri.isRelative()) {
            buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
        } else {
            buildUri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", buildUri.toString());
        bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), dialogFeature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(96623);
    }

    public static void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature dialogFeature) {
        AppMethodBeat.i(96624);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = dialogFeature.getAction();
        ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(dialogFeature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        FacebookException facebookException;
        if (protocolVersion == -1) {
            facebookException = new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
            AppMethodBeat.o(96624);
            throw facebookException;
        }
        Bundle parameters;
        if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion)) {
            parameters = parameterProvider.getParameters();
        } else {
            parameters = parameterProvider.getLegacyParameters();
        }
        if (parameters == null) {
            parameters = new Bundle();
        }
        Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, parameters);
        if (createPlatformActivityIntent == null) {
            facebookException = new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
            AppMethodBeat.o(96624);
            throw facebookException;
        }
        appCall.setRequestIntent(createPlatformActivityIntent);
        AppMethodBeat.o(96624);
    }

    private static Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        AppMethodBeat.i(96625);
        String name = dialogFeature.name();
        DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.getDialogFeatureConfig(FacebookSdk.getApplicationId(), dialogFeature.getAction(), name);
        Uri uri = null;
        if (dialogFeatureConfig != null) {
            uri = dialogFeatureConfig.getFallbackUrl();
        }
        AppMethodBeat.o(96625);
        return uri;
    }

    public static ProtocolVersionQueryResult getProtocolVersionForNativeDialog(DialogFeature dialogFeature) {
        AppMethodBeat.i(96626);
        String applicationId = FacebookSdk.getApplicationId();
        String action = dialogFeature.getAction();
        ProtocolVersionQueryResult latestAvailableProtocolVersionForAction = NativeProtocol.getLatestAvailableProtocolVersionForAction(action, getVersionSpecForFeature(applicationId, action, dialogFeature));
        AppMethodBeat.o(96626);
        return latestAvailableProtocolVersionForAction;
    }

    private static int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        AppMethodBeat.i(96627);
        DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.getDialogFeatureConfig(str, str2, dialogFeature.name());
        int[] versionSpec;
        if (dialogFeatureConfig != null) {
            versionSpec = dialogFeatureConfig.getVersionSpec();
            AppMethodBeat.o(96627);
            return versionSpec;
        }
        versionSpec = new int[]{dialogFeature.getMinVersion()};
        AppMethodBeat.o(96627);
        return versionSpec;
    }

    public static void logDialogActivity(Context context, String str, String str2) {
        AppMethodBeat.i(96628);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        newLogger.logSdkEvent(str, null, bundle);
        AppMethodBeat.o(96628);
    }
}
