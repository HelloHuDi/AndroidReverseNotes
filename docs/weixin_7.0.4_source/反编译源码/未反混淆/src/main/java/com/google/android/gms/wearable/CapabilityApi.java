package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@Deprecated
public interface CapabilityApi {
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    @Deprecated
    public interface AddLocalCapabilityResult extends Result {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CapabilityFilterType {
    }

    @Deprecated
    public interface CapabilityListener {
        void onCapabilityChanged(CapabilityInfo capabilityInfo);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NodeFilterType {
    }

    @Deprecated
    public interface RemoveLocalCapabilityResult extends Result {
    }

    @Deprecated
    public interface GetAllCapabilitiesResult extends Result {
        Map<String, CapabilityInfo> getAllCapabilities();
    }

    @Deprecated
    public interface GetCapabilityResult extends Result {
        CapabilityInfo getCapability();
    }

    PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult<Status> addListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, Uri uri, int i);

    PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, String str);

    PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, int i);

    PendingResult<GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i);

    PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult<Status> removeListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener);

    PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, String str);
}
