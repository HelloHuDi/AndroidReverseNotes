package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18665g;
import com.tencent.p177mm.p1528bb.C37508a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.p1094i.C15898a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15905c;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15906a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15907b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C46035e;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34373g;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C43223b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C35852b;
import com.tencent.p177mm.protocal.protobuf.aqq;
import com.tencent.p177mm.protocal.protobuf.csc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI */
public class IPCallShareCouponCardUI extends MMActivity implements C1202f, C15906a, C15907b {
    private String eeO = null;
    private ProgressDialog ehJ = null;
    private int mFrom = 0;
    private String mTitle = null;
    private ProgressDialog nBv = null;
    private TextView nED;
    private TextView nEE;
    private TextView nEF;
    private TextView nEG;
    private Button nEH;
    private ImageView nEI;
    private C15898a nEJ = new C15898a();
    private ProgressDialog nEK = null;
    private C43232i nEL = null;
    private ImageView nEM = null;
    private ProgressBar nEN = null;
    private C46035e nEO = new C46035e();
    private String nEP = null;
    private String nEQ = null;
    private String nER = null;
    private String nES = null;
    private String nET = null;
    private String nEU = null;
    private String nEV = null;
    private String nEW = null;
    private String nEX = null;
    private csc nEY = null;
    private String nEZ = null;
    private View nFa;
    /* renamed from: qQ */
    private View f17896qQ;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$9 */
    class C33179 implements OnCancelListener {
        C33179() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22291);
            try {
                IPCallShareCouponCardUI.this.finish();
                AppMethodBeat.m2505o(22291);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", e.getMessage());
                AppMethodBeat.m2505o(22291);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$10 */
    class C1229210 implements OnClickListener {
        C1229210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22292);
            IPCallShareCouponCardUI.this.finish();
            AppMethodBeat.m2505o(22292);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$16 */
    class C1229316 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$16$1 */
        class C122941 implements OnCancelListener {
            C122941() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C1229316() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22296);
            IPCallShareCouponCardUI iPCallShareCouponCardUI = IPCallShareCouponCardUI.this;
            Context context = IPCallShareCouponCardUI.this.mController.ylL;
            IPCallShareCouponCardUI.this.mController.ylL.getString(C25738R.string.f9238tz);
            iPCallShareCouponCardUI.nEK = C30379h.m48458b(context, IPCallShareCouponCardUI.this.mController.ylL.getString(C25738R.string.ey0), true, new C122941());
            IPCallShareCouponCardUI.this.nEJ.mo28144a(IPCallShareCouponCardUI.this, IPCallShareCouponCardUI.this.mController.ylL);
            AppMethodBeat.m2505o(22296);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$3 */
    class C122953 implements OnClickListener {
        C122953() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22284);
            C25985d.m41467b(IPCallShareCouponCardUI.this.mController.ylL, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.m2505o(22284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$4 */
    class C122964 implements OnClickListener {
        C122964() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$1 */
    class C211261 implements OnMenuItemClickListener {
        C211261() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22283);
            IPCallShareCouponCardUI.this.finish();
            AppMethodBeat.m2505o(22283);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$15 */
    class C2834615 implements OnClickListener {
        C2834615() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$2 */
    class C283472 implements OnClickListener {
        C283472() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$11 */
    class C3438911 implements View.OnClickListener {
        C3438911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22293);
            IPCallShareCouponCardUI.m85654a(IPCallShareCouponCardUI.this);
            AppMethodBeat.m2505o(22293);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$12 */
    class C3926712 implements C36073c {
        C3926712() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(22294);
            Iterator it = IPCallShareCouponCardUI.m85652a(IPCallShareCouponCardUI.this, IPCallShareCouponCardUI.this.nEY.xpz).iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                CharSequence Q = IPCallShareCouponCardUI.m85650Q(IPCallShareCouponCardUI.this.mController.ylL, num.intValue());
                int xu = IPCallShareCouponCardUI.m85665xu(num.intValue());
                if (!(Q == null || xu == -1)) {
                    c44273l.mo70049a(num.intValue(), Q, xu);
                }
            }
            AppMethodBeat.m2505o(22294);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$14 */
    class C3926814 implements OnClickListener {
        C3926814() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$13 */
    class C4604213 implements C5279d {
        C4604213() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(22295);
            IPCallShareCouponCardUI.m85655a(IPCallShareCouponCardUI.this, menuItem.getItemId());
            AppMethodBeat.m2505o(22295);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public IPCallShareCouponCardUI() {
        AppMethodBeat.m2504i(22297);
        AppMethodBeat.m2505o(22297);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22298);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cjq);
        setBackBtn(new C211261());
        this.f17896qQ = findViewById(2131824244);
        this.nED = (TextView) findViewById(2131825044);
        this.nEE = (TextView) findViewById(2131825045);
        this.nEF = (TextView) findViewById(2131825047);
        this.nEG = (TextView) findViewById(2131825048);
        this.nEH = (Button) findViewById(2131825049);
        this.nEI = (ImageView) findViewById(2131821043);
        this.f17896qQ.setVisibility(8);
        C40460b.m69433a(this.nEI, C1853r.m3846Yz(), 0.5f, false);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.nBv = C30379h.m48458b(context, getString(C25738R.string.ch0), true, new C33179());
        C43223b.bHU().mo68730it(false);
        this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1804, (C1202f) this);
        AppMethodBeat.m2505o(22298);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22299);
        super.onResume();
        AppMethodBeat.m2505o(22299);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22300);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_TOKYO, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1804, (C1202f) this);
        AppMethodBeat.m2505o(22300);
    }

    public final int getLayoutId() {
        return 2130969886;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22301);
        if (c1207m instanceof C34373g) {
            if (i == 0 && i2 == 0) {
                this.f17896qQ.setVisibility(0);
                aqq bIU = C34382c.bIU();
                if (bIU != null) {
                    this.nEP = bIU.wut;
                    this.eeO = bIU.Desc;
                    this.nEQ = bIU.wuu;
                    this.mTitle = bIU.Title;
                    this.nER = bIU.nzz;
                    this.nES = bIU.wuv;
                    this.nEU = bIU.wuw;
                    this.nEV = bIU.wux;
                    this.nEW = bIU.wuy;
                    this.nEX = bIU.wuA;
                    this.nEY = bIU.wuz;
                    this.nEZ = bIU.wuB;
                }
                this.nED.setText(this.nEX);
                this.nEE.setText(String.format(this.mController.ylL.getString(C25738R.string.cjj), new Object[]{this.nEP}));
                this.nEH.setOnClickListener(new C3438911());
                this.nEF.setText(String.format(getString(C25738R.string.cjl), new Object[]{this.nEX}));
                TextView textView = this.nEG;
                String format = String.format(getString(C25738R.string.cjk), new Object[]{this.nEX});
                final String string = getString(C25738R.string.cjp);
                if (C5046bo.isNullOrNil(string)) {
                    textView.setText(format);
                } else {
                    String concat;
                    String string2 = getString(C25738R.string.cjs);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int gd = C1338a.m2868gd(this.mController.ylL) - (((LayoutParams) textView.getLayoutParams()).rightMargin + ((LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) gd)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) gd)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        concat = IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(string2));
                    } else {
                        concat = string2;
                    }
                    textView.setGravity(17);
                    Spannable newSpannable = Factory.getInstance().newSpannable(format + concat);
                    newSpannable.setSpan(new ClickableSpan() {

                        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI$6$1 */
                        class C343901 implements OnClickListener {
                            C343901() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(22287);
                            ((TextView) view).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(C25738R.color.a3p));
                            C7060h.pYm.mo8381e(13340, Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1));
                            C30379h.m48461b(IPCallShareCouponCardUI.this.mController.ylL, string, IPCallShareCouponCardUI.this.getString(C25738R.string.cjt), true).mo11487a((int) C25738R.string.cgc, new C343901());
                            AppMethodBeat.m2505o(22287);
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.m2504i(22288);
                            textPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(C25738R.color.f12123t7));
                            textPaint.setUnderlineText(false);
                            AppMethodBeat.m2505o(22288);
                        }
                    }, format.length(), concat.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.nBv != null && this.nBv.isShowing()) {
                    this.nBv.dismiss();
                }
                AppMethodBeat.m2505o(22301);
                return;
            } else if (this.nBv != null && this.nBv.isShowing()) {
                this.nBv.dismiss();
                C30379h.m48438a(this.mController.ylL, getString(C25738R.string.cgy), getString(C25738R.string.cgr), new C1229210());
                AppMethodBeat.m2505o(22301);
                return;
            }
        } else if (c1207m instanceof C18665g) {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (C24837b.gkF.mo38861b(this.mController.ylL, i, i2, str)) {
                AppMethodBeat.m2505o(22301);
                return;
            } else if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.ate));
                AppMethodBeat.m2505o(22301);
                return;
            } else {
                C30379h.m48467g(this.mController.ylL, C25738R.string.e3n, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(22301);
                return;
            }
        } else if (c1207m instanceof C37508a) {
            if (i != 0 || i2 != 0) {
                AppMethodBeat.m2505o(22301);
                return;
            } else if (this.nEM != null) {
                if (this.nEN != null) {
                    this.nEN.setVisibility(8);
                }
                this.nEM.setImageBitmap(IPCallShareCouponCardUI.bIu());
            }
        }
        AppMethodBeat.m2505o(22301);
    }

    /* renamed from: a */
    public static void m85653a(Context context, int i, TextView textView, ImageView imageView) {
        AppMethodBeat.m2504i(22302);
        String Q = IPCallShareCouponCardUI.m85650Q(context, i);
        if (Q != null) {
            textView.setText(Q);
        }
        int xu = IPCallShareCouponCardUI.m85665xu(i);
        if (xu != -1) {
            imageView.setImageResource(xu);
        }
        AppMethodBeat.m2505o(22302);
    }

    /* renamed from: Q */
    public static String m85650Q(Context context, int i) {
        AppMethodBeat.m2504i(22303);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), context.getString(C25738R.string.chr));
        hashMap.put(Integer.valueOf(0), context.getString(C25738R.string.g0j));
        hashMap.put(Integer.valueOf(1), context.getString(C25738R.string.chw));
        hashMap.put(Integer.valueOf(3), context.getString(C25738R.string.chs));
        hashMap.put(Integer.valueOf(2), context.getString(C25738R.string.chv));
        hashMap.put(Integer.valueOf(5), context.getString(C25738R.string.chx));
        hashMap.put(Integer.valueOf(4), context.getString(C25738R.string.chy));
        hashMap.put(Integer.valueOf(6), context.getString(C25738R.string.chu));
        hashMap.put(Integer.valueOf(7), context.getString(C25738R.string.cht));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            String str = (String) hashMap.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(22303);
            return str;
        }
        AppMethodBeat.m2505o(22303);
        return null;
    }

    /* renamed from: xu */
    public static int m85665xu(int i) {
        AppMethodBeat.m2504i(22304);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(8), Integer.valueOf(C1318a.bottomsheet_copy));
        hashMap.put(Integer.valueOf(0), Integer.valueOf(C1318a.bottomsheet_repost));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(C1318a.bottomsheet_moment));
        hashMap.put(Integer.valueOf(3), Integer.valueOf(C1318a.bottomsheet_email));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(C1318a.bottomsheet_sms));
        hashMap.put(Integer.valueOf(5), Integer.valueOf(C1318a.bottomsheet_twitter));
        hashMap.put(Integer.valueOf(4), Integer.valueOf(C1318a.bottomsheet_whatsapp));
        hashMap.put(Integer.valueOf(6), Integer.valueOf(C1318a.bottomsheet_facebook));
        hashMap.put(Integer.valueOf(7), Integer.valueOf(C1318a.bottomsheet_messenger));
        if (hashMap.containsKey(Integer.valueOf(i))) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i))).intValue();
            AppMethodBeat.m2505o(22304);
            return intValue;
        }
        AppMethodBeat.m2505o(22304);
        return -1;
    }

    /* renamed from: aD */
    private static boolean m85656aD(Context context, String str) {
        AppMethodBeat.m2504i(22305);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(22305);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            AppMethodBeat.m2505o(22305);
            return true;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(22305);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo28157a(C15905c c15905c) {
        AppMethodBeat.m2504i(22306);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (c15905c) {
            case Finished:
                m85666xv(C25738R.string.ey2);
                AppMethodBeat.m2505o(22306);
                return;
            case Canceled:
                AppMethodBeat.m2505o(22306);
                return;
            case Failed:
                m85666xv(C25738R.string.ey1);
                break;
        }
        AppMethodBeat.m2505o(22306);
    }

    /* renamed from: b */
    public final void mo28156b(C15905c c15905c) {
    }

    private static Bitmap bIu() {
        AppMethodBeat.m2504i(22308);
        byte[] Pj = IPCallShareCouponCardUI.m85649Pj(C1853r.m3846Yz());
        if (Pj == null) {
            AppMethodBeat.m2505o(22308);
            return null;
        }
        Bitmap bQ = C5056d.m7652bQ(Pj);
        AppMethodBeat.m2505o(22308);
        return bQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063 A:{SYNTHETIC, Splitter:B:15:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A:{SYNTHETIC, Splitter:B:21:0x006e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Pj */
    private static byte[] m85649Pj(String str) {
        Throwable e;
        AppMethodBeat.m2504i(22309);
        C9638aw.m17190ZK();
        String XW = C18628c.m29088XW();
        C9638aw.m17190ZK();
        XW = C15428j.m23711g(XW, C18628c.m29089XX(), "qr_", C1178g.m2591x(str.getBytes()), ".png");
        if (C5046bo.isNullOrNil(XW)) {
            C4990ab.m7412e("MicroMsg.IPCallShareCouponCardUI", "filename is null");
            AppMethodBeat.m2505o(22309);
            return null;
        }
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(XW, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(22309);
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(22309);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(22309);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            C4990ab.printErrStackTrace("MicroMsg.IPCallShareCouponCardUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.m2505o(22309);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(22309);
            throw e;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22311);
        if (i == 1 && intent != null) {
            final String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                C35844g.m58765a(this.mController, this.mTitle, this.nEQ, this.eeO, true, getResources().getString(C25738R.string.f9221tf), new C30111a() {
                    /* renamed from: a */
                    public final void mo6399a(boolean z, String str, int i) {
                        AppMethodBeat.m2504i(22289);
                        if (z) {
                            C8910b c8910b = new C8910b();
                            c8910b.title = IPCallShareCouponCardUI.this.mTitle;
                            c8910b.url = IPCallShareCouponCardUI.this.nES;
                            c8910b.description = IPCallShareCouponCardUI.this.eeO;
                            c8910b.thumburl = IPCallShareCouponCardUI.this.nEQ;
                            c8910b.type = 5;
                            C4733l.m7088a(c8910b, null, null, stringExtra, "", null, null);
                            if (!C5046bo.isNullOrNil(str)) {
                                C18372qb c18372qb = new C18372qb();
                                c18372qb.cMq.cMr = stringExtra;
                                c18372qb.cMq.content = str;
                                c18372qb.cMq.type = C1855t.m3925nK(stringExtra);
                                c18372qb.cMq.flags = 0;
                                C4879a.xxA.mo10055m(c18372qb);
                            }
                            C30379h.m48465bQ(IPCallShareCouponCardUI.this.mController.ylL, IPCallShareCouponCardUI.this.getResources().getString(C25738R.string.f9229to));
                            AppMethodBeat.m2505o(22289);
                            return;
                        }
                        AppMethodBeat.m2505o(22289);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(22311);
    }

    /* renamed from: xv */
    private void m85666xv(int i) {
        AppMethodBeat.m2504i(22307);
        C30379h.m48432a(this.mController.ylL, i, (int) C25738R.string.f9238tz, new C3926814(), new C2834615());
        AppMethodBeat.m2505o(22307);
    }

    /* renamed from: w */
    private void m85664w(final int i, final String str, String str2) {
        AppMethodBeat.m2504i(22310);
        this.nFa = View.inflate(this.mController.ylL, 2130969183, null);
        final EditText editText = (EditText) this.nFa.findViewById(2131822921);
        this.nEM = (ImageView) this.nFa.findViewById(2131822920);
        this.nEN = (ProgressBar) this.nFa.findViewById(2131821605);
        editText.setText(str);
        Bitmap bIu = IPCallShareCouponCardUI.bIu();
        if (bIu == null) {
            String Yz = C1853r.m3846Yz();
            C9638aw.m17190ZK();
            C9638aw.m17182Rg().mo14541a(new C37508a(Yz, C5046bo.m7567h((Integer) C18628c.m29072Ry().get(66561, null))), 0);
            this.nEN.setVisibility(0);
        } else if (this.nEM != null) {
            this.nEM.setImageBitmap(bIu);
        }
        C35844g.m58763a(this.mController, str2, this.nFa, getResources().getString(C25738R.string.f9221tf), new C35852b() {
            /* renamed from: iw */
            public final void mo26134iw(boolean z) {
                AppMethodBeat.m2504i(22286);
                if (z) {
                    String str;
                    if (editText == null) {
                        str = str;
                    } else {
                        str = editText.getText().toString();
                    }
                    final C1207m c18665g = new C18665g(i, str);
                    IPCallShareCouponCardUI iPCallShareCouponCardUI = IPCallShareCouponCardUI.this;
                    Context context = IPCallShareCouponCardUI.this;
                    IPCallShareCouponCardUI.this.getString(C25738R.string.f9238tz);
                    iPCallShareCouponCardUI.ehJ = C30379h.m48458b(context, IPCallShareCouponCardUI.this.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(22285);
                            C9638aw.m17182Rg().mo14547c(c18665g);
                            AppMethodBeat.m2505o(22285);
                        }
                    });
                    C9638aw.m17182Rg().mo14541a(c18665g, 0);
                    AppMethodBeat.m2505o(22286);
                    return;
                }
                AppMethodBeat.m2505o(22286);
            }
        });
        AppMethodBeat.m2505o(22310);
    }
}
