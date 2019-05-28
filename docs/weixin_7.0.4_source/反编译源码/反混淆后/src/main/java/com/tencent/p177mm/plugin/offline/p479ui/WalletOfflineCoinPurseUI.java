package com.tencent.p177mm.plugin.offline.p479ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18216ap;
import com.tencent.p177mm.p230g.p231a.C32565gq;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C37756lf;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p230g.p231a.C45315ca;
import com.tencent.p177mm.p230g.p231a.C45341lg;
import com.tencent.p177mm.p230g.p231a.C45361qs;
import com.tencent.p177mm.p230g.p231a.C6468cm;
import com.tencent.p177mm.p230g.p231a.C6517lu;
import com.tencent.p177mm.p230g.p231a.C9489us;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.offline.C12741e;
import com.tencent.p177mm.plugin.offline.C34645g;
import com.tencent.p177mm.plugin.offline.C39473i;
import com.tencent.p177mm.plugin.offline.C46119b;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C12736e;
import com.tencent.p177mm.plugin.offline.p478a.C21401j;
import com.tencent.p177mm.plugin.offline.p478a.C21403m;
import com.tencent.p177mm.plugin.offline.p478a.C21404r;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21407d;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21409e;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21410g;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21411f;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C3562a;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C3563c;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C7004b;
import com.tencent.p177mm.plugin.offline.p478a.C28626a;
import com.tencent.p177mm.plugin.offline.p478a.C43353n;
import com.tencent.p177mm.plugin.offline.p478a.C43354o;
import com.tencent.p177mm.plugin.offline.p478a.C46116f;
import com.tencent.p177mm.plugin.offline.p478a.C46118q;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C127628;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1276411;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1276513;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1276614;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C127671;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1276812;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1276915;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C127719;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C1277410;
import com.tencent.p177mm.plugin.offline.p479ui.C12763c.C127787;
import com.tencent.p177mm.plugin.offline.p479ui.OfflineAlertView.C28642a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C29625f;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a.C43798a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22584ac;
import com.tencent.p177mm.plugin.wallet_core.model.C22591c;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C30292bc.C23502a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.wallet_core.p649c.C16077f;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C46724c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@C18524i
/* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI */
public class WalletOfflineCoinPurseUI extends WalletBaseUI implements C18765a, C3562a, C46119b, C3566a, C23502a {
    private static int jpc = 0;
    private int emC;
    private OnClickListener gKK = new C4612015();
    private int gwj = -1;
    private boolean kXv;
    private boolean kjx = true;
    private int lTe;
    private long mLastTime = 0;
    private int mState = 3;
    private String oWS = "";
    private C7564ap oXA = new C7564ap(new C4612232(), false);
    private String oXv = "";
    private C21403m oXx;
    private int oXz = 60000;
    Bitmap oZA = null;
    private C28653a oZB;
    private boolean oZC = false;
    private boolean oZD = false;
    private ArrayList<String> oZE = new ArrayList();
    private ArrayList<String> oZF = new ArrayList();
    private ArrayList<Boolean> oZG = new ArrayList();
    private View oZH;
    private ImageView oZI;
    private ImageView oZJ;
    private TextView oZK;
    private String oZL;
    private View oZM;
    private TextView oZN;
    private ImageView oZO;
    private RelativeLayout oZP;
    private LinearLayout oZQ;
    private LinearLayout oZR;
    private LinearLayout oZS;
    private LinearLayout oZT;
    private LinearLayout oZU;
    private Dialog oZV;
    private String oZW = "";
    private boolean oZX = false;
    private C34645g oZY;
    private boolean oZZ = false;
    private HashMap<String, View> oZx = new HashMap();
    private HashMap<String, Integer> oZy = new HashMap();
    Bitmap oZz = null;
    private boolean paa = false;
    private boolean pab = false;
    private boolean pac = false;
    private ArrayList<Bitmap> pad = new ArrayList();
    private ArrayList<Bitmap> pae = new ArrayList();
    private C46724c paf;
    private C12763c pag;
    private OfflineAlertView pah;
    private boolean pai = false;
    C4884c<C32652uv> paj = new C461211();
    private C4884c<C6468cm> pak = new C4335512();
    private C4884c<C6517lu> pal = new C2141623();
    private C4884c<C37756lf> pam = new C2864936();
    private C4884c<C45341lg> pan = new C2865037();
    private C4884c pao = new C1275138();
    private C4884c pap = new C4612339();
    private C4884c paq = new C701340();
    public boolean par = false;
    private HashMap<String, Integer> pas = new HashMap();
    private C7564ap pat = new C7564ap(new C3947833(), false);
    private C7564ap pau = new C7564ap(new C1275035(), false);

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$40 */
    class C701340 extends C4884c<C18216ap> {
        C701340() {
            AppMethodBeat.m2504i(43554);
            this.xxI = C18216ap.class.getName().hashCode();
            AppMethodBeat.m2505o(43554);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43555);
            C18216ap c18216ap = (C18216ap) c4883b;
            if (C28630a.pbe == 3 && (c18216ap instanceof C18216ap) && c18216ap.ctF.ctG) {
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.m2505o(43555);
                return true;
            }
            AppMethodBeat.m2505o(43555);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$16 */
    class C1274716 implements C30391c {
        C1274716() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(43522);
            switch (i) {
                case 0:
                    C28630a.m45521eH(WalletOfflineCoinPurseUI.this);
                    AppMethodBeat.m2505o(43522);
                    return;
                case 1:
                    C12763c z = WalletOfflineCoinPurseUI.this.pag;
                    if (((C40167b) C1720g.m3528K(C40167b.class)).cTj()) {
                        C30379h.m48466d(z.mActivity, z.getString(C25738R.string.fvg), "", z.getString(C25738R.string.fvf), z.getString(C25738R.string.f9076or), new C127719(), new C1277410());
                        break;
                    }
                    C30379h.m48466d(z.mActivity, z.getString(C25738R.string.fvi), "", z.getString(C25738R.string.fwg), z.getString(C25738R.string.fvf), new C127787(), new C127628());
                    AppMethodBeat.m2505o(43522);
                    return;
            }
            AppMethodBeat.m2505o(43522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$18 */
    class C1274818 implements OnCancelListener {
        C1274818() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(43524);
            WalletOfflineCoinPurseUI.m89331E(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$22 */
    class C1274922 implements DialogInterface.OnClickListener {
        C1274922() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43528);
            dialogInterface.dismiss();
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$35 */
    class C1275035 implements C5015a {
        C1275035() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(43545);
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", Boolean.valueOf(WalletOfflineCoinPurseUI.this.kXv));
            if (WalletOfflineCoinPurseUI.this.kXv) {
                C45315ca c45315ca = new C45315ca();
                c45315ca.cvj.bFZ = 0;
                C4879a.xxA.mo10055m(c45315ca);
            }
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43545);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$38 */
    class C1275138 extends C4884c<C45361qs> {
        C1275138() {
            AppMethodBeat.m2504i(43550);
            this.xxI = C45361qs.class.getName().hashCode();
            AppMethodBeat.m2505o(43550);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43551);
            if (!WalletOfflineCoinPurseUI.this.isFinishing()) {
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.m2505o(43551);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$4 */
    class C127524 implements C28642a {
        C127524() {
        }

        public final void onClose() {
            AppMethodBeat.m2504i(43506);
            WalletOfflineCoinPurseUI.m89357g(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43506);
        }

        public final void onShow() {
            AppMethodBeat.m2504i(43507);
            WalletOfflineCoinPurseUI.m89357g(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43507);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$23 */
    class C2141623 extends C4884c<C6517lu> {
        C2141623() {
            AppMethodBeat.m2504i(43529);
            this.xxI = C6517lu.class.getName().hashCode();
            AppMethodBeat.m2505o(43529);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43530);
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", " ecard finish: %s", Integer.valueOf(((C6517lu) c4883b).cHC.retCode));
            WalletOfflineCoinPurseUI.this.mo39970a(new C35475y(null, 8), false, false);
            AppMethodBeat.m2505o(43530);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$29 */
    class C2141729 implements Runnable {
        C2141729() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43536);
            WalletOfflineCoinPurseUI.m89370s(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43536);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$24 */
    class C2864724 implements OnClickListener {
        C2864724() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43531);
            C28630a.bYo();
            C7007k.bXg();
            C7007k.m11711aT(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            WalletOfflineCoinPurseUI.m89336I(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43531);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$34 */
    class C2864834 implements OnMenuItemClickListener {
        C2864834() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43544);
            C32565gq c32565gq = new C32565gq();
            c32565gq.cBo.cBp = "ok";
            C4879a.xxA.mo10055m(c32565gq);
            if (WalletOfflineCoinPurseUI.this.emC == 8) {
                C28630a.m45508Up(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
            }
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43544);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$36 */
    class C2864936 extends C4884c<C37756lf> {
        C2864936() {
            AppMethodBeat.m2504i(43546);
            this.xxI = C37756lf.class.getName().hashCode();
            AppMethodBeat.m2505o(43546);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43547);
            WalletOfflineCoinPurseUI.this.mo39970a(new C35475y(null, 8), false, false);
            WalletOfflineCoinPurseUI.m89353d(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.m89355e(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.m89356f(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43547);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$37 */
    class C2865037 extends C4884c<C45341lg> {
        C2865037() {
            AppMethodBeat.m2504i(43548);
            this.xxI = C45341lg.class.getName().hashCode();
            AppMethodBeat.m2505o(43548);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43549);
            if (((C45341lg) c4883b).cHi.aBR != hashCode()) {
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "has create a new ui, finish self");
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.m2505o(43549);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$3 */
    class C286513 implements C16077f {
        C286513() {
        }

        public final void bMI() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$a */
    class C28653a extends BaseAdapter {
        ArrayList<String> iPr = new ArrayList();
        ArrayList<Boolean> paT = new ArrayList();

        public C28653a() {
            AppMethodBeat.m2504i(43556);
            AppMethodBeat.m2505o(43556);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(43557);
            int size = this.iPr.size();
            AppMethodBeat.m2505o(43557);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(43558);
            Object obj = this.iPr.get(i);
            AppMethodBeat.m2505o(43558);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(43559);
            boolean booleanValue = ((Boolean) this.paT.get(i)).booleanValue();
            AppMethodBeat.m2505o(43559);
            return booleanValue;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(43560);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletOfflineCoinPurseUI.this, 2130971115, null);
            checkedTextView.setText((String) this.iPr.get(i));
            if (WalletOfflineCoinPurseUI.jpc == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            if (isEnabled(i)) {
                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(C25738R.color.f12212w4));
                checkedTextView.setEnabled(true);
            } else {
                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(C25738R.color.f12092s0));
                checkedTextView.setEnabled(false);
            }
            AppMethodBeat.m2505o(43560);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$21 */
    class C3465521 implements DialogInterface.OnClickListener {
        C3465521() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43527);
            dialogInterface.dismiss();
            C28630a.m45511a(WalletOfflineCoinPurseUI.this, 0, WalletOfflineCoinPurseUI.this.gwj);
            WalletOfflineCoinPurseUI.this.oZD = true;
            C4990ab.m7418v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
            AppMethodBeat.m2505o(43527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$2 */
    class C394762 implements DialogInterface.OnClickListener {
        C394762() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43505);
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43505);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$33 */
    class C3947833 implements C5015a {
        C3947833() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(43543);
            WalletOfflineCoinPurseUI.this.oZX = false;
            if (WalletOfflineCoinPurseUI.this.oZV != null && WalletOfflineCoinPurseUI.this.oZV.isShowing()) {
                WalletOfflineCoinPurseUI.this.oZV.dismiss();
            }
            C34645g.bXc();
            WalletOfflineCoinPurseUI.m89342O(WalletOfflineCoinPurseUI.this);
            if (C28630a.bYE()) {
                WalletOfflineCoinPurseUI.this.bXu();
            }
            AppMethodBeat.m2505o(43543);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$12 */
    class C4335512 extends C4884c<C6468cm> {
        C4335512() {
            AppMethodBeat.m2504i(43517);
            this.xxI = C6468cm.class.getName().hashCode();
            AppMethodBeat.m2505o(43517);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43518);
            C6468cm c6468cm = (C6468cm) c4883b;
            C4990ab.m7410d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
            C7007k.bXg();
            C7007k.bXi();
            C1207m c43354o = new C43354o(C12741e.bWZ(), WalletOfflineCoinPurseUI.this.gwj, c6468cm.cvK.cvL);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c43354o, 0);
            AppMethodBeat.m2505o(43518);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$13 */
    class C4335613 implements OnClickListener {
        C4335613() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43519);
            WalletOfflineCoinPurseUI.m89369r(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43519);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$14 */
    class C4335714 implements OnClickListener {
        C4335714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43520);
            C7060h.pYm.mo8381e(14515, Integer.valueOf(1));
            WalletOfflineCoinPurseUI.m89370s(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43520);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$25 */
    class C4335825 implements OnClickListener {
        C4335825() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43532);
            C28630a.m45522f(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.emC);
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$26 */
    class C4335926 implements OnClickListener {
        C4335926() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43533);
            Object[] objArr = new Object[1];
            C7007k.bXg();
            C7007k.bXj();
            objArr[0] = Integer.valueOf(C39473i.bXf());
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", objArr);
            C7007k.bXg();
            C7007k.bXj();
            if (C39473i.bXf() <= 0) {
                WalletOfflineCoinPurseUI.this.mo39970a(new C21403m(((int) (System.currentTimeMillis() / 1000)), 10), true, false);
                AppMethodBeat.m2505o(43533);
                return;
            }
            WalletOfflineCoinPurseUI.m89337J(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.m2505o(43533);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$27 */
    class C4336027 implements OnClickListener {
        C4336027() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43534);
            C28630a.bYo();
            C28630a.m45523g(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.emC);
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.m2505o(43534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$28 */
    class C4336128 implements Runnable {
        C4336128() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43535);
            C12763c z = WalletOfflineCoinPurseUI.this.pag;
            C28630a.m45519e(z.mActivity, z.oZq);
            WalletOfflineCoinPurseUI.this.oZD = true;
            AppMethodBeat.m2505o(43535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$15 */
    class C4612015 implements OnClickListener {
        C4612015() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43521);
            if (view.getId() == 2131828886 || view.getId() == 2131828885 || view.getId() == 2131828884) {
                if (view.getId() == 2131828886 && WalletOfflineCoinPurseUI.this.pah != null && WalletOfflineCoinPurseUI.this.pah.isShowing()) {
                    C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
                    AppMethodBeat.m2505o(43521);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ((WalletOfflineCoinPurseUI.this.pah == null || !WalletOfflineCoinPurseUI.this.pah.isShowing()) && currentTimeMillis - WalletOfflineCoinPurseUI.this.mLastTime >= 400 && C28630a.bYd() && !WalletOfflineCoinPurseUI.m89373v(WalletOfflineCoinPurseUI.this)) {
                    if (view.getId() == 2131828886) {
                        WalletOfflineCoinPurseUI.this.kjx = false;
                    } else if (view.getId() == 2131828885 || view.getId() == 2131828884) {
                        C7060h.pYm.mo8381e(13958, Integer.valueOf(4));
                        WalletOfflineCoinPurseUI.this.kjx = true;
                    }
                    if (WalletOfflineCoinPurseUI.this.paf != null) {
                        WalletOfflineCoinPurseUI.m89375x(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.this.paf.mo75136G(view, WalletOfflineCoinPurseUI.this.kjx);
                    }
                    WalletOfflineCoinPurseUI.this.mLastTime = currentTimeMillis;
                }
            }
            AppMethodBeat.m2505o(43521);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$1 */
    class C461211 extends C4884c<C32652uv> {
        C461211() {
            AppMethodBeat.m2504i(43503);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(43503);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43504);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4879a.xxA.mo10053d(this);
            if (C28630a.bYE() && c32652uv.cRF.result == 0) {
                WalletOfflineCoinPurseUI.this.oZX = false;
            }
            AppMethodBeat.m2505o(43504);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$32 */
    class C4612232 implements C5015a {
        C4612232() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(43542);
            if (!WalletOfflineCoinPurseUI.this.oZX) {
                WalletOfflineCoinPurseUI.m89329C(WalletOfflineCoinPurseUI.this);
                WalletOfflineCoinPurseUI.m89330D(WalletOfflineCoinPurseUI.this);
            }
            long M = (long) WalletOfflineCoinPurseUI.this.oXz;
            WalletOfflineCoinPurseUI.this.oXA.mo16770ae(M, M);
            AppMethodBeat.m2505o(43542);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$39 */
    class C4612339 extends C4884c<C9489us> {
        C4612339() {
            AppMethodBeat.m2504i(43552);
            this.xxI = C9489us.class.getName().hashCode();
            AppMethodBeat.m2505o(43552);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43553);
            C9489us c9489us = (C9489us) c4883b;
            if (c9489us instanceof C9489us) {
                WalletOfflineCoinPurseUI.m89349a(WalletOfflineCoinPurseUI.this, c9489us.cRy.cRz);
            }
            AppMethodBeat.m2505o(43553);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOfflineCoinPurseUI() {
        AppMethodBeat.m2504i(43561);
        AppMethodBeat.m2505o(43561);
    }

    /* renamed from: C */
    static /* synthetic */ void m89329C(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43626);
        walletOfflineCoinPurseUI.m89327Az(0);
        AppMethodBeat.m2505o(43626);
    }

    /* renamed from: D */
    static /* synthetic */ void m89330D(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43627);
        walletOfflineCoinPurseUI.m89361jG(true);
        AppMethodBeat.m2505o(43627);
    }

    /* renamed from: E */
    static /* synthetic */ void m89331E(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43628);
        walletOfflineCoinPurseUI.bLz();
        AppMethodBeat.m2505o(43628);
    }

    /* renamed from: J */
    static /* synthetic */ void m89337J(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43630);
        walletOfflineCoinPurseUI.m89332E(true, true);
        AppMethodBeat.m2505o(43630);
    }

    /* renamed from: O */
    static /* synthetic */ void m89342O(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43631);
        walletOfflineCoinPurseUI.bXK();
        AppMethodBeat.m2505o(43631);
    }

    /* renamed from: d */
    static /* synthetic */ void m89353d(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43616);
        walletOfflineCoinPurseUI.bXQ();
        AppMethodBeat.m2505o(43616);
    }

    /* renamed from: e */
    static /* synthetic */ void m89355e(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43617);
        walletOfflineCoinPurseUI.bXR();
        AppMethodBeat.m2505o(43617);
    }

    /* renamed from: f */
    static /* synthetic */ void m89356f(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43618);
        walletOfflineCoinPurseUI.bXO();
        AppMethodBeat.m2505o(43618);
    }

    /* renamed from: m */
    static /* synthetic */ void m89364m(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43621);
        walletOfflineCoinPurseUI.bXz();
        AppMethodBeat.m2505o(43621);
    }

    /* renamed from: s */
    static /* synthetic */ void m89370s(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43623);
        walletOfflineCoinPurseUI.bXW();
        AppMethodBeat.m2505o(43623);
    }

    /* renamed from: v */
    static /* synthetic */ boolean m89373v(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43624);
        boolean bXF = walletOfflineCoinPurseUI.bXF();
        AppMethodBeat.m2505o(43624);
        return bXF;
    }

    /* renamed from: x */
    static /* synthetic */ void m89375x(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43625);
        walletOfflineCoinPurseUI.bXH();
        AppMethodBeat.m2505o(43625);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(43562);
        super.onCreate(bundle);
        C7007k.oXK = true;
        C36391e.m59978QS(41);
        Intent intent = getIntent();
        this.oZZ = intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.gwj = intent.getIntExtra("key_entry_scene", this.gwj);
        }
        this.emC = intent.getIntExtra("key_from_scene", 0);
        this.oZL = C5046bo.m7532bc(intent.getStringExtra("key_business_attach"), "");
        this.lTe = 1;
        if (this.gwj == 2) {
            this.lTe = 1;
        } else if (this.gwj == 1) {
            this.lTe = 2;
        } else if (this.gwj == 8) {
            this.lTe = 4;
        } else if (this.gwj == 4) {
            this.lTe = 6;
        } else {
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", Integer.valueOf(this.lTe));
        }
        getWindow().addFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38286a(this, null);
        mo9439AM(0);
        mo17446xE(getResources().getColor(C25738R.color.a4t));
        dyb();
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setBackBtn(new C2864834());
        try {
            C30292bc.m48192a(this, this);
            z = true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e, "", new Object[0]);
            getWindow().setFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            z = false;
        }
        if (z) {
            C30292bc.m48192a(this, null);
        }
        C36391e.dOK();
        if (!C46118q.isEnabled()) {
            mo39970a(new C35475y(null, 8), false, false);
        }
        if (C14241r.cPI().cQl()) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (C14241r.cPI().cQi()) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            C28630a.bYo();
            C7007k.bXg();
            C7007k.m11711aT(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else if (C14241r.cPI().cQg() && C28630a.bYd()) {
            WalletOfflineCoinPurseUI.bXX();
        }
        initView();
        C18764x.m29326a((C18765a) this);
        C7007k.bXg();
        C7007k.bXh().mo36866a(this);
        mo39992nf(606);
        mo39992nf(609);
        mo39992nf(1501);
        C7007k.bXg();
        C7007k.bXi().mo62416cl(this);
        C4879a.xxA.mo10052c(this.paq);
        C28630a.bYp();
        C4879a.xxA.mo10051b(this.pao);
        C4879a.xxA.mo10051b(this.pam);
        C4879a.xxA.mo10051b(this.paj);
        this.pak.dnU();
        this.pal.dnU();
        this.oZY = new C34645g();
        C45341lg c45341lg = new C45341lg();
        c45341lg.cHi.aBR = hashCode();
        C4879a.xxA.mo10055m(c45341lg);
        this.pan.dnU();
        AppMethodBeat.m2505o(43562);
    }

    private void bXy() {
        AppMethodBeat.m2504i(43563);
        bXQ();
        bXV();
        bXR();
        bXO();
        AppMethodBeat.m2505o(43563);
    }

    public void onResume() {
        boolean z;
        AppMethodBeat.m2504i(43564);
        super.onResume();
        C4879a.xxA.mo10052c(this.pap);
        try {
            C30292bc.m48192a(this, this);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e, "", new Object[0]);
        }
        if (!this.pai) {
            bXy();
            this.pai = true;
        }
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.kXv = true;
        C40167b c40167b = (C40167b) C1720g.m3528K(C40167b.class);
        c40167b.mo38287a(this, c40167b.cTi(), null);
        if (C5023at.isNetworkConnected(getBaseContext())) {
            if (C14241r.cPI().cQl()) {
                mo39970a(new C35475y(null, 8), true, false);
            }
            if (C28630a.bYd()) {
                C7007k.bXg();
                C7007k.bXj().mo62421jF(false);
                if (!C12763c.bXw()) {
                    if (C46118q.isEnabled()) {
                        mo39970a(new C46118q(C28630a.pbe), false, false);
                    } else {
                        bXL();
                    }
                }
            }
        }
        bXE();
        Bankcard bYf = C28630a.bYf();
        if (bYf == null || bYf.field_bindSerial == null || bYf.field_bindSerial.equals(this.oWS)) {
            z = false;
        } else {
            this.oWS = bYf.field_bindSerial;
            C7007k.bXg();
            C7007k.bXi().oWS = this.oWS;
            z = true;
        }
        if (z || (this.oZD && this.oZC)) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            this.oZD = false;
            this.oZC = false;
            bXM();
            m89327Az(0);
            m89361jG(true);
        }
        C34645g c34645g = this.oZY;
        if (C28630a.bYE()) {
            C4990ab.m7416i(C34645g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + c34645g.oXm.doT());
            if (c34645g.oXm == null || c34645g.oXm.doT()) {
                c34645g.status = 1;
                C7060h.pYm.mo8378a(135, 61, 1, true);
                long j;
                int i;
                if (c34645g.oXl) {
                    C34645g.bXc();
                    j = (long) C34645g.oWV;
                    c34645g.oXm.mo16770ae(j, j);
                    i = C34645g.oWV;
                    AppMethodBeat.m2505o(43564);
                    return;
                }
                j = (long) C34645g.oXj;
                c34645g.oXm.mo16770ae(j, j);
                i = C34645g.oXj;
                AppMethodBeat.m2505o(43564);
                return;
            }
        }
        C4990ab.m7416i(C34645g.TAG, "OfflineGetMsg is not in abtest");
        AppMethodBeat.m2505o(43564);
    }

    private void bXz() {
        AppMethodBeat.m2504i(43565);
        C36391e.m59978QS(32);
        C35899h.m58860ai(this, this.lTe);
        AppMethodBeat.m2505o(43565);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(43566);
        super.onNewIntent(intent);
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
        this.oZC = true;
        AppMethodBeat.m2505o(43566);
    }

    public void onPause() {
        AppMethodBeat.m2504i(43567);
        C7007k.bXg();
        C39473i bXj = C7007k.bXj();
        bXj.mHandler.removeCallbacks(bXj.oXy);
        C30292bc.m48192a(this, null);
        this.kXv = false;
        C4879a.xxA.mo10053d(this.pap);
        this.oZY.stop();
        super.onPause();
        AppMethodBeat.m2505o(43567);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43568);
        C7007k.oXK = false;
        C36391e.m59975K(this.oZz);
        C36391e.m59975K(this.oZA);
        C36391e.m59995ar(this.pad);
        C36391e.m59995ar(this.pae);
        this.pad.clear();
        this.pae.clear();
        this.oZE.clear();
        this.oZF.clear();
        this.oZG.clear();
        C18764x.m29330c((C18765a) this);
        C7007k.bXg();
        C7007k.bXh().mo36867b((C3562a) this);
        mo39993ng(606);
        mo39993ng(609);
        mo39993ng(1501);
        C7007k.bXg();
        C7007k.bXi().mo62417cm(this);
        C4879a.xxA.mo10053d(this.paq);
        C4879a.xxA.mo10053d(this.pao);
        C4879a.xxA.mo10053d(this.paj);
        if (!this.oXA.doT()) {
            this.oXA.stopTimer();
        }
        if (!this.pau.doT()) {
            this.pau.stopTimer();
        }
        if (this.paf != null) {
            this.paf.release();
        }
        if (this.pag != null) {
            C12763c c12763c = this.pag;
            c12763c.kgA.cancel();
            c12763c.mActivity = null;
        }
        C4879a.xxA.mo10053d(this.pam);
        this.pak.dead();
        this.pal.dead();
        C34645g c34645g = this.oZY;
        c34645g.stop();
        C34645g.bXc();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, c34645g.oXk);
        c34645g.oXm = null;
        this.pan.dead();
        super.onDestroy();
        AppMethodBeat.m2505o(43568);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43569);
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " scene: " + c1207m);
        if ((c1207m instanceof C46116f) && ((i == 0 && i2 == 0) || i != 0)) {
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.oXx.bXn();
            this.oXx = null;
        }
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C35475y) {
                if (C28630a.bYd()) {
                    if (C28630a.bYg() != null) {
                        bXL();
                    }
                    WalletOfflineCoinPurseUI.bXX();
                }
                bXV();
            } else if (c1207m instanceof C21403m) {
                this.oXx = (C21403m) c1207m;
                String str2 = this.oXx.oYz;
                C7007k.bXg();
                C1207m c46116f = new C46116f(str2, C7007k.m11709Ax(196617));
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c46116f, 0);
            } else if (c1207m instanceof C21401j) {
                bXE();
                bXy();
            } else if (c1207m instanceof C43353n) {
                C43353n c43353n = (C43353n) c1207m;
                if ("1".equals(c43353n.oYE)) {
                    C4990ab.m7420w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    C30379h.m48448a((Context) this, C5046bo.isNullOrNil(c43353n.oYF) ? getString(C25738R.string.fdx) : c43353n.oYF, "", false, new C394762());
                    AppMethodBeat.m2505o(43569);
                    return true;
                } else if (c43353n.oXZ == 0) {
                    C12763c c12763c = this.pag;
                    c12763c.oZp = (float) C28630a.bYk();
                    c12763c.oZp = c12763c.oZp;
                    if ("1".equals(c43353n.oYD)) {
                        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        mo39970a(new C21403m(((int) (System.currentTimeMillis() / 1000)), 8), false, false);
                    }
                } else if (c43353n.oXZ != 0) {
                    this.pag.mo24765a(c43353n, c43353n.oXZ, c43353n.oYa);
                }
            } else if (!(c1207m instanceof C28626a)) {
                if (c1207m instanceof C12736e) {
                    this.pag.mo24769c(i, i2, str, c1207m);
                } else if (c1207m instanceof C29625f) {
                    if (this.oZV != null && this.oZV.isShowing()) {
                        this.oZV.dismiss();
                    }
                    C29625f c29625f = (C29625f) c1207m;
                    if ("1".equals(c29625f.tvH) || ("2".equals(c29625f.tvH) && !C5046bo.isNullOrNil(c29625f.tvI))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                        bundle.putString("realname_verify_process_jump_plugin", "offline");
                        C43795a.m78493a(this, bundle, null, 1006);
                    } else if ("collect".equals(c29625f.tvL)) {
                        bXz();
                    } else if ("reward".equals(c29625f.tvL)) {
                        C25985d.m41448H(this.mController.ylL, "collect", ".reward.ui.QrRewardMainUI");
                    } else {
                        C4990ab.m7421w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", c29625f.tvL);
                    }
                    AppMethodBeat.m2505o(43569);
                    return true;
                } else if (c1207m instanceof C46118q) {
                    C46118q c46118q = (C46118q) c1207m;
                    if (c46118q.bLD() && !this.pac && c46118q.nYe.mo39946a((Activity) this, new C286513())) {
                        this.pac = true;
                    }
                    mo7885c(c46118q.oYK.errType, c46118q.oYK.errCode, c46118q.oYK.aIm, c46118q.oYI);
                    mo7885c(c46118q.oYJ.errType, c46118q.oYJ.errCode, c46118q.oYJ.aIm, c46118q.oYH);
                }
            }
            if ((c1207m instanceof C35475y) || (c1207m instanceof C43353n) || (c1207m instanceof C28626a) || (c1207m instanceof C12736e)) {
                bXE();
                m89332E(false, true);
            } else if (c1207m instanceof C46116f) {
                bXE();
                m89332E(true, true);
            }
        } else if (c1207m instanceof C43353n) {
            bXE();
            m89332E(false, true);
            if (411 == i2) {
                this.pag.mo24765a(c1207m, i2, str);
            }
        } else if (c1207m instanceof C12736e) {
            this.pag.mo24769c(i, i2, str, c1207m);
        } else if (!(c1207m instanceof C21401j)) {
            if (c1207m instanceof C46116f) {
                this.oXx = null;
            } else if (c1207m instanceof C29625f) {
                if (this.oZV != null && this.oZV.isShowing()) {
                    this.oZV.dismiss();
                }
            } else if (c1207m instanceof C46118q) {
                bXE();
                m89332E(false, true);
                if (411 == i2) {
                    this.pag.mo24765a(c1207m, i2, str);
                }
            }
        }
        AppMethodBeat.m2505o(43569);
        return true;
    }

    public final int getLayoutId() {
        return 2130971130;
    }

    public final void initView() {
        AppMethodBeat.m2504i(43570);
        this.pah = (OfflineAlertView) findViewById(2131828891);
        this.pah.dismiss();
        this.pah.setDialogState(new C127524());
        C40928b.dNJ();
        C40928b.init(getApplicationContext());
        if (this.gwj == 3 || this.gwj == 10 || this.gwj == 11 || this.gwj == 12) {
            setMMTitle((int) C25738R.string.fvk);
        } else {
            setMMTitle((int) C25738R.string.fvl);
        }
        this.pag = new C12763c(this, this);
        this.pag.init();
        this.paf = new C46724c(this, true);
        this.paf.ase();
        bXC();
        bXB();
        if (C28630a.bYd() && C12763c.bXw()) {
            C12763c c12763c = this.pag;
            C7007k.bXg();
            c12763c.mo24767a(C7007k.bXh().oYL);
        }
        bXA();
        long j = (long) this.oXz;
        this.oXA.mo16770ae(j, j);
        bXY();
        bXD();
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "5";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43508);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
                    AppMethodBeat.m2505o(43508);
                    return;
                }
                C36391e.m59985a((TextView) WalletOfflineCoinPurseUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(43508);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(43570);
    }

    private void bXA() {
        AppMethodBeat.m2504i(43571);
        bXE();
        m89332E(true, false);
        AppMethodBeat.m2505o(43571);
    }

    /* renamed from: a */
    private void m89347a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.m2504i(43572);
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
            AppMethodBeat.m2505o(43572);
            return;
        }
        final boolean z6 = z;
        final boolean z7 = z4;
        final boolean z8 = z2;
        final boolean z9 = z3;
        final boolean z10 = z5;
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43509);
                ScrollView scrollView = (ScrollView) WalletOfflineCoinPurseUI.this.findViewById(2131828904);
                if (scrollView == null) {
                    AppMethodBeat.m2505o(43509);
                    return;
                }
                int bottom;
                int[] iArr = new int[2];
                scrollView.getLocationInWindow(iArr);
                int i = C5222ae.m7953hy(WalletOfflineCoinPurseUI.this.mController.ylL).y;
                if (C5222ae.m7951hw(WalletOfflineCoinPurseUI.this.mController.ylL)) {
                    C4990ab.m7410d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                    i -= C5222ae.m7944fr(WalletOfflineCoinPurseUI.this.mController.ylL);
                }
                if (z6) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZQ.getBottom();
                } else {
                    bottom = 0;
                }
                if (z7) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZT.getBottom();
                }
                if (z8) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZR.getBottom();
                }
                if (z9) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZS.getBottom();
                }
                if (z10) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZU.getBottom();
                }
                C4990ab.m7411d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", Integer.valueOf(bottom), Integer.valueOf(i));
                i = bottom - i;
                if (i > 0) {
                    scrollView.scrollBy(0, i);
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.TRUE);
                AppMethodBeat.m2505o(43509);
            }
        });
        AppMethodBeat.m2505o(43572);
    }

    private void bXB() {
        AppMethodBeat.m2504i(43573);
        this.oZQ = (LinearLayout) findViewById(2131828892);
        this.oZR = (LinearLayout) findViewById(2131828898);
        this.oZS = (LinearLayout) findViewById(2131828900);
        this.oZT = (LinearLayout) findViewById(2131828896);
        this.oZU = (LinearLayout) findViewById(2131828902);
        if (this.gwj == 3 || this.gwj == 10 || this.gwj == 11 || this.gwj == 12) {
            this.oZQ.setVisibility(8);
            this.oZR.setVisibility(8);
            this.oZS.setVisibility(8);
            this.oZT.setVisibility(8);
            AppMethodBeat.m2505o(43573);
            return;
        }
        this.oZT.setVisibility(0);
        this.oZU.setVisibility(0);
        boolean b = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b2 = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b3 = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b4 = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b5 = C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        final ImageView imageView = (ImageView) this.oZR.findViewById(2131828899);
        final ImageView imageView2 = (ImageView) this.oZQ.findViewById(2131828893);
        final ImageView imageView3 = (ImageView) this.oZS.findViewById(2131828901);
        final ImageView imageView4 = (ImageView) this.oZT.findViewById(2131828897);
        final TextView textView = (TextView) this.oZQ.findViewById(2131828894);
        final ImageView imageView5 = (ImageView) this.oZQ.findViewById(2131828895);
        final ImageView imageView6 = (ImageView) this.oZU.findViewById(2131828903);
        if (b) {
            imageView.setVisibility(0);
        }
        if (b2) {
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, (Object) "");
            if (C5046bo.isNullOrNil(str)) {
                imageView2.setVisibility(0);
            } else {
                textView.setText(str);
                textView.setVisibility(0);
                imageView5.setVisibility(0);
            }
        }
        if (b3) {
            imageView3.setVisibility(0);
        }
        if (b4) {
            imageView4.setVisibility(0);
        }
        if (b5) {
            imageView6.setVisibility(0);
        }
        m89347a(b2, b, b3, b4, b5);
        this.oZQ.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$7$1 */
            class C127551 implements C43798a {
                C127551() {
                }

                /* renamed from: c */
                public final boolean mo24759c(int i, int i2, String str, boolean z) {
                    AppMethodBeat.m2504i(43510);
                    C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                    if (i == 2) {
                        WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("collect"), false, false);
                    } else if (i == 0 && z) {
                        WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("collect"), false, false);
                    } else if (WalletOfflineCoinPurseUI.this.oZV != null) {
                        WalletOfflineCoinPurseUI.this.oZV.dismiss();
                    }
                    AppMethodBeat.m2505o(43510);
                    return true;
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(43511);
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView2.setVisibility(8);
                    textView.setVisibility(8);
                    imageView5.setVisibility(8);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, (Object) "");
                    C7060h.pYm.mo8381e(14396, Integer.valueOf(3));
                }
                if (C14241r.cPI().cQg()) {
                    WalletOfflineCoinPurseUI.m89364m(WalletOfflineCoinPurseUI.this);
                    AppMethodBeat.m2505o(43511);
                    return;
                }
                C14241r.cPD();
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                C30868i n = WalletOfflineCoinPurseUI.this.Ahr;
                C127551 c127551 = new C127551();
                if (!C14241r.m22437b(walletOfflineCoinPurseUI, n)) {
                    WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("collect"), true, false);
                }
                AppMethodBeat.m2505o(43511);
            }
        });
        this.oZR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(43512);
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
                C7060h.pYm.mo8381e(14021, Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                Intent intent = new Intent();
                if (WalletOfflineCoinPurseUI.this.emC == 1) {
                    intent.putExtra("enter_scene", 2);
                } else if (WalletOfflineCoinPurseUI.this.emC == 2) {
                    intent.putExtra("enter_scene", 4);
                } else {
                    C4990ab.m7421w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", Integer.valueOf(WalletOfflineCoinPurseUI.this.emC));
                }
                C25985d.m41467b(WalletOfflineCoinPurseUI.this.mController.ylL, "aa", ".ui.AAEntranceUI", intent);
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView.setVisibility(8);
                    C7060h.pYm.mo8381e(14396, Integer.valueOf(4));
                }
                AppMethodBeat.m2505o(43512);
            }
        });
        this.oZS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(43513);
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
                C7060h.pYm.mo8381e(14021, Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                C25985d.m41448H(WalletOfflineCoinPurseUI.this.mController.ylL, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView3.setVisibility(8);
                    C7060h.pYm.mo8381e(14396, Integer.valueOf(5));
                }
                AppMethodBeat.m2505o(43513);
            }
        });
        this.oZT.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$10$1 */
            class C286441 implements C43798a {
                C286441() {
                }

                /* renamed from: c */
                public final boolean mo24759c(int i, int i2, String str, boolean z) {
                    AppMethodBeat.m2504i(43514);
                    C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                    if (i == 2) {
                        WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("reward"), false, false);
                    } else if (i == 0 && z) {
                        WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("reward"), false, false);
                    } else if (WalletOfflineCoinPurseUI.this.oZV != null) {
                        WalletOfflineCoinPurseUI.this.oZV.dismiss();
                    }
                    AppMethodBeat.m2505o(43514);
                    return true;
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(43515);
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
                C7060h.pYm.mo8381e(14021, Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView4.setVisibility(8);
                }
                if (C14241r.cPI().cQg()) {
                    C25985d.m41448H(WalletOfflineCoinPurseUI.this.mController.ylL, "collect", ".reward.ui.QrRewardMainUI");
                    AppMethodBeat.m2505o(43515);
                    return;
                }
                C14241r.cPD();
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                C30868i q = WalletOfflineCoinPurseUI.this.Ahr;
                C286441 c286441 = new C286441();
                if (!C14241r.m22437b(walletOfflineCoinPurseUI, q)) {
                    WalletOfflineCoinPurseUI.this.mo39970a(new C29625f("reward"), true, false);
                }
                AppMethodBeat.m2505o(43515);
            }
        });
        this.oZU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(43516);
                C25985d.m41448H(WalletOfflineCoinPurseUI.this.mController.ylL, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView6.setVisibility(8);
                }
                AppMethodBeat.m2505o(43516);
            }
        });
        AppMethodBeat.m2505o(43573);
    }

    private void bXC() {
        AppMethodBeat.m2504i(43574);
        this.oZH = findViewById(2131828883);
        this.oZI = (ImageView) findViewById(2131828886);
        this.oZJ = (ImageView) findViewById(2131828885);
        this.oZK = (TextView) findViewById(2131828884);
        this.oZM = findViewById(2131828887);
        this.oZN = (TextView) findViewById(2131828889);
        this.oZO = (ImageView) findViewById(2131828888);
        this.oZP = (RelativeLayout) findViewById(2131828882);
        this.oZP.setOnClickListener(new C4335613());
        this.oZI.setOnClickListener(this.gKK);
        this.oZJ.setOnClickListener(this.gKK);
        this.oZK.setOnClickListener(this.gKK);
        this.oZM.setClickable(true);
        this.oZM.setOnClickListener(new C4335714());
        this.mLastTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(43574);
    }

    private void bcQ() {
        AppMethodBeat.m2504i(43575);
        if (C28630a.bYd()) {
            this.oZP.setVisibility(0);
            AppMethodBeat.m2505o(43575);
            return;
        }
        this.oZP.setVisibility(4);
        AppMethodBeat.m2505o(43575);
    }

    /* renamed from: E */
    private void m89332E(boolean z, boolean z2) {
        AppMethodBeat.m2504i(43576);
        if (C28630a.m45524jH(true).size() > 0) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            bXN();
            bXM();
            this.oZM.setVisibility(0);
        } else {
            this.oZM.setVisibility(0);
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        if (z) {
            m89327Az(0);
        }
        m89361jG(z2);
        bcQ();
        bXD();
        AppMethodBeat.m2505o(43576);
    }

    private void bXD() {
        AppMethodBeat.m2504i(43577);
        if (!(this.par || C5023at.isNetworkConnected(getBaseContext()))) {
            C7007k.bXg();
            C7007k.bXi();
            if (C12741e.bWZ() == 0) {
                this.par = true;
                C12759b.m20771T(this);
                C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
        AppMethodBeat.m2505o(43577);
    }

    private void bXE() {
        AppMethodBeat.m2504i(43578);
        int bYi = C28630a.bYi();
        Bankcard bYg = C28630a.bYg();
        if (C12763c.bXw()) {
            this.mState = 7;
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
            AppMethodBeat.m2505o(43578);
        } else if (!C5023at.isNetworkConnected(getBaseContext())) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
            AppMethodBeat.m2505o(43578);
        } else if (C28630a.bYd()) {
            if (bYi == 0) {
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
                AppMethodBeat.m2505o(43578);
            } else if (bYi == 0 || bYg != null) {
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
                AppMethodBeat.m2505o(43578);
            } else {
                C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
                AppMethodBeat.m2505o(43578);
            }
        } else if (bYi == 0) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
            AppMethodBeat.m2505o(43578);
        } else if (bYi == 0 || bYg != null) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
            AppMethodBeat.m2505o(43578);
        } else {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
            AppMethodBeat.m2505o(43578);
        }
    }

    public final boolean bNf() {
        return false;
    }

    /* renamed from: jG */
    private void m89361jG(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(43579);
        long currentTimeMillis = System.currentTimeMillis();
        if (z && (C5046bo.isNullOrNil(this.oZW) || C5046bo.isNullOrNil(this.oXv))) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
            bXS();
        } else {
            bXU();
        }
        bLh();
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bXG();
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        bds();
        bXH();
        C36381z.m59954hL(10, 0);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(C28630a.m45520eA(C4996ah.getContext()) ? 0 : 1);
        if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        C7007k.bXg();
        C7007k.bXi();
        objArr[3] = Integer.valueOf(C12741e.bWZ());
        c7060h.mo8381e(14163, objArr);
        C7060h.pYm.mo8378a(135, 67, 1, true);
        if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            C7060h.pYm.mo8378a(135, 32, 1, true);
        } else {
            C7060h.pYm.mo8378a(135, 33, 1, true);
        }
        if (C28630a.m45520eA(this)) {
            C7060h.pYm.mo8378a(135, 34, 1, true);
            AppMethodBeat.m2505o(43579);
            return;
        }
        C7060h.pYm.mo8378a(135, 35, 1, true);
        AppMethodBeat.m2505o(43579);
    }

    private boolean bXF() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void bLh() {
        AppMethodBeat.m2504i(43580);
        Bitmap bitmap = this.oZz;
        this.oZz = bXJ();
        this.oZI.setImageBitmap(this.oZz);
        if (bXF()) {
            this.oZI.setAlpha(10);
        } else {
            this.oZI.setAlpha(255);
        }
        this.pad.add(0, bitmap);
        AppMethodBeat.m2505o(43580);
    }

    private void bXG() {
        AppMethodBeat.m2504i(43581);
        Bitmap bitmap = this.oZA;
        this.oZA = bXI();
        this.oZJ.setImageBitmap(this.oZA);
        if (bXF()) {
            this.oZJ.setAlpha(10);
        } else {
            this.oZJ.setAlpha(255);
        }
        this.pae.add(0, bitmap);
        AppMethodBeat.m2505o(43581);
    }

    private void bXH() {
        AppMethodBeat.m2504i(43582);
        if (this.paf != null) {
            this.paf.mo75141iw(this.oZW, this.oXv);
            this.paf.oZz = this.oZz;
            this.paf.oZA = this.oZA;
            this.paf.dOv();
        }
        AppMethodBeat.m2505o(43582);
    }

    private void bds() {
        int size;
        AppMethodBeat.m2504i(43583);
        if (this.pad.size() >= 2) {
            for (size = this.pad.size() - 1; size > 1; size--) {
                C36391e.m59975K((Bitmap) this.pad.remove(size));
            }
        }
        if (this.pae.size() >= 2) {
            for (size = this.pae.size() - 1; size > 1; size--) {
                C36391e.m59975K((Bitmap) this.pae.remove(size));
            }
        }
        AppMethodBeat.m2505o(43583);
    }

    private Bitmap bXI() {
        AppMethodBeat.m2504i(43584);
        if (TextUtils.isEmpty(this.oXv)) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
            AppMethodBeat.m2505o(43584);
            return null;
        }
        Bitmap b = C37623a.m63542b(this, this.oXv, 5, 0);
        AppMethodBeat.m2505o(43584);
        return b;
    }

    private Bitmap bXJ() {
        AppMethodBeat.m2504i(43585);
        if (TextUtils.isEmpty(this.oZW)) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            AppMethodBeat.m2505o(43585);
            return null;
        }
        Bitmap b = C37623a.m63542b(this, this.oZW, 12, 3);
        AppMethodBeat.m2505o(43585);
        return b;
    }

    /* renamed from: Az */
    private void m89327Az(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(43586);
        if (C28630a.bYd()) {
            C7007k.bXg();
            String q = C7007k.bXi().mo24747q(this.gwj, i, this.oZL);
            this.oXv = q;
            this.oZW = q;
            C4990ab.m7419v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", Integer.valueOf(i), this.oXv, this.oZW, C5046bo.dpG().toString());
            bhw();
            if (C5046bo.isNullOrNil(q)) {
                int i3;
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(1);
                if (C28630a.m45520eA(C4996ah.getContext())) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                objArr[1] = Integer.valueOf(i3);
                if (C5023at.isNetworkConnected(getBaseContext())) {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                c7060h.mo8381e(14163, objArr);
                C7060h.pYm.mo8378a(135, 26, 1, true);
                if (C5023at.isNetworkConnected(getBaseContext())) {
                    C7060h.pYm.mo8378a(135, 28, 1, true);
                    AppMethodBeat.m2505o(43586);
                    return;
                }
                C7060h.pYm.mo8378a(135, 27, 1, true);
            }
            AppMethodBeat.m2505o(43586);
            return;
        }
        C4990ab.m7420w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
        AppMethodBeat.m2505o(43586);
    }

    /* renamed from: a */
    public final boolean mo8122a(C3563c c3563c) {
        AppMethodBeat.m2504i(43587);
        if (c3563c == null) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            AppMethodBeat.m2505o(43587);
            return false;
        }
        boolean z;
        bXK();
        this.paf.dismiss();
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + c3563c.oYS);
        if (4 == c3563c.oYS) {
            this.oZX = false;
            z = false;
        } else {
            if (5 == c3563c.oYS) {
                this.oZX = true;
                this.paa = true;
                this.pab = false;
                if (!this.pat.doT()) {
                    this.pat.stopTimer();
                    z = false;
                }
            } else {
                if (6 == c3563c.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                    }
                    if (!this.oXA.doT()) {
                        this.oXA.stopTimer();
                    }
                    this.oZX = false;
                    if (C28630a.bYe()) {
                        z = false;
                    }
                } else if (8 == c3563c.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = true;
                    }
                } else if (23 == c3563c.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = false;
                    }
                } else if (20 == c3563c.oYS) {
                    this.oZX = false;
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = false;
                    }
                } else if (24 == c3563c.oYS) {
                    if (C28630a.bYE()) {
                        this.oZX = true;
                        if (C28630a.bYE()) {
                            if (this.oZV == null) {
                                this.oZV = C30901g.m49317a(this.mController.ylL, false, new C1274818());
                            } else if (!this.oZV.isShowing()) {
                                this.oZV.show();
                            }
                        }
                        long bXb = (long) C34645g.bXb();
                        this.pat.mo16770ae(bXb, bXb);
                    }
                }
                z = true;
            }
            z = false;
        }
        C12763c c12763c = this.pag;
        if (c3563c == null) {
            C4990ab.m7412e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + c3563c.oYS);
            if (c3563c.oYS == 24) {
                c12763c.kgA.vibrate(50);
            }
            if (4 == c3563c.oYS) {
                c12763c.mo24767a((C7004b) c3563c);
                C34645g.bXc();
            } else if (5 == c3563c.oYS) {
                C21409e c21409e = (C21409e) c3563c;
                if (c21409e != null) {
                    C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + c21409e.oYV + " msg.wxRetMsg:" + c21409e.oYW + " msg.cftRetCode:" + c21409e.oYV + " msg.cftRetMsg:" + c21409e.oYU);
                    if (!(TextUtils.isEmpty(c21409e.oYV) && TextUtils.isEmpty(c21409e.oYW) && TextUtils.isEmpty(c21409e.oYT) && TextUtils.isEmpty(c21409e.oYU))) {
                        if (TextUtils.isEmpty(c21409e.oYV) && TextUtils.isEmpty(c21409e.oYW) && !TextUtils.isEmpty(c21409e.oYT) && !TextUtils.isEmpty(c21409e.oYU)) {
                            C12759b.m20772b(c12763c.mActivity, c21409e.oYU);
                        } else if (TextUtils.isEmpty(c21409e.oYV) || !C28630a.isNumeric(c21409e.oYV)) {
                            C12759b.m20772b(c12763c.mActivity, c21409e.oYW);
                        } else {
                            c12763c.mo24766a(null, Integer.valueOf(c21409e.oYV).intValue(), c21409e.oYW, c21409e.oYX);
                        }
                    }
                }
                C34645g.bXc();
                C7060h.pYm.mo8378a(135, 0, 1, true);
            } else if (6 == c3563c.oYS) {
                C21411f c21411f = (C21411f) c3563c;
                if (c21411f != null) {
                    C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + c21411f.oYZ);
                    C7007k.bXg();
                    C21404r TY = C7007k.bXk().mo55234TY(c21411f.oZa.czZ);
                    boolean z2 = TY != null ? TY.field_status == C34645g.oXg : false;
                    if (!z2) {
                        C34645g.m56847cM(c21411f.oZa.czZ, C34645g.oXg);
                        C28630a.m45512a(c12763c.mActivity, c21411f);
                        c12763c.mActivity.setResult(-1);
                        c12763c.mActivity.finish();
                    }
                }
                C34645g.bXc();
                C7060h.pYm.mo8378a(135, 7, 1, true);
                if (C28630a.pbe == 4) {
                    C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    C7060h.pYm.mo8381e(13412, new Object[0]);
                }
            } else if (8 == c3563c.oYS) {
                C21410g c21410g = (C21410g) c3563c;
                C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + c21410g.f4389id);
                if (c21410g.kKC == 0) {
                    View inflate = c12763c.mActivity.getLayoutInflater().inflate(2130971135, null);
                    TextView textView = (TextView) inflate.findViewById(2131828917);
                    ((TextView) inflate.findViewById(2131828916)).setText(c21410g.oZc);
                    textView.setText(c21410g.oZb);
                    C34645g.m56847cM(c21410g.cBT, C34645g.oXi);
                    C30379h.m48437a(c12763c.mActivity, "", inflate, c12763c.getString(C25738R.string.fvx), c12763c.getString(C25738R.string.f9076or), new C1276411(c21410g), new C1276812(c21410g));
                } else if (c21410g.kKC == 1) {
                    if (c12763c.oZo != null) {
                        c12763c.oZo.show();
                    }
                    C7060h.pYm.mo8381e(13955, Integer.valueOf(1));
                    C4990ab.m7416i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + c21410g.f4389id);
                    C34645g.m56847cM(c21410g.cBT, C34645g.oXi);
                    c12763c.oZo = C40131q.m68802a(c12763c.mActivity, c21410g.oZb, c21410g.oZc, new C1276513(c21410g), new C1276614(), new C1276915(c21410g));
                    c12763c.oZo.qcc.setVisibility(0);
                    c12763c.oZo.pUA.setVisibility(8);
                }
            } else if (23 == c3563c.oYS) {
                C21407d c21407d = (C21407d) c3563c;
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = c21407d.cBT;
                payInfo.cIf = 8;
                payInfo.vwn = 1;
                payInfo.vwh = new Bundle();
                payInfo.vwh.putLong("extinfo_key_9", System.currentTimeMillis());
                C4879a.xxA.mo10051b(new C127671(payInfo));
                C35899h.m58858a(c12763c.mActivity, false, "", c12763c.oZn == null ? "" : c12763c.oZn.bXt(), payInfo, "", new Intent(), 1);
            } else if (20 == c3563c.oYS) {
                C34645g.bXc();
            }
        }
        if (this.paa && !this.pab) {
            this.paa = false;
            this.oZX = false;
        }
        if (z) {
            m89327Az(0);
            m89361jG(true);
        }
        AppMethodBeat.m2505o(43587);
        return true;
    }

    public final void addDialog(Dialog dialog) {
        AppMethodBeat.m2504i(43588);
        if ((dialog instanceof C5653c) && this.paa) {
            this.pab = true;
            final OnDismissListener onDismissListener = ((C5653c) dialog).zPV;
            dialog.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(43523);
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(dialogInterface);
                    }
                    if (WalletOfflineCoinPurseUI.this.paa) {
                        WalletOfflineCoinPurseUI.this.oZX = false;
                        WalletOfflineCoinPurseUI.this.paa = false;
                        WalletOfflineCoinPurseUI.m89329C(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.m89330D(WalletOfflineCoinPurseUI.this);
                    }
                    AppMethodBeat.m2505o(43523);
                }
            });
        }
        super.addDialog(dialog);
        AppMethodBeat.m2505o(43588);
    }

    private void bXK() {
        AppMethodBeat.m2504i(43589);
        if (this.oZV != null && this.oZV.isShowing()) {
            this.oZV.dismiss();
        }
        AppMethodBeat.m2505o(43589);
    }

    private void bXL() {
        AppMethodBeat.m2504i(43590);
        mo39970a(new C43353n(System.currentTimeMillis(), C28630a.pbe), false, false);
        AppMethodBeat.m2505o(43590);
    }

    /* renamed from: e */
    private void m89354e(ImageView imageView, String str, int i) {
        AppMethodBeat.m2504i(43591);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43591);
            return;
        }
        Bitmap a = C18764x.m29325a(new C4467c(str));
        if (a != null) {
            imageView.setImageBitmap(C5056d.m7615a(a, i, i, true, false));
        }
        this.oZx.put(str, imageView);
        this.oZy.put(str, Integer.valueOf(i));
        AppMethodBeat.m2505o(43591);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(43592);
        if (TextUtils.isEmpty(str) || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(43592);
            return;
        }
        final ImageView imageView = (ImageView) this.oZx.get(str);
        final Integer num = (Integer) this.oZy.get(str);
        if (imageView == null || num == null) {
            AppMethodBeat.m2505o(43592);
            return;
        }
        new C7306ak(getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43525);
                int intValue = num.intValue();
                imageView.setImageBitmap(C5056d.m7615a(bitmap, intValue, intValue, true, false));
                AppMethodBeat.m2505o(43525);
            }
        });
        AppMethodBeat.m2505o(43592);
    }

    public final void aNW() {
        AppMethodBeat.m2504i(43593);
        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        m89327Az(1);
        m89361jG(true);
        C36391e.m59978QS(40);
        C7060h.pYm.mo8378a(135, 21, 1, true);
        if (this.paf.gKG.isShowing()) {
            if (this.paf.kjx) {
                this.paf.dOw();
                AppMethodBeat.m2505o(43593);
                return;
            }
            this.paf.dismiss();
        }
        bXP();
        AppMethodBeat.m2505o(43593);
    }

    public final void bXM() {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(43594);
        Bankcard bYf = C28630a.bYf();
        findViewById(2131828890).setVisibility(0);
        this.oZN.setTextSize(0, (float) getResources().getDimensionPixelSize(C25738R.dimen.f9980m5));
        if (this.oZN != null && bYf != null) {
            CharSequence charSequence;
            String string = getString(C25738R.string.fv7, new Object[]{bYf.field_desc});
            List<C22591c> cQC = C14241r.cPI().cQC();
            if (!(cQC == null || C5046bo.isNullOrNil(bYf.field_forbidWord))) {
                for (C22591c c22591c : cQC) {
                    if (c22591c.pbo.equals(bYf.field_bindSerial)) {
                        break;
                    }
                }
            }
            C22591c c22591c2 = null;
            if (c22591c2 == null || C5046bo.isNullOrNil(c22591c2.twE)) {
                Object charSequence2 = string;
                i = 0;
            } else {
                charSequence2 = bYf.field_desc + c22591c2.twE;
                findViewById(2131828890).setVisibility(8);
                C7060h.pYm.mo8381e(14515, Integer.valueOf(2));
                this.oZN.setTextSize(0, (float) getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            }
            this.oZN.setText(C44089j.m79293b(this.mController.ylL, charSequence2, this.oZN.getTextSize()));
            i2 = i;
        } else if (bYf == null) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
        }
        if (bYf != null) {
            m89346a(bYf);
        }
        if (i2 != 0) {
            this.oZO.setImageResource(C1318a.error_offline_info);
        }
        AppMethodBeat.m2505o(43594);
    }

    private void bXN() {
        AppMethodBeat.m2504i(43595);
        Bankcard bYf = C28630a.bYf();
        if (bYf != null) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
            C28630a.m45497Ue(bYf.field_bindSerial);
            this.oWS = bYf.field_bindSerial;
            C7007k.bXg();
            C7007k.bXi().oWS = this.oWS;
            AppMethodBeat.m2505o(43595);
            return;
        }
        C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
        AppMethodBeat.m2505o(43595);
    }

    private void bXO() {
        AppMethodBeat.m2504i(43596);
        if (this.oZZ) {
            AppMethodBeat.m2505o(43596);
        } else if (this.pah.mo55246Ay(4)) {
            C1720g.m3537RQ();
            if (!(((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() || this.pah.isShowing())) {
                bXP();
            }
            AppMethodBeat.m2505o(43596);
        } else {
            AppMethodBeat.m2505o(43596);
        }
    }

    private void bXP() {
        AppMethodBeat.m2504i(43597);
        if (this.pah.mo55246Ay(4)) {
            this.pah.mo55252dq(this.oZH);
            AppMethodBeat.m2505o(43597);
            return;
        }
        AppMethodBeat.m2505o(43597);
    }

    private void bXQ() {
        AppMethodBeat.m2504i(43598);
        if (this.pah.mo55246Ay(1)) {
            if (this.pah.oZe == 1) {
                this.pah.dismiss();
            }
            boolean cQi = C14241r.cPI().cQi();
            boolean cQh = C14241r.cPI().cQh();
            if (cQi || cQh) {
                C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", Boolean.valueOf(cQi), Boolean.valueOf(cQh));
                this.pah.mo55248a(this.oZH, new C2864724(), 1);
            }
            AppMethodBeat.m2505o(43598);
            return;
        }
        AppMethodBeat.m2505o(43598);
    }

    private void bXR() {
        AppMethodBeat.m2504i(43599);
        if (this.pah.mo55246Ay(3)) {
            if (this.pah.oZe == 3) {
                this.pah.dismiss();
            }
            C7007k.bXg();
            String Ax = C7007k.m11709Ax(196617);
            C40928b.dNJ();
            boolean isCertExist = C40928b.isCertExist(Ax);
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", Boolean.valueOf(isCertExist), Boolean.valueOf(C28630a.bYd()));
            if (!(isCertExist && r2)) {
                if (!isCertExist) {
                    C1720g.m3537RQ();
                    String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, (Object) "");
                    if (str == null || !str.equals(C1427q.m3026LK())) {
                        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                    }
                    C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + Ax + " ,recreate offline");
                    C28630a.bYo();
                }
                this.pah.mo55248a(this.oZH, new C4335825(), 3);
            }
            AppMethodBeat.m2505o(43599);
            return;
        }
        AppMethodBeat.m2505o(43599);
    }

    private void bXS() {
        AppMethodBeat.m2504i(43600);
        if (this.pah.mo55246Ay(5)) {
            if (this.pah.oZe == 5) {
                this.pah.dismiss();
            }
            this.pah.mo55250b(this.oZH, new C4335926());
            C7060h.pYm.mo8378a(135, 73, 1, true);
            AppMethodBeat.m2505o(43600);
            return;
        }
        AppMethodBeat.m2505o(43600);
    }

    public final void bXT() {
        AppMethodBeat.m2504i(43601);
        this.oZP.setVisibility(4);
        this.pah.mo55247a(this.oZH, new C4336027());
        AppMethodBeat.m2505o(43601);
    }

    private void bXU() {
        AppMethodBeat.m2504i(43602);
        if (this.pah.isShowing() && this.pah.oZe == 5) {
            this.pah.dismiss();
        }
        AppMethodBeat.m2505o(43602);
    }

    private boolean bXV() {
        AppMethodBeat.m2504i(43603);
        if (this.pah.mo55246Ay(2)) {
            if (this.pah.oZe == 2) {
                this.pah.dismiss();
            }
            List bYj = C28630a.bYj();
            if (bYj.size() <= 0) {
                C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                AppMethodBeat.m2505o(43603);
                return false;
            }
            for (int i = 0; i < bYj.size(); i++) {
                Bankcard bankcard = (Bankcard) bYj.get(i);
                if (bankcard != null && bankcard.field_support_micropay && C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                    AppMethodBeat.m2505o(43603);
                    return true;
                }
            }
            this.pah.dismiss();
            this.pah.mo55249a(this.oZH, new C4336128(), new C2141729());
            AppMethodBeat.m2505o(43603);
            return false;
        }
        AppMethodBeat.m2505o(43603);
        return false;
    }

    private void bXW() {
        AppMethodBeat.m2504i(43604);
        if (!C28630a.bYd()) {
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", Boolean.valueOf(C28630a.bYd()));
            AppMethodBeat.m2505o(43604);
        } else if (C28630a.m45524jH(false).size() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            this.oZN.setVisibility(8);
            AppMethodBeat.m2505o(43604);
        } else {
            final ArrayList ne = C22584ac.m34277ne(true);
            final C36356d c36356d = new C36356d(this, 2, true);
            int i = 0;
            for (int i2 = 0; i2 < ne.size(); i2++) {
                Bankcard bankcard = (Bankcard) ne.get(i2);
                if (!C5046bo.isNullOrNil(bankcard.field_bindSerial) && this.oWS.equals(bankcard.field_bindSerial)) {
                    i = i2;
                }
            }
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(final C44273l c44273l) {
                    AppMethodBeat.m2504i(43540);
                    for (int i = 0; i < ne.size(); i++) {
                        CharSequence charSequence;
                        CharSequence spannableString;
                        String str;
                        Drawable f;
                        Drawable drawable;
                        boolean z;
                        final Bankcard bankcard = (Bankcard) ne.get(i);
                        String Uk = C28630a.m45503Uk(bankcard.field_bankcardType);
                        if (bankcard.cPd() && bankcard.txc != null) {
                            Uk = bankcard.txc.oRi;
                        }
                        Bitmap a = C18764x.m29325a(new C4467c(Uk));
                        C18764x.m29326a(new C18765a() {
                            /* renamed from: m */
                            public final void mo8136m(final String str, final Bitmap bitmap) {
                                AppMethodBeat.m2504i(43538);
                                C5004al.m7441d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(43537);
                                        C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, Uk);
                                        if (WalletOfflineCoinPurseUI.this.pas.containsKey(str)) {
                                            int intValue = ((Integer) WalletOfflineCoinPurseUI.this.pas.get(str)).intValue();
                                            if (c44273l.getItem(intValue) != null) {
                                                c44273l.getItem(intValue).setIcon(new BitmapDrawable(C5056d.m7615a(bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false)));
                                                c36356d.dKX();
                                            }
                                        }
                                        AppMethodBeat.m2505o(43537);
                                    }
                                });
                                AppMethodBeat.m2505o(43538);
                            }
                        });
                        String str2 = "";
                        if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                            str2 = bankcard.field_forbidWord;
                        }
                        if (!C5046bo.isNullOrNil(str2) || bankcard.field_support_micropay) {
                            Object charSequence2 = str2;
                        } else {
                            charSequence2 = C5046bo.isNullOrNil(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
                        }
                        if (C5046bo.isNullOrNil(bankcard.field_forbid_title)) {
                            spannableString = new SpannableString(charSequence2);
                            str = charSequence2;
                        } else {
                            String str3 = charSequence2 + " ";
                            spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                            C214192 c214192 = new C46373j(WalletOfflineCoinPurseUI.this) {
                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(43539);
                                    Intent intent = new Intent();
                                    C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", bankcard.field_forbid_url);
                                    intent.putExtra("rawUrl", r1);
                                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                                    intent.putExtra("pay_channel", 1);
                                    C25985d.m41467b(WalletOfflineCoinPurseUI.this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                    AppMethodBeat.m2505o(43539);
                                }
                            };
                            int length = str3.length();
                            int length2 = str3.length() + bankcard.field_forbid_title.length();
                            spannableString.setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(C25738R.color.a50)), length, length2, 33);
                            spannableString.setSpan(c214192, length, length2, 33);
                            str = str3;
                        }
                        if ((bankcard.cPc() || bankcard.cPd()) && bankcard.twS >= 0.0d) {
                            charSequence2 = bankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(C25738R.string.f94, new Object[]{C36391e.m59972G(bankcard.twS)});
                        } else {
                            charSequence2 = bankcard.field_desc;
                        }
                        if (bankcard.cPg()) {
                            f = C5147a.m7837f(WalletOfflineCoinPurseUI.this.getResources(), C1318a.honey_pay_bank_logo);
                        } else if (a != null) {
                            f = new BitmapDrawable(C5056d.m7615a(a, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false));
                        } else {
                            f = null;
                        }
                        if (f == null) {
                            WalletOfflineCoinPurseUI.this.pas.put(Uk, Integer.valueOf(i));
                        }
                        C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", Integer.valueOf(i), charSequence2, spannableString);
                        SpannableString b = C44089j.m79292b(WalletOfflineCoinPurseUI.this.mController.ylL, charSequence2);
                        if (f == null) {
                            drawable = null;
                        } else {
                            drawable = f;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        c44273l.mo70053a(i, b, spannableString, drawable, z);
                    }
                    AppMethodBeat.m2505o(43540);
                }
            };
            c36356d.rBm = new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(43541);
                    if (c36356d != null) {
                        c36356d.cpE();
                        Bankcard bankcard = (Bankcard) ne.get(i);
                        C7060h.pYm.mo8381e(14515, Integer.valueOf(3));
                        if (!(C5046bo.isNullOrNil(bankcard.field_forbid_title) && C5046bo.isNullOrNil(bankcard.field_forbidWord) && bankcard.field_support_micropay)) {
                            C7060h.pYm.mo8381e(14515, Integer.valueOf(4));
                        }
                        String str = bankcard.field_bindSerial;
                        if (!(TextUtils.isEmpty(str) || str.equals(WalletOfflineCoinPurseUI.this.oWS))) {
                            WalletOfflineCoinPurseUI.this.oWS = str;
                            C28630a.m45497Ue(WalletOfflineCoinPurseUI.this.oWS);
                            C7007k.bXg();
                            C7007k.bXi().oWS = WalletOfflineCoinPurseUI.this.oWS;
                            WalletOfflineCoinPurseUI.this.bXM();
                            WalletOfflineCoinPurseUI.m89329C(WalletOfflineCoinPurseUI.this);
                            WalletOfflineCoinPurseUI.m89330D(WalletOfflineCoinPurseUI.this);
                        }
                    }
                    AppMethodBeat.m2505o(43541);
                }
            };
            View inflate = View.inflate(this, 2130971128, null);
            c36356d.pIf = true;
            c36356d.zQA = i;
            c36356d.zQy = true;
            c36356d.mo57234F(inflate, false);
            c36356d.cpD();
            C7060h.pYm.mo8381e(13955, Integer.valueOf(3));
            AppMethodBeat.m2505o(43604);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    private static void bXX() {
        AppMethodBeat.m2504i(43605);
        if (!C28630a.bYw()) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            C7007k.bXg();
            C7007k.bXj().mo62419eO(3, 3);
        }
        AppMethodBeat.m2505o(43605);
    }

    /* renamed from: a */
    private void m89346a(Bankcard bankcard) {
        AppMethodBeat.m2504i(43606);
        if (TextUtils.isEmpty(this.oWS)) {
            C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
            AppMethodBeat.m2505o(43606);
        } else if (bankcard.cPg()) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
            this.oZO.setImageDrawable(C5147a.m7837f(this.mController.ylL.getResources(), C1318a.honey_pay_bank_logo));
            AppMethodBeat.m2505o(43606);
        } else {
            CharSequence Ul = C28630a.m45504Ul(this.oWS);
            if (bankcard.cPd() && bankcard.txc != null) {
                Ul = bankcard.txc.oRi;
            }
            if (TextUtils.isEmpty(Ul)) {
                C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
                AppMethodBeat.m2505o(43606);
                return;
            }
            m89354e(this.oZO, Ul, getResources().getDimensionPixelOffset(C25738R.dimen.aaq));
            AppMethodBeat.m2505o(43606);
        }
    }

    public final void bap() {
        AppMethodBeat.m2504i(43607);
        m89327Az(0);
        m89361jG(true);
        AppMethodBeat.m2505o(43607);
    }

    public final void bXr() {
        AppMethodBeat.m2504i(43609);
        bXW();
        AppMethodBeat.m2505o(43609);
    }

    public final void bXs() {
        AppMethodBeat.m2504i(43610);
        mo39970a(new C21401j(""), false, false);
        AppMethodBeat.m2505o(43610);
    }

    public final String bXt() {
        return this.oWS;
    }

    private void bXY() {
        AppMethodBeat.m2504i(43611);
        if (C28630a.pbe == 3 && C28630a.pbh) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = C28630a.pbf;
            long j = C28630a.pbg;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (C28630a.pbf <= 0 || C28630a.pbg <= 0 || j2 <= 0) {
                C4990ab.m7412e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
                AppMethodBeat.m2505o(43611);
                return;
            }
            if (!this.pau.doT()) {
                this.pau.stopTimer();
            }
            this.pau.mo16770ae(j2, j2);
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            AppMethodBeat.m2505o(43611);
        } else if (C28630a.pbe == 3) {
            C4990ab.m7416i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
            AppMethodBeat.m2505o(43611);
        } else {
            C4990ab.m7417i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", Integer.valueOf(C28630a.pbe));
            AppMethodBeat.m2505o(43611);
        }
    }

    private void bhw() {
        AppMethodBeat.m2504i(43612);
        C15319aw cPy = C22594k.cPy();
        StringBuilder append = new StringBuilder().append(this.oZW);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String ck = C4995ag.m7428ck(append.append(C1183p.getString(C1668a.m3383QF())).toString());
        if (cPy != null) {
            C7060h.pYm.mo8381e(13444, cPy.vCF, cPy.vCG, Long.valueOf(cPy.vCE), ck, cPy.vCH, cPy.vCI);
        }
        AppMethodBeat.m2505o(43612);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43613);
        if (i == 4 && this.pah != null && this.pah.getVisibility() == 0 && this.pah.oZg) {
            this.pah.dismiss();
            AppMethodBeat.m2505o(43613);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(43613);
        return onKeyUp;
    }

    public final void bXu() {
        AppMethodBeat.m2504i(43614);
        if (!this.oXA.doT()) {
            this.oXA.stopTimer();
        }
        m89327Az(0);
        m89361jG(true);
        this.oZX = false;
        long j = (long) this.oXz;
        this.oXA.mo16770ae(j, j);
        AppMethodBeat.m2505o(43614);
    }

    /* renamed from: e */
    public final void mo8134e(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(43608);
        mo39970a(new C12736e(i, str, str2, str3), C28630a.bYe(), false);
        AppMethodBeat.m2505o(43608);
    }

    public /* synthetic */ Dialog onCreateDialog(final int i) {
        AppMethodBeat.m2504i(43615);
        View inflate = getLayoutInflater().inflate(2130971114, null);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131821054);
        if (this.oZB == null) {
            this.oZB = new C28653a();
        }
        if (i == 1) {
            C28653a c28653a = this.oZB;
            ArrayList arrayList = this.oZE;
            ArrayList arrayList2 = this.oZG;
            if (arrayList != null) {
                c28653a.iPr.clear();
                c28653a.iPr.addAll(arrayList);
            }
            if (arrayList2 != null) {
                c28653a.paT.clear();
                c28653a.paT.addAll(arrayList2);
            }
        }
        listViewInScrollView.setAdapter(this.oZB);
        this.oZB.notifyDataSetChanged();
        listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(43526);
                WalletOfflineCoinPurseUI.this.dismissDialog(i);
                WalletOfflineCoinPurseUI.jpc = i;
                if (i == 1) {
                    String str = (String) WalletOfflineCoinPurseUI.this.oZF.get(i);
                    if (!(TextUtils.isEmpty(str) || str.equals(WalletOfflineCoinPurseUI.this.oWS))) {
                        WalletOfflineCoinPurseUI.this.oWS = str;
                        C28630a.m45497Ue(WalletOfflineCoinPurseUI.this.oWS);
                        C7007k.bXg();
                        C7007k.bXi().oWS = WalletOfflineCoinPurseUI.this.oWS;
                        WalletOfflineCoinPurseUI.this.bXM();
                        WalletOfflineCoinPurseUI.m89329C(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.m89330D(WalletOfflineCoinPurseUI.this);
                    }
                }
                AppMethodBeat.m2505o(43526);
            }
        });
        C5652a c5652a = new C5652a(this);
        if (i == 1) {
            c5652a.mo11446PV(C25738R.string.fv9);
        }
        c5652a.mo11479fn(inflate);
        c5652a.mo11478f(null);
        C5653c aMb = c5652a.aMb();
        AppMethodBeat.m2505o(43615);
        return aMb;
    }

    /* renamed from: g */
    static /* synthetic */ void m89357g(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43620);
        walletOfflineCoinPurseUI.pah.getVisibility();
        AppMethodBeat.m2505o(43620);
    }

    /* renamed from: r */
    static /* synthetic */ void m89369r(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43622);
        C30379h.m48424a(walletOfflineCoinPurseUI.mController.ylL, null, walletOfflineCoinPurseUI.getResources().getStringArray(C25738R.array.f12639at), null, false, new C1274716());
        AppMethodBeat.m2505o(43622);
    }

    /* renamed from: I */
    static /* synthetic */ void m89336I(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.m2504i(43629);
        C30379h.m48453a((Context) walletOfflineCoinPurseUI, false, walletOfflineCoinPurseUI.getString(C25738R.string.fuz), "", walletOfflineCoinPurseUI.getString(C25738R.string.fvd), walletOfflineCoinPurseUI.getString(C25738R.string.f9076or), new C3465521(), new C1274922());
        AppMethodBeat.m2505o(43629);
    }
}
