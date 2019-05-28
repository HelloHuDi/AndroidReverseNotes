package com.tencent.p177mm.p612ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C25826k;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.ImageDownloadUI */
public class ImageDownloadUI extends MMActivity implements C1202f, C32231g {
    private long cKK = 0;
    private long cvx = 0;
    private int fDC;
    private TextView kPu;
    private ProgressBar pyV;
    private TextView pyW;
    private TextView pyX;
    private TextView pyY;
    private C25822e pza;
    private C25826k pzb;
    private String username;
    private ImageView yLL;

    /* renamed from: com.tencent.mm.ui.chatting.ImageDownloadUI$1 */
    class C361161 implements OnMenuItemClickListener {
        C361161() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30945);
            C9638aw.m17182Rg().mo14547c(ImageDownloadUI.this.pzb);
            ImageDownloadUI.this.finish();
            AppMethodBeat.m2505o(30945);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30946);
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
            C4990ab.m7412e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cvx + ", or msgSvrId = " + this.cKK);
            AppMethodBeat.m2505o(30946);
            return;
        }
        if (this.cvx <= 0 && this.cKK > 0) {
            C9638aw.m17190ZK();
            this.cvx = C18628c.m29080XO().mo15241Q(this.username, this.cKK).field_msgId;
        }
        this.pzb = new C25826k(this.pza.fDy, this.cvx, this.fDC, this);
        C9638aw.m17182Rg().mo14541a(this.pzb, 0);
        AppMethodBeat.m2505o(30946);
    }

    public final int getLayoutId() {
        return 2130970988;
    }

    public void onPause() {
        AppMethodBeat.m2504i(30947);
        super.onPause();
        C9638aw.m17182Rg().mo14546b(109, (C1202f) this);
        AppMethodBeat.m2505o(30947);
    }

    public void onResume() {
        AppMethodBeat.m2504i(30948);
        super.onResume();
        C9638aw.m17182Rg().mo14539a(109, (C1202f) this);
        AppMethodBeat.m2505o(30948);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30949);
        this.pyW = (TextView) findViewById(2131825712);
        this.pyX = (TextView) findViewById(2131828412);
        this.kPu = (TextView) findViewById(2131828413);
        this.pyY = (TextView) findViewById(2131828414);
        this.yLL = (ImageView) findViewById(2131828410);
        this.yLL.setImageResource(C1318a.download_image_icon);
        this.pyW.setVisibility(0);
        this.pyX.setVisibility(8);
        this.kPu.setVisibility(8);
        this.pyY.setVisibility(8);
        setBackBtn(new C361161());
        this.pyV = (ProgressBar) findViewById(2131828411);
        AppMethodBeat.m2505o(30949);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(30950);
        C4990ab.m7410d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (c1207m.getType() == 109) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            m88260Bv(Math.max(0, i3));
        }
        AppMethodBeat.m2505o(30950);
    }

    /* renamed from: Bv */
    private void m88260Bv(int i) {
        AppMethodBeat.m2504i(30951);
        this.pyV.setProgress(i);
        this.pyW.setText(getString(C25738R.string.bxs, new Object[]{Integer.valueOf(i)}));
        if (i < this.pyV.getMax()) {
            AppMethodBeat.m2505o(30951);
            return;
        }
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(this.pzb.fEX));
        String str = b.fDz;
        if (this.fDC == 1) {
            str = C37478f.m63227c(b);
        }
        arf(C32291o.ahl().mo73118q(str, null, null));
        AppMethodBeat.m2505o(30951);
    }

    private void arf(String str) {
        AppMethodBeat.m2504i(30952);
        if (str == null || str.equals("") || !C5730e.m8628ct(str)) {
            C4990ab.m7410d("ImageDownloadUI", "showImg : imgPath is null");
            AppMethodBeat.m2505o(30952);
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
        AppMethodBeat.m2505o(30952);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(30953);
        if (c1207m.getType() != 109) {
            AppMethodBeat.m2505o(30953);
        } else if (i == 0 && i2 == 0) {
            m88260Bv(this.pyV.getMax());
            AppMethodBeat.m2505o(30953);
        } else {
            C4990ab.m7412e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, C25738R.string.cdh, 1).show();
            AppMethodBeat.m2505o(30953);
        }
    }
}
