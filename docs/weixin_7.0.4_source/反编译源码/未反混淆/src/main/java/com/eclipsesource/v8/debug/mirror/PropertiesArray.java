package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    PropertiesArray(V8Array v8Array) {
        AppMethodBeat.i(74893);
        this.v8Array = v8Array.twin();
        AppMethodBeat.o(74893);
    }

    public PropertyMirror getProperty(int i) {
        AppMethodBeat.i(74894);
        V8Object object = this.v8Array.getObject(i);
        try {
            PropertyMirror propertyMirror = new PropertyMirror(object);
            return propertyMirror;
        } finally {
            object.release();
            AppMethodBeat.o(74894);
        }
    }

    public void release() {
        AppMethodBeat.i(74895);
        if (!this.v8Array.isReleased()) {
            this.v8Array.release();
        }
        AppMethodBeat.o(74895);
    }

    public int length() {
        AppMethodBeat.i(74896);
        int length = this.v8Array.length();
        AppMethodBeat.o(74896);
        return length;
    }
}
