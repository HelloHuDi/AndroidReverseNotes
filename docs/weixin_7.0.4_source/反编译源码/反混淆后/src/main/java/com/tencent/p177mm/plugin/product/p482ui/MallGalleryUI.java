package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.product.p482ui.C31385g.C31386a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI */
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager pit;
    private C31385g piu;
    private List<String> piv;
    private int piw = 0;
    private boolean pix;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI$4 */
    class C35984 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI$4$1 */
        class C35991 implements C30391c {
            C35991() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(44038);
                MallGalleryUI mallGalleryUI;
                switch (i) {
                    case 0:
                        mallGalleryUI = MallGalleryUI.this;
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", "");
                        intent.putExtra("Retr_Msg_Type", 0);
                        if (C5046bo.isNullOrNil(mallGalleryUI.bZZ())) {
                            C4990ab.m7412e("MicroMsg.MallGalleryUI", "url is null or nil");
                            AppMethodBeat.m2505o(44038);
                            return;
                        }
                        intent.putExtra("Retr_File_Name", mallGalleryUI.bZZ());
                        intent.putExtra("Retr_go_to_chattingUI", false);
                        intent.putExtra("Retr_show_success_tips", true);
                        C25985d.m41473f(mallGalleryUI, ".ui.transmit.MsgRetransmitUI", intent);
                        AppMethodBeat.m2505o(44038);
                        return;
                    case 1:
                        mallGalleryUI = MallGalleryUI.this;
                        String bZZ = mallGalleryUI.bZZ();
                        if (C5046bo.isNullOrNil(bZZ)) {
                            C4990ab.m7420w("MicroMsg.MallGalleryUI", "save error.");
                            AppMethodBeat.m2505o(44038);
                            return;
                        }
                        C4990ab.m7411d("MicroMsg.MallGalleryUI", "can save. img path: %s", bZZ);
                        C14987n.m23321j(bZZ, mallGalleryUI);
                        AppMethodBeat.m2505o(44038);
                        return;
                    case 2:
                        MallGalleryUI mallGalleryUI2 = MallGalleryUI.this;
                        String bZZ2 = mallGalleryUI2.bZZ();
                        if (C5046bo.isNullOrNil(bZZ2)) {
                            C4990ab.m7420w("MicroMsg.MallGalleryUI", "file path invalid");
                            break;
                        }
                        C4990ab.m7410d("MicroMsg.MallGalleryUI", "file path valid");
                        C45316cl c45316cl = new C45316cl();
                        if (C5046bo.isNullOrNil(bZZ2)) {
                            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                            c45316cl.cvA.cvG = C25738R.string.boh;
                        } else {
                            C4990ab.m7417i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", bZZ2, Integer.valueOf(9));
                            abf abf = new abf();
                            abl abl = new abl();
                            aar aar = new aar();
                            aar.mo27394LE(2);
                            aar.akV(bZZ2);
                            aar.akU(C1178g.m2591x((aar.toString() + 2 + System.currentTimeMillis()).getBytes()));
                            C37721gh c37721gh = new C37721gh();
                            c37721gh.cAH.type = 27;
                            c37721gh.cAH.cAJ = aar;
                            C4879a.xxA.mo10055m(c37721gh);
                            String str = c37721gh.cAI.thumbPath;
                            C5056d.m7656c(bZZ2, 150, 150, CompressFormat.JPEG, 90, str);
                            aar.akW(str);
                            abl.alD(C1853r.m3846Yz());
                            abl.alE(C1853r.m3846Yz());
                            abl.mo39126LN(9);
                            abl.mo39136ml(C5046bo.anU());
                            abf.mo74737a(abl);
                            abf.wiv.add(aar);
                            c45316cl.cvA.title = aar.title;
                            c45316cl.cvA.cvC = abf;
                            c45316cl.cvA.type = 2;
                        }
                        c45316cl.cvA.cvH = 4;
                        c45316cl.cvA.activity = mallGalleryUI2;
                        C4879a.xxA.mo10055m(c45316cl);
                        AppMethodBeat.m2505o(44038);
                        return;
                }
                AppMethodBeat.m2505o(44038);
            }
        }

        C35984() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            String[] stringArray;
            AppMethodBeat.m2504i(44039);
            if (C25985d.afj("favorite")) {
                stringArray = MallGalleryUI.this.getResources().getStringArray(C25738R.array.f12618z);
            } else {
                stringArray = MallGalleryUI.this.getResources().getStringArray(C25738R.array.f12619a0);
            }
            C30379h.m48424a(MallGalleryUI.this.mController.ylL, null, stringArray, null, false, new C35991());
            AppMethodBeat.m2505o(44039);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI$2 */
    class C36002 implements C31386a {
        C36002() {
        }

        public final void caa() {
            AppMethodBeat.m2504i(44036);
            MallGalleryUI.m5948c(MallGalleryUI.this);
            AppMethodBeat.m2505o(44036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI$1 */
    class C36011 implements OnPageChangeListener {
        C36011() {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(44035);
            C4990ab.m7411d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", Integer.valueOf(i));
            MallGalleryUI.this.piw = i;
            if (MallGalleryUI.this.pix) {
                MallGalleryUI.this.mController.hideTitleView();
                MallGalleryUI.this.pix = false;
            }
            AppMethodBeat.m2505o(44035);
        }

        public final synchronized void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallGalleryUI$3 */
    class C36023 implements OnMenuItemClickListener {
        C36023() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44037);
            MallGalleryUI.this.finish();
            AppMethodBeat.m2505o(44037);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970384;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44040);
        super.onCreate(bundle);
        this.piv = getIntent().getStringArrayListExtra("keys_img_urls");
        this.mController.hideTitleView();
        this.pix = false;
        initView();
        AppMethodBeat.m2505o(44040);
    }

    public void onResume() {
        AppMethodBeat.m2504i(44041);
        super.onResume();
        this.piu.setData(this.piv);
        this.piu.notifyDataSetChanged();
        if (this.piv != null) {
            this.piv.size();
        }
        AppMethodBeat.m2505o(44041);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44042);
        this.pit = (ViewPager) findViewById(2131826578);
        this.pit.setOnPageChangeListener(new C36011());
        this.piu = new C31385g(this);
        this.piu.piS = new C36002();
        this.pit.setAdapter(this.piu);
        setBackBtn(new C36023());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C35984());
        AppMethodBeat.m2505o(44042);
    }

    /* Access modifiers changed, original: final */
    public final String bZZ() {
        String str;
        AppMethodBeat.m2504i(44043);
        if (this.piv == null || this.piv.size() < this.piw + 1) {
            C4990ab.m7412e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.piv.get(this.piw);
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.MallGalleryUI", "invoke error. No current url");
            AppMethodBeat.m2505o(44043);
            return null;
        }
        String UK = C39492c.m67475UK(str);
        AppMethodBeat.m2505o(44043);
        return UK;
    }

    /* renamed from: c */
    static /* synthetic */ void m5948c(MallGalleryUI mallGalleryUI) {
        AppMethodBeat.m2504i(44044);
        mallGalleryUI.pix = !mallGalleryUI.pix;
        if (mallGalleryUI.pix) {
            mallGalleryUI.mController.showTitleView();
            AppMethodBeat.m2505o(44044);
            return;
        }
        mallGalleryUI.mController.hideTitleView();
        AppMethodBeat.m2505o(44044);
    }
}
