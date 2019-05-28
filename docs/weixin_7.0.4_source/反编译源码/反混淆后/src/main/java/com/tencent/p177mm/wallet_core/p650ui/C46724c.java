package com.tencent.p177mm.wallet_core.p650ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6468cm;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MMVerticalTextView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.wallet_core.ui.c */
public final class C46724c {
    ViewGroup Ahn;
    private boolean Aho;
    public C46633o gKG;
    private ImageView gKH;
    private View gKI;
    private OnClickListener gKK;
    private MMActivity jiE;
    public boolean kjx;
    private Bitmap kno;
    private View knr;
    private ImageView kns;
    private MMVerticalTextView knt;
    private ArrayList<Bitmap> knv;
    private String oXv;
    public Bitmap oZA;
    private String oZW;
    public Bitmap oZz;

    /* renamed from: com.tencent.mm.wallet_core.ui.c$2 */
    class C241772 implements OnClickListener {
        C241772() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49228);
            C4990ab.m7410d("MicroMsg.OfflinePopupWindow", "on click know");
            C46724c.this.Ahn.setVisibility(8);
            C6468cm c6468cm = new C6468cm();
            c6468cm.cvK.cvL = 1;
            C4879a.xxA.mo10055m(c6468cm);
            AppMethodBeat.m2505o(49228);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.c$1 */
    class C308781 implements OnClickListener {
        C308781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49227);
            if ((view.getId() == 2131822257 || view.getId() == 2131822263) && C46724c.this.gKG != null && C46724c.this.gKG.isShowing()) {
                C46724c.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(49227);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.c$3 */
    class C363883 implements OnClickListener {
        C363883() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49229);
            C4990ab.m7410d("MicroMsg.OfflinePopupWindow", "root on click");
            if (C46724c.this.gKG != null && C46724c.this.gKG.isShowing()) {
                C46724c.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(49229);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.c$4 */
    class C363894 implements OnClickListener {
        C363894() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49230);
            if (C46724c.this.gKG != null && C46724c.this.gKG.isShowing()) {
                C46724c.this.gKG.dismiss();
            }
            AppMethodBeat.m2505o(49230);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.c$5 */
    class C363905 implements OnDismissListener {
        C363905() {
        }

        public final void onDismiss() {
        }
    }

    public C46724c(MMActivity mMActivity, boolean z) {
        AppMethodBeat.m2504i(49231);
        this.oZz = null;
        this.oZA = null;
        this.kno = null;
        this.oZW = "";
        this.oXv = "";
        this.kjx = true;
        this.knv = new ArrayList();
        this.gKG = null;
        this.Aho = false;
        this.gKK = new C308781();
        this.jiE = mMActivity;
        this.Aho = z;
        AppMethodBeat.m2505o(49231);
    }

    public C46724c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    /* renamed from: iw */
    public final void mo75141iw(String str, String str2) {
        this.oZW = str;
        this.oXv = str2;
    }

    public final void release() {
        AppMethodBeat.m2504i(49232);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKG.dismiss();
        }
        C36391e.m59975K(this.kno);
        C36391e.m59995ar(this.knv);
        this.knv.clear();
        this.jiE = null;
        AppMethodBeat.m2505o(49232);
    }

    public final void ase() {
        AppMethodBeat.m2504i(49233);
        if (this.gKG != null) {
            AppMethodBeat.m2505o(49233);
            return;
        }
        View view;
        if (this.Aho) {
            View inflate = View.inflate(this.jiE, 2130971133, null);
            MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(2131828913);
            this.Ahn = (ViewGroup) inflate.findViewById(2131828912);
            mMVerticalTextView.setOnClickListener(new C241772());
            inflate.findViewById(2131828910).setOnClickListener(new C363883());
            view = inflate;
        } else {
            View inflate2 = View.inflate(this.jiE, 2130971136, null);
            inflate2.setOnClickListener(new C363894());
            view = inflate2;
        }
        this.gKI = view.findViewById(2131822256);
        this.gKH = (ImageView) view.findViewById(2131822257);
        this.knr = view.findViewById(2131822260);
        this.kns = (ImageView) view.findViewById(2131822263);
        this.knt = (MMVerticalTextView) view.findViewById(2131822262);
        this.gKG = new C46633o(view, -1, -1, true);
        this.gKG.setClippingEnabled(false);
        this.gKG.update();
        this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
        this.gKG.setOnDismissListener(new C363905());
        AppMethodBeat.m2505o(49233);
    }

    /* renamed from: G */
    public final void mo75136G(View view, boolean z) {
        AppMethodBeat.m2504i(49234);
        this.kjx = z;
        if (!(this.gKG == null || this.gKG.isShowing())) {
            this.gKG.showAtLocation(view.getRootView(), 17, 0, 0);
            this.gKG.setFocusable(true);
            this.gKG.setTouchable(true);
            this.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
            this.gKG.setOutsideTouchable(true);
            if (this.kjx) {
                dOw();
            }
            dOx();
        }
        AppMethodBeat.m2505o(49234);
    }

    public final void dOv() {
        AppMethodBeat.m2504i(49235);
        if (this.gKG != null && this.gKG.isShowing()) {
            dOx();
        }
        AppMethodBeat.m2505o(49235);
    }

    public final void dOw() {
        AppMethodBeat.m2504i(49236);
        if (this.Ahn != null) {
            this.Ahn.setVisibility(0);
        }
        AppMethodBeat.m2505o(49236);
    }

    private void dOx() {
        AppMethodBeat.m2504i(49237);
        if (this.kjx) {
            this.kns.setOnClickListener(this.gKK);
            Bitmap bitmap = this.kno;
            if (this.oZA != null) {
                this.kno = C36391e.m59974J(this.oZA);
                C4990ab.m7416i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.kno = null;
                C4990ab.m7412e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.kns.setImageBitmap(this.kno);
            this.knv.add(0, bitmap);
            bds();
            this.gKI.setVisibility(8);
            this.knr.setVisibility(0);
            this.knt.setText(C36391e.aty(this.oXv));
        } else {
            this.gKH.setOnClickListener(this.gKK);
            this.gKH.setImageBitmap(this.oZz);
            if (this.oZz != null) {
                C4990ab.m7412e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                C4990ab.m7416i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.gKI.setVisibility(0);
            this.knr.setVisibility(8);
        }
        this.gKG.update();
        AppMethodBeat.m2505o(49237);
    }

    private void bds() {
        AppMethodBeat.m2504i(49238);
        if (this.knv.size() >= 2) {
            int size = this.knv.size() - 1;
            while (true) {
                int i = size;
                if (i <= 1) {
                    break;
                }
                C36391e.m59975K((Bitmap) this.knv.remove(i));
                size = i - 1;
            }
        }
        AppMethodBeat.m2505o(49238);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(49239);
        if (this.gKG != null && this.gKG.isShowing()) {
            this.gKG.dismiss();
        }
        AppMethodBeat.m2505o(49239);
    }
}
