package org.xwalk.core.extension;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public interface XWalkExtensionContextClient {
    void broadcastMessage(XWalkExternalExtension xWalkExternalExtension, String str);

    Activity getActivity();

    Context getContext();

    void postBinaryMessage(XWalkExternalExtension xWalkExternalExtension, int i, byte[] bArr);

    void postMessage(XWalkExternalExtension xWalkExternalExtension, int i, String str);

    void registerExtension(XWalkExternalExtension xWalkExternalExtension);

    void startActivityForResult(Intent intent, int i, Bundle bundle);

    void unregisterExtension(String str);
}
