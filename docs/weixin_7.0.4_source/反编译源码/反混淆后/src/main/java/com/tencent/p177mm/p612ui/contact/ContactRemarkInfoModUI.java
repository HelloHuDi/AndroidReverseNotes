package com.tencent.p177mm.p612ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.p1185bc.C17972a;
import com.tencent.p177mm.p1185bc.C17973b;
import com.tencent.p177mm.p1185bc.C17974c;
import com.tencent.p177mm.p1185bc.C17974c.C17976a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.MMClearEditText;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileEditPhoneNumberView;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileEditPhoneNumberView.C14903a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.bbw;
import com.tencent.p177mm.protocal.protobuf.bck;
import com.tencent.p177mm.protocal.protobuf.bkf;
import com.tencent.p177mm.protocal.protobuf.bkg;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI */
public class ContactRemarkInfoModUI extends MMActivity implements C1202f {
    private String bCv;
    private String dul;
    private C7616ad ehM;
    private String fNa;
    private ProgressDialog fsh;
    private int gwP;
    private String nIM;
    private C4937b ppA = new C793910();
    private MMTagPanel ppy;
    private List<String> ppz;
    private String username;
    private String vrd;
    private MMClearEditText zlC;
    private TextView zlD;
    private MMEditText zlE;
    private TextView zlF;
    private TextView zlG;
    private TextView zlH;
    private TextView zlI;
    private ImageView zlJ;
    private ImageView zlK;
    private TextView zlL;
    private View zlM;
    private View zlN;
    private String zlO;
    private boolean zlP = false;
    private boolean zlQ = false;
    private boolean zlR = false;
    private boolean zlS = false;
    private boolean zlT = false;
    private C7931a zlU = new C7931a(this, (byte) 0);
    private TextView zlV;
    private ScrollView zlW;
    private ProfileEditPhoneNumberView zlX;
    private String zlY;
    private String zlZ;
    private TextWatcher zma = new C79371();
    private C7945b zmb = new C7945b(this, (byte) 0);
    private String zmc;
    boolean zmd = true;
    boolean zme = false;
    private boolean zmf = false;

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$3 */
    class C54333 implements OnClickListener {
        C54333() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33630);
            ContactRemarkInfoModUI.m14096a(ContactRemarkInfoModUI.this, true);
            ContactRemarkInfoModUI.m14107k(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33630);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$6 */
    class C54346 implements C17976a {
        C54346() {
        }

        /* renamed from: cP */
        public final void mo11072cP(final boolean z) {
            AppMethodBeat.m2504i(33634);
            ContactRemarkInfoModUI.this.zlJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33633);
                    if (z) {
                        ContactRemarkInfoModUI.m14119v(ContactRemarkInfoModUI.this);
                        AppMethodBeat.m2505o(33633);
                        return;
                    }
                    C30379h.m48465bQ(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(C25738R.string.f9111ps));
                    ContactRemarkInfoModUI.this.zlK.setVisibility(0);
                    ContactRemarkInfoModUI.this.zlH.setVisibility(8);
                    ContactRemarkInfoModUI.this.zlJ.setVisibility(8);
                    AppMethodBeat.m2505o(33633);
                }
            });
            AppMethodBeat.m2505o(33634);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$5 */
    class C73515 implements C5581a {
        C73515() {
        }

        /* renamed from: ki */
        public final void mo11317ki(String str) {
        }

        /* renamed from: JW */
        public final void mo11315JW() {
        }

        /* renamed from: JX */
        public final void mo11316JX() {
            AppMethodBeat.m2504i(33632);
            C30379h.m48467g(ContactRemarkInfoModUI.this, C25738R.string.e8h, C25738R.string.e8p);
            ContactRemarkInfoModUI.this.zmd = false;
            AppMethodBeat.m2505o(33632);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$4 */
    class C79284 implements C5581a {
        C79284() {
        }

        /* renamed from: ki */
        public final void mo11317ki(String str) {
        }

        /* renamed from: JW */
        public final void mo11315JW() {
        }

        /* renamed from: JX */
        public final void mo11316JX() {
            AppMethodBeat.m2504i(33631);
            C30379h.m48467g(ContactRemarkInfoModUI.this, C25738R.string.e8u, C25738R.string.e8p);
            ContactRemarkInfoModUI.this.zmd = false;
            AppMethodBeat.m2505o(33631);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$14 */
    class C792914 implements OnClickListener {
        C792914() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33642);
            ContactRemarkInfoModUI.this.zlR = true;
            ContactRemarkInfoModUI.m14097a(ContactRemarkInfoModUI.this, false, view.getId());
            ContactRemarkInfoModUI.this.zlE.performClick();
            ContactRemarkInfoModUI.this.zlE.requestFocus();
            ContactRemarkInfoModUI.this.showVKB();
            AppMethodBeat.m2505o(33642);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$16 */
    class C793016 implements OnClickListener {
        C793016() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33644);
            if (ContactRemarkInfoModUI.this.zlP) {
                String o;
                ContactRemarkInfoModUI.m14107k(ContactRemarkInfoModUI.this);
                Intent intent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
                intent.putExtra("Contact_User", ContactRemarkInfoModUI.this.username);
                if (C42252ah.isNullOrNil(ContactRemarkInfoModUI.this.fNa) || ContactRemarkInfoModUI.this.zlQ) {
                    o = ContactRemarkInfoModUI.this.zlO;
                } else {
                    C17974c.aiB();
                    o = C17974c.m28282sW(ContactRemarkInfoModUI.this.username);
                }
                intent.putExtra("remark_image_path", o);
                intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.this.zlQ);
                ContactRemarkInfoModUI.this.startActivityForResult(intent, 400);
                AppMethodBeat.m2505o(33644);
                return;
            }
            AppMethodBeat.m2505o(33644);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$a */
    class C7931a implements OnClickListener {
        private C7931a() {
        }

        /* synthetic */ C7931a(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33647);
            ContactRemarkInfoModUI.m14099c(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33647);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$15 */
    class C793215 implements OnFocusChangeListener {
        C793215() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(33643);
            if (z) {
                ContactRemarkInfoModUI.this.zlN.setBackgroundResource(C25738R.drawable.b77);
                AppMethodBeat.m2505o(33643);
                return;
            }
            ContactRemarkInfoModUI.this.zlN.setBackgroundResource(C25738R.drawable.b78);
            AppMethodBeat.m2505o(33643);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$17 */
    class C793317 implements OnClickListener {
        C793317() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33645);
            if (C42252ah.isNullOrNil(ContactRemarkInfoModUI.this.fNa) || ContactRemarkInfoModUI.this.zlT) {
                ContactRemarkInfoModUI.m14096a(ContactRemarkInfoModUI.this, false);
                ContactRemarkInfoModUI.m14107k(ContactRemarkInfoModUI.this);
            }
            AppMethodBeat.m2505o(33645);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$7 */
    class C79347 implements C30391c {
        C79347() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(GLType.GL_UNSIGNED_SHORT_5_6_5);
            switch (i) {
                case 0:
                    C4990ab.m7410d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                    Intent intent = new Intent();
                    intent.putExtra("max_select_count", 1);
                    intent.putExtra("query_source_type", 0);
                    intent.putExtra("send_btn_string", " ");
                    intent.addFlags(67108864);
                    C25985d.m41468b(ContactRemarkInfoModUI.this, "gallery", ".ui.GalleryEntryUI", intent, 200);
                    AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_5_6_5);
                    return;
                case 1:
                    C4990ab.m7410d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                    ContactRemarkInfoModUI.m14120w(ContactRemarkInfoModUI.this);
                    break;
            }
            AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_5_6_5);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$c */
    class C7935c extends ClickableSpan {
        public String hHV;

        public C7935c(String str) {
            this.hHV = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33649);
            ContactRemarkInfoModUI.this.zlR = true;
            ContactRemarkInfoModUI.m14097a(ContactRemarkInfoModUI.this, true, -1);
            ContactRemarkInfoModUI.this.zlC.setText(C44089j.m79293b(ContactRemarkInfoModUI.this, C42252ah.nullAsNil(this.hHV), ContactRemarkInfoModUI.this.zlC.getTextSize()));
            ContactRemarkInfoModUI.this.zlC.setSelection(ContactRemarkInfoModUI.this.zlC.getText().length());
            ContactRemarkInfoModUI.this.zlM.setVisibility(8);
            AppMethodBeat.m2505o(33649);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(33650);
            textPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(C25738R.color.f11788hb));
            textPaint.setUnderlineText(false);
            AppMethodBeat.m2505o(33650);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$18 */
    class C793618 implements OnMenuItemClickListener {
        C793618() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33646);
            ContactRemarkInfoModUI.m14113q(ContactRemarkInfoModUI.this);
            ContactRemarkInfoModUI.this.aqX();
            AppMethodBeat.m2505o(33646);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$1 */
    class C79371 implements TextWatcher {
        C79371() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(33628);
            ContactRemarkInfoModUI.m14095a(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33628);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$8 */
    class C79388 implements OnCancelListener {
        C79388() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$10 */
    class C793910 implements C4937b {
        C793910() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(33637);
            C4990ab.m7410d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            ContactRemarkInfoModUI.m14100d(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33637);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$11 */
    class C794011 implements DialogInterface.OnClickListener {
        C794011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33638);
            ContactRemarkInfoModUI.this.finish();
            AppMethodBeat.m2505o(33638);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$12 */
    class C794112 implements C14903a {
        C794112() {
        }

        public final void aVU() {
            AppMethodBeat.m2504i(33639);
            ContactRemarkInfoModUI.m14095a(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33639);
        }

        public final void djk() {
            AppMethodBeat.m2504i(33640);
            C1855t.m3962s(ContactRemarkInfoModUI.this.ehM);
            C18668n.ahW().mo44216lN(7);
            AppMethodBeat.m2505o(33640);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$13 */
    class C794213 implements OnClickListener {
        C794213() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33641);
            ContactRemarkInfoModUI.this.zlR = true;
            ContactRemarkInfoModUI.m14097a(ContactRemarkInfoModUI.this, false, view.getId());
            ContactRemarkInfoModUI.this.zlC.performClick();
            ContactRemarkInfoModUI.this.zlC.requestFocus();
            ContactRemarkInfoModUI.this.showVKB();
            AppMethodBeat.m2505o(33641);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$2 */
    class C79432 implements OnMenuItemClickListener {
        C79432() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33629);
            ContactRemarkInfoModUI.m14115r(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33629);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$9 */
    class C79449 implements DialogInterface.OnClickListener {
        C79449() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33636);
            ContactRemarkInfoModUI.m14113q(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33636);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkInfoModUI$b */
    class C7945b implements TextWatcher {
        private int qkM;
        private String zmi;

        private C7945b() {
            this.qkM = 800;
            this.zmi = "";
        }

        /* synthetic */ C7945b(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(33648);
            this.qkM = C5584f.m8385bP(800, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (ContactRemarkInfoModUI.this.zlI != null) {
                ContactRemarkInfoModUI.this.zlI.setText(this.qkM);
            }
            ContactRemarkInfoModUI.m14095a(ContactRemarkInfoModUI.this);
            AppMethodBeat.m2505o(33648);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactRemarkInfoModUI() {
        AppMethodBeat.m2504i(33651);
        AppMethodBeat.m2505o(33651);
    }

    /* renamed from: a */
    static /* synthetic */ void m14095a(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33677);
        contactRemarkInfoModUI.m14094JZ();
        AppMethodBeat.m2505o(33677);
    }

    /* renamed from: a */
    static /* synthetic */ void m14097a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z, int i) {
        AppMethodBeat.m2504i(33680);
        contactRemarkInfoModUI.m14093I(z, i);
        AppMethodBeat.m2505o(33680);
    }

    /* renamed from: d */
    static /* synthetic */ void m14100d(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33679);
        contactRemarkInfoModUI.cbz();
        AppMethodBeat.m2505o(33679);
    }

    /* renamed from: k */
    static /* synthetic */ void m14107k(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33681);
        contactRemarkInfoModUI.dHH();
        AppMethodBeat.m2505o(33681);
    }

    /* renamed from: r */
    static /* synthetic */ void m14115r(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33684);
        contactRemarkInfoModUI.goBack();
        AppMethodBeat.m2505o(33684);
    }

    /* renamed from: v */
    static /* synthetic */ void m14119v(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33685);
        contactRemarkInfoModUI.dHJ();
        AppMethodBeat.m2505o(33685);
    }

    /* renamed from: w */
    static /* synthetic */ void m14120w(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33686);
        contactRemarkInfoModUI.dHO();
        AppMethodBeat.m2505o(33686);
    }

    /* renamed from: JZ */
    private void m14094JZ() {
        boolean z;
        AppMethodBeat.m2504i(33652);
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.zlX;
        ArrayList phoneNumberList = profileEditPhoneNumberView.getPhoneNumberList();
        if (phoneNumberList == null || phoneNumberList.isEmpty()) {
            if (profileEditPhoneNumberView.vio != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.vio == null) {
            z = true;
        } else if (phoneNumberList.size() != profileEditPhoneNumberView.vio.length) {
            z = true;
        } else {
            Iterator it = phoneNumberList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.vio[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.zmf = z;
        if (dHM() || dHN() || m14114qD(false) || this.zmf) {
            enableOptionMenu(true);
            AppMethodBeat.m2505o(33652);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.m2505o(33652);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(33653);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(575, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(576, (C1202f) this);
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.vrd = getIntent().getStringExtra("Contact_RoomNickname");
        this.zlS = getIntent().getBooleanExtra("view_mode", false);
        this.zmc = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.zlY = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.zlZ = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (C42252ah.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.m2505o(33653);
            return;
        }
        int i2;
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(this.username);
        this.bCv = this.ehM.field_conRemark;
        this.dul = this.ehM.dul;
        this.fNa = this.ehM.dum;
        this.nIM = this.ehM.field_contactLabelIds;
        this.ppz = C21156a.bJa().mo41634PG(this.nIM);
        initView();
        m14094JZ();
        if (this.ehM == null || !C7616ad.aox(this.ehM.field_username)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            if (this.zlC == null) {
                AppMethodBeat.m2505o(33653);
                return;
            }
            View view = (ViewGroup) this.zlC.getParent();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != view) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(33653);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33654);
        super.onResume();
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.ppA);
        cbz();
        AppMethodBeat.m2505o(33654);
    }

    public void onPause() {
        AppMethodBeat.m2504i(33655);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.ppA);
        super.onPause();
        AppMethodBeat.m2505o(33655);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33656);
        C9638aw.m17182Rg().mo14546b(575, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(576, (C1202f) this);
        this.zlC.removeTextChangedListener(this.zma);
        this.zlE.removeTextChangedListener(this.zmb);
        super.onDestroy();
        AppMethodBeat.m2505o(33656);
    }

    public final int getLayoutId() {
        return 2130969235;
    }

    /* renamed from: I */
    private void m14093I(boolean z, int i) {
        AppMethodBeat.m2504i(33657);
        if (this.zlR) {
            this.zlF.setVisibility(8);
            if (z && C42252ah.isNullOrNil(this.dul)) {
                this.zlG.setVisibility(0);
                this.zlN.setVisibility(8);
            } else if (i == 2131823130) {
                this.zlG.setVisibility(8);
                this.zlN.setVisibility(0);
            }
            this.zlC.setVisibility(0);
            AppMethodBeat.m2505o(33657);
            return;
        }
        this.zlF.setVisibility(0);
        this.zlG.setVisibility(0);
        this.zlC.setVisibility(8);
        this.zlN.setVisibility(8);
        AppMethodBeat.m2505o(33657);
    }

    public final void initView() {
        AppMethodBeat.m2504i(33658);
        this.zlD = (TextView) findViewById(2131823118);
        this.zlF = (TextView) findViewById(2131823120);
        this.zlG = (TextView) findViewById(2131823130);
        this.zlH = (TextView) findViewById(2131823131);
        this.zlC = (MMClearEditText) findViewById(2131823119);
        this.zlE = (MMEditText) findViewById(2131823128);
        this.zlJ = (ImageView) findViewById(2131823133);
        this.zlK = (ImageView) findViewById(2131823132);
        this.zlI = (TextView) findViewById(2131823129);
        this.zlN = findViewById(2131823127);
        this.zlX = (ProfileEditPhoneNumberView) findViewById(2131823126);
        this.zlX.ldh = this.ehM;
        this.zlX.mo58722hF(this.zlY, this.zlZ);
        this.zlX.vir = new C794112();
        this.ppy = (MMTagPanel) findViewById(2131823125);
        this.ppy.setPanelClickable(false);
        this.zlW = (ScrollView) findViewById(2131823117);
        this.zlV = (TextView) findViewById(2131823124);
        this.zlV.setText(C25738R.string.d0x);
        this.ppy.setOnClickListener(this.zlU);
        this.zlV.setOnClickListener(this.zlU);
        setMMTitle((int) C25738R.string.axw);
        if (C42252ah.isNullOrNil(this.bCv)) {
            this.zlC.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.ehM.mo16706Oi()), this.zlC.getTextSize()));
            this.zlF.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.ehM.mo16706Oi()), this.zlC.getTextSize()));
        } else {
            this.zlC.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.bCv), this.zlC.getTextSize()));
            this.zlF.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.bCv), this.zlF.getTextSize()));
        }
        this.zlC.setSelection(this.zlC.getText().length());
        this.zlE.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.dul), this.zlG.getTextSize()));
        this.zlE.setSelection(this.zlE.getText().length());
        if (!C42252ah.isNullOrNil(this.dul)) {
            this.zlG.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(this.dul), this.zlG.getTextSize()));
            this.zlG.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        }
        this.zlF.setOnClickListener(new C794213());
        this.zlG.setOnClickListener(new C792914());
        this.zlC.addTextChangedListener(this.zma);
        this.zlI.setText(C5584f.m8385bP(800, this.zlE.getEditableText().toString()));
        this.zlE.setOnFocusChangeListener(new C793215());
        this.zlE.addTextChangedListener(this.zmb);
        if (C42252ah.isNullOrNil(this.fNa)) {
            this.zlH.setVisibility(0);
            this.zlJ.setVisibility(8);
        } else {
            this.zlH.setVisibility(8);
            this.zlJ.setVisibility(0);
            dHI();
        }
        this.zlJ.setOnClickListener(new C793016());
        this.zlH.setOnClickListener(new C793317());
        if (!cbB()) {
            dHK();
        }
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C793618(), C5535b.GREEN);
        setBackBtn(new C79432());
        if (C42252ah.isNullOrNil(this.bCv)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.zlK.setOnClickListener(new C54333());
        if (!this.zlS) {
            this.zlR = true;
            m14093I(true, -1);
        }
        dHH();
        AppMethodBeat.m2505o(33658);
    }

    private void dHH() {
        AppMethodBeat.m2504i(33659);
        this.zlD.setFocusableInTouchMode(true);
        this.zlD.requestFocus();
        this.zlC.clearFocus();
        this.zlE.clearFocus();
        this.zlX.clearFocus();
        aqX();
        AppMethodBeat.m2505o(33659);
    }

    private void dHI() {
        AppMethodBeat.m2504i(33660);
        C17974c.aiB();
        if (C17974c.m28283sX(this.username)) {
            dHJ();
            AppMethodBeat.m2505o(33660);
            return;
        }
        C17974c.aiB().mo33525a(this.username, this.fNa, new C54346());
        AppMethodBeat.m2505o(33660);
    }

    private void dHJ() {
        AppMethodBeat.m2504i(33661);
        C17974c.aiB();
        Bitmap sZ = C17974c.m28285sZ(this.username);
        if (sZ != null) {
            this.zlH.setVisibility(8);
            this.zlK.setVisibility(8);
            this.zlJ.setVisibility(0);
            this.zlJ.setImageBitmap(sZ);
        }
        this.zlP = true;
        AppMethodBeat.m2505o(33661);
    }

    private void arO(String str) {
        AppMethodBeat.m2504i(33662);
        if (C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(33662);
            return;
        }
        C5728b c5728b = new C5728b(str);
        if (!c5728b.exists()) {
            AppMethodBeat.m2505o(33662);
        } else if (c5728b.length() > 204800) {
            C30379h.m48461b((Context) this, getString(C25738R.string.av4), null, true);
            AppMethodBeat.m2505o(33662);
        } else {
            Bitmap i = C4977b.m7374i(this.zlO, C1338a.getDensity(this));
            if (i != null) {
                this.zlH.setVisibility(8);
                this.zlK.setVisibility(8);
                this.zlJ.setVisibility(0);
                this.zlJ.setImageBitmap(i);
                this.zlP = true;
            }
            AppMethodBeat.m2505o(33662);
        }
    }

    private boolean cbB() {
        AppMethodBeat.m2504i(33663);
        C18817a vT = C32923a.getAddrUploadStg().mo34089vT(this.ehM.field_username);
        if (vT == null || C42252ah.isNullOrNil(vT.apA()) || vT.apA().equals(this.zlC.getText().toString())) {
            AppMethodBeat.m2505o(33663);
            return false;
        }
        this.zlL = (TextView) findViewById(2131823122);
        this.zlM = findViewById(2131823121);
        this.zlM.setVisibility(0);
        this.zlL.setText(C42252ah.nullAsNil(getString(C25738R.string.b05, new Object[]{vT.apA()})));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C7935c(vT.apA()), 0, c44090k.length(), 17);
        this.zlL.append(" ");
        this.zlL.append(c44090k);
        this.zlL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(33663);
        return true;
    }

    private boolean dHK() {
        AppMethodBeat.m2504i(33664);
        if (this.gwP != 14 || C42252ah.isNullOrNil(this.vrd) || this.vrd.equals(this.zlC.getText().toString())) {
            AppMethodBeat.m2505o(33664);
            return false;
        }
        this.zlL = (TextView) findViewById(2131823122);
        this.zlM = findViewById(2131823121);
        this.zlM.setVisibility(0);
        this.zlL.setText(C44089j.m79293b((Context) this, C42252ah.nullAsNil(getString(C25738R.string.b04, new Object[]{this.vrd})), this.zlL.getTextSize()));
        C44090k c44090k = new C44090k(getString(C25738R.string.g1q));
        c44090k.setSpan(new C7935c(this.vrd), 0, c44090k.length(), 17);
        this.zlL.append(" ");
        this.zlL.append(c44090k);
        this.zlL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(33664);
        return true;
    }

    private void dHL() {
        AppMethodBeat.m2504i(33665);
        if (this.zmf) {
            String str;
            bck bck = new bck();
            bck.wGA = this.username;
            bkg bkg = new bkg();
            ArrayList phoneNumberList = this.zlX.getPhoneNumberList();
            bkg.jBv = phoneNumberList == null ? 0 : phoneNumberList.size();
            bkg.wNu = new LinkedList();
            if (phoneNumberList != null) {
                Iterator it = phoneNumberList.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    bkf bkf = new bkf();
                    bkf.wNt = str;
                    bkg.wNu.add(bkf);
                }
            }
            bck.wGw = bkg;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(60, bck));
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.username);
            if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                String str2;
                str = "";
                if (phoneNumberList != null) {
                    Iterator it2 = phoneNumberList.iterator();
                    while (true) {
                        str2 = str;
                        if (!it2.hasNext()) {
                            break;
                        }
                        str = (str2 + ((String) it2.next())) + ",";
                    }
                } else {
                    str2 = str;
                }
                C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, str2);
                this.ehM.mo14733jd(str2);
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15701Y(this.ehM);
            }
            AppMethodBeat.m2505o(33665);
            return;
        }
        AppMethodBeat.m2505o(33665);
    }

    /* renamed from: qD */
    private boolean m14114qD(boolean z) {
        AppMethodBeat.m2504i(33666);
        String obj = this.zlC.getText().toString();
        if (z) {
            boolean z2;
            if ((this.bCv == null || !this.bCv.equals(obj)) && !(C42252ah.isNullOrNil(this.bCv) && C42252ah.isNullOrNil(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.ehM.field_nickname))) {
                AppMethodBeat.m2505o(33666);
                return false;
            }
            AppMethodBeat.m2505o(33666);
            return true;
        } else if ((this.bCv == null || !this.bCv.equals(obj)) && !(C42252ah.isNullOrNil(this.bCv) && C42252ah.isNullOrNil(obj))) {
            AppMethodBeat.m2505o(33666);
            return true;
        } else {
            AppMethodBeat.m2505o(33666);
            return false;
        }
    }

    private boolean dHM() {
        AppMethodBeat.m2504i(33667);
        String obj = this.zlE.getText().toString();
        if ((this.dul == null || !this.dul.equals(obj)) && !(C42252ah.isNullOrNil(this.dul) && C42252ah.isNullOrNil(obj))) {
            AppMethodBeat.m2505o(33667);
            return true;
        }
        AppMethodBeat.m2505o(33667);
        return false;
    }

    private boolean dHN() {
        AppMethodBeat.m2504i(33668);
        if (!C42252ah.isNullOrNil(this.zlO) || this.zlT) {
            AppMethodBeat.m2505o(33668);
            return true;
        }
        AppMethodBeat.m2505o(33668);
        return false;
    }

    private void goBack() {
        AppMethodBeat.m2504i(33669);
        boolean dHN = dHN();
        boolean qD = m14114qD(true);
        boolean dHM = dHM();
        if (dHN || qD || dHM) {
            C30379h.m48466d(this, getString(C25738R.string.aze), null, getString(C25738R.string.azg), getString(C25738R.string.azf), new C79449(), new C794011());
            AppMethodBeat.m2505o(33669);
            return;
        }
        aqX();
        finish();
        AppMethodBeat.m2505o(33669);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(33670);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.m2505o(33670);
            return true;
        }
        AppMethodBeat.m2505o(33670);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(33671);
        C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            C4990ab.m7412e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            AppMethodBeat.m2505o(33671);
            return;
        }
        Context applicationContext;
        String h;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                C9638aw.m17190ZK();
                h = C14987n.m23320h(applicationContext, intent, C18628c.m29088XW());
                if (h == null) {
                    AppMethodBeat.m2505o(33671);
                    return;
                }
                this.zlO = arP(h);
                arO(this.zlO);
                this.zlQ = true;
                this.zlT = false;
                m14094JZ();
                AppMethodBeat.m2505o(33671);
                return;
            case 200:
                applicationContext = getApplicationContext();
                C9638aw.m17190ZK();
                h = C36338a.m59824i(applicationContext, intent, C18628c.m29088XW());
                if (h == null) {
                    AppMethodBeat.m2505o(33671);
                    return;
                }
                this.zlO = arP(h);
                arO(this.zlO);
                this.zlQ = true;
                this.zlT = false;
                m14094JZ();
                AppMethodBeat.m2505o(33671);
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    dHO();
                }
                AppMethodBeat.m2505o(33671);
                return;
            case 600:
                if (m14114qD(true) || dHM() || dHN() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    AppMethodBeat.m2505o(33671);
                    return;
                }
                enableOptionMenu(false);
                AppMethodBeat.m2505o(33671);
                return;
            default:
                AppMethodBeat.m2505o(33671);
                return;
        }
    }

    private void dHO() {
        AppMethodBeat.m2504i(33672);
        this.zlT = true;
        this.zlK.setVisibility(8);
        this.zlH.setVisibility(0);
        this.zlJ.setVisibility(8);
        this.zlJ.setImageBitmap(null);
        m14094JZ();
        AppMethodBeat.m2505o(33672);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(33673);
        C4990ab.m7416i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 575) {
                if (this.zlO != null) {
                    C5728b c5728b = new C5728b(this.zlO);
                    if (c5728b.exists()) {
                        C17974c.aiB();
                        c5728b.mo11675o(new C5728b(C17974c.m28282sW(this.username)));
                    }
                }
                String str2 = ((C17973b) c1207m).fNa;
                if (!C42252ah.isNullOrNil(str2)) {
                    this.fNa = str2;
                }
            } else if (c1207m.getType() == 576) {
                this.zlO = null;
                this.fNa = null;
                this.zlP = false;
                C9638aw.m17190ZK();
                this.ehM = C18628c.m29078XM().aoO(this.username);
                this.ehM.mo14726iY("");
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15724b(this.username, this.ehM);
            }
            finish();
            AppMethodBeat.m2505o(33673);
            return;
        }
        C30379h.m48461b((Context) this, getString(C25738R.string.f9110pr), null, true);
        AppMethodBeat.m2505o(33673);
    }

    private String arP(String str) {
        AppMethodBeat.m2504i(33674);
        if (C5730e.m8628ct(str)) {
            int bJ = ExifHelper.m7368bJ(str);
            StringBuilder stringBuilder = new StringBuilder();
            C17974c.aiB();
            String stringBuilder2 = stringBuilder.append(C17974c.m28282sW(this.username)).append(".tmp").toString();
            if (!C5056d.m7628a(str, (int) VideoFilterUtil.IMAGE_HEIGHT, VideoFilterUtil.IMAGE_HEIGHT, CompressFormat.JPEG, 70, stringBuilder2)) {
                C4990ab.m7412e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
                AppMethodBeat.m2505o(33674);
                return null;
            } else if (bJ == 0 || C5056d.m7633a(stringBuilder2, bJ, CompressFormat.JPEG, 70, stringBuilder2)) {
                AppMethodBeat.m2505o(33674);
                return stringBuilder2;
            } else {
                C4990ab.m7412e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
                AppMethodBeat.m2505o(33674);
                return null;
            }
        }
        AppMethodBeat.m2505o(33674);
        return null;
    }

    private void cbA() {
        AppMethodBeat.m2504i(33675);
        if (C42252ah.isNullOrNil(this.nIM)) {
            this.ppy.setVisibility(8);
            this.zlV.setVisibility(0);
            AppMethodBeat.m2505o(33675);
            return;
        }
        this.ppy.setVisibility(0);
        this.zlV.setVisibility(8);
        this.ppy.mo71950a(this.ppz, this.ppz);
        AppMethodBeat.m2505o(33675);
    }

    private void cbz() {
        AppMethodBeat.m2504i(33676);
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(this.username);
        this.nIM = this.ehM.field_contactLabelIds;
        this.ppz = C21156a.bJa().mo41634PG(this.nIM);
        cbA();
        AppMethodBeat.m2505o(33676);
    }

    /* renamed from: c */
    static /* synthetic */ void m14099c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33678);
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.nIM);
        if (contactRemarkInfoModUI.ppz != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.ppz);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        C25985d.m41468b((Context) contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
        AppMethodBeat.m2505o(33678);
    }

    /* renamed from: a */
    static /* synthetic */ void m14096a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        AppMethodBeat.m2504i(33682);
        C9638aw.m17190ZK();
        if (!C18628c.isSDCardAvailable()) {
            C23639t.m36492hO(contactRemarkInfoModUI);
        }
        if (z) {
            C30379h.m48422a((Context) contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(C25738R.string.e28), contactRemarkInfoModUI.getString(C25738R.string.f9088p4)}, "", new C79347());
            AppMethodBeat.m2505o(33682);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        C25985d.m41468b((Context) contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
        AppMethodBeat.m2505o(33682);
    }

    /* renamed from: q */
    static /* synthetic */ void m14113q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        AppMethodBeat.m2504i(33683);
        contactRemarkInfoModUI.zmd = true;
        C7357c.m12555d(contactRemarkInfoModUI.zlC).mo15877PM(100).mo15879a(new C79284());
        C7357c.m12555d(contactRemarkInfoModUI.zlE).mo15877PM(800).mo15879a(new C73515());
        if (contactRemarkInfoModUI.zmd) {
            String obj;
            C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.dHM()) {
                obj = contactRemarkInfoModUI.zlE.getText().toString();
                contactRemarkInfoModUI.dul = obj;
                bbw bbw = new bbw();
                bbw.wGA = contactRemarkInfoModUI.username;
                bbw.Desc = obj;
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C3465a(54, bbw));
            }
            String obj2 = contactRemarkInfoModUI.zlC.getText().toString();
            C4990ab.m7416i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.gwP);
            C7060h.pYm.mo8381e(10448, Integer.valueOf(contactRemarkInfoModUI.gwP));
            switch (contactRemarkInfoModUI.ehM.getSource()) {
                case 10:
                case 11:
                case 13:
                    C18817a vT = C32923a.getAddrUploadStg().mo34089vT(contactRemarkInfoModUI.ehM.field_username);
                    if (!(vT == null || C42252ah.isNullOrNil(vT.apA()))) {
                        if (C42252ah.isNullOrNil(obj2)) {
                            vT.apH();
                        } else {
                            vT.guJ &= -2;
                        }
                        C32923a.getAddrUploadStg().mo34084a(vT.mo34067Aq(), vT);
                        break;
                    }
            }
            C9638aw.m17190ZK();
            C7575bv RB = C18628c.m29079XN().mo15364RB(contactRemarkInfoModUI.ehM.field_username);
            if ((RB == null || C42252ah.isNullOrNil(RB.field_encryptUsername)) && !C42252ah.isNullOrNil(contactRemarkInfoModUI.ehM.field_encryptUsername)) {
                C9638aw.m17190ZK();
                RB = C18628c.m29079XN().mo15364RB(contactRemarkInfoModUI.ehM.field_encryptUsername);
            }
            if (!(RB == null || C42252ah.isNullOrNil(RB.field_encryptUsername))) {
                C9638aw.m17190ZK();
                C18628c.m29079XN().mo15365RC(RB.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.m14114qD(false)) {
                contactRemarkInfoModUI.bCv = obj2;
                C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.ehM.field_username, obj2);
                C1855t.m3887b(contactRemarkInfoModUI.ehM, obj2);
            } else {
                C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.m14114qD(false)));
            }
            contactRemarkInfoModUI.dHL();
            obj = contactRemarkInfoModUI.bCv;
            obj2 = contactRemarkInfoModUI.dul;
            String str = contactRemarkInfoModUI.fNa;
            C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, obj);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(contactRemarkInfoModUI.username);
            if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
                C4990ab.m7412e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                int i;
                contactRemarkInfoModUI.ehM.mo14729iz(obj);
                contactRemarkInfoModUI.ehM.mo14725iX(obj2);
                contactRemarkInfoModUI.ehM.mo14726iY(str);
                C9638aw.m17190ZK();
                boolean Y = C18628c.m29078XM().mo15701Y(contactRemarkInfoModUI.ehM);
                C4990ab.m7417i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(Y));
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                if (obj2 == null) {
                    i = 0;
                } else {
                    i = obj2.length();
                }
                objArr[1] = Integer.valueOf(i);
                if (obj2 == null) {
                    obj = "";
                } else {
                    obj = C5046bo.anv(obj2);
                }
                objArr[2] = obj;
                C4990ab.m7417i(str, str2, objArr);
                C4879a.xxA.mo10055m(new C26245tv());
            }
            if (!contactRemarkInfoModUI.dHN()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.zlT) {
                C9638aw.m17182Rg().mo14541a(new C17972a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(C25738R.string.f9238tz);
                contactRemarkInfoModUI.fsh = C30379h.m48458b((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(C25738R.string.av5), false, new C79388());
                AppMethodBeat.m2505o(33683);
                return;
            } else {
                C9638aw.m17182Rg().mo14541a(new C17973b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.zlO), 0);
                contactRemarkInfoModUI.getString(C25738R.string.f9238tz);
                contactRemarkInfoModUI.fsh = C30379h.m48458b((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(C25738R.string.av6), false, null);
                AppMethodBeat.m2505o(33683);
                return;
            }
        }
        AppMethodBeat.m2505o(33683);
    }
}
