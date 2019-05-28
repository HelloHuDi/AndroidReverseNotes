package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C36724c;
import com.tencent.p177mm.plugin.emoji.C42935b;
import com.tencent.p177mm.plugin.emoji.model.C42951i;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C27740b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.C11548f;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2DesignerUI;
import com.tencent.p177mm.plugin.emoji.p384ui.widget.ScaleRelativeLayout;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C20373l;
import com.tencent.p177mm.plugin.emoji.p726f.C20375n;
import com.tencent.p177mm.plugin.emoji.p726f.C38881k;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p726f.C42947i;
import com.tencent.p177mm.plugin.emoji.p726f.C45856j;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.protocal.protobuf.EmotionDetail;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.p177mm.protocal.protobuf.aic;
import com.tencent.p177mm.protocal.protobuf.aii;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.emotion.C44224i;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI */
public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, C1202f, C11558a, C27740b {
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String cwg;
    private String ejD;
    private EmojiInfo exP;
    C11548f kYB;
    private View kYC;
    private ImageView kYD;
    private TextView kYE;
    private TextView kYF;
    private aic kYG;
    private EmotionDetail kYH = new EmotionDetail();
    private String kYI;
    private ScaleRelativeLayout kYJ;
    private TextView kYK;
    private BaseEmojiView kYL;
    private C42951i kYM;
    private aii kYN;
    private long kYO;
    String kYP;
    private String kYQ;
    private boolean kYR = false;
    private Runnable kYS = new C29421();
    private Runnable kYT = new C339608();
    private C4884c kYU = new C3888910();
    private C4884c kYt = new C203899();
    private C42945g kYu;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$15 */
    class C294115 implements OnClickListener {
        C294115() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138345);
            if (CustomSmileyPreviewUI.this.kYG == null || CustomSmileyPreviewUI.this.kYG.woq == null) {
                C4990ab.m7416i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                AppMethodBeat.m2505o(138345);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(CustomSmileyPreviewUI.this.mController.ylL, EmojiStoreV2DesignerUI.class);
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, CustomSmileyPreviewUI.this.kYG.woq.DesignerUin);
            intent.putExtra("name", CustomSmileyPreviewUI.this.kYG.woq.Name);
            intent.putExtra("headurl", CustomSmileyPreviewUI.this.kYG.woq.HeadUrl);
            intent.putExtra("extra_scence", 9);
            CustomSmileyPreviewUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(138345);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$1 */
    class C29421 implements Runnable {
        C29421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53220);
            if (CustomSmileyPreviewUI.this.kYK != null) {
                CustomSmileyPreviewUI.this.kYK.setText(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(CustomSmileyPreviewUI.this.exP.mo20410Aq()));
            }
            AppMethodBeat.m2505o(53220);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$6 */
    class C29436 implements Runnable {
        final /* synthetic */ int gOm;
        final /* synthetic */ String kUJ;

        C29436(String str, int i) {
            this.kUJ = str;
            this.gOm = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(138343);
            if (C5046bo.isNullOrNil(this.kUJ)) {
                C4990ab.m7420w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                AppMethodBeat.m2505o(138343);
                return;
            }
            if (!(CustomSmileyPreviewUI.this.kYB == null || CustomSmileyPreviewUI.this.kYB.kSP == null)) {
                CustomSmileyPreviewUI.this.kYB.mo54492bX(this.kUJ, this.gOm);
                CustomSmileyPreviewUI.this.kYB.refreshView();
            }
            AppMethodBeat.m2505o(138343);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$14 */
    class C1156514 implements OnMenuItemClickListener {
        C1156514() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53238);
            CustomSmileyPreviewUI.m65984g(CustomSmileyPreviewUI.this);
            AppMethodBeat.m2505o(53238);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$7 */
    class C115667 implements Runnable {
        final /* synthetic */ int fTG;
        final /* synthetic */ String kUJ;

        C115667(String str, int i) {
            this.kUJ = str;
            this.fTG = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(53227);
            if (C5046bo.isNullOrNil(this.kUJ)) {
                C4990ab.m7420w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                AppMethodBeat.m2505o(53227);
                return;
            }
            if (!(CustomSmileyPreviewUI.this.kYB == null || CustomSmileyPreviewUI.this.kYB.kSP == null)) {
                CustomSmileyPreviewUI.this.kYB.mo54491bW(this.kUJ, this.fTG);
            }
            AppMethodBeat.m2505o(53227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$9 */
    class C203899 extends C4884c<C18232da> {
        C203899() {
            AppMethodBeat.m2504i(53230);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53230);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53231);
            C18232da c18232da = (C18232da) c4883b;
            if (!(c18232da == null || C5046bo.isNullOrNil(CustomSmileyPreviewUI.this.cwg) || !CustomSmileyPreviewUI.this.cwg.equals(c18232da.cwf.cwg))) {
                CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                String str = c18232da.cwf.cwg;
                int i = c18232da.cwf.status;
                int i2 = c18232da.cwf.progress;
                C4990ab.m7411d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), c18232da.cwf.cwh);
                if (i == 6) {
                    C5004al.m7441d(new C29436(str, i2));
                } else {
                    C4990ab.m7417i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", Integer.valueOf(i));
                    C5004al.m7441d(new C115667(str, i));
                }
                if (customSmileyPreviewUI.kYB != null) {
                    C45842c c45842c = customSmileyPreviewUI.kYB.kSP;
                    if (c45842c != null) {
                        C11546f IT = c45842c.mo73635IT(str);
                        if (IT != null) {
                            IT.kTe = r4;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(53231);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$2 */
    class C339582 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$2$1 */
        class C277461 implements OnClickListener {
            C277461() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(138338);
                CustomSmileyPreviewUI.m65974a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.kYN.wou.wdY);
                AppMethodBeat.m2505o(138338);
            }
        }

        C339582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138339);
            if (CustomSmileyPreviewUI.this.kYN != null && CustomSmileyPreviewUI.this.kYN.wou != null) {
                CustomSmileyPreviewUI.this.kYC.setVisibility(0);
                CustomSmileyPreviewUI.this.kYE.setText(CustomSmileyPreviewUI.this.kYN.wou.Name);
                if (C5046bo.isNullOrNil(CustomSmileyPreviewUI.this.kYN.wou.IconUrl)) {
                    CustomSmileyPreviewUI.this.kYD.setVisibility(8);
                } else {
                    CustomSmileyPreviewUI.this.kYD.setVisibility(0);
                    C32291o.ahp().mo43766a(CustomSmileyPreviewUI.this.kYN.wou.IconUrl, CustomSmileyPreviewUI.this.kYD, C20364g.m31461dJ(CustomSmileyPreviewUI.this.exP.field_groupId, CustomSmileyPreviewUI.this.kYN.wou.IconUrl));
                }
                CustomSmileyPreviewUI.this.kYF.setText(C25738R.string.b90);
                CustomSmileyPreviewUI.this.kYC.setOnClickListener(new C277461());
                CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                AppMethodBeat.m2505o(138339);
            } else if (CustomSmileyPreviewUI.this.kYG == null || CustomSmileyPreviewUI.this.kYG.woq == null) {
                CustomSmileyPreviewUI.this.kYC.setVisibility(8);
                AppMethodBeat.m2505o(138339);
            } else {
                CustomSmileyPreviewUI.this.kYC.setVisibility(0);
                CustomSmileyPreviewUI.this.kYE.setText(CustomSmileyPreviewUI.this.kYG.woq.Name);
                C32291o.ahp().mo43766a(CustomSmileyPreviewUI.this.kYG.woq.HeadUrl, CustomSmileyPreviewUI.this.kYD, C20364g.m31460dI(CustomSmileyPreviewUI.this.exP.field_groupId, CustomSmileyPreviewUI.this.kYG.woq.HeadUrl));
                CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                AppMethodBeat.m2505o(138339);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$8 */
    class C339608 implements Runnable {
        C339608() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53229);
            CustomSmileyPreviewUI.m65975a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.cwg, CustomSmileyPreviewUI.this.exP);
            AppMethodBeat.m2505o(53229);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$3 */
    class C367613 implements C36073c {
        C367613() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(138340);
            if (!(CustomSmileyPreviewUI.this.exP.field_catalog == EmojiInfo.yaB || CustomSmileyPreviewUI.this.exP.duS())) {
                c44273l.mo70072hi(0, C25738R.string.f8719d3);
            }
            if (CustomSmileyPreviewUI.this.exP.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(CustomSmileyPreviewUI.this.exP.field_groupId) || (!C5046bo.isNullOrNil(CustomSmileyPreviewUI.this.exP.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(CustomSmileyPreviewUI.this.exP.field_groupId))) {
                c44273l.mo70072hi(1, C25738R.string.dr8);
            }
            C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
            CustomSmileyPreviewUI.this.exP;
            if (emojiMgr.bjR()) {
                c44273l.mo70072hi(2, C25738R.string.b_p);
            }
            c44273l.mo70072hi(3, C25738R.string.b_6);
            AppMethodBeat.m2505o(138340);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$10 */
    class C3888910 extends C4884c<C37781pe> {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$10$1 */
        class C388901 implements DialogInterface.OnClickListener {
            C388901() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(53232);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                CustomSmileyPreviewUI.this.finish();
                AppMethodBeat.m2505o(53232);
            }
        }

        C3888910() {
            AppMethodBeat.m2504i(53233);
            this.xxI = C37781pe.class.getName().hashCode();
            AppMethodBeat.m2505o(53233);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53234);
            C37781pe c37781pe = (C37781pe) c4883b;
            if (CustomSmileyPreviewUI.this.kYO != 0 && c37781pe.cLt.cLw == CustomSmileyPreviewUI.this.kYO) {
                C4990ab.m7416i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                C30379h.m48447a(CustomSmileyPreviewUI.this.mController.ylL, c37781pe.cLt.cLu, "", CustomSmileyPreviewUI.this.getString(C25738R.string.f9187s6), false, new C388901());
            }
            AppMethodBeat.m2505o(53234);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$4 */
    class C388914 implements C5279d {
        C388914() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(138341);
            switch (menuItem.getItemId()) {
                case 0:
                    CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                    EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5"));
                    if (aqi == null) {
                        C4990ab.m7420w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                        AppMethodBeat.m2505o(138341);
                        return;
                    }
                    if (aqi.field_catalog != EmojiInfo.yax) {
                        if (aqi.field_catalog == EmojiInfo.yaB) {
                            C30379h.m48465bQ(customSmileyPreviewUI, customSmileyPreviewUI.getString(C25738R.string.f8817fv));
                            AppMethodBeat.m2505o(138341);
                            return;
                        }
                        C7060h.pYm.mo8381e(12789, Integer.valueOf(3), aqi.mo20410Aq(), Integer.valueOf(1), aqi.field_designerID, aqi.field_groupId, "", "", "", "", "", aqi.field_activityid);
                        C42952j.bki().mo35621a(customSmileyPreviewUI.mController.ylL, aqi, 4, customSmileyPreviewUI.kYP);
                    }
                    AppMethodBeat.m2505o(138341);
                    return;
                case 1:
                    CustomSmileyPreviewUI.m65992o(CustomSmileyPreviewUI.this);
                    AppMethodBeat.m2505o(138341);
                    return;
                case 2:
                    CustomSmileyPreviewUI.this.setResult(-1);
                    C20423c.m31581an(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.exP.mo20410Aq());
                    break;
                case 3:
                    CustomSmileyPreviewUI.m65993p(CustomSmileyPreviewUI.this);
                    AppMethodBeat.m2505o(138341);
                    return;
            }
            AppMethodBeat.m2505o(138341);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$12 */
    class C3889212 implements Runnable {
        C3889212() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53236);
            ScaleRelativeLayout f = CustomSmileyPreviewUI.this.kYJ;
            f.aJf = Math.min(Math.min(((float) f.getMeasuredWidth()) / ((float) CustomSmileyPreviewUI.this.kYL.getMeasuredWidth()), ((float) f.getMeasuredHeight()) / ((float) CustomSmileyPreviewUI.this.kYL.getMeasuredHeight())), 3.0f);
            f.lgE = f.aJf * 1.5f;
            AppMethodBeat.m2505o(53236);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$11 */
    class C3889311 implements OnClickListener {
        C3889311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53235);
            Toast.makeText(CustomSmileyPreviewUI.this.mController.ylL, "isHevc:" + CustomSmileyPreviewUI.this.kYL.eAi, 0).show();
            AppMethodBeat.m2505o(53235);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$13 */
    class C3889413 implements OnMenuItemClickListener {
        C3889413() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(138344);
            CustomSmileyPreviewUI.this.finish();
            AppMethodBeat.m2505o(138344);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CustomSmileyPreviewUI() {
        AppMethodBeat.m2504i(53240);
        AppMethodBeat.m2505o(53240);
    }

    public final int getLayoutId() {
        return 2130969258;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53241);
        super.onCreate(bundle);
        C1720g.m3535RO().eJo.mo14539a(412, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) C36724c.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(368, (C1202f) this);
        C4879a.xxA.mo10052c(this.kYt);
        C4879a.xxA.mo10052c(this.kYU);
        initView();
        String str = "";
        if (!(this.kYG == null || this.kYG.woq == null)) {
            str = C1183p.getString(this.kYG.woq.DesignerUin);
        }
        C7060h.pYm.mo8381e(12740, Integer.valueOf(4), str, this.exP.field_groupId, "", Integer.valueOf(9), Integer.valueOf(9));
        AppMethodBeat.m2505o(53241);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53242);
        super.onResume();
        AppMethodBeat.m2505o(53242);
    }

    public void onStart() {
        AppMethodBeat.m2504i(53243);
        super.onStart();
        AppMethodBeat.m2505o(53243);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53244);
        super.onPause();
        AppMethodBeat.m2505o(53244);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53245);
        C1720g.m3535RO().eJo.mo14546b(412, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) C36724c.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(368, (C1202f) this);
        C4879a.xxA.mo10053d(this.kYt);
        C4879a.xxA.mo10053d(this.kYU);
        super.onDestroy();
        C5004al.m7439af(this.kYS);
        C5004al.m7439af(this.kYT);
        AppMethodBeat.m2505o(53245);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(53246);
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.kYO = getIntent().getLongExtra("msg_id", 0);
        this.kYP = getIntent().getStringExtra("msg_sender");
        this.kYQ = getIntent().getStringExtra("msg_content");
        this.ejD = getIntent().getStringExtra("room_id");
        C4990ab.m7411d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", stringExtra);
        String nullAsNil = C5046bo.nullAsNil(stringExtra);
        if (TextUtils.isEmpty(nullAsNil)) {
            C4990ab.m7412e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.kYJ = (ScaleRelativeLayout) findViewById(2131823186);
        this.kYK = (TextView) findViewById(2131823189);
        this.kYL = (BaseEmojiView) findViewById(2131821449);
        View findViewById = findViewById(2131823187);
        ((ImageView) findViewById(2131823188)).setImageDrawable(C5225ah.m7962f(this, C1318a.emoticonstore_capture_icon, -1));
        if (C4872b.dnO() || C5058f.IS_FLAVOR_RED) {
            this.kYL.setOnClickListener(new C3889311());
        }
        this.exP = C42952j.getEmojiStorageMgr().xYn.aqi(nullAsNil);
        if (this.exP == null) {
            finish();
        }
        if (this.exP.duP()) {
            this.kYL.setEmojiInfo(this.exP);
        } else {
            C37682a c37682a = C37682a.exs;
            C37682a.m63723a(this.exP, this.kYL, null);
        }
        if (C2933b.m5227y(this.exP)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        C5004al.m7441d(new C3889212());
        stringExtra = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(this.exP.mo20410Aq());
        if (!(this.kYK == null || C5046bo.isNullOrNil(stringExtra))) {
            this.kYK.setText(stringExtra);
            this.kYL.setContentDescription(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        String stringExtra3 = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(2131821452);
        C40439f bT = C46494g.m87739bT(stringExtra2, true);
        if (!(bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0)) {
            stringExtra3 = bT.field_appName;
        }
        if (stringExtra2 == null || stringExtra2.length() <= 0 || !CustomSmileyPreviewUI.m65981dg(stringExtra3)) {
            textView.setVisibility(8);
            this.cwg = this.exP.field_groupId;
            C1720g.m3535RO().eJo.mo14541a(new C38881k(this.cwg), 0);
            this.mListView = (ListView) findViewById(16908298);
            this.kYB = new C11548f(this.mController.ylL);
            this.kYB.kSQ = this;
            this.kYB.kSk = true;
            this.kYB.kSn = false;
            this.mListView.setOnItemClickListener(this);
            this.mListView.setAdapter(this.kYB);
            this.kYB.kSO = this.mListView;
            if (!C5046bo.isNullOrNil(this.cwg)) {
                blj();
            }
            this.kYM = new C42951i();
            this.kYM.jiq = this;
            this.kYM.kVA = this.kYB;
            this.kYM.kVD = 9;
            this.kYM.kVG = this;
            this.kYR = C42952j.getEmojiStorageMgr().xYp.aqg(this.cwg);
            m65976a(this.cwg, this.exP);
        } else {
            textView.setText(getString(C25738R.string.ba6, new Object[]{C46494g.m87733b(this.mController.ylL, bT, stringExtra3)}));
            textView.setVisibility(0);
            m65971a(this, (View) textView, stringExtra2);
            CustomSmileyPreviewUI.m65973a(this, textView, stringExtra2);
        }
        setBackBtn(new C3889413());
        if (this.exP.field_catalog == EmojiInfo.yaB || this.exP.duS()) {
            z = false;
        } else {
            z = true;
        }
        if (this.exP.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(this.exP.field_groupId) || (!C5046bo.isNullOrNil(this.exP.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(this.exP.field_groupId))) {
            z = true;
        }
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C1156514());
        showOptionMenu(z);
        blg();
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.cwg;
        objArr[2] = nullAsNil;
        objArr[3] = this.exP == null ? "" : this.exP.field_designerID;
        objArr[4] = this.exP == null ? "" : this.exP.field_activityid;
        c7060h.mo8381e(12067, objArr);
        AppMethodBeat.m2505o(53246);
    }

    private void blg() {
        AppMethodBeat.m2504i(53247);
        this.kYC = findViewById(2131823537);
        this.kYD = (ImageView) this.kYC.findViewById(2131823538);
        this.kYE = (TextView) this.kYC.findViewById(2131823539);
        this.kYF = (TextView) this.kYC.findViewById(2131823540);
        this.kYC.setVisibility(8);
        if (!(this.exP == null || C5046bo.isNullOrNil(this.exP.field_designerID))) {
            m65968JK(this.exP.field_designerID);
            CustomSmileyPreviewUI.m65967JJ(this.exP.field_designerID);
        }
        if (!(this.exP == null || C5046bo.isNullOrNil(this.exP.field_activityid))) {
            m65969JL(this.exP.field_activityid);
            m65980dM(this.exP.field_activityid, this.exP.field_md5);
        }
        blh();
        this.kYC.setOnClickListener(new C294115());
        AppMethodBeat.m2505o(53247);
    }

    /* renamed from: JJ */
    private static void m65967JJ(String str) {
        AppMethodBeat.m2504i(53248);
        C1720g.m3535RO().eJo.mo14541a(new C42947i(str), 0);
        AppMethodBeat.m2505o(53248);
    }

    /* renamed from: JK */
    private void m65968JK(String str) {
        AppMethodBeat.m2504i(53249);
        this.kYG = C42952j.getEmojiStorageMgr().xYt.aqn(str);
        AppMethodBeat.m2505o(53249);
    }

    /* renamed from: JL */
    private void m65969JL(String str) {
        AppMethodBeat.m2504i(53250);
        this.kYN = C42952j.getEmojiStorageMgr().xYq.aqt(str);
        AppMethodBeat.m2505o(53250);
    }

    /* renamed from: dM */
    private void m65980dM(String str, String str2) {
        AppMethodBeat.m2504i(53251);
        if (this.kYN == null || !(this.kYN == null || this.kYN.wou == null || ((long) this.kYN.wou.wdZ) >= System.currentTimeMillis() / 1000)) {
            C1720g.m3535RO().eJo.mo14541a(new C45856j(str, str2), 0);
            AppMethodBeat.m2505o(53251);
            return;
        }
        C4990ab.m7416i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
        AppMethodBeat.m2505o(53251);
    }

    private void blh() {
        AppMethodBeat.m2504i(53252);
        C5004al.m7441d(new C339582());
        AppMethodBeat.m2505o(53252);
    }

    /* renamed from: dg */
    private static boolean m65981dg(String str) {
        AppMethodBeat.m2504i(53253);
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            AppMethodBeat.m2505o(53253);
            return false;
        }
        AppMethodBeat.m2505o(53253);
        return true;
    }

    /* renamed from: a */
    private void m65971a(CustomSmileyPreviewUI customSmileyPreviewUI, View view, String str) {
        AppMethodBeat.m2504i(53254);
        final String f = C35799p.m58693f(customSmileyPreviewUI, str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(138342);
                if (C5046bo.isNullOrNil(f)) {
                    AppMethodBeat.m2505o(138342);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", f);
                C25985d.m41467b(CustomSmileyPreviewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(138342);
            }
        });
        AppMethodBeat.m2505o(53254);
    }

    /* renamed from: a */
    private static void m65973a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, String str) {
        AppMethodBeat.m2504i(53255);
        Bitmap b = C46494g.m87732b(str, 2, C1338a.getDensity(customSmileyPreviewUI));
        if (b == null || b.isRecycled()) {
            CustomSmileyPreviewUI.m65972a(customSmileyPreviewUI, textView, BitmapFactory.decodeResource(customSmileyPreviewUI.getResources(), C25738R.drawable.akc));
            AppMethodBeat.m2505o(53255);
            return;
        }
        CustomSmileyPreviewUI.m65972a(customSmileyPreviewUI, textView, b);
        AppMethodBeat.m2505o(53255);
    }

    /* renamed from: a */
    private static void m65972a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        AppMethodBeat.m2504i(53256);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(C25738R.dimen.f9936kr);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        AppMethodBeat.m2505o(53256);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53257);
        switch (c1207m.getType()) {
            case C31128d.MIC_PTU_SHISHANG2 /*239*/:
                this.kYG = ((C42947i) c1207m).bkx();
                blh();
                AppMethodBeat.m2505o(53257);
                return;
            case 368:
                if (i2 != 0) {
                    C4990ab.m7420w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                    break;
                }
                C45856j c45856j = (C45856j) c1207m;
                aii aii = (aii) c45856j.ehh.fsH.fsP;
                if (!(aii == null || aii.wou == null)) {
                    aii.wou.wdZ = ((int) (System.currentTimeMillis() / 1000)) + aii.wou.wdZ;
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYq.mo64087a(c45856j.kWN, aii);
                }
                this.kYN = aii;
                blh();
                AppMethodBeat.m2505o(53257);
                return;
            case 411:
                if (c1207m instanceof C20375n) {
                    C42952j.getEmojiStorageMgr().xYq.mo64086a(12, ((C20375n) c1207m).bkB());
                    AppMethodBeat.m2505o(53257);
                    return;
                }
                break;
            case 412:
                if (c1207m instanceof C20373l) {
                    C20373l c20373l = (C20373l) c1207m;
                    String str2;
                    String str3;
                    Object[] objArr;
                    C45842c bli;
                    if (i == 0) {
                        if (i2 == 0) {
                            this.kYH = c20373l.bkz();
                            if (this.kYH == null || TextUtils.isEmpty(this.cwg) || !this.cwg.equals(this.kYH.ProductID)) {
                                str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                                str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                                objArr = new Object[2];
                                objArr[0] = this.cwg;
                                objArr[1] = this.kYH == null ? "" : this.kYH.ProductID;
                                C4990ab.m7417i(str2, str3, objArr);
                                AppMethodBeat.m2505o(53257);
                                return;
                            }
                            bli = bli();
                            if (this.kYB != null) {
                                this.kYB.mo54488a(bli);
                            }
                            C4990ab.m7416i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kYH.ProductID);
                            AppMethodBeat.m2505o(53257);
                            return;
                        } else if (i2 == 1) {
                            AppMethodBeat.m2505o(53257);
                            return;
                        }
                    } else if (i2 == 5) {
                        if (this.kYH == null || c20373l.bkz() == null || TextUtils.isEmpty(this.cwg) || !this.cwg.equals(this.kYH.ProductID) || this.kYH.PackFlag == c20373l.bkz().PackFlag) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.cwg;
                            objArr[1] = this.kYH == null ? "" : this.kYH.ProductID;
                            C4990ab.m7417i(str2, str3, objArr);
                            AppMethodBeat.m2505o(53257);
                            return;
                        }
                        this.kYH.PackFlag = c20373l.bkz().PackFlag;
                        bli = bli();
                        if (this.kYB != null) {
                            this.kYB.mo54488a(bli);
                        }
                        C4990ab.m7416i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kYH.ProductID);
                        AppMethodBeat.m2505o(53257);
                        return;
                    }
                }
                break;
            case C36724c.CTRL_INDEX /*521*/:
                if (i2 == 0) {
                    C5004al.m7441d(this.kYT);
                    C5004al.m7442n(this.kYS, 500);
                    AppMethodBeat.m2505o(53257);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(53257);
    }

    private C45842c bli() {
        AppMethodBeat.m2504i(53258);
        List arrayList = new ArrayList();
        EmotionSummary emotionSummary = new EmotionSummary();
        emotionSummary.CoverUrl = this.kYH.CoverUrl;
        emotionSummary.IconUrl = this.kYH.IconUrl;
        emotionSummary.PackName = this.kYH.PackName;
        emotionSummary.PackFlag = this.kYH.PackFlag;
        emotionSummary.PackDesc = this.kYH.PackDesc;
        emotionSummary.PackExpire = this.kYH.PackExpire;
        emotionSummary.PackType = this.kYH.PackType;
        emotionSummary.PackPrice = this.kYH.PackPrice;
        emotionSummary.PriceNum = this.kYH.PriceNum;
        emotionSummary.PriceType = this.kYH.PriceType;
        emotionSummary.ProductID = this.kYH.ProductID;
        arrayList.add(new C11546f(emotionSummary));
        C45842c c45842c = new C45842c(arrayList);
        AppMethodBeat.m2505o(53258);
        return c45842c;
    }

    /* renamed from: a */
    private void m65976a(String str, EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53259);
        if (C5046bo.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.m2505o(53259);
            return;
        }
        if (!C5046bo.isNullOrNil(str) && emojiInfo.field_catalog != EmojiGroupInfo.yas && emojiInfo.field_catalog != EmojiGroupInfo.yar && ((emojiInfo.field_type != EmojiInfo.zYX || emojiInfo.field_type != EmojiInfo.zYY) && C42952j.getEmojiStorageMgr().xYp.aqf(str))) {
            if (this.mListView != null) {
                this.mListView.setVisibility(0);
            }
            if (this.kYB != null) {
                this.kYB.kSl = this.kYR;
                this.kYB.notifyDataSetChanged();
                AppMethodBeat.m2505o(53259);
                return;
            }
        } else if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        AppMethodBeat.m2505o(53259);
    }

    /* renamed from: a */
    public final void mo23265a(C45843a c45843a) {
        AppMethodBeat.m2504i(53260);
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = c45843a.getProductId();
        objArr[1] = TextUtils.isEmpty(c45843a.bjo()) ? "" : c45843a.bjo();
        objArr[2] = Integer.valueOf(c45843a.bjn());
        C4990ab.m7417i(str, str2, objArr);
        this.kYM.mo68470a(c45843a);
        AppMethodBeat.m2505o(53260);
    }

    public final void bkf() {
    }

    private void blj() {
        AppMethodBeat.m2504i(53262);
        C44224i aqp = C42952j.getEmojiStorageMgr().xYr.aqp(this.cwg);
        if (!(aqp == null || aqp.field_content == null)) {
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            try {
                getEmotionDetailResponse.parseFrom(aqp.field_content);
                this.kYH = getEmotionDetailResponse.EmotionDetail;
                this.kYI = aqp.field_lan;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", C5046bo.m7574l(e));
            }
        }
        if (this.kYH == null || C5046bo.isNullOrNil(this.kYI) || !this.kYI.equalsIgnoreCase(C4988aa.m7403gw(this.mController.ylL))) {
            C1720g.m3535RO().eJo.mo14541a(new C20373l(this.cwg, 1), 0);
            AppMethodBeat.m2505o(53262);
            return;
        }
        C45842c bli = bli();
        if (this.kYB != null) {
            this.kYB.mo54488a(bli);
        }
        C1720g.m3535RO().eJo.mo14541a(new C20373l(this.cwg, 1, this.kYH.Version), 0);
        AppMethodBeat.m2505o(53262);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(53263);
        if (this.kYB == null || i < 0 || i >= this.kYB.getCount()) {
            AppMethodBeat.m2505o(53263);
            return;
        }
        C7060h.pYm.mo8381e(12789, Integer.valueOf(4), this.exP.mo20410Aq(), Integer.valueOf(1), this.exP.field_designerID, this.exP.field_groupId, "", "", "", "", this.exP.field_activityid);
        C11546f tX = this.kYB.getItem(i);
        Intent intent = new Intent();
        intent.setClass(this, EmojiStoreDetailUI.class);
        EmotionSummary emotionSummary = tX.kTb;
        if (emotionSummary == null) {
            intent = null;
        } else {
            intent.putExtra("extra_id", emotionSummary.ProductID);
            intent.putExtra("extra_name", emotionSummary.PackName);
            intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
            intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
            intent.putExtra("extra_description", emotionSummary.PackDesc);
            intent.putExtra("extra_price", emotionSummary.PackPrice);
            intent.putExtra("extra_type", emotionSummary.PackType);
            intent.putExtra("extra_flag", emotionSummary.PackFlag);
            intent.putExtra("preceding_scence", 4);
            intent.putExtra("call_by", 1);
            intent.putExtra("download_entrance_scene", 9);
            intent.putExtra("check_clickflag", true);
            intent.putExtra("extra_status", tX.mStatus);
            intent.putExtra("extra_progress", tX.f2905EV);
            String stringExtra = getIntent().getStringExtra("to_talker_name");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                intent.putExtra("to_talker_name", stringExtra);
            }
        }
        startActivity(intent);
        AppMethodBeat.m2505o(53263);
    }

    /* renamed from: i */
    public final void mo23318i(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(53261);
        this.kYu = new C42945g(str, str2, str3);
        C1720g.m3535RO().eJo.mo14541a(this.kYu, 0);
        AppMethodBeat.m2505o(53261);
    }

    /* renamed from: g */
    static /* synthetic */ void m65984g(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.m2504i(138346);
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(customSmileyPreviewUI.exP.mo20410Aq());
        if (aqi != null) {
            customSmileyPreviewUI.exP = aqi;
        }
        C36356d c36356d = new C36356d(customSmileyPreviewUI, 1, false);
        c36356d.rBl = new C367613();
        c36356d.rBm = new C388914();
        c36356d.cpD();
        AppMethodBeat.m2505o(138346);
    }

    /* renamed from: o */
    static /* synthetic */ void m65992o(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.m2504i(138348);
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        C42935b.gkE.mo38926k(intent, customSmileyPreviewUI);
        C7060h.pYm.mo8381e(12789, Integer.valueOf(1), customSmileyPreviewUI.exP.mo20410Aq(), Integer.valueOf(1), customSmileyPreviewUI.exP.field_designerID, customSmileyPreviewUI.exP.field_groupId, customSmileyPreviewUI.kYP, "", "", "", customSmileyPreviewUI.exP.field_activityid);
        AppMethodBeat.m2505o(138348);
    }

    /* renamed from: p */
    static /* synthetic */ void m65993p(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.m2504i(138349);
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.kYQ);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        if (C5046bo.isNullOrNil(customSmileyPreviewUI.ejD)) {
            intent.putExtra("k_username", customSmileyPreviewUI.kYP);
        } else {
            intent.putExtra("k_username", customSmileyPreviewUI.ejD);
        }
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.kYO);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        C25985d.m41467b((Context) customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(138349);
    }
}
