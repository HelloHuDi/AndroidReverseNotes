package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.e;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class SelfQRCodeUI extends MMActivity implements f {
    private static final String PATH = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private ProgressDialog ehJ = null;
    private Bitmap fru = null;
    private ImageView iqT = null;
    private TextView jPp = null;
    private long kFU;
    private ImageView qkD = null;
    private byte[] qkE = null;
    private TextView qlv = null;
    private boolean qlw = false;
    private b qlx;
    private String userName = "";

    interface a {
        String ciA();

        byte[] ciy();

        String ciz();
    }

    public class b extends FileObserver {
        private MMActivity qlB;
        private String qlC;

        public b(MMActivity mMActivity) {
            super(SelfQRCodeUI.PATH, 8);
            AppMethodBeat.i(127023);
            this.qlB = mMActivity;
            AppMethodBeat.o(127023);
        }

        public final void onEvent(int i, String str) {
            AppMethodBeat.i(127024);
            if (str != null && i == 8 && (this.qlC == null || !str.equalsIgnoreCase(this.qlC))) {
                this.qlC = str;
                Uri.fromFile(new File(SelfQRCodeUI.PATH + str));
                SelfQRCodeUI.cix();
                ab.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
            }
            AppMethodBeat.o(127024);
        }

        public final void start() {
            AppMethodBeat.i(127025);
            super.startWatching();
            AppMethodBeat.o(127025);
        }

        public final void stop() {
            AppMethodBeat.i(127026);
            super.stopWatching();
            AppMethodBeat.o(127026);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SelfQRCodeUI selfQRCodeUI, int i) {
        AppMethodBeat.i(127037);
        selfQRCodeUI.Ck(i);
        AppMethodBeat.o(127037);
    }

    public final int getLayoutId() {
        return R.layout.ar7;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127027);
        super.onCreate(bundle);
        dyb();
        this.qlx = new b(this);
        this.qlx.start();
        g.Rg().a(168, (f) this);
        g.Rg().a(890, (f) this);
        initView();
        this.qkD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(127014);
                int width = SelfQRCodeUI.this.qkD.getWidth();
                LayoutParams layoutParams = (LayoutParams) SelfQRCodeUI.this.qkD.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                SelfQRCodeUI.this.qkD.setLayoutParams(layoutParams);
                AppMethodBeat.o(127014);
            }
        });
        AppMethodBeat.o(127027);
    }

    public void onDestroy() {
        AppMethodBeat.i(127028);
        g.Rg().b(168, (f) this);
        g.Rg().b(890, (f) this);
        if (this.qlx != null) {
            this.qlx.stop();
        }
        if (!(this.fru == null || this.fru.isRecycled())) {
            ab.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", this.fru.toString());
            this.fru.recycle();
        }
        super.onDestroy();
        AppMethodBeat.o(127028);
    }

    public void onResume() {
        AppMethodBeat.i(127029);
        super.onResume();
        if (t.mN(this.userName) || com.tencent.mm.aj.f.rc(this.userName)) {
            AppMethodBeat.o(127029);
            return;
        }
        View findViewById = findViewById(R.id.mx);
        this.kFU = r.YE();
        ab.d("MicroMsg.SelfQRCodeNewUI", (this.kFU & 2) + ",extstatus:" + this.kFU);
        if ((this.kFU & 2) != 0) {
            findViewById.setVisibility(0);
            this.qkD.setAlpha(0.1f);
            findViewById(R.id.my).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127018);
                    d.H(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
                    AppMethodBeat.o(127018);
                }
            });
            AppMethodBeat.o(127029);
            return;
        }
        findViewById.setVisibility(8);
        this.qkD.setAlpha(1.0f);
        AppMethodBeat.o(127029);
    }

    public final void initView() {
        AppMethodBeat.i(127030);
        this.userName = getIntent().getStringExtra("from_userName");
        if (bo.isNullOrNil(this.userName)) {
            this.userName = r.Yz();
        }
        if (r.Yz().equals(this.userName)) {
            this.qlw = true;
        }
        if (t.mN(this.userName)) {
            setMMTitle((int) R.string.ea0);
            ((TextView) findViewById(R.id.mz)).setText("");
            enableOptionMenu(false);
        } else if (com.tencent.mm.aj.f.rc(this.userName)) {
            setMMTitle((int) R.string.bdx);
            ((TextView) findViewById(R.id.mz)).setText(R.string.bdy);
            enableOptionMenu(false);
        } else {
            setMMTitle((int) R.string.e_o);
        }
        this.qkD = (ImageView) findViewById(R.id.mw);
        this.iqT = (ImageView) findViewById(R.id.ms);
        this.jPp = (TextView) findViewById(R.id.mu);
        this.qlv = (TextView) findViewById(R.id.mv);
        CharSequence charSequence;
        if (!t.mN(this.userName) && !com.tencent.mm.aj.f.rc(this.userName)) {
            String str = (String) g.RP().Ry().get(42, null);
            String string = getString(R.string.qf);
            if (bo.isNullOrNil(str)) {
                str = (String) g.RP().Ry().get(2, null);
                string = string + str;
                ad.aoA(str);
                str = string;
            } else {
                str = string + str;
            }
            ab.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", str);
            if (this.fru == null) {
                ab.d("MicroMsg.SelfQRCodeNewUI", "%s", "bitmap == null");
                Ck(1);
            } else {
                this.qkD.setImageBitmap(this.fru);
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(this.iqT, r.Yz());
            ab.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", (String) g.RP().Ry().get(4, null));
            this.jPp.setText(j.b((Context) this, charSequence, com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.kr)));
            bp aao = bp.aao();
            string = bo.nullAsNil(aao.getProvince());
            ab.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", s.mL(string) + " " + bo.nullAsNil(aao.getCity()));
            this.qlv.setText(str);
            switch (bo.a((Integer) g.RP().Ry().get(12290, null), 0)) {
                case 1:
                    this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this, R.raw.ic_sex_male), null);
                    break;
                case 2:
                    this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bz.a.g(this, R.raw.ic_sex_female), null);
                    break;
            }
        }
        Ck(1);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.iqT, this.userName);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.userName);
        this.jPp.setSingleLine(false);
        this.jPp.setMaxLines(3);
        if (t.mP(this.userName)) {
            this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.raw.open_im_main_logo), null);
        } else {
            this.jPp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        if (aoO != null) {
            charSequence = aoO.field_nickname;
            if (bo.isNullOrNil(charSequence)) {
                charSequence = ((c) g.K(c.class)).XV().ob(this.userName).field_displayname;
            }
            this.jPp.setText(j.b((Context) this, charSequence, this.jPp.getTextSize()));
        } else {
            this.jPp.setVisibility(8);
        }
        this.qlv.setVisibility(8);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127016);
                SelfQRCodeUI.b(SelfQRCodeUI.this);
                AppMethodBeat.o(127016);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127017);
                SelfQRCodeUI.this.aqX();
                SelfQRCodeUI.this.finish();
                AppMethodBeat.o(127017);
                return true;
            }
        });
        AppMethodBeat.o(127030);
    }

    private void Ck(int i) {
        int h;
        m gVar;
        AppMethodBeat.i(127031);
        if (this.qlw) {
            h = bo.h((Integer) g.RP().Ry().get(66561, null));
        } else {
            h = 0;
        }
        if (t.mP(this.userName)) {
            gVar = new com.tencent.mm.openim.b.g(this.userName);
            g.Rg().a(gVar, 0);
        } else {
            m aVar = new com.tencent.mm.bb.a(this.userName, h, i);
            g.Rg().a(aVar, 0);
            gVar = aVar;
        }
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.e2g), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127019);
                g.Rg().c(gVar);
                if (t.mN(SelfQRCodeUI.this.userName) || com.tencent.mm.aj.f.rc(SelfQRCodeUI.this.userName)) {
                    SelfQRCodeUI.this.finish();
                }
                AppMethodBeat.o(127019);
            }
        });
        AppMethodBeat.o(127031);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127032);
        ab.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar instanceof com.tencent.mm.bb.a) {
            final com.tencent.mm.bb.a aVar = (com.tencent.mm.bb.a) mVar;
            a(i, i2, str, new a() {
                public final byte[] ciy() {
                    return aVar.fME;
                }

                public final String ciz() {
                    return aVar.fMC;
                }

                public final String ciA() {
                    return aVar.fMD;
                }
            });
            AppMethodBeat.o(127032);
            return;
        }
        if (mVar instanceof com.tencent.mm.openim.b.g) {
            alj alj = (alj) ((com.tencent.mm.ai.b) ((com.tencent.mm.openim.b.g) mVar).ftl).fsH.fsP;
            final byte[] bArr = alj.wqK.wR;
            final String str2 = alj.vBP;
            a(i, i2, str, new a() {
                public final byte[] ciy() {
                    return bArr;
                }

                public final String ciz() {
                    return str2;
                }

                public final String ciA() {
                    return str2;
                }
            });
        }
        AppMethodBeat.o(127032);
    }

    private void a(int i, int i2, String str, a aVar) {
        AppMethodBeat.i(127033);
        if (com.tencent.mm.plugin.setting.b.gkF.b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(127033);
        } else if (i == 0 && i2 == 0) {
            this.qkE = aVar.ciy();
            this.fru = com.tencent.mm.sdk.platformtools.d.bQ(this.qkE);
            if (t.mN(this.userName) || com.tencent.mm.aj.f.rc(this.userName)) {
                enableOptionMenu(true);
                String ciz = aVar.ciz();
                if (!bo.isNullOrNil(ciz)) {
                    ((TextView) findViewById(R.id.mz)).setText(ciz);
                }
            } else if (this.qlw) {
                String ciA = aVar.ciA();
                TextView textView = (TextView) findViewById(R.id.e8p);
                View view = (View) textView.getParent();
                if (bo.isNullOrNil(ciA)) {
                    view.setVisibility(8);
                } else {
                    textView.setText(ciA);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(127015);
                            SelfQRCodeUI.f(SelfQRCodeUI.this);
                            AppMethodBeat.o(127015);
                        }
                    });
                    view.setVisibility(0);
                }
            }
            this.qkD.setImageBitmap(this.fru);
            AppMethodBeat.o(127033);
        } else {
            Toast.makeText(this, getString(R.string.bym, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(127033);
        }
    }

    public static void cix() {
        AppMethodBeat.i(127034);
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 14, 1, true);
        AppMethodBeat.o(127034);
    }

    static {
        AppMethodBeat.i(127039);
        AppMethodBeat.o(127039);
    }

    static /* synthetic */ void b(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.i(127035);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(selfQRCodeUI, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(127020);
                boolean mN = t.mN(SelfQRCodeUI.this.userName);
                boolean rc = com.tencent.mm.aj.f.rc(SelfQRCodeUI.this.userName);
                if (!(rc || mN)) {
                    lVar.hi(2, R.string.e2d);
                }
                lVar.hi(1, R.string.e2h);
                if (!rc) {
                    lVar.hi(3, R.string.e2x);
                }
                if (SelfQRCodeUI.this.qlw) {
                    lVar.hi(4, R.string.e2w);
                }
                AppMethodBeat.o(127020);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(127021);
                switch (menuItem.getItemId()) {
                    case 1:
                        SelfQRCodeUI.e(SelfQRCodeUI.this);
                        AppMethodBeat.o(127021);
                        return;
                    case 2:
                        SelfQRCodeUI.a(SelfQRCodeUI.this, 0);
                        AppMethodBeat.o(127021);
                        return;
                    case 3:
                        if (!(com.tencent.mm.r.a.bI(SelfQRCodeUI.this.mController.ylL) || e.akI())) {
                            d.H(SelfQRCodeUI.this.mController.ylL, "scanner", ".ui.BaseScanUI");
                            AppMethodBeat.o(127021);
                            return;
                        }
                    case 4:
                        SelfQRCodeUI.f(SelfQRCodeUI.this);
                        break;
                }
                AppMethodBeat.o(127021);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(127035);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3 A:{SYNTHETIC, Splitter:B:28:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3 A:{SYNTHETIC, Splitter:B:36:0x00c3} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        Throwable e;
        AppMethodBeat.i(127036);
        if (t.mN(selfQRCodeUI.userName) || com.tencent.mm.aj.f.rc(selfQRCodeUI.userName)) {
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 10, 1, true);
            Bitmap eA = com.tencent.mm.sdk.platformtools.d.eA(selfQRCodeUI.findViewById(R.id.e8n));
            if (eA != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                eA.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.qkE;
            }
        } else {
            toByteArray = selfQRCodeUI.qkE;
        }
        if (toByteArray == null || toByteArray.length <= 0) {
            AppMethodBeat.o(127036);
            return;
        }
        String str = com.tencent.mm.pluginsdk.ui.tools.n.dly() + "mmqrcode" + System.currentTimeMillis() + ".png";
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(toByteArray);
                Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(R.string.b3r, new Object[]{com.tencent.mm.pluginsdk.ui.tools.n.dly()}), 1).show();
                com.tencent.mm.pluginsdk.ui.tools.n.a(str, selfQRCodeUI);
                try {
                    fileOutputStream.close();
                    AppMethodBeat.o(127036);
                } catch (Exception e2) {
                    AppMethodBeat.o(127036);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            AppMethodBeat.o(127036);
                            return;
                        }
                    }
                    AppMethodBeat.o(127036);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.o(127036);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            ab.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(127036);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(127036);
            throw e;
        }
    }

    static /* synthetic */ void f(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.i(127038);
        com.tencent.mm.ui.base.h.a((Context) selfQRCodeUI, true, selfQRCodeUI.getString(R.string.dr9), selfQRCodeUI.getString(R.string.dr_), selfQRCodeUI.getString(R.string.dra), selfQRCodeUI.getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(127022);
                SelfQRCodeUI.a(SelfQRCodeUI.this, 2);
                AppMethodBeat.o(127022);
            }
        }, null);
        AppMethodBeat.o(127038);
    }
}
