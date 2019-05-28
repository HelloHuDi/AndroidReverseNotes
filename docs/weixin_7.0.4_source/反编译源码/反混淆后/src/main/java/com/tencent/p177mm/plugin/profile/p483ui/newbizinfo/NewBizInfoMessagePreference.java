package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C12865b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C46140d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference */
public class NewBizInfoMessagePreference extends Preference {
    private MMActivity crP;
    private C7616ad ehM;
    private RecyclerView iJP;
    private View jcv;
    private boolean lyb = false;
    private C46140d ppN;
    private C21492a pqe;
    private int state = 1;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference$a */
    public static class C21492a extends C41523a<C21493a> {
        private static final int IMAGE_WIDTH = C4996ah.getResources().getDimensionPixelSize(C25738R.dimen.f10014ng);
        private static int pqg = C1338a.fromDPToPix(C4996ah.getContext(), 6);
        private static int pqh = C1338a.fromDPToPix(C4996ah.getContext(), 4);
        private static int pqi = 13;
        private static int pqj = C1338a.fromDPToPix(C4996ah.getContext(), 1);
        private static int pqk = C1338a.fromDPToPix(C4996ah.getContext(), 8);
        private static int pql = 13;
        private MMActivity crP;
        private C7616ad ehM;
        private List<C12865b> pqf = new ArrayList();

        /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference$a$a */
        public class C21493a extends C41531v implements OnClickListener {
            public TextView eku;
            public ImageView iyo;
            public LinearLayout kuD;
            public ImageView pnv;
            public View pqm;
            public C12865b pqn;

            public C21493a(View view) {
                super(view);
                AppMethodBeat.m2504i(23883);
                this.pnv = (ImageView) view.findViewById(2131823048);
                this.iyo = (ImageView) view.findViewById(2131823049);
                this.eku = (TextView) view.findViewById(2131823050);
                this.kuD = (LinearLayout) view.findViewById(2131822967);
                this.pqm = view.findViewById(2131823051);
                view.setOnClickListener(this);
                AppMethodBeat.m2505o(23883);
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23884);
                C4990ab.m7417i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", this.pqn.pqv);
                int intExtra = C21492a.this.crP.getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
                Intent intent = new Intent();
                String c = C1192l.m2621c(this.pqn.pqv, 126, intExtra, 0);
                intent.putExtra("rawUrl", c);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                String stringExtra = C21492a.this.crP.getIntent().getStringExtra("prePublishId");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    intent.putExtra("prePublishId", "brand_profile");
                    intent.putExtra("KPublisherId", "brand_profile");
                } else {
                    intent.putExtra("KPublisherId", stringExtra);
                    intent.putExtra("prePublishId", stringExtra);
                    intent.putExtra("preUsername", C21492a.this.crP.getIntent().getStringExtra("preUsername"));
                    intent.putExtra("preChatName", C21492a.this.crP.getIntent().getStringExtra("preChatName"));
                }
                intent.putExtra("preChatTYPE", C21492a.this.crP.getIntent().getIntExtra("preChatTYPE", 0));
                int intExtra2 = C21492a.this.crP.getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                if (this.pqn.type == 5 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                    intent.putExtra("biz_video_title", this.pqn.title);
                    intent.putExtra("biz_video_desc", this.pqn.pqC);
                    intent.putExtra("biz_video_icon_url", this.pqn.hAg);
                    intent.putExtra("srcUsername", C21492a.this.ehM.field_username);
                    intent.putExtra("srcDisplayname", C21492a.this.ehM.mo16706Oi());
                    intent.putExtra("biz_video_item_show_type", this.pqn.type);
                    intent.putExtra("biz_video_pub_time", (long) this.pqn.oyB);
                    intent.putExtra("biz_video_duration", this.pqn.eWK);
                    intent.putExtra("biz_video_width", this.pqn.videoWidth);
                    intent.putExtra("biz_video_height", this.pqn.videoHeight);
                    intent.putExtra("biz_video_vid", this.pqn.fgd);
                    intent.putExtra("biz_video_scene", 126);
                    intent.putExtra("biz_video_subscene", intExtra2);
                    C4990ab.m7416i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
                    int[] iArr = new int[2];
                    View findViewById = view.findViewById(2131823048);
                    if (findViewById != null) {
                        int width = findViewById.getWidth();
                        int height = findViewById.getHeight();
                        findViewById.getLocationInWindow(iArr);
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    }
                    intent.addFlags(268435456);
                    C25985d.m41467b(C21492a.this.crP, "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent);
                    AppMethodBeat.m2505o(23884);
                } else if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(6) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(C21492a.this.crP, c, this.pqn.type, 126, intExtra2, intent)) {
                    C4990ab.m7416i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
                    AppMethodBeat.m2505o(23884);
                } else {
                    C25985d.m41467b(C21492a.this.crP, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(23884);
                }
            }
        }

        static {
            AppMethodBeat.m2504i(23889);
            AppMethodBeat.m2505o(23889);
        }

        public C21492a(MMActivity mMActivity, List<C12865b> list, C7616ad c7616ad) {
            AppMethodBeat.m2504i(23885);
            this.crP = mMActivity;
            this.pqf = list;
            this.ehM = c7616ad;
            AppMethodBeat.m2505o(23885);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(23886);
            if (this.pqf == null) {
                AppMethodBeat.m2505o(23886);
                return 0;
            }
            int size = this.pqf.size();
            AppMethodBeat.m2505o(23886);
            return size;
        }
    }

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23890);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23890);
    }

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23891);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.m2505o(23891);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23892);
        this.iJP = (RecyclerView) view.findViewById(2131823046);
        this.iJP.setLayoutManager(new LinearLayoutManager());
        this.iJP.setNestedScrollingEnabled(false);
        this.jcv = view.findViewById(2131823042);
        this.lyb = true;
        initView();
        AppMethodBeat.m2505o(23892);
    }

    private void initView() {
        AppMethodBeat.m2504i(23893);
        if (this.lyb) {
            if (this.state == 1) {
                this.jcv.setVisibility(0);
            } else if (this.state == 2) {
                this.iJP.setVisibility(8);
                this.jcv.setVisibility(0);
                AppMethodBeat.m2505o(23893);
                return;
            } else if (this.state == 3) {
                this.jcv.setVisibility(8);
                this.iJP.setVisibility(0);
                this.iJP.setAdapter(this.pqe);
                AppMethodBeat.m2505o(23893);
                return;
            }
            this.iJP.setVisibility(8);
            AppMethodBeat.m2505o(23893);
            return;
        }
        AppMethodBeat.m2505o(23893);
    }

    /* renamed from: a */
    public final void mo74085a(C46140d c46140d, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23894);
        this.ehM = c7616ad;
        if (c46140d == null) {
            AppMethodBeat.m2505o(23894);
            return;
        }
        this.ppN = c46140d;
        this.pqe = new C21492a(this.crP, c46140d.cbL(), c7616ad);
        cbv();
        initView();
        AppMethodBeat.m2505o(23894);
    }

    private void cbv() {
        AppMethodBeat.m2504i(23895);
        if (this.ppN == null) {
            this.state = 0;
            AppMethodBeat.m2505o(23895);
            return;
        }
        if (!this.ppN.cbO()) {
            this.state = 4;
        } else if (this.ppN.cbL().size() <= 0) {
            this.state = 2;
            AppMethodBeat.m2505o(23895);
            return;
        } else if (this.ppN.cbL().size() > 0) {
            this.state = 3;
            AppMethodBeat.m2505o(23895);
            return;
        }
        AppMethodBeat.m2505o(23895);
    }
}
