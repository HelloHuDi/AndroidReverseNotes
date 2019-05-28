package com.tencent.p177mm.plugin.card.p355ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MMVerticalTextView;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.ui.j */
public final class C2777j {
    public Bitmap gKF;
    public C46633o gKG = null;
    ImageView gKH;
    View gKI;
    OnClickListener gKK = new C27791();
    C42837b kaS;
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

    /* renamed from: com.tencent.mm.plugin.card.ui.j$3 */
    class C27783 implements OnDismissListener {
        C27783() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.j$1 */
    class C27791 implements OnClickListener {
        C27791() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88621);
            if (view.getId() == 2131822257 || view.getId() == 2131822263) {
                if (C2777j.this.gKG != null && C2777j.this.gKG.isShowing()) {
                    C2777j.this.gKG.dismiss();
                }
                if (!C2777j.this.kaS.aZF()) {
                    C2777j.this.bdq();
                }
            }
            AppMethodBeat.m2505o(88621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.j$2 */
    class C27802 implements OnClickListener {
        C27802() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88622);
            if (C2777j.this.gKG != null && C2777j.this.gKG.isShowing()) {
                C2777j.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(88622);
        }
    }

    public C2777j(MMActivity mMActivity) {
        AppMethodBeat.m2504i(88623);
        this.knn = mMActivity;
        AppMethodBeat.m2505o(88623);
    }

    /* renamed from: az */
    private void m5014az(float f) {
        AppMethodBeat.m2504i(88624);
        LayoutParams attributes = this.knn.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.knn.getWindow().setAttributes(attributes);
        AppMethodBeat.m2505o(88624);
    }

    public final void bdp() {
        AppMethodBeat.m2504i(88625);
        if (this.kgj < 0.8f) {
            m5014az(0.8f);
        }
        AppMethodBeat.m2505o(88625);
    }

    public final void bdq() {
        AppMethodBeat.m2504i(88626);
        m5014az(this.kgj);
        AppMethodBeat.m2505o(88626);
    }

    public final void bdr() {
        AppMethodBeat.m2504i(88627);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKH.setImageBitmap(this.gKF);
        }
        AppMethodBeat.m2505o(88627);
    }

    /* Access modifiers changed, original: final */
    public final void bds() {
        AppMethodBeat.m2504i(88628);
        if (this.knv.size() > 2) {
            int size = this.knv.size() - 1;
            while (true) {
                int i = size;
                if (i <= 1) {
                    break;
                }
                C38736l.m65709K((Bitmap) this.knv.remove(i));
                size = i - 1;
            }
        }
        AppMethodBeat.m2505o(88628);
    }
}
