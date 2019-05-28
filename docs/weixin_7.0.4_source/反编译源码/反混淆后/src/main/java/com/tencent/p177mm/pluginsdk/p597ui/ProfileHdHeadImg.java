package com.tencent.p177mm.pluginsdk.p597ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1376bv.p1377a.C32428a.C25995a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41733e;
import com.tencent.p177mm.p182ah.C41733e.C25750c;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

@C5271a(3)
/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg */
public class ProfileHdHeadImg extends MMActivity {
    private String hix = null;
    private GetHdHeadImageGalleryView qll;
    private C41733e qlm;
    private String username = null;
    private String viu = null;

    /* renamed from: com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg$1 */
    class C149041 implements C30745f {
        C149041() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(27524);
            ProfileHdHeadImg.this.finish();
            AppMethodBeat.m2505o(27524);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m35740a(ProfileHdHeadImg profileHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(27529);
        profileHdHeadImg.m35742d(bitmap, str);
        AppMethodBeat.m2505o(27529);
    }

    public final int getLayoutId() {
        return 2130969799;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(27526);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.username = getIntent().getStringExtra("username");
        this.hix = getIntent().getStringExtra("brand_icon_url");
        mo17446xE(getResources().getColor(C25738R.color.f11625j));
        mo17372Nb(getResources().getColor(C25738R.color.f11625j));
        this.qll = (GetHdHeadImageGalleryView) findViewById(2131822081);
        this.qll.setUsername(this.username);
        this.qll.setSingleClickOverListener(new C149041());
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            Bitmap a;
            if (C5046bo.isNullOrNil(this.hix)) {
                a = C41730b.m73490a(this.username, true, -1);
            } else {
                a = C8935m.m16104aA(this.username, this.hix);
            }
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), C25738R.drawable.ad2);
            }
            if (a == null || a.isRecycled()) {
                C4990ab.m7417i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                C4990ab.m7417i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.qll.setThumbImage(a);
            }
            if (!C5046bo.isNullOrNil(this.viu)) {
                this.username = this.viu;
            }
            C17884o.acd();
            Bitmap qg = C41732d.m73526qg(this.username);
            if (qg == null || qg.isRecycled()) {
                this.qlm = new C41733e();
                this.qlm.mo67507a(this.username, new C25750c() {
                    /* renamed from: cr */
                    public final int mo4442cr(int i, int i2) {
                        AppMethodBeat.m2504i(27525);
                        ProfileHdHeadImg.this.qlm.ach();
                        C4990ab.m7417i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C17884o.acd();
                            Bitmap qg = C41732d.m73526qg(ProfileHdHeadImg.this.username);
                            if (qg != null) {
                                ProfileHdHeadImg profileHdHeadImg = ProfileHdHeadImg.this;
                                C17884o.acd();
                                ProfileHdHeadImg.m35740a(profileHdHeadImg, qg, C41732d.m73514C(ProfileHdHeadImg.this.username, true));
                            } else {
                                ProfileHdHeadImg.m35740a(ProfileHdHeadImg.this, a, null);
                            }
                            AppMethodBeat.m2505o(27525);
                        } else {
                            ProfileHdHeadImg.m35740a(ProfileHdHeadImg.this, a, null);
                            AppMethodBeat.m2505o(27525);
                        }
                        return 0;
                    }
                });
                AppMethodBeat.m2505o(27526);
                return;
            }
            C4990ab.m7417i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            C17884o.acd();
            m35742d(qg, C41732d.m73514C(this.username, true));
            AppMethodBeat.m2505o(27526);
            return;
        }
        C23639t.m36492hO(this);
        m35742d(C17884o.acd().mo67501bU(this), null);
        AppMethodBeat.m2505o(27526);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(27527);
        super.onDestroy();
        AppMethodBeat.m2505o(27527);
    }

    /* renamed from: d */
    private void m35742d(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(27528);
        try {
            Bitmap a = C5056d.m7616a(bitmap, false, 0.1f);
            C25995a.xtT.mo53070p(this.username, a);
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                a = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            C4990ab.m7411d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(a.getWidth()), Integer.valueOf(a.getHeight()));
            this.qll.setHdHeadImage(a);
            this.qll.setHdHeadImagePath(str);
            AppMethodBeat.m2505o(27528);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ProfileHdHeadImg", e, "", new Object[0]);
            AppMethodBeat.m2505o(27528);
        }
    }
}
