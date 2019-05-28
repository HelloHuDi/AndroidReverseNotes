package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable.WearableOptions;
import java.util.List;

public abstract class NodeClient extends GoogleApi<WearableOptions> {
    public NodeClient(Activity activity, Settings settings) {
        super(activity, Wearable.API, null, settings);
    }

    public NodeClient(Context context, Settings settings) {
        super(context, Wearable.API, null, settings);
    }

    public abstract Task<List<Node>> getConnectedNodes();

    public abstract Task<Node> getLocalNode();
}
