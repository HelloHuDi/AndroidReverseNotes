package com.tencent.tmassistantsdk.network;

import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;

public interface IGetSettingHttpListener {
    void onSettingHttpRequestFinish(GetSettingsRequest getSettingsRequest, GetSettingsResponse getSettingsResponse, boolean z);
}
