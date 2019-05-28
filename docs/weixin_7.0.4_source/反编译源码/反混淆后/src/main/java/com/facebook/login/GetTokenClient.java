package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

final class GetTokenClient extends PlatformServiceClient {
    GetTokenClient(Context context, String str) {
        super(context, 65536, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, NativeProtocol.PROTOCOL_VERSION_20121101, str);
    }

    public final void populateRequestBundle(Bundle bundle) {
    }
}
