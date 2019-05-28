package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class AutoMatchKeywordEditText extends MMEditText {
    private a zLO;
    private int zLP;
    private int zLQ;

    public interface a {
        void b(EditText editText, int i, int i2);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107833);
        init();
        AppMethodBeat.o(107833);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107834);
        init();
        AppMethodBeat.o(107834);
    }

    private void init() {
        AppMethodBeat.i(107835);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        AppMethodBeat.o(107835);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107836);
        super.onDraw(canvas);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (!(this.zLP == selectionStart && this.zLQ == selectionEnd)) {
            this.zLP = selectionStart;
            this.zLQ = selectionEnd;
            if (this.zLO != null) {
                this.zLO.b(this, getSelectionStart(), getSelectionEnd());
            }
        }
        AppMethodBeat.o(107836);
    }

    public void setSelection(int i) {
        AppMethodBeat.i(107837);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.zLO == null)) {
            this.zLO.b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(107837);
    }

    public void setSelection(int i, int i2) {
        AppMethodBeat.i(107838);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i, i2);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.zLO == null)) {
            this.zLO.b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(107838);
    }

    public void extendSelection(int i) {
        AppMethodBeat.i(107839);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
        super.extendSelection(i);
        this.zLP = getSelectionStart();
        this.zLQ = getSelectionEnd();
        AppMethodBeat.o(107839);
    }

    public boolean moveCursorToVisibleOffset() {
        AppMethodBeat.i(107840);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
        boolean moveCursorToVisibleOffset = super.moveCursorToVisibleOffset();
        AppMethodBeat.o(107840);
        return moveCursorToVisibleOffset;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        AppMethodBeat.i(107841);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
        boolean performAccessibilityAction = super.performAccessibilityAction(i, bundle);
        AppMethodBeat.o(107841);
        return performAccessibilityAction;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        AppMethodBeat.i(107842);
        ab.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
        boolean onDragEvent = super.onDragEvent(dragEvent);
        AppMethodBeat.o(107842);
        return onDragEvent;
    }

    public a getOnSelectionChangeListener() {
        return this.zLO;
    }

    public void setOnSelectionChangeListener(a aVar) {
        this.zLO = aVar;
    }
}
