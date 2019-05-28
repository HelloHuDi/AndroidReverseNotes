package com.tencent.mm.protocal.protobuf;

import com.tencent.mm.bt.a;

public abstract class btd extends a {
    public BaseResponse BaseResponse;

    public BaseResponse getBaseResponse() {
        return this.BaseResponse;
    }

    public btd setBaseResponse(BaseResponse baseResponse) {
        this.BaseResponse = baseResponse;
        return this;
    }
}
