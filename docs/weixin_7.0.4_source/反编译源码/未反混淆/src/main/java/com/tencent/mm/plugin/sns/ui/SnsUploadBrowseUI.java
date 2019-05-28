package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private ArrayList<String> rCg = new ArrayList();
    private HashMap<Integer, Boolean> rCh = new HashMap();
    private int rpr = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUploadBrowseUI() {
        AppMethodBeat.i(39680);
        AppMethodBeat.o(39680);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39681);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(39681);
    }

    public void onDestroy() {
        AppMethodBeat.i(39682);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        af.cnC().ab(this);
        super.onDestroy();
        AppMethodBeat.o(39682);
    }

    public void onResume() {
        AppMethodBeat.i(39683);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.o(39683);
    }

    public void onPause() {
        AppMethodBeat.i(39684);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        AppMethodBeat.o(39684);
    }

    public final int getLayoutId() {
        return R.layout.auv;
    }

    public final void cuw() {
        AppMethodBeat.i(39685);
        Intent intent = new Intent();
        List<b> flipList = this.rpp.getFlipList();
        if (flipList == null) {
            AppMethodBeat.o(39685);
            return;
        }
        this.rCg.clear();
        for (b bVar : flipList) {
            Object substring;
            String str = af.getAccSnsTmpPath() + bVar.cNr.Id;
            if (bVar.cNr.Id.startsWith("pre_temp_extend_pic")) {
                substring = bVar.cNr.Id.substring(19);
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
        AppMethodBeat.o(39685);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39686);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
            cuw();
            AppMethodBeat.o(39686);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39686);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.i(39687);
        String bc = bo.bc(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.rCg = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.rCg == null) {
            AppMethodBeat.o(39687);
            return;
        }
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setEnableHorLongBmpMode(false);
        this.rpp.setShowTitle(true);
        af.getAccSnsTmpPath();
        this.rpp.a(aj.df(this.rCg), bc, this.rpr, this.rpk, this);
        this.rpp.setOnPageSelectListener(new c() {
            public final void Eb(int i) {
                AppMethodBeat.i(39676);
                SnsUploadBrowseUI.this.rCh.put(Integer.valueOf(i), Boolean.TRUE);
                AppMethodBeat.o(39676);
            }
        });
        addView(this.rpp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39677);
                SnsUploadBrowseUI.this.cuw();
                AppMethodBeat.o(39677);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.p4, R.drawable.aiy, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39679);
                h.a(SnsUploadBrowseUI.this, (int) R.string.ekz, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39678);
                        if (SnsUploadBrowseUI.this.rpp.ctn() == 0) {
                            SnsUploadBrowseUI.this.cuw();
                        }
                        AppMethodBeat.o(39678);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(39679);
                return true;
            }
        });
        AppMethodBeat.o(39687);
    }

    public final void dg(String str, int i) {
        AppMethodBeat.i(39688);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.o(39688);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39689);
        ab.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(39689);
        } else {
            AppMethodBeat.o(39689);
        }
    }

    public final int getForceOrientation() {
        return 4;
    }

    public final void dh(String str, int i) {
    }
}
