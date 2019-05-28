package com.tencent.p177mm.memory.p1206ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C26406i;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.memory.p1205b.C18602a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.memory.ui.PictureView */
public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private C26406i feT = null;
    private boolean feU = false;
    private Runnable feV = new C186071();

    /* renamed from: com.tencent.mm.memory.ui.PictureView$1 */
    class C186071 implements Runnable {
        C186071() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115483);
            PictureView.m29036a(PictureView.this);
            AppMethodBeat.m2505o(115483);
        }
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(115484);
        AppMethodBeat.m2505o(115484);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(115485);
        AppMethodBeat.m2505o(115485);
    }

    /* renamed from: aZ */
    private static String m29037aZ(Object obj) {
        AppMethodBeat.m2504i(115486);
        String str;
        if (obj == null) {
            str = "NULL";
            AppMethodBeat.m2505o(115486);
            return str;
        } else if (obj instanceof C18602a) {
            str = obj + " hashcode " + obj.hashCode() + " " + ((C18602a) obj).mo33855Xx() + " " + ((C18602a) obj).mo33855Xx().hashCode();
            AppMethodBeat.m2505o(115486);
            return str;
        } else {
            str = String.valueOf(obj);
            AppMethodBeat.m2505o(115486);
            return str;
        }
    }

    public void setReleasableBitmap(C45434n c45434n) {
        AppMethodBeat.m2504i(115487);
        if (c45434n == null || c45434n.equals(this.feT)) {
            AppMethodBeat.m2505o(115487);
            return;
        }
        setImageBitmap(c45434n.mo73230Xi());
        this.feT = c45434n;
        PictureView.m29038ba(this.feT);
        AppMethodBeat.m2505o(115487);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(115488);
        removeCallbacks(this.feV);
        if (drawable == null || drawable.equals(this.feT)) {
            AppMethodBeat.m2505o(115488);
            return;
        }
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + PictureView.m29037aZ(this.feT) + " new:" + PictureView.m29037aZ(drawable) + " " + C5046bo.dpG().toString());
        }
        PictureView.m29039bb(this.feT);
        if (drawable instanceof C26406i) {
            this.feT = (C26406i) drawable;
        } else {
            this.feT = null;
        }
        PictureView.m29038ba(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.m2505o(115488);
    }

    /* renamed from: ba */
    private static void m29038ba(Object obj) {
        AppMethodBeat.m2504i(115489);
        if (obj != null && (obj instanceof C26406i)) {
            ((C26406i) obj).mo33853Xd();
        }
        AppMethodBeat.m2505o(115489);
    }

    /* renamed from: bb */
    private static void m29039bb(Object obj) {
        AppMethodBeat.m2504i(115490);
        if (obj != null && (obj instanceof C26406i)) {
            ((C26406i) obj).mo33854Xe();
        }
        AppMethodBeat.m2505o(115490);
    }

    /* renamed from: Xy */
    private void m29035Xy() {
        AppMethodBeat.m2504i(115491);
        removeCallbacks(this.feV);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + C5046bo.dpG().toString());
        }
        if (this.feU) {
            AppMethodBeat.m2505o(115491);
            return;
        }
        this.feU = true;
        AppMethodBeat.m2505o(115491);
    }

    private void onDetach() {
        AppMethodBeat.m2504i(115492);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + C5046bo.dpG().toString());
        }
        if (this.feU) {
            this.feU = false;
            removeCallbacks(this.feV);
            postDelayed(this.feV, 500);
            AppMethodBeat.m2505o(115492);
            return;
        }
        AppMethodBeat.m2505o(115492);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(115493);
        super.onAttachedToWindow();
        m29035Xy();
        AppMethodBeat.m2505o(115493);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(115494);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.m2505o(115494);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.m2504i(115495);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.m2505o(115495);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.m2504i(115496);
        super.onFinishTemporaryDetach();
        m29035Xy();
        AppMethodBeat.m2505o(115496);
    }

    /* renamed from: a */
    static /* synthetic */ void m29036a(PictureView pictureView) {
        AppMethodBeat.m2504i(115497);
        PictureView.m29039bb(pictureView.feT);
        pictureView.feT = null;
        super.setImageDrawable(null);
        AppMethodBeat.m2505o(115497);
    }
}
