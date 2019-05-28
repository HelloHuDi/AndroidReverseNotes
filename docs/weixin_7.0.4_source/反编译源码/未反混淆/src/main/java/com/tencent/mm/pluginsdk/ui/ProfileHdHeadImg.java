package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

@a(3)
public class ProfileHdHeadImg extends MMActivity {
    private String hix = null;
    private GetHdHeadImageGalleryView qll;
    private e qlm;
    private String username = null;
    private String viu = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ProfileHdHeadImg profileHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.i(27529);
        profileHdHeadImg.d(bitmap, str);
        AppMethodBeat.o(27529);
    }

    public final int getLayoutId() {
        return R.layout.a69;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27526);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.username = getIntent().getStringExtra("username");
        this.hix = getIntent().getStringExtra("brand_icon_url");
        xE(getResources().getColor(R.color.j));
        Nb(getResources().getColor(R.color.j));
        this.qll = (GetHdHeadImageGalleryView) findViewById(R.id.adi);
        this.qll.setUsername(this.username);
        this.qll.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(27524);
                ProfileHdHeadImg.this.finish();
                AppMethodBeat.o(27524);
            }
        });
        aw.ZK();
        if (c.isSDCardAvailable()) {
            Bitmap a;
            if (bo.isNullOrNil(this.hix)) {
                a = b.a(this.username, true, -1);
            } else {
                a = m.aA(this.username, this.hix);
            }
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), R.drawable.ad2);
            }
            if (a == null || a.isRecycled()) {
                ab.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                ab.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.qll.setThumbImage(a);
            }
            if (!bo.isNullOrNil(this.viu)) {
                this.username = this.viu;
            }
            o.acd();
            Bitmap qg = d.qg(this.username);
            if (qg == null || qg.isRecycled()) {
                this.qlm = new e();
                this.qlm.a(this.username, new e.c() {
                    public final int cr(int i, int i2) {
                        AppMethodBeat.i(27525);
                        ProfileHdHeadImg.this.qlm.ach();
                        ab.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            o.acd();
                            Bitmap qg = d.qg(ProfileHdHeadImg.this.username);
                            if (qg != null) {
                                ProfileHdHeadImg profileHdHeadImg = ProfileHdHeadImg.this;
                                o.acd();
                                ProfileHdHeadImg.a(profileHdHeadImg, qg, d.C(ProfileHdHeadImg.this.username, true));
                            } else {
                                ProfileHdHeadImg.a(ProfileHdHeadImg.this, a, null);
                            }
                            AppMethodBeat.o(27525);
                        } else {
                            ProfileHdHeadImg.a(ProfileHdHeadImg.this, a, null);
                            AppMethodBeat.o(27525);
                        }
                        return 0;
                    }
                });
                AppMethodBeat.o(27526);
                return;
            }
            ab.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            o.acd();
            d(qg, d.C(this.username, true));
            AppMethodBeat.o(27526);
            return;
        }
        t.hO(this);
        d(o.acd().bU(this), null);
        AppMethodBeat.o(27526);
    }

    public void onDestroy() {
        AppMethodBeat.i(27527);
        super.onDestroy();
        AppMethodBeat.o(27527);
    }

    private void d(Bitmap bitmap, String str) {
        AppMethodBeat.i(27528);
        try {
            Bitmap a = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, 0.1f);
            com.tencent.mm.bv.a.a.a.xtT.p(this.username, a);
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                a = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            ab.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(a.getWidth()), Integer.valueOf(a.getHeight()));
            this.qll.setHdHeadImage(a);
            this.qll.setHdHeadImagePath(str);
            AppMethodBeat.o(27528);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ProfileHdHeadImg", e, "", new Object[0]);
            AppMethodBeat.o(27528);
        }
    }
}
