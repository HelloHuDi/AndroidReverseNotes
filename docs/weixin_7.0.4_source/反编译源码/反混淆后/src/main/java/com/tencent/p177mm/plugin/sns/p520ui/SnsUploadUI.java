package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p135f.C8769e;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.compatible.util.Exif.C1440a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6545sa;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.p1094i.C15898a.C15906a;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C39760j;
import com.tencent.p177mm.plugin.sns.p520ui.LocationWidget.C3965a;
import com.tencent.p177mm.plugin.sns.p520ui.previewimageview.DynamicGridView;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14988o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35898l;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@C5271a(17)
@C18524i
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI */
public class SnsUploadUI extends MMActivity implements C3965a {
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
    private Map<Integer, C22150y> rCL = new HashMap();
    private FrameLayout rCM = null;
    private long rCN = 0;
    private SnsUploadConfigView rhg;
    private int rjO = 0;
    private String rkC = "";
    private boolean rkD = false;
    private String rmH = "";
    private String rmI = "";
    private SnsEditText rnb;
    private C22150y rnc = null;
    private LinearLayout rnd;
    private int rnf = 0;
    private int rng = 0;
    private ArrayList<String> rnh;
    private boolean rni = false;
    private boolean rnk = false;
    private long rnl = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$11 */
    class C401011 implements OnClickListener {
        C401011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            AppMethodBeat.m2504i(39750);
            Parcel obtain = Parcel.obtain();
            SnsUploadUI.this.getIntent().putExtra(C5504k.ygd, SnsUploadUI.this.rnb.getText().toString());
            SnsUploadUI.this.getIntent().writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            if (SnsUploadUI.this.rjO == 9) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, C8769e.bytesToHexString(marshall));
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, C8769e.bytesToHexString(marshall));
            }
            SnsUploadUI.m21794h(SnsUploadUI.this);
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
            C7060h.pYm.mo8381e(14247, Integer.valueOf(0), Integer.valueOf(i2), SnsUploadUI.this.rkC, Long.valueOf(C5046bo.anT()));
            SnsUploadUI.m21796j(SnsUploadUI.this);
            AppMethodBeat.m2505o(39750);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$17 */
    class C401117 implements OnMenuItemClickListener {
        C401117() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39756);
            SnsUploadUI.m21800m(SnsUploadUI.this);
            AppMethodBeat.m2505o(39756);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$10 */
    class C1358110 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$10$1 */
        class C135821 implements OnDragListener {
            C135821() {
            }

            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean z;
                AppMethodBeat.m2504i(39748);
                switch (dragEvent.getAction()) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        C4990ab.m7417i("MicroMsg.SnsUploadUI", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                        z = true;
                        break;
                    case 3:
                        C4990ab.m7416i("MicroMsg.SnsUploadUI", "ACTION_DROP");
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
                                C4990ab.m7412e("MicroMsg.SnsUploadUI", "item == null");
                            } else if (itemAt.getIntent() != null) {
                                SnsUploadUI.this.startActivity(itemAt.getIntent());
                            } else if (itemAt.getUri() != null) {
                                C14988o c14988o = new C14988o(SnsUploadUI.this.mController.ylL, itemAt.getUri());
                                if (c14988o.fileType != 0 && c14988o.filePath != null) {
                                    switch (c14988o.fileType) {
                                        case 3:
                                            arrayList.add(c14988o.filePath);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                C4990ab.m7412e("MicroMsg.SnsUploadUI", "get file path failed");
                            }
                        }
                        if (arrayList.size() >= 0) {
                            ((C29181ag) SnsUploadUI.this.rnc).mo47353d(arrayList, 0, false);
                            z = true;
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.SnsUploadUI", "no image file available");
                        AppMethodBeat.m2505o(39748);
                        return true;
                        break;
                    default:
                        C4990ab.m7412e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                        z = false;
                        break;
                }
                AppMethodBeat.m2505o(39748);
                return z;
            }
        }

        C1358110() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39749);
            C135821 c135821 = new C135821();
            if (SnsUploadUI.this.rCM != null) {
                SnsUploadUI.this.rCM.setOnDragListener(c135821);
            }
            AppMethodBeat.m2505o(39749);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$5 */
    class C135835 implements OnClickListener {
        C135835() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39743);
            SnsUploadUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(39743);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$7 */
    class C135847 implements TextWatcher {
        C135847() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(39745);
            if (SnsUploadUI.this.rnb.getText().toString().trim().length() > 10) {
                View findViewById = SnsUploadUI.this.findViewById(2131827936);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(39745);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$6 */
    class C135856 implements OnClickListener {
        C135856() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39744);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(39744);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$8 */
    class C135868 implements TextWatcher {
        C135868() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(39746);
            if (SnsUploadUI.this.rnb.getText().toString().trim().length() > 0) {
                SnsUploadUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(39746);
                return;
            }
            SnsUploadUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(39746);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$13 */
    class C1358713 implements OnClickListener {
        C1358713() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(39752);
            if (SnsUploadUI.this.rjO == 9) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
            }
            SnsUploadUI.m21794h(SnsUploadUI.this);
            SnsUploadUI.m21797k(SnsUploadUI.this);
            AppMethodBeat.m2505o(39752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$14 */
    class C1358814 implements Runnable {
        C1358814() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39753);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            C13373af.cnu();
            C13478s.m21646fs(displayMetrics.widthPixels, displayMetrics.heightPixels);
            AppMethodBeat.m2505o(39753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$15 */
    class C1358915 implements View.OnClickListener {
        C1358915() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39754);
            SnsUploadUI.m21798l(SnsUploadUI.this);
            AppMethodBeat.m2505o(39754);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$16 */
    class C1359016 implements OnLongClickListener {
        C1359016() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(39755);
            SnsUploadUI.m21798l(SnsUploadUI.this);
            AppMethodBeat.m2505o(39755);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$12 */
    class C1359112 implements OnClickListener {
        C1359112() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            AppMethodBeat.m2504i(39751);
            if (SnsUploadUI.this.rjO == 9) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
            }
            SnsUploadUI.m21794h(SnsUploadUI.this);
            if (SnsUploadUI.this.rnc instanceof C39826ad) {
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
            C7060h.pYm.mo8381e(14247, Integer.valueOf(0), Integer.valueOf(i2), SnsUploadUI.this.rkC, Long.valueOf(C5046bo.anT()));
            SnsUploadUI.m21797k(SnsUploadUI.this);
            AppMethodBeat.m2505o(39751);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$9 */
    class C135929 implements OnTouchListener {
        C135929() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39747);
            boolean D = SnsUploadUI.m21780D(SnsUploadUI.this);
            AppMethodBeat.m2505o(39747);
            return D;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$2 */
    class C135932 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$2$1 */
        class C135941 implements C5581a {
            C135941() {
            }

            /* renamed from: ki */
            public final void mo11317ki(String str) {
                AppMethodBeat.m2504i(39738);
                int syncFlag = SnsUploadUI.this.rhg.getSyncFlag();
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(68404, Integer.valueOf(syncFlag));
                SnsUploadUI.this.desc = SnsUploadUI.this.rnb.getText().toString();
                int pasterLen = SnsUploadUI.this.rnb.getPasterLen();
                int privated = SnsUploadUI.this.rhg.getPrivated();
                int syncFlag2 = SnsUploadUI.this.rhg.getSyncFlag();
                SnsUploadUI.this.rCF;
                if (SnsUploadUI.this.rCI) {
                    SnsUploadUI.this.setResult(-1, new Intent());
                }
                if (SnsUploadUI.this.rnc instanceof C29181ag) {
                    ((C29181ag) SnsUploadUI.this.rnc).rlV = SnsUploadUI.this.rCE.getCurLocation();
                }
                if (SnsUploadUI.this.rnc instanceof C39826ad) {
                    SnsUploadUI.this.rnb.setText("");
                }
                PInt pInt = new PInt();
                SnsUploadUI.this.rnc.mo8912a(privated, syncFlag2, SnsUploadUI.this.rhg.getTwitterAccessToken(), SnsUploadUI.this.desc, SnsUploadUI.this.rCD.getAtList(), SnsUploadUI.this.rCE.getLocation(), pasterLen, SnsUploadUI.this.rni, SnsUploadUI.this.rnh, pInt, SnsUploadUI.this.rCK, SnsUploadUI.this.rnf, SnsUploadUI.this.rng);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[4];
                objArr[0] = Long.valueOf(SnsUploadUI.this.rnl);
                objArr[1] = Long.valueOf(C5046bo.anT());
                objArr[2] = Integer.valueOf(SnsUploadUI.this.rnk ? 0 : 1);
                objArr[3] = Integer.valueOf(pInt.value);
                c7060h.mo8381e(13303, objArr);
                String str2 = "MicroMsg.SnsUploadUI";
                String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                objArr = new Object[4];
                objArr[0] = Long.valueOf(SnsUploadUI.this.rnl);
                objArr[1] = Long.valueOf(C5046bo.anT());
                objArr[2] = Integer.valueOf(SnsUploadUI.this.rnk ? 0 : 1);
                objArr[3] = Integer.valueOf(pInt.value);
                C4990ab.m7411d(str2, str3, objArr);
                C7060h.pYm.mo8374X(10910, "1");
                if (!C5046bo.isNullOrNil(SnsUploadUI.this.rmH)) {
                    if (SnsUploadUI.this.rni) {
                        C7060h.pYm.mo8381e(11455, "", SnsUploadUI.this.rmH, Integer.valueOf(-1), Integer.valueOf(-1));
                    } else {
                        C7060h.pYm.mo8381e(11455, SnsUploadUI.this.rmH, "", Integer.valueOf(-1), Integer.valueOf(-1));
                    }
                }
                if (SnsUploadUI.this.rCJ) {
                    Intent intent = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                    intent.putExtra("sns_resume_state", false);
                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                    intent.addFlags(67108864);
                    SnsUploadUI.this.startActivity(intent);
                }
                C35898l.m58846aG(SnsUploadUI.this.getIntent());
                C4879a.xxA.mo10055m(new C6545sa());
                AppMethodBeat.m2505o(39738);
            }

            /* renamed from: JW */
            public final void mo11315JW() {
            }

            /* renamed from: JX */
            public final void mo11316JX() {
                AppMethodBeat.m2504i(39739);
                C30379h.m48467g(SnsUploadUI.this, C25738R.string.eqg, C25738R.string.eqh);
                AppMethodBeat.m2505o(39739);
            }
        }

        C135932() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(39740);
            if (SnsUploadUI.this.isFinishing()) {
                AppMethodBeat.m2505o(39740);
            } else if (System.currentTimeMillis() - SnsUploadUI.this.rCN < 500) {
                AppMethodBeat.m2505o(39740);
            } else {
                if (SnsUploadUI.this.rjO == 9) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                } else {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                }
                SnsUploadUI.m21794h(SnsUploadUI.this);
                SnsUploadUI.this.rCN = System.currentTimeMillis();
                C34830g.m57194BN(22);
                C7357c PM = C7357c.m12555d(SnsUploadUI.this.rnb).mo15877PM(C42164b.m74335MW());
                PM.zIx = true;
                PM.mo15879a(new C135941());
                AppMethodBeat.m2505o(39740);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$3 */
    class C135953 implements OnTouchListener {
        C135953() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39741);
            C4990ab.m7410d("MicroMsg.SnsUploadUI", "upload_content onTouch");
            if (SnsUploadUI.m21780D(SnsUploadUI.this)) {
                AppMethodBeat.m2505o(39741);
                return true;
            }
            AppMethodBeat.m2505o(39741);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$4 */
    class C135964 implements Runnable {
        C135964() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39742);
            C18175j.m28619r(SnsUploadUI.this);
            AppMethodBeat.m2505o(39742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$1 */
    class C135971 implements C44246a {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$1$2 */
        class C135982 implements Runnable {
            C135982() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39736);
                SnsUploadSayFooter a = SnsUploadUI.this.rCG;
                if (!a.aYV()) {
                    a.setVisibility(8);
                }
                SnsUploadUI.this.rCG.postInvalidate();
                SnsUploadUI.this.mController.contentView.postInvalidate();
                AppMethodBeat.m2505o(39736);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadUI$1$1 */
        class C135991 implements Runnable {
            C135991() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39735);
                SnsUploadUI.this.rCG.aYS();
                SnsUploadUI.this.rCG.postInvalidate();
                SnsUploadUI.this.mController.contentView.postInvalidate();
                AppMethodBeat.m2505o(39735);
            }
        }

        C135971() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(39737);
            if (i == -3) {
                C4990ab.m7410d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                new C7306ak().postDelayed(new C135991(), 100);
                AppMethodBeat.m2505o(39737);
                return;
            }
            new C7306ak().postDelayed(new C135982(), 200);
            C4990ab.m7410d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
            AppMethodBeat.m2505o(39737);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsUploadUI() {
        AppMethodBeat.m2504i(39757);
        AppMethodBeat.m2505o(39757);
    }

    /* renamed from: j */
    static /* synthetic */ void m21796j(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39780);
        snsUploadUI.cuD();
        AppMethodBeat.m2505o(39780);
    }

    /* renamed from: m */
    static /* synthetic */ void m21800m(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39783);
        snsUploadUI.cuC();
        AppMethodBeat.m2505o(39783);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(39758);
        if (this.rnb != null) {
            bundle.putString("contentdesc", this.rnb.getText().toString());
        }
        bundle.getString("contentdesc");
        this.rnc.mo8911N(bundle);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(39758);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(39759);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.a69));
        dyb();
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        m21782Kh();
        this.rnb = (SnsEditText) findViewById(2131825373);
        if (!C5046bo.isNullOrNil(getIntent().getStringExtra(C5504k.ygd))) {
            this.rnb.setText(C5509b.m8295c(this.mController.ylL, getIntent().getStringExtra(C5504k.ygd), this.rnb.getTextSize()));
        } else if (!(this.rnb == null || bundle == null)) {
            String string = bundle.getString("contentdesc");
            if (string != null) {
                this.rnb.setText(string);
            }
        }
        if (this.rjO == 8) {
            this.rnb.setText(C5509b.m8295c(this.mController.ylL, getIntent().getStringExtra(C5504k.ygd), this.rnb.getTextSize()));
        }
        this.mJB = (KeyboardLinearLayout) findViewById(2131820987);
        this.rCG = (SnsUploadSayFooter) findViewById(2131827849);
        this.rCG.setMMEditText(this.rnb);
        this.rCG.setVisibility(8);
        this.rCM = (FrameLayout) findViewById(2131827847);
        this.rCM.post(new C1358814());
        this.rnb.setOnClickListener(new C1358915());
        this.rnb.setOnLongClickListener(new C1359016());
        WrapScollview wrapScollview = (WrapScollview) findViewById(2131823999);
        wrapScollview.setContentView(this.rnb);
        wrapScollview.setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("reportSessionId"), "");
        this.rhg = (SnsUploadConfigView) findViewById(2131827941);
        C15906a c15906a = this.rhg;
        if (this.rjO != 14 || bc.contains("wx5dfbe0a95623607b")) {
            z = false;
        } else {
            z = true;
        }
        c15906a.rCv = z;
        if (z) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(2842, (C1202f) c15906a);
            C1207m c39760j = new C39760j();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c39760j, 0);
        }
        c15906a.rCw.vRq = -1000.0f;
        c15906a.rCw.vRp = -1000.0f;
        if (!c15906a.rwo) {
            C1720g.m3537RQ();
            int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(68404, null));
            c15906a.rCp = (h & 2) != 0;
            if ((h & 8) == 0) {
                z2 = false;
            }
            c15906a.rCq = z2;
            if (!C17950b.ahP()) {
                c15906a.rCq = false;
            }
            if (!C1853r.m3842YX()) {
                c15906a.rCp = false;
            }
        }
        c15906a.setSyncFacebook(false);
        c15906a.cuy();
        c15906a.cuA();
        c15906a.cuz();
        if (c15906a.rCq) {
            c15906a.rCx.mo28143a(c15906a);
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
        setBackBtn(new C401117());
        mo17379a(0, getString(C25738R.string.eo2), (OnMenuItemClickListener) new C135932(), C5535b.GREEN);
        findViewById(2131827931).setOnTouchListener(new C135953());
        this.rCD = (AtContactWidget) findViewById(2131827940);
        this.rCD.rhg = this.rhg;
        this.rCE = (LocationWidget) findViewById(2131827846);
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
                this.rCF = (RangeWidget) findViewById(2131827939);
                findViewById(2131827933).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rCF = (RangeWidget) findViewById(2131827939);
                findViewById(2131827933).setVisibility(8);
                break;
            case 2:
            case 8:
                this.rCF = (RangeWidget) findViewById(2131827939);
                findViewById(2131827933).setVisibility(8);
                this.rCD.setVisibility(8);
                break;
        }
        this.rCF.rhg = this.rhg;
        this.rCE.mo8732ao(getIntent());
        this.rCD.mo55583ao(getIntent());
        m21787aq(getIntent());
        aqX();
        m21783P(bundle);
        this.mJB.setOnkbdStateListener(new C135971());
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(39759);
    }

    @TargetApi(11)
    private void cuB() {
        AppMethodBeat.m2504i(39760);
        if (!(this.rnc instanceof C29181ag)) {
            C4990ab.m7412e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            AppMethodBeat.m2505o(39760);
        } else if (VERSION.SDK_INT < 11) {
            C4990ab.m7410d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            AppMethodBeat.m2505o(39760);
        } else {
            new C1358110().run();
            AppMethodBeat.m2505o(39760);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(39761);
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
                AppMethodBeat.m2505o(39761);
                return true;
            }
            cuC();
            AppMethodBeat.m2505o(39761);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(39761);
        return onKeyDown;
    }

    private void cuC() {
        AppMethodBeat.m2504i(39762);
        if ((this.rjO != 0 || ((C29181ag) this.rnc).css() <= 0) && (!(this.rjO == 14 && (this.rnc instanceof C46249ac) && !((C46249ac) this.rnc).rkE) && (this.rjO != 9 || C5046bo.isNullOrNil(this.rnb.getText().toString())))) {
            C30379h.m48430a((Context) this, (int) C25738R.string.eqb, 0, (int) C25738R.string.f8819fx, (int) C25738R.string.f9076or, false, new C1358713(), null, (int) C25738R.color.f11717ei);
            AppMethodBeat.m2505o(39762);
            return;
        }
        C30379h.m48430a((Context) this, (int) C25738R.string.eqc, 0, (int) C25738R.string.eqe, (int) C25738R.string.eqd, true, new C401011(), new C1359112(), (int) C25738R.color.f11716eh);
        AppMethodBeat.m2505o(39762);
    }

    private void cuD() {
        AppMethodBeat.m2504i(39763);
        setResult(0, new Intent());
        finish();
        AppMethodBeat.m2505o(39763);
    }

    public final void cuE() {
        AppMethodBeat.m2504i(39764);
        if (this.rnc.crG()) {
            enableOptionMenu(true);
            AppMethodBeat.m2505o(39764);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(39764);
    }

    /* renamed from: Kh */
    private void m21782Kh() {
        AppMethodBeat.m2504i(39765);
        this.rnk = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rnl = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.rjO = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.rkD = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rCI = getIntent().getBooleanExtra("need_result", false);
        this.rCJ = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.rCK = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.rkC = getIntent().getStringExtra("KSessionID");
        if (C5046bo.isNullOrNil(this.rkC)) {
            this.rkC = C5046bo.anU() + "_" + C5046bo.m7507Mb(5);
            getIntent().putExtra("KSessionID", this.rkC);
        }
        AppMethodBeat.m2505o(39765);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39766);
        if (this.rjO == 9) {
            Object trim = this.rnb.getText().toString().trim();
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(68408, trim);
            if (C5046bo.isNullOrNil(trim)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7489, Integer.valueOf(0));
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(7489, Integer.valueOf(this.rnb.getPasterLen()));
            }
        }
        super.aqX();
        super.onPause();
        AppMethodBeat.m2505o(39766);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39767);
        super.onResume();
        this.rCG.post(new C135964());
        if (this.rnc != null && (this.rnc instanceof C46249ac)) {
            C46249ac c46249ac = (C46249ac) this.rnc;
            if (c46249ac.rkx != null) {
                if (c46249ac.rkE) {
                    c46249ac.csa();
                } else {
                    c46249ac.crZ();
                    AppMethodBeat.m2505o(39767);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(39767);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39768);
        super.onDestroy();
        if (this.rhg != null) {
            C1202f c1202f = this.rhg;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(2842, c1202f);
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
                snsUploadSayFooter.eAk.mo11686AC();
                snsUploadSayFooter.eAk.destroy();
            }
        }
        this.rCL.clear();
        AppMethodBeat.m2505o(39768);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39769);
        super.onActivityResult(i, i2, intent);
        if (this.rnb != null) {
            this.rnb.clearFocus();
        }
        if (i2 != -1) {
            AppMethodBeat.m2505o(39769);
        } else if (i == 30764) {
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                C35805b.m58709b(this.mController.ylL, "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
            AppMethodBeat.m2505o(39769);
        } else {
            if (this.rnc.mo8916f(i, intent)) {
                cuE();
            }
            switch (i) {
                case 5:
                    if (intent == null) {
                        AppMethodBeat.m2505o(39769);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    m21787aq(intent);
                    AppMethodBeat.m2505o(39769);
                    return;
                case 6:
                    if (intent == null) {
                        AppMethodBeat.m2505o(39769);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    this.rCD.mo55583ao(intent);
                    AppMethodBeat.m2505o(39769);
                    return;
                case 8:
                    if (intent == null) {
                        AppMethodBeat.m2505o(39769);
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                    SnsUploadConfigView snsUploadConfigView = this.rhg;
                    if (booleanExtra) {
                        snsUploadConfigView.rCp = true;
                        snsUploadConfigView.setSyncFacebook(true);
                    }
                    AppMethodBeat.m2505o(39769);
                    return;
                case 10:
                    if (intent != null) {
                        getIntent().putExtras(intent.getExtras());
                        this.rCE.mo8732ao(intent);
                        break;
                    }
                    AppMethodBeat.m2505o(39769);
                    return;
            }
            AppMethodBeat.m2505o(39769);
        }
    }

    /* renamed from: aq */
    private void m21787aq(Intent intent) {
        List list = null;
        AppMethodBeat.m2504i(39770);
        this.rCF.mo62963a(5, -1, intent, this.rCD);
        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
        if (intExtra >= 2) {
            List list2;
            this.rmH = intent.getStringExtra("Klabel_name_list");
            this.rmI = intent.getStringExtra("Kother_user_name_list");
            if (C5046bo.isNullOrNil(this.rmH)) {
                list2 = null;
            } else {
                list2 = Arrays.asList(this.rmH.split(","));
            }
            if (!C5046bo.isNullOrNil(this.rmI)) {
                list = Arrays.asList(this.rmI.split(","));
            }
            m21799l(list2, list);
            if (intExtra == 2) {
                this.rni = false;
                AppMethodBeat.m2505o(39770);
                return;
            }
            this.rni = true;
        }
        AppMethodBeat.m2505o(39770);
    }

    /* renamed from: l */
    private void m21799l(List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(39771);
        this.rnh = new ArrayList();
        this.rnf = 0;
        if (list != null && list.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String PE : list) {
                List<String> PH = C21156a.bJa().mo41635PH(C21156a.bJa().mo41632PE(PE));
                if (PH == null || PH.size() == 0) {
                    C4990ab.m7412e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                    break;
                }
                for (String PE2 : PH) {
                    hashSet.add(PE2);
                    this.rnf++;
                    C4990ab.m7411d("MicroMsg.SnsUploadUI", "dz:name : %s", PE2);
                }
            }
            this.rnh = new ArrayList(hashSet);
        }
        if (list != null) {
            int i = 0;
            for (String PE22 : list) {
                int i2;
                if (C5046bo.isNullOrNil(PE22)) {
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
        AppMethodBeat.m2505o(39771);
    }

    public final int getLayoutId() {
        return 2130970827;
    }

    public final ArrayList<C1440a> crV() {
        AppMethodBeat.m2504i(39772);
        if (this.rnc instanceof C29181ag) {
            C29181ag c29181ag = (C29181ag) this.rnc;
            ArrayList arrayList = c29181ag.rlP.rma;
            ArrayList<C1440a> arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1440a c1440a = (C1440a) c29181ag.rlR.get((String) it.next());
                if (c1440a != null) {
                    arrayList2.add(c1440a);
                }
            }
            AppMethodBeat.m2505o(39772);
            return arrayList2;
        }
        AppMethodBeat.m2505o(39772);
        return null;
    }

    public final boolean crW() {
        return this.rkD;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(39773);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(39773);
            return;
        }
        C4990ab.m7417i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C135835(), new C135856());
                    break;
                }
                this.rCE.crS();
                AppMethodBeat.m2505o(39773);
                return;
        }
        AppMethodBeat.m2505o(39773);
    }

    /* renamed from: a */
    public final void mo25789a(String str, boolean z, int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2) {
        AppMethodBeat.m2504i(39774);
        getIntent().getExtras().clear();
        getIntent().putExtra("KTouchCameraTime", C5046bo.anT());
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 0);
        getIntent().putExtra("KFilterId", i);
        if (!C5046bo.isNullOrNil(str)) {
            getIntent().putExtra("sns_kemdia_path", str);
        }
        if (!C5046bo.m7548ek(arrayList)) {
            getIntent().putExtra("sns_kemdia_path_list", arrayList);
        }
        if (!C5046bo.m7548ek(arrayList2)) {
            getIntent().putStringArrayListExtra("sns_media_latlong_list", arrayList2);
        }
        if (z) {
            getIntent().putExtra("Kis_take_photo", z);
        }
        if (i2 != 0) {
            getIntent().putExtra("Ksnsupload_source", 11);
        }
        AppMethodBeat.m2505o(39774);
    }

    /* renamed from: a */
    public final void mo25788a(String str, String str2, String str3, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(39775);
        getIntent().getExtras().clear();
        getIntent().putExtra("KSightPath", str);
        getIntent().putExtra("KSightThumbPath", str2);
        getIntent().putExtra("sight_md5", str3);
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 14);
        getIntent().putExtra("Kis_take_photo", false);
        getIntent().putExtra("KMMSightExtInfo", bArr);
        if (z) {
            getIntent().putExtra("KSessionID", C5046bo.anU() + "_" + C5046bo.m7507Mb(5));
        }
        AppMethodBeat.m2505o(39775);
    }

    public final void cuF() {
        AppMethodBeat.m2504i(39776);
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
        m21782Kh();
        m21783P(null);
        AppMethodBeat.m2505o(39776);
    }

    /* renamed from: En */
    private C22150y m21781En(int i) {
        AppMethodBeat.m2504i(39777);
        C22150y c22150y = (C22150y) this.rCL.get(Integer.valueOf(i));
        if (c22150y == null) {
            if (i == 0) {
                c22150y = new C29181ag(this);
            } else if (i == 14) {
                c22150y = new C46249ac(this);
            }
            this.rCL.put(Integer.valueOf(i), c22150y);
        }
        AppMethodBeat.m2505o(39777);
        return c22150y;
    }

    /* renamed from: P */
    private void m21783P(Bundle bundle) {
        View findViewById;
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(39778);
        C4990ab.m7411d("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", Integer.valueOf(this.rjO), Boolean.valueOf(this.rnk));
        if (this.rjO == 0 || this.rjO == 14 || this.rjO == 9) {
            Parcel obtain = Parcel.obtain();
            getIntent().writeToParcel(obtain, 0);
            obtain.marshall();
            if (this.rjO == 9) {
                setMMTitle(this.mController.ylL.getResources().getString(C25738R.string.epk));
            } else {
                setMMTitle("");
            }
        }
        switch (this.rjO) {
            case 0:
                this.rnc = m21781En(this.rjO);
                this.rnb.addTextChangedListener(new C135847());
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rnc = new C29248z(this);
                break;
            case 2:
                this.rnc = new C39823ab(this);
                break;
            case 3:
                this.rnc = new C24832ah(this, 9);
                break;
            case 4:
                this.rnc = new C43598o(this);
                break;
            case 5:
                this.rnc = new C24832ah(this, 14);
                break;
            case 6:
                this.rnc = new C24832ah(this, 12);
                break;
            case 7:
                this.rnc = new C24832ah(this, 13);
                break;
            case 8:
                this.rnc = new C4051ba(this);
                break;
            case 9:
                boolean z;
                C1720g.m3537RQ();
                String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(68408, (Object) ""), "");
                C1720g.m3537RQ();
                int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(7489, Integer.valueOf(0)), 0);
                if (C5046bo.isNullOrNil(bc)) {
                    z = false;
                } else {
                    z = true;
                }
                this.rnc = new C39826ad(this, z);
                this.rnb.setPasterLen(a);
                this.rnb.setText(C5509b.m8295c(this.mController.ylL, bc, this.rnb.getTextSize()));
                this.rnb.addTextChangedListener(new C135868());
                break;
            case 10:
                this.rnc = new C39848m(this);
                break;
            case 12:
                this.rnc = new C46259n(this);
                break;
            case 13:
                this.rnc = new C29231p(this);
                break;
            case 14:
                this.rnc = m21781En(this.rjO);
                break;
        }
        this.rnc.mo8910M(bundle);
        View findViewById2;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.rnc instanceof C4015a) {
            findViewById = findViewById(2131827934);
            findViewById2 = findViewById(2131827936);
            this.rCH = (DynamicGridView) findViewById(2131827932);
            this.rCH.setOnTouchListener(new C135929());
            findViewById = ((C4015a) this.rnc).mo8861a(findViewById, findViewById(2131827942), this.rCH, findViewById2);
            this.rCH.setVisibility(0);
            findViewById2 = findViewById(2131827938);
            layoutParams2 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(3, 2131827932);
            findViewById2.setLayoutParams(layoutParams2);
        } else {
            findViewById2 = this.rnc.crH();
            this.rnd = (LinearLayout) findViewById(2131827848);
            this.rnd.setVisibility(0);
            this.rnd.setClipChildren(false);
            if (findViewById2 != null) {
                C4990ab.m7410d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
                this.rnd.addView(findViewById2);
            } else {
                this.rnd.setVisibility(8);
            }
            if (this.rjO == 9 || this.rjO == 14) {
                View findViewById3 = findViewById(2131827938);
                layoutParams2 = (RelativeLayout.LayoutParams) findViewById3.getLayoutParams();
                layoutParams2.addRule(3, 2131827848);
                layoutParams2.topMargin = (int) (((float) (this.rjO == 9 ? 128 : 96)) * C5056d.anS().density);
                findViewById3.setLayoutParams(layoutParams2);
            }
            findViewById = findViewById2;
        }
        if (this.rnc instanceof C29248z) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = -1;
            findViewById.setLayoutParams(layoutParams);
        }
        if ((this.rnc instanceof C43598o) || (this.rnc instanceof C39848m) || (this.rnc instanceof C46259n)) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = -1;
            findViewById.setLayoutParams(layoutParams);
        }
        cuE();
        if (this.rjO == 0) {
            cuB();
        }
        AppMethodBeat.m2505o(39778);
    }

    /* renamed from: h */
    static /* synthetic */ void m21794h(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39779);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, snsUploadUI.rkC);
        AppMethodBeat.m2505o(39779);
    }

    /* renamed from: k */
    static /* synthetic */ void m21797k(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39781);
        snsUploadUI.cuD();
        AppMethodBeat.m2505o(39781);
    }

    /* renamed from: l */
    static /* synthetic */ void m21798l(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39782);
        snsUploadUI.rnb.requestFocus();
        C4990ab.m7410d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.rCG.aYV()) {
            snsUploadUI.rCG.aYW();
        }
        if (!C40619x.m70075gu(snsUploadUI)) {
            snsUploadUI.rCG.aYS();
        }
        snsUploadUI.mController.contentView.postInvalidate();
        AppMethodBeat.m2505o(39782);
    }

    /* renamed from: D */
    static /* synthetic */ boolean m21780D(SnsUploadUI snsUploadUI) {
        AppMethodBeat.m2504i(39784);
        snsUploadUI.aqX();
        if (snsUploadUI.rCG.aYV()) {
            snsUploadUI.rCG.aYW();
            AppMethodBeat.m2505o(39784);
            return true;
        }
        AppMethodBeat.m2505o(39784);
        return false;
    }
}
