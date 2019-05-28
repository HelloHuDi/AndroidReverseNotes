package com.tencent.mm.media.editor.b;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J-\u0010\u0011\u001a\u00020\u000f2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-mediaeditor_release"})
public final class a extends com.tencent.mm.emoji.view.a {
    public b<? super Boolean, y> eUw;

    public a(Context context, ViewGroup viewGroup) {
        j.p(context, "context");
        j.p(viewGroup, "parent");
        super(context, viewGroup);
        AppMethodBeat.i(12899);
        AppMethodBeat.o(12899);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(12896);
        if (z) {
            show();
            AppMethodBeat.o(12896);
            return;
        }
        dismiss();
        AppMethodBeat.o(12896);
    }

    public final void show() {
        AppMethodBeat.i(12897);
        super.show();
        b bVar = this.eUw;
        if (bVar != null) {
            bVar.am(Boolean.TRUE);
            AppMethodBeat.o(12897);
            return;
        }
        AppMethodBeat.o(12897);
    }

    public final void dismiss() {
        AppMethodBeat.i(12898);
        super.dismiss();
        b bVar = this.eUw;
        if (bVar != null) {
            bVar.am(Boolean.FALSE);
            AppMethodBeat.o(12898);
            return;
        }
        AppMethodBeat.o(12898);
    }
}
