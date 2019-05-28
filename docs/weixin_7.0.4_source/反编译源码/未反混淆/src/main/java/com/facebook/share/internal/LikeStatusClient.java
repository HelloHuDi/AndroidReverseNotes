package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
final class LikeStatusClient extends PlatformServiceClient {
    private String objectId;

    LikeStatusClient(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.objectId = str2;
    }

    public final void populateRequestBundle(Bundle bundle) {
        AppMethodBeat.i(97122);
        bundle.putString(ShareConstants.EXTRA_OBJECT_ID, this.objectId);
        AppMethodBeat.o(97122);
    }
}
