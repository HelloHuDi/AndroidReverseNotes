package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C25826k;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI */
public class MailImageDownloadUI extends MMActivity implements C1202f, C32231g {
    private long cKK = 0;
    private long cvx = 0;
    private int fDC;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private TextView kPu;
    private ProgressBar pyV;
    private TextView pyW;
    private TextView pyX;
    private TextView pyY;
    private RelativeLayout pyZ;
    private C25822e pza;
    private C25826k pzb;
    private ImageView pzc;
    private LinearLayout pzd;
    private String username;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI$1 */
    class C287671 implements OnMenuItemClickListener {
        C287671() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68381);
            C1720g.m3535RO().eJo.mo14547c(MailImageDownloadUI.this.pzb);
            MailImageDownloadUI.this.finish();
            AppMethodBeat.m2505o(68381);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MailImageDownloadUI() {
        AppMethodBeat.m2504i(68382);
        AppMethodBeat.m2505o(68382);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68383);
        super.onCreate(bundle);
        this.cvx = getIntent().getLongExtra("img_msg_id", 0);
        this.cKK = getIntent().getLongExtra("img_server_id", 0);
        this.fDC = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.cvx > 0) {
            this.pza = C32291o.ahl().mo73113fJ(this.cvx);
        }
        if ((this.pza == null || this.pza.fDy <= 0) && this.cKK > 0) {
            this.pza = C32291o.ahl().mo73112fI(this.cKK);
        }
        if (this.pza == null || this.pza.fDy <= 0) {
            C4990ab.m7412e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cvx + ", or msgSvrId = " + this.cKK);
            AppMethodBeat.m2505o(68383);
            return;
        }
        if (this.cvx <= 0 && this.cKK > 0) {
            this.cvx = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(this.username, this.cKK).field_msgId;
        }
        String str = this.pza.fDz;
        String q = C32291o.ahl().mo73118q(str, null, null);
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(q)) {
            this.pzb = new C25826k(this.pza.fDy, this.cvx, this.fDC, this);
            C1720g.m3535RO().eJo.mo14541a(this.pzb, 0);
            AppMethodBeat.m2505o(68383);
            return;
        }
        C4990ab.m7417i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", str, Boolean.valueOf(this.pza.agQ()), q);
        if (q == null || q.equals("") || !C5730e.m8628ct(q)) {
            C4990ab.m7410d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.m2505o(68383);
            return;
        }
        this.pzd.setVisibility(8);
        this.pyV.setVisibility(8);
        this.pzc.setVisibility(0);
        this.pzc.setImageBitmap(C5056d.aml(q));
        this.pyZ.invalidate();
        AppMethodBeat.m2505o(68383);
    }

    public final int getLayoutId() {
        return 2130970017;
    }

    public void onPause() {
        AppMethodBeat.m2504i(68384);
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b(109, (C1202f) this);
        AppMethodBeat.m2505o(68384);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68385);
        super.onResume();
        C1720g.m3535RO().eJo.mo14539a(109, (C1202f) this);
        AppMethodBeat.m2505o(68385);
    }

    public final void initView() {
        AppMethodBeat.m2504i(68386);
        this.pyW = (TextView) findViewById(2131825712);
        this.pyX = (TextView) findViewById(2131825712);
        this.kPu = (TextView) findViewById(2131825713);
        this.pyY = (TextView) findViewById(2131825714);
        this.pzc = (ImageView) findViewById(2131825710);
        this.pyW.setVisibility(0);
        this.pzd = (LinearLayout) findViewById(2131825711);
        this.pyZ = (RelativeLayout) findViewById(2131825708);
        this.pyX.setVisibility(8);
        this.kPu.setVisibility(8);
        this.pyY.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new C287671());
        this.pyV = (ProgressBar) findViewById(2131825709);
        AppMethodBeat.m2505o(68386);
    }

    /* renamed from: Bv */
    private void m45738Bv(int i) {
        AppMethodBeat.m2504i(68387);
        this.pyW.setText(getString(C25738R.string.bxs, new Object[]{Integer.valueOf(i)}));
        if (i < this.pyV.getMax()) {
            AppMethodBeat.m2505o(68387);
            return;
        }
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(this.pzb.fEX));
        if (this.fDC == 1) {
            C37478f.m63227c(b);
        }
        finish();
        startActivity(getIntent());
        AppMethodBeat.m2505o(68387);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(68388);
        C4990ab.m7410d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (c1207m.getType() == 109) {
            m45738Bv(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
        AppMethodBeat.m2505o(68388);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(68389);
        if (c1207m.getType() != 109) {
            AppMethodBeat.m2505o(68389);
        } else if (i == 0 && i2 == 0) {
            m45738Bv(this.pyV.getMax());
            AppMethodBeat.m2505o(68389);
        } else {
            C4990ab.m7412e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, C25738R.string.cdh, 1).show();
            AppMethodBeat.m2505o(68389);
        }
    }
}
