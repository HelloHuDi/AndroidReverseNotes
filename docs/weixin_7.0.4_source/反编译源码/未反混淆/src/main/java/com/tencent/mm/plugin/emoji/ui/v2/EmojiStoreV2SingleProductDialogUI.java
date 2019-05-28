package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.c;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    public String edV;
    private EmojiInfo exP;
    private ProgressBar gHA;
    private int gOW;
    private c ggF;
    private long kVE;
    private View leP;
    private EmojiStatusView leQ;
    private ImageView leR;
    private Button leS;
    private Button leT;
    private int leU;
    private int leV;
    private OnClickListener leW = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(53730);
            EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.exP != null) {
                h.pYm.e(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.gOW), Integer.valueOf(2), EmojiStoreV2SingleProductDialogUI.this.exP.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.kVE), EmojiStoreV2SingleProductDialogUI.this.exP.field_designerID, EmojiStoreV2SingleProductDialogUI.this.exP.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.leV));
            }
            AppMethodBeat.o(53730);
        }
    };
    private OnClickListener leX = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(53731);
            EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.exP != null) {
                h.pYm.e(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.gOW), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.this.exP.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.kVE), EmojiStoreV2SingleProductDialogUI.this.exP.field_designerID, EmojiStoreV2SingleProductDialogUI.this.exP.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.leV));
            }
            AppMethodBeat.o(53731);
        }
    };
    private View.OnClickListener leY = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53732);
            EmojiStoreV2SingleProductDialogUI.this.ggF.setOnDismissListener(null);
            EmojiStoreV2SingleProductDialogUI.this.ggF.dismiss();
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(R.anim.c4, R.anim.c9);
            AppMethodBeat.o(53732);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2SingleProductDialogUI() {
        AppMethodBeat.i(53735);
        AppMethodBeat.o(53735);
    }

    static /* synthetic */ void j(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(53743);
        emojiStoreV2SingleProductDialogUI.blW();
        AppMethodBeat.o(53743);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53736);
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
                xx xxVar = new xx();
                xxVar.parseFrom(byteArrayExtra);
                this.exP = j.getEmojiStorageMgr().xYn.aqi(xxVar.Md5);
                if (this.exP == null) {
                    this.exP = new EmojiInfo();
                    this.exP.field_catalog = 84;
                    this.exP.field_reserved4 |= EmojiInfo.zZi;
                    b.a(xxVar, this.exP);
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
        }
        if (this.exP == null) {
            setResult(0);
            finish();
        }
        this.leP = v.hu(this).inflate(R.layout.ux, null);
        this.gHA = (ProgressBar) this.leP.findViewById(R.id.bha);
        this.leQ = (EmojiStatusView) this.leP.findViewById(R.id.bh_);
        this.leR = (ImageView) this.leP.findViewById(R.id.bh9);
        this.leR.setOnClickListener(this.leY);
        this.ggF = com.tencent.mm.ui.base.h.a(this, this.leP, "");
        this.ggF.a(getString(R.string.tf), false, this.leW);
        this.ggF.b(getString(R.string.fv), false, this.leX);
        this.ggF.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(53733);
                EmojiStoreV2SingleProductDialogUI.this.setResult(0);
                EmojiStoreV2SingleProductDialogUI.this.finish();
                AppMethodBeat.o(53733);
            }
        });
        this.leS = this.ggF.getButton(-1);
        this.leT = this.ggF.getButton(-2);
        this.leQ.setVisibility(8);
        this.gHA.setVisibility(0);
        this.leT.setText(R.string.ba8);
        this.leS.setText(R.string.tf);
        this.leT.setEnabled(false);
        this.leT.setTextColor(getResources().getColor(R.color.rh));
        this.leS.setEnabled(false);
        this.leS.setTextColor(getResources().getColor(R.color.rh));
        this.leQ.setStatusListener(new EmojiStatusView.b() {
            public final void jm(int i) {
                AppMethodBeat.i(53734);
                if (i == 1) {
                    EmojiStoreV2SingleProductDialogUI.this.leQ.setVisibility(0);
                    EmojiStoreV2SingleProductDialogUI.this.gHA.setVisibility(8);
                    EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
                    EmojiStoreV2SingleProductDialogUI.this.leS.setEnabled(true);
                    EmojiStoreV2SingleProductDialogUI.this.leS.setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(R.color.hi));
                }
                AppMethodBeat.o(53734);
            }
        });
        this.leQ.setEmojiInfo(this.exP);
        AppMethodBeat.o(53736);
    }

    public void onResume() {
        AppMethodBeat.i(53737);
        super.onResume();
        if (this.exP != null) {
            EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(this.exP.field_md5);
            if (aqi != null) {
                this.exP = aqi;
            }
        }
        blW();
        this.ggF.show();
        AppMethodBeat.o(53737);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53738);
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            this.ggF.setOnDismissListener(null);
            this.ggF.dismiss();
            setResult(-1);
            finish();
            overridePendingTransition(R.anim.c4, 0);
        }
        AppMethodBeat.o(53738);
    }

    private void blW() {
        AppMethodBeat.i(53739);
        if (this.exP != null && this.exP.field_catalog == EmojiGroupInfo.yat) {
            this.leT.setEnabled(false);
            this.leT.setText(R.string.fv);
            this.leT.setTextColor(getResources().getColor(R.color.rh));
            AppMethodBeat.o(53739);
        } else if (this.exP == null || !this.exP.duP()) {
            this.leT.setEnabled(false);
            this.leT.setText(R.string.ba8);
            this.leT.setTextColor(getResources().getColor(R.color.rh));
            AppMethodBeat.o(53739);
        } else {
            this.leT.setEnabled(true);
            this.leT.setText(R.string.ba8);
            this.leT.setTextColor(getResources().getColor(R.color.hi));
            AppMethodBeat.o(53739);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(53740);
        super.onDestroy();
        this.ggF.setOnDismissListener(null);
        if (this.ggF.isShowing()) {
            this.ggF.dismiss();
        }
        AppMethodBeat.o(53740);
    }

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(53741);
        if (j.getEmojiStorageMgr().xYn.aqi(emojiStoreV2SingleProductDialogUI.exP.field_md5) == null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "sendEmoji: db info is null");
            emojiStoreV2SingleProductDialogUI.exP.field_catalog = EmojiInfo.yau;
            j.getEmojiStorageMgr().xYn.E(emojiStoreV2SingleProductDialogUI.exP);
        }
        Intent intent = new Intent(emojiStoreV2SingleProductDialogUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", emojiStoreV2SingleProductDialogUI.exP);
        emojiStoreV2SingleProductDialogUI.startActivityForResult(intent, 1001);
        emojiStoreV2SingleProductDialogUI.ggF.hide();
        AppMethodBeat.o(53741);
    }

    static /* synthetic */ void f(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(53742);
        if (emojiStoreV2SingleProductDialogUI.exP != null) {
            if (j.getEmojiStorageMgr().xYn.aqi(emojiStoreV2SingleProductDialogUI.exP.field_md5) == null) {
                ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "doAddAction: db info is null");
                emojiStoreV2SingleProductDialogUI.exP.field_catalog = EmojiInfo.yau;
                j.getEmojiStorageMgr().xYn.E(emojiStoreV2SingleProductDialogUI.exP);
            }
            j.bki().a(emojiStoreV2SingleProductDialogUI, emojiStoreV2SingleProductDialogUI.exP, emojiStoreV2SingleProductDialogUI.leU, r.Yz());
        }
        AppMethodBeat.o(53742);
    }
}
