package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.FlowLayout;
import com.tencent.p177mm.p612ui.widget.edittext.PasterEditText;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.C43221e;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C39260d;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C39256m;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21085e;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C43225f;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.protocal.protobuf.cru;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.g */
public final class C39274g extends Dialog {
    /* renamed from: IT */
    private CharSequence f16172IT;
    private ScrollView hJh;
    View jcl;
    private Activity mActivity;
    private Context mContext;
    private C7306ak mHandler = new C7306ak();
    private ArrayList<C39277a> mItemList;
    private OnClickListener mOnClickListener = new C392753();
    private int mlt = C25738R.color.f12007p9;
    private int mlu = C25738R.drawable.f6721o2;
    private int nCE = 0;
    private int nCF;
    private long nCG;
    private LinearLayout nCH;
    private LinearLayout nCI;
    private RelativeLayout nCJ;
    private RelativeLayout nCK;
    private RelativeLayout nCL;
    private ImageView nCM;
    private ImageView nCN;
    private ImageView nCO;
    private int nCP;
    private FrameLayout nCQ;
    private FlowLayout nCR;
    private Button nCS;
    private Button nCT;
    private PasterEditText nCU;
    private Button nCV;
    private Button nCW;
    private TextView nCX;
    private Animation nCY;
    private int nCZ = C25738R.drawable.f6718nz;
    private int nDa = C25738R.color.a6a;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$9 */
    class C123269 implements Runnable {
        C123269() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22159);
            C39274g.this.dismiss();
            AppMethodBeat.m2505o(22159);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$2 */
    class C211422 implements Runnable {
        C211422() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22152);
            C39274g.this.hJh.fullScroll(130);
            AppMethodBeat.m2505o(22152);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$8 */
    class C283518 implements OnClickListener {
        C283518() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22158);
            C39274g.this.dismiss();
            Intent intent = new Intent();
            intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
            intent.setClass(C39274g.this.mContext, IPCallShareCouponCardUI.class);
            C39274g.this.mContext.startActivity(intent);
            C39260d.m66909a(1, -1, C39274g.this.nCP, C39274g.m66939b(C39274g.this, C39274g.this.nCP), 1, 1, -1, C39274g.this.nCF, C39274g.this.nCG);
            AppMethodBeat.m2505o(22158);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$4 */
    class C392714 implements OnClickListener {
        C392714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22154);
            C39274g.this.dismiss();
            int i = -1;
            C39260d.m66909a(-1, 1, i, "", 0, -1, -1, C39274g.this.nCF, C39274g.this.nCG);
            AppMethodBeat.m2505o(22154);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$6 */
    class C392726 implements OnClickListener {
        C392726() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22156);
            C39277a c39277a = (C39277a) view.getTag();
            if (c39277a.nDc) {
                c39277a.nDc = false;
            } else {
                c39277a.nDc = true;
            }
            C39274g.m66937a(C39274g.this, (TextView) view);
            AppMethodBeat.m2505o(22156);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$7 */
    class C392737 implements OnClickListener {
        C392737() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22157);
            C39274g.this.dismiss();
            C39260d.m66909a(1, -1, C39274g.this.nCP, C39274g.m66939b(C39274g.this, C39274g.this.nCP), 1, -1, 1, C39274g.this.nCF, C39274g.this.nCG);
            AppMethodBeat.m2505o(22157);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$3 */
    class C392753 implements OnClickListener {
        C392753() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22153);
            if (view == C39274g.this.nCJ) {
                C39274g.m66936a(C39274g.this, 1);
                AppMethodBeat.m2505o(22153);
            } else if (view == C39274g.this.nCK) {
                C39274g.m66936a(C39274g.this, 2);
                AppMethodBeat.m2505o(22153);
            } else {
                if (view == C39274g.this.nCL) {
                    C39274g.m66936a(C39274g.this, 3);
                }
                AppMethodBeat.m2505o(22153);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$5 */
    class C392765 implements OnClickListener {
        C392765() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22155);
            C39274g.m66944g(C39274g.this);
            AppMethodBeat.m2505o(22155);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.g$a */
    public static class C39277a {
        /* renamed from: Id */
        public String f16173Id;
        public boolean nDc;
        public String nzz;
    }

    /* renamed from: b */
    static /* synthetic */ String m66939b(C39274g c39274g, int i) {
        AppMethodBeat.m2504i(22172);
        String xq = c39274g.m66948xq(i);
        AppMethodBeat.m2505o(22172);
        return xq;
    }

    public C39274g(Activity activity, Context context, int i, long j) {
        String format;
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(22160);
        setCancelable(false);
        this.mContext = context;
        this.nCF = i;
        this.nCG = j;
        this.mActivity = activity;
        this.jcl = View.inflate(this.mContext, 2130969896, null);
        this.nCH = (LinearLayout) this.jcl.findViewById(2131825146);
        this.nCI = (LinearLayout) this.jcl.findViewById(2131825157);
        this.nCY = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8288n);
        this.nCY.setDuration(200);
        this.nCY.setStartOffset(100);
        bIn();
        this.nCJ = (RelativeLayout) this.jcl.findViewById(2131825147);
        this.nCK = (RelativeLayout) this.jcl.findViewById(2131825149);
        this.nCL = (RelativeLayout) this.jcl.findViewById(2131825151);
        this.nCJ.setOnClickListener(this.mOnClickListener);
        this.nCK.setOnClickListener(this.mOnClickListener);
        this.nCL.setOnClickListener(this.mOnClickListener);
        this.nCM = (ImageView) this.jcl.findViewById(2131825148);
        this.nCN = (ImageView) this.jcl.findViewById(2131825150);
        this.nCO = (ImageView) this.jcl.findViewById(2131825152);
        this.nCP = 0;
        m66947xp(this.nCP);
        this.nCV = (Button) this.jcl.findViewById(2131825160);
        this.nCW = (Button) this.jcl.findViewById(2131825161);
        this.nCX = (TextView) this.jcl.findViewById(2131825159);
        if (C34382c.bIU() != null) {
            format = String.format(this.mContext.getString(C25738R.string.cjk), new Object[]{r0.wuA});
        } else {
            format = null;
        }
        if (C5046bo.isNullOrNil(format)) {
            this.nCX.setVisibility(4);
        } else {
            this.nCX.setVisibility(0);
            this.nCX.setText(format);
        }
        this.nCV.setOnClickListener(new C392737());
        this.nCW.setOnClickListener(new C283518());
        this.hJh = (ScrollView) this.jcl.findViewById(2131825145);
        final View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.m2504i(22151);
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    C39274g c39274g = C39274g.this;
                    c39274g.jcl.postDelayed(new C211422(), 100);
                }
                AppMethodBeat.m2505o(22151);
            }
        });
        AppMethodBeat.m2505o(22160);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22161);
        super.onCreate(bundle);
        setContentView(this.jcl);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        m66950xs(0);
        AppMethodBeat.m2505o(22161);
    }

    /* renamed from: xp */
    private void m66947xp(int i) {
        AppMethodBeat.m2504i(22162);
        this.nCP = i;
        if (i == 0) {
            this.nCM.setVisibility(4);
            this.nCN.setVisibility(4);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(false);
            m66950xs(0);
            AppMethodBeat.m2505o(22162);
        } else if (i == 1) {
            this.nCM.setVisibility(0);
            this.nCN.setVisibility(4);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(true);
            m66950xs(1);
            AppMethodBeat.m2505o(22162);
        } else if (i == 2) {
            this.nCM.setVisibility(0);
            this.nCN.setVisibility(0);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(true);
            m66950xs(1);
            AppMethodBeat.m2505o(22162);
        } else {
            if (i == 3) {
                this.nCM.setVisibility(0);
                this.nCN.setVisibility(0);
                this.nCO.setVisibility(0);
                this.nCT.setEnabled(true);
                m66950xs(0);
            }
            AppMethodBeat.m2505o(22162);
        }
    }

    private void bIn() {
        String gM;
        C43225f c43225f;
        AppMethodBeat.m2504i(22163);
        this.nCQ = (FrameLayout) this.jcl.findViewById(2131825153);
        this.nCR = (FlowLayout) this.jcl.findViewById(2131825154);
        this.nCS = (Button) this.jcl.findViewById(2131825155);
        this.nCT = (Button) this.jcl.findViewById(2131825156);
        this.nCU = (PasterEditText) this.jcl.findViewById(2131822921);
        this.nCS.setOnClickListener(new C392714());
        this.nCT.setOnClickListener(new C392765());
        C43221e bHj = C43221e.bHj();
        if (bHj.nvw == null) {
            C4990ab.m7416i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            C14845c.veg;
            gM = C14839b.m23097gM(39, 1);
            if (C5046bo.isNullOrNil(gM)) {
                C4990ab.m7416i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] f = C1173e.m2571f(gM, 0, -1);
                if (f != null) {
                    bHj.mo68729aX(f);
                } else {
                    C4990ab.m7412e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (bHj.nvw != null) {
            String str;
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
            C4996ah.getContext();
            gM = C4988aa.m7405h(sharedPreferences);
            if (!"language_default".equalsIgnoreCase(gM) || Locale.getDefault() == null) {
                str = gM;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = bHj.nvw.iterator();
            while (it.hasNext()) {
                c43225f = (C43225f) it.next();
                if (str.equalsIgnoreCase(c43225f.nzA)) {
                    C4990ab.m7417i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", str, Integer.valueOf(bHj.nvw.size()));
                    break;
                }
            }
            C4990ab.m7413e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", str, Integer.valueOf(bHj.nvw.size()));
        }
        c43225f = null;
        if (c43225f != null) {
            ArrayList arrayList = c43225f.nzB;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C21085e c21085e = (C21085e) it2.next();
                C39277a c39277a = new C39277a();
                c39277a.f16173Id = c21085e.f4385Id;
                c39277a.nzz = c21085e.nzz;
                c39277a.nDc = false;
                arrayList2.add(c39277a);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                C39277a c39277a2 = (C39277a) it3.next();
                FlowLayout flowLayout = this.nCR;
                TextView textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(C25738R.dimen.a27) * C1338a.m2860dm(getContext()));
                textView.setBackgroundResource(this.mlu);
                textView.setTextColor(this.mContext.getResources().getColor(this.mlt));
                textView.setTag(c39277a2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(c39277a2.nzz);
                textView.setOnClickListener(new C392726());
                flowLayout.addView(textView);
            }
        }
        AppMethodBeat.m2505o(22163);
    }

    /* renamed from: xq */
    private String m66948xq(int i) {
        AppMethodBeat.m2504i(22164);
        String str = "";
        String str2;
        if (i == 3) {
            str2 = "";
            AppMethodBeat.m2505o(22164);
            return str2;
        }
        if (!C5046bo.isNullOrNil(this.nCU.getText().toString().trim())) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (true) {
                str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                C39277a c39277a = (C39277a) it.next();
                if (!c39277a.nDc) {
                    str = str2;
                } else if (str2.equals("")) {
                    str = c39277a.f16173Id;
                } else {
                    str = str2 + "_" + c39277a.f16173Id;
                }
            }
        } else {
            str2 = str;
        }
        AppMethodBeat.m2505o(22164);
        return str2;
    }

    /* renamed from: xr */
    private LinkedList<cru> m66949xr(int i) {
        AppMethodBeat.m2504i(22165);
        LinkedList<cru> linkedList = new LinkedList();
        if (i == 3) {
            AppMethodBeat.m2505o(22165);
            return linkedList;
        }
        String trim = this.nCU.getText().toString().trim();
        if (!C5046bo.isNullOrNil(trim)) {
            cru cru = new cru();
            cru.f13733ID = 0;
            cru.ncM = trim;
            linkedList.add(cru);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                C39277a c39277a = (C39277a) it.next();
                if (c39277a.nDc) {
                    cru cru2 = new cru();
                    try {
                        cru2.f13733ID = C5046bo.getInt(c39277a.f16173Id, 0);
                        linkedList.add(cru2);
                    } catch (NumberFormatException e) {
                        C4990ab.m7412e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + c39277a.f16173Id);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(22165);
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f16172IT = charSequence;
        } else {
            this.f16172IT = null;
        }
    }

    public final void show() {
        AppMethodBeat.m2504i(22166);
        super.show();
        AppMethodBeat.m2505o(22166);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(22167);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(22167);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(22167);
        }
    }

    /* renamed from: xs */
    private void m66950xs(int i) {
        AppMethodBeat.m2504i(22168);
        if (i == 0) {
            this.nCH.setVisibility(0);
            this.nCI.setVisibility(4);
            if (this.nCE == 1) {
                ((LayoutParams) this.nCQ.getLayoutParams()).height = 0;
                this.nCQ.requestLayout();
            }
            C5046bo.hideVKB(this.jcl);
        } else if (i == 1) {
            this.nCH.setVisibility(0);
            this.nCI.setVisibility(4);
            if (this.nCE == 0) {
                ((LayoutParams) this.nCQ.getLayoutParams()).height = -2;
                this.nCQ.requestLayout();
                this.nCQ.startAnimation(this.nCY);
            }
        } else if (i == 2) {
            this.nCH.setVisibility(4);
            this.nCI.setVisibility(0);
            C5046bo.hideVKB(this.jcl);
        }
        this.nCE = i;
        AppMethodBeat.m2505o(22168);
    }

    /* renamed from: g */
    static /* synthetic */ void m66944g(C39274g c39274g) {
        AppMethodBeat.m2504i(22170);
        C9638aw.m17182Rg().mo14541a(new C39256m(c39274g.nCF, c39274g.nCP, c39274g.m66949xr(c39274g.nCP)), 0);
        if (c39274g.nCP == 3) {
            c39274g.m66950xs(2);
            AppMethodBeat.m2505o(22170);
            return;
        }
        c39274g.hide();
        c39274g.mHandler.postDelayed(new C123269(), 1800);
        C5670b.m8523i(c39274g.mActivity, c39274g.mContext.getString(C25738R.string.cio));
        C39260d.m66909a(1, -1, c39274g.nCP, c39274g.m66948xq(c39274g.nCP), 0, -1, -1, c39274g.nCF, c39274g.nCG);
        AppMethodBeat.m2505o(22170);
    }
}
