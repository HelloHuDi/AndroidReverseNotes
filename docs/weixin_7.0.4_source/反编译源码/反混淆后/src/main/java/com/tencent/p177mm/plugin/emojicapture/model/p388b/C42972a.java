package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.p253f.C1778c;
import com.tencent.p177mm.media.p253f.C1779d;
import com.tencent.p177mm.media.p253f.C32744b;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "preViewRect", "Landroid/graphics/RectF;", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "currFrameTime", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "height", "", "paint", "Landroid/graphics/Paint;", "preViewMatrix", "Landroid/graphics/Matrix;", "width", "addItem", "", "item", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "stop", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.a */
public final class C42972a implements C1779d {
    private final Paint aFY;
    private final Bitmap bitmap;
    private final Canvas bmG;
    private long eUj;
    List<C9584b> eWG;
    private int height;
    private final Matrix lil;
    private final C32744b lim;
    private int width = C34006c.lht;

    public C42972a(RectF rectF) {
        C25052j.m39376p(rectF, "preViewRect");
        AppMethodBeat.m2504i(2662);
        C11617a c11617a = C34006c.lhw;
        c11617a = C34006c.lhw;
        this.height = C34006c.lht;
        this.eWG = new ArrayList();
        this.lil = new Matrix();
        this.aFY = new Paint();
        this.lim = new C32744b(this.eWG);
        this.lil.setPolyToPoly(new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom}, 0, new float[]{0.0f, 0.0f, (float) this.width, (float) this.height}, 0, 2);
        this.aFY.setAntiAlias(true);
        this.aFY.setFilterBitmap(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
        C25052j.m39375o(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = createBitmap;
        this.bmG = new Canvas(this.bitmap);
        AppMethodBeat.m2505o(2662);
    }

    /* renamed from: UX */
    public final C1778c mo5327UX() {
        AppMethodBeat.m2504i(2659);
        if (this.eWG.size() <= 0) {
            AppMethodBeat.m2505o(2659);
            return null;
        }
        int save = this.bmG.save();
        this.bmG.drawColor(0, Mode.MULTIPLY);
        this.bmG.concat(this.lil);
        this.eUj = this.lim.mo53300a(this.bmG, this.aFY);
        this.bmG.restoreToCount(save);
        C1778c c1778c = new C1778c(this.bitmap, this.eUj);
        AppMethodBeat.m2505o(2659);
        return c1778c;
    }

    public final void stop() {
        AppMethodBeat.m2504i(2660);
        for (C9584b destroy : this.eWG) {
            destroy.destroy();
        }
        AppMethodBeat.m2505o(2660);
    }

    /* renamed from: a */
    public final void mo68503a(C9584b c9584b) {
        AppMethodBeat.m2504i(2661);
        if (c9584b != null) {
            this.eWG.add(c9584b);
        }
        AppMethodBeat.m2505o(2661);
    }
}
