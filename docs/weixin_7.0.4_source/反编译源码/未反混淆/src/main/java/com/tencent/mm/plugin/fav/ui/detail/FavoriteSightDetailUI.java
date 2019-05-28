package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.d;

public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements p, a {
    private aar cAv;
    private k mjD = new k();
    private g mjP;
    private boolean mlN = false;
    private boolean mlT = false;
    private VideoPlayerTextureView mmA;
    private ImageView mmB;
    private long mmC;
    private boolean mmD = true;
    private boolean mmE = false;
    private Runnable mmF = new Runnable() {
        public final void run() {
            AppMethodBeat.i(74420);
            if (FavoriteSightDetailUI.this.mjP.isDone() && b.f(FavoriteSightDetailUI.this.cAv) && FavoriteSightDetailUI.this.mmA != null && FavoriteSightDetailUI.this.mmA.isPlaying()) {
                AppMethodBeat.o(74420);
                return;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true);
            AppMethodBeat.o(74420);
        }
    };
    private boolean mmG = false;
    private View mmx;
    private ImageView mmy;
    private MMPinProgressBtn mmz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteSightDetailUI() {
        AppMethodBeat.i(74423);
        AppMethodBeat.o(74423);
    }

    static /* synthetic */ void f(FavoriteSightDetailUI favoriteSightDetailUI) {
        AppMethodBeat.i(74436);
        favoriteSightDetailUI.bwo();
        AppMethodBeat.o(74436);
    }

    public final int getLayoutId() {
        return R.layout.za;
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.i(74424);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.bsd);
        AppMethodBeat.o(74424);
        return mMLoadScrollView;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74425);
        f.m(this);
        super.onCreate(bundle);
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mjP = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mmC);
        if (this.mjP == null) {
            ab.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", Long.valueOf(this.mmC));
            finish();
            AppMethodBeat.o(74425);
            return;
        }
        F(this.mjP);
        m.w(this.mjP);
        a.a(this, this.mjP);
        this.cAv = b.c(this.mjP);
        this.mmy = (ImageView) findViewById(R.id.l4);
        this.mmz = (MMPinProgressBtn) findViewById(R.id.af0);
        this.mmx = findViewById(R.id.bsf);
        this.mmA = (VideoPlayerTextureView) findViewById(R.id.wh);
        this.mmB = (ImageView) findViewById(R.id.aex);
        this.mmx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74408);
                if (com.tencent.mm.r.a.bJ(view.getContext()) || com.tencent.mm.r.a.bH(view.getContext())) {
                    AppMethodBeat.o(74408);
                    return;
                }
                ab.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_id), Long.valueOf(FavoriteSightDetailUI.this.mjP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_itemStatus));
                if (FavoriteSightDetailUI.this.mjP.isDone()) {
                    if (b.f(FavoriteSightDetailUI.this.cAv)) {
                        m.a(m.a.EnterFullScreen, FavoriteSightDetailUI.this.mjP);
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, view.getContext());
                        AppMethodBeat.o(74408);
                        return;
                    } else if (bo.isNullOrNil(FavoriteSightDetailUI.this.cAv.wfZ)) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                        AppMethodBeat.o(74408);
                        return;
                    } else {
                        ab.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (FavoriteSightDetailUI.this.mjP.buy()) {
                    if (bo.isNullOrNil(FavoriteSightDetailUI.this.cAv.wfZ)) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                        AppMethodBeat.o(74408);
                        return;
                    }
                } else if (FavoriteSightDetailUI.this.mjP.isDownloading() || FavoriteSightDetailUI.this.mjP.buw()) {
                    if (FavoriteSightDetailUI.this.mmz.getVisibility() == 8) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
                    }
                    AppMethodBeat.o(74408);
                    return;
                }
                if (FavoriteSightDetailUI.this.mjP.bux()) {
                    b.l(FavoriteSightDetailUI.this.mjP);
                } else {
                    b.m(FavoriteSightDetailUI.this.mjP);
                }
                FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
                AppMethodBeat.o(74408);
            }
        });
        this.mmA.setVideoCallback(new e.a() {
            public final void pL() {
                AppMethodBeat.i(74411);
                ab.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
                FavoriteSightDetailUI.this.mmA.setLoop(true);
                FavoriteSightDetailUI.this.mmE = FavoriteSightDetailUI.this.mmA.start();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74409);
                        FavoriteSightDetailUI.this.mmB.setVisibility(8);
                        AppMethodBeat.o(74409);
                    }
                });
                AppMethodBeat.o(74411);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(74412);
                ab.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == -1) {
                    FavoriteSightDetailUI.this.mmA.stop();
                    if (com.tencent.mm.vfs.e.ct(b.b(FavoriteSightDetailUI.this.cAv))) {
                        FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
                        AppMethodBeat.o(74412);
                        return;
                    }
                    if (com.tencent.mm.vfs.e.ct(b.c(FavoriteSightDetailUI.this.cAv))) {
                        FavoriteSightDetailUI.this.mmB.setVisibility(0);
                    }
                    AppMethodBeat.o(74412);
                } else if (FavoriteSightDetailUI.this.mmE) {
                    EA();
                    AppMethodBeat.o(74412);
                } else {
                    FavoriteSightDetailUI.this.mmA.stop();
                    if (FavoriteSightDetailUI.this.mlN) {
                        AppMethodBeat.o(74412);
                        return;
                    }
                    FavoriteSightDetailUI.this.mlN = true;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74410);
                            h.g(FavoriteSightDetailUI.this.mController.ylL, R.string.f1a, R.string.f1j);
                            AppMethodBeat.o(74410);
                        }
                    });
                    AppMethodBeat.o(74412);
                }
            }

            public final void EA() {
                AppMethodBeat.i(74413);
                FavoriteSightDetailUI.this.mmA.B(0.0d);
                AppMethodBeat.o(74413);
            }

            public final int dG(int i, int i2) {
                return 0;
            }

            public final void dH(int i, int i2) {
            }
        });
        setMMTitle(getString(R.string.bns));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74414);
                FavoriteSightDetailUI.this.finish();
                AppMethodBeat.o(74414);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.ewm, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74419);
                d dVar = new d(FavoriteSightDetailUI.this.mController.ylL, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(74415);
                        int i = (!FavoriteSightDetailUI.this.mjP.but() || FavoriteSightDetailUI.this.mjD.t(FavoriteSightDetailUI.this.mjP)) ? 0 : 1;
                        if (i != 0 && FavoriteSightDetailUI.this.cAv.whh == 0) {
                            lVar.e(0, FavoriteSightDetailUI.this.getString(R.string.bri));
                        }
                        lVar.e(4, FavoriteSightDetailUI.this.getString(R.string.br7));
                        lVar.e(3, FavoriteSightDetailUI.this.getString(R.string.bo8));
                        lVar.e(2, FavoriteSightDetailUI.this.mController.ylL.getString(R.string.p4));
                        AppMethodBeat.o(74415);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(74418);
                        Intent intent;
                        com.tencent.mm.plugin.fav.a.h.a aVar;
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.plugin.fav.a.h.j(FavoriteSightDetailUI.this.mjP.field_localId, 1, 0);
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.this.mjP.field_localId);
                                com.tencent.mm.bp.d.b(FavoriteSightDetailUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                                aVar = FavoriteSightDetailUI.this.mlz;
                                aVar.meZ++;
                                AppMethodBeat.o(74418);
                                return;
                            case 2:
                                h.a(FavoriteSightDetailUI.this.mController.ylL, FavoriteSightDetailUI.this.getString(R.string.p5), "", new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(74417);
                                        final com.tencent.mm.ui.base.p b = h.b(FavoriteSightDetailUI.this.mController.ylL, FavoriteSightDetailUI.this.getString(R.string.p5), false, null);
                                        b.a(FavoriteSightDetailUI.this.mjP.field_localId, new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(74416);
                                                FavoriteSightDetailUI.this.mlz.mfd = true;
                                                b.dismiss();
                                                ab.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteSightDetailUI.this.mjP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_id));
                                                FavoriteSightDetailUI.this.finish();
                                                AppMethodBeat.o(74416);
                                            }
                                        });
                                        AppMethodBeat.o(74417);
                                    }
                                }, null);
                                AppMethodBeat.o(74418);
                                return;
                            case 3:
                                aVar = FavoriteSightDetailUI.this.mlz;
                                aVar.mfc++;
                                intent = new Intent();
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteSightDetailUI.this.mjP.field_localId);
                                b.b(FavoriteSightDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                AppMethodBeat.o(74418);
                                return;
                            case 4:
                                com.tencent.mm.plugin.fav.ui.g.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.this.mmC, FavoriteSightDetailUI.this.mlz);
                                break;
                        }
                        AppMethodBeat.o(74418);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(74419);
                return true;
            }
        });
        if (com.tencent.mm.vfs.e.ct(b.c(this.cAv))) {
            Bitmap a = com.tencent.mm.plugin.fav.ui.l.a(this.cAv, this.mjP);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.mmG) {
                    this.mmG = true;
                    DisplayMetrics displayMetrics = this.mmx.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.mmx.getLayoutParams();
                    if (layoutParams == null) {
                        ab.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.mmx.setLayoutParams(layoutParams);
                    }
                }
                this.mmB.setImageBitmap(a);
                this.mmB.setVisibility(0);
            }
        } else if (!bo.isNullOrNil(this.cAv.fgE)) {
            b.a(this.mjP, this.cAv);
        }
        hm(false);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(this);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(this);
        f.n(this);
        AppMethodBeat.o(74425);
    }

    public void onDestroy() {
        AppMethodBeat.i(74426);
        if (this.mmA != null) {
            this.mmA.setVideoCallback(null);
            this.mmA.stop();
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(this);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(this);
        super.onDestroy();
        AppMethodBeat.o(74426);
    }

    public void onResume() {
        AppMethodBeat.i(74427);
        super.onResume();
        if (this.mmA != null) {
            if (!this.mmD) {
                bwo();
            } else if (!this.mmA.isPlaying()) {
                this.mmA.start();
            }
            this.mmD = false;
        }
        AppMethodBeat.o(74427);
    }

    public void onPause() {
        AppMethodBeat.i(74428);
        if (this.mmA != null) {
            this.mmA.stop();
        }
        super.onPause();
        AppMethodBeat.o(74428);
    }

    @SuppressLint({"ResourceType"})
    private void hm(boolean z) {
        AppMethodBeat.i(74429);
        if (this.mjP.isDone()) {
            if (b.f(this.cAv)) {
                this.mmy.setVisibility(8);
                this.mmz.setVisibility(8);
                bwo();
                AppMethodBeat.o(74429);
                return;
            } else if (bo.isNullOrNil(this.cAv.wfZ)) {
                this.mmy.setImageResource(R.raw.shortvideo_play_btn);
            } else {
                ab.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.mmy.setImageResource(R.raw.shortvideo_play_btn);
            }
        } else if (this.mjP.buy()) {
            if (bo.isNullOrNil(this.cAv.wfZ)) {
                this.mmy.setImageResource(R.raw.shortvideo_play_btn);
                if (z) {
                }
            } else {
                this.mmy.setImageResource(R.raw.shortvideo_play_btn);
                if (z) {
                    h.bQ(this.mController.ylL, getString(R.string.b6p));
                }
            }
        } else if (this.mjP.bux()) {
            this.mmy.setImageResource(R.raw.shortvideo_play_btn);
            if (z) {
                h.bQ(this.mController.ylL, getString(R.string.bnk));
            }
        } else if (this.mjP.isDownloading() || this.mjP.buw()) {
            this.mmy.setVisibility(8);
            this.mmz.setVisibility(0);
            com.tencent.mm.plugin.fav.a.c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd);
            if (LR != null) {
                this.mmz.setProgress((int) LR.getProgress());
            } else {
                this.mmz.setProgress(0);
            }
            this.mmB.setVisibility(0);
            AppMethodBeat.o(74429);
            return;
        } else {
            ab.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.mmy.setImageResource(R.raw.shortvideo_play_btn);
        }
        this.mmy.setVisibility(0);
        this.mmz.setVisibility(8);
        this.mmB.setVisibility(0);
        AppMethodBeat.o(74429);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(74430);
        ab.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.mjP.field_localId));
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mjP.field_localId);
        if (iE == null) {
            ab.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            AppMethodBeat.o(74430);
            return;
        }
        boolean z;
        this.mjP = iE;
        this.cAv = b.c(iE);
        com.tencent.mm.plugin.fav.a.c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd);
        if (LR == null) {
            z = false;
        } else if (this.mlT) {
            z = false;
        } else {
            if (LR.field_status == 4 && ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd).field_extFlag != 0) {
                b.a(this.mjP, this.cAv, true);
                this.mlT = true;
            }
            ab.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.mlT));
            z = this.mlT;
        }
        if (z) {
            AppMethodBeat.o(74430);
            return;
        }
        al.af(this.mmF);
        al.n(this.mmF, 500);
        AppMethodBeat.o(74430);
    }

    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(74431);
        if (cVar == null || cVar.field_dataId == null) {
            ab.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.o(74431);
            return;
        }
        ab.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", this.cAv.mnd, cVar.field_dataId, Integer.valueOf(cVar.field_offset), Integer.valueOf(cVar.field_totalLen), Integer.valueOf(cVar.field_status), Integer.valueOf(cVar.field_type));
        if (cVar.field_offset > cVar.field_totalLen) {
            ab.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == cVar.field_type) {
                cVar.field_status = 2;
            } else {
                cVar.field_status = 4;
            }
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(cVar, new String[0]);
            if (cVar.field_type == 0) {
                b.a(cVar);
            }
            if (cVar.field_type == 1) {
                b.b(cVar);
            }
        }
        if (cVar.field_dataId.equals(this.cAv.mnd)) {
            final int progress = (int) cVar.getProgress();
            this.mmz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74421);
                    FavoriteSightDetailUI.this.mmz.setProgress(progress);
                    AppMethodBeat.o(74421);
                }
            });
        }
        AppMethodBeat.o(74431);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74432);
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final com.tencent.mm.ui.base.p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            i.a(this.mController.ylL, stringExtra, str, this.mjP, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74422);
                    b.dismiss();
                    AppMethodBeat.o(74422);
                }
            });
            boolean kH = t.kH(stringExtra);
            m.a(kH ? m.c.Chatroom : m.c.Chat, this.mjP, m.d.Samll, kH ? com.tencent.mm.model.n.mA(stringExtra) : 0);
            com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.bnf));
            AppMethodBeat.o(74432);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74432);
    }

    private void bwo() {
        AppMethodBeat.i(74433);
        String b = b.b(this.cAv);
        if (com.tencent.mm.vfs.e.ct(b)) {
            this.mmA.stop();
            this.mmA.setMute(true);
            this.mmA.setVideoPath(b);
            AppMethodBeat.o(74433);
            return;
        }
        AppMethodBeat.o(74433);
    }

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        AppMethodBeat.i(74434);
        aar c = b.c(favoriteSightDetailUI.mjP);
        Intent intent;
        if (c == null) {
            ab.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(74434);
        } else if (c.wgZ == null || (bo.isNullOrNil(c.wgZ.fiG) && bo.isNullOrNil(c.wgZ.fiK))) {
            intent = new Intent();
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.mjP.field_localId);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.mlz.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.mlz.jSW);
            intent.putExtra("key_detail_fav_path", b.b(c));
            intent.putExtra("key_detail_fav_thumb_path", b.c(c));
            intent.putExtra("key_detail_fav_video_duration", c.duration);
            intent.putExtra("key_detail_statExtStr", c.cMn);
            intent.putExtra("key_detail_data_valid", z);
            b.b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
            AppMethodBeat.o(74434);
        } else {
            ab.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            intent = new Intent();
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.mlz.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.mlz.jSW);
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.mjP.field_localId);
            intent.putExtra("key_detail_data_id", c.mnd);
            intent.putExtra("key_detail_can_delete", false);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.o(74434);
        }
    }
}
