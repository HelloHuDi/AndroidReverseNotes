package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor extends Interceptor<Callback> {
    private static Field ADv;
    private final Handler ADt;
    private final MessageHandler ADu;

    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    static class CallbackWrapper implements Callback, ITinkerHotplugProxy {
        private final MessageHandler ADu;
        private final Callback ADw;
        private volatile boolean ADx = false;

        CallbackWrapper(MessageHandler messageHandler, Callback callback) {
            this.ADu = messageHandler;
            this.ADw = callback;
        }

        public boolean handleMessage(Message message) {
            if (this.ADx) {
                return false;
            }
            boolean handleMessage;
            this.ADx = true;
            this.ADu.handleMessage(message);
            if (this.ADw != null) {
                handleMessage = this.ADw.handleMessage(message);
            } else {
                handleMessage = false;
            }
            this.ADx = false;
            return handleMessage;
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: de */
    public final /* synthetic */ void mo12686de(Object obj) {
        ADv.set(this.ADt, (Callback) obj);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: df */
    public final /* synthetic */ Object mo12687df(Object obj) {
        Callback callback = (Callback) obj;
        if (callback == null || !ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) {
            return new CallbackWrapper(this.ADu, callback);
        }
        return callback;
    }

    static {
        ADv = null;
        synchronized (HandlerMessageInterceptor.class) {
            if (ADv == null) {
                try {
                    ADv = ShareReflectUtil.m9400d(Handler.class, "mCallback");
                } catch (Throwable th) {
                }
            }
        }
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.ADt = handler;
        this.ADu = messageHandler;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object dSm() {
        return (Callback) ADv.get(this.ADt);
    }
}
