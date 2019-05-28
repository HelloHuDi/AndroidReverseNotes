package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

@Deprecated
public interface NodeApi {

    @Deprecated
    public interface GetLocalNodeResult extends Result {
        Node getNode();
    }

    @Deprecated
    public interface GetConnectedNodesResult extends Result {
        List<Node> getNodes();
    }

    PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient);

    PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient);
}
