package com.tencent.mm.plugin.fav.ui.detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavoriteFileDetailUI extends BaseFavDetailReportUI implements p, a {
    private aar cAv;
    private boolean cHc = true;
    private long cvv;
    private ak fbD;
    private TextView gxi;
    private TextView iqU;
    private int jLX;
    private int jLY;
    private com.tencent.mm.ui.widget.b.a jMO = null;
    private e klq = null;
    private d lCi = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            CharSequence string;
            AppMethodBeat.i(74344);
            ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            if (FavoriteFileDetailUI.this.cAv.title.equals("")) {
                string = FavoriteFileDetailUI.this.getString(R.string.dar);
            } else {
                string = FavoriteFileDetailUI.this.cAv.title;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, string));
            h.bQ(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(R.string.oz));
            AppMethodBeat.o(74344);
        }
    };
    private g mgf;
    private k mjD = new k();
    private Button mlD;
    private Button mlE;
    private Button mlF;
    private MMImageView mlG;
    private TextView mlH;
    private View mlI;
    private View mlJ;
    private TextView mlK;
    private ImageView mlL;
    private TextView mlM;
    private boolean mlN = false;
    private boolean mlO = false;
    private String mlP;
    private String mlQ;
    private boolean mlR = false;
    private boolean mlS = false;
    private boolean mlT = false;
    private OnTouchListener mlU = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(74322);
            switch (motionEvent.getAction()) {
                case 0:
                    FavoriteFileDetailUI.this.jLX = (int) motionEvent.getRawX();
                    FavoriteFileDetailUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(74322);
            return false;
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(74323);
            ab.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
            if (FavoriteFileDetailUI.this.jMO == null) {
                FavoriteFileDetailUI.this.jMO = new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.mController.ylL);
            }
            FavoriteFileDetailUI.this.jMO.a(view, FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.lCi, FavoriteFileDetailUI.this.jLX, FavoriteFileDetailUI.this.jLY);
            AppMethodBeat.o(74323);
            return true;
        }
    };
    private ProgressBar progressBar;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteFileDetailUI() {
        AppMethodBeat.i(74345);
        AppMethodBeat.o(74345);
    }

    static /* synthetic */ int c(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74365);
        int type = favoriteFileDetailUI.getType();
        AppMethodBeat.o(74365);
        return type;
    }

    static /* synthetic */ void e(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74366);
        favoriteFileDetailUI.bnS();
        AppMethodBeat.o(74366);
    }

    static /* synthetic */ void g(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74368);
        favoriteFileDetailUI.bwi();
        AppMethodBeat.o(74368);
    }

    static /* synthetic */ void i(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74369);
        favoriteFileDetailUI.bwj();
        AppMethodBeat.o(74369);
    }

    static /* synthetic */ void v(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74373);
        favoriteFileDetailUI.hl(true);
        AppMethodBeat.o(74373);
    }

    public final int getLayoutId() {
        return R.layout.z7;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bwg() {
        AppMethodBeat.i(74346);
        this.mlQ = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.mgf.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(this.mlQ)) {
                this.cAv = aar;
                break;
            }
        }
        if (this.cAv == null) {
            this.cAv = b.c(this.mgf);
        }
        AppMethodBeat.o(74346);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(74347);
        super.onCreate(bundle);
        this.fbD = new ak();
        this.cvv = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mlO = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mlP = getIntent().getStringExtra("fav_note_xml");
        this.mgf = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.cvv);
        if (this.mlO && !bo.isNullOrNil(this.mlP)) {
            this.mgf = b.LF(this.mlP);
        }
        if (this.mgf == null) {
            ab.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            AppMethodBeat.o(74347);
            return;
        }
        String str;
        F(this.mgf);
        m.w(this.mgf);
        bwg();
        this.mlD = (Button) findViewById(R.id.bsb);
        this.mlE = (Button) findViewById(R.id.bsc);
        this.mlF = (Button) findViewById(R.id.at4);
        this.mlG = (MMImageView) findViewById(R.id.rq);
        this.gxi = (TextView) findViewById(R.id.rr);
        this.iqU = (TextView) findViewById(R.id.bn0);
        this.mlJ = findViewById(R.id.zi);
        this.mlI = findViewById(R.id.zg);
        this.progressBar = (ProgressBar) findViewById(R.id.zh);
        this.mlH = (TextView) findViewById(R.id.bsa);
        this.mlK = (TextView) findViewById(R.id.ee0);
        this.mlL = (ImageView) findViewById(R.id.bs9);
        this.mlM = (TextView) findViewById(R.id.bs_);
        this.gxi.setOnTouchListener(this.mlU);
        this.gxi.setOnLongClickListener(this.mlV);
        int type = getType();
        if (4 == type) {
            setMMTitle((int) R.string.bs9);
        } else if (15 == type) {
            setMMTitle((int) R.string.bs9);
            findViewById(R.id.bs7).setBackgroundResource(R.color.h4);
            this.gxi.setVisibility(8);
        } else {
            setMMTitle((int) R.string.bp0);
        }
        if (this.cAv.dataType == 4) {
            this.mlG.setImageResource(R.raw.app_attach_file_icon_video);
        } else {
            this.mlG.setImageResource(((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.ab.class)).LU(this.cAv.wgo));
        }
        this.gxi.setText(this.cAv.title);
        aau aau = this.cAv.wgZ;
        if (aau == null) {
            this.mlK.setVisibility(8);
        } else if (bo.isNullOrNil(aau.fiG)) {
            ab.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            str = aau.fiJ;
            final String str2 = aau.fiK;
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                this.mlK.setVisibility(8);
            } else {
                this.mlK.setText(str);
                this.mlK.setVisibility(0);
                this.mlK.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(74321);
                        final Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.this.cAv.cMn);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        new ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(74320);
                                com.tencent.mm.bp.d.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                FavoriteFileDetailUI.this.finish();
                                AppMethodBeat.o(74320);
                            }
                        });
                        AppMethodBeat.o(74321);
                    }
                });
            }
        } else {
            str = getResources().getString(R.string.ej7);
            if (aau.wid / 60 > 0) {
                str = str + getResources().getString(R.string.ej9, new Object[]{Integer.valueOf(aau.wid / 60)});
            }
            if (aau.wid % 60 > 0) {
                str = str + getResources().getString(R.string.ej_, new Object[]{Integer.valueOf(aau.wid % 60)});
            }
            this.mlK.setText(str + getResources().getString(R.string.ej8));
            this.mlK.setVisibility(0);
            this.mlK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74332);
                    m.a(m.a.EnterCompleteVideo, FavoriteFileDetailUI.this.mgf);
                    aau aau = FavoriteFileDetailUI.this.cAv.wgZ;
                    String c = b.c(FavoriteFileDetailUI.this.cAv);
                    Intent intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", aau.fiG);
                    intent.putExtra("StreamWording", aau.fiJ);
                    intent.putExtra("StremWebUrl", aau.fiK);
                    intent.putExtra("KBlockFav", true);
                    intent.putExtra("KThumUrl", aau.fiL);
                    intent.putExtra("KThumbPath", c);
                    intent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.this.mgf.field_id);
                    intent.putExtra("KMediaVideoTime", aau.wid);
                    intent.putExtra("KMediaTitle", FavoriteFileDetailUI.this.cAv.title);
                    intent.putExtra("KSta_StremVideoAduxInfo", aau.fiM);
                    intent.putExtra("KSta_StremVideoPublishId", aau.fiN);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", m.b.Fav.value);
                    intent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.this.mgf.field_fromUser);
                    intent.putExtra("KSta_FavID", FavoriteFileDetailUI.this.mgf.field_id);
                    intent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.this.cAv.cMn);
                    com.tencent.mm.bp.d.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", intent);
                    AppMethodBeat.o(74332);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74333);
                m.a(m.a.LeavelFullScreen, FavoriteFileDetailUI.this.mgf);
                FavoriteFileDetailUI.this.finish();
                AppMethodBeat.o(74333);
                return true;
            }
        });
        this.mlE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74334);
                String b = b.b(FavoriteFileDetailUI.this.cAv);
                if (4 == FavoriteFileDetailUI.c(FavoriteFileDetailUI.this)) {
                    FavoriteFileDetailUI.this.mlR = false;
                    FavoriteFileDetailUI.e(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(74334);
                    return;
                }
                FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, b);
                AppMethodBeat.o(74334);
            }
        });
        str = this.cAv.wgg;
        if (!bo.isNullOrNil(str)) {
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74335);
                    ab.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id), Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", FavoriteFileDetailUI.this.mgf.field_localId);
                    intent.putExtra("geta8key_scene", 14);
                    intent.putExtra("geta8key_scene", 14);
                    com.tencent.mm.bp.d.b(FavoriteFileDetailUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(74335);
                }
            });
        }
        this.mlF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74336);
                ab.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id), Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId), Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_itemStatus));
                if (f.Mn()) {
                    if (FavoriteFileDetailUI.this.mgf.bux() || bo.isNullOrNil(FavoriteFileDetailUI.this.cAv.wfZ)) {
                        b.l(FavoriteFileDetailUI.this.mgf);
                    } else if (FavoriteFileDetailUI.this.mlO) {
                        FavoriteFileDetailUI.this.mgf.field_itemStatus = 7;
                        b.b(FavoriteFileDetailUI.this.cAv, 18, -1);
                    } else {
                        b.a(FavoriteFileDetailUI.this.mgf, FavoriteFileDetailUI.this.cAv, true);
                    }
                    FavoriteFileDetailUI.g(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(74336);
                    return;
                }
                h.g(FavoriteFileDetailUI.this.mController.ylL, R.string.bpt, R.string.bnl);
                AppMethodBeat.o(74336);
            }
        });
        this.mlJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74337);
                if (FavoriteFileDetailUI.this.mgf.isDownloading()) {
                    b.d(FavoriteFileDetailUI.this.cAv);
                    FavoriteFileDetailUI.this.mlF.setText(R.string.bpg);
                } else {
                    b.n(FavoriteFileDetailUI.this.mgf);
                    FavoriteFileDetailUI.this.mlF.setText(R.string.bph);
                }
                FavoriteFileDetailUI.i(FavoriteFileDetailUI.this);
                AppMethodBeat.o(74337);
            }
        });
        if (this.cHc) {
            boolean z2;
            final boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            final int type2 = getType();
            if (type2 == 8) {
                z = this.mgf.but();
            } else if (type2 == 15) {
                z2 = this.mgf.but() && bo.ank(com.tencent.mm.m.g.Nu().getValue("SIGHTCannotTransmitForFav")) == 0;
                if (z2 || booleanExtra) {
                    addIconOptionMenu(0, R.string.ewm, R.drawable.uu, new OnMenuItemClickListener() {
                        /* JADX WARNING: Missing block: B:5:0x0025, code skipped:
            if (com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.a(r5.mlX).whh == 0) goto L_0x002f;
     */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(74343);
                            if (z2) {
                                FavoriteFileDetailUI.this.mjD;
                                if (!k.h(FavoriteFileDetailUI.this.cAv)) {
                                }
                            }
                            if (!booleanExtra) {
                                AppMethodBeat.o(74343);
                                return false;
                            }
                            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(FavoriteFileDetailUI.this.mController.ylL, 1, false);
                            dVar.rBl = new c() {
                                public final void a(l lVar) {
                                    AppMethodBeat.i(74338);
                                    if (z2) {
                                        FavoriteFileDetailUI.this.mjD;
                                        if (!k.h(FavoriteFileDetailUI.this.cAv) && FavoriteFileDetailUI.this.cAv.whh == 0) {
                                            if (type2 == 8) {
                                                lVar.e(0, FavoriteFileDetailUI.this.getString(R.string.bri));
                                            } else if (type2 == 15) {
                                                lVar.e(0, FavoriteFileDetailUI.this.getString(R.string.bri));
                                                lVar.e(4, FavoriteFileDetailUI.this.getString(R.string.dx0));
                                            } else if (type2 == 4) {
                                                lVar.e(0, FavoriteFileDetailUI.this.getString(R.string.bri));
                                                lVar.e(4, FavoriteFileDetailUI.this.getString(R.string.dx0));
                                            } else {
                                                lVar.e(0, FavoriteFileDetailUI.this.getString(R.string.bri));
                                                if (booleanExtra && FavoriteFileDetailUI.this.mgf.buu()) {
                                                    lVar.e(1, FavoriteFileDetailUI.this.getString(R.string.bq_));
                                                }
                                            }
                                        }
                                    }
                                    if (booleanExtra) {
                                        lVar.e(3, FavoriteFileDetailUI.this.getString(R.string.bo8));
                                        lVar.e(2, FavoriteFileDetailUI.this.mController.ylL.getString(R.string.p4));
                                    }
                                    AppMethodBeat.o(74338);
                                }
                            };
                            dVar.rBm = new d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.i(74342);
                                    com.tencent.mm.plugin.fav.a.h.a aVar;
                                    switch (menuItem.getItemId()) {
                                        case 0:
                                            if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) == 8) {
                                                String b = b.b(FavoriteFileDetailUI.this.cAv);
                                                if (!com.tencent.mm.vfs.e.ct(b)) {
                                                    ab.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                                                    Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(R.string.brg), 1).show();
                                                    AppMethodBeat.o(74342);
                                                    return;
                                                } else if (new com.tencent.mm.vfs.b(b).length() > 10485760) {
                                                    ab.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                                                    Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(R.string.brh), 1).show();
                                                    AppMethodBeat.o(74342);
                                                    return;
                                                }
                                            }
                                            aVar = FavoriteFileDetailUI.this.mlz;
                                            aVar.meZ++;
                                            FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.mgf);
                                            AppMethodBeat.o(74342);
                                            return;
                                        case 1:
                                            aVar = FavoriteFileDetailUI.this.mlz;
                                            aVar.mfa++;
                                            final com.tencent.mm.ui.base.p b2 = h.b(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(R.string.bp2), false, null);
                                            AppCompatActivity appCompatActivity = FavoriteFileDetailUI.this.mController.ylL;
                                            g b3 = FavoriteFileDetailUI.this.mgf;
                                            AnonymousClass1 anonymousClass1 = new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(74339);
                                                    b2.dismiss();
                                                    AppMethodBeat.o(74339);
                                                }
                                            };
                                            LinkedList linkedList = new LinkedList();
                                            linkedList.add(Integer.valueOf(b3.field_id));
                                            com.tencent.mm.kernel.g.Rg().a(new am("", linkedList, new com.tencent.mm.plugin.fav.ui.i.AnonymousClass2(b3, appCompatActivity, anonymousClass1)), 0);
                                            AppMethodBeat.o(74342);
                                            return;
                                        case 2:
                                            h.a(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(R.string.p5), "", new DialogInterface.OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(74341);
                                                    final com.tencent.mm.ui.base.p b = h.b(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(R.string.p5), false, null);
                                                    b.a(FavoriteFileDetailUI.this.mgf.field_localId, new Runnable() {
                                                        public final void run() {
                                                            AppMethodBeat.i(74340);
                                                            FavoriteFileDetailUI.this.mlz.mfd = true;
                                                            b.dismiss();
                                                            ab.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId), Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id));
                                                            FavoriteFileDetailUI.this.finish();
                                                            AppMethodBeat.o(74340);
                                                        }
                                                    });
                                                    AppMethodBeat.o(74341);
                                                }
                                            }, null);
                                            AppMethodBeat.o(74342);
                                            return;
                                        case 3:
                                            aVar = FavoriteFileDetailUI.this.mlz;
                                            aVar.mfc++;
                                            Intent intent = new Intent();
                                            intent.putExtra("key_fav_scene", 2);
                                            intent.putExtra("key_fav_item_id", FavoriteFileDetailUI.this.mgf.field_localId);
                                            b.b(FavoriteFileDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                            AppMethodBeat.o(74342);
                                            return;
                                        case 4:
                                            FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                                            break;
                                    }
                                    AppMethodBeat.o(74342);
                                }
                            };
                            dVar.cpD();
                            AppMethodBeat.o(74343);
                            return true;
                        }
                    });
                }
            } else if (!(this.mgf.buu() || this.mgf.but())) {
                z = false;
            }
            z2 = z;
            addIconOptionMenu(0, R.string.ewm, R.drawable.uu, /* anonymous class already generated */);
        }
        hl(false);
        AppMethodBeat.o(74347);
    }

    private int getType() {
        AppMethodBeat.i(74348);
        if (this.cAv == null) {
            ab.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            AppMethodBeat.o(74348);
            return 8;
        } else if (this.cAv.dataType == 0) {
            ab.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", Integer.valueOf(this.mgf.field_type));
            if (4 == this.mgf.field_type) {
                AppMethodBeat.o(74348);
                return 4;
            } else if (16 == this.mgf.field_type) {
                if (!(this.cAv == null || this.cAv.wgZ == null)) {
                    if (!bo.isNullOrNil(this.cAv.wgZ.fiG)) {
                        AppMethodBeat.o(74348);
                        return 15;
                    } else if (!bo.isNullOrNil(this.cAv.wgZ.fiK)) {
                        AppMethodBeat.o(74348);
                        return 15;
                    }
                }
                AppMethodBeat.o(74348);
                return 4;
            } else {
                AppMethodBeat.o(74348);
                return 8;
            }
        } else if (this.cAv.dataType == 15) {
            if (!(this.cAv == null || this.cAv.wgZ == null)) {
                if (!bo.isNullOrNil(this.cAv.wgZ.fiG)) {
                    AppMethodBeat.o(74348);
                    return 15;
                } else if (!bo.isNullOrNil(this.cAv.wgZ.fiK)) {
                    AppMethodBeat.o(74348);
                    return 15;
                }
            }
            AppMethodBeat.o(74348);
            return 4;
        } else {
            int i = this.cAv.dataType;
            AppMethodBeat.o(74348);
            return i;
        }
    }

    private void hl(boolean z) {
        AppMethodBeat.i(74349);
        boolean f = b.f(this.cAv);
        ab.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", Integer.valueOf(this.mgf.field_itemStatus), Boolean.valueOf(f), b.b(this.cAv));
        if (this.cAv.whh != 0) {
            bwh();
            AppMethodBeat.o(74349);
        } else if (this.mgf.isDone() || f || !bo.isNullOrNil(this.cAv.wfZ)) {
            if (f) {
                bwl();
                if (getIntent().getBooleanExtra("key_detail_open_way", false)) {
                    abh abh = new abh();
                    abh.cOi = 2;
                    ((y) com.tencent.mm.kernel.g.K(y.class)).a(this.mController.ylL, this.mgf, abh);
                    AppMethodBeat.o(74349);
                    return;
                }
            } else if (bo.isNullOrNil(this.cAv.wfZ)) {
                bwh();
                AppMethodBeat.o(74349);
                return;
            } else {
                ab.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                bwj();
            }
            AppMethodBeat.o(74349);
        } else {
            if (this.mgf.buy()) {
                if (bo.isNullOrNil(this.cAv.wfZ)) {
                    bwh();
                    if (z) {
                        int type = getType();
                        if (4 == type || 15 == type) {
                            type = R.string.bqx;
                        } else {
                            type = R.string.bqk;
                        }
                        h.bQ(this.mController.ylL, getString(type));
                        AppMethodBeat.o(74349);
                        return;
                    }
                }
                bwj();
                if (z) {
                    h.bQ(this.mController.ylL, getString(R.string.b6p));
                    AppMethodBeat.o(74349);
                    return;
                }
            } else if (this.mgf.bux()) {
                bwj();
                if (z) {
                    h.bQ(this.mController.ylL, getString(R.string.bnk));
                    AppMethodBeat.o(74349);
                    return;
                }
            } else if (this.mgf.isDownloading() || this.mgf.buw()) {
                bwi();
                AppMethodBeat.o(74349);
                return;
            } else {
                ab.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                bwj();
            }
            AppMethodBeat.o(74349);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(74350);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.oy));
        AppMethodBeat.o(74350);
    }

    private void bwh() {
        AppMethodBeat.i(74351);
        this.mlG.setVisibility(8);
        this.gxi.setVisibility(8);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.mlI.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlL.setVisibility(0);
        this.mlM.setVisibility(0);
        if (this.cAv.dataType == 4) {
            this.iqU.setGravity(17);
            this.iqU.setText(R.string.bq0);
            AppMethodBeat.o(74351);
            return;
        }
        this.iqU.setGravity(17);
        this.iqU.setText(R.string.bpz);
        if (this.cAv.whh == 2) {
            this.mlM.setText(R.string.bnu);
            AppMethodBeat.o(74351);
            return;
        }
        this.mlM.setText(R.string.bnv);
        AppMethodBeat.o(74351);
    }

    private void bwi() {
        int progress;
        int i;
        int i2;
        AppMethodBeat.i(74352);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlI.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd);
        if (LR != null) {
            progress = (int) LR.getProgress();
            i = LR.field_offset;
            i2 = LR.field_totalLen;
        } else {
            i2 = (int) this.cAv.wgu;
            i = 0;
            progress = 0;
        }
        if (this.mgf.buw() && bo.isNullOrNil(this.cAv.wfZ)) {
            b((float) progress, getString(R.string.bs7, new Object[]{b.aC((float) i), b.aC((float) i2)}));
            AppMethodBeat.o(74352);
            return;
        }
        b((float) progress, getString(R.string.bo5, new Object[]{b.aC((float) i), b.aC((float) i2)}));
        AppMethodBeat.o(74352);
    }

    private void bwj() {
        AppMethodBeat.i(74353);
        this.mlI.setVisibility(8);
        this.mlE.setVisibility(8);
        if (bo.isNullOrNil(this.cAv.wgg)) {
            this.mlD.setVisibility(8);
        } else {
            this.mlD.setVisibility(0);
        }
        this.mlF.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd);
        if (LR == null || LR.field_offset <= 0) {
            this.mlF.setText(this.mgf.bux() ? R.string.bpi : R.string.bpd);
        } else {
            this.mlF.setText(this.mgf.bux() ? R.string.bph : R.string.bpg);
        }
        this.iqU.setVisibility(8);
        AppMethodBeat.o(74353);
    }

    private boolean bwk() {
        AppMethodBeat.i(74354);
        if (b.f(this.cAv) && b.g(this.cAv)) {
            AppMethodBeat.o(74354);
            return true;
        }
        AppMethodBeat.o(74354);
        return false;
    }

    private void bwl() {
        AppMethodBeat.i(74355);
        if (!(getType() != 15 || this.cAv.wgZ == null || bo.isNullOrNil(this.cAv.wgZ.fiG) || bo.isNullOrNil(this.cAv.wgZ.fiK))) {
            this.mlS = true;
            this.mlG.setVisibility(8);
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            String b = b.b(this.cAv);
            ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mp() + " initView: fullpath:" + b);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bs7);
            this.klq = q.fT(this.mController.ylL);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.klq, 0, layoutParams);
            this.klq.setVideoCallback(new e.a() {
                public final void pL() {
                    AppMethodBeat.i(74325);
                    ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mp() + " onPrepared");
                    FavoriteFileDetailUI.this.klq.setLoop(true);
                    FavoriteFileDetailUI.this.klq.start();
                    AppMethodBeat.o(74325);
                }

                public final void onError(int i, int i2) {
                    AppMethodBeat.i(74326);
                    FavoriteFileDetailUI.this.klq.stop();
                    if (FavoriteFileDetailUI.this.mlN) {
                        AppMethodBeat.o(74326);
                        return;
                    }
                    FavoriteFileDetailUI.this.mlN = true;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74324);
                            h.g(FavoriteFileDetailUI.this.mController.ylL, R.string.f1a, R.string.f1j);
                            Bitmap a = com.tencent.mm.plugin.fav.ui.l.a(FavoriteFileDetailUI.this.cAv, FavoriteFileDetailUI.this.mgf);
                            ImageView imageView = (ImageView) FavoriteFileDetailUI.this.findViewById(R.id.bs8);
                            if (imageView != null) {
                                imageView.setImageBitmap(a);
                                imageView.setVisibility(0);
                            }
                            AppMethodBeat.o(74324);
                        }
                    });
                    AppMethodBeat.o(74326);
                }

                public final void EA() {
                }

                public final int dG(int i, int i2) {
                    return 0;
                }

                public final void dH(int i, int i2) {
                }
            });
            ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mp() + " initView :" + b);
            if (b != null) {
                this.klq.stop();
                this.klq.setVideoPath(b);
            }
            ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mp() + " initView");
            com.tencent.mm.aw.a.aic();
            com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(4));
        }
        if (getType() == 15 || getType() == 4) {
            if (!this.mlS) {
                this.mlI.setVisibility(8);
                this.mlF.setVisibility(8);
                this.mlD.setVisibility(8);
                this.mlE.setVisibility(0);
                this.mlE.setText(R.string.bpf);
                this.iqU.setVisibility(8);
                bnS();
            }
        } else if (bwk()) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(0);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74327);
                    FavoriteFileDetailUI.s(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(74327);
                }
            });
        } else {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            if (bo.isNullOrNil(this.cAv.wgg)) {
                this.mlD.setVisibility(8);
            } else {
                this.mlD.setVisibility(0);
            }
            this.mlE.setVisibility(0);
            this.mlz.meX = true;
            this.iqU.setVisibility(0);
        }
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74328);
                b.o(FavoriteFileDetailUI.this.mgf);
                AppMethodBeat.o(74328);
            }
        });
        AppMethodBeat.o(74355);
    }

    public void onDestroy() {
        AppMethodBeat.i(74356);
        setResult(0, getIntent().putExtra("key_activity_browse_time", dyi()));
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
        }
        super.onDestroy();
        AppMethodBeat.o(74356);
    }

    public void onResume() {
        AppMethodBeat.i(74357);
        super.onResume();
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(this);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(this);
        if (this.klq != null) {
            this.klq.start();
        }
        AppMethodBeat.o(74357);
    }

    public void onPause() {
        AppMethodBeat.i(74358);
        super.onPause();
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(this);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(this);
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.o(74358);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74359);
        super.onActivityResult(i, i2, intent);
        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.ab.class)).b(this, i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(74359);
            return;
        }
        if (i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final com.tencent.mm.ui.base.p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            ab.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            Runnable anonymousClass7 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74329);
                    b.dismiss();
                    AppMethodBeat.o(74329);
                }
            };
            int type = getType();
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(74359);
                return;
            }
            for (String str2 : bo.P(stringExtra.split(","))) {
                if (type == 4 || type == 15) {
                    int mA;
                    i.a(this.mController.ylL, str2, this.cAv, anonymousClass7);
                    boolean kH = t.kH(str2);
                    m.c cVar = kH ? m.c.Chatroom : m.c.Chat;
                    g gVar = this.mgf;
                    m.d dVar = m.d.Full;
                    if (kH) {
                        mA = n.mA(str2);
                    } else {
                        mA = 0;
                    }
                    m.a(cVar, gVar, dVar, mA);
                } else {
                    i.a(this.mController.ylL, str2, this.mgf, this.cAv, anonymousClass7);
                }
                if (!bo.isNullOrNil(str)) {
                    com.tencent.mm.plugin.messenger.a.g.bOk().F(str2, str, t.nK(str2));
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.bnf));
        }
        AppMethodBeat.o(74359);
    }

    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(74360);
        if (cVar == null || cVar.field_dataId == null) {
            ab.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.o(74360);
            return;
        }
        ab.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", this.cAv.mnd, cVar.field_dataId);
        if (!cVar.field_dataId.equals(this.cAv.mnd)) {
            AppMethodBeat.o(74360);
        } else if (this.mgf.buw() && bo.isNullOrNil(this.cAv.wfZ)) {
            b(cVar.getProgress(), getString(R.string.bs7, new Object[]{b.aC((float) cVar.field_offset), b.aC((float) cVar.field_totalLen)}));
            AppMethodBeat.o(74360);
        } else {
            b(cVar.getProgress(), getString(R.string.bo5, new Object[]{b.aC((float) cVar.field_offset), b.aC((float) cVar.field_totalLen)}));
            if (this.mlO && com.tencent.mm.vfs.e.ct(cVar.field_path)) {
                this.mgf.field_itemStatus = 10;
                a("", null);
            }
            AppMethodBeat.o(74360);
        }
    }

    private void b(final float f, final String str) {
        AppMethodBeat.i(74361);
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74330);
                FavoriteFileDetailUI.this.progressBar.setProgress((int) f);
                FavoriteFileDetailUI.this.mlH.setText(str);
                AppMethodBeat.o(74330);
            }
        });
        AppMethodBeat.o(74361);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(74362);
        ab.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.mgf.field_localId));
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mgf.field_localId);
        if (iE != null || this.mlO) {
            if (!this.mlO) {
                this.mgf = iE;
            }
            bwg();
            if (bwm()) {
                AppMethodBeat.o(74362);
                return;
            }
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74331);
                    FavoriteFileDetailUI.v(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(74331);
                }
            });
            AppMethodBeat.o(74362);
            return;
        }
        ab.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
        AppMethodBeat.o(74362);
    }

    private void bnS() {
        AppMethodBeat.i(74363);
        if (this.mlR) {
            AppMethodBeat.o(74363);
            return;
        }
        com.tencent.mm.plugin.fav.a.h.a aVar = this.mlz;
        aVar.meY++;
        this.mlR = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", this.cvv);
        intent.putExtra("key_detail_fav_path", b.b(this.cAv));
        intent.putExtra("key_detail_fav_thumb_path", b.c(this.cAv));
        intent.putExtra("key_detail_fav_video_duration", this.cAv.duration);
        intent.putExtra("key_detail_statExtStr", this.cAv.cMn);
        b.b((Context) this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.o(74363);
    }

    private boolean bwm() {
        AppMethodBeat.i(74364);
        com.tencent.mm.plugin.fav.a.c LR = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd);
        if (LR == null) {
            AppMethodBeat.o(74364);
            return false;
        } else if (LR.field_status == 1) {
            AppMethodBeat.o(74364);
            return true;
        } else if (this.cAv.dataType == 8) {
            AppMethodBeat.o(74364);
            return false;
        } else if (this.mlT) {
            AppMethodBeat.o(74364);
            return false;
        } else {
            if (LR.field_status == 4 && ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().LR(this.cAv.mnd).field_extFlag != 0) {
                b.a(this.mgf, this.cAv, true);
                this.mlT = true;
            }
            ab.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.mlT));
            boolean z = this.mlT;
            AppMethodBeat.o(74364);
            return z;
        }
    }

    static /* synthetic */ void k(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74371);
        String uu = u.uu(b.b(favoriteFileDetailUI.cAv));
        ab.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, uu);
        if (bo.isNullOrNil(uu)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.string.f1c), 1).show();
            AppMethodBeat.o(74371);
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.string.f1d, new Object[]{uu}), 1).show();
        com.tencent.mm.pluginsdk.ui.tools.n.a(uu, favoriteFileDetailUI);
        AppMethodBeat.o(74371);
    }

    static /* synthetic */ void s(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.i(74372);
        if (favoriteFileDetailUI.getType() == 8 && b.f(favoriteFileDetailUI.cAv) && b.g(favoriteFileDetailUI.cAv)) {
            com.tencent.mm.plugin.fav.a.h.a aVar = favoriteFileDetailUI.mlz;
            aVar.meY++;
            y yVar = (y) com.tencent.mm.kernel.g.K(y.class);
            AppCompatActivity appCompatActivity = favoriteFileDetailUI.mController.ylL;
            g gVar = favoriteFileDetailUI.mgf;
            abh abh = new abh();
            abh.scene = favoriteFileDetailUI.mlz.scene;
            abh.jSW = favoriteFileDetailUI.mlz.jSW;
            abh.index = favoriteFileDetailUI.mlz.index;
            yVar.a(appCompatActivity, gVar, abh);
        }
        AppMethodBeat.o(74372);
    }
}
