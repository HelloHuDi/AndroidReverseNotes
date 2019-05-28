package com.bumptech.glide;

import com.bumptech.glide.f.b.a;
import com.bumptech.glide.f.b.c;

public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    c<? super TranscodeType> axu = a.oh();

    /* renamed from: lJ */
    public final CHILD clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
