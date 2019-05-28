package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0002\u001a\u001d\u0010\u0012\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\b\u0015\u001a\u0014\u0010\u0016\u001a\u00020\b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, dWq = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "MainDispatcher", "choreographer", "Landroid/view/Choreographer;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"})
/* renamed from: kotlinx.coroutines.android.d */
public final class C44610d {
    public static final C24588c BRd;
    private static final C24588c BRe;
    private static final Handler awA;

    static {
        AppMethodBeat.m2504i(118257);
        Looper mainLooper = Looper.getMainLooper();
        C25052j.m39375o(mainLooper, "Looper.getMainLooper()");
        awA = C44610d.m81030m(mainLooper);
        C24588c c31539b = new C31539b(awA, "Main");
        BRd = c31539b;
        BRe = c31539b;
        AppMethodBeat.m2505o(118257);
    }

    /* renamed from: m */
    private static Handler m81030m(Looper looper) {
        AppMethodBeat.m2504i(118256);
        C25052j.m39376p(looper, "receiver$0");
        Handler handler;
        Object invoke;
        if (VERSION.SDK_INT < 16) {
            handler = new Handler(looper);
            AppMethodBeat.m2505o(118256);
            return handler;
        } else if (VERSION.SDK_INT >= 28) {
            invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{looper});
            if (invoke == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.os.Handler");
                AppMethodBeat.m2505o(118256);
                throw c44941v;
            }
            handler = (Handler) invoke;
            AppMethodBeat.m2505o(118256);
            return handler;
        } else {
            try {
                Constructor declaredConstructor = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Callback.class, Boolean.TYPE});
                C25052j.m39375o(declaredConstructor, "Handler::class.java.getD…:class.javaPrimitiveType)");
                invoke = declaredConstructor.newInstance(new Object[]{looper, null, Boolean.TRUE});
                C25052j.m39375o(invoke, "constructor.newInstance(this, null, true)");
                handler = (Handler) invoke;
                AppMethodBeat.m2505o(118256);
                return handler;
            } catch (NoSuchMethodException e) {
                handler = new Handler(looper);
                AppMethodBeat.m2505o(118256);
                return handler;
            }
        }
    }
}
