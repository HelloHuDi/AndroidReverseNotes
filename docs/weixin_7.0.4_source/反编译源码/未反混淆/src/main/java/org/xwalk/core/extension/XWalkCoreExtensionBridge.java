package org.xwalk.core.extension;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtension;

class XWalkCoreExtensionBridge extends XWalkExtension implements XWalkExternalExtensionBridge {
    private XWalkExternalExtension mExtension;

    public XWalkCoreExtensionBridge(XWalkExternalExtension xWalkExternalExtension) {
        super(xWalkExternalExtension.getExtensionName(), xWalkExternalExtension.getJsApi(), xWalkExternalExtension.getEntryPoints());
        AppMethodBeat.i(86161);
        this.mExtension = xWalkExternalExtension;
        AppMethodBeat.o(86161);
    }

    public void onMessage(int i, String str) {
        AppMethodBeat.i(86162);
        this.mExtension.onMessage(i, str);
        AppMethodBeat.o(86162);
    }

    public void onBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.i(86163);
        this.mExtension.onBinaryMessage(i, bArr);
        AppMethodBeat.o(86163);
    }

    public String onSyncMessage(int i, String str) {
        AppMethodBeat.i(86164);
        String onSyncMessage = this.mExtension.onSyncMessage(i, str);
        AppMethodBeat.o(86164);
        return onSyncMessage;
    }

    public void onInstanceCreated(int i) {
        AppMethodBeat.i(86165);
        this.mExtension.onInstanceCreated(i);
        AppMethodBeat.o(86165);
    }

    public void onInstanceDestroyed(int i) {
        AppMethodBeat.i(86166);
        this.mExtension.onInstanceDestroyed(i);
        AppMethodBeat.o(86166);
    }

    public void onDestroy() {
        AppMethodBeat.i(86167);
        this.mExtension.onDestroy();
        AppMethodBeat.o(86167);
    }

    public void onResume() {
        AppMethodBeat.i(86168);
        this.mExtension.onResume();
        AppMethodBeat.o(86168);
    }

    public void onPause() {
        AppMethodBeat.i(86169);
        this.mExtension.onPause();
        AppMethodBeat.o(86169);
    }

    public void onStart() {
        AppMethodBeat.i(86170);
        this.mExtension.onStart();
        AppMethodBeat.o(86170);
    }

    public void onStop() {
        AppMethodBeat.i(86171);
        this.mExtension.onStop();
        AppMethodBeat.o(86171);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(86172);
        this.mExtension.onNewIntent(intent);
        AppMethodBeat.o(86172);
    }

    public void postMessage(int i, String str) {
        AppMethodBeat.i(86173);
        super.postMessage(i, str);
        AppMethodBeat.o(86173);
    }

    public void postBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.i(86174);
        super.postBinaryMessage(i, bArr);
        AppMethodBeat.o(86174);
    }

    public void broadcastMessage(String str) {
        AppMethodBeat.i(86175);
        super.broadcastMessage(str);
        AppMethodBeat.o(86175);
    }
}
