package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class RecordMsgFileUI extends MMActivity implements d {
    private aar cAv;
    private String cHr;
    private long cvx;
    private ak fbD;
    private TextView gxi;
    private TextView iqU;
    private e klq = null;
    private Button mlD;
    private Button mlE;
    private Button mlF;
    private MMImageView mlG;
    private TextView mlH;
    private View mlI;
    private View mlJ;
    private boolean mlN = false;
    private boolean mlR = false;
    private boolean mlS = false;
    private l pKH;
    private ProgressBar progressBar;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24286);
        recordMsgFileUI.bnS();
        AppMethodBeat.o(24286);
    }

    static /* synthetic */ void f(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24288);
        recordMsgFileUI.bwi();
        AppMethodBeat.o(24288);
    }

    static /* synthetic */ void g(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24289);
        recordMsgFileUI.bwj();
        AppMethodBeat.o(24289);
    }

    static /* synthetic */ String m(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24291);
        String ceR = recordMsgFileUI.ceR();
        AppMethodBeat.o(24291);
        return ceR;
    }

    static /* synthetic */ void p(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24292);
        recordMsgFileUI.bwl();
        AppMethodBeat.o(24292);
    }

    static /* synthetic */ void q(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(24293);
        recordMsgFileUI.bwh();
        AppMethodBeat.o(24293);
    }

    public final int getLayoutId() {
        return R.layout.zf;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24272);
        super.onCreate(bundle);
        this.fbD = new ak();
        this.pKH = new l();
        this.cvx = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        c VI = n.VI(getIntent().getStringExtra("record_xml"));
        if (VI == null) {
            ab.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.o(24272);
            return;
        }
        Iterator it = VI.fjr.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(stringExtra)) {
                this.cAv = aar;
            }
        }
        if (this.cAv == null) {
            ab.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            AppMethodBeat.o(24272);
            return;
        }
        this.cHr = n.h(this.cAv.mnd, this.cvx, true);
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
        if (4 == getType()) {
            setMMTitle((int) R.string.bs9);
        } else if (15 == getType()) {
            setMMTitle((int) R.string.brj);
            findViewById(R.id.bs7).setBackgroundResource(R.color.h4);
        } else {
            setMMTitle((int) R.string.bp0);
        }
        if (getType() == 4) {
            this.mlG.setImageResource(R.raw.app_attach_file_icon_video);
        } else {
            this.mlG.setImageResource(com.tencent.mm.pluginsdk.d.ail(this.cAv.wgo));
        }
        this.gxi.setText(this.cAv.title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24252);
                RecordMsgFileUI.this.finish();
                AppMethodBeat.o(24252);
                return true;
            }
        });
        this.mlE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24259);
                String c = n.c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                new Intent().setAction("android.intent.action.VIEW");
                if (4 == RecordMsgFileUI.c(RecordMsgFileUI.this)) {
                    RecordMsgFileUI.this.mlR = false;
                    RecordMsgFileUI.e(RecordMsgFileUI.this);
                    AppMethodBeat.o(24259);
                    return;
                }
                RecordMsgFileUI.a(RecordMsgFileUI.this, c);
                AppMethodBeat.o(24259);
            }
        });
        final String str = this.cAv.wgg;
        if (!bo.isNullOrNil(str)) {
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(24260);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.bp.d.b(RecordMsgFileUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(24260);
                }
            });
        }
        this.mlF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24261);
                if (f.Mn()) {
                    n.b(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx, true);
                    RecordMsgFileUI.f(RecordMsgFileUI.this);
                    AppMethodBeat.o(24261);
                    return;
                }
                h.g(RecordMsgFileUI.this.mController.ylL, R.string.bpt, R.string.tz);
                AppMethodBeat.o(24261);
            }
        });
        this.mlJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24262);
                RecordMsgFileUI.g(RecordMsgFileUI.this);
                AppMethodBeat.o(24262);
            }
        });
        if (getType() != 15 || bo.ank(g.Nu().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24265);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(RecordMsgFileUI.this.mController.ylL, 1, false);
                    dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            AppMethodBeat.i(24263);
                            lVar.e(0, RecordMsgFileUI.this.getString(R.string.bri));
                            AppMethodBeat.o(24263);
                        }
                    };
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(24264);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 8) {
                                        String c = n.c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                                        if (!com.tencent.mm.a.e.ct(c)) {
                                            ab.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.string.brg), 1).show();
                                            AppMethodBeat.o(24264);
                                            return;
                                        } else if (new File(c).length() > 10485760) {
                                            ab.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.string.brh), 1).show();
                                            AppMethodBeat.o(24264);
                                            return;
                                        }
                                    }
                                    RecordMsgFileUI.h(RecordMsgFileUI.this);
                                    break;
                            }
                            AppMethodBeat.o(24264);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(24265);
                    return true;
                }
            });
        } else {
            ab.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        boolean z = bo.isNullOrNil(this.cAv.wfZ) || bo.isNullOrNil(this.cAv.wgb);
        boolean z2;
        if (bo.isNullOrNil(this.cAv.whr) || bo.isNullOrNil(this.cAv.who)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z && !z2) {
            bwh();
        } else if (n.d(this.cAv, this.cvx)) {
            enableOptionMenu(true);
            bwl();
        } else {
            i VH = ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().VH(this.cHr);
            if (VH == null || 2 == VH.field_status) {
                bwj();
            } else if (4 == VH.field_status) {
                bwh();
            } else if (VH.field_status == 0 || 1 == VH.field_status) {
                bwi();
            } else {
                ab.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                bwj();
            }
            enableOptionMenu(false);
        }
        ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().a((d) this);
        AppMethodBeat.o(24272);
    }

    private int getType() {
        int i = this.cAv.dataType;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void bwh() {
        AppMethodBeat.i(24273);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.mlI.setVisibility(8);
        this.iqU.setVisibility(0);
        if (this.cAv.dataType == 4) {
            this.iqU.setGravity(17);
            this.iqU.setText(R.string.bq0);
            AppMethodBeat.o(24273);
            return;
        }
        this.iqU.setGravity(17);
        this.iqU.setText(R.string.bpz);
        AppMethodBeat.o(24273);
    }

    private void bwi() {
        AppMethodBeat.i(24274);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlI.setVisibility(0);
        c(((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().VH(this.cHr));
        AppMethodBeat.o(24274);
    }

    private void bwj() {
        AppMethodBeat.i(24275);
        this.mlI.setVisibility(8);
        this.mlE.setVisibility(8);
        if (bo.isNullOrNil(this.cAv.wgg)) {
            this.mlD.setVisibility(8);
        } else {
            this.mlD.setVisibility(0);
        }
        this.mlF.setVisibility(0);
        this.mlF.setText(R.string.bpd);
        this.iqU.setVisibility(8);
        AppMethodBeat.o(24275);
    }

    private void bwl() {
        AppMethodBeat.i(24276);
        if (!(getType() != 15 || this.cAv.wgZ == null || bo.isNullOrNil(this.cAv.wgZ.fiG) || bo.isNullOrNil(this.cAv.wgZ.fiK))) {
            this.mlS = true;
            this.mlG.setVisibility(8);
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            String c = n.c(this.cAv, this.cvx);
            ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mp() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bs7);
            this.klq = q.fT(this.mController.ylL);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.klq, 0, layoutParams);
            this.klq.setVideoCallback(new e.a() {
                public final void pL() {
                    AppMethodBeat.i(24267);
                    ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mp() + " onPrepared");
                    RecordMsgFileUI.this.klq.setLoop(true);
                    RecordMsgFileUI.this.klq.start();
                    AppMethodBeat.o(24267);
                }

                public final void onError(int i, int i2) {
                    AppMethodBeat.i(24268);
                    RecordMsgFileUI.this.klq.stop();
                    if (RecordMsgFileUI.this.mlN) {
                        AppMethodBeat.o(24268);
                        return;
                    }
                    RecordMsgFileUI.this.mlN = true;
                    final Bitmap b = RecordMsgFileUI.this.pKH.b(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                    final String videoPath = RecordMsgFileUI.this.klq.getVideoPath();
                    b.A(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.ckW() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bo.bc(videoPath, "")).getBytes(), 2), "FullScreenPlaySight");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24266);
                            ImageView imageView = (ImageView) RecordMsgFileUI.this.findViewById(R.id.bs8);
                            imageView.setImageBitmap(b);
                            imageView.setVisibility(0);
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            k.a(RecordMsgFileUI.this.mController.ylL, intent, new File(videoPath), "video/*");
                            try {
                                RecordMsgFileUI.this.startActivity(Intent.createChooser(intent, RecordMsgFileUI.this.getString(R.string.bs9)));
                                AppMethodBeat.o(24266);
                            } catch (Exception e) {
                                ab.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                                h.g(RecordMsgFileUI.this.mController.ylL, R.string.bpq, R.string.bpr);
                                AppMethodBeat.o(24266);
                            }
                        }
                    });
                    AppMethodBeat.o(24268);
                }

                public final void EA() {
                }

                public final int dG(int i, int i2) {
                    return 0;
                }

                public final void dH(int i, int i2) {
                }
            });
            ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mp() + " initView :" + c);
            if (c != null) {
                this.klq.stop();
                this.klq.setVideoPath(c);
            }
            ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mp() + " initView");
            if (aw.Cc() != null) {
                aw.Cc().Id();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(4);
            if (bo.isNullOrNil(this.cAv.wgg)) {
                this.mlD.setVisibility(8);
            } else {
                this.mlD.setVisibility(0);
            }
            this.mlE.setVisibility(0);
            this.iqU.setVisibility(0);
        } else if (!this.mlS) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(0);
            this.mlE.setText(R.string.bpf);
            this.iqU.setVisibility(8);
            bnS();
            AppMethodBeat.o(24276);
            return;
        }
        AppMethodBeat.o(24276);
    }

    public void onDestroy() {
        AppMethodBeat.i(24277);
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
            if (aw.Cc() != null) {
                aw.Cc().Ic();
            }
        }
        super.onDestroy();
        ((a) com.tencent.mm.kernel.g.M(a.class)).getRecordMsgCDNStorage().b((d) this);
        this.pKH.destory();
        AppMethodBeat.o(24277);
    }

    public void onResume() {
        AppMethodBeat.i(24278);
        super.onResume();
        if (this.klq != null) {
            this.klq.start();
        }
        AppMethodBeat.o(24278);
    }

    public void onPause() {
        AppMethodBeat.i(24279);
        super.onPause();
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.o(24279);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(24280);
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.string.b6t, R.string.b6u, 5);
        if (i2 != -1) {
            AppMethodBeat.o(24280);
            return;
        }
        if (i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            ab.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            final AnonymousClass13 anonymousClass13 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24269);
                    b.dismiss();
                    AppMethodBeat.o(24269);
                }
            };
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(24280);
                return;
            }
            final ArrayList P = bo.P(stringExtra.split(","));
            if (getType() == 4 || getType() == 15) {
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24270);
                        File file = new File(n.c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                        for (String str : P) {
                            if (file.exists()) {
                                String m = RecordMsgFileUI.m(RecordMsgFileUI.this);
                                ab.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", file.getAbsolutePath(), m);
                                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                                    com.tencent.mm.plugin.messenger.a.g.bOk().a(RecordMsgFileUI.this.mController.ylL, str, file.getAbsolutePath(), m, 62, RecordMsgFileUI.this.cAv.duration, "");
                                } else {
                                    com.tencent.mm.plugin.messenger.a.g.bOk().a(RecordMsgFileUI.this.mController.ylL, str, file.getAbsolutePath(), m, 1, RecordMsgFileUI.this.cAv.duration, "");
                                }
                            } else {
                                String str2 = RecordMsgFileUI.this.cAv.wgg;
                                if (!bo.isNullOrNil(str2)) {
                                    WXVideoObject wXVideoObject = new WXVideoObject();
                                    wXVideoObject.videoUrl = str2;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                    str2 = bo.bc(RecordMsgFileUI.this.cAv.title, RecordMsgFileUI.this.mController.ylL.getResources().getString(R.string.bs9));
                                    wXMediaMessage.mediaObject = wXVideoObject;
                                    wXMediaMessage.title = str2;
                                    wXMediaMessage.description = RecordMsgFileUI.this.cAv.desc;
                                    wXMediaMessage.thumbData = bo.readFromFile(n.f(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                                    if (wXMediaMessage.thumbData == null) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        aw.ZK();
                                        wXMediaMessage.thumbData = bo.readFromFile(stringBuilder.append(com.tencent.mm.model.c.Yg()).append("web/").append(com.tencent.mm.a.g.x(bo.bc(RecordMsgFileUI.this.cAv.cvq, "").getBytes())).toString());
                                    }
                                    com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.g.bOk().eZ(str, str);
                        }
                        al.d(anonymousClass13);
                        AppMethodBeat.o(24270);
                    }

                    public final String toString() {
                        AppMethodBeat.i(24271);
                        String str = super.toString() + "|onActivityResult1";
                        AppMethodBeat.o(24271);
                        return str;
                    }
                });
                AppMethodBeat.o(24280);
                return;
            }
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24253);
                    String c = n.c(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx);
                    WXFileObject wXFileObject = new WXFileObject();
                    wXFileObject.setFilePath(c);
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXFileObject;
                    wXMediaMessage.title = RecordMsgFileUI.this.cAv.title;
                    wXMediaMessage.description = RecordMsgFileUI.this.cAv.desc;
                    wXMediaMessage.thumbData = bo.readFromFile(n.f(RecordMsgFileUI.this.cAv, RecordMsgFileUI.this.cvx));
                    for (String str : P) {
                        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, "", "", str, 3, null);
                        com.tencent.mm.plugin.messenger.a.g.bOk().eZ(str, str);
                    }
                    al.d(anonymousClass13);
                    AppMethodBeat.o(24253);
                }

                public final String toString() {
                    AppMethodBeat.i(24254);
                    String str = super.toString() + "|onActivityResult2";
                    AppMethodBeat.o(24254);
                    return str;
                }
            });
        }
        AppMethodBeat.o(24280);
    }

    private String ceR() {
        String absolutePath;
        AppMethodBeat.i(24281);
        File file = new File(n.f(this.cAv, this.cvx));
        if (file.exists()) {
            absolutePath = file.getAbsolutePath();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            absolutePath = stringBuilder.append(com.tencent.mm.model.c.Yg()).append("web/").append(com.tencent.mm.a.g.x(bo.bc(this.cAv.cvq, "").getBytes())).toString();
        }
        AppMethodBeat.o(24281);
        return absolutePath;
    }

    private void c(i iVar) {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(24282);
        if (iVar != null) {
            int max = (int) ((((float) iVar.field_offset) / ((float) Math.max(1, iVar.field_totalLen))) * 100.0f);
            i = iVar.field_offset;
            i2 = iVar.field_totalLen;
            i3 = max;
        } else {
            i2 = (int) this.cAv.wgu;
            i = 0;
            i3 = 0;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24255);
                RecordMsgFileUI.this.progressBar.setProgress(i3);
                RecordMsgFileUI.this.mlH.setText(RecordMsgFileUI.this.getString(R.string.bo5, new Object[]{bo.aC((float) i), bo.aC((float) i2)}));
                AppMethodBeat.o(24255);
            }
        });
        AppMethodBeat.o(24282);
    }

    public final void a(int i, i iVar) {
        AppMethodBeat.i(24283);
        if (iVar == null) {
            ab.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            AppMethodBeat.o(24283);
            return;
        }
        ab.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", this.cHr, iVar.field_mediaId);
        if (this.cHr.equals(iVar.field_mediaId)) {
            switch (iVar.field_status) {
                case 2:
                    this.fbD.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24256);
                            RecordMsgFileUI.this.enableOptionMenu(true);
                            RecordMsgFileUI.p(RecordMsgFileUI.this);
                            AppMethodBeat.o(24256);
                        }
                    });
                    AppMethodBeat.o(24283);
                    return;
                case 3:
                    this.fbD.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24258);
                            RecordMsgFileUI.g(RecordMsgFileUI.this);
                            h.bQ(RecordMsgFileUI.this.mController.ylL, RecordMsgFileUI.this.getString(R.string.b6p));
                            AppMethodBeat.o(24258);
                        }
                    });
                    AppMethodBeat.o(24283);
                    return;
                case 4:
                    this.fbD.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24257);
                            RecordMsgFileUI.q(RecordMsgFileUI.this);
                            AppMethodBeat.o(24257);
                        }
                    });
                    AppMethodBeat.o(24283);
                    return;
                default:
                    c(iVar);
                    AppMethodBeat.o(24283);
                    return;
            }
        }
        AppMethodBeat.o(24283);
    }

    private void bnS() {
        AppMethodBeat.i(24284);
        if (this.mlR) {
            AppMethodBeat.o(24284);
            return;
        }
        this.mlR = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_fav_path", n.c(this.cAv, this.cvx));
        intent.putExtra("key_detail_fav_thumb_path", n.f(this.cAv, this.cvx));
        intent.putExtra("key_detail_fav_video_duration", this.cAv.duration);
        intent.putExtra("key_detail_statExtStr", this.cAv.cMn);
        intent.putExtra("key_detail_fav_video_scene_from", 1);
        com.tencent.mm.plugin.fav.a.b.b((Context) this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.o(24284);
    }

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        AppMethodBeat.i(24290);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.ceR());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.ceR());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.cAv.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        com.tencent.mm.bp.d.b((Context) recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.o(24290);
    }
}
