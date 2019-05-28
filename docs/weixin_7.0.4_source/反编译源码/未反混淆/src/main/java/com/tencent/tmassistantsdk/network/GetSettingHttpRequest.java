package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingHttpRequest extends PostHttpRequest {
    protected static final String TAG = "GetSettingHttpRequest";
    protected IGetSettingHttpListener mListener = null;

    public void setGetSettingHttpListener(IGetSettingHttpListener iGetSettingHttpListener) {
        this.mListener = iGetSettingHttpListener;
    }

    public void sendSettingRequest() {
        AppMethodBeat.i(75836);
        super.sendRequest(new GetSettingsRequest());
        AppMethodBeat.o(75836);
    }

    /* Access modifiers changed, original: protected */
    public void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i) {
        AppMethodBeat.i(75837);
        if (jceStruct2 == null) {
            TMLog.i(TAG, "response is null!");
            AppMethodBeat.o(75837);
            return;
        }
        if (this.mListener != null && i == 0 && (jceStruct2 instanceof GetSettingsResponse)) {
            GetSettingsResponse getSettingsResponse = (GetSettingsResponse) jceStruct2;
            if (getSettingsResponse.ret == 0) {
                this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, true);
                AppMethodBeat.o(75837);
                return;
            }
            this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, false);
        }
        AppMethodBeat.o(75837);
    }
}
