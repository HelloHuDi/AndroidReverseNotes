package com.google.android.gms.tasks;

interface zzq<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
