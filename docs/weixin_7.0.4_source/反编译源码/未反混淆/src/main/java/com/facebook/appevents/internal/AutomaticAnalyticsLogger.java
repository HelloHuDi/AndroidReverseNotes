package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticAnalyticsLogger {
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    static class PurchaseLoggingParameters {
        Currency currency;
        Bundle param;
        BigDecimal purchaseAmount;

        PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.purchaseAmount = bigDecimal;
            this.currency = currency;
            this.param = bundle;
        }
    }

    static {
        AppMethodBeat.i(72178);
        AppMethodBeat.o(72178);
    }

    public static void logActivateAppEvent() {
        AppMethodBeat.i(72172);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean autoLogAppEventsEnabled = FacebookSdk.getAutoLogAppEventsEnabled();
        Validate.notNull(applicationContext, "context");
        if (autoLogAppEventsEnabled && (applicationContext instanceof Application)) {
            AppEventsLogger.activateApp((Application) applicationContext, applicationId);
        }
        AppMethodBeat.o(72172);
    }

    public static void logActivityTimeSpentEvent(String str, long j) {
        AppMethodBeat.i(72173);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        Validate.notNull(applicationContext, "context");
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j > 0) {
            AppEventsLogger newLogger = AppEventsLogger.newLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j, bundle);
        }
        AppMethodBeat.o(72173);
    }

    public static void logPurchaseInapp(String str, String str2) {
        AppMethodBeat.i(72174);
        if (isImplicitPurchaseLoggingEnabled()) {
            PurchaseLoggingParameters purchaseLoggingParameters = getPurchaseLoggingParameters(str, str2);
            if (purchaseLoggingParameters != null) {
                internalAppEventsLogger.logPurchaseImplicitlyInternal(purchaseLoggingParameters.purchaseAmount, purchaseLoggingParameters.currency, purchaseLoggingParameters.param);
            }
            AppMethodBeat.o(72174);
            return;
        }
        AppMethodBeat.o(72174);
    }

    /* JADX WARNING: Missing block: B:5:0x001f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(72175);
     */
    /* JADX WARNING: Missing block: B:7:0x0026, code skipped:
            r1 = getPurchaseLoggingParameters(r7, r8);
     */
    /* JADX WARNING: Missing block: B:8:0x002a, code skipped:
            if (r1 == null) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:9:0x002c, code skipped:
            internalAppEventsLogger.logEventImplicitly(r0, r1.purchaseAmount, r1.currency, r1.param);
     */
    /* JADX WARNING: Missing block: B:10:0x0037, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(72175);
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void logPurchaseSubs(SubscriptionType subscriptionType, String str, String str2) {
        AppMethodBeat.i(72175);
        if (isImplicitPurchaseLoggingEnabled()) {
            String applicationId = FacebookSdk.getApplicationId();
            switch (subscriptionType) {
                case RESTORE:
                    applicationId = "SubscriptionRestore";
                    break;
                case CANCEL:
                    applicationId = "SubscriptionCancel";
                    break;
                case HEARTBEAT:
                    applicationId = "SubscriptionHeartbeat";
                    break;
                case EXPIRE:
                    applicationId = "SubscriptionExpire";
                    break;
                case NEW:
                    if (!FetchedAppGateKeepersManager.getGateKeeperForKey(FetchedAppGateKeepersManager.APP_EVENTS_IF_AUTO_LOG_SUBS, applicationId, true)) {
                        logPurchaseInapp(str, str2);
                        break;
                    } else {
                        applicationId = AppEventsConstants.EVENT_NAME_SUBSCRIBE;
                        break;
                    }
            }
        }
        AppMethodBeat.o(72175);
    }

    public static boolean isImplicitPurchaseLoggingEnabled() {
        AppMethodBeat.i(72176);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled()) {
            AppMethodBeat.o(72176);
            return true;
        }
        AppMethodBeat.o(72176);
        return false;
    }

    private static PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        AppMethodBeat.i(72177);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString("productId"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString(DownloadInfoColumns.PACKAGENAME));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            PurchaseLoggingParameters purchaseLoggingParameters = new PurchaseLoggingParameters(new BigDecimal(((double) jSONObject2.getLong("price_amount_micros")) / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
            AppMethodBeat.o(72177);
            return purchaseLoggingParameters;
        } catch (JSONException e) {
            AppMethodBeat.o(72177);
            return null;
        }
    }
}
