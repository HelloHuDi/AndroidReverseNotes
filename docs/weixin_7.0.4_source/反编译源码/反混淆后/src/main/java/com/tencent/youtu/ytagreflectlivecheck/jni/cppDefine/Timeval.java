package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

public class Timeval {
    public final long tvSec;
    public final int tvUsec;

    public Timeval(long j, int i) {
        this.tvSec = j;
        this.tvUsec = i;
    }
}
