package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.aa;
import com.tencent.mm.plugin.qqmail.b.ab;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.z;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.s;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<o> pwd;
    private p gBk;
    private int mode = 5;
    private int ptH = 1;
    private ab puY = ac.ccD();
    private long pvG;
    private Map<String, String> pvf = new HashMap();
    private com.tencent.mm.ui.base.o pwA;
    public boolean pwB = true;
    public boolean pwC = true;
    public boolean pwD = false;
    private String pwE = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String pwF = "document.getElementById('history').innerHTML";
    private String pwG = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String pwH = "</div>";
    private String pwI = null;
    private String pwJ = null;
    private String pwK = "weixin://get_img_info/";
    private String pwL = "weixin://get_mail_content/";
    private String pwM = "weixin://img_onclick/";
    private boolean pwN = false;
    private boolean pwO = false;
    private ap pwP = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(68167);
            ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
            AppMethodBeat.o(68167);
            return true;
        }
    }, true);
    private ap pwQ = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(68184);
            if (ComposeUI.this.pwB && ComposeUI.a(ComposeUI.this, false) && ComposeUI.this.mode == 5) {
                ComposeUI.b(ComposeUI.this);
                if (ComposeUI.this.pwA != null) {
                    ComposeUI.this.pwA.dismiss();
                }
                ComposeUI.this.pwA = t.a(ComposeUI.this, ComposeUI.this.getString(R.string.ddb), (long) FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.o(68184);
            return true;
        }
    }, true);
    com.tencent.mm.plugin.qqmail.b.p.a pwR = new com.tencent.mm.plugin.qqmail.b.p.a() {
        public final void onComplete() {
            AppMethodBeat.i(68195);
            com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b bVar = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b(ComposeUI.this, ComposeUI.this.pww.Vi(null));
            ComposeUI.this.pwf.setAddrsAdapter(bVar);
            ComposeUI.this.pwj.setAddrsAdapter(bVar);
            ComposeUI.this.pwm.setAddrsAdapter(bVar);
            AppMethodBeat.o(68195);
        }
    };
    private OnClickListener pwS = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(68174);
            ComposeUI.this.pwh.setVisibility(8);
            ComposeUI.this.pwi.setVisibility(0);
            ComposeUI.this.pwl.setVisibility(0);
            ComposeUI.this.pwh.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68173);
                    ComposeUI.this.pwi.requestFocus();
                    ComposeUI.this.pwj.cdj();
                    ComposeUI.this.pwm.cdj();
                    AppMethodBeat.o(68173);
                }
            });
            AppMethodBeat.o(68174);
        }
    };
    private OnClickListener pwT = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(68176);
            h.a(ComposeUI.this, null, new String[]{ComposeUI.this.getString(R.string.dda), ComposeUI.this.getString(R.string.dd8), ComposeUI.this.getString(R.string.dd9)}, null, new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(68175);
                    switch (i) {
                        case 0:
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), ComposeUI.this.mController.ylL);
                            if (com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                                ComposeUI.C(ComposeUI.this);
                                AppMethodBeat.o(68175);
                                return;
                            }
                            AppMethodBeat.o(68175);
                            return;
                        case 1:
                            n.a(ComposeUI.this, 4, null);
                            AppMethodBeat.o(68175);
                            return;
                        case 2:
                            ComposeUI.this.startActivityForResult(new Intent(ComposeUI.this, FileExplorerUI.class), 5);
                            break;
                    }
                    AppMethodBeat.o(68175);
                }
            });
            AppMethodBeat.o(68176);
        }
    };
    private OnMenuItemClickListener pwU = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(68179);
            if ((ComposeUI.a(ComposeUI.this, false) && ComposeUI.this.mode == 5) || ComposeUI.this.mode == 6) {
                h.d(ComposeUI.this.mController.ylL, ComposeUI.this.getString(R.string.ddh), "", ComposeUI.this.getString(R.string.ddj), ComposeUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(68178);
                        ComposeUI.this.setResult(0);
                        ComposeUI.this.finish();
                        AppMethodBeat.o(68178);
                    }
                }, null);
            } else {
                ComposeUI.this.setResult(0);
                ComposeUI.this.finish();
            }
            AppMethodBeat.o(68179);
            return true;
        }
    };
    private OnClickListener pwV = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(68183);
            ComposeUI.this.aqX();
            ComposeUI.this.pwo.getText();
            ComposeUI.D(ComposeUI.this);
            if (ComposeUI.this.ccT()) {
                ComposeUI composeUI = ComposeUI.this;
                Context context = ComposeUI.this;
                ComposeUI.this.getString(R.string.tz);
                composeUI.gBk = h.b(context, ComposeUI.this.getString(R.string.dd2), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(68180);
                        ComposeUI.this.pwx.cdb();
                        ComposeUI.this.pwx.pxV = null;
                        ac.ccC().cancel(ComposeUI.this.pvG);
                        AppMethodBeat.o(68180);
                    }
                });
                if (ComposeUI.this.pwx.cdc()) {
                    ComposeUI.this.pvG = ComposeUI.H(ComposeUI.this);
                    AppMethodBeat.o(68183);
                    return;
                }
                ComposeUI.this.gBk.setMessage(ComposeUI.this.getString(R.string.dcz));
                ComposeUI.this.pwx.pxV = new com.tencent.mm.plugin.qqmail.ui.b.b() {
                    public final void ccU() {
                        AppMethodBeat.i(68181);
                        ComposeUI.this.gBk.setMessage(ComposeUI.this.getString(R.string.dcz));
                        AppMethodBeat.o(68181);
                    }

                    public final void onComplete() {
                        AppMethodBeat.i(68182);
                        ComposeUI.this.pvG = ComposeUI.H(ComposeUI.this);
                        AppMethodBeat.o(68182);
                    }
                };
                AppMethodBeat.o(68183);
                return;
            }
            AppMethodBeat.o(68183);
        }
    };
    private OnClickListener pwW = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(68187);
            if (ComposeUI.this.pwx.cdc()) {
                u.a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
                ComposeUI.this.pwO = true;
                AppMethodBeat.o(68187);
                return;
            }
            ComposeUI.this.gBk = h.b(ComposeUI.this, ComposeUI.this.getString(R.string.dcz), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(68185);
                    ComposeUI.this.pwx.cdb();
                    ComposeUI.this.pwx.pxV = null;
                    AppMethodBeat.o(68185);
                }
            });
            ComposeUI.this.pwx.pxV = new com.tencent.mm.plugin.qqmail.ui.b.b() {
                public final void ccU() {
                }

                public final void onComplete() {
                    AppMethodBeat.i(68186);
                    ComposeUI.this.gBk.dismiss();
                    u.a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
                    ComposeUI.this.pwO = true;
                    AppMethodBeat.o(68186);
                }
            };
            AppMethodBeat.o(68187);
        }
    };
    private com.tencent.mm.plugin.qqmail.b.v.a pwX = new com.tencent.mm.plugin.qqmail.b.v.a() {
        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.i(68191);
            h.a(ComposeUI.this, (int) R.string.dd3, (int) R.string.tz, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(68189);
                    File file = new File(ac.ccC().puE.ptG.ptQ + i.cR(ComposeUI.this.pwz, ComposeUI.this.ptH));
                    if (file.exists()) {
                        file.delete();
                    }
                    ComposeUI.this.setResult(-1);
                    ComposeUI.this.finish();
                    AppMethodBeat.o(68189);
                }
            });
            ComposeUI.this.pww.cG(ComposeUI.this.pwf.getMailAddrs());
            ComposeUI.this.pww.cG(ComposeUI.this.pwj.getMailAddrs());
            ComposeUI.this.pww.cG(ComposeUI.this.pwm.getMailAddrs());
            AppMethodBeat.o(68191);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.i(68192);
            if (i == -5) {
                ComposeUI.this.pwy.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                    public final void ccF() {
                        AppMethodBeat.i(68190);
                        ComposeUI.H(ComposeUI.this);
                        AppMethodBeat.o(68190);
                    }

                    public final void ccG() {
                    }
                });
                AppMethodBeat.o(68192);
                return;
            }
            h.a(ComposeUI.this, str, ComposeUI.this.getString(R.string.dd1), null);
            AppMethodBeat.o(68192);
        }

        public final void onComplete() {
            AppMethodBeat.i(68193);
            if (ComposeUI.this.gBk != null) {
                ComposeUI.this.gBk.dismiss();
                ComposeUI.this.gBk = null;
            }
            AppMethodBeat.o(68193);
        }
    };
    private ScrollView pwe;
    protected MailAddrsViewControl pwf;
    private ImageView pwg;
    private LinearLayout pwh;
    private LinearLayout pwi;
    private MailAddrsViewControl pwj;
    private ImageView pwk;
    private LinearLayout pwl;
    private MailAddrsViewControl pwm;
    private ImageView pwn;
    private EditText pwo;
    private LinearLayout pwp;
    private TextView pwq;
    private ImageView pwr;
    private LinearLayout pws;
    private TextView pwt;
    private EditText pwu;
    private MMWebView pwv;
    private com.tencent.mm.plugin.qqmail.b.p pww;
    private b pwx;
    public c pwy = new c(this);
    private String pwz;

    class a extends l {
        private a() {
        }

        /* synthetic */ a(ComposeUI composeUI, byte b) {
            this();
        }

        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(68207);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", consoleMessage);
            String akn = u.akn(consoleMessage != null ? consoleMessage.message() : null);
            String[] split;
            if (akn.startsWith(ComposeUI.this.pwM)) {
                ComposeUI.this.aqX();
                try {
                    String[] split2 = URLDecoder.decode(akn.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    String str = split2[0];
                    String str2 = split2[1];
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", split[1], str, str2);
                    bi jf = ((j) g.K(j.class)).bOr().jf((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", jf.field_msgId);
                    intent.putExtra("img_server_id", jf.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", jf.field_talker);
                    ComposeUI.this.startActivity(intent);
                    AppMethodBeat.o(68207);
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (akn.startsWith(ComposeUI.this.pwL)) {
                try {
                    ComposeUI.this.pwJ = URLDecoder.decode(akn.substring(ComposeUI.this.pwL.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwO) {
                    if (ComposeUI.this.pwJ.indexOf("<img") == -1) {
                        ComposeUI.this.pvf.clear();
                        ComposeUI.r(ComposeUI.this);
                        AppMethodBeat.o(68207);
                        return true;
                    }
                    u.a(ComposeUI.this.pwv, ComposeUI.this.pwK, ComposeUI.this.pwE);
                }
                AppMethodBeat.o(68207);
                return true;
            } else {
                if (akn.startsWith(ComposeUI.this.pwK)) {
                    ComposeUI.this.pvf.clear();
                    try {
                        String[] split3 = URLDecoder.decode(akn.substring(ComposeUI.this.pwK.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String akn2 : split3) {
                            split = akn2.split("@@");
                            Object obj = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                            ComposeUI.this.pvf.put(obj, obj2);
                        }
                        if (ComposeUI.this.pwO) {
                            ComposeUI.r(ComposeUI.this);
                        }
                        AppMethodBeat.o(68207);
                        return true;
                    } catch (Exception e22) {
                        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", e22.getMessage());
                        AppMethodBeat.o(68207);
                        return true;
                    }
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(68207);
                return onConsoleMessage;
            }
        }
    }

    class c extends com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c {
        private ImageView pxl;
        private int tag;

        public c(ImageView imageView, int i) {
            this.pxl = imageView;
            this.tag = i;
        }

        public final void jW(boolean z) {
            ImageView imageView;
            int i = 0;
            AppMethodBeat.i(68212);
            ComposeUI.y(ComposeUI.this);
            if (ComposeUI.this.pwD) {
                imageView = this.pxl;
            } else {
                imageView = this.pxl;
                if (!z) {
                    i = 4;
                }
            }
            imageView.setVisibility(i);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                ComposeUI.this.pwh.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(68211);
                        if (!ComposeUI.this.pwj.pyz.isFocused() && !ComposeUI.this.pwm.pyz.isFocused() && ComposeUI.this.pwj.getMailAddrs().size() == 0 && ComposeUI.this.pwm.getMailAddrs().size() == 0 && ComposeUI.this.pwj.cdg() && ComposeUI.this.pwm.cdg()) {
                            ComposeUI.this.pwh.setVisibility(0);
                            ComposeUI.this.pwi.setVisibility(8);
                            ComposeUI.this.pwl.setVisibility(8);
                        }
                        AppMethodBeat.o(68211);
                    }
                }, 10);
            }
            AppMethodBeat.o(68212);
        }
    }

    class b extends s {
        private boolean pxk;

        private b() {
            this.pxk = false;
        }

        /* synthetic */ b(ComposeUI composeUI, byte b) {
            this();
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(68208);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", str);
            String[] split;
            String str2;
            if (str.startsWith(ComposeUI.this.pwM)) {
                ComposeUI.this.aqX();
                try {
                    split = URLDecoder.decode(str.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    String str3 = split[0];
                    str2 = split[1];
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", r0[1], str3, str2);
                    bi jf = ((j) g.K(j.class)).bOr().jf((long) Integer.valueOf(str3).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", jf.field_msgId);
                    intent.putExtra("img_server_id", jf.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", jf.field_talker);
                    ComposeUI.this.startActivity(intent);
                    AppMethodBeat.o(68208);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (str.startsWith(ComposeUI.this.pwL)) {
                try {
                    ComposeUI.this.pwJ = URLDecoder.decode(str.substring(ComposeUI.this.pwL.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwO) {
                    if (ComposeUI.this.pwJ.indexOf("<img") == -1) {
                        ComposeUI.this.pvf.clear();
                        ComposeUI.r(ComposeUI.this);
                        AppMethodBeat.o(68208);
                    } else {
                        u.a(ComposeUI.this.pwv, ComposeUI.this.pwK, ComposeUI.this.pwE);
                    }
                }
                AppMethodBeat.o(68208);
            } else {
                if (str.startsWith(ComposeUI.this.pwK)) {
                    ComposeUI.this.pvf.clear();
                    try {
                        String[] split2 = URLDecoder.decode(str.substring(ComposeUI.this.pwK.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String str22 : split2) {
                            split = str22.split("@@");
                            Object obj = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                            ComposeUI.this.pvf.put(obj, obj2);
                        }
                        if (ComposeUI.this.pwO) {
                            ComposeUI.r(ComposeUI.this);
                        }
                        AppMethodBeat.o(68208);
                    } catch (Exception e22) {
                        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", e22.getMessage());
                        AppMethodBeat.o(68208);
                    }
                }
                AppMethodBeat.o(68208);
            }
            return true;
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(68209);
            super.b(webView, str, bitmap);
            if (!ComposeUI.this.pwN) {
                u.d(ComposeUI.this.pwv);
                ComposeUI.this.pwN = true;
            }
            AppMethodBeat.o(68209);
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(68210);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", str, Boolean.valueOf(this.pxk));
            if (!this.pxk) {
                this.pxk = true;
                u.a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
            }
            super.b(webView, str);
            AppMethodBeat.o(68210);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ComposeUI() {
        AppMethodBeat.i(68213);
        AppMethodBeat.o(68213);
    }

    static /* synthetic */ void C(ComposeUI composeUI) {
        AppMethodBeat.i(68235);
        composeUI.bCz();
        AppMethodBeat.o(68235);
    }

    static /* synthetic */ String D(ComposeUI composeUI) {
        AppMethodBeat.i(68236);
        String ccS = composeUI.ccS();
        AppMethodBeat.o(68236);
        return ccS;
    }

    static /* synthetic */ void h(ComposeUI composeUI) {
        AppMethodBeat.i(68232);
        composeUI.ccQ();
        AppMethodBeat.o(68232);
    }

    public final int getLayoutId() {
        return R.layout.am6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68214);
        super.onCreate(bundle);
        this.pwI = this.pwG + "%s" + this.pwH;
        this.pwN = false;
        this.pwO = false;
        this.ptH = getIntent().getIntExtra("composeType", 1);
        this.pwz = getIntent().getStringExtra("mailid");
        if (this.pwz == null) {
            this.pwz = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "onCreate, mode = %d", Integer.valueOf(this.mode));
        initView();
        this.pww = ac.ccC().puD;
        this.pww.a(this.pwR);
        this.pww.ccq();
        this.pwQ.ae(180000, 180000);
        AppMethodBeat.o(68214);
    }

    public void onResume() {
        AppMethodBeat.i(68215);
        super.onResume();
        this.pwP.ae(1500, 1500);
        AppMethodBeat.o(68215);
    }

    public void onPause() {
        AppMethodBeat.i(68216);
        super.onPause();
        aqX();
        this.pwP.stopTimer();
        if (this.pwA != null) {
            this.pwA.dismiss();
        }
        AppMethodBeat.o(68216);
    }

    public void onDestroy() {
        AppMethodBeat.i(68217);
        super.onDestroy();
        if (pwd != null) {
            pwd = null;
        }
        this.pwx.cdb();
        g.RO().eJo.b(484, this.pwx);
        this.pww.b(this.pwR);
        this.pwy.release();
        this.pwQ.stopTimer();
        AppMethodBeat.o(68217);
    }

    private void ccQ() {
        AppMethodBeat.i(68218);
        this.pwf.clearFocus();
        this.pwj.clearFocus();
        this.pwm.clearFocus();
        AppMethodBeat.o(68218);
    }

    public final void initView() {
        String str;
        AppMethodBeat.i(68219);
        this.pwe = (ScrollView) findViewById(R.id.dri);
        this.pwf = (MailAddrsViewControl) findViewById(R.id.drm);
        this.pwg = (ImageView) findViewById(R.id.drn);
        this.pwh = (LinearLayout) findViewById(R.id.dro);
        this.pwi = (LinearLayout) findViewById(R.id.drp);
        this.pwj = (MailAddrsViewControl) findViewById(R.id.drq);
        this.pwk = (ImageView) findViewById(R.id.drr);
        this.pwl = (LinearLayout) findViewById(R.id.drs);
        this.pwm = (MailAddrsViewControl) findViewById(R.id.drt);
        this.pwn = (ImageView) findViewById(R.id.dru);
        this.pwo = (EditText) findViewById(R.id.drw);
        this.pwp = (LinearLayout) findViewById(R.id.dry);
        this.pwt = (TextView) findViewById(R.id.ds2);
        this.pwu = (EditText) findViewById(R.id.ds3);
        this.pwv = com.tencent.mm.ui.widget.MMWebView.a.n(this, R.id.ds4);
        this.pwq = (TextView) findViewById(R.id.drz);
        this.pwr = (ImageView) findViewById(R.id.ds0);
        this.pws = (LinearLayout) findViewById(R.id.ds1);
        this.pwf.setEditable(true);
        this.pwj.setEditable(true);
        this.pwm.setEditable(true);
        String stringExtra = getIntent().getStringExtra("mail_content");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        ArrayList stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        com.tencent.mm.plugin.qqmail.b.j cQ = ac.ccC().puE.cQ(this.pwz, this.ptH);
        this.pwx = new b(this, this.pwq, this.pwr, this.pws, (byte) 0);
        if (!bo.isNullOrNil(stringExtra)) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                ccR();
                this.pwf.requestFocus();
                this.pwJ = String.format(this.pwI, new Object[]{stringExtra});
                this.pwv.loadDataWithBaseURL("", this.pwJ, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwu.setVisibility(8);
                this.pwv.setVisibility(0);
            } else if (this.mode == 5) {
                this.pwu.setVisibility(0);
                this.pwv.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set content in html format");
                    this.pwu.setText(Html.fromHtml(stringExtra));
                } else {
                    this.pwu.setText(stringExtra);
                }
            }
            this.pwx.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.pwx.cde() > DeviceUtils.MIN_STORAGE_SIZE) {
                            h.a((Context) this, (int) R.string.de4, (int) R.string.tz, null);
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(this.mode));
                        int i2 = i + 1;
                        this.pwx.fG(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (cQ == null || this.mode != 6) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                ccR();
                this.pwf.requestFocus();
                this.pwJ = String.format(this.pwI, new Object[]{""});
                this.pwv.loadDataWithBaseURL("", this.pwJ, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwu.setVisibility(8);
                this.pwv.setVisibility(0);
            } else if (this.mode == 5) {
                this.pwv.setVisibility(8);
                this.pwu.setVisibility(0);
            }
            this.pwx.mode = this.mode;
        } else {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.pwf.cJ(cQ.ptJ);
            this.pwj.cJ(cQ.ptK);
            this.pwm.cJ(cQ.ptL);
            this.pwo.setText(cQ.ptN);
            str2 = cQ.content;
            this.mode = 5;
            if (str2.indexOf("<div>") != -1) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set content in html format");
                this.pwu.setText(Html.fromHtml(str2));
            } else {
                this.pwu.setText(str2);
            }
            this.pwx.mode = this.mode;
            this.pwx.cI(cQ.ptM);
            this.pwx.cdd();
            this.pwv.setVisibility(8);
            this.pwu.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.ptH != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.pwf.b(stringArrayExtra, false);
            this.pwj.b(stringArrayExtra2, false);
            this.pwm.b(stringArrayExtra3, false);
            if (!bo.isNullOrNil(stringExtra2)) {
                EditText editText = this.pwo;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.ptH == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.ptH == 2 || this.ptH == 3) {
            this.pwt.setVisibility(0);
        } else if (this.ptH == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.pwf.b(stringArrayExtra, false);
            }
        } else if (this.ptH == 1) {
            str2 = getIntent().getStringExtra("subject");
            if (!bo.isNullOrNil(str2)) {
                this.pwo.setText(str2);
            }
        }
        if (this.pwj.getMailAddrs().size() > 0 || this.pwm.getMailAddrs().size() > 0) {
            this.pwh.setVisibility(8);
            this.pwi.setVisibility(0);
            this.pwl.setVisibility(0);
        }
        if (this.ptH == 2 && this.mode != 6 && this.mode == 5) {
            this.pwu.requestFocus();
            this.pwu.setSelection(0);
            this.pwe.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(68196);
                    ComposeUI.this.pwe.fullScroll(130);
                    AppMethodBeat.o(68196);
                }
            }, 1000);
        }
        this.pwf.setOnActionListener(new c(this.pwg, 0));
        this.pwj.setOnActionListener(new c(this.pwk, 1));
        this.pwm.setOnActionListener(new c(this.pwn, 2));
        AnonymousClass19 anonymousClass19 = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a() {
            public final void b(final MailAddrsViewControl mailAddrsViewControl) {
                AppMethodBeat.i(68201);
                h.a(ComposeUI.this.mController.ylL, ComposeUI.this.getString(R.string.dds), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(68198);
                        mailAddrsViewControl.pyz.setText("");
                        ComposeUI.this.pwQ.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(68197);
                                ComposeUI.h(ComposeUI.this);
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                                AppMethodBeat.o(68197);
                            }
                        }, 150);
                        AppMethodBeat.o(68198);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(68200);
                        ComposeUI.this.pwQ.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(68199);
                                ComposeUI.h(ComposeUI.this);
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                                AppMethodBeat.o(68199);
                            }
                        }, 150);
                        AppMethodBeat.o(68200);
                    }
                });
                AppMethodBeat.o(68201);
            }

            public final void ccV() {
                AppMethodBeat.i(68202);
                t.a(ComposeUI.this, ComposeUI.this.getString(R.string.dds), 1500);
                AppMethodBeat.o(68202);
            }
        };
        this.pwf.setInvalidMailAddrListener(anonymousClass19);
        this.pwj.setInvalidMailAddrListener(anonymousClass19);
        this.pwm.setInvalidMailAddrListener(anonymousClass19);
        this.pwg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68203);
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwf.a(false, null));
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                ComposeUI.this.startActivityForResult(intent, 0);
                ComposeUI.this.overridePendingTransition(R.anim.cg, R.anim.b6);
                AppMethodBeat.o(68203);
            }
        });
        this.pwk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68204);
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwj.a(false, null));
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                ComposeUI.this.startActivityForResult(intent, 1);
                ComposeUI.this.overridePendingTransition(R.anim.cg, R.anim.b6);
                AppMethodBeat.o(68204);
            }
        });
        this.pwn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68205);
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwm.a(false, null));
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                ComposeUI.this.startActivityForResult(intent, 2);
                ComposeUI.this.overridePendingTransition(R.anim.cg, R.anim.b6);
                AppMethodBeat.o(68205);
            }
        });
        this.pwh.setOnClickListener(this.pwS);
        final ImageView imageView = (ImageView) findViewById(R.id.drx);
        if (this.pwC && this.pwo.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.pwo.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(68206);
                if (z) {
                    ComposeUI.this.pwo.setSelection(ComposeUI.this.pwo.getText().length());
                }
                AppMethodBeat.o(68206);
            }
        });
        this.pwo.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 4;
                AppMethodBeat.i(68168);
                if (ComposeUI.this.pwC) {
                    ImageView imageView = imageView;
                    if (ComposeUI.this.pwo.getText().length() > 0) {
                        i4 = 0;
                    }
                    imageView.setVisibility(i4);
                    AppMethodBeat.o(68168);
                    return;
                }
                imageView.setVisibility(4);
                AppMethodBeat.o(68168);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68169);
                ComposeUI.this.pwo.getText().clear();
                ComposeUI.this.pwo.requestFocus();
                AppMethodBeat.o(68169);
            }
        });
        this.pwp.setOnClickListener(this.pwT);
        setMMTitle((int) R.string.ddm);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            int intValue = ((Integer) g.RP().Ry().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                setMMSubTitle(new com.tencent.mm.a.p(intValue) + "@qq.com");
            }
        }
        setBackBtn(this.pwU);
        if (this.mode == 5) {
            addTextOptionMenu(0, getString(R.string.tf), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(68170);
                    ComposeUI.this.pwV.onClick(null);
                    AppMethodBeat.o(68170);
                    return false;
                }
            });
        } else if (this.mode == 6) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            addTextOptionMenu(0, getString(R.string.tf), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(68171);
                    ComposeUI.this.pwW.onClick(null);
                    AppMethodBeat.o(68171);
                    return false;
                }
            });
        }
        enableOptionMenu(false);
        ccQ();
        AppMethodBeat.o(68219);
    }

    private void ccR() {
        AppMethodBeat.i(68220);
        if (this.pwv != null) {
            this.pwv.clearFocus();
            this.pwv.getSettings().setJavaScriptEnabled(true);
            this.pwv.setWebViewClient(new b(this, (byte) 0));
            this.pwv.setWebChromeClient(new a(this, (byte) 0));
            this.pwv.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(68172);
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 1:
                            if (!view.hasFocus()) {
                                view.requestFocus();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(68172);
                    return false;
                }
            });
        }
        AppMethodBeat.o(68220);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(68221);
        if (i == 4) {
            this.pwU.onMenuItemClick(null);
            AppMethodBeat.o(68221);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(68221);
        return onKeyDown;
    }

    private void bCz() {
        AppMethodBeat.i(68222);
        if (!n.c(this, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 3)) {
            Toast.makeText(this, getString(R.string.e29), 1).show();
        }
        AppMethodBeat.o(68222);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(68223);
        if (iArr == null || iArr.length <= 0) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(68223);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(68177);
                            ComposeUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(68177);
                        }
                    }, null);
                    break;
                }
                bCz();
                AppMethodBeat.o(68223);
                return;
        }
        AppMethodBeat.o(68223);
    }

    private String ccS() {
        AppMethodBeat.i(68224);
        String str;
        if (this.mode == 6) {
            u.a(this.pwv, this.pwL, this.pwF);
            if (this.pwJ != null) {
                int indexOf = this.pwJ.indexOf(this.pwG);
                int lastIndexOf = this.pwJ.lastIndexOf(this.pwH);
                if (indexOf == -1 || lastIndexOf == -1) {
                    str = this.pwJ;
                    AppMethodBeat.o(68224);
                    return str;
                }
                str = this.pwJ.substring(indexOf + this.pwG.length(), lastIndexOf + this.pwH.length());
                AppMethodBeat.o(68224);
                return str;
            }
        } else if (this.mode == 5) {
            str = this.pwu.getText().toString();
            AppMethodBeat.o(68224);
            return str;
        }
        AppMethodBeat.o(68224);
        return null;
    }

    private String getSubject() {
        int i = 40;
        AppMethodBeat.i(68225);
        String obj = this.pwo.getText().toString();
        if (obj.trim().length() > 0) {
            AppMethodBeat.o(68225);
            return obj;
        }
        String substring;
        obj = ccS();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                substring = obj.substring(0, i);
                AppMethodBeat.o(68225);
                return substring;
            }
        } else if (this.mode == 6 && !bo.isNullOrNil(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            substring = obj.substring(0, i);
            AppMethodBeat.o(68225);
            return substring;
        }
        substring = getString(R.string.ddi);
        AppMethodBeat.o(68225);
        return substring;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ccT() {
        AppMethodBeat.i(68226);
        if (!this.pwf.cdi()) {
            Toast.makeText(this, R.string.ddo, 1).show();
            AppMethodBeat.o(68226);
            return false;
        } else if (!this.pwj.cdi()) {
            Toast.makeText(this, R.string.ddf, 1).show();
            AppMethodBeat.o(68226);
            return false;
        } else if (!this.pwm.cdi()) {
            Toast.makeText(this, R.string.ddd, 1).show();
            AppMethodBeat.o(68226);
            return false;
        } else if ((this.pwf.getMailAddrs().size() + this.pwj.getMailAddrs().size()) + this.pwm.getMailAddrs().size() > 20) {
            Toast.makeText(this, R.string.ddu, 1).show();
            AppMethodBeat.o(68226);
            return false;
        } else {
            AppMethodBeat.o(68226);
            return true;
        }
    }

    static void cH(List<o> list) {
        pwd = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        AppMethodBeat.i(68227);
        if (pwd == null) {
            AppMethodBeat.o(68227);
            return;
        }
        mailAddrsViewControl.setMailAdds(pwd);
        AppMethodBeat.o(68227);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(68228);
        if (i2 != -1) {
            AppMethodBeat.o(68228);
            return;
        }
        String h;
        switch (i) {
            case 0:
                a(this.pwf);
                showVKB();
                AppMethodBeat.o(68228);
                return;
            case 1:
                a(this.pwj);
                showVKB();
                AppMethodBeat.o(68228);
                return;
            case 2:
                a(this.pwm);
                showVKB();
                AppMethodBeat.o(68228);
                return;
            case 3:
                h = n.h(this, intent, com.tencent.mm.plugin.i.c.XW());
                if (h != null) {
                    Vo(h);
                    ccQ();
                    AppMethodBeat.o(68228);
                    return;
                }
                break;
            case 4:
                if (intent != null) {
                    h = com.tencent.mm.ui.tools.a.i(this, intent, com.tencent.mm.plugin.i.c.XW());
                    if (h != null && h.length() > 0) {
                        Vo(h);
                        ccQ();
                        AppMethodBeat.o(68228);
                        return;
                    }
                }
                break;
            case 5:
                if (intent != null) {
                    Vo(intent.getStringExtra("choosed_file_path"));
                    ccQ();
                    break;
                }
                break;
        }
        AppMethodBeat.o(68228);
    }

    private void Vo(final String str) {
        AppMethodBeat.i(68229);
        final File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(68229);
        } else if (this.pwx.wi(str)) {
            h.g(this.mController.ylL, R.string.de2, R.string.tz);
            AppMethodBeat.o(68229);
        } else {
            final int length = (int) file.length();
            if (length > 20971520) {
                h.a((Context) this, (int) R.string.de3, (int) R.string.tz, null);
                AppMethodBeat.o(68229);
                return;
            }
            h.a((Context) this, getString(R.string.de5, new Object[]{bo.ga((long) length)}), getString(R.string.tz), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(68194);
                    if (ComposeUI.this.pwx.cde() + length > DeviceUtils.MIN_STORAGE_SIZE) {
                        h.a(ComposeUI.this, (int) R.string.de4, (int) R.string.tz, null);
                        AppMethodBeat.o(68194);
                        return;
                    }
                    if (ComposeUI.this.pwo.getText().toString().trim().length() == 0) {
                        String trim = file.getName().trim();
                        int lastIndexOf = trim.lastIndexOf(".");
                        EditText j = ComposeUI.this.pwo;
                        if (lastIndexOf <= 0) {
                            lastIndexOf = trim.length();
                        }
                        j.setText(trim.substring(0, lastIndexOf));
                    }
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(ComposeUI.this.mode));
                    ComposeUI.this.pwx.fG(str, null);
                    AppMethodBeat.o(68194);
                }
            }, null);
            AppMethodBeat.o(68229);
        }
    }

    public void setRequestedOrientation(int i) {
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        AppMethodBeat.i(68231);
        com.tencent.mm.plugin.qqmail.b.j jVar = new com.tencent.mm.plugin.qqmail.b.j();
        jVar.ptH = composeUI.ptH;
        jVar.ptI = composeUI.pwz;
        jVar.ptJ = composeUI.pwf.getMailAddrs();
        jVar.ptK = composeUI.pwj.getMailAddrs();
        jVar.ptL = composeUI.pwm.getMailAddrs();
        jVar.ptN = composeUI.pwo.getText().toString();
        jVar.ptM = composeUI.pwx.cda();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            jVar.content = composeUI.ccS();
            jVar.ptO = composeUI.mode;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        i iVar = ac.ccC().puE;
        try {
            iVar.ptG.cco();
            k.z(iVar.ptG.ptQ + i.cR(jVar.ptI, jVar.ptH), jVar.toByteArray());
            AppMethodBeat.o(68231);
        } catch (IOException e) {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            AppMethodBeat.o(68231);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        Map map;
        String str = null;
        AppMethodBeat.i(68233);
        String pVar = new com.tencent.mm.a.p(((Integer) g.RP().Ry().get(9, null)).intValue()).toString();
        if (bo.isNullOrNil(pVar)) {
            pVar = null;
        } else {
            pVar = pVar + "@qq.com";
        }
        aa aaVar = new aa();
        aaVar.cEV = pVar;
        aaVar.ptN = composeUI.getSubject();
        if (!bo.isNullOrNil(composeUI.pwf.getAddrsString())) {
            aaVar.pur = composeUI.pwf.getAddrsString().split(",");
        }
        if (!bo.isNullOrNil(composeUI.pwj.getAddrsString())) {
            aaVar.pus = composeUI.pwj.getAddrsString().split(",");
        }
        if (!bo.isNullOrNil(composeUI.pwm.getAddrsString())) {
            aaVar.put = composeUI.pwm.getAddrsString().split(",");
        }
        pVar = composeUI.ccS();
        if (!bo.isNullOrNil(pVar)) {
            str = pVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        aaVar.pve = str;
        if (composeUI.pvf.size() > 0) {
            map = composeUI.pvf;
            aaVar.pvf = new HashMap();
            aaVar.pvf.putAll(map);
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "send mail content: \n%s", str);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", Integer.valueOf(composeUI.pvf.size()));
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", Integer.valueOf(composeUI.pwx.pxT.size()));
        if (composeUI.pwx.pxT.size() > 0 && composeUI.pwx.pxU.size() > 0) {
            map = composeUI.pwx.pxT;
            aaVar.pvg = new LinkedHashMap();
            aaVar.pvg.putAll(map);
            map = composeUI.pwx.pxU;
            aaVar.pvh = new LinkedHashMap();
            aaVar.pvh.putAll(map);
        }
        ab abVar = composeUI.puY;
        if (abVar.pvj == null) {
            abVar.pvj = new z();
        }
        abVar.pvj.a(aaVar);
        composeUI.pwO = false;
        h.bQ(composeUI.mController.ylL, composeUI.getString(R.string.bvk));
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68188);
                ComposeUI.this.setResult(-1);
                ComposeUI.this.finish();
                AppMethodBeat.o(68188);
            }
        }, 800);
        AppMethodBeat.o(68233);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        AppMethodBeat.i(68234);
        composeUI.pwg.setVisibility(4);
        composeUI.pwk.setVisibility(4);
        composeUI.pwn.setVisibility(4);
        AppMethodBeat.o(68234);
    }

    static /* synthetic */ long H(ComposeUI composeUI) {
        AppMethodBeat.i(68237);
        HashMap hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.pwf.getAddrsString());
        hashMap.put("cc", composeUI.pwj.getAddrsString());
        hashMap.put("bcc", composeUI.pwm.getAddrsString());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, composeUI.ccS());
        hashMap.put("attachlist", composeUI.pwx.ccZ());
        hashMap.put("sendtype", (composeUI.ptH == 4 ? 1 : composeUI.ptH));
        hashMap.put("oldmailid", composeUI.pwz);
        com.tencent.mm.plugin.qqmail.b.v.c cVar = new com.tencent.mm.plugin.qqmail.b.v.c();
        cVar.puP = false;
        cVar.puO = true;
        long a = ac.ccC().a("/cgi-bin/composesendwithattach", hashMap, cVar, composeUI.pwX);
        AppMethodBeat.o(68237);
        return a;
    }
}
