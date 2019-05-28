package com.tencent.mm.at.a.c;

import java.util.concurrent.Executor;

public interface h extends Executor {
    boolean DA();

    boolean isShutdown();

    void pause();

    void remove(Object obj);

    void resume();
}
