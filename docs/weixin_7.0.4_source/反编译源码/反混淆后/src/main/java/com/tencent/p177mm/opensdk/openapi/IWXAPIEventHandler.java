package com.tencent.p177mm.opensdk.openapi;

import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;

/* renamed from: com.tencent.mm.opensdk.openapi.IWXAPIEventHandler */
public interface IWXAPIEventHandler {
    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
