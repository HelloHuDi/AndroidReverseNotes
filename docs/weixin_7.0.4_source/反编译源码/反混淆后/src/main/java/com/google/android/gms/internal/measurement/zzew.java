package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;

@VisibleForTesting
public final class zzew {
    private static final zzxc zzagc;
    private static zzex<Boolean> zzagd = zzex.zzb("measurement.log_third_party_store_events_enabled", false, false);
    private static zzex<Boolean> zzage = zzex.zzb("measurement.log_installs_enabled", false, false);
    private static zzex<Boolean> zzagf = zzex.zzb("measurement.log_upgrades_enabled", false, false);
    private static zzex<Boolean> zzagg = zzex.zzb("measurement.log_androidId_enabled", false, false);
    public static zzex<Boolean> zzagh = zzex.zzb("measurement.upload_dsid_enabled", false, false);
    public static zzex<String> zzagi = zzex.zzd("measurement.log_tag", "FA", "FA-SVC");
    public static zzex<Long> zzagj = zzex.zzb("measurement.ad_id_cache_time", 10000, 10000);
    public static zzex<Long> zzagk = zzex.zzb("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static zzex<Long> zzagl = zzex.zzb("measurement.config.cache_time", 86400000, 3600000);
    public static zzex<String> zzagm;
    public static zzex<String> zzagn;
    public static zzex<Integer> zzago = zzex.zzc("measurement.upload.max_bundles", 100, 100);
    public static zzex<Integer> zzagp = zzex.zzc("measurement.upload.max_batch_size", 65536, 65536);
    public static zzex<Integer> zzagq = zzex.zzc("measurement.upload.max_bundle_size", 65536, 65536);
    public static zzex<Integer> zzagr = zzex.zzc("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zzex<Integer> zzags = zzex.zzc("measurement.upload.max_events_per_day", 100000, 100000);
    public static zzex<Integer> zzagt = zzex.zzc("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zzex<Integer> zzagu = zzex.zzc("measurement.upload.max_public_events_per_day", SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
    public static zzex<Integer> zzagv = zzex.zzc("measurement.upload.max_conversions_per_day", 500, 500);
    public static zzex<Integer> zzagw = zzex.zzc("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zzex<Integer> zzagx = zzex.zzc("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static zzex<String> zzagy;
    public static zzex<Long> zzagz = zzex.zzb("measurement.upload.backoff_period", 43200000, 43200000);
    public static zzex<Long> zzaha = zzex.zzb("measurement.upload.window_interval", 3600000, 3600000);
    public static zzex<Long> zzahb = zzex.zzb("measurement.upload.interval", 3600000, 3600000);
    public static zzex<Long> zzahc = zzex.zzb("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static zzex<Long> zzahd = zzex.zzb("measurement.upload.debug_upload_interval", 1000, 1000);
    public static zzex<Long> zzahe = zzex.zzb("measurement.upload.minimum_delay", 500, 500);
    public static zzex<Long> zzahf = zzex.zzb("measurement.alarm_manager.minimum_interval", 60000, 60000);
    public static zzex<Long> zzahg = zzex.zzb("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static zzex<Long> zzahh = zzex.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static zzex<Long> zzahi = zzex.zzb("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static zzex<Long> zzahj = zzex.zzb("measurement.upload.retry_time", 1800000, 1800000);
    public static zzex<Integer> zzahk = zzex.zzc("measurement.upload.retry_count", 6, 6);
    public static zzex<Long> zzahl = zzex.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zzex<Integer> zzahm = zzex.zzc("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zzex<Integer> zzahn = zzex.zzc("measurement.audience.filter_result_max_count", 200, 200);
    public static zzex<Long> zzaho = zzex.zzb("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    public static zzex<Boolean> zzahp = zzex.zzb("measurement.test.boolean_flag", false, false);
    public static zzex<String> zzahq;
    public static zzex<Long> zzahr = zzex.zzb("measurement.test.long_flag", -1, -1);
    public static zzex<Integer> zzahs = zzex.zzc("measurement.test.int_flag", -2, -2);
    public static zzex<Double> zzaht = zzex.zza("measurement.test.double_flag", -3.0d, -3.0d);
    public static zzex<Boolean> zzahu = zzex.zzb("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
    public static zzex<Boolean> zzahv = zzex.zzb("measurement.audience.complex_param_evaluation", false, false);
    public static zzex<Boolean> zzahw = zzex.zzb("measurement.validation.internal_limits_internal_event_params", false, false);
    public static zzex<Boolean> zzahx = zzex.zzb("measurement.quality.unsuccessful_update_retry_counter", false, false);
    public static zzex<Boolean> zzahy = zzex.zzb("measurement.iid.disable_on_collection_disabled", true, true);
    public static zzex<Boolean> zzahz = zzex.zzb("measurement.app_launch.call_only_when_enabled", true, true);
    public static zzex<Boolean> zzaia = zzex.zzb("measurement.run_on_worker_inline", true, false);
    private static zzex<Boolean> zzaib = zzex.zzb("measurement.audience.dynamic_filters", false, false);
    public static zzex<Boolean> zzaic = zzex.zzb("measurement.reset_analytics.persist_time", false, false);

    static {
        AppMethodBeat.m2504i(68750);
        String str = "content://com.google.android.gms.phenotype/";
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        zzagc = new zzxc(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        String str2 = "https";
        zzagm = zzex.zzd("measurement.config.url_scheme", str2, str2);
        str2 = "app-measurement.com";
        zzagn = zzex.zzd("measurement.config.url_authority", str2, str2);
        str2 = "https://app-measurement.com/a";
        zzagy = zzex.zzd("measurement.upload.url", str2, str2);
        str2 = "---";
        zzahq = zzex.zzd("measurement.test.string_flag", str2, str2);
        AppMethodBeat.m2505o(68750);
    }
}
