package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
    Context a = null;
    TbsVideoCacheListener b = null;
    private boolean c = false;
    private bd d = null;
    private String e;
    private String f;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        AppMethodBeat.i(64605);
        this.a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString("url");
        }
        a(bundle);
        AppMethodBeat.o(64605);
    }

    private void a(Bundle bundle) {
        AppMethodBeat.i(64606);
        if (this.d == null) {
            DexLoader b;
            o.a(true).a(this.a, false, false, null);
            bi a = o.a(true).a();
            if (a != null) {
                b = a.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                b = null;
            }
            if (b != null) {
                this.d = new bd(b);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        if (this.d != null) {
            this.g = this.d.a(this.a, this, bundle);
            if (this.g == null) {
                this.b.onVideoDownloadError(this, -1, "init task error!", null);
                AppMethodBeat.o(64606);
                return;
            }
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "init error!", null);
        }
        AppMethodBeat.o(64606);
    }

    public long getContentLength() {
        AppMethodBeat.i(64611);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64611);
            return 0;
        }
        long d = this.d.d();
        AppMethodBeat.o(64611);
        return d;
    }

    public int getDownloadedSize() {
        AppMethodBeat.i(64612);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64612);
            return 0;
        }
        int e = this.d.e();
        AppMethodBeat.o(64612);
        return e;
    }

    public int getProgress() {
        AppMethodBeat.i(64613);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64613);
            return 0;
        }
        int f = this.d.f();
        AppMethodBeat.o(64613);
        return f;
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    public void pauseTask() {
        AppMethodBeat.i(64607);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64607);
            return;
        }
        this.d.a();
        AppMethodBeat.o(64607);
    }

    public void removeTask(boolean z) {
        AppMethodBeat.i(64610);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64610);
            return;
        }
        this.d.a(z);
        AppMethodBeat.o(64610);
    }

    public void resumeTask() {
        AppMethodBeat.i(64609);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64609);
            return;
        }
        this.d.b();
        AppMethodBeat.o(64609);
    }

    public void stopTask() {
        AppMethodBeat.i(64608);
        if (this.d == null || this.g == null) {
            if (this.b != null) {
                this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(64608);
            return;
        }
        this.d.c();
        AppMethodBeat.o(64608);
    }
}
