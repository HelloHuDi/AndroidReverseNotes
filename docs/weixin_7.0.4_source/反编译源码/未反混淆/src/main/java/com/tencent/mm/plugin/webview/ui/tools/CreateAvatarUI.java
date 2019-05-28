package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.webview.e.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class CreateAvatarUI extends MMActivity implements f, a {
    private String appId;
    private p ejZ;
    private String fileId;
    private InputMethodManager urd;
    private EditText ure;
    private String urf;
    private boolean urg = true;
    private boolean urh = false;
    private volatile b urj;
    private String urk;
    private boolean urm = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7364);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.d4));
        dyb();
        setMMTitle(getString(R.string.b3l));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7353);
                CreateAvatarUI.this.finish();
                AppMethodBeat.o(7353);
                return true;
            }
        });
        this.appId = getIntent().getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.fileId = getIntent().getStringExtra("default_fileid");
        this.ure = (EditText) findViewById(R.id.b6q);
        this.ure.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(7356);
                if (i == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                    CreateAvatarUI.this.urd = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                    if (CreateAvatarUI.this.urd != null && CreateAvatarUI.this.urd.isActive()) {
                        CreateAvatarUI.this.urd.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                        CreateAvatarUI.this.ure.setCursorVisible(false);
                        CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                    }
                }
                AppMethodBeat.o(7356);
                return false;
            }
        });
        this.ure.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(7357);
                if (i == 4) {
                    CreateAvatarUI.this.urd = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                    if (CreateAvatarUI.this.urd != null && CreateAvatarUI.this.urd.isActive()) {
                        CreateAvatarUI.this.urd.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                        CreateAvatarUI.this.ure.setCursorVisible(false);
                        CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                    }
                }
                AppMethodBeat.o(7357);
                return false;
            }
        });
        this.ure.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(7358);
                if (CreateAvatarUI.this.ure.getText().toString().equals("")) {
                    CreateAvatarUI.this.findViewById(R.id.b6u).setEnabled(false);
                    AppMethodBeat.o(7358);
                    return;
                }
                CreateAvatarUI.this.findViewById(R.id.b6u).setEnabled(true);
                AppMethodBeat.o(7358);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.ure.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(7359);
                if (motionEvent.getAction() == 0) {
                    CreateAvatarUI.this.ure.setCursorVisible(true);
                }
                AppMethodBeat.o(7359);
                return false;
            }
        });
        findViewById(R.id.b6o).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7360);
                n.k(CreateAvatarUI.this, 4);
                AppMethodBeat.o(7360);
            }
        });
        findViewById(R.id.b6s).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7361);
                CreateAvatarUI.afs(CreateAvatarUI.this.appId);
                AppMethodBeat.o(7361);
            }
        });
        findViewById(R.id.b6t).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7362);
                CreateAvatarUI.afs(CreateAvatarUI.this.appId);
                AppMethodBeat.o(7362);
            }
        });
        findViewById(R.id.b6u).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7363);
                String obj = CreateAvatarUI.this.ure.getText().toString();
                String Ne = com.tencent.mm.m.b.Ne();
                if (bo.isNullOrNil(Ne) || !obj.matches(".*[" + Ne + "].*")) {
                    c.d(CreateAvatarUI.this.ure).hz(1, 32).a(CreateAvatarUI.this);
                    AppMethodBeat.o(7363);
                    return;
                }
                h.b(CreateAvatarUI.this.mController.ylL, CreateAvatarUI.this.getString(R.string.ce4, new Object[]{Ne}), CreateAvatarUI.this.getString(R.string.tz), true);
                AppMethodBeat.o(7363);
            }
        });
        AppMethodBeat.o(7364);
    }

    public void onResume() {
        AppMethodBeat.i(7365);
        super.onResume();
        g.Rg().a(2500, (f) this);
        g.Rg().a(2785, (f) this);
        g.Rg().a(2667, (f) this);
        AppMethodBeat.o(7365);
    }

    public void onPause() {
        AppMethodBeat.i(7366);
        super.onPause();
        g.Rg().b(2500, (f) this);
        g.Rg().b(2785, (f) this);
        g.Rg().a(2667, (f) this);
        AppMethodBeat.o(7366);
    }

    public void onDestroy() {
        AppMethodBeat.i(7367);
        super.onDestroy();
        if (this.ejZ != null) {
            this.ejZ.dismiss();
        }
        AppMethodBeat.o(7367);
    }

    public final int getLayoutId() {
        return R.layout.rh;
    }

    public final void ki(String str) {
        AppMethodBeat.i(7368);
        this.urm = true;
        if (this.urh || this.urj == null || this.urg) {
            if (this.fileId == null || this.fileId.isEmpty()) {
                Bitmap b = d.b(d.LV(R.raw.default_avatar), 500, 500, false);
                String str2 = this.appId;
                byte[] ae = ae(b);
                ab.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str2);
                cZw();
                g.Rg().a(new com.tencent.mm.plugin.webview.model.g(str2, str, ae), 0);
                AppMethodBeat.o(7368);
                return;
            }
            aw(this.appId, str, this.fileId);
            AppMethodBeat.o(7368);
        } else if (this.urj.uKO == b.b.SUCCESS) {
            aw(this.appId, str, this.urk);
            AppMethodBeat.o(7368);
        } else if (this.urj.uKO == b.b.FAIL) {
            cZw();
            this.urj.ho(this.urf, this.appId);
            AppMethodBeat.o(7368);
        } else {
            cZw();
            AppMethodBeat.o(7368);
        }
    }

    public final void JW() {
        AppMethodBeat.i(7369);
        h.g(this, R.string.e8m, R.string.e8p);
        AppMethodBeat.o(7369);
    }

    public final void JX() {
        AppMethodBeat.i(7370);
        h.g(this, R.string.e8n, R.string.e8p);
        AppMethodBeat.o(7370);
    }

    private static byte[] ae(Bitmap bitmap) {
        AppMethodBeat.i(7371);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d.a(bitmap, CompressFormat.JPEG, 85, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CreateAvatarUI", e, "", new Object[0]);
        }
        AppMethodBeat.o(7371);
        return toByteArray;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(7372);
        ab.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            ab.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
            AppMethodBeat.o(7372);
            return;
        }
        switch (i) {
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(7372);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                o.acd();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.D(r.Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                intent2.setClassName(this, "com.tencent.mm.ui.tools.CropImageNewUI");
                com.tencent.mm.ui.tools.a.b(this, intent, intent2, com.tencent.mm.plugin.i.c.XW(), 5, null);
                AppMethodBeat.o(7372);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        ab.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", stringExtra, Long.valueOf(new File(stringExtra).length()));
                        this.urf = stringExtra;
                        this.urm = false;
                        this.urg = false;
                        this.urh = false;
                        ((ImageView) findViewById(R.id.b6p)).setImageBitmap(BitmapFactory.decodeFile(stringExtra));
                        if (this.urj == null) {
                            this.urj = new b();
                            this.urj.uKN.observe(this, new Observer<String>() {
                                public final /* synthetic */ void onChanged(Object obj) {
                                    AppMethodBeat.i(7354);
                                    String str = (String) obj;
                                    ab.i("MicroMsg.CreateAvatarUI", "avatar file id get success = &s", CreateAvatarUI.this.urk);
                                    CreateAvatarUI.this.urk = str;
                                    if (CreateAvatarUI.this.urm) {
                                        c.d(CreateAvatarUI.this.ure).hz(1, 32).a(CreateAvatarUI.this);
                                    }
                                    AppMethodBeat.o(7354);
                                }
                            });
                        }
                        this.urk = null;
                        this.urj.ho(this.urf, this.appId);
                        break;
                    }
                    ab.e("MicroMsg.CreateAvatarUI", "crop picture failed");
                    AppMethodBeat.o(7372);
                    return;
                }
                AppMethodBeat.o(7372);
                return;
        }
        AppMethodBeat.o(7372);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(7373);
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
                AppMethodBeat.o(7373);
                return z;
            }
            z = false;
            if (z) {
            }
            z = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(7373);
            return z;
        } else if (getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent)) {
            AppMethodBeat.o(7373);
            return true;
        } else {
            AppMethodBeat.o(7373);
            return false;
        }
    }

    private static void aw(String str, String str2, String str3) {
        AppMethodBeat.i(7374);
        ab.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str);
        g.Rg().a(new com.tencent.mm.plugin.webview.model.g(str, str2, str3), 0);
        AppMethodBeat.o(7374);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(7375);
        if (mVar instanceof com.tencent.mm.plugin.webview.model.g) {
            ab.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            cZx();
            if (i == 0 && i2 == 0) {
                bet bet = ((bx) ((com.tencent.mm.plugin.webview.model.g) mVar).ehh.fsH.fsP).vEe;
                Intent intent = new Intent();
                intent.putExtra("id", bet.id);
                intent.putExtra("nickname", bet.nickname);
                intent.putExtra("avatarurl", bet.wrK);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(7375);
            } else if (II(i)) {
                h.b((Context) this, str, getString(R.string.b3d), true);
                AppMethodBeat.o(7375);
            } else {
                h.b((Context) this, getString(R.string.g0b), getString(R.string.b3d), true);
                AppMethodBeat.o(7375);
            }
        } else if (mVar instanceof com.tencent.mm.plugin.webview.model.n) {
            ab.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                and and = (and) ((com.tencent.mm.plugin.webview.model.n) mVar).ehh.fsH.fsP;
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePT = R.raw.default_avatar;
                aVar.eQg = getResources().getDimension(R.dimen.a7t);
                aVar.eQf = true;
                com.tencent.mm.at.o.ahp().a(and.wrK, (ImageView) findViewById(R.id.b6p), aVar.ahG());
                this.ure.setText(and.nickname);
                this.urh = true;
                this.urg = false;
                this.fileId = and.fileid;
                if (this.ure.getText().toString().equals("")) {
                    findViewById(R.id.b6u).setEnabled(false);
                    AppMethodBeat.o(7375);
                    return;
                }
                findViewById(R.id.b6u).setEnabled(true);
                AppMethodBeat.o(7375);
            } else if (II(i)) {
                h.b((Context) this, str, getString(R.string.b3f), true);
                AppMethodBeat.o(7375);
            } else {
                h.b((Context) this, getString(R.string.g0b), getString(R.string.b3f), true);
                AppMethodBeat.o(7375);
            }
        } else {
            if (mVar instanceof com.tencent.mm.plugin.webview.model.h) {
                ab.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.urj == null) {
                    ab.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
                    AppMethodBeat.o(7375);
                    return;
                }
                b bVar = this.urj;
                if (!((com.tencent.mm.plugin.webview.model.h) mVar).mnu.equals(bVar.hWL)) {
                    ab.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", bVar.hWL, ((com.tencent.mm.plugin.webview.model.h) mVar).mnu);
                } else if (i == 0 && i2 == 0) {
                    bVar.uKO = b.b.SUCCESS;
                    bVar.uKN.postValue(((bv) ((com.tencent.mm.plugin.webview.model.h) mVar).ehh.fsH.fsP).fileid);
                    ab.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", r0.fileid);
                } else {
                    bVar.uKO = b.b.FAIL;
                    ab.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                }
                if (this.urm) {
                    cZx();
                    if (this.urj.uKO != b.b.SUCCESS) {
                        cZx();
                        if (II(i)) {
                            h.b((Context) this, str, getString(R.string.b3d), true);
                        } else {
                            cZx();
                            h.b((Context) this, getString(R.string.g0b), getString(R.string.b3d), true);
                            AppMethodBeat.o(7375);
                            return;
                        }
                    }
                }
            }
            AppMethodBeat.o(7375);
        }
    }

    private boolean II(int i) {
        AppMethodBeat.i(7376);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            ab.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.o(7376);
            return false;
        } else if (at.isConnected(this)) {
            AppMethodBeat.o(7376);
            return true;
        } else {
            ab.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(7376);
            return false;
        }
    }

    private void cZw() {
        AppMethodBeat.i(7377);
        if (this.ejZ == null || this.ejZ.isShowing()) {
            this.ejZ = h.b((Context) this, getString(R.string.b3k), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(7355);
                    try {
                        dialogInterface.dismiss();
                        AppMethodBeat.o(7355);
                    } catch (Exception e) {
                        ab.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                        AppMethodBeat.o(7355);
                    }
                }
            });
            AppMethodBeat.o(7377);
            return;
        }
        this.ejZ.show();
        AppMethodBeat.o(7377);
    }

    private void cZx() {
        AppMethodBeat.i(7378);
        if (this.ejZ == null) {
            AppMethodBeat.o(7378);
            return;
        }
        this.ejZ.dismiss();
        AppMethodBeat.o(7378);
    }

    static /* synthetic */ void afs(String str) {
        AppMethodBeat.i(7379);
        ab.i("MicroMsg.CreateAvatarUI", "doGetRandomAvatar appid: %s", str);
        g.Rg().a(new com.tencent.mm.plugin.webview.model.n(str), 0);
        AppMethodBeat.o(7379);
    }
}
