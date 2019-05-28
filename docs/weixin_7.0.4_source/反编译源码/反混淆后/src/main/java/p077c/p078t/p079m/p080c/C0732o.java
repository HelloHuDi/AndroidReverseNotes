package p077c.p078t.p079m.p080c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: c.t.m.c.o */
public class C0732o {
    /* renamed from: a */
    public static boolean m1686a(Handler handler) {
        AppMethodBeat.m2504i(136395);
        boolean a = C0732o.m1689a(handler == null ? null : handler.getLooper());
        AppMethodBeat.m2505o(136395);
        return a;
    }

    /* renamed from: a */
    public static boolean m1689a(Looper looper) {
        AppMethodBeat.m2504i(136396);
        if (looper == null || !looper.getThread().isAlive()) {
            AppMethodBeat.m2505o(136396);
            return false;
        }
        AppMethodBeat.m2505o(136396);
        return true;
    }

    /* renamed from: a */
    public static boolean m1687a(Handler handler, Message message) {
        AppMethodBeat.m2504i(136397);
        boolean a = C0732o.m1688a(handler, message, 0);
        AppMethodBeat.m2505o(136397);
        return a;
    }

    /* renamed from: a */
    public static boolean m1688a(Handler handler, Message message, long j) {
        AppMethodBeat.m2504i(136398);
        if (message == null || !C0732o.m1686a(handler)) {
            AppMethodBeat.m2505o(136398);
            return false;
        }
        boolean sendMessageDelayed = handler.sendMessageDelayed(message, j);
        AppMethodBeat.m2505o(136398);
        return sendMessageDelayed;
    }
}
