package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Canvas;
import android.graphics.Paint;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\u0004H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "", "()V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.b */
public abstract class C9584b {
    long eUj;

    /* renamed from: UH */
    public abstract long mo20904UH();

    public abstract void destroy();

    public abstract void draw(Canvas canvas, Paint paint);

    public abstract void init();

    /* renamed from: ff */
    public long mo20907ff(long j) {
        while (this.eUj <= j) {
            this.eUj += mo20904UH();
        }
        this.eUj -= j;
        return this.eUj;
    }
}
