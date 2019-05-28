package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.view.SnsStoryHeaderView;
import com.tencent.p177mm.plugin.sns.p520ui.view.SnsStoryHeaderView.C29246a;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsHeader */
public class SnsHeader extends LinearLayout {
    Context context;
    private String cvF;
    boolean czr = false;
    private Dialog dialog;
    String ecX;
    private String qSf;
    C29121c rrU;
    private C13534a rrV;
    private C29120b rrW;
    private boolean rrX = false;
    private Map<Integer, View> rrY = new HashMap();
    private String rrZ = "";
    Bitmap rsa = null;
    private int type;
    String userName;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsHeader$a */
    public interface C13534a {
        boolean ctk();

        /* renamed from: kH */
        boolean mo25710kH(long j);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsHeader$d */
    class C13535d implements Comparator<C46236n> {
        C13535d() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C46236n c46236n = (C46236n) obj;
            C46236n c46236n2 = (C46236n) obj2;
            if (c46236n.field_createTime == c46236n2.field_createTime) {
                return 0;
            }
            if (c46236n.field_createTime > c46236n2.field_createTime) {
                return -1;
            }
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsHeader$b */
    public interface C29120b {
        /* renamed from: aa */
        void mo25773aa(Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsHeader$c */
    class C29121c {
        ImageView eks;
        TextView jAJ;
        TextView rgK;
        ImageView rsg;
        ImageView rsh;
        LinearLayout rsi;
        LinearLayout rsj;
        SnsStoryHeaderView rsk;

        C29121c() {
        }
    }

    public void setHeadBgListener(C29120b c29120b) {
        this.rrW = c29120b;
    }

    public SnsHeader(Context context) {
        super(context);
        AppMethodBeat.m2504i(38951);
        init(context);
        AppMethodBeat.m2505o(38951);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38952);
        init(context);
        AppMethodBeat.m2505o(38952);
    }

    public void setType(int i) {
        AppMethodBeat.m2504i(38953);
        this.type = i;
        if (i == 1 && this.rrU.rgK != null) {
            this.rrU.rgK.setVisibility(8);
        }
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setSnsType(i);
        }
        AppMethodBeat.m2505o(38953);
    }

    public void setStoryAction(C29246a c29246a) {
        AppMethodBeat.m2504i(38954);
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setStoryAction(c29246a);
        }
        AppMethodBeat.m2505o(38954);
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(38955);
        this.cvF = str;
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setSessionId(str);
        }
        AppMethodBeat.m2505o(38955);
    }

    public void setEnterObjectId(String str) {
        AppMethodBeat.m2504i(38956);
        this.qSf = str;
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setEnterObjectId(str);
        }
        AppMethodBeat.m2505o(38956);
    }

    private void init(final Context context) {
        AppMethodBeat.m2504i(38957);
        this.context = context;
        View inflate = C5616v.m8409hu(context).inflate(2130970765, this, true);
        this.rrU = new C29121c();
        this.rrU.jAJ = (TextView) inflate.findViewById(2131823149);
        this.rrU.eks = (ImageView) inflate.findViewById(2131821183);
        this.rrU.rgK = (TextView) inflate.findViewById(2131827773);
        this.rrU.rsg = (ImageView) inflate.findViewById(2131827771);
        this.rrU.rsh = (ImageView) inflate.findViewById(2131827772);
        this.rrU.rsi = (LinearLayout) inflate.findViewById(2131827780);
        this.rrU.rsj = (LinearLayout) inflate.findViewById(2131827776);
        this.rrU.rsk = (SnsStoryHeaderView) inflate.findViewById(2131827774);
        this.rrU.rsk.setSessionId(this.cvF);
        this.rrU.rsk.setEnterObjectId(this.qSf);
        this.rrU.rsg.setContentDescription(context.getString(C25738R.string.ejs));
        this.rrU.rsg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(38947);
                C4990ab.m7410d("MicroMsg.SnsHeader", "change backGround");
                if (SnsHeader.this.dialog == null || !SnsHeader.this.dialog.isShowing()) {
                    if (SnsHeader.this.rrV != null) {
                        SnsHeader.this.rrV.ctk();
                    }
                    C29097l YX = C13373af.cnJ().mo69179YX(SnsHeader.this.type == 1 ? SnsHeader.this.ecX : SnsHeader.this.userName);
                    final long j = YX.field_snsBgId;
                    if (SnsHeader.this.czr || j != 0) {
                        String[] strArr;
                        SnsHeader.this.rrX = YX.cqJ();
                        if (SnsHeader.this.type == 1 || SnsHeader.this.ecX.trim().equals(SnsHeader.this.userName.trim())) {
                            strArr = new String[]{context.getString(C25738R.string.eq_)};
                            SnsHeader.this.rrX = false;
                        } else {
                            strArr = SnsHeader.this.rrX ? new String[0] : new String[]{context.getString(C25738R.string.em_)};
                        }
                        String string = SnsHeader.this.rrX ? context.getString(C25738R.string.eo8) : "";
                        if (SnsHeader.this.rrX) {
                            context.getString(C25738R.string.f9187s6);
                        } else {
                            context.getString(C25738R.string.f9076or);
                        }
                        SnsHeader.this.dialog = C30379h.m48421a(SnsHeader.this.getContext(), string, strArr, new C30391c() {
                            /* renamed from: iE */
                            public final void mo7700iE(int i) {
                                AppMethodBeat.m2504i(38946);
                                switch (i) {
                                    case 0:
                                        if (!SnsHeader.this.rrX) {
                                            SnsHeader.m86516a(SnsHeader.this, j);
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.m2505o(38946);
                            }
                        });
                        AppMethodBeat.m2505o(38947);
                        return;
                    }
                    AppMethodBeat.m2505o(38947);
                    return;
                }
                AppMethodBeat.m2505o(38947);
            }
        });
        this.rrU.eks.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 1;
                AppMethodBeat.m2504i(38948);
                C7616ad aoO = C13373af.cnt().aoO(SnsHeader.this.userName);
                if (aoO == null || !(C7486a.m12942jh(aoO.field_type) || SnsHeader.this.czr)) {
                    Intent intent = ((Activity) context).getIntent();
                    intent.putExtra("Contact_User", SnsHeader.this.userName);
                    C24826a.gkE.mo38912c(intent, context);
                    AppMethodBeat.m2505o(38948);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", SnsHeader.this.userName);
                if (SnsHeader.this.userName != null && SnsHeader.this.userName.length() > 0) {
                    String str = "CONTACT_INFO_UI_SOURCE";
                    if (SnsHeader.this.type == 1) {
                        i = 6;
                    }
                    intent2.putExtra(str, i);
                    C24826a.gkE.mo38912c(intent2, context);
                }
                AppMethodBeat.m2505o(38948);
            }
        });
        AppMethodBeat.m2505o(38957);
    }

    public void setAvatarOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(38958);
        if (!(this.rrU == null || this.rrU.eks == null)) {
            this.rrU.eks.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(38958);
    }

    public final void cti() {
        boolean z;
        String str;
        Bitmap a;
        AppMethodBeat.m2504i(38959);
        Object obj = this.userName;
        if (this.type == 1) {
            obj = this.ecX;
        }
        String accSnsPath = C13373af.getAccSnsPath();
        C4990ab.m7410d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(obj)));
        C29097l YX = C13373af.cnJ().mo69179YX(obj);
        String str2 = YX.field_bgId;
        C4990ab.m7410d("MicroMsg.SnsHeader", "showName " + obj + " get bgId : " + str2 + "  olderBgId：　" + YX.field_older_bgId);
        String Xc = C29036i.m46080Xc(str2);
        String str3 = obj + "bg_";
        String str4 = obj + "tbg_";
        String fZ = C3892an.m6198fZ(accSnsPath, obj);
        C5730e.m8643tf(fZ);
        if ((YX.field_local_flag & 1) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C4990ab.m7410d("MicroMsg.SnsHeader", "bg is change");
            C13373af.cnJ().mo69178YW(obj);
            if (C5730e.m8628ct(C3892an.m6198fZ(accSnsPath, obj) + str3)) {
                C5730e.deleteFile(C3892an.m6198fZ(accSnsPath, obj) + str4);
                C5730e.m8633h(C3892an.m6198fZ(accSnsPath, obj), str3, str4);
            }
            YX.field_local_flag &= -2;
            C13373af.cnJ().mo69182c(YX);
        }
        if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), str2) + Xc) && !C5730e.m8628ct(C3892an.m6198fZ(accSnsPath, obj) + str3)) {
            C5730e.m8644y(C3892an.m6198fZ(accSnsPath, str2) + Xc, C3892an.m6198fZ(accSnsPath, obj) + str3);
            C4990ab.m7410d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        accSnsPath = YX.field_bgUrl;
        if (str2 != null) {
            C13373af.cnC();
            str = fZ + str3;
            this.context.hashCode();
            a = C21925g.m33510a(str, accSnsPath, str2, true, C44222az.xYU);
            C4990ab.m7410d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                C5730e.deleteFile(fZ + str3);
            }
        } else {
            a = null;
        }
        if (a == null && str2 != null) {
            C13373af.cnC();
            str = fZ + str4;
            this.context.hashCode();
            a = C21925g.m33510a(str, accSnsPath, str2, false, C44222az.xYU);
        }
        if (this.rrU.rsg != null) {
            this.rrU.rsg.setImageBitmap(a);
            if (a != null) {
                this.rrU.rsg.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.rsa == null || this.rsa.isRecycled()) {
                        C4990ab.m7416i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.rsa = C5056d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.rrU.rsg.setBackgroundDrawable(new BitmapDrawable(this.rsa));
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.rrU.rsi.setVisibility(8);
        if (a == null && (this.type == 1 || this.ecX.equals(obj))) {
            this.rrU.rsi.setVisibility(0);
        }
        this.rrX = YX.cqJ();
        if (this.rrW != null) {
            this.rrW.mo25773aa(a);
            if (a != null) {
                int fromDPToPix = C1338a.fromDPToPix(this.context, 65);
                if (fromDPToPix > a.getHeight()) {
                    fromDPToPix = a.getHeight();
                }
                fromDPToPix = C5222ae.m7936ao(Bitmap.createBitmap(a, 0, 0, a.getWidth(), fromDPToPix))[0];
                C435783 c435783 = new ShaderFactory() {
                    public final Shader resize(int i, int i2) {
                        AppMethodBeat.m2504i(38949);
                        float f = 0.0f;
                        float f2 = 0.0f;
                        LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{fromDPToPix, 0}, new float[]{0.0f, 1.0f}, TileMode.CLAMP);
                        AppMethodBeat.m2505o(38949);
                        return linearGradient;
                    }
                };
                PaintDrawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(c435783);
                this.rrU.rsh.setBackground(paintDrawable);
            }
        }
        AppMethodBeat.m2505o(38959);
    }

    public void setBackClickListener(C13534a c13534a) {
        this.rrV = c13534a;
    }

    public final boolean ctj() {
        AppMethodBeat.m2504i(38960);
        if (this.rrU.rsj == null) {
            AppMethodBeat.m2505o(38960);
            return false;
        }
        int i;
        List cnX = C34955aj.cnX();
        LinkedList linkedList = new LinkedList();
        for (i = 0; i < cnX.size(); i++) {
            C46236n c46236n = (C46236n) cnX.get(i);
            try {
                if (((bav) new bav().parseFrom(c46236n.field_postBuf)).wFv) {
                }
            } catch (Exception e) {
            }
            linkedList.add(c46236n);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((bav) new bav().parseFrom(((C46236n) linkedList.get(i)).field_postBuf)).wFv) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((C46236n) linkedList.get(i)).cqU() + " ";
            i++;
            str = str2;
        }
        C4990ab.m7417i("MicroMsg.SnsHeader", "refreshError %s %s %s", Integer.valueOf(linkedList.size()), str, this.rrZ);
        if (!str.equals(this.rrZ)) {
            this.rrZ = str;
            this.rrU.rsj.removeAllViews();
            this.rrU.rsj.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new C13535d());
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View linearLayout2;
                int i3 = ((C46236n) linkedList.get(i2)).reX;
                i = linkedList.size();
                if (!this.rrY.containsKey(Integer.valueOf(i3)) || this.rrY.get(Integer.valueOf(i3)) == null) {
                    linearLayout2 = (LinearLayout) C5616v.m8409hu(this.context).inflate(2130969817, null);
                    linearLayout2.getChildAt(0).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(38950);
                            if (view.getTag() instanceof String) {
                                String str = (String) view.getTag();
                                C4990ab.m7416i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(str)));
                                C46236n YT = C13373af.cnF().mo62918YT(str);
                                if (!(SnsHeader.this.context == null || YT == null)) {
                                    Intent intent = new Intent();
                                    intent.setClass(SnsHeader.this.context, SnsCommentDetailUI.class);
                                    if (YT == null || YT.field_userName == null || YT.field_userName.equals("")) {
                                        C4990ab.m7416i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                                        AppMethodBeat.m2505o(38950);
                                        return;
                                    }
                                    intent.putExtra("INTENT_TALKER", YT.field_userName);
                                    intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                                    intent.putExtra("INTENT_FROMGALLERY", true);
                                    C37952b lY = C37952b.m64170lY(726);
                                    lY.mo60720mb(i).mo60720mb(i2).mo60720mb(YT.field_createTime);
                                    lY.ajK();
                                    SnsHeader.this.context.startActivity(intent);
                                    try {
                                        bav bav = (bav) new bav().parseFrom(YT.field_postBuf);
                                        if (bav.wFm == 201 || bav.wFm == 210 || bav.wFm != 211) {
                                            bav.wFv = true;
                                            YT.field_postBuf = bav.toByteArray();
                                            C13373af.cnF().mo62928b(YT.reX, YT);
                                        }
                                        AppMethodBeat.m2505o(38950);
                                        return;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            AppMethodBeat.m2505o(38950);
                        }
                    });
                    this.rrY.put(Integer.valueOf(i3), linearLayout2);
                } else {
                    linearLayout2 = (View) this.rrY.get(Integer.valueOf(i3));
                }
                linearLayout2 = (LinearLayout) linearLayout2;
                linearLayout2.getChildAt(0).setTag(((C46236n) linkedList.get(i2)).cqU());
                TextView textView = (TextView) linearLayout2.findViewById(2131824845);
                if (((C46236n) linkedList.get(i2)).field_type == 15) {
                    textView.setText(C25738R.string.enr);
                } else {
                    textView.setTag(Integer.valueOf(C25738R.string.enm));
                }
                this.rrU.rsj.addView(linearLayout2);
            }
            if (linkedList.size() > 0) {
                AppMethodBeat.m2505o(38960);
                return true;
            }
            AppMethodBeat.m2505o(38960);
            return false;
        } else if (linkedList.size() > 0) {
            AppMethodBeat.m2505o(38960);
            return true;
        } else {
            AppMethodBeat.m2505o(38960);
            return false;
        }
    }
}
