package com.tencent.p177mm.memory.p1206ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C26406i;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.memory.p1205b.C18602a;
import com.tencent.p177mm.p612ui.widget.QImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.memory.ui.QPictureView */
public class QPictureView extends QImageView {
    private boolean DEBUG = false;
    private C26406i feT = null;
    private boolean feU = false;
    private Runnable feV = new C327721();

    /* renamed from: com.tencent.mm.memory.ui.QPictureView$1 */
    class C327721 implements Runnable {
        C327721() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115498);
            QPictureView.m53531a(QPictureView.this);
            AppMethodBeat.m2505o(115498);
        }
    }

    public QPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(115499);
        AppMethodBeat.m2505o(115499);
    }

    public QPictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(115500);
        AppMethodBeat.m2505o(115500);
    }

    /* renamed from: aZ */
    private static String m53532aZ(Object obj) {
        AppMethodBeat.m2504i(115501);
        String str;
        if (obj == null) {
            str = "NULL";
            AppMethodBeat.m2505o(115501);
            return str;
        } else if (obj instanceof C18602a) {
            str = obj + " hashcode " + obj.hashCode() + " " + ((C18602a) obj).mo33855Xx() + " " + ((C18602a) obj).mo33855Xx().hashCode();
            AppMethodBeat.m2505o(115501);
            return str;
        } else {
            str = String.valueOf(obj);
            AppMethodBeat.m2505o(115501);
            return str;
        }
    }

    public void setReleasableBitmap(C45434n c45434n) {
        AppMethodBeat.m2504i(115502);
        if (c45434n == null || c45434n.equals(this.feT)) {
            AppMethodBeat.m2505o(115502);
            return;
        }
        setImageBitmap(c45434n.mo73230Xi());
        this.feT = c45434n;
        QPictureView.m53533ba(this.feT);
        AppMethodBeat.m2505o(115502);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(115503);
        removeCallbacks(this.feV);
        if (drawable == null || drawable.equals(this.feT)) {
            AppMethodBeat.m2505o(115503);
            return;
        }
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + QPictureView.m53532aZ(this.feT) + " new:" + QPictureView.m53532aZ(drawable) + " " + C5046bo.dpG().toString());
        }
        QPictureView.m53534bb(this.feT);
        if (drawable instanceof C26406i) {
            this.feT = (C26406i) drawable;
        } else {
            this.feT = null;
        }
        QPictureView.m53533ba(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.m2505o(115503);
    }

    /* renamed from: ba */
    private static void m53533ba(Object obj) {
        AppMethodBeat.m2504i(115504);
        if (obj != null && (obj instanceof C26406i)) {
            ((C26406i) obj).mo33853Xd();
        }
        AppMethodBeat.m2505o(115504);
    }

    /* renamed from: bb */
    private static void m53534bb(Object obj) {
        AppMethodBeat.m2504i(115505);
        if (obj != null && (obj instanceof C26406i)) {
            ((C26406i) obj).mo33854Xe();
        }
        AppMethodBeat.m2505o(115505);
    }

    /* renamed from: Xy */
    private void m53530Xy() {
        AppMethodBeat.m2504i(115506);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + C5046bo.dpG().toString());
        }
        removeCallbacks(this.feV);
        if (this.feU) {
            AppMethodBeat.m2505o(115506);
            return;
        }
        this.feU = true;
        AppMethodBeat.m2505o(115506);
    }

    private void onDetach() {
        AppMethodBeat.m2504i(115507);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + C5046bo.dpG().toString());
        }
        if (this.feU) {
            this.feU = false;
            removeCallbacks(this.feV);
            postDelayed(this.feV, 500);
            AppMethodBeat.m2505o(115507);
            return;
        }
        AppMethodBeat.m2505o(115507);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(115508);
        super.onAttachedToWindow();
        m53530Xy();
        AppMethodBeat.m2505o(115508);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(115509);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.m2505o(115509);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.m2504i(115510);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.m2505o(115510);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.m2504i(115511);
        super.onFinishTemporaryDetach();
        m53530Xy();
        AppMethodBeat.m2505o(115511);
    }

    /* renamed from: a */
    static /* synthetic */ void m53531a(QPictureView qPictureView) {
        AppMethodBeat.m2504i(115512);
        QPictureView.m53534bb(qPictureView.feT);
        qPictureView.feT = null;
        super.setImageDrawable(null);
        AppMethodBeat.m2505o(115512);
    }
}
