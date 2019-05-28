package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface CallbackManager {

    public static class Factory {
        public static CallbackManager create() {
            AppMethodBeat.i(71572);
            CallbackManagerImpl callbackManagerImpl = new CallbackManagerImpl();
            AppMethodBeat.o(71572);
            return callbackManagerImpl;
        }
    }

    boolean onActivityResult(int i, int i2, Intent intent);
}
