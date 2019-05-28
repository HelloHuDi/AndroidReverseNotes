package org.xwalk.core.extension;

import android.content.Intent;

interface XWalkExternalExtensionBridge {
    void broadcastMessage(String str);

    void onBinaryMessage(int i, byte[] bArr);

    void onDestroy();

    void onInstanceCreated(int i);

    void onInstanceDestroyed(int i);

    void onMessage(int i, String str);

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    String onSyncMessage(int i, String str);

    void postBinaryMessage(int i, byte[] bArr);

    void postMessage(int i, String str);
}
