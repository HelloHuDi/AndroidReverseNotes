package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements CallbackManager {
    private static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    private static final String TAG = CallbackManagerImpl.class.getSimpleName();
    private static Map<Integer, Callback> staticCallbacks = new HashMap();
    private Map<Integer, Callback> callbacks = new HashMap();

    public interface Callback {
        boolean onActivityResult(int i, Intent intent);
    }

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int offset;

        static {
            AppMethodBeat.o(72270);
        }

        private RequestCodeOffset(int i) {
            this.offset = i;
        }

        public final int toRequestCode() {
            AppMethodBeat.i(72269);
            int callbackRequestCodeOffset = FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
            AppMethodBeat.o(72269);
            return callbackRequestCodeOffset;
        }
    }

    public CallbackManagerImpl() {
        AppMethodBeat.i(72271);
        AppMethodBeat.o(72271);
    }

    static {
        AppMethodBeat.i(72278);
        AppMethodBeat.o(72278);
    }

    public static synchronized void registerStaticCallback(int i, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            AppMethodBeat.i(72272);
            Validate.notNull(callback, "callback");
            if (staticCallbacks.containsKey(Integer.valueOf(i))) {
                AppMethodBeat.o(72272);
            } else {
                staticCallbacks.put(Integer.valueOf(i), callback);
                AppMethodBeat.o(72272);
            }
        }
    }

    private static synchronized Callback getStaticCallback(Integer num) {
        Callback callback;
        synchronized (CallbackManagerImpl.class) {
            AppMethodBeat.i(72273);
            callback = (Callback) staticCallbacks.get(num);
            AppMethodBeat.o(72273);
        }
        return callback;
    }

    private static boolean runStaticCallback(int i, int i2, Intent intent) {
        AppMethodBeat.i(72274);
        Callback staticCallback = getStaticCallback(Integer.valueOf(i));
        if (staticCallback != null) {
            boolean onActivityResult = staticCallback.onActivityResult(i2, intent);
            AppMethodBeat.o(72274);
            return onActivityResult;
        }
        AppMethodBeat.o(72274);
        return false;
    }

    public final void registerCallback(int i, Callback callback) {
        AppMethodBeat.i(72275);
        Validate.notNull(callback, "callback");
        this.callbacks.put(Integer.valueOf(i), callback);
        AppMethodBeat.o(72275);
    }

    public final void unregisterCallback(int i) {
        AppMethodBeat.i(72276);
        this.callbacks.remove(Integer.valueOf(i));
        AppMethodBeat.o(72276);
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(72277);
        Callback callback = (Callback) this.callbacks.get(Integer.valueOf(i));
        boolean onActivityResult;
        if (callback != null) {
            onActivityResult = callback.onActivityResult(i2, intent);
            AppMethodBeat.o(72277);
            return onActivityResult;
        }
        onActivityResult = runStaticCallback(i, i2, intent);
        AppMethodBeat.o(72277);
        return onActivityResult;
    }
}
