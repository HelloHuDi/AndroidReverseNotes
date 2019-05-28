package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.tmassistantsdk.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;

public interface ITMAssistantExchangeURLListenner {
    void onExchangedURLSucceed(ArrayList<AppSimpleDetail> arrayList, boolean z);
}
