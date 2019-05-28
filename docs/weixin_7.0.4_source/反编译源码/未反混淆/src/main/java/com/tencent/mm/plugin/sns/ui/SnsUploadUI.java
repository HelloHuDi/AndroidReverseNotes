package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.j;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@a(17)
@i
public class SnsUploadUI extends MMActivity implements LocationWidget.a {
    private String desc;
    private KeyboardLinearLayout mJB;
    private AtContactWidget rCD;
    private LocationWidget rCE;
    private RangeWidget rCF;
    private SnsUploadSayFooter rCG;
    private DynamicGridView rCH;
    private boolean rCI = false;
    private boolean rCJ = false;
    private String rCK = null;
    private Map<Integer, y> rCL = new HashMap();
    private FrameLayout rCM = null;
    private long rCN = 0;
    private SnsUploadConfigView rhg;
    private int rjO = 0;
    private String rkC = "";
    private boolean rkD = false;
    private String rmH = "";
    private String rmI = "";
    private SnsEditText rnb;
    private y rnc = null;
    private LinearLayout rnd;
    private int rnf = 0;
    private int rng = 0;
    private ArrayList<String> rnh;
    private boolean rni = false;
    private boolean rnk = false;
    private long rnl = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUploadUI() {
        AppMethodBeat.i(39757);
        AppMethodBeat.o(39757);
    }

    static /* synthetic */ void j(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39780);
        snsUploadUI.cuD();
        AppMethodBeat.o(39780);
    }

    static /* synthetic */ void m(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39783);
        snsUploadUI.cuC();
        AppMethodBeat.o(39783);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(39758);
        if (this.rnb != null) {
            bundle.putString("contentdesc", this.rnb.getText().toString());
        }
        bundle.getString("contentdesc");
        this.rnc.N(bundle);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(39758);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(39759);
        f.m(this);
        super.onCreate(bundle);
        xE(this.mController.ylL.getResources().getColor(R.color.a69));
        dyb();
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        Kh();
        this.rnb = (SnsEditText) findViewById(R.id.csj);
        if (!bo.isNullOrNil(getIntent().getStringExtra(k.ygd))) {
            this.rnb.setText(b.c(this.mController.ylL, getIntent().getStringExtra(k.ygd), this.rnb.getTextSize()));
        } else if (!(this.rnb == null || bundle == null)) {
            String string = bundle.getString("contentdesc");
            if (string != null) {
                this.rnb.setText(string);
            }
        }
        if (this.rjO == 8) {
            this.rnb.setText(b.c(this.mController.ylL, getIntent().getStringExtra(k.ygd), this.rnb.getTextSize()));
        }
        this.mJB = (KeyboardLinearLayout) findViewById(R.id.l_);
        this.rCG = (SnsUploadSayFooter) findViewById(R.id.elg);
        this.rCG.setMMEditText(this.rnb);
        this.rCG.setVisibility(8);
        this.rCM = (FrameLayout) findViewById(R.id.ele);
        this.rCM.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39753);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                af.cnu();
                s.fs(displayMetrics.widthPixels, displayMetrics.heightPixels);
                AppMethodBeat.o(39753);
            }
        });
        this.rnb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39754);
                SnsUploadUI.l(SnsUploadUI.this);
                AppMethodBeat.o(39754);
            }
        });
        this.rnb.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(39755);
                SnsUploadUI.l(SnsUploadUI.this);
                AppMethodBeat.o(39755);
                return false;
            }
        });
        WrapScollview wrapScollview = (WrapScollview) findViewById(R.id.bsd);
        wrapScollview.setContentView(this.rnb);
        wrapScollview.setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        String bc = bo.bc(getIntent().getStringExtra("reportSessionId"), "");
        this.rhg = (SnsUploadConfigView) findViewById(R.id.eny);
        com.tencent.mm.ui.i.a.a aVar = this.rhg;
        if (this.rjO != 14 || bc.contains("wx5dfbe0a95623607b")) {
            z = false;
        } else {
            z = true;
        }
        aVar.rCv = z;
        if (z) {
            g.RQ();
            g.RO().eJo.a(2842, (com.tencent.mm.ai.f) aVar);
            m jVar = new j();
            g.RQ();
            g.RO().eJo.a(jVar, 0);
        }
        aVar.rCw.vRq = -1000.0f;
        aVar.rCw.vRp = -1000.0f;
        if (!aVar.rwo) {
            g.RQ();
            int h = bo.h((Integer) g.RP().Ry().get(68404, null));
            aVar.rCp = (h & 2) != 0;
            if ((h & 8) == 0) {
                z2 = false;
            }
            aVar.rCq = z2;
            if (!com.tencent.mm.au.b.ahP()) {
                aVar.rCq = false;
            }
            if (!r.YX()) {
                aVar.rCp = false;
            }
        }
        aVar.setSyncFacebook(false);
        aVar.cuy();
        aVar.cuA();
        aVar.cuz();
        if (aVar.rCq) {
            aVar.rCx.a(aVar);
        }
        if (this.rjO != 0) {
            SnsUploadConfigView snsUploadConfigView = this.rhg;
            snsUploadConfigView.rCk.setVisibility(8);
            snsUploadConfigView.rCl.setVisibility(8);
            snsUploadConfigView.rCm.setVisibility(8);
            snsUploadConfigView.rCn.setVisibility(8);
        }
        if (this.rjO == 9) {
            this.rhg.rCm.setVisibility(0);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39756);
                SnsUploadUI.m(SnsUploadUI.this);
                AppMethodBeat.o(39756);
                return true;
            }
        });
        a(0, getString(R.string.eo2), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39740);
                if (SnsUploadUI.this.isFinishing()) {
                    AppMethodBeat.o(39740);
                } else if (System.currentTimeMillis() - SnsUploadUI.this.rCN < 500) {
                    AppMethodBeat.o(39740);
                } else {
                    if (SnsUploadUI.this.rjO == 9) {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                    } else {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                    }
                    SnsUploadUI.h(SnsUploadUI.this);
                    SnsUploadUI.this.rCN = System.currentTimeMillis();
                    com.tencent.mm.plugin.report.service.g.BN(22);
                    c PM = c.d(SnsUploadUI.this.rnb).PM(com.tencent.mm.m.b.MW());
                    PM.zIx = true;
                    PM.a(new c.a() {
                        public final void ki(String str) {
                            AppMethodBeat.i(39738);
                            int syncFlag = SnsUploadUI.this.rhg.getSyncFlag();
                            g.RQ();
                            g.RP().Ry().set(68404, Integer.valueOf(syncFlag));
                            SnsUploadUI.this.desc = SnsUploadUI.this.rnb.getText().toString();
                            int pasterLen = SnsUploadUI.this.rnb.getPasterLen();
                            int privated = SnsUploadUI.this.rhg.getPrivated();
                            int syncFlag2 = SnsUploadUI.this.rhg.getSyncFlag();
                            SnsUploadUI.this.rCF;
                            if (SnsUploadUI.this.rCI) {
                                SnsUploadUI.this.setResult(-1, new Intent());
                            }
                            if (SnsUploadUI.this.rnc instanceof ag) {
                                ((ag) SnsUploadUI.this.rnc).rlV = SnsUploadUI.this.rCE.getCurLocation();
                            }
                            if (SnsUploadUI.this.rnc instanceof ad) {
                                SnsUploadUI.this.rnb.setText("");
                            }
                            PInt pInt = new PInt();
                            SnsUploadUI.this.rnc.a(privated, syncFlag2, SnsUploadUI.this.rhg.getTwitterAccessToken(), SnsUploadUI.this.desc, SnsUploadUI.this.rCD.getAtList(), SnsUploadUI.this.rCE.getLocation(), pasterLen, SnsUploadUI.this.rni, SnsUploadUI.this.rnh, pInt, SnsUploadUI.this.rCK, SnsUploadUI.this.rnf, SnsUploadUI.this.rng);
                            h hVar = h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(SnsUploadUI.this.rnl);
                            objArr[1] = Long.valueOf(bo.anT());
                            objArr[2] = Integer.valueOf(SnsUploadUI.this.rnk ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            hVar.e(13303, objArr);
                            String str2 = "MicroMsg.SnsUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(SnsUploadUI.this.rnl);
                            objArr[1] = Long.valueOf(bo.anT());
                            objArr[2] = Integer.valueOf(SnsUploadUI.this.rnk ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            ab.d(str2, str3, objArr);
                            h.pYm.X(10910, "1");
                            if (!bo.isNullOrNil(SnsUploadUI.this.rmH)) {
                                if (SnsUploadUI.this.rni) {
                                    h.pYm.e(11455, "", SnsUploadUI.this.rmH, Integer.valueOf(-1), Integer.valueOf(-1));
                                } else {
                                    h.pYm.e(11455, SnsUploadUI.this.rmH, "", Integer.valueOf(-1), Integer.valueOf(-1));
                                }
                            }
                            if (SnsUploadUI.this.rCJ) {
                                Intent intent = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                                intent.putExtra("sns_resume_state", false);
                                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                                intent.addFlags(67108864);
                                SnsUploadUI.this.startActivity(intent);
                            }
                            l.aG(SnsUploadUI.this.getIntent());
                            com.tencent.mm.sdk.b.a.xxA.m(new sa());
                            AppMethodBeat.o(39738);
                        }

                        public final void JW() {
                        }

                        public final void JX() {
                            AppMethodBeat.i(39739);
                            com.tencent.mm.ui.base.h.g(SnsUploadUI.this, R.string.eqg, R.string.eqh);
                            AppMethodBeat.o(39739);
                        }
                    });
                    AppMethodBeat.o(39740);
                }
                return false;
            }
        }, q.b.GREEN);
        findViewById(R.id.eno).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39741);
                ab.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
                if (SnsUploadUI.D(SnsUploadUI.this)) {
                    AppMethodBeat.o(39741);
                    return true;
                }
                AppMethodBeat.o(39741);
                return false;
            }
        });
        this.rCD = (AtContactWidget) findViewById(R.id.enx);
        this.rCD.rhg = this.rhg;
        this.rCE = (LocationWidget) findViewById(R.id.eld);
        this.rCE.setLocationWidgetListener(this);
        switch (this.rjO) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
                this.rCF = (RangeWidget) findViewById(R.id.enw);
                findViewById(R.id.enq).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rCF = (RangeWidget) findViewById(R.id.enw);
                findViewById(R.id.enq).setVisibility(8);
                break;
            case 2:
            case 8:
                this.rCF = (RangeWidget) findViewById(R.id.enw);
                findViewById(R.id.enq).setVisibility(8);
                this.rCD.setVisibility(8);
                break;
        }
        this.rCF.rhg = this.rhg;
        this.rCE.ao(getIntent());
        this.rCD.ao(getIntent());
        aq(getIntent());
        aqX();
        P(bundle);
        this.mJB.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(39737);
                if (i == -3) {
                    ab.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(39735);
                            SnsUploadUI.this.rCG.aYS();
                            SnsUploadUI.this.rCG.postInvalidate();
                            SnsUploadUI.this.mController.contentView.postInvalidate();
                            AppMethodBeat.o(39735);
                        }
                    }, 100);
                    AppMethodBeat.o(39737);
                    return;
                }
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39736);
                        SnsUploadSayFooter a = SnsUploadUI.this.rCG;
                        if (!a.aYV()) {
                            a.setVisibility(8);
                        }
                        SnsUploadUI.this.rCG.postInvalidate();
                        SnsUploadUI.this.mController.contentView.postInvalidate();
                        AppMethodBeat.o(39736);
                    }
                }, 200);
                ab.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
                AppMethodBeat.o(39737);
            }
        });
        f.n(this);
        AppMethodBeat.o(39759);
    }

    @TargetApi(11)
    private void cuB() {
        AppMethodBeat.i(39760);
        if (!(this.rnc instanceof ag)) {
            ab.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            AppMethodBeat.o(39760);
        } else if (VERSION.SDK_INT < 11) {
            ab.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            AppMethodBeat.o(39760);
        } else {
            new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39749);
                    AnonymousClass1 anonymousClass1 = new OnDragListener() {
                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            boolean z;
                            AppMethodBeat.i(39748);
                            switch (dragEvent.getAction()) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    ab.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                                    z = true;
                                    break;
                                case 3:
                                    ab.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData == null) {
                                        z = true;
                                        break;
                                    }
                                    int itemCount = clipData.getItemCount();
                                    ArrayList arrayList = new ArrayList();
                                    for (int i = 0; i < itemCount; i++) {
                                        Item itemAt = clipData.getItemAt(i);
                                        if (itemAt == null) {
                                            ab.e("MicroMsg.SnsUploadUI", "item == null");
                                        } else if (itemAt.getIntent() != null) {
                                            SnsUploadUI.this.startActivity(itemAt.getIntent());
                                        } else if (itemAt.getUri() != null) {
                                            o oVar = new o(SnsUploadUI.this.mController.ylL, itemAt.getUri());
                                            if (oVar.fileType != 0 && oVar.filePath != null) {
                                                switch (oVar.fileType) {
                                                    case 3:
                                                        arrayList.add(oVar.filePath);
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            ab.e("MicroMsg.SnsUploadUI", "get file path failed");
                                        }
                                    }
                                    if (arrayList.size() >= 0) {
                                        ((ag) SnsUploadUI.this.rnc).d(arrayList, 0, false);
                                        z = true;
                                        break;
                                    }
                                    ab.e("MicroMsg.SnsUploadUI", "no image file available");
                                    AppMethodBeat.o(39748);
                                    return true;
                                    break;
                                default:
                                    ab.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                                    z = false;
                                    break;
                            }
                            AppMethodBeat.o(39748);
                            return z;
                        }
                    };
                    if (SnsUploadUI.this.rCM != null) {
                        SnsUploadUI.this.rCM.setOnDragListener(anonymousClass1);
                    }
                    AppMethodBeat.o(39749);
                }
            }.run();
            AppMethodBeat.o(39760);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(39761);
        if (keyEvent.getKeyCode() == 4) {
            boolean z;
            SnsUploadSayFooter snsUploadSayFooter = this.rCG;
            if (snsUploadSayFooter.aYV() || snsUploadSayFooter.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.rCG.aYW();
                AppMethodBeat.o(39761);
                return true;
            }
            cuC();
            AppMethodBeat.o(39761);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(39761);
        return onKeyDown;
    }

    private void cuC() {
        AppMethodBeat.i(39762);
        if ((this.rjO != 0 || ((ag) this.rnc).css() <= 0) && (!(this.rjO == 14 && (this.rnc instanceof ac) && !((ac) this.rnc).rkE) && (this.rjO != 9 || bo.isNullOrNil(this.rnb.getText().toString())))) {
            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.eqb, 0, (int) R.string.fx, (int) R.string.or, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(39752);
                    if (SnsUploadUI.this.rjO == 9) {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                    } else {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                    }
                    SnsUploadUI.h(SnsUploadUI.this);
                    SnsUploadUI.k(SnsUploadUI.this);
                    AppMethodBeat.o(39752);
                }
            }, null, (int) R.color.ei);
            AppMethodBeat.o(39762);
            return;
        }
        com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.eqc, 0, (int) R.string.eqe, (int) R.string.eqd, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                int i2;
                AppMethodBeat.i(39750);
                Parcel obtain = Parcel.obtain();
                SnsUploadUI.this.getIntent().putExtra(k.ygd, SnsUploadUI.this.rnb.getText().toString());
                SnsUploadUI.this.getIntent().writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                if (SnsUploadUI.this.rjO == 9) {
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, e.bytesToHexString(marshall));
                } else {
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, e.bytesToHexString(marshall));
                }
                SnsUploadUI.h(SnsUploadUI.this);
                switch (SnsUploadUI.this.rjO) {
                    case 0:
                        i2 = 3;
                        break;
                    case 9:
                        i2 = 1;
                        break;
                    case 14:
                        i2 = 5;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                h.pYm.e(14247, Integer.valueOf(0), Integer.valueOf(i2), SnsUploadUI.this.rkC, Long.valueOf(bo.anT()));
                SnsUploadUI.j(SnsUploadUI.this);
                AppMethodBeat.o(39750);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                int i2;
                AppMethodBeat.i(39751);
                if (SnsUploadUI.this.rjO == 9) {
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                } else {
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                }
                SnsUploadUI.h(SnsUploadUI.this);
                if (SnsUploadUI.this.rnc instanceof ad) {
                    SnsUploadUI.this.rnb.setText("");
                }
                switch (SnsUploadUI.this.rjO) {
                    case 0:
                        i2 = 4;
                        break;
                    case 9:
                        i2 = 2;
                        break;
                    case 14:
                        i2 = 6;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                h.pYm.e(14247, Integer.valueOf(0), Integer.valueOf(i2), SnsUploadUI.this.rkC, Long.valueOf(bo.anT()));
                SnsUploadUI.k(SnsUploadUI.this);
                AppMethodBeat.o(39751);
            }
        }, (int) R.color.eh);
        AppMethodBeat.o(39762);
    }

    private void cuD() {
        AppMethodBeat.i(39763);
        setResult(0, new Intent());
        finish();
        AppMethodBeat.o(39763);
    }

    public final void cuE() {
        AppMethodBeat.i(39764);
        if (this.rnc.crG()) {
            enableOptionMenu(true);
            AppMethodBeat.o(39764);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(39764);
    }

    private void Kh() {
        AppMethodBeat.i(39765);
        this.rnk = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rnl = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.rjO = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.rkD = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rCI = getIntent().getBooleanExtra("need_result", false);
        this.rCJ = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.rCK = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.rkC = getIntent().getStringExtra("KSessionID");
        if (bo.isNullOrNil(this.rkC)) {
            this.rkC = bo.anU() + "_" + bo.Mb(5);
            getIntent().putExtra("KSessionID", this.rkC);
        }
        AppMethodBeat.o(39765);
    }

    public void onPause() {
        AppMethodBeat.i(39766);
        if (this.rjO == 9) {
            Object trim = this.rnb.getText().toString().trim();
            g.RQ();
            g.RP().Ry().set(68408, trim);
            if (bo.isNullOrNil(trim)) {
                g.RQ();
                g.RP().Ry().set(7489, Integer.valueOf(0));
            } else {
                g.RQ();
                g.RP().Ry().set(7489, Integer.valueOf(this.rnb.getPasterLen()));
            }
        }
        super.aqX();
        super.onPause();
        AppMethodBeat.o(39766);
    }

    public void onResume() {
        AppMethodBeat.i(39767);
        super.onResume();
        this.rCG.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39742);
                com.tencent.mm.compatible.util.j.r(SnsUploadUI.this);
                AppMethodBeat.o(39742);
            }
        });
        if (this.rnc != null && (this.rnc instanceof ac)) {
            ac acVar = (ac) this.rnc;
            if (acVar.rkx != null) {
                if (acVar.rkE) {
                    acVar.csa();
                } else {
                    acVar.crZ();
                    AppMethodBeat.o(39767);
                    return;
                }
            }
        }
        AppMethodBeat.o(39767);
    }

    public void onDestroy() {
        AppMethodBeat.i(39768);
        super.onDestroy();
        if (this.rhg != null) {
            com.tencent.mm.ai.f fVar = this.rhg;
            g.RQ();
            g.RO().eJo.b(2842, fVar);
        }
        if (this.rnc != null) {
            this.rnc.crI();
        }
        if (this.rCE != null) {
            this.rCE.stop();
        }
        if (this.rCG != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.rCG;
            if (snsUploadSayFooter.eAk != null) {
                snsUploadSayFooter.eAk.AC();
                snsUploadSayFooter.eAk.destroy();
            }
        }
        this.rCL.clear();
        AppMethodBeat.o(39768);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39769);
        super.onActivityResult(i, i2, intent);
        if (this.rnb != null) {
            this.rnb.clearFocus();
        }
        if (i2 != -1) {
            AppMethodBeat.o(39769);
        } else if (i == 30764) {
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                g.RP().Ry().set(ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.pluginsdk.permission.b.b(this.mController.ylL, "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
            AppMethodBeat.o(39769);
        } else {
            if (this.rnc.f(i, intent)) {
                cuE();
            }
            switch (i) {
                case 5:
                    if (intent == null) {
                        AppMethodBeat.o(39769);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    aq(intent);
                    AppMethodBeat.o(39769);
                    return;
                case 6:
                    if (intent == null) {
                        AppMethodBeat.o(39769);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    this.rCD.ao(intent);
                    AppMethodBeat.o(39769);
                    return;
                case 8:
                    if (intent == null) {
                        AppMethodBeat.o(39769);
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                    SnsUploadConfigView snsUploadConfigView = this.rhg;
                    if (booleanExtra) {
                        snsUploadConfigView.rCp = true;
                        snsUploadConfigView.setSyncFacebook(true);
                    }
                    AppMethodBeat.o(39769);
                    return;
                case 10:
                    if (intent != null) {
                        getIntent().putExtras(intent.getExtras());
                        this.rCE.ao(intent);
                        break;
                    }
                    AppMethodBeat.o(39769);
                    return;
            }
            AppMethodBeat.o(39769);
        }
    }

    private void aq(Intent intent) {
        List list = null;
        AppMethodBeat.i(39770);
        this.rCF.a(5, -1, intent, this.rCD);
        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
        if (intExtra >= 2) {
            List list2;
            this.rmH = intent.getStringExtra("Klabel_name_list");
            this.rmI = intent.getStringExtra("Kother_user_name_list");
            if (bo.isNullOrNil(this.rmH)) {
                list2 = null;
            } else {
                list2 = Arrays.asList(this.rmH.split(","));
            }
            if (!bo.isNullOrNil(this.rmI)) {
                list = Arrays.asList(this.rmI.split(","));
            }
            l(list2, list);
            if (intExtra == 2) {
                this.rni = false;
                AppMethodBeat.o(39770);
                return;
            }
            this.rni = true;
        }
        AppMethodBeat.o(39770);
    }

    private void l(List<String> list, List<String> list2) {
        AppMethodBeat.i(39771);
        this.rnh = new ArrayList();
        this.rnf = 0;
        if (list != null && list.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String PE : list) {
                List<String> PH = com.tencent.mm.plugin.label.a.a.bJa().PH(com.tencent.mm.plugin.label.a.a.bJa().PE(PE));
                if (PH == null || PH.size() == 0) {
                    ab.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                    break;
                }
                for (String PE2 : PH) {
                    hashSet.add(PE2);
                    this.rnf++;
                    ab.d("MicroMsg.SnsUploadUI", "dz:name : %s", PE2);
                }
            }
            this.rnh = new ArrayList(hashSet);
        }
        if (list != null) {
            int i = 0;
            for (String PE22 : list) {
                int i2;
                if (bo.isNullOrNil(PE22)) {
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            this.rnf = i;
        }
        this.rng = 0;
        if (list2 != null && list2.size() > 0) {
            for (String PE222 : list2) {
                if (!this.rnh.contains(PE222)) {
                    this.rnh.add(PE222);
                    this.rng++;
                }
            }
        }
        AppMethodBeat.o(39771);
    }

    public final int getLayoutId() {
        return R.layout.ax1;
    }

    public final ArrayList<Exif.a> crV() {
        AppMethodBeat.i(39772);
        if (this.rnc instanceof ag) {
            ag agVar = (ag) this.rnc;
            ArrayList arrayList = agVar.rlP.rma;
            ArrayList<Exif.a> arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Exif.a aVar = (Exif.a) agVar.rlR.get((String) it.next());
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            AppMethodBeat.o(39772);
            return arrayList2;
        }
        AppMethodBeat.o(39772);
        return null;
    }

    public final boolean crW() {
        return this.rkD;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(39773);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(39773);
            return;
        }
        ab.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(39743);
                            SnsUploadUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            dialogInterface.dismiss();
                            AppMethodBeat.o(39743);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(39744);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(39744);
                        }
                    });
                    break;
                }
                this.rCE.crS();
                AppMethodBeat.o(39773);
                return;
        }
        AppMethodBeat.o(39773);
    }

    public final void a(String str, boolean z, int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2) {
        AppMethodBeat.i(39774);
        getIntent().getExtras().clear();
        getIntent().putExtra("KTouchCameraTime", bo.anT());
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 0);
        getIntent().putExtra("KFilterId", i);
        if (!bo.isNullOrNil(str)) {
            getIntent().putExtra("sns_kemdia_path", str);
        }
        if (!bo.ek(arrayList)) {
            getIntent().putExtra("sns_kemdia_path_list", arrayList);
        }
        if (!bo.ek(arrayList2)) {
            getIntent().putStringArrayListExtra("sns_media_latlong_list", arrayList2);
        }
        if (z) {
            getIntent().putExtra("Kis_take_photo", z);
        }
        if (i2 != 0) {
            getIntent().putExtra("Ksnsupload_source", 11);
        }
        AppMethodBeat.o(39774);
    }

    public final void a(String str, String str2, String str3, byte[] bArr, boolean z) {
        AppMethodBeat.i(39775);
        getIntent().getExtras().clear();
        getIntent().putExtra("KSightPath", str);
        getIntent().putExtra("KSightThumbPath", str2);
        getIntent().putExtra("sight_md5", str3);
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 14);
        getIntent().putExtra("Kis_take_photo", false);
        getIntent().putExtra("KMMSightExtInfo", bArr);
        if (z) {
            getIntent().putExtra("KSessionID", bo.anU() + "_" + bo.Mb(5));
        }
        AppMethodBeat.o(39775);
    }

    public final void cuF() {
        AppMethodBeat.i(39776);
        if (this.rCH != null) {
            this.rCH.setVisibility(8);
        }
        if (this.rnd != null) {
            this.rnd.removeAllViews();
            this.rnd.setVisibility(8);
        }
        if (this.rnc != null) {
            this.rnc.crI();
        }
        Kh();
        P(null);
        AppMethodBeat.o(39776);
    }

    private y En(int i) {
        AppMethodBeat.i(39777);
        y yVar = (y) this.rCL.get(Integer.valueOf(i));
        if (yVar == null) {
            if (i == 0) {
                yVar = new ag(this);
            } else if (i == 14) {
                yVar = new ac(this);
            }
            this.rCL.put(Integer.valueOf(i), yVar);
        }
        AppMethodBeat.o(39777);
        return yVar;
    }

    private void P(Bundle bundle) {
        View findViewById;
        LayoutParams layoutParams;
        AppMethodBeat.i(39778);
        ab.d("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", Integer.valueOf(this.rjO), Boolean.valueOf(this.rnk));
        if (this.rjO == 0 || this.rjO == 14 || this.rjO == 9) {
            Parcel obtain = Parcel.obtain();
            getIntent().writeToParcel(obtain, 0);
            obtain.marshall();
            if (this.rjO == 9) {
                setMMTitle(this.mController.ylL.getResources().getString(R.string.epk));
            } else {
                setMMTitle("");
            }
        }
        switch (this.rjO) {
            case 0:
                this.rnc = En(this.rjO);
                this.rnb.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.i(39745);
                        if (SnsUploadUI.this.rnb.getText().toString().trim().length() > 10) {
                            View findViewById = SnsUploadUI.this.findViewById(R.id.ent);
                            if (findViewById != null) {
                                findViewById.setVisibility(8);
                            }
                        }
                        AppMethodBeat.o(39745);
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rnc = new z(this);
                break;
            case 2:
                this.rnc = new ab(this);
                break;
            case 3:
                this.rnc = new ah(this, 9);
                break;
            case 4:
                this.rnc = new o(this);
                break;
            case 5:
                this.rnc = new ah(this, 14);
                break;
            case 6:
                this.rnc = new ah(this, 12);
                break;
            case 7:
                this.rnc = new ah(this, 13);
                break;
            case 8:
                this.rnc = new ba(this);
                break;
            case 9:
                boolean z;
                g.RQ();
                String bc = bo.bc((String) g.RP().Ry().get(68408, (Object) ""), "");
                g.RQ();
                int a = bo.a((Integer) g.RP().Ry().get(7489, Integer.valueOf(0)), 0);
                if (bo.isNullOrNil(bc)) {
                    z = false;
                } else {
                    z = true;
                }
                this.rnc = new ad(this, z);
                this.rnb.setPasterLen(a);
                this.rnb.setText(b.c(this.mController.ylL, bc, this.rnb.getTextSize()));
                this.rnb.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.i(39746);
                        if (SnsUploadUI.this.rnb.getText().toString().trim().length() > 0) {
                            SnsUploadUI.this.enableOptionMenu(true);
                            AppMethodBeat.o(39746);
                            return;
                        }
                        SnsUploadUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(39746);
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 10:
                this.rnc = new m(this);
                break;
            case 12:
                this.rnc = new n(this);
                break;
            case 13:
                this.rnc = new p(this);
                break;
            case 14:
                this.rnc = En(this.rjO);
                break;
        }
        this.rnc.M(bundle);
        View findViewById2;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.rnc instanceof a) {
            findViewById = findViewById(R.id.enr);
            findViewById2 = findViewById(R.id.ent);
            this.rCH = (DynamicGridView) findViewById(R.id.enp);
            this.rCH.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(39747);
                    boolean D = SnsUploadUI.D(SnsUploadUI.this);
                    AppMethodBeat.o(39747);
                    return D;
                }
            });
            findViewById = ((a) this.rnc).a(findViewById, findViewById(R.id.enz), this.rCH, findViewById2);
            this.rCH.setVisibility(0);
            findViewById2 = findViewById(R.id.env);
            layoutParams2 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(3, R.id.enp);
            findViewById2.setLayoutParams(layoutParams2);
        } else {
            findViewById2 = this.rnc.crH();
            this.rnd = (LinearLayout) findViewById(R.id.elf);
            this.rnd.setVisibility(0);
            this.rnd.setClipChildren(false);
            if (findViewById2 != null) {
                ab.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
                this.rnd.addView(findViewById2);
            } else {
                this.rnd.setVisibility(8);
            }
            if (this.rjO == 9 || this.rjO == 14) {
                View findViewById3 = findViewById(R.id.env);
                layoutParams2 = (RelativeLayout.LayoutParams) findViewById3.getLayoutParams();
                layoutParams2.addRule(3, R.id.elf);
                layoutParams2.topMargin = (int) (((float) (this.rjO == 9 ? 128 : 96)) * d.anS().density);
                findViewById3.setLayoutParams(layoutParams2);
            }
            findViewById = findViewById2;
        }
        if (this.rnc instanceof z) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = -1;
            findViewById.setLayoutParams(layoutParams);
        }
        if ((this.rnc instanceof o) || (this.rnc instanceof m) || (this.rnc instanceof n)) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = -1;
            findViewById.setLayoutParams(layoutParams);
        }
        cuE();
        if (this.rjO == 0) {
            cuB();
        }
        AppMethodBeat.o(39778);
    }

    static /* synthetic */ void h(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39779);
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, snsUploadUI.rkC);
        AppMethodBeat.o(39779);
    }

    static /* synthetic */ void k(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39781);
        snsUploadUI.cuD();
        AppMethodBeat.o(39781);
    }

    static /* synthetic */ void l(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39782);
        snsUploadUI.rnb.requestFocus();
        ab.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.rCG.aYV()) {
            snsUploadUI.rCG.aYW();
        }
        if (!x.gu(snsUploadUI)) {
            snsUploadUI.rCG.aYS();
        }
        snsUploadUI.mController.contentView.postInvalidate();
        AppMethodBeat.o(39782);
    }

    static /* synthetic */ boolean D(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(39784);
        snsUploadUI.aqX();
        if (snsUploadUI.rCG.aYV()) {
            snsUploadUI.rCG.aYW();
            AppMethodBeat.o(39784);
            return true;
        }
        AppMethodBeat.o(39784);
        return false;
    }
}
