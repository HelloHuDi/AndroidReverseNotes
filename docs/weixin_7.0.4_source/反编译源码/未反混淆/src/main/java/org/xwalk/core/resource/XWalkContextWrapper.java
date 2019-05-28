package org.xwalk.core.resource;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

public class XWalkContextWrapper extends ContextWrapper {
    private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
    private static final String TAG = "XWalkLib";
    private static String mPackageName = null;
    private static HashMap<Long, Integer> mResourcessKeyIdMap;
    public int apkVersion = 0;
    public String extractedCoreDir;
    private ApplicationInfo mApplicationInfo;
    private ClassLoader mClassLoader;
    private Context mContext;
    private boolean mHasAddFilterResources = false;
    private final LayoutInflater mLayoutInflater;
    private Resources mResources;
    private Theme mTheme;
    public boolean usingCustomContext = false;

    static final class XWalkLayoutInflaterFactory implements Factory {
        LayoutInflater layoutInflater;

        private XWalkLayoutInflaterFactory() {
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            AppMethodBeat.i(86209);
            View view = null;
            try {
                view = inflateView(str, context, attributeSet);
                if ((view instanceof ViewStub) && VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.layoutInflater);
                }
            } catch (ClassNotFoundException e) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[]{str}));
            } catch (InflateException e2) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[]{str}));
            }
            AppMethodBeat.o(86209);
            return view;
        }

        public final View inflateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            AppMethodBeat.i(86210);
            if (str.indexOf(".") == -1) {
                if (str.equals("WebView")) {
                    view = createView(str, "android.webkit.", attributeSet);
                }
                if (view == null) {
                    view = createView(str, "android.widget.", attributeSet);
                }
                if (view == null) {
                    view = createView(str, "android.view.", attributeSet);
                }
            } else {
                view = this.layoutInflater.createView(str, null, attributeSet);
            }
            AppMethodBeat.o(86210);
            return view;
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            AppMethodBeat.i(86211);
            View view = null;
            try {
                view = this.layoutInflater.createView(str, str2, attributeSet);
            } catch (InflateException | ClassNotFoundException e) {
            }
            AppMethodBeat.o(86211);
            return view;
        }
    }

    public XWalkContextWrapper(Context context, int i) {
        super(context);
        AppMethodBeat.i(86212);
        this.apkVersion = i;
        String downloadApkPath = XWalkEnvironment.getDownloadApkPath(i);
        this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(i);
        this.mContext = context;
        this.mLayoutInflater = ((LayoutInflater) context.getSystemService("layout_inflater")).cloneInContext(this);
        XWalkLayoutInflaterFactory xWalkLayoutInflaterFactory = new XWalkLayoutInflaterFactory();
        xWalkLayoutInflaterFactory.layoutInflater = this.mLayoutInflater;
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("mFactorySet");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this.mLayoutInflater, false);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e.getMessage());
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e2.getMessage());
        }
        this.mLayoutInflater.setFactory(xWalkLayoutInflaterFactory);
        this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
        if (this.usingCustomContext) {
            this.mResources = new XWalkResource(getResources(context, downloadApkPath), context);
        } else {
            this.mResources = getResources(context, downloadApkPath);
        }
        if (!(this.mResources == null || this.mApplicationInfo == null)) {
            this.mTheme = this.mResources.newTheme();
            if (getPackageInfo(context, downloadApkPath) != null) {
                Theme theme = context.getTheme();
                if (theme != null) {
                    this.mTheme.setTo(theme);
                }
                this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
            }
        }
        AppMethodBeat.o(86212);
    }

    private Resources getResources(Context context, String str) {
        AppMethodBeat.i(86213);
        if (checkResApkExist(str)) {
            Resources resourcesForApplication;
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo != null) {
                mPackageName = packageArchiveInfo.packageName;
                this.mApplicationInfo = packageArchiveInfo.applicationInfo;
                if (this.mApplicationInfo != null) {
                    this.mApplicationInfo.sourceDir = str;
                    this.mApplicationInfo.publicSourceDir = str;
                    try {
                        resourcesForApplication = context.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
                        if (resourcesForApplication != null) {
                            AppMethodBeat.o(86213);
                            return resourcesForApplication;
                        }
                    } catch (Throwable th) {
                    }
                    Log.i(TAG, "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
                }
            }
            resourcesForApplication = getResourcesWithReflect(context, str);
            AppMethodBeat.o(86213);
            return resourcesForApplication;
        }
        Log.i(TAG, "XWalkContextWrapper checkResApkExist false");
        AppMethodBeat.o(86213);
        return null;
    }

    private Resources getResourcesWithReflect(Context context, String str) {
        AppMethodBeat.i(86214);
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            Resources resources = super.getResources();
            Resources resources2 = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            AppMethodBeat.o(86214);
            return resources2;
        } catch (Exception e) {
            Log.e(TAG, "XWalkContextWrapper getResourcesWithReflect error:" + e.getMessage());
            AppMethodBeat.o(86214);
            return null;
        }
    }

    private boolean checkResApkExist(String str) {
        AppMethodBeat.i(86215);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(86215);
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            AppMethodBeat.o(86215);
            return true;
        }
        AppMethodBeat.o(86215);
        return false;
    }

    private PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.i(86216);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        AppMethodBeat.o(86216);
        return packageArchiveInfo;
    }

    public HashMap<Long, Integer> getResourcesKeyIdMap(Resources resources) {
        AppMethodBeat.i(86217);
        if (mResourcessKeyIdMap != null) {
            HashMap hashMap = (HashMap) mResourcessKeyIdMap.clone();
            AppMethodBeat.o(86217);
            return hashMap;
        }
        Log.i(TAG, "getResourcesKeyIdMap start");
        HashMap hashMap2 = new HashMap();
        try {
            for (Class cls : getClassLoader().loadClass(GENERATED_RESOURCE_CLASS).getClasses()) {
                if (cls.getSimpleName().equals("drawable")) {
                    for (Field field : cls.getFields()) {
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        int i = 0;
                        try {
                            TypedValue typedValue = new TypedValue();
                            i = field.getInt(null);
                            resources.getValue(i, typedValue, true);
                            long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
                            hashMap2.put(Long.valueOf(j), Integer.valueOf(i));
                            Log.d(TAG, "name:" + field.getName() + ",id:" + i + ",key:" + j);
                        } catch (IllegalAccessException e) {
                            Log.w(TAG, field.getName() + " is not accessable.");
                        } catch (IllegalArgumentException e2) {
                            Log.w(TAG, field.getName() + " is not int.");
                        } catch (NotFoundException e3) {
                            Log.w(TAG, field.getName() + " is not found." + Integer.toHexString(i));
                        }
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(false);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e4) {
            Log.e(TAG, "org.xwalk.core.Ris not found.");
        } catch (Exception e5) {
            Log.e(TAG, e5.getMessage());
        }
        mResourcessKeyIdMap = hashMap2;
        Log.i(TAG, "getResourcesKeyIdMap end, size:" + mResourcessKeyIdMap.keySet().size());
        HashMap<Long, Integer> hashMap3 = (HashMap) mResourcessKeyIdMap.clone();
        AppMethodBeat.o(86217);
        return hashMap3;
    }

    private Intent getRealIntent(Intent intent) {
        AppMethodBeat.i(86218);
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        AppMethodBeat.o(86218);
        return intent;
    }

    public Context getApplicationContext() {
        AppMethodBeat.i(86219);
        Context applicationContext = this.mContext.getApplicationContext();
        AppMethodBeat.o(86219);
        return applicationContext;
    }

    public AssetManager getAssets() {
        AppMethodBeat.i(86220);
        Resources resources = getResources();
        AssetManager assets;
        if (resources != null) {
            assets = resources.getAssets();
            AppMethodBeat.o(86220);
            return assets;
        }
        assets = super.getAssets();
        AppMethodBeat.o(86220);
        return assets;
    }

    public Context getBaseContext() {
        return this.mContext;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mLayoutInflater;
    }

    public String getPackageName() {
        AppMethodBeat.i(86221);
        String packageName = this.mContext.getPackageName();
        AppMethodBeat.o(86221);
        return packageName;
    }

    public Context getPlatformContext() {
        return this.mContext;
    }

    public Resources getResources() {
        AppMethodBeat.i(86222);
        if (!this.mHasAddFilterResources) {
            if (WebViewExtension.addFilterResources(this.mResources, getResourcesKeyIdMap(this.mResources))) {
                this.mHasAddFilterResources = true;
            } else {
                Log.e(TAG, "mHasAddFilterResources = false");
            }
        }
        Resources resources = this.mResources;
        if (resources != null) {
            AppMethodBeat.o(86222);
            return resources;
        }
        resources = super.getResources();
        AppMethodBeat.o(86222);
        return resources;
    }

    public Object getSystemService(String str) {
        AppMethodBeat.i(86223);
        if (str.equals("layout_inflater")) {
            LayoutInflater layoutInflater = getLayoutInflater();
            AppMethodBeat.o(86223);
            return layoutInflater;
        }
        Object systemService = this.mContext.getSystemService(str);
        AppMethodBeat.o(86223);
        return systemService;
    }

    public Theme getTheme() {
        AppMethodBeat.i(86224);
        Theme theme;
        if (this.mTheme != null) {
            theme = this.mTheme;
            AppMethodBeat.o(86224);
            return theme;
        }
        theme = super.getTheme();
        AppMethodBeat.o(86224);
        return theme;
    }

    public void setTheme(int i) {
        AppMethodBeat.i(86225);
        if (this.mContext.getTheme() != null) {
            this.mContext.getTheme().applyStyle(i, true);
            AppMethodBeat.o(86225);
            return;
        }
        super.setTheme(i);
        AppMethodBeat.o(86225);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(86226);
        super.startActivity(getRealIntent(intent));
        AppMethodBeat.o(86226);
    }

    public ComponentName startService(Intent intent) {
        AppMethodBeat.i(86227);
        ComponentName startService = super.startService(getRealIntent(intent));
        AppMethodBeat.o(86227);
        return startService;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        AppMethodBeat.i(86228);
        ClassLoader classLoader;
        if (this.mClassLoader != null) {
            classLoader = this.mClassLoader;
            AppMethodBeat.o(86228);
            return classLoader;
        }
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        if (instance != null) {
            classLoader = instance.getBridgeLoader();
            AppMethodBeat.o(86228);
            return classLoader;
        }
        classLoader = super.getClassLoader();
        AppMethodBeat.o(86228);
        return classLoader;
    }
}
