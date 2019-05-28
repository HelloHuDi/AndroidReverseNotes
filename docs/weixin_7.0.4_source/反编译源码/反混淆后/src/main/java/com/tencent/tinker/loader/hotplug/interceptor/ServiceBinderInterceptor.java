package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static Class<?> ADB;
    private static Field ADC;
    private static Method ADE;
    private final BinderInvocationHandler ADA;
    private final Context ADz;
    private final String bWb;

    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr);
    }

    static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler ADA;
        private final IBinder ADG;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.ADG = iBinder;
            this.ADA = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.ADG, objArr);
            }
            String interfaceDescriptor = this.ADG.getInterfaceDescriptor();
            if (interfaceDescriptor.equals("android.app.IActivityManager")) {
                interfaceDescriptor = "android.app.ActivityManagerNative";
            } else {
                interfaceDescriptor = interfaceDescriptor + "$Stub";
            }
            IInterface iInterface = (IInterface) ShareReflectUtil.m9398c(Class.forName(interfaceDescriptor), "asInterface", IBinder.class).invoke(null, new Object[]{this.ADG});
            return ServiceBinderInterceptor.m12658a(ServiceBinderInterceptor.m12659aK(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.ADA));
        }
    }

    static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler ADA;
        private final IBinder ADG;
        private final IInterface ADH;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.ADH = iInterface;
            this.ADG = iBinder;
            this.ADA = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("asBinder".equals(method.getName())) {
                return this.ADG;
            }
            return this.ADA.invoke(this.ADH, method, objArr);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: de */
    public final /* synthetic */ void mo12686de(Object obj) {
        IBinder iBinder = (IBinder) obj;
        ((Map) ADC.get(null)).put(this.bWb, iBinder);
        Field b;
        IInterface iInterface;
        if ("activity".equals(this.bWb)) {
            Object obj2;
            try {
                obj2 = ShareReflectUtil.m9400d(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
            } catch (Throwable th) {
                obj2 = ShareReflectUtil.m9400d(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
            }
            b = ShareReflectUtil.m9395b(obj2, "mInstance");
            iInterface = (IInterface) b.get(obj2);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(obj2, iInterface);
            }
        } else if ("package".equals(this.bWb)) {
            Context context = this.ADz;
            b = ShareReflectUtil.m9400d(Class.forName("android.app.ActivityThread"), "sPackageManager");
            iInterface = (IInterface) b.get(null);
            if (!(iInterface == null || ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass()))) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(null, iInterface);
            }
            b = ShareReflectUtil.m9400d(Class.forName("android.app.ApplicationPackageManager"), "mPM");
            PackageManager packageManager = context.getPackageManager();
            iInterface = (IInterface) b.get(packageManager);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(packageManager, iInterface);
            }
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: df */
    public final /* synthetic */ Object mo12687df(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            throw new IllegalStateException("target is null.");
        } else if (ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass())) {
            return iBinder;
        } else {
            return (IBinder) m12658a(m12659aK(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.ADA));
        }
    }

    static {
        ADB = null;
        ADC = null;
        ADE = null;
        synchronized (ServiceBinderInterceptor.class) {
            if (ADB == null) {
                try {
                    Class cls = Class.forName("android.os.ServiceManager");
                    ADB = cls;
                    ADC = ShareReflectUtil.m9400d(cls, "sCache");
                    ADE = ShareReflectUtil.m9398c(ADB, "getService", String.class);
                } catch (Throwable th) {
                }
            }
        }
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        Context context2 = context;
        while (context2 != null && (context2 instanceof ContextWrapper)) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        this.ADz = context2;
        this.bWb = str;
        this.ADA = binderInvocationHandler;
    }

    /* renamed from: a */
    private static <T> T m12658a(Class<?>[] clsArr, InvocationHandler invocationHandler) {
        Throwable th;
        Object obj;
        Class[] clsArr2 = new Class[(clsArr.length + 1)];
        System.arraycopy(clsArr, 0, clsArr2, 0, clsArr.length);
        clsArr2[clsArr.length] = ITinkerHotplugProxy.class;
        try {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), clsArr2, invocationHandler);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("cl: ".concat(String.valueOf(obj)), th);
        }
    }

    /* renamed from: aK */
    private static Class<?>[] m12659aK(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        HashSet hashSet = new HashSet(10);
        Object cls2;
        while (!Object.class.equals(cls2)) {
            hashSet.addAll(Arrays.asList(cls2.getInterfaces()));
            cls2 = cls2.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object dSm() {
        return (IBinder) ADE.invoke(null, new Object[]{this.bWb});
    }
}
