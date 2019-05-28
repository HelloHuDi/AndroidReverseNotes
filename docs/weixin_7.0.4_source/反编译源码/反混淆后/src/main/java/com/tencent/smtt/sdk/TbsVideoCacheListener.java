package com.tencent.smtt.sdk;

import android.os.Bundle;

public interface TbsVideoCacheListener {
    void onVideoDownloadCompletion(TbsVideoCacheTask tbsVideoCacheTask, long j, long j2, Bundle bundle);

    void onVideoDownloadError(TbsVideoCacheTask tbsVideoCacheTask, int i, String str, Bundle bundle);

    void onVideoDownloadInit(TbsVideoCacheTask tbsVideoCacheTask, int i, String str, Bundle bundle);

    void onVideoDownloadProgress(TbsVideoCacheTask tbsVideoCacheTask, int i, long j, int i2, Bundle bundle);

    void onVideoDownloadStart(TbsVideoCacheTask tbsVideoCacheTask, Bundle bundle);
}
