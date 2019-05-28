package com.tencent.mm.plugin.normsg.b;

import android.content.Context;
import android.graphics.Region;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b {
    private static final ClassLoader oUb = b.class.getClassLoader();
    private static final String oUc = d.TQ("\u001f~\u0010t\u0006i\u0000dJ<U0Gi\bk\bm\u001em\u0004f\u000fc\n~\u0007)`!B!D7D-O&J#W.c\u0002l\rj\u000f}Y\n~\u000bi");
    private static final String oUd = d.TQ("\u0011p\u001ez\bg\u000ejD+Xv%@2D-N+f\u0007i\bo\nx");
    private static final String oUe = d.TQ("\u0007t7V5]8");
    private static final String oUf = d.TQ("\u0017v\u0005L\"V3A'F%@");
    private static final String oUg = d.TQ("\ng$E)E'F%N");
    private static final String oUh = d.TQ("\u000ec5\\9N\u001cs\u001ch!L<P");
    private static final String oUi = d.TQ("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    private static final String oUj = d.TQ("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    private static final String oUk = d.TQ("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    private static final String oUl = d.TQ("\u001ak\u001e{\tp<S0Q=t\u001an\u000by\u001f~\u001dx");
    private static final String oUm = d.TQ("?Y0^:l\u0005`\u0017U,m\u000em\b{\ba\u0003j\u0006o\u001bb+O");
    private static final String oUn = d.TQ("+M$J.o\fo\ny\nc\u0001h\u0004m\u0019`.A%@\tg\u0001n,U\u0014w\u0014q\u0002q\u0018z\u0013\u0016b\u001bR6");
    private static final String oUo = d.TQ("!G.@$e\u0006e\u0000s\u0000i\u000bb\u000eg\u0013j$K/J\u0003m\u000bd&_\t`\u0005r;_");
    private static final String oUp = d.TQ("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    private static final String oUq = d.TQ("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    private static final String oUr = d.TQ("\rk\u0002l\bN!B7D");
    private static final String oUs = d.TQ("\"D+H=N\u001dx\u0019k\b`");
    private static final String oUt = d.TQ("m\u001dx\nl\u0003q\u001c]>]8K8Q3Z6_+R\u0013p\u0004m\u0002l");
    private static final String oUu = d.TQ("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    private static final String oUv = d.TQ("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    private static final String oUw = d.TQ("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    private volatile boolean eMP;
    private final Handler oUA;
    private IInterface oUB;
    public final Queue<g> oUx;
    private final Map<Object, IBinder> oUy;
    private final Map<IBinder, Integer> oUz;

    class e implements InvocationHandler {
        protected final IInterface oUR;

        e(IInterface iInterface) {
            this.oUR = iInterface;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(10410);
            Object invoke;
            try {
                if ("asBinder".equals(method.getName())) {
                    IBinder asBinder = asBinder();
                    AppMethodBeat.o(10410);
                    return asBinder;
                }
                invoke = method.invoke(this.oUR, objArr);
                AppMethodBeat.o(10410);
                return invoke;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    AppMethodBeat.o(10410);
                    throw targetException;
                }
                Class[] exceptionTypes = method.getExceptionTypes();
                if (exceptionTypes != null && exceptionTypes.length > 0) {
                    for (Class isAssignableFrom : method.getExceptionTypes()) {
                        if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                            AppMethodBeat.o(10410);
                            throw targetException;
                        }
                    }
                }
                b.a(b.this, targetException);
                invoke = b.c(method);
                AppMethodBeat.o(10410);
                return invoke;
            } catch (Throwable th) {
                b.a(b.this, th);
                invoke = b.c(method);
                AppMethodBeat.o(10410);
                return invoke;
            }
        }

        public IBinder asBinder() {
            AppMethodBeat.i(10411);
            IBinder asBinder = this.oUR.asBinder();
            AppMethodBeat.o(10411);
            return asBinder;
        }
    }

    public static class f extends Exception {
        f(String str) {
            super(str);
        }

        f(Throwable th) {
            super(th);
        }
    }

    class d extends Binder {
        protected final IBinder oUQ;

        d(IBinder iBinder) {
            this.oUQ = iBinder;
        }

        public String getInterfaceDescriptor() {
            AppMethodBeat.i(10402);
            String interfaceDescriptor;
            try {
                interfaceDescriptor = this.oUQ.getInterfaceDescriptor();
                AppMethodBeat.o(10402);
                return interfaceDescriptor;
            } catch (RemoteException e) {
                interfaceDescriptor = "<failure>";
                AppMethodBeat.o(10402);
                return interfaceDescriptor;
            }
        }

        public boolean pingBinder() {
            AppMethodBeat.i(10403);
            boolean pingBinder = this.oUQ.pingBinder();
            AppMethodBeat.o(10403);
            return pingBinder;
        }

        public boolean isBinderAlive() {
            AppMethodBeat.i(10404);
            boolean isBinderAlive = this.oUQ.isBinderAlive();
            AppMethodBeat.o(10404);
            return isBinderAlive;
        }

        public IInterface queryLocalInterface(String str) {
            return null;
        }

        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.i(10405);
            try {
                this.oUQ.dump(fileDescriptor, strArr);
                AppMethodBeat.o(10405);
            } catch (RemoteException e) {
                AppMethodBeat.o(10405);
            }
        }

        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.i(10406);
            try {
                this.oUQ.dumpAsync(fileDescriptor, strArr);
                AppMethodBeat.o(10406);
            } catch (RemoteException e) {
                AppMethodBeat.o(10406);
            }
        }

        /* Access modifiers changed, original: protected */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            AppMethodBeat.i(10407);
            try {
                if (this.oUQ.isBinderAlive()) {
                    z = this.oUQ.transact(i, parcel, parcel2, i2);
                    AppMethodBeat.o(10407);
                } else {
                    AppMethodBeat.o(10407);
                }
            } catch (RemoteException e) {
                AppMethodBeat.o(10407);
                throw e;
            } catch (Throwable th) {
                b.a(b.this, th);
                AppMethodBeat.o(10407);
            }
            return z;
        }

        public void linkToDeath(DeathRecipient deathRecipient, int i) {
            AppMethodBeat.i(10408);
            try {
                this.oUQ.linkToDeath(deathRecipient, i);
                AppMethodBeat.o(10408);
            } catch (RemoteException e) {
                deathRecipient.binderDied();
                AppMethodBeat.o(10408);
            }
        }

        public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            AppMethodBeat.i(10409);
            boolean unlinkToDeath = this.oUQ.unlinkToDeath(deathRecipient, i);
            AppMethodBeat.o(10409);
            return unlinkToDeath;
        }
    }

    public interface g {
        void a(int i, View view, List<AccessibilityNodeInfo> list);

        boolean a(int i, int i2, View view);

        void onError(Throwable th);
    }

    final class a extends d {
        private i oUI = null;
        private WeakReference<Object> oUJ = null;

        a(Object obj, IBinder iBinder) {
            super(iBinder);
            AppMethodBeat.i(10392);
            try {
                this.oUJ = new WeakReference(obj);
                this.oUI = new i(h.findClass(b.oUi + "$Stub"));
                AppMethodBeat.o(10392);
            } catch (Throwable th) {
                b.a(b.this, th);
                AppMethodBeat.o(10392);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AppMethodBeat.i(10393);
            boolean onTransact;
            if (i <= 0 || i > 16777215) {
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.o(10393);
                return onTransact;
            } else if (this.oUI == null) {
                ab.e("MicroMsg.AED", "init failed, give up intercepting.");
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.o(10393);
                return onTransact;
            } else if (this.oUJ.get() == null) {
                ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.o(10393);
                return onTransact;
            } else {
                String str = (String) this.oUI.bWn().get(i);
                try {
                    parcel.enforceInterface(b.oUi);
                    int i3;
                    IBinder readStrongBinder;
                    IBinder readStrongBinder2;
                    if (b.oUn.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        if (i3 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        if (i3 >= 16 && i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i3 >= 21) {
                            if (parcel.readInt() != 0) {
                                Region.CREATOR.createFromParcel(parcel);
                            }
                        }
                        parcel.readInt();
                        readStrongBinder = parcel.readStrongBinder();
                        if (i3 >= 16) {
                            parcel.readInt();
                        }
                        b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUo.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        if (i3 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        if (i3 >= 16) {
                            parcel.readInt();
                            if (i3 < 17) {
                                parcel.readInt();
                                parcel.readInt();
                            }
                        }
                        parcel.readInt();
                        readStrongBinder = parcel.readStrongBinder();
                        if (i3 >= 16) {
                            parcel.readInt();
                        }
                        b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUp.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readString();
                        if (i3 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder2 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUq.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readString();
                        if (i3 >= 16 && i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i3 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder2 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUr.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readInt();
                        if (i3 >= 16 && i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i3 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder2 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUs.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readInt();
                        if (i3 >= 16 && i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i3 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder2 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (b.oUt.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        if (i3 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        parcel.readInt();
                        if (i3 >= 16 && parcel.readInt() != 0) {
                            Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder = parcel.readStrongBinder();
                        if (i3 >= 16) {
                            parcel.readInt();
                        }
                        b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    }
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                }
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.o(10393);
                return onTransact;
            }
        }
    }

    final class c extends e {
        private InvocationHandler oUO = new InvocationHandler() {
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object b;
                AppMethodBeat.i(10398);
                synchronized (b.this) {
                    String biF;
                    try {
                        String name = method.getName();
                        biF = b.oUl;
                        if (biF.equals(name)) {
                            b = b.this.oUB;
                        } else {
                            b = method.invoke(c.this.oUR.asBinder(), objArr);
                        }
                    } catch (InvocationTargetException e) {
                        biF = e.getTargetException();
                        Class[] exceptionTypes = method.getExceptionTypes();
                        if (exceptionTypes != null && exceptionTypes.length > 0) {
                            for (Class isAssignableFrom : method.getExceptionTypes()) {
                                if (isAssignableFrom.isAssignableFrom(biF.getClass())) {
                                    throw biF;
                                }
                            }
                        }
                        b.a(b.this, biF);
                        b = b.c(method);
                        AppMethodBeat.o(10398);
                    } catch (Throwable th) {
                        biF = b.this;
                        b.a(biF, th);
                        b = b.c(method);
                    } finally {
                        AppMethodBeat.o(10398);
                        throw biF;
                    }
                }
                return b;
            }
        };

        c(IInterface iInterface) {
            super(iInterface);
            AppMethodBeat.i(10399);
            AppMethodBeat.o(10399);
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(10400);
            if (b.oUj.equals(method.getName()) && objArr != null && objArr.length >= 2) {
                Object obj2 = objArr[1];
                try {
                    if (h.findClass(b.oUi).isAssignableFrom(obj2.getClass())) {
                        WeakReference weakReference = (WeakReference) h.f(obj2, b.oUh);
                        Object obj3 = weakReference.get();
                        if (obj3 == null) {
                            ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                        } else {
                            Object obj4;
                            if (VERSION.SDK_INT < 16) {
                                obj4 = obj3;
                            } else {
                                obj4 = h.f(h.b(obj3, b.oUk, null, new Object[0]), "mHandler");
                            }
                            Callback callback = (Callback) h.f(obj4, b.oUg);
                            if (!(callback instanceof b)) {
                                h.b(obj4, b.oUg, new b(obj3, callback));
                            }
                            synchronized (b.this.oUy) {
                                IBinder iBinder = (IBinder) b.this.oUy.get(obj3);
                                if (iBinder == null) {
                                    iBinder = new a(weakReference.get(), ((IInterface) obj2).asBinder());
                                    b.this.oUy.put(obj3, iBinder);
                                }
                                objArr[1] = (IInterface) h.a(b.oUi + "$Stub", "asInterface", h.b(IBinder.class), iBinder);
                            }
                        }
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException("mismatched conn class: " + obj2.getClass() + ", give up intercepting.");
                        AppMethodBeat.o(10400);
                        throw illegalStateException;
                    }
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                    objArr[1] = obj2;
                }
            }
            Object invoke = super.invoke(obj, method, objArr);
            AppMethodBeat.o(10400);
            return invoke;
        }

        public final IBinder asBinder() {
            AppMethodBeat.i(10401);
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(b.oUb, new Class[]{IBinder.class}, this.oUO);
            AppMethodBeat.o(10401);
            return iBinder;
        }
    }

    static final class h {
        static final b oUS = new b();

        static {
            AppMethodBeat.i(10412);
            AppMethodBeat.o(10412);
        }
    }

    final class i implements IBinder {
        private final Class<?> oUT;
        private a<String> oUU = null;
        private String oUV = null;

        final class a<T> extends SparseArray<T> {
            private a() {
            }

            /* synthetic */ a(i iVar, byte b) {
                this();
            }

            public final void clear() {
                AppMethodBeat.i(10413);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(10413);
                throw unsupportedOperationException;
            }

            public final void put(int i, T t) {
                AppMethodBeat.i(10414);
                if (get(i) != null) {
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                    AppMethodBeat.o(10414);
                    throw unsupportedOperationException;
                }
                super.put(i, t);
                AppMethodBeat.o(10414);
            }
        }

        i(Class<?> cls) {
            this.oUT = cls;
        }

        public final synchronized SparseArray<String> bWn() {
            SparseArray<String> sparseArray;
            AppMethodBeat.i(10415);
            if (this.oUU != null) {
                sparseArray = this.oUU;
                AppMethodBeat.o(10415);
            } else {
                this.oUU = new a(this, (byte) 0);
                try {
                    IInterface iInterface = (IInterface) h.b(this.oUT, "asInterface", h.b(IBinder.class), this);
                    for (Class cls : this.oUT.getInterfaces()) {
                        if (IInterface.class.isAssignableFrom(cls)) {
                            for (Method method : cls.getDeclaredMethods()) {
                                if (!"asBinder".equals(method.getName())) {
                                    this.oUV = method.getName();
                                    if (!method.isAccessible()) {
                                        method.setAccessible(true);
                                    }
                                    Class[] parameterTypes = method.getParameterTypes();
                                    int length = parameterTypes.length;
                                    Object[] objArr = new Object[length];
                                    for (int i = 0; i < length; i++) {
                                        Class cls2 = parameterTypes[i];
                                        if (cls2.isPrimitive()) {
                                            if (Boolean.TYPE.isAssignableFrom(cls2)) {
                                                objArr[i] = Boolean.FALSE;
                                            } else {
                                                objArr[i] = Integer.valueOf(0);
                                            }
                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Integer.valueOf(0);
                                        } else if (Character.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Character.valueOf(0);
                                        } else if (Boolean.class.isAssignableFrom(cls2)) {
                                            objArr[i] = Boolean.FALSE;
                                        } else {
                                            objArr[i] = null;
                                        }
                                    }
                                    method.invoke(iInterface, objArr);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                    this.oUU.clear();
                }
                sparseArray = this.oUU;
                AppMethodBeat.o(10415);
            }
            return sparseArray;
        }

        public final String getInterfaceDescriptor() {
            return null;
        }

        public final boolean pingBinder() {
            return false;
        }

        public final boolean isBinderAlive() {
            return false;
        }

        public final IInterface queryLocalInterface(String str) {
            return null;
        }

        public final void dump(FileDescriptor fileDescriptor, String[] strArr) {
        }

        public final void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        }

        public final boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AppMethodBeat.i(10416);
            synchronized (this) {
                try {
                    if (this.oUU != null) {
                        this.oUU.put(i, this.oUV);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10416);
                }
            }
            return false;
        }

        public final void linkToDeath(DeathRecipient deathRecipient, int i) {
        }

        public final boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            return false;
        }
    }

    final class b implements Callback {
        private final WeakReference<Object> oUJ;
        private final Callback oUK;

        b(Object obj, Callback callback) {
            AppMethodBeat.i(10395);
            this.oUJ = new WeakReference(obj);
            this.oUK = callback;
            AppMethodBeat.o(10395);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0086 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0086 A:{Catch:{ Throwable -> 0x0204 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            boolean q;
            AppMethodBeat.i(10396);
            Object obj = this.oUJ.get();
            if (obj == null) {
                ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                q = q(message);
                AppMethodBeat.o(10396);
                return q;
            }
            try {
                obj = (View) h.b(obj, "getView", null, new Object[0]);
                if (obj == null) {
                    ab.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
                    q = q(message);
                    AppMethodBeat.o(10396);
                    return q;
                }
                Object obj2;
                IInterface obj22;
                switch (message.what) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 1020:
                        obj22 = (IInterface) h.f(message.obj, "arg1");
                    case 4:
                    case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                        obj22 = (IInterface) h.f(message.obj, "arg2");
                        if (obj22 == null) {
                            ab.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", Integer.valueOf(message.what));
                            q = q(message);
                            AppMethodBeat.o(10396);
                            return q;
                        } else if (!Proxy.isProxyClass(obj22.getClass()) || !(Proxy.getInvocationHandler(obj22) instanceof e)) {
                            int i;
                            View view;
                            int intValue;
                            switch (message.what) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 1020:
                                case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                    switch (message.what) {
                                        case 1:
                                        case 3:
                                        case 6:
                                            i = message.arg2;
                                            break;
                                        case 2:
                                        case 4:
                                        case 1020:
                                        case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                            i = ((Integer) h.f(message.obj, "argi1")).intValue();
                                            break;
                                        case 5:
                                            i = ((Integer) h.f(message.obj, "argi2")).intValue();
                                            break;
                                        case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                            i = message.arg1;
                                            break;
                                        default:
                                            i = 0;
                                            break;
                                    }
                                    view = (View) h.b(obj, b.oUm, h.b(Integer.TYPE), Integer.valueOf(i));
                                case 1022:
                                    if (message.what == 1022) {
                                        i = message.arg1;
                                    } else {
                                        i = 0;
                                    }
                                    view = obj.findViewById(i);
                                default:
                                    view = null;
                            }
                            switch (message.what) {
                                case 1:
                                case 2:
                                case 4:
                                case 6:
                                case 1020:
                                    intValue = ((Integer) h.f(message.obj, "argi3")).intValue();
                                    break;
                                case 3:
                                case 5:
                                    intValue = ((Integer) h.f(message.obj, "argi1")).intValue();
                                    break;
                                case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                case 1022:
                                    intValue = message.arg2;
                                    break;
                                case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                    intValue = ((Integer) h.f(message.obj, "argi2")).intValue();
                                    break;
                                default:
                                    intValue = 0;
                                    break;
                            }
                            final Integer num = (Integer) b.this.oUz.remove(obj22.asBinder());
                            if (num != null) {
                                switch (message.what) {
                                    case 1:
                                    case 1020:
                                        switch (message.what) {
                                            case 1:
                                            case 1020:
                                                i = ((Integer) h.f(message.obj, "argi2")).intValue();
                                                break;
                                            default:
                                                i = 0;
                                                break;
                                        }
                                        if (!b.a(b.this, i, num.intValue(), view)) {
                                            h.b(obj22, b.oUw, h.b(Boolean.TYPE, Integer.TYPE), Boolean.FALSE, Integer.valueOf(intValue));
                                            AppMethodBeat.o(10396);
                                            return true;
                                        }
                                        break;
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                    case 1022:
                                    case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                        IInterface iInterface = (IInterface) Proxy.newProxyInstance(b.oUb, obj22.getClass().getInterfaces(), new e(obj22) {
                                            public final Object invoke(Object obj, Method method, Object[] objArr) {
                                                AppMethodBeat.i(10394);
                                                String name = method.getName();
                                                if (b.oUu.equals(name)) {
                                                    List arrayList = new ArrayList();
                                                    if (objArr[0] != null) {
                                                        arrayList.add((AccessibilityNodeInfo) objArr[0]);
                                                    }
                                                    b.a(b.this, num.intValue(), view, arrayList);
                                                    if (arrayList.isEmpty()) {
                                                        objArr[0] = null;
                                                    } else {
                                                        objArr[0] = arrayList.get(0);
                                                    }
                                                } else if (b.oUv.equals(name)) {
                                                    List list = (List) objArr[0];
                                                    if (list == null) {
                                                        list = new ArrayList();
                                                    }
                                                    b.a(b.this, num.intValue(), view, list);
                                                }
                                                Object invoke = super.invoke(obj, method, objArr);
                                                AppMethodBeat.o(10394);
                                                return invoke;
                                            }
                                        });
                                        switch (message.what) {
                                            case 1:
                                            case 2:
                                            case 3:
                                            case 5:
                                            case 6:
                                            case 1020:
                                                h.b(message.obj, "arg1", iInterface);
                                                break;
                                            case 4:
                                            case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                                h.b(message.obj, "arg2", iInterface);
                                                break;
                                            case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                            case 1022:
                                                message.obj = iInterface;
                                                break;
                                            default:
                                                break;
                                        }
                                }
                            }
                            ab.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", obj22.getClass().getName());
                            q = q(message);
                            AppMethodBeat.o(10396);
                            return q;
                        } else {
                            ab.w("MicroMsg.AED", "reused callback, skip rest works.");
                            q = q(message);
                            AppMethodBeat.o(10396);
                            return q;
                        }
                        break;
                    case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                    case 1022:
                        obj22 = (IInterface) message.obj;
                        if (obj22 == null) {
                        }
                        break;
                    default:
                        obj22 = null;
                }
                if (obj22 == null) {
                }
            } catch (Throwable th) {
                b.a(b.this, th);
            }
            q = q(message);
            AppMethodBeat.o(10396);
            return q;
        }

        private boolean q(Message message) {
            AppMethodBeat.i(10397);
            if (this.oUK != null) {
                boolean handleMessage = this.oUK.handleMessage(message);
                AppMethodBeat.o(10397);
                return handleMessage;
            }
            AppMethodBeat.o(10397);
            return false;
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    static /* synthetic */ void b(b bVar, Throwable th) {
        AppMethodBeat.i(10430);
        bVar.k(th);
        AppMethodBeat.o(10430);
    }

    static {
        AppMethodBeat.i(10431);
        AppMethodBeat.o(10431);
    }

    public static b bWc() {
        return h.oUS;
    }

    public final synchronized void initialize(Context context) {
        f fVar;
        try {
            AppMethodBeat.i(10417);
            if (this.eMP) {
                AppMethodBeat.o(10417);
            } else if (VERSION.SDK_INT < 15) {
                f fVar2 = new f("unsupported system, api: " + VERSION.SDK_INT);
                AppMethodBeat.o(10417);
                throw fVar2;
            } else {
                IBinder iBinder = (IBinder) h.a(oUd, "getService", h.b(String.class), "accessibility");
                IInterface iInterface = (IInterface) h.a(oUc, oUf, h.b(IBinder.class), iBinder);
                this.oUB = (IInterface) Proxy.newProxyInstance(oUb, iInterface.getClass().getInterfaces(), new c(iInterface));
                ((Map) h.fx(oUd, oUe)).put("accessibility", this.oUB.asBinder());
                try {
                    Object f;
                    Object b = h.b(AccessibilityManager.class, "getInstance", h.b(Context.class), context);
                    try {
                        f = h.f(b, "mLock");
                    } catch (Throwable th) {
                        f = null;
                    }
                    if (f != null) {
                        synchronized (f) {
                            h.b(b, "mService", this.oUB);
                        }
                    } else {
                        h.b(b, "mService", this.oUB);
                    }
                    this.eMP = true;
                    AppMethodBeat.o(10417);
                } catch (Throwable th2) {
                    fVar = new f(th2);
                    AppMethodBeat.o(10417);
                    throw fVar;
                }
            }
        } catch (Throwable th22) {
            throw th22;
        }
    }

    public final synchronized void ensureInitialized() {
        AppMethodBeat.i(10418);
        if (this.eMP) {
            AppMethodBeat.o(10418);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("you must call initialize first.");
            AppMethodBeat.o(10418);
            throw illegalStateException;
        }
    }

    private void b(int i, View view, List<AccessibilityNodeInfo> list) {
        AppMethodBeat.i(10419);
        for (g a : this.oUx) {
            a.a(i, view, (List) list);
        }
        AppMethodBeat.o(10419);
    }

    private boolean b(int i, int i2, View view) {
        AppMethodBeat.i(10420);
        boolean c;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c = c(i, i2, view);
            AppMethodBeat.o(10420);
            return c;
        }
        final boolean[] zArr = new boolean[]{true, false};
        final int i3 = i;
        final int i4 = i2;
        final View view2 = view;
        this.oUA.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10390);
                zArr[0] = b.b(b.this, i3, i4, view2);
                synchronized (zArr) {
                    try {
                        zArr[1] = true;
                        zArr.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(10390);
                    }
                }
            }
        });
        synchronized (zArr) {
            while (!zArr[1]) {
                try {
                    try {
                        zArr.wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10420);
                }
            }
        }
        c = zArr[0];
        return c;
    }

    private boolean c(int i, int i2, View view) {
        AppMethodBeat.i(10421);
        for (g a : this.oUx) {
            if (!a.a(i, i2, view)) {
                AppMethodBeat.o(10421);
                return false;
            }
        }
        AppMethodBeat.o(10421);
        return true;
    }

    private void k(Throwable th) {
        AppMethodBeat.i(10422);
        for (g onError : this.oUx) {
            onError.onError(th);
        }
        AppMethodBeat.o(10422);
    }

    private b() {
        AppMethodBeat.i(10423);
        this.oUx = new ConcurrentLinkedQueue();
        this.oUy = new WeakHashMap();
        this.oUz = new ConcurrentHashMap();
        this.oUA = new Handler(Looper.getMainLooper());
        this.oUB = null;
        this.eMP = false;
        AppMethodBeat.o(10423);
    }

    static /* synthetic */ void a(b bVar, final Throwable th) {
        AppMethodBeat.i(10424);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.k(th);
            AppMethodBeat.o(10424);
            return;
        }
        final boolean[] zArr = new boolean[]{false};
        bVar.oUA.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10391);
                b.b(b.this, th);
                synchronized (zArr) {
                    try {
                        zArr[0] = true;
                        zArr.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(10391);
                    }
                }
            }
        });
        synchronized (zArr) {
            while (!zArr[0]) {
                try {
                    try {
                        zArr.wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10424);
                }
            }
        }
    }
}
