package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.view.EmojiStatusView;
import com.tencent.p177mm.emoji.view.EmojiStatusView.C37687b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiSendDialogUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI */
public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    public String edV;
    private EmojiInfo exP;
    private ProgressBar gHA;
    private int gOW;
    private C5653c ggF;
    private long kVE;
    private View leP;
    private EmojiStatusView leQ;
    private ImageView leR;
    private Button leS;
    private Button leT;
    private int leU;
    private int leV;
    private OnClickListener leW = new C29491();
    private OnClickListener leX = new C29512();
    private View.OnClickListener leY = new C29503();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI$1 */
    class C29491 implements OnClickListener {
        C29491() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53730);
            EmojiStoreV2SingleProductDialogUI.m5237a(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.exP != null) {
                C7060h.pYm.mo8381e(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.gOW), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.this.exP.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.kVE), EmojiStoreV2SingleProductDialogUI.this.exP.field_designerID, EmojiStoreV2SingleProductDialogUI.this.exP.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.leV));
            }
            AppMethodBeat.m2505o(53730);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI$3 */
    class C29503 implements View.OnClickListener {
        C29503() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53732);
            EmojiStoreV2SingleProductDialogUI.this.ggF.setOnDismissListener(null);
            EmojiStoreV2SingleProductDialogUI.this.ggF.dismiss();
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8367c9);
            AppMethodBeat.m2505o(53732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI$2 */
    class C29512 implements OnClickListener {
        C29512() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53731);
            EmojiStoreV2SingleProductDialogUI.m5242f(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.exP != null) {
                C7060h.pYm.mo8381e(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.gOW), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.this.exP.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.kVE), EmojiStoreV2SingleProductDialogUI.this.exP.field_designerID, EmojiStoreV2SingleProductDialogUI.this.exP.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.leV));
            }
            AppMethodBeat.m2505o(53731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI$4 */
    class C29524 implements OnDismissListener {
        C29524() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53733);
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            AppMethodBeat.m2505o(53733);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI$5 */
    class C29535 implements C37687b {
        C29535() {
        }

        /* renamed from: jm */
        public final void mo7155jm(int i) {
            AppMethodBeat.m2504i(53734);
            if (i == 1) {
                EmojiStoreV2SingleProductDialogUI.this.leQ.setVisibility(0);
                EmojiStoreV2SingleProductDialogUI.this.gHA.setVisibility(8);
                EmojiStoreV2SingleProductDialogUI.m5246j(EmojiStoreV2SingleProductDialogUI.this);
                EmojiStoreV2SingleProductDialogUI.this.leS.setEnabled(true);
                EmojiStoreV2SingleProductDialogUI.this.leS.setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(C25738R.color.f11795hi));
            }
            AppMethodBeat.m2505o(53734);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2SingleProductDialogUI() {
        AppMethodBeat.m2504i(53735);
        AppMethodBeat.m2505o(53735);
    }

    /* renamed from: j */
    static /* synthetic */ void m5246j(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.m2504i(53743);
        emojiStoreV2SingleProductDialogUI.blW();
        AppMethodBeat.m2505o(53743);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53736);
        overridePendingTransition(-1, -1);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        this.leU = getIntent().getIntExtra("add_source", 5);
        this.leV = getIntent().getIntExtra("entrance_scene", 0);
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.kVE = getIntent().getLongExtra("searchID", 0);
        this.edV = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                C40588xx c40588xx = new C40588xx();
                c40588xx.parseFrom(byteArrayExtra);
                this.exP = C42952j.getEmojiStorageMgr().xYn.aqi(c40588xx.Md5);
                if (this.exP == null) {
                    this.exP = new EmojiInfo();
                    this.exP.field_catalog = 84;
                    this.exP.field_reserved4 |= EmojiInfo.zZi;
                    C2933b.m5222a(c40588xx, this.exP);
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
        }
        if (this.exP == null) {
            setResult(0);
            finish();
        }
        this.leP = C5616v.m8409hu(this).inflate(2130969378, null);
        this.gHA = (ProgressBar) this.leP.findViewById(2131823589);
        this.leQ = (EmojiStatusView) this.leP.findViewById(2131823588);
        this.leR = (ImageView) this.leP.findViewById(2131823587);
        this.leR.setOnClickListener(this.leY);
        this.ggF = C30379h.m48434a(this, this.leP, "");
        this.ggF.mo11489a(getString(C25738R.string.f9221tf), false, this.leW);
        this.ggF.mo11491b(getString(C25738R.string.f8817fv), false, this.leX);
        this.ggF.setOnDismissListener(new C29524());
        this.leS = this.ggF.getButton(-1);
        this.leT = this.ggF.getButton(-2);
        this.leQ.setVisibility(8);
        this.gHA.setVisibility(0);
        this.leT.setText(C25738R.string.ba8);
        this.leS.setText(C25738R.string.f9221tf);
        this.leT.setEnabled(false);
        this.leT.setTextColor(getResources().getColor(C25738R.color.f12075rh));
        this.leS.setEnabled(false);
        this.leS.setTextColor(getResources().getColor(C25738R.color.f12075rh));
        this.leQ.setStatusListener(new C29535());
        this.leQ.setEmojiInfo(this.exP);
        AppMethodBeat.m2505o(53736);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53737);
        super.onResume();
        if (this.exP != null) {
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(this.exP.field_md5);
            if (aqi != null) {
                this.exP = aqi;
            }
        }
        blW();
        this.ggF.show();
        AppMethodBeat.m2505o(53737);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53738);
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            this.ggF.setOnDismissListener(null);
            this.ggF.dismiss();
            setResult(-1);
            finish();
            overridePendingTransition(C25738R.anim.f8362c4, 0);
        }
        AppMethodBeat.m2505o(53738);
    }

    private void blW() {
        AppMethodBeat.m2504i(53739);
        if (this.exP != null && this.exP.field_catalog == EmojiGroupInfo.yat) {
            this.leT.setEnabled(false);
            this.leT.setText(C25738R.string.f8817fv);
            this.leT.setTextColor(getResources().getColor(C25738R.color.f12075rh));
            AppMethodBeat.m2505o(53739);
        } else if (this.exP == null || !this.exP.duP()) {
            this.leT.setEnabled(false);
            this.leT.setText(C25738R.string.ba8);
            this.leT.setTextColor(getResources().getColor(C25738R.color.f12075rh));
            AppMethodBeat.m2505o(53739);
        } else {
            this.leT.setEnabled(true);
            this.leT.setText(C25738R.string.ba8);
            this.leT.setTextColor(getResources().getColor(C25738R.color.f11795hi));
            AppMethodBeat.m2505o(53739);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53740);
        super.onDestroy();
        this.ggF.setOnDismissListener(null);
        if (this.ggF.isShowing()) {
            this.ggF.dismiss();
        }
        AppMethodBeat.m2505o(53740);
    }

    /* renamed from: a */
    static /* synthetic */ void m5237a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.m2504i(53741);
        if (C42952j.getEmojiStorageMgr().xYn.aqi(emojiStoreV2SingleProductDialogUI.exP.field_md5) == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "sendEmoji: db info is null");
            emojiStoreV2SingleProductDialogUI.exP.field_catalog = EmojiInfo.yau;
            C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiStoreV2SingleProductDialogUI.exP);
        }
        Intent intent = new Intent(emojiStoreV2SingleProductDialogUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", emojiStoreV2SingleProductDialogUI.exP);
        emojiStoreV2SingleProductDialogUI.startActivityForResult(intent, 1001);
        emojiStoreV2SingleProductDialogUI.ggF.hide();
        AppMethodBeat.m2505o(53741);
    }

    /* renamed from: f */
    static /* synthetic */ void m5242f(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.m2504i(53742);
        if (emojiStoreV2SingleProductDialogUI.exP != null) {
            if (C42952j.getEmojiStorageMgr().xYn.aqi(emojiStoreV2SingleProductDialogUI.exP.field_md5) == null) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "doAddAction: db info is null");
                emojiStoreV2SingleProductDialogUI.exP.field_catalog = EmojiInfo.yau;
                C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiStoreV2SingleProductDialogUI.exP);
            }
            C42952j.bki().mo35621a(emojiStoreV2SingleProductDialogUI, emojiStoreV2SingleProductDialogUI.exP, emojiStoreV2SingleProductDialogUI.leU, C1853r.m3846Yz());
        }
        AppMethodBeat.m2505o(53742);
    }
}
