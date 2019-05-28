package com.tencent.p177mm.plugin.masssend.p452ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p194a.C32297a;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5262g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.masssend.C12490a;
import com.tencent.p177mm.plugin.masssend.p452ui.C43295c.C43296e;
import com.tencent.p177mm.plugin.masssend.p992a.C21270h;
import com.tencent.p177mm.plugin.masssend.p992a.C39356a;
import com.tencent.p177mm.plugin.masssend.p992a.C46069b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.sdk.platformtools.SensorController.C4986a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI */
public class MassSendHistoryUI extends MMActivity implements C17889a, C17892b, C4986a {
    private static SensorController mfW;
    private C32297a chb;
    private C5279d jOb = new C77874();
    private boolean mfP = true;
    private View nDr;
    private ListView ooS;
    private C43295c ooT;
    private Button ooU;
    private Button ooV;
    private MMPullDownView ooW;
    private boolean ooX = false;
    private LinearLayout ooY;

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$9 */
    class C77839 implements OnItemClickListener {
        C77839() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22802);
            C4990ab.m7418v("MicroMsg.MassSendHistoryUI", "onItemClick");
            AppMethodBeat.m2505o(22802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$1 */
    class C77841 implements C43296e {
        C77841() {
        }

        /* renamed from: Qw */
        public final String mo17616Qw(String str) {
            AppMethodBeat.m2504i(22794);
            C9638aw.m17190ZK();
            String nullAsNil;
            if (C18628c.isSDCardAvailable()) {
                nullAsNil = C5046bo.nullAsNil(str);
                if (MassSendHistoryUI.this.chb.isPlaying() && nullAsNil.equals(MassSendHistoryUI.this.ooT.ooH)) {
                    MassSendHistoryUI.bNN();
                    MassSendHistoryUI.this.releaseWakeLock();
                    MassSendHistoryUI.this.chb.stop(false);
                    nullAsNil = "";
                    AppMethodBeat.m2505o(22794);
                    return nullAsNil;
                } else if (MassSendHistoryUI.m13820a(MassSendHistoryUI.this, nullAsNil)) {
                    AppMethodBeat.m2505o(22794);
                    return nullAsNil;
                } else {
                    nullAsNil = "";
                    AppMethodBeat.m2505o(22794);
                    return nullAsNil;
                }
            }
            C23639t.m36492hO(MassSendHistoryUI.this);
            nullAsNil = "";
            AppMethodBeat.m2505o(22794);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$2 */
    class C77852 implements OnMenuItemClickListener {
        C77852() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22795);
            if (MassSendHistoryUI.this.ooX) {
                MassSendHistoryUI.this.finish();
            } else {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C12490a.gkE.mo38931p(intent, MassSendHistoryUI.this);
                MassSendHistoryUI.this.finish();
            }
            AppMethodBeat.m2505o(22795);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$3 */
    class C77863 implements OnMenuItemClickListener {
        C77863() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22796);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "masssendapp");
            C12490a.gkE.mo38912c(intent, MassSendHistoryUI.this);
            AppMethodBeat.m2505o(22796);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$4 */
    class C77874 implements C5279d {
        C77874() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(22797);
            if (menuItem.getItemId() == 1) {
                C39356a c39356a = (C39356a) MassSendHistoryUI.this.ooT.getItem(menuItem.getGroupId());
                if (c39356a == null) {
                    AppMethodBeat.m2505o(22797);
                    return;
                }
                if (c39356a.bNv().equals(MassSendHistoryUI.this.ooT.ooH)) {
                    MassSendHistoryUI.m13827h(MassSendHistoryUI.this);
                }
                C46069b bNE = C21270h.bNE();
                String bNv = c39356a.bNv();
                Cursor a = bNE.fni.mo10104a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                if (a != null) {
                    C39356a c39356a2;
                    C7617ak c7617ak;
                    if (a.getCount() == 0) {
                        a.close();
                    } else if (a.getCount() == 1) {
                        a.moveToFirst();
                        c39356a2 = new C39356a();
                        c39356a2.mo62252d(a);
                        a.close();
                        c7617ak = new C7617ak();
                        c7617ak.setUsername("masssendapp");
                        c7617ak.setContent(C4996ah.getContext().getResources().getString(C25738R.string.axn));
                        c7617ak.mo14742eD(c39356a2.createTime);
                        c7617ak.mo14750hO(0);
                        c7617ak.mo14748hM(0);
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15767a(c7617ak, "masssendapp");
                    } else {
                        a.moveToPosition(1);
                        c39356a2 = new C39356a();
                        c39356a2.mo62252d(a);
                        a.close();
                        c7617ak = new C7617ak();
                        c7617ak.setUsername("masssendapp");
                        c7617ak.setContent(C46069b.m85832a(c39356a2));
                        c7617ak.mo14742eD(c39356a2.createTime);
                        c7617ak.mo14750hO(0);
                        c7617ak.mo14748hM(0);
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15767a(c7617ak, "masssendapp");
                    }
                }
                if (bNE.fni.delete("massendinfo", "clientid= ?", new String[]{String.valueOf(bNv)}) > 0) {
                    bNE.doNotify();
                }
            }
            AppMethodBeat.m2505o(22797);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$10 */
    class C778810 implements OnTouchListener {
        C778810() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(22803);
            C4990ab.m7418v("MicroMsg.MassSendHistoryUI", "onTouch");
            AppMethodBeat.m2505o(22803);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$11 */
    class C778911 implements OnClickListener {
        C778911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22804);
            MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            AppMethodBeat.m2505o(22804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$12 */
    class C779012 implements OnClickListener {
        C779012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22805);
            MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            AppMethodBeat.m2505o(22805);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$7 */
    class C77917 implements C5260d {
        C77917() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(22800);
            View childAt = MassSendHistoryUI.this.ooS.getChildAt(MassSendHistoryUI.this.ooS.getFirstVisiblePosition());
            if (childAt == null || childAt.getTop() != 0) {
                AppMethodBeat.m2505o(22800);
                return false;
            }
            AppMethodBeat.m2505o(22800);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$6 */
    class C77926 implements C5258c {
        C77926() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(22799);
            if (MassSendHistoryUI.this.ooS.getChildAt(MassSendHistoryUI.this.ooS.getChildCount() - 1).getBottom() > MassSendHistoryUI.this.ooS.getHeight() || MassSendHistoryUI.this.ooS.getLastVisiblePosition() != MassSendHistoryUI.this.ooS.getAdapter().getCount() - 1) {
                AppMethodBeat.m2505o(22799);
                return false;
            }
            AppMethodBeat.m2505o(22799);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$5 */
    class C77935 implements C5262g {
        C77935() {
        }

        public final boolean bhn() {
            int i = 0;
            AppMethodBeat.m2504i(22798);
            if (MassSendHistoryUI.this.ooT.bdn()) {
                MassSendHistoryUI.this.ooS.setSelectionFromTop(0, MassSendHistoryUI.this.ooW.getTopHeight());
                AppMethodBeat.m2505o(22798);
            } else {
                C43295c b = MassSendHistoryUI.this.ooT;
                if (!b.bdn()) {
                    b.kmW += 10;
                    if (b.kmW <= b.enb) {
                        i = 10;
                    } else {
                        b.kmW = b.enb;
                        i = b.enb % 10;
                    }
                }
                C4990ab.m7418v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
                MassSendHistoryUI.this.ooT.mo5248a(null, null);
                MassSendHistoryUI.this.ooS.setSelectionFromTop(i, MassSendHistoryUI.this.ooW.getTopHeight());
                AppMethodBeat.m2505o(22798);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI$8 */
    class C77948 implements C30723a {
        C77948() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(22801);
            MassSendHistoryUI.this.ooW.setIsTopShowAll(MassSendHistoryUI.this.ooT.bdn());
            if (MassSendHistoryUI.this.ooT.getCount() == 0) {
                MassSendHistoryUI.this.ooW.setVisibility(8);
                MassSendHistoryUI.this.nDr.setVisibility(0);
                MassSendHistoryUI.this.ooY.setVisibility(8);
                AppMethodBeat.m2505o(22801);
                return;
            }
            MassSendHistoryUI.this.ooW.setVisibility(0);
            MassSendHistoryUI.this.nDr.setVisibility(8);
            MassSendHistoryUI.this.ooY.setVisibility(0);
            AppMethodBeat.m2505o(22801);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MassSendHistoryUI() {
        AppMethodBeat.m2504i(22806);
        AppMethodBeat.m2505o(22806);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m13820a(MassSendHistoryUI massSendHistoryUI, String str) {
        AppMethodBeat.m2504i(22821);
        boolean Qx = massSendHistoryUI.m13818Qx(str);
        AppMethodBeat.m2505o(22821);
        return Qx;
    }

    /* renamed from: h */
    static /* synthetic */ void m13827h(MassSendHistoryUI massSendHistoryUI) {
        AppMethodBeat.m2504i(22822);
        massSendHistoryUI.stopPlay();
        AppMethodBeat.m2505o(22822);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22807);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cyx);
        if (mfW == null) {
            mfW = new SensorController(getApplicationContext());
        }
        initView();
        this.chb = new C32297a(this);
        this.chb.coD = this;
        this.chb.coC = this;
        this.ooT.ooI = new C77841();
        if (this.mController != null) {
            this.mController.mo11176aC(3, false);
        }
        AppMethodBeat.m2505o(22807);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22808);
        super.onResume();
        C21270h.bNE().mo10116c(this.ooT);
        this.ooT.mo5248a(null, null);
        this.ooS.setSelection(this.ooT.getCount() - 1);
        AppMethodBeat.m2505o(22808);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22809);
        super.onPause();
        C9638aw.m17191ZL().mo4825La();
        C21270h.bNE().mo10117d(this.ooT);
        mfW.dps();
        AppMethodBeat.m2505o(22809);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22810);
        this.ooT.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(22810);
    }

    public final int getLayoutId() {
        return 2130970071;
    }

    public final void initView() {
        AppMethodBeat.m2504i(22811);
        this.ooX = getIntent().getBooleanExtra("finish_direct", false);
        C4990ab.m7410d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.ooX);
        this.ooY = (LinearLayout) findViewById(2131825921);
        this.ooS = (ListView) findViewById(2131825918);
        this.ooS.setTranscriptMode(0);
        this.ooW = (MMPullDownView) findViewById(2131825917);
        this.ooW.setOnTopLoadDataListener(new C77935());
        this.ooW.setTopViewVisible(true);
        this.ooW.setAtBottomCallBack(new C77926());
        this.ooW.setAtTopCallBack(new C77917());
        this.ooW.setIsBottomShowAll(true);
        this.ooT = new C43295c(this);
        this.ooT.mo74992a((C30723a) new C77948());
        this.nDr = findViewById(2131825919);
        this.ooS.setAdapter(this.ooT);
        this.ooS.setOnItemClickListener(new C77839());
        this.ooS.setOnTouchListener(new C778810());
        this.ooU = (Button) findViewById(2131825922);
        this.ooU.setOnClickListener(new C778911());
        this.ooV = (Button) findViewById(2131825920);
        this.ooV.setOnClickListener(new C779012());
        setBackBtn(new C77852());
        addIconOptionMenu(0, C25738R.string.f9225tk, C1318a.actionbar_setting_icon, new C77863());
        new C46696j(this).mo75005a(this.ooS, this, this.jOb);
        AppMethodBeat.m2505o(22811);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(22812);
        if (i == 4) {
            if (this.ooX) {
                finish();
            } else {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C12490a.gkE.mo38931p(intent, this);
                finish();
            }
            AppMethodBeat.m2505o(22812);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(22812);
        return onKeyDown;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(22813);
        C4990ab.m7418v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((C39356a) this.ooT.getItem(adapterContextMenuInfo.position)).bNy().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (aoO != null) {
                stringBuilder.append(aoO.mo16707Oj() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(C25738R.string.am7));
        AppMethodBeat.m2505o(22813);
    }

    /* Access modifiers changed, original: protected|final */
    public final void releaseWakeLock() {
        AppMethodBeat.m2504i(22814);
        this.ooS.setKeepScreenOn(false);
        AppMethodBeat.m2505o(22814);
    }

    /* renamed from: he */
    public final void mo10257he(boolean z) {
        AppMethodBeat.m2504i(22815);
        if (this.chb == null) {
            AppMethodBeat.m2505o(22815);
        } else if (this.chb.isPlaying()) {
            this.chb.mo33407bo(z);
            C9638aw.m17191ZL().mo4834f(z, false, false);
            this.mfP = z;
            if (!z) {
                if (m13818Qx(this.ooT.ooH)) {
                    this.ooT.mo68841Qv(this.ooT.ooH);
                    AppMethodBeat.m2505o(22815);
                    return;
                }
                this.ooT.mo68841Qv("");
            }
            AppMethodBeat.m2505o(22815);
        } else {
            this.chb.mo33407bo(true);
            C9638aw.m17191ZL().mo4834f(true, false, false);
            this.mfP = true;
            AppMethodBeat.m2505o(22815);
        }
    }

    /* renamed from: Qx */
    private boolean m13818Qx(String str) {
        AppMethodBeat.m2504i(22816);
        Assert.assertTrue(str != null);
        mfW.mo10258a(this);
        C39356a Qs = C21270h.bNE().mo73988Qs(str);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable() || C5046bo.isNullOrNil(Qs.bNw())) {
            if (this.chb == null) {
                this.chb = new C32297a(this);
            }
            this.chb.stop(false);
            if (this.chb.mo53007m(Qs.bNw(), this.mfP)) {
                C9638aw.m17191ZL().mo4834f(this.mfP, false, false);
                this.chb.coD = this;
                this.chb.coC = this;
                AppMethodBeat.m2505o(22816);
                return true;
            }
            Toast.makeText(this, getString(C25738R.string.ank), 0).show();
            AppMethodBeat.m2505o(22816);
            return false;
        }
        C23639t.m36492hO(this);
        AppMethodBeat.m2505o(22816);
        return false;
    }

    /* renamed from: EA */
    public final void mo17611EA() {
        AppMethodBeat.m2504i(22818);
        stopPlay();
        AppMethodBeat.m2505o(22818);
    }

    public final void onError() {
        AppMethodBeat.m2504i(22819);
        stopPlay();
        AppMethodBeat.m2505o(22819);
    }

    private void stopPlay() {
        AppMethodBeat.m2504i(22817);
        mfW.dps();
        this.chb.stop(false);
        this.ooT.mo68841Qv("");
        releaseWakeLock();
        AppMethodBeat.m2505o(22817);
    }

    static /* synthetic */ void bNN() {
        AppMethodBeat.m2504i(22820);
        mfW.dps();
        AppMethodBeat.m2505o(22820);
    }
}
