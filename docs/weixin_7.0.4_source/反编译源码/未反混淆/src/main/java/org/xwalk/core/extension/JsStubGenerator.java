package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import org.xwalk.core.extension.ReflectionHelper.MemberInfo;
import org.xwalk.core.extension.ReflectionHelper.MemberType;

public class JsStubGenerator {
    public static final String MSG_TO_CLASS = "postMessageToClass";
    public static final String MSG_TO_EXTENSION = "postMessageToExtension";
    public static final String MSG_TO_OBJECT = "postMessageToObject";
    public static String TAG = "JsStubGenerator";
    String jsHeader = "var v8tools = requireNative(\"v8tools\");\nvar jsStubModule = requireNative(\"jsStub\");\njsStubModule.init(extension, v8tools);\nvar jsStub = jsStubModule.jsStub;\nvar helper = jsStub.createRootStub(exports);\n";
    ReflectionHelper reflection;

    JsStubGenerator(ReflectionHelper reflectionHelper) {
        this.reflection = reflectionHelper;
    }

    /* Access modifiers changed, original: 0000 */
    public String generate() {
        AppMethodBeat.i(86113);
        String str = "";
        MemberInfo entryPoint = this.reflection.getEntryPoint();
        if (entryPoint != null) {
            str = generateEntryPoint(entryPoint);
        }
        if (str.length() <= 0) {
            str = this.jsHeader;
        }
        if (this.reflection.getEventList() != null) {
            str = str + generateEventTarget(this.reflection);
        }
        Map members = this.reflection.getMembers();
        String str2 = str;
        for (String str3 : members.keySet()) {
            MemberInfo memberInfo = (MemberInfo) members.get(str3);
            if (!memberInfo.isEntryPoint) {
                switch (memberInfo.type) {
                    case JS_PROPERTY:
                        str2 = str2 + generateProperty(MSG_TO_EXTENSION, memberInfo);
                        continue;
                    case JS_METHOD:
                        str2 = str2 + generateMethod(MSG_TO_EXTENSION, memberInfo, true);
                        continue;
                    case JS_CONSTRUCTOR:
                        str3 = str2 + generateConstructor(memberInfo, true);
                        break;
                    default:
                        str3 = str2;
                        break;
                }
                str2 = str3;
            }
        }
        str3 = str2 + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.o(86113);
        return str3;
    }

    /* Access modifiers changed, original: 0000 */
    public String generateEntryPoint(MemberInfo memberInfo) {
        AppMethodBeat.i(86114);
        String simpleName;
        if (memberInfo.type == MemberType.JS_PROPERTY) {
            simpleName = ((Field) memberInfo.accesser).getType().getSimpleName();
            simpleName = this.jsHeader + String.format("%s(exports, helper);\n", new Object[]{getPrototypeName(simpleName)});
            AppMethodBeat.o(86114);
            return simpleName;
        } else if (memberInfo.type == MemberType.JS_METHOD) {
            simpleName = String.format("exports = %s;\n %s\n %s", new Object[]{getInternalName(memberInfo.jsName), this.jsHeader, generateMethod(MSG_TO_EXTENSION, memberInfo, false)});
            AppMethodBeat.o(86114);
            return simpleName;
        } else if (memberInfo.type == MemberType.JS_CONSTRUCTOR) {
            simpleName = String.format("exports = %s;\n %s\n %s", new Object[]{memberInfo.jsName, this.jsHeader, generateConstructor(memberInfo, false)});
            AppMethodBeat.o(86114);
            return simpleName;
        } else {
            simpleName = "";
            AppMethodBeat.o(86114);
            return simpleName;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String[] classGenerator(ReflectionHelper reflectionHelper) {
        String generateEventTarget;
        AppMethodBeat.i(86115);
        String str = "";
        String str2 = "";
        if (reflectionHelper.getEventList() != null) {
            generateEventTarget = generateEventTarget(reflectionHelper);
            str = str + generateEventTarget;
            str2 = str2 + generateEventTarget;
        }
        Map members = reflectionHelper.getMembers();
        generateEventTarget = str2;
        String str3 = str;
        for (String str22 : members.keySet()) {
            MemberInfo memberInfo = (MemberInfo) members.get(str22);
            str = memberInfo.isStatic ? MSG_TO_CLASS : MSG_TO_OBJECT;
            switch (memberInfo.type) {
                case JS_PROPERTY:
                    str = generateProperty(str, memberInfo);
                    break;
                case JS_METHOD:
                    str = generateMethod(str, memberInfo, true);
                    break;
                default:
                    str = "";
                    break;
            }
            if (memberInfo.isStatic) {
                generateEventTarget = generateEventTarget + str;
            } else {
                str3 = str3 + str;
            }
        }
        String[] strArr = new String[]{str3, generateEventTarget};
        AppMethodBeat.o(86115);
        return strArr;
    }

    /* Access modifiers changed, original: 0000 */
    public String destroyBindingObject(ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(86116);
        String str = "exports.destroy = function() {\n";
        Iterator it = reflectionHelper.getMembers().keySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + "delete exports[\"" + ((String) it.next()) + "\"];\n";
            } else {
                str = (((str2 + "helper.destroy();\n") + "delete exports[\"__stubHelper\"];\n") + "delete exports[\"destroy\"];\n") + "};";
                AppMethodBeat.o(86116);
                return str;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String generateEventTarget(ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(86117);
        String[] eventList = reflectionHelper.getEventList();
        String str;
        if (eventList == null || eventList.length == 0) {
            str = "";
            AppMethodBeat.o(86117);
            return str;
        }
        str = "jsStub.makeEventTarget(exports);\n";
        for (String str2 : eventList) {
            str = str + "helper.addEvent(\"" + str2 + "\");\n";
        }
        AppMethodBeat.o(86117);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    public String generateProperty(String str, MemberInfo memberInfo) {
        AppMethodBeat.i(86118);
        String str2 = memberInfo.jsName;
        str2 = String.format("jsStub.defineProperty(\"%s\", exports, \"%s\", %b);\n", new Object[]{str, str2, Boolean.valueOf(memberInfo.isWritable)});
        AppMethodBeat.o(86118);
        return str2;
    }

    /* Access modifiers changed, original: 0000 */
    public String generatePromiseMethod(String str, MemberInfo memberInfo) {
        AppMethodBeat.i(86119);
        String str2 = memberInfo.jsName;
        String str3 = memberInfo.wrapArgs.length() > 0 ? memberInfo.wrapArgs : BuildConfig.COMMAND;
        String str4 = memberInfo.wrapReturns.length() > 0 ? memberInfo.wrapReturns : BuildConfig.COMMAND;
        str3 = String.format("jsStub.addMethodWithPromise(\"%s\", exports, \"%s\", %s, %s);\n", new Object[]{str, str2, str3, str4});
        AppMethodBeat.o(86119);
        return str3;
    }

    /* Access modifiers changed, original: 0000 */
    public String getArgString(Method method, boolean z) {
        AppMethodBeat.i(86120);
        String str;
        if (method == null) {
            str = "";
            AppMethodBeat.o(86120);
            return str;
        }
        Class[] parameterTypes = method.getParameterTypes();
        method.getParameterAnnotations();
        str = "";
        int length = z ? parameterTypes.length - 1 : parameterTypes.length;
        for (int i = 0; i < length; i++) {
            String str2 = "arg" + i + "_" + parameterTypes[i].getSimpleName();
            if (str.length() > 0) {
                str = str + ", ";
            }
            str = str + str2;
        }
        AppMethodBeat.o(86120);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    public String generateMethod(String str, MemberInfo memberInfo, boolean z) {
        AppMethodBeat.i(86121);
        String generatePromiseMethod;
        if (memberInfo.withPromise) {
            generatePromiseMethod = generatePromiseMethod(str, memberInfo);
            AppMethodBeat.o(86121);
            return generatePromiseMethod;
        }
        Method method = (Method) memberInfo.accesser;
        String internalName = getInternalName(memberInfo.jsName);
        method.getParameterAnnotations();
        String argString = getArgString(method, memberInfo.withPromise);
        generatePromiseMethod = String.format("function %s(%s) {\n" + (!method.getReturnType().equals(Void.TYPE) ? "  return " : "  ") + "helper.invokeNative(\"%s\", \"%s\", [%s], %b);\n};\n", new Object[]{internalName, argString, str, memberInfo.jsName, argString, Boolean.valueOf(!method.getReturnType().equals(Void.TYPE))}) + (z ? String.format("exports[\"%s\"] = %s;\n", new Object[]{r4, internalName}) : "");
        AppMethodBeat.o(86121);
        return generatePromiseMethod;
    }

    /* Access modifiers changed, original: 0000 */
    public String getInternalName(String str) {
        AppMethodBeat.i(86122);
        String concat = "__".concat(String.valueOf(str));
        AppMethodBeat.o(86122);
        return concat;
    }

    /* Access modifiers changed, original: 0000 */
    public String getPrototypeName(String str) {
        AppMethodBeat.i(86123);
        String str2 = "__" + str + "_prototype";
        AppMethodBeat.o(86123);
        return str2;
    }

    /* Access modifiers changed, original: 0000 */
    public String generateConstructor(MemberInfo memberInfo, boolean z) {
        AppMethodBeat.i(86124);
        String str = memberInfo.jsName;
        String prototypeName = getPrototypeName(str);
        String argString = getArgString((Method) memberInfo.accesser, false);
        String[] classGenerator = classGenerator(this.reflection.getConstructorReflection(str));
        String format = String.format("function %s(exports, helper){\n%s\n%s\n}\n", new Object[]{prototypeName, classGenerator[0], destroyBindingObject(r3)});
        prototypeName = String.format("function %s(%s) {\nvar newObject = this;\nvar objectId =\nNumber(helper.invokeNative(\"%s\", \"+%s\", [%s], true));\nif (!objectId) throw \"Error to create instance for constructor:%s.\";\nvar objectHelper = jsStub.getHelper(newObject, helper);\nobjectHelper.objectId = objectId;\nobjectHelper.constructorJsName = \"%s\";\nobjectHelper.registerLifecycleTracker();%s(newObject, objectHelper);\nhelper.addBindingObject(objectId, newObject);}\nhelper.constructors[\"%s\"] = %s;\n", new Object[]{str, argString, MSG_TO_EXTENSION, str, argString, str, str, prototypeName, str, str});
        String format2 = String.format("(function(exports, helper){\n  helper.constructorJsName = \"%s\";\n%s\n})(%s, jsStub.getHelper(%s, helper));\n", new Object[]{str, classGenerator[1], str, str});
        if (z) {
            argString = String.format("exports[\"%s\"] = %s;\n", new Object[]{str, str});
        } else {
            argString = "";
        }
        argString = format + prototypeName + format2 + argString;
        AppMethodBeat.o(86124);
        return argString;
    }
}
