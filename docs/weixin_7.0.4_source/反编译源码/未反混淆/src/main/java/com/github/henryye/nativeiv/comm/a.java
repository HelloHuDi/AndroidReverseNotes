package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b<NativeBitmapStruct> {
    HashMap<Integer, NativeImage> aMo = new HashMap();
    private NativeImageJni jni = new NativeImageJni();

    public a() {
        AppMethodBeat.i(115768);
        NativeImageJni nativeImageJni = this.jni;
        if (nativeImageJni.mNativeInst != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("NativeImageJni not released last time");
            AppMethodBeat.o(115768);
            throw illegalStateException;
        }
        nativeImageJni.mNativeInst = nativeImageJni.nativeInit();
        AppMethodBeat.o(115768);
    }

    public final IBitmap<NativeBitmapStruct> pz() {
        AppMethodBeat.i(115769);
        NativeImage nativeImage = new NativeImage(this.jni, this);
        AppMethodBeat.o(115769);
        return nativeImage;
    }

    public final boolean a(c cVar) {
        return cVar == c.PNG || cVar == c.JPG;
    }

    public final void destroy() {
        AppMethodBeat.i(115770);
        NativeImageJni nativeImageJni = this.jni;
        if (nativeImageJni.mNativeInst != 0) {
            nativeImageJni.nativeDestroy(nativeImageJni.mNativeInst);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            try {
                for (NativeImage push : this.aMo.values()) {
                    linkedList.push(push);
                }
                this.aMo.clear();
            } finally {
                AppMethodBeat.o(115770);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((NativeImage) it.next()).recycle();
        }
        linkedList.clear();
    }
}
