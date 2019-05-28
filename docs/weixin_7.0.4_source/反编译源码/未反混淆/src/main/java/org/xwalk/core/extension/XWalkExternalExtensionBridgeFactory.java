package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class XWalkExternalExtensionBridgeFactory {
    XWalkExternalExtensionBridgeFactory() {
    }

    public static XWalkExternalExtensionBridge createInstance(XWalkExternalExtension xWalkExternalExtension) {
        AppMethodBeat.i(86190);
        XWalkCoreExtensionBridge xWalkCoreExtensionBridge = new XWalkCoreExtensionBridge(xWalkExternalExtension);
        AppMethodBeat.o(86190);
        return xWalkCoreExtensionBridge;
    }
}
