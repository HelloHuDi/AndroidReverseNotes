package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletAwardShakeAnimView.C22640a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletScratchShakeView.C4457a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletScratchShakeView.C4458b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletScratchShakeView.C4458b.C44591;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22562j;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35472i;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43789g;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C23466xq;
import com.tencent.p177mm.protocal.protobuf.C40593zc;
import com.tencent.p177mm.protocal.protobuf.akm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.xweb.util.C6037d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import p1121d.p1122a.p1123a.C16442f;
import p1121d.p1122a.p1123a.C31176c;
import p1121d.p1122a.p1123a.C44604a;
import p1121d.p1122a.p1123a.C44605g;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget */
public class WalletSuccPageAwardWidget extends FrameLayout {
    private static final String tOJ = (C6457e.eSn + "wallet/images/");
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private TextView gtb;
    private TextView hrg;
    private String kBE;
    private CdnImageView kqn;
    private C31176c pSK;
    private boolean qgo = true;
    private ViewGroup sis;
    private WalletScratchShakeView tOA;
    private WalletAwardShakeAnimView tOB;
    private C44605g tOC;
    private WalletBaseUI tOD;
    private boolean tOE = false;
    private boolean tOF = false;
    private boolean tOG = false;
    private C44604a tOH = null;
    private boolean tOI = false;
    private Button tOx;
    private ImageView tOy;
    private ImageView tOz;
    private boolean ttT;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$5 */
    class C143295 implements C22640a {
        C143295() {
        }

        /* renamed from: ns */
        public final void mo26613ns(boolean z) {
            AppMethodBeat.m2504i(47945);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", Boolean.valueOf(z), Boolean.valueOf(WalletSuccPageAwardWidget.this.tOE));
            C7060h c7060h;
            Object[] objArr;
            if (z) {
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.tOE ? 2 : 1);
                c7060h.mo8381e(15225, objArr);
            } else {
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(7);
                objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.tOE ? 2 : 1);
                c7060h.mo8381e(15225, objArr);
            }
            WalletSuccPageAwardWidget.this.tOB.setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(C25738R.string.ftk));
            WalletSuccPageAwardWidget.this.tOB.setShakeHintWordingColor(Color.parseColor("#9C9C9C"));
            WalletSuccPageAwardWidget.m34319a(WalletSuccPageAwardWidget.this, 2, false);
            WalletSuccPageAwardWidget.this.tOF = true;
            AppMethodBeat.m2505o(47945);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$7 */
    class C226457 implements Runnable {
        C226457() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47947);
            WalletSuccPageAwardWidget.m34328g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.m2505o(47947);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$4 */
    class C226464 implements Runnable {
        C226464() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47944);
            if (WalletSuccPageAwardWidget.this.tOB.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                LayoutParams layoutParams = (LayoutParams) WalletSuccPageAwardWidget.this.tOB.getLayoutParams();
                layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight() - C1338a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2);
                layoutParams.topMargin = C1338a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                layoutParams.bottomMargin = C1338a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                WalletSuccPageAwardWidget.this.tOB.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(47944);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$6 */
    class C226476 implements Runnable {
        C226476() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47946);
            WalletSuccPageAwardWidget.m34328g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.m2505o(47946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$10 */
    class C2264810 implements Runnable {
        C2264810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47954);
            try {
                if (WalletSuccPageAwardWidget.this.tOx.getVisibility() == 0 && WalletSuccPageAwardWidget.this.gtb.getRight() > 0 && WalletSuccPageAwardWidget.this.tOx.getLeft() > 0 && WalletSuccPageAwardWidget.this.gtb.getRight() >= WalletSuccPageAwardWidget.this.tOx.getLeft() && !C5046bo.m7519ac(WalletSuccPageAwardWidget.this.gtb.getText())) {
                    float textSize = WalletSuccPageAwardWidget.this.gtb.getTextSize();
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", Integer.valueOf(WalletSuccPageAwardWidget.this.gtb.getRight()), Integer.valueOf(WalletSuccPageAwardWidget.this.tOx.getLeft()));
                    Paint paint = new Paint();
                    paint.setTextSize(textSize);
                    String charSequence = WalletSuccPageAwardWidget.this.gtb.getText().toString();
                    float left = (float) (WalletSuccPageAwardWidget.this.tOx.getLeft() - WalletSuccPageAwardWidget.this.gtb.getLeft());
                    int i = 1;
                    while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                        i++;
                    }
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                    CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                    if (charSequence.length() > 9 && substring.length() < 9) {
                        substring = charSequence.substring(0, 9);
                    }
                    WalletSuccPageAwardWidget.this.gtb.setText(substring);
                    WalletSuccPageAwardWidget.this.gtb.append("...");
                }
                AppMethodBeat.m2505o(47954);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "calc nameTv len error: %s", e.getMessage());
                AppMethodBeat.m2505o(47954);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$11 */
    class C2264911 implements C1282i {
        C2264911() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, final Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(47956);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", str, bitmap);
            if (!(bitmap == null || WalletSuccPageAwardWidget.this.pSK == null || C5046bo.isNullOrNil(WalletSuccPageAwardWidget.this.pSK.BTE) || !WalletSuccPageAwardWidget.this.pSK.BTE.equals(str))) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(47955);
                        WalletSuccPageAwardWidget.this.tOz.setScaleType(ScaleType.CENTER_CROP);
                        WalletSuccPageAwardWidget.this.tOz.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(47955);
                    }
                });
            }
            AppMethodBeat.m2505o(47956);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$3 */
    class C226503 implements Runnable {
        C226503() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47943);
            WalletSuccPageAwardWidget.m34328g(WalletSuccPageAwardWidget.this);
            AppMethodBeat.m2505o(47943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$2 */
    class C226512 implements C4457a {
        C226512() {
        }

        /* renamed from: nt */
        public final void mo9504nt(boolean z) {
            int i = 2;
            AppMethodBeat.m2504i(47941);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", Boolean.valueOf(z));
            WalletSuccPageAwardWidget.m34319a(WalletSuccPageAwardWidget.this, z ? 1 : 2, false);
            C7060h c7060h;
            Object[] objArr;
            if (z) {
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(5);
                if (!WalletSuccPageAwardWidget.this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                c7060h.mo8381e(15225, objArr);
            } else {
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4);
                if (!WalletSuccPageAwardWidget.this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                c7060h.mo8381e(15225, objArr);
            }
            WalletSuccPageAwardWidget.this.tOF = true;
            AppMethodBeat.m2505o(47941);
        }

        public final void cSD() {
            AppMethodBeat.m2504i(47942);
            C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
            if (WalletSuccPageAwardWidget.this.pSK.BTC != 0) {
                WalletSuccPageAwardWidget.cSO();
            }
            AppMethodBeat.m2505o(47942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$8 */
    class C226528 implements C1282i {
        C226528() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(47950);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", str, bitmap);
            if (!(bitmap == null || WalletSuccPageAwardWidget.this.tOC == null || C5046bo.isNullOrNil(WalletSuccPageAwardWidget.this.tOC.BTR) || !WalletSuccPageAwardWidget.this.tOC.BTR.equals(str))) {
                final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(WalletSuccPageAwardWidget.this.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.m34321ac(bitmap), "widget_bg"));
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$8$1$1 */
                    class C44651 implements Runnable {
                        C44651() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(47948);
                            ViewGroup.LayoutParams layoutParams = WalletSuccPageAwardWidget.this.tOy.getLayoutParams();
                            layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight();
                            layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                            WalletSuccPageAwardWidget.this.tOy.setLayoutParams(layoutParams);
                            WalletSuccPageAwardWidget.this.findViewById(2131826989).setVisibility(8);
                            WalletSuccPageAwardWidget.this.findViewById(2131826994).setVisibility(8);
                            AppMethodBeat.m2505o(47948);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(47949);
                        WalletSuccPageAwardWidget.this.tOy.setImageDrawable(ninePatchDrawable);
                        WalletSuccPageAwardWidget.this.tOy.setVisibility(0);
                        WalletSuccPageAwardWidget.this.tOy.post(new C44651());
                        AppMethodBeat.m2505o(47949);
                    }
                });
            }
            AppMethodBeat.m2505o(47950);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$9 */
    class C226539 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$9$1 */
        class C44661 implements Runnable {
            C44661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47951);
                WalletSuccPageAwardWidget.m34328g(WalletSuccPageAwardWidget.this);
                AppMethodBeat.m2505o(47951);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$9$2 */
        class C226542 implements Runnable {
            C226542() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47952);
                WalletSuccPageAwardWidget.m34328g(WalletSuccPageAwardWidget.this);
                AppMethodBeat.m2505o(47952);
            }
        }

        C226539() {
        }

        public final void onClick(View view) {
            int i = 2;
            AppMethodBeat.m2504i(47953);
            if (!(WalletSuccPageAwardWidget.this.pSK == null || WalletSuccPageAwardWidget.this.pSK.wey == null)) {
                WalletSuccPageAwardWidget.this.tOH = WalletSuccPageAwardWidget.this.pSK.wey;
                C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu));
                if (WalletSuccPageAwardWidget.this.tOH.BTu == 1) {
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu), WalletSuccPageAwardWidget.this.tOH.url);
                    C36391e.m60016n(WalletSuccPageAwardWidget.this.tOD, WalletSuccPageAwardWidget.this.tOH.url, false);
                    WalletSuccPageAwardWidget.this.tOE = true;
                    WalletSuccPageAwardWidget.this.tOG = true;
                    WalletSuccPageAwardWidget.this.tOI = false;
                    WalletSuccPageAwardWidget.this.fbD.postDelayed(new C44661(), 3000);
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 2) {
                    C16442f c16442f = WalletSuccPageAwardWidget.this.tOH.BTv;
                    if (c16442f != null) {
                        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", c16442f.wMk, c16442f.wMl, Integer.valueOf(c16442f.wMm));
                        C32628se c32628se = new C32628se();
                        c32628se.cOf.userName = c16442f.wMk;
                        c32628se.cOf.cOh = C5046bo.m7532bc(c16442f.wMl, "");
                        c32628se.cOf.scene = 1060;
                        c32628se.cOf.cst = WalletSuccPageAwardWidget.this.kBE;
                        c32628se.cOf.cOi = 0;
                        if (c16442f.wMm > 0) {
                            c32628se.cOf.axy = c16442f.wMm;
                        }
                        c32628se.cOf.context = WalletSuccPageAwardWidget.this.tOD;
                        C4879a.xxA.mo10055m(c32628se);
                        WalletSuccPageAwardWidget.this.tOE = true;
                        WalletSuccPageAwardWidget.this.tOI = false;
                        WalletSuccPageAwardWidget.this.fbD.postDelayed(new C226542(), 3000);
                    }
                    WalletSuccPageAwardWidget.this.tOG = true;
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 3) {
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                    WalletSuccPageAwardWidget.m34339r(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.this.tOG = true;
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 5) {
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 6) {
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                    WalletSuccPageAwardWidget.this.tOG = true;
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 7) {
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                    WalletSuccPageAwardWidget.m34319a(WalletSuccPageAwardWidget.this, 3, true);
                    WalletSuccPageAwardWidget.this.tOG = true;
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 8) {
                    WalletSuccPageAwardWidget.m34339r(WalletSuccPageAwardWidget.this);
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.tOH.BTu), WalletSuccPageAwardWidget.this.tOH.url);
                    WalletSuccPageAwardWidget.this.tOG = true;
                } else if (WalletSuccPageAwardWidget.this.tOH.BTu == 9) {
                    WalletSuccPageAwardWidget.m34339r(WalletSuccPageAwardWidget.this);
                    WalletSuccPageAwardWidget.this.tOG = true;
                }
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(2);
                if (!WalletSuccPageAwardWidget.this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                c7060h.mo8381e(15225, objArr);
            }
            AppMethodBeat.m2505o(47953);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget$1 */
    class C226551 implements Runnable {
        C226551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47940);
            if (WalletSuccPageAwardWidget.this.tOA.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                LayoutParams layoutParams = (LayoutParams) WalletSuccPageAwardWidget.this.tOA.getLayoutParams();
                layoutParams.width = WalletSuccPageAwardWidget.this.sis.getWidth();
                layoutParams.height = WalletSuccPageAwardWidget.this.sis.getHeight();
                WalletSuccPageAwardWidget.this.tOA.setLayoutParams(layoutParams);
            }
            WalletSuccPageAwardWidget.m34324c(WalletSuccPageAwardWidget.this);
            AppMethodBeat.m2505o(47940);
        }
    }

    static /* synthetic */ void cSO() {
    }

    static {
        AppMethodBeat.m2504i(47982);
        AppMethodBeat.m2505o(47982);
    }

    /* renamed from: a */
    public static boolean m34320a(C31176c c31176c) {
        AppMethodBeat.m2504i(47957);
        if (c31176c == null || ((c31176c.wew == null || c31176c.wew.size() <= 0) && c31176c.BTF == null)) {
            AppMethodBeat.m2505o(47957);
            return false;
        }
        AppMethodBeat.m2505o(47957);
        return true;
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47958);
        init(context);
        AppMethodBeat.m2505o(47958);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47959);
        init(context);
        AppMethodBeat.m2505o(47959);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(47960);
        C5616v.m8409hu(context).inflate(2130971171, this, true);
        this.sis = (ViewGroup) findViewById(2131821686);
        this.kqn = (CdnImageView) findViewById(2131829062);
        this.gtb = (TextView) findViewById(2131821227);
        this.hrg = (TextView) findViewById(2131820991);
        this.tOx = (Button) findViewById(2131820869);
        this.tOA = (WalletScratchShakeView) findViewById(2131829063);
        this.tOy = (ImageView) findViewById(2131824036);
        this.tOB = (WalletAwardShakeAnimView) findViewById(2131829064);
        this.kqn.setRoundCorner(true);
        this.kqn.setUseSdcardCache(true);
        AppMethodBeat.m2505o(47960);
    }

    /* renamed from: a */
    public final void mo38237a(WalletBaseUI walletBaseUI, C31176c c31176c, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        AppMethodBeat.m2504i(47961);
        String str2 = "MicroMsg.WalletSuccPageAwardWidget";
        String str3 = "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s";
        Object[] objArr = new Object[5];
        objArr[0] = WalletSuccPageAwardWidget.m34323b(c31176c);
        boolean z3 = c31176c == null || c31176c.BTD == null;
        objArr[1] = Boolean.valueOf(z3);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.tOE);
        objArr[4] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        this.tOD = walletBaseUI;
        this.pSK = c31176c;
        this.ttT = z;
        this.kBE = str;
        this.tOz = imageView;
        cSG();
        AppMethodBeat.m2505o(47961);
    }

    private void cSG() {
        int i = 2;
        AppMethodBeat.m2504i(47962);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", WalletSuccPageAwardWidget.m34323b(this.pSK), Boolean.valueOf(this.qgo));
        if (this.pSK == null) {
            C4990ab.m7412e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            AppMethodBeat.m2505o(47962);
            return;
        }
        C4990ab.m7409c("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", Integer.valueOf(this.pSK.BTB), Integer.valueOf(this.pSK.wew.size()), Boolean.valueOf(this.tOE));
        if (this.pSK.BTB <= 0 || this.pSK.BTB > 5) {
            AppMethodBeat.m2505o(47962);
        } else if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            if (this.pSK.BTB == 4) {
                cSK();
            } else if (this.pSK.BTB == 1 || this.pSK.BTB == 2 || this.pSK.BTB == 3) {
                cSJ();
            } else if (this.pSK.BTB == 5) {
                cSL();
            }
            if (this.qgo || this.tOE) {
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(3);
                if (!this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                c7060h.mo8381e(15225, objArr);
            }
            this.qgo = false;
            AppMethodBeat.m2505o(47962);
        } else {
            AppMethodBeat.m2505o(47962);
        }
    }

    private void cSH() {
        AppMethodBeat.m2504i(47963);
        C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtb.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrg.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.gtb.setLayoutParams(layoutParams);
        this.hrg.setLayoutParams(layoutParams2);
        this.gtb.setVisibility(0);
        this.hrg.setVisibility(8);
        this.gtb.setText(C25738R.string.ftj);
        this.gtb.setTextColor(Color.parseColor("#353535"));
        this.hrg.setTextColor(Color.parseColor("#B2B2B2"));
        this.tOy.setVisibility(8);
        findViewById(2131826989).setVisibility(0);
        findViewById(2131826994).setVisibility(0);
        this.tOx.setVisibility(8);
        this.kqn.setVisibility(0);
        this.kqn.setImageResource(C25738R.drawable.blg);
        this.tOA.setVisibility(8);
        this.tOA.onDestroy();
        this.tOB.setVisibility(8);
        this.tOB.destroy();
        AppMethodBeat.m2505o(47963);
    }

    public final void init() {
        AppMethodBeat.m2504i(47964);
        if (this.tOD != null) {
            C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "init");
            this.tOD.mo39992nf(1859);
            this.tOD.mo39992nf(2547);
            this.tOD.mo39992nf(2803);
            this.tOD.mo39992nf(2508);
            this.tOD.mo39992nf(2529);
            this.tOD.mo39992nf(2888);
        }
        AppMethodBeat.m2505o(47964);
    }

    public final void onDestroy() {
        int i = 2;
        AppMethodBeat.m2504i(47965);
        if (this.tOD != null) {
            this.tOD.mo39993ng(1859);
            this.tOD.mo39993ng(2547);
            this.tOD.mo39993ng(2803);
            this.tOD.mo39993ng(2508);
            this.tOD.mo39993ng(2529);
            this.tOD.mo39993ng(2888);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", Boolean.valueOf(this.tOF), Boolean.valueOf(this.tOG));
            if (!(this.tOF || this.tOG)) {
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(6);
                if (!this.tOE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                c7060h.mo8381e(15225, objArr);
                C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.tOD.mo39970a(new C43789g(this.pSK.wdr, 4, this.ttT), false, false);
            }
        }
        if (this.tOA != null) {
            this.tOA.onDestroy();
        }
        if (this.tOB != null) {
            this.tOB.destroy();
        }
        AppMethodBeat.m2505o(47965);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(47966);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", Boolean.valueOf(this.tOE), WalletSuccPageAwardWidget.m34323b(this.pSK), Boolean.valueOf(this.tOI));
        if (!this.tOI) {
            this.tOI = true;
            cSI();
        }
        AppMethodBeat.m2505o(47966);
    }

    private void cSI() {
        AppMethodBeat.m2504i(47967);
        C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
        if (!(this.pSK.BTF == null || this.pSK.BTF.xis == 1)) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        cSN();
        AppMethodBeat.m2505o(47967);
    }

    private void cSJ() {
        AppMethodBeat.m2504i(47968);
        cSM();
        if (this.tOB.getVisibility() != 8) {
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        if (this.tOA.getVisibility() != 0) {
            this.tOA.setVisibility(0);
            this.tOA.post(new C226551());
        }
        AppMethodBeat.m2505o(47968);
    }

    private void cSK() {
        AppMethodBeat.m2504i(47969);
        cSM();
        if (this.tOA.getVisibility() != 8) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
        }
        if (this.tOB.getVisibility() != 8) {
            this.tOB.setVisibility(8);
            this.tOB.destroy();
        }
        AppMethodBeat.m2505o(47969);
    }

    private void cSL() {
        AppMethodBeat.m2504i(47970);
        cSM();
        if (this.tOA.getVisibility() != 8) {
            this.tOA.setVisibility(8);
            this.tOA.onDestroy();
        }
        if (this.pSK.BTF != null) {
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", Integer.valueOf(this.pSK.BTF.xis));
            switch (this.pSK.BTF.xis) {
                case 1:
                    if (this.tOB.getVisibility() != 0) {
                        this.tOB.setVisibility(0);
                        this.tOB.post(new C226464());
                    }
                    this.tOB.destroy();
                    if (!C5046bo.isNullOrNil(this.pSK.BTF.BTw)) {
                        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", this.pSK.BTF.BTw);
                        this.tOB.setShakeHintWording(this.pSK.BTF.BTw);
                    }
                    if (!C5046bo.isNullOrNil(this.pSK.BTF.BTx)) {
                        try {
                            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", this.pSK.BTF.BTx);
                            this.tOB.setShakeHintWordingColor(Color.parseColor(this.pSK.BTF.BTx));
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse animation_wording_color %s error %s", this.pSK.BTF.BTx, e.getMessage());
                        }
                    }
                    if (!C5046bo.isNullOrNil(this.pSK.BTF.BTy)) {
                        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", this.pSK.BTF.BTy);
                        this.tOB.setAfterHintWording(this.pSK.BTF.BTy);
                    }
                    if (!C5046bo.isNullOrNil(this.pSK.BTF.BTz)) {
                        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", this.pSK.BTF.BTz);
                        try {
                            this.tOB.setAfterHintWordingColor(Color.parseColor(this.pSK.BTF.BTz));
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse after_animation_wording_color %s error %s", this.pSK.BTF.BTz, e2.getMessage());
                        }
                    }
                    this.tOB.setShakeOrClickCallback(new C143295());
                    this.tOB.cSw();
                    AppMethodBeat.m2505o(47970);
                    return;
                case 2:
                    C16442f c16442f = this.pSK.BTF.BTv;
                    if (c16442f != null) {
                        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", c16442f.wMk, c16442f.wMl, Integer.valueOf(c16442f.wMm));
                        C32628se c32628se = new C32628se();
                        c32628se.cOf.userName = c16442f.wMk;
                        c32628se.cOf.cOh = C5046bo.m7532bc(c16442f.wMl, "");
                        c32628se.cOf.scene = 1060;
                        c32628se.cOf.cst = this.kBE;
                        c32628se.cOf.cOi = 0;
                        if (c16442f.wMm > 0) {
                            c32628se.cOf.axy = c16442f.wMm;
                        }
                        c32628se.cOf.context = this.tOD;
                        C4879a.xxA.mo10055m(c32628se);
                        this.tOE = true;
                        this.tOI = false;
                        this.fbD.postDelayed(new C226476(), 3000);
                        AppMethodBeat.m2505o(47970);
                        return;
                    }
                    break;
                case 3:
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", this.pSK.BTF.url);
                    C36391e.m60016n(this.tOD, this.pSK.BTF.url, false);
                    this.tOE = true;
                    this.tOI = false;
                    this.fbD.postDelayed(new C226457(), 3000);
                    AppMethodBeat.m2505o(47970);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
                    this.tOA.setVisibility(8);
                    this.tOA.onDestroy();
                    break;
                default:
                    this.tOB.setVisibility(8);
                    this.tOB.destroy();
                    AppMethodBeat.m2505o(47970);
                    return;
            }
        }
        this.tOB.setVisibility(8);
        this.tOB.destroy();
        AppMethodBeat.m2505o(47970);
    }

    private static String adh(String str) {
        AppMethodBeat.m2504i(47971);
        if (C5046bo.m7510Q(new String[0])) {
            AppMethodBeat.m2505o(47971);
            return null;
        }
        C5730e.m8643tf(tOJ);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", str, tOJ + C6037d.m9506x(str.getBytes()));
        AppMethodBeat.m2505o(47971);
        return tOJ + C6037d.m9506x(str.getBytes());
    }

    private void cSM() {
        C17927a c17927a;
        AppMethodBeat.m2504i(47972);
        C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
        LinkedList linkedList = this.pSK.wew;
        String str = "MicroMsg.WalletSuccPageAwardWidget";
        String str2 = "singleExposureInfoList %s, size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = linkedList;
        objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (linkedList != null && linkedList.size() > 0) {
            int i;
            this.tOC = (C44605g) linkedList.get(0);
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", Integer.valueOf(0), this.tOC.BTP, this.tOC.BTQ, this.tOC.pia);
            this.kqn.setUrl(this.tOC.pia);
            if (!C5046bo.isNullOrNil(this.tOC.pia)) {
                this.kqn.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(this.tOC.BTP)) {
                i = 0;
            } else {
                this.gtb.setText(this.tOC.BTP);
                this.gtb.setVisibility(0);
                try {
                    if (!C5046bo.isNullOrNil(this.tOC.BTS)) {
                        this.gtb.setTextColor(Color.parseColor(this.tOC.BTS));
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse award_name_color error: %s", e.getMessage());
                }
                i = 1;
            }
            if (!C5046bo.isNullOrNil(this.tOC.BTQ)) {
                this.hrg.setText(this.tOC.BTQ);
                this.hrg.setVisibility(0);
                try {
                    if (!C5046bo.isNullOrNil(this.tOC.BTT)) {
                        this.hrg.setTextColor(Color.parseColor(this.tOC.BTT));
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_description_color error: %s", e2.getMessage());
                }
                i = 1;
            }
            if (i != 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtb.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrg.getLayoutParams();
                if (!C5046bo.isNullOrNil(this.tOC.BTP) && C5046bo.isNullOrNil(this.tOC.BTQ)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(0);
                    this.hrg.setVisibility(8);
                } else if (!C5046bo.isNullOrNil(this.tOC.BTP) || C5046bo.isNullOrNil(this.tOC.BTQ)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(0);
                    this.hrg.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.gtb.setLayoutParams(layoutParams);
                    this.hrg.setLayoutParams(layoutParams2);
                    this.gtb.setVisibility(8);
                    this.hrg.setVisibility(0);
                }
            }
            if (C5046bo.isNullOrNil(this.tOC.BTR)) {
                this.tOy.setVisibility(8);
                findViewById(2131826989).setVisibility(0);
                findViewById(2131826994).setVisibility(0);
            } else {
                C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", this.tOC.BTR);
                c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePG = true;
                c17927a.ePJ = WalletSuccPageAwardWidget.adh(this.tOC.BTR);
                C32291o.ahp().mo43768a(this.tOC.BTR, null, c17927a.ahG(), new C226528());
            }
        }
        String str3 = "MicroMsg.WalletSuccPageAwardWidget";
        str = "is_show_btn: %s, btn_info: %s, btn_words: %s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.pSK.wex);
        objArr2[1] = this.pSK.wey;
        objArr2[2] = this.pSK.wey != null ? this.pSK.wey.BTs : "";
        C4990ab.m7417i(str3, str, objArr2);
        if (this.pSK.wex == 0 || this.pSK.wey == null || C5046bo.isNullOrNil(this.pSK.wey.BTs)) {
            this.tOx.setVisibility(8);
        } else {
            C44604a c44604a = this.pSK.wey;
            if (c44604a != null) {
                C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", c44604a.BTs, Integer.valueOf(c44604a.BTu), c44604a.BTt, c44604a.url);
                this.tOx.setText(c44604a.BTs);
                if (!C5046bo.isNullOrNil(c44604a.BTt)) {
                    Drawable drawable = getContext().getResources().getDrawable(C25738R.drawable.f6484fp);
                    drawable.setColorFilter(Color.parseColor(c44604a.BTt), Mode.SRC);
                    this.tOx.setBackground(drawable);
                }
                this.tOx.setOnClickListener(new C226539());
                this.tOx.setVisibility(0);
                if (this.qgo || this.tOE) {
                    C7060h c7060h = C7060h.pYm;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(1);
                    objArr2[1] = Integer.valueOf(this.tOE ? 2 : 1);
                    c7060h.mo8381e(15225, objArr2);
                }
            }
        }
        if (this.gtb.getVisibility() == 0) {
            this.gtb.setSingleLine();
            this.gtb.post(new C2264810());
        }
        if (this.tOx.getVisibility() != 0) {
            this.gtb.setEllipsize(TruncateAt.END);
        }
        if (this.pSK.BTC != 0) {
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", Integer.valueOf(this.pSK.BTC));
        }
        if (!C5046bo.isNullOrNil(this.pSK.BTE)) {
            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", this.pSK.BTE);
            if (this.tOz != null) {
                this.tOz.setVisibility(0);
                c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePG = true;
                c17927a.ePJ = WalletSuccPageAwardWidget.adh(this.pSK.BTE);
                C32291o.ahp().mo43768a(this.pSK.BTE, null, c17927a.ahG(), new C2264911());
            }
        }
        AppMethodBeat.m2505o(47972);
    }

    private void cSN() {
        AppMethodBeat.m2504i(47973);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", Boolean.valueOf(this.tOE));
        if (this.tOE) {
            this.tOD.mo39970a(new C22562j(this.pSK.wev, this.ttT), false, false);
        }
        AppMethodBeat.m2505o(47973);
    }

    /* renamed from: c */
    public final boolean mo38238c(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(47974);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        int i4;
        String str2;
        String str3;
        Object[] objArr;
        if (c1207m instanceof C35472i) {
            C35472i c35472i = (C35472i) c1207m;
            if (i == 0 && i2 == 0) {
                akm akm = c35472i.ttY;
                if (akm == null) {
                    C4990ab.m7412e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    AppMethodBeat.m2505o(47974);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", Integer.valueOf(akm.kdT), akm.kdU, akm.wmt, akm.tBw);
                if (akm.kdT != 0) {
                    C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (C5046bo.isNullOrNil(akm.wmt)) {
                    if (akm.tBw != null) {
                        i4 = this.pSK.wey != null ? this.pSK.wey.BTu : 0;
                        this.pSK = akm.tBw;
                        if (!(akm.tBw.wey == null || this.pSK.wey == null)) {
                            C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", Integer.valueOf(akm.tBw.wey.BTu));
                            if (akm.tBw.wey.BTu == 4) {
                                C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.pSK.wey.BTu = i4;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        cSG();
                    }
                    if (this.tOH != null && this.tOG) {
                        if (this.tOH.BTu == 8) {
                            C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            C36391e.m60016n(this.tOD, this.tOH.url, false);
                            this.tOE = true;
                        } else if (this.tOH.BTu == 9) {
                            C16442f c16442f = this.tOH.BTv;
                            if (c16442f != null) {
                                C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", c16442f.wMk, c16442f.wMl, Integer.valueOf(c16442f.wMm));
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = c16442f.wMk;
                                c32628se.cOf.cOh = C5046bo.m7532bc(c16442f.wMl, "");
                                c32628se.cOf.scene = 1060;
                                c32628se.cOf.cst = this.kBE;
                                c32628se.cOf.cOi = 0;
                                if (c16442f.wMm > 0) {
                                    c32628se.cOf.axy = c16442f.wMm;
                                }
                                c32628se.cOf.context = this.tOD;
                                C4879a.xxA.mo10055m(c32628se);
                                this.tOE = true;
                                this.tOI = false;
                                this.fbD.postDelayed(new C226503(), 3000);
                            }
                        }
                    }
                    this.tOH = null;
                    AppMethodBeat.m2505o(47974);
                    return true;
                } else {
                    Toast.makeText(getContext(), akm.wmt, 1).show();
                    AppMethodBeat.m2505o(47974);
                    return true;
                }
            }
            cSH();
            AppMethodBeat.m2505o(47974);
            return true;
        } else if (c1207m instanceof C22562j) {
            C22562j c22562j = (C22562j) c1207m;
            if (i == 0 && i2 == 0) {
                C40593zc c40593zc = c22562j.tua;
                if (c40593zc == null) {
                    C4990ab.m7412e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    AppMethodBeat.m2505o(47974);
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s";
                objArr = new Object[6];
                objArr[0] = Integer.valueOf(c40593zc.kdT);
                objArr[1] = c40593zc.kdU;
                objArr[2] = c40593zc.wew;
                objArr[3] = Integer.valueOf(c40593zc.wex);
                objArr[4] = c40593zc.wey;
                objArr[5] = Integer.valueOf(c40593zc.wey != null ? c40593zc.wey.BTu : 0);
                C4990ab.m7417i(str2, str3, objArr);
                if (c40593zc.kdT == 0) {
                    this.pSK.wew = c40593zc.wew;
                    this.pSK.wex = c40593zc.wex;
                    if (this.pSK.wey != null) {
                        i4 = this.pSK.wey.BTu;
                    } else {
                        i4 = 0;
                    }
                    if (c40593zc.wey != null) {
                        this.pSK.wey = c40593zc.wey;
                        if (this.pSK.wey != null && c40593zc.wey.BTu == 4) {
                            C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.pSK.wey.BTu = i4;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", WalletSuccPageAwardWidget.m34323b(this.pSK));
                    cSM();
                }
            }
            this.tOE = false;
            AppMethodBeat.m2505o(47974);
            return true;
        } else if (c1207m instanceof C43789g) {
            C43789g c43789g = (C43789g) c1207m;
            if (i == 0 && i2 == 0) {
                C23466xq c23466xq = c43789g.ttS;
                if (c23466xq == null) {
                    C4990ab.m7412e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    AppMethodBeat.m2505o(47974);
                    return true;
                }
                str2 = "MicroMsg.WalletSuccPageAwardWidget";
                str3 = "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(c23466xq.kdT);
                objArr[1] = c23466xq.kdU;
                objArr[2] = c23466xq.tBw;
                objArr[3] = c23466xq.tBw != null ? c23466xq.tBw.wew : "";
                C4990ab.m7417i(str2, str3, objArr);
                if (c23466xq.tBw == null || c23466xq.tBw.wew == null || c23466xq.tBw.wew.size() <= 0) {
                    cSH();
                } else {
                    str2 = "MicroMsg.WalletSuccPageAwardWidget";
                    str3 = "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s";
                    objArr = new Object[3];
                    objArr[0] = c23466xq.tBw;
                    objArr[1] = c23466xq.tBw.wey;
                    if (c23466xq.tBw.wey != null) {
                        i4 = c23466xq.tBw.wey.BTu;
                    } else {
                        i4 = 0;
                    }
                    objArr[2] = Integer.valueOf(i4);
                    C4990ab.m7417i(str2, str3, objArr);
                    if (this.pSK.wey != null) {
                        i3 = this.pSK.wey.BTu;
                    }
                    this.pSK = c23466xq.tBw;
                    if (!(this.pSK.wey == null || c23466xq.tBw.wey == null || c23466xq.tBw.wey.BTu != 4)) {
                        C4990ab.m7416i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.pSK.wey.BTu = i3;
                    }
                    cSG();
                }
            } else {
                cSH();
            }
            AppMethodBeat.m2505o(47974);
            return true;
        } else {
            AppMethodBeat.m2505o(47974);
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(47975);
        if (this.tOA != null && this.tOA.getVisibility() == 0) {
            if (this.tOA != null) {
                boolean K;
                WalletScratchShakeView walletScratchShakeView = this.tOA;
                if (walletScratchShakeView.tNW != null) {
                    K = walletScratchShakeView.tNW.mo9505K(motionEvent);
                } else {
                    K = false;
                }
                if (K) {
                }
                walletScratchShakeView = this.tOA;
                if (walletScratchShakeView.tNW != null) {
                    K = walletScratchShakeView.tNW.tOq;
                } else {
                    K = true;
                }
                if (!K) {
                    z = this.tOA.dispatchTouchEvent(motionEvent);
                }
            }
            if (!(this.sis == null || z)) {
                z = this.sis.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(47975);
                return z;
            }
        }
        z = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(47975);
        return z;
    }

    /* renamed from: b */
    private static String m34323b(C31176c c31176c) {
        AppMethodBeat.m2504i(47976);
        String jSONObject;
        if (c31176c != null) {
            try {
                JSONObject jSONObject2;
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (c31176c.wew != null && c31176c.wew.size() > 0) {
                    Iterator it = c31176c.wew.iterator();
                    while (it.hasNext()) {
                        C44605g c44605g = (C44605g) it.next();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("logo", c44605g.pia);
                        jSONObject4.put("award_name", c44605g.BTP);
                        jSONObject4.put("award_description", c44605g.BTQ);
                        jSONObject4.put("background_img", c44605g.BTR);
                        jSONObject4.put("award_name_color", c44605g.BTS);
                        jSONObject4.put("award_description_color", c44605g.BTT);
                        jSONArray.put(jSONObject4);
                    }
                }
                jSONObject3.put("single_exposure_info_list", jSONArray);
                jSONObject3.put("is_query_others", c31176c.BTA);
                jSONObject3.put("draw_lottery_params", c31176c.wdr);
                jSONObject3.put("is_show_btn", c31176c.wex);
                JSONObject jSONObject5 = new JSONObject();
                if (c31176c.wey != null) {
                    jSONObject5.put("btn_words", c31176c.wey.BTs);
                    jSONObject5.put("btn_color", c31176c.wey.BTt);
                    jSONObject5.put("btn_op_type", c31176c.wey.BTu);
                    jSONObject5.put("url", c31176c.wey.url);
                    jSONObject2 = new JSONObject();
                    if (c31176c.wey.BTv != null) {
                        jSONObject2.put("activity_tinyapp_username", c31176c.wey.BTv.wMk);
                        jSONObject2.put("activity_tinyapp_path", c31176c.wey.BTv.wMl);
                        jSONObject2.put("activity_tinyapp_version", c31176c.wey.BTv.wMm);
                    }
                    jSONObject5.put("mini_app_info", jSONObject2);
                    jSONObject5.put("get_lottery_params", c31176c.wey.wqf);
                }
                jSONObject3.put("btn_info", jSONObject5);
                jSONObject3.put("exposure_info_modify_params", c31176c.wev);
                jSONObject3.put("user_opertaion_type", c31176c.BTB);
                jSONObject3.put("is_show_layer", c31176c.BTC);
                jSONObject3.put("background_img_whole", c31176c.BTE);
                if (c31176c.BTF != null) {
                    jSONObject5 = new JSONObject();
                    jSONObject5.put("animation_wording", c31176c.BTF.BTw);
                    jSONObject5.put("animation_wording_color", c31176c.BTF.BTx);
                    jSONObject5.put("url", c31176c.BTF.url);
                    jSONObject5.put("op_type", c31176c.BTF.xis);
                    jSONObject5.put("after_animation_wording", c31176c.BTF.BTy);
                    jSONObject5.put("after_animation_wording_color", c31176c.BTF.BTz);
                    jSONObject2 = new JSONObject();
                    if (c31176c.BTF.BTv != null) {
                        jSONObject2.put("activity_tinyapp_username", c31176c.BTF.BTv.wMk);
                        jSONObject2.put("activity_tinyapp_path", c31176c.BTF.BTv.wMl);
                        jSONObject2.put("activity_tinyapp_version", c31176c.BTF.BTv.wMm);
                    }
                    jSONObject5.put("mini_app_info", jSONObject2);
                    jSONObject3.put("draw_lottery_info", jSONObject5);
                }
                jSONObject = jSONObject3.toString();
                AppMethodBeat.m2505o(47976);
                return jSONObject;
            } catch (Exception e) {
                jSONObject = "";
                AppMethodBeat.m2505o(47976);
                return jSONObject;
            }
        }
        jSONObject = "";
        AppMethodBeat.m2505o(47976);
        return jSONObject;
    }

    /* renamed from: c */
    static /* synthetic */ void m34324c(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z;
        AppMethodBeat.m2504i(47977);
        boolean z2 = walletSuccPageAwardWidget.pSK.BTB == 1 || walletSuccPageAwardWidget.pSK.BTB == 3;
        if (walletSuccPageAwardWidget.pSK.BTB == 2 || walletSuccPageAwardWidget.pSK.BTB == 3) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        int fromDPToPix = C1338a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.tOA;
        float f = (float) fromDPToPix;
        fromDPToPix /= 2;
        C4990ab.m7417i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        walletScratchShakeView.tNY = z2;
        walletScratchShakeView.tNX = z;
        if (walletScratchShakeView.tNW != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.tNW);
            walletScratchShakeView.tNW = null;
        }
        walletScratchShakeView.tNW = new C4458b(walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.tNW, new ViewGroup.LayoutParams(-1, -1));
        C4458b c4458b = walletScratchShakeView.tNW;
        C4990ab.m7416i("MicroMsg.WalletScratchShakeView", "init inner view");
        c4458b.aKf = new Paint();
        c4458b.aKf.setAntiAlias(true);
        c4458b.aKf.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(c4458b.getResources(), C25738R.drawable.blr);
        c4458b.tOb = new NinePatchDrawable(c4458b.getResources(), new NinePatch(decodeResource, C4458b.m6835ab(decodeResource), "shake_bg"));
        c4458b.tOc = new Paint();
        c4458b.tOc.setAntiAlias(true);
        c4458b.tOc.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        c4458b.tOc.setStyle(Style.STROKE);
        c4458b.tOc.setStrokeCap(Cap.ROUND);
        c4458b.tOc.setStrokeWidth(f);
        c4458b.tOd = new Paint();
        c4458b.tOd.setAntiAlias(true);
        c4458b.tOd.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        c4458b.tOd.setStyle(Style.FILL);
        c4458b.tOd.setStrokeCap(Cap.ROUND);
        c4458b.tOe = new Path();
        c4458b.tOf = new Path();
        c4458b.tOn = 0.0f;
        c4458b.tOm = 0.0f;
        c4458b.nfE = ViewConfiguration.get(c4458b.getContext()).getScaledTouchSlop();
        c4458b.tOk = false;
        c4458b.tOl = false;
        c4458b.tOo = fromDPToPix;
        if (WalletScratchShakeView.this.tNX) {
            c4458b.oOS = new C30050d(c4458b.getContext());
            c4458b.oOS.mo48276a(new C44591());
            c4458b.mfT = C5046bo.m7588yz();
        }
        c4458b.invalidate();
        walletScratchShakeView.setClipChildren(false);
        walletSuccPageAwardWidget.tOA.setScratchShakeCallback(new C226512());
        AppMethodBeat.m2505o(47977);
    }

    /* renamed from: a */
    static /* synthetic */ void m34319a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i, boolean z) {
        AppMethodBeat.m2504i(47978);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", Integer.valueOf(walletSuccPageAwardWidget.pSK.BTA));
        if (walletSuccPageAwardWidget.pSK.BTA != 0) {
            walletSuccPageAwardWidget.tOD.mo39970a(new C43789g(walletSuccPageAwardWidget.pSK.wdr, i, walletSuccPageAwardWidget.ttT), z, false);
        }
        AppMethodBeat.m2505o(47978);
    }

    /* renamed from: g */
    static /* synthetic */ void m34328g(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        AppMethodBeat.m2504i(47979);
        C4990ab.m7417i("MicroMsg.WalletSuccPageAwardWidget", "delayCheckStartMiniApp, isMiniAppReturn: %s", Boolean.valueOf(walletSuccPageAwardWidget.tOI));
        if (!walletSuccPageAwardWidget.tOI) {
            walletSuccPageAwardWidget.cSI();
            walletSuccPageAwardWidget.tOI = true;
        }
        AppMethodBeat.m2505o(47979);
    }

    /* renamed from: ac */
    static /* synthetic */ byte[] m34321ac(Bitmap bitmap) {
        int i = 0;
        AppMethodBeat.m2504i(47980);
        int[] iArr = new int[]{(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
        int[] iArr2 = new int[]{(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        byte[] array = order.array();
        AppMethodBeat.m2505o(47980);
        return array;
    }

    /* renamed from: r */
    static /* synthetic */ void m34339r(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        AppMethodBeat.m2504i(47981);
        walletSuccPageAwardWidget.tOD.mo39970a(new C35472i(walletSuccPageAwardWidget.pSK.wey.wqf, walletSuccPageAwardWidget.ttT), true, true);
        AppMethodBeat.m2505o(47981);
    }
}
