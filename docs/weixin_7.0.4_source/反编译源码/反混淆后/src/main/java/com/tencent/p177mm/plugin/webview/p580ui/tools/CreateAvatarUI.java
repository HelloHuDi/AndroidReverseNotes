package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.webview.model.C22892g;
import com.tencent.p177mm.plugin.webview.model.C22894n;
import com.tencent.p177mm.plugin.webview.model.C43917h;
import com.tencent.p177mm.plugin.webview.p1068e.C43865b;
import com.tencent.p177mm.plugin.webview.p1068e.C43865b.C29765b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.C35907bv;
import com.tencent.p177mm.protocal.protobuf.C35909bx;
import com.tencent.p177mm.protocal.protobuf.and;
import com.tencent.p177mm.protocal.protobuf.bet;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI */
public class CreateAvatarUI extends MMActivity implements C1202f, C5581a {
    private String appId;
    private C44275p ejZ;
    private String fileId;
    private InputMethodManager urd;
    private EditText ure;
    private String urf;
    private boolean urg = true;
    private boolean urh = false;
    private volatile C43865b urj;
    private String urk;
    private boolean urm = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$10 */
    class C456910 implements OnClickListener {
        C456910() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7362);
            CreateAvatarUI.afs(CreateAvatarUI.this.appId);
            AppMethodBeat.m2505o(7362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$5 */
    class C229145 implements OnKeyListener {
        C229145() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(7357);
            if (i == 4) {
                CreateAvatarUI.this.urd = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                if (CreateAvatarUI.this.urd != null && CreateAvatarUI.this.urd.isActive()) {
                    CreateAvatarUI.this.urd.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                    CreateAvatarUI.this.ure.setCursorVisible(false);
                    CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                }
            }
            AppMethodBeat.m2505o(7357);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$6 */
    class C229156 implements TextWatcher {
        C229156() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(7358);
            if (CreateAvatarUI.this.ure.getText().toString().equals("")) {
                CreateAvatarUI.this.findViewById(2131823165).setEnabled(false);
                AppMethodBeat.m2505o(7358);
                return;
            }
            CreateAvatarUI.this.findViewById(2131823165).setEnabled(true);
            AppMethodBeat.m2505o(7358);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$4 */
    class C298554 implements OnEditorActionListener {
        C298554() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(7356);
            if (i == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                CreateAvatarUI.this.urd = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                if (CreateAvatarUI.this.urd != null && CreateAvatarUI.this.urd.isActive()) {
                    CreateAvatarUI.this.urd.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                    CreateAvatarUI.this.ure.setCursorVisible(false);
                    CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                }
            }
            AppMethodBeat.m2505o(7356);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$7 */
    class C298567 implements OnTouchListener {
        C298567() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7359);
            if (motionEvent.getAction() == 0) {
                CreateAvatarUI.this.ure.setCursorVisible(true);
            }
            AppMethodBeat.m2505o(7359);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$11 */
    class C3562511 implements OnClickListener {
        C3562511() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7363);
            String obj = CreateAvatarUI.this.ure.getText().toString();
            String Ne = C42164b.m74343Ne();
            if (C5046bo.isNullOrNil(Ne) || !obj.matches(".*[" + Ne + "].*")) {
                C7357c.m12555d(CreateAvatarUI.this.ure).mo15880hz(1, 32).mo15879a(CreateAvatarUI.this);
                AppMethodBeat.m2505o(7363);
                return;
            }
            C30379h.m48461b(CreateAvatarUI.this.mController.ylL, CreateAvatarUI.this.getString(C25738R.string.ce4, new Object[]{Ne}), CreateAvatarUI.this.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(7363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$1 */
    class C402831 implements OnMenuItemClickListener {
        C402831() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7353);
            CreateAvatarUI.this.finish();
            AppMethodBeat.m2505o(7353);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$3 */
    class C439313 implements OnCancelListener {
        C439313() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7355);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(7355);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                AppMethodBeat.m2505o(7355);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$8 */
    class C439328 implements OnClickListener {
        C439328() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7360);
            C14987n.m23322k(CreateAvatarUI.this, 4);
            AppMethodBeat.m2505o(7360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$9 */
    class C439339 implements OnClickListener {
        C439339() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7361);
            CreateAvatarUI.afs(CreateAvatarUI.this.appId);
            AppMethodBeat.m2505o(7361);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI$2 */
    class C464352 implements Observer<String> {
        C464352() {
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AppMethodBeat.m2504i(7354);
            String str = (String) obj;
            C4990ab.m7417i("MicroMsg.CreateAvatarUI", "avatar file id get success = &s", CreateAvatarUI.this.urk);
            CreateAvatarUI.this.urk = str;
            if (CreateAvatarUI.this.urm) {
                C7357c.m12555d(CreateAvatarUI.this.ure).mo15880hz(1, 32).mo15879a(CreateAvatarUI.this);
            }
            AppMethodBeat.m2505o(7354);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7364);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        dyb();
        setMMTitle(getString(C25738R.string.b3l));
        setBackBtn(new C402831());
        this.appId = getIntent().getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.fileId = getIntent().getStringExtra("default_fileid");
        this.ure = (EditText) findViewById(2131823161);
        this.ure.setOnEditorActionListener(new C298554());
        this.ure.setOnKeyListener(new C229145());
        this.ure.addTextChangedListener(new C229156());
        this.ure.setOnTouchListener(new C298567());
        findViewById(2131823159).setOnClickListener(new C439328());
        findViewById(2131823163).setOnClickListener(new C439339());
        findViewById(2131823164).setOnClickListener(new C456910());
        findViewById(2131823165).setOnClickListener(new C3562511());
        AppMethodBeat.m2505o(7364);
    }

    public void onResume() {
        AppMethodBeat.m2504i(7365);
        super.onResume();
        C1720g.m3540Rg().mo14539a(2500, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2785, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2667, (C1202f) this);
        AppMethodBeat.m2505o(7365);
    }

    public void onPause() {
        AppMethodBeat.m2504i(7366);
        super.onPause();
        C1720g.m3540Rg().mo14546b(2500, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2785, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2667, (C1202f) this);
        AppMethodBeat.m2505o(7366);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7367);
        super.onDestroy();
        if (this.ejZ != null) {
            this.ejZ.dismiss();
        }
        AppMethodBeat.m2505o(7367);
    }

    public final int getLayoutId() {
        return 2130969251;
    }

    /* renamed from: ki */
    public final void mo11317ki(String str) {
        AppMethodBeat.m2504i(7368);
        this.urm = true;
        if (this.urh || this.urj == null || this.urg) {
            if (this.fileId == null || this.fileId.isEmpty()) {
                Bitmap b = C5056d.m7649b(C5056d.m7610LV(C1318a.default_avatar), 500, 500, false);
                String str2 = this.appId;
                byte[] ae = CreateAvatarUI.m87507ae(b);
                C4990ab.m7417i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str2);
                cZw();
                C1720g.m3540Rg().mo14541a(new C22892g(str2, str, ae), 0);
                AppMethodBeat.m2505o(7368);
                return;
            }
            CreateAvatarUI.m87508aw(this.appId, str, this.fileId);
            AppMethodBeat.m2505o(7368);
        } else if (this.urj.uKO == C29765b.SUCCESS) {
            CreateAvatarUI.m87508aw(this.appId, str, this.urk);
            AppMethodBeat.m2505o(7368);
        } else if (this.urj.uKO == C29765b.FAIL) {
            cZw();
            this.urj.mo69551ho(this.urf, this.appId);
            AppMethodBeat.m2505o(7368);
        } else {
            cZw();
            AppMethodBeat.m2505o(7368);
        }
    }

    /* renamed from: JW */
    public final void mo11315JW() {
        AppMethodBeat.m2504i(7369);
        C30379h.m48467g(this, C25738R.string.e8m, C25738R.string.e8p);
        AppMethodBeat.m2505o(7369);
    }

    /* renamed from: JX */
    public final void mo11316JX() {
        AppMethodBeat.m2504i(7370);
        C30379h.m48467g(this, C25738R.string.e8n, C25738R.string.e8p);
        AppMethodBeat.m2505o(7370);
    }

    /* renamed from: ae */
    private static byte[] m87507ae(Bitmap bitmap) {
        AppMethodBeat.m2504i(7371);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5056d.m7627a(bitmap, CompressFormat.JPEG, 85, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CreateAvatarUI", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(7371);
        return toByteArray;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(7372);
        C4990ab.m7417i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            C4990ab.m7412e("MicroMsg.CreateAvatarUI", "Get image from album failed");
            AppMethodBeat.m2505o(7372);
            return;
        }
        switch (i) {
            case 4:
                if (intent == null) {
                    AppMethodBeat.m2505o(7372);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                C17884o.acd();
                intent2.putExtra("CropImage_OutputPath", C41732d.m73515D(C1853r.m3846Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                intent2.setClassName(this, "com.tencent.mm.ui.tools.CropImageNewUI");
                C36338a.m59823b(this, intent, intent2, C43217c.m76863XW(), 5, null);
                AppMethodBeat.m2505o(7372);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        C4990ab.m7417i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", stringExtra, Long.valueOf(new File(stringExtra).length()));
                        this.urf = stringExtra;
                        this.urm = false;
                        this.urg = false;
                        this.urh = false;
                        ((ImageView) findViewById(2131823160)).setImageBitmap(BitmapFactory.decodeFile(stringExtra));
                        if (this.urj == null) {
                            this.urj = new C43865b();
                            this.urj.uKN.observe(this, new C464352());
                        }
                        this.urk = null;
                        this.urj.mo69551ho(this.urf, this.appId);
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.CreateAvatarUI", "crop picture failed");
                    AppMethodBeat.m2505o(7372);
                    return;
                }
                AppMethodBeat.m2505o(7372);
                return;
        }
        AppMethodBeat.m2505o(7372);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(7373);
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                int[] iArr = new int[]{0, 0};
                currentFocus.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                int height = currentFocus.getHeight() + i2;
                int width = currentFocus.getWidth() + i;
                if (motionEvent.getX() > ((float) i) && motionEvent.getX() < ((float) width) && motionEvent.getY() > ((float) i2) && motionEvent.getY() < ((float) height)) {
                    this.ure.setCursorVisible(true);
                }
                if (z) {
                    this.urd = (InputMethodManager) getSystemService("input_method");
                    if (this.urd != null) {
                        this.urd.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        this.ure.setCursorVisible(false);
                        getWindow().getDecorView().requestFocus();
                    }
                }
                z = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(7373);
                return z;
            }
            z = false;
            if (z) {
            }
            z = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(7373);
            return z;
        } else if (getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(7373);
            return true;
        } else {
            AppMethodBeat.m2505o(7373);
            return false;
        }
    }

    /* renamed from: aw */
    private static void m87508aw(String str, String str2, String str3) {
        AppMethodBeat.m2504i(7374);
        C4990ab.m7417i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str);
        C1720g.m3540Rg().mo14541a(new C22892g(str, str2, str3), 0);
        AppMethodBeat.m2505o(7374);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(7375);
        if (c1207m instanceof C22892g) {
            C4990ab.m7417i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            cZx();
            if (i == 0 && i2 == 0) {
                bet bet = ((C35909bx) ((C22892g) c1207m).ehh.fsH.fsP).vEe;
                Intent intent = new Intent();
                intent.putExtra("id", bet.f2978id);
                intent.putExtra("nickname", bet.nickname);
                intent.putExtra("avatarurl", bet.wrK);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(7375);
            } else if (m87503II(i)) {
                C30379h.m48461b((Context) this, str, getString(C25738R.string.b3d), true);
                AppMethodBeat.m2505o(7375);
            } else {
                C30379h.m48461b((Context) this, getString(C25738R.string.g0b), getString(C25738R.string.b3d), true);
                AppMethodBeat.m2505o(7375);
            }
        } else if (c1207m instanceof C22894n) {
            C4990ab.m7417i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                and and = (and) ((C22894n) c1207m).ehh.fsH.fsP;
                C17927a c17927a = new C17927a();
                c17927a.ePT = C1318a.default_avatar;
                c17927a.eQg = getResources().getDimension(C25738R.dimen.a7t);
                c17927a.eQf = true;
                C32291o.ahp().mo43766a(and.wrK, (ImageView) findViewById(2131823160), c17927a.ahG());
                this.ure.setText(and.nickname);
                this.urh = true;
                this.urg = false;
                this.fileId = and.fileid;
                if (this.ure.getText().toString().equals("")) {
                    findViewById(2131823165).setEnabled(false);
                    AppMethodBeat.m2505o(7375);
                    return;
                }
                findViewById(2131823165).setEnabled(true);
                AppMethodBeat.m2505o(7375);
            } else if (m87503II(i)) {
                C30379h.m48461b((Context) this, str, getString(C25738R.string.b3f), true);
                AppMethodBeat.m2505o(7375);
            } else {
                C30379h.m48461b((Context) this, getString(C25738R.string.g0b), getString(C25738R.string.b3f), true);
                AppMethodBeat.m2505o(7375);
            }
        } else {
            if (c1207m instanceof C43917h) {
                C4990ab.m7417i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.urj == null) {
                    C4990ab.m7412e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
                    AppMethodBeat.m2505o(7375);
                    return;
                }
                C43865b c43865b = this.urj;
                if (!((C43917h) c1207m).mnu.equals(c43865b.hWL)) {
                    C4990ab.m7417i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", c43865b.hWL, ((C43917h) c1207m).mnu);
                } else if (i == 0 && i2 == 0) {
                    c43865b.uKO = C29765b.SUCCESS;
                    c43865b.uKN.postValue(((C35907bv) ((C43917h) c1207m).ehh.fsH.fsP).fileid);
                    C4990ab.m7417i("MicroMsg.VestImgUploadEngine", "file id create success: %s", r0.fileid);
                } else {
                    c43865b.uKO = C29765b.FAIL;
                    C4990ab.m7417i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                }
                if (this.urm) {
                    cZx();
                    if (this.urj.uKO != C29765b.SUCCESS) {
                        cZx();
                        if (m87503II(i)) {
                            C30379h.m48461b((Context) this, str, getString(C25738R.string.b3d), true);
                        } else {
                            cZx();
                            C30379h.m48461b((Context) this, getString(C25738R.string.g0b), getString(C25738R.string.b3d), true);
                            AppMethodBeat.m2505o(7375);
                            return;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(7375);
        }
    }

    /* renamed from: II */
    private boolean m87503II(int i) {
        AppMethodBeat.m2504i(7376);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            C4990ab.m7412e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(7376);
            return false;
        } else if (C5023at.isConnected(this)) {
            AppMethodBeat.m2505o(7376);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.m2505o(7376);
            return false;
        }
    }

    private void cZw() {
        AppMethodBeat.m2504i(7377);
        if (this.ejZ == null || this.ejZ.isShowing()) {
            this.ejZ = C30379h.m48458b((Context) this, getString(C25738R.string.b3k), true, new C439313());
            AppMethodBeat.m2505o(7377);
            return;
        }
        this.ejZ.show();
        AppMethodBeat.m2505o(7377);
    }

    private void cZx() {
        AppMethodBeat.m2504i(7378);
        if (this.ejZ == null) {
            AppMethodBeat.m2505o(7378);
            return;
        }
        this.ejZ.dismiss();
        AppMethodBeat.m2505o(7378);
    }

    static /* synthetic */ void afs(String str) {
        AppMethodBeat.m2504i(7379);
        C4990ab.m7417i("MicroMsg.CreateAvatarUI", "doGetRandomAvatar appid: %s", str);
        C1720g.m3540Rg().mo14541a(new C22894n(str), 0);
        AppMethodBeat.m2505o(7379);
    }
}
