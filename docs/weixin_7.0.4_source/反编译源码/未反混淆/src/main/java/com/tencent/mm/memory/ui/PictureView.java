package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class PictureView extends ImageView {
    private boolean DEBUG = false;
    private i feT = null;
    private boolean feU = false;
    private Runnable feV = new Runnable() {
        public final void run() {
            AppMethodBeat.i(115483);
            PictureView.a(PictureView.this);
            AppMethodBeat.o(115483);
        }
    };

    public PictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115484);
        AppMethodBeat.o(115484);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(115485);
        AppMethodBeat.o(115485);
    }

    private static String aZ(Object obj) {
        AppMethodBeat.i(115486);
        String str;
        if (obj == null) {
            str = "NULL";
            AppMethodBeat.o(115486);
            return str;
        } else if (obj instanceof a) {
            str = obj + " hashcode " + obj.hashCode() + " " + ((a) obj).Xx() + " " + ((a) obj).Xx().hashCode();
            AppMethodBeat.o(115486);
            return str;
        } else {
            str = String.valueOf(obj);
            AppMethodBeat.o(115486);
            return str;
        }
    }

    public void setReleasableBitmap(n nVar) {
        AppMethodBeat.i(115487);
        if (nVar == null || nVar.equals(this.feT)) {
            AppMethodBeat.o(115487);
            return;
        }
        setImageBitmap(nVar.Xi());
        this.feT = nVar;
        ba(this.feT);
        AppMethodBeat.o(115487);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(115488);
        removeCallbacks(this.feV);
        if (drawable == null || drawable.equals(this.feT)) {
            AppMethodBeat.o(115488);
            return;
        }
        if (this.DEBUG) {
            ab.i("MicroMsg.PictureView", "setImageDrawable " + hashCode() + " old: " + aZ(this.feT) + " new:" + aZ(drawable) + " " + bo.dpG().toString());
        }
        bb(this.feT);
        if (drawable instanceof i) {
            this.feT = (i) drawable;
        } else {
            this.feT = null;
        }
        ba(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(115488);
    }

    private static void ba(Object obj) {
        AppMethodBeat.i(115489);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Xd();
        }
        AppMethodBeat.o(115489);
    }

    private static void bb(Object obj) {
        AppMethodBeat.i(115490);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Xe();
        }
        AppMethodBeat.o(115490);
    }

    private void Xy() {
        AppMethodBeat.i(115491);
        removeCallbacks(this.feV);
        if (this.DEBUG) {
            ab.i("MicroMsg.PictureView", "onAttach" + hashCode() + " " + bo.dpG().toString());
        }
        if (this.feU) {
            AppMethodBeat.o(115491);
            return;
        }
        this.feU = true;
        AppMethodBeat.o(115491);
    }

    private void onDetach() {
        AppMethodBeat.i(115492);
        if (this.DEBUG) {
            ab.i("MicroMsg.PictureView", "onDetach " + hashCode() + " " + bo.dpG().toString());
        }
        if (this.feU) {
            this.feU = false;
            removeCallbacks(this.feV);
            postDelayed(this.feV, 500);
            AppMethodBeat.o(115492);
            return;
        }
        AppMethodBeat.o(115492);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(115493);
        super.onAttachedToWindow();
        Xy();
        AppMethodBeat.o(115493);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(115494);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.o(115494);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(115495);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.o(115495);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(115496);
        super.onFinishTemporaryDetach();
        Xy();
        AppMethodBeat.o(115496);
    }

    static /* synthetic */ void a(PictureView pictureView) {
        AppMethodBeat.i(115497);
        bb(pictureView.feT);
        pictureView.feT = null;
        super.setImageDrawable(null);
        AppMethodBeat.o(115497);
    }
}
