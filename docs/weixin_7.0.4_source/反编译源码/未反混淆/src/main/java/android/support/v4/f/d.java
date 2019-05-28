package android.support.v4.f;

import com.tencent.mm.loader.BuildConfig;

public final class d {
    public static void a(Object obj, StringBuilder stringBuilder) {
        if (obj == null) {
            stringBuilder.append(BuildConfig.COMMAND);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName == null || simpleName.length() <= 0) {
            simpleName = obj.getClass().getName();
            int lastIndexOf = simpleName.lastIndexOf(46);
            if (lastIndexOf > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
        }
        stringBuilder.append(simpleName);
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
