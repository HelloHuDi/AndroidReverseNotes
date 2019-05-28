package com.tencent.p177mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.remoteservice.C30258b.C30259a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.remoteservice.a */
public class C31577a extends C30259a {
    private final C46607d ext;
    protected RemoteService xtU;
    public C30258b xtV;

    public C31577a(C46607d c46607d) {
        this.ext = c46607d;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(80217);
        C4990ab.m7411d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? C40602e.class : C46608f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.m2505o(80217);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BaseClientRequest", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(80217);
        }
    }

    public Object REMOTE_CALL(final String str, final Object... objArr) {
        AppMethodBeat.m2504i(80218);
        if (this.ext.isConnected()) {
            Bundle objectsToBundle = objectsToBundle(objArr);
            this.ext.mo74749a(this, str, objectsToBundle);
            objectsToBundle.setClassLoader(getClass().getClassLoader());
            Object obj = objectsToBundle.get("result_key");
            AppMethodBeat.m2505o(80218);
            return obj;
        }
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80216);
                C31577a.this.ext.mo74749a(C31577a.this, str, C31577a.this.objectsToBundle(objArr));
                AppMethodBeat.m2505o(80216);
            }
        });
        AppMethodBeat.m2505o(80218);
        return null;
    }

    public Object CLIENT_CALL(String str, Object... objArr) {
        AppMethodBeat.m2504i(80219);
        Bundle objectsToBundle = objectsToBundle(objArr);
        try {
            this.xtV.onCallback(str, objectsToBundle, true);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BaseClientRequest", "exception:%s", C5046bo.m7574l(e));
        }
        Object obj = objectsToBundle.get("result_key");
        AppMethodBeat.m2505o(80219);
        return obj;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.m2504i(80220);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        AppMethodBeat.m2505o(80220);
        return bundle;
    }

    public Object[] getArgs(Bundle bundle) {
        AppMethodBeat.m2504i(80221);
        LinkedList linkedList = new LinkedList();
        int size = bundle.size();
        for (int i = 0; i < size; i++) {
            String valueOf = String.valueOf(i);
            if (bundle.containsKey(valueOf)) {
                linkedList.add(bundle.get(valueOf));
            }
        }
        Object[] toArray = linkedList.toArray();
        AppMethodBeat.m2505o(80221);
        return toArray;
    }
}
