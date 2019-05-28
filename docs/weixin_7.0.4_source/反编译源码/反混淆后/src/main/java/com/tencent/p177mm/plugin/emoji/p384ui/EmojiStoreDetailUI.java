package com.tencent.p177mm.plugin.emoji.p384ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.p069v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p193c.C32280j;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMAutoSizeTextView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C36724c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C27727e;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p383h.C33952c;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.DonorsAvatarView;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2DesignerUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2RewardDetailUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2RewardUI;
import com.tencent.p177mm.plugin.emoji.p726f.C20373l;
import com.tencent.p177mm.plugin.emoji.p726f.C27738o;
import com.tencent.p177mm.plugin.emoji.p726f.C38881k;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p726f.C42949q;
import com.tencent.p177mm.plugin.emoji.p726f.C45855a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l.C313501;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.model.C23249h;
import com.tencent.p177mm.pluginsdk.model.C23249h.C14889a;
import com.tencent.p177mm.pluginsdk.model.C44064n;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.BannerEmojiView;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.protocal.protobuf.EmotionDetail;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.protocal.protobuf.PackThumbExt;
import com.tencent.p177mm.protocal.protobuf.aik;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.view.p645a.C36374g;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wxmm.v2helper;
import java.math.BigDecimal;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI */
public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, C1202f, C4931a {
    /* renamed from: EV */
    private int f15046EV;
    /* renamed from: Ek */
    private View f15047Ek;
    private int eno;
    private ProgressDialog gqo;
    private ProgressBar kRN;
    private long kVE = 0;
    private String kVF = "";
    private C33952c kVI;
    private String kWA;
    private String kWB;
    private String kWz;
    private EmotionDetail kYH = new EmotionDetail();
    private String kYI = "";
    private int kYp;
    private C4884c kYt = new C277601();
    private boolean laA = false;
    private int laB = -1;
    private C20373l laC;
    private C42945g laD;
    private C27738o laE;
    private C33979a laF;
    private GetEmotionRewardResponse laG = null;
    private boolean laH;
    private TextView laI;
    private View laJ;
    private EmojiDetailScrollView laK;
    private BannerEmojiView laL;
    private TextView laM;
    private MMAutoSizeTextView laN;
    private TextView laO;
    private TextView laP;
    private TextView laQ;
    private EmojiDetailGridView laR;
    private ImageView laS;
    private View laT;
    private TextView laU;
    private TextView laV;
    private int laW;
    private View laX;
    private ProgressBar laY;
    private View laZ;
    private int lax;
    private String lay;
    private boolean laz;
    private OnClickListener lbA = new C3398216();
    private OnClickListener lbB = new C2039717();
    private OnClickListener lbC = new C2775918();
    private C1282i lbD = new C3398320();
    private C32280j lbE = new C3397321();
    private C14889a lbF = new C3397215();
    private ImageView lba;
    private TextView lbb;
    private View lbc;
    private View lbd;
    private TextView lbe;
    private Button lbf;
    private DonorsAvatarView lbg;
    private TextView lbh;
    private int lbi;
    private int lbj;
    private int lbk;
    private String lbl;
    private boolean lbm;
    private int lbn;
    private int lbo = -1;
    private String lbp;
    private String lbq;
    private String lbr;
    private String[] lbs = new String[1];
    private boolean lbt = false;
    private View lbu;
    private boolean lbv = true;
    private aik lbw;
    private boolean lbx = false;
    private boolean lby = true;
    private OnClickListener lbz = new C2775812();
    private Context mContext;
    private C7306ak mHandler = new C750219();
    private int mNumColumns;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$19 */
    class C750219 extends C7306ak {
        C750219() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53436);
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.m55622e(EmojiStoreDetailUI.this);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1002:
                    EmojiStoreDetailUI.m55623f(EmojiStoreDetailUI.this);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1003:
                    EmojiStoreDetailUI.m55624g(EmojiStoreDetailUI.this);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1004:
                    if (EmojiStoreDetailUI.this.laP.getVisibility() == 0) {
                        EmojiStoreDetailUI.this.laP.setVisibility(8);
                        EmojiStoreDetailUI.this.laT.setVisibility(0);
                        EmojiStoreDetailUI.this.laS.setVisibility(0);
                    }
                    EmojiStoreDetailUI.this.kRN.setProgress(EmojiStoreDetailUI.this.f15046EV);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1005:
                    EmojiStoreDetailUI.this.laK.scrollTo(0, 0);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1006:
                    EmojiStoreDetailUI.m55632n(EmojiStoreDetailUI.this);
                    AppMethodBeat.m2505o(53436);
                    return;
                case 1007:
                    EmojiStoreDetailUI.this.blH();
                    AppMethodBeat.m2505o(53436);
                    return;
                default:
                    C4990ab.m7420w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    AppMethodBeat.m2505o(53436);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$10 */
    class C1157310 implements DialogInterface.OnClickListener {
        C1157310() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53428);
            EmojiStoreDetailUI.this.laD = new C42945g(EmojiStoreDetailUI.this.kWz, EmojiStoreDetailUI.this.kWB, EmojiStoreDetailUI.this.kWA);
            EmojiStoreDetailUI.m55608A(EmojiStoreDetailUI.this);
            EmojiStoreDetailUI.this.laB = 6;
            EmojiStoreDetailUI.m55624g(EmojiStoreDetailUI.this);
            AppMethodBeat.m2505o(53428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$17 */
    class C2039717 implements OnClickListener {
        C2039717() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53434);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.kWz);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.kYH.PackName);
            if (!(EmojiStoreDetailUI.this.kYH == null || EmojiStoreDetailUI.this.kYH.PersonalDesigner == null)) {
                intent.putExtra("name", EmojiStoreDetailUI.this.kYH.PersonalDesigner.Name);
            }
            intent.putExtra("scene", EmojiStoreDetailUI.this.lbk);
            intent.putExtra("pageType", 1);
            intent.putExtra("searchID", EmojiStoreDetailUI.this.kVE);
            EmojiStoreDetailUI.this.startActivity(intent);
            C7060h.pYm.mo8381e(12738, EmojiStoreDetailUI.this.kWz, Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.this.lbk), Integer.valueOf(0));
            AppMethodBeat.m2505o(53434);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$22 */
    class C2039822 implements Runnable {
        C2039822() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53439);
            EmojiStoreDetailUI.this.laK.fullScroll(130);
            AppMethodBeat.m2505o(53439);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$2 */
    class C203992 implements OnMenuItemClickListener {
        C203992() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53422);
            EmojiStoreDetailUI.this.finish();
            AppMethodBeat.m2505o(53422);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$7 */
    class C204007 implements OnMenuItemClickListener {
        C204007() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53426);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
            EmojiStoreDetailUI.m55636r(EmojiStoreDetailUI.this);
            AppMethodBeat.m2505o(53426);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$8 */
    class C204018 implements DialogInterface.OnClickListener {
        C204018() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53427);
            if (C2932a.m5216JW(EmojiStoreDetailUI.this.kWz)) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                C45855a.bkq().bks();
            } else {
                C1720g.m3535RO().eJo.mo14547c(EmojiStoreDetailUI.this.laD);
            }
            if (!TextUtils.isEmpty(EmojiStoreDetailUI.this.lbl)) {
                C37461f.afx().mo51228rO(EmojiStoreDetailUI.this.lbl);
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", EmojiStoreDetailUI.this.lbl);
            }
            if (C27727e.m44040dR(EmojiStoreDetailUI.this.kYH.PackFlag, 1) || C27727e.m44042uc(EmojiStoreDetailUI.this.kYH.PackType)) {
                EmojiStoreDetailUI.this.laB = 3;
            } else {
                EmojiStoreDetailUI.this.laB = -1;
            }
            C42952j.bkn().mo35678g(EmojiStoreDetailUI.this.kWz, EmojiStoreDetailUI.this.laB, 0, EmojiStoreDetailUI.this.lbl);
            EmojiStoreDetailUI.this.laT.setVisibility(8);
            EmojiStoreDetailUI.this.kRN.setProgress(0);
            EmojiStoreDetailUI.this.laS.setVisibility(4);
            EmojiStoreDetailUI.this.laP.setVisibility(0);
            EmojiStoreDetailUI.this.lax;
            EmojiStoreDetailUI.m55624g(EmojiStoreDetailUI.this);
            C1720g.m3535RO().eJo.mo14541a(new C42949q(EmojiStoreDetailUI.this.kWz, 2), 0);
            AppMethodBeat.m2505o(53427);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$9 */
    class C204029 implements DialogInterface.OnClickListener {
        C204029() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$11 */
    class C2775711 implements DialogInterface.OnClickListener {
        C2775711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$12 */
    class C2775812 implements OnClickListener {
        C2775812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53429);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + C4988aa.dor());
            String str = EmojiStoreDetailUI.this.getString(C25738R.string.b_q) + C4988aa.dor();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            C25985d.m41467b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(53429);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$18 */
    class C2775918 implements OnClickListener {
        C2775918() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53435);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.kWz);
            intent.putExtra("extra_iconurl", EmojiStoreDetailUI.this.kYH.IconUrl);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.kYH.PackName);
            if (EmojiStoreDetailUI.this.kYH.PersonalDesigner != null) {
                intent.putExtra("name", EmojiStoreDetailUI.this.kYH.PersonalDesigner.Name);
            }
            EmojiStoreDetailUI.this.startActivity(intent);
            AppMethodBeat.m2505o(53435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$1 */
    class C277601 extends C4884c<C18232da> {
        C277601() {
            AppMethodBeat.m2504i(53420);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53420);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53421);
            C18232da c18232da = (C18232da) c4883b;
            if (EmojiStoreDetailUI.this.kWz == null || c18232da.cwf.cwg == null || !c18232da.cwf.cwg.equals(EmojiStoreDetailUI.this.kWz)) {
                AppMethodBeat.m2505o(53421);
            } else {
                EmojiStoreDetailUI.this.mo54515h(c18232da.cwf.cwg, c18232da.cwf.status, c18232da.cwf.progress, c18232da.cwf.cwh);
                AppMethodBeat.m2505o(53421);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$c */
    class C27761c {
        SquareImageView lbI;

        public C27761c(View view) {
            AppMethodBeat.m2504i(53448);
            this.lbI = (SquareImageView) view.findViewById(2131823529);
            this.lbI.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.m2505o(53448);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$15 */
    class C3397215 implements C14889a {
        C3397215() {
        }

        /* renamed from: A */
        public final void mo24138A(ArrayList<C44064n> arrayList) {
            AppMethodBeat.m2504i(53432);
            String str = "MicroMsg.emoji.EmojiStoreDetailUI";
            String str2 = "[onQueryFinish] %s";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            C4990ab.m7417i(str, str2, objArr);
            EmojiStoreDetailUI.this.lbn = 12;
            if (arrayList != null && arrayList.size() > 0) {
                C44064n c44064n = (C44064n) arrayList.get(0);
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", c44064n);
                if (c44064n.vbt == 10232) {
                    EmojiStoreDetailUI.this.laB = 4;
                    EmojiStoreDetailUI.this.lbp = c44064n.vbq;
                    EmojiStoreDetailUI.this.lbq = c44064n.vbr;
                    EmojiStoreDetailUI.this.lbr = new BigDecimal(c44064n.vbs).divide(new BigDecimal(1000000)).toString();
                } else {
                    EmojiStoreDetailUI.this.laB = 10;
                    EmojiStoreDetailUI.this.lbo = c44064n.vbt;
                }
                EmojiStoreDetailUI.this.mo54518uh(1002);
            }
            AppMethodBeat.m2505o(53432);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$21 */
    class C3397321 implements C32280j {
        C3397321() {
        }

        /* renamed from: fN */
        public final void mo33455fN(long j) {
            AppMethodBeat.m2504i(53438);
            C7060h.pYm.mo8374X(10930, EmojiStoreDetailUI.this.kWz + "," + j);
            AppMethodBeat.m2505o(53438);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$13 */
    class C3397413 implements C36073c {
        C3397413() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(53430);
            c44273l.mo70049a(1001, EmojiStoreDetailUI.this.getString(C25738R.string.ba1), (int) C1318a.bottomsheet_icon_transmit);
            c44273l.mo70049a(1000, EmojiStoreDetailUI.this.getString(C25738R.string.ba2), (int) C1318a.bottomsheet_icon_moment);
            AppMethodBeat.m2505o(53430);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$3 */
    class C339753 implements OnItemClickListener {
        C339753() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(53423);
            Object item = adapterView.getAdapter().getItem(i);
            if (item instanceof EmojiInfo) {
                EmojiInfo emojiInfo = (EmojiInfo) item;
                C40588xx c40588xx = new C40588xx();
                if (C5046bo.isNullOrNil(c40588xx.Md5) || c40588xx.Md5.equals(emojiInfo.field_md5)) {
                    c40588xx.Md5 = C2933b.m5224dN(emojiInfo.field_md5, c40588xx.Md5);
                    c40588xx.Url = C2933b.m5224dN(emojiInfo.field_cdnUrl, c40588xx.Url);
                    c40588xx.ThumbUrl = C2933b.m5224dN(emojiInfo.field_thumbUrl, c40588xx.ThumbUrl);
                    c40588xx.wdC = C2933b.m5224dN(emojiInfo.field_designerID, c40588xx.wdC);
                    c40588xx.EncryptUrl = C2933b.m5224dN(emojiInfo.field_encrypturl, c40588xx.EncryptUrl);
                    c40588xx.AesKey = C2933b.m5224dN(emojiInfo.field_aeskey, c40588xx.AesKey);
                    c40588xx.ProductID = C2933b.m5224dN(emojiInfo.field_groupId, c40588xx.ProductID);
                    c40588xx.ExternUrl = C2933b.m5224dN(emojiInfo.field_externUrl, c40588xx.ExternUrl);
                    c40588xx.ExternMd5 = C2933b.m5224dN(emojiInfo.field_externMd5, c40588xx.ExternMd5);
                    c40588xx.ActivityID = C2933b.m5224dN(emojiInfo.field_activityid, c40588xx.ActivityID);
                    c40588xx.wdD = C2933b.m5224dN(emojiInfo.field_attachedText, c40588xx.wdD);
                    c40588xx.wdE = C2933b.m5224dN(emojiInfo.field_attachTextColor, c40588xx.wdE);
                    c40588xx.wdF = C2933b.m5224dN(emojiInfo.field_lensId, c40588xx.wdF);
                }
                EmojiStoreDetailUI.m55615a(EmojiStoreDetailUI.this, c40588xx);
                C7060h.pYm.mo8381e(12787, Integer.valueOf(0), Integer.valueOf(0), emojiInfo.field_md5, Long.valueOf(EmojiStoreDetailUI.this.kVE), emojiInfo.field_designerID, emojiInfo.field_groupId, Integer.valueOf(26));
            }
            AppMethodBeat.m2505o(53423);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$4 */
    class C339764 implements DialogInterface.OnClickListener {
        C339764() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$5 */
    class C339775 implements OnCancelListener {
        C339775() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53424);
            C1720g.m3535RO().eJo.mo14547c(EmojiStoreDetailUI.this.laC);
            EmojiStoreDetailUI.this.laI.setText(C25738R.string.bau);
            EmojiStoreDetailUI.m55635q(EmojiStoreDetailUI.this);
            AppMethodBeat.m2505o(53424);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$6 */
    class C339786 implements OnClickListener {
        C339786() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53425);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this.mController.ylL, EmojiStoreV2DesignerUI.class);
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.this.kYH.PersonalDesigner.DesignerUin);
            intent.putExtra("name", EmojiStoreDetailUI.this.kYH.PersonalDesigner.Name);
            intent.putExtra("headurl", EmojiStoreDetailUI.this.kYH.PersonalDesigner.HeadUrl);
            intent.putExtra("rediret_url", EmojiStoreDetailUI.this.kYH.OldRedirectUrl);
            intent.putExtra("searchID", EmojiStoreDetailUI.this.kVE);
            intent.putExtra("extra_scence", 26);
            EmojiStoreDetailUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(53425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$a */
    class C33979a extends BaseAdapter implements C36374g {
        public int getCount() {
            AppMethodBeat.m2504i(53440);
            if (EmojiStoreDetailUI.this.kYH == null) {
                AppMethodBeat.m2505o(53440);
                return 0;
            }
            int i = EmojiStoreDetailUI.this.kYH.PackThumbCnt;
            AppMethodBeat.m2505o(53440);
            return i;
        }

        public Object getItem(int i) {
            AppMethodBeat.m2504i(53441);
            if (EmojiStoreDetailUI.this.kYH == null || EmojiStoreDetailUI.this.kYH.ThumbExtList == null || EmojiStoreDetailUI.this.kYH.ThumbExtList.size() <= 0 || EmojiStoreDetailUI.this.kYH.ThumbExtList.get(i) == null || ((PackThumbExt) EmojiStoreDetailUI.this.kYH.ThumbExtList.get(i)).PreviewUrl == null) {
                AppMethodBeat.m2505o(53441);
                return null;
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", Integer.valueOf(i));
            PackThumbExt packThumbExt = (PackThumbExt) EmojiStoreDetailUI.this.kYH.ThumbExtList.get(i);
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = packThumbExt.Md5;
            emojiInfo.field_thumbUrl = packThumbExt.ThumbUrl;
            emojiInfo.field_cdnUrl = packThumbExt.CDNUrl;
            emojiInfo.field_aeskey = packThumbExt.AesKey;
            emojiInfo.field_encrypturl = packThumbExt.EncryptUrl;
            emojiInfo.field_externUrl = packThumbExt.ExternUrl;
            emojiInfo.field_externMd5 = packThumbExt.ExternMd5;
            emojiInfo.field_activityid = packThumbExt.ActivityID;
            emojiInfo.field_groupId = EmojiStoreDetailUI.this.kWz;
            emojiInfo.field_catalog = 84;
            emojiInfo.field_reserved4 |= EmojiInfo.zZi;
            AppMethodBeat.m2505o(53441);
            return emojiInfo;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C27761c c27761c;
            AppMethodBeat.m2504i(53442);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(2130969351, null);
                C27761c c27761c2 = new C27761c(view);
                view.setTag(c27761c2);
                c27761c = c27761c2;
            } else {
                c27761c = (C27761c) view.getTag();
            }
            if (EmojiStoreDetailUI.this.laR.Aba) {
                c27761c.lbI.setBackgroundResource(C25738R.drawable.smiley_item_bg2);
            } else {
                c27761c.lbI.setBackgroundDrawable(null);
            }
            String str = "";
            if (EmojiStoreDetailUI.this.kYH.PackThumbList != null) {
                str = C1946aa.m4148a((bts) EmojiStoreDetailUI.this.kYH.PackThumbList.get(i));
            }
            C32291o.ahp().mo43766a(str, c27761c.lbI, C20364g.m31459dH(EmojiStoreDetailUI.this.kWz, str));
            AppMethodBeat.m2505o(53442);
            return view;
        }

        /* renamed from: ui */
        public final boolean mo28409ui(int i) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$b */
    class C33980b extends C33979a {
        private ArrayList<EmojiInfo> lbH;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(53447);
            EmojiInfo uf = m55652uf(i);
            AppMethodBeat.m2505o(53447);
            return uf;
        }

        public C33980b() {
            super();
            AppMethodBeat.m2504i(53443);
            this.lbH = new ArrayList();
            this.lbH = (ArrayList) C42952j.getEmojiStorageMgr().xYn.mo48557Jg(C2932a.bmu());
            AppMethodBeat.m2505o(53443);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(53444);
            if (this.lbH == null) {
                AppMethodBeat.m2505o(53444);
                return 0;
            }
            int size = this.lbH.size();
            AppMethodBeat.m2505o(53444);
            return size;
        }

        /* renamed from: uf */
        private EmojiInfo m55652uf(int i) {
            AppMethodBeat.m2504i(53445);
            if (this.lbH == null) {
                AppMethodBeat.m2505o(53445);
                return null;
            }
            EmojiInfo emojiInfo = (EmojiInfo) this.lbH.get(i);
            AppMethodBeat.m2505o(53445);
            return emojiInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27761c c27761c;
            AppMethodBeat.m2504i(53446);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(2130969351, null);
                c27761c = new C27761c(view);
                view.setTag(c27761c);
            } else {
                c27761c = (C27761c) view.getTag();
            }
            c27761c.lbI.setBackgroundResource(C25738R.drawable.smiley_item_bg2);
            EmojiInfo uf = m55652uf(i);
            C32291o.ahp().mo43766a((C5046bo.isNullOrNil(uf.getContent()) ? uf.getName() : uf.getContent()).split("\\.")[0], c27761c.lbI, C20364g.bjM());
            AppMethodBeat.m2505o(53446);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$14 */
    class C3398114 implements C5279d {
        C3398114() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(53431);
            switch (menuItem.getItemId()) {
                case 1000:
                    C45854l.m84902a(EmojiStoreDetailUI.this.mController.ylL, EmojiStoreDetailUI.this.kYH.PackName + EmojiStoreDetailUI.this.getString(C25738R.string.bc1), EmojiStoreDetailUI.this.kYH.PackDesc, EmojiStoreDetailUI.this.kYH.IconUrl, EmojiStoreDetailUI.this.kYH.OldRedirectUrl, EmojiLogic.m44065Jt(EmojiStoreDetailUI.this.kWz), 4);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.this.kWz, "");
                    break;
                case 1001:
                    C45854l.m84904dE(EmojiStoreDetailUI.this.mController.ylL);
                    EmojiStoreDetailUI.this.mController.ylL.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.this.kWz, "");
                    AppMethodBeat.m2505o(53431);
                    return;
            }
            AppMethodBeat.m2505o(53431);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$16 */
    class C3398216 implements OnClickListener {
        C3398216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53433);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + C4988aa.dor());
            String str = EmojiStoreDetailUI.this.getString(C25738R.string.b9u) + C4988aa.dor();
            Intent intent = new Intent();
            intent.putExtra("title", EmojiStoreDetailUI.this.getString(C25738R.string.bac));
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            C25985d.m41467b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(53433);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI$20 */
    class C3398320 implements C1282i {
        C3398320() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(53437);
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", str);
            if (bitmap != null) {
                EmojiStoreDetailUI.this.mo54518uh(1006);
            }
            AppMethodBeat.m2505o(53437);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreDetailUI() {
        AppMethodBeat.m2504i(53449);
        AppMethodBeat.m2505o(53449);
    }

    /* renamed from: A */
    static /* synthetic */ void m55608A(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53490);
        emojiStoreDetailUI.blP();
        AppMethodBeat.m2505o(53490);
    }

    /* renamed from: f */
    static /* synthetic */ void m55623f(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53484);
        emojiStoreDetailUI.blF();
        AppMethodBeat.m2505o(53484);
    }

    /* renamed from: g */
    static /* synthetic */ void m55624g(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53485);
        emojiStoreDetailUI.blK();
        AppMethodBeat.m2505o(53485);
    }

    /* renamed from: n */
    static /* synthetic */ void m55632n(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53486);
        emojiStoreDetailUI.m55625gp(false);
        AppMethodBeat.m2505o(53486);
    }

    /* renamed from: q */
    static /* synthetic */ void m55635q(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53488);
        emojiStoreDetailUI.blB();
        AppMethodBeat.m2505o(53488);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53450);
        super.onCreate(bundle);
        this.lbm = C1853r.m3830YL();
        this.kVI = new C33952c(2003);
        Intent intent = getIntent();
        this.kWz = getIntent().getStringExtra("extra_id");
        this.kYp = getIntent().getIntExtra("preceding_scence", -1);
        this.kWA = getIntent().getStringExtra("extra_name");
        this.lax = getIntent().getIntExtra("call_by", -1);
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kWz = EmojiLogic.m44062Jl(stringExtra);
            this.kYp = 0;
            this.kYp = 10;
            C7060h.pYm.mo8381e(10993, Integer.valueOf(3), this.kWz);
        }
        if (TextUtils.isEmpty(this.kWz)) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.kYp == -1) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.lbv = intent.getBooleanExtra("check_clickflag", true);
        this.lbl = intent.getStringExtra("cdn_client_id");
        this.lbk = intent.getIntExtra("download_entrance_scene", 0);
        this.kVE = intent.getLongExtra("searchID", 0);
        this.kVF = C5046bo.m7532bc(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.PackCopyright = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.CoverUrl = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.PackDesc = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.PackPrice = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.kYH.PackType = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.kYH.PackFlag = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.PriceType = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kYH.PriceNum = stringExtra;
        }
        if (this.lbm) {
            this.lbn = 11;
            C23249h.m35678a(this, this.lbs, this.lbF);
        }
        this.laz = intent.getBooleanExtra("reward_tip", false);
        this.lbs[0] = this.kWz;
        this.kYH.ProductID = this.kWz;
        this.kYH.PackName = this.kWA;
        this.kYH.ShareDesc = this.lay;
        this.kYH.Version = -1;
        this.mContext = this;
        initView();
        if (C2932a.m5216JW(this.kWz)) {
            AppCompatActivity appCompatActivity = this.mController.ylL;
            EmotionDetail emotionDetail = new EmotionDetail();
            emotionDetail.ProductID = EmojiGroupInfo.yar;
            emotionDetail.PackName = appCompatActivity.getString(C25738R.string.bca);
            emotionDetail.PackDesc = appCompatActivity.getString(C25738R.string.bc9);
            emotionDetail.PackAuthInfo = appCompatActivity.getString(C25738R.string.bc7);
            emotionDetail.PackPrice = "";
            emotionDetail.PackType = 0;
            emotionDetail.PackFlag = 1;
            emotionDetail.CoverUrl = "";
            emotionDetail.PackExpire = 0;
            emotionDetail.PackCopyright = appCompatActivity.getString(C25738R.string.bc8);
            emotionDetail.PanelUrl = "";
            emotionDetail.PriceNum = "";
            emotionDetail.PriceType = "";
            emotionDetail.TimeLimitStr = appCompatActivity.getString(C25738R.string.bc_);
            this.kYH = emotionDetail;
            this.lbx = true;
            this.lbw = EmojiLogic.bkd();
            blE();
        } else {
            if (this.kYH == null) {
                this.laC = new C20373l(this.kWz, this.kYp);
            } else if (C5046bo.isNullOrNil(this.kYI) || !this.kYI.equalsIgnoreCase(C4988aa.m7403gw(this.mContext))) {
                this.laC = new C20373l(this.kWz, this.kYp);
            } else {
                this.laC = new C20373l(this.kWz, this.kYp, this.kYH.Version);
            }
            C1720g.m3535RO().eJo.mo14541a(this.laC, 0);
            if (this.lax == -1 || this.lax == 3) {
                this.laJ.setVisibility(8);
                this.f15047Ek.setVisibility(8);
                getString(C25738R.string.f9238tz);
                this.gqo = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C339775());
            }
            blC();
            if (this.lbv) {
                C1720g.m3535RO().eJo.mo14541a(new C38881k(this.kWz), 0);
            } else {
                this.lbx = true;
                this.lbw = EmojiLogic.bkd();
            }
        }
        blF();
        C42952j.getEmojiStorageMgr().xYo.mo10116c(this);
        C4879a.xxA.mo10052c(this.kYt);
        C1720g.m3535RO().eJo.mo14539a(822, (C1202f) this);
        mo54515h(this.kWz, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.lbl);
        this.lby = true;
        C7060h.pYm.mo8381e(12740, Integer.valueOf(1), "", this.kWz, "", Integer.valueOf(this.lbk), Integer.valueOf(26));
        if (this.laz && this.laK != null) {
            this.mHandler.postDelayed(new C2039822(), 0);
        }
        AppMethodBeat.m2505o(53450);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969349;
    }

    public final void initView() {
        AppMethodBeat.m2504i(53451);
        if (!C5046bo.isNullOrNil(this.kWA)) {
            setMMTitle(this.kWA);
        }
        setBackBtn(new C203992());
        this.eno = C1338a.m2856al(this.mContext, C25738R.dimen.a0c);
        this.lbi = getResources().getDimensionPixelSize(C25738R.dimen.a0b);
        this.lbi = C1338a.m2856al(this.mContext, C25738R.dimen.a0b);
        this.mNumColumns = 4;
        this.laK = (EmojiDetailScrollView) findViewById(2131823117);
        this.f15047Ek = findViewById(2131821749);
        this.laI = (TextView) this.f15047Ek.findViewById(2131823528);
        this.laJ = findViewById(2131823509);
        this.laL = (BannerEmojiView) findViewById(2131823510);
        this.laL.setMinimumHeight((int) (((float) (((this.laL.getRight() - this.laL.getLeft()) - this.laL.getPaddingRight()) - this.laL.getPaddingLeft())) * 0.56f));
        this.laM = (TextView) findViewById(2131823513);
        this.laN = (MMAutoSizeTextView) findViewById(2131823512);
        this.laO = (TextView) findViewById(2131823525);
        this.laP = (TextView) findViewById(2131823515);
        this.laQ = (TextView) findViewById(2131823520);
        this.laW = C1338a.m2868gd(this.mController.ylL);
        this.laX = findViewById(2131823514);
        this.laR = (EmojiDetailGridView) findViewById(2131823522);
        if (C2932a.m5216JW(this.kWz)) {
            this.laF = new C33980b();
        } else {
            this.laF = new C33979a();
        }
        this.laT = findViewById(2131823516);
        this.kRN = (ProgressBar) findViewById(2131823517);
        this.laS = (ImageView) findViewById(2131823518);
        this.laS.setOnClickListener(this);
        this.laT.setVisibility(8);
        this.laS.setVisibility(8);
        this.kRN.setProgress(0);
        this.laR.setAdapter((ListAdapter) this.laF);
        this.laR.setColumnWidth(this.lbi);
        this.laR.setNumColumns(this.mNumColumns);
        this.laR.setHorizontalSpacing(this.eno);
        this.laR.setVerticalSpacing(this.eno);
        this.laR.setEmojiDetailScrollView(this.laK);
        this.laR.setFromDetail(true);
        this.laR.setIsShowPopWin(true);
        this.laR.setOnItemClickListener(new C339753());
        this.laP.setOnClickListener(this);
        this.laU = (TextView) findViewById(2131823526);
        this.laV = (TextView) findViewById(2131823527);
        this.laU.setOnClickListener(this.lbz);
        this.laV.setOnClickListener(this.lbA);
        this.laY = (ProgressBar) findViewById(2131823519);
        this.laY.setVisibility(this.lbm ? 0 : 8);
        this.lbu = findViewById(2131823521);
        this.lbc = findViewById(2131823523);
        this.laZ = findViewById(2131823537);
        this.lba = (ImageView) findViewById(2131823538);
        this.lbb = (TextView) findViewById(2131823539);
        this.lbd = findViewById(2131823524);
        this.lbe = (TextView) findViewById(2131823565);
        this.lbf = (Button) findViewById(2131823566);
        this.lbh = (TextView) findViewById(2131823567);
        this.lbg = (DonorsAvatarView) findViewById(2131823568);
        this.lbf.setOnClickListener(this.lbB);
        this.lbh.setOnClickListener(this.lbC);
        AppMethodBeat.m2505o(53451);
    }

    public void onStart() {
        AppMethodBeat.m2504i(53452);
        super.onStart();
        AppMethodBeat.m2505o(53452);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53453);
        super.onResume();
        C1720g.m3535RO().eJo.mo14539a(412, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) C36724c.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        this.lbt = false;
        if (!this.lby) {
            blC();
            mo54518uh(1007);
        }
        blD();
        this.lby = false;
        mo54518uh(1001);
        AppMethodBeat.m2505o(53453);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53454);
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b(412, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) C36724c.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        AppMethodBeat.m2505o(53454);
    }

    public void onStop() {
        AppMethodBeat.m2504i(53455);
        super.onStop();
        AppMethodBeat.m2505o(53455);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53456);
        super.onDestroy();
        C42952j.getEmojiStorageMgr().xYo.mo10117d(this);
        C4879a.xxA.mo10053d(this.kYt);
        C1720g.m3535RO().eJo.mo14546b(822, (C1202f) this);
        if (this.laR != null) {
            this.laR.release();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(53456);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(53457);
        bundle.putInt("status", this.laB);
        bundle.putInt("progress", this.f15046EV);
        AppMethodBeat.m2505o(53457);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(53458);
        this.laB = bundle.getInt("status");
        this.f15046EV = bundle.getInt("progress");
        AppMethodBeat.m2505o(53458);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(53459);
        int id = view.getId();
        if (id == 2131823515) {
            String stringExtra;
            if (this.laB == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (C5046bo.isNullOrNil(stringExtra) || !this.laA) {
                    this.kVI.mo54501A(this);
                    C7060h.pYm.mo8381e(12069, Integer.valueOf(2), this.kWz);
                } else {
                    C33952c.m55569a(stringExtra, this.kWz, (Activity) this);
                }
                C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                C7060h.pYm.mo8374X(11076, "0, ");
                AppMethodBeat.m2505o(53459);
                return;
            }
            switch (this.laB) {
                case -1:
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    AppMethodBeat.m2505o(53459);
                    return;
                case 0:
                case 3:
                    blP();
                    this.laB = 6;
                    blK();
                    C7060h.pYm.mo8381e(12066, Integer.valueOf(1), Integer.valueOf(this.lbk), "", this.kWz, Long.valueOf(this.kVE), this.kVF);
                    AppMethodBeat.m2505o(53459);
                    return;
                case 4:
                    if (!this.lbt) {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", this.kWz, this.kYH.PackPrice, this.kYH.PriceType);
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.kWz);
                        if (this.lbm) {
                            intent.putExtra("key_currency_type", this.lbq);
                            intent.putExtra("key_price", this.lbq + this.lbr);
                        } else {
                            intent.putExtra("key_currency_type", this.kYH.PriceType);
                            intent.putExtra("key_price", this.kYH.PriceNum);
                        }
                        C25985d.m41468b((Context) this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        C7060h.pYm.mo8381e(12066, Integer.valueOf(2), Integer.valueOf(this.lbk), "", this.kWz, Long.valueOf(this.kVE), this.kVF);
                        this.lbt = true;
                        AppMethodBeat.m2505o(53459);
                        return;
                    }
                    break;
                case 5:
                    this.laB = 3;
                    blK();
                    AppMethodBeat.m2505o(53459);
                    return;
                case 10:
                case 12:
                    switch (this.lbo) {
                        case 10233:
                            stringExtra = getString(C25738R.string.b_i);
                            break;
                        case 10234:
                            stringExtra = getString(C25738R.string.b_a);
                            break;
                        case 10235:
                            stringExtra = getString(C25738R.string.bcw);
                            break;
                        default:
                            stringExtra = getString(C25738R.string.bd1);
                            break;
                    }
                    C30379h.m48461b((Context) this, stringExtra, null, true);
                    AppMethodBeat.m2505o(53459);
                    return;
                case 11:
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    AppMethodBeat.m2505o(53459);
                    return;
                default:
                    C4990ab.m7413e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", Integer.valueOf(this.laB));
                    break;
            }
            AppMethodBeat.m2505o(53459);
        } else if (id == 2131823517) {
            blO();
            AppMethodBeat.m2505o(53459);
        } else if (id == 2131823518) {
            blO();
            AppMethodBeat.m2505o(53459);
        } else {
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
            AppMethodBeat.m2505o(53459);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53460);
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (c1207m.getType()) {
            case 412:
                if (c1207m instanceof C20373l) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                    C20373l c20373l = (C20373l) c1207m;
                    if (c20373l == null || C5046bo.isNullOrNil(c20373l.kWz) || !c20373l.kWz.equalsIgnoreCase(this.kWz)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.m2505o(53460);
                        return;
                    } else if (i == 0) {
                        if (i2 == 0) {
                            this.kYH = c20373l.bkz();
                            mo54518uh(1002);
                            AppMethodBeat.m2505o(53460);
                            return;
                        } else if (i2 == 1) {
                            blA();
                            AppMethodBeat.m2505o(53460);
                            return;
                        } else {
                            this.laI.setText(C25738R.string.bat);
                            blB();
                            AppMethodBeat.m2505o(53460);
                            return;
                        }
                    } else if (i2 == 5) {
                        if (!(c20373l == null || c20373l.bkz() == null)) {
                            this.kYH.PackFlag = c20373l.bkz().PackFlag;
                        }
                        mo54518uh(1002);
                        AppMethodBeat.m2505o(53460);
                        return;
                    } else if (i2 == 1) {
                        blA();
                        AppMethodBeat.m2505o(53460);
                        return;
                    } else {
                        this.laK.setVisibility(8);
                        this.f15047Ek.setVisibility(0);
                        this.laI.setText(C25738R.string.bau);
                        blB();
                        AppMethodBeat.m2505o(53460);
                        return;
                    }
                }
                break;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (c1207m instanceof C42945g) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                    C42945g c42945g = (C42945g) c1207m;
                    if (c42945g == null || C5046bo.isNullOrNil(c42945g.kWz) || !c42945g.kWz.equalsIgnoreCase(this.kWz)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.m2505o(53460);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        this.lbl = c42945g.fFa;
                        this.laB = 6;
                        blK();
                        AppMethodBeat.m2505o(53460);
                        return;
                    } else {
                        this.laB = -1;
                        blK();
                        String str2 = this.kWA;
                        C30379h.m48440a((Context) this, String.format(getString(C25738R.string.baj), new Object[]{str2}), "", new C1157310(), new C2775711());
                        AppMethodBeat.m2505o(53460);
                        return;
                    }
                }
                break;
            case C36724c.CTRL_INDEX /*521*/:
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                C38881k c38881k = (C38881k) c1207m;
                if (c38881k == null || C5046bo.isNullOrNil(c38881k.kWl) || !c38881k.kWl.equalsIgnoreCase(this.kWz)) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.lbw = (aik) c38881k.ehh.fsH.fsP;
                    } else {
                        this.lbw = null;
                    }
                    this.lbx = true;
                    blL();
                }
                this.lbx = true;
                blL();
                AppMethodBeat.m2505o(53460);
                return;
            case 822:
                if (c1207m instanceof C27738o) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                    if (i == 0 && i2 == 0) {
                        this.laG = ((C27738o) c1207m).bkD();
                        mo54518uh(1007);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(53460);
    }

    private void blA() {
        AppMethodBeat.m2504i(53461);
        this.f15047Ek.setVisibility(0);
        this.laJ.setVisibility(8);
        this.laK.setVisibility(8);
        this.laI.setText(C25738R.string.b_h);
        AppMethodBeat.m2505o(53461);
    }

    private void blB() {
        AppMethodBeat.m2504i(53462);
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.kYH == null || this.kYH.PackFlag == 0) {
            this.f15047Ek.setVisibility(0);
            this.laJ.setVisibility(8);
        }
        AppMethodBeat.m2505o(53462);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53463);
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        String str;
        if (i == 2001) {
            str = "";
            int i3 = 0;
            if (intent != null) {
                i3 = intent.getIntExtra("key_err_code", 0);
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(i3)));
                str = intent.getStringExtra("key_err_msg");
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
            }
            this.lbt = false;
            if (i2 != -1) {
                this.laB = -1;
                blK();
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 6, 1, false);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                C7060h.pYm.mo8378a(166, 2, 1, false);
                AppMethodBeat.m2505o(53463);
                return;
            } else if (intent != null && i3 == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.kWz)) {
                    this.laB = -1;
                    blK();
                    m55610JD(str);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= stringArrayListExtra.size()) {
                        break;
                    }
                    if (this.kWz.equals(stringArrayListExtra.get(i4))) {
                        this.kWB = (String) stringArrayListExtra2.get(i4);
                    }
                    i3 = i4 + 1;
                }
                this.kYH.PackFlag = 1;
                blP();
                this.laB = 6;
                C30379h.m48465bQ(this, str);
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 4, 1, false);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                C7060h.pYm.mo8378a(166, 0, 1, false);
                AppMethodBeat.m2505o(53463);
                return;
            } else if (intent != null && i3 == 100000002) {
                blP();
                this.laB = 6;
                this.laF.notifyDataSetChanged();
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 7, 1, false);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                C7060h.pYm.mo8378a(166, 3, 1, false);
                AppMethodBeat.m2505o(53463);
                return;
            } else if (intent == null || i3 != 1) {
                this.laB = -1;
                blK();
                m55610JD(str);
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 5, 1, false);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                C7060h.pYm.mo8378a(166, 1, 1, false);
                AppMethodBeat.m2505o(53463);
                return;
            } else {
                this.laB = -1;
                blK();
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 6, 1, false);
                    AppMethodBeat.m2505o(53463);
                    return;
                }
                C7060h.pYm.mo8378a(166, 2, 1, false);
                AppMethodBeat.m2505o(53463);
                return;
            }
        }
        if (i == 2002) {
            if (i2 == -1) {
                str = intent.getStringExtra("Select_Conv_User");
                if (!C5046bo.isNullOrNil(str)) {
                    C4990ab.m7410d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(str)));
                    String str2 = this.kWz;
                    String str3 = this.kYH.PackName;
                    String str4 = this.kYH.PackDesc;
                    String str5 = this.kYH.IconUrl;
                    String str6 = this.kYH.OldRedirectUrl;
                    int i5 = this.kYH.PackFlag;
                    C40437i c40437i = (C40437i) C1720g.m3528K(C40437i.class);
                    c40437i.mo56646a((Context) this, str, getResources().getString(C25738R.string.f9102pj) + str3, getString(C25738R.string.f9221tf), getString(C25738R.string.atc), str5, (C30111a) new C313501(str, str2, str3, str4, str5, str6, i5, this));
                }
                AppMethodBeat.m2505o(53463);
                return;
            }
        } else if (i == this.kVI.iGJ) {
            if (i2 == -1) {
                Intent intent2 = intent;
                C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", intent2.getStringExtra("Select_Conv_User"));
                C33952c.m55568a(intent, this.kWz, (Activity) this);
                C7060h.pYm.mo8381e(12069, Integer.valueOf(3), this.kWz);
                AppMethodBeat.m2505o(53463);
                return;
            }
        } else if (i == 2004 && i2 == -1) {
            C5670b.m8523i(this, this.mController.ylL.getString(C25738R.string.f9223ti));
        }
        AppMethodBeat.m2505o(53463);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(53464);
        mo54518uh(1001);
        AppMethodBeat.m2505o(53464);
    }

    /* renamed from: JD */
    private void m55610JD(String str) {
        AppMethodBeat.m2504i(53465);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.b_o);
        }
        C30379h.m48438a((Context) this, str, "", new C339764());
        AppMethodBeat.m2505o(53465);
    }

    private void blC() {
        AppMethodBeat.m2504i(53466);
        this.laG = C42952j.getEmojiStorageMgr().xYs.aqq(this.kWz);
        AppMethodBeat.m2505o(53466);
    }

    private void blD() {
        AppMethodBeat.m2504i(53467);
        if (C27727e.m44040dR(this.kYH.PackFlag, 64) && C26072e.m41615OJ()) {
            this.laE = new C27738o(this.kWz, C27738o.kWX);
            C1720g.m3535RO().eJo.mo14541a(this.laE, 0);
        }
        AppMethodBeat.m2505o(53467);
    }

    private boolean blE() {
        AppMethodBeat.m2504i(53468);
        boolean blE = C2932a.blE();
        this.laH = blE;
        this.laB = blE ? 7 : 3;
        AppMethodBeat.m2505o(53468);
        return blE;
    }

    private void blF() {
        AppMethodBeat.m2504i(53469);
        if (!C5046bo.isNullOrNil(this.kYH.PackName)) {
            setMMTitle(this.kYH.PackName);
        }
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", this.kYH.PanelUrl);
        this.laJ.setVisibility(0);
        this.f15047Ek.setVisibility(8);
        m55625gp(true);
        this.laN.setText(this.kYH.PackName);
        this.laO.setText(this.kYH.PackCopyright);
        this.laQ.setText(this.kYH.PackDesc);
        if (C27727e.m44040dR(this.kYH.PackType, 1)) {
            this.laM.setVisibility(8);
        } else {
            this.laM.setVisibility(0);
            this.laM.setText(C25738R.string.bd0);
        }
        blJ();
        blK();
        blL();
        blM();
        blN();
        this.laN.setMaxWidth((((this.laW - this.laX.getWidth()) - (C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9979m4) * 2)) - this.laM.getWidth()) - (C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9957ld) * 2));
        this.laN.setVisibility(8);
        this.laN.setVisibility(0);
        blG();
        blI();
        blH();
        AppMethodBeat.m2505o(53469);
    }

    /* renamed from: gp */
    private void m55625gp(boolean z) {
        AppMethodBeat.m2504i(53470);
        EmojiInfo emojiInfo = null;
        if (!C5046bo.isNullOrNil(this.kYH.CoverUrl)) {
            String str;
            if (z) {
                str = this.kWz;
                String str2 = this.kYH.CoverUrl;
                C1338a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.m44074a(str, str2, this.lbD);
            } else {
                str = this.kWz;
                String str3 = this.kYH.CoverUrl;
                C1338a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.m44081r(str, 4, str3);
            }
        }
        if (!(emojiInfo == null || this.laL == null)) {
            this.laL.setImageFilePath(emojiInfo.dve());
        }
        if (C2932a.m5216JW(this.kWz)) {
            this.laL.setImageResource(C25738R.drawable.aq6);
        }
        AppMethodBeat.m2505o(53470);
    }

    private void blG() {
        AppMethodBeat.m2504i(53471);
        if (this.kYH.PersonalDesigner == null || this.kYH.PersonalDesigner.DesignerUin == 0 || this.lbk == 6) {
            this.lbc.setVisibility(8);
            this.laZ.setVisibility(8);
            AppMethodBeat.m2505o(53471);
            return;
        }
        this.lbc.setVisibility(0);
        this.laZ.setVisibility(0);
        C32291o.ahp().mo43766a(this.kYH.PersonalDesigner.HeadUrl, this.lba, C20364g.m31460dI(this.kWz, this.kYH.PersonalDesigner.HeadUrl));
        this.lbb.setText(this.kYH.PersonalDesigner.Name);
        this.laZ.setOnClickListener(new C339786());
        AppMethodBeat.m2505o(53471);
    }

    public final void blH() {
        AppMethodBeat.m2504i(53472);
        if (!C27727e.m44040dR(this.kYH.PackFlag, 64) || !C26072e.m41615OJ()) {
            this.lbd.setVisibility(8);
            AppMethodBeat.m2505o(53472);
        } else if (this.laG != null) {
            this.lbd.setVisibility(0);
            this.lbf.setText(C25738R.string.bbe);
            this.lbe.setText(this.laG.Reward.wea);
            this.lbe.setLongClickable(false);
            if (this.laG.DonorNum > 0) {
                this.lbh.setVisibility(0);
                String valueOf = String.valueOf(this.laG.DonorNum);
                String format = String.format(getString(C25738R.string.bbi), new Object[]{Integer.valueOf(this.laG.DonorNum)});
                SpannableString spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C25738R.color.f11959n6)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.lbh.setText(spannableString);
            } else {
                this.lbh.setVisibility(8);
            }
            if (this.laG.Donors == null || this.laG.Donors.size() <= 0) {
                this.lbg.setVisibility(8);
                AppMethodBeat.m2505o(53472);
                return;
            }
            this.lbg.setVisibility(0);
            this.lbg.mo54529c(this.kWz, this.laG.Donors);
            AppMethodBeat.m2505o(53472);
        } else {
            this.lbd.setVisibility(8);
            blD();
            AppMethodBeat.m2505o(53472);
        }
    }

    private void blI() {
        AppMethodBeat.m2504i(53473);
        LayoutParams layoutParams;
        if ((this.kYH.PackFlag & 32) == 32) {
            layoutParams = (LayoutParams) this.laV.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.laU.getLayoutParams();
            this.laV.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9979m4);
            this.laV.setLayoutParams(layoutParams);
            this.laV.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9979m4);
            this.laU.setLayoutParams(layoutParams2);
            this.laU.setGravity(5);
            AppMethodBeat.m2505o(53473);
            return;
        }
        layoutParams = (LayoutParams) this.laU.getLayoutParams();
        layoutParams.gravity = 17;
        this.laU.setLayoutParams(layoutParams);
        this.laU.setGravity(17);
        this.laV.setVisibility(8);
        AppMethodBeat.m2505o(53473);
    }

    private void blJ() {
        AppMethodBeat.m2504i(53474);
        if (C27727e.m44040dR(this.kYH.PackType, 8)) {
            this.lbj = 0;
        } else if (C27727e.m44040dR(this.kYH.PackType, 4)) {
            this.lbj = 0;
        } else if (this.lbm || !TextUtils.isEmpty(this.kYH.PackPrice)) {
            this.lbj = 1;
        } else {
            this.lbj = 0;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", Integer.valueOf(this.kYH.PackFlag));
        if (C27727e.m44040dR(this.kYH.PackFlag, 8) && C27727e.m44042uc(this.kYH.PackType)) {
            this.laB = 8;
        } else if (C27727e.m44040dR(this.kYH.PackFlag, 1) || C27727e.m44040dR(this.kYH.PackType, 8)) {
            this.laB = 3;
        } else if (C27727e.m44042uc(this.kYH.PackType)) {
            this.laB = 0;
        } else if (!this.lbm && (TextUtils.isEmpty(this.kYH.PriceNum) || this.kYH.PriceNum.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            this.laB = 0;
        } else if (!this.lbm) {
            this.laB = 4;
        } else if (TextUtils.isEmpty(this.lbp)) {
            this.laB = this.lbn;
        } else {
            this.laB = 4;
        }
        if (this.laH) {
            this.laB = 7;
        }
        AppMethodBeat.m2505o(53474);
    }

    /* JADX WARNING: Missing block: B:7:0x0030, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(53475);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void blK() {
        AppMethodBeat.m2504i(53475);
        while (true) {
            if (C2932a.m5216JW(this.kWz)) {
                blE();
            }
            switch (this.laB) {
                case -1:
                    blJ();
                case 0:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(C25738R.color.a8m));
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setText(C25738R.string.bai);
                    this.laP.setEnabled(true);
                    AppMethodBeat.m2505o(53475);
                    return;
                case 3:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(C25738R.color.a8m));
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setText(C25738R.string.bai);
                    this.laP.setEnabled(true);
                    AppMethodBeat.m2505o(53475);
                    return;
                case 4:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(C25738R.color.a8m));
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setEnabled(true);
                    if (!this.lbm) {
                        this.laP.setText(this.kYH.PackPrice);
                        this.laB = 4;
                        AppMethodBeat.m2505o(53475);
                        return;
                    } else if (C5046bo.isNullOrNil(this.lbp)) {
                        this.laP.setText("");
                        AppMethodBeat.m2505o(53475);
                        return;
                    } else {
                        this.laP.setText(this.lbp);
                        AppMethodBeat.m2505o(53475);
                        return;
                    }
                case 5:
                    this.laY.setVisibility(8);
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setText(C25738R.string.bai);
                    this.laP.setEnabled(true);
                    break;
                case 6:
                    this.laY.setVisibility(8);
                    this.laP.setEnabled(false);
                    this.laT.setVisibility(0);
                    this.laS.setVisibility(0);
                    this.laP.setVisibility(4);
                    if (this.lax != 3) {
                        AppMethodBeat.m2505o(53475);
                        return;
                    }
                    break;
                case 7:
                    this.laY.setVisibility(8);
                    this.laP.setVisibility(0);
                    this.laP.setEnabled(true);
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setText(C25738R.string.bcd);
                    this.laT.setVisibility(8);
                    this.kRN.setProgress(0);
                    this.laS.setVisibility(4);
                    if (this.lax != 3) {
                        AppMethodBeat.m2505o(53475);
                        return;
                    }
                    break;
                case 8:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(C25738R.color.f11951mw));
                    this.laP.setBackgroundResource(C25738R.drawable.f6489fu);
                    this.laP.setText(C25738R.string.bal);
                    this.laP.setEnabled(false);
                    AppMethodBeat.m2505o(53475);
                    return;
                case 10:
                case 12:
                    this.laY.setVisibility(8);
                    this.laP.setVisibility(0);
                    this.laP.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.laP.setText(C25738R.string.bb6);
                    this.laP.setEnabled(true);
                    this.laT.setVisibility(8);
                    this.kRN.setProgress(0);
                    this.laS.setVisibility(4);
                    AppMethodBeat.m2505o(53475);
                    return;
                case 11:
                    break;
                default:
                    C4990ab.m7421w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", Integer.valueOf(this.laB));
                    break;
            }
        }
        this.laY.setVisibility(0);
        this.laP.setVisibility(0);
        this.laP.setBackgroundResource(C25738R.drawable.as_);
        this.laP.setText("");
        this.laP.setEnabled(false);
        this.laT.setVisibility(8);
        this.kRN.setProgress(0);
        this.laS.setVisibility(4);
        AppMethodBeat.m2505o(53475);
    }

    private void blL() {
        AppMethodBeat.m2504i(53476);
        if (this.lbx && ((this.lbw == null || (this.lbw.wox & 1) != 1) && !((this.kYH != null && C27727e.m44040dR(this.kYH.PackFlag, 1)) || this.lbw == null || TextUtils.isEmpty(this.lbw.wow)))) {
            this.laP.setText(this.lbw.wow);
            this.laP.setTextColor(this.mController.ylL.getResources().getColor(C25738R.color.f12084rr));
            this.laP.setBackgroundDrawable(null);
            this.laP.setEnabled(false);
        }
        AppMethodBeat.m2505o(53476);
    }

    private void blM() {
        AppMethodBeat.m2504i(53477);
        if (C2932a.m5216JW(this.kWz) || !(this.kYH.ThumbExtList == null || this.kYH.ThumbExtList.size() <= 0 || ((PackThumbExt) this.kYH.ThumbExtList.get(0)).PreviewUrl == null)) {
            this.lbu.setVisibility(0);
        } else {
            this.lbu.setVisibility(8);
        }
        this.laR.setProductId(this.kWz);
        if (this.laF != null) {
            this.laF.notifyDataSetInvalidated();
        }
        AppMethodBeat.m2505o(53477);
    }

    private void blN() {
        AppMethodBeat.m2504i(53478);
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", this.kYH.PackFlag);
        if ((this.kYH.PackFlag & 16) == 16) {
            addIconOptionMenu(0, C1318a.ofm_send_icon, new C204007());
        }
        AppMethodBeat.m2505o(53478);
    }

    private void blO() {
        AppMethodBeat.m2504i(53479);
        C30379h.m48428a((Context) this, (int) C25738R.string.baa, 0, (int) C25738R.string.bc2, (int) C25738R.string.bad, new C204018(), new C204029());
        AppMethodBeat.m2505o(53479);
    }

    /* renamed from: h */
    public final void mo54515h(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(53480);
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (C5046bo.isNullOrNil(str) || !str.equals(this.kWz)) {
            AppMethodBeat.m2505o(53480);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.lbl = str2;
        }
        if (i == -1) {
            if (this.laB != -1) {
                this.laB = -1;
                mo54518uh(1003);
                AppMethodBeat.m2505o(53480);
                return;
            }
        } else if (i == 7) {
            this.laB = 7;
            mo54518uh(1003);
            AppMethodBeat.m2505o(53480);
            return;
        } else if (i != 6) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
        } else if (!TextUtils.isEmpty(str) && str.equals(this.kWz)) {
            this.laB = 6;
            this.f15046EV = i2;
            mo54518uh(1004);
            AppMethodBeat.m2505o(53480);
            return;
        }
        AppMethodBeat.m2505o(53480);
    }

    private void blP() {
        AppMethodBeat.m2504i(53481);
        if (C2932a.m5216JW(this.kWz)) {
            C45855a.bkq();
            C45855a.bkr();
            AppMethodBeat.m2505o(53481);
            return;
        }
        this.laD = new C42945g(this.kWz, this.kWB, this.kWA);
        C1720g.m3535RO().eJo.mo14541a(this.laD, 0);
        switch (this.kYp) {
            case 9:
                C7060h.pYm.mo8381e(11598, Integer.valueOf(2), this.kWz);
                break;
            case 10:
                C7060h.pYm.mo8381e(11598, Integer.valueOf(1), this.kWz);
                AppMethodBeat.m2505o(53481);
                return;
            case 11:
                C7060h.pYm.mo8381e(11598, Integer.valueOf(3), this.kWz);
                AppMethodBeat.m2505o(53481);
                return;
        }
        AppMethodBeat.m2505o(53481);
    }

    /* renamed from: uh */
    public final void mo54518uh(int i) {
        AppMethodBeat.m2504i(53482);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
        AppMethodBeat.m2505o(53482);
    }

    /* renamed from: e */
    static /* synthetic */ void m55622e(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53483);
        if (!C2932a.m5216JW(emojiStoreDetailUI.kWz)) {
            if (C1720g.m3536RP().isSDCardAvailable() && C42952j.getEmojiStorageMgr().xYo.aqc(emojiStoreDetailUI.kWz)) {
                if (C42952j.getEmojiStorageMgr().xYn.mo48558Jp(emojiStoreDetailUI.kWz) > 0) {
                    C5728b c5728b = new C5728b(C2933b.m5221Yb() + emojiStoreDetailUI.kWz);
                    if (c5728b.exists()) {
                        C5728b[] dMF = c5728b.dMF();
                        if (dMF == null || dMF.length <= 0) {
                            C42952j.getEmojiStorageMgr().xYo.aqd(emojiStoreDetailUI.kWz);
                            C42952j.getEmojiStorageMgr().xYn.aqm(emojiStoreDetailUI.kWz);
                        } else {
                            emojiStoreDetailUI.laH = true;
                            emojiStoreDetailUI.laB = 7;
                            emojiStoreDetailUI.blK();
                            AppMethodBeat.m2505o(53483);
                            return;
                        }
                    }
                }
                C42952j.getEmojiStorageMgr().xYn.aqm(emojiStoreDetailUI.kWz);
            }
            emojiStoreDetailUI.laH = false;
        }
        AppMethodBeat.m2505o(53483);
    }

    /* renamed from: r */
    static /* synthetic */ void m55636r(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.m2504i(53489);
        C36356d c36356d = new C36356d(emojiStoreDetailUI.mContext, 1, false);
        c36356d.rBl = new C3397413();
        c36356d.rBm = new C3398114();
        c36356d.cpD();
        C7060h.pYm.mo8381e(13224, Integer.valueOf(0), Integer.valueOf(0), "", "");
        AppMethodBeat.m2505o(53489);
    }
}
