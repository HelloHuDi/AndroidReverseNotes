package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.extension.ReflectionHelper.MemberType;

public class MessageHandler {
    private String TAG = "MessageHandler";
    private Map<String, Handler> mHandlers = new HashMap();

    public class Handler {
        String javaName;
        ReflectionHelper reflection;
        Object targetObject;
        MemberType type;

        public Handler(String str, MemberType memberType, Object obj, ReflectionHelper reflectionHelper) {
            this.type = memberType;
            this.javaName = str;
            this.targetObject = obj;
            this.reflection = reflectionHelper;
        }

        public Handler(MessageHandler messageHandler, String str, MemberType memberType, Object obj) {
            this(str, memberType, obj, null);
        }
    }

    public MessageHandler() {
        AppMethodBeat.i(86125);
        AppMethodBeat.o(86125);
    }

    public MessageHandler(MessageHandler messageHandler) {
        AppMethodBeat.i(86126);
        this.mHandlers.putAll(messageHandler.mHandlers);
        AppMethodBeat.o(86126);
    }

    public void register(String str, String str2, MemberType memberType, Object obj, ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(86127);
        if (this.mHandlers.containsKey(str)) {
            Log.w(this.TAG, "Existing handler for ".concat(String.valueOf(str)));
            AppMethodBeat.o(86127);
            return;
        }
        this.mHandlers.put(str, new Handler(str2, memberType, obj, reflectionHelper));
        AppMethodBeat.o(86127);
    }

    public void register(String str, String str2, MemberType memberType, Object obj) {
        AppMethodBeat.i(86128);
        register(str, str2, memberType, obj, null);
        AppMethodBeat.o(86128);
    }

    public void register(String str, String str2, Object obj) {
        AppMethodBeat.i(86129);
        register(str, str2, MemberType.JS_METHOD, obj, null);
        AppMethodBeat.o(86129);
    }

    public void register(String str, Object obj) {
        AppMethodBeat.i(86130);
        register(str, str, MemberType.JS_METHOD, obj, null);
        AppMethodBeat.o(86130);
    }

    public Object handleMessage(MessageInfo messageInfo) {
        AppMethodBeat.i(86131);
        String jsName = messageInfo.getJsName();
        Handler handler = (Handler) this.mHandlers.get(jsName);
        if (handler == null || handler.targetObject == null) {
            Log.w(this.TAG, "Cannot find handler for method ".concat(String.valueOf(jsName)));
            AppMethodBeat.o(86131);
            return null;
        }
        Object invoke;
        Object obj = handler.targetObject;
        if (!messageInfo.getExtension().isAutoJS() || handler.reflection == null) {
            try {
                invoke = obj.getClass().getMethod(handler.javaName, new Class[]{MessageInfo.class}).invoke(obj, new Object[]{messageInfo});
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                Log.e(this.TAG, e.toString());
                invoke = null;
            }
        } else {
            try {
                invoke = handler.reflection.handleMessage(messageInfo, obj);
            } catch (Exception e2) {
                Log.e(this.TAG, e2.toString());
                invoke = null;
            }
        }
        AppMethodBeat.o(86131);
        return invoke;
    }
}
