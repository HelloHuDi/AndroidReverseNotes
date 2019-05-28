package com.tencent.rtmp;

import android.os.Bundle;

public interface ITXLivePlayListener {
    void onNetStatus(Bundle bundle);

    void onPlayEvent(int i, Bundle bundle);
}
