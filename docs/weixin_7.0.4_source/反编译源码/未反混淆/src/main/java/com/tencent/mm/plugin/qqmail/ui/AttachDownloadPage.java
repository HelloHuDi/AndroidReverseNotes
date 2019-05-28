package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private int fUO = 0;
    private long fVz = 0;
    private TextView gnh;
    private TextView iGX;
    private long jrb;
    private Button mlD;
    private Button mlF;
    private View mlI;
    private ProgressBar progressBar;
    private String ptI;
    private String pux;
    private long pvG;
    private MMImageView pvR;
    private ImageView pvS;
    private ImageView pvT;
    private TextView pvU;
    private LinearLayout pvV;
    private String pvW;
    private int pvX;
    private boolean pvY = false;
    private String pvZ;
    private boolean pwa = true;
    private int retryCount = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ String a(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68158);
        String jV = attachDownloadPage.jV(false);
        AppMethodBeat.o(68158);
        return jV;
    }

    static /* synthetic */ void d(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68160);
        attachDownloadPage.ccK();
        AppMethodBeat.o(68160);
    }

    static /* synthetic */ void f(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68161);
        attachDownloadPage.ccM();
        AppMethodBeat.o(68161);
    }

    static /* synthetic */ void h(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68164);
        attachDownloadPage.ccJ();
        AppMethodBeat.o(68164);
    }

    static /* synthetic */ String l(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68166);
        String ccN = attachDownloadPage.ccN();
        AppMethodBeat.o(68166);
        return ccN;
    }

    public final int getLayoutId() {
        return R.layout.ew;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68142);
        super.onCreate(bundle);
        this.pvX = getIntent().getIntExtra("is_preview", 0);
        this.pvY = getIntent().getBooleanExtra("is_compress", false);
        this.pvZ = getIntent().getStringExtra("attach_name");
        this.ptI = getIntent().getStringExtra("mail_id");
        this.pux = getIntent().getStringExtra("attach_id");
        this.jrb = getIntent().getLongExtra("total_size", 0);
        ac.ccC();
        this.pvW = v.getDownloadPath();
        setMMTitle(this.pvZ);
        initView();
        AppMethodBeat.o(68142);
    }

    public void onResume() {
        AppMethodBeat.i(68143);
        super.onResume();
        AppMethodBeat.o(68143);
    }

    public void onPause() {
        AppMethodBeat.i(68144);
        super.onPause();
        AppMethodBeat.o(68144);
    }

    public void onDestroy() {
        AppMethodBeat.i(68145);
        super.onDestroy();
        ac.ccC().cancel(this.pvG);
        AppMethodBeat.o(68145);
    }

    public final void initView() {
        AppMethodBeat.i(68146);
        this.pvR = (MMImageView) findViewById(R.id.zf);
        this.mlI = findViewById(R.id.zg);
        this.progressBar = (ProgressBar) findViewById(R.id.zh);
        this.pvS = (ImageView) findViewById(R.id.zi);
        this.pvT = (ImageView) findViewById(R.id.zj);
        this.pvU = (TextView) findViewById(R.id.zk);
        this.mlD = (Button) findViewById(R.id.zl);
        this.mlF = (Button) findViewById(R.id.zm);
        this.pvV = (LinearLayout) findViewById(R.id.zn);
        this.gnh = (TextView) findViewById(R.id.zo);
        this.iGX = (TextView) findViewById(R.id.zp);
        ccI();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68130);
                AttachDownloadPage.this.finish();
                AppMethodBeat.o(68130);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68132);
                h.a(AttachDownloadPage.this, "", new String[]{AttachDownloadPage.this.getString(R.string.dcq)}, "", false, new c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(68131);
                        switch (i) {
                            case 0:
                                AttachDownloadPage.a(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                                break;
                        }
                        AppMethodBeat.o(68131);
                    }
                });
                AppMethodBeat.o(68132);
                return true;
            }
        });
        enableOptionMenu(false);
        ccP();
        if (this.fUO == 1) {
            ccJ();
            AppMethodBeat.o(68146);
            return;
        }
        ccK();
        AppMethodBeat.o(68146);
    }

    private void ccI() {
        AppMethodBeat.i(68147);
        if (FileExplorerUI.ajX(this.pvZ)) {
            this.pvR.setBackgroundResource(R.raw.download_image_icon);
            AppMethodBeat.o(68147);
        } else if (FileExplorerUI.ajY(this.pvZ)) {
            this.pvR.setImageResource(R.raw.app_attach_file_icon_video);
            AppMethodBeat.o(68147);
        } else {
            int aiD = o.aiD(e.cv(this.pvZ));
            if (aiD > 0) {
                this.pvR.setImageResource(aiD);
                AppMethodBeat.o(68147);
                return;
            }
            this.pvR.setImageResource(R.raw.app_attach_file_icon_unknow);
            AppMethodBeat.o(68147);
        }
    }

    private void ccJ() {
        AppMethodBeat.i(68148);
        this.mlI.setVisibility(0);
        this.mlD.setVisibility(8);
        this.mlF.setVisibility(8);
        this.pvS.setVisibility(0);
        this.pvT.setVisibility(8);
        this.pvU.setVisibility(8);
        this.gnh.setVisibility(8);
        this.iGX.setVisibility(8);
        this.pvS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68133);
                AttachDownloadPage.this.fUO = 2;
                ac.ccC().cancel(AttachDownloadPage.this.pvG);
                AttachDownloadPage.this.pvG = 0;
                AttachDownloadPage.d(AttachDownloadPage.this);
                AppMethodBeat.o(68133);
            }
        });
        this.pvT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68134);
                AttachDownloadPage.this.retryCount = 0;
                AttachDownloadPage.f(AttachDownloadPage.this);
                AppMethodBeat.o(68134);
            }
        });
        AppMethodBeat.o(68148);
    }

    private void ccK() {
        AppMethodBeat.i(68149);
        if (this.pvX == 1) {
            if (FileExplorerUI.ajX(this.pvZ)) {
                if (this.fUO == 3) {
                    ccL();
                    AppMethodBeat.o(68149);
                    return;
                } else if (this.fUO == 0 || this.pwa) {
                    this.retryCount = 0;
                    this.pwa = false;
                    ccM();
                    ccJ();
                    AppMethodBeat.o(68149);
                    return;
                }
            }
            this.mlI.setVisibility(8);
            this.gnh.setVisibility(0);
            this.pvU.setVisibility(8);
            this.mlD.setVisibility(0);
            this.mlF.setVisibility(8);
            this.iGX.setVisibility(0);
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(68135);
                    AttachDownloadPage.g(AttachDownloadPage.this);
                    AppMethodBeat.o(68135);
                }
            });
            if (this.fUO == 3) {
                this.gnh.setText(R.string.cv3);
                this.iGX.setText(R.string.cv0);
                this.iGX.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(68136);
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                        AppMethodBeat.o(68136);
                    }
                });
                enableOptionMenu(true);
                AppMethodBeat.o(68149);
                return;
            }
            this.gnh.setText(R.string.cv3);
            if (this.fUO == 2) {
                this.iGX.setText(R.string.cv2);
            } else {
                this.iGX.setText(R.string.cv1);
            }
            this.iGX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(68137);
                    AttachDownloadPage.this.retryCount = 0;
                    AttachDownloadPage.f(AttachDownloadPage.this);
                    AttachDownloadPage.h(AttachDownloadPage.this);
                    AppMethodBeat.o(68137);
                }
            });
            AppMethodBeat.o(68149);
            return;
        }
        if (this.pvX == 0) {
            this.mlI.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlF.setVisibility(0);
            this.pvU.setVisibility(8);
            this.gnh.setVisibility(0);
            this.iGX.setVisibility(8);
            if (this.fUO == 3) {
                this.mlF.setText(R.string.cux);
                enableOptionMenu(true);
            } else if (this.fUO == 2) {
                this.mlF.setText(R.string.cv4);
            } else {
                this.mlF.setText(R.string.cuv);
            }
            this.gnh.setText(R.string.cuw);
            this.mlF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(68138);
                    if (AttachDownloadPage.this.fUO == 3) {
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
                        AppMethodBeat.o(68138);
                        return;
                    }
                    AttachDownloadPage.h(AttachDownloadPage.this);
                    AttachDownloadPage.this.retryCount = 0;
                    AttachDownloadPage.f(AttachDownloadPage.this);
                    AppMethodBeat.o(68138);
                }
            });
        }
        AppMethodBeat.o(68149);
    }

    private void ccL() {
        AppMethodBeat.i(68150);
        Intent intent = new Intent();
        intent.putExtra("key_favorite", true);
        intent.putExtra("key_favorite_source_type", 9);
        intent.putExtra("key_image_path", jV(false));
        a.gkE.d(this.mController.ylL, intent);
        finish();
        AppMethodBeat.o(68150);
    }

    private void ccM() {
        AppMethodBeat.i(68151);
        ccP();
        if (this.fUO == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                ccM();
            } else {
                ccK();
            }
        } else if (this.fUO == 3) {
            e.h(this.pvW, ccN() + ".temp", ccN());
            this.fUO = 3;
            ccK();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("attachid", this.pux);
        hashMap.put("username", "");
        hashMap.put("offset", this.fVz);
        hashMap.put("datalen", this.jrb);
        hashMap.put("default_attach_name", ccN() + ".temp");
        v.c cVar = new v.c();
        cVar.puP = false;
        cVar.puQ = false;
        this.pvG = ac.ccC().a("/cgi-bin/mmdownload", hashMap, cVar, new v.a() {
            public final void onProgress(int i) {
                AppMethodBeat.i(68139);
                ab.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(i)));
                AttachDownloadPage.j(AttachDownloadPage.this);
                AttachDownloadPage.this.fUO = 1;
                AppMethodBeat.o(68139);
            }

            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(68140);
                e.h(AttachDownloadPage.this.pvW, AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
                AttachDownloadPage.this.fUO = 3;
                Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(R.string.b71) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
                AttachDownloadPage.d(AttachDownloadPage.this);
                AppMethodBeat.o(68140);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.i(68141);
                AttachDownloadPage.this.fUO = 4;
                if (AttachDownloadPage.this.retryCount < 5) {
                    AttachDownloadPage.this.retryCount = AttachDownloadPage.this.retryCount + 1;
                    AttachDownloadPage.f(AttachDownloadPage.this);
                    AppMethodBeat.o(68141);
                    return;
                }
                AttachDownloadPage.d(AttachDownloadPage.this);
                AppMethodBeat.o(68141);
            }

            public final void onComplete() {
            }
        });
        AppMethodBeat.o(68151);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(68152);
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.string.b6t, R.string.b6u, 3);
        AppMethodBeat.o(68152);
    }

    private String ccN() {
        String substring;
        AppMethodBeat.i(68153);
        int hashCode = this.pux.hashCode() & CdnLogic.kBizGeneric;
        int lastIndexOf = this.pvZ.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.pvZ.substring(0, lastIndexOf);
            str = this.pvZ;
            str = str.substring(lastIndexOf, str.length());
        } else {
            substring = this.pvZ;
        }
        substring = String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
        AppMethodBeat.o(68153);
        return substring;
    }

    private String jV(boolean z) {
        AppMethodBeat.i(68154);
        String str = this.pvW + ccN() + (!z ? "" : ".temp");
        AppMethodBeat.o(68154);
        return str;
    }

    private String ccO() {
        AppMethodBeat.i(68155);
        String str = this.pvW + this.pvZ;
        AppMethodBeat.o(68155);
        return str;
    }

    private void ccP() {
        AppMethodBeat.i(68156);
        if (e.ct(jV(true))) {
            this.fVz = e.asZ(jV(true));
            this.fUO = 2;
            AppMethodBeat.o(68156);
        } else if (e.ct(jV(false))) {
            this.fUO = 3;
            AppMethodBeat.o(68156);
        } else if (!e.ct(ccO())) {
            this.fVz = 0;
            this.fUO = 0;
            AppMethodBeat.o(68156);
        } else if (e.asZ(ccO()) == this.jrb) {
            e.h(this.pvW, this.pvZ, ccN());
            this.fUO = 3;
            AppMethodBeat.o(68156);
        } else if (e.asZ(ccO()) > this.jrb) {
            e.deleteFile(ccO());
            this.fVz = 0;
            this.fUO = 4;
            AppMethodBeat.o(68156);
        } else {
            this.fVz = 0;
            this.fUO = 0;
            AppMethodBeat.o(68156);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(68157);
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
        LayoutParams layoutParams = (LayoutParams) this.pvV.getLayoutParams();
        if (i == 2) {
            layoutParams.bottomMargin = aj.fromDPToPix(this.mController.ylL, 60);
        } else if (i == 1) {
            layoutParams.bottomMargin = aj.fromDPToPix(this.mController.ylL, 120);
        }
        this.pvV.setLayoutParams(layoutParams);
        AppMethodBeat.o(68157);
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68162);
        if (attachDownloadPage.pvY) {
            Intent intent = new Intent(attachDownloadPage.mController.ylL, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.ptI);
            intent.putExtra("attach_id", attachDownloadPage.pux);
            intent.putExtra("attach_size", attachDownloadPage.jrb);
            intent.putExtra("attach_name", attachDownloadPage.pvZ);
            attachDownloadPage.mController.ylL.startActivity(intent);
            AppMethodBeat.o(68162);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.ptI, "attachid=" + attachDownloadPage.pux, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", v.ccw());
        intent2.putExtra(b.METHOD, "get");
        intent2.putExtra("singleColumn", FileExplorerUI.ajX(attachDownloadPage.pvZ));
        intent2.putExtra("title", attachDownloadPage.pvZ);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
        AppMethodBeat.o(68162);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        AppMethodBeat.i(68163);
        String cv = e.cv(str);
        if (!(cv == null || cv.length() == 0)) {
            com.tencent.mm.pluginsdk.ui.tools.a.a(attachDownloadPage, str, cv, 3);
        }
        AppMethodBeat.o(68163);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.i(68165);
        long asZ = e.asZ(attachDownloadPage.jV(true));
        ab.d("MicroMsg.AttachDownloadPage", "cur download size:".concat(String.valueOf(asZ)));
        attachDownloadPage.fVz = asZ;
        attachDownloadPage.progressBar.setProgress((int) ((100 * asZ) / attachDownloadPage.jrb));
        attachDownloadPage.pvU.setText(attachDownloadPage.getString(R.string.cuy, new Object[]{bo.ga(asZ), bo.ga(attachDownloadPage.jrb)}));
        if (attachDownloadPage.fUO != 1 || attachDownloadPage.pvG == 0) {
            attachDownloadPage.pvU.setVisibility(8);
            AppMethodBeat.o(68165);
            return;
        }
        attachDownloadPage.pvU.setVisibility(0);
        AppMethodBeat.o(68165);
    }
}
