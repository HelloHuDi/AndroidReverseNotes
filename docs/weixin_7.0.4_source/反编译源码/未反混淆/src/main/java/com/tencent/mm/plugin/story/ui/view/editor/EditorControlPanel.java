package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ak;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0011H\u0016J-\u0010\u0017\u001a\u00020\u00152#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelBottom", "Landroid/view/ViewGroup;", "panelTop", "visibleCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "isShow", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-story_release"})
public final class EditorControlPanel extends FrameLayout {
    private b<? super Boolean, y> eUw;
    private final ViewGroup sln;
    private final ViewGroup slo;

    public EditorControlPanel(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110538);
        View.inflate(context, R.layout.aye, this);
        View findViewById = findViewById(R.id.esq);
        j.o(findViewById, "findViewById(R.id.story_editor_control_layout_top)");
        this.sln = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.esv);
        j.o(findViewById, "findViewById(R.id.story_…or_control_layout_bottom)");
        this.slo = (ViewGroup) findViewById;
        this.slo.setPadding(0, 0, 0, ak.fr(context));
        AppMethodBeat.o(110538);
    }

    public EditorControlPanel(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110539);
        AppMethodBeat.o(110539);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(110537);
        b bVar;
        if (z) {
            setVisibility(0);
            bVar = this.eUw;
            if (bVar != null) {
                bVar.am(Boolean.TRUE);
                AppMethodBeat.o(110537);
                return;
            }
            AppMethodBeat.o(110537);
            return;
        }
        setVisibility(8);
        bVar = this.eUw;
        if (bVar != null) {
            bVar.am(Boolean.FALSE);
            AppMethodBeat.o(110537);
            return;
        }
        AppMethodBeat.o(110537);
    }

    public final void setOnVisibleChangeCallback(b<? super Boolean, y> bVar) {
        this.eUw = bVar;
    }
}
