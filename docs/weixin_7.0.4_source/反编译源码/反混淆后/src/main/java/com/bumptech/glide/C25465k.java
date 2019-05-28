package com.bumptech.glide;

import com.bumptech.glide.p791f.p792b.C25458a;
import com.bumptech.glide.p791f.p792b.C25459c;

/* renamed from: com.bumptech.glide.k */
public abstract class C25465k<CHILD extends C25465k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    C25459c<? super TranscodeType> axu = C25458a.m40230oh();

    /* renamed from: lJ */
    public final CHILD clone() {
        try {
            return (C25465k) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
