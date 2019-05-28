package kotlinx.coroutines.android;

import android.support.annotation.Keep;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C36627bj;
import p000a.C0220l;

@Keep
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, dWq = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Companion", "kotlinx-coroutines-android"})
public final class AndroidDispatcherFactory {
    public static final C24586a Companion = new C24586a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, dWq = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory$Companion;", "", "()V", "getDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "kotlinx-coroutines-android"})
    /* renamed from: kotlinx.coroutines.android.AndroidDispatcherFactory$a */
    public static final class C24586a {
        private C24586a() {
        }

        public /* synthetic */ C24586a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(118247);
        AppMethodBeat.m2505o(118247);
    }

    public final C36627bj createDispatcher() {
        return C44610d.BRd;
    }

    public final int getLoadPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static final C36627bj getDispatcher() {
        return C44610d.BRd;
    }
}
