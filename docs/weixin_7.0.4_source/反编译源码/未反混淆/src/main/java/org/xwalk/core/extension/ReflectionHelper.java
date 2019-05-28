package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

class ReflectionHelper {
    private static final String TAG = "JsStubReflectHelper";
    static Set<Class<?>> primitives = new HashSet();
    private Map<String, String> bindingClasses = new HashMap();
    private Map<String, ReflectionHelper> constructorReflections = new HashMap();
    private MemberInfo entryPoint = null;
    private String[] eventList = null;
    private Map<String, MemberInfo> members = new HashMap();
    private Class<?> myClass;

    public class MemberInfo {
        AccessibleObject accesser;
        boolean isEntryPoint;
        boolean isStatic;
        boolean isWritable;
        String javaName;
        String jsName;
        Class<?> mainClass;
        MemberType type;
        boolean withPromise;
        String wrapArgs = "";
        String wrapReturns = "";
    }

    public enum MemberType {
        JS_METHOD,
        JS_PROPERTY,
        JS_CONSTRUCTOR;

        static {
            AppMethodBeat.o(86139);
        }
    }

    static {
        AppMethodBeat.i(86160);
        AppMethodBeat.o(86160);
    }

    public ReflectionHelper(Class<?> cls) {
        AppMethodBeat.i(86140);
        this.myClass = cls;
        init();
        AppMethodBeat.o(86140);
    }

    /* Access modifiers changed, original: 0000 */
    public void getMemberInfo(AccessibleObject[] accessibleObjectArr, MemberType memberType) {
        AppMethodBeat.i(86141);
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(JsApi.class) || accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                MemberInfo memberInfo = new MemberInfo();
                String name = ((Member) accessibleObject).getName();
                memberInfo.javaName = name;
                memberInfo.accesser = accessibleObject;
                memberInfo.isStatic = Modifier.isStatic(((Member) accessibleObject).getModifiers());
                if (accessibleObject.isAnnotationPresent(JsApi.class)) {
                    JsApi jsApi = (JsApi) accessibleObject.getAnnotation(JsApi.class);
                    if (memberType != MemberType.JS_PROPERTY || !jsApi.isEventList()) {
                        memberInfo.type = memberType;
                        memberInfo.isWritable = jsApi.isWritable();
                        memberInfo.isEntryPoint = jsApi.isEntryPoint();
                        memberInfo.withPromise = jsApi.withPromise();
                        memberInfo.jsName = name;
                        memberInfo.wrapArgs = jsApi.wrapArgs();
                        memberInfo.wrapReturns = jsApi.wrapReturns();
                    } else if (((Field) accessibleObject).getType().equals(String[].class)) {
                        try {
                            this.eventList = (String[]) ((Field) accessibleObject).get(null);
                        } catch (IllegalAccessException | IllegalArgumentException e) {
                        }
                    } else {
                        Log.w(TAG, "Invalid type for Supported JS event list".concat(String.valueOf(name)));
                    }
                } else if (accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                    if (memberType != MemberType.JS_METHOD) {
                        Log.w(TAG, "Invalid @JsConstructor on non-function member:".concat(String.valueOf(name)));
                    } else {
                        JsConstructor jsConstructor = (JsConstructor) accessibleObject.getAnnotation(JsConstructor.class);
                        memberInfo.type = MemberType.JS_CONSTRUCTOR;
                        memberInfo.isEntryPoint = jsConstructor.isEntryPoint();
                        memberInfo.mainClass = jsConstructor.mainClass();
                        memberInfo.withPromise = false;
                        if (memberInfo.mainClass != null) {
                            memberInfo.jsName = memberInfo.mainClass.getSimpleName();
                            this.bindingClasses.put(memberInfo.mainClass.getName(), memberInfo.jsName);
                            this.constructorReflections.put(memberInfo.jsName, new ReflectionHelper(memberInfo.mainClass));
                        }
                    }
                }
                if (memberInfo.isEntryPoint) {
                    if (this.entryPoint != null) {
                        Log.w(TAG, "Entry point already exist, try to set another:" + memberInfo.jsName);
                    } else if (memberType != MemberType.JS_PROPERTY || isBindingClass(((Field) memberInfo.accesser).getType())) {
                        this.entryPoint = memberInfo;
                    } else {
                        Log.w(TAG, "Invalid entry point setting on property:".concat(String.valueOf(name)));
                    }
                }
                if (this.members.containsKey(memberInfo.jsName)) {
                    Log.w(TAG, "Conflict namespace - " + memberInfo.jsName);
                } else {
                    this.members.put(memberInfo.jsName, memberInfo);
                }
            }
        }
        AppMethodBeat.o(86141);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isBindingClass(Class<?> cls) {
        AppMethodBeat.i(86142);
        boolean isAssignableFrom = BindingObject.class.isAssignableFrom(cls);
        AppMethodBeat.o(86142);
        return isAssignableFrom;
    }

    /* Access modifiers changed, original: 0000 */
    public void init() {
        AppMethodBeat.i(86143);
        primitives.add(Byte.class);
        primitives.add(Integer.class);
        primitives.add(Long.class);
        primitives.add(Double.class);
        primitives.add(Character.class);
        primitives.add(Float.class);
        primitives.add(Boolean.class);
        primitives.add(Short.class);
        getMemberInfo(this.myClass.getDeclaredMethods(), MemberType.JS_METHOD);
        getMemberInfo(this.myClass.getDeclaredFields(), MemberType.JS_PROPERTY);
        AppMethodBeat.o(86143);
    }

    public static void registerHandlers(ReflectionHelper reflectionHelper, MessageHandler messageHandler, Object obj) {
        AppMethodBeat.i(86144);
        if (reflectionHelper == null || messageHandler == null) {
            AppMethodBeat.o(86144);
            return;
        }
        for (String str : reflectionHelper.getMembers().keySet()) {
            MemberInfo memberInfo = (MemberInfo) reflectionHelper.getMembers().get(str);
            messageHandler.register(memberInfo.jsName, memberInfo.javaName, memberInfo.type, obj, reflectionHelper);
        }
        AppMethodBeat.o(86144);
    }

    /* Access modifiers changed, original: 0000 */
    public Map<String, MemberInfo> getMembers() {
        return this.members;
    }

    /* Access modifiers changed, original: 0000 */
    public ReflectionHelper getConstructorReflection(String str) {
        AppMethodBeat.i(86145);
        if (this.constructorReflections.containsKey(str)) {
            ReflectionHelper reflectionHelper = (ReflectionHelper) this.constructorReflections.get(str);
            AppMethodBeat.o(86145);
            return reflectionHelper;
        }
        AppMethodBeat.o(86145);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public ReflectionHelper getReflectionByBindingClass(String str) {
        AppMethodBeat.i(86146);
        if (this.bindingClasses.containsKey(str)) {
            ReflectionHelper constructorReflection = getConstructorReflection((String) this.bindingClasses.get(str));
            AppMethodBeat.o(86146);
            return constructorReflection;
        }
        AppMethodBeat.o(86146);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public Boolean hasMethod(String str) {
        AppMethodBeat.i(86147);
        Boolean valueOf;
        if (this.members.containsKey(str)) {
            MemberInfo memberInfo = (MemberInfo) this.members.get(str);
            boolean z = memberInfo.type == MemberType.JS_METHOD || memberInfo.type == MemberType.JS_CONSTRUCTOR;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(86147);
            return valueOf;
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.o(86147);
        return valueOf;
    }

    /* Access modifiers changed, original: 0000 */
    public Boolean hasProperty(String str) {
        AppMethodBeat.i(86148);
        Boolean valueOf;
        if (this.members.containsKey(str)) {
            valueOf = Boolean.valueOf(((MemberInfo) this.members.get(str)).type == MemberType.JS_PROPERTY);
            AppMethodBeat.o(86148);
            return valueOf;
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.o(86148);
        return valueOf;
    }

    /* Access modifiers changed, original: 0000 */
    public MemberInfo getMemberInfo(String str) {
        AppMethodBeat.i(86149);
        MemberInfo memberInfo = (MemberInfo) this.members.get(str);
        AppMethodBeat.o(86149);
        return memberInfo;
    }

    /* Access modifiers changed, original: 0000 */
    public Object[] getArgsFromJson(XWalkExternalExtension xWalkExternalExtension, int i, Method method, JSONArray jSONArray) {
        int i2 = 0;
        AppMethodBeat.i(86150);
        Class[] parameterTypes = method.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        while (i2 < parameterTypes.length) {
            try {
                Object obj = parameterTypes[i2];
                if (isStatic && obj.equals(JsContextInfo.class)) {
                    int i3 = i2 + 1;
                    try {
                        objArr[i2] = new JsContextInfo(i, xWalkExternalExtension, method.getClass(), Integer.toString(0));
                        i2 = i3;
                    } catch (Exception e) {
                        i2 = i3;
                    }
                    i2++;
                } else {
                    objArr[i2] = jSONArray.get(i2);
                    i2++;
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(86150);
        return objArr;
    }

    public static boolean isSerializable(Object obj) {
        AppMethodBeat.i(86151);
        Class cls = obj.getClass();
        if (cls.isPrimitive() || primitives.contains(cls) || (obj instanceof String) || (obj instanceof Map) || (obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            AppMethodBeat.o(86151);
            return true;
        }
        AppMethodBeat.o(86151);
        return false;
    }

    public static Object toSerializableObject(Object obj) {
        int i = 0;
        AppMethodBeat.i(86152);
        JSONArray jSONArray;
        if (obj.getClass().isArray()) {
            jSONArray = new JSONArray();
            Object[] objArr = (Object[]) obj;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                try {
                    jSONArray.put(i2, toSerializableObject(objArr[i2]));
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(86152);
            return jSONArray;
        } else if (isSerializable(obj)) {
            AppMethodBeat.o(86152);
            return obj;
        } else {
            try {
                String str = (String) obj.getClass().getMethod("toJSONString", new Class[0]).invoke(obj, new Object[0]);
                if (str.trim().charAt(0) == '[') {
                    jSONArray = new JSONArray(str);
                    AppMethodBeat.o(86152);
                    return jSONArray;
                }
                JSONObject jSONObject = new JSONObject(str);
                AppMethodBeat.o(86152);
                return jSONObject;
            } catch (Exception e2) {
                Log.w(TAG, "No serialization method: \"toJSONString\", or errors happened.");
                try {
                    Class cls = obj.getClass();
                    JSONObject jSONObject2 = new JSONObject();
                    Field[] fields = cls.getFields();
                    int length = fields.length;
                    while (i < length) {
                        Field field = fields[i];
                        jSONObject2.put(field.getName(), field.get(obj));
                        i++;
                    }
                    AppMethodBeat.o(86152);
                    return jSONObject2;
                } catch (Exception e3) {
                    Log.e(TAG, "Field to serialize object to JSON.");
                    AppMethodBeat.o(86152);
                    return null;
                }
            }
        }
    }

    public static String objToJSON(Object obj) {
        AppMethodBeat.i(86153);
        String str;
        if (obj == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(86153);
            return str;
        }
        Object toSerializableObject = toSerializableObject(obj);
        if (toSerializableObject == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(86153);
            return str;
        } else if (toSerializableObject instanceof String) {
            str = JSONObject.quote(toSerializableObject.toString());
            AppMethodBeat.o(86153);
            return str;
        } else {
            str = toSerializableObject.toString();
            AppMethodBeat.o(86153);
            return str;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Object invokeMethod(XWalkExternalExtension xWalkExternalExtension, int i, Object obj, String str, JSONArray jSONArray) {
        AppMethodBeat.i(86154);
        if (!hasMethod(str).booleanValue()) {
            NoSuchMethodException noSuchMethodException = new NoSuchMethodException("No such method:".concat(String.valueOf(str)));
            AppMethodBeat.o(86154);
            throw noSuchMethodException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Method method = (Method) ((MemberInfo) this.members.get(str)).accesser;
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            Object invoke = method.invoke(obj, getArgsFromJson(xWalkExternalExtension, i, method, jSONArray));
            AppMethodBeat.o(86154);
            return invoke;
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(86154);
            throw invocationTargetException;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Object getProperty(Object obj, String str) {
        AppMethodBeat.i(86155);
        if (!hasProperty(str).booleanValue()) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such property:".concat(String.valueOf(str)));
            AppMethodBeat.o(86155);
            throw noSuchFieldException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) ((MemberInfo) this.members.get(str)).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            AppMethodBeat.o(86155);
            return obj2;
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(86155);
            throw invocationTargetException;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setProperty(Object obj, String str, Object obj2) {
        AppMethodBeat.i(86156);
        if (!hasProperty(str).booleanValue()) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such property:".concat(String.valueOf(str)));
            AppMethodBeat.o(86156);
            throw noSuchFieldException;
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) ((MemberInfo) this.members.get(str)).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
            AppMethodBeat.o(86156);
        } else {
            InvocationTargetException invocationTargetException = new InvocationTargetException(new Exception("Invalid target to set property:".concat(String.valueOf(str))));
            AppMethodBeat.o(86156);
            throw invocationTargetException;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String[] getEventList() {
        return this.eventList;
    }

    /* Access modifiers changed, original: 0000 */
    public MemberInfo getEntryPoint() {
        return this.entryPoint;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isEventSupported(String str) {
        AppMethodBeat.i(86157);
        if (this.eventList == null) {
            AppMethodBeat.o(86157);
            return false;
        }
        for (String equals : this.eventList) {
            if (equals.equals(str)) {
                AppMethodBeat.o(86157);
                return true;
            }
        }
        AppMethodBeat.o(86157);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isInstance(Object obj) {
        AppMethodBeat.i(86158);
        boolean isInstance = this.myClass.isInstance(obj);
        AppMethodBeat.o(86158);
        return isInstance;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object handleMessage(MessageInfo messageInfo, Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(86159);
        try {
            JSONArray jSONArray;
            String cmd = messageInfo.getCmd();
            if (messageInfo.getBinaryArgs() != null) {
                jSONArray = new JSONArray();
                jSONArray.put(messageInfo.getBinaryArgs());
                jSONArray.put(messageInfo.getCallbackId());
            } else {
                jSONArray = messageInfo.getArgs();
            }
            String jsName = messageInfo.getJsName();
            XWalkExternalExtension extension = messageInfo.getExtension();
            int instanceId = messageInfo.getInstanceId();
            switch (cmd.hashCode()) {
                case -633190737:
                    if (cmd.equals("invokeNative")) {
                        break;
                    }
                case 996179031:
                    if (cmd.equals("setProperty")) {
                        obj2 = 3;
                        break;
                    }
                case 1084758859:
                    if (cmd.equals("getProperty")) {
                        obj2 = 2;
                        break;
                    }
                case 1811874389:
                    if (cmd.equals("newInstance")) {
                        obj2 = 1;
                        break;
                    }
                default:
                    obj2 = -1;
                    break;
            }
            switch (obj2) {
                case null:
                    obj2 = invokeMethod(extension, instanceId, obj, jsName, jSONArray);
                    break;
                case 1:
                    obj2 = Boolean.valueOf(messageInfo.getInstanceHelper().addBindingObject(messageInfo.getObjectId(), (BindingObject) invokeMethod(extension, instanceId, obj, jsName, jSONArray)));
                    break;
                case 2:
                    obj2 = getProperty(obj, jsName);
                    break;
                case 3:
                    setProperty(obj, jsName, jSONArray.get(0));
                    obj2 = null;
                    break;
                default:
                    Log.w(TAG, "Unsupported cmd: ".concat(String.valueOf(cmd)));
                    obj2 = null;
                    break;
            }
        } catch (Exception e) {
            Log.w(TAG, "Invalid message, error msg:\n" + e.toString());
            obj2 = null;
        }
        AppMethodBeat.o(86159);
        return obj2;
    }
}
