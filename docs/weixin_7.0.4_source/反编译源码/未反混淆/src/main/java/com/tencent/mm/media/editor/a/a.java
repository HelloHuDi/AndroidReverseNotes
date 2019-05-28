package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, dWq = {"Lcom/tencent/mm/media/editor/item/BaseEditorData;", "", "dataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setDataType", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public abstract class a {
    public e eUi;

    public abstract com.tencent.mm.bt.a UG();

    public a(e eVar) {
        j.p(eVar, "dataType");
        this.eUi = eVar;
    }
}
