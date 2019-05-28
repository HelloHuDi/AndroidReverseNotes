package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import org.xwalk.core.XWalkUpdater;

public class SayHiEditUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private MMEditText zov;

    static class a implements TextWatcher {
        private boolean eLU;

        private a() {
            this.eLU = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(33843);
            if (this.eLU) {
                AppMethodBeat.o(33843);
                return;
            }
            this.eLU = true;
            b.oTO.ae(3, 2, 10);
            AppMethodBeat.o(33843);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33844);
        super.onCreate(bundle);
        aw.Rg().a(30, (f) this);
        setMMTitle((int) R.string.d50);
        initView();
        AppMethodBeat.o(33844);
    }

    public final int getLayoutId() {
        return R.layout.ap3;
    }

    public void onDestroy() {
        AppMethodBeat.i(33845);
        aw.Rg().b(30, (f) this);
        super.onDestroy();
        AppMethodBeat.o(33845);
    }

    public final void initView() {
        AppMethodBeat.i(33846);
        this.zov = (MMEditText) findViewById(R.id.e49);
        this.zov.addTextChangedListener(new a());
        c.d(this.zov).PM(100).a(null);
        final String stringExtra = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 18);
        final String stringExtra2 = getIntent().getStringExtra(e.b.yfT);
        a(0, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33841);
                SayHiEditUI.this.aqX();
                b.oTO.ae(2, 1, 5);
                LinkedList linkedList = new LinkedList();
                linkedList.add(stringExtra);
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                LinkedList linkedList3 = new LinkedList();
                if (!ah.isNullOrNil(stringExtra2)) {
                    linkedList3.add(stringExtra2);
                }
                final m mVar = new com.tencent.mm.pluginsdk.model.m(2, linkedList, linkedList2, linkedList3, SayHiEditUI.a(SayHiEditUI.this), "", null, null, "");
                aw.Rg().a(mVar, 0);
                SayHiEditUI sayHiEditUI = SayHiEditUI.this;
                Context context = SayHiEditUI.this.mController.ylL;
                SayHiEditUI.this.getString(R.string.tz);
                sayHiEditUI.ehJ = h.b(context, SayHiEditUI.this.getString(R.string.e3p), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(33840);
                        aw.Rg().c(mVar);
                        AppMethodBeat.o(33840);
                    }
                });
                AppMethodBeat.o(33841);
                return false;
            }
        }, q.b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33842);
                SayHiEditUI.this.finish();
                AppMethodBeat.o(33842);
                return true;
            }
        });
        AppMethodBeat.o(33846);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        Object obj = 1;
        AppMethodBeat.i(33847);
        ab.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            switch (i2) {
                case -34:
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    Toast.makeText(this, R.string.d54, 0).show();
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    Toast.makeText(this, R.string.d51, 0).show();
                default:
                    obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(33847);
            } else if (i == 0 && i2 == 0) {
                h.bQ(this, getString(R.string.ate));
                finish();
                AppMethodBeat.o(33847);
            } else {
                if (i == 4 && i2 == -24) {
                    if (!ah.isNullOrNil(str)) {
                        Toast.makeText(this, str, 1).show();
                        AppMethodBeat.o(33847);
                        return;
                    }
                }
                if (i2 != XWalkUpdater.ERROR_SET_VERNUM || ah.isNullOrNil(str)) {
                    Toast.makeText(this, R.string.d52, 0).show();
                    AppMethodBeat.o(33847);
                    return;
                }
                h.a((Context) this, str, getString(R.string.tz), getString(R.string.s6), null);
                AppMethodBeat.o(33847);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
            AppMethodBeat.o(33847);
        }
    }

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        AppMethodBeat.i(33848);
        String trim = sayHiEditUI.zov.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.o(33848);
            return trim;
        }
        trim = trim.substring(0, 50);
        AppMethodBeat.o(33848);
        return trim;
    }
}
