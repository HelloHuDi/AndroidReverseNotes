package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.vfs.b;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class MassSendMsgUI extends MMActivity implements f {
    private static String opb = "";
    private String filePath;
    private TextView nDX;
    private ChatFooter oor;
    private String oou;
    private List<String> oov;
    private boolean oow = false;
    private TextView opa;
    private c opc;
    private b opd;
    private AppPanel.a ope = new AppPanel.a() {
        public final void bNO() {
            AppMethodBeat.i(22834);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cz8), 0).show();
            AppMethodBeat.o(22834);
        }

        public final void bNP() {
            AppMethodBeat.i(22835);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cyq), 0).show();
            AppMethodBeat.o(22835);
        }

        public final void bNQ() {
            AppMethodBeat.i(22836);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cz6), 0).show();
            AppMethodBeat.o(22836);
        }

        public final void bNR() {
            AppMethodBeat.i(22837);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cyz), 0).show();
            AppMethodBeat.o(22837);
        }

        public final void bNS() {
            AppMethodBeat.i(22838);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cyq), 0).show();
            AppMethodBeat.o(22838);
        }

        public final void ys(int i) {
            AppMethodBeat.i(22839);
            switch (i) {
                case 0:
                    b bVar = new b(e.euR);
                    if (bVar.exists() || bVar.mkdirs()) {
                        ab.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), MassSendMsgUI.this.mController.ylL);
                        if (com.tencent.mm.pluginsdk.permission.b.a(MassSendMsgUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                            MassSendMsgUI.c(MassSendMsgUI.this);
                            break;
                        } else {
                            AppMethodBeat.o(22839);
                            return;
                        }
                    }
                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.aor), 1).show();
                    AppMethodBeat.o(22839);
                    return;
                    break;
                case 1:
                    n.a(MassSendMsgUI.this, 1, 1, 0, 3, null);
                    AppMethodBeat.o(22839);
                    return;
            }
            AppMethodBeat.o(22839);
        }

        public final void b(com.tencent.mm.pluginsdk.model.app.f fVar) {
        }

        public final void bNT() {
            AppMethodBeat.i(22840);
            com.tencent.mm.plugin.masssend.a.gkE.bj(MassSendMsgUI.this);
            AppMethodBeat.o(22840);
        }

        public final void bNU() {
            AppMethodBeat.i(22841);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cyq), 0).show();
            AppMethodBeat.o(22841);
        }

        public final void bNV() {
        }

        public final void bNW() {
            AppMethodBeat.i(22842);
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            d.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            AppMethodBeat.o(22842);
        }

        public final void yt(int i) {
            AppMethodBeat.i(22843);
            MassSendMsgUI.d(MassSendMsgUI.this);
            AppMethodBeat.o(22843);
        }

        public final void bNX() {
            AppMethodBeat.i(22844);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.cz0), 0).show();
            AppMethodBeat.o(22844);
        }

        public final void bNY() {
        }

        public final void bNZ() {
        }

        public final void bOa() {
        }

        public final void bOb() {
        }
    };
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MassSendMsgUI() {
        AppMethodBeat.i(22851);
        AppMethodBeat.o(22851);
    }

    static /* synthetic */ void b(MassSendMsgUI massSendMsgUI, Intent intent) {
        AppMethodBeat.i(22872);
        massSendMsgUI.aj(intent);
        AppMethodBeat.o(22872);
    }

    static /* synthetic */ void c(MassSendMsgUI massSendMsgUI) {
        AppMethodBeat.i(22869);
        massSendMsgUI.bCz();
        AppMethodBeat.o(22869);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22852);
        super.onCreate(bundle);
        aw.Rg().a((int) JsApiChooseMedia.CTRL_INDEX, (f) this);
        this.oow = getIntent().getBooleanExtra("mass_send_again", false);
        this.oou = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.oou;
        this.oov = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.oov = bo.P(split);
            }
        }
        initView();
        AppMethodBeat.o(22852);
    }

    public void onResume() {
        AppMethodBeat.i(22853);
        super.onResume();
        if (this.oor != null) {
            this.oor.setLastText(opb);
            this.oor.a(this.mController.ylL, (Activity) this);
        }
        AppMethodBeat.o(22853);
    }

    public static void Qy(String str) {
        opb = str;
    }

    public void onDestroy() {
        AppMethodBeat.i(22854);
        aw.Rg().b((int) JsApiChooseMedia.CTRL_INDEX, (f) this);
        super.onDestroy();
        if (this.oor != null) {
            this.oor.destroy();
        }
        AppMethodBeat.o(22854);
    }

    public void onPause() {
        AppMethodBeat.i(22855);
        this.oor.bvH();
        this.oor.onPause();
        super.onPause();
        AppMethodBeat.o(22855);
    }

    public final int getLayoutId() {
        return R.layout.acq;
    }

    public final void initView() {
        CharSequence spannableString;
        boolean z = true;
        AppMethodBeat.i(22856);
        setMMTitle((int) R.string.cz1);
        this.opa = (TextView) findViewById(R.id.d7s);
        this.nDX = (TextView) findViewById(R.id.d7r);
        TextView textView = this.opa;
        int textSize = (int) this.opa.getTextSize();
        if (this.oov == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.oov.size(); i++) {
                String mJ = s.mJ((String) this.oov.get(i));
                if (i == this.oov.size() - 1) {
                    stringBuilder.append(mJ);
                } else {
                    stringBuilder.append(mJ + ",  ");
                }
            }
            spannableString = j.b((Context) this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.nDX.setText(getResources().getQuantityString(R.plurals.s, this.oov.size(), new Object[]{Integer.valueOf(this.oov.size())}));
        this.oor = (ChatFooter) findViewById(R.id.alw);
        ((MassSendLayout) findViewById(R.id.d7q)).setPanel(this.oor.getPanel());
        this.oor.setCattingRootLayoutId(R.id.d7q);
        this.opd = new b(this, this.oor, this.oou, this.oov, this.oow);
        this.oor.setFooterEventListener(this.opd);
        this.oor.setSmileyPanelCallback(new d(this));
        ChatFooter chatFooter = this.oor;
        aw.ZK();
        int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.setMode(intValue);
        this.oor.setUserName("masssendapp");
        this.oor.vmM.refresh();
        aw.ZK();
        if (((Boolean) com.tencent.mm.model.c.Ry().get(66832, Boolean.FALSE)).booleanValue()) {
            this.oor.dkt();
            this.oor.dkd();
        }
        this.oor.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(22833);
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                if ((MassSendMsgUI.this.opc == null || !MassSendMsgUI.this.opc.isShowing()) && r.amn(substring)) {
                    Bitmap d = com.tencent.mm.sdk.platformtools.d.d(substring, 300, 300, false);
                    if (d == null) {
                        ab.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        AppMethodBeat.o(22833);
                        return;
                    }
                    View imageView = new ImageView(MassSendMsgUI.this);
                    imageView.setImageBitmap(d);
                    int dimensionPixelSize = MassSendMsgUI.this.getResources().getDimensionPixelSize(R.dimen.l5);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    MassSendMsgUI.this.opc = h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.aoh), imageView, MassSendMsgUI.this.getString(R.string.s6), MassSendMsgUI.this.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22832);
                            Intent intent = new Intent();
                            intent.putExtra("CropImage_OutputPath", substring);
                            MassSendMsgUI.a(MassSendMsgUI.this, intent);
                            AppMethodBeat.o(22832);
                        }
                    }, null);
                    String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                    MassSendMsgUI.this.oor.u(str, -1, false);
                    MassSendMsgUI.opb = str;
                }
                AppMethodBeat.o(22833);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.oor.vmM.djN();
        this.oor.vmM.djK();
        this.oor.vmM.djM();
        this.oor.ac(true, true);
        this.oor.vmM.djL();
        this.oor.oH(true);
        this.oor.setAppPanelListener(this.ope);
        ChatFooter chatFooter2 = this.oor;
        d.dlL();
        if (!com.tencent.mm.au.b.ahK()) {
            z = false;
        }
        chatFooter2.oI(z);
        this.oor.vmM.djO();
        this.oor.vmM.djP();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22824);
                MassSendMsgUI.this.finish();
                AppMethodBeat.o(22824);
                return true;
            }
        });
        AppMethodBeat.o(22856);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(22857);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && this.oor.dky()) {
            this.oor.setBottomPanelVisibility(8);
            AppMethodBeat.o(22857);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(22857);
        return onKeyDown;
    }

    private void bCz() {
        AppMethodBeat.i(22858);
        if (!n.c(this, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(R.string.e29), 1).show();
        }
        AppMethodBeat.o(22858);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(22859);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(22859);
            return;
        }
        ab.i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22845);
                            MassSendMsgUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(22845);
                        }
                    }, null);
                    break;
                }
                bCz();
                AppMethodBeat.o(22859);
                return;
        }
        AppMethodBeat.o(22859);
    }

    private void ag(Intent intent) {
        AppMethodBeat.i(22860);
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.onZ = this.oou;
        aVar.ooa = this.oov.size();
        aVar.filename = stringExtra;
        aVar.oob = intExtra;
        aVar.msgType = 43;
        final m fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, this.oow);
        aw.Rg().a(fVar, 0);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.tipDialog = h.b(context, getString(R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22846);
                aw.Rg().c(fVar);
                AppMethodBeat.o(22846);
            }
        });
        AppMethodBeat.o(22860);
    }

    private void ah(Intent intent) {
        AppMethodBeat.i(22861);
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra == null) {
            AppMethodBeat.o(22861);
            return;
        }
        int i;
        if (com.tencent.mm.model.r.g(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true))) {
            i = 1;
        } else {
            i = 0;
        }
        com.tencent.mm.plugin.masssend.a.h.bNE();
        com.tencent.mm.plugin.masssend.a.a i2 = com.tencent.mm.plugin.masssend.a.b.i(stringExtra, this.oou, this.oov.size(), i);
        if (i2 == null) {
            AppMethodBeat.o(22861);
            return;
        }
        final m fVar = new com.tencent.mm.plugin.masssend.a.f(i2, this.oow, i);
        aw.Rg().a(fVar, 0);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.tipDialog = h.b(context, getString(R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22847);
                aw.Rg().c(fVar);
                AppMethodBeat.o(22847);
            }
        });
        AppMethodBeat.o(22861);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22862);
        ab.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(22862);
            return;
        }
        String stringExtra;
        Context applicationContext;
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(22862);
                    return;
                } else if (intent.getBooleanExtra("is_video", false)) {
                    stringExtra = intent.getStringExtra("video_full_path");
                    Intent intent2 = new Intent();
                    intent2.setData(Uri.parse("file://".concat(String.valueOf(stringExtra))));
                    ai(intent2);
                    AppMethodBeat.o(22862);
                    return;
                } else {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    com.tencent.mm.pluginsdk.n nVar = com.tencent.mm.plugin.masssend.a.gkE;
                    aw.ZK();
                    nVar.a((Activity) this, intent, intent3, com.tencent.mm.model.c.XW(), 4, null);
                    AppMethodBeat.o(22862);
                    return;
                }
            case 2:
                applicationContext = getApplicationContext();
                aw.ZK();
                this.filePath = n.h(applicationContext, intent, com.tencent.mm.model.c.XW());
                if (this.filePath == null) {
                    AppMethodBeat.o(22862);
                    return;
                }
                Intent intent4 = new Intent();
                intent4.putExtra("CropImageMode", 4);
                intent4.putExtra("CropImage_Filter", true);
                intent4.putExtra("CropImage_ImgPath", this.filePath);
                com.tencent.mm.plugin.masssend.a.gkE.a(this.mController.ylL, intent4, 4);
                AppMethodBeat.o(22862);
                return;
            case 4:
                ah(intent);
                AppMethodBeat.o(22862);
                return;
            case 5:
                ag(intent);
                AppMethodBeat.o(22862);
                return;
            case 6:
                ai(intent);
                AppMethodBeat.o(22862);
                return;
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(22862);
                    return;
                } else if (intent.getBooleanExtra("from_record", false)) {
                    ag(intent);
                    AppMethodBeat.o(22862);
                    return;
                } else {
                    ai(intent);
                    AppMethodBeat.o(22862);
                    return;
                }
            case 8:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        stringExtra = sightCaptureResult.osI;
                        if (!bo.isNullOrNil(stringExtra)) {
                            try {
                                ab.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", stringExtra);
                                com.tencent.mm.plugin.masssend.a.h.bNE();
                                com.tencent.mm.plugin.masssend.a.a i3 = com.tencent.mm.plugin.masssend.a.b.i(stringExtra, this.oou, this.oov.size(), 0);
                                if (i3 == null) {
                                    AppMethodBeat.o(22862);
                                    return;
                                }
                                final m fVar = new com.tencent.mm.plugin.masssend.a.f(i3, this.oow, 0);
                                aw.Rg().a(fVar, 0);
                                applicationContext = this.mController.ylL;
                                getString(R.string.tz);
                                this.tipDialog = h.b(applicationContext, getString(R.string.e3p), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(22848);
                                        aw.Rg().c(fVar);
                                        AppMethodBeat.o(22848);
                                    }
                                });
                                AppMethodBeat.o(22862);
                                return;
                            } catch (Exception e) {
                                ab.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", e.getMessage());
                            }
                        }
                        AppMethodBeat.o(22862);
                        return;
                    }
                    ab.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                    o.all();
                    String uh = t.uh(sightCaptureResult.osE);
                    if (!sightCaptureResult.osC.equals(uh)) {
                        ab.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", sightCaptureResult.osC, uh);
                        com.tencent.mm.vfs.e.aQ(sightCaptureResult.osC, uh);
                    }
                    uh = sightCaptureResult.osE;
                    final int i4 = sightCaptureResult.osG;
                    final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
                    getString(R.string.tz);
                    this.tipDialog = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            cVar.fUF = null;
                        }
                    });
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(22850);
                            VideoTransPara afG = com.tencent.mm.modelcontrol.d.afF().afG();
                            baa baa = new baa();
                            baa.wDP = true;
                            if (l.a(uh, afG, baa, new com.tencent.mm.plugin.mmsight.model.d() {
                                public final boolean bOc() {
                                    return false;
                                }
                            })) {
                                l.b(uh, afG, baa, new com.tencent.mm.plugin.mmsight.model.d() {
                                    public final boolean bOc() {
                                        return false;
                                    }
                                });
                            }
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(22849);
                                    MassSendMsgUI.a(MassSendMsgUI.this, uh, i4);
                                    AppMethodBeat.o(22849);
                                }
                            });
                            AppMethodBeat.o(22850);
                        }
                    }, "MassSend_Remux");
                }
                AppMethodBeat.o(22862);
                return;
            default:
                ab.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.o(22862);
                return;
        }
    }

    private void ai(final Intent intent) {
        AppMethodBeat.i(22863);
        if (com.tencent.mm.network.ab.ch(this)) {
            aj(intent);
            AppMethodBeat.o(22863);
            return;
        }
        h.a((Context) this, (int) R.string.f17, (int) R.string.tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(22825);
                MassSendMsgUI.b(MassSendMsgUI.this, intent);
                AppMethodBeat.o(22825);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(22863);
    }

    private void aj(Intent intent) {
        AppMethodBeat.i(22864);
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.string.tz);
        this.tipDialog = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                cVar.fUF = null;
            }
        });
        cVar.a(this, intent, new com.tencent.mm.modelvideo.c.a() {
            public final void b(int i, final String str, final String str2, final int i2) {
                AppMethodBeat.i(22829);
                ab.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", Integer.valueOf(i), str, str2);
                if (i >= 0 || i == -50002) {
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(22828);
                            if (MassSendMsgUI.a(MassSendMsgUI.this, str, str2)) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(22826);
                                        MassSendMsgUI.a(MassSendMsgUI.this, str, i2);
                                        AppMethodBeat.o(22826);
                                    }
                                });
                                AppMethodBeat.o(22828);
                                return;
                            }
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(22827);
                                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.f16), 0).show();
                                    if (MassSendMsgUI.this.tipDialog != null) {
                                        MassSendMsgUI.this.tipDialog.dismiss();
                                        MassSendMsgUI.this.tipDialog = null;
                                    }
                                    AppMethodBeat.o(22827);
                                }
                            });
                            AppMethodBeat.o(22828);
                        }
                    }, "MassSend_Remux");
                } else {
                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.string.f15), 0).show();
                    if (MassSendMsgUI.this.tipDialog != null) {
                        MassSendMsgUI.this.tipDialog.dismiss();
                        MassSendMsgUI.this.tipDialog = null;
                        AppMethodBeat.o(22829);
                        return;
                    }
                }
                AppMethodBeat.o(22829);
            }
        });
        AppMethodBeat.o(22864);
    }

    private boolean eY(String str, String str2) {
        double d;
        AppMethodBeat.i(22865);
        boolean is2G = at.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        ab.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)));
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                AppMethodBeat.o(22865);
                return false;
            case 0:
                int i2;
                int i3;
                o.all();
                String uh = t.uh(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                ab.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", uh);
                int i4 = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i5 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                VideoTransPara videoTransPara = new VideoTransPara();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(str2, pInt, pInt2, pInt3, pInt4, pInt5);
                videoTransPara.duration = pInt.value / 1000;
                videoTransPara.width = pInt2.value;
                videoTransPara.height = pInt3.value;
                videoTransPara.fps = pInt4.value;
                videoTransPara.videoBitrate = pInt5.value;
                VideoTransPara b = com.tencent.mm.modelcontrol.d.afF().b(videoTransPara);
                int i6 = com.tencent.mm.plugin.sight.base.b.qwZ;
                ab.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", videoTransPara, b);
                if (b == null) {
                    i2 = 0;
                    i = i5;
                    int i7 = i4;
                    while (i2 < 3) {
                        if (i7 % 2 != 0) {
                            i7--;
                        }
                        if (i % 2 != 0) {
                            i--;
                        }
                        if ((i7 < i || (i7 > 640 && i > 480)) && (i7 > i || (i7 > 480 && i > 640))) {
                            i7 /= 2;
                            i /= 2;
                            i2++;
                        } else {
                            i3 = i7;
                        }
                    }
                    i = i5;
                    i3 = i4;
                } else {
                    i3 = b.width;
                    i = b.height;
                    i6 = b.videoBitrate;
                }
                mediaMetadataRetriever.release();
                if (SightVideoJNI.remuxing(str2, uh, i3, i, i6, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qxa, null, 0, false) < 0) {
                    ab.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                    AppMethodBeat.o(22865);
                    return false;
                }
                Qz(uh);
                o.all();
                String ui = t.ui(str);
                if (!com.tencent.mm.vfs.e.ct(ui)) {
                    ab.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", ui);
                    try {
                        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(uh, 1);
                        if (createVideoThumbnail != null) {
                            com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 60, CompressFormat.JPEG, ui, true);
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                        ab.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", e.getMessage());
                    }
                }
                ab.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", uh, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(22865);
                return true;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                o.all();
                Qz(t.uh(str));
                AppMethodBeat.o(22865);
                return true;
            default:
                AppMethodBeat.o(22865);
                return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22866);
        ab.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.opd != null) {
            b bVar = this.opd;
            if (bVar.tipDialog != null) {
                bVar.tipDialog.dismiss();
                bVar.tipDialog = null;
            }
        }
        if (i == 0 && i2 == 0) {
            opb = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
            AppMethodBeat.o(22866);
        } else if (i == 4 && i2 == -24) {
            ab.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, R.string.cyw, 0).show();
            AppMethodBeat.o(22866);
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.oor.setLastText(opb);
            }
            com.tencent.mm.plugin.masssend.a.gkF.a(this.mController.ylL, i, i2, str);
            switch (i2) {
                case -71:
                    h.a((Context) this, getString(R.string.cz7, new Object[]{Integer.valueOf(((baq) ((com.tencent.mm.plugin.masssend.a.f) mVar).ehh.fsH.fsP).wEC)}), getString(R.string.tz), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22831);
                            MassSendMsgUI.this.finish();
                            AppMethodBeat.o(22831);
                        }
                    });
                    AppMethodBeat.o(22866);
                    return;
                case -34:
                    Toast.makeText(this, R.string.cyv, 0).show();
                    AppMethodBeat.o(22866);
                    return;
                default:
                    Toast.makeText(this, R.string.e3n, 0).show();
                    AppMethodBeat.o(22866);
                    return;
            }
        }
    }

    private static void Qz(String str) {
        AppMethodBeat.i(22867);
        long asZ = com.tencent.mm.vfs.e.asZ(str);
        int h = bo.h((Integer) com.tencent.mm.plugin.report.service.h.a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, 247, 255));
        com.tencent.mm.plugin.report.service.h.pYm.a(106, (long) h, 1, false);
        com.tencent.mm.plugin.report.service.h.pYm.a(106, 246, 1, false);
        ab.d("MicroMsg.MassSendMsgUI", "report video size res : " + h + " hadCompress : true fileLen : " + (asZ / 1024) + "K");
        AppMethodBeat.o(22867);
    }

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        AppMethodBeat.i(22870);
        ab.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), bo.dpG(), massSendMsgUI);
        if (com.tencent.mm.pluginsdk.permission.b.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            ab.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), bo.dpG(), massSendMsgUI);
            if (com.tencent.mm.pluginsdk.permission.b.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                com.tencent.mm.plugin.report.service.h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(1));
                n.e(massSendMsgUI, new Intent(), massSendMsgUI.oou);
            }
        }
        AppMethodBeat.o(22870);
    }
}
