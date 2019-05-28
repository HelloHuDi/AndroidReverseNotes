package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class ArtistUI extends MMActivity implements f {
    private SharedPreferences ehZ;
    private ListView gGW;
    ak lda = af.bCo();
    private String nJy = "";
    private f rgL;
    private ArtistHeader rgM;
    private m rgN = null;
    g rgO = af.cnC();
    b rgP = af.cnA();
    private Runnable rgQ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38114);
            if (ArtistUI.this.rgL == null) {
                AppMethodBeat.o(38114);
                return;
            }
            ab.d("MicroMsg.ArtistUI", "will pause ImageLoader");
            af.cnC().pause();
            AppMethodBeat.o(38114);
        }
    };
    private Runnable rgR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38115);
            if (ArtistUI.this.rgL == null) {
                AppMethodBeat.o(38115);
                return;
            }
            ab.d("MicroMsg.ArtistUI", "will start ImageLoader");
            af.cnC().start();
            ArtistUI.this.rgL.notifyDataSetChanged();
            AppMethodBeat.o(38115);
        }
    };
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ArtistUI() {
        AppMethodBeat.i(38122);
        AppMethodBeat.o(38122);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38123);
        super.onCreate(bundle);
        String g = aa.g(getSharedPreferences(ah.doA(), 0));
        ab.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(g)));
        if (!(g.equals("zh_CN") || g.equals("en") || g.equals("zh_TW"))) {
            g = g.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nJy = g;
        ab.d("MicroMsg.ArtistUI", "lan " + this.nJy);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        this.ehZ = getSharedPreferences(ah.doA(), 0);
        initView();
        af.cnA().a(this.rgM);
        AppMethodBeat.o(38123);
    }

    public void onDestroy() {
        AppMethodBeat.i(38124);
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog = null;
        }
        if (this.rgM != null) {
            af.cnA().b(this.rgM);
        }
        af.cnC().ab(this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
        AppMethodBeat.o(38124);
    }

    public void onResume() {
        AppMethodBeat.i(38125);
        super.onResume();
        AppMethodBeat.o(38125);
    }

    public void onPause() {
        AppMethodBeat.i(38126);
        super.onPause();
        AppMethodBeat.o(38126);
    }

    public final void initView() {
        AppMethodBeat.i(38127);
        setMMTitle((int) R.string.eat);
        getString(R.string.tz);
        this.tipDialog = h.b((Context) this, getString(R.string.re), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.gGW = (ListView) findViewById(R.id.eh5);
        a.gkF.bj(false);
        this.rgL = new f(this, this.nJy, new b() {
            public final void DM(int i) {
                AppMethodBeat.i(38116);
                Intent intent = new Intent();
                intent.putExtra("sns_gallery_is_artist", true);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_artist_lan", ArtistUI.this.nJy);
                intent.putExtra("sns_gallery_showtype", 2);
                intent.setClass(ArtistUI.this, ArtistBrowseUI.class);
                ArtistUI.this.startActivity(intent);
                AppMethodBeat.o(38116);
            }
        }, new f.a() {
            public final void a(fq fqVar) {
                AppMethodBeat.i(38117);
                if (ArtistUI.this.rgM != null) {
                    ArtistUI.this.rgM.setVisibility(0);
                    ArtistUI.this.rgM.setUserName(fqVar);
                    String str = fqVar.Name;
                    if (!(str == null || str.equals(""))) {
                        ArtistUI.this.ehZ.edit().putString("artist_name", str).commit();
                    }
                    if (ArtistUI.this.rgL != null) {
                        ArtistUI.this.rgL.notifyDataSetChanged();
                    }
                }
                ArtistUI.this.tipDialog.dismiss();
                AppMethodBeat.o(38117);
            }

            public final void b(fq fqVar) {
                AppMethodBeat.i(38118);
                if (ArtistUI.this.rgM != null) {
                    ArtistUI.this.rgM.setVisibility(0);
                    ArtistUI.this.rgM.setUserName(fqVar);
                }
                AppMethodBeat.o(38118);
            }

            public final void crx() {
                AppMethodBeat.i(38119);
                if (ArtistUI.this.rgN == null && ArtistUI.this.tipDialog != null) {
                    ab.d("MicroMsg.ArtistUI", "onNothingBgGet");
                    a.gkF.bj(true);
                }
                AppMethodBeat.o(38119);
            }
        });
        this.gGW.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(38120);
                if (i == 2) {
                    if (ArtistUI.this.rgO.qHJ || ArtistUI.this.rgP.qHJ) {
                        ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgQ);
                        ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgR);
                        ArtistUI.this.lda.postDelayed(ArtistUI.this.rgQ, 0);
                        AppMethodBeat.o(38120);
                        return;
                    }
                } else if (ArtistUI.this.rgO.qHJ && ArtistUI.this.rgP.qHJ) {
                    AppMethodBeat.o(38120);
                    return;
                } else {
                    ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgQ);
                    ArtistUI.this.lda.removeCallbacks(ArtistUI.this.rgR);
                    ArtistUI.this.lda.postDelayed(ArtistUI.this.rgR, 0);
                }
                AppMethodBeat.o(38120);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.rgM = new ArtistHeader(this);
        this.gGW.addHeaderView(this.rgM);
        this.gGW.setAdapter(this.rgL);
        this.rgL.notifyDataSetChanged();
        this.rgM.setVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38121);
                ArtistUI.this.finish();
                AppMethodBeat.o(38121);
                return true;
            }
        });
        AppMethodBeat.o(38127);
    }

    public final int getLayoutId() {
        return R.layout.auu;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(38128);
        if ((mVar instanceof o) && ((o) mVar).acR() == 4) {
            ab.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                        if (this.rgL != null) {
                            this.rgL.KC();
                        }
                        this.rgN = null;
                        break;
                }
                AppMethodBeat.o(38128);
                return;
            }
            if (mVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX && this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.o(38128);
            return;
        }
        ab.d("MicroMsg.ArtistUI", "another scene");
        AppMethodBeat.o(38128);
    }
}
