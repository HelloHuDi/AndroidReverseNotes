package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ar implements InvocationHandler {
    private final Map<String, Method> gUD = new ConcurrentHashMap();
    private final b gUE;

    static final class b implements Closeable {
        private final u gUF;
        private final Map<ao, y> gUG;

        /* synthetic */ b(u uVar, byte b) {
            this(uVar);
        }

        private b(u uVar) {
            AppMethodBeat.i(86802);
            this.gUG = new HashMap();
            this.gUF = uVar;
            AppMethodBeat.o(86802);
        }

        /* Access modifiers changed, original: final */
        public final Collection<y> awi() {
            Collection<y> values;
            AppMethodBeat.i(86803);
            synchronized (this.gUG) {
                try {
                    values = this.gUG.values();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(86803);
                }
            }
            return values;
        }

        /* Access modifiers changed, original: final */
        public final y xA(String str) {
            y yVar = null;
            AppMethodBeat.i(86804);
            if (this.gUF == null) {
                AppMethodBeat.o(86804);
            } else {
                ao findAppropriateModuleInfo = this.gUF.findAppropriateModuleInfo(str);
                if (findAppropriateModuleInfo == null) {
                    AppMethodBeat.o(86804);
                } else {
                    synchronized (this.gUG) {
                        try {
                            yVar = (y) this.gUG.get(findAppropriateModuleInfo);
                            if (yVar == null) {
                                Map map = this.gUG;
                                yVar = new y(findAppropriateModuleInfo);
                                map.put(findAppropriateModuleInfo, yVar);
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(86804);
                        }
                    }
                }
            }
            return yVar;
        }

        public final void close() {
            AppMethodBeat.i(86805);
            synchronized (this.gUG) {
                try {
                    this.gUG.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(86805);
                    }
                }
            }
            if (this.gUF != null) {
                this.gUF.close();
            }
            AppMethodBeat.o(86805);
        }
    }

    static final class a extends g implements IWxaFileSystemWithModularizing {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final ao findAppropriateModuleInfo(String str) {
            return null;
        }
    }

    public static IWxaFileSystemWithModularizing o(i iVar) {
        AppMethodBeat.i(86806);
        IWxaFileSystemWithModularizing iWxaFileSystemWithModularizing;
        try {
            ar arVar = new ar(aw.q(iVar));
            iWxaFileSystemWithModularizing = (IWxaFileSystemWithModularizing) Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[]{IWxaFileSystemWithModularizing.class}, arVar);
            AppMethodBeat.o(86806);
            return iWxaFileSystemWithModularizing;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", e);
            iWxaFileSystemWithModularizing = new a();
            AppMethodBeat.o(86806);
            return iWxaFileSystemWithModularizing;
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        AppMethodBeat.i(86807);
        if (method.getReturnType().equals(Boolean.TYPE)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(86807);
            return bool;
        } else if (Modifier.isStatic(method.getModifiers())) {
            AppMethodBeat.o(86807);
            return null;
        } else {
            Object a;
            y xA;
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                xA = this.gUE.xA((String) objArr[0]);
                if (xA == null) {
                    a = a(method);
                    AppMethodBeat.o(86807);
                    return a;
                } else if (method.getReturnType().equals(ao.class)) {
                    a = xA.gTI;
                    AppMethodBeat.o(86807);
                    return a;
                } else {
                    Method b = b(method);
                    if (b != null) {
                        a = b.invoke(xA, objArr);
                        AppMethodBeat.o(86807);
                        return a;
                    }
                }
            } else if (method.getReturnType().equals(Void.TYPE)) {
                Collection<y> awi = this.gUE.awi();
                if (awi != null) {
                    Method b2 = b(method);
                    if (b2 != null) {
                        for (y xA2 : awi) {
                            b2.invoke(xA2, objArr);
                        }
                    }
                }
                AppMethodBeat.o(86807);
                return null;
            }
            a = a(method);
            AppMethodBeat.o(86807);
            return a;
        }
    }

    private static Object a(Method method) {
        AppMethodBeat.i(86808);
        if (method.getReturnType().equals(j.class)) {
            j jVar = j.ERR_PERMISSION_DENIED;
            AppMethodBeat.o(86808);
            return jVar;
        }
        AppMethodBeat.o(86808);
        return null;
    }

    private Method b(Method method) {
        AppMethodBeat.i(86809);
        String toGenericString = method.toGenericString();
        Method method2 = (Method) this.gUD.get(toGenericString);
        if (method2 == null) {
            method2 = y.class.getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                this.gUD.put(toGenericString, method2);
            }
        }
        AppMethodBeat.o(86809);
        return method2;
    }

    private ar(u uVar) {
        AppMethodBeat.i(86810);
        this.gUE = new b(uVar, (byte) 0);
        AppMethodBeat.o(86810);
    }
}
