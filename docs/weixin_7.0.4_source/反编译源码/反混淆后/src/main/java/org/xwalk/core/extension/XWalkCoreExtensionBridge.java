package org.xwalk.core.extension;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtension;

class XWalkCoreExtensionBridge extends XWalkExtension implements XWalkExternalExtensionBridge {
    private XWalkExternalExtension mExtension;

    public XWalkCoreExtensionBridge(XWalkExternalExtension xWalkExternalExtension) {
        super(xWalkExternalExtension.getExtensionName(), xWalkExternalExtension.getJsApi(), xWalkExternalExtension.getEntryPoints());
        AppMethodBeat.m2504i(86161);
        this.mExtension = xWalkExternalExtension;
        AppMethodBeat.m2505o(86161);
    }

    public void onMessage(int i, String str) {
        AppMethodBeat.m2504i(86162);
        this.mExtension.onMessage(i, str);
        AppMethodBeat.m2505o(86162);
    }

    public void onBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.m2504i(86163);
        this.mExtension.onBinaryMessage(i, bArr);
        AppMethodBeat.m2505o(86163);
    }

    public String onSyncMessage(int i, String str) {
        AppMethodBeat.m2504i(86164);
        String onSyncMessage = this.mExtension.onSyncMessage(i, str);
        AppMethodBeat.m2505o(86164);
        return onSyncMessage;
    }

    public void onInstanceCreated(int i) {
        AppMethodBeat.m2504i(86165);
        this.mExtension.onInstanceCreated(i);
        AppMethodBeat.m2505o(86165);
    }

    public void onInstanceDestroyed(int i) {
        AppMethodBeat.m2504i(86166);
        this.mExtension.onInstanceDestroyed(i);
        AppMethodBeat.m2505o(86166);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(86167);
        this.mExtension.onDestroy();
        AppMethodBeat.m2505o(86167);
    }

    public void onResume() {
        AppMethodBeat.m2504i(86168);
        this.mExtension.onResume();
        AppMethodBeat.m2505o(86168);
    }

    public void onPause() {
        AppMethodBeat.m2504i(86169);
        this.mExtension.onPause();
        AppMethodBeat.m2505o(86169);
    }

    public void onStart() {
        AppMethodBeat.m2504i(86170);
        this.mExtension.onStart();
        AppMethodBeat.m2505o(86170);
    }

    public void onStop() {
        AppMethodBeat.m2504i(86171);
        this.mExtension.onStop();
        AppMethodBeat.m2505o(86171);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(86172);
        this.mExtension.onNewIntent(intent);
        AppMethodBeat.m2505o(86172);
    }

    public void postMessage(int i, String str) {
        AppMethodBeat.m2504i(86173);
        super.postMessage(i, str);
        AppMethodBeat.m2505o(86173);
    }

    public void postBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.m2504i(86174);
        super.postBinaryMessage(i, bArr);
        AppMethodBeat.m2505o(86174);
    }

    public void broadcastMessage(String str) {
        AppMethodBeat.m2504i(86175);
        super.broadcastMessage(str);
        AppMethodBeat.m2505o(86175);
    }
}
