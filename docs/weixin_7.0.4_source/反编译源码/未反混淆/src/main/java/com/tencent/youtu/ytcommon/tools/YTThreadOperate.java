package com.tencent.youtu.ytcommon.tools;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class YTThreadOperate {
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public interface UiThreadCallback<T> {
        void callback(T t);
    }

    static {
        AppMethodBeat.i(118111);
        AppMethodBeat.o(118111);
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(118106);
        mHandler.post(runnable);
        AppMethodBeat.o(118106);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        AppMethodBeat.i(118107);
        mHandler.postDelayed(runnable, j);
        AppMethodBeat.o(118107);
    }

    public static void runOnSubThread(final Runnable runnable) {
        AppMethodBeat.i(118108);
        mExecutorService.submit(new Runnable() {
            public final void run() {
                AppMethodBeat.i(118102);
                runnable.run();
                AppMethodBeat.o(118102);
            }
        });
        AppMethodBeat.o(118108);
    }

    public static <T> Future<T> runOnSubThread(final Callable<T> callable) {
        AppMethodBeat.i(118109);
        Future submit = mExecutorService.submit(new Callable<T>() {
            public final T call() {
                AppMethodBeat.i(118103);
                try {
                    Object call = callable.call();
                    AppMethodBeat.o(118103);
                    return call;
                } catch (Exception e) {
                    AppMethodBeat.o(118103);
                    return null;
                }
            }
        });
        AppMethodBeat.o(118109);
        return submit;
    }

    public static <T> void runOnSubThread(final Callable<T> callable, final UiThreadCallback<T> uiThreadCallback) {
        AppMethodBeat.i(118110);
        mExecutorService.submit(new Runnable() {
            public final void run() {
                AppMethodBeat.i(118105);
                Object obj = null;
                try {
                    obj = callable.call();
                } catch (Exception e) {
                }
                YTThreadOperate.mHandler.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(118104);
                        if (uiThreadCallback != null) {
                            try {
                                uiThreadCallback.callback(obj);
                                AppMethodBeat.o(118104);
                                return;
                            } catch (Exception e) {
                                YTException.report(e);
                            }
                        }
                        AppMethodBeat.o(118104);
                    }
                });
                AppMethodBeat.o(118105);
            }
        });
        AppMethodBeat.o(118110);
    }
}
