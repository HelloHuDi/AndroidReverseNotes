package com.tencent.mm.memory.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.QImageView;

public class QPictureView extends QImageView {
    private boolean DEBUG = false;
    private i feT = null;
    private boolean feU = false;
    private Runnable feV = new Runnable() {
        public final void run() {
            AppMethodBeat.i(115498);
            QPictureView.a(QPictureView.this);
            AppMethodBeat.o(115498);
        }
    };

    public QPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115499);
        AppMethodBeat.o(115499);
    }

    public QPictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(115500);
        AppMethodBeat.o(115500);
    }

    private static String aZ(Object obj) {
        AppMethodBeat.i(115501);
        String str;
        if (obj == null) {
            str = "NULL";
            AppMethodBeat.o(115501);
            return str;
        } else if (obj instanceof a) {
            str = obj + " hashcode " + obj.hashCode() + " " + ((a) obj).Xx() + " " + ((a) obj).Xx().hashCode();
            AppMethodBeat.o(115501);
            return str;
        } else {
            str = String.valueOf(obj);
            AppMethodBeat.o(115501);
            return str;
        }
    }

    public void setReleasableBitmap(n nVar) {
        AppMethodBeat.i(115502);
        if (nVar == null || nVar.equals(this.feT)) {
            AppMethodBeat.o(115502);
            return;
        }
        setImageBitmap(nVar.Xi());
        this.feT = nVar;
        ba(this.feT);
        AppMethodBeat.o(115502);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(115503);
        removeCallbacks(this.feV);
        if (drawable == null || drawable.equals(this.feT)) {
            AppMethodBeat.o(115503);
            return;
        }
        if (this.DEBUG) {
            ab.i("MicroMsg.QPictureView", "setImageDrawable " + hashCode() + " old: " + aZ(this.feT) + " new:" + aZ(drawable) + " " + bo.dpG().toString());
        }
        bb(this.feT);
        if (drawable instanceof i) {
            this.feT = (i) drawable;
        } else {
            this.feT = null;
        }
        ba(drawable);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(115503);
    }

    private static void ba(Object obj) {
        AppMethodBeat.i(115504);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Xd();
        }
        AppMethodBeat.o(115504);
    }

    private static void bb(Object obj) {
        AppMethodBeat.i(115505);
        if (obj != null && (obj instanceof i)) {
            ((i) obj).Xe();
        }
        AppMethodBeat.o(115505);
    }

    private void Xy() {
        AppMethodBeat.i(115506);
        if (this.DEBUG) {
            ab.i("MicroMsg.QPictureView", "onAttach" + hashCode() + " " + bo.dpG().toString());
        }
        removeCallbacks(this.feV);
        if (this.feU) {
            AppMethodBeat.o(115506);
            return;
        }
        this.feU = true;
        AppMethodBeat.o(115506);
    }

    private void onDetach() {
        AppMethodBeat.i(115507);
        if (this.DEBUG) {
            ab.i("MicroMsg.QPictureView", "onDetach " + hashCode() + " " + bo.dpG().toString());
        }
        if (this.feU) {
            this.feU = false;
            removeCallbacks(this.feV);
            postDelayed(this.feV, 500);
            AppMethodBeat.o(115507);
            return;
        }
        AppMethodBeat.o(115507);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(115508);
        super.onAttachedToWindow();
        Xy();
        AppMethodBeat.o(115508);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(115509);
        super.onDetachedFromWindow();
        onDetach();
        AppMethodBeat.o(115509);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(115510);
        super.onStartTemporaryDetach();
        onDetach();
        AppMethodBeat.o(115510);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(115511);
        super.onFinishTemporaryDetach();
        Xy();
        AppMethodBeat.o(115511);
    }

    static /* synthetic */ void a(QPictureView qPictureView) {
        AppMethodBeat.i(115512);
        bb(qPictureView.feT);
        qPictureView.feT = null;
        super.setImageDrawable(null);
        AppMethodBeat.o(115512);
    }
}
