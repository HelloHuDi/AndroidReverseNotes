package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.da;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wxmm.v2helper;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, f, com.tencent.mm.sdk.e.k.a {
    private int EV;
    private View Ek;
    private int eno;
    private ProgressDialog gqo;
    private ProgressBar kRN;
    private long kVE = 0;
    private String kVF = "";
    private com.tencent.mm.plugin.emoji.h.c kVI;
    private String kWA;
    private String kWB;
    private String kWz;
    private EmotionDetail kYH = new EmotionDetail();
    private String kYI = "";
    private int kYp;
    private com.tencent.mm.sdk.b.c kYt = new com.tencent.mm.sdk.b.c<da>() {
        {
            AppMethodBeat.i(53420);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53420);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53421);
            da daVar = (da) bVar;
            if (EmojiStoreDetailUI.this.kWz == null || daVar.cwf.cwg == null || !daVar.cwf.cwg.equals(EmojiStoreDetailUI.this.kWz)) {
                AppMethodBeat.o(53421);
            } else {
                EmojiStoreDetailUI.this.h(daVar.cwf.cwg, daVar.cwf.status, daVar.cwf.progress, daVar.cwf.cwh);
                AppMethodBeat.o(53421);
            }
            return false;
        }
    };
    private boolean laA = false;
    private int laB = -1;
    private l laC;
    private g laD;
    private o laE;
    private a laF;
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
    private OnClickListener lbA = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53433);
            ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + aa.dor());
            String str = EmojiStoreDetailUI.this.getString(R.string.b9u) + aa.dor();
            Intent intent = new Intent();
            intent.putExtra("title", EmojiStoreDetailUI.this.getString(R.string.bac));
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.o(53433);
        }
    };
    private OnClickListener lbB = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53434);
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
            h.pYm.e(12738, EmojiStoreDetailUI.this.kWz, Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.this.lbk), Integer.valueOf(0));
            AppMethodBeat.o(53434);
        }
    };
    private OnClickListener lbC = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53435);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.kWz);
            intent.putExtra("extra_iconurl", EmojiStoreDetailUI.this.kYH.IconUrl);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.kYH.PackName);
            if (EmojiStoreDetailUI.this.kYH.PersonalDesigner != null) {
                intent.putExtra("name", EmojiStoreDetailUI.this.kYH.PersonalDesigner.Name);
            }
            EmojiStoreDetailUI.this.startActivity(intent);
            AppMethodBeat.o(53435);
        }
    };
    private i lbD = new i() {
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(53437);
            ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", str);
            if (bitmap != null) {
                EmojiStoreDetailUI.this.uh(1006);
            }
            AppMethodBeat.o(53437);
        }
    };
    private j lbE = new j() {
        public final void fN(long j) {
            AppMethodBeat.i(53438);
            h.pYm.X(10930, EmojiStoreDetailUI.this.kWz + "," + j);
            AppMethodBeat.o(53438);
        }
    };
    private com.tencent.mm.pluginsdk.model.h.a lbF = new com.tencent.mm.pluginsdk.model.h.a() {
        public final void A(ArrayList<n> arrayList) {
            AppMethodBeat.i(53432);
            String str = "MicroMsg.emoji.EmojiStoreDetailUI";
            String str2 = "[onQueryFinish] %s";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            ab.i(str, str2, objArr);
            EmojiStoreDetailUI.this.lbn = 12;
            if (arrayList != null && arrayList.size() > 0) {
                n nVar = (n) arrayList.get(0);
                ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", nVar);
                if (nVar.vbt == 10232) {
                    EmojiStoreDetailUI.this.laB = 4;
                    EmojiStoreDetailUI.this.lbp = nVar.vbq;
                    EmojiStoreDetailUI.this.lbq = nVar.vbr;
                    EmojiStoreDetailUI.this.lbr = new BigDecimal(nVar.vbs).divide(new BigDecimal(1000000)).toString();
                } else {
                    EmojiStoreDetailUI.this.laB = 10;
                    EmojiStoreDetailUI.this.lbo = nVar.vbt;
                }
                EmojiStoreDetailUI.this.uh(1002);
            }
            AppMethodBeat.o(53432);
        }
    };
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
    private OnClickListener lbz = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53429);
            ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + aa.dor());
            String str = EmojiStoreDetailUI.this.getString(R.string.b_q) + aa.dor();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            AppMethodBeat.o(53429);
        }
    };
    private Context mContext;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53436);
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(53436);
                    return;
                case 1002:
                    EmojiStoreDetailUI.f(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(53436);
                    return;
                case 1003:
                    EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(53436);
                    return;
                case 1004:
                    if (EmojiStoreDetailUI.this.laP.getVisibility() == 0) {
                        EmojiStoreDetailUI.this.laP.setVisibility(8);
                        EmojiStoreDetailUI.this.laT.setVisibility(0);
                        EmojiStoreDetailUI.this.laS.setVisibility(0);
                    }
                    EmojiStoreDetailUI.this.kRN.setProgress(EmojiStoreDetailUI.this.EV);
                    AppMethodBeat.o(53436);
                    return;
                case 1005:
                    EmojiStoreDetailUI.this.laK.scrollTo(0, 0);
                    AppMethodBeat.o(53436);
                    return;
                case 1006:
                    EmojiStoreDetailUI.n(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(53436);
                    return;
                case 1007:
                    EmojiStoreDetailUI.this.blH();
                    AppMethodBeat.o(53436);
                    return;
                default:
                    ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    AppMethodBeat.o(53436);
                    return;
            }
        }
    };
    private int mNumColumns;

    class c {
        SquareImageView lbI;

        public c(View view) {
            AppMethodBeat.i(53448);
            this.lbI = (SquareImageView) view.findViewById(R.id.bfo);
            this.lbI.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.o(53448);
        }
    }

    class a extends BaseAdapter implements com.tencent.mm.view.a.g {
        public int getCount() {
            AppMethodBeat.i(53440);
            if (EmojiStoreDetailUI.this.kYH == null) {
                AppMethodBeat.o(53440);
                return 0;
            }
            int i = EmojiStoreDetailUI.this.kYH.PackThumbCnt;
            AppMethodBeat.o(53440);
            return i;
        }

        public Object getItem(int i) {
            AppMethodBeat.i(53441);
            if (EmojiStoreDetailUI.this.kYH == null || EmojiStoreDetailUI.this.kYH.ThumbExtList == null || EmojiStoreDetailUI.this.kYH.ThumbExtList.size() <= 0 || EmojiStoreDetailUI.this.kYH.ThumbExtList.get(i) == null || ((PackThumbExt) EmojiStoreDetailUI.this.kYH.ThumbExtList.get(i)).PreviewUrl == null) {
                AppMethodBeat.o(53441);
                return null;
            }
            ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", Integer.valueOf(i));
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
            AppMethodBeat.o(53441);
            return emojiInfo;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(53442);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.layout.u7, null);
                c cVar2 = new c(view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (EmojiStoreDetailUI.this.laR.Aba) {
                cVar.lbI.setBackgroundResource(R.drawable.smiley_item_bg2);
            } else {
                cVar.lbI.setBackgroundDrawable(null);
            }
            String str = "";
            if (EmojiStoreDetailUI.this.kYH.PackThumbList != null) {
                str = com.tencent.mm.platformtools.aa.a((bts) EmojiStoreDetailUI.this.kYH.PackThumbList.get(i));
            }
            com.tencent.mm.at.o.ahp().a(str, cVar.lbI, com.tencent.mm.plugin.emoji.e.g.dH(EmojiStoreDetailUI.this.kWz, str));
            AppMethodBeat.o(53442);
            return view;
        }

        public final boolean ui(int i) {
            return true;
        }
    }

    class b extends a {
        private ArrayList<EmojiInfo> lbH;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(53447);
            EmojiInfo uf = uf(i);
            AppMethodBeat.o(53447);
            return uf;
        }

        public b() {
            super();
            AppMethodBeat.i(53443);
            this.lbH = new ArrayList();
            this.lbH = (ArrayList) com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.Jg(com.tencent.mm.plugin.emoji.h.a.bmu());
            AppMethodBeat.o(53443);
        }

        public final int getCount() {
            AppMethodBeat.i(53444);
            if (this.lbH == null) {
                AppMethodBeat.o(53444);
                return 0;
            }
            int size = this.lbH.size();
            AppMethodBeat.o(53444);
            return size;
        }

        private EmojiInfo uf(int i) {
            AppMethodBeat.i(53445);
            if (this.lbH == null) {
                AppMethodBeat.o(53445);
                return null;
            }
            EmojiInfo emojiInfo = (EmojiInfo) this.lbH.get(i);
            AppMethodBeat.o(53445);
            return emojiInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(53446);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.layout.u7, null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.lbI.setBackgroundResource(R.drawable.smiley_item_bg2);
            EmojiInfo uf = uf(i);
            com.tencent.mm.at.o.ahp().a((bo.isNullOrNil(uf.getContent()) ? uf.getName() : uf.getContent()).split("\\.")[0], cVar.lbI, com.tencent.mm.plugin.emoji.e.g.bjM());
            AppMethodBeat.o(53446);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreDetailUI() {
        AppMethodBeat.i(53449);
        AppMethodBeat.o(53449);
    }

    static /* synthetic */ void A(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53490);
        emojiStoreDetailUI.blP();
        AppMethodBeat.o(53490);
    }

    static /* synthetic */ void f(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53484);
        emojiStoreDetailUI.blF();
        AppMethodBeat.o(53484);
    }

    static /* synthetic */ void g(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53485);
        emojiStoreDetailUI.blK();
        AppMethodBeat.o(53485);
    }

    static /* synthetic */ void n(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53486);
        emojiStoreDetailUI.gp(false);
        AppMethodBeat.o(53486);
    }

    static /* synthetic */ void q(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53488);
        emojiStoreDetailUI.blB();
        AppMethodBeat.o(53488);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53450);
        super.onCreate(bundle);
        this.lbm = r.YL();
        this.kVI = new com.tencent.mm.plugin.emoji.h.c(2003);
        Intent intent = getIntent();
        this.kWz = getIntent().getStringExtra("extra_id");
        this.kYp = getIntent().getIntExtra("preceding_scence", -1);
        this.kWA = getIntent().getStringExtra("extra_name");
        this.lax = getIntent().getIntExtra("call_by", -1);
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kWz = EmojiLogic.Jl(stringExtra);
            this.kYp = 0;
            this.kYp = 10;
            h.pYm.e(10993, Integer.valueOf(3), this.kWz);
        }
        if (TextUtils.isEmpty(this.kWz)) {
            ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.kYp == -1) {
            ab.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.lbv = intent.getBooleanExtra("check_clickflag", true);
        this.lbl = intent.getStringExtra("cdn_client_id");
        this.lbk = intent.getIntExtra("download_entrance_scene", 0);
        this.kVE = intent.getLongExtra("searchID", 0);
        this.kVF = bo.bc(intent.getStringExtra("docID"), "");
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
            com.tencent.mm.pluginsdk.model.h.a(this, this.lbs, this.lbF);
        }
        this.laz = intent.getBooleanExtra("reward_tip", false);
        this.lbs[0] = this.kWz;
        this.kYH.ProductID = this.kWz;
        this.kYH.PackName = this.kWA;
        this.kYH.ShareDesc = this.lay;
        this.kYH.Version = -1;
        this.mContext = this;
        initView();
        if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz)) {
            AppCompatActivity appCompatActivity = this.mController.ylL;
            EmotionDetail emotionDetail = new EmotionDetail();
            emotionDetail.ProductID = EmojiGroupInfo.yar;
            emotionDetail.PackName = appCompatActivity.getString(R.string.bca);
            emotionDetail.PackDesc = appCompatActivity.getString(R.string.bc9);
            emotionDetail.PackAuthInfo = appCompatActivity.getString(R.string.bc7);
            emotionDetail.PackPrice = "";
            emotionDetail.PackType = 0;
            emotionDetail.PackFlag = 1;
            emotionDetail.CoverUrl = "";
            emotionDetail.PackExpire = 0;
            emotionDetail.PackCopyright = appCompatActivity.getString(R.string.bc8);
            emotionDetail.PanelUrl = "";
            emotionDetail.PriceNum = "";
            emotionDetail.PriceType = "";
            emotionDetail.TimeLimitStr = appCompatActivity.getString(R.string.bc_);
            this.kYH = emotionDetail;
            this.lbx = true;
            this.lbw = EmojiLogic.bkd();
            blE();
        } else {
            if (this.kYH == null) {
                this.laC = new l(this.kWz, this.kYp);
            } else if (bo.isNullOrNil(this.kYI) || !this.kYI.equalsIgnoreCase(aa.gw(this.mContext))) {
                this.laC = new l(this.kWz, this.kYp);
            } else {
                this.laC = new l(this.kWz, this.kYp, this.kYH.Version);
            }
            com.tencent.mm.kernel.g.RO().eJo.a(this.laC, 0);
            if (this.lax == -1 || this.lax == 3) {
                this.laJ.setVisibility(8);
                this.Ek.setVisibility(8);
                getString(R.string.tz);
                this.gqo = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(53424);
                        com.tencent.mm.kernel.g.RO().eJo.c(EmojiStoreDetailUI.this.laC);
                        EmojiStoreDetailUI.this.laI.setText(R.string.bau);
                        EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
                        AppMethodBeat.o(53424);
                    }
                });
            }
            blC();
            if (this.lbv) {
                com.tencent.mm.kernel.g.RO().eJo.a(new k(this.kWz), 0);
            } else {
                this.lbx = true;
                this.lbw = EmojiLogic.bkd();
            }
        }
        blF();
        com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYo.c(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
        com.tencent.mm.kernel.g.RO().eJo.a(822, (f) this);
        h(this.kWz, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.lbl);
        this.lby = true;
        h.pYm.e(12740, Integer.valueOf(1), "", this.kWz, "", Integer.valueOf(this.lbk), Integer.valueOf(26));
        if (this.laz && this.laK != null) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53439);
                    EmojiStoreDetailUI.this.laK.fullScroll(130);
                    AppMethodBeat.o(53439);
                }
            }, 0);
        }
        AppMethodBeat.o(53450);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.u5;
    }

    public final void initView() {
        AppMethodBeat.i(53451);
        if (!bo.isNullOrNil(this.kWA)) {
            setMMTitle(this.kWA);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53422);
                EmojiStoreDetailUI.this.finish();
                AppMethodBeat.o(53422);
                return true;
            }
        });
        this.eno = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a0c);
        this.lbi = getResources().getDimensionPixelSize(R.dimen.a0b);
        this.lbi = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a0b);
        this.mNumColumns = 4;
        this.laK = (EmojiDetailScrollView) findViewById(R.id.b5j);
        this.Ek = findViewById(R.id.a5j);
        this.laI = (TextView) this.Ek.findViewById(R.id.bfn);
        this.laJ = findViewById(R.id.bf5);
        this.laL = (BannerEmojiView) findViewById(R.id.bf6);
        this.laL.setMinimumHeight((int) (((float) (((this.laL.getRight() - this.laL.getLeft()) - this.laL.getPaddingRight()) - this.laL.getPaddingLeft())) * 0.56f));
        this.laM = (TextView) findViewById(R.id.bf9);
        this.laN = (MMAutoSizeTextView) findViewById(R.id.bf8);
        this.laO = (TextView) findViewById(R.id.bfk);
        this.laP = (TextView) findViewById(R.id.bfa);
        this.laQ = (TextView) findViewById(R.id.bff);
        this.laW = com.tencent.mm.bz.a.gd(this.mController.ylL);
        this.laX = findViewById(R.id.bf_);
        this.laR = (EmojiDetailGridView) findViewById(R.id.bfh);
        if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz)) {
            this.laF = new b();
        } else {
            this.laF = new a();
        }
        this.laT = findViewById(R.id.bfb);
        this.kRN = (ProgressBar) findViewById(R.id.bfc);
        this.laS = (ImageView) findViewById(R.id.bfd);
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
        this.laR.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(53423);
                Object item = adapterView.getAdapter().getItem(i);
                if (item instanceof EmojiInfo) {
                    EmojiInfo emojiInfo = (EmojiInfo) item;
                    xx xxVar = new xx();
                    if (bo.isNullOrNil(xxVar.Md5) || xxVar.Md5.equals(emojiInfo.field_md5)) {
                        xxVar.Md5 = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_md5, xxVar.Md5);
                        xxVar.Url = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_cdnUrl, xxVar.Url);
                        xxVar.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_thumbUrl, xxVar.ThumbUrl);
                        xxVar.wdC = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_designerID, xxVar.wdC);
                        xxVar.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_encrypturl, xxVar.EncryptUrl);
                        xxVar.AesKey = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_aeskey, xxVar.AesKey);
                        xxVar.ProductID = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_groupId, xxVar.ProductID);
                        xxVar.ExternUrl = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_externUrl, xxVar.ExternUrl);
                        xxVar.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_externMd5, xxVar.ExternMd5);
                        xxVar.ActivityID = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_activityid, xxVar.ActivityID);
                        xxVar.wdD = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_attachedText, xxVar.wdD);
                        xxVar.wdE = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_attachTextColor, xxVar.wdE);
                        xxVar.wdF = com.tencent.mm.plugin.emoji.h.b.dN(emojiInfo.field_lensId, xxVar.wdF);
                    }
                    EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, xxVar);
                    h.pYm.e(12787, Integer.valueOf(0), Integer.valueOf(0), emojiInfo.field_md5, Long.valueOf(EmojiStoreDetailUI.this.kVE), emojiInfo.field_designerID, emojiInfo.field_groupId, Integer.valueOf(26));
                }
                AppMethodBeat.o(53423);
            }
        });
        this.laP.setOnClickListener(this);
        this.laU = (TextView) findViewById(R.id.bfl);
        this.laV = (TextView) findViewById(R.id.bfm);
        this.laU.setOnClickListener(this.lbz);
        this.laV.setOnClickListener(this.lbA);
        this.laY = (ProgressBar) findViewById(R.id.bfe);
        this.laY.setVisibility(this.lbm ? 0 : 8);
        this.lbu = findViewById(R.id.bfg);
        this.lbc = findViewById(R.id.bfi);
        this.laZ = findViewById(R.id.bfw);
        this.lba = (ImageView) findViewById(R.id.bfx);
        this.lbb = (TextView) findViewById(R.id.bfy);
        this.lbd = findViewById(R.id.bfj);
        this.lbe = (TextView) findViewById(R.id.bgn);
        this.lbf = (Button) findViewById(R.id.bgo);
        this.lbh = (TextView) findViewById(R.id.bgp);
        this.lbg = (DonorsAvatarView) findViewById(R.id.bgq);
        this.lbf.setOnClickListener(this.lbB);
        this.lbh.setOnClickListener(this.lbC);
        AppMethodBeat.o(53451);
    }

    public void onStart() {
        AppMethodBeat.i(53452);
        super.onStart();
        AppMethodBeat.o(53452);
    }

    public void onResume() {
        AppMethodBeat.i(53453);
        super.onResume();
        com.tencent.mm.kernel.g.RO().eJo.a(412, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        this.lbt = false;
        if (!this.lby) {
            blC();
            uh(1007);
        }
        blD();
        this.lby = false;
        uh(1001);
        AppMethodBeat.o(53453);
    }

    public void onPause() {
        AppMethodBeat.i(53454);
        super.onPause();
        com.tencent.mm.kernel.g.RO().eJo.b(412, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        AppMethodBeat.o(53454);
    }

    public void onStop() {
        AppMethodBeat.i(53455);
        super.onStop();
        AppMethodBeat.o(53455);
    }

    public void onDestroy() {
        AppMethodBeat.i(53456);
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYo.d(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.kYt);
        com.tencent.mm.kernel.g.RO().eJo.b(822, (f) this);
        if (this.laR != null) {
            this.laR.release();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(53456);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(53457);
        bundle.putInt("status", this.laB);
        bundle.putInt("progress", this.EV);
        AppMethodBeat.o(53457);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(53458);
        this.laB = bundle.getInt("status");
        this.EV = bundle.getInt("progress");
        AppMethodBeat.o(53458);
    }

    public void onClick(View view) {
        AppMethodBeat.i(53459);
        int id = view.getId();
        if (id == R.id.bfa) {
            String stringExtra;
            if (this.laB == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (bo.isNullOrNil(stringExtra) || !this.laA) {
                    this.kVI.A(this);
                    h.pYm.e(12069, Integer.valueOf(2), this.kWz);
                } else {
                    com.tencent.mm.plugin.emoji.h.c.a(stringExtra, this.kWz, (Activity) this);
                }
                ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                h.pYm.X(11076, "0, ");
                AppMethodBeat.o(53459);
                return;
            }
            switch (this.laB) {
                case -1:
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    AppMethodBeat.o(53459);
                    return;
                case 0:
                case 3:
                    blP();
                    this.laB = 6;
                    blK();
                    h.pYm.e(12066, Integer.valueOf(1), Integer.valueOf(this.lbk), "", this.kWz, Long.valueOf(this.kVE), this.kVF);
                    AppMethodBeat.o(53459);
                    return;
                case 4:
                    if (!this.lbt) {
                        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", this.kWz, this.kYH.PackPrice, this.kYH.PriceType);
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.kWz);
                        if (this.lbm) {
                            intent.putExtra("key_currency_type", this.lbq);
                            intent.putExtra("key_price", this.lbq + this.lbr);
                        } else {
                            intent.putExtra("key_currency_type", this.kYH.PriceType);
                            intent.putExtra("key_price", this.kYH.PriceNum);
                        }
                        d.b((Context) this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        h.pYm.e(12066, Integer.valueOf(2), Integer.valueOf(this.lbk), "", this.kWz, Long.valueOf(this.kVE), this.kVF);
                        this.lbt = true;
                        AppMethodBeat.o(53459);
                        return;
                    }
                    break;
                case 5:
                    this.laB = 3;
                    blK();
                    AppMethodBeat.o(53459);
                    return;
                case 10:
                case 12:
                    switch (this.lbo) {
                        case 10233:
                            stringExtra = getString(R.string.b_i);
                            break;
                        case 10234:
                            stringExtra = getString(R.string.b_a);
                            break;
                        case 10235:
                            stringExtra = getString(R.string.bcw);
                            break;
                        default:
                            stringExtra = getString(R.string.bd1);
                            break;
                    }
                    com.tencent.mm.ui.base.h.b((Context) this, stringExtra, null, true);
                    AppMethodBeat.o(53459);
                    return;
                case 11:
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    AppMethodBeat.o(53459);
                    return;
                default:
                    ab.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", Integer.valueOf(this.laB));
                    break;
            }
            AppMethodBeat.o(53459);
        } else if (id == R.id.bfc) {
            blO();
            AppMethodBeat.o(53459);
        } else if (id == R.id.bfd) {
            blO();
            AppMethodBeat.o(53459);
        } else {
            ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
            AppMethodBeat.o(53459);
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53460);
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (mVar.getType()) {
            case 412:
                if (mVar instanceof l) {
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                    l lVar = (l) mVar;
                    if (lVar == null || bo.isNullOrNil(lVar.kWz) || !lVar.kWz.equalsIgnoreCase(this.kWz)) {
                        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.o(53460);
                        return;
                    } else if (i == 0) {
                        if (i2 == 0) {
                            this.kYH = lVar.bkz();
                            uh(1002);
                            AppMethodBeat.o(53460);
                            return;
                        } else if (i2 == 1) {
                            blA();
                            AppMethodBeat.o(53460);
                            return;
                        } else {
                            this.laI.setText(R.string.bat);
                            blB();
                            AppMethodBeat.o(53460);
                            return;
                        }
                    } else if (i2 == 5) {
                        if (!(lVar == null || lVar.bkz() == null)) {
                            this.kYH.PackFlag = lVar.bkz().PackFlag;
                        }
                        uh(1002);
                        AppMethodBeat.o(53460);
                        return;
                    } else if (i2 == 1) {
                        blA();
                        AppMethodBeat.o(53460);
                        return;
                    } else {
                        this.laK.setVisibility(8);
                        this.Ek.setVisibility(0);
                        this.laI.setText(R.string.bau);
                        blB();
                        AppMethodBeat.o(53460);
                        return;
                    }
                }
                break;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (mVar instanceof g) {
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                    g gVar = (g) mVar;
                    if (gVar == null || bo.isNullOrNil(gVar.kWz) || !gVar.kWz.equalsIgnoreCase(this.kWz)) {
                        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.o(53460);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        this.lbl = gVar.fFa;
                        this.laB = 6;
                        blK();
                        AppMethodBeat.o(53460);
                        return;
                    } else {
                        this.laB = -1;
                        blK();
                        String str2 = this.kWA;
                        com.tencent.mm.ui.base.h.a((Context) this, String.format(getString(R.string.baj), new Object[]{str2}), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(53428);
                                EmojiStoreDetailUI.this.laD = new g(EmojiStoreDetailUI.this.kWz, EmojiStoreDetailUI.this.kWB, EmojiStoreDetailUI.this.kWA);
                                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                                EmojiStoreDetailUI.this.laB = 6;
                                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                                AppMethodBeat.o(53428);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(53460);
                        return;
                    }
                }
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX /*521*/:
                ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                k kVar = (k) mVar;
                if (kVar == null || bo.isNullOrNil(kVar.kWl) || !kVar.kWl.equalsIgnoreCase(this.kWz)) {
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.lbw = (aik) kVar.ehh.fsH.fsP;
                    } else {
                        this.lbw = null;
                    }
                    this.lbx = true;
                    blL();
                }
                this.lbx = true;
                blL();
                AppMethodBeat.o(53460);
                return;
            case 822:
                if (mVar instanceof o) {
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                    if (i == 0 && i2 == 0) {
                        this.laG = ((o) mVar).bkD();
                        uh(1007);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(53460);
    }

    private void blA() {
        AppMethodBeat.i(53461);
        this.Ek.setVisibility(0);
        this.laJ.setVisibility(8);
        this.laK.setVisibility(8);
        this.laI.setText(R.string.b_h);
        AppMethodBeat.o(53461);
    }

    private void blB() {
        AppMethodBeat.i(53462);
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.kYH == null || this.kYH.PackFlag == 0) {
            this.Ek.setVisibility(0);
            this.laJ.setVisibility(8);
        }
        AppMethodBeat.o(53462);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53463);
        ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        String str;
        if (i == 2001) {
            str = "";
            int i3 = 0;
            if (intent != null) {
                i3 = intent.getIntExtra("key_err_code", 0);
                ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(i3)));
                str = intent.getStringExtra("key_err_msg");
                ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
            }
            this.lbt = false;
            if (i2 != -1) {
                this.laB = -1;
                blK();
                if (r.YL()) {
                    h.pYm.a(166, 6, 1, false);
                    AppMethodBeat.o(53463);
                    return;
                }
                h.pYm.a(166, 2, 1, false);
                AppMethodBeat.o(53463);
                return;
            } else if (intent != null && i3 == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.kWz)) {
                    this.laB = -1;
                    blK();
                    JD(str);
                    AppMethodBeat.o(53463);
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
                com.tencent.mm.ui.base.h.bQ(this, str);
                if (r.YL()) {
                    h.pYm.a(166, 4, 1, false);
                    AppMethodBeat.o(53463);
                    return;
                }
                h.pYm.a(166, 0, 1, false);
                AppMethodBeat.o(53463);
                return;
            } else if (intent != null && i3 == 100000002) {
                blP();
                this.laB = 6;
                this.laF.notifyDataSetChanged();
                if (r.YL()) {
                    h.pYm.a(166, 7, 1, false);
                    AppMethodBeat.o(53463);
                    return;
                }
                h.pYm.a(166, 3, 1, false);
                AppMethodBeat.o(53463);
                return;
            } else if (intent == null || i3 != 1) {
                this.laB = -1;
                blK();
                JD(str);
                if (r.YL()) {
                    h.pYm.a(166, 5, 1, false);
                    AppMethodBeat.o(53463);
                    return;
                }
                h.pYm.a(166, 1, 1, false);
                AppMethodBeat.o(53463);
                return;
            } else {
                this.laB = -1;
                blK();
                if (r.YL()) {
                    h.pYm.a(166, 6, 1, false);
                    AppMethodBeat.o(53463);
                    return;
                }
                h.pYm.a(166, 2, 1, false);
                AppMethodBeat.o(53463);
                return;
            }
        }
        if (i == 2002) {
            if (i2 == -1) {
                str = intent.getStringExtra("Select_Conv_User");
                if (!bo.isNullOrNil(str)) {
                    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(str)));
                    String str2 = this.kWz;
                    String str3 = this.kYH.PackName;
                    String str4 = this.kYH.PackDesc;
                    String str5 = this.kYH.IconUrl;
                    String str6 = this.kYH.OldRedirectUrl;
                    int i5 = this.kYH.PackFlag;
                    com.tencent.mm.pluginsdk.i iVar = (com.tencent.mm.pluginsdk.i) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.i.class);
                    iVar.a((Context) this, str, getResources().getString(R.string.pj) + str3, getString(R.string.tf), getString(R.string.atc), str5, (com.tencent.mm.pluginsdk.ui.applet.q.a) new com.tencent.mm.plugin.emoji.e.l.AnonymousClass1(str, str2, str3, str4, str5, str6, i5, this));
                }
                AppMethodBeat.o(53463);
                return;
            }
        } else if (i == this.kVI.iGJ) {
            if (i2 == -1) {
                Intent intent2 = intent;
                ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", intent2.getStringExtra("Select_Conv_User"));
                com.tencent.mm.plugin.emoji.h.c.a(intent, this.kWz, (Activity) this);
                h.pYm.e(12069, Integer.valueOf(3), this.kWz);
                AppMethodBeat.o(53463);
                return;
            }
        } else if (i == 2004 && i2 == -1) {
            com.tencent.mm.ui.widget.snackbar.b.i(this, this.mController.ylL.getString(R.string.ti));
        }
        AppMethodBeat.o(53463);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(53464);
        uh(1001);
        AppMethodBeat.o(53464);
    }

    private void JD(String str) {
        AppMethodBeat.i(53465);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.b_o);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53465);
    }

    private void blC() {
        AppMethodBeat.i(53466);
        this.laG = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYs.aqq(this.kWz);
        AppMethodBeat.o(53466);
    }

    private void blD() {
        AppMethodBeat.i(53467);
        if (e.dR(this.kYH.PackFlag, 64) && com.tencent.mm.emoji.a.e.OJ()) {
            this.laE = new o(this.kWz, o.kWX);
            com.tencent.mm.kernel.g.RO().eJo.a(this.laE, 0);
        }
        AppMethodBeat.o(53467);
    }

    private boolean blE() {
        AppMethodBeat.i(53468);
        boolean blE = com.tencent.mm.plugin.emoji.h.a.blE();
        this.laH = blE;
        this.laB = blE ? 7 : 3;
        AppMethodBeat.o(53468);
        return blE;
    }

    private void blF() {
        AppMethodBeat.i(53469);
        if (!bo.isNullOrNil(this.kYH.PackName)) {
            setMMTitle(this.kYH.PackName);
        }
        ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", this.kYH.PanelUrl);
        this.laJ.setVisibility(0);
        this.Ek.setVisibility(8);
        gp(true);
        this.laN.setText(this.kYH.PackName);
        this.laO.setText(this.kYH.PackCopyright);
        this.laQ.setText(this.kYH.PackDesc);
        if (e.dR(this.kYH.PackType, 1)) {
            this.laM.setVisibility(8);
        } else {
            this.laM.setVisibility(0);
            this.laM.setText(R.string.bd0);
        }
        blJ();
        blK();
        blL();
        blM();
        blN();
        this.laN.setMaxWidth((((this.laW - this.laX.getWidth()) - (com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.m4) * 2)) - this.laM.getWidth()) - (com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.ld) * 2));
        this.laN.setVisibility(8);
        this.laN.setVisibility(0);
        blG();
        blI();
        blH();
        AppMethodBeat.o(53469);
    }

    private void gp(boolean z) {
        AppMethodBeat.i(53470);
        EmojiInfo emojiInfo = null;
        if (!bo.isNullOrNil(this.kYH.CoverUrl)) {
            String str;
            if (z) {
                str = this.kWz;
                String str2 = this.kYH.CoverUrl;
                com.tencent.mm.bz.a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.a(str, str2, this.lbD);
            } else {
                str = this.kWz;
                String str3 = this.kYH.CoverUrl;
                com.tencent.mm.bz.a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.r(str, 4, str3);
            }
        }
        if (!(emojiInfo == null || this.laL == null)) {
            this.laL.setImageFilePath(emojiInfo.dve());
        }
        if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz)) {
            this.laL.setImageResource(R.drawable.aq6);
        }
        AppMethodBeat.o(53470);
    }

    private void blG() {
        AppMethodBeat.i(53471);
        if (this.kYH.PersonalDesigner == null || this.kYH.PersonalDesigner.DesignerUin == 0 || this.lbk == 6) {
            this.lbc.setVisibility(8);
            this.laZ.setVisibility(8);
            AppMethodBeat.o(53471);
            return;
        }
        this.lbc.setVisibility(0);
        this.laZ.setVisibility(0);
        com.tencent.mm.at.o.ahp().a(this.kYH.PersonalDesigner.HeadUrl, this.lba, com.tencent.mm.plugin.emoji.e.g.dI(this.kWz, this.kYH.PersonalDesigner.HeadUrl));
        this.lbb.setText(this.kYH.PersonalDesigner.Name);
        this.laZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53425);
                Intent intent = new Intent();
                intent.setClass(EmojiStoreDetailUI.this.mController.ylL, EmojiStoreV2DesignerUI.class);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.this.kYH.PersonalDesigner.DesignerUin);
                intent.putExtra("name", EmojiStoreDetailUI.this.kYH.PersonalDesigner.Name);
                intent.putExtra("headurl", EmojiStoreDetailUI.this.kYH.PersonalDesigner.HeadUrl);
                intent.putExtra("rediret_url", EmojiStoreDetailUI.this.kYH.OldRedirectUrl);
                intent.putExtra("searchID", EmojiStoreDetailUI.this.kVE);
                intent.putExtra("extra_scence", 26);
                EmojiStoreDetailUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(53425);
            }
        });
        AppMethodBeat.o(53471);
    }

    public final void blH() {
        AppMethodBeat.i(53472);
        if (!e.dR(this.kYH.PackFlag, 64) || !com.tencent.mm.emoji.a.e.OJ()) {
            this.lbd.setVisibility(8);
            AppMethodBeat.o(53472);
        } else if (this.laG != null) {
            this.lbd.setVisibility(0);
            this.lbf.setText(R.string.bbe);
            this.lbe.setText(this.laG.Reward.wea);
            this.lbe.setLongClickable(false);
            if (this.laG.DonorNum > 0) {
                this.lbh.setVisibility(0);
                String valueOf = String.valueOf(this.laG.DonorNum);
                String format = String.format(getString(R.string.bbi), new Object[]{Integer.valueOf(this.laG.DonorNum)});
                SpannableString spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.n6)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.lbh.setText(spannableString);
            } else {
                this.lbh.setVisibility(8);
            }
            if (this.laG.Donors == null || this.laG.Donors.size() <= 0) {
                this.lbg.setVisibility(8);
                AppMethodBeat.o(53472);
                return;
            }
            this.lbg.setVisibility(0);
            this.lbg.c(this.kWz, this.laG.Donors);
            AppMethodBeat.o(53472);
        } else {
            this.lbd.setVisibility(8);
            blD();
            AppMethodBeat.o(53472);
        }
    }

    private void blI() {
        AppMethodBeat.i(53473);
        LayoutParams layoutParams;
        if ((this.kYH.PackFlag & 32) == 32) {
            layoutParams = (LayoutParams) this.laV.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.laU.getLayoutParams();
            this.laV.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.m4);
            this.laV.setLayoutParams(layoutParams);
            this.laV.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.m4);
            this.laU.setLayoutParams(layoutParams2);
            this.laU.setGravity(5);
            AppMethodBeat.o(53473);
            return;
        }
        layoutParams = (LayoutParams) this.laU.getLayoutParams();
        layoutParams.gravity = 17;
        this.laU.setLayoutParams(layoutParams);
        this.laU.setGravity(17);
        this.laV.setVisibility(8);
        AppMethodBeat.o(53473);
    }

    private void blJ() {
        AppMethodBeat.i(53474);
        if (e.dR(this.kYH.PackType, 8)) {
            this.lbj = 0;
        } else if (e.dR(this.kYH.PackType, 4)) {
            this.lbj = 0;
        } else if (this.lbm || !TextUtils.isEmpty(this.kYH.PackPrice)) {
            this.lbj = 1;
        } else {
            this.lbj = 0;
        }
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", Integer.valueOf(this.kYH.PackFlag));
        if (e.dR(this.kYH.PackFlag, 8) && e.uc(this.kYH.PackType)) {
            this.laB = 8;
        } else if (e.dR(this.kYH.PackFlag, 1) || e.dR(this.kYH.PackType, 8)) {
            this.laB = 3;
        } else if (e.uc(this.kYH.PackType)) {
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
        AppMethodBeat.o(53474);
    }

    /* JADX WARNING: Missing block: B:7:0x0030, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(53475);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void blK() {
        AppMethodBeat.i(53475);
        while (true) {
            if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz)) {
                blE();
            }
            switch (this.laB) {
                case -1:
                    blJ();
                case 0:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(R.color.a8m));
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setText(R.string.bai);
                    this.laP.setEnabled(true);
                    AppMethodBeat.o(53475);
                    return;
                case 3:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(R.color.a8m));
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setText(R.string.bai);
                    this.laP.setEnabled(true);
                    AppMethodBeat.o(53475);
                    return;
                case 4:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(R.color.a8m));
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setEnabled(true);
                    if (!this.lbm) {
                        this.laP.setText(this.kYH.PackPrice);
                        this.laB = 4;
                        AppMethodBeat.o(53475);
                        return;
                    } else if (bo.isNullOrNil(this.lbp)) {
                        this.laP.setText("");
                        AppMethodBeat.o(53475);
                        return;
                    } else {
                        this.laP.setText(this.lbp);
                        AppMethodBeat.o(53475);
                        return;
                    }
                case 5:
                    this.laY.setVisibility(8);
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setText(R.string.bai);
                    this.laP.setEnabled(true);
                    break;
                case 6:
                    this.laY.setVisibility(8);
                    this.laP.setEnabled(false);
                    this.laT.setVisibility(0);
                    this.laS.setVisibility(0);
                    this.laP.setVisibility(4);
                    if (this.lax != 3) {
                        AppMethodBeat.o(53475);
                        return;
                    }
                    break;
                case 7:
                    this.laY.setVisibility(8);
                    this.laP.setVisibility(0);
                    this.laP.setEnabled(true);
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setText(R.string.bcd);
                    this.laT.setVisibility(8);
                    this.kRN.setProgress(0);
                    this.laS.setVisibility(4);
                    if (this.lax != 3) {
                        AppMethodBeat.o(53475);
                        return;
                    }
                    break;
                case 8:
                    this.laY.setVisibility(8);
                    this.laP.setTextColor(getResources().getColorStateList(R.color.mw));
                    this.laP.setBackgroundResource(R.drawable.fu);
                    this.laP.setText(R.string.bal);
                    this.laP.setEnabled(false);
                    AppMethodBeat.o(53475);
                    return;
                case 10:
                case 12:
                    this.laY.setVisibility(8);
                    this.laP.setVisibility(0);
                    this.laP.setBackgroundResource(R.drawable.fp);
                    this.laP.setText(R.string.bb6);
                    this.laP.setEnabled(true);
                    this.laT.setVisibility(8);
                    this.kRN.setProgress(0);
                    this.laS.setVisibility(4);
                    AppMethodBeat.o(53475);
                    return;
                case 11:
                    break;
                default:
                    ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", Integer.valueOf(this.laB));
                    break;
            }
        }
        this.laY.setVisibility(0);
        this.laP.setVisibility(0);
        this.laP.setBackgroundResource(R.drawable.as_);
        this.laP.setText("");
        this.laP.setEnabled(false);
        this.laT.setVisibility(8);
        this.kRN.setProgress(0);
        this.laS.setVisibility(4);
        AppMethodBeat.o(53475);
    }

    private void blL() {
        AppMethodBeat.i(53476);
        if (this.lbx && ((this.lbw == null || (this.lbw.wox & 1) != 1) && !((this.kYH != null && e.dR(this.kYH.PackFlag, 1)) || this.lbw == null || TextUtils.isEmpty(this.lbw.wow)))) {
            this.laP.setText(this.lbw.wow);
            this.laP.setTextColor(this.mController.ylL.getResources().getColor(R.color.rr));
            this.laP.setBackgroundDrawable(null);
            this.laP.setEnabled(false);
        }
        AppMethodBeat.o(53476);
    }

    private void blM() {
        AppMethodBeat.i(53477);
        if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz) || !(this.kYH.ThumbExtList == null || this.kYH.ThumbExtList.size() <= 0 || ((PackThumbExt) this.kYH.ThumbExtList.get(0)).PreviewUrl == null)) {
            this.lbu.setVisibility(0);
        } else {
            this.lbu.setVisibility(8);
        }
        this.laR.setProductId(this.kWz);
        if (this.laF != null) {
            this.laF.notifyDataSetInvalidated();
        }
        AppMethodBeat.o(53477);
    }

    private void blN() {
        AppMethodBeat.i(53478);
        ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", this.kYH.PackFlag);
        if ((this.kYH.PackFlag & 16) == 16) {
            addIconOptionMenu(0, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(53426);
                    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
                    EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(53426);
                    return true;
                }
            });
        }
        AppMethodBeat.o(53478);
    }

    private void blO() {
        AppMethodBeat.i(53479);
        com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.baa, 0, (int) R.string.bc2, (int) R.string.bad, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(53427);
                if (com.tencent.mm.plugin.emoji.h.a.JW(EmojiStoreDetailUI.this.kWz)) {
                    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                    com.tencent.mm.plugin.emoji.f.a.bkq().bks();
                } else {
                    com.tencent.mm.kernel.g.RO().eJo.c(EmojiStoreDetailUI.this.laD);
                }
                if (!TextUtils.isEmpty(EmojiStoreDetailUI.this.lbl)) {
                    com.tencent.mm.al.f.afx().rO(EmojiStoreDetailUI.this.lbl);
                    ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", EmojiStoreDetailUI.this.lbl);
                }
                if (e.dR(EmojiStoreDetailUI.this.kYH.PackFlag, 1) || e.uc(EmojiStoreDetailUI.this.kYH.PackType)) {
                    EmojiStoreDetailUI.this.laB = 3;
                } else {
                    EmojiStoreDetailUI.this.laB = -1;
                }
                com.tencent.mm.plugin.emoji.model.j.bkn().g(EmojiStoreDetailUI.this.kWz, EmojiStoreDetailUI.this.laB, 0, EmojiStoreDetailUI.this.lbl);
                EmojiStoreDetailUI.this.laT.setVisibility(8);
                EmojiStoreDetailUI.this.kRN.setProgress(0);
                EmojiStoreDetailUI.this.laS.setVisibility(4);
                EmojiStoreDetailUI.this.laP.setVisibility(0);
                EmojiStoreDetailUI.this.lax;
                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                com.tencent.mm.kernel.g.RO().eJo.a(new q(EmojiStoreDetailUI.this.kWz, 2), 0);
                AppMethodBeat.o(53427);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53479);
    }

    public final void h(String str, int i, int i2, String str2) {
        AppMethodBeat.i(53480);
        ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (bo.isNullOrNil(str) || !str.equals(this.kWz)) {
            AppMethodBeat.o(53480);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.lbl = str2;
        }
        if (i == -1) {
            if (this.laB != -1) {
                this.laB = -1;
                uh(1003);
                AppMethodBeat.o(53480);
                return;
            }
        } else if (i == 7) {
            this.laB = 7;
            uh(1003);
            AppMethodBeat.o(53480);
            return;
        } else if (i != 6) {
            ab.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
        } else if (!TextUtils.isEmpty(str) && str.equals(this.kWz)) {
            this.laB = 6;
            this.EV = i2;
            uh(1004);
            AppMethodBeat.o(53480);
            return;
        }
        AppMethodBeat.o(53480);
    }

    private void blP() {
        AppMethodBeat.i(53481);
        if (com.tencent.mm.plugin.emoji.h.a.JW(this.kWz)) {
            com.tencent.mm.plugin.emoji.f.a.bkq();
            com.tencent.mm.plugin.emoji.f.a.bkr();
            AppMethodBeat.o(53481);
            return;
        }
        this.laD = new g(this.kWz, this.kWB, this.kWA);
        com.tencent.mm.kernel.g.RO().eJo.a(this.laD, 0);
        switch (this.kYp) {
            case 9:
                h.pYm.e(11598, Integer.valueOf(2), this.kWz);
                break;
            case 10:
                h.pYm.e(11598, Integer.valueOf(1), this.kWz);
                AppMethodBeat.o(53481);
                return;
            case 11:
                h.pYm.e(11598, Integer.valueOf(3), this.kWz);
                AppMethodBeat.o(53481);
                return;
        }
        AppMethodBeat.o(53481);
    }

    public final void uh(int i) {
        AppMethodBeat.i(53482);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
        AppMethodBeat.o(53482);
    }

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53483);
        if (!com.tencent.mm.plugin.emoji.h.a.JW(emojiStoreDetailUI.kWz)) {
            if (com.tencent.mm.kernel.g.RP().isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYo.aqc(emojiStoreDetailUI.kWz)) {
                if (com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.Jp(emojiStoreDetailUI.kWz) > 0) {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.emoji.h.b.Yb() + emojiStoreDetailUI.kWz);
                    if (bVar.exists()) {
                        com.tencent.mm.vfs.b[] dMF = bVar.dMF();
                        if (dMF == null || dMF.length <= 0) {
                            com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYo.aqd(emojiStoreDetailUI.kWz);
                            com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqm(emojiStoreDetailUI.kWz);
                        } else {
                            emojiStoreDetailUI.laH = true;
                            emojiStoreDetailUI.laB = 7;
                            emojiStoreDetailUI.blK();
                            AppMethodBeat.o(53483);
                            return;
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqm(emojiStoreDetailUI.kWz);
            }
            emojiStoreDetailUI.laH = false;
        }
        AppMethodBeat.o(53483);
    }

    static /* synthetic */ void r(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(53489);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(emojiStoreDetailUI.mContext, 1, false);
        dVar.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(53430);
                lVar.a(1001, EmojiStoreDetailUI.this.getString(R.string.ba1), (int) R.raw.bottomsheet_icon_transmit);
                lVar.a(1000, EmojiStoreDetailUI.this.getString(R.string.ba2), (int) R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(53430);
            }
        };
        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(53431);
                switch (menuItem.getItemId()) {
                    case 1000:
                        com.tencent.mm.plugin.emoji.e.l.a(EmojiStoreDetailUI.this.mController.ylL, EmojiStoreDetailUI.this.kYH.PackName + EmojiStoreDetailUI.this.getString(R.string.bc1), EmojiStoreDetailUI.this.kYH.PackDesc, EmojiStoreDetailUI.this.kYH.IconUrl, EmojiStoreDetailUI.this.kYH.OldRedirectUrl, EmojiLogic.Jt(EmojiStoreDetailUI.this.kWz), 4);
                        h.pYm.e(13224, Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.this.kWz, "");
                        break;
                    case 1001:
                        com.tencent.mm.plugin.emoji.e.l.dE(EmojiStoreDetailUI.this.mController.ylL);
                        EmojiStoreDetailUI.this.mController.ylL.overridePendingTransition(R.anim.cg, R.anim.b6);
                        h.pYm.e(13224, Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.this.kWz, "");
                        AppMethodBeat.o(53431);
                        return;
                }
                AppMethodBeat.o(53431);
            }
        };
        dVar.cpD();
        h.pYm.e(13224, Integer.valueOf(0), Integer.valueOf(0), "", "");
        AppMethodBeat.o(53489);
    }
}
