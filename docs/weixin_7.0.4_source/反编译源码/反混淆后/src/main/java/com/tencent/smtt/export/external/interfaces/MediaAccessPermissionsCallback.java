package com.tencent.smtt.export.external.interfaces;

public interface MediaAccessPermissionsCallback {
    public static final long ALLOW_AUDIO_CAPTURE = 4;
    public static final long ALLOW_VIDEO_CAPTURE = 2;
    public static final long BITMASK_RESOURCE_AUDIO_CAPTURE = 4;
    public static final long BITMASK_RESOURCE_VIDEO_CAPTURE = 2;

    void invoke(String str, long j, boolean z);
}
