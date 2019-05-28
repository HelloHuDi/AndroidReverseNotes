package com.tencent.qqmusic.mediaplayer.audiofx;

import android.content.Context;
import android.os.Bundle;

public interface IAudioListenerBuilder {
    IAudioListener createAudioEffect(Bundle bundle);

    Bundle getConfiguration(int i, Bundle bundle);

    String getId();

    void init(Context context);

    boolean isEnabled();

    void release();

    void setConfiguration(int i, Bundle bundle);

    boolean setEnabled(boolean z);

    void setListener(OnBuilderStateChangedListener onBuilderStateChangedListener);
}
