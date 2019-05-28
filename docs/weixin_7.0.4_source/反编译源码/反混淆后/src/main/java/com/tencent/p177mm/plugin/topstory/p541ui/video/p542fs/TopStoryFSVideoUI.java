package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1397a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42007im;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C29431c;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35292i;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13954d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13979m;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C39991p;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C39996r;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4233e;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4239l;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46311o;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C40003c;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C40003c.C40004a;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C4251f;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C46312b;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C46312b.C35321a;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.TopStoryCommentFloatDialog;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.TopStoryCommentFloatDialog.C14003a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.abz;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chr;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI */
public class TopStoryFSVideoUI extends MMActivity implements C29431c, C4232b {
    private static long sGE = 0;
    protected C41530m eja = new C3997514();
    protected ImageButton oOO;
    private Point qLw;
    protected LinearLayoutManager qYS;
    protected View qpb;
    protected chv sBa;
    protected View sDU;
    protected ImageView sDV;
    protected RecyclerView sDY;
    protected int sEg = 0;
    protected long sEh = -1;
    protected long sEi = -1;
    private C4239l sEk;
    private C46311o sEl;
    private C13979m sEm;
    C39996r sEn;
    C13986n sEo;
    private boolean sEp;
    protected C46312b sEq;
    private C17487am sEr;
    private C1202f sEu = new C399775();
    C40003c sGA;
    View sGB;
    TopStoryCommentFloatDialog sGC;
    private boolean sGD;
    protected C46305i sGs;
    protected C39982h sGt;
    private ProgressDialog sGu;
    private View sGv;
    private View sGw;
    private View sGx;
    private Button sGy;
    View sGz;
    private int videoHeight;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$12 */
    class C1395612 implements OnTouchListener {
        C1395612() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(1966);
            if (TopStoryFSVideoUI.this.sGz.getVisibility() == 0) {
                if (TopStoryFSVideoUI.m68458f(TopStoryFSVideoUI.this.sGB, motionEvent.getX(), motionEvent.getY())) {
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                    AppMethodBeat.m2505o(1966);
                    return false;
                }
                TopStoryFSVideoUI.this.sGz.setVisibility(8);
            }
            AppMethodBeat.m2505o(1966);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$1 */
    class C139571 implements OnClickListener {
        C139571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1951);
            TopStoryFSVideoUI.m68451a(TopStoryFSVideoUI.this);
            AppMethodBeat.m2505o(1951);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$10 */
    class C2240510 implements OnClickListener {
        C2240510() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1964);
            TopStoryFSVideoUI.this.finish();
            AppMethodBeat.m2505o(1964);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$11 */
    class C2240611 implements OnCancelListener {
        C2240611() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(1965);
            TopStoryFSVideoUI.this.finish();
            AppMethodBeat.m2505o(1965);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$6 */
    class C224076 implements Runnable {
        C224076() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1958);
            C46305i c46305i = TopStoryFSVideoUI.this.sGs;
            int footersCount = c46305i.getFootersCount();
            int itemCount = c46305i.getItemCount();
            c46305i.cGm();
            c46305i.mo66311au(itemCount - footersCount, footersCount);
            AppMethodBeat.m2505o(1958);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$9 */
    class C224099 implements OnClickListener {
        C224099() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1963);
            TopStoryFSVideoUI.this.cHh();
            AppMethodBeat.m2505o(1963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$8 */
    class C294428 implements Runnable {
        C294428() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1962);
            if (TopStoryFSVideoUI.this.sGz.getVisibility() == 0) {
                TopStoryFSVideoUI.this.sGz.setVisibility(8);
            }
            AppMethodBeat.m2505o(1962);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$14 */
    class C3997514 extends C41530m {
        C3997514() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(1968);
            switch (i) {
                case 0:
                    TopStoryFSVideoUI.this.sGt.mo26188b(TopStoryFSVideoUI.this);
                    break;
            }
            AppMethodBeat.m2505o(1968);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(1969);
            if (i2 == 0) {
                AppMethodBeat.m2505o(1969);
                return;
            }
            TopStoryFSVideoUI.this.cGG();
            AppMethodBeat.m2505o(1969);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$3 */
    class C399763 implements Runnable {
        C399763() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1954);
            TopStoryFSVideoUI.this.sGw.setVisibility(4);
            TopStoryFSVideoUI.this.sGv.setVisibility(4);
            TopStoryFSVideoUI.this.sDY.mo66329a(0, 3, null);
            if (TopStoryFSVideoUI.this.sGu != null) {
                TopStoryFSVideoUI.this.sGu.dismiss();
                TopStoryFSVideoUI.this.sGu = null;
            }
            AppMethodBeat.m2505o(1954);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$5 */
    class C399775 implements C1202f {
        C399775() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(1957);
            final C35292i c35292i = (C35292i) c1207m;
            chr chr = (chr) c35292i.ehh.fsG.fsP;
            if (i == 0 && i2 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("docId", chr.wUo);
                    jSONObject.put("opType", "LIKE");
                    jSONObject.put("isLike", chr.nbk == 4);
                } catch (JSONException e) {
                }
                if (c35292i.sAX != null) {
                    boolean z;
                    chw chw = c35292i.sAX;
                    if (chr.nbk == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    chw.xhh = z;
                }
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb:" + c35292i.sAX.xhh);
                if (chr.nbk == 4) {
                    View view;
                    C46927h b = TopStoryFSVideoUI.this.cGa().mo9200b(c35292i.sAX);
                    if (TopStoryFSVideoUI.this.sEn.sFv == null || TopStoryFSVideoUI.this.sEn.sFv.xgS == null || !TopStoryFSVideoUI.this.sEn.sFv.xgS.equals(c35292i.sAX.xgS) || !(b instanceof C29454g)) {
                        view = null;
                    } else {
                        view = b.getWowView();
                    }
                    if (view != null) {
                        TopStoryFSVideoUI.this.mo63194a(c35292i.sAX, view, true);
                        if (b instanceof C29454g) {
                            b.cGA().getControlBar().show();
                        }
                    }
                } else {
                    if (c35292i.cFw().xgy) {
                        C30379h.m48461b(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(C25738R.string.exf), "", true);
                    } else {
                        C23639t.makeText(TopStoryFSVideoUI.this.mController.ylL, C25738R.string.gab, 0).show();
                    }
                    TopStoryFSVideoUI.this.mo63194a(c35292i.sAX, null, false);
                }
                C42007im c42007im = new C42007im();
                c42007im.cDD.cDE = jSONObject.toString();
                c42007im.cDD.cDF = "";
                C4879a.xxA.mo10055m(c42007im);
            } else {
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C23639t.makeText(TopStoryFSVideoUI.this.mController.ylL, TopStoryFSVideoUI.this.getString(C25738R.string.ex8), 0).show();
                if (c35292i.sAX != null) {
                    c35292i.sAX.xhh = !c35292i.sAX.xhh;
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + c35292i.sAX.xhh);
                }
            }
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1956);
                    C46927h b = TopStoryFSVideoUI.this.cGa().mo9200b(c35292i.sAX);
                    if (b != null && (b instanceof C29454g)) {
                        ((C22411f) b.cGA().getControlBar()).mo37955h(c35292i.sAX);
                    }
                    AppMethodBeat.m2505o(1956);
                }
            });
            AppMethodBeat.m2505o(1957);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$13 */
    class C3997913 implements OnSystemUiVisibilityChangeListener {
        C3997913() {
        }

        public final void onSystemUiVisibilityChange(int i) {
            AppMethodBeat.m2504i(1967);
            TopStoryFSVideoUI.m68453b(TopStoryFSVideoUI.this);
            AppMethodBeat.m2505o(1967);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public TopStoryFSVideoUI() {
        AppMethodBeat.m2504i(1970);
        AppMethodBeat.m2505o(1970);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1971);
        if (VERSION.SDK_INT >= 28) {
            this.ylm = true;
        }
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.sBa = new chv();
        try {
            this.sBa.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            finish();
        }
        this.sEo = new C13986n();
        this.sEo.sDo = this;
        this.sEm = new C13979m();
        this.sEm.mo26212d(this);
        this.sEl = new C46311o();
        this.sEl.mo74505d(this);
        this.sEn = new C39996r();
        this.sEn.mo63225d(this);
        this.sEk = new C4239l();
        this.sGt = new C39982h();
        if (this.sBa.xgH != null) {
            this.sEo.mo26224d(this.sBa.xgH);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.f12015pi));
        }
        if (this.sBa.xgJ) {
            this.sEk.sEM = true;
        }
        cGB();
        this.qpb = findViewById(2131827963);
        this.sDU = findViewById(2131828302);
        this.sDV = (ImageView) findViewById(2131828303);
        this.oOO = (ImageButton) findViewById(2131826267);
        this.oOO.getDrawable().setColorFilter(getResources().getColor(C25738R.color.a69), Mode.SRC_ATOP);
        this.oOO.setOnClickListener(new C139571());
        this.sDU.setOnClickListener(new C224099());
        this.sGx = findViewById(2131828300);
        this.sGy = (Button) findViewById(2131828301);
        this.sDY = (RecyclerView) findViewById(2131828299);
        this.sDY.mo66332a(this.eja);
        this.qYS = new LinearLayoutManager();
        this.sDY.setLayoutManager(this.qYS);
        this.sEr = C17487am.m27242e(this.qYS);
        this.sGs = new C46305i(this);
        C46305i c46305i = this.sGs;
        View inflate = LayoutInflater.from(this).inflate(2130970958, null);
        inflate.setLayoutParams(new LayoutParams(-1, -1));
        this.sGw = inflate.findViewById(2131828338);
        this.sGv = inflate.findViewById(2131824238);
        c46305i.mo9202ei(inflate);
        this.sDY.setAdapter(this.sGs);
        this.oOO.setOnClickListener(new C2240510());
        new C43696b().mo26237i(this.sDY);
        if (!cGI()) {
            this.sGw.setVisibility(4);
            this.sGv.setVisibility(4);
        } else if (this.sEk.isConnected()) {
            cHg();
            this.sGD = false;
            if (this.sBa.scene != 21 && this.sBa.xgI == null) {
                this.sGu = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C2240611());
            }
        } else {
            Toast.makeText(this, C25738R.string.dj3, 1).show();
            this.sGD = true;
        }
        this.sGs.sGI = true;
        this.sGx.setVisibility(8);
        if (this.sEk.cGN() && C39964g.cFp() && System.currentTimeMillis() - sGE > 86400000) {
            Toast.makeText(this, C25738R.string.exc, 0).show();
            sGE = System.currentTimeMillis();
        }
        this.sGz = findViewById(2131828304);
        this.sGB = findViewById(2131828305);
        this.sGz.setVisibility(8);
        this.sGz.setOnTouchListener(new C1395612());
        this.sGC = (TopStoryCommentFloatDialog) findViewById(2131828306);
        this.sGC.setVisibility(8);
        this.sGC.mo69382k(this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new C3997913());
        C1720g.m3540Rg().mo14539a(2802, this.sEu);
        AppMethodBeat.m2505o(1971);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cGG() {
        int i = 1;
        AppMethodBeat.m2504i(1972);
        this.sGt.mo26186a(this);
        this.sEg = this.qYS.mo1782iS();
        int itemCount = this.qYS.getItemCount();
        if (this.sEh <= 0 || C5046bo.m7525az(this.sEh) >= 50) {
            this.sEh = C5046bo.m7588yz();
            if (this.sEo.sEZ == 1 ? itemCount - this.sEg > 2 || this.sEo.sEY || C5046bo.m7525az(this.sEi) < 50 : this.sEg < itemCount - 1 || this.sEo.sEY || C5046bo.m7525az(this.sEi) < 50) {
                i = 0;
            }
            if (!cGI()) {
                i = 0;
            }
            if (i != 0) {
                this.sGw.setVisibility(0);
                this.sGv.setVisibility(0);
                this.sEo.mo26219FM(this.sEo.cGR());
            }
        }
        AppMethodBeat.m2505o(1972);
    }

    private boolean cGI() {
        if (this.sBa.scene == 36 || this.sBa.xgP) {
            return false;
        }
        return true;
    }

    private void cGB() {
        AppMethodBeat.m2504i(1973);
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (C1443d.m3067fP(19)) {
            decorView.setSystemUiVisibility(2);
        } else {
            decorView.setSystemUiVisibility(4102);
        }
        getWindow().addFlags(128);
        AppMethodBeat.m2505o(1973);
    }

    public final void cFN() {
        AppMethodBeat.m2504i(1974);
        this.qpb.animate().alpha(0.0f).setDuration(200).setStartDelay(1800);
        this.sGz.setVisibility(8);
        AppMethodBeat.m2505o(1974);
    }

    public final void cFO() {
        AppMethodBeat.m2504i(1975);
        this.qpb.animate().cancel();
        this.qpb.setAlpha(1.0f);
        AppMethodBeat.m2505o(1975);
    }

    /* renamed from: FC */
    public final boolean mo9157FC(int i) {
        AppMethodBeat.m2504i(1976);
        this.sGz.setVisibility(8);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i));
        try {
            if (i >= (this.sGs.getItemCount() - this.sGs.getFootersCount()) - this.sGs.getHeadersCount()) {
                AppMethodBeat.m2505o(1976);
                return false;
            }
            this.sDY.smoothScrollToPosition(this.sGs.getHeadersCount() + i);
            AppMethodBeat.m2505o(1976);
            return true;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(1976);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130970946;
    }

    public final void cGe() {
    }

    public final void cGf() {
    }

    /* renamed from: a */
    public final void mo9160a(bzs bzs) {
    }

    /* renamed from: fS */
    public final boolean mo9189fS(int i, int i2) {
        return true;
    }

    public final int getForceOrientation() {
        AppMethodBeat.m2504i(1977);
        if (cGb()) {
            AppMethodBeat.m2505o(1977);
            return 1;
        }
        AppMethodBeat.m2505o(1977);
        return 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(1978);
        C39991p.sFq.mo63212a(this, i, i2, intent);
        if (i == 10001 && (this.sEk.bkJ() || C39964g.cFp())) {
            C46927h c = C13954d.m22095c(this);
            if (c != null) {
                c.mo47707mc(false);
            }
        }
        AppMethodBeat.m2505o(1978);
    }

    private void cHg() {
        AppMethodBeat.m2504i(1979);
        this.sGw.setVisibility(0);
        this.sGv.setVisibility(0);
        this.sEo.mo26219FM(0);
        AppMethodBeat.m2505o(1979);
    }

    public final C4239l cFQ() {
        return this.sEk;
    }

    public final C46311o cFR() {
        return this.sEl;
    }

    public final String cFS() {
        AppMethodBeat.m2504i(1980);
        String abz = C39964g.abz(this.sBa.xgj);
        AppMethodBeat.m2505o(1980);
        return abz;
    }

    public final chv cFT() {
        return this.sBa;
    }

    public final C13979m cFU() {
        return this.sEm;
    }

    public final C39996r cFV() {
        return this.sEn;
    }

    public final C13986n cGg() {
        return this.sEo;
    }

    public final String cGh() {
        return this.sBa.xgN == null ? "" : this.sBa.xgN;
    }

    public final void abI(String str) {
        this.sBa.xgN = str;
    }

    public final int cGi() {
        return this.sBa.xgO;
    }

    /* renamed from: FE */
    public final void mo9159FE(int i) {
        this.sBa.xgO = i;
    }

    public final boolean cGb() {
        return this.sBa.xgG == 100203;
    }

    public final int getVideoHeight() {
        int i;
        AppMethodBeat.m2504i(1981);
        if (this.videoHeight == 0) {
            if (cGb()) {
                this.videoHeight = ActUtil.HEIGHT;
                i = (cFW().y * 3) / 5;
                if (this.videoHeight > i) {
                    this.videoHeight = i;
                }
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i));
            } else {
                this.videoHeight = (getVideoWidth() * C31128d.MIC_PTU_TRANS_XINXIAN) / C19486m.CTRL_INDEX;
            }
        }
        i = this.videoHeight;
        AppMethodBeat.m2505o(1981);
        return i;
    }

    public final int getVideoWidth() {
        AppMethodBeat.m2504i(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        int min = Math.min(cFW().x, cFW().y);
        AppMethodBeat.m2505o(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        return min;
    }

    public final Point cFW() {
        AppMethodBeat.m2504i(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        if (this.qLw == null) {
            this.qLw = C5222ae.m7953hy(this);
        }
        Point point = this.qLw;
        AppMethodBeat.m2505o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        return point;
    }

    public final C17487am cFX() {
        return this.sEr;
    }

    public final C17480i getLayoutManager() {
        return this.qYS;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(Exif.PARSE_EXIF_ERROR_CORRUPT);
        if (i == 4 && this.sGC.getVisibility() == 0) {
            this.sGC.hide();
            AppMethodBeat.m2505o(Exif.PARSE_EXIF_ERROR_CORRUPT);
            return true;
        }
        if (i == 25 && keyEvent.getAction() == 0) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            chv chv = this.sBa;
            if (getSystemVolume() > 1) {
                z = false;
            }
            chv.eif = z;
            cGL();
        } else if (i == 24 && keyEvent.getAction() == 0) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
            this.sBa.eif = false;
            cGL();
        }
        z = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(Exif.PARSE_EXIF_ERROR_CORRUPT);
        return z;
    }

    @SuppressLint({"ResourceType"})
    private void cGL() {
        AppMethodBeat.m2504i(1987);
        if (this.sBa.eif) {
            this.sDV.setBackgroundResource(C1318a.top_story_volume_off);
        } else {
            this.sDV.setBackgroundResource(C1318a.top_story_volume_on);
        }
        if (this.sEn.sFw) {
            this.sEn.setMute(this.sBa.eif);
        }
        AppMethodBeat.m2505o(1987);
    }

    /* renamed from: DX */
    public final boolean mo9156DX() {
        return this.sBa.eif;
    }

    public final int cFY() {
        return this.sBa.xgL;
    }

    /* renamed from: FD */
    public final void mo9158FD(int i) {
        this.sBa.xgL = i;
    }

    public final boolean cFZ() {
        if (this.sBa.scene == 36) {
            return false;
        }
        return true;
    }

    public final C4233e cGa() {
        return this.sGs;
    }

    /* renamed from: i */
    public final void mo9194i(List<chw> list, boolean z) {
        AppMethodBeat.m2504i(1989);
        this.sGs.mo9205j(list, z);
        C5004al.m7442n(new C399763(), 50);
        AppMethodBeat.m2505o(1989);
    }

    public final void abH(final String str) {
        AppMethodBeat.m2504i(1990);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1955);
                TopStoryFSVideoUI.this.sGw.setVisibility(4);
                TopStoryFSVideoUI.this.sGv.setVisibility(4);
                if (TopStoryFSVideoUI.this.sGu != null) {
                    TopStoryFSVideoUI.this.sGu.dismiss();
                    TopStoryFSVideoUI.this.sGu = null;
                }
                TopStoryFSVideoUI.m68452a(TopStoryFSVideoUI.this, str);
                AppMethodBeat.m2505o(1955);
            }
        });
        AppMethodBeat.m2505o(1990);
    }

    public final boolean isFullscreenMode() {
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1991);
        C46297h.m86862a(this.sBa, dyi(), this.sEo.mo26218FL(this.sBa.xgL));
        C1720g.m3540Rg().mo14546b(2802, this.sEu);
        this.sEo.aEX();
        ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIDestroy(this.sBa);
        this.sEn.aEX();
        this.sEk.aEX();
        this.sEl.aEX();
        this.sEm.aEX();
        this.sGC.sIl.close();
        C14419a.m22633kT(16);
        super.onDestroy();
        AppMethodBeat.m2505o(1991);
    }

    public void onResume() {
        AppMethodBeat.m2504i(1992);
        super.onResume();
        cGB();
        cGL();
        ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIResume();
        this.sEn.akW();
        this.sEk.sEO = C4239l.cGO();
        this.sGC.onResume();
        C14419a.m22633kT(14);
        AppMethodBeat.m2505o(1992);
    }

    public void onPause() {
        AppMethodBeat.m2504i(1993);
        super.onPause();
        this.sEn.akV();
        ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIPause();
        this.sGC.onPause();
        C14419a.m22633kT(15);
        AppMethodBeat.m2505o(1993);
    }

    public final RecyclerView getRecyclerView() {
        return this.sDY;
    }

    /* renamed from: fP */
    public final void mo47665fP(int i, int i2) {
        AppMethodBeat.m2504i(1994);
        if ((i2 == 2 || i2 == 1) && this.sGD) {
            cHg();
        }
        this.sEn.mo63226fT(i, i2);
        AppMethodBeat.m2505o(1994);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void cGc() {
        AppMethodBeat.m2504i(1995);
        cGB();
        AppMethodBeat.m2505o(1995);
    }

    public final int cGd() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9161a(chw chw) {
        AppMethodBeat.m2504i(1996);
        if (chw != null) {
            if (C5023at.isConnected(this)) {
                boolean z;
                C1720g.m3540Rg().mo14541a(new C35292i(chw, chw.ubA, chw.xhh ? 5 : 4, System.currentTimeMillis(), this.sBa.scene, this.sBa.hlm, cGb() ? 318 : C16681c.CTRL_INDEX, chw.xgS, chw.xhi), 0);
                if (chw.xhh) {
                    z = false;
                } else {
                    z = true;
                }
                chw.xhh = z;
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + chw.xhh);
            } else {
                Toast.makeText(this.mController.ylL, getString(C25738R.string.ex8), 0).show();
                AppMethodBeat.m2505o(1996);
                return;
            }
        }
        AppMethodBeat.m2505o(1996);
    }

    public final void cGj() {
        AppMethodBeat.m2504i(1997);
        runOnUiThread(new C224076());
        AppMethodBeat.m2505o(1997);
    }

    public final int cGk() {
        AppMethodBeat.m2504i(1998);
        int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_topstory_v_video_play, 0);
        AppMethodBeat.m2505o(1998);
        return a;
    }

    /* renamed from: a */
    public final void mo63194a(final chw chw, View view, boolean z) {
        AppMethodBeat.m2504i(1999);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", chw.xgS, Boolean.valueOf(z));
        if (z) {
            C13944f c13944f = new C13944f(System.currentTimeMillis(), chw.ubA, "", "", "", "", chw.title, this.sBa.hlm, this.sBa.scene, cGb() ? 318 : C16681c.CTRL_INDEX, chw.xgS, chw.xhi);
            this.sGz.setVisibility(0);
            this.sGA = new C40003c(this.sGB, new C40004a() {

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI$7$1 */
                class C42341 implements C14003a {
                    C42341() {
                    }

                    public final void onDismiss() {
                        AppMethodBeat.m2504i(1959);
                        TopStoryFSVideoUI.this.sEn.cEf();
                        TopStoryFSVideoUI.m68453b(TopStoryFSVideoUI.this);
                        AppMethodBeat.m2505o(1959);
                    }

                    public final void cHi() {
                        AppMethodBeat.m2504i(1960);
                        TopStoryFSVideoUI.this.sGz.setVisibility(8);
                        AppMethodBeat.m2505o(1960);
                    }
                }

                /* renamed from: a */
                public final void mo9227a(C13944f c13944f) {
                    AppMethodBeat.m2504i(1961);
                    TopStoryFSVideoUI.this.sGC.mo69378a(c13944f, new C42341(), (int) TopStoryFSVideoUI.this.sBa.xgG, chw.xgW);
                    if (TopStoryFSVideoUI.this.sEn.cGZ()) {
                        TopStoryFSVideoUI.this.sEn.cpN();
                    }
                    AppMethodBeat.m2505o(1961);
                }
            }, c13944f, chw.xgS);
            this.sGz.postDelayed(new C294428(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.sGA.mo63238a(view, true, C4251f.dip2px(this, 10.0f));
            AppMethodBeat.m2505o(1999);
            return;
        }
        if (this.sGz.getVisibility() == 0 && this.sGA != null && this.sGA.fgd != null && this.sGA.fgd.equals(chw.xgS)) {
            this.sGz.setVisibility(8);
        }
        AppMethodBeat.m2505o(1999);
    }

    private int getSystemVolume() {
        AppMethodBeat.m2504i(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        int streamVolume = ((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        AppMethodBeat.m2505o(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        return streamVolume;
    }

    public final void cHh() {
        AppMethodBeat.m2504i(1986);
        if (this.sBa.eif) {
            this.sBa.eif = false;
            if (getSystemVolume() == 0) {
                C1397a.m2944b((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1);
            }
        } else {
            this.sBa.eif = true;
        }
        cGL();
        cFO();
        cFN();
        AppMethodBeat.m2505o(1986);
    }

    /* renamed from: ad */
    public final void mo9164ad(View view, final int i) {
        AppMethodBeat.m2504i(1988);
        if (this.sEn.cGZ()) {
            this.sEn.cpN();
            this.sEp = true;
        }
        final chw FL = this.sEo.mo26218FL(i);
        this.sEq = new C46312b(this.mController.ylL, FL.xhc, new C35321a() {
            /* renamed from: j */
            public final void mo9153j(Set<abz> set) {
                AppMethodBeat.m2504i(1952);
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
                C23639t.makeText(TopStoryFSVideoUI.this.mController.ylL, C25738R.string.ex4, 0).show();
                C46297h.m86864a(TopStoryFSVideoUI.this.cFT(), FL, (Set) set, TopStoryFSVideoUI.this.sEo.cGR());
                TopStoryFSVideoUI.this.sEn.stopPlay();
                TopStoryFSVideoUI.this.sEo.mo26217FK(i);
                TopStoryFSVideoUI.this.sGs.mo66318ci(i + TopStoryFSVideoUI.this.sGs.getHeadersCount());
                TopStoryFSVideoUI.this.sDY.mo66329a(0, 3, null);
                AppMethodBeat.m2505o(1952);
            }

            public final void onDismiss() {
                AppMethodBeat.m2504i(1953);
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
                if (TopStoryFSVideoUI.this.sEp) {
                    TopStoryFSVideoUI.this.sEn.cEf();
                    TopStoryFSVideoUI.this.sEp = false;
                    try {
                        ((C22411f) TopStoryFSVideoUI.this.sEn.sFu.getControlBar()).aFE();
                        AppMethodBeat.m2505o(1953);
                        return;
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.m2505o(1953);
            }
        });
        this.sEq.mo74508a(view, true, 0, C1338a.fromDPToPix(this.mController.ylL, 16));
        try {
            ((C22411f) this.sEn.sFu.getControlBar()).cHd();
            AppMethodBeat.m2505o(1988);
        } catch (Exception e) {
            AppMethodBeat.m2505o(1988);
        }
    }

    /* renamed from: f */
    static /* synthetic */ boolean m68458f(View view, float f, float f2) {
        AppMethodBeat.m2504i(2001);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i;
            int measuredHeight = view.getMeasuredHeight() + i2;
            if (f2 >= ((float) i2) && f2 <= ((float) measuredHeight) && f >= ((float) i) && f <= ((float) measuredWidth)) {
                AppMethodBeat.m2505o(2001);
                return true;
            }
        }
        AppMethodBeat.m2505o(2001);
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ void m68453b(TopStoryFSVideoUI topStoryFSVideoUI) {
        AppMethodBeat.m2504i(2002);
        View decorView = topStoryFSVideoUI.getWindow().getDecorView();
        decorView.setSystemUiVisibility(((decorView.getSystemUiVisibility() | 2) | 4096) | 4);
        AppMethodBeat.m2505o(2002);
    }

    /* renamed from: a */
    static /* synthetic */ void m68452a(TopStoryFSVideoUI topStoryFSVideoUI, String str) {
        AppMethodBeat.m2504i(2003);
        if (!C5023at.isNetworkConnected(topStoryFSVideoUI)) {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(C25738R.string.dj1), 1).show();
            AppMethodBeat.m2505o(2003);
        } else if (C5046bo.isNullOrNil(str)) {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(C25738R.string.dj2), 1).show();
            AppMethodBeat.m2505o(2003);
        } else {
            Toast.makeText(topStoryFSVideoUI, str, 1).show();
            AppMethodBeat.m2505o(2003);
        }
    }
}
