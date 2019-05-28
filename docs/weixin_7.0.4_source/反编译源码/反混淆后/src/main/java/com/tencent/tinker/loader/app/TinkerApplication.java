package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.hotplug.UnsupportedEnvironmentException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Method;

public abstract class TinkerApplication extends Application {
    private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    private static final int TINKER_DISABLE = 0;
    private static final String TINKER_LOADER_METHOD = "tryLoad";
    private Method appLikeGetAssets;
    private Method appLikeGetBaseContext;
    private Method appLikeGetClassLoader;
    private Method appLikeGetResources;
    private Method appLikeGetSystemService;
    private Method appLikeOnBaseContextAttached;
    private Method appLikeOnConfigurationChanged;
    private Method appLikeOnCreate;
    private Method appLikeOnLowMemory;
    private Method appLikeOnTerminate;
    private Method appLikeOnTrimMemory;
    private Object applicationLike;
    private long applicationStartElapsedTime;
    private long applicationStartMillisTime;
    private final String delegateClassName;
    private final String loaderClassName;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    private Intent tinkerResultIntent;
    private boolean useSafeMode;

    protected TinkerApplication(int i) {
        this(i, "com.tencent.tinker.entry.DefaultApplicationLike", TinkerLoader.class.getName(), false);
    }

    protected TinkerApplication(int i, String str, String str2, boolean z) {
        this.applicationLike = null;
        this.appLikeOnBaseContextAttached = null;
        this.appLikeOnCreate = null;
        this.appLikeOnTerminate = null;
        this.appLikeOnLowMemory = null;
        this.appLikeOnTrimMemory = null;
        this.appLikeOnConfigurationChanged = null;
        this.appLikeGetResources = null;
        this.appLikeGetClassLoader = null;
        this.appLikeGetAssets = null;
        this.appLikeGetSystemService = null;
        this.appLikeGetBaseContext = null;
        this.tinkerFlags = i;
        this.delegateClassName = str;
        this.loaderClassName = str2;
        this.tinkerLoadVerifyFlag = z;
    }

    protected TinkerApplication(int i, String str) {
        this(i, str, TinkerLoader.class.getName(), false);
    }

    private Object createDelegate() {
        try {
            return Class.forName(this.delegateClassName, false, getClassLoader()).getConstructor(new Class[]{Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class}).newInstance(new Object[]{this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag), Long.valueOf(this.applicationStartElapsedTime), Long.valueOf(this.applicationStartMillisTime), this.tinkerResultIntent});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("createDelegate failed", th);
        }
    }

    private synchronized void ensureDelegate() {
        if (this.applicationLike == null) {
            this.applicationLike = createDelegate();
        }
    }

    private void invokeAppLikeOnBaseContextAttached(Object obj, Context context) {
        try {
            if (this.appLikeOnBaseContextAttached == null) {
                this.appLikeOnBaseContextAttached = ShareReflectUtil.m9396b(this.applicationLike, "onBaseContextAttached", Context.class);
            }
            this.appLikeOnBaseContextAttached.invoke(obj, new Object[]{context});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onBaseContextAttached of appLike.", th);
        }
    }

    private void onBaseContextAttached(Context context) {
        try {
            this.applicationStartElapsedTime = SystemClock.elapsedRealtime();
            this.applicationStartMillisTime = System.currentTimeMillis();
            loadTinker();
            ensureDelegate();
            invokeAppLikeOnBaseContextAttached(this.applicationLike, context);
            if (this.useSafeMode) {
                ShareTinkerInternals.m9417aD(this, 0);
            }
        } catch (TinkerRuntimeException e) {
            throw e;
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    /* Access modifiers changed, original: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
        onBaseContextAttached(context);
    }

    private void loadTinker() {
        try {
            Class cls = Class.forName(this.loaderClassName, false, getClassLoader());
            this.tinkerResultIntent = (Intent) cls.getMethod(TINKER_LOADER_METHOD, new Class[]{TinkerApplication.class}).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[]{this});
        } catch (Throwable th) {
            this.tinkerResultIntent = new Intent();
            ShareIntentUtil.m9354b(this.tinkerResultIntent, -20);
            this.tinkerResultIntent.putExtra(INTENT_PATCH_EXCEPTION, th);
        }
    }

    private void invokeAppLikeOnCreate(Object obj) {
        try {
            if (this.appLikeOnCreate == null) {
                this.appLikeOnCreate = ShareReflectUtil.m9396b(this.applicationLike, "onCreate", new Class[0]);
            }
            this.appLikeOnCreate.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onCreate of appLike.", th);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            ensureDelegate();
            ComponentHotplug.dSl();
            invokeAppLikeOnCreate(this.applicationLike);
        } catch (UnsupportedEnvironmentException e) {
            throw new TinkerRuntimeException("failed to make sure that ComponentHotplug logic is fine.", e);
        } catch (TinkerRuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    private void invokeAppLikeOnTerminate(Object obj) {
        try {
            if (this.appLikeOnTerminate == null) {
                this.appLikeOnTerminate = ShareReflectUtil.m9396b(this.applicationLike, "onTerminate", new Class[0]);
            }
            this.appLikeOnTerminate.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onTerminate of appLike.", th);
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.applicationLike != null) {
            invokeAppLikeOnTerminate(this.applicationLike);
        }
    }

    private void invokeAppLikeOnLowMemory(Object obj) {
        try {
            if (this.appLikeOnLowMemory == null) {
                this.appLikeOnLowMemory = ShareReflectUtil.m9396b(this.applicationLike, "onLowMemory", new Class[0]);
            }
            this.appLikeOnLowMemory.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onLowMemory of appLike.", th);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.applicationLike != null) {
            invokeAppLikeOnLowMemory(this.applicationLike);
        }
    }

    private void invokeAppLikeOnTrimMemory(Object obj, int i) {
        try {
            if (this.appLikeOnTrimMemory == null) {
                this.appLikeOnTrimMemory = ShareReflectUtil.m9396b(this.applicationLike, "onTrimMemory", Integer.TYPE);
            }
            this.appLikeOnTrimMemory.invoke(obj, new Object[]{Integer.valueOf(i)});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onTrimMemory of appLike.", th);
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.applicationLike != null) {
            invokeAppLikeOnTrimMemory(this.applicationLike, i);
        }
    }

    private void invokeAppLikeOnConfigurationChanged(Object obj, Configuration configuration) {
        try {
            if (this.appLikeOnConfigurationChanged == null) {
                this.appLikeOnConfigurationChanged = ShareReflectUtil.m9396b(this.applicationLike, "onConfigurationChanged", Configuration.class);
            }
            this.appLikeOnConfigurationChanged.invoke(obj, new Object[]{configuration});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke onConfigurationChanged of appLike.", th);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.applicationLike != null) {
            invokeAppLikeOnConfigurationChanged(this.applicationLike, configuration);
        }
    }

    private Resources invokeAppLikeGetResources(Object obj, Resources resources) {
        try {
            if (this.appLikeGetResources == null) {
                this.appLikeGetResources = ShareReflectUtil.m9396b(this.applicationLike, "getResources", Resources.class);
            }
            return (Resources) this.appLikeGetResources.invoke(obj, new Object[]{resources});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke getResources of appLike.", th);
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        if (this.applicationLike != null) {
            return invokeAppLikeGetResources(this.applicationLike, resources);
        }
        return resources;
    }

    private ClassLoader invokeAppLikeGetClassLoader(Object obj, ClassLoader classLoader) {
        try {
            if (this.appLikeGetClassLoader == null) {
                this.appLikeGetClassLoader = ShareReflectUtil.m9396b(this.applicationLike, "getClassLoader", ClassLoader.class);
            }
            return (ClassLoader) this.appLikeGetClassLoader.invoke(obj, new Object[]{classLoader});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke getClassLoader of appLike.", th);
        }
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader = super.getClassLoader();
        if (this.applicationLike != null) {
            return invokeAppLikeGetClassLoader(this.applicationLike, classLoader);
        }
        return classLoader;
    }

    private AssetManager invokeAppLikeGetAssets(Object obj, AssetManager assetManager) {
        try {
            if (this.appLikeGetAssets == null) {
                this.appLikeGetAssets = ShareReflectUtil.m9396b(this.applicationLike, "getAssets", AssetManager.class);
            }
            return (AssetManager) this.appLikeGetAssets.invoke(obj, new Object[]{assetManager});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke getAssets of appLike.", th);
        }
    }

    public AssetManager getAssets() {
        AssetManager assets = super.getAssets();
        if (this.applicationLike != null) {
            return invokeAppLikeGetAssets(this.applicationLike, assets);
        }
        return assets;
    }

    private Object invokeAppLikeGetSystemService(Object obj, String str, Object obj2) {
        try {
            if (this.appLikeGetSystemService == null) {
                this.appLikeGetSystemService = ShareReflectUtil.m9396b(this.applicationLike, "getSystemService", String.class, Object.class);
            }
            return this.appLikeGetSystemService.invoke(obj, new Object[]{str, obj2});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke getSystemService of appLike.", th);
        }
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (this.applicationLike != null) {
            return invokeAppLikeGetSystemService(this.applicationLike, str, systemService);
        }
        return systemService;
    }

    private Object invokeAppLikeGetBaseContext(Object obj, Context context) {
        try {
            if (this.appLikeGetBaseContext == null) {
                this.appLikeGetBaseContext = ShareReflectUtil.m9396b(this.applicationLike, "getBaseContext", Context.class);
            }
            return this.appLikeGetBaseContext.invoke(obj, new Object[]{context});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("fail to invoke getBaseContext of appLike.", th);
        }
    }

    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        if (this.applicationLike != null) {
            return (Context) invokeAppLikeGetBaseContext(this.applicationLike, baseContext);
        }
        return baseContext;
    }

    public void setUseSafeMode(boolean z) {
        this.useSafeMode = z;
    }

    public boolean isTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public int getTinkerFlags() {
        return this.tinkerFlags;
    }
}
