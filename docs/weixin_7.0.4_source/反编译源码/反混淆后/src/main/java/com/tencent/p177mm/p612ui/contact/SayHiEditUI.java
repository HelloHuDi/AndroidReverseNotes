package com.tencent.p177mm.p612ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.ui.contact.SayHiEditUI */
public class SayHiEditUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private MMEditText zov;

    /* renamed from: com.tencent.mm.ui.contact.SayHiEditUI$2 */
    class C239122 implements OnMenuItemClickListener {
        C239122() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33842);
            SayHiEditUI.this.finish();
            AppMethodBeat.m2505o(33842);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SayHiEditUI$a */
    static class C23913a implements TextWatcher {
        private boolean eLU;

        private C23913a() {
            this.eLU = false;
        }

        /* synthetic */ C23913a(byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(33843);
            if (this.eLU) {
                AppMethodBeat.m2505o(33843);
                return;
            }
            this.eLU = true;
            C6998b.oTO.mo8097ae(3, 2, 10);
            AppMethodBeat.m2505o(33843);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33844);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
        setMMTitle((int) C25738R.string.d50);
        initView();
        AppMethodBeat.m2505o(33844);
    }

    public final int getLayoutId() {
        return 2130970534;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33845);
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(33845);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33846);
        this.zov = (MMEditText) findViewById(2131827175);
        this.zov.addTextChangedListener(new C23913a());
        C7357c.m12555d(this.zov).mo15877PM(100).mo15879a(null);
        final String stringExtra = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 18);
        final String stringExtra2 = getIntent().getStringExtra(C5495b.yfT);
        mo17379a(0, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(33841);
                SayHiEditUI.this.aqX();
                C6998b.oTO.mo8097ae(2, 1, 5);
                LinkedList linkedList = new LinkedList();
                linkedList.add(stringExtra);
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                LinkedList linkedList3 = new LinkedList();
                if (!C42252ah.isNullOrNil(stringExtra2)) {
                    linkedList3.add(stringExtra2);
                }
                final C1207m c46498m = new C46498m(2, linkedList, linkedList2, linkedList3, SayHiEditUI.m36858a(SayHiEditUI.this), "", null, null, "");
                C9638aw.m17182Rg().mo14541a(c46498m, 0);
                SayHiEditUI sayHiEditUI = SayHiEditUI.this;
                Context context = SayHiEditUI.this.mController.ylL;
                SayHiEditUI.this.getString(C25738R.string.f9238tz);
                sayHiEditUI.ehJ = C30379h.m48458b(context, SayHiEditUI.this.getString(C25738R.string.e3p), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(33840);
                        C9638aw.m17182Rg().mo14547c(c46498m);
                        AppMethodBeat.m2505o(33840);
                    }
                });
                AppMethodBeat.m2505o(33841);
                return false;
            }
        }, C5535b.GREEN);
        setBackBtn(new C239122());
        AppMethodBeat.m2505o(33846);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Object obj = 1;
        AppMethodBeat.m2504i(33847);
        C4990ab.m7416i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            switch (i2) {
                case -34:
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    Toast.makeText(this, C25738R.string.d54, 0).show();
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    Toast.makeText(this, C25738R.string.d51, 0).show();
                default:
                    obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(33847);
            } else if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getString(C25738R.string.ate));
                finish();
                AppMethodBeat.m2505o(33847);
            } else {
                if (i == 4 && i2 == -24) {
                    if (!C42252ah.isNullOrNil(str)) {
                        Toast.makeText(this, str, 1).show();
                        AppMethodBeat.m2505o(33847);
                        return;
                    }
                }
                if (i2 != XWalkUpdater.ERROR_SET_VERNUM || C42252ah.isNullOrNil(str)) {
                    Toast.makeText(this, C25738R.string.d52, 0).show();
                    AppMethodBeat.m2505o(33847);
                    return;
                }
                C30379h.m48443a((Context) this, str, getString(C25738R.string.f9238tz), getString(C25738R.string.f9187s6), null);
                AppMethodBeat.m2505o(33847);
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
            AppMethodBeat.m2505o(33847);
        }
    }

    /* renamed from: a */
    static /* synthetic */ String m36858a(SayHiEditUI sayHiEditUI) {
        AppMethodBeat.m2504i(33848);
        String trim = sayHiEditUI.zov.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.m2505o(33848);
            return trim;
        }
        trim = trim.substring(0, 50);
        AppMethodBeat.m2505o(33848);
        return trim;
    }
}
