package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public class ml {
    static final mi a = new mi() {
    };
    private static final ml b = new ml();
    private final AtomicReference<mi> c = new AtomicReference();
    private final AtomicReference<mj> d = new AtomicReference();
    private final AtomicReference<Object> e = new AtomicReference();

    static {
        AppMethodBeat.i(100518);
        AppMethodBeat.o(100518);
    }

    public static ml a() {
        return b;
    }

    ml() {
        AppMethodBeat.i(100514);
        AppMethodBeat.o(100514);
    }

    public mi b() {
        AppMethodBeat.i(100515);
        if (this.c.get() == null) {
            Object a = a(mi.class);
            if (a == null) {
                this.c.compareAndSet(null, a);
            } else {
                this.c.compareAndSet(null, (mi) a);
            }
        }
        mi miVar = (mi) this.c.get();
        AppMethodBeat.o(100515);
        return miVar;
    }

    public mj c() {
        AppMethodBeat.i(100516);
        if (this.d.get() == null) {
            Object a = a(mj.class);
            if (a == null) {
                this.d.compareAndSet(null, mk.a());
            } else {
                this.d.compareAndSet(null, (mj) a);
            }
        }
        mj mjVar = (mj) this.d.get();
        AppMethodBeat.o(100516);
        return mjVar;
    }

    private static Object a(Class<?> cls) {
        RuntimeException runtimeException;
        AppMethodBeat.i(100517);
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property != null) {
            try {
                Object newInstance = Class.forName(property).asSubclass(cls).newInstance();
                AppMethodBeat.o(100517);
                return newInstance;
            } catch (ClassCastException e) {
                RuntimeException runtimeException2 = new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
                AppMethodBeat.o(100517);
                throw runtimeException2;
            } catch (ClassNotFoundException e2) {
                runtimeException = new RuntimeException(simpleName + " implementation class not found: " + property, e2);
                AppMethodBeat.o(100517);
                throw runtimeException;
            } catch (InstantiationException e3) {
                runtimeException = new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e3);
                AppMethodBeat.o(100517);
                throw runtimeException;
            } catch (IllegalAccessException e4) {
                runtimeException = new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e4);
                AppMethodBeat.o(100517);
                throw runtimeException;
            }
        }
        AppMethodBeat.o(100517);
        return null;
    }
}
