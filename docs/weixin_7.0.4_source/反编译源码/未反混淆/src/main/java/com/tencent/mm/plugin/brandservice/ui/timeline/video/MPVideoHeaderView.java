package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;
import com.tencent.mm.af.p;
import com.tencent.mm.af.r;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u00020.H\u0002J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020.2\u0006\u00104\u001a\u000207J\u000e\u00108\u001a\u00020.2\u0006\u0010\t\u001a\u00020\nJ\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020*J\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020,J\b\u0010=\u001a\u00020.H\u0002J\b\u0010>\u001a\u00020.H\u0002J\u000e\u0010?\u001a\u00020.2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "wowEduLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWowEduView;", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWowEduView", "view", "setWriteCommentLayout", "layout", "showEduView", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoHeaderView";
    private ImageView eks;
    r jVG;
    p jVH;
    private MPVideoWriteCommentLayout jWN;
    b jWx;
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
    jz jXv;
    private LinearLayout jXw;
    private TextView jXx;
    private MMNeat7extView jXy;
    private MMNeat7extView jXz;
    String talker = "";
    private TextView timeTv;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;

        e(MPVideoHeaderView mPVideoHeaderView) {
            this.jXL = mPVideoHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(15255);
            if (MPVideoHeaderView.g(this.jXL) != null) {
                MPVideoHeaderView.g(this.jXL).fA(true);
                this.jXL.jXG.setVisibility(8);
            }
            AppMethodBeat.o(15255);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ MPVideoHeaderView jXL;
        final /* synthetic */ ad jXN;

        b(MPVideoHeaderView mPVideoHeaderView, ad adVar) {
            this.jXL = mPVideoHeaderView;
            this.jXN = adVar;
        }

        public final void run() {
            AppMethodBeat.i(138521);
            if (com.tencent.mm.ah.b.pW(this.jXL.talker) == null) {
                h qo = o.act().qo(this.jXL.talker);
                if (!(qo == null || bo.isNullOrNil(qo.acl()))) {
                    com.tencent.mm.plugin.brandservice.b.a.a(this.jXL.eks, this.jXN, qo.acl(), true);
                }
            }
            AppMethodBeat.o(138521);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;

        c(MPVideoHeaderView mPVideoHeaderView) {
            this.jXL = mPVideoHeaderView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(15252);
            this.jXL.jXA.setVisibility(8);
            this.jXL.jXz.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
            this.jXL.jXz.requestLayout();
            AppMethodBeat.o(15252);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements OnClickListener {
        final /* synthetic */ MPVideoHeaderView jXL;
        final /* synthetic */ jz jXO;

        d(MPVideoHeaderView mPVideoHeaderView, jz jzVar) {
            this.jXL = mPVideoHeaderView;
            this.jXO = jzVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(15254);
            if (this.jXO.vMP == 1) {
                MPVideoHeaderView.e(this.jXL).ao(2, "");
                AppMethodBeat.o(15254);
                return;
            }
            MPVideoHeaderView.e(this.jXL).ao(1, "");
            this.jXL.jXu = true;
            AppMethodBeat.o(15254);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class a implements com.tencent.mm.model.ao.b.a {
        final /* synthetic */ WeakReference jXM;

        a(WeakReference weakReference) {
            this.jXM = weakReference;
        }

        public final void o(String str, boolean z) {
            AppMethodBeat.i(138520);
            ImageView imageView = (ImageView) this.jXM.get();
            if (imageView == null) {
                AppMethodBeat.o(138520);
                return;
            }
            j.o(imageView, "weakReference.get() ?: return@GetContactCallBack");
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
            if (aoO == null || aoO.Oh() <= 0) {
                AppMethodBeat.o(138520);
                return;
            }
            if (imageView.getTag() instanceof String) {
                o.acv().pZ(str);
                Object tag = imageView.getTag();
                if (tag == null) {
                    v vVar = new v("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(138520);
                    throw vVar;
                } else if (bo.isEqual((String) tag, str)) {
                    h qo = o.act().qo(str);
                    if (qo == null || bo.isNullOrNil(qo.acl())) {
                        com.tencent.mm.pluginsdk.ui.a.b.r(imageView, str);
                    } else {
                        com.tencent.mm.plugin.brandservice.b.a.a(imageView, aoO, qo.acl(), true);
                        AppMethodBeat.o(138520);
                        return;
                    }
                }
            }
            AppMethodBeat.o(138520);
        }
    }

    public static final /* synthetic */ b e(MPVideoHeaderView mPVideoHeaderView) {
        AppMethodBeat.i(15267);
        b bVar = mPVideoHeaderView.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        AppMethodBeat.o(15267);
        return bVar;
    }

    public static final /* synthetic */ MPVideoWriteCommentLayout g(MPVideoHeaderView mPVideoHeaderView) {
        AppMethodBeat.i(15268);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = mPVideoHeaderView.jWN;
        if (mPVideoWriteCommentLayout == null) {
            j.avw("writeCommentLayout");
        }
        AppMethodBeat.o(15268);
        return mPVideoWriteCommentLayout;
    }

    public MPVideoHeaderView(final Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(15266);
        View.inflate(context, R.layout.ahk, this);
        View findViewById = findViewById(R.id.dd8);
        j.o(findViewById, "findViewById(R.id.biz_video_avatar_layout)");
        this.jXw = (LinearLayout) findViewById;
        findViewById = findViewById(R.id.dcq);
        j.o(findViewById, "findViewById(R.id.biz_video_avatar_iv)");
        this.eks = (ImageView) findViewById;
        findViewById = findViewById(R.id.dd9);
        j.o(findViewById, "findViewById(R.id.biz_video_nick_name_tv)");
        this.jXx = (TextView) findViewById;
        findViewById = findViewById(R.id.dda);
        j.o(findViewById, "findViewById(R.id.biz_video_title_tv)");
        this.jXy = (MMNeat7extView) findViewById;
        findViewById = findViewById(R.id.ddd);
        j.o(findViewById, "findViewById(R.id.biz_video_desc_tv)");
        this.jXz = (MMNeat7extView) findViewById;
        findViewById = findViewById(R.id.dde);
        j.o(findViewById, "findViewById(R.id.biz_video_desc_show_more_layout)");
        this.jXA = findViewById;
        findViewById = findViewById(R.id.ddc);
        j.o(findViewById, "findViewById(R.id.biz_video_desc_layout)");
        this.jXB = findViewById;
        findViewById = findViewById(R.id.ddg);
        j.o(findViewById, "findViewById(R.id.biz_video_time_tv)");
        this.timeTv = (TextView) findViewById;
        findViewById = findViewById(R.id.ddh);
        j.o(findViewById, "findViewById(R.id.biz_video_read_count_tv)");
        this.jXC = (TextView) findViewById;
        findViewById = findViewById(R.id.ddj);
        j.o(findViewById, "findViewById(R.id.biz_video_haokan_tv)");
        this.jXD = (TextView) findViewById;
        findViewById = findViewById(R.id.ddi);
        j.o(findViewById, "findViewById(R.id.biz_video_haokan_count_tv)");
        this.jXE = (TextView) findViewById;
        findViewById = findViewById(R.id.ddb);
        j.o(findViewById, "findViewById(R.id.biz_video_malicious_tips)");
        this.jXF = (TextView) findViewById;
        findViewById = findViewById(R.id.ddk);
        j.o(findViewById, "findViewById(R.id.biz_video_write_wow_tips_layout)");
        this.jXG = findViewById;
        findViewById = findViewById(R.id.ddn);
        j.o(findViewById, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
        this.jXH = (TextView) findViewById;
        findViewById = findViewById(R.id.ddl);
        j.o(findViewById, "findViewById(R.id.biz_video_write_wow_tips_icon)");
        this.jXI = (ImageView) findViewById;
        findViewById = findViewById(R.id.ddf);
        j.o(findViewById, "findViewById(R.id.biz_video_header_data_layout)");
        this.jXJ = findViewById;
        TextPaint paint = this.jXy.getPaint();
        j.o(paint, "tp");
        paint.setFakeBoldText(true);
        this.jXw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoHeaderView jXL;

            public final void onClick(View view) {
                AppMethodBeat.i(15251);
                if ((MPVideoHeaderView.e(this.jXL).fgc & 1) != 0) {
                    ab.w(this.jXL.TAG, "not allow jump to profile " + MPVideoHeaderView.e(this.jXL).fgc);
                    AppMethodBeat.o(15251);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.jXL.talker);
                intent.putExtra("Contact_Scene", 152);
                com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(15251);
            }
        });
        AppMethodBeat.o(15266);
    }

    public final void initView() {
        AppMethodBeat.i(15256);
        aYL();
        TextView textView = this.timeTv;
        Context context = getContext();
        r rVar = this.jVG;
        if (rVar == null) {
            j.avw("msgInfo");
        }
        textView.setText(com.tencent.mm.plugin.brandservice.ui.b.b.e(context, rVar.fjT.time * 1000));
        p pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        if (bo.isNullOrNil(pVar.fjz)) {
            this.jXB.setVisibility(8);
        } else {
            this.jXB.setVisibility(0);
            aYK();
        }
        MMNeat7extView mMNeat7extView = this.jXy;
        r rVar2 = this.jVG;
        if (rVar2 == null) {
            j.avw("msgInfo");
        }
        mMNeat7extView.ah(rVar2.fjT.title);
        AppMethodBeat.o(15256);
    }

    public final void setMaliciousInfo(bac bac) {
        AppMethodBeat.i(15257);
        j.p(bac, "info");
        this.jXF.setVisibility(0);
        this.jXF.setText(bac.wDU);
        AppMethodBeat.o(15257);
    }

    public final void setOriginInfo(eg egVar) {
        AppMethodBeat.i(15258);
        j.p(egVar, "info");
        p pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        pVar.title = egVar.title;
        pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        pVar.fjz = egVar.fjz;
        initView();
        AppMethodBeat.o(15258);
    }

    private final void aYK() {
        int dPe;
        AppMethodBeat.i(15259);
        MMNeat7extView mMNeat7extView = this.jXz;
        p pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        if (pVar == null) {
            j.dWJ();
        }
        mMNeat7extView.ah(pVar.fjz);
        com.tencent.neattextview.textview.layout.a QV = this.jXz.QV(com.tencent.mm.bz.a.gd(getContext()) - com.tencent.mm.bz.a.fromDPToPix(getContext(), 32));
        if (QV != null) {
            dPe = QV.dPe();
        } else {
            dPe = 0;
        }
        if (dPe > 4) {
            float textSize = this.jXz.getTextSize();
            this.jXz.a(TruncateAt.END, textSize);
            this.jXA.setMinimumHeight((int) textSize);
            this.jXA.setVisibility(0);
            this.jXz.setMaxLines(4);
            this.jXB.setOnClickListener(new c(this));
        }
        AppMethodBeat.o(15259);
    }

    private final void aYL() {
        String str = null;
        AppMethodBeat.i(138522);
        com.tencent.mm.pluginsdk.ui.a.b.r(this.eks, this.talker);
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(this.talker);
        r rVar;
        String str2;
        if (aoO == null || aoO.Oh() <= 0) {
            Object HE;
            rVar = this.jVG;
            if (rVar == null) {
                j.avw("msgInfo");
            }
            str2 = rVar != null ? rVar.fjR : null;
            ImageView imageView = this.eks;
            rVar = this.jVG;
            if (rVar == null) {
                j.avw("msgInfo");
            }
            if (rVar != null) {
                HE = rVar.HE();
            } else {
                HE = null;
            }
            imageView.setTag(HE);
            WeakReference weakReference = new WeakReference(this.eks);
            com.tencent.mm.model.ao.b Zu = com.tencent.mm.model.ao.a.Zu();
            rVar = this.jVG;
            if (rVar == null) {
                j.avw("msgInfo");
            }
            if (rVar != null) {
                str = rVar.HE();
            }
            Zu.a(str, "", new a(weakReference));
            str = str2;
        } else {
            String HE2;
            if (!aoO.NX()) {
                al.n(new b(this, aoO), 200);
            }
            rVar = this.jVG;
            if (rVar == null) {
                j.avw("msgInfo");
            }
            if (rVar != null) {
                HE2 = rVar.HE();
            } else {
                HE2 = null;
            }
            str2 = s.mJ(HE2);
            if (bo.isEqual(str2, this.talker)) {
                rVar = this.jVG;
                if (rVar == null) {
                    j.avw("msgInfo");
                }
                if (rVar != null) {
                    HE2 = rVar.fjR;
                } else {
                    HE2 = null;
                }
                if (!bo.isNullOrNil(HE2)) {
                    rVar = this.jVG;
                    if (rVar == null) {
                        j.avw("msgInfo");
                    }
                    if (rVar != null) {
                        str = rVar.fjR;
                    }
                }
            }
            str = str2;
        }
        SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), (CharSequence) str + "  ", this.jXx.getTextSize());
        Context context = getContext();
        j.o(context, "context");
        Drawable drawable = context.getResources().getDrawable(R.drawable.axm);
        int textSize = (int) this.jXx.getTextSize();
        drawable.setBounds(0, 0, textSize / 2, textSize);
        new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable), 0, 1, 33);
        this.jXx.setText(TextUtils.concat(new CharSequence[]{b, r2}));
        AppMethodBeat.o(138522);
    }

    public final void a(jz jzVar) {
        AppMethodBeat.i(15262);
        j.p(jzVar, "appMsgStat");
        this.jXv = jzVar;
        if (jzVar.enabled == 1) {
            this.jXC.setVisibility(0);
            TextView textView = this.jXC;
            Context context = getContext();
            Object[] objArr = new Object[1];
            Context context2 = getContext();
            j.o(context2, "context");
            objArr[0] = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.G(context2, jzVar.vMN);
            textView.setText(context.getString(R.string.g5u, objArr));
        } else {
            this.jXC.setVisibility(8);
        }
        setWow(jzVar);
        AppMethodBeat.o(15262);
    }

    public final void setWow(jz jzVar) {
        AppMethodBeat.i(15263);
        j.p(jzVar, "appMsgStat");
        if (jzVar.vMQ != 1) {
            this.jXD.setVisibility(8);
            this.jXE.setVisibility(8);
            AppMethodBeat.o(15263);
            return;
        }
        int i;
        Context context;
        this.jXD.setVisibility(0);
        this.jXE.setVisibility(0);
        if (jzVar.vMP == 1) {
            this.jXD.setTextColor(getResources().getColor(R.color.h1));
            this.jXE.setTextColor(getResources().getColor(R.color.h1));
            i = R.drawable.ay0;
        } else {
            this.jXD.setTextColor(getResources().getColor(R.color.h3));
            this.jXE.setTextColor(getResources().getColor(R.color.h3));
            i = R.drawable.axy;
        }
        String string = getContext().getString(R.string.g5s);
        if (jzVar.vMO > 0) {
            this.jXE.setVisibility(0);
            TextView textView = this.jXE;
            context = getContext();
            j.o(context, "context");
            textView.setText(String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.G(context, jzVar.vMO)));
        } else {
            this.jXE.setText("");
            this.jXE.setVisibility(4);
        }
        context = getContext();
        j.o(context, "context");
        Drawable drawable = context.getResources().getDrawable(i);
        i = (int) (((double) this.jXx.getTextSize()) * 1.3d);
        drawable.setBounds(0, 0, i, i);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        new SpannableString("@").setSpan(aVar, 0, 1, 33);
        this.jXD.setText(TextUtils.concat(new CharSequence[]{r1, " ", string}));
        this.jXD.setOnClickListener(new d(this, jzVar));
        AppMethodBeat.o(15263);
    }

    public final void setWriteCommentLayout(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.i(15264);
        j.p(mPVideoWriteCommentLayout, "layout");
        this.jWN = mPVideoWriteCommentLayout;
        AppMethodBeat.o(15264);
    }

    public final void setWowEduView(MPVideoWowEduView mPVideoWowEduView) {
        AppMethodBeat.i(15265);
        j.p(mPVideoWowEduView, "view");
        this.jXK = mPVideoWowEduView;
        AppMethodBeat.o(15265);
    }
}
