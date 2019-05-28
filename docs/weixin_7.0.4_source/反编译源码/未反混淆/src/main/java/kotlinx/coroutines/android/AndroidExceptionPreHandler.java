package kotlinx.coroutines.android;

import a.c.a;
import a.c.e;
import a.f.b.j;
import a.l;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import kotlinx.coroutines.x;

@Keep
@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-android"})
public final class AndroidExceptionPreHandler extends a implements x {
    public AndroidExceptionPreHandler() {
        super(x.BPJ);
        AppMethodBeat.i(118260);
        AppMethodBeat.o(118260);
    }

    public final void handleException(e eVar, Throwable th) {
        Object invoke;
        AppMethodBeat.i(118259);
        j.p(eVar, "context");
        j.p(th, "exception");
        Method elD = a.BQW;
        if (elD != null) {
            invoke = elD.invoke(null, new Object[0]);
        } else {
            invoke = null;
        }
        if (!(invoke instanceof UncaughtExceptionHandler)) {
            invoke = null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = (UncaughtExceptionHandler) invoke;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            AppMethodBeat.o(118259);
            return;
        }
        AppMethodBeat.o(118259);
    }
}
