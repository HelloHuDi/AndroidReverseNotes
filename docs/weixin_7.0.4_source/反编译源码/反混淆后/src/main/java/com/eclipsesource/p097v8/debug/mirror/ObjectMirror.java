package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.ObjectMirror */
public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    /* renamed from: com.eclipsesource.v8.debug.mirror.ObjectMirror$PropertyKind */
    public enum PropertyKind {
        Named(1),
        Indexed(2);
        
        int index;

        static {
            AppMethodBeat.m2505o(74889);
        }

        private PropertyKind(int i) {
            this.index = i;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(74890);
        String v8Object = this.v8Object.toString();
        AppMethodBeat.m2505o(74890);
        return v8Object;
    }

    ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isObject() {
        return true;
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i) {
        AppMethodBeat.m2504i(74891);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            String[] strArr = new String[v8Array2.length()];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = v8Array2.getString(i2);
            }
            return strArr;
        } finally {
            v8Array.release();
            if (v8Array2 != null) {
                v8Array2.release();
            }
            AppMethodBeat.m2505o(74891);
        }
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i) {
        AppMethodBeat.m2504i(74892);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
            PropertiesArray propertiesArray = new PropertiesArray(v8Array2);
            return propertiesArray;
        } finally {
            v8Array.release();
            if (!(v8Array2 == null || v8Array2.isReleased())) {
                v8Array2.release();
            }
            AppMethodBeat.m2505o(74892);
        }
    }
}
