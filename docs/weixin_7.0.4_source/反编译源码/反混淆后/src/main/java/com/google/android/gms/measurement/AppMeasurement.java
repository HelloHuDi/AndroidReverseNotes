package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.p057v4.p065f.C6197a;
import com.facebook.AccessToken;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics.C17704c;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    private final zzgl zzacw;

    @KeepForSdk
    public static final class Event extends C8740a {
        @KeepForSdk
        public static final String AD_REWARD = "_ar";
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";
        public static final String[] zzacx = new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
        public static final String[] zzacy = new String[]{"_cd", APP_EXCEPTION, "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", AD_REWARD, "_vs", "_ep"};

        private Event() {
        }

        public static String zzak(String str) {
            AppMethodBeat.m2504i(69777);
            String zza = zzka.zza(str, zzacx, zzacy);
            AppMethodBeat.m2505o(69777);
            return zza;
        }
    }

    @KeepForSdk
    public static final class Param extends C8741b {
        @KeepForSdk
        public static final String FATAL = "fatal";
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";
        @KeepForSdk
        public static final String TYPE = "type";
        public static final String[] zzacz = new String[]{"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection"};
        public static final String[] zzada = new String[]{"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac"};

        private Param() {
        }

        public static String zzak(String str) {
            AppMethodBeat.m2504i(69778);
            String zza = zzka.zza(str, zzacz, zzada);
            AppMethodBeat.m2505o(69778);
            return zza;
        }
    }

    @KeepForSdk
    public interface OnEventListener {
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public interface EventInterceptor {
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public static final class UserProperty extends C17704c {
        @KeepForSdk
        public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
        public static final String[] zzadb = new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY, "first_open_after_install", "lifetime_user_engagement"};
        public static final String[] zzadc = new String[]{FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte"};

        private UserProperty() {
        }

        public static String zzak(String str) {
            AppMethodBeat.m2504i(69779);
            String zza = zzka.zza(str, zzadb, zzadc);
            AppMethodBeat.m2505o(69779);
            return zza;
        }
    }

    @KeepForSdk
    public static class ConditionalUserProperty {
        @Keep
        @KeepForSdk
        public boolean mActive;
        @Keep
        @KeepForSdk
        public String mAppId;
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        @KeepForSdk
        public String mName;
        @Keep
        @KeepForSdk
        public String mOrigin;
        @Keep
        @KeepForSdk
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        @KeepForSdk
        public String mTriggerEventName;
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;
        @Keep
        @KeepForSdk
        public Object mValue;

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            AppMethodBeat.m2504i(69776);
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzka.zzf(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
            AppMethodBeat.m2505o(69776);
        }
    }

    public AppMeasurement(zzgl zzgl) {
        AppMethodBeat.m2504i(69786);
        Preconditions.checkNotNull(zzgl);
        this.zzacw = zzgl;
        AppMethodBeat.m2505o(69786);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        AppMethodBeat.m2504i(69780);
        AppMeasurement zzjr = zzgl.zzg(context).zzjr();
        AppMethodBeat.m2505o(69780);
        return zzjr;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        AppMethodBeat.m2504i(69799);
        this.zzacw.zzft().beginAdUnitExposure(str);
        AppMethodBeat.m2505o(69799);
    }

    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69803);
        this.zzacw.zzfu().clearConditionalUserProperty(str, str2, bundle);
        AppMethodBeat.m2505o(69803);
    }

    /* Access modifiers changed, original: protected */
    @Keep
    @VisibleForTesting
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.m2504i(69804);
        this.zzacw.zzfu().clearConditionalUserPropertyAs(str, str2, str3, bundle);
        AppMethodBeat.m2505o(69804);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        AppMethodBeat.m2504i(69800);
        this.zzacw.zzft().endAdUnitExposure(str);
        AppMethodBeat.m2505o(69800);
    }

    @Keep
    public long generateEventId() {
        AppMethodBeat.m2504i(69798);
        long zzlb = this.zzacw.zzgb().zzlb();
        AppMethodBeat.m2505o(69798);
        return zzlb;
    }

    @Keep
    public String getAppInstanceId() {
        AppMethodBeat.m2504i(69796);
        String zzja = this.zzacw.zzfu().zzja();
        AppMethodBeat.m2505o(69796);
        return zzja;
    }

    @KeepForSdk
    public Boolean getBoolean() {
        AppMethodBeat.m2504i(69810);
        Boolean zzjx = this.zzacw.zzfu().zzjx();
        AppMethodBeat.m2505o(69810);
        return zzjx;
    }

    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        AppMethodBeat.m2504i(69807);
        List conditionalUserProperties = this.zzacw.zzfu().getConditionalUserProperties(str, str2);
        AppMethodBeat.m2505o(69807);
        return conditionalUserProperties;
    }

    /* Access modifiers changed, original: protected */
    @Keep
    @VisibleForTesting
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        AppMethodBeat.m2504i(69808);
        List conditionalUserPropertiesAs = this.zzacw.zzfu().getConditionalUserPropertiesAs(str, str2, str3);
        AppMethodBeat.m2505o(69808);
        return conditionalUserPropertiesAs;
    }

    @Keep
    public String getCurrentScreenClass() {
        AppMethodBeat.m2504i(69795);
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            String str = zzkd.zzaoi;
            AppMethodBeat.m2505o(69795);
            return str;
        }
        AppMethodBeat.m2505o(69795);
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        AppMethodBeat.m2504i(69794);
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            String str = zzkd.zzul;
            AppMethodBeat.m2505o(69794);
            return str;
        }
        AppMethodBeat.m2505o(69794);
        return null;
    }

    @KeepForSdk
    public Double getDouble() {
        AppMethodBeat.m2504i(69814);
        Double zzka = this.zzacw.zzfu().zzka();
        AppMethodBeat.m2505o(69814);
        return zzka;
    }

    @Keep
    public String getGmpAppId() {
        AppMethodBeat.m2504i(69797);
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            AppMethodBeat.m2505o(69797);
            return googleAppId;
        } catch (IllegalStateException e) {
            this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", e);
            AppMethodBeat.m2505o(69797);
            return null;
        }
    }

    @KeepForSdk
    public Integer getInteger() {
        AppMethodBeat.m2504i(69813);
        Integer zzjz = this.zzacw.zzfu().zzjz();
        AppMethodBeat.m2505o(69813);
        return zzjz;
    }

    @KeepForSdk
    public Long getLong() {
        AppMethodBeat.m2504i(69812);
        Long zzjy = this.zzacw.zzfu().zzjy();
        AppMethodBeat.m2505o(69812);
        return zzjy;
    }

    @Keep
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        AppMethodBeat.m2504i(69809);
        this.zzacw.zzfu();
        Preconditions.checkNotEmpty(str);
        AppMethodBeat.m2505o(69809);
        return 25;
    }

    @KeepForSdk
    public String getString() {
        AppMethodBeat.m2504i(69811);
        String zzhm = this.zzacw.zzfu().zzhm();
        AppMethodBeat.m2505o(69811);
        return zzhm;
    }

    /* Access modifiers changed, original: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(69805);
        Map userProperties = this.zzacw.zzfu().getUserProperties(str, str2, z);
        AppMethodBeat.m2505o(69805);
        return userProperties;
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        AppMethodBeat.m2504i(69790);
        List<zzjx> zzj = this.zzacw.zzfu().zzj(z);
        C6197a c6197a = new C6197a(zzj.size());
        for (zzjx zzjx : zzj) {
            c6197a.put(zzjx.name, zzjx.getValue());
        }
        AppMethodBeat.m2505o(69790);
        return c6197a;
    }

    /* Access modifiers changed, original: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(69806);
        Map userPropertiesAs = this.zzacw.zzfu().getUserPropertiesAs(str, str2, str3, z);
        AppMethodBeat.m2505o(69806);
        return userPropertiesAs;
    }

    public final void logEvent(String str, Bundle bundle) {
        AppMethodBeat.m2504i(69781);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().zza("app", str, bundle, true);
        AppMethodBeat.m2505o(69781);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(69787);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().logEvent(str, str2, bundle);
        AppMethodBeat.m2505o(69787);
    }

    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        AppMethodBeat.m2504i(69788);
        this.zzacw.zzfu().zza(str, str2, bundle == null ? new Bundle() : bundle, j);
        AppMethodBeat.m2505o(69788);
    }

    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.m2504i(69792);
        this.zzacw.zzfu().registerOnMeasurementEventListener(onEventListener);
        AppMethodBeat.m2505o(69792);
    }

    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69801);
        this.zzacw.zzfu().setConditionalUserProperty(conditionalUserProperty);
        AppMethodBeat.m2505o(69801);
    }

    /* Access modifiers changed, original: protected */
    @Keep
    @VisibleForTesting
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.m2504i(69802);
        this.zzacw.zzfu().setConditionalUserPropertyAs(conditionalUserProperty);
        AppMethodBeat.m2505o(69802);
    }

    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        AppMethodBeat.m2504i(69791);
        this.zzacw.zzfu().setEventInterceptor(eventInterceptor);
        AppMethodBeat.m2505o(69791);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        AppMethodBeat.m2504i(69783);
        this.zzacw.zzfu().setMeasurementEnabled(z);
        AppMethodBeat.m2505o(69783);
    }

    public final void setMinimumSessionDuration(long j) {
        AppMethodBeat.m2504i(69784);
        this.zzacw.zzfu().setMinimumSessionDuration(j);
        AppMethodBeat.m2505o(69784);
    }

    public final void setSessionTimeoutDuration(long j) {
        AppMethodBeat.m2504i(69785);
        this.zzacw.zzfu().setSessionTimeoutDuration(j);
        AppMethodBeat.m2505o(69785);
    }

    public final void setUserProperty(String str, String str2) {
        AppMethodBeat.m2504i(69782);
        int zzce = this.zzacw.zzgb().zzce(str);
        if (zzce != 0) {
            this.zzacw.zzgb();
            this.zzacw.zzgb().zza(zzce, "_ev", zzka.zza(str, 24, true), str != null ? str.length() : 0);
            AppMethodBeat.m2505o(69782);
            return;
        }
        setUserPropertyInternal("app", str, str2);
        AppMethodBeat.m2505o(69782);
    }

    @KeepForSdk
    public void setUserPropertyInternal(String str, String str2, Object obj) {
        AppMethodBeat.m2504i(69789);
        this.zzacw.zzfu().setUserProperty(str, str2, obj);
        AppMethodBeat.m2505o(69789);
    }

    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.m2504i(69793);
        this.zzacw.zzfu().unregisterOnMeasurementEventListener(onEventListener);
        AppMethodBeat.m2505o(69793);
    }
}
