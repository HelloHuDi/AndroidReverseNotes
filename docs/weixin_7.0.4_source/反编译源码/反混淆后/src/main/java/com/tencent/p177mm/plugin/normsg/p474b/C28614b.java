package com.tencent.p177mm.plugin.normsg.p474b;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.plugin.normsg.b.b */
public final class C28614b {
    private static final ClassLoader oUb = C28614b.class.getClassLoader();
    private static final String oUc = C21394d.m32815TQ("\u001f~\u0010t\u0006i\u0000dJ<U0Gi\bk\bm\u001em\u0004f\u000fc\n~\u0007)`!B!D7D-O&J#W.c\u0002l\rj\u000f}Y\n~\u000bi");
    private static final String oUd = C21394d.m32815TQ("\u0011p\u001ez\bg\u000ejD+Xv%@2D-N+f\u0007i\bo\nx");
    private static final String oUe = C21394d.m32815TQ("\u0007t7V5]8");
    private static final String oUf = C21394d.m32815TQ("\u0017v\u0005L\"V3A'F%@");
    private static final String oUg = C21394d.m32815TQ("\ng$E)E'F%N");
    private static final String oUh = C21394d.m32815TQ("\u000ec5\\9N\u001cs\u001ch!L<P");
    private static final String oUi = C21394d.m32815TQ("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    private static final String oUj = C21394d.m32815TQ("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    private static final String oUk = C21394d.m32815TQ("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    private static final String oUl = C21394d.m32815TQ("\u001ak\u001e{\tp<S0Q=t\u001an\u000by\u001f~\u001dx");
    private static final String oUm = C21394d.m32815TQ("?Y0^:l\u0005`\u0017U,m\u000em\b{\ba\u0003j\u0006o\u001bb+O");
    private static final String oUn = C21394d.m32815TQ("+M$J.o\fo\ny\nc\u0001h\u0004m\u0019`.A%@\tg\u0001n,U\u0014w\u0014q\u0002q\u0018z\u0013\u0016b\u001bR6");
    private static final String oUo = C21394d.m32815TQ("!G.@$e\u0006e\u0000s\u0000i\u000bb\u000eg\u0013j$K/J\u0003m\u000bd&_\t`\u0005r;_");
    private static final String oUp = C21394d.m32815TQ("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    private static final String oUq = C21394d.m32815TQ("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    private static final String oUr = C21394d.m32815TQ("\rk\u0002l\bN!B7D");
    private static final String oUs = C21394d.m32815TQ("\"D+H=N\u001dx\u0019k\b`");
    private static final String oUt = C21394d.m32815TQ("m\u001dx\nl\u0003q\u001c]>]8K8Q3Z6_+R\u0013p\u0004m\u0002l");
    private static final String oUu = C21394d.m32815TQ("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    private static final String oUv = C21394d.m32815TQ("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    private static final String oUw = C21394d.m32815TQ("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    private volatile boolean eMP;
    private final Handler oUA;
    private IInterface oUB;
    public final Queue<C28613g> oUx;
    private final Map<Object, IBinder> oUy;
    private final Map<IBinder, Integer> oUz;

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$e */
    class C21389e implements InvocationHandler {
        protected final IInterface oUR;

        C21389e(IInterface iInterface) {
            this.oUR = iInterface;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.m2504i(10410);
            Object invoke;
            try {
                if ("asBinder".equals(method.getName())) {
                    IBinder asBinder = asBinder();
                    AppMethodBeat.m2505o(10410);
                    return asBinder;
                }
                invoke = method.invoke(this.oUR, objArr);
                AppMethodBeat.m2505o(10410);
                return invoke;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    AppMethodBeat.m2505o(10410);
                    throw targetException;
                }
                Class[] exceptionTypes = method.getExceptionTypes();
                if (exceptionTypes != null && exceptionTypes.length > 0) {
                    for (Class isAssignableFrom : method.getExceptionTypes()) {
                        if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                            AppMethodBeat.m2505o(10410);
                            throw targetException;
                        }
                    }
                }
                C28614b.m45448a(C28614b.this, targetException);
                invoke = C28614b.m45456c(method);
                AppMethodBeat.m2505o(10410);
                return invoke;
            } catch (Throwable th) {
                C28614b.m45448a(C28614b.this, th);
                invoke = C28614b.m45456c(method);
                AppMethodBeat.m2505o(10410);
                return invoke;
            }
        }

        public IBinder asBinder() {
            AppMethodBeat.m2504i(10411);
            IBinder asBinder = this.oUR.asBinder();
            AppMethodBeat.m2505o(10411);
            return asBinder;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$f */
    public static class C21390f extends Exception {
        C21390f(String str) {
            super(str);
        }

        C21390f(Throwable th) {
            super(th);
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$d */
    class C28612d extends Binder {
        protected final IBinder oUQ;

        C28612d(IBinder iBinder) {
            this.oUQ = iBinder;
        }

        public String getInterfaceDescriptor() {
            AppMethodBeat.m2504i(10402);
            String interfaceDescriptor;
            try {
                interfaceDescriptor = this.oUQ.getInterfaceDescriptor();
                AppMethodBeat.m2505o(10402);
                return interfaceDescriptor;
            } catch (RemoteException e) {
                interfaceDescriptor = "<failure>";
                AppMethodBeat.m2505o(10402);
                return interfaceDescriptor;
            }
        }

        public boolean pingBinder() {
            AppMethodBeat.m2504i(10403);
            boolean pingBinder = this.oUQ.pingBinder();
            AppMethodBeat.m2505o(10403);
            return pingBinder;
        }

        public boolean isBinderAlive() {
            AppMethodBeat.m2504i(10404);
            boolean isBinderAlive = this.oUQ.isBinderAlive();
            AppMethodBeat.m2505o(10404);
            return isBinderAlive;
        }

        public IInterface queryLocalInterface(String str) {
            return null;
        }

        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.m2504i(10405);
            try {
                this.oUQ.dump(fileDescriptor, strArr);
                AppMethodBeat.m2505o(10405);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(10405);
            }
        }

        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.m2504i(10406);
            try {
                this.oUQ.dumpAsync(fileDescriptor, strArr);
                AppMethodBeat.m2505o(10406);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(10406);
            }
        }

        /* Access modifiers changed, original: protected */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            AppMethodBeat.m2504i(10407);
            try {
                if (this.oUQ.isBinderAlive()) {
                    z = this.oUQ.transact(i, parcel, parcel2, i2);
                    AppMethodBeat.m2505o(10407);
                } else {
                    AppMethodBeat.m2505o(10407);
                }
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(10407);
                throw e;
            } catch (Throwable th) {
                C28614b.m45448a(C28614b.this, th);
                AppMethodBeat.m2505o(10407);
            }
            return z;
        }

        public void linkToDeath(DeathRecipient deathRecipient, int i) {
            AppMethodBeat.m2504i(10408);
            try {
                this.oUQ.linkToDeath(deathRecipient, i);
                AppMethodBeat.m2505o(10408);
            } catch (RemoteException e) {
                deathRecipient.binderDied();
                AppMethodBeat.m2505o(10408);
            }
        }

        public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
            AppMethodBeat.m2504i(10409);
            boolean unlinkToDeath = this.oUQ.unlinkToDeath(deathRecipient, i);
            AppMethodBeat.m2505o(10409);
            return unlinkToDeath;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$g */
    public interface C28613g {
        /* renamed from: a */
        void mo36840a(int i, View view, List<AccessibilityNodeInfo> list);

        /* renamed from: a */
        boolean mo36841a(int i, int i2, View view);

        void onError(Throwable th);
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$a */
    final class C28616a extends C28612d {
        private C28620i oUI = null;
        private WeakReference<Object> oUJ = null;

        C28616a(Object obj, IBinder iBinder) {
            super(iBinder);
            AppMethodBeat.m2504i(10392);
            try {
                this.oUJ = new WeakReference(obj);
                this.oUI = new C28620i(C43351h.findClass(C28614b.oUi + "$Stub"));
                AppMethodBeat.m2505o(10392);
            } catch (Throwable th) {
                C28614b.m45448a(C28614b.this, th);
                AppMethodBeat.m2505o(10392);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AppMethodBeat.m2504i(10393);
            boolean onTransact;
            if (i <= 0 || i > 16777215) {
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.m2505o(10393);
                return onTransact;
            } else if (this.oUI == null) {
                C4990ab.m7412e("MicroMsg.AED", "init failed, give up intercepting.");
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.m2505o(10393);
                return onTransact;
            } else if (this.oUJ.get() == null) {
                C4990ab.m7412e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.m2505o(10393);
                return onTransact;
            } else {
                String str = (String) this.oUI.bWn().get(i);
                try {
                    parcel.enforceInterface(C28614b.oUi);
                    int i3;
                    IBinder readStrongBinder;
                    IBinder readStrongBinder2;
                    if (C28614b.oUn.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUo.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUp.equals(str)) {
                        i3 = VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readString();
                        if (i3 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        readStrongBinder2 = parcel.readStrongBinder();
                        parcel.readInt();
                        C28614b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUq.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUr.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUs.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (C28614b.oUt.equals(str)) {
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
                        C28614b.this.oUz.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    C28614b.m45448a(C28614b.this, th);
                }
                onTransact = super.onTransact(i, parcel, parcel2, i2);
                AppMethodBeat.m2505o(10393);
                return onTransact;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$c */
    final class C28617c extends C21389e {
        private InvocationHandler oUO = new C286181();

        /* renamed from: com.tencent.mm.plugin.normsg.b.b$c$1 */
        class C286181 implements InvocationHandler {
            C286181() {
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object b;
                AppMethodBeat.m2504i(10398);
                synchronized (C28614b.this) {
                    String biF;
                    try {
                        String name = method.getName();
                        biF = C28614b.oUl;
                        if (biF.equals(name)) {
                            b = C28614b.this.oUB;
                        } else {
                            b = method.invoke(C28617c.this.oUR.asBinder(), objArr);
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
                        C28614b.m45448a(C28614b.this, biF);
                        b = C28614b.m45456c(method);
                        AppMethodBeat.m2505o(10398);
                    } catch (Throwable th) {
                        biF = C28614b.this;
                        C28614b.m45448a(biF, th);
                        b = C28614b.m45456c(method);
                    } finally {
                        AppMethodBeat.m2505o(10398);
                        throw biF;
                    }
                }
                return b;
            }
        }

        C28617c(IInterface iInterface) {
            super(iInterface);
            AppMethodBeat.m2504i(10399);
            AppMethodBeat.m2505o(10399);
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.m2504i(10400);
            if (C28614b.oUj.equals(method.getName()) && objArr != null && objArr.length >= 2) {
                Object obj2 = objArr[1];
                try {
                    if (C43351h.findClass(C28614b.oUi).isAssignableFrom(obj2.getClass())) {
                        WeakReference weakReference = (WeakReference) C43351h.m77372f(obj2, C28614b.oUh);
                        Object obj3 = weakReference.get();
                        if (obj3 == null) {
                            C4990ab.m7412e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                        } else {
                            Object obj4;
                            if (VERSION.SDK_INT < 16) {
                                obj4 = obj3;
                            } else {
                                obj4 = C43351h.m77372f(C43351h.m77368b(obj3, C28614b.oUk, null, new Object[0]), "mHandler");
                            }
                            Callback callback = (Callback) C43351h.m77372f(obj4, C28614b.oUg);
                            if (!(callback instanceof C28621b)) {
                                C43351h.m77370b(obj4, C28614b.oUg, new C28621b(obj3, callback));
                            }
                            synchronized (C28614b.this.oUy) {
                                IBinder iBinder = (IBinder) C28614b.this.oUy.get(obj3);
                                if (iBinder == null) {
                                    iBinder = new C28616a(weakReference.get(), ((IInterface) obj2).asBinder());
                                    C28614b.this.oUy.put(obj3, iBinder);
                                }
                                objArr[1] = (IInterface) C43351h.m77365a(C28614b.oUi + "$Stub", "asInterface", C43351h.m77371b(IBinder.class), iBinder);
                            }
                        }
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException("mismatched conn class: " + obj2.getClass() + ", give up intercepting.");
                        AppMethodBeat.m2505o(10400);
                        throw illegalStateException;
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    C28614b.m45448a(C28614b.this, th);
                    objArr[1] = obj2;
                }
            }
            Object invoke = super.invoke(obj, method, objArr);
            AppMethodBeat.m2505o(10400);
            return invoke;
        }

        public final IBinder asBinder() {
            AppMethodBeat.m2504i(10401);
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(C28614b.oUb, new Class[]{IBinder.class}, this.oUO);
            AppMethodBeat.m2505o(10401);
            return iBinder;
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$h */
    static final class C28619h {
        static final C28614b oUS = new C28614b();

        static {
            AppMethodBeat.m2504i(10412);
            AppMethodBeat.m2505o(10412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$i */
    final class C28620i implements IBinder {
        private final Class<?> oUT;
        private C12724a<String> oUU = null;
        private String oUV = null;

        /* renamed from: com.tencent.mm.plugin.normsg.b.b$i$a */
        final class C12724a<T> extends SparseArray<T> {
            private C12724a() {
            }

            /* synthetic */ C12724a(C28620i c28620i, byte b) {
                this();
            }

            public final void clear() {
                AppMethodBeat.m2504i(10413);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(10413);
                throw unsupportedOperationException;
            }

            public final void put(int i, T t) {
                AppMethodBeat.m2504i(10414);
                if (get(i) != null) {
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                    AppMethodBeat.m2505o(10414);
                    throw unsupportedOperationException;
                }
                super.put(i, t);
                AppMethodBeat.m2505o(10414);
            }
        }

        C28620i(Class<?> cls) {
            this.oUT = cls;
        }

        public final synchronized SparseArray<String> bWn() {
            SparseArray<String> sparseArray;
            AppMethodBeat.m2504i(10415);
            if (this.oUU != null) {
                sparseArray = this.oUU;
                AppMethodBeat.m2505o(10415);
            } else {
                this.oUU = new C12724a(this, (byte) 0);
                try {
                    IInterface iInterface = (IInterface) C43351h.m77367b(this.oUT, "asInterface", C43351h.m77371b(IBinder.class), this);
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
                    C4990ab.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    C28614b.m45448a(C28614b.this, th);
                    this.oUU.clear();
                }
                sparseArray = this.oUU;
                AppMethodBeat.m2505o(10415);
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
            AppMethodBeat.m2504i(10416);
            synchronized (this) {
                try {
                    if (this.oUU != null) {
                        this.oUU.put(i, this.oUV);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10416);
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

    /* renamed from: com.tencent.mm.plugin.normsg.b.b$b */
    final class C28621b implements Callback {
        private final WeakReference<Object> oUJ;
        private final Callback oUK;

        C28621b(Object obj, Callback callback) {
            AppMethodBeat.m2504i(10395);
            this.oUJ = new WeakReference(obj);
            this.oUK = callback;
            AppMethodBeat.m2505o(10395);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0086 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A:{Catch:{ Throwable -> 0x0204 }} */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0086 A:{Catch:{ Throwable -> 0x0204 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            boolean q;
            AppMethodBeat.m2504i(10396);
            Object obj = this.oUJ.get();
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                q = m45460q(message);
                AppMethodBeat.m2505o(10396);
                return q;
            }
            try {
                obj = (View) C43351h.m77368b(obj, "getView", null, new Object[0]);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.AED", "cannot find root view, give up intercepting.");
                    q = m45460q(message);
                    AppMethodBeat.m2505o(10396);
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
                        obj22 = (IInterface) C43351h.m77372f(message.obj, "arg1");
                    case 4:
                    case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                        obj22 = (IInterface) C43351h.m77372f(message.obj, "arg2");
                        if (obj22 == null) {
                            C4990ab.m7421w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", Integer.valueOf(message.what));
                            q = m45460q(message);
                            AppMethodBeat.m2505o(10396);
                            return q;
                        } else if (!Proxy.isProxyClass(obj22.getClass()) || !(Proxy.getInvocationHandler(obj22) instanceof C21389e)) {
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
                                            i = ((Integer) C43351h.m77372f(message.obj, "argi1")).intValue();
                                            break;
                                        case 5:
                                            i = ((Integer) C43351h.m77372f(message.obj, "argi2")).intValue();
                                            break;
                                        case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                            i = message.arg1;
                                            break;
                                        default:
                                            i = 0;
                                            break;
                                    }
                                    view = (View) C43351h.m77368b(obj, C28614b.oUm, C43351h.m77371b(Integer.TYPE), Integer.valueOf(i));
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
                                    intValue = ((Integer) C43351h.m77372f(message.obj, "argi3")).intValue();
                                    break;
                                case 3:
                                case 5:
                                    intValue = ((Integer) C43351h.m77372f(message.obj, "argi1")).intValue();
                                    break;
                                case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                                case 1022:
                                    intValue = message.arg2;
                                    break;
                                case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                    intValue = ((Integer) C43351h.m77372f(message.obj, "argi2")).intValue();
                                    break;
                                default:
                                    intValue = 0;
                                    break;
                            }
                            final Integer num = (Integer) C28614b.this.oUz.remove(obj22.asBinder());
                            if (num != null) {
                                switch (message.what) {
                                    case 1:
                                    case 1020:
                                        switch (message.what) {
                                            case 1:
                                            case 1020:
                                                i = ((Integer) C43351h.m77372f(message.obj, "argi2")).intValue();
                                                break;
                                            default:
                                                i = 0;
                                                break;
                                        }
                                        if (!C28614b.m45449a(C28614b.this, i, num.intValue(), view)) {
                                            C43351h.m77368b(obj22, C28614b.oUw, C43351h.m77371b(Boolean.TYPE, Integer.TYPE), Boolean.FALSE, Integer.valueOf(intValue));
                                            AppMethodBeat.m2505o(10396);
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
                                        IInterface iInterface = (IInterface) Proxy.newProxyInstance(C28614b.oUb, obj22.getClass().getInterfaces(), new C21389e(obj22) {
                                            public final Object invoke(Object obj, Method method, Object[] objArr) {
                                                AppMethodBeat.m2504i(10394);
                                                String name = method.getName();
                                                if (C28614b.oUu.equals(name)) {
                                                    List arrayList = new ArrayList();
                                                    if (objArr[0] != null) {
                                                        arrayList.add((AccessibilityNodeInfo) objArr[0]);
                                                    }
                                                    C28614b.m45447a(C28614b.this, num.intValue(), view, arrayList);
                                                    if (arrayList.isEmpty()) {
                                                        objArr[0] = null;
                                                    } else {
                                                        objArr[0] = arrayList.get(0);
                                                    }
                                                } else if (C28614b.oUv.equals(name)) {
                                                    List list = (List) objArr[0];
                                                    if (list == null) {
                                                        list = new ArrayList();
                                                    }
                                                    C28614b.m45447a(C28614b.this, num.intValue(), view, list);
                                                }
                                                Object invoke = super.invoke(obj, method, objArr);
                                                AppMethodBeat.m2505o(10394);
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
                                                C43351h.m77370b(message.obj, "arg1", iInterface);
                                                break;
                                            case 4:
                                            case FilterEnum4Shaka.MIC_SHAKA_ADD_4 /*1023*/:
                                                C43351h.m77370b(message.obj, "arg2", iInterface);
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
                            C4990ab.m7421w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", obj22.getClass().getName());
                            q = m45460q(message);
                            AppMethodBeat.m2505o(10396);
                            return q;
                        } else {
                            C4990ab.m7420w("MicroMsg.AED", "reused callback, skip rest works.");
                            q = m45460q(message);
                            AppMethodBeat.m2505o(10396);
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
                C28614b.m45448a(C28614b.this, th);
            }
            q = m45460q(message);
            AppMethodBeat.m2505o(10396);
            return q;
        }

        /* renamed from: q */
        private boolean m45460q(Message message) {
            AppMethodBeat.m2504i(10397);
            if (this.oUK != null) {
                boolean handleMessage = this.oUK.handleMessage(message);
                AppMethodBeat.m2505o(10397);
                return handleMessage;
            }
            AppMethodBeat.m2505o(10397);
            return false;
        }
    }

    /* synthetic */ C28614b(byte b) {
        this();
    }

    /* renamed from: b */
    static /* synthetic */ void m45453b(C28614b c28614b, Throwable th) {
        AppMethodBeat.m2504i(10430);
        c28614b.m45459k(th);
        AppMethodBeat.m2505o(10430);
    }

    static {
        AppMethodBeat.m2504i(10431);
        AppMethodBeat.m2505o(10431);
    }

    public static C28614b bWc() {
        return C28619h.oUS;
    }

    public final synchronized void initialize(Context context) {
        C21390f c21390f;
        try {
            AppMethodBeat.m2504i(10417);
            if (this.eMP) {
                AppMethodBeat.m2505o(10417);
            } else if (VERSION.SDK_INT < 15) {
                C21390f c21390f2 = new C21390f("unsupported system, api: " + VERSION.SDK_INT);
                AppMethodBeat.m2505o(10417);
                throw c21390f2;
            } else {
                IBinder iBinder = (IBinder) C43351h.m77365a(oUd, "getService", C43351h.m77371b(String.class), "accessibility");
                IInterface iInterface = (IInterface) C43351h.m77365a(oUc, oUf, C43351h.m77371b(IBinder.class), iBinder);
                this.oUB = (IInterface) Proxy.newProxyInstance(oUb, iInterface.getClass().getInterfaces(), new C28617c(iInterface));
                ((Map) C43351h.m77373fx(oUd, oUe)).put("accessibility", this.oUB.asBinder());
                try {
                    Object f;
                    Object b = C43351h.m77367b(AccessibilityManager.class, "getInstance", C43351h.m77371b(Context.class), context);
                    try {
                        f = C43351h.m77372f(b, "mLock");
                    } catch (Throwable th) {
                        f = null;
                    }
                    if (f != null) {
                        synchronized (f) {
                            C43351h.m77370b(b, "mService", this.oUB);
                        }
                    } else {
                        C43351h.m77370b(b, "mService", this.oUB);
                    }
                    this.eMP = true;
                    AppMethodBeat.m2505o(10417);
                } catch (Throwable th2) {
                    c21390f = new C21390f(th2);
                    AppMethodBeat.m2505o(10417);
                    throw c21390f;
                }
            }
        } catch (Throwable th22) {
            throw th22;
        }
    }

    public final synchronized void ensureInitialized() {
        AppMethodBeat.m2504i(10418);
        if (this.eMP) {
            AppMethodBeat.m2505o(10418);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("you must call initialize first.");
            AppMethodBeat.m2505o(10418);
            throw illegalStateException;
        }
    }

    /* renamed from: b */
    private void m45451b(int i, View view, List<AccessibilityNodeInfo> list) {
        AppMethodBeat.m2504i(10419);
        for (C28613g a : this.oUx) {
            a.mo36840a(i, view, (List) list);
        }
        AppMethodBeat.m2505o(10419);
    }

    /* renamed from: b */
    private boolean m45454b(int i, int i2, View view) {
        AppMethodBeat.m2504i(10420);
        boolean c;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c = m45458c(i, i2, view);
            AppMethodBeat.m2505o(10420);
            return c;
        }
        final boolean[] zArr = new boolean[]{true, false};
        final int i3 = i;
        final int i4 = i2;
        final View view2 = view;
        this.oUA.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(10390);
                zArr[0] = C28614b.m45455b(C28614b.this, i3, i4, view2);
                synchronized (zArr) {
                    try {
                        zArr[1] = true;
                        zArr.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(10390);
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
                    AppMethodBeat.m2505o(10420);
                }
            }
        }
        c = zArr[0];
        return c;
    }

    /* renamed from: c */
    private boolean m45458c(int i, int i2, View view) {
        AppMethodBeat.m2504i(10421);
        for (C28613g a : this.oUx) {
            if (!a.mo36841a(i, i2, view)) {
                AppMethodBeat.m2505o(10421);
                return false;
            }
        }
        AppMethodBeat.m2505o(10421);
        return true;
    }

    /* renamed from: k */
    private void m45459k(Throwable th) {
        AppMethodBeat.m2504i(10422);
        for (C28613g onError : this.oUx) {
            onError.onError(th);
        }
        AppMethodBeat.m2505o(10422);
    }

    private C28614b() {
        AppMethodBeat.m2504i(10423);
        this.oUx = new ConcurrentLinkedQueue();
        this.oUy = new WeakHashMap();
        this.oUz = new ConcurrentHashMap();
        this.oUA = new Handler(Looper.getMainLooper());
        this.oUB = null;
        this.eMP = false;
        AppMethodBeat.m2505o(10423);
    }

    /* renamed from: a */
    static /* synthetic */ void m45448a(C28614b c28614b, final Throwable th) {
        AppMethodBeat.m2504i(10424);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c28614b.m45459k(th);
            AppMethodBeat.m2505o(10424);
            return;
        }
        final boolean[] zArr = new boolean[]{false};
        c28614b.oUA.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(10391);
                C28614b.m45453b(C28614b.this, th);
                synchronized (zArr) {
                    try {
                        zArr[0] = true;
                        zArr.notifyAll();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(10391);
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
                    AppMethodBeat.m2505o(10424);
                }
            }
        }
    }
}
