package com.tencent.p177mm.media.editor.p1202b;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.view.C32506a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J-\u0010\u0011\u001a\u00020\u000f2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.b.a */
public final class C18590a extends C32506a {
    public C17126b<? super Boolean, C37091y> eUw;

    public C18590a(Context context, ViewGroup viewGroup) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(viewGroup, "parent");
        super(context, viewGroup);
        AppMethodBeat.m2504i(12899);
        AppMethodBeat.m2505o(12899);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(12896);
        if (z) {
            show();
            AppMethodBeat.m2505o(12896);
            return;
        }
        dismiss();
        AppMethodBeat.m2505o(12896);
    }

    public final void show() {
        AppMethodBeat.m2504i(12897);
        super.show();
        C17126b c17126b = this.eUw;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.TRUE);
            AppMethodBeat.m2505o(12897);
            return;
        }
        AppMethodBeat.m2505o(12897);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(12898);
        super.dismiss();
        C17126b c17126b = this.eUw;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(12898);
            return;
        }
        AppMethodBeat.m2505o(12898);
    }
}
