package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.source.l;

public interface r extends b {
    void a(t tVar, Format[] formatArr, l lVar, long j, boolean z, long j2);

    void a(Format[] formatArr, l lVar, long j);

    void disable();

    void f(long j, long j2);

    int getState();

    int getTrackType();

    boolean isReady();

    s pC();

    h pD();

    l pE();

    boolean pF();

    void pG();

    boolean pH();

    void pI();

    boolean qf();

    void setIndex(int i);

    void start();

    void stop();

    void v(long j);
}
