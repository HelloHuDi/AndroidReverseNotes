package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T value;

    public LockOnGetVariable(T t) {
        this.value = t;
    }

    public LockOnGetVariable(final Callable<T> callable) {
        AppMethodBeat.i(72402);
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable<Void>() {
            public Void call() {
                AppMethodBeat.i(72400);
                try {
                    LockOnGetVariable.this.value = callable.call();
                    LockOnGetVariable.this.initLatch.countDown();
                    AppMethodBeat.o(72400);
                    return null;
                } catch (Throwable th) {
                    LockOnGetVariable.this.initLatch.countDown();
                    AppMethodBeat.o(72400);
                }
            }
        }));
        AppMethodBeat.o(72402);
    }

    public T getValue() {
        AppMethodBeat.i(72403);
        waitOnInit();
        Object obj = this.value;
        AppMethodBeat.o(72403);
        return obj;
    }

    private void waitOnInit() {
        AppMethodBeat.i(72404);
        if (this.initLatch == null) {
            AppMethodBeat.o(72404);
            return;
        }
        try {
            this.initLatch.await();
            AppMethodBeat.o(72404);
        } catch (InterruptedException e) {
            AppMethodBeat.o(72404);
        }
    }
}
