package com.tencent.p177mm.plugin.collect.p368ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.collect.model.C27676d;
import com.tencent.p177mm.plugin.collect.model.C27676d.C27677a;
import com.tencent.p177mm.plugin.collect.model.C27680t;
import com.tencent.p177mm.plugin.collect.model.C33854b;
import com.tencent.p177mm.plugin.collect.model.C33855f;
import com.tencent.p177mm.plugin.collect.model.C33855f.C11415a;
import com.tencent.p177mm.plugin.collect.model.C6830l;
import com.tencent.p177mm.plugin.collect.model.voice.C45818a;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.protocal.protobuf.C40555oy;
import com.tencent.p177mm.protocal.protobuf.bbc;
import com.tencent.p177mm.protocal.protobuf.bbj;
import com.tencent.p177mm.protocal.protobuf.bci;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C30292bc.C23502a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletPreferenceUI;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C5271a(0)
/* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI */
public class CollectMainUI extends WalletPreferenceUI implements C27677a, C23502a {
    private static int kGN;
    private static int kHh = -1;
    private static int kHi = -1;
    private static int kHj = -1;
    private static int kHk = -1;
    private int cQG;
    private C15541f iFE = null;
    private Vibrator iVt;
    protected ScrollView kEu = null;
    private long kFU;
    protected TextView kGA;
    private RelativeLayout kGB;
    private Bitmap kGC = null;
    protected String kGD = null;
    protected String kGE = null;
    protected String kGF = null;
    private String kGG = null;
    private List<C31348a> kGH = new LinkedList();
    private double kGI;
    private String kGJ = null;
    private String kGK = null;
    protected boolean kGL = false;
    private long kGM;
    private View kGO;
    private C38820b kGP = new C38820b(this, (byte) 0);
    private SpannableStringBuilder kGQ;
    private SpannableStringBuilder kGR;
    private C33855f kGS;
    private int kGT = 0;
    private String kGU;
    private String kGV;
    private String kGW;
    protected CdnImageView kGX;
    protected TextView kGY;
    protected TextView kGZ;
    private ImageView kGi = null;
    private TextView kGj = null;
    private WalletTextView kGk = null;
    private TextView kGl = null;
    private TextView kGm = null;
    private TextView kGn = null;
    private RelativeLayout kGo = null;
    private View kGp = null;
    private TextView kGq = null;
    private Dialog kGr = null;
    private View kGs = null;
    private View kGt = null;
    private boolean kGu = false;
    private View kGv = null;
    private ImageView kGw;
    private TextView kGx;
    private TextView kGy;
    private TextView kGz;
    protected ImageView kHa;
    protected ViewGroup kHb;
    protected View kHc;
    private boolean kHd = false;
    private int kHe = 0;
    private bbj kHf;
    private C18765a kHg = new C3881412();

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$17 */
    class C1145317 implements C35502a {
        C1145317() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41272);
            CollectMainUI.this.kGL = false;
            CollectMainUI.this.bhs();
            CollectMainUI.this.kGz.setText(CollectMainUI.this.kGQ);
            CollectMainUI.m81491h(CollectMainUI.this);
            AppMethodBeat.m2505o(41272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$10 */
    class C2028010 implements C11415a {

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$10$1 */
        class C28471 implements OnClickListener {
            C28471() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(41260);
                C4990ab.m7416i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
                AppMethodBeat.m2505o(41260);
            }
        }

        C2028010() {
        }

        /* renamed from: dz */
        public final void mo23167dz(String str, String str2) {
            AppMethodBeat.m2504i(41261);
            C4990ab.m7417i("MicroMsg.CollectMainUI", "get cache: %s, %s", str, str2);
            CollectMainUI.this.kGo.setVisibility(0);
            CollectMainUI.this.kGD = str;
            CollectMainUI.this.kGE = str2;
            bbc bhD = CollectMainUI.bhD();
            List bhE = CollectMainUI.bhE();
            CollectMainUI.m81478a(CollectMainUI.this, bhD);
            CollectMainUI.this.mo71803bq(bhE);
            if (CollectMainUI.this.cQG == 1) {
                CollectMainUI collectMainUI = CollectMainUI.this;
                C1720g.m3537RQ();
                collectMainUI.kGT = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, Integer.valueOf(-1))).intValue();
                collectMainUI = CollectMainUI.this;
                C1720g.m3537RQ();
                collectMainUI.kGW = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, (Object) "");
            }
            AppMethodBeat.m2505o(41261);
        }

        /* renamed from: a */
        public final void mo23166a(boolean z, C40555oy c40555oy) {
            AppMethodBeat.m2504i(41262);
            String str = "MicroMsg.CollectMainUI";
            String str2 = "get from cgi: %s resp.retcode: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = c40555oy == null ? BuildConfig.COMMAND : Integer.valueOf(c40555oy.kCl);
            C4990ab.m7417i(str, str2, objArr);
            if (z) {
                if (c40555oy == null || c40555oy.kCl != 416) {
                    CollectMainUI.m81506v(CollectMainUI.this);
                    CollectMainUI.this.kGo.setVisibility(0);
                    CollectMainUI.this.kHd = false;
                    CollectMainUI.this.kGD = c40555oy.url;
                    CollectMainUI.this.kGE = c40555oy.twd;
                    CollectMainUI.this.kGT = c40555oy.pPV;
                    CollectMainUI.this.kGV = c40555oy.pPW;
                    CollectMainUI.this.kGW = c40555oy.pPX;
                    CollectMainUI.this.kGU = c40555oy.vWc;
                    CollectMainUI.m81478a(CollectMainUI.this, c40555oy.vVZ);
                    CollectMainUI.this.mo71803bq(c40555oy.vVY);
                    CollectMainUI.this.kHe = c40555oy.vWd;
                    CollectMainUI.this.kHf = c40555oy.vWe;
                    C4990ab.m7411d("MicroMsg.CollectMainUI", "flag: %s", Integer.valueOf(CollectMainUI.this.kHe));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, Integer.valueOf(CollectMainUI.this.kGT));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, CollectMainUI.this.kGW);
                    CollectMainUI.this.refreshView();
                } else {
                    boolean z2;
                    str = "MicroMsg.CollectMainUI";
                    str2 = "realNameInfo:%s";
                    objArr = new Object[1];
                    if (c40555oy.vWf == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[0] = Boolean.valueOf(z2);
                    C4990ab.m7411d(str, str2, objArr);
                    CollectMainUI.this.kGo.setVisibility(4);
                    CollectMainUI.this.kHd = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
                    bundle.putString("realname_verify_process_jump_plugin", "collect");
                    Activity activity = CollectMainUI.this;
                    int i = c40555oy.kCl;
                    bpt bpt = c40555oy.vWf;
                    C28471 c28471 = new C28471();
                    C43795a.m78491a(activity, i, bpt, bundle, 1010);
                    AppMethodBeat.m2505o(41262);
                    return;
                }
            }
            AppMethodBeat.m2505o(41262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$19 */
    class C2028219 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$19$3 */
        class C28483 implements C36073c {
            C28483() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(41276);
                c44273l.mo70068e(1, CollectMainUI.this.getString(C25738R.string.ask));
                c44273l.mo70068e(0, CollectMainUI.this.getString(C25738R.string.asn));
                AppMethodBeat.m2505o(41276);
            }
        }

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$19$1 */
        class C114541 implements C36073c {
            C114541() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(41274);
                c44273l.mo70068e(0, CollectMainUI.this.getString(C25738R.string.asa));
                AppMethodBeat.m2505o(41274);
            }
        }

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$19$2 */
        class C114552 implements C5279d {
            C114552() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(41275);
                switch (menuItem.getItemId()) {
                    case 0:
                        CollectMainUI.m81487e(CollectMainUI.this);
                        break;
                    case 1:
                        if (CollectMainUI.this.kHf != null) {
                            CollectMainUI.m81486dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                            AppMethodBeat.m2505o(41275);
                            return;
                        }
                        break;
                }
                AppMethodBeat.m2505o(41275);
            }
        }

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$19$4 */
        class C114564 implements C5279d {
            C114564() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(41277);
                switch (menuItem.getItemId()) {
                    case 0:
                        CollectMainUI.m81487e(CollectMainUI.this);
                        break;
                    case 1:
                        if (CollectMainUI.this.kHf != null) {
                            CollectMainUI.m81486dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                            C7060h.pYm.mo8381e(15387, Integer.valueOf(1));
                            AppMethodBeat.m2505o(41277);
                            return;
                        }
                        break;
                }
                AppMethodBeat.m2505o(41277);
            }
        }

        C2028219() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(41278);
            if (CollectMainUI.this.kHe == 0) {
                C46696j c46696j = new C46696j(CollectMainUI.this.mController.ylL);
                c46696j.rBl = new C114541();
                c46696j.rBm = new C114552();
                c46696j.cuu();
            } else {
                C36356d c36356d = new C36356d(CollectMainUI.this.mController.ylL, 1, false);
                c36356d.rBl = new C28483();
                c36356d.rBm = new C114564();
                c36356d.cpD();
            }
            AppMethodBeat.m2505o(41278);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$3 */
    class C202833 implements Runnable {
        C202833() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41254);
            int fromDPToPix = C1338a.fromDPToPix(CollectMainUI.this.mController.ylL, 37);
            LayoutParams layoutParams = CollectMainUI.this.kGO.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = fromDPToPix;
                CollectMainUI.this.kGO.setLayoutParams(layoutParams);
                CollectMainUI.this.kGO.requestLayout();
            }
            AppMethodBeat.m2505o(41254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$4 */
    class C202844 implements Runnable {
        C202844() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41255);
            CollectMainUI.m81495l(CollectMainUI.this);
            CollectMainUI.this.kGP.bhF();
            CollectMainUI.m81491h(CollectMainUI.this);
            AppMethodBeat.m2505o(41255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$16 */
    class C2769516 implements C35502a {
        C2769516() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41271);
            Intent intent = new Intent();
            intent.setClass(CollectMainUI.this.mController.ylL, CollectCreateQRCodeUI.class);
            intent.putExtra("key_currency_unit", CollectMainUI.this.kGF);
            CollectMainUI.this.startActivityForResult(intent, 4096);
            AppMethodBeat.m2505o(41271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$6 */
    class C276966 implements C5662c {
        C276966() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(41257);
            if (CollectMainUI.this.kHf != null) {
                CollectMainUI.m81486dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                C7060h.pYm.mo8381e(15387, Integer.valueOf(3));
            }
            AppMethodBeat.m2505o(41257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$a */
    class C31348a extends C27680t {
        public boolean jYD = false;

        public C31348a(C27680t c27680t) {
            this.username = c27680t.username;
            this.cAa = c27680t.cAa;
            this.kCJ = c27680t.kCJ;
            this.timestamp = c27680t.timestamp;
            this.scene = c27680t.scene;
            this.status = c27680t.status;
            this.eoz = c27680t.eoz;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$12 */
    class C3881412 implements C18765a {
        C3881412() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(41264);
            if (str == null || CollectMainUI.this.kGW == null) {
                AppMethodBeat.m2505o(41264);
                return;
            }
            if (str.equals(CollectMainUI.this.kGW)) {
                C4990ab.m7417i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", CollectMainUI.this.kGW, str);
                CollectMainUI.this.bhs();
            }
            AppMethodBeat.m2505o(41264);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$14 */
    class C3881514 implements OnMenuItemClickListener {
        C3881514() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41268);
            CollectMainUI.this.finish();
            AppMethodBeat.m2505o(41268);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$15 */
    class C3881615 implements C35502a {

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$15$1 */
        class C202811 implements OnClickListener {
            C202811() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(41269);
                C4990ab.m7416i("MicroMsg.CollectMainUI", "save code from click");
                if (CollectMainUI.this.kHf != null) {
                    CollectMainUI.m81486dB(CollectMainUI.this.kHf.username, CollectMainUI.this.kHf.iAb);
                    C7060h.pYm.mo8381e(15387, Integer.valueOf(2));
                }
                AppMethodBeat.m2505o(41269);
            }
        }

        /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$15$2 */
        class C276942 implements OnClickListener {
            C276942() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C3881615() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41270);
            if (CollectMainUI.this.kHe == 1) {
                CollectMainUI.m81484c(CollectMainUI.this);
                C30379h.m48445a(CollectMainUI.this.mController.ylL, CollectMainUI.this.getString(C25738R.string.asm), "", CollectMainUI.this.getString(C25738R.string.asl), CollectMainUI.this.getString(C25738R.string.f9076or), true, new C202811(), new C276942());
            } else {
                CollectMainUI.m81487e(CollectMainUI.this);
            }
            C7060h.pYm.mo8381e(13944, Integer.valueOf(5));
            AppMethodBeat.m2505o(41270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$9 */
    class C388189 implements OnClickListener {
        C388189() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$b */
    class C38820b {
        boolean kHw;
        LinkedList<C31348a> kHx;

        private C38820b() {
            AppMethodBeat.m2504i(41283);
            this.kHx = new LinkedList();
            AppMethodBeat.m2505o(41283);
        }

        /* synthetic */ C38820b(CollectMainUI collectMainUI, byte b) {
            this();
        }

        /* renamed from: tK */
        private int m65871tK(int i) {
            AppMethodBeat.m2504i(41284);
            float height = 0.0f + ((float) (CollectMainUI.this.kGs.getHeight() / 2));
            if (CollectMainUI.this.kGp.getVisibility() == 0) {
                height += (float) CollectMainUI.this.kGp.getHeight();
            }
            height += (float) ((CollectMainUI.kHi * i) + (CollectMainUI.kHi / 2));
            int[] iArr = new int[2];
            CollectMainUI.this.kGs.getLocationInWindow(iArr);
            int bhA = (int) (height + ((float) (iArr[1] - CollectMainUI.kGN)));
            AppMethodBeat.m2505o(41284);
            return bhA;
        }

        public final void bhF() {
            AppMethodBeat.m2504i(41285);
            if (this.kHw) {
                C4990ab.m7410d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.kHx.size());
            } else if (!this.kHx.isEmpty()) {
                m65870a((C31348a) this.kHx.poll());
                AppMethodBeat.m2505o(41285);
                return;
            }
            AppMethodBeat.m2505o(41285);
        }

        /* renamed from: a */
        private void m65870a(final C31348a c31348a) {
            AppMethodBeat.m2504i(41286);
            this.kHw = true;
            CollectMainUI.m81495l(CollectMainUI.this);
            CollectMainUI.this.kGv.setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.this.kGs.getWidth(), CollectMainUI.this.kGs.getHeight()));
            if (CollectMainUI.this.kGL) {
                CollectMainUI.this.kGv.setPadding(0, CollectMainUI.kHk, 0, 0);
            } else {
                CollectMainUI.this.kGv.setPadding(0, CollectMainUI.kHj, 0, 0);
            }
            CollectMainUI.this.kGx.setText(C44089j.m79293b(CollectMainUI.this.mController.ylL, c31348a.eoz, CollectMainUI.this.kGx.getTextSize()));
            C40460b.m69434b(CollectMainUI.this.kGw, c31348a.username);
            CollectMainUI.this.kGy.setText(C36391e.m60006e(c31348a.kCJ, c31348a.cuZ));
            CollectMainUI.this.kGv.setVisibility(0);
            final AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < CollectMainUI.this.kGH.size()) {
                    if (((C31348a) CollectMainUI.this.kGH.get(i3)).cAa.equals(c31348a.cAa)) {
                        i = i3;
                    }
                    i2 = i3 + 1;
                } else {
                    animationSet.addAnimation(new TranslateAnimation(0.0f, (float) CollectMainUI.kHh, 0.0f, (float) m65871tK(i)));
                    animationSet.setDuration(300);
                    animationSet.setInterpolator(new DecelerateInterpolator());
                    animationSet.setAnimationListener(new AnimationListener() {
                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(41280);
                            CollectMainUI.this.kGv.setVisibility(8);
                            C4990ab.m7410d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + c31348a.cAa);
                            for (int i = 0; i < CollectMainUI.this.kGH.size(); i++) {
                                if (((C31348a) CollectMainUI.this.kGH.get(i)).cAa.equals(c31348a.cAa)) {
                                    ((C31348a) CollectMainUI.this.kGH.get(i)).jYD = true;
                                    C4990ab.m7410d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + c31348a.cAa);
                                    break;
                                }
                            }
                            CollectMainUI.m81495l(CollectMainUI.this);
                            C38820b.this.kHw = false;
                            C38820b.this.bhF();
                            AppMethodBeat.m2505o(41280);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                        }
                    });
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setInterpolator(new LinearInterpolator());
                    scaleAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(41281);
                            animationSet.setStartOffset(1700);
                            CollectMainUI.this.kGv.startAnimation(animationSet);
                            AppMethodBeat.m2505o(41281);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.m2504i(41282);
                            CollectMainUI.this.kGv.setVisibility(0);
                            AppMethodBeat.m2505o(41282);
                        }
                    });
                    CollectMainUI.this.kGv.startAnimation(scaleAnimation);
                    AppMethodBeat.m2505o(41286);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$7 */
    class C428997 implements C5662c {
        C428997() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(41258);
            CollectMainUI.m81487e(CollectMainUI.this);
            AppMethodBeat.m2505o(41258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$8 */
    class C429008 implements OnClickListener {
        C429008() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41259);
            CollectMainUI.m81487e(CollectMainUI.this);
            C7060h.pYm.mo8381e(13944, Integer.valueOf(10));
            AppMethodBeat.m2505o(41259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$1 */
    class C447281 implements OnClickListener {
        C447281() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$20 */
    class C4472920 implements Runnable {
        C4472920() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41279);
            int[] iArr = new int[2];
            CollectMainUI.this.kGs.getLocationInWindow(iArr);
            CollectMainUI.kGN = iArr[1];
            AppMethodBeat.m2505o(41279);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CollectMainUI() {
        AppMethodBeat.m2504i(41287);
        AppMethodBeat.m2505o(41287);
    }

    static /* synthetic */ bbc bhD() {
        AppMethodBeat.m2504i(41317);
        bbc bhx = CollectMainUI.bhx();
        AppMethodBeat.m2505o(41317);
        return bhx;
    }

    static /* synthetic */ List bhE() {
        AppMethodBeat.m2504i(41318);
        List bhy = CollectMainUI.bhy();
        AppMethodBeat.m2505o(41318);
        return bhy;
    }

    /* renamed from: c */
    static /* synthetic */ void m81484c(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41312);
        collectMainUI.m81489fX(false);
        AppMethodBeat.m2505o(41312);
    }

    /* renamed from: h */
    static /* synthetic */ void m81491h(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41315);
        collectMainUI.bhu();
        AppMethodBeat.m2505o(41315);
    }

    /* renamed from: l */
    static /* synthetic */ void m81495l(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41316);
        collectMainUI.bhv();
        AppMethodBeat.m2505o(41316);
    }

    public final void bht() {
        AppMethodBeat.m2504i(41289);
        mo17446xE(getResources().getColor(C25738R.color.f11656aw));
        AppMethodBeat.m2505o(41289);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41290);
        if (this.kGi != null) {
            this.kGi.setImageBitmap(null);
        }
        Bitmap bitmap = this.kGC;
        if (!(bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7417i("MicroMsg.CollectMainUI", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        if (this.kGr != null) {
            this.kGr.dismiss();
        }
        C45815a.bgv();
        C45815a.bgw().kaD.remove(this);
        this.iVt.cancel();
        if (this.kGS != null) {
            C1202f c1202f = this.kGS;
            for (Entry entry : c1202f.jxd.entrySet()) {
                C4990ab.m7416i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14547c((C1207m) entry.getKey());
            }
            c1202f.jxd.clear();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(1588, c1202f);
        }
        C18764x.m29330c(this.kHg);
        super.onDestroy();
        AppMethodBeat.m2505o(41290);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41291);
        setMMTitle((int) C25738R.string.daa);
        setBackBtn(new C3881514());
        this.iFE = this.yCw;
        this.kGo = (RelativeLayout) findViewById(2131820987);
        this.kGp = findViewById(2131822874);
        this.kHc = findViewById(2131822875);
        this.kGk = (WalletTextView) findViewById(2131822861);
        this.kGj = (TextView) findViewById(2131822862);
        this.kGl = (TextView) findViewById(2131822860);
        this.kGm = (TextView) findViewById(2131822876);
        this.kGA = (TextView) findViewById(2131821634);
        this.kGs = (RelativeLayout) findViewById(2131822853);
        this.kGt = findViewById(2131822877);
        this.kGO = LayoutInflater.from(this).inflate(2130969161, null, false);
        this.kGn = (TextView) findViewById(2131822867);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C25738R.string.asd));
        spannableStringBuilder.setSpan(new C35503o(new C3881615()), 0, spannableStringBuilder.length(), 18);
        this.kGn.setText(spannableStringBuilder);
        this.kGn.setClickable(true);
        this.kGn.setOnTouchListener(new C30132m(this));
        this.nDp.addFooterView(this.kGO, null, false);
        this.nDp.setFooterDividersEnabled(false);
        this.kGi = (ImageView) findViewById(2131822864);
        this.kGq = (TextView) findViewById(2131822856);
        this.kGz = (TextView) findViewById(2131822866);
        this.kGz.setClickable(true);
        this.kGz.setOnTouchListener(new C30132m(this));
        this.kGQ = new SpannableStringBuilder(getString(C25738R.string.as2));
        this.kGR = new SpannableStringBuilder(getString(C25738R.string.as3));
        final C35503o c35503o = new C35503o(new C2769516());
        final C35503o c35503o2 = new C35503o(new C1145317());
        this.kGQ.setSpan(c35503o, 0, this.kGQ.length(), 18);
        if (C5215a.yqY.dzj()) {
            this.kGz.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(41273);
                    if (CollectMainUI.this.kGz.getText().toString().equals(CollectMainUI.this.kGR)) {
                        c35503o.onClick(view);
                        AppMethodBeat.m2505o(41273);
                        return;
                    }
                    c35503o2.onClick(view);
                    AppMethodBeat.m2505o(41273);
                }
            });
        }
        this.kGR.setSpan(c35503o2, 0, this.kGR.length(), 18);
        this.kGz.setText(this.kGQ);
        this.kGB = (RelativeLayout) findViewById(2131822855);
        this.kGi.setOnLongClickListener(new C2028219());
        this.kGv = findViewById(2131822848);
        this.kGw = (ImageView) findViewById(2131822849);
        this.kGx = (TextView) findViewById(2131822850);
        this.kGy = (TextView) findViewById(2131822851);
        this.kGX = (CdnImageView) findViewById(2131822870);
        this.kGY = (TextView) findViewById(2131822871);
        this.kGZ = (TextView) findViewById(2131822872);
        this.kHa = (ImageView) findViewById(2131822873);
        this.kHb = (ViewGroup) findViewById(2131822869);
        this.kGs.postDelayed(new C4472920(), 300);
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "8";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(41253);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.CollectMainUI", "no bulletin data");
                    AppMethodBeat.m2505o(41253);
                    return;
                }
                C36391e.m59985a((TextView) CollectMainUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(41253);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(41291);
    }

    /* renamed from: fX */
    private void m81489fX(final boolean z) {
        AppMethodBeat.m2504i(41292);
        if (this.kGC == null || this.kGC.isRecycled()) {
            C4990ab.m7420w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(this.mController.ylL, getString(C25738R.string.asq), 1).show();
        } else {
            Object obj;
            Bitmap a = C33854b.m55397a(this, this.kGD, C1853r.m3846Yz(), this.kGT, this.kGW, C4977b.m7371b((Context) this, 197.0f), this.kHg, false);
            if (a == null || a.isRecycled()) {
                obj = null;
            } else {
                int i;
                if (this.kGL) {
                    C7060h.pYm.mo8381e(11343, Integer.valueOf(1), Integer.valueOf((int) Math.round(this.kGI * 100.0d)));
                } else {
                    C7060h.pYm.mo8381e(11343, Integer.valueOf(0));
                }
                if (this.kGu) {
                    i = 0;
                } else {
                    this.kEu = (ScrollView) ((ViewStub) findViewById(2131822847)).inflate();
                    bhr();
                    this.kGu = true;
                    i = 250;
                }
                this.kEu.setVisibility(4);
                ((ImageView) this.kEu.findViewById(2131822885)).setImageBitmap(this.kGC);
                TextView textView = (TextView) this.kEu.findViewById(2131822886);
                TextView textView2 = (TextView) this.kEu.findViewById(2131822887);
                final LinearLayout linearLayout = (LinearLayout) this.kEu.findViewById(2131822879);
                LinearLayout linearLayout2 = (LinearLayout) this.kEu.findViewById(2131822881);
                TextView textView3 = (TextView) this.kEu.findViewById(2131822883);
                TextView textView4 = (TextView) this.kEu.findViewById(2131822884);
                TextView textView5 = (TextView) this.kEu.findViewById(2131822882);
                CharSequence eK = C36391e.m60007eK(C36391e.m60015mJ(C1853r.m3846Yz()), 10);
                if (!C5046bo.isNullOrNil(bhp())) {
                    eK = eK + getString(C25738R.string.asc, new Object[]{r9});
                }
                if (this.kGT != 1) {
                    textView.setText(C44089j.m79293b((Context) this, eK, textView.getTextSize()));
                } else if (C5046bo.isNullOrNil(this.kGV)) {
                    textView.setText(C44089j.m79293b((Context) this, eK, textView.getTextSize()));
                } else {
                    textView.setText(this.kGV);
                    textView2.setText(C44089j.m79293b((Context) this, eK, textView2.getTextSize()));
                    textView2.setVisibility(0);
                }
                if (this.kGL) {
                    if (C5046bo.isNullOrNil(this.kGK)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(this.kGK);
                        textView4.setVisibility(0);
                    }
                    textView3.setText(bhq());
                    textView5.setText(C36391e.m59971F(this.kGI));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(41256);
                        C4990ab.m7411d("MicroMsg.CollectMainUI", "height: %d, width: %d", Integer.valueOf(linearLayout.getHeight()), Integer.valueOf(linearLayout.getWidth()));
                        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Config.ARGB_8888);
                        linearLayout.draw(new Canvas(createBitmap));
                        try {
                            String str = C14987n.dly() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                            C5056d.m7625a(createBitmap, 100, CompressFormat.PNG, str, false);
                            if (z) {
                                Toast.makeText(CollectMainUI.this.mController.ylL, CollectMainUI.this.getString(C25738R.string.fdw, new Object[]{str}), 1).show();
                            }
                            C14987n.m23300a(str, CollectMainUI.this.mController.ylL);
                        } catch (Exception e) {
                            C4990ab.m7420w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                        }
                        CollectMainUI.this.kEu.setVisibility(8);
                        AppMethodBeat.m2505o(41256);
                    }
                }, (long) i);
                obj = 1;
            }
            if (obj == null) {
                Toast.makeText(this.mController.ylL, getString(C25738R.string.asq), 1).show();
            }
        }
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(41292);
    }

    /* Access modifiers changed, original: protected|final */
    public final void refreshView() {
        AppMethodBeat.m2504i(41293);
        if (C5046bo.isNullOrNil(this.kGD)) {
            C4990ab.m7420w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            AppMethodBeat.m2505o(41293);
            return;
        }
        if (this.kGT == 1) {
            if (!C5046bo.isNullOrNil(this.kGU)) {
                this.kGq.setText(this.kGU);
            }
            if (!C5046bo.isNullOrNil(this.kGV)) {
                TextView textView = (TextView) findViewById(2131822857);
                textView.setText(this.kGV);
                textView.setVisibility(0);
            }
        }
        bhs();
        bhv();
        bhw();
        AppMethodBeat.m2505o(41293);
    }

    /* Access modifiers changed, original: protected */
    public void bhs() {
        AppMethodBeat.m2504i(41294);
        this.kGi.setImageBitmap(null);
        if (this.kGL) {
            if (C5046bo.isNullOrNil(this.kGG)) {
                C4990ab.m7420w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                AppMethodBeat.m2505o(41294);
                return;
            }
            this.kGC = m81472Id(this.kGG);
        } else if (C5046bo.isNullOrNil(this.kGD)) {
            C4990ab.m7420w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            AppMethodBeat.m2505o(41294);
            return;
        } else {
            this.kGC = m81472Id(this.kGD);
        }
        if (this.kGC == null || this.kGC.isRecycled()) {
            C4990ab.m7420w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + C5046bo.nullAsNil(this.kGG));
        } else {
            this.kGi.setImageBitmap(this.kGC);
        }
        if (this.kGL) {
            this.kGk.setPrefix(bhq());
            this.kGk.setText(C36391e.m59971F(this.kGI));
            this.kGk.setVisibility(0);
            if (C5046bo.isNullOrNil(this.kGK)) {
                this.kGj.setVisibility(8);
            } else {
                this.kGj.setText(C44089j.m79293b(this.mController.ylL, this.kGK, this.kGj.getTextSize()));
                this.kGj.setVisibility(0);
            }
            findViewById(2131822858).setVisibility(0);
            AppMethodBeat.m2505o(41294);
            return;
        }
        this.kGl.setVisibility(8);
        this.kGk.setVisibility(8);
        this.kGj.setVisibility(8);
        findViewById(2131822858).setVisibility(8);
        AppMethodBeat.m2505o(41294);
    }

    private void bhu() {
        AppMethodBeat.m2504i(41295);
        getWindow().getDecorView().post(new C202833());
        AppMethodBeat.m2505o(41295);
    }

    private void bhv() {
        double d;
        AppMethodBeat.m2504i(41296);
        if (this.kGH == null || this.kGH.size() <= 0) {
            d = 0.0d;
        } else {
            this.kGs.setBackgroundResource(C25738R.drawable.f6607jo);
            this.iFE.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.kGH.size(); i++) {
                C24735c c24735c;
                C31348a c31348a = (C31348a) this.kGH.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.kGH.size() - 1) {
                    c24735c = new C24735c(this, (byte) 0);
                } else {
                    c24735c = new C24735c(this);
                }
                c24735c.setKey(valueOf);
                valueOf = c31348a.eoz;
                if (C5046bo.isNullOrNil(valueOf) && !C5046bo.isNullOrNil(c31348a.username)) {
                    valueOf = C36391e.m60015mJ(c31348a.username);
                }
                c24735c.mTitle = valueOf;
                c24735c.edV = c31348a.username;
                if (c31348a.status == 0) {
                    c24735c.setSummary((int) C25738R.string.as9);
                } else if (c31348a.status == 1) {
                    if (c31348a.jYD) {
                        d += c31348a.kCJ;
                        c24735c.setSummary((CharSequence) C36391e.m60006e(c31348a.kCJ, c31348a.cuZ));
                    } else {
                        c24735c.setSummary((int) C25738R.string.as8);
                    }
                    this.iFE.mo27713b(c24735c);
                } else if (c31348a.status == 2) {
                    c24735c.setSummary((int) C25738R.string.as7);
                }
                this.iFE.mo27713b(c24735c);
            }
            this.iFE.notifyDataSetChanged();
            this.kGm.setText(C36391e.m60006e(d, ((C31348a) this.kGH.get(0)).cuZ));
            this.kGm.setVisibility(0);
        }
        if (this.kGH == null || this.kGH.size() <= 0) {
            this.kGm.setVisibility(8);
            this.kGp.setVisibility(8);
            this.kGt.setVisibility(8);
        } else {
            this.kHb.setBackgroundResource(C25738R.drawable.f6608jp);
            this.kGp.setVisibility(0);
            if (d > 0.0d && this.kGH.size() > 0) {
                this.kHc.setVisibility(0);
                this.kGt.setVisibility(0);
                AppMethodBeat.m2505o(41296);
                return;
            }
        }
        AppMethodBeat.m2505o(41296);
    }

    public final int getLayoutId() {
        return 2130969160;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8476q;
    }

    public final int aWi() {
        return 2130969162;
    }

    /* renamed from: f */
    public boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    /* renamed from: Id */
    private Bitmap m81472Id(String str) {
        AppMethodBeat.m2504i(41297);
        Bitmap a = C33854b.m55398a(this, str, C1853r.m3846Yz(), this.kGT, this.kGW, this.kHg);
        AppMethodBeat.m2505o(41297);
        return a;
    }

    /* renamed from: a */
    public final void mo45523a(C27680t c27680t) {
        Object obj = null;
        AppMethodBeat.m2504i(41298);
        C4990ab.m7410d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.cQG == 1 || this.cQG == 0) && c27680t.msgType == 9) || (this.cQG == 8 && c27680t.msgType == 26)) {
            if (this.iVt != null) {
                this.iVt.vibrate(50);
            }
            if (((long) c27680t.timestamp) < this.kGM) {
                C4990ab.m7410d("MicroMsg.CollectMainUI", "Recieve but time out ");
                AppMethodBeat.m2505o(41298);
                return;
            }
            Object obj2;
            int i = 0;
            while (i < this.kGH.size()) {
                if (c27680t.status == 0 && C5046bo.nullAsNil(c27680t.username).equals(((C31348a) this.kGH.get(i)).username) && ((C31348a) this.kGH.get(i)).status == 2) {
                    this.kGH.remove(i);
                    this.kGH.add(i, new C31348a(c27680t));
                    obj2 = 1;
                    break;
                } else if (c27680t.cAa.equals(((C31348a) this.kGH.get(i)).cAa)) {
                    C4990ab.m7418v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + c27680t.cAa);
                    if (((C31348a) this.kGH.get(i)).status == 0) {
                        ((C31348a) this.kGH.get(i)).status = c27680t.status;
                        ((C31348a) this.kGH.get(i)).kCJ = c27680t.kCJ;
                        ((C31348a) this.kGH.get(i)).cuZ = c27680t.cuZ;
                        if (c27680t.status == 1) {
                            C31348a c31348a = (C31348a) this.kGH.get(i);
                            this.kGP.kHx.add(c31348a);
                        }
                    }
                    int obj22 = 1;
                } else {
                    i++;
                }
            }
            obj22 = null;
            if (obj22 == null) {
                for (i = 0; i < this.kGH.size(); i++) {
                    if (c27680t.timestamp > ((C27680t) this.kGH.get(i)).timestamp) {
                        this.kGH.add(i, new C31348a(c27680t));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    this.kGH.add(new C31348a(c27680t));
                }
            }
            C5004al.m7441d(new C202844());
        }
        AppMethodBeat.m2505o(41298);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41299);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4096:
                if (i2 != -1 || intent == null) {
                    this.kGL = false;
                } else {
                    this.kGG = intent.getStringExtra("ftf_pay_url");
                    this.kGI = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.kGJ = intent.getStringExtra("ftf_fixed_fee_type");
                    this.kGK = intent.getStringExtra("ftf_fixed_desc");
                    this.kGF = intent.getStringExtra("key_currency_unit");
                    this.kGz.setText(this.kGR);
                    this.kGL = true;
                }
                refreshView();
                bhu();
                AppMethodBeat.m2505o(41299);
                return;
            case 4097:
                this.kFU = C1853r.m3823YE();
                break;
        }
        AppMethodBeat.m2505o(41299);
    }

    public void onResume() {
        AppMethodBeat.m2504i(41300);
        super.onResume();
        C30292bc.m48192a(this, this);
        AppMethodBeat.m2505o(41300);
    }

    public void onPause() {
        AppMethodBeat.m2504i(41301);
        super.onPause();
        C30292bc.m48192a(this, null);
        AppMethodBeat.m2505o(41301);
    }

    public final void aNW() {
        AppMethodBeat.m2504i(41302);
        C4990ab.m7416i("MicroMsg.CollectMainUI", "do screen shot");
        C7060h.pYm.mo8381e(13944, Integer.valueOf(9));
        if (this.kHd) {
            C4990ab.m7416i("MicroMsg.CollectMainUI", "onScreenShot() realNameVerifying == true ");
            AppMethodBeat.m2505o(41302);
        } else if (this.kHe == 1) {
            C5659a c5659a = new C5659a(this.mController.ylL);
            C5659a asL = c5659a.asL(getString(C25738R.string.aso));
            asL.vkm.zQe.zOU = true;
            asL.zQL = true;
            asL.zQK = getString(C25738R.string.ask);
            asL.zQJ = getString(C25738R.string.asn);
            asL.mo11510Qh(getResources().getColor(C25738R.color.f12212w4)).mo11526re(true).mo11513a(new C276966(), new C428997());
            c5659a.show();
            AppMethodBeat.m2505o(41302);
        } else {
            C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ash), "", getString(C25738R.string.asg), getString(C25738R.string.f9076or), false, new C429008(), new C388189());
            AppMethodBeat.m2505o(41302);
        }
    }

    public void finish() {
        AppMethodBeat.m2504i(41303);
        super.finish();
        overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
        AppMethodBeat.m2505o(41303);
    }

    private void bhw() {
        AppMethodBeat.m2504i(41304);
        C15319aw cPy = C22594k.cPy();
        int i = this.kGL ? 33 : 32;
        if (cPy != null) {
            C7060h.pYm.mo8381e(13447, Integer.valueOf(i), cPy.vCF, cPy.vCG, this.kGD, Double.valueOf(this.kGI), Long.valueOf(C5046bo.anT()), Long.valueOf(cPy.vCE), cPy.vCH, cPy.vCI);
        }
        AppMethodBeat.m2505o(41304);
    }

    private static bbc bhx() {
        AppMethodBeat.m2504i(41306);
        try {
            C1720g.m3537RQ();
            bbc Q = CollectMainUI.m81473Q(new JSONObject((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, (Object) "")));
            AppMethodBeat.m2505o(41306);
            return Q;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(41306);
            return null;
        }
    }

    private static List<bbc> bhy() {
        AppMethodBeat.m2504i(41307);
        ArrayList arrayList = new ArrayList();
        try {
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, (Object) "");
            if (!C5046bo.isNullOrNil(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(CollectMainUI.m81473Q(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(41307);
        return arrayList;
    }

    /* renamed from: Q */
    private static bbc m81473Q(JSONObject jSONObject) {
        AppMethodBeat.m2504i(41308);
        bbc bbc = new bbc();
        bbc.type = jSONObject.optInt("type", -1);
        bbc.url = jSONObject.optString("url", "");
        bbc.cEh = jSONObject.optString("wording", "");
        bbc.wFS = jSONObject.optString("waapp_username", "");
        bbc.wFT = jSONObject.optString("waapp_path", "");
        AppMethodBeat.m2505o(41308);
        return bbc;
    }

    /* Access modifiers changed, original: protected */
    public String bhp() {
        AppMethodBeat.m2504i(41309);
        if (C5046bo.isNullOrNil(this.kGE)) {
            this.kGE = C14241r.cPI().bhp();
            this.kGE = C36391e.att(this.kGE);
        }
        String str = this.kGE;
        AppMethodBeat.m2505o(41309);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public String bhq() {
        AppMethodBeat.m2504i(41310);
        String atq = C36391e.atq(this.kGJ);
        AppMethodBeat.m2505o(41310);
        return atq;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: bq */
    public final void mo71803bq(final List<bbc> list) {
        AppMethodBeat.m2504i(41311);
        if (list != null) {
            for (bbc bbc : list) {
                if (bbc.type == 1) {
                    C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(1), bbc.cEh, "", "", "", Integer.valueOf(1));
                } else if (bbc.type == 2) {
                    C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(2), bbc.cEh, "", "", bbc.url, Integer.valueOf(1));
                } else if (bbc.type == 3) {
                    C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(3), bbc.cEh, bbc.wFS, bbc.wFT, "", Integer.valueOf(1));
                }
            }
        }
        this.kGB.setOnClickListener(new View.OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$13$1 */
            class C338801 implements C36073c {
                C338801() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(41265);
                    C45815a.bgv();
                    if (C45815a.bgx()) {
                        c44273l.add(0, 1, 0, (int) C25738R.string.arv);
                    } else {
                        c44273l.add(0, 1, 0, (int) C25738R.string.as5);
                    }
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            bbc bbc = (bbc) list.get(i);
                            if (!C5046bo.isNullOrNil(bbc.cEh)) {
                                c44273l.add(0, (i + 1) + 1, 0, bbc.cEh);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(41265);
                }
            }

            /* renamed from: com.tencent.mm.plugin.collect.ui.CollectMainUI$13$2 */
            class C338812 implements C5279d {
                C338812() {
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(41266);
                    switch (menuItem.getItemId()) {
                        case 1:
                            C45815a.bgv();
                            if (C45815a.bgx()) {
                                CollectMainUI.m81508x(CollectMainUI.this);
                                Toast.makeText(CollectMainUI.this.mController.ylL, C25738R.string.arw, 1).show();
                                C7060h.pYm.mo8381e(13944, Integer.valueOf(8));
                                AppMethodBeat.m2505o(41266);
                                return;
                            }
                            CollectMainUI.m81509y(CollectMainUI.this);
                            Toast.makeText(CollectMainUI.this.mController.ylL, C25738R.string.as6, 1).show();
                            C45818a.bgJ().bgK();
                            C7060h.pYm.mo8381e(13944, Integer.valueOf(7));
                            AppMethodBeat.m2505o(41266);
                            return;
                        default:
                            int itemId = (menuItem.getItemId() - 1) - 1;
                            if (itemId < 0) {
                                C4990ab.m7421w("MicroMsg.CollectMainUI", "illegal pos: %s", Integer.valueOf(itemId));
                                AppMethodBeat.m2505o(41266);
                                return;
                            }
                            bbc bbc = (bbc) list.get(itemId);
                            if (bbc.type == 1) {
                                C4990ab.m7421w("MicroMsg.CollectMainUI", "wrong native type: %s", bbc.url);
                                C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(1), bbc.cEh, "", "", "", Integer.valueOf(2));
                                AppMethodBeat.m2505o(41266);
                                return;
                            }
                            if (bbc.type == 2) {
                                if (!C5046bo.isNullOrNil(bbc.url)) {
                                    C36391e.m60016n(CollectMainUI.this.mController.ylL, bbc.url, false);
                                    C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(2), bbc.cEh, "", "", bbc.url, Integer.valueOf(2));
                                    AppMethodBeat.m2505o(41266);
                                    return;
                                }
                            } else if (bbc.type == 3) {
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = bbc.wFS;
                                c32628se.cOf.cOh = C5046bo.m7532bc(bbc.wFT, "");
                                c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_MUDAN;
                                c32628se.cOf.cOi = 0;
                                C4879a.xxA.mo10055m(c32628se);
                                C7060h.pYm.mo8381e(14526, Integer.valueOf(2), Integer.valueOf(3), bbc.cEh, bbc.wFS, bbc.wFT, "", Integer.valueOf(2));
                            }
                            AppMethodBeat.m2505o(41266);
                            return;
                    }
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(41267);
                C36356d c36356d = new C36356d(CollectMainUI.this.mController.ylL, 1, false);
                c36356d.rBl = new C338801();
                c36356d.rBm = new C338812();
                c36356d.cpD();
                AppMethodBeat.m2505o(41267);
            }
        });
        AppMethodBeat.m2505o(41311);
    }

    /* Access modifiers changed, original: protected */
    public void bhr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41288);
        this.yll = true;
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        mo17426pO(true);
        dyb();
        C1720g.m3537RQ();
        this.cQG = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        this.kFU = C1853r.m3823YE();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        C7060h.pYm.mo8381e(14021, Integer.valueOf(2), Integer.valueOf(intExtra));
        overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
        C45815a.bgv();
        C27676d bgw = C45815a.bgw();
        if (!bgw.kaD.contains(this)) {
            bgw.kaD.add(this);
        }
        initView();
        bho();
        refreshView();
        this.iVt = (Vibrator) getSystemService("vibrator");
        this.kGM = C5046bo.anT();
        if (kHh < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            kHh = (displayMetrics.widthPixels / 2) - C4977b.m7371b(this.mController.ylL, 20.0f);
            kHi = C4977b.m7371b(this.mController.ylL, 60.0f);
            kHj = C4977b.m7371b(this.mController.ylL, 40.0f);
            kHk = C4977b.m7371b(this.mController.ylL, 70.0f);
        }
        bhu();
        C36381z.m59954hL(16, 0);
        AppMethodBeat.m2505o(41288);
    }

    /* Access modifiers changed, original: protected */
    public void bho() {
        AppMethodBeat.m2504i(41305);
        if (C33855f.kBJ == null) {
            C33855f.kBJ = new C33855f();
        }
        this.kGS = C33855f.kBJ;
        C1202f c1202f = this.kGS;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1588, c1202f);
        C33855f c33855f = this.kGS;
        C2028010 c2028010 = new C2028010();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, (Object) "");
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = C14241r.cPI().cQn();
        }
        c2028010.mo23167dz(str, str2);
        C1207m c6830l = new C6830l();
        c33855f.jxd.put(c6830l, c2028010);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c6830l, 0);
        AppMethodBeat.m2505o(41305);
    }

    /* renamed from: dB */
    static /* synthetic */ void m81486dB(String str, String str2) {
        AppMethodBeat.m2504i(41313);
        if (!C5046bo.isNullOrNil(str)) {
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = str;
            c32628se.cOf.cOh = C5046bo.m7532bc(str2, "");
            c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_MUDAN;
            c32628se.cOf.cOi = 0;
            C4879a.xxA.mo10055m(c32628se);
        }
        AppMethodBeat.m2505o(41313);
    }

    /* renamed from: e */
    static /* synthetic */ void m81487e(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41314);
        collectMainUI.m81489fX(true);
        AppMethodBeat.m2505o(41314);
    }

    /* renamed from: v */
    static /* synthetic */ void m81506v(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41320);
        C1720g.m3537RQ();
        if (((String) C1720g.m3536RP().mo5239Ry().get(327731, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            int i;
            Context context = collectMainUI.mController.ylL;
            if (C1853r.m3831YM()) {
                i = C25738R.string.ary;
            } else {
                i = C25738R.string.arx;
            }
            C30379h.m48431a(context, i, (int) C25738R.string.arz, new C447281());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(327731, (Object) "1");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().dsb();
        }
        AppMethodBeat.m2505o(41320);
    }

    /* renamed from: x */
    static /* synthetic */ void m81508x(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41321);
        collectMainUI.kFU &= -32769;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(collectMainUI.kFU));
        bci bci = new bci();
        bci.pXD = 2;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(209, bci));
        C45815a.bgv().bgz();
        AppMethodBeat.m2505o(41321);
    }

    /* renamed from: y */
    static /* synthetic */ void m81509y(CollectMainUI collectMainUI) {
        AppMethodBeat.m2504i(41322);
        collectMainUI.kFU |= 32768;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(collectMainUI.kFU));
        bci bci = new bci();
        bci.pXD = 1;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(209, bci));
        C45815a.bgv().bgy();
        AppMethodBeat.m2505o(41322);
    }
}
