package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.Wearable.WearableOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public abstract class CapabilityClient extends GoogleApi<WearableOptions> {
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CapabilityFilterType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NodeFilterType {
    }

    public interface OnCapabilityChangedListener extends CapabilityListener {
        void onCapabilityChanged(CapabilityInfo capabilityInfo);
    }

    public CapabilityClient(Activity activity, Settings settings) {
        super(activity, Wearable.API, null, settings);
    }

    public CapabilityClient(Context context, Settings settings) {
        super(context, Wearable.API, null, settings);
    }

    public abstract Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, Uri uri, int i);

    public abstract Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, String str);

    public abstract Task<Void> addLocalCapability(String str);

    public abstract Task<Map<String, CapabilityInfo>> getAllCapabilities(int i);

    public abstract Task<CapabilityInfo> getCapability(String str, int i);

    public abstract Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener);

    public abstract Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener, String str);

    public abstract Task<Void> removeLocalCapability(String str);
}
