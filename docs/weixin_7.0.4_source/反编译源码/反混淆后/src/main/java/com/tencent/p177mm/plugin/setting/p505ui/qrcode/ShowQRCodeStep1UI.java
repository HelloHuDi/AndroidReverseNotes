package com.tencent.p177mm.plugin.setting.p505ui.qrcode;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1528bb.C37508a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.FacebookAuthUI;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.FileOutputStream;

/* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI */
public class ShowQRCodeStep1UI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private ImageView qkD = null;
    byte[] qkE = null;
    private int qky = 1;

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI$1 */
    class C435031 implements OnMenuItemClickListener {
        C435031() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126931);
            ShowQRCodeStep1UI.this.aqX();
            ShowQRCodeStep1UI.this.finish();
            AppMethodBeat.m2505o(126931);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI$2 */
    class C435042 implements OnMenuItemClickListener {
        C435042() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126932);
            Context context = ShowQRCodeStep1UI.this;
            C30379h.m48424a(context, "", new String[]{context.getString(C25738R.string.e2d), context.getString(C25738R.string.e2h)}, "", false, new C435064());
            AppMethodBeat.m2505o(126932);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI$3 */
    class C435053 implements OnClickListener {
        C435053() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126933);
            Intent intent;
            if (ShowQRCodeStep1UI.this.qky == 3) {
                byte[] jQ = C1720g.m3535RO().mo5189jQ(1);
                C4990ab.m7411d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", C5046bo.anv(C5046bo.m7543cd(jQ)), C1853r.m3846Yz(), Integer.valueOf(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66561, null))));
                C4990ab.m7411d("MicroMsg.ShowQRCodeStep1UI", "[%s]", "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + C1178g.m2591x(jQ) + "&u=" + r2 + "&qr=" + r0 + "&device=" + C7243d.eSg + "&version=" + C7243d.vxo);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", r0);
                intent2.putExtra("title", ShowQRCodeStep1UI.this.getString(C25738R.string.e2v));
                C25985d.m41467b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", intent2);
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.m2505o(126933);
            } else if (ShowQRCodeStep1UI.this.qky == 4) {
                if (C1853r.m3847Za()) {
                    intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                    intent.putExtra("show_to", 4);
                    ShowQRCodeStep1UI.this.startActivity(intent);
                } else {
                    ShowQRCodeStep1UI.m86350a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
                }
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.m2505o(126933);
            } else if (ShowQRCodeStep1UI.this.qky == 2) {
                intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                intent.putExtra("show_to", 2);
                ShowQRCodeStep1UI.this.startActivity(intent);
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.m2505o(126933);
            } else {
                intent = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                intent.putExtra("show_to", 1);
                ShowQRCodeStep1UI.this.startActivity(intent);
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.m2505o(126933);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI$4 */
    class C435064 implements C30391c {
        C435064() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0083 A:{SYNTHETIC, Splitter:B:23:0x0083} */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A:{SYNTHETIC, Splitter:B:31:0x0094} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: iE */
        public final void mo7700iE(int i) {
            Throwable e;
            AppMethodBeat.m2504i(126934);
            switch (i) {
                case 0:
                    ShowQRCodeStep1UI.this.cit();
                    AppMethodBeat.m2505o(126934);
                    return;
                case 1:
                    ShowQRCodeStep1UI showQRCodeStep1UI = ShowQRCodeStep1UI.this;
                    byte[] bArr = showQRCodeStep1UI.qkE;
                    if (bArr != null && bArr.length > 0) {
                        String str = C14987n.dly() + "mmqrcode" + System.currentTimeMillis() + ".png";
                        FileOutputStream fileOutputStream;
                        try {
                            fileOutputStream = new FileOutputStream(str);
                            try {
                                fileOutputStream.write(bArr);
                                Toast.makeText(showQRCodeStep1UI, showQRCodeStep1UI.getString(C25738R.string.b3r, new Object[]{str}), 1).show();
                                C14987n.m23300a(str, showQRCodeStep1UI);
                                try {
                                    fileOutputStream.close();
                                    AppMethodBeat.m2505o(126934);
                                    return;
                                } catch (Exception e2) {
                                    AppMethodBeat.m2505o(126934);
                                    return;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    C4990ab.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e4) {
                                            AppMethodBeat.m2505o(126934);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.m2505o(126934);
                                    return;
                                } catch (Throwable th) {
                                    e = th;
                                    if (fileOutputStream != null) {
                                    }
                                    AppMethodBeat.m2505o(126934);
                                    throw e;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileOutputStream = null;
                            C4990ab.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(126934);
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
                            AppMethodBeat.m2505o(126934);
                            throw e;
                        }
                    }
            }
            AppMethodBeat.m2505o(126934);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m86350a(ShowQRCodeStep1UI showQRCodeStep1UI, Class cls) {
        AppMethodBeat.m2504i(126941);
        showQRCodeStep1UI.mo17383aA(cls);
        AppMethodBeat.m2505o(126941);
    }

    public final int getLayoutId() {
        return 2130970679;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126936);
        super.onCreate(bundle);
        initView();
        C1720g.m3540Rg().mo14539a(168, (C1202f) this);
        AppMethodBeat.m2505o(126936);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(126937);
        C1720g.m3540Rg().mo14546b(168, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(126937);
    }

    public final void initView() {
        AppMethodBeat.m2504i(126938);
        setMMTitle((int) C25738R.string.e3f);
        this.qkD = (ImageView) findViewById(2131821047);
        this.qky = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(2131827561);
        if (this.qky == 3) {
            textView.setText(getString(C25738R.string.e2l, new Object[]{getString(C25738R.string.e2p)}));
        } else if (this.qky == 4) {
            textView.setText(getString(C25738R.string.e2l, new Object[]{getString(C25738R.string.e2m)}));
        } else if (this.qky == 2) {
            textView.setText(getString(C25738R.string.e2l, new Object[]{getString(C25738R.string.e2o)}));
        } else {
            textView.setText(getString(C25738R.string.e2l, new Object[]{getString(C25738R.string.e2n)}));
        }
        cit();
        setBackBtn(new C435031());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C435042());
        ((Button) findViewById(2131827562)).setOnClickListener(new C435053());
        AppMethodBeat.m2505o(126938);
    }

    /* Access modifiers changed, original: final */
    public final void cit() {
        AppMethodBeat.m2504i(126939);
        final C1207m c37508a = new C37508a();
        C1720g.m3540Rg().mo14541a(c37508a, 0);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.e2g), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(126935);
                C1720g.m3540Rg().mo14547c(c37508a);
                AppMethodBeat.m2505o(126935);
            }
        });
        AppMethodBeat.m2505o(126939);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(126940);
        C4990ab.m7417i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (C24824b.gkF.mo38861b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(126940);
        } else if (i == 0 && i2 == 0) {
            this.qkE = ((C37508a) c1207m).fME;
            this.qkD.setImageBitmap(C5056d.m7652bQ(this.qkE));
            AppMethodBeat.m2505o(126940);
        } else {
            Toast.makeText(this, getString(C25738R.string.bym, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(126940);
        }
    }
}
