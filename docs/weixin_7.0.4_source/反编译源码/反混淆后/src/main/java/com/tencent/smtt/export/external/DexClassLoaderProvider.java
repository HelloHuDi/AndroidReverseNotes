package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance = null;
    private static String mRealDexPath = null;
    protected static Service mService = null;
    private SpeedyDexClassLoader mClassLoader = null;

    static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
            AppMethodBeat.m2504i(63727);
            Package definePackage = super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
            AppMethodBeat.m2505o(63727);
            return definePackage;
        }

        public Class<?> findClass(String str) {
            AppMethodBeat.m2504i(63723);
            Class findClass = super.findClass(str);
            AppMethodBeat.m2505o(63723);
            return findClass;
        }

        public URL findResource(String str) {
            AppMethodBeat.m2504i(63724);
            URL findResource = super.findResource(str);
            AppMethodBeat.m2505o(63724);
            return findResource;
        }

        public Enumeration<URL> findResources(String str) {
            AppMethodBeat.m2504i(63725);
            Enumeration findResources = super.findResources(str);
            AppMethodBeat.m2505o(63725);
            return findResources;
        }

        public synchronized Package getPackage(String str) {
            Package packageR;
            AppMethodBeat.m2504i(63726);
            packageR = super.getPackage(str);
            AppMethodBeat.m2505o(63726);
            return packageR;
        }

        public Package[] getPackages() {
            AppMethodBeat.m2504i(63728);
            Package[] packages = super.getPackages();
            AppMethodBeat.m2505o(63728);
            return packages;
        }

        public Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.m2504i(63729);
            Class loadClass = super.loadClass(str, z);
            AppMethodBeat.m2505o(63729);
            return loadClass;
        }
    }

    private DexClassLoaderProvider(String str, String str2, String str3, ClassLoader classLoader, boolean z) {
        super(str, str2, str3, classLoader);
        AppMethodBeat.m2504i(63730);
        if (z) {
            new StringBuilder("SpeedyDexClassLoader: ").append(mRealDexPath);
            this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
            AppMethodBeat.m2505o(63730);
            return;
        }
        new StringBuilder("DexClassLoader: ").append(mRealDexPath);
        this.mClassLoader = null;
        AppMethodBeat.m2505o(63730);
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        AppMethodBeat.m2504i(63731);
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int lastIndexOf = str.lastIndexOf("/");
        String str4 = str.substring(0, lastIndexOf + 1) + "fake_dex.jar";
        String substring = str.substring(lastIndexOf + 1);
        if (supportSpeedyClassLoader() && is_first_load_tbs_dex(str2, substring)) {
            set_first_load_tbs_dex(str2, substring);
            mInstance = new DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(substring, str, str2, str3, classLoader);
        } else {
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        DexClassLoaderProvider dexClassLoaderProvider = mInstance;
        AppMethodBeat.m2505o(63731);
        return dexClassLoaderProvider;
    }

    private static void doAsyncDexLoad(final String str, final String str2, final String str3, final String str4, ClassLoader classLoader) {
        AppMethodBeat.m2504i(63732);
        if (shouldUseDexLoaderService()) {
            new Timer().schedule(new TimerTask() {
                public final void run() {
                    AppMethodBeat.m2504i(63721);
                    try {
                        ArrayList arrayList = new ArrayList(4);
                        arrayList.add(0, str);
                        arrayList.add(1, str2);
                        arrayList.add(2, str3);
                        arrayList.add(3, str4);
                        Intent intent = new Intent(DexClassLoaderProvider.mContext, DexClassLoaderProviderService.class);
                        intent.putStringArrayListExtra("dex2oat", arrayList);
                        DexClassLoaderProvider.mContext.startService(intent);
                        AppMethodBeat.m2505o(63721);
                    } catch (SecurityException e) {
                        AppMethodBeat.m2505o(63721);
                    } catch (Throwable th) {
                        new StringBuilder("after shouldUseDexLoaderService exception: ").append(th);
                        AppMethodBeat.m2505o(63721);
                    }
                }
            }, LOAD_DEX_DELAY);
            AppMethodBeat.m2505o(63732);
            return;
        }
        final String str5 = str2;
        final String str6 = str3;
        final String str7 = str4;
        final ClassLoader classLoader2 = classLoader;
        final String str8 = str;
        new Timer().schedule(new TimerTask() {
            public final void run() {
                boolean z = true;
                AppMethodBeat.m2504i(63722);
                try {
                    File file = new File(str5.replace(".jar", ".dex"));
                    if (!file.exists() || file.length() == 0) {
                        z = false;
                    }
                    File file2 = new File(str6);
                    File file3 = new File(str5);
                    boolean exists = file2.exists();
                    boolean isDirectory = file2.isDirectory();
                    boolean exists2 = file3.exists();
                    if (exists && isDirectory && exists2) {
                        long currentTimeMillis = System.currentTimeMillis();
                        DexClassLoader dexClassLoader = new DexClassLoader(str5, str6, str7, classLoader2);
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(z)});
                        if (DexClassLoaderProvider.mForceLoadDexFlag && DexClassLoaderProvider.LAST_DEX_NAME.equals(str8) && DexClassLoaderProvider.mService != null) {
                            DexClassLoaderProvider.mService.stopSelf();
                        }
                        AppMethodBeat.m2505o(63722);
                        return;
                    }
                    new StringBuilder("dex loading exception(").append(exists).append(", ").append(isDirectory).append(", ").append(exists2).append(")");
                    AppMethodBeat.m2505o(63722);
                } catch (Throwable th) {
                    new StringBuilder("@AsyncDexLoad task exception: ").append(th);
                    AppMethodBeat.m2505o(63722);
                }
            }
        }, LOAD_DEX_DELAY);
        AppMethodBeat.m2505o(63732);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        AppMethodBeat.m2504i(63733);
        if (mForceLoadDexFlag) {
            AppMethodBeat.m2505o(63733);
            return true;
        } else if (new File(str, str2 + "_is_first_load_dex_flag_file").exists()) {
            AppMethodBeat.m2505o(63733);
            return false;
        } else {
            AppMethodBeat.m2505o(63733);
            return true;
        }
    }

    static void setForceLoadDexFlag(boolean z, Service service) {
        mForceLoadDexFlag = z;
        mService = service;
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        AppMethodBeat.m2504i(63734);
        File file = new File(str, str2 + "_is_first_load_dex_flag_file");
        if (!file.exists()) {
            try {
                file.createNewFile();
                AppMethodBeat.m2505o(63734);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(63734);
    }

    private static boolean shouldUseDexLoaderService() {
        return !mForceLoadDexFlag && DexLoader.mCanUseDexLoaderProviderService;
    }

    private static boolean supportSpeedyClassLoader() {
        return VERSION.SDK_INT != 21 || DexLoader.mCanUseDexLoaderProviderService;
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    public void clearAssertionStatus() {
        AppMethodBeat.m2504i(63741);
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
            AppMethodBeat.m2505o(63741);
            return;
        }
        this.mClassLoader.clearAssertionStatus();
        AppMethodBeat.m2505o(63741);
    }

    /* Access modifiers changed, original: protected */
    public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
        AppMethodBeat.m2504i(63742);
        Package definePackage;
        if (useSelfClassloader()) {
            definePackage = super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
            AppMethodBeat.m2505o(63742);
            return definePackage;
        }
        definePackage = this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        AppMethodBeat.m2505o(63742);
        return definePackage;
    }

    /* Access modifiers changed, original: protected */
    public Class<?> findClass(String str) {
        AppMethodBeat.m2504i(63735);
        Class findClass;
        if (useSelfClassloader()) {
            findClass = super.findClass(str);
            AppMethodBeat.m2505o(63735);
            return findClass;
        }
        findClass = this.mClassLoader.findClass(str);
        AppMethodBeat.m2505o(63735);
        return findClass;
    }

    public String findLibrary(String str) {
        AppMethodBeat.m2504i(63736);
        String findLibrary;
        if (useSelfClassloader()) {
            findLibrary = super.findLibrary(str);
            AppMethodBeat.m2505o(63736);
            return findLibrary;
        }
        findLibrary = this.mClassLoader.findLibrary(str);
        AppMethodBeat.m2505o(63736);
        return findLibrary;
    }

    /* Access modifiers changed, original: protected */
    public URL findResource(String str) {
        AppMethodBeat.m2504i(63737);
        URL findResource;
        if (useSelfClassloader()) {
            findResource = super.findResource(str);
            AppMethodBeat.m2505o(63737);
            return findResource;
        }
        findResource = this.mClassLoader.findResource(str);
        AppMethodBeat.m2505o(63737);
        return findResource;
    }

    /* Access modifiers changed, original: protected */
    public Enumeration<URL> findResources(String str) {
        AppMethodBeat.m2504i(63738);
        Enumeration findResources;
        if (useSelfClassloader()) {
            findResources = super.findResources(str);
            AppMethodBeat.m2505o(63738);
            return findResources;
        }
        findResources = this.mClassLoader.findResources(str);
        AppMethodBeat.m2505o(63738);
        return findResources;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized Package getPackage(String str) {
        Package packageR;
        AppMethodBeat.m2504i(63739);
        if (useSelfClassloader()) {
            packageR = super.getPackage(str);
            AppMethodBeat.m2505o(63739);
        } else {
            packageR = this.mClassLoader.getPackage(str);
            AppMethodBeat.m2505o(63739);
        }
        return packageR;
    }

    /* Access modifiers changed, original: protected */
    public Package[] getPackages() {
        AppMethodBeat.m2504i(63743);
        Package[] packages;
        if (useSelfClassloader()) {
            packages = super.getPackages();
            AppMethodBeat.m2505o(63743);
            return packages;
        }
        packages = this.mClassLoader.getPackages();
        AppMethodBeat.m2505o(63743);
        return packages;
    }

    public URL getResource(String str) {
        AppMethodBeat.m2504i(63744);
        URL resource;
        if (useSelfClassloader()) {
            resource = super.getResource(str);
            AppMethodBeat.m2505o(63744);
            return resource;
        }
        resource = this.mClassLoader.getResource(str);
        AppMethodBeat.m2505o(63744);
        return resource;
    }

    public InputStream getResourceAsStream(String str) {
        AppMethodBeat.m2504i(63745);
        InputStream resourceAsStream;
        if (useSelfClassloader()) {
            resourceAsStream = getResourceAsStream(str);
            AppMethodBeat.m2505o(63745);
            return resourceAsStream;
        }
        resourceAsStream = this.mClassLoader.getResourceAsStream(str);
        AppMethodBeat.m2505o(63745);
        return resourceAsStream;
    }

    public Enumeration<URL> getResources(String str) {
        AppMethodBeat.m2504i(63746);
        Enumeration resources;
        if (useSelfClassloader()) {
            resources = super.getResources(str);
            AppMethodBeat.m2505o(63746);
            return resources;
        }
        resources = this.mClassLoader.getResources(str);
        AppMethodBeat.m2505o(63746);
        return resources;
    }

    public Class<?> loadClass(String str) {
        AppMethodBeat.m2504i(63748);
        Class loadClass;
        if (useSelfClassloader()) {
            loadClass = super.loadClass(str);
            AppMethodBeat.m2505o(63748);
            return loadClass;
        }
        loadClass = this.mClassLoader.loadClass(str);
        AppMethodBeat.m2505o(63748);
        return loadClass;
    }

    /* Access modifiers changed, original: protected */
    public Class<?> loadClass(String str, boolean z) {
        AppMethodBeat.m2504i(63747);
        Class loadClass;
        if (useSelfClassloader()) {
            loadClass = super.loadClass(str, z);
            AppMethodBeat.m2505o(63747);
            return loadClass;
        }
        loadClass = this.mClassLoader.loadClass(str, z);
        AppMethodBeat.m2505o(63747);
        return loadClass;
    }

    public void setClassAssertionStatus(String str, boolean z) {
        AppMethodBeat.m2504i(63749);
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z);
            AppMethodBeat.m2505o(63749);
            return;
        }
        this.mClassLoader.setClassAssertionStatus(str, z);
        AppMethodBeat.m2505o(63749);
    }

    public void setDefaultAssertionStatus(boolean z) {
        AppMethodBeat.m2504i(63750);
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z);
            AppMethodBeat.m2505o(63750);
            return;
        }
        this.mClassLoader.setDefaultAssertionStatus(z);
        AppMethodBeat.m2505o(63750);
    }

    public void setPackageAssertionStatus(String str, boolean z) {
        AppMethodBeat.m2504i(63751);
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z);
            AppMethodBeat.m2505o(63751);
            return;
        }
        this.mClassLoader.setPackageAssertionStatus(str, z);
        AppMethodBeat.m2505o(63751);
    }

    public String toString() {
        AppMethodBeat.m2504i(63740);
        String dexClassLoader;
        if (useSelfClassloader()) {
            dexClassLoader = super.toString();
            AppMethodBeat.m2505o(63740);
            return dexClassLoader;
        }
        dexClassLoader = this.mClassLoader.toString();
        AppMethodBeat.m2505o(63740);
        return dexClassLoader;
    }
}
