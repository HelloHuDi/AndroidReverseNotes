package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.m;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    private CharSequence IT;
    private ScrollView hJh;
    View jcl;
    private Activity mActivity;
    private Context mContext;
    private ak mHandler = new ak();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22153);
            if (view == g.this.nCJ) {
                g.a(g.this, 1);
                AppMethodBeat.o(22153);
            } else if (view == g.this.nCK) {
                g.a(g.this, 2);
                AppMethodBeat.o(22153);
            } else {
                if (view == g.this.nCL) {
                    g.a(g.this, 3);
                }
                AppMethodBeat.o(22153);
            }
        }
    };
    private int mlt = R.color.p9;
    private int mlu = R.drawable.o2;
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
    private int nCZ = R.drawable.nz;
    private int nDa = R.color.a6a;

    public static class a {
        public String Id;
        public boolean nDc;
        public String nzz;
    }

    static /* synthetic */ String b(g gVar, int i) {
        AppMethodBeat.i(22172);
        String xq = gVar.xq(i);
        AppMethodBeat.o(22172);
        return xq;
    }

    public g(Activity activity, Context context, int i, long j) {
        String format;
        super(context, R.style.zt);
        AppMethodBeat.i(22160);
        setCancelable(false);
        this.mContext = context;
        this.nCF = i;
        this.nCG = j;
        this.mActivity = activity;
        this.jcl = View.inflate(this.mContext, R.layout.a8v, null);
        this.nCH = (LinearLayout) this.jcl.findViewById(R.id.cmd);
        this.nCI = (LinearLayout) this.jcl.findViewById(R.id.cmo);
        this.nCY = AnimationUtils.loadAnimation(ah.getContext(), R.anim.n);
        this.nCY.setDuration(200);
        this.nCY.setStartOffset(100);
        bIn();
        this.nCJ = (RelativeLayout) this.jcl.findViewById(R.id.cme);
        this.nCK = (RelativeLayout) this.jcl.findViewById(R.id.cmg);
        this.nCL = (RelativeLayout) this.jcl.findViewById(R.id.cmi);
        this.nCJ.setOnClickListener(this.mOnClickListener);
        this.nCK.setOnClickListener(this.mOnClickListener);
        this.nCL.setOnClickListener(this.mOnClickListener);
        this.nCM = (ImageView) this.jcl.findViewById(R.id.cmf);
        this.nCN = (ImageView) this.jcl.findViewById(R.id.cmh);
        this.nCO = (ImageView) this.jcl.findViewById(R.id.cmj);
        this.nCP = 0;
        xp(this.nCP);
        this.nCV = (Button) this.jcl.findViewById(R.id.cmr);
        this.nCW = (Button) this.jcl.findViewById(R.id.cms);
        this.nCX = (TextView) this.jcl.findViewById(R.id.cmq);
        if (c.bIU() != null) {
            format = String.format(this.mContext.getString(R.string.cjk), new Object[]{r0.wuA});
        } else {
            format = null;
        }
        if (bo.isNullOrNil(format)) {
            this.nCX.setVisibility(4);
        } else {
            this.nCX.setVisibility(0);
            this.nCX.setText(format);
        }
        this.nCV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22157);
                g.this.dismiss();
                d.a(1, -1, g.this.nCP, g.b(g.this, g.this.nCP), 1, -1, 1, g.this.nCF, g.this.nCG);
                AppMethodBeat.o(22157);
            }
        });
        this.nCW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22158);
                g.this.dismiss();
                Intent intent = new Intent();
                intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
                intent.setClass(g.this.mContext, IPCallShareCouponCardUI.class);
                g.this.mContext.startActivity(intent);
                d.a(1, -1, g.this.nCP, g.b(g.this, g.this.nCP), 1, 1, -1, g.this.nCF, g.this.nCG);
                AppMethodBeat.o(22158);
            }
        });
        this.hJh = (ScrollView) this.jcl.findViewById(R.id.cmc);
        final View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(22151);
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    g gVar = g.this;
                    gVar.jcl.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(22152);
                            g.this.hJh.fullScroll(130);
                            AppMethodBeat.o(22152);
                        }
                    }, 100);
                }
                AppMethodBeat.o(22151);
            }
        });
        AppMethodBeat.o(22160);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(22161);
        super.onCreate(bundle);
        setContentView(this.jcl);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        xs(0);
        AppMethodBeat.o(22161);
    }

    private void xp(int i) {
        AppMethodBeat.i(22162);
        this.nCP = i;
        if (i == 0) {
            this.nCM.setVisibility(4);
            this.nCN.setVisibility(4);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(false);
            xs(0);
            AppMethodBeat.o(22162);
        } else if (i == 1) {
            this.nCM.setVisibility(0);
            this.nCN.setVisibility(4);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(true);
            xs(1);
            AppMethodBeat.o(22162);
        } else if (i == 2) {
            this.nCM.setVisibility(0);
            this.nCN.setVisibility(0);
            this.nCO.setVisibility(4);
            this.nCT.setEnabled(true);
            xs(1);
            AppMethodBeat.o(22162);
        } else {
            if (i == 3) {
                this.nCM.setVisibility(0);
                this.nCN.setVisibility(0);
                this.nCO.setVisibility(0);
                this.nCT.setEnabled(true);
                xs(0);
            }
            AppMethodBeat.o(22162);
        }
    }

    private void bIn() {
        String gM;
        f fVar;
        AppMethodBeat.i(22163);
        this.nCQ = (FrameLayout) this.jcl.findViewById(R.id.cmk);
        this.nCR = (FlowLayout) this.jcl.findViewById(R.id.cml);
        this.nCS = (Button) this.jcl.findViewById(R.id.cmm);
        this.nCT = (Button) this.jcl.findViewById(R.id.cmn);
        this.nCU = (PasterEditText) this.jcl.findViewById(R.id.b09);
        this.nCS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22154);
                g.this.dismiss();
                int i = -1;
                d.a(-1, 1, i, "", 0, -1, -1, g.this.nCF, g.this.nCG);
                AppMethodBeat.o(22154);
            }
        });
        this.nCT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22155);
                g.g(g.this);
                AppMethodBeat.o(22155);
            }
        });
        e bHj = e.bHj();
        if (bHj.nvw == null) {
            ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            b.c.veg;
            gM = b.gM(39, 1);
            if (bo.isNullOrNil(gM)) {
                ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] f = com.tencent.mm.a.e.f(gM, 0, -1);
                if (f != null) {
                    bHj.aX(f);
                } else {
                    ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (bHj.nvw != null) {
            String str;
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
            ah.getContext();
            gM = aa.h(sharedPreferences);
            if (!"language_default".equalsIgnoreCase(gM) || Locale.getDefault() == null) {
                str = gM;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = bHj.nvw.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.nzA)) {
                    ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", str, Integer.valueOf(bHj.nvw.size()));
                    break;
                }
            }
            ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", str, Integer.valueOf(bHj.nvw.size()));
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.nzB;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.Id = eVar.Id;
                aVar.nzz = eVar.nzz;
                aVar.nDc = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.nCR;
                TextView textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.dimen.a27) * com.tencent.mm.bz.a.dm(getContext()));
                textView.setBackgroundResource(this.mlu);
                textView.setTextColor(this.mContext.getResources().getColor(this.mlt));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.nzz);
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(22156);
                        a aVar = (a) view.getTag();
                        if (aVar.nDc) {
                            aVar.nDc = false;
                        } else {
                            aVar.nDc = true;
                        }
                        g.a(g.this, (TextView) view);
                        AppMethodBeat.o(22156);
                    }
                });
                flowLayout.addView(textView);
            }
        }
        AppMethodBeat.o(22163);
    }

    private String xq(int i) {
        AppMethodBeat.i(22164);
        String str = "";
        String str2;
        if (i == 3) {
            str2 = "";
            AppMethodBeat.o(22164);
            return str2;
        }
        if (!bo.isNullOrNil(this.nCU.getText().toString().trim())) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (true) {
                str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (!aVar.nDc) {
                    str = str2;
                } else if (str2.equals("")) {
                    str = aVar.Id;
                } else {
                    str = str2 + "_" + aVar.Id;
                }
            }
        } else {
            str2 = str;
        }
        AppMethodBeat.o(22164);
        return str2;
    }

    private LinkedList<cru> xr(int i) {
        AppMethodBeat.i(22165);
        LinkedList<cru> linkedList = new LinkedList();
        if (i == 3) {
            AppMethodBeat.o(22165);
            return linkedList;
        }
        String trim = this.nCU.getText().toString().trim();
        if (!bo.isNullOrNil(trim)) {
            cru cru = new cru();
            cru.ID = 0;
            cru.ncM = trim;
            linkedList.add(cru);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.nDc) {
                    cru cru2 = new cru();
                    try {
                        cru2.ID = bo.getInt(aVar.Id, 0);
                        linkedList.add(cru2);
                    } catch (NumberFormatException e) {
                        ab.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.Id);
                    }
                }
            }
        }
        AppMethodBeat.o(22165);
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.IT = charSequence;
        } else {
            this.IT = null;
        }
    }

    public final void show() {
        AppMethodBeat.i(22166);
        super.show();
        AppMethodBeat.o(22166);
    }

    public final void dismiss() {
        AppMethodBeat.i(22167);
        try {
            super.dismiss();
            AppMethodBeat.o(22167);
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(22167);
        }
    }

    private void xs(int i) {
        AppMethodBeat.i(22168);
        if (i == 0) {
            this.nCH.setVisibility(0);
            this.nCI.setVisibility(4);
            if (this.nCE == 1) {
                ((LayoutParams) this.nCQ.getLayoutParams()).height = 0;
                this.nCQ.requestLayout();
            }
            bo.hideVKB(this.jcl);
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
            bo.hideVKB(this.jcl);
        }
        this.nCE = i;
        AppMethodBeat.o(22168);
    }

    static /* synthetic */ void g(g gVar) {
        AppMethodBeat.i(22170);
        aw.Rg().a(new m(gVar.nCF, gVar.nCP, gVar.xr(gVar.nCP)), 0);
        if (gVar.nCP == 3) {
            gVar.xs(2);
            AppMethodBeat.o(22170);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22159);
                g.this.dismiss();
                AppMethodBeat.o(22159);
            }
        }, 1800);
        com.tencent.mm.ui.widget.snackbar.b.i(gVar.mActivity, gVar.mContext.getString(R.string.cio));
        d.a(1, -1, gVar.nCP, gVar.xq(gVar.nCP), 0, -1, -1, gVar.nCF, gVar.nCG);
        AppMethodBeat.o(22170);
    }
}
