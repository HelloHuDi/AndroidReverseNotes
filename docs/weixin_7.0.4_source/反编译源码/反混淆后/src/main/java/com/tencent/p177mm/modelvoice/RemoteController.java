package com.tencent.p177mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.modelvoice.RemoteController */
public final class RemoteController {
    private static Method fZj;
    private static Method fZk;
    private AudioManager fZh;
    private ComponentName fZi;

    /* renamed from: com.tencent.mm.modelvoice.RemoteController$a */
    public interface C9730a {
    }

    /* renamed from: com.tencent.mm.modelvoice.RemoteController$RemoteControlReceiver */
    public static class RemoteControlReceiver extends BroadcastReceiver {
        private static C7564ap che;
        private static C9730a fZl;

        /* renamed from: com.tencent.mm.modelvoice.RemoteController$RemoteControlReceiver$1 */
        class C187161 implements C5015a {
            C187161() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(116584);
                C4990ab.m7410d("MicroMsg.RemoteControlReceiver", "got remote key event up");
                if (RemoteControlReceiver.fZl != null) {
                    RemoteControlReceiver.fZl;
                }
                RemoteControlReceiver.che = null;
                AppMethodBeat.m2505o(116584);
                return false;
            }
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(116585);
            if (intent == null) {
                AppMethodBeat.m2505o(116585);
            } else if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (che == null && fZl != null) {
                    C4990ab.m7410d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                    che = new C7564ap(new C187161(), true);
                }
                if (che != null) {
                    che.mo16770ae(1000, 1000);
                }
                AppMethodBeat.m2505o(116585);
            } else {
                C4990ab.m7410d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
                AppMethodBeat.m2505o(116585);
            }
        }

        public static void alQ() {
            AppMethodBeat.m2504i(116586);
            fZl = null;
            if (che != null) {
                che.stopTimer();
                che = null;
            }
            AppMethodBeat.m2505o(116586);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(116587);
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
                AppMethodBeat.m2505o(116587);
                throw runtimeException;
            } else if (cause instanceof Error) {
                Error error = (Error) cause;
                AppMethodBeat.m2505o(116587);
                throw error;
            } else {
                runtimeException = new RuntimeException(invocationTargetException);
                AppMethodBeat.m2505o(116587);
                throw runtimeException;
            }
        } catch (IllegalAccessException e2) {
            C4990ab.m7412e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(e2)));
        }
        super.finalize();
        AppMethodBeat.m2505o(116587);
    }

    static {
        AppMethodBeat.m2504i(116588);
        try {
            if (fZj == null) {
                fZj = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (fZk == null) {
                fZk = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            AppMethodBeat.m2505o(116588);
        } catch (NoSuchMethodException e) {
            AppMethodBeat.m2505o(116588);
        }
    }
}
