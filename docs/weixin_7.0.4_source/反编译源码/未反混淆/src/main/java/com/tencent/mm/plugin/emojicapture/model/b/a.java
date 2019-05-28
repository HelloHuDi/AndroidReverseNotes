package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.emojicapture.model.c;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
public final class a implements d {
    private final Paint aFY;
    private final Bitmap bitmap;
    private final Canvas bmG;
    private long eUj;
    List<b> eWG;
    private int height;
    private final Matrix lil;
    private final com.tencent.mm.media.f.b lim;
    private int width = c.lht;

    public a(RectF rectF) {
        j.p(rectF, "preViewRect");
        AppMethodBeat.i(2662);
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = c.lhw;
        aVar = c.lhw;
        this.height = c.lht;
        this.eWG = new ArrayList();
        this.lil = new Matrix();
        this.aFY = new Paint();
        this.lim = new com.tencent.mm.media.f.b(this.eWG);
        this.lil.setPolyToPoly(new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom}, 0, new float[]{0.0f, 0.0f, (float) this.width, (float) this.height}, 0, 2);
        this.aFY.setAntiAlias(true);
        this.aFY.setFilterBitmap(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
        j.o(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = createBitmap;
        this.bmG = new Canvas(this.bitmap);
        AppMethodBeat.o(2662);
    }

    public final com.tencent.mm.media.f.c UX() {
        AppMethodBeat.i(2659);
        if (this.eWG.size() <= 0) {
            AppMethodBeat.o(2659);
            return null;
        }
        int save = this.bmG.save();
        this.bmG.drawColor(0, Mode.MULTIPLY);
        this.bmG.concat(this.lil);
        this.eUj = this.lim.a(this.bmG, this.aFY);
        this.bmG.restoreToCount(save);
        com.tencent.mm.media.f.c cVar = new com.tencent.mm.media.f.c(this.bitmap, this.eUj);
        AppMethodBeat.o(2659);
        return cVar;
    }

    public final void stop() {
        AppMethodBeat.i(2660);
        for (b destroy : this.eWG) {
            destroy.destroy();
        }
        AppMethodBeat.o(2660);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(2661);
        if (bVar != null) {
            this.eWG.add(bVar);
        }
        AppMethodBeat.o(2661);
    }
}
