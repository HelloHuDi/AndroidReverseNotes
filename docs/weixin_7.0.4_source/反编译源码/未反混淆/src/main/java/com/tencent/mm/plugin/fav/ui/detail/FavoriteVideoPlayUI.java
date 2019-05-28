package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.j;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private boolean cHc = true;
    private String ePJ;
    private int eWK;
    private Bundle jWy;
    private boolean jYD = false;
    private e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74457);
            FavoriteVideoPlayUI.this.bcW();
            AppMethodBeat.o(74457);
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(74460);
            view.getTag();
            j jVar = new j(FavoriteVideoPlayUI.this.mController.ylL);
            jVar.rBl = new c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(74458);
                    if (FavoriteVideoPlayUI.this.mna) {
                        if (com.tencent.mm.vfs.e.ct(FavoriteVideoPlayUI.this.thumbPath)) {
                            lVar.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(R.string.bri));
                        }
                        lVar.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(R.string.dx0));
                    }
                    AppMethodBeat.o(74458);
                }
            };
            jVar.rBm = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(74459);
                    switch (menuItem.getItemId()) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (com.tencent.mm.vfs.e.ct(FavoriteVideoPlayUI.this.thumbPath)) {
                                intent.putExtra("image_path", FavoriteVideoPlayUI.this.thumbPath);
                            } else {
                                intent.putExtra("image_path", FavoriteVideoPlayUI.this.ePJ);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            com.tencent.mm.bp.d.b(FavoriteVideoPlayUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                            if (FavoriteVideoPlayUI.this.mnb == 0) {
                                h.j(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0), 1, 0);
                                AppMethodBeat.o(74459);
                                return;
                            }
                            break;
                        case 2:
                            FavoriteVideoPlayUI.f(FavoriteVideoPlayUI.this.ePJ, FavoriteVideoPlayUI.this);
                            break;
                    }
                    AppMethodBeat.o(74459);
                }
            };
            jVar.cuu();
            AppMethodBeat.o(74460);
            return true;
        }
    };
    private boolean mmD = true;
    private String mmV;
    private RelativeLayout mmW;
    private ImageView mmX;
    private FavVideoView mmY;
    private LinearLayout mmZ;
    private boolean mna = true;
    private int mnb;
    private boolean mnc = false;
    private String mnd = "";
    private String thumbPath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteVideoPlayUI() {
        AppMethodBeat.i(74466);
        AppMethodBeat.o(74466);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(74467);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.jWy = bundle;
        getWindow().addFlags(128);
        this.mna = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.ePJ = getIntent().getStringExtra("key_detail_fav_path");
        this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.eWK = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.mmV = getIntent().getStringExtra("key_detail_statExtStr");
        this.mnb = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mnc = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.mnd = getIntent().getStringExtra("key_detail_data_id");
        if (!com.tencent.mm.vfs.e.ct(this.thumbPath)) {
            Bitmap LY = com.tencent.mm.plugin.fav.ui.c.LY(this.ePJ);
            if (LY != null) {
                try {
                    ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    com.tencent.mm.sdk.platformtools.d.a(LY, 60, CompressFormat.JPEG, this.thumbPath, true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str2 = "MicroMsg.FavoriteVideoPlayUI";
        String str3 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mna);
        objArr[1] = bo.isNullOrNil(this.thumbPath) ? "" : this.thumbPath;
        if (bo.isNullOrNil(this.ePJ)) {
            str = "";
        } else {
            str = this.ePJ;
        }
        objArr[2] = str;
        ab.i(str2, str3, objArr);
        this.mmW = (RelativeLayout) findViewById(R.id.aew);
        this.mmY = (FavVideoView) findViewById(R.id.wh);
        ImageView imageView = (ImageView) findViewById(R.id.aex);
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.mmZ = (LinearLayout) findViewById(R.id.bp_);
        if (!(this.mna || this.mmZ == null)) {
            this.mmZ.setVisibility(0);
        }
        if (this.mmX != null) {
            this.mmX.setLayerType(2, null);
        }
        if (bo.isNullOrNil(this.ePJ)) {
            g(imageView);
        } else if (com.tencent.mm.vfs.e.ct(this.ePJ)) {
            this.mmY.setVideoData(this.ePJ);
            ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            g(imageView);
        }
        this.mmY.setOnClickListener(this.mjE);
        if (this.cHc) {
            this.mmY.setOnLongClickListener(this.mlV);
        }
        this.jYE = new e(null);
        AppMethodBeat.o(74467);
    }

    public final int getLayoutId() {
        return R.layout.z4;
    }

    private void g(ImageView imageView) {
        AppMethodBeat.i(74468);
        this.mmY.a(this.ePJ, this.mnc, this.mnd);
        if (imageView != null) {
            if (com.tencent.mm.vfs.e.ct(this.thumbPath)) {
                imageView.setImageBitmap(b.i(this.thumbPath, 1.0f));
            } else {
                imageView.setImageResource(R.drawable.b0z);
            }
        }
        ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
        AppMethodBeat.o(74468);
    }

    public static void f(String str, Context context) {
        AppMethodBeat.i(74469);
        String uu = u.uu(str);
        ab.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", str, uu);
        if (bo.isNullOrNil(uu)) {
            Toast.makeText(context, context.getString(R.string.f1c), 1).show();
            AppMethodBeat.o(74469);
            return;
        }
        Toast.makeText(context, context.getString(R.string.f1d, new Object[]{uu}), 1).show();
        n.a(uu, context);
        AppMethodBeat.o(74469);
    }

    public void onStart() {
        AppMethodBeat.i(74470);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.mmY.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(74463);
                            FavoriteVideoPlayUI.this.mmY.getViewTreeObserver().removeOnPreDrawListener(this);
                            FavoriteVideoPlayUI.this.jYE.a(FavoriteVideoPlayUI.this.mmY, FavoriteVideoPlayUI.this.mmX, new e.b() {
                                public final void onAnimationStart() {
                                    AppMethodBeat.i(74462);
                                    if (FavoriteVideoPlayUI.this.mmY != null) {
                                        FavoriteVideoPlayUI.this.mmY.onResume();
                                    }
                                    AppMethodBeat.o(74462);
                                }

                                public final void onAnimationEnd() {
                                }
                            });
                            AppMethodBeat.o(74463);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(74470);
    }

    public void onResume() {
        AppMethodBeat.i(74471);
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", Boolean.valueOf(this.mmD));
        if (!this.mmD) {
            this.mmY.onResume();
        }
        this.mmD = false;
        super.onResume();
        o.JV(1);
        AppMethodBeat.o(74471);
    }

    public void onPause() {
        AppMethodBeat.i(74472);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.mmY;
        ab.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.klq.isPlaying()) {
            ab.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.klq.pause();
        }
        super.onPause();
        o.JV(2);
        AppMethodBeat.o(74472);
    }

    public void onDestroy() {
        AppMethodBeat.i(74473);
        setResult(0, getIntent().putExtra("key_activity_browse_time", dyi()));
        this.mmY.onDestroy();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.o(74473);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(74474);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(74474);
        return dispatchKeyEvent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74475);
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final p b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            AnonymousClass3 anonymousClass3 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74461);
                    b.dismiss();
                    AppMethodBeat.o(74461);
                }
            };
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(74475);
                return;
            }
            for (String stringExtra2 : bo.P(stringExtra2.split(","))) {
                AppCompatActivity appCompatActivity = this.mController.ylL;
                String str2 = this.ePJ;
                String str3 = this.thumbPath;
                int i3 = this.eWK;
                String str4 = this.mmV;
                if (appCompatActivity == null) {
                    ab.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                } else if (bo.isNullOrNil(stringExtra2)) {
                    ab.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                } else {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
                    if (!bo.isNullOrNil(str2) || bVar.exists()) {
                        g.RS().aa(new com.tencent.mm.plugin.fav.ui.i.AnonymousClass5(appCompatActivity, stringExtra2, str2, str3, i3, str4, anonymousClass3));
                    } else {
                        ab.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                    }
                }
                if (!bo.isNullOrNil(str)) {
                    com.tencent.mm.plugin.messenger.a.g.bOk().F(stringExtra2, str, t.nK(stringExtra2));
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.bnf));
            AppMethodBeat.o(74475);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74475);
    }

    public final void bcW() {
        AppMethodBeat.i(74476);
        this.mmZ.setVisibility(8);
        int width = this.mmW.getWidth();
        int height = this.mmW.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.hw(width, height);
        this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.a(this.mmY, this.mmX, new e.b() {
            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(74465);
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74464);
                        FavoriteVideoPlayUI.this.finish();
                        FavoriteVideoPlayUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(74464);
                    }
                });
                AppMethodBeat.o(74465);
            }
        }, null);
        AppMethodBeat.o(74476);
    }

    public void onBackPressed() {
        AppMethodBeat.i(74477);
        bcW();
        AppMethodBeat.o(74477);
    }
}
