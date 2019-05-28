package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u000b\u001a\u00020\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleLeft", "getBubbleLeft", "()I", "setBubbleLeft", "(I)V", "bubbleTop", "getBubbleTop", "setBubbleTop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
public final class StoryCommentBubbleView extends ImageView {
    private int siT;
    private int siU;

    public StoryCommentBubbleView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110378);
        AppMethodBeat.o(110378);
    }

    public StoryCommentBubbleView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110379);
        AppMethodBeat.o(110379);
    }

    public final void setBubbleLeft(int i) {
        this.siT = i;
    }

    public final int getBubbleLeft() {
        AppMethodBeat.i(138897);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[0];
        AppMethodBeat.o(138897);
        return i;
    }

    public final void setBubbleTop(int i) {
        this.siU = i;
    }

    public final int getBubbleTop() {
        AppMethodBeat.i(138898);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[1];
        AppMethodBeat.o(138898);
        return i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(110377);
        j.p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                animate().scaleX(1.3f).scaleY(1.3f).setDuration(100).start();
                break;
            case 1:
            case 3:
                animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(110377);
        return onTouchEvent;
    }
}
