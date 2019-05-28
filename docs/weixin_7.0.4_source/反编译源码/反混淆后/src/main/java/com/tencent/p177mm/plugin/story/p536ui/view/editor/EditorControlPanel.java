package com.tencent.p177mm.plugin.story.p536ui.view.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5230ak;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0011H\u0016J-\u0010\u0017\u001a\u00020\u00152#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelBottom", "Landroid/view/ViewGroup;", "panelTop", "visibleCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "isShow", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorControlPanel */
public final class EditorControlPanel extends FrameLayout {
    private C17126b<? super Boolean, C37091y> eUw;
    private final ViewGroup sln;
    private final ViewGroup slo;

    public EditorControlPanel(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110538);
        View.inflate(context, 2130970878, this);
        View findViewById = findViewById(2131828118);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_control_layout_top)");
        this.sln = (ViewGroup) findViewById;
        findViewById = findViewById(2131828123);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…or_control_layout_bottom)");
        this.slo = (ViewGroup) findViewById;
        this.slo.setPadding(0, 0, 0, C5230ak.m7988fr(context));
        AppMethodBeat.m2505o(110538);
    }

    public EditorControlPanel(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110539);
        AppMethodBeat.m2505o(110539);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(110537);
        C17126b c17126b;
        if (z) {
            setVisibility(0);
            c17126b = this.eUw;
            if (c17126b != null) {
                c17126b.mo50am(Boolean.TRUE);
                AppMethodBeat.m2505o(110537);
                return;
            }
            AppMethodBeat.m2505o(110537);
            return;
        }
        setVisibility(8);
        c17126b = this.eUw;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(110537);
            return;
        }
        AppMethodBeat.m2505o(110537);
    }

    public final void setOnVisibleChangeCallback(C17126b<? super Boolean, C37091y> c17126b) {
        this.eUw = c17126b;
    }
}
