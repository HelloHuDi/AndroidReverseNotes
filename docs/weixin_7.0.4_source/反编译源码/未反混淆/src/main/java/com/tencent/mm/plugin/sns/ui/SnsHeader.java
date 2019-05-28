package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    Context context;
    private String cvF;
    boolean czr = false;
    private Dialog dialog;
    String ecX;
    private String qSf;
    c rrU;
    private a rrV;
    private b rrW;
    private boolean rrX = false;
    private Map<Integer, View> rrY = new HashMap();
    private String rrZ = "";
    Bitmap rsa = null;
    private int type;
    String userName;

    public interface a {
        boolean ctk();

        boolean kH(long j);
    }

    class d implements Comparator<n> {
        d() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            n nVar = (n) obj;
            n nVar2 = (n) obj2;
            if (nVar.field_createTime == nVar2.field_createTime) {
                return 0;
            }
            if (nVar.field_createTime > nVar2.field_createTime) {
                return -1;
            }
            return 1;
        }
    }

    public interface b {
        void aa(Bitmap bitmap);
    }

    class c {
        ImageView eks;
        TextView jAJ;
        TextView rgK;
        ImageView rsg;
        ImageView rsh;
        LinearLayout rsi;
        LinearLayout rsj;
        SnsStoryHeaderView rsk;

        c() {
        }
    }

    public void setHeadBgListener(b bVar) {
        this.rrW = bVar;
    }

    public SnsHeader(Context context) {
        super(context);
        AppMethodBeat.i(38951);
        init(context);
        AppMethodBeat.o(38951);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38952);
        init(context);
        AppMethodBeat.o(38952);
    }

    public void setType(int i) {
        AppMethodBeat.i(38953);
        this.type = i;
        if (i == 1 && this.rrU.rgK != null) {
            this.rrU.rgK.setVisibility(8);
        }
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setSnsType(i);
        }
        AppMethodBeat.o(38953);
    }

    public void setStoryAction(com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a aVar) {
        AppMethodBeat.i(38954);
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setStoryAction(aVar);
        }
        AppMethodBeat.o(38954);
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(38955);
        this.cvF = str;
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setSessionId(str);
        }
        AppMethodBeat.o(38955);
    }

    public void setEnterObjectId(String str) {
        AppMethodBeat.i(38956);
        this.qSf = str;
        if (!(this.rrU == null || this.rrU.rsk == null)) {
            this.rrU.rsk.setEnterObjectId(str);
        }
        AppMethodBeat.o(38956);
    }

    private void init(final Context context) {
        AppMethodBeat.i(38957);
        this.context = context;
        View inflate = v.hu(context).inflate(R.layout.avc, this, true);
        this.rrU = new c();
        this.rrU.jAJ = (TextView) inflate.findViewById(R.id.b6e);
        this.rrU.eks = (ImageView) inflate.findViewById(R.id.qk);
        this.rrU.rgK = (TextView) inflate.findViewById(R.id.eje);
        this.rrU.rsg = (ImageView) inflate.findViewById(R.id.ejc);
        this.rrU.rsh = (ImageView) inflate.findViewById(R.id.ejd);
        this.rrU.rsi = (LinearLayout) inflate.findViewById(R.id.ejl);
        this.rrU.rsj = (LinearLayout) inflate.findViewById(R.id.ejh);
        this.rrU.rsk = (SnsStoryHeaderView) inflate.findViewById(R.id.ejf);
        this.rrU.rsk.setSessionId(this.cvF);
        this.rrU.rsk.setEnterObjectId(this.qSf);
        this.rrU.rsg.setContentDescription(context.getString(R.string.ejs));
        this.rrU.rsg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38947);
                ab.d("MicroMsg.SnsHeader", "change backGround");
                if (SnsHeader.this.dialog == null || !SnsHeader.this.dialog.isShowing()) {
                    if (SnsHeader.this.rrV != null) {
                        SnsHeader.this.rrV.ctk();
                    }
                    l YX = af.cnJ().YX(SnsHeader.this.type == 1 ? SnsHeader.this.ecX : SnsHeader.this.userName);
                    final long j = YX.field_snsBgId;
                    if (SnsHeader.this.czr || j != 0) {
                        String[] strArr;
                        SnsHeader.this.rrX = YX.cqJ();
                        if (SnsHeader.this.type == 1 || SnsHeader.this.ecX.trim().equals(SnsHeader.this.userName.trim())) {
                            strArr = new String[]{context.getString(R.string.eq_)};
                            SnsHeader.this.rrX = false;
                        } else {
                            strArr = SnsHeader.this.rrX ? new String[0] : new String[]{context.getString(R.string.em_)};
                        }
                        String string = SnsHeader.this.rrX ? context.getString(R.string.eo8) : "";
                        if (SnsHeader.this.rrX) {
                            context.getString(R.string.s6);
                        } else {
                            context.getString(R.string.or);
                        }
                        SnsHeader.this.dialog = h.a(SnsHeader.this.getContext(), string, strArr, new com.tencent.mm.ui.base.h.c() {
                            public final void iE(int i) {
                                AppMethodBeat.i(38946);
                                switch (i) {
                                    case 0:
                                        if (!SnsHeader.this.rrX) {
                                            SnsHeader.a(SnsHeader.this, j);
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(38946);
                            }
                        });
                        AppMethodBeat.o(38947);
                        return;
                    }
                    AppMethodBeat.o(38947);
                    return;
                }
                AppMethodBeat.o(38947);
            }
        });
        this.rrU.eks.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 1;
                AppMethodBeat.i(38948);
                ad aoO = af.cnt().aoO(SnsHeader.this.userName);
                if (aoO == null || !(com.tencent.mm.n.a.jh(aoO.field_type) || SnsHeader.this.czr)) {
                    Intent intent = ((Activity) context).getIntent();
                    intent.putExtra("Contact_User", SnsHeader.this.userName);
                    com.tencent.mm.plugin.sns.c.a.gkE.c(intent, context);
                    AppMethodBeat.o(38948);
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
                    com.tencent.mm.plugin.sns.c.a.gkE.c(intent2, context);
                }
                AppMethodBeat.o(38948);
            }
        });
        AppMethodBeat.o(38957);
    }

    public void setAvatarOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(38958);
        if (!(this.rrU == null || this.rrU.eks == null)) {
            this.rrU.eks.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(38958);
    }

    public final void cti() {
        boolean z;
        String str;
        Bitmap a;
        AppMethodBeat.i(38959);
        Object obj = this.userName;
        if (this.type == 1) {
            obj = this.ecX;
        }
        String accSnsPath = af.getAccSnsPath();
        ab.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(obj)));
        l YX = af.cnJ().YX(obj);
        String str2 = YX.field_bgId;
        ab.d("MicroMsg.SnsHeader", "showName " + obj + " get bgId : " + str2 + "  olderBgId：　" + YX.field_older_bgId);
        String Xc = i.Xc(str2);
        String str3 = obj + "bg_";
        String str4 = obj + "tbg_";
        String fZ = an.fZ(accSnsPath, obj);
        e.tf(fZ);
        if ((YX.field_local_flag & 1) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ab.d("MicroMsg.SnsHeader", "bg is change");
            af.cnJ().YW(obj);
            if (e.ct(an.fZ(accSnsPath, obj) + str3)) {
                e.deleteFile(an.fZ(accSnsPath, obj) + str4);
                e.h(an.fZ(accSnsPath, obj), str3, str4);
            }
            YX.field_local_flag &= -2;
            af.cnJ().c(YX);
        }
        if (e.ct(an.fZ(af.getAccSnsPath(), str2) + Xc) && !e.ct(an.fZ(accSnsPath, obj) + str3)) {
            e.y(an.fZ(accSnsPath, str2) + Xc, an.fZ(accSnsPath, obj) + str3);
            ab.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        accSnsPath = YX.field_bgUrl;
        if (str2 != null) {
            af.cnC();
            str = fZ + str3;
            this.context.hashCode();
            a = g.a(str, accSnsPath, str2, true, az.xYU);
            ab.d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                e.deleteFile(fZ + str3);
            }
        } else {
            a = null;
        }
        if (a == null && str2 != null) {
            af.cnC();
            str = fZ + str4;
            this.context.hashCode();
            a = g.a(str, accSnsPath, str2, false, az.xYU);
        }
        if (this.rrU.rsg != null) {
            this.rrU.rsg.setImageBitmap(a);
            if (a != null) {
                this.rrU.rsg.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.rsa == null || this.rsa.isRecycled()) {
                        ab.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.rsa = com.tencent.mm.sdk.platformtools.d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.rrU.rsg.setBackgroundDrawable(new BitmapDrawable(this.rsa));
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.rrU.rsi.setVisibility(8);
        if (a == null && (this.type == 1 || this.ecX.equals(obj))) {
            this.rrU.rsi.setVisibility(0);
        }
        this.rrX = YX.cqJ();
        if (this.rrW != null) {
            this.rrW.aa(a);
            if (a != null) {
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.context, 65);
                if (fromDPToPix > a.getHeight()) {
                    fromDPToPix = a.getHeight();
                }
                fromDPToPix = ae.ao(Bitmap.createBitmap(a, 0, 0, a.getWidth(), fromDPToPix))[0];
                AnonymousClass3 anonymousClass3 = new ShaderFactory() {
                    public final Shader resize(int i, int i2) {
                        AppMethodBeat.i(38949);
                        float f = 0.0f;
                        float f2 = 0.0f;
                        LinearGradient linearGradient = new LinearGradient(0.0f, f, f2, (float) i2, new int[]{fromDPToPix, 0}, new float[]{0.0f, 1.0f}, TileMode.CLAMP);
                        AppMethodBeat.o(38949);
                        return linearGradient;
                    }
                };
                PaintDrawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(anonymousClass3);
                this.rrU.rsh.setBackground(paintDrawable);
            }
        }
        AppMethodBeat.o(38959);
    }

    public void setBackClickListener(a aVar) {
        this.rrV = aVar;
    }

    public final boolean ctj() {
        AppMethodBeat.i(38960);
        if (this.rrU.rsj == null) {
            AppMethodBeat.o(38960);
            return false;
        }
        int i;
        List cnX = aj.cnX();
        LinkedList linkedList = new LinkedList();
        for (i = 0; i < cnX.size(); i++) {
            n nVar = (n) cnX.get(i);
            try {
                if (((bav) new bav().parseFrom(nVar.field_postBuf)).wFv) {
                }
            } catch (Exception e) {
            }
            linkedList.add(nVar);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((bav) new bav().parseFrom(((n) linkedList.get(i)).field_postBuf)).wFv) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((n) linkedList.get(i)).cqU() + " ";
            i++;
            str = str2;
        }
        ab.i("MicroMsg.SnsHeader", "refreshError %s %s %s", Integer.valueOf(linkedList.size()), str, this.rrZ);
        if (!str.equals(this.rrZ)) {
            this.rrZ = str;
            this.rrU.rsj.removeAllViews();
            this.rrU.rsj.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new d());
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View linearLayout2;
                int i3 = ((n) linkedList.get(i2)).reX;
                i = linkedList.size();
                if (!this.rrY.containsKey(Integer.valueOf(i3)) || this.rrY.get(Integer.valueOf(i3)) == null) {
                    linearLayout2 = (LinearLayout) v.hu(this.context).inflate(R.layout.a6q, null);
                    linearLayout2.getChildAt(0).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(38950);
                            if (view.getTag() instanceof String) {
                                String str = (String) view.getTag();
                                ab.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(str)));
                                n YT = af.cnF().YT(str);
                                if (!(SnsHeader.this.context == null || YT == null)) {
                                    Intent intent = new Intent();
                                    intent.setClass(SnsHeader.this.context, SnsCommentDetailUI.class);
                                    if (YT == null || YT.field_userName == null || YT.field_userName.equals("")) {
                                        ab.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                                        AppMethodBeat.o(38950);
                                        return;
                                    }
                                    intent.putExtra("INTENT_TALKER", YT.field_userName);
                                    intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                                    intent.putExtra("INTENT_FROMGALLERY", true);
                                    com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(726);
                                    lY.mb(i).mb(i2).mb(YT.field_createTime);
                                    lY.ajK();
                                    SnsHeader.this.context.startActivity(intent);
                                    try {
                                        bav bav = (bav) new bav().parseFrom(YT.field_postBuf);
                                        if (bav.wFm == 201 || bav.wFm == 210 || bav.wFm != 211) {
                                            bav.wFv = true;
                                            YT.field_postBuf = bav.toByteArray();
                                            af.cnF().b(YT.reX, YT);
                                        }
                                        AppMethodBeat.o(38950);
                                        return;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            AppMethodBeat.o(38950);
                        }
                    });
                    this.rrY.put(Integer.valueOf(i3), linearLayout2);
                } else {
                    linearLayout2 = (View) this.rrY.get(Integer.valueOf(i3));
                }
                linearLayout2 = (LinearLayout) linearLayout2;
                linearLayout2.getChildAt(0).setTag(((n) linkedList.get(i2)).cqU());
                TextView textView = (TextView) linearLayout2.findViewById(R.id.ce9);
                if (((n) linkedList.get(i2)).field_type == 15) {
                    textView.setText(R.string.enr);
                } else {
                    textView.setTag(Integer.valueOf(R.string.enm));
                }
                this.rrU.rsj.addView(linearLayout2);
            }
            if (linkedList.size() > 0) {
                AppMethodBeat.o(38960);
                return true;
            }
            AppMethodBeat.o(38960);
            return false;
        } else if (linkedList.size() > 0) {
            AppMethodBeat.o(38960);
            return true;
        } else {
            AppMethodBeat.o(38960);
            return false;
        }
    }
}
