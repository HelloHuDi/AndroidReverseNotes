package com.tencent.p177mm.plugin.emojicapture.p949c;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.p177mm.media.editor.p1203c.C42171c;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.C38926a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorItemContainer;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract;", "", "IPresenter", "IView", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.c.c */
public interface C42970c {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.c$b */
    public interface C27796b extends C38926a {
        EditorItemContainer getItemContainer();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.c.c$a */
    public interface C38903a {
        /* renamed from: G */
        boolean mo54536G(MotionEvent motionEvent);

        /* renamed from: a */
        void mo54537a(RectF rectF, float f);

        /* renamed from: dV */
        void mo54538dV(int i, int i2);

        C42171c getTouchTracker();

        /* renamed from: h */
        void mo54540h(Canvas canvas);

        /* renamed from: i */
        void mo54541i(Canvas canvas);

        void setEditing(boolean z);
    }
}
