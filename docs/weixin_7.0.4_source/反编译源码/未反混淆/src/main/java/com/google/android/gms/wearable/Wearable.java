package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v4.f.l;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.wearable.internal.zzaa;
import com.google.android.gms.wearable.internal.zzaj;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zzbv;
import com.google.android.gms.wearable.internal.zzbw;
import com.google.android.gms.wearable.internal.zzcj;
import com.google.android.gms.wearable.internal.zzeu;
import com.google.android.gms.wearable.internal.zzez;
import com.google.android.gms.wearable.internal.zzfg;
import com.google.android.gms.wearable.internal.zzfl;
import com.google.android.gms.wearable.internal.zzgi;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzhg;
import com.google.android.gms.wearable.internal.zzhq;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wearable {
    @Deprecated
    public static final Api<WearableOptions> API = new Api("Wearable.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<zzhg, WearableOptions> CLIENT_BUILDER = new zzj();
    private static final ClientKey<zzhg> CLIENT_KEY = new ClientKey();
    @Deprecated
    public static final CapabilityApi CapabilityApi = new zzo();
    @Deprecated
    public static final ChannelApi ChannelApi = new zzaj();
    @Deprecated
    public static final DataApi DataApi = new zzbw();
    @Deprecated
    public static final MessageApi MessageApi = new zzeu();
    @Deprecated
    public static final NodeApi NodeApi = new zzfg();
    @Deprecated
    private static final zzi zzaa = new zzgi();
    @Deprecated
    private static final zzu zzab = new zzhq();
    @Deprecated
    private static final zzc zzx = new zzk();
    @Deprecated
    private static final zza zzy = new zzh();
    @Deprecated
    private static final zzf zzz = new zzbv();

    public static final class WearableOptions implements Optional {
        private final Looper zzac;

        public static class Builder {
            private Looper zzac;

            public WearableOptions build() {
                AppMethodBeat.i(70889);
                WearableOptions wearableOptions = new WearableOptions(this, null);
                AppMethodBeat.o(70889);
                return wearableOptions;
            }

            public Builder setLooper(Looper looper) {
                this.zzac = looper;
                return this;
            }
        }

        private WearableOptions(Builder builder) {
            AppMethodBeat.i(70890);
            this.zzac = builder.zzac;
            AppMethodBeat.o(70890);
        }

        /* synthetic */ WearableOptions(Builder builder, zzj zzj) {
            this(builder);
        }

        private final Settings zza() {
            AppMethodBeat.i(70891);
            Settings build;
            if (this.zzac != null) {
                build = new com.google.android.gms.common.api.GoogleApi.Settings.Builder().setLooper(this.zzac).build();
                AppMethodBeat.o(70891);
                return build;
            }
            build = Settings.DEFAULT_SETTINGS;
            AppMethodBeat.o(70891);
            return build;
        }

        static /* synthetic */ Settings zza(WearableOptions wearableOptions) {
            AppMethodBeat.i(70892);
            Settings zza = wearableOptions.zza();
            AppMethodBeat.o(70892);
            return zza;
        }
    }

    static {
        AppMethodBeat.i(70913);
        AppMethodBeat.o(70913);
    }

    private Wearable() {
    }

    public static CapabilityClient getCapabilityClient(Activity activity) {
        AppMethodBeat.i(70903);
        zzaa zzaa = new zzaa(activity, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70903);
        return zzaa;
    }

    public static CapabilityClient getCapabilityClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(70904);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzaa zzaa = new zzaa(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70904);
        return zzaa;
    }

    public static CapabilityClient getCapabilityClient(Context context) {
        AppMethodBeat.i(70901);
        zzaa zzaa = new zzaa(context, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70901);
        return zzaa;
    }

    public static CapabilityClient getCapabilityClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(70902);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzaa zzaa = new zzaa(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70902);
        return zzaa;
    }

    public static ChannelClient getChannelClient(Activity activity) {
        AppMethodBeat.i(70911);
        zzao zzao = new zzao(activity, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70911);
        return zzao;
    }

    public static ChannelClient getChannelClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(70912);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzao zzao = new zzao(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70912);
        return zzao;
    }

    public static ChannelClient getChannelClient(Context context) {
        AppMethodBeat.i(70909);
        zzao zzao = new zzao(context, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70909);
        return zzao;
    }

    public static ChannelClient getChannelClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(70910);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzao zzao = new zzao(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70910);
        return zzao;
    }

    public static DataClient getDataClient(Activity activity) {
        AppMethodBeat.i(70895);
        zzcj zzcj = new zzcj(activity, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70895);
        return zzcj;
    }

    public static DataClient getDataClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(70896);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzcj zzcj = new zzcj(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70896);
        return zzcj;
    }

    public static DataClient getDataClient(Context context) {
        AppMethodBeat.i(70893);
        zzcj zzcj = new zzcj(context, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70893);
        return zzcj;
    }

    public static DataClient getDataClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(70894);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzcj zzcj = new zzcj(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70894);
        return zzcj;
    }

    public static MessageClient getMessageClient(Activity activity) {
        AppMethodBeat.i(70899);
        zzez zzez = new zzez(activity, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70899);
        return zzez;
    }

    public static MessageClient getMessageClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(70900);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzez zzez = new zzez(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70900);
        return zzez;
    }

    public static MessageClient getMessageClient(Context context) {
        AppMethodBeat.i(70897);
        zzez zzez = new zzez(context, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70897);
        return zzez;
    }

    public static MessageClient getMessageClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(70898);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzez zzez = new zzez(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70898);
        return zzez;
    }

    public static NodeClient getNodeClient(Activity activity) {
        AppMethodBeat.i(70907);
        zzfl zzfl = new zzfl(activity, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70907);
        return zzfl;
    }

    public static NodeClient getNodeClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(70908);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzfl zzfl = new zzfl(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70908);
        return zzfl;
    }

    public static NodeClient getNodeClient(Context context) {
        AppMethodBeat.i(70905);
        zzfl zzfl = new zzfl(context, Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(70905);
        return zzfl;
    }

    public static NodeClient getNodeClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(70906);
        l.checkNotNull(wearableOptions, "options must not be null");
        zzfl zzfl = new zzfl(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(70906);
        return zzfl;
    }
}
