package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager pit;
    private g piu;
    private List<String> piv;
    private int piw = 0;
    private boolean pix;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.al1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44040);
        super.onCreate(bundle);
        this.piv = getIntent().getStringArrayListExtra("keys_img_urls");
        this.mController.hideTitleView();
        this.pix = false;
        initView();
        AppMethodBeat.o(44040);
    }

    public void onResume() {
        AppMethodBeat.i(44041);
        super.onResume();
        this.piu.setData(this.piv);
        this.piu.notifyDataSetChanged();
        if (this.piv != null) {
            this.piv.size();
        }
        AppMethodBeat.o(44041);
    }

    public final void initView() {
        AppMethodBeat.i(44042);
        this.pit = (ViewPager) findViewById(R.id.do4);
        this.pit.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageSelected(int i) {
                AppMethodBeat.i(44035);
                ab.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", Integer.valueOf(i));
                MallGalleryUI.this.piw = i;
                if (MallGalleryUI.this.pix) {
                    MallGalleryUI.this.mController.hideTitleView();
                    MallGalleryUI.this.pix = false;
                }
                AppMethodBeat.o(44035);
            }

            public final synchronized void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageScrollStateChanged(int i) {
            }
        });
        this.piu = new g(this);
        this.piu.piS = new g.a() {
            public final void caa() {
                AppMethodBeat.i(44036);
                MallGalleryUI.c(MallGalleryUI.this);
                AppMethodBeat.o(44036);
            }
        };
        this.pit.setAdapter(this.piu);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44037);
                MallGalleryUI.this.finish();
                AppMethodBeat.o(44037);
                return false;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                AppMethodBeat.i(44039);
                if (d.afj("favorite")) {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(R.array.z);
                } else {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(R.array.a0);
                }
                h.a(MallGalleryUI.this.mController.ylL, null, stringArray, null, false, new c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(44038);
                        MallGalleryUI mallGalleryUI;
                        switch (i) {
                            case 0:
                                mallGalleryUI = MallGalleryUI.this;
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", "");
                                intent.putExtra("Retr_Msg_Type", 0);
                                if (bo.isNullOrNil(mallGalleryUI.bZZ())) {
                                    ab.e("MicroMsg.MallGalleryUI", "url is null or nil");
                                    AppMethodBeat.o(44038);
                                    return;
                                }
                                intent.putExtra("Retr_File_Name", mallGalleryUI.bZZ());
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                d.f(mallGalleryUI, ".ui.transmit.MsgRetransmitUI", intent);
                                AppMethodBeat.o(44038);
                                return;
                            case 1:
                                mallGalleryUI = MallGalleryUI.this;
                                String bZZ = mallGalleryUI.bZZ();
                                if (bo.isNullOrNil(bZZ)) {
                                    ab.w("MicroMsg.MallGalleryUI", "save error.");
                                    AppMethodBeat.o(44038);
                                    return;
                                }
                                ab.d("MicroMsg.MallGalleryUI", "can save. img path: %s", bZZ);
                                n.j(bZZ, mallGalleryUI);
                                AppMethodBeat.o(44038);
                                return;
                            case 2:
                                MallGalleryUI mallGalleryUI2 = MallGalleryUI.this;
                                String bZZ2 = mallGalleryUI2.bZZ();
                                if (bo.isNullOrNil(bZZ2)) {
                                    ab.w("MicroMsg.MallGalleryUI", "file path invalid");
                                    break;
                                }
                                ab.d("MicroMsg.MallGalleryUI", "file path valid");
                                cl clVar = new cl();
                                if (bo.isNullOrNil(bZZ2)) {
                                    ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                                    clVar.cvA.cvG = R.string.boh;
                                } else {
                                    ab.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", bZZ2, Integer.valueOf(9));
                                    abf abf = new abf();
                                    abl abl = new abl();
                                    aar aar = new aar();
                                    aar.LE(2);
                                    aar.akV(bZZ2);
                                    aar.akU(g.x((aar.toString() + 2 + System.currentTimeMillis()).getBytes()));
                                    gh ghVar = new gh();
                                    ghVar.cAH.type = 27;
                                    ghVar.cAH.cAJ = aar;
                                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                    String str = ghVar.cAI.thumbPath;
                                    com.tencent.mm.sdk.platformtools.d.c(bZZ2, 150, 150, CompressFormat.JPEG, 90, str);
                                    aar.akW(str);
                                    abl.alD(r.Yz());
                                    abl.alE(r.Yz());
                                    abl.LN(9);
                                    abl.ml(bo.anU());
                                    abf.a(abl);
                                    abf.wiv.add(aar);
                                    clVar.cvA.title = aar.title;
                                    clVar.cvA.cvC = abf;
                                    clVar.cvA.type = 2;
                                }
                                clVar.cvA.cvH = 4;
                                clVar.cvA.activity = mallGalleryUI2;
                                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                AppMethodBeat.o(44038);
                                return;
                        }
                        AppMethodBeat.o(44038);
                    }
                });
                AppMethodBeat.o(44039);
                return true;
            }
        });
        AppMethodBeat.o(44042);
    }

    /* Access modifiers changed, original: final */
    public final String bZZ() {
        String str;
        AppMethodBeat.i(44043);
        if (this.piv == null || this.piv.size() < this.piw + 1) {
            ab.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.piv.get(this.piw);
        }
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
            AppMethodBeat.o(44043);
            return null;
        }
        String UK = c.UK(str);
        AppMethodBeat.o(44043);
        return UK;
    }

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        AppMethodBeat.i(44044);
        mallGalleryUI.pix = !mallGalleryUI.pix;
        if (mallGalleryUI.pix) {
            mallGalleryUI.mController.showTitleView();
            AppMethodBeat.o(44044);
            return;
        }
        mallGalleryUI.mController.hideTitleView();
        AppMethodBeat.o(44044);
    }
}
