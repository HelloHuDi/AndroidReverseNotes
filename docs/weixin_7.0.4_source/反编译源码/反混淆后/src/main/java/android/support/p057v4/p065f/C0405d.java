package android.support.p057v4.p065f;

import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: android.support.v4.f.d */
public final class C0405d {
    /* renamed from: a */
    public static void m692a(Object obj, StringBuilder stringBuilder) {
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
