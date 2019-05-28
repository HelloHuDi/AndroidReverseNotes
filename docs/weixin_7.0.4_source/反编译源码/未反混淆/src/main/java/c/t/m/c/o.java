package c.t.m.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o {
    public static boolean a(Handler handler) {
        AppMethodBeat.i(136395);
        boolean a = a(handler == null ? null : handler.getLooper());
        AppMethodBeat.o(136395);
        return a;
    }

    public static boolean a(Looper looper) {
        AppMethodBeat.i(136396);
        if (looper == null || !looper.getThread().isAlive()) {
            AppMethodBeat.o(136396);
            return false;
        }
        AppMethodBeat.o(136396);
        return true;
    }

    public static boolean a(Handler handler, Message message) {
        AppMethodBeat.i(136397);
        boolean a = a(handler, message, 0);
        AppMethodBeat.o(136397);
        return a;
    }

    public static boolean a(Handler handler, Message message, long j) {
        AppMethodBeat.i(136398);
        if (message == null || !a(handler)) {
            AppMethodBeat.o(136398);
            return false;
        }
        boolean sendMessageDelayed = handler.sendMessageDelayed(message, j);
        AppMethodBeat.o(136398);
        return sendMessageDelayed;
    }
}
