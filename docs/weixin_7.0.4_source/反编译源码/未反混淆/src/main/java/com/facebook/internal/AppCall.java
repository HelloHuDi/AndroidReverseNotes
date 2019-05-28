package com.facebook.internal;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        return currentPendingCall;
    }

    public static synchronized AppCall finishPendingCall(UUID uuid, int i) {
        AppCall currentPendingCall;
        synchronized (AppCall.class) {
            AppMethodBeat.i(96609);
            currentPendingCall = getCurrentPendingCall();
            if (currentPendingCall != null && currentPendingCall.getCallId().equals(uuid) && currentPendingCall.getRequestCode() == i) {
                setCurrentPendingCall(null);
                AppMethodBeat.o(96609);
            } else {
                AppMethodBeat.o(96609);
                currentPendingCall = null;
            }
        }
        return currentPendingCall;
    }

    private static synchronized boolean setCurrentPendingCall(AppCall appCall) {
        boolean z;
        synchronized (AppCall.class) {
            AppMethodBeat.i(96610);
            AppCall currentPendingCall = getCurrentPendingCall();
            currentPendingCall = appCall;
            if (currentPendingCall != null) {
                z = true;
                AppMethodBeat.o(96610);
            } else {
                z = false;
                AppMethodBeat.o(96610);
            }
        }
        return z;
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
        AppMethodBeat.i(96611);
        AppMethodBeat.o(96611);
    }

    public AppCall(int i, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i;
    }

    public Intent getRequestIntent() {
        return this.requestIntent;
    }

    public UUID getCallId() {
        return this.callId;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public void setRequestIntent(Intent intent) {
        this.requestIntent = intent;
    }

    public boolean setPending() {
        AppMethodBeat.i(96612);
        boolean currentPendingCall = setCurrentPendingCall(this);
        AppMethodBeat.o(96612);
        return currentPendingCall;
    }
}
