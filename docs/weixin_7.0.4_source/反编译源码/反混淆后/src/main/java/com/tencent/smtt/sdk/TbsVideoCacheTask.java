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
    /* renamed from: a */
    Context f17285a = null;
    /* renamed from: b */
    TbsVideoCacheListener f17286b = null;
    /* renamed from: c */
    private boolean f17287c = false;
    /* renamed from: d */
    private C40975bd f17288d = null;
    /* renamed from: e */
    private String f17289e;
    /* renamed from: f */
    private String f17290f;
    /* renamed from: g */
    private Object f17291g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        AppMethodBeat.m2504i(64605);
        this.f17285a = context;
        this.f17286b = tbsVideoCacheListener;
        if (bundle != null) {
            this.f17289e = bundle.getString("taskId");
            this.f17290f = bundle.getString("url");
        }
        m80426a(bundle);
        AppMethodBeat.m2505o(64605);
    }

    /* renamed from: a */
    private void m80426a(Bundle bundle) {
        AppMethodBeat.m2504i(64606);
        if (this.f17288d == null) {
            DexLoader b;
            C5818o.m8863a(true).mo12196a(this.f17285a, false, false, null);
            C30947bi a = C5818o.m8863a(true).mo12195a();
            if (a != null) {
                b = a.mo50067b();
            } else {
                this.f17286b.onVideoDownloadError(this, -1, "init engine error!", null);
                b = null;
            }
            if (b != null) {
                this.f17288d = new C40975bd(b);
            } else {
                this.f17286b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        if (this.f17288d != null) {
            this.f17291g = this.f17288d.mo64909a(this.f17285a, this, bundle);
            if (this.f17291g == null) {
                this.f17286b.onVideoDownloadError(this, -1, "init task error!", null);
                AppMethodBeat.m2505o(64606);
                return;
            }
        } else if (this.f17286b != null) {
            this.f17286b.onVideoDownloadError(this, -1, "init error!", null);
        }
        AppMethodBeat.m2505o(64606);
    }

    public long getContentLength() {
        AppMethodBeat.m2504i(64611);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64611);
            return 0;
        }
        long d = this.f17288d.mo64914d();
        AppMethodBeat.m2505o(64611);
        return d;
    }

    public int getDownloadedSize() {
        AppMethodBeat.m2504i(64612);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64612);
            return 0;
        }
        int e = this.f17288d.mo64915e();
        AppMethodBeat.m2505o(64612);
        return e;
    }

    public int getProgress() {
        AppMethodBeat.m2504i(64613);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64613);
            return 0;
        }
        int f = this.f17288d.mo64916f();
        AppMethodBeat.m2505o(64613);
        return f;
    }

    public String getTaskID() {
        return this.f17289e;
    }

    public String getTaskUrl() {
        return this.f17290f;
    }

    public void pauseTask() {
        AppMethodBeat.m2504i(64607);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64607);
            return;
        }
        this.f17288d.mo64910a();
        AppMethodBeat.m2505o(64607);
    }

    public void removeTask(boolean z) {
        AppMethodBeat.m2504i(64610);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64610);
            return;
        }
        this.f17288d.mo64911a(z);
        AppMethodBeat.m2505o(64610);
    }

    public void resumeTask() {
        AppMethodBeat.m2504i(64609);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64609);
            return;
        }
        this.f17288d.mo64912b();
        AppMethodBeat.m2505o(64609);
    }

    public void stopTask() {
        AppMethodBeat.m2504i(64608);
        if (this.f17288d == null || this.f17291g == null) {
            if (this.f17286b != null) {
                this.f17286b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
            }
            AppMethodBeat.m2505o(64608);
            return;
        }
        this.f17288d.mo64913c();
        AppMethodBeat.m2505o(64608);
    }
}
