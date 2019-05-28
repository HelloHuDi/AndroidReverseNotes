package com.tencent.tmassistantsdk.network;

import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;

public interface IGetAuthorizedHttpRequestListenner {
    void onGetAuthorizedRequestFinished(AuthorizedResult authorizedResult, int i);
}
