package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class V8 extends V8Object {
    public static final int MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
    public static final int MEMORY_PRESSURE_LEVEL_MODERATE = 1;
    public static final int MEMORY_PRESSURE_LEVEL_NONE = 0;
    private static boolean initialized = false;
    private static Object invalid = new Object();
    private static Object lock = new Object();
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError = null;
    private static Exception nativeLoadException = null;
    private static volatile int runtimeCounter = 0;
    private static ILoadLibraryDelegate sLoadLibraryDelegate = new ILoadLibraryDelegate() {
        public final void loadLibrary(String str) {
            AppMethodBeat.i(75160);
            LibraryLoader.loadLibrary(str);
            AppMethodBeat.o(75160);
        }
    };
    private static V8Value undefined = new Undefined();
    private static String v8Flags = null;
    private Map<String, Object> data;
    private V8Map<V8Executor> executors;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    private final V8Locker locker;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;

    class MethodDescriptor {
        JavaCallback callback;
        boolean includeReceiver;
        Method method;
        Object object;
        JavaVoidCallback voidCallback;

        private MethodDescriptor() {
        }

        /* synthetic */ MethodDescriptor(V8 v8, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private native void _acquireLock(long j);

    private native void _add(long j, long j2, String str, double d);

    private native void _add(long j, long j2, String str, int i);

    private native void _add(long j, long j2, String str, String str2);

    private native void _add(long j, long j2, String str, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str);

    private native void _addObject(long j, long j2, String str, long j3);

    private native void _addUndefined(long j, long j2, String str);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native int _arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j, long j2, int i, int i2);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native int _arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr);

    private native byte[] _arrayGetBytes(long j, long j2, int i, int i2);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr);

    private native double[] _arrayGetDoubles(long j, long j2, int i, int i2);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr);

    private native int[] _arrayGetIntegers(long j, long j2, int i, int i2);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native int _arrayGetStrings(long j, long j2, int i, int i2, String[] strArr);

    private native String[] _arrayGetStrings(long j, long j2, int i, int i2);

    private native void _closeUVLoop(long j);

    private native boolean _contains(long j, long j2, String str);

    private native long _createContext(long j, int i);

    private native long _createIsolate(String str, boolean z);

    private native void _createTwin(long j, long j2, long j3);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private static native void _debugMessageLoop(long j);

    private native boolean _equals(long j, long j2, long j3);

    private native boolean _executeBooleanFunction(long j, long j2, String str, long j3);

    private native boolean _executeBooleanScript(long j, String str, String str2, int i, String str3, String str4);

    private static native String _executeDebugScript(long j, String str, String str2);

    private native double _executeDoubleFunction(long j, long j2, String str, long j3);

    private native double _executeDoubleScript(long j, String str, String str2, int i, String str3, String str4);

    private native Object _executeFunction(long j, int i, long j2, String str, long j3);

    private native Object _executeFunction(long j, long j2, long j3, long j4);

    private native int _executeIntegerFunction(long j, long j2, String str, long j3);

    private native int _executeIntegerScript(long j, String str, String str2, int i, String str3, String str4);

    private native Object _executeScript(long j, int i, String str, String str2, int i2, String str3, String str4);

    private native String _executeStringFunction(long j, long j2, String str, long j3);

    private native String _executeStringScript(long j, String str, String str2, int i, String str3, String str4);

    private native void _executeVoidFunction(long j, long j2, String str, long j3);

    private native void _executeVoidScript(long j, String str, String str2, int i, String str3, String str4);

    private native Object _get(long j, int i, long j2, String str);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    private native long _getBuildID();

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native int _getInteger(long j, long j2, String str);

    private native long _getIsolatePtr(long j);

    private native String[] _getKeys(long j, long j2);

    private native String _getString(long j, long j2, String str);

    private native int _getType(long j, long j2);

    private native int _getType(long j, long j2, int i);

    private native int _getType(long j, long j2, int i, int i2);

    private native int _getType(long j, long j2, String str);

    private static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private native long _initNewSharedV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Float32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Float64Array(long j, long j2, int i, int i2);

    private native long[] _initNewV8Function(long j);

    private native long _initNewV8Int16Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int32Array(long j, long j2, int i, int i2);

    private native long _initNewV8Int8Array(long j, long j2, int i, int i2);

    private native long _initNewV8Object(long j);

    private native long _initNewV8UInt16Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt32Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8Array(long j, long j2, int i, int i2);

    private native long _initNewV8UInt8ClampedArray(long j, long j2, int i, int i2);

    private static native boolean _isRunning(long j);

    private native boolean _isWeak(long j, long j2);

    private native void _lowMemoryNotification(long j);

    private native void _memoryPressureNotification(long j, int i);

    private static native boolean _pumpMessageLoop(long j);

    private native long _registerJavaMethod(long j, long j2, String str, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseContext(long j, long j2);

    private native void _releaseLock(long j);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j);

    private native boolean _sameValue(long j, long j2, long j3);

    private static native void _setCodeCacheDir(String str);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j, long j2, long j3);

    private static native void _setSnapshotBlob(byte[] bArr);

    private native void _setWeak(long j, long j2);

    private static native void _startNodeJS(long j, String str);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native void _switchContext(long j, long j2);

    private native void _terminateExecution(long j);

    private native String _toString(long j, long j2);

    private static native void _waitForDebuger(long j, String str);

    private native void _wakeUpUVLoop(long j);

    static {
        AppMethodBeat.i(75343);
        AppMethodBeat.o(75343);
    }

    private static synchronized void load(String str) {
        synchronized (V8.class) {
            AppMethodBeat.i(75161);
            try {
                sLoadLibraryDelegate.loadLibrary(str);
                nativeLibraryLoaded = true;
                AppMethodBeat.o(75161);
            } catch (Error e) {
                nativeLoadError = e;
                AppMethodBeat.o(75161);
            } catch (Exception e2) {
                nativeLoadException = e2;
                AppMethodBeat.o(75161);
            }
        }
        return;
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static void setFlags(String str) {
        v8Flags = str;
        initialized = false;
    }

    public static V8 createV8Runtime() {
        AppMethodBeat.i(75162);
        V8 createV8Runtime = createV8Runtime(null, null);
        AppMethodBeat.o(75162);
        return createV8Runtime;
    }

    public static V8 createV8Runtime(String str) {
        AppMethodBeat.i(75163);
        V8 createV8Runtime = createV8Runtime(str, null);
        AppMethodBeat.o(75163);
        return createV8Runtime;
    }

    public static V8 createV8Runtime(String str, String str2) {
        AppMethodBeat.i(75164);
        V8 createV8Runtime = createV8Runtime(str, str2, true, null, null);
        AppMethodBeat.o(75164);
        return createV8Runtime;
    }

    protected static V8 createV8Runtime(String str, String str2, boolean z) {
        AppMethodBeat.i(75165);
        V8 createV8Runtime = createV8Runtime(str, str2, z, null, null);
        AppMethodBeat.o(75165);
        return createV8Runtime;
    }

    protected static V8 createV8Runtime(String str, String str2, boolean z, String str3, byte[] bArr) {
        AppMethodBeat.i(75166);
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                try {
                    if (!nativeLibraryLoaded) {
                        load(str2);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(75166);
                    }
                }
            }
        }
        checkNativeLibraryLoaded();
        if (!initialized) {
            _setFlags(v8Flags);
            synchronized (lock) {
                if (str3 != null) {
                    try {
                        _setCodeCacheDir(str3);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(75166);
                        }
                    }
                }
                if (bArr != null) {
                    _setSnapshotBlob(bArr);
                }
            }
            initialized = true;
        }
        V8 v8 = new V8(str, z);
        synchronized (lock) {
            try {
                runtimeCounter++;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(75166);
            }
        }
        return v8;
    }

    /* Access modifiers changed, original: protected */
    public long createV8Context(int i) {
        AppMethodBeat.i(75167);
        long _createContext = _createContext(this.v8RuntimePtr, i);
        AppMethodBeat.o(75167);
        return _createContext;
    }

    /* Access modifiers changed, original: protected */
    public void switchV8Context(long j) {
        AppMethodBeat.i(75168);
        _switchContext(this.v8RuntimePtr, j);
        AppMethodBeat.o(75168);
    }

    /* Access modifiers changed, original: protected */
    public void wakeUpUVLoop() {
        AppMethodBeat.i(75169);
        _wakeUpUVLoop(this.v8RuntimePtr);
        AppMethodBeat.o(75169);
    }

    /* Access modifiers changed, original: protected */
    public void closeUVLoop() {
        AppMethodBeat.i(75170);
        _closeUVLoop(this.v8RuntimePtr);
        AppMethodBeat.o(75170);
    }

    /* Access modifiers changed, original: protected */
    public void releaseV8Context(long j) {
        AppMethodBeat.i(75171);
        _releaseContext(this.v8RuntimePtr, j);
        AppMethodBeat.o(75171);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        AppMethodBeat.i(75172);
        this.referenceHandlers.add(0, referenceHandler);
        AppMethodBeat.o(75172);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        AppMethodBeat.i(75173);
        this.releaseHandlers.add(v8Runnable);
        AppMethodBeat.o(75173);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        AppMethodBeat.i(75174);
        this.referenceHandlers.remove(referenceHandler);
        AppMethodBeat.o(75174);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        AppMethodBeat.i(75175);
        this.releaseHandlers.remove(v8Runnable);
        AppMethodBeat.o(75175);
    }

    public synchronized void setData(String str, Object obj) {
        AppMethodBeat.i(75176);
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
        AppMethodBeat.o(75176);
    }

    public Object getData(String str) {
        AppMethodBeat.i(75177);
        if (this.data == null) {
            AppMethodBeat.o(75177);
            return null;
        }
        Object obj = this.data.get(str);
        AppMethodBeat.o(75177);
        return obj;
    }

    private void notifyReleaseHandlers(V8 v8) {
        AppMethodBeat.i(75178);
        Iterator it = this.releaseHandlers.iterator();
        while (it.hasNext()) {
            ((V8Runnable) it.next()).run(v8);
        }
        AppMethodBeat.o(75178);
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        AppMethodBeat.i(75179);
        Iterator it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            ((ReferenceHandler) it.next()).v8HandleCreated(v8Value);
        }
        AppMethodBeat.o(75179);
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        AppMethodBeat.i(75180);
        Iterator it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            ((ReferenceHandler) it.next()).v8HandleDisposed(v8Value);
        }
        AppMethodBeat.o(75180);
    }

    private static void checkNativeLibraryLoaded() {
        AppMethodBeat.i(75181);
        IllegalStateException illegalStateException;
        if (nativeLibraryLoaded) {
            AppMethodBeat.o(75181);
        } else if (nativeLoadError != null) {
            illegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
            AppMethodBeat.o(75181);
            throw illegalStateException;
        } else if (nativeLoadException != null) {
            illegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
            AppMethodBeat.o(75181);
            throw illegalStateException;
        } else {
            illegalStateException = new IllegalStateException("J2V8 native library not loaded");
            AppMethodBeat.o(75181);
            throw illegalStateException;
        }
    }

    protected V8() {
        this(null, true);
    }

    protected V8(String str, boolean z) {
        super(null);
        AppMethodBeat.i(75182);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.objectReferences = 0;
        this.v8RuntimePtr = 0;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList();
        this.releaseHandlers = new LinkedList();
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str, z);
        this.locker = new V8Locker(this);
        checkThread();
        if (z) {
            this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
        }
        AppMethodBeat.o(75182);
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    public long getObjectReferenceCount() {
        AppMethodBeat.i(75183);
        long size = this.objectReferences - ((long) this.v8WeakReferences.size());
        AppMethodBeat.o(75183);
        return size;
    }

    /* Access modifiers changed, original: protected */
    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public static String getV8Version() {
        AppMethodBeat.i(75184);
        String _getVersion = _getVersion();
        AppMethodBeat.o(75184);
        return _getVersion;
    }

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    public void release() {
        AppMethodBeat.i(75185);
        release(true);
        AppMethodBeat.o(75185);
    }

    public void terminateExecution() {
        AppMethodBeat.i(75186);
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
        AppMethodBeat.o(75186);
    }

    public void release(boolean z) {
        AppMethodBeat.i(75187);
        if (isReleased()) {
            AppMethodBeat.o(75187);
            return;
        }
        checkThread();
        IllegalStateException illegalStateException;
        try {
            notifyReleaseHandlers(this);
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            if (this.executors != null) {
                this.executors.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                try {
                    runtimeCounter--;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(75187);
                        throw th;
                    }
                }
            }
            _releaseRuntime(this.v8RuntimePtr);
            this.v8RuntimePtr = 0;
            this.released = true;
            if (!z || getObjectReferenceCount() <= 0) {
                AppMethodBeat.o(75187);
                return;
            }
            illegalStateException = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
            AppMethodBeat.o(75187);
            throw illegalStateException;
        } catch (Throwable th2) {
            while (true) {
                AppMethodBeat.o(75187);
                throw th2;
            }
        }
    }

    private void releaseNativeMethodDescriptors() {
        AppMethodBeat.i(75188);
        for (Long longValue : this.functionRegistry.keySet()) {
            releaseMethodDescriptor(this.v8RuntimePtr, longValue.longValue());
        }
        AppMethodBeat.o(75188);
    }

    private void releaseResources() {
        AppMethodBeat.i(75189);
        if (this.resources != null) {
            for (Releasable release : this.resources) {
                release.release();
            }
            this.resources.clear();
            this.resources = null;
        }
        AppMethodBeat.o(75189);
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        AppMethodBeat.i(75190);
        checkThread();
        if (this.executors == null) {
            this.executors = new V8Map();
        }
        this.executors.put((V8Value) v8Object, (Object) v8Executor);
        AppMethodBeat.o(75190);
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        AppMethodBeat.i(75191);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(75191);
            return null;
        }
        V8Executor v8Executor = (V8Executor) this.executors.remove(v8Object);
        AppMethodBeat.o(75191);
        return v8Executor;
    }

    public V8Executor getExecutor(V8Object v8Object) {
        AppMethodBeat.i(75192);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(75192);
            return null;
        }
        V8Executor v8Executor = (V8Executor) this.executors.get(v8Object);
        AppMethodBeat.o(75192);
        return v8Executor;
    }

    public void shutdownExecutors(boolean z) {
        AppMethodBeat.i(75193);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(75193);
            return;
        }
        for (V8Executor v8Executor : this.executors.values()) {
            if (z) {
                v8Executor.forceTermination();
            } else {
                v8Executor.shutdown();
            }
        }
        AppMethodBeat.o(75193);
    }

    public void registerResource(Releasable releasable) {
        AppMethodBeat.i(75194);
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
        AppMethodBeat.o(75194);
    }

    public int executeIntegerScript(String str) {
        AppMethodBeat.i(75195);
        int executeIntegerScript = executeIntegerScript(str, null, 0, null, null);
        AppMethodBeat.o(75195);
        return executeIntegerScript;
    }

    public int executeIntegerScript(String str, String str2, int i) {
        AppMethodBeat.i(75196);
        int executeIntegerScript = executeIntegerScript(str, str2, i, null, null);
        AppMethodBeat.o(75196);
        return executeIntegerScript;
    }

    public int executeIntegerScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75197);
        checkThread();
        checkScript(str);
        int executeIntegerScript = executeIntegerScript(this.v8RuntimePtr, str, str2, i, str3, str4);
        AppMethodBeat.o(75197);
        return executeIntegerScript;
    }

    /* Access modifiers changed, original: protected */
    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        AppMethodBeat.i(75198);
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
        AppMethodBeat.o(75198);
    }

    public double executeDoubleScript(String str) {
        AppMethodBeat.i(75199);
        double executeDoubleScript = executeDoubleScript(str, null, 0, null, null);
        AppMethodBeat.o(75199);
        return executeDoubleScript;
    }

    public double executeDoubleScript(String str, String str2, int i) {
        AppMethodBeat.i(75200);
        double executeDoubleScript = executeDoubleScript(str, str2, i, null, null);
        AppMethodBeat.o(75200);
        return executeDoubleScript;
    }

    public double executeDoubleScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75201);
        checkThread();
        checkScript(str);
        double executeDoubleScript = executeDoubleScript(this.v8RuntimePtr, str, str2, i, str3, str4);
        AppMethodBeat.o(75201);
        return executeDoubleScript;
    }

    public String executeStringScript(String str) {
        AppMethodBeat.i(75202);
        String executeStringScript = executeStringScript(str, null, 0, null, null);
        AppMethodBeat.o(75202);
        return executeStringScript;
    }

    public String executeStringScript(String str, String str2, int i) {
        AppMethodBeat.i(75203);
        String executeStringScript = executeStringScript(str, str2, i, null, null);
        AppMethodBeat.o(75203);
        return executeStringScript;
    }

    public String executeStringScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75204);
        checkThread();
        checkScript(str);
        String executeStringScript = executeStringScript(this.v8RuntimePtr, str, str2, i, str3, str4);
        AppMethodBeat.o(75204);
        return executeStringScript;
    }

    public boolean executeBooleanScript(String str) {
        AppMethodBeat.i(75205);
        boolean executeBooleanScript = executeBooleanScript(str, null, 0, null, null);
        AppMethodBeat.o(75205);
        return executeBooleanScript;
    }

    public boolean executeBooleanScript(String str, String str2, int i) {
        AppMethodBeat.i(75206);
        boolean executeBooleanScript = executeBooleanScript(str, str2, i, null, null);
        AppMethodBeat.o(75206);
        return executeBooleanScript;
    }

    public boolean executeBooleanScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75207);
        checkThread();
        checkScript(str);
        boolean executeBooleanScript = executeBooleanScript(this.v8RuntimePtr, str, str2, i, str3, str4);
        AppMethodBeat.o(75207);
        return executeBooleanScript;
    }

    public V8Array executeArrayScript(String str) {
        AppMethodBeat.i(75208);
        V8Array executeArrayScript = executeArrayScript(str, null, 0, null, null);
        AppMethodBeat.o(75208);
        return executeArrayScript;
    }

    public V8Array executeArrayScript(String str, String str2, int i) {
        AppMethodBeat.i(75209);
        V8Array executeArrayScript = executeArrayScript(str, str2, i, null, null);
        AppMethodBeat.o(75209);
        return executeArrayScript;
    }

    public V8Array executeArrayScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75210);
        checkThread();
        Object executeScript = executeScript(str, str2, i, str3, str4);
        if (executeScript instanceof V8Array) {
            V8Array v8Array = (V8Array) executeScript;
            AppMethodBeat.o(75210);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(75210);
        throw v8ResultUndefined;
    }

    public Object executeScript(String str) {
        AppMethodBeat.i(75211);
        Object executeScript = executeScript(str, null, 0, null, null);
        AppMethodBeat.o(75211);
        return executeScript;
    }

    public Object executeScript(String str, String str2, int i) {
        AppMethodBeat.i(75212);
        Object executeScript = executeScript(str, str2, i, null, null);
        AppMethodBeat.o(75212);
        return executeScript;
    }

    public Object executeScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75213);
        checkThread();
        checkScript(str);
        Object executeScript = executeScript(getV8RuntimePtr(), 0, str, str2, i, str3, str4);
        AppMethodBeat.o(75213);
        return executeScript;
    }

    public V8Object executeObjectScript(String str) {
        AppMethodBeat.i(75214);
        V8Object executeObjectScript = executeObjectScript(str, null, 0, null, null);
        AppMethodBeat.o(75214);
        return executeObjectScript;
    }

    public V8Object executeObjectScript(String str, String str2, int i) {
        AppMethodBeat.i(75215);
        V8Object executeObjectScript = executeObjectScript(str, str2, i, null, null);
        AppMethodBeat.o(75215);
        return executeObjectScript;
    }

    public V8Object executeObjectScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75216);
        checkThread();
        Object executeScript = executeScript(str, str2, i, str3, str4);
        if (executeScript instanceof V8Object) {
            V8Object v8Object = (V8Object) executeScript;
            AppMethodBeat.o(75216);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(75216);
        throw v8ResultUndefined;
    }

    public void executeVoidScript(String str) {
        AppMethodBeat.i(75217);
        executeVoidScript(str, null, 0, null, null);
        AppMethodBeat.o(75217);
    }

    public void executeVoidScript(String str, String str2, int i) {
        AppMethodBeat.i(75218);
        executeVoidScript(str, str2, i, null, null);
        AppMethodBeat.o(75218);
    }

    public void executeVoidScript(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75219);
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i, str3, str4);
        AppMethodBeat.o(75219);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getBuildID() {
        AppMethodBeat.i(75220);
        long _getBuildID = _getBuildID();
        AppMethodBeat.o(75220);
        return _getBuildID;
    }

    public void lowMemoryNotification() {
        AppMethodBeat.i(75221);
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
        AppMethodBeat.o(75221);
    }

    public void memoryPressureNotification(int i) {
        AppMethodBeat.i(75222);
        _memoryPressureNotification(this.v8RuntimePtr, i);
        AppMethodBeat.o(75222);
    }

    /* Access modifiers changed, original: 0000 */
    public void checkRuntime(V8Value v8Value) {
        AppMethodBeat.i(75223);
        if (v8Value == null || v8Value.isUndefined()) {
            AppMethodBeat.o(75223);
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            Error error = new Error("Invalid target runtime");
            AppMethodBeat.o(75223);
            throw error;
        }
        AppMethodBeat.o(75223);
    }

    /* Access modifiers changed, original: 0000 */
    public void checkThread() {
        AppMethodBeat.i(75224);
        this.locker.checkThread();
        if (isReleased()) {
            Error error = new Error("Runtime disposed error");
            AppMethodBeat.o(75224);
            throw error;
        }
        AppMethodBeat.o(75224);
    }

    static void checkScript(String str) {
        AppMethodBeat.i(75225);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Script is null");
            AppMethodBeat.o(75225);
            throw nullPointerException;
        }
        AppMethodBeat.o(75225);
    }

    /* Access modifiers changed, original: 0000 */
    public void registerCallback(Object obj, Method method, long j, String str, boolean z) {
        AppMethodBeat.i(75226);
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, isVoidMethod(method))), methodDescriptor);
        AppMethodBeat.o(75226);
    }

    /* Access modifiers changed, original: 0000 */
    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j, String str) {
        AppMethodBeat.i(75227);
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, true)), methodDescriptor);
        AppMethodBeat.o(75227);
    }

    /* Access modifiers changed, original: 0000 */
    public void registerCallback(JavaCallback javaCallback, long j, String str) {
        AppMethodBeat.i(75228);
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j, str, false));
        AppMethodBeat.o(75228);
    }

    /* Access modifiers changed, original: 0000 */
    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j) {
        AppMethodBeat.i(75229);
        MethodDescriptor methodDescriptor = new MethodDescriptor(this, null);
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
        AppMethodBeat.o(75229);
    }

    private boolean isVoidMethod(Method method) {
        AppMethodBeat.i(75230);
        if (method.getReturnType().equals(Void.TYPE)) {
            AppMethodBeat.o(75230);
            return true;
        }
        AppMethodBeat.o(75230);
        return false;
    }

    private Object getDefaultValue(Class<?> cls) {
        AppMethodBeat.i(75231);
        Object undefined;
        if (cls.equals(V8Object.class)) {
            Undefined undefined2 = new Undefined();
            AppMethodBeat.o(75231);
            return undefined2;
        } else if (cls.equals(V8Array.class)) {
            undefined = new Undefined();
            AppMethodBeat.o(75231);
            return undefined;
        } else {
            undefined = invalid;
            AppMethodBeat.o(75231);
            return undefined;
        }
    }

    /* Access modifiers changed, original: protected */
    public void disposeMethodID(long j) {
        AppMethodBeat.i(75232);
        this.functionRegistry.remove(Long.valueOf(j));
        AppMethodBeat.o(75232);
    }

    /* Access modifiers changed, original: protected */
    public void weakReferenceReleased(long j) {
        AppMethodBeat.i(75233);
        V8Value v8Value = (V8Value) this.v8WeakReferences.get(Long.valueOf(j));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j));
            try {
                v8Value.release();
                AppMethodBeat.o(75233);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(75233);
    }

    /* Access modifiers changed, original: protected */
    public Object callObjectJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(75234);
        MethodDescriptor methodDescriptor = (MethodDescriptor) this.functionRegistry.get(Long.valueOf(j));
        Object checkResult;
        if (methodDescriptor.callback != null) {
            checkResult = checkResult(methodDescriptor.callback.invoke(v8Object, v8Array));
            AppMethodBeat.o(75234);
            return checkResult;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            checkResult = checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(75234);
            return checkResult;
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            AppMethodBeat.o(75234);
            throw targetException;
        } catch (IllegalAccessException e2) {
            AppMethodBeat.o(75234);
            throw e2;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(75234);
            throw e3;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(75234);
        }
    }

    private Object checkResult(Object obj) {
        AppMethodBeat.i(75235);
        V8RuntimeException v8RuntimeException;
        if (obj == null) {
            AppMethodBeat.o(75235);
            return obj;
        } else if (obj instanceof Float) {
            obj = Double.valueOf(((Float) obj).doubleValue());
            AppMethodBeat.o(75235);
            return obj;
        } else if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            AppMethodBeat.o(75235);
            return obj;
        } else if (!(obj instanceof V8Value)) {
            v8RuntimeException = new V8RuntimeException("Unknown return type: " + obj.getClass());
            AppMethodBeat.o(75235);
            throw v8RuntimeException;
        } else if (((V8Value) obj).isReleased()) {
            v8RuntimeException = new V8RuntimeException("V8Value already released");
            AppMethodBeat.o(75235);
            throw v8RuntimeException;
        } else {
            AppMethodBeat.o(75235);
            return obj;
        }
    }

    /* Access modifiers changed, original: protected */
    public void callVoidJavaMethod(long j, V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(75236);
        MethodDescriptor methodDescriptor = (MethodDescriptor) this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor.voidCallback != null) {
            methodDescriptor.voidCallback.invoke(v8Object, v8Array);
            AppMethodBeat.o(75236);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            methodDescriptor.method.invoke(methodDescriptor.object, args);
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(75236);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            AppMethodBeat.o(75236);
            throw targetException;
        } catch (IllegalAccessException e2) {
            AppMethodBeat.o(75236);
            throw e2;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(75236);
            throw e3;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(75236);
        }
    }

    private void checkArgs(Object[] objArr) {
        AppMethodBeat.i(75237);
        for (Object obj : objArr) {
            if (obj == invalid) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("argument type mismatch");
                AppMethodBeat.o(75237);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(75237);
    }

    private void releaseArguments(Object[] objArr, boolean z) {
        AppMethodBeat.i(75238);
        if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
        AppMethodBeat.o(75238);
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        AppMethodBeat.i(75239);
        int length = methodDescriptor.method.getParameterTypes().length;
        int i = z ? length - 1 : length;
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        ArrayList arrayList = new ArrayList();
        populateParamters(v8Array, i, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i] = varArgContainer;
        }
        AppMethodBeat.o(75239);
        return defaultValues;
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i) {
        AppMethodBeat.i(75240);
        Class cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        Object newInstance = Array.newInstance(cls, i);
        AppMethodBeat.o(75240);
        return newInstance;
    }

    private void populateParamters(V8Array v8Array, int i, Object[] objArr, List<Object> list, boolean z) {
        AppMethodBeat.i(75241);
        int i2 = 0;
        if (z) {
            i2 = 1;
        }
        for (int i3 = i2; i3 < v8Array.length() + i2; i3++) {
            if (i3 >= i) {
                list.add(getArrayItem(v8Array, i3 - i2));
            } else {
                objArr[i3] = getArrayItem(v8Array, i3 - i2);
            }
        }
        AppMethodBeat.o(75241);
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        int i;
        AppMethodBeat.i(75242);
        if (z) {
            i = 1;
            objArr[0] = v8Object;
        } else {
            i = 0;
        }
        while (i < objArr.length) {
            objArr[i] = getDefaultValue(clsArr[i]);
            i++;
        }
        AppMethodBeat.o(75242);
        return objArr;
    }

    private Object getArrayItem(V8Array v8Array, int i) {
        AppMethodBeat.i(75243);
        try {
            Object valueOf;
            switch (v8Array.getType(i)) {
                case 1:
                    valueOf = Integer.valueOf(v8Array.getInteger(i));
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 2:
                    valueOf = Double.valueOf(v8Array.getDouble(i));
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 3:
                    valueOf = Boolean.valueOf(v8Array.getBoolean(i));
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 4:
                    valueOf = v8Array.getString(i);
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 5:
                case 8:
                    valueOf = v8Array.getArray(i);
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 6:
                    valueOf = v8Array.getObject(i);
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 7:
                    valueOf = v8Array.getObject(i);
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 10:
                    valueOf = v8Array.get(i);
                    AppMethodBeat.o(75243);
                    return valueOf;
                case 99:
                    valueOf = getUndefined();
                    AppMethodBeat.o(75243);
                    return valueOf;
            }
        } catch (V8ResultUndefined e) {
        }
        AppMethodBeat.o(75243);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void createNodeRuntime(String str) {
        AppMethodBeat.i(75244);
        _startNodeJS(this.v8RuntimePtr, str);
        AppMethodBeat.o(75244);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean pumpMessageLoop() {
        AppMethodBeat.i(75245);
        boolean _pumpMessageLoop = _pumpMessageLoop(this.v8RuntimePtr);
        AppMethodBeat.o(75245);
        return _pumpMessageLoop;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isRunning() {
        AppMethodBeat.i(75246);
        boolean _isRunning = _isRunning(this.v8RuntimePtr);
        AppMethodBeat.o(75246);
        return _isRunning;
    }

    /* Access modifiers changed, original: protected */
    public long initNewV8Object(long j) {
        AppMethodBeat.i(75247);
        long _initNewV8Object = _initNewV8Object(j);
        AppMethodBeat.o(75247);
        return _initNewV8Object;
    }

    /* Access modifiers changed, original: protected */
    public long getGlobalObject() {
        AppMethodBeat.i(75248);
        long _getGlobalObject = _getGlobalObject(this.v8RuntimePtr);
        AppMethodBeat.o(75248);
        return _getGlobalObject;
    }

    /* Access modifiers changed, original: protected */
    public void acquireLock(long j) {
        AppMethodBeat.i(75249);
        _acquireLock(j);
        AppMethodBeat.o(75249);
    }

    /* Access modifiers changed, original: protected */
    public void releaseLock(long j) {
        AppMethodBeat.i(75250);
        _releaseLock(j);
        AppMethodBeat.o(75250);
    }

    /* Access modifiers changed, original: protected */
    public void lowMemoryNotification(long j) {
        AppMethodBeat.i(75251);
        _lowMemoryNotification(j);
        AppMethodBeat.o(75251);
    }

    /* Access modifiers changed, original: protected */
    public void createTwin(long j, long j2, long j3) {
        AppMethodBeat.i(75252);
        _createTwin(j, j2, j3);
        AppMethodBeat.o(75252);
    }

    /* Access modifiers changed, original: protected */
    public int executeIntegerScript(long j, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75253);
        int _executeIntegerScript = _executeIntegerScript(j, str, str2, i, str3, str4);
        AppMethodBeat.o(75253);
        return _executeIntegerScript;
    }

    /* Access modifiers changed, original: protected */
    public double executeDoubleScript(long j, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75254);
        double _executeDoubleScript = _executeDoubleScript(j, str, str2, i, str3, str4);
        AppMethodBeat.o(75254);
        return _executeDoubleScript;
    }

    /* Access modifiers changed, original: protected */
    public String executeStringScript(long j, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75255);
        String _executeStringScript = _executeStringScript(j, str, str2, i, str3, str4);
        AppMethodBeat.o(75255);
        return _executeStringScript;
    }

    /* Access modifiers changed, original: protected */
    public boolean executeBooleanScript(long j, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75256);
        boolean _executeBooleanScript = _executeBooleanScript(j, str, str2, i, str3, str4);
        AppMethodBeat.o(75256);
        return _executeBooleanScript;
    }

    /* Access modifiers changed, original: protected */
    public Object executeScript(long j, int i, String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(75257);
        Object _executeScript = _executeScript(j, i, str, str2, i2, str3, str4);
        AppMethodBeat.o(75257);
        return _executeScript;
    }

    /* Access modifiers changed, original: protected */
    public void executeVoidScript(long j, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(75258);
        _executeVoidScript(j, str, str2, i, str3, str4);
        AppMethodBeat.o(75258);
    }

    /* Access modifiers changed, original: protected */
    public void setWeak(long j, long j2) {
        AppMethodBeat.i(75259);
        _setWeak(j, j2);
        AppMethodBeat.o(75259);
    }

    /* Access modifiers changed, original: protected */
    public boolean isWeak(long j, long j2) {
        AppMethodBeat.i(75260);
        boolean _isWeak = _isWeak(j, j2);
        AppMethodBeat.o(75260);
        return _isWeak;
    }

    /* Access modifiers changed, original: protected */
    public void release(long j, long j2) {
        AppMethodBeat.i(75261);
        _release(j, j2);
        AppMethodBeat.o(75261);
    }

    /* Access modifiers changed, original: protected */
    public boolean contains(long j, long j2, String str) {
        AppMethodBeat.i(75262);
        boolean _contains = _contains(j, j2, str);
        AppMethodBeat.o(75262);
        return _contains;
    }

    /* Access modifiers changed, original: protected */
    public String[] getKeys(long j, long j2) {
        AppMethodBeat.i(75263);
        String[] _getKeys = _getKeys(j, j2);
        AppMethodBeat.o(75263);
        return _getKeys;
    }

    /* Access modifiers changed, original: protected */
    public int getInteger(long j, long j2, String str) {
        AppMethodBeat.i(75264);
        int _getInteger = _getInteger(j, j2, str);
        AppMethodBeat.o(75264);
        return _getInteger;
    }

    /* Access modifiers changed, original: protected */
    public boolean getBoolean(long j, long j2, String str) {
        AppMethodBeat.i(75265);
        boolean _getBoolean = _getBoolean(j, j2, str);
        AppMethodBeat.o(75265);
        return _getBoolean;
    }

    /* Access modifiers changed, original: protected */
    public double getDouble(long j, long j2, String str) {
        AppMethodBeat.i(75266);
        double _getDouble = _getDouble(j, j2, str);
        AppMethodBeat.o(75266);
        return _getDouble;
    }

    /* Access modifiers changed, original: protected */
    public String getString(long j, long j2, String str) {
        AppMethodBeat.i(75267);
        String _getString = _getString(j, j2, str);
        AppMethodBeat.o(75267);
        return _getString;
    }

    /* Access modifiers changed, original: protected */
    public Object get(long j, int i, long j2, String str) {
        AppMethodBeat.i(75268);
        Object _get = _get(j, i, j2, str);
        AppMethodBeat.o(75268);
        return _get;
    }

    /* Access modifiers changed, original: protected */
    public int executeIntegerFunction(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75269);
        int _executeIntegerFunction = _executeIntegerFunction(j, j2, str, j3);
        AppMethodBeat.o(75269);
        return _executeIntegerFunction;
    }

    /* Access modifiers changed, original: protected */
    public double executeDoubleFunction(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75270);
        double _executeDoubleFunction = _executeDoubleFunction(j, j2, str, j3);
        AppMethodBeat.o(75270);
        return _executeDoubleFunction;
    }

    /* Access modifiers changed, original: protected */
    public String executeStringFunction(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75271);
        String _executeStringFunction = _executeStringFunction(j, j2, str, j3);
        AppMethodBeat.o(75271);
        return _executeStringFunction;
    }

    /* Access modifiers changed, original: protected */
    public boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75272);
        boolean _executeBooleanFunction = _executeBooleanFunction(j, j2, str, j3);
        AppMethodBeat.o(75272);
        return _executeBooleanFunction;
    }

    /* Access modifiers changed, original: protected */
    public Object executeFunction(long j, int i, long j2, String str, long j3) {
        AppMethodBeat.i(75273);
        Object _executeFunction = _executeFunction(j, i, j2, str, j3);
        AppMethodBeat.o(75273);
        return _executeFunction;
    }

    /* Access modifiers changed, original: protected */
    public Object executeFunction(long j, long j2, long j3, long j4) {
        AppMethodBeat.i(75274);
        Object _executeFunction = _executeFunction(j, j2, j3, j4);
        AppMethodBeat.o(75274);
        return _executeFunction;
    }

    /* Access modifiers changed, original: protected */
    public void executeVoidFunction(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75275);
        _executeVoidFunction(j, j2, str, j3);
        AppMethodBeat.o(75275);
    }

    /* Access modifiers changed, original: protected */
    public boolean equals(long j, long j2, long j3) {
        AppMethodBeat.i(75276);
        boolean _equals = _equals(j, j2, j3);
        AppMethodBeat.o(75276);
        return _equals;
    }

    /* Access modifiers changed, original: protected */
    public String toString(long j, long j2) {
        AppMethodBeat.i(75277);
        String _toString = _toString(j, j2);
        AppMethodBeat.o(75277);
        return _toString;
    }

    /* Access modifiers changed, original: protected */
    public boolean strictEquals(long j, long j2, long j3) {
        AppMethodBeat.i(75278);
        boolean _strictEquals = _strictEquals(j, j2, j3);
        AppMethodBeat.o(75278);
        return _strictEquals;
    }

    /* Access modifiers changed, original: protected */
    public boolean sameValue(long j, long j2, long j3) {
        AppMethodBeat.i(75279);
        boolean _sameValue = _sameValue(j, j2, j3);
        AppMethodBeat.o(75279);
        return _sameValue;
    }

    /* Access modifiers changed, original: protected */
    public int identityHash(long j, long j2) {
        AppMethodBeat.i(75280);
        int _identityHash = _identityHash(j, j2);
        AppMethodBeat.o(75280);
        return _identityHash;
    }

    /* Access modifiers changed, original: protected */
    public void add(long j, long j2, String str, int i) {
        AppMethodBeat.i(75281);
        _add(j, j2, str, i);
        AppMethodBeat.o(75281);
    }

    /* Access modifiers changed, original: protected */
    public void addObject(long j, long j2, String str, long j3) {
        AppMethodBeat.i(75282);
        _addObject(j, j2, str, j3);
        AppMethodBeat.o(75282);
    }

    /* Access modifiers changed, original: protected */
    public void add(long j, long j2, String str, boolean z) {
        AppMethodBeat.i(75283);
        _add(j, j2, str, z);
        AppMethodBeat.o(75283);
    }

    /* Access modifiers changed, original: protected */
    public void add(long j, long j2, String str, double d) {
        AppMethodBeat.i(75284);
        _add(j, j2, str, d);
        AppMethodBeat.o(75284);
    }

    /* Access modifiers changed, original: protected */
    public void add(long j, long j2, String str, String str2) {
        AppMethodBeat.i(75285);
        _add(j, j2, str, str2);
        AppMethodBeat.o(75285);
    }

    /* Access modifiers changed, original: protected */
    public void addUndefined(long j, long j2, String str) {
        AppMethodBeat.i(75286);
        _addUndefined(j, j2, str);
        AppMethodBeat.o(75286);
    }

    /* Access modifiers changed, original: protected */
    public void addNull(long j, long j2, String str) {
        AppMethodBeat.i(75287);
        _addNull(j, j2, str);
        AppMethodBeat.o(75287);
    }

    /* Access modifiers changed, original: protected */
    public long registerJavaMethod(long j, long j2, String str, boolean z) {
        AppMethodBeat.i(75288);
        long _registerJavaMethod = _registerJavaMethod(j, j2, str, z);
        AppMethodBeat.o(75288);
        return _registerJavaMethod;
    }

    /* Access modifiers changed, original: protected */
    public long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(75289);
        long _initNewV8ArrayBuffer = _initNewV8ArrayBuffer(j, byteBuffer, i);
        AppMethodBeat.o(75289);
        return _initNewV8ArrayBuffer;
    }

    /* Access modifiers changed, original: protected */
    public long initNewSharedV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(75290);
        long _initNewSharedV8ArrayBuffer = _initNewSharedV8ArrayBuffer(j, byteBuffer, i);
        AppMethodBeat.o(75290);
        return _initNewSharedV8ArrayBuffer;
    }

    /* Access modifiers changed, original: protected */
    public long initNewV8ArrayBuffer(long j, int i) {
        AppMethodBeat.i(75291);
        long _initNewV8ArrayBuffer = _initNewV8ArrayBuffer(j, i);
        AppMethodBeat.o(75291);
        return _initNewV8ArrayBuffer;
    }

    public long initNewV8Int32Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75292);
        long _initNewV8Int32Array = _initNewV8Int32Array(j, j2, i, i2);
        AppMethodBeat.o(75292);
        return _initNewV8Int32Array;
    }

    public long initNewV8Float32Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75293);
        long _initNewV8Float32Array = _initNewV8Float32Array(j, j2, i, i2);
        AppMethodBeat.o(75293);
        return _initNewV8Float32Array;
    }

    public long initNewV8Float64Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75294);
        long _initNewV8Float64Array = _initNewV8Float64Array(j, j2, i, i2);
        AppMethodBeat.o(75294);
        return _initNewV8Float64Array;
    }

    public long initNewV8UInt32Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75295);
        long _initNewV8UInt32Array = _initNewV8UInt32Array(j, j2, i, i2);
        AppMethodBeat.o(75295);
        return _initNewV8UInt32Array;
    }

    public long initNewV8UInt16Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75296);
        long _initNewV8UInt16Array = _initNewV8UInt16Array(j, j2, i, i2);
        AppMethodBeat.o(75296);
        return _initNewV8UInt16Array;
    }

    public long initNewV8Int16Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75297);
        long _initNewV8Int16Array = _initNewV8Int16Array(j, j2, i, i2);
        AppMethodBeat.o(75297);
        return _initNewV8Int16Array;
    }

    public long initNewV8UInt8Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75298);
        long _initNewV8UInt8Array = _initNewV8UInt8Array(j, j2, i, i2);
        AppMethodBeat.o(75298);
        return _initNewV8UInt8Array;
    }

    public long initNewV8Int8Array(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75299);
        long _initNewV8Int8Array = _initNewV8Int8Array(j, j2, i, i2);
        AppMethodBeat.o(75299);
        return _initNewV8Int8Array;
    }

    public long initNewV8UInt8ClampedArray(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75300);
        long _initNewV8UInt8ClampedArray = _initNewV8UInt8ClampedArray(j, j2, i, i2);
        AppMethodBeat.o(75300);
        return _initNewV8UInt8ClampedArray;
    }

    /* Access modifiers changed, original: protected */
    public ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        AppMethodBeat.i(75301);
        ByteBuffer _createV8ArrayBufferBackingStore = _createV8ArrayBufferBackingStore(j, j2, i);
        AppMethodBeat.o(75301);
        return _createV8ArrayBufferBackingStore;
    }

    /* Access modifiers changed, original: protected */
    public long initNewV8Array(long j) {
        AppMethodBeat.i(75302);
        long _initNewV8Array = _initNewV8Array(j);
        AppMethodBeat.o(75302);
        return _initNewV8Array;
    }

    /* Access modifiers changed, original: protected */
    public long[] initNewV8Function(long j) {
        AppMethodBeat.i(75303);
        checkThread();
        long[] _initNewV8Function = _initNewV8Function(j);
        AppMethodBeat.o(75303);
        return _initNewV8Function;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetSize(long j, long j2) {
        AppMethodBeat.i(75304);
        int _arrayGetSize = _arrayGetSize(j, j2);
        AppMethodBeat.o(75304);
        return _arrayGetSize;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetInteger(long j, long j2, int i) {
        AppMethodBeat.i(75305);
        int _arrayGetInteger = _arrayGetInteger(j, j2, i);
        AppMethodBeat.o(75305);
        return _arrayGetInteger;
    }

    /* Access modifiers changed, original: protected */
    public boolean arrayGetBoolean(long j, long j2, int i) {
        AppMethodBeat.i(75306);
        boolean _arrayGetBoolean = _arrayGetBoolean(j, j2, i);
        AppMethodBeat.o(75306);
        return _arrayGetBoolean;
    }

    /* Access modifiers changed, original: protected */
    public byte arrayGetByte(long j, long j2, int i) {
        AppMethodBeat.i(75307);
        byte _arrayGetByte = _arrayGetByte(j, j2, i);
        AppMethodBeat.o(75307);
        return _arrayGetByte;
    }

    /* Access modifiers changed, original: protected */
    public double arrayGetDouble(long j, long j2, int i) {
        AppMethodBeat.i(75308);
        double _arrayGetDouble = _arrayGetDouble(j, j2, i);
        AppMethodBeat.o(75308);
        return _arrayGetDouble;
    }

    /* Access modifiers changed, original: protected */
    public String arrayGetString(long j, long j2, int i) {
        AppMethodBeat.i(75309);
        String _arrayGetString = _arrayGetString(j, j2, i);
        AppMethodBeat.o(75309);
        return _arrayGetString;
    }

    /* Access modifiers changed, original: protected */
    public Object arrayGet(long j, int i, long j2, int i2) {
        AppMethodBeat.i(75310);
        Object _arrayGet = _arrayGet(j, i, j2, i2);
        AppMethodBeat.o(75310);
        return _arrayGet;
    }

    /* Access modifiers changed, original: protected */
    public void addArrayIntItem(long j, long j2, int i) {
        AppMethodBeat.i(75311);
        _addArrayIntItem(j, j2, i);
        AppMethodBeat.o(75311);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayBooleanItem(long j, long j2, boolean z) {
        AppMethodBeat.i(75312);
        _addArrayBooleanItem(j, j2, z);
        AppMethodBeat.o(75312);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayDoubleItem(long j, long j2, double d) {
        AppMethodBeat.i(75313);
        _addArrayDoubleItem(j, j2, d);
        AppMethodBeat.o(75313);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayStringItem(long j, long j2, String str) {
        AppMethodBeat.i(75314);
        _addArrayStringItem(j, j2, str);
        AppMethodBeat.o(75314);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayObjectItem(long j, long j2, long j3) {
        AppMethodBeat.i(75315);
        _addArrayObjectItem(j, j2, j3);
        AppMethodBeat.o(75315);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayUndefinedItem(long j, long j2) {
        AppMethodBeat.i(75316);
        _addArrayUndefinedItem(j, j2);
        AppMethodBeat.o(75316);
    }

    /* Access modifiers changed, original: protected */
    public void addArrayNullItem(long j, long j2) {
        AppMethodBeat.i(75317);
        _addArrayNullItem(j, j2);
        AppMethodBeat.o(75317);
    }

    /* Access modifiers changed, original: protected */
    public int getType(long j, long j2) {
        AppMethodBeat.i(75318);
        int _getType = _getType(j, j2);
        AppMethodBeat.o(75318);
        return _getType;
    }

    /* Access modifiers changed, original: protected */
    public int getType(long j, long j2, String str) {
        AppMethodBeat.i(75319);
        int _getType = _getType(j, j2, str);
        AppMethodBeat.o(75319);
        return _getType;
    }

    /* Access modifiers changed, original: protected */
    public int getType(long j, long j2, int i) {
        AppMethodBeat.i(75320);
        int _getType = _getType(j, j2, i);
        AppMethodBeat.o(75320);
        return _getType;
    }

    /* Access modifiers changed, original: protected */
    public int getArrayType(long j, long j2) {
        AppMethodBeat.i(75321);
        int _getArrayType = _getArrayType(j, j2);
        AppMethodBeat.o(75321);
        return _getArrayType;
    }

    /* Access modifiers changed, original: protected */
    public int getType(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75322);
        int _getType = _getType(j, j2, i, i2);
        AppMethodBeat.o(75322);
        return _getType;
    }

    /* Access modifiers changed, original: protected */
    public void setPrototype(long j, long j2, long j3) {
        AppMethodBeat.i(75323);
        _setPrototype(j, j2, j3);
        AppMethodBeat.o(75323);
    }

    /* Access modifiers changed, original: protected */
    public int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75324);
        int[] _arrayGetIntegers = _arrayGetIntegers(j, j2, i, i2);
        AppMethodBeat.o(75324);
        return _arrayGetIntegers;
    }

    /* Access modifiers changed, original: protected */
    public double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75325);
        double[] _arrayGetDoubles = _arrayGetDoubles(j, j2, i, i2);
        AppMethodBeat.o(75325);
        return _arrayGetDoubles;
    }

    /* Access modifiers changed, original: protected */
    public boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75326);
        boolean[] _arrayGetBooleans = _arrayGetBooleans(j, j2, i, i2);
        AppMethodBeat.o(75326);
        return _arrayGetBooleans;
    }

    /* Access modifiers changed, original: protected */
    public byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75327);
        byte[] _arrayGetBytes = _arrayGetBytes(j, j2, i, i2);
        AppMethodBeat.o(75327);
        return _arrayGetBytes;
    }

    /* Access modifiers changed, original: protected */
    public String[] arrayGetStrings(long j, long j2, int i, int i2) {
        AppMethodBeat.i(75328);
        String[] _arrayGetStrings = _arrayGetStrings(j, j2, i, i2);
        AppMethodBeat.o(75328);
        return _arrayGetStrings;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        AppMethodBeat.i(75329);
        int _arrayGetIntegers = _arrayGetIntegers(j, j2, i, i2, iArr);
        AppMethodBeat.o(75329);
        return _arrayGetIntegers;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        AppMethodBeat.i(75330);
        int _arrayGetDoubles = _arrayGetDoubles(j, j2, i, i2, dArr);
        AppMethodBeat.o(75330);
        return _arrayGetDoubles;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        AppMethodBeat.i(75331);
        int _arrayGetBooleans = _arrayGetBooleans(j, j2, i, i2, zArr);
        AppMethodBeat.o(75331);
        return _arrayGetBooleans;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        AppMethodBeat.i(75332);
        int _arrayGetBytes = _arrayGetBytes(j, j2, i, i2, bArr);
        AppMethodBeat.o(75332);
        return _arrayGetBytes;
    }

    /* Access modifiers changed, original: protected */
    public int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        AppMethodBeat.i(75333);
        int _arrayGetStrings = _arrayGetStrings(j, j2, i, i2, strArr);
        AppMethodBeat.o(75333);
        return _arrayGetStrings;
    }

    /* Access modifiers changed, original: protected */
    public void terminateExecution(long j) {
        AppMethodBeat.i(75334);
        _terminateExecution(j);
        AppMethodBeat.o(75334);
    }

    /* Access modifiers changed, original: protected */
    public void releaseMethodDescriptor(long j, long j2) {
        AppMethodBeat.i(75335);
        _releaseMethodDescriptor(j, j2);
        AppMethodBeat.o(75335);
    }

    /* Access modifiers changed, original: protected */
    public long getIsolatePtr() {
        AppMethodBeat.i(75336);
        long _getIsolatePtr = _getIsolatePtr(this.v8RuntimePtr);
        AppMethodBeat.o(75336);
        return _getIsolatePtr;
    }

    /* Access modifiers changed, original: 0000 */
    public void addObjRef(V8Value v8Value) {
        AppMethodBeat.i(75337);
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
        AppMethodBeat.o(75337);
    }

    /* Access modifiers changed, original: 0000 */
    public void releaseObjRef(V8Value v8Value) {
        AppMethodBeat.i(75338);
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
        AppMethodBeat.o(75338);
    }

    public static void setLoadLibraryDelegate(ILoadLibraryDelegate iLoadLibraryDelegate) {
        AppMethodBeat.i(75339);
        if (iLoadLibraryDelegate == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setLoadLibraryDelegate: param delegate null");
            AppMethodBeat.o(75339);
            throw illegalArgumentException;
        }
        sLoadLibraryDelegate = iLoadLibraryDelegate;
        AppMethodBeat.o(75339);
    }

    public String executeDebugScript(String str, String str2) {
        AppMethodBeat.i(75340);
        checkThread();
        checkScript(str);
        String _executeDebugScript = _executeDebugScript(this.v8RuntimePtr, str, str2);
        AppMethodBeat.o(75340);
        return _executeDebugScript;
    }

    public void waitForDebugger(String str) {
        AppMethodBeat.i(75341);
        checkThread();
        _waitForDebuger(this.v8RuntimePtr, str);
        AppMethodBeat.o(75341);
    }

    public void debuggerMessageLoop() {
        AppMethodBeat.i(75342);
        checkThread();
        _debugMessageLoop(this.v8RuntimePtr);
        AppMethodBeat.o(75342);
    }
}
