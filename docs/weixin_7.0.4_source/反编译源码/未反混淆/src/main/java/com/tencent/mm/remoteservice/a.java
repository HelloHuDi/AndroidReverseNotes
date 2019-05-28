package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class a extends com.tencent.mm.remoteservice.b.a {
    private final d ext;
    protected RemoteService xtU;
    public b xtV;

    public a(d dVar) {
        this.ext = dVar;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(80217);
        ab.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(80217);
        } catch (Exception e) {
            ab.e("MicroMsg.BaseClientRequest", "exception:%s", bo.l(e));
            AppMethodBeat.o(80217);
        }
    }

    public Object REMOTE_CALL(final String str, final Object... objArr) {
        AppMethodBeat.i(80218);
        if (this.ext.isConnected()) {
            Bundle objectsToBundle = objectsToBundle(objArr);
            this.ext.a(this, str, objectsToBundle);
            objectsToBundle.setClassLoader(getClass().getClassLoader());
            Object obj = objectsToBundle.get("result_key");
            AppMethodBeat.o(80218);
            return obj;
        }
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80216);
                a.this.ext.a(a.this, str, a.this.objectsToBundle(objArr));
                AppMethodBeat.o(80216);
            }
        });
        AppMethodBeat.o(80218);
        return null;
    }

    public Object CLIENT_CALL(String str, Object... objArr) {
        AppMethodBeat.i(80219);
        Bundle objectsToBundle = objectsToBundle(objArr);
        try {
            this.xtV.onCallback(str, objectsToBundle, true);
        } catch (Exception e) {
            ab.e("MicroMsg.BaseClientRequest", "exception:%s", bo.l(e));
        }
        Object obj = objectsToBundle.get("result_key");
        AppMethodBeat.o(80219);
        return obj;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(80220);
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
        AppMethodBeat.o(80220);
        return bundle;
    }

    public Object[] getArgs(Bundle bundle) {
        AppMethodBeat.i(80221);
        LinkedList linkedList = new LinkedList();
        int size = bundle.size();
        for (int i = 0; i < size; i++) {
            String valueOf = String.valueOf(i);
            if (bundle.containsKey(valueOf)) {
                linkedList.add(bundle.get(valueOf));
            }
        }
        Object[] toArray = linkedList.toArray();
        AppMethodBeat.o(80221);
        return toArray;
    }
}
