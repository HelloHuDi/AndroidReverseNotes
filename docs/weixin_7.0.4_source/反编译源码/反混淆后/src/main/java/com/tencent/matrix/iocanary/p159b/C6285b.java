package com.tencent.matrix.iocanary.p159b;

import com.tencent.matrix.iocanary.p160c.C1080a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.iocanary.b.b */
public final class C6285b extends C1064c implements InvocationHandler {
    private final Object bWn;

    public C6285b(C1063a c1063a, Object obj) {
        super(c1063a);
        this.bWn = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        C1070c.m2368i("Matrix.CloseGuardInvocationHandler", "invoke method: %s", method.getName());
        if (!method.getName().equals("report")) {
            return method.invoke(this.bWn, objArr);
        }
        if (objArr.length != 2) {
            C1070c.m2367e("Matrix.CloseGuardInvocationHandler", "closeGuard report should has 2 params, current: %d", Integer.valueOf(objArr.length));
            return null;
        } else if (objArr[1] instanceof Throwable) {
            String throwableStack = C1080a.getThrowableStack((Throwable) objArr[1]);
            if (mo4202cg(throwableStack)) {
                C1070c.m2366d("Matrix.CloseGuardInvocationHandler", "close leak issue already published; key:%s", throwableStack);
            } else {
                C1062b c1062b = new C1062b(4);
                c1062b.key = throwableStack;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, throwableStack);
                } catch (JSONException e) {
                    C1070c.m2367e("Matrix.CloseGuardInvocationHandler", "json content error: %s", e);
                }
                c1062b.bWv = jSONObject;
                mo4200b(c1062b);
                C1070c.m2366d("Matrix.CloseGuardInvocationHandler", "close leak issue publish, key:%s", throwableStack);
                mo4201cf(throwableStack);
            }
            return null;
        } else {
            C1070c.m2367e("Matrix.CloseGuardInvocationHandler", "closeGuard report args 1 should be throwable, current: %s", objArr[1]);
            return null;
        }
    }
}
