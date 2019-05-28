package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class mh<T> extends ly<T> {
    boolean a = false;
    private final ly<? super T> b;

    public mh(ly<? super T> lyVar) {
        super(lyVar);
        this.b = lyVar;
    }

    public void a() {
        AppMethodBeat.i(100508);
        if (this.a) {
            AppMethodBeat.o(100508);
            return;
        }
        this.a = true;
        try {
            this.b.a();
        } catch (Throwable th) {
            mb.a(th);
            b(th);
        } finally {
            b();
            AppMethodBeat.o(100508);
        }
    }

    public void a(Throwable th) {
        AppMethodBeat.i(100509);
        mb.a(th);
        if (!this.a) {
            this.a = true;
            b(th);
        }
        AppMethodBeat.o(100509);
    }

    public void a(T t) {
        AppMethodBeat.i(100510);
        try {
            if (!this.a) {
                this.b.a((Object) t);
            }
            AppMethodBeat.o(100510);
        } catch (Throwable th) {
            mb.a(th);
            a(th);
            AppMethodBeat.o(100510);
        }
    }

    /* Access modifiers changed, original: protected */
    public void b(Throwable th) {
        AppMethodBeat.i(100511);
        try {
            ml.a().b().a(th);
        } catch (Throwable th2) {
            c(th2);
        }
        mc mcVar;
        try {
            this.b.a(th);
            try {
                b();
                AppMethodBeat.o(100511);
                return;
            } catch (RuntimeException e) {
                ml.a().b().a(e);
            } catch (Throwable th22) {
                c(th22);
            }
            mc mcVar2 = new mc(e);
            AppMethodBeat.o(100511);
            throw mcVar2;
            b();
            mcVar = new mc("Error occurred when trying to propagate error to Observer.onError", new ma(Arrays.asList(new Throwable[]{th, th22})));
            AppMethodBeat.o(100511);
        } catch (Throwable th3) {
            try {
                ml.a().b().a(th3);
            } catch (Throwable th4) {
                c(th4);
            }
            mcVar = new mc("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new ma(Arrays.asList(new Throwable[]{th, th22, th3})));
            AppMethodBeat.o(100511);
        }
    }

    private void c(Throwable th) {
        AppMethodBeat.i(100512);
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th.getMessage());
        AppMethodBeat.o(100512);
    }
}
