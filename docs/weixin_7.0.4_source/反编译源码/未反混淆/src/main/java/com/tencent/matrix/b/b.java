package com.tencent.matrix.b;

import android.app.Application;
import com.tencent.matrix.c.c.a;
import com.tencent.matrix.d.c;
import com.tencent.matrix.d.d;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b implements a {
    public static final int PLUGIN_CREATE = 0;
    public static final int PLUGIN_DESTROYED = 8;
    public static final int PLUGIN_INITED = 1;
    public static final int PLUGIN_STARTED = 2;
    public static final int PLUGIN_STOPPED = 4;
    private static final String TAG = "Matrix.Plugin";
    private Application application;
    private boolean isSupported = true;
    private c pluginListener;
    private int status = 0;

    public void init(Application application, c cVar) {
        if (this.application == null && this.pluginListener == null) {
            this.status = 1;
            this.application = application;
            this.pluginListener = cVar;
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
            this.pluginListener.c(this);
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
            this.pluginListener.d(this);
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
        this.pluginListener.e(this);
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

    public void onDetectIssue(com.tencent.matrix.c.b bVar) {
        if (bVar.tag == null) {
            bVar.tag = getTag();
        }
        bVar.bWw = this;
        JSONObject jSONObject = bVar.bWv;
        try {
            if (bVar.tag != null) {
                jSONObject.put("tag", bVar.tag);
            }
            if (bVar.bWu != null) {
                jSONObject.put("type", bVar.bWu);
            }
            jSONObject.put("process", d.aD(this.application));
            jSONObject.put("time", System.currentTimeMillis());
        } catch (JSONException e) {
            c.e(TAG, "json error", e);
        }
        this.pluginListener.a(bVar);
    }
}
