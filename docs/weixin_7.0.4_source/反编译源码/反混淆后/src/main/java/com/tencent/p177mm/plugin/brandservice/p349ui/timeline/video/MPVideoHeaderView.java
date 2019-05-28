package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42809b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C35931jz;
import com.tencent.p177mm.protocal.protobuf.C46535eg;
import com.tencent.p177mm.protocal.protobuf.bac;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u00020.H\u0002J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020.2\u0006\u00104\u001a\u000207J\u000e\u00108\u001a\u00020.2\u0006\u0010\t\u001a\u00020\nJ\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020*J\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020,J\b\u0010=\u001a\u00020.H\u0002J\b\u0010>\u001a\u00020.H\u0002J\u000e\u0010?\u001a\u00020.2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "wowEduLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWowEduView;", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWowEduView", "view", "setWriteCommentLayout", "layout", "showEduView", "showHaoKanView", "update", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView */
public final class MPVideoHeaderView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoHeaderView";
    private ImageView eks;
    C37436r jVG;
    C32224p jVH;
    private MPVideoWriteCommentLayout jWN;
    C45767b jWx;
    private View jXA;
    private View jXB;
    private TextView jXC;
    private TextView jXD;
    private TextView jXE;
    private TextView jXF;
    View jXG;
    TextView jXH;
    ImageView jXI;
    View jXJ;
    MPVideoWowEduView jXK;
    boolean jXu;
    C35931jz jXv;
    private LinearLayout jXw;
    private TextView jXx;
    private MMNeat7extView jXy;
    private MMNeat7extView jXz;
    String talker = "";
    private TextView timeTv;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView$e */
    static final class C2744e implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;

        C2744e(MPVideoHeaderView mPVideoHeaderView) {
            this.jXL = mPVideoHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15255);
            if (MPVideoHeaderView.m4991g(this.jXL) != null) {
                MPVideoHeaderView.m4991g(this.jXL).mo35342fA(true);
                this.jXL.jXG.setVisibility(8);
            }
            AppMethodBeat.m2505o(15255);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView$b */
    static final class C2746b implements Runnable {
        final /* synthetic */ MPVideoHeaderView jXL;
        final /* synthetic */ C7616ad jXN;

        C2746b(MPVideoHeaderView mPVideoHeaderView, C7616ad c7616ad) {
            this.jXL = mPVideoHeaderView;
            this.jXN = c7616ad;
        }

        public final void run() {
            AppMethodBeat.m2504i(138521);
            if (C41730b.m73504pW(this.jXL.talker) == null) {
                C17880h qo = C17884o.act().mo33392qo(this.jXL.talker);
                if (!(qo == null || C5046bo.isNullOrNil(qo.acl()))) {
                    C11188a.m18894a(this.jXL.eks, this.jXN, qo.acl(), true);
                }
            }
            AppMethodBeat.m2505o(138521);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView$c */
    static final class C2747c implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;

        C2747c(MPVideoHeaderView mPVideoHeaderView) {
            this.jXL = mPVideoHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15252);
            this.jXL.jXA.setVisibility(8);
            this.jXL.jXz.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            this.jXL.jXz.requestLayout();
            AppMethodBeat.m2505o(15252);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView$d */
    static final class C2748d implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;
        final /* synthetic */ C35931jz jXO;

        C2748d(MPVideoHeaderView mPVideoHeaderView, C35931jz c35931jz) {
            this.jXL = mPVideoHeaderView;
            this.jXO = c35931jz;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15254);
            if (this.jXO.vMP == 1) {
                MPVideoHeaderView.m4989e(this.jXL).mo73560ao(2, "");
                AppMethodBeat.m2505o(15254);
                return;
            }
            MPVideoHeaderView.m4989e(this.jXL).mo73560ao(1, "");
            this.jXL.jXu = true;
            AppMethodBeat.m2505o(15254);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView$a */
    static final class C2749a implements C9636a {
        final /* synthetic */ WeakReference jXM;

        C2749a(WeakReference weakReference) {
            this.jXM = weakReference;
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(138520);
            ImageView imageView = (ImageView) this.jXM.get();
            if (imageView == null) {
                AppMethodBeat.m2505o(138520);
                return;
            }
            C25052j.m39375o(imageView, "weakReference.get() ?: return@GetContactCallBack");
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
            if (aoO == null || aoO.mo16705Oh() <= 0) {
                AppMethodBeat.m2505o(138520);
                return;
            }
            if (imageView.getTag() instanceof String) {
                C17884o.acv().mo67495pZ(str);
                Object tag = imageView.getTag();
                if (tag == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.m2505o(138520);
                    throw c44941v;
                } else if (C5046bo.isEqual((String) tag, str)) {
                    C17880h qo = C17884o.act().mo33392qo(str);
                    if (qo == null || C5046bo.isNullOrNil(qo.acl())) {
                        C40460b.m69437r(imageView, str);
                    } else {
                        C11188a.m18894a(imageView, aoO, qo.acl(), true);
                        AppMethodBeat.m2505o(138520);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(138520);
        }
    }

    /* renamed from: e */
    public static final /* synthetic */ C45767b m4989e(MPVideoHeaderView mPVideoHeaderView) {
        AppMethodBeat.m2504i(15267);
        C45767b c45767b = mPVideoHeaderView.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        AppMethodBeat.m2505o(15267);
        return c45767b;
    }

    /* renamed from: g */
    public static final /* synthetic */ MPVideoWriteCommentLayout m4991g(MPVideoHeaderView mPVideoHeaderView) {
        AppMethodBeat.m2504i(15268);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = mPVideoHeaderView.jWN;
        if (mPVideoWriteCommentLayout == null) {
            C25052j.avw("writeCommentLayout");
        }
        AppMethodBeat.m2505o(15268);
        return mPVideoWriteCommentLayout;
    }

    public MPVideoHeaderView(final Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(15266);
        View.inflate(context, 2130970255, this);
        View findViewById = findViewById(2131826175);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_avatar_layout)");
        this.jXw = (LinearLayout) findViewById;
        findViewById = findViewById(2131826157);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_avatar_iv)");
        this.eks = (ImageView) findViewById;
        findViewById = findViewById(2131826176);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_nick_name_tv)");
        this.jXx = (TextView) findViewById;
        findViewById = findViewById(2131826178);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_title_tv)");
        this.jXy = (MMNeat7extView) findViewById;
        findViewById = findViewById(2131826181);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_desc_tv)");
        this.jXz = (MMNeat7extView) findViewById;
        findViewById = findViewById(2131826182);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_desc_show_more_layout)");
        this.jXA = findViewById;
        findViewById = findViewById(2131826180);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_desc_layout)");
        this.jXB = findViewById;
        findViewById = findViewById(2131826184);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_time_tv)");
        this.timeTv = (TextView) findViewById;
        findViewById = findViewById(2131826185);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_read_count_tv)");
        this.jXC = (TextView) findViewById;
        findViewById = findViewById(2131826187);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_haokan_tv)");
        this.jXD = (TextView) findViewById;
        findViewById = findViewById(2131826186);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_haokan_count_tv)");
        this.jXE = (TextView) findViewById;
        findViewById = findViewById(2131826179);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_malicious_tips)");
        this.jXF = (TextView) findViewById;
        findViewById = findViewById(2131826188);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_write_wow_tips_layout)");
        this.jXG = findViewById;
        findViewById = findViewById(2131826191);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
        this.jXH = (TextView) findViewById;
        findViewById = findViewById(2131826189);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_write_wow_tips_icon)");
        this.jXI = (ImageView) findViewById;
        findViewById = findViewById(2131826183);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_header_data_layout)");
        this.jXJ = findViewById;
        TextPaint paint = this.jXy.getPaint();
        C25052j.m39375o(paint, "tp");
        paint.setFakeBoldText(true);
        this.jXw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoHeaderView jXL;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15251);
                if ((MPVideoHeaderView.m4989e(this.jXL).fgc & 1) != 0) {
                    C4990ab.m7420w(this.jXL.TAG, "not allow jump to profile " + MPVideoHeaderView.m4989e(this.jXL).fgc);
                    AppMethodBeat.m2505o(15251);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.jXL.talker);
                intent.putExtra("Contact_Scene", 152);
                C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(15251);
            }
        });
        AppMethodBeat.m2505o(15266);
    }

    public final void initView() {
        AppMethodBeat.m2504i(15256);
        aYL();
        TextView textView = this.timeTv;
        Context context = getContext();
        C37436r c37436r = this.jVG;
        if (c37436r == null) {
            C25052j.avw("msgInfo");
        }
        textView.setText(C42809b.m75917e(context, c37436r.fjT.time * 1000));
        C32224p c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        if (C5046bo.isNullOrNil(c32224p.fjz)) {
            this.jXB.setVisibility(8);
        } else {
            this.jXB.setVisibility(0);
            aYK();
        }
        MMNeat7extView mMNeat7extView = this.jXy;
        C37436r c37436r2 = this.jVG;
        if (c37436r2 == null) {
            C25052j.avw("msgInfo");
        }
        mMNeat7extView.mo15921ah(c37436r2.fjT.title);
        AppMethodBeat.m2505o(15256);
    }

    public final void setMaliciousInfo(bac bac) {
        AppMethodBeat.m2504i(15257);
        C25052j.m39376p(bac, "info");
        this.jXF.setVisibility(0);
        this.jXF.setText(bac.wDU);
        AppMethodBeat.m2505o(15257);
    }

    public final void setOriginInfo(C46535eg c46535eg) {
        AppMethodBeat.m2504i(15258);
        C25052j.m39376p(c46535eg, "info");
        C32224p c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        c32224p.title = c46535eg.title;
        c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        c32224p.fjz = c46535eg.fjz;
        initView();
        AppMethodBeat.m2505o(15258);
    }

    private final void aYK() {
        int dPe;
        AppMethodBeat.m2504i(15259);
        MMNeat7extView mMNeat7extView = this.jXz;
        C32224p c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        if (c32224p == null) {
            C25052j.dWJ();
        }
        mMNeat7extView.mo15921ah(c32224p.fjz);
        C5782a QV = this.jXz.mo15918QV(C1338a.m2868gd(getContext()) - C1338a.fromDPToPix(getContext(), 32));
        if (QV != null) {
            dPe = QV.dPe();
        } else {
            dPe = 0;
        }
        if (dPe > 4) {
            float textSize = this.jXz.getTextSize();
            this.jXz.mo15919a(TruncateAt.END, textSize);
            this.jXA.setMinimumHeight((int) textSize);
            this.jXA.setVisibility(0);
            this.jXz.setMaxLines(4);
            this.jXB.setOnClickListener(new C2747c(this));
        }
        AppMethodBeat.m2505o(15259);
    }

    private final void aYL() {
        String str = null;
        AppMethodBeat.m2504i(138522);
        C40460b.m69437r(this.eks, this.talker);
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        C7616ad aoO = ((C6982j) K).mo15369XM().aoO(this.talker);
        C37436r c37436r;
        String str2;
        if (aoO == null || aoO.mo16705Oh() <= 0) {
            Object HE;
            c37436r = this.jVG;
            if (c37436r == null) {
                C25052j.avw("msgInfo");
            }
            str2 = c37436r != null ? c37436r.fjR : null;
            ImageView imageView = this.eks;
            c37436r = this.jVG;
            if (c37436r == null) {
                C25052j.avw("msgInfo");
            }
            if (c37436r != null) {
                HE = c37436r.mo60325HE();
            } else {
                HE = null;
            }
            imageView.setTag(HE);
            WeakReference weakReference = new WeakReference(this.eks);
            C9635b Zu = C26417a.m42064Zu();
            c37436r = this.jVG;
            if (c37436r == null) {
                C25052j.avw("msgInfo");
            }
            if (c37436r != null) {
                str = c37436r.mo60325HE();
            }
            Zu.mo20966a(str, "", new C2749a(weakReference));
            str = str2;
        } else {
            String HE2;
            if (!aoO.mo16693NX()) {
                C5004al.m7442n(new C2746b(this, aoO), 200);
            }
            c37436r = this.jVG;
            if (c37436r == null) {
                C25052j.avw("msgInfo");
            }
            if (c37436r != null) {
                HE2 = c37436r.mo60325HE();
            } else {
                HE2 = null;
            }
            str2 = C1854s.m3866mJ(HE2);
            if (C5046bo.isEqual(str2, this.talker)) {
                c37436r = this.jVG;
                if (c37436r == null) {
                    C25052j.avw("msgInfo");
                }
                if (c37436r != null) {
                    HE2 = c37436r.fjR;
                } else {
                    HE2 = null;
                }
                if (!C5046bo.isNullOrNil(HE2)) {
                    c37436r = this.jVG;
                    if (c37436r == null) {
                        C25052j.avw("msgInfo");
                    }
                    if (c37436r != null) {
                        str = c37436r.fjR;
                    }
                }
            }
            str = str2;
        }
        SpannableString b = C44089j.m79293b(getContext(), (CharSequence) str + "  ", this.jXx.getTextSize());
        Context context = getContext();
        C25052j.m39375o(context, "context");
        Drawable drawable = context.getResources().getDrawable(C25738R.drawable.axm);
        int textSize = (int) this.jXx.getTextSize();
        drawable.setBounds(0, 0, textSize / 2, textSize);
        new SpannableString("@").setSpan(new C5664a(drawable), 0, 1, 33);
        this.jXx.setText(TextUtils.concat(new CharSequence[]{b, r2}));
        AppMethodBeat.m2505o(138522);
    }

    /* renamed from: a */
    public final void mo6811a(C35931jz c35931jz) {
        AppMethodBeat.m2504i(15262);
        C25052j.m39376p(c35931jz, "appMsgStat");
        this.jXv = c35931jz;
        if (c35931jz.enabled == 1) {
            this.jXC.setVisibility(0);
            TextView textView = this.jXC;
            Context context = getContext();
            Object[] objArr = new Object[1];
            Context context2 = getContext();
            C25052j.m39375o(context2, "context");
            objArr[0] = C11263c.m18979G(context2, c35931jz.vMN);
            textView.setText(context.getString(C25738R.string.g5u, objArr));
        } else {
            this.jXC.setVisibility(8);
        }
        setWow(c35931jz);
        AppMethodBeat.m2505o(15262);
    }

    public final void setWow(C35931jz c35931jz) {
        AppMethodBeat.m2504i(15263);
        C25052j.m39376p(c35931jz, "appMsgStat");
        if (c35931jz.vMQ != 1) {
            this.jXD.setVisibility(8);
            this.jXE.setVisibility(8);
            AppMethodBeat.m2505o(15263);
            return;
        }
        int i;
        Context context;
        this.jXD.setVisibility(0);
        this.jXE.setVisibility(0);
        if (c35931jz.vMP == 1) {
            this.jXD.setTextColor(getResources().getColor(C25738R.color.f11779h1));
            this.jXE.setTextColor(getResources().getColor(C25738R.color.f11779h1));
            i = C25738R.drawable.ay0;
        } else {
            this.jXD.setTextColor(getResources().getColor(C25738R.color.f11781h3));
            this.jXE.setTextColor(getResources().getColor(C25738R.color.f11781h3));
            i = C25738R.drawable.axy;
        }
        String string = getContext().getString(C25738R.string.g5s);
        if (c35931jz.vMO > 0) {
            this.jXE.setVisibility(0);
            TextView textView = this.jXE;
            context = getContext();
            C25052j.m39375o(context, "context");
            textView.setText(String.valueOf(C11263c.m18979G(context, c35931jz.vMO)));
        } else {
            this.jXE.setText("");
            this.jXE.setVisibility(4);
        }
        context = getContext();
        C25052j.m39375o(context, "context");
        Drawable drawable = context.getResources().getDrawable(i);
        i = (int) (((double) this.jXx.getTextSize()) * 1.3d);
        drawable.setBounds(0, 0, i, i);
        C5664a c5664a = new C5664a(drawable);
        new SpannableString("@").setSpan(c5664a, 0, 1, 33);
        this.jXD.setText(TextUtils.concat(new CharSequence[]{r1, " ", string}));
        this.jXD.setOnClickListener(new C2748d(this, c35931jz));
        AppMethodBeat.m2505o(15263);
    }

    public final void setWriteCommentLayout(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.m2504i(15264);
        C25052j.m39376p(mPVideoWriteCommentLayout, "layout");
        this.jWN = mPVideoWriteCommentLayout;
        AppMethodBeat.m2505o(15264);
    }

    public final void setWowEduView(MPVideoWowEduView mPVideoWowEduView) {
        AppMethodBeat.m2504i(15265);
        C25052j.m39376p(mPVideoWowEduView, "view");
        this.jXK = mPVideoWowEduView;
        AppMethodBeat.m2505o(15265);
    }
}
