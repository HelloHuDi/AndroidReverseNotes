package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C2080y;
import com.tencent.p177mm.plugin.appbrand.appstorage.C24685g;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ar */
public final class C2051ar implements InvocationHandler {
    private final Map<String, Method> gUD = new ConcurrentHashMap();
    private final C2052b gUE;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ar$b */
    static final class C2052b implements Closeable {
        private final C42361u gUF;
        private final Map<C45512ao, C2080y> gUG;

        /* synthetic */ C2052b(C42361u c42361u, byte b) {
            this(c42361u);
        }

        private C2052b(C42361u c42361u) {
            AppMethodBeat.m2504i(86802);
            this.gUG = new HashMap();
            this.gUF = c42361u;
            AppMethodBeat.m2505o(86802);
        }

        /* Access modifiers changed, original: final */
        public final Collection<C2080y> awi() {
            Collection<C2080y> values;
            AppMethodBeat.m2504i(86803);
            synchronized (this.gUG) {
                try {
                    values = this.gUG.values();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(86803);
                }
            }
            return values;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: xA */
        public final C2080y mo5819xA(String str) {
            C2080y c2080y = null;
            AppMethodBeat.m2504i(86804);
            if (this.gUF == null) {
                AppMethodBeat.m2505o(86804);
            } else {
                C45512ao findAppropriateModuleInfo = this.gUF.findAppropriateModuleInfo(str);
                if (findAppropriateModuleInfo == null) {
                    AppMethodBeat.m2505o(86804);
                } else {
                    synchronized (this.gUG) {
                        try {
                            c2080y = (C2080y) this.gUG.get(findAppropriateModuleInfo);
                            if (c2080y == null) {
                                Map map = this.gUG;
                                c2080y = new C2080y(findAppropriateModuleInfo);
                                map.put(findAppropriateModuleInfo, c2080y);
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(86804);
                        }
                    }
                }
            }
            return c2080y;
        }

        public final void close() {
            AppMethodBeat.m2504i(86805);
            synchronized (this.gUG) {
                try {
                    this.gUG.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(86805);
                    }
                }
            }
            if (this.gUF != null) {
                this.gUF.close();
            }
            AppMethodBeat.m2505o(86805);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ar$a */
    static final class C2053a extends C24685g implements IWxaFileSystemWithModularizing {
        private C2053a() {
        }

        /* synthetic */ C2053a(byte b) {
            this();
        }

        public final C45512ao findAppropriateModuleInfo(String str) {
            return null;
        }
    }

    /* renamed from: o */
    public static IWxaFileSystemWithModularizing m4211o(C6750i c6750i) {
        AppMethodBeat.m2504i(86806);
        IWxaFileSystemWithModularizing iWxaFileSystemWithModularizing;
        try {
            C2051ar c2051ar = new C2051ar(C33082aw.m54076q(c6750i));
            iWxaFileSystemWithModularizing = (IWxaFileSystemWithModularizing) Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[]{IWxaFileSystemWithModularizing.class}, c2051ar);
            AppMethodBeat.m2505o(86806);
            return iWxaFileSystemWithModularizing;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", e);
            iWxaFileSystemWithModularizing = new C2053a();
            AppMethodBeat.m2505o(86806);
            return iWxaFileSystemWithModularizing;
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.m2504i(86807);
        if (method.getReturnType().equals(Boolean.TYPE)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.m2505o(86807);
            return bool;
        } else if (Modifier.isStatic(method.getModifiers())) {
            AppMethodBeat.m2505o(86807);
            return null;
        } else {
            Object a;
            C2080y xA;
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                xA = this.gUE.mo5819xA((String) objArr[0]);
                if (xA == null) {
                    a = C2051ar.m4209a(method);
                    AppMethodBeat.m2505o(86807);
                    return a;
                } else if (method.getReturnType().equals(C45512ao.class)) {
                    a = xA.gTI;
                    AppMethodBeat.m2505o(86807);
                    return a;
                } else {
                    Method b = m4210b(method);
                    if (b != null) {
                        a = b.invoke(xA, objArr);
                        AppMethodBeat.m2505o(86807);
                        return a;
                    }
                }
            } else if (method.getReturnType().equals(Void.TYPE)) {
                Collection<C2080y> awi = this.gUE.awi();
                if (awi != null) {
                    Method b2 = m4210b(method);
                    if (b2 != null) {
                        for (C2080y xA2 : awi) {
                            b2.invoke(xA2, objArr);
                        }
                    }
                }
                AppMethodBeat.m2505o(86807);
                return null;
            }
            a = C2051ar.m4209a(method);
            AppMethodBeat.m2505o(86807);
            return a;
        }
    }

    /* renamed from: a */
    private static Object m4209a(Method method) {
        AppMethodBeat.m2504i(86808);
        if (method.getReturnType().equals(C45518j.class)) {
            C45518j c45518j = C45518j.ERR_PERMISSION_DENIED;
            AppMethodBeat.m2505o(86808);
            return c45518j;
        }
        AppMethodBeat.m2505o(86808);
        return null;
    }

    /* renamed from: b */
    private Method m4210b(Method method) {
        AppMethodBeat.m2504i(86809);
        String toGenericString = method.toGenericString();
        Method method2 = (Method) this.gUD.get(toGenericString);
        if (method2 == null) {
            method2 = C2080y.class.getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                this.gUD.put(toGenericString, method2);
            }
        }
        AppMethodBeat.m2505o(86809);
        return method2;
    }

    private C2051ar(C42361u c42361u) {
        AppMethodBeat.m2504i(86810);
        this.gUE = new C2052b(c42361u, (byte) 0);
        AppMethodBeat.m2505o(86810);
    }
}
