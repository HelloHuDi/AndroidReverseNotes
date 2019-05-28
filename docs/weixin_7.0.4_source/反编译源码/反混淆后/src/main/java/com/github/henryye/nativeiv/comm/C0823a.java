package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.bitmap.C37223c;
import com.github.henryye.nativeiv.bitmap.C45014b;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.github.henryye.nativeiv.comm.a */
public final class C0823a implements C45014b<NativeBitmapStruct> {
    HashMap<Integer, NativeImage> aMo = new HashMap();
    private NativeImageJni jni = new NativeImageJni();

    public C0823a() {
        AppMethodBeat.m2504i(115768);
        NativeImageJni nativeImageJni = this.jni;
        if (nativeImageJni.mNativeInst != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("NativeImageJni not released last time");
            AppMethodBeat.m2505o(115768);
            throw illegalStateException;
        }
        nativeImageJni.mNativeInst = nativeImageJni.nativeInit();
        AppMethodBeat.m2505o(115768);
    }

    /* renamed from: pz */
    public final IBitmap<NativeBitmapStruct> mo2519pz() {
        AppMethodBeat.m2504i(115769);
        NativeImage nativeImage = new NativeImage(this.jni, this);
        AppMethodBeat.m2505o(115769);
        return nativeImage;
    }

    /* renamed from: a */
    public final boolean mo2517a(C37223c c37223c) {
        return c37223c == C37223c.PNG || c37223c == C37223c.JPG;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(115770);
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
                AppMethodBeat.m2505o(115770);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((NativeImage) it.next()).recycle();
        }
        linkedList.clear();
    }
}
