package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.e;
import com.tencent.mm.at.k;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;

public class MailImageDownloadUI extends MMActivity implements f, g {
    private long cKK = 0;
    private long cvx = 0;
    private int fDC;
    private ak handler = new ak(Looper.getMainLooper());
    private TextView kPu;
    private ProgressBar pyV;
    private TextView pyW;
    private TextView pyX;
    private TextView pyY;
    private RelativeLayout pyZ;
    private e pza;
    private k pzb;
    private ImageView pzc;
    private LinearLayout pzd;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailImageDownloadUI() {
        AppMethodBeat.i(68382);
        AppMethodBeat.o(68382);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68383);
        super.onCreate(bundle);
        this.cvx = getIntent().getLongExtra("img_msg_id", 0);
        this.cKK = getIntent().getLongExtra("img_server_id", 0);
        this.fDC = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.cvx > 0) {
            this.pza = o.ahl().fJ(this.cvx);
        }
        if ((this.pza == null || this.pza.fDy <= 0) && this.cKK > 0) {
            this.pza = o.ahl().fI(this.cKK);
        }
        if (this.pza == null || this.pza.fDy <= 0) {
            ab.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cvx + ", or msgSvrId = " + this.cKK);
            AppMethodBeat.o(68383);
            return;
        }
        if (this.cvx <= 0 && this.cKK > 0) {
            this.cvx = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Q(this.username, this.cKK).field_msgId;
        }
        String str = this.pza.fDz;
        String q = o.ahl().q(str, null, null);
        if (bo.isNullOrNil(str) || !com.tencent.mm.vfs.e.ct(q)) {
            this.pzb = new k(this.pza.fDy, this.cvx, this.fDC, this);
            com.tencent.mm.kernel.g.RO().eJo.a(this.pzb, 0);
            AppMethodBeat.o(68383);
            return;
        }
        ab.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", str, Boolean.valueOf(this.pza.agQ()), q);
        if (q == null || q.equals("") || !com.tencent.mm.vfs.e.ct(q)) {
            ab.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.o(68383);
            return;
        }
        this.pzd.setVisibility(8);
        this.pyV.setVisibility(8);
        this.pzc.setVisibility(0);
        this.pzc.setImageBitmap(d.aml(q));
        this.pyZ.invalidate();
        AppMethodBeat.o(68383);
    }

    public final int getLayoutId() {
        return R.layout.ab5;
    }

    public void onPause() {
        AppMethodBeat.i(68384);
        super.onPause();
        com.tencent.mm.kernel.g.RO().eJo.b(109, (f) this);
        AppMethodBeat.o(68384);
    }

    public void onResume() {
        AppMethodBeat.i(68385);
        super.onResume();
        com.tencent.mm.kernel.g.RO().eJo.a(109, (f) this);
        AppMethodBeat.o(68385);
    }

    public final void initView() {
        AppMethodBeat.i(68386);
        this.pyW = (TextView) findViewById(R.id.d1p);
        this.pyX = (TextView) findViewById(R.id.d1p);
        this.kPu = (TextView) findViewById(R.id.d1q);
        this.pyY = (TextView) findViewById(R.id.d1r);
        this.pzc = (ImageView) findViewById(R.id.d1n);
        this.pyW.setVisibility(0);
        this.pzd = (LinearLayout) findViewById(R.id.d1o);
        this.pyZ = (RelativeLayout) findViewById(R.id.d1l);
        this.pyX.setVisibility(8);
        this.kPu.setVisibility(8);
        this.pyY.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68381);
                com.tencent.mm.kernel.g.RO().eJo.c(MailImageDownloadUI.this.pzb);
                MailImageDownloadUI.this.finish();
                AppMethodBeat.o(68381);
                return true;
            }
        });
        this.pyV = (ProgressBar) findViewById(R.id.d1m);
        AppMethodBeat.o(68386);
    }

    private void Bv(int i) {
        AppMethodBeat.i(68387);
        this.pyW.setText(getString(R.string.bxs, new Object[]{Integer.valueOf(i)}));
        if (i < this.pyV.getMax()) {
            AppMethodBeat.o(68387);
            return;
        }
        e b = o.ahl().b(Long.valueOf(this.pzb.fEX));
        if (this.fDC == 1) {
            com.tencent.mm.at.f.c(b);
        }
        finish();
        startActivity(getIntent());
        AppMethodBeat.o(68387);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(68388);
        ab.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (mVar.getType() == 109) {
            Bv(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
        AppMethodBeat.o(68388);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(68389);
        if (mVar.getType() != 109) {
            AppMethodBeat.o(68389);
        } else if (i == 0 && i2 == 0) {
            Bv(this.pyV.getMax());
            AppMethodBeat.o(68389);
        } else {
            ab.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.string.cdh, 1).show();
            AppMethodBeat.o(68389);
        }
    }
}
