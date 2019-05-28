package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.p520ui.SnsInfoFlip.C3981c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI */
public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements C29239a {
    private ArrayList<String> rCg = new ArrayList();
    private HashMap<Integer, Boolean> rCh = new HashMap();
    private int rpr = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI$2 */
    class C135742 implements OnMenuItemClickListener {
        C135742() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39677);
            SnsUploadBrowseUI.this.cuw();
            AppMethodBeat.m2505o(39677);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI$3 */
    class C135753 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI$3$1 */
        class C40071 implements OnClickListener {
            C40071() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(39678);
                if (SnsUploadBrowseUI.this.rpp.ctn() == 0) {
                    SnsUploadBrowseUI.this.cuw();
                }
                AppMethodBeat.m2505o(39678);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI$3$2 */
        class C40082 implements OnClickListener {
            C40082() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C135753() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39679);
            C30379h.m48432a(SnsUploadBrowseUI.this, (int) C25738R.string.ekz, (int) C25738R.string.f9238tz, new C40071(), new C40082());
            AppMethodBeat.m2505o(39679);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI$1 */
    class C135761 implements C3981c {
        C135761() {
        }

        /* renamed from: Eb */
        public final void mo8815Eb(int i) {
            AppMethodBeat.m2504i(39676);
            SnsUploadBrowseUI.this.rCh.put(Integer.valueOf(i), Boolean.TRUE);
            AppMethodBeat.m2505o(39676);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsUploadBrowseUI() {
        AppMethodBeat.m2504i(39680);
        AppMethodBeat.m2505o(39680);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39681);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(39681);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39682);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        C13373af.cnC().mo37452ab(this);
        super.onDestroy();
        AppMethodBeat.m2505o(39682);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39683);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.m2505o(39683);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39684);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        AppMethodBeat.m2505o(39684);
    }

    public final int getLayoutId() {
        return 2130970748;
    }

    public final void cuw() {
        AppMethodBeat.m2504i(39685);
        Intent intent = new Intent();
        List<C34937b> flipList = this.rpp.getFlipList();
        if (flipList == null) {
            AppMethodBeat.m2505o(39685);
            return;
        }
        this.rCg.clear();
        for (C34937b c34937b : flipList) {
            Object substring;
            String str = C13373af.getAccSnsTmpPath() + c34937b.cNr.f17915Id;
            if (c34937b.cNr.f17915Id.startsWith("pre_temp_extend_pic")) {
                substring = c34937b.cNr.f17915Id.substring(19);
            } else {
                String substring2 = str;
            }
            this.rCg.add(substring2);
        }
        intent.putExtra("sns_gallery_temp_paths", this.rCg);
        intent.putExtra("sns_update_preview_image_count", this.rCh.size());
        this.rCh.clear();
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(39685);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39686);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
            cuw();
            AppMethodBeat.m2505o(39686);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(39686);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.m2504i(39687);
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.rCg = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.rCg == null) {
            AppMethodBeat.m2505o(39687);
            return;
        }
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setEnableHorLongBmpMode(false);
        this.rpp.setShowTitle(true);
        C13373af.getAccSnsTmpPath();
        this.rpp.mo8770a(C34955aj.m57406df(this.rCg), bc, this.rpr, this.rpk, this);
        this.rpp.setOnPageSelectListener(new C135761());
        addView(this.rpp);
        setBackBtn(new C135742());
        addIconOptionMenu(0, C25738R.string.f9088p4, C25738R.drawable.aiy, new C135753());
        AppMethodBeat.m2505o(39687);
    }

    /* renamed from: dg */
    public final void mo8727dg(String str, int i) {
        AppMethodBeat.m2504i(39688);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.m2505o(39688);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39689);
        C4990ab.m7416i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(39689);
        } else {
            AppMethodBeat.m2505o(39689);
        }
    }

    public final int getForceOrientation() {
        return 4;
    }

    /* renamed from: dh */
    public final void mo8728dh(String str, int i) {
    }
}
