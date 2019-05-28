package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
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
            AppMethodBeat.i(85555);
            this.mMethod = reflectMethod;
            if (reflectMethod.getArguments() != null) {
                this.mArguments = Arrays.copyOf(reflectMethod.getArguments(), reflectMethod.getArguments().length);
            }
            AppMethodBeat.o(85555);
        }
    }

    static {
        AppMethodBeat.i(85591);
        AppMethodBeat.o(85591);
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
        AppMethodBeat.i(85556);
        if (sInstance != null) {
            AppMethodBeat.o(85556);
            return;
        }
        Log.d(TAG, "Pre init xwalk core in ".concat(String.valueOf(str)));
        if (sReservedActions.containsKey(str)) {
            sReservedActions.remove(str);
        } else {
            sReservedActivities.add(str);
        }
        sReservedActions.put(str, new LinkedList());
        AppMethodBeat.o(85556);
    }

    public static void reserveReflectObject(Object obj) {
        AppMethodBeat.i(85557);
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve object " + obj.getClass() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(obj));
        AppMethodBeat.o(85557);
    }

    public static void reserveReflectClass(Class<?> cls) {
        AppMethodBeat.i(85558);
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve class " + cls.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction((Class) cls));
        AppMethodBeat.o(85558);
    }

    public static void reserveReflectMethod(ReflectMethod reflectMethod) {
        AppMethodBeat.i(85559);
        String str = (String) sReservedActivities.getLast();
        Log.d(TAG, "Reserve method " + reflectMethod.toString() + " to " + str);
        ((LinkedList) sReservedActions.get(str)).add(new ReservedAction(reflectMethod));
        AppMethodBeat.o(85559);
    }

    public static void handlePostInit(String str) {
        AppMethodBeat.i(85560);
        Log.d(TAG, "Post init xwalk core in ".concat(String.valueOf(str)));
        if (sReservedActions.containsKey(str)) {
            LinkedList linkedList = (LinkedList) sReservedActions.get(str);
            while (linkedList.size() != 0) {
                ReservedAction reservedAction = (ReservedAction) linkedList.pop();
                if (reservedAction.mObject != null) {
                    Log.d(TAG, "Init reserved object: " + reservedAction.mObject.getClass());
                    new ReflectMethod(reservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else if (reservedAction.mClass != null) {
                    Log.d(TAG, "Init reserved class: " + reservedAction.mClass.toString());
                    new ReflectMethod(reservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
                } else {
                    Log.d(TAG, "Call reserved method: " + reservedAction.mMethod.toString());
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
            AppMethodBeat.o(85560);
            return;
        }
        AppMethodBeat.o(85560);
    }

    public static void handleRuntimeError(RuntimeException runtimeException) {
        AppMethodBeat.i(85561);
        Log.e(TAG, "This API is incompatible with the Crosswalk runtime library");
        AppMethodBeat.o(85561);
    }

    public DexClassLoader getBridgeLoader() {
        AppMethodBeat.i(85562);
        DexClassLoader dexClassLoader;
        if (this.sBridgeLoader != null) {
            dexClassLoader = this.sBridgeLoader;
            AppMethodBeat.o(85562);
            return dexClassLoader;
        }
        String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
        String classDexFilePath = XWalkEnvironment.getClassDexFilePath(this.mApkVersion);
        if (new File(classDexFilePath).exists()) {
            this.sBridgeLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(this.mApkVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
            dexClassLoader = this.sBridgeLoader;
            AppMethodBeat.o(85562);
            return dexClassLoader;
        }
        AppMethodBeat.o(85562);
        return null;
    }

    public int getApkVersion() {
        AppMethodBeat.i(85563);
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.o(85563);
            return 0;
        }
        try {
            Class loadClass = bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion");
            if (loadClass == null) {
                AppMethodBeat.o(85563);
                return 0;
            }
            int intValue;
            try {
                intValue = ((Integer) new ReflectField(loadClass, "XWALK_APK_VERSION").get()).intValue();
            } catch (RuntimeException e) {
                intValue = 0;
            }
            AppMethodBeat.o(85563);
            return intValue;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(85563);
            return 0;
        }
    }

    public boolean isDownLoadCoreAvailable() {
        AppMethodBeat.i(85564);
        DexClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.o(85564);
            return false;
        }
        try {
            if (bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion") == null) {
                AppMethodBeat.o(85564);
                return false;
            }
            AppMethodBeat.o(85564);
            return true;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(85564);
            return false;
        }
    }

    public static int attachXWalkCore(int i) {
        AppMethodBeat.i(85565);
        Assert.assertFalse(sReservedActivities.isEmpty());
        Assert.assertNull(sInstance);
        Log.i(TAG, "Attach xwalk core");
        if (i == -1) {
            Log.i(TAG, "version = -1, no xwalk");
            AppMethodBeat.o(85565);
            return 10;
        }
        sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, i);
        int i2;
        if (XWalkEnvironment.isDownloadMode()) {
            sProvisionalInstance.findDownloadedCore();
            i2 = sProvisionalInstance.mCoreStatus;
            AppMethodBeat.o(85565);
            return i2;
        }
        i2 = sProvisionalInstance.mCoreStatus;
        AppMethodBeat.o(85565);
        return i2;
    }

    public static void dockXWalkCore() {
        AppMethodBeat.i(85566);
        Assert.assertNotNull(sProvisionalInstance);
        Assert.assertNull(sInstance);
        Log.d(TAG, "Dock xwalk core");
        sInstance = sProvisionalInstance;
        sProvisionalInstance = null;
        AppMethodBeat.o(85566);
    }

    public static void initEmbeddedMode() {
        AppMethodBeat.i(85567);
        if (sInstance == null && sReservedActivities.isEmpty()) {
            RuntimeException runtimeException = new RuntimeException("royle:downloadmode should not goto this");
            AppMethodBeat.o(85567);
            throw runtimeException;
        }
        AppMethodBeat.o(85567);
    }

    private XWalkCoreWrapper(Context context, int i, int i2) {
        AppMethodBeat.i(85568);
        if (i <= 0 || i > this.mApiVersion) {
            i = this.mApiVersion;
        }
        this.mMinApiVersion = i;
        this.mCoreStatus = 0;
        this.mWrapperContext = context;
        this.mApkVersion = i2;
        AppMethodBeat.o(85568);
    }

    private void initCoreBridge() {
        AppMethodBeat.i(85569);
        Log.d(TAG, "Init core bridge");
        new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", Context.class, Object.class).invoke(this.mBridgeContext, this);
        AppMethodBeat.o(85569);
    }

    private void initXWalkView() {
        AppMethodBeat.i(85570);
        Log.d(TAG, "Init xwalk view");
        new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", Context.class, Context.class).invoke(this.mBridgeContext, this.mWrapperContext);
        AppMethodBeat.o(85570);
    }

    private boolean findDownloadedCore() {
        AppMethodBeat.i(85571);
        this.mBridgeLoader = getBridgeLoader();
        sProvisionalInstance.initCoreBridge();
        if (this.mBridgeLoader != null && checkCoreVersion() && checkCoreArchitecture() && checkCoreApk()) {
            if (initLog(sProvisionalInstance)) {
                Log.i(TAG, "initLog success!");
            } else {
                Log.e(TAG, "initLog failed !");
            }
            Log.d(TAG, "Running in downloaded mode");
            this.mCoreStatus = 1;
            AppMethodBeat.o(85571);
            return true;
        }
        Log.e(TAG, "mBridgeLoader set to null , prev mBridgeLoader =  " + this.mBridgeLoader);
        this.mBridgeLoader = null;
        AppMethodBeat.o(85571);
        return false;
    }

    public boolean checkCoreVersion() {
        AppMethodBeat.i(85572);
        Log.i(TAG, "[Environment] SDK:" + VERSION.SDK_INT);
        Log.i(TAG, "[App Version] build:24.53.595.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
        Class bridgeClass = getBridgeClass("XWalkCoreVersion");
        String str = "";
        try {
            str = (String) new ReflectField(bridgeClass, "XWALK_BUILD_VERSION").get();
        } catch (RuntimeException e) {
        }
        try {
            int intValue = ((Integer) new ReflectField(bridgeClass, "API_VERSION").get()).intValue();
            int intValue2 = ((Integer) new ReflectField(bridgeClass, "MIN_API_VERSION").get()).intValue();
            Log.i(TAG, "[Lib Version] build:" + str + ", api:" + intValue + ", min_api:" + intValue2);
            if (XWalkEnvironment.isDownloadMode() && XWalkEnvironment.isDownloadModeUpdate() && !str.isEmpty() && !str.equals(XWalkAppVersion.XWALK_BUILD_VERSION)) {
                this.mCoreStatus = 8;
                AppMethodBeat.o(85572);
                return false;
            } else if (this.mMinApiVersion > intValue) {
                this.mCoreStatus = 3;
                AppMethodBeat.o(85572);
                return false;
            } else if (this.mApiVersion < intValue2) {
                this.mCoreStatus = 4;
                AppMethodBeat.o(85572);
                return false;
            } else {
                Log.i(TAG, "XWalk core version matched");
                AppMethodBeat.o(85572);
                return true;
            }
        } catch (RuntimeException e2) {
            Log.e(TAG, "XWalk core not found");
            this.mCoreStatus = 2;
            AppMethodBeat.o(85572);
            return false;
        }
    }

    private boolean initLog(XWalkCoreWrapper xWalkCoreWrapper) {
        AppMethodBeat.i(85573);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.o(85573);
            return false;
        }
        AnonymousClass1 anonymousClass1 = new XWalkLogMessageListener(xWalkCoreWrapper) {
            public void onLogMessage(int i, String str, int i2, String str2) {
                AppMethodBeat.i(85553);
                Log.i(XWalkCoreWrapper.TAG, "[WCWebview] :".concat(String.valueOf(str2)));
                AppMethodBeat.o(85553);
            }
        };
        try {
            Class bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = anonymousClass1.getBridge();
            new ReflectMethod(bridgeClass, "setLogCallBack", Object.class).invoke(bridge);
            AppMethodBeat.o(85573);
            return true;
        } catch (RuntimeException e) {
            Log.d(TAG, e.getLocalizedMessage());
            AppMethodBeat.o(85573);
            return false;
        }
    }

    public boolean initNotifyChannnel() {
        AppMethodBeat.i(85574);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.o(85574);
            return false;
        }
        AnonymousClass2 anonymousClass2 = new XWalkNotifyChannelListener() {
            public void onNotifyCallBackChannel(int i, Object[] objArr) {
                AppMethodBeat.i(85554);
                Log.i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i + " para size = " + objArr.length);
                switch (i) {
                    case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY /*50001*/:
                        f.n(Long.parseLong((String) objArr[0]), Long.parseLong((String) objArr[1]), (long) Integer.parseInt((String) objArr[2]));
                        AppMethodBeat.o(85554);
                        return;
                    case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT /*50002*/:
                        f.bX(Integer.parseInt((String) objArr[0]), (String) objArr[1]);
                        AppMethodBeat.o(85554);
                        return;
                    default:
                        try {
                            Log.i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i + " do not match");
                            AppMethodBeat.o(85554);
                            return;
                        } catch (RuntimeException e) {
                            Log.e(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener error:" + e.getLocalizedMessage());
                            AppMethodBeat.o(85554);
                        }
                }
                Log.e(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener error:" + e.getLocalizedMessage());
                AppMethodBeat.o(85554);
            }
        };
        try {
            Class bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = anonymousClass2.getBridge();
            new ReflectMethod(bridgeClass, "setNotifyCallBackChannel", Object.class).invoke(bridge);
            AppMethodBeat.o(85574);
            return true;
        } catch (RuntimeException e) {
            Log.d(TAG, e.getLocalizedMessage());
            AppMethodBeat.o(85574);
            return false;
        }
    }

    public static Object invokeRuntimeChannel(int i, Object[] objArr) {
        AppMethodBeat.i(85575);
        Object invokeRuntimeChannel = invokeRuntimeChannel(null, i, objArr);
        AppMethodBeat.o(85575);
        return invokeRuntimeChannel;
    }

    private static Object invokeRuntimeChannel(ClassLoader classLoader, int i, Object[] objArr) {
        Object obj = null;
        AppMethodBeat.i(85576);
        if (XWalkEnvironment.getAvailableVersion() < 255) {
            Log.d(TAG, "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
            AppMethodBeat.o(85576);
        } else {
            try {
                obj = invokeReflectMethod(classLoader, "invokeRuntimeChannel", i, objArr);
                AppMethodBeat.o(85576);
            } catch (RuntimeException e) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e.getLocalizedMessage());
                f.dVx();
                AppMethodBeat.o(85576);
                return obj;
            } catch (ClassCircularityError e2) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e2.getLocalizedMessage());
                f.dVy();
                AppMethodBeat.o(85576);
                return obj;
            } catch (Exception e3) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
                f.dVz();
                AppMethodBeat.o(85576);
                return obj;
            }
        }
        return obj;
    }

    public static boolean invokeNativeChannel(ClassLoader classLoader, int i, Object[] objArr) {
        AppMethodBeat.i(85577);
        if (XWalkEnvironment.getAvailableVersion() < XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION) {
            Log.d(TAG, "XWalk invokeNativeChannel runtime version not matched 153");
            AppMethodBeat.o(85577);
            return false;
        }
        try {
            invokeReflectMethod(classLoader, "invokeNativeChannel", i, objArr);
        } catch (RuntimeException e) {
            Log.e(TAG, "invokeNativeChannel error:" + e.getLocalizedMessage());
            f.dVx();
            AppMethodBeat.o(85577);
            return false;
        } catch (ClassCircularityError e2) {
            Log.e(TAG, "invokeRuntimeChannel error:" + e2.getLocalizedMessage());
            f.dVy();
        } catch (Exception e3) {
            Log.e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
            f.dVz();
        }
        AppMethodBeat.o(85577);
        return true;
    }

    private static Object invokeReflectMethod(ClassLoader classLoader, String str, int i, Object[] objArr) {
        AppMethodBeat.i(85578);
        Object invoke;
        if (classLoader == null) {
            invoke = new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), "invokeRuntimeChannel", Integer.TYPE, Object[].class).invoke(Integer.valueOf(i), objArr);
            AppMethodBeat.o(85578);
            return invoke;
        }
        try {
            invoke = new ReflectMethod(classLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate"), str, Integer.TYPE, Object[].class).invoke(Integer.valueOf(i), objArr);
            AppMethodBeat.o(85578);
            return invoke;
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "invokeRuntimeChannel with classloader error:" + e.getMessage());
            AppMethodBeat.o(85578);
            return null;
        }
    }

    public boolean hasFeature(int i) {
        AppMethodBeat.i(85579);
        Object invokeRuntimeChannel = invokeRuntimeChannel(INVOKE_RUNTIME_ID_HAS_FEATURE, new Object[]{Integer.valueOf(i)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.o(85579);
            return booleanValue;
        }
        AppMethodBeat.o(85579);
        return false;
    }

    private static ClassLoader getStandAloneClassLoader() {
        AppMethodBeat.i(85580);
        ClassLoader classLoader;
        if (getInstance() != null && getInstance().sBridgeLoader != null) {
            DexClassLoader dexClassLoader = getInstance().sBridgeLoader;
            AppMethodBeat.o(85580);
            return dexClassLoader;
        } else if (mStandAloneClassLoader != null) {
            classLoader = mStandAloneClassLoader;
            AppMethodBeat.o(85580);
            return classLoader;
        } else {
            try {
                int availableVersion = XWalkEnvironment.getAvailableVersion();
                if (availableVersion == -1) {
                    Log.i(TAG, "getXWalkClassLoader version = -1");
                    AppMethodBeat.o(85580);
                    return null;
                }
                String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(availableVersion);
                String classDexFilePath = XWalkEnvironment.getClassDexFilePath(availableVersion);
                if (new File(classDexFilePath).exists()) {
                    mStandAloneClassLoader = new DexClassLoader(classDexFilePath, XWalkEnvironment.getOptimizedDexDir(availableVersion), extractedCoreDir, ClassLoader.getSystemClassLoader());
                    classLoader = mStandAloneClassLoader;
                    AppMethodBeat.o(85580);
                    return classLoader;
                }
                AppMethodBeat.o(85580);
                return null;
            } catch (Exception e) {
                Log.e(TAG, "getXWalkClassLoader error:" + e.getMessage());
                AppMethodBeat.o(85580);
                return null;
            }
        }
    }

    public static boolean hasFeatureStatic(int i) {
        AppMethodBeat.i(85581);
        Object invokeRuntimeChannel = invokeRuntimeChannel(getStandAloneClassLoader(), INVOKE_RUNTIME_ID_HAS_FEATURE, new Object[]{Integer.valueOf(i)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.o(85581);
            return booleanValue;
        }
        AppMethodBeat.o(85581);
        return false;
    }

    private boolean checkCoreArchitecture() {
        AppMethodBeat.i(85582);
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
                Log.i(TAG, "XWalk core architecture matched");
                AppMethodBeat.o(85582);
                return true;
            }
            Log.e(TAG, "Mismatch of CPU architecture");
            this.mCoreStatus = 6;
            AppMethodBeat.o(85582);
            return false;
        } catch (RuntimeException e) {
            Log.e(TAG, e.getLocalizedMessage());
            if (e.getCause() instanceof UnsatisfiedLinkError) {
                this.mCoreStatus = 6;
                AppMethodBeat.o(85582);
                return false;
            }
            this.mCoreStatus = 5;
            AppMethodBeat.o(85582);
            return false;
        }
    }

    private boolean checkCorePackage(String str) {
        AppMethodBeat.i(85583);
        try {
            this.mBridgeContext = this.mWrapperContext.createPackageContext(str, 3);
            Log.d(TAG, "Created package context for ".concat(String.valueOf(str)));
            AppMethodBeat.o(85583);
            return true;
        } catch (NameNotFoundException e) {
            Log.d(TAG, str + " not found");
            AppMethodBeat.o(85583);
            return false;
        }
    }

    private boolean checkCoreApk() {
        AppMethodBeat.i(85584);
        if (new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists()) {
            Log.i(TAG, "XWalk checkCoreApk matched");
            AppMethodBeat.o(85584);
            return true;
        }
        Log.e(TAG, "checkCoreApk apk not exists");
        this.mCoreStatus = 9;
        AppMethodBeat.o(85584);
        return false;
    }

    private boolean verifyPackageInfo(PackageInfo packageInfo, String str, String str2) {
        AppMethodBeat.i(85585);
        if (packageInfo.signatures == null) {
            Log.e(TAG, "No signature in package info");
            AppMethodBeat.o(85585);
            return false;
        }
        IllegalArgumentException illegalArgumentException;
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] hexStringToByteArray = hexStringToByteArray(str2);
            if (hexStringToByteArray == null) {
                illegalArgumentException = new IllegalArgumentException("Invalid hash code");
                AppMethodBeat.o(85585);
                throw illegalArgumentException;
            }
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                Log.d(TAG, "Checking signature ".concat(String.valueOf(i)));
                if (MessageDigest.isEqual(instance.digest(packageInfo.signatures[i].toByteArray()), hexStringToByteArray)) {
                    Log.d(TAG, "Signature passed verification");
                    AppMethodBeat.o(85585);
                    return true;
                }
                Log.e(TAG, "Hash code does not match");
            }
            AppMethodBeat.o(85585);
            return false;
        } catch (NullPointerException | NoSuchAlgorithmException e) {
            illegalArgumentException = new IllegalArgumentException("Invalid hash algorithm");
            AppMethodBeat.o(85585);
            throw illegalArgumentException;
        }
    }

    private byte[] hexStringToByteArray(String str) {
        AppMethodBeat.i(85586);
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            AppMethodBeat.o(85586);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        AppMethodBeat.o(85586);
        return bArr;
    }

    public boolean isSharedMode() {
        return this.mBridgeContext != null;
    }

    public Object getBridgeObject(Object obj) {
        AppMethodBeat.i(85587);
        try {
            Object invoke = new ReflectMethod(obj, "getBridge", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.o(85587);
            return invoke;
        } catch (RuntimeException e) {
            AppMethodBeat.o(85587);
            return null;
        }
    }

    public Object getWrapperObject(Object obj) {
        AppMethodBeat.i(85588);
        try {
            Object invoke = new ReflectMethod(obj, "getWrapper", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.o(85588);
            return invoke;
        } catch (RuntimeException e) {
            AppMethodBeat.o(85588);
            return null;
        }
    }

    public Class<?> getBridgeClass(String str) {
        AppMethodBeat.i(85589);
        try {
            Class loadClass = this.mBridgeLoader.loadClass("org.xwalk.core.internal.".concat(String.valueOf(str)));
            AppMethodBeat.o(85589);
            return loadClass;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(85589);
            return null;
        }
    }

    public Class<?> getClass(String str) {
        AppMethodBeat.i(85590);
        try {
            Class loadClass = this.mBridgeLoader.loadClass(str);
            AppMethodBeat.o(85590);
            return loadClass;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(85590);
            return null;
        }
    }
}
