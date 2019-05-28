package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.AutoMatchKeywordEditText */
public class AutoMatchKeywordEditText extends MMEditText {
    private C5619a zLO;
    private int zLP;
    private int zLQ;

    /* renamed from: com.tencent.mm.ui.widget.AutoMatchKeywordEditText$a */
    public interface C5619a {
        /* renamed from: b */
        void mo11388b(EditText editText, int i, int i2);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107833);
        init();
        AppMethodBeat.m2505o(107833);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107834);
        init();
        AppMethodBeat.m2505o(107834);
    }

    private void init() {
        AppMethodBeat.m2504i(107835);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        AppMethodBeat.m2505o(107835);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107836);
        super.onDraw(canvas);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (!(this.zLP == selectionStart && this.zLQ == selectionEnd)) {
            this.zLP = selectionStart;
            this.zLQ = selectionEnd;
            if (this.zLO != null) {
                this.zLO.mo11388b(this, getSelectionStart(), getSelectionEnd());
            }
        }
        AppMethodBeat.m2505o(107836);
    }

    public void setSelection(int i) {
        AppMethodBeat.m2504i(107837);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.zLO == null)) {
            this.zLO.mo11388b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.m2505o(107837);
    }

    public void setSelection(int i, int i2) {
        AppMethodBeat.m2504i(107838);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i, i2);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.zLO == null)) {
            this.zLO.mo11388b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.m2505o(107838);
    }

    public void extendSelection(int i) {
        AppMethodBeat.m2504i(107839);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
        super.extendSelection(i);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        AppMethodBeat.m2505o(107839);
    }

    public boolean moveCursorToVisibleOffset() {
        AppMethodBeat.m2504i(107840);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
        boolean moveCursorToVisibleOffset = super.moveCursorToVisibleOffset();
        AppMethodBeat.m2505o(107840);
        return moveCursorToVisibleOffset;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        AppMethodBeat.m2504i(107841);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
        boolean performAccessibilityAction = super.performAccessibilityAction(i, bundle);
        AppMethodBeat.m2505o(107841);
        return performAccessibilityAction;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        AppMethodBeat.m2504i(107842);
        C4990ab.m7410d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
        boolean onDragEvent = super.onDragEvent(dragEvent);
        AppMethodBeat.m2505o(107842);
        return onDragEvent;
    }

    public C5619a getOnSelectionChangeListener() {
        return this.zLO;
    }

    public void setOnSelectionChangeListener(C5619a c5619a) {
        this.zLO = c5619a;
    }
}
