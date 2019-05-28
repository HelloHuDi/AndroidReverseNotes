package com.google.android.gms.auth.api.phone;

import com.google.android.gms.tasks.Task;

public interface SmsRetrieverApi {
    Task<Void> startSmsRetriever();
}
