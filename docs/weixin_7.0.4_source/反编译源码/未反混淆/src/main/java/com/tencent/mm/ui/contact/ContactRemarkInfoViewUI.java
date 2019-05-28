package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bc.c;
import com.tencent.mm.bc.c.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String bCv;
    private String dul;
    private ad ehM;
    private String fNa;
    private int gwP;
    private String username;
    private TextView zlF;
    private TextView zlG;
    private ImageView zlJ;
    private boolean zlP = false;
    private View zmj;
    private View zmk;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        AppMethodBeat.i(33698);
        contactRemarkInfoViewUI.dHJ();
        AppMethodBeat.o(33698);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33692);
        super.onCreate(bundle);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (ah.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(33692);
            return;
        }
        Kh();
        initView();
        AppMethodBeat.o(33692);
    }

    public void onResume() {
        AppMethodBeat.i(33693);
        super.onResume();
        Kh();
        this.zlF.setText(j.b((Context) this, ah.nullAsNil(this.bCv), this.zlF.getTextSize()));
        if (ah.isNullOrNil(this.dul)) {
            this.zmj.setVisibility(8);
        } else {
            this.zmj.setVisibility(0);
            this.zlG.setText(ah.nullAsNil(this.dul));
        }
        if (ah.isNullOrNil(this.fNa)) {
            this.zmk.setVisibility(8);
            AppMethodBeat.o(33693);
            return;
        }
        this.zmk.setVisibility(0);
        c.aiB();
        if (c.sX(this.username)) {
            dHJ();
            AppMethodBeat.o(33693);
            return;
        }
        c.aiB().a(this.username, this.fNa, new a() {
            public final void cP(final boolean z) {
                AppMethodBeat.i(33691);
                ContactRemarkInfoViewUI.this.zlJ.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33690);
                        if (z) {
                            ContactRemarkInfoViewUI.e(ContactRemarkInfoViewUI.this);
                            AppMethodBeat.o(33690);
                            return;
                        }
                        h.bQ(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(R.string.ps));
                        AppMethodBeat.o(33690);
                    }
                });
                AppMethodBeat.o(33691);
            }
        });
        AppMethodBeat.o(33693);
    }

    public void onDestroy() {
        AppMethodBeat.i(33694);
        super.onDestroy();
        AppMethodBeat.o(33694);
    }

    public final int getLayoutId() {
        return R.layout.r3;
    }

    private void Kh() {
        AppMethodBeat.i(33695);
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(this.username);
        this.bCv = this.ehM.Oj();
        this.dul = this.ehM.dul;
        this.fNa = this.ehM.dum;
        AppMethodBeat.o(33695);
    }

    public final void initView() {
        AppMethodBeat.i(33696);
        this.zlF = (TextView) findViewById(R.id.b5m);
        this.zlG = (TextView) findViewById(R.id.b5w);
        this.zlJ = (ImageView) findViewById(R.id.b5z);
        this.zmj = findViewById(R.id.b60);
        this.zmk = findViewById(R.id.b61);
        setMMTitle((int) R.string.axx);
        this.zlJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33687);
                if (ContactRemarkInfoViewUI.this.zlP) {
                    Intent intent = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.username);
                    c.aiB();
                    intent.putExtra("remark_image_path", c.sW(ContactRemarkInfoViewUI.this.username));
                    intent.putExtra("view_only", true);
                    ContactRemarkInfoViewUI.this.startActivity(intent);
                    AppMethodBeat.o(33687);
                    return;
                }
                AppMethodBeat.o(33687);
            }
        });
        addTextOptionMenu(0, getString(R.string.pg), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33688);
                Intent intent = new Intent();
                intent.setClass(ContactRemarkInfoViewUI.this.mController.ylL, ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.this.gwP);
                intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.ehM.field_username);
                ContactRemarkInfoViewUI.this.startActivity(intent);
                AppMethodBeat.o(33688);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33689);
                ContactRemarkInfoViewUI.this.finish();
                AppMethodBeat.o(33689);
                return true;
            }
        });
        AppMethodBeat.o(33696);
    }

    private void dHJ() {
        AppMethodBeat.i(33697);
        c.aiB();
        Bitmap sZ = c.sZ(this.username);
        if (sZ != null) {
            this.zlJ.setImageBitmap(sZ);
            this.zlP = true;
        }
        AppMethodBeat.o(33697);
    }
}
