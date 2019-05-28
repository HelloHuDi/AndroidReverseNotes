package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.io.FileOutputStream;

public class ShowQRCodeStep1UI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private ImageView qkD = null;
    byte[] qkE = null;
    private int qky = 1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ShowQRCodeStep1UI showQRCodeStep1UI, Class cls) {
        AppMethodBeat.i(126941);
        showQRCodeStep1UI.aA(cls);
        AppMethodBeat.o(126941);
    }

    public final int getLayoutId() {
        return R.layout.at0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126936);
        super.onCreate(bundle);
        initView();
        g.Rg().a(168, (f) this);
        AppMethodBeat.o(126936);
    }

    public void onDestroy() {
        AppMethodBeat.i(126937);
        g.Rg().b(168, (f) this);
        super.onDestroy();
        AppMethodBeat.o(126937);
    }

    public final void initView() {
        AppMethodBeat.i(126938);
        setMMTitle((int) R.string.e3f);
        this.qkD = (ImageView) findViewById(R.id.mw);
        this.qky = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(R.id.edo);
        if (this.qky == 3) {
            textView.setText(getString(R.string.e2l, new Object[]{getString(R.string.e2p)}));
        } else if (this.qky == 4) {
            textView.setText(getString(R.string.e2l, new Object[]{getString(R.string.e2m)}));
        } else if (this.qky == 2) {
            textView.setText(getString(R.string.e2l, new Object[]{getString(R.string.e2o)}));
        } else {
            textView.setText(getString(R.string.e2l, new Object[]{getString(R.string.e2n)}));
        }
        cit();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126931);
                ShowQRCodeStep1UI.this.aqX();
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.o(126931);
                return true;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126932);
                Context context = ShowQRCodeStep1UI.this;
                h.a(context, "", new String[]{context.getString(R.string.e2d), context.getString(R.string.e2h)}, "", false, new c() {
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083 A:{SYNTHETIC, Splitter:B:23:0x0083} */
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A:{SYNTHETIC, Splitter:B:31:0x0094} */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void iE(int i) {
                        Throwable e;
                        AppMethodBeat.i(126934);
                        switch (i) {
                            case 0:
                                ShowQRCodeStep1UI.this.cit();
                                AppMethodBeat.o(126934);
                                return;
                            case 1:
                                ShowQRCodeStep1UI showQRCodeStep1UI = ShowQRCodeStep1UI.this;
                                byte[] bArr = showQRCodeStep1UI.qkE;
                                if (bArr != null && bArr.length > 0) {
                                    String str = n.dly() + "mmqrcode" + System.currentTimeMillis() + ".png";
                                    FileOutputStream fileOutputStream;
                                    try {
                                        fileOutputStream = new FileOutputStream(str);
                                        try {
                                            fileOutputStream.write(bArr);
                                            Toast.makeText(showQRCodeStep1UI, showQRCodeStep1UI.getString(R.string.b3r, new Object[]{str}), 1).show();
                                            n.a(str, showQRCodeStep1UI);
                                            try {
                                                fileOutputStream.close();
                                                AppMethodBeat.o(126934);
                                                return;
                                            } catch (Exception e2) {
                                                AppMethodBeat.o(126934);
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                ab.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Exception e4) {
                                                        AppMethodBeat.o(126934);
                                                        return;
                                                    }
                                                }
                                                AppMethodBeat.o(126934);
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                if (fileOutputStream != null) {
                                                }
                                                AppMethodBeat.o(126934);
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        fileOutputStream = null;
                                        ab.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                        if (fileOutputStream != null) {
                                        }
                                        AppMethodBeat.o(126934);
                                        return;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        fileOutputStream = null;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception e6) {
                                            }
                                        }
                                        AppMethodBeat.o(126934);
                                        throw e;
                                    }
                                }
                        }
                        AppMethodBeat.o(126934);
                    }
                });
                AppMethodBeat.o(126932);
                return true;
            }
        });
        ((Button) findViewById(R.id.edp)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126933);
                Intent intent;
                if (ShowQRCodeStep1UI.this.qky == 3) {
                    byte[] jQ = g.RO().jQ(1);
                    ab.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", bo.anv(bo.cd(jQ)), r.Yz(), Integer.valueOf(bo.h((Integer) g.RP().Ry().get(66561, null))));
                    ab.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.x(jQ) + "&u=" + r2 + "&qr=" + r0 + "&device=" + d.eSg + "&version=" + d.vxo);
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", r0);
                    intent2.putExtra("title", ShowQRCodeStep1UI.this.getString(R.string.e2v));
                    com.tencent.mm.bp.d.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", intent2);
                    ShowQRCodeStep1UI.this.finish();
                    AppMethodBeat.o(126933);
                } else if (ShowQRCodeStep1UI.this.qky == 4) {
                    if (r.Za()) {
                        intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                        intent.putExtra("show_to", 4);
                        ShowQRCodeStep1UI.this.startActivity(intent);
                    } else {
                        ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
                    }
                    ShowQRCodeStep1UI.this.finish();
                    AppMethodBeat.o(126933);
                } else if (ShowQRCodeStep1UI.this.qky == 2) {
                    intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                    intent.putExtra("show_to", 2);
                    ShowQRCodeStep1UI.this.startActivity(intent);
                    ShowQRCodeStep1UI.this.finish();
                    AppMethodBeat.o(126933);
                } else {
                    intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                    intent.putExtra("show_to", 1);
                    ShowQRCodeStep1UI.this.startActivity(intent);
                    ShowQRCodeStep1UI.this.finish();
                    AppMethodBeat.o(126933);
                }
            }
        });
        AppMethodBeat.o(126938);
    }

    /* Access modifiers changed, original: final */
    public final void cit() {
        AppMethodBeat.i(126939);
        final m aVar = new a();
        g.Rg().a(aVar, 0);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.e2g), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(126935);
                g.Rg().c(aVar);
                AppMethodBeat.o(126935);
            }
        });
        AppMethodBeat.o(126939);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(126940);
        ab.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (b.gkF.b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(126940);
        } else if (i == 0 && i2 == 0) {
            this.qkE = ((a) mVar).fME;
            this.qkD.setImageBitmap(com.tencent.mm.sdk.platformtools.d.bQ(this.qkE));
            AppMethodBeat.o(126940);
        } else {
            Toast.makeText(this, getString(R.string.bym, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(126940);
        }
    }
}
