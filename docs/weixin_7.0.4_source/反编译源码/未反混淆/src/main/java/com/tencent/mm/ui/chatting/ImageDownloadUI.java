package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public class ImageDownloadUI extends MMActivity implements f, g {
    private long cKK = 0;
    private long cvx = 0;
    private int fDC;
    private TextView kPu;
    private ProgressBar pyV;
    private TextView pyW;
    private TextView pyX;
    private TextView pyY;
    private e pza;
    private k pzb;
    private String username;
    private ImageView yLL;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30946);
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
            ab.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cvx + ", or msgSvrId = " + this.cKK);
            AppMethodBeat.o(30946);
            return;
        }
        if (this.cvx <= 0 && this.cKK > 0) {
            aw.ZK();
            this.cvx = c.XO().Q(this.username, this.cKK).field_msgId;
        }
        this.pzb = new k(this.pza.fDy, this.cvx, this.fDC, this);
        aw.Rg().a(this.pzb, 0);
        AppMethodBeat.o(30946);
    }

    public final int getLayoutId() {
        return R.layout.b1b;
    }

    public void onPause() {
        AppMethodBeat.i(30947);
        super.onPause();
        aw.Rg().b(109, (f) this);
        AppMethodBeat.o(30947);
    }

    public void onResume() {
        AppMethodBeat.i(30948);
        super.onResume();
        aw.Rg().a(109, (f) this);
        AppMethodBeat.o(30948);
    }

    public final void initView() {
        AppMethodBeat.i(30949);
        this.pyW = (TextView) findViewById(R.id.d1p);
        this.pyX = (TextView) findViewById(R.id.f0o);
        this.kPu = (TextView) findViewById(R.id.f0p);
        this.pyY = (TextView) findViewById(R.id.f0q);
        this.yLL = (ImageView) findViewById(R.id.f0m);
        this.yLL.setImageResource(R.raw.download_image_icon);
        this.pyW.setVisibility(0);
        this.pyX.setVisibility(8);
        this.kPu.setVisibility(8);
        this.pyY.setVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30945);
                aw.Rg().c(ImageDownloadUI.this.pzb);
                ImageDownloadUI.this.finish();
                AppMethodBeat.o(30945);
                return true;
            }
        });
        this.pyV = (ProgressBar) findViewById(R.id.f0n);
        AppMethodBeat.o(30949);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(30950);
        ab.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (mVar.getType() == 109) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            Bv(Math.max(0, i3));
        }
        AppMethodBeat.o(30950);
    }

    private void Bv(int i) {
        AppMethodBeat.i(30951);
        this.pyV.setProgress(i);
        this.pyW.setText(getString(R.string.bxs, new Object[]{Integer.valueOf(i)}));
        if (i < this.pyV.getMax()) {
            AppMethodBeat.o(30951);
            return;
        }
        e b = o.ahl().b(Long.valueOf(this.pzb.fEX));
        String str = b.fDz;
        if (this.fDC == 1) {
            str = com.tencent.mm.at.f.c(b);
        }
        arf(o.ahl().q(str, null, null));
        AppMethodBeat.o(30951);
    }

    private void arf(String str) {
        AppMethodBeat.i(30952);
        if (str == null || str.equals("") || !com.tencent.mm.vfs.e.ct(str)) {
            ab.d("ImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.o(30952);
            return;
        }
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("key_message_id", this.cvx);
        intent.putExtra("key_image_path", str);
        intent.putExtra("key_compress_type", this.fDC);
        intent.putExtra("key_favorite", true);
        intent.putExtra("img_gallery_msg_id", this.cvx);
        intent.putExtra("img_gallery_talker", this.username);
        finish();
        AppMethodBeat.o(30952);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(30953);
        if (mVar.getType() != 109) {
            AppMethodBeat.o(30953);
        } else if (i == 0 && i2 == 0) {
            Bv(this.pyV.getMax());
            AppMethodBeat.o(30953);
        } else {
            ab.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.string.cdh, 1).show();
            AppMethodBeat.o(30953);
        }
    }
}
