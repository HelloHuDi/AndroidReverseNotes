package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExtensionInstanceHelper {
    XWalkExternalExtension mExtension;
    MessageHandler mHandler = new MessageHandler(this.mExtension.getMessageHandler());
    int mId;
    private BindingObjectStore mStore;

    public ExtensionInstanceHelper(XWalkExternalExtension xWalkExternalExtension, int i) {
        AppMethodBeat.i(86101);
        this.mId = i;
        this.mExtension = xWalkExternalExtension;
        if (this.mExtension.isAutoJS()) {
            ReflectionHelper.registerHandlers(this.mExtension.getReflection(), this.mHandler, this.mExtension);
        }
        this.mStore = new BindingObjectStore(this.mHandler, this);
        AppMethodBeat.o(86101);
    }

    public int getId() {
        return this.mId;
    }

    public XWalkExternalExtension getExtension() {
        return this.mExtension;
    }

    public BindingObject getBindingObject(String str) {
        AppMethodBeat.i(86102);
        BindingObject bindingObject = this.mStore.getBindingObject(str);
        AppMethodBeat.o(86102);
        return bindingObject;
    }

    public boolean addBindingObject(String str, BindingObject bindingObject) {
        AppMethodBeat.i(86103);
        boolean addBindingObject = this.mStore.addBindingObject(str, bindingObject);
        AppMethodBeat.o(86103);
        return addBindingObject;
    }

    public BindingObject removeBindingObject(String str) {
        AppMethodBeat.i(86104);
        BindingObject removeBindingObject = this.mStore.removeBindingObject(str);
        AppMethodBeat.o(86104);
        return removeBindingObject;
    }

    public Object handleMessage(String str) {
        AppMethodBeat.i(86105);
        Object handleMessage = this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, str));
        AppMethodBeat.o(86105);
        return handleMessage;
    }

    public Object handleMessage(byte[] bArr) {
        AppMethodBeat.i(86106);
        Object handleMessage = this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, bArr));
        AppMethodBeat.o(86106);
        return handleMessage;
    }
}
