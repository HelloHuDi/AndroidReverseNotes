package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p492b.C43434l;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46510q;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI */
public class RecordMsgFileUI extends MMActivity implements C43427d {
    private aar cAv;
    private String cHr;
    private long cvx;
    private C7306ak fbD;
    private TextView gxi;
    private TextView iqU;
    private C14979e klq = null;
    private Button mlD;
    private Button mlE;
    private Button mlF;
    private MMImageView mlG;
    private TextView mlH;
    private View mlI;
    private View mlJ;
    private boolean mlN = false;
    private boolean mlR = false;
    private boolean mlS = false;
    private C43434l pKH;
    private ProgressBar progressBar;

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$10 */
    class C1299710 implements OnClickListener {
        C1299710() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24262);
            RecordMsgFileUI.m20969g(RecordMsgFileUI.this);
            AppMethodBeat.m2505o(24262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$6 */
    class C129986 implements Runnable {
        C129986() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24258);
            RecordMsgFileUI.m20969g(RecordMsgFileUI.this);
            C30379h.m48465bQ(RecordMsgFileUI.this.mController.ylL, RecordMsgFileUI.this.getString(C25738R.string.b6p));
            AppMethodBeat.m2505o(24258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$7 */
    class C129997 implements OnClickListener {
        C129997() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24259);
            String c = C43436n.m77558c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
            new Intent().setAction("android.intent.action.VIEW");
            if (4 == RecordMsgFileUI.m20964c(RecordMsgFileUI.this)) {
                RecordMsgFileUI.this.mlR = false;
                RecordMsgFileUI.m20967e(RecordMsgFileUI.this);
                AppMethodBeat.m2505o(24259);
                return;
            }
            RecordMsgFileUI.m20962a(RecordMsgFileUI.this, c);
            AppMethodBeat.m2505o(24259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$11 */
    class C1300111 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$11$1 */
        class C129961 implements C36073c {
            C129961() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(24263);
                c44273l.mo70068e(0, RecordMsgFileUI.this.getString(C25738R.string.bri));
                AppMethodBeat.m2505o(24263);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$11$2 */
        class C130022 implements C5279d {
            C130022() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(24264);
                switch (menuItem.getItemId()) {
                    case 0:
                        if (RecordMsgFileUI.m20964c(RecordMsgFileUI.this) == 8) {
                            String c = C43436n.m77558c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                            if (!C1173e.m2561ct(c)) {
                                C4990ab.m7412e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(C25738R.string.brg), 1).show();
                                AppMethodBeat.m2505o(24264);
                                return;
                            } else if (new File(c).length() > 10485760) {
                                C4990ab.m7412e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(C25738R.string.brh), 1).show();
                                AppMethodBeat.m2505o(24264);
                                return;
                            }
                        }
                        RecordMsgFileUI.m20970h(RecordMsgFileUI.this);
                        break;
                }
                AppMethodBeat.m2505o(24264);
            }
        }

        C1300111() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24265);
            C36356d c36356d = new C36356d(RecordMsgFileUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C129961();
            c36356d.rBm = new C130022();
            c36356d.cpD();
            AppMethodBeat.m2505o(24265);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$12 */
    class C1300312 implements C14981a {
        C1300312() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(24267);
            C4990ab.m7410d("MicroMsg.RecordMsgFileUI", C1447g.m3074Mp() + " onPrepared");
            RecordMsgFileUI.this.klq.setLoop(true);
            RecordMsgFileUI.this.klq.start();
            AppMethodBeat.m2505o(24267);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(24268);
            RecordMsgFileUI.this.klq.stop();
            if (RecordMsgFileUI.this.mlN) {
                AppMethodBeat.m2505o(24268);
                return;
            }
            RecordMsgFileUI.this.mlN = true;
            final Bitmap b = RecordMsgFileUI.this.pKH.mo68993b(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
            final String videoPath = RecordMsgFileUI.this.klq.getVideoPath();
            C4872b.m7233A(Base64.encodeToString((C21846d.ckW() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + C5046bo.m7532bc(videoPath, "")).getBytes(), 2), "FullScreenPlaySight");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24266);
                    ImageView imageView = (ImageView) RecordMsgFileUI.this.findViewById(2131823993);
                    imageView.setImageBitmap(b);
                    imageView.setVisibility(0);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23713a(RecordMsgFileUI.this.mController.ylL, intent, new File(videoPath), "video/*");
                    try {
                        RecordMsgFileUI.this.startActivity(Intent.createChooser(intent, RecordMsgFileUI.this.getString(C25738R.string.bs9)));
                        AppMethodBeat.m2505o(24266);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                        C30379h.m48467g(RecordMsgFileUI.this.mController.ylL, C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(24266);
                    }
                }
            });
            AppMethodBeat.m2505o(24268);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$9 */
    class C130059 implements OnClickListener {
        C130059() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24261);
            if (C1445f.m3070Mn()) {
                C43436n.m77557b(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx, true);
                RecordMsgFileUI.m20968f(RecordMsgFileUI.this);
                AppMethodBeat.m2505o(24261);
                return;
            }
            C30379h.m48467g(RecordMsgFileUI.this.mController.ylL, C25738R.string.bpt, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(24261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$1 */
    class C130081 implements OnMenuItemClickListener {
        C130081() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24252);
            RecordMsgFileUI.this.finish();
            AppMethodBeat.m2505o(24252);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$5 */
    class C130105 implements Runnable {
        C130105() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24257);
            RecordMsgFileUI.m20979q(RecordMsgFileUI.this);
            AppMethodBeat.m2505o(24257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgFileUI$4 */
    class C130124 implements Runnable {
        C130124() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24256);
            RecordMsgFileUI.this.enableOptionMenu(true);
            RecordMsgFileUI.m20978p(RecordMsgFileUI.this);
            AppMethodBeat.m2505o(24256);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m20967e(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24286);
        recordMsgFileUI.bnS();
        AppMethodBeat.m2505o(24286);
    }

    /* renamed from: f */
    static /* synthetic */ void m20968f(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24288);
        recordMsgFileUI.bwi();
        AppMethodBeat.m2505o(24288);
    }

    /* renamed from: g */
    static /* synthetic */ void m20969g(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24289);
        recordMsgFileUI.bwj();
        AppMethodBeat.m2505o(24289);
    }

    /* renamed from: m */
    static /* synthetic */ String m20975m(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24291);
        String ceR = recordMsgFileUI.ceR();
        AppMethodBeat.m2505o(24291);
        return ceR;
    }

    /* renamed from: p */
    static /* synthetic */ void m20978p(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24292);
        recordMsgFileUI.bwl();
        AppMethodBeat.m2505o(24292);
    }

    /* renamed from: q */
    static /* synthetic */ void m20979q(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.m2504i(24293);
        recordMsgFileUI.bwh();
        AppMethodBeat.m2505o(24293);
    }

    public final int getLayoutId() {
        return 2130969546;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24272);
        super.onCreate(bundle);
        this.fbD = new C7306ak();
        this.pKH = new C43434l();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        C44099c VI = C43436n.m77547VI(getIntent().getStringExtra("record_xml"));
        if (VI == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.m2505o(24272);
            return;
        }
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(stringExtra)) {
                this.cAv = aar;
            }
        }
        if (this.cAv == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            AppMethodBeat.m2505o(24272);
            return;
        }
        this.cHr = C43436n.m77564h(this.cAv.mnd, this.cvx, true);
        this.mlD = (Button) findViewById(2131823997);
        this.mlE = (Button) findViewById(2131823998);
        this.mlF = (Button) findViewById(2131822658);
        this.mlG = (MMImageView) findViewById(2131821226);
        this.gxi = (TextView) findViewById(2131821227);
        this.iqU = (TextView) findViewById(2131823800);
        this.mlJ = findViewById(2131821526);
        this.mlI = findViewById(2131821524);
        this.progressBar = (ProgressBar) findViewById(2131821525);
        this.mlH = (TextView) findViewById(2131823996);
        if (4 == getType()) {
            setMMTitle((int) C25738R.string.bs9);
        } else if (15 == getType()) {
            setMMTitle((int) C25738R.string.brj);
            findViewById(2131823992).setBackgroundResource(C25738R.color.f11782h4);
        } else {
            setMMTitle((int) C25738R.string.bp0);
        }
        if (getType() == 4) {
            this.mlG.setImageResource(C1318a.app_attach_file_icon_video);
        } else {
            this.mlG.setImageResource(C30034d.ail(this.cAv.wgo));
        }
        this.gxi.setText(this.cAv.title);
        setBackBtn(new C130081());
        this.mlE.setOnClickListener(new C129997());
        final String str = this.cAv.wgg;
        if (!C5046bo.isNullOrNil(str)) {
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(24260);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    C25985d.m41467b(RecordMsgFileUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(24260);
                }
            });
        }
        this.mlF.setOnClickListener(new C130059());
        this.mlJ.setOnClickListener(new C1299710());
        if (getType() != 15 || C5046bo.ank(C26373g.m41964Nu().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, new C1300111());
        } else {
            C4990ab.m7420w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        boolean z = C5046bo.isNullOrNil(this.cAv.wfZ) || C5046bo.isNullOrNil(this.cAv.wgb);
        boolean z2;
        if (C5046bo.isNullOrNil(this.cAv.whr) || C5046bo.isNullOrNil(this.cAv.who)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z && !z2) {
            bwh();
        } else if (C43436n.m77560d(this.cAv, this.cvx)) {
            enableOptionMenu(true);
            bwl();
        } else {
            C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(this.cHr);
            if (VH == null || 2 == VH.field_status) {
                bwj();
            } else if (4 == VH.field_status) {
                bwh();
            } else if (VH.field_status == 0 || 1 == VH.field_status) {
                bwi();
            } else {
                C4990ab.m7420w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                bwj();
            }
            enableOptionMenu(false);
        }
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a((C43427d) this);
        AppMethodBeat.m2505o(24272);
    }

    private int getType() {
        int i = this.cAv.dataType;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void bwh() {
        AppMethodBeat.m2504i(24273);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.mlI.setVisibility(8);
        this.iqU.setVisibility(0);
        if (this.cAv.dataType == 4) {
            this.iqU.setGravity(17);
            this.iqU.setText(C25738R.string.bq0);
            AppMethodBeat.m2505o(24273);
            return;
        }
        this.iqU.setGravity(17);
        this.iqU.setText(C25738R.string.bpz);
        AppMethodBeat.m2505o(24273);
    }

    private void bwi() {
        AppMethodBeat.m2504i(24274);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlI.setVisibility(0);
        m20965c(((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(this.cHr));
        AppMethodBeat.m2505o(24274);
    }

    private void bwj() {
        AppMethodBeat.m2504i(24275);
        this.mlI.setVisibility(8);
        this.mlE.setVisibility(8);
        if (C5046bo.isNullOrNil(this.cAv.wgg)) {
            this.mlD.setVisibility(8);
        } else {
            this.mlD.setVisibility(0);
        }
        this.mlF.setVisibility(0);
        this.mlF.setText(C25738R.string.bpd);
        this.iqU.setVisibility(8);
        AppMethodBeat.m2505o(24275);
    }

    private void bwl() {
        AppMethodBeat.m2504i(24276);
        if (!(getType() != 15 || this.cAv.wgZ == null || C5046bo.isNullOrNil(this.cAv.wgZ.fiG) || C5046bo.isNullOrNil(this.cAv.wgZ.fiK))) {
            this.mlS = true;
            this.mlG.setVisibility(8);
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            String c = C43436n.m77558c(this.cAv, this.cvx);
            C4990ab.m7410d("MicroMsg.RecordMsgFileUI", C1447g.m3074Mp() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(2131823992);
            this.klq = C46510q.m87801fT(this.mController.ylL);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.klq, 0, layoutParams);
            this.klq.setVideoCallback(new C1300312());
            C4990ab.m7410d("MicroMsg.RecordMsgFileUI", C1447g.m3074Mp() + " initView :" + c);
            if (c != null) {
                this.klq.stop();
                this.klq.setVideoPath(c);
            }
            C4990ab.m7410d("MicroMsg.RecordMsgFileUI", C1447g.m3074Mp() + " initView");
            if (C9638aw.m17176Cc() != null) {
                C9638aw.m17176Cc().mo4649Id();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(4);
            if (C5046bo.isNullOrNil(this.cAv.wgg)) {
                this.mlD.setVisibility(8);
            } else {
                this.mlD.setVisibility(0);
            }
            this.mlE.setVisibility(0);
            this.iqU.setVisibility(0);
        } else if (!this.mlS) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(0);
            this.mlE.setText(C25738R.string.bpf);
            this.iqU.setVisibility(8);
            bnS();
            AppMethodBeat.m2505o(24276);
            return;
        }
        AppMethodBeat.m2505o(24276);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24277);
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
            if (C9638aw.m17176Cc() != null) {
                C9638aw.m17176Cc().mo4648Ic();
            }
        }
        super.onDestroy();
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b((C43427d) this);
        this.pKH.destory();
        AppMethodBeat.m2505o(24277);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24278);
        super.onResume();
        if (this.klq != null) {
            this.klq.start();
        }
        AppMethodBeat.m2505o(24278);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24279);
        super.onPause();
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.m2505o(24279);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24280);
        super.onActivityResult(i, i2, intent);
        C44094a.m79367a(this, i, i2, intent, true, C25738R.string.b6t, C25738R.string.b6u, 5);
        if (i2 != -1) {
            AppMethodBeat.m2505o(24280);
            return;
        }
        if (i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C4990ab.m7411d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            final C1300713 c1300713 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24269);
                    b.dismiss();
                    AppMethodBeat.m2505o(24269);
                }
            };
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(24280);
                return;
            }
            final ArrayList P = C5046bo.m7508P(stringExtra.split(","));
            if (getType() == 4 || getType() == 15) {
                C9638aw.m17180RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(24270);
                        File file = new File(C43436n.m77558c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                        for (String str : P) {
                            if (file.exists()) {
                                String m = RecordMsgFileUI.m20975m(RecordMsgFileUI.this);
                                C4990ab.m7411d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", file.getAbsolutePath(), m);
                                if (RecordMsgFileUI.m20964c(RecordMsgFileUI.this) == 15) {
                                    C12519g.bOk().mo46459a(RecordMsgFileUI.this.mController.ylL, str, file.getAbsolutePath(), m, 62, RecordMsgFileUI.this.cAv.duration, "");
                                } else {
                                    C12519g.bOk().mo46459a(RecordMsgFileUI.this.mController.ylL, str, file.getAbsolutePath(), m, 1, RecordMsgFileUI.this.cAv.duration, "");
                                }
                            } else {
                                String str2 = RecordMsgFileUI.this.cAv.wgg;
                                if (!C5046bo.isNullOrNil(str2)) {
                                    WXVideoObject wXVideoObject = new WXVideoObject();
                                    wXVideoObject.videoUrl = str2;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                    str2 = C5046bo.m7532bc(RecordMsgFileUI.this.cAv.title, RecordMsgFileUI.this.mController.ylL.getResources().getString(C25738R.string.bs9));
                                    wXMediaMessage.mediaObject = wXVideoObject;
                                    wXMediaMessage.title = str2;
                                    wXMediaMessage.description = RecordMsgFileUI.this.cAv.desc;
                                    wXMediaMessage.thumbData = C5046bo.readFromFile(C43436n.m77562f(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                                    if (wXMediaMessage.thumbData == null) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        C9638aw.m17190ZK();
                                        wXMediaMessage.thumbData = C5046bo.readFromFile(stringBuilder.append(C18628c.m29098Yg()).append("web/").append(C1178g.m2591x(C5046bo.m7532bc(RecordMsgFileUI.this.cAv.cvq, "").getBytes())).toString());
                                    }
                                    C4733l.m7090a(wXMediaMessage, "", "", str, 3, null);
                                }
                            }
                            C12519g.bOk().mo46461eZ(str, str);
                        }
                        C5004al.m7441d(c1300713);
                        AppMethodBeat.m2505o(24270);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(24271);
                        String str = super.toString() + "|onActivityResult1";
                        AppMethodBeat.m2505o(24271);
                        return str;
                    }
                });
                AppMethodBeat.m2505o(24280);
                return;
            }
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24253);
                    String c = C43436n.m77558c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                    WXFileObject wXFileObject = new WXFileObject();
                    wXFileObject.setFilePath(c);
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXFileObject;
                    wXMediaMessage.title = RecordMsgFileUI.this.cAv.title;
                    wXMediaMessage.description = RecordMsgFileUI.this.cAv.desc;
                    wXMediaMessage.thumbData = C5046bo.readFromFile(C43436n.m77562f(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                    for (String str : P) {
                        C4733l.m7090a(wXMediaMessage, "", "", str, 3, null);
                        C12519g.bOk().mo46461eZ(str, str);
                    }
                    C5004al.m7441d(c1300713);
                    AppMethodBeat.m2505o(24253);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(24254);
                    String str = super.toString() + "|onActivityResult2";
                    AppMethodBeat.m2505o(24254);
                    return str;
                }
            });
        }
        AppMethodBeat.m2505o(24280);
    }

    private String ceR() {
        String absolutePath;
        AppMethodBeat.m2504i(24281);
        File file = new File(C43436n.m77562f(this.cAv, this.cvx));
        if (file.exists()) {
            absolutePath = file.getAbsolutePath();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            absolutePath = stringBuilder.append(C18628c.m29098Yg()).append("web/").append(C1178g.m2591x(C5046bo.m7532bc(this.cAv.cvq, "").getBytes())).toString();
        }
        AppMethodBeat.m2505o(24281);
        return absolutePath;
    }

    /* renamed from: c */
    private void m20965c(C34792i c34792i) {
        int i;
        int i2;
        int i3;
        AppMethodBeat.m2504i(24282);
        if (c34792i != null) {
            int max = (int) ((((float) c34792i.field_offset) / ((float) Math.max(1, c34792i.field_totalLen))) * 100.0f);
            i = c34792i.field_offset;
            i2 = c34792i.field_totalLen;
            i3 = max;
        } else {
            i2 = (int) this.cAv.wgu;
            i = 0;
            i3 = 0;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24255);
                RecordMsgFileUI.this.progressBar.setProgress(i3);
                RecordMsgFileUI.this.mlH.setText(RecordMsgFileUI.this.getString(C25738R.string.bo5, new Object[]{C5046bo.m7518aC((float) i), C5046bo.m7518aC((float) i2)}));
                AppMethodBeat.m2505o(24255);
            }
        });
        AppMethodBeat.m2505o(24282);
    }

    /* renamed from: a */
    public final void mo25051a(int i, C34792i c34792i) {
        AppMethodBeat.m2504i(24283);
        if (c34792i == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            AppMethodBeat.m2505o(24283);
            return;
        }
        C4990ab.m7419v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", this.cHr, c34792i.field_mediaId);
        if (this.cHr.equals(c34792i.field_mediaId)) {
            switch (c34792i.field_status) {
                case 2:
                    this.fbD.post(new C130124());
                    AppMethodBeat.m2505o(24283);
                    return;
                case 3:
                    this.fbD.post(new C129986());
                    AppMethodBeat.m2505o(24283);
                    return;
                case 4:
                    this.fbD.post(new C130105());
                    AppMethodBeat.m2505o(24283);
                    return;
                default:
                    m20965c(c34792i);
                    AppMethodBeat.m2505o(24283);
                    return;
            }
        }
        AppMethodBeat.m2505o(24283);
    }

    private void bnS() {
        AppMethodBeat.m2504i(24284);
        if (this.mlR) {
            AppMethodBeat.m2505o(24284);
            return;
        }
        this.mlR = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_fav_path", C43436n.m77558c(this.cAv, this.cvx));
        intent.putExtra("key_detail_fav_thumb_path", C43436n.m77562f(this.cAv, this.cvx));
        intent.putExtra("key_detail_fav_video_duration", this.cAv.duration);
        intent.putExtra("key_detail_statExtStr", this.cAv.cMn);
        intent.putExtra("key_detail_fav_video_scene_from", 1);
        C39037b.m66371b((Context) this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.m2505o(24284);
    }

    /* renamed from: h */
    static /* synthetic */ void m20970h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        AppMethodBeat.m2504i(24290);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.ceR());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.ceR());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.cAv.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        C25985d.m41466b((Context) recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.m2505o(24290);
    }
}
