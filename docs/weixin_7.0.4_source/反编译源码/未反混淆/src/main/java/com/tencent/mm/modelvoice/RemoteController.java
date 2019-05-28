package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method fZj;
    private static Method fZk;
    private AudioManager fZh;
    private ComponentName fZi;

    public interface a {
    }

    public static class RemoteControlReceiver extends BroadcastReceiver {
        private static ap che;
        private static a fZl;

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(116585);
            if (intent == null) {
                AppMethodBeat.o(116585);
            } else if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (che == null && fZl != null) {
                    ab.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                    che = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(116584);
                            ab.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
                            if (RemoteControlReceiver.fZl != null) {
                                RemoteControlReceiver.fZl;
                            }
                            RemoteControlReceiver.che = null;
                            AppMethodBeat.o(116584);
                            return false;
                        }
                    }, true);
                }
                if (che != null) {
                    che.ae(1000, 1000);
                }
                AppMethodBeat.o(116585);
            } else {
                ab.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
                AppMethodBeat.o(116585);
            }
        }

        public static void alQ() {
            AppMethodBeat.i(116586);
            fZl = null;
            if (che != null) {
                che.stopTimer();
                che = null;
            }
            AppMethodBeat.o(116586);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(116587);
        try {
            if (fZk != null) {
                fZk.invoke(this.fZh, new Object[]{this.fZi});
                RemoteControlReceiver.alQ();
            }
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(116587);
                throw runtimeException;
            } else if (cause instanceof Error) {
                Error error = (Error) cause;
                AppMethodBeat.o(116587);
                throw error;
            } else {
                runtimeException = new RuntimeException(invocationTargetException);
                AppMethodBeat.o(116587);
                throw runtimeException;
            }
        } catch (IllegalAccessException e2) {
            ab.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(e2)));
        }
        super.finalize();
        AppMethodBeat.o(116587);
    }

    static {
        AppMethodBeat.i(116588);
        try {
            if (fZj == null) {
                fZj = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (fZk == null) {
                fZk = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            AppMethodBeat.o(116588);
        } catch (NoSuchMethodException e) {
            AppMethodBeat.o(116588);
        }
    }
}
