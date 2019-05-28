package com.eclipsesource.p097v8.debug.mirror;

import com.eclipsesource.p097v8.Releasable;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.debug.mirror.PropertiesArray */
public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    PropertiesArray(V8Array v8Array) {
        AppMethodBeat.m2504i(74893);
        this.v8Array = v8Array.twin();
        AppMethodBeat.m2505o(74893);
    }

    public PropertyMirror getProperty(int i) {
        AppMethodBeat.m2504i(74894);
        V8Object object = this.v8Array.getObject(i);
        try {
            PropertyMirror propertyMirror = new PropertyMirror(object);
            return propertyMirror;
        } finally {
            object.release();
            AppMethodBeat.m2505o(74894);
        }
    }

    public void release() {
        AppMethodBeat.m2504i(74895);
        if (!this.v8Array.isReleased()) {
            this.v8Array.release();
        }
        AppMethodBeat.m2505o(74895);
    }

    public int length() {
        AppMethodBeat.m2504i(74896);
        int length = this.v8Array.length();
        AppMethodBeat.m2505o(74896);
        return length;
    }
}
