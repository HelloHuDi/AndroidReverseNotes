package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.C24532f;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public class XWalkCoreWrapper {
    private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
    public static final int INVOKE_NOTITY_FUNCTION_ID_FOR_TEST = 10001;
    public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
    public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
    public static final int INVOKE_RUNTIME_ID_CONTEXT_CHANGED = 80001;
    public static final int INVOKE_RUNTIME_ID_DELETE_ORIGIN = 80006;
    public static final int INVOKE_RUNTIME_ID_HAS_FEATURE = 80003;
    public static final int INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL = 80005;
    private static final String TAG = "XWalkLib";
    private static final String WRAPPER_PACKAGE = "org.xwalk.core";
    private static ClassLoader mStandAloneClassLoader;
    private static XWalkCoreWrapper sInstance;
    private static XWalkCoreWrapper sProvisionalInstance;
    private static HashMap<String, LinkedList<ReservedAction>> sReservedActions = new HashMap();
    private static LinkedList<String> sReservedActivities = new LinkedList();
    private int mApiVersion = 8;
    private int mApkVersion;
    private Context mBridgeContext;
    private ClassLoader mBridgeLoader;
    private int mCoreStatus;
    private int mMinApiVersion;
    private Context mWrapperContext;
    DexClassLoader sBridgeLoader;

    /* renamed from: org.xwalk.core.XWalkCoreWrapper$2 */
    class C246022 extends XWalkNotifyChannelListener {
        C246022() {
        }

        public void onNotifyCallBackChannel(int i, Object[] objArr) {
            AppMethodBeat.m2504i(85554);
            Log.m81049i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i + " para size = " + objArr.length);
            switch (i) {
                case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY /*50001*/:
                    C24532f.m38180n(Long.parseLong((String) objArr[0]), Long.parseLong((String) objArr[1]), (long) Integer.parseInt((String) objArr[2]));
                    AppMethodBeat.m2505o(85554);
                    return;
                case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT /*50002*/:
                    C24532f.m38172bX(Integer.parseInt((String) objArr[0]), (String) objArr[1]);
                    AppMethodBeat.m2505o(85554);
                    return;
                default:
                    try {
                        Log.m81049i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i + " do not match");
                        AppMethodBeat.m2505o(85554);
                        return;
                    } catch (RuntimeException e) {
                        Log.m81046e(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener error:" + e.getLocalizedMessage());
                        AppMethodBeat.m2505o(85554);
                    }
            }
            Log.m81046e(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener error:" + e.getLocalizedMessage());
            AppMethodBeat.m2505o(85554);
        }
    }

    static class ReservedAction {
        Object[] mArguments;
        Class<?> mClass;
        ReflectMethod mMethod;
        Object mObject;

        ReservedAction(Object obj) {
            this.mObject = obj;
        }

        ReservedAction(Class<?> cls) {
            this.mClass = cls;
        }

        ReservedAction(ReflectMethod reflectMethod) {
            AppMethodBeat.m2504i(85555);
            this.mMethod = reflectMethod;
            if (reflectMethod.getArguments() != null) {
                this.mArguments = Arrays.copyOf(reflectMethod.getArguments(), reflectMethod.getArguments().length);
            }
            AppMethodBeat.m2505o(85555);
        }
    }

    static {
        AppMethodBeat.m2504i(85591);
        AppMethodBeat.m2505o(85591);
    }

    public static XWalkCoreWrapper getInstance() {
        return sInstance;
    }

    public static int getCoreStatus() {
        if (sInstance != null) {
            return sInstance.mCoreStatus;
        }
        if (sProvisionalInstance == null) {
            return 0;
        }
        return sProvisionalInstance.mCoreStatus;
    }

    public static void handlePreInit(String str) {
        AppMethodBeat.m2504i(85556);
        if (sInstance != null) {
            AppMethodBeat.m2505o(85556);
            return;
        }
        Log.m81045d(TAG, "Pre init xwalk core in ".concat(String.valueOf(str)));
        if (sReservedActions.containsKey(str)) {
            sReservedActions.remove(str);
        } else {
            sReservedActivities.add(str);
        }
        sReservedActions.put(str, new LinkedList());
        AppMethodBeat.m2505o(85556);
    }

    public static void reserveReflectObject(Object obj) {
        AppMethodBeat.m2504i(85557);
        String str = (String) sReservedActivities.getLast();
        Log.m81045d(TAG, "Reserve object " + obj.getClass() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(obj));
        AppMethodBeat.m2505o(85557);
    }

    public static void reserveReflectClass(Class<?> cls) {
        AppMethodBeat.m2504i(85558);
        String str = (String) sReservedActivities.getLast();
        Log.m81045d(TAG, "Reserve class " + cls.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction((Class) cls));
        AppMethodBeat.m2505o(85558);
    }

    public static void reserveReflectMethod(ReflectMethod reflectMethod) {
        AppMethodBeat.m2504i(85559);
        String str = (String) sReservedActivities.getLast();
        Log.m81045d(TAG, "Reserve method " + reflectMethod.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(reflectMethod));
        AppMethodBeat.m2505o(85559);
    }

    public static void handlePostInit(String str) {
        AppMethodBeat.m2504i(85560);
        Log.m81045d(TAG, "Post init xwalk core in ".concat(String.valueOf(str)));
        if (sReservedActions.containsKey(str)) {
            LinkedList linkedList = (LinkedList) sReservedActions.get(str);
            while (linkedList.size() != 0) {
                ReservedAction reservedAction = (ReservedAction) linkedList.pop();
                if (reservedAction.mObject != null) {
                    Log.m81045d(TAG, "Init reserved object: " + reservedAction.mObject.getClass());
                    new ReflectMethod(reservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else if (reservedAction.mClass != null) {
                    Log.m81045d(TAG, "Init reserved class: " + reservedAction.mClass.toString());
                    new ReflectMethod(reservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else {
                    Log.m81045d(TAG, "Call reserved method: " + reservedAction.mMethod.toString());
                    Object[] objArr = reservedAction.mArguments;
                    if (objArr != null) {
                        for (int i = 0; i < objArr.length; i++) {
                            if (objArr[i] instanceof ReflectMethod) {
                                objArr[i] = ((ReflectMethod) objArr[i]).invokeWithArguments();
                            }
                        }
                    }
                    reservedAction.mMethod.invoke(objArr);
                }
            }
            sReservedActions.remove(str);
            sReservedActivities.remove(str);
            AppMethodBeat.m2505o(85560);
            return;
        }
        AppMethodBeat.m2505o(85560);
    }

    public static void handleRuntimeError(RuntimeException runtimeException) {
        AppMethodBeat.m2504i(85561);
        Log.m81046e(TAG, "This API is incompatible with the Crosswalk runtime library");
        AppMethodBeat.m2505o(85561);
    }

    public DexClassLoader getBridgeLoader() {
        AppMethodBeat.m2504i(85562);
        DexClassLoader dexClassLoader;
        if (this.sBridgeLoader != null) {
            dexClassLoader = this.sBridgeLoader;
            AppMethodBeat.m2505o(85562);
            return dexClassLoader;
        }
        String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
        String classDexFilePath = XWalkEnvironment.getClassDexFilePath(this.mApkVersion);
        if (new File(classDexFilePath).exists()) {
            this.sBridgeLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(this.mApkVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
            dexClassLoader = this.sBridgeLoader;
            AppMethodBeat.m2505o(85562);
            return dexClassLoader;
        }
        AppMethodBeat.m2505o(85562);
        return null;
    }

    public int getApkVersion() {
        AppMethodBeat.m2504i(85563);
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.m2505o(85563);
            return 0;
        }
        try {
            Class loadClass = bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion");
            if (loadClass == null) {
                AppMethodBeat.m2505o(85563);
                return 0;
            }
            int intValue;
            try {
                intValue = ((Integer) new ReflectField(loadClass, "XWALK_APK_VERSION").get()).intValue();
            } catch (RuntimeException e) {
                intValue = 0;
            }
            AppMethodBeat.m2505o(85563);
            return intValue;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.m2505o(85563);
            return 0;
        }
    }

    public boolean isDownLoadCoreAvailable() {
        AppMethodBeat.m2504i(85564);
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.m2505o(85564);
            return false;
        }
        try {
            if (bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion") == null) {
                AppMethodBeat.m2505o(85564);
                return false;
            }
            AppMethodBeat.m2505o(85564);
            return true;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(85564);
            return false;
        }
    }

    public static int attachXWalkCore(int i) {
        AppMethodBeat.m2504i(85565);
        Assert.assertFalse(sReservedActivities.isEmpty());
        Assert.assertNull(sInstance);
        Log.m81049i(TAG, "Attach xwalk core");
        if (i == -1) {
            Log.m81049i(TAG, "version = -1, no xwalk");
            AppMethodBeat.m2505o(85565);
            return 10;
        }
        sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, i);
        int i2;
        if (XWalkEnvironment.isDownloadMode()) {
            sProvisionalInstance.findDownloadedCore();
            i2 = sProvisionalInstance.mCoreStatus;
            AppMethodBeat.m2505o(85565);
            return i2;
        }
        i2 = sProvisionalInstance.mCoreStatus;
        AppMethodBeat.m2505o(85565);
        return i2;
    }

    public static void dockXWalkCore() {
        AppMethodBeat.m2504i(85566);
        Assert.assertNotNull(sProvisionalInstance);
        Assert.assertNull(sInstance);
        Log.m81045d(TAG, "Dock xwalk core");
        sInstance = sProvisionalInstance;
        sProvisionalInstance = null;
        AppMethodBeat.m2505o(85566);
    }

    public static void initEmbeddedMode() {
        AppMethodBeat.m2504i(85567);
        if (sInstance == null && sReservedActivities.isEmpty()) {
            RuntimeException runtimeException = new RuntimeException("royle:downloadmode should not goto this");
            AppMethodBeat.m2505o(85567);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(85567);
    }

    private XWalkCoreWrapper(Context context, int i, int i2) {
        AppMethodBeat.m2504i(85568);
        if (i <= 0 || i > this.mApiVersion) {
            i = this.mApiVersion;
        }
        this.mMinApiVersion = i;
        this.mCoreStatus = 0;
        this.mWrapperContext = context;
        this.mApkVersion = i2;
        AppMethodBeat.m2505o(85568);
    }

    private void initCoreBridge() {
        AppMethodBeat.m2504i(85569);
        Log.m81045d(TAG, "Init core bridge");
        new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", Context.class, Object.class).invoke(this.mBridgeContext, this);
        AppMethodBeat.m2505o(85569);
    }

    private void initXWalkView() {
        AppMethodBeat.m2504i(85570);
        Log.m81045d(TAG, "Init xwalk view");
        new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", Context.class, Context.class).invoke(this.mBridgeContext, this.mWrapperContext);
        AppMethodBeat.m2505o(85570);
    }

    private boolean findDownloadedCore() {
        AppMethodBeat.m2504i(85571);
        this.mBridgeLoader = getBridgeLoader();
        sProvisionalInstance.initCoreBridge();
        if (this.mBridgeLoader != null && checkCoreVersion() && checkCoreArchitecture() && checkCoreApk()) {
            if (initLog(sProvisionalInstance)) {
                Log.m81049i(TAG, "initLog success!");
            } else {
                Log.m81046e(TAG, "initLog failed !");
            }
            Log.m81045d(TAG, "Running in downloaded mode");
            this.mCoreStatus = 1;
            AppMethodBeat.m2505o(85571);
            return true;
        }
        Log.m81046e(TAG, "mBridgeLoader set to null , prev mBridgeLoader =  " + this.mBridgeLoader);
        this.mBridgeLoader = null;
        AppMethodBeat.m2505o(85571);
        return false;
    }

    public boolean checkCoreVersion() {
        AppMethodBeat.m2504i(85572);
        Log.m81049i(TAG, "[Environment] SDK:" + VERSION.SDK_INT);
        Log.m81049i(TAG, "[App Version] build:24.53.595.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
        Class bridgeClass = getBridgeClass("XWalkCoreVersion");
        String str = "";
        try {
            str = (String) new ReflectField(bridgeClass, "XWALK_BUILD_VERSION").get();
        } catch (RuntimeException e) {
        }
        try {
            int intValue = ((Integer) new ReflectField(bridgeClass, "API_VERSION").get()).intValue();
            int intValue2 = ((Integer) new ReflectField(bridgeClass, "MIN_API_VERSION").get()).intValue();
            Log.m81049i(TAG, "[Lib Version] build:" + str + ", api:" + intValue + ", min_api:" + intValue2);
            if (XWalkEnvironment.isDownloadMode() && XWalkEnvironment.isDownloadModeUpdate() && !str.isEmpty() && !str.equals(XWalkAppVersion.XWALK_BUILD_VERSION)) {
                this.mCoreStatus = 8;
                AppMethodBeat.m2505o(85572);
                return false;
            } else if (this.mMinApiVersion > intValue) {
                this.mCoreStatus = 3;
                AppMethodBeat.m2505o(85572);
                return false;
            } else if (this.mApiVersion < intValue2) {
                this.mCoreStatus = 4;
                AppMethodBeat.m2505o(85572);
                return false;
            } else {
                Log.m81049i(TAG, "XWalk core version matched");
                AppMethodBeat.m2505o(85572);
                return true;
            }
        } catch (RuntimeException e2) {
            Log.m81046e(TAG, "XWalk core not found");
            this.mCoreStatus = 2;
            AppMethodBeat.m2505o(85572);
            return false;
        }
    }

    private boolean initLog(XWalkCoreWrapper xWalkCoreWrapper) {
        AppMethodBeat.m2504i(85573);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.m81045d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.m2505o(85573);
            return false;
        }
        C312101 c312101 = new XWalkLogMessageListener(xWalkCoreWrapper) {
            public void onLogMessage(int i, String str, int i2, String str2) {
                AppMethodBeat.m2504i(85553);
                Log.m81049i(XWalkCoreWrapper.TAG, "[WCWebview] :".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(85553);
            }
        };
        try {
            Class bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = c312101.getBridge();
            new ReflectMethod(bridgeClass, "setLogCallBack", Object.class).invoke(bridge);
            AppMethodBeat.m2505o(85573);
            return true;
        } catch (RuntimeException e) {
            Log.m81045d(TAG, e.getLocalizedMessage());
            AppMethodBeat.m2505o(85573);
            return false;
        }
    }

    public boolean initNotifyChannnel() {
        AppMethodBeat.m2504i(85574);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.m81045d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.m2505o(85574);
            return false;
        }
        C246022 c246022 = new C246022();
        try {
            Class bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = c246022.getBridge();
            new ReflectMethod(bridgeClass, "setNotifyCallBackChannel", Object.class).invoke(bridge);
            AppMethodBeat.m2505o(85574);
            return true;
        } catch (RuntimeException e) {
            Log.m81045d(TAG, e.getLocalizedMessage());
            AppMethodBeat.m2505o(85574);
            return false;
        }
    }

    public static Object invokeRuntimeChannel(int i, Object[] objArr) {
        AppMethodBeat.m2504i(85575);
        Object invokeRuntimeChannel = invokeRuntimeChannel(null, i, objArr);
        AppMethodBeat.m2505o(85575);
        return invokeRuntimeChannel;
    }

    private static Object invokeRuntimeChannel(ClassLoader classLoader, int i, Object[] objArr) {
        Object obj = null;
        AppMethodBeat.m2504i(85576);
        if (XWalkEnvironment.getAvailableVersion() < 255) {
            Log.m81045d(TAG, "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
            AppMethodBeat.m2505o(85576);
        } else {
            try {
                obj = invokeReflectMethod(classLoader, "invokeRuntimeChannel", i, objArr);
                AppMethodBeat.m2505o(85576);
            } catch (RuntimeException e) {
                Log.m81046e(TAG, "invokeRuntimeChannel error:" + e.getLocalizedMessage());
                C24532f.dVx();
                AppMethodBeat.m2505o(85576);
                return obj;
            } catch (ClassCircularityError e2) {
                Log.m81046e(TAG, "invokeRuntimeChannel error:" + e2.getLocalizedMessage());
                C24532f.dVy();
                AppMethodBeat.m2505o(85576);
                return obj;
            } catch (Exception e3) {
                Log.m81046e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
                C24532f.dVz();
                AppMethodBeat.m2505o(85576);
                return obj;
            }
        }
        return obj;
    }

    public static boolean invokeNativeChannel(ClassLoader classLoader, int i, Object[] objArr) {
        AppMethodBeat.m2504i(85577);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.m81045d(TAG, "XWalk invokeNativeChannel runtime version not matched 153");
            AppMethodBeat.m2505o(85577);
            return false;
        }
        try {
            invokeReflectMethod(classLoader, "invokeNativeChannel", i, objArr);
        } catch (RuntimeException e) {
            Log.m81046e(TAG, "invokeNativeChannel error:" + e.getLocalizedMessage());
            C24532f.dVx();
            AppMethodBeat.m2505o(85577);
            return false;
        } catch (ClassCircularityError e2) {
            Log.m81046e(TAG, "invokeRuntimeChannel error:" + e2.getLocalizedMessage());
            C24532f.dVy();
        } catch (Exception e3) {
            Log.m81046e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
            C24532f.dVz();
        }
        AppMethodBeat.m2505o(85577);
        return true;
    }

    private static Object invokeReflectMethod(ClassLoader classLoader, String str, int i, Object[] objArr) {
        AppMethodBeat.m2504i(85578);
        Object invoke;
        if (classLoader == null) {
            invoke = new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), "invokeRuntimeChannel", Integer.TYPE, Object[].class).invoke(Integer.valueOf(i), objArr);
            AppMethodBeat.m2505o(85578);
            return invoke;
        }
        try {
            invoke = new ReflectMethod(classLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate"), str, Integer.TYPE, Object[].class).invoke(Integer.valueOf(i), objArr);
            AppMethodBeat.m2505o(85578);
            return invoke;
        } catch (ClassNotFoundException e) {
            Log.m81046e(TAG, "invokeRuntimeChannel with classloader error:" + e.getMessage());
            AppMethodBeat.m2505o(85578);
            return null;
        }
    }

    public boolean hasFeature(int i) {
        AppMethodBeat.m2504i(85579);
        Object invokeRuntimeChannel = invokeRuntimeChannel(INVOKE_RUNTIME_ID_HAS_FEATURE, new Object[]{Integer.valueOf(i)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.m2505o(85579);
            return booleanValue;
        }
        AppMethodBeat.m2505o(85579);
        return false;
    }

    private static ClassLoader getStandAloneClassLoader() {
        AppMethodBeat.m2504i(85580);
        ClassLoader classLoader;
        if (getInstance() != null && getInstance().sBridgeLoader != null) {
            DexClassLoader dexClassLoader = getInstance().sBridgeLoader;
            AppMethodBeat.m2505o(85580);
            return dexClassLoader;
        } else if (mStandAloneClassLoader != null) {
            classLoader = mStandAloneClassLoader;
            AppMethodBeat.m2505o(85580);
            return classLoader;
        } else {
            try {
                int availableVersion = XWalkEnvironment.getAvailableVersion();
                if (availableVersion == -1) {
                    Log.m81049i(TAG, "getXWalkClassLoader version = -1");
                    AppMethodBeat.m2505o(85580);
                    return null;
                }
                String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(availableVersion);
                String classDexFilePath = XWalkEnvironment.getClassDexFilePath(availableVersion);
                if (new File(classDexFilePath).exists()) {
                    mStandAloneClassLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(availableVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
                    classLoader = mStandAloneClassLoader;
                    AppMethodBeat.m2505o(85580);
                    return classLoader;
                }
                AppMethodBeat.m2505o(85580);
                return null;
            } catch (Exception e) {
                Log.m81046e(TAG, "getXWalkClassLoader error:" + e.getMessage());
                AppMethodBeat.m2505o(85580);
                return null;
            }
        }
    }

    public static boolean hasFeatureStatic(int i) {
        AppMethodBeat.m2504i(85581);
        Object invokeRuntimeChannel = invokeRuntimeChannel(getStandAloneClassLoader(), INVOKE_RUNTIME_ID_HAS_FEATURE, new Object[]{Integer.valueOf(i)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.m2505o(85581);
            return booleanValue;
        }
        AppMethodBeat.m2505o(85581);
        return false;
    }

    private boolean checkCoreArchitecture() {
        AppMethodBeat.m2504i(85582);
        try {
            boolean booleanValue;
            ReflectMethod reflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", Context.class, String.class);
            String str = null;
            if (this.mBridgeContext != null) {
                if (VERSION.SDK_INT < 17) {
                    str = "/data/data/" + this.mBridgeContext.getPackageName() + "/lib";
                }
                booleanValue = ((Boolean) reflectMethod.invoke(this.mBridgeContext, str)).booleanValue();
            } else if (this.mWrapperContext != null) {
                str = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
                booleanValue = ((Boolean) reflectMethod.invoke(this.mWrapperContext, str)).booleanValue();
            } else {
                booleanValue = false;
            }
            if (booleanValue) {
                Log.m81049i(TAG, "XWalk core architecture matched");
                AppMethodBeat.m2505o(85582);
                return true;
            }
            Log.m81046e(TAG, "Mismatch of CPU architecture");
            this.mCoreStatus = 6;
            AppMethodBeat.m2505o(85582);
            return false;
        } catch (RuntimeException e) {
            Log.m81046e(TAG, e.getLocalizedMessage());
            if (e.getCause() instanceof UnsatisfiedLinkError) {
                this.mCoreStatus = 6;
                AppMethodBeat.m2505o(85582);
                return false;
            }
            this.mCoreStatus = 5;
            AppMethodBeat.m2505o(85582);
            return false;
        }
    }

    private boolean checkCorePackage(String str) {
        AppMethodBeat.m2504i(85583);
        try {
            this.mBridgeContext = this.mWrapperContext.createPackageContext(str, 3);
            Log.m81045d(TAG, "Created package context for ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(85583);
            return true;
        } catch (NameNotFoundException e) {
            Log.m81045d(TAG, str + " not found");
            AppMethodBeat.m2505o(85583);
            return false;
        }
    }

    private boolean checkCoreApk() {
        AppMethodBeat.m2504i(85584);
        if (new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists()) {
            Log.m81049i(TAG, "XWalk checkCoreApk matched");
            AppMethodBeat.m2505o(85584);
            return true;
        }
        Log.m81046e(TAG, "checkCoreApk apk not exists");
        this.mCoreStatus = 9;
        AppMethodBeat.m2505o(85584);
        return false;
    }

    private boolean verifyPackageInfo(PackageInfo packageInfo, String str, String str2) {
        AppMethodBeat.m2504i(85585);
        if (packageInfo.signatures == null) {
            Log.m81046e(TAG, "No signature in package info");
            AppMethodBeat.m2505o(85585);
            return false;
        }
        IllegalArgumentException illegalArgumentException;
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] hexStringToByteArray = hexStringToByteArray(str2);
            if (hexStringToByteArray == null) {
                illegalArgumentException = new IllegalArgumentException("Invalid hash code");
                AppMethodBeat.m2505o(85585);
                throw illegalArgumentException;
            }
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                Log.m81045d(TAG, "Checking signature ".concat(String.valueOf(i)));
                if (MessageDigest.isEqual(instance.digest(packageInfo.signatures[i].toByteArray()), hexStringToByteArray)) {
                    Log.m81045d(TAG, "Signature passed verification");
                    AppMethodBeat.m2505o(85585);
                    return true;
                }
                Log.m81046e(TAG, "Hash code does not match");
            }
            AppMethodBeat.m2505o(85585);
            return false;
        } catch (NullPointerException | NoSuchAlgorithmException e) {
            illegalArgumentException = new IllegalArgumentException("Invalid hash algorithm");
            AppMethodBeat.m2505o(85585);
            throw illegalArgumentException;
        }
    }

    private byte[] hexStringToByteArray(String str) {
        AppMethodBeat.m2504i(85586);
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            AppMethodBeat.m2505o(85586);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        AppMethodBeat.m2505o(85586);
        return bArr;
    }

    public boolean isSharedMode() {
        return this.mBridgeContext != null;
    }

    public Object getBridgeObject(Object obj) {
        AppMethodBeat.m2504i(85587);
        try {
            Object invoke = new ReflectMethod(obj, "getBridge", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.m2505o(85587);
            return invoke;
        } catch (RuntimeException e) {
            AppMethodBeat.m2505o(85587);
            return null;
        }
    }

    public Object getWrapperObject(Object obj) {
        AppMethodBeat.m2504i(85588);
        try {
            Object invoke = new ReflectMethod(obj, "getWrapper", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.m2505o(85588);
            return invoke;
        } catch (RuntimeException e) {
            AppMethodBeat.m2505o(85588);
            return null;
        }
    }

    public Class<?> getBridgeClass(String str) {
        AppMethodBeat.m2504i(85589);
        try {
            Class loadClass = this.mBridgeLoader.loadClass("org.xwalk.core.internal.".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(85589);
            return loadClass;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(85589);
            return null;
        }
    }

    public Class<?> getClass(String str) {
        AppMethodBeat.m2504i(85590);
        try {
            Class loadClass = this.mBridgeLoader.loadClass(str);
            AppMethodBeat.m2505o(85590);
            return loadClass;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(85590);
            return null;
        }
    }
}
