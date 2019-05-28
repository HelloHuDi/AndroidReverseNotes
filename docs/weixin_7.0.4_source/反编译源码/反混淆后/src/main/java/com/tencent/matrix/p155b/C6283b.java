package com.tencent.matrix.p155b;

import android.app.Application;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.b.b */
public abstract class C6283b implements C1063a {
    public static final int PLUGIN_CREATE = 0;
    public static final int PLUGIN_DESTROYED = 8;
    public static final int PLUGIN_INITED = 1;
    public static final int PLUGIN_STARTED = 2;
    public static final int PLUGIN_STOPPED = 4;
    private static final String TAG = "Matrix.Plugin";
    private Application application;
    private boolean isSupported = true;
    private C1061c pluginListener;
    private int status = 0;

    public void init(Application application, C1061c c1061c) {
        if (this.application == null && this.pluginListener == null) {
            this.status = 1;
            this.application = application;
            this.pluginListener = c1061c;
            return;
        }
        throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }

    public Application getApplication() {
        return this.application;
    }

    public void start() {
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin start, but plugin has been already destroyed");
        } else if (isPluginStarted()) {
            throw new RuntimeException("plugin start, but plugin has been already started");
        } else {
            this.status = 2;
            if (this.pluginListener == null) {
                throw new RuntimeException("plugin start, plugin listener is null");
            }
            this.pluginListener.mo4195c(this);
        }
    }

    public void stop() {
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin stop, but plugin has been already destroyed");
        } else if (isPluginStarted()) {
            this.status = 4;
            if (this.pluginListener == null) {
                throw new RuntimeException("plugin stop, plugin listener is null");
            }
            this.pluginListener.mo4196d(this);
        } else {
            throw new RuntimeException("plugin stop, but plugin is never started");
        }
    }

    public void destroy() {
        if (isPluginStarted()) {
            stop();
        }
        if (isPluginDestroyed()) {
            throw new RuntimeException("plugin destroy, but plugin has been already destroyed");
        }
        this.status = 8;
        if (this.pluginListener == null) {
            throw new RuntimeException("plugin destroy, plugin listener is null");
        }
        this.pluginListener.mo4197e(this);
    }

    public String getTag() {
        return getClass().getName();
    }

    public void onForeground(boolean z) {
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isPluginStarted() {
        return this.status == 2;
    }

    public boolean isPluginStoped() {
        return this.status == 4;
    }

    public boolean isPluginDestroyed() {
        return this.status == 8;
    }

    public boolean isSupported() {
        return this.isSupported;
    }

    public void unSupportPlugin() {
        this.isSupported = false;
    }

    public JSONObject getJsonInfo() {
        return new JSONObject();
    }

    public void onDetectIssue(C1062b c1062b) {
        if (c1062b.tag == null) {
            c1062b.tag = getTag();
        }
        c1062b.bWw = this;
        JSONObject jSONObject = c1062b.bWv;
        try {
            if (c1062b.tag != null) {
                jSONObject.put("tag", c1062b.tag);
            }
            if (c1062b.bWu != null) {
                jSONObject.put("type", c1062b.bWu);
            }
            jSONObject.put("process", C1073d.m2377aD(this.application));
            jSONObject.put("time", System.currentTimeMillis());
        } catch (JSONException e) {
            C1070c.m2367e(TAG, "json error", e);
        }
        this.pluginListener.mo4193a(c1062b);
    }
}
