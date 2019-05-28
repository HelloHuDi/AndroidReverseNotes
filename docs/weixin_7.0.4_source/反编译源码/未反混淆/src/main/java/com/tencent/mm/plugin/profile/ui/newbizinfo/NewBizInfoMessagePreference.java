package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

public class NewBizInfoMessagePreference extends Preference {
    private MMActivity crP;
    private ad ehM;
    private RecyclerView iJP;
    private View jcv;
    private boolean lyb = false;
    private d ppN;
    private a pqe;
    private int state = 1;

    public static class a extends android.support.v7.widget.RecyclerView.a<a> {
        private static final int IMAGE_WIDTH = ah.getResources().getDimensionPixelSize(R.dimen.ng);
        private static int pqg = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 6);
        private static int pqh = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 4);
        private static int pqi = 13;
        private static int pqj = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 1);
        private static int pqk = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8);
        private static int pql = 13;
        private MMActivity crP;
        private ad ehM;
        private List<b> pqf = new ArrayList();

        public class a extends v implements OnClickListener {
            public TextView eku;
            public ImageView iyo;
            public LinearLayout kuD;
            public ImageView pnv;
            public View pqm;
            public b pqn;

            public a(View view) {
                super(view);
                AppMethodBeat.i(23883);
                this.pnv = (ImageView) view.findViewById(R.id.b3o);
                this.iyo = (ImageView) view.findViewById(R.id.b3p);
                this.eku = (TextView) view.findViewById(R.id.b3q);
                this.kuD = (LinearLayout) view.findViewById(R.id.b1h);
                this.pqm = view.findViewById(R.id.b3r);
                view.setOnClickListener(this);
                AppMethodBeat.o(23883);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(23884);
                ab.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", this.pqn.pqv);
                int intExtra = a.this.crP.getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
                Intent intent = new Intent();
                String c = l.c(this.pqn.pqv, 126, intExtra, 0);
                intent.putExtra("rawUrl", c);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                String stringExtra = a.this.crP.getIntent().getStringExtra("prePublishId");
                if (bo.isNullOrNil(stringExtra)) {
                    intent.putExtra("prePublishId", "brand_profile");
                    intent.putExtra("KPublisherId", "brand_profile");
                } else {
                    intent.putExtra("KPublisherId", stringExtra);
                    intent.putExtra("prePublishId", stringExtra);
                    intent.putExtra("preUsername", a.this.crP.getIntent().getStringExtra("preUsername"));
                    intent.putExtra("preChatName", a.this.crP.getIntent().getStringExtra("preChatName"));
                }
                intent.putExtra("preChatTYPE", a.this.crP.getIntent().getIntExtra("preChatTYPE", 0));
                int intExtra2 = a.this.crP.getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                if (this.pqn.type == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
                    intent.putExtra("biz_video_title", this.pqn.title);
                    intent.putExtra("biz_video_desc", this.pqn.pqC);
                    intent.putExtra("biz_video_icon_url", this.pqn.hAg);
                    intent.putExtra("srcUsername", a.this.ehM.field_username);
                    intent.putExtra("srcDisplayname", a.this.ehM.Oi());
                    intent.putExtra("biz_video_item_show_type", this.pqn.type);
                    intent.putExtra("biz_video_pub_time", (long) this.pqn.oyB);
                    intent.putExtra("biz_video_duration", this.pqn.eWK);
                    intent.putExtra("biz_video_width", this.pqn.videoWidth);
                    intent.putExtra("biz_video_height", this.pqn.videoHeight);
                    intent.putExtra("biz_video_vid", this.pqn.fgd);
                    intent.putExtra("biz_video_scene", 126);
                    intent.putExtra("biz_video_subscene", intExtra2);
                    ab.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
                    int[] iArr = new int[2];
                    View findViewById = view.findViewById(R.id.b3o);
                    if (findViewById != null) {
                        int width = findViewById.getWidth();
                        int height = findViewById.getHeight();
                        findViewById.getLocationInWindow(iArr);
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    }
                    intent.addFlags(268435456);
                    com.tencent.mm.bp.d.b(a.this.crP, "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent);
                    AppMethodBeat.o(23884);
                } else if (((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(6) && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(a.this.crP, c, this.pqn.type, 126, intExtra2, intent)) {
                    ab.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
                    AppMethodBeat.o(23884);
                } else {
                    com.tencent.mm.bp.d.b(a.this.crP, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(23884);
                }
            }
        }

        static {
            AppMethodBeat.i(23889);
            AppMethodBeat.o(23889);
        }

        public a(MMActivity mMActivity, List<b> list, ad adVar) {
            AppMethodBeat.i(23885);
            this.crP = mMActivity;
            this.pqf = list;
            this.ehM = adVar;
            AppMethodBeat.o(23885);
        }

        public final int getItemCount() {
            AppMethodBeat.i(23886);
            if (this.pqf == null) {
                AppMethodBeat.o(23886);
                return 0;
            }
            int size = this.pqf.size();
            AppMethodBeat.o(23886);
            return size;
        }
    }

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23890);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23890);
    }

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23891);
        this.crP = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(23891);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23892);
        this.iJP = (RecyclerView) view.findViewById(R.id.b3m);
        this.iJP.setLayoutManager(new LinearLayoutManager());
        this.iJP.setNestedScrollingEnabled(false);
        this.jcv = view.findViewById(R.id.b3i);
        this.lyb = true;
        initView();
        AppMethodBeat.o(23892);
    }

    private void initView() {
        AppMethodBeat.i(23893);
        if (this.lyb) {
            if (this.state == 1) {
                this.jcv.setVisibility(0);
            } else if (this.state == 2) {
                this.iJP.setVisibility(8);
                this.jcv.setVisibility(0);
                AppMethodBeat.o(23893);
                return;
            } else if (this.state == 3) {
                this.jcv.setVisibility(8);
                this.iJP.setVisibility(0);
                this.iJP.setAdapter(this.pqe);
                AppMethodBeat.o(23893);
                return;
            }
            this.iJP.setVisibility(8);
            AppMethodBeat.o(23893);
            return;
        }
        AppMethodBeat.o(23893);
    }

    public final void a(d dVar, ad adVar) {
        AppMethodBeat.i(23894);
        this.ehM = adVar;
        if (dVar == null) {
            AppMethodBeat.o(23894);
            return;
        }
        this.ppN = dVar;
        this.pqe = new a(this.crP, dVar.cbL(), adVar);
        cbv();
        initView();
        AppMethodBeat.o(23894);
    }

    private void cbv() {
        AppMethodBeat.i(23895);
        if (this.ppN == null) {
            this.state = 0;
            AppMethodBeat.o(23895);
            return;
        }
        if (!this.ppN.cbO()) {
            this.state = 4;
        } else if (this.ppN.cbL().size() <= 0) {
            this.state = 2;
            AppMethodBeat.o(23895);
            return;
        } else if (this.ppN.cbL().size() > 0) {
            this.state = 3;
            AppMethodBeat.o(23895);
            return;
        }
        AppMethodBeat.o(23895);
    }
}
