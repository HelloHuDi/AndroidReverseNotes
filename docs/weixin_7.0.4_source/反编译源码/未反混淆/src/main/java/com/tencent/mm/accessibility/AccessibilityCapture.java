package com.tencent.mm.accessibility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.ViewSearchTool.Matcher;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AccessibilityCapture {
    public static final long EVENT_MIN_INTERVAL = 1000;
    private static final String INTERFACE_IACCESSIBILITYMANAGER = "android.view.accessibility.IAccessibilityManager";
    private static final String INTERFACE_IACCESSIBILITYMANAGERCLIENT = "android.view.accessibility.IAccessibilityManagerClient";
    private static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 1;
    private static final String TAG = "MicroMsg.AccessibilityCapture";
    private static Field enableField;
    private static IAccessibilityManagerInvocationHandler iAccessibilityManagerInvocationHandler = null;
    private static Field idField;
    private static long lastEventTime = 0;
    private static int lastEventType = 0;
    private static APIProvider mAPIProvider;
    private static boolean mEnable = false;
    private static boolean mForwardEnable;
    private static AccessibilityManager mManager;
    private static Class<AccessibilityManager> managerClass = AccessibilityManager.class;

    static class IAccessibilityManagerClientInvocationHandler implements InvocationHandler {
        private IAccessibilityManagerClientInvocationHandler() {
        }

        /* synthetic */ IAccessibilityManagerClientInvocationHandler(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(118624);
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            if (name.equals("setState") && parameterTypes.length == 1 && parameterTypes[0].equals(Integer.TYPE)) {
                Object obj2 = objArr[0];
                if (obj2 == null || !(obj2 instanceof Integer)) {
                    AppMethodBeat.o(118624);
                    return null;
                }
                AccessibilityCapture.mAPIProvider.i(AccessibilityCapture.TAG, "setState %d", Integer.valueOf(((Integer) obj2).intValue()));
                AccessibilityCapture.access$700(r0);
            }
            AppMethodBeat.o(118624);
            return null;
        }
    }

    public static class ViewSearchTask implements Runnable {
        private long elapsedTime = 0;
        private final AccessibilityEvent mEvent;

        public ViewSearchTask(AccessibilityEvent accessibilityEvent, long j) {
            this.mEvent = accessibilityEvent;
            this.elapsedTime = j;
        }

        private int findAccessibilityId() {
            Field declaredField;
            int longValue;
            AppMethodBeat.i(118627);
            try {
                declaredField = AccessibilityRecord.class.getDeclaredField("mSourceNodeId");
            } catch (NoSuchFieldException e) {
                declaredField = AccessibilityRecord.class.getDeclaredField("mSourceViewId");
            }
            try {
                declaredField.setAccessible(true);
                longValue = (int) ((Long) declaredField.get(this.mEvent)).longValue();
            } catch (NoSuchFieldException e2) {
                declaredField = AccessibilityNodeInfo.class.getDeclaredField("mSourceNodeId");
                Field declaredField2 = AccessibilityRecord.class.getDeclaredField("mSealed");
                declaredField2.setAccessible(true);
                declaredField2.set(this.mEvent, Boolean.TRUE);
                AccessibilityNodeInfo source = this.mEvent.getSource();
                if (source == null) {
                    AccessibilityIdNotFoundException accessibilityIdNotFoundException = new AccessibilityIdNotFoundException();
                    AppMethodBeat.o(118627);
                    throw accessibilityIdNotFoundException;
                }
                declaredField.setAccessible(true);
                longValue = (int) ((Long) declaredField.get(source)).longValue();
            } catch (NoSuchFieldException e3) {
                AccessibilityIdNotFoundException accessibilityIdNotFoundException2 = new AccessibilityIdNotFoundException(e3);
                AppMethodBeat.o(118627);
                throw accessibilityIdNotFoundException2;
            }
            AppMethodBeat.o(118627);
            return longValue;
        }

        public void run() {
            AppMethodBeat.i(118628);
            if (this.mEvent == null) {
                AppMethodBeat.o(118628);
                return;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                AccessibilityCapture.access$800(this.mEvent, searchViewByAccessibilityId(findAccessibilityId()), this.elapsedTime);
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                AccessibilityCapture.mAPIProvider.i(AccessibilityCapture.TAG, "analysis event %s, cost %dms", AccessibilityEvent.eventTypeToString(this.mEvent.getEventType()), Long.valueOf(elapsedRealtime));
                try {
                    this.mEvent.recycle();
                    AppMethodBeat.o(118628);
                } catch (Throwable th) {
                    AccessibilityCapture.mAPIProvider.e(AccessibilityCapture.TAG, "Throw something when recycle event which shouldn't occurs.", th);
                    AppMethodBeat.o(118628);
                }
            } catch (Throwable th2) {
                AccessibilityCapture.mAPIProvider.e(AccessibilityCapture.TAG, "Throw something when recycle event which shouldn't occurs.", th2);
                AppMethodBeat.o(118628);
            }
        }

        private View searchViewByAccessibilityId(final int i) {
            AppMethodBeat.i(118629);
            try {
                List findView = new ViewSearchTool().findView(new Matcher() {
                    public boolean match(View view) {
                        AppMethodBeat.i(118626);
                        try {
                            if (((Integer) AccessibilityCapture.idField.get(view)).intValue() == i) {
                                AppMethodBeat.o(118626);
                                return true;
                            }
                            AppMethodBeat.o(118626);
                            return false;
                        } catch (IllegalAccessException e) {
                            AppMethodBeat.o(118626);
                            return false;
                        }
                    }
                });
                if (findView != null && findView.size() == 1) {
                    View view = (View) findView.get(0);
                    AppMethodBeat.o(118629);
                    return view;
                }
            } catch (NoSuchMethodException e) {
            } catch (Exception e2) {
                AccessibilityCapture.mAPIProvider.e(AccessibilityCapture.TAG, "exception when find root", e2);
            }
            AppMethodBeat.o(118629);
            return null;
        }
    }

    public interface APIProvider {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void onEvent(Event event);

        void post(Runnable runnable, String str);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);
    }

    static class IAccessibilityManagerInvocationHandler implements InvocationHandler {
        private final Object originalInstance;

        /* synthetic */ IAccessibilityManagerInvocationHandler(Object obj, AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        private IAccessibilityManagerInvocationHandler(Object obj) {
            this.originalInstance = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(118625);
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            Object obj2;
            if (name.equals("sendAccessibilityEvent") && parameterTypes.length == 2 && parameterTypes[0].equals(AccessibilityEvent.class) && parameterTypes[1].equals(Integer.TYPE)) {
                obj2 = objArr[0];
                if (obj2 == null || !(obj2 instanceof AccessibilityEvent)) {
                    AppMethodBeat.o(118625);
                    return null;
                }
                AccessibilityEvent accessibilityEvent = (AccessibilityEvent) obj2;
                if (AccessibilityCapture.mForwardEnable) {
                    if (AccessibilityCapture.access$300(accessibilityEvent) && AccessibilityCapture.access$400(accessibilityEvent)) {
                        AccessibilityCapture.access$500(AccessibilityEvent.obtain(accessibilityEvent));
                    }
                    obj2 = method.invoke(this.originalInstance, objArr);
                    AppMethodBeat.o(118625);
                    return obj2;
                } else if (AccessibilityCapture.access$300(accessibilityEvent) && AccessibilityCapture.access$400(accessibilityEvent)) {
                    AccessibilityCapture.access$500(accessibilityEvent);
                    obj2 = Boolean.FALSE;
                    AppMethodBeat.o(118625);
                    return obj2;
                } else {
                    AccessibilityCapture.mAPIProvider.v(AccessibilityCapture.TAG, "filter a event: %s", AccessibilityEvent.eventTypeToString(accessibilityEvent.getEventType()));
                    obj2 = Boolean.TRUE;
                    AppMethodBeat.o(118625);
                    return obj2;
                }
            }
            AccessibilityCapture.mAPIProvider.i(AccessibilityCapture.TAG, "[oneliang]original accessibility instance: %s,method name:%s", this.originalInstance, name);
            if (this.originalInstance != null) {
                obj2 = method.invoke(this.originalInstance, objArr);
                AppMethodBeat.o(118625);
                return obj2;
            }
            AppMethodBeat.o(118625);
            return null;
        }

        public Object getOriginalInstance() {
            return this.originalInstance;
        }
    }

    public static class Event {
        public final Activity activity;
        public final long elapsedTime;
        public final AccessibilityEvent event;
        public final View view;

        public Event(AccessibilityEvent accessibilityEvent, View view, Activity activity, long j) {
            this.event = accessibilityEvent;
            this.view = view;
            this.activity = activity;
            this.elapsedTime = j;
        }
    }

    static /* synthetic */ boolean access$300(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(118640);
        boolean filter = filter(accessibilityEvent);
        AppMethodBeat.o(118640);
        return filter;
    }

    static /* synthetic */ boolean access$400(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(118641);
        boolean filterEventMerged = filterEventMerged(accessibilityEvent);
        AppMethodBeat.o(118641);
        return filterEventMerged;
    }

    static /* synthetic */ void access$500(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(118642);
        post(accessibilityEvent);
        AppMethodBeat.o(118642);
    }

    static /* synthetic */ void access$700(int i) {
        AppMethodBeat.i(118643);
        updateState(i);
        AppMethodBeat.o(118643);
    }

    static /* synthetic */ void access$800(AccessibilityEvent accessibilityEvent, View view, long j) {
        AppMethodBeat.i(118644);
        logTarget(accessibilityEvent, view, j);
        AppMethodBeat.o(118644);
    }

    private AccessibilityCapture() {
        AppMethodBeat.i(118630);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("You should instantiate this class");
        AppMethodBeat.o(118630);
        throw unsupportedOperationException;
    }

    public static boolean isEnable() {
        return mEnable;
    }

    private static void setAccessibilityEnable() {
        Field declaredField;
        AppMethodBeat.i(118631);
        if (enableField == null) {
            declaredField = managerClass.getDeclaredField("mIsEnabled");
            enableField = declaredField;
            declaredField.setAccessible(true);
        }
        enableField.set(mManager, Boolean.TRUE);
        declaredField = managerClass.getDeclaredField("mService");
        declaredField.setAccessible(true);
        iAccessibilityManagerInvocationHandler = new IAccessibilityManagerInvocationHandler(declaredField.get(mManager), null);
        Class cls = Class.forName(INTERFACE_IACCESSIBILITYMANAGER);
        Object newProxyInstance = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls}, iAccessibilityManagerInvocationHandler);
        try {
            declaredField.set(mManager, newProxyInstance);
            mEnable = true;
            try {
                Class cls2 = Class.forName(INTERFACE_IACCESSIBILITYMANAGERCLIENT);
                int intValue;
                Object invoke;
                if (VERSION.SDK_INT > 17) {
                    declaredField = managerClass.getDeclaredField("mUserId");
                    declaredField.setAccessible(true);
                    intValue = ((Integer) declaredField.get(mManager)).intValue();
                    IAccessibilityManagerClientInvocationHandler iAccessibilityManagerClientInvocationHandler = new IAccessibilityManagerClientInvocationHandler();
                    Object newProxyInstance2 = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls2}, iAccessibilityManagerClientInvocationHandler);
                    invoke = cls.getMethod("addClient", new Class[]{cls2, Integer.TYPE}).invoke(newProxyInstance, new Object[]{newProxyInstance2, Integer.valueOf(intValue)});
                    if (invoke != null && (invoke instanceof Integer)) {
                        mAPIProvider.i(TAG, "api > 17 state: %d", Integer.valueOf(((Integer) invoke).intValue()));
                        updateState(intValue);
                    }
                    AppMethodBeat.o(118631);
                    return;
                }
                IAccessibilityManagerClientInvocationHandler iAccessibilityManagerClientInvocationHandler2 = new IAccessibilityManagerClientInvocationHandler();
                invoke = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls2}, iAccessibilityManagerClientInvocationHandler2);
                invoke = cls.getMethod("addClient", new Class[]{cls2, Integer.TYPE}).invoke(newProxyInstance, new Object[]{invoke});
                if (invoke != null && (invoke instanceof Integer)) {
                    mAPIProvider.i(TAG, "api <= 17 state: %d", Integer.valueOf(((Integer) invoke).intValue()));
                    updateState(intValue);
                }
                AppMethodBeat.o(118631);
            } catch (Throwable th) {
                mAPIProvider.printErrStackTrace(TAG, th, "exception:" + th.getMessage(), new Object[0]);
                mForwardEnable = true;
                AppMethodBeat.o(118631);
            }
        } catch (Exception e) {
            mAPIProvider.e(TAG, "fail to set IAccessibilityManager proxy", e);
            if (!mForwardEnable) {
                enableField.set(mManager, Boolean.FALSE);
            }
            AccessibilityCaptureNotSupportException accessibilityCaptureNotSupportException = new AccessibilityCaptureNotSupportException();
            AppMethodBeat.o(118631);
            throw accessibilityCaptureNotSupportException;
        }
    }

    @TargetApi(16)
    public static void enableAccessibilityCapture(Context context, APIProvider aPIProvider) {
        AppMethodBeat.i(118632);
        try {
            Field declaredField;
            mAPIProvider = aPIProvider;
            aPIProvider.d(TAG, "accessibility set up start time: %d", Long.valueOf(SystemClock.elapsedRealtime()));
            if (idField == null) {
                declaredField = View.class.getDeclaredField("mAccessibilityViewId");
                idField = declaredField;
                declaredField.setAccessible(true);
            }
            Class cls = AccessibilityManager.class;
            declaredField = cls.getDeclaredField("sInstance");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mLock");
            declaredField2.setAccessible(true);
            AccessibilityManager accessibilityManager = (AccessibilityManager) declaredField.get(null);
            mManager = accessibilityManager;
            if (accessibilityManager == null) {
                mManager = (AccessibilityManager) cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context.getApplicationContext()});
            }
            Object obj = declaredField2.get(mManager);
            if (obj == null) {
                mAPIProvider.i(TAG, "need to set enable,mLock is null.", new Object[0]);
                setAccessibilityEnable();
            } else {
                mAPIProvider.i(TAG, "need to set enable,mLock is not null.", new Object[0]);
                synchronized (obj) {
                    setAccessibilityEnable();
                }
            }
            mAPIProvider.d(TAG, "accessibility set up end time: %d", Long.valueOf(SystemClock.elapsedRealtime()));
            mAPIProvider.i(TAG, "accessibility enabled", new Object[0]);
            AppMethodBeat.o(118632);
        } catch (Throwable th) {
            mAPIProvider.printErrStackTrace(TAG, th, "failed to enable accessibility", new Object[0]);
            AppMethodBeat.o(118632);
        }
    }

    private static void notifyListeners(boolean z) {
        AppMethodBeat.i(118633);
        try {
            Field declaredField = AccessibilityManager.class.getDeclaredField("mAccessibilityStateChangeListeners");
            declaredField.setAccessible(true);
            Iterator it = ((CopyOnWriteArrayList) declaredField.get(mManager)).iterator();
            while (it.hasNext()) {
                ((AccessibilityStateChangeListener) it.next()).onAccessibilityStateChanged(z);
            }
            AppMethodBeat.o(118633);
        } catch (Throwable th) {
            AppMethodBeat.o(118633);
        }
    }

    @TargetApi(16)
    public static void disableAccessibilityCapture(Context context) {
        AppMethodBeat.i(118634);
        try {
            mAPIProvider.d(TAG, "accessibility set up start time: %d", Long.valueOf(SystemClock.elapsedRealtime()));
            Class cls = AccessibilityManager.class;
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("sInstance");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mLock");
            declaredField3.setAccessible(true);
            Object obj = (AccessibilityManager) declaredField2.get(null);
            if (obj == null) {
                obj = (AccessibilityManager) cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context.getApplicationContext()});
            }
            Object obj2 = declaredField3.get(mManager);
            Field declaredField4 = cls.getDeclaredField("mIsEnabled");
            declaredField4.setAccessible(true);
            if (obj2 == null) {
                mAPIProvider.i(TAG, "need to set disable,mLock is null.", new Object[0]);
                declaredField4.set(obj, Boolean.FALSE);
                if (iAccessibilityManagerInvocationHandler != null) {
                    declaredField.set(obj, iAccessibilityManagerInvocationHandler.getOriginalInstance());
                }
            } else {
                mAPIProvider.i(TAG, "need to set disable,mLock is not null.", new Object[0]);
                synchronized (obj2) {
                    declaredField4.set(obj, Boolean.FALSE);
                    if (iAccessibilityManagerInvocationHandler != null) {
                        declaredField.set(obj, iAccessibilityManagerInvocationHandler.getOriginalInstance());
                    }
                }
            }
            mEnable = false;
            mAPIProvider.d(TAG, "accessibility set up end time: %d", Long.valueOf(SystemClock.elapsedRealtime()));
            mAPIProvider.i(TAG, "accessibility disabled", new Object[0]);
            AppMethodBeat.o(118634);
        } catch (Throwable th) {
            mAPIProvider.printErrStackTrace(TAG, th, "failed to disable accessibility", new Object[0]);
            AppMethodBeat.o(118634);
        }
    }

    private static void post(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(118635);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        mAPIProvider.d(TAG, "[oneliang]before post event:event time" + accessibilityEvent.getEventTime() + ",elspsed time:" + elapsedRealtime, new Object[0]);
        mAPIProvider.post(new ViewSearchTask(accessibilityEvent, elapsedRealtime), "AccessibilityCapture search event's view");
        AppMethodBeat.o(118635);
    }

    private static boolean filter(AccessibilityEvent accessibilityEvent) {
        int i = 1;
        AppMethodBeat.i(118636);
        int eventType = accessibilityEvent.getEventType();
        boolean z = eventType == 1 || eventType == 2 || eventType == 4096 || eventType == 4 || eventType == Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (VERSION.SDK_INT >= 23) {
            if (eventType != 8388608) {
                i = 0;
            }
            z |= i;
        }
        AppMethodBeat.o(118636);
        return z;
    }

    private static boolean filterEventMerged(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(118637);
        if (accessibilityEvent.getEventTime() - lastEventTime < 1000 && accessibilityEvent.getEventType() == 4096) {
            AppMethodBeat.o(118637);
            return false;
        } else if (lastEventType == Utility.DEFAULT_STREAM_BUFFER_SIZE && accessibilityEvent.getEventType() == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            AppMethodBeat.o(118637);
            return false;
        } else {
            lastEventTime = accessibilityEvent.getEventTime();
            lastEventType = accessibilityEvent.getEventType();
            AppMethodBeat.o(118637);
            return true;
        }
    }

    private static void logTarget(AccessibilityEvent accessibilityEvent, View view, long j) {
        String str;
        AppMethodBeat.i(118638);
        Activity activityOfView = Util.getActivityOfView(view);
        APIProvider aPIProvider = mAPIProvider;
        String str2 = TAG;
        String str3 = "Event: %s, View's id: %s, Activity: %s, Time: %s";
        Object[] objArr = new Object[4];
        objArr[0] = AccessibilityEvent.eventTypeToString(accessibilityEvent.getEventType());
        objArr[1] = Util.getViewIdName(view).trim();
        if (activityOfView == null) {
            str = "unknown";
        } else {
            str = activityOfView.getClass().getName();
        }
        objArr[2] = str;
        objArr[3] = Long.valueOf(accessibilityEvent.getEventTime());
        aPIProvider.i(str2, str3, objArr);
        mAPIProvider.onEvent(new Event(accessibilityEvent, view, activityOfView, j));
        AppMethodBeat.o(118638);
    }

    private static void updateState(int i) {
        AppMethodBeat.i(118639);
        if ((i & 1) != 0) {
            notifyListeners(true);
            mForwardEnable = true;
            AppMethodBeat.o(118639);
            return;
        }
        mForwardEnable = false;
        AppMethodBeat.o(118639);
    }
}
