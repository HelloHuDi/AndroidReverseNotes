package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class j {
    public Bitmap gKF;
    public o gKG = null;
    ImageView gKH;
    View gKI;
    OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88621);
            if (view.getId() == R.id.ai_ || view.getId() == R.id.aif) {
                if (j.this.gKG != null && j.this.gKG.isShowing()) {
                    j.this.gKG.dismiss();
                }
                if (!j.this.kaS.aZF()) {
                    j.this.bdq();
                }
            }
            AppMethodBeat.o(88621);
        }
    };
    b kaS;
    public Bitmap kgb;
    float kgj = 0.0f;
    boolean kjx = true;
    MMActivity knn;
    Bitmap kno = null;
    TextView knp;
    TextView knq;
    View knr;
    ImageView kns;
    MMVerticalTextView knt;
    MMVerticalTextView knu;
    ArrayList<Bitmap> knv = new ArrayList();
    String knw = "";

    public j(MMActivity mMActivity) {
        AppMethodBeat.i(88623);
        this.knn = mMActivity;
        AppMethodBeat.o(88623);
    }

    private void az(float f) {
        AppMethodBeat.i(88624);
        LayoutParams attributes = this.knn.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.knn.getWindow().setAttributes(attributes);
        AppMethodBeat.o(88624);
    }

    public final void bdp() {
        AppMethodBeat.i(88625);
        if (this.kgj < 0.8f) {
            az(0.8f);
        }
        AppMethodBeat.o(88625);
    }

    public final void bdq() {
        AppMethodBeat.i(88626);
        az(this.kgj);
        AppMethodBeat.o(88626);
    }

    public final void bdr() {
        AppMethodBeat.i(88627);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKH.setImageBitmap(this.gKF);
        }
        AppMethodBeat.o(88627);
    }

    /* Access modifiers changed, original: final */
    public final void bds() {
        AppMethodBeat.i(88628);
        if (this.knv.size() > 2) {
            int size = this.knv.size() - 1;
            while (true) {
                int i = size;
                if (i <= 1) {
                    break;
                }
                l.K((Bitmap) this.knv.remove(i));
                size = i - 1;
            }
        }
        AppMethodBeat.o(88628);
    }
}
